package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearbypro.api.INearbyProAioUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class EmoticonPanelTabSortHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> {
    static IPatchRedirector $redirector_ = null;
    protected static final String LOG_TAG = "EmoticonPanelTabSortHelper";
    protected List<EmotionPanelInfo> mBehindDisSelectedDataList;
    protected List<EmotionPanelInfo> mEmotionPanelInfos;
    protected List<EmotionPanelInfo> mFrontDisSelectedDataList;
    protected boolean mHideSettingBtn;
    protected IPanelInteractionListener mInteractionListener;
    protected boolean mPanelTabSortEnable;

    public EmoticonPanelTabSortHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.mFrontDisSelectedDataList = new ArrayList();
        this.mBehindDisSelectedDataList = new ArrayList();
        this.mPanelTabSortEnable = false;
        this.mHideSettingBtn = false;
    }

    private boolean aiTabEnable() {
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener == null) {
            return false;
        }
        int curType = iPanelInteractionListener.getCurType();
        if (curType != 0 && curType != 1) {
            return false;
        }
        return true;
    }

    private boolean aniStickerTabEnable() {
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener == null) {
            return false;
        }
        int curType = iPanelInteractionListener.getCurType();
        if (curType == 0 || curType == 1 || com.tencent.mobileqq.activity.i.a(curType) || curType == 1044 || curType == 1045 || curType == 1046) {
            return true;
        }
        if (curType == 10021 && this.mInteractionListener.getPanelChatPieType() == 119) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "aniStickerTabEnable return false, sessionType=", Integer.valueOf(curType));
        }
        return false;
    }

    private List<EmotionPanelInfo> filterFavoriteBtnInMatchChatAndNearby(List<EmotionPanelInfo> list) {
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && (iPanelInteractionListener.getCurType() == 1044 || this.mInteractionListener.getCurType() == 1045 || this.mInteractionListener.getCurType() == 1001 || this.mInteractionListener.getCurType() == 1046 || !((INearbyProAioUtil) QRoute.api(INearbyProAioUtil.class)).checkFavoriteBtnShow(this.mInteractionListener.getPanelChatPieType()))) {
            if (this.mInteractionListener.getCurType() == 1001) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (baseQQAppInterface == null) {
                    return list;
                }
                if (!((Boolean) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(baseQQAppInterface.getAccount(), INearbySPUtil.SP_KEY_SELF_AIO_SHIELD_STATUS, Boolean.FALSE)).booleanValue()) {
                    return list;
                }
            }
            List<EmotionPanelInfo> synchronizedList = Collections.synchronizedList(new ArrayList());
            if (list != null && !list.isEmpty()) {
                synchronizedList.addAll(list);
            }
            ArrayList arrayList = new ArrayList();
            for (EmotionPanelInfo emotionPanelInfo : synchronizedList) {
                int i3 = emotionPanelInfo.type;
                if (i3 == 4 || i3 == 5 || i3 == 11) {
                    arrayList.add(emotionPanelInfo);
                }
            }
            if (!arrayList.isEmpty()) {
                synchronizedList.removeAll(arrayList);
            }
            return synchronizedList;
        }
        return list;
    }

    public void checkAndRemoveItem(List<EmotionPanelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(list);
        }
    }

    protected void fillDisSelectedDataList(com.tencent.mobileqq.config.business.m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) mVar);
            return;
        }
        this.mBehindDisSelectedDataList.clear();
        this.mFrontDisSelectedDataList.clear();
        if (mVar != null && !mVar.f202673e.isEmpty()) {
            boolean z16 = false;
            for (int i3 = 0; i3 < mVar.f202673e.size(); i3++) {
                String str = mVar.f202673e.get(i3);
                if (PreDetect.FACE_DETECT.equalsIgnoreCase(str)) {
                    z16 = true;
                } else if ("add".equalsIgnoreCase(str)) {
                    if (com.tencent.mobileqq.core.util.a.o(((EmoticonPanelController) this.mPanelController).getSessionType(), this.mInteractionListener.getPanelChatPieType())) {
                        this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(18, 4, null));
                    } else if (z16) {
                        if (((EmoticonPanelController) this.mPanelController).getBasePanelView().hasBigEmotion && shouldDisplayBigEmoticon(((EmoticonPanelController) this.mPanelController).getSessionType())) {
                            this.mBehindDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
                        }
                    } else if (((EmoticonPanelController) this.mPanelController).getBasePanelView().hasBigEmotion && shouldDisplayBigEmoticon(((EmoticonPanelController) this.mPanelController).getSessionType())) {
                        this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
                    }
                } else if ("setting".equalsIgnoreCase(str) && !this.mHideSettingBtn) {
                    if (z16) {
                        this.mBehindDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
                    } else {
                        this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
                    }
                }
            }
        } else {
            this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
            this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
        }
        EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mFrontDisSelectedDataList);
        EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mBehindDisSelectedDataList);
    }

    public int getBehindDisSelectedTabSize() {
        List<EmotionPanelInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (this.mPanelTabSortEnable && (list = this.mBehindDisSelectedDataList) != null) {
            return list.size();
        }
        return 0;
    }

    public List<EmotionPanelInfo> getFrontDisSelectedDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mFrontDisSelectedDataList;
    }

    public int getFrontDisSelectedTabSize() {
        List<EmotionPanelInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (this.mPanelTabSortEnable && (list = this.mFrontDisSelectedDataList) != null) {
            return list.size();
        }
        return 0;
    }

    public String getGifEntranceIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        com.tencent.mobileqq.config.business.m loadTabSortConObj = loadTabSortConObj();
        if (loadTabSortConObj != null) {
            return loadTabSortConObj.f202675h;
        }
        return "";
    }

    public int getLastCanSelectedTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        List<EmotionPanelInfo> list = this.mEmotionPanelInfos;
        if (list != null && !list.isEmpty()) {
            return (this.mEmotionPanelInfos.size() - getBehindDisSelectedTabSize()) - 1;
        }
        return getFrontDisSelectedTabSize();
    }

    public int getPkgEndSwitchSelectIndex() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        CameraEmoRoamingManagerServiceProxy cameraEmoRoamingManagerServiceProxy = (CameraEmoRoamingManagerServiceProxy) ((EmoticonPanelController) this.mPanelController).app.getRuntimeService(ICameraEmoRoamingManagerService.class);
        if (!cameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp()) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        List<PromotionEmoticonPkg> proEmoticonPkgs = ((EmoticonManagerServiceProxy) ((EmoticonPanelController) this.mPanelController).app.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, ((EmoticonPanelController) this.mPanelController).getBusinessType(), ((EmoticonPanelController) this.mPanelController).getKanDianBiu());
        if (proEmoticonPkgs == null || proEmoticonPkgs.size() == 0) {
            i3--;
        }
        com.tencent.mobileqq.config.business.m loadTabSortConObj = loadTabSortConObj();
        if (loadTabSortConObj != null && loadTabSortConObj.f202674f.size() > 0) {
            i3 = loadTabSortConObj.f202674f.size();
            for (String str : loadTabSortConObj.f202674f) {
                if (("camera".equalsIgnoreCase(str) && !cameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp()) || ("recommend".equalsIgnoreCase(str) && (proEmoticonPkgs == null || proEmoticonPkgs.size() == 0))) {
                    i3--;
                }
            }
        }
        return getFrontDisSelectedTabSize() + i3;
    }

    public List<EmotionPanelInfo> getSortEmotionPanelInfoList(List<EmotionPanelInfo> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        }
        List<EmotionPanelInfo> filterFavoriteBtnInMatchChatAndNearby = filterFavoriteBtnInMatchChatAndNearby(list);
        if (!this.mPanelTabSortEnable) {
            return filterFavoriteBtnInMatchChatAndNearby;
        }
        List<EmotionPanelInfo> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (filterFavoriteBtnInMatchChatAndNearby != null && !filterFavoriteBtnInMatchChatAndNearby.isEmpty()) {
            synchronizedList.addAll(filterFavoriteBtnInMatchChatAndNearby);
        }
        ArrayList arrayList = new ArrayList();
        for (EmotionPanelInfo emotionPanelInfo : synchronizedList) {
            int i16 = emotionPanelInfo.type;
            if (i16 == 13 || i16 == 14) {
                arrayList.add(emotionPanelInfo);
            }
            IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
            if (iPanelInteractionListener != null && iPanelInteractionListener.getCurType() == 10014 && ((i3 = emotionPanelInfo.type) == 8 || i3 == 11)) {
                arrayList.add(emotionPanelInfo);
            }
        }
        if (!arrayList.isEmpty()) {
            synchronizedList.removeAll(arrayList);
        }
        if (!this.mFrontDisSelectedDataList.isEmpty()) {
            synchronizedList.addAll(0, this.mFrontDisSelectedDataList);
        }
        if (!this.mBehindDisSelectedDataList.isEmpty()) {
            synchronizedList.addAll(this.mBehindDisSelectedDataList);
        }
        IPanelInteractionListener iPanelInteractionListener2 = this.mInteractionListener;
        if (iPanelInteractionListener2 != null && (iPanelInteractionListener2.getCurType() == 0 || this.mInteractionListener.getCurType() == 1 || this.mInteractionListener.getCurType() == 3000)) {
            checkAndRemoveItem(synchronizedList);
            checkAndRemoveItem(this.mFrontDisSelectedDataList);
            checkAndRemoveItem(this.mBehindDisSelectedDataList);
        }
        if (!aiTabEnable()) {
            EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 20);
        }
        if (!aniStickerTabEnable()) {
            EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 19);
        } else if (EmoticonTabNtUtils.INSTANCE.isReverseOrderOfRedHeartAndSuperEmoji()) {
            EmoticonStoreTabEntryUtils.reverseTabOrderOfRedHeartAndSuperEmoji(synchronizedList);
        }
        IPanelInteractionListener iPanelInteractionListener3 = this.mInteractionListener;
        if (iPanelInteractionListener3 != null && isQCircleSingleFollow(iPanelInteractionListener3.getCurFriendUin())) {
            EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 4);
            EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 12);
        }
        IPanelInteractionListener iPanelInteractionListener4 = this.mInteractionListener;
        if (iPanelInteractionListener4 != null) {
            String curFriendUin = iPanelInteractionListener4.getCurFriendUin();
            if (!TextUtils.isEmpty(curFriendUin)) {
                if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(curFriendUin)) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("robot_hide_gif_9090", false)) {
                    EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 4);
                    EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 12);
                    EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 17);
                    EmoticonStoreTabEntryUtils.removeEmotionPanelInfoByType(synchronizedList, 18);
                }
            }
        }
        this.mEmotionPanelInfos = synchronizedList;
        updateLastSelectedSecondTabIndex();
        return synchronizedList;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return LOG_TAG;
    }

    public void hideEmoSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.mHideSettingBtn = true;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mInteractionListener = ((EmoticonPanelController) this.mPanelController).getInteractionListener();
        com.tencent.mobileqq.config.business.m loadTabSortConObj = loadTabSortConObj();
        boolean z17 = false;
        if (loadTabSortConObj != null) {
            if (loadTabSortConObj.a() && isInAIOPanel() && !((EmoticonPanelController) this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mPanelTabSortEnable = z16;
        }
        if (!this.mPanelTabSortEnable) {
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getParams().hideSettingBtn || ((EmoticonPanelController) this.mPanelController).getBusinessType() == 3 || this.mHideSettingBtn) {
            z17 = true;
        }
        this.mHideSettingBtn = z17;
        EmoticonPanelSettingHelper emoticonPanelSettingHelper = (EmoticonPanelSettingHelper) ((EmoticonPanelController) this.mPanelController).getHelper(5);
        emoticonPanelSettingHelper.setMoreSettingVisibility(8);
        emoticonPanelSettingHelper.setHideMoreAndSettingButton(true, true);
        if (com.tencent.mobileqq.emosm.h.a()) {
            this.mFrontDisSelectedDataList.clear();
            if (com.tencent.mobileqq.core.util.a.o(((EmoticonPanelController) this.mPanelController).getSessionType(), this.mInteractionListener.getPanelChatPieType())) {
                this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(18, 4, null));
            }
        } else {
            fillDisSelectedDataList(loadTabSortConObj);
        }
        updateLastSelectedSecondTabIndex();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{1, 3, 8};
    }

    protected boolean isInAIOPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mInteractionListener != null && !((EmoticonPanelController) this.mPanelController).getParams().kanDianBiu && this.mInteractionListener.getEditText() != null) {
            return true;
        }
        return false;
    }

    public boolean isQCircleSingleFollow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        try {
            if (((EmoticonPanelController) this.mPanelController).getSessionType() != 10008) {
                return false;
            }
            if (!com.tencent.mobileqq.qcircle.api.utils.a.c(str)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected com.tencent.mobileqq.config.business.m loadTabSortConObj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.config.business.m) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return EmoticonTabSortConfProcessor.g();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mEmotionPanelInfos = null;
        this.mFrontDisSelectedDataList.clear();
        this.mBehindDisSelectedDataList.clear();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            updateViewPagerScrollEnable(i3);
        }
    }

    public boolean setSelection(int i3) {
        List<EmotionPanelInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, i3)).booleanValue();
        }
        if (this.mPanelTabSortEnable && (list = this.mEmotionPanelInfos) != null && i3 >= 0 && i3 < list.size()) {
            return ((EmoticonPanelSettingHelper) ((EmoticonPanelController) this.mPanelController).getHelper(5)).performClick(this.mEmotionPanelInfos.get(i3).type);
        }
        return false;
    }

    protected boolean shouldDisplayBigEmoticon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        return com.tencent.mobileqq.core.util.a.n(i3);
    }

    public void updateLastSelectedSecondTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.mPanelTabSortEnable && this.mEmotionPanelInfos != null) {
            int i3 = BasePanelModel.sLastSelectedSecondTabIndex;
            if (i3 >= 0 && i3 < getFrontDisSelectedTabSize()) {
                BasePanelModel.sLastSelectedSecondTabIndex += getFrontDisSelectedTabSize();
            } else if (getBehindDisSelectedTabSize() > 0 && getLastCanSelectedTabIndex() >= 0 && BasePanelModel.sLastSelectedSecondTabIndex > getLastCanSelectedTabIndex()) {
                BasePanelModel.sLastSelectedSecondTabIndex = getLastCanSelectedTabIndex();
            }
            for (int i16 = 0; i16 < this.mEmotionPanelInfos.size(); i16++) {
                if (this.mEmotionPanelInfos.get(i16).type == 8) {
                    BasePanelView.sRecommendEmoticonViewPoSition = i16;
                    return;
                }
            }
        }
    }

    public int updateOriginalSelectIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, i3)).intValue();
        }
        if (this.mPanelTabSortEnable && getFrontDisSelectedTabSize() != 0 && i3 < getFrontDisSelectedTabSize()) {
            if (i3 < 0) {
                i3 = 0;
            }
            int frontDisSelectedTabSize = i3 + getFrontDisSelectedTabSize();
            int lastCanSelectedTabIndex = getLastCanSelectedTabIndex();
            if (frontDisSelectedTabSize > lastCanSelectedTabIndex) {
                return lastCanSelectedTabIndex;
            }
            return frontDisSelectedTabSize;
        }
        return i3;
    }

    protected void updateViewPagerNoScrollItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.mEmotionPanelInfos != null && ((EmoticonPanelController) this.mPanelController).getViewPager() != null) {
            ((EmoticonPanelController) this.mPanelController).getViewPager().setNoScrollItem(getFrontDisSelectedTabSize(), getLastCanSelectedTabIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateViewPagerScrollEnable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (!this.mPanelTabSortEnable) {
            ((EmoticonPanelController) this.mPanelController).getViewPager().setRightScrollDisEnable(false);
            ((EmoticonPanelController) this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
            return;
        }
        if (i3 != 0 && i3 <= getFrontDisSelectedTabSize()) {
            ((EmoticonPanelController) this.mPanelController).getViewPager().setRightScrollDisEnable(true);
            ((EmoticonPanelController) this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
        } else if (i3 >= getLastCanSelectedTabIndex()) {
            ((EmoticonPanelController) this.mPanelController).getViewPager().setRightScrollDisEnable(false);
            ((EmoticonPanelController) this.mPanelController).getViewPager().setLeftScrollDisEnable(true);
        } else {
            ((EmoticonPanelController) this.mPanelController).getViewPager().setRightScrollDisEnable(false);
            ((EmoticonPanelController) this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
        }
        updateViewPagerNoScrollItem();
    }
}
