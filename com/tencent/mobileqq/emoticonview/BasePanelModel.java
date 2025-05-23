package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.emoticon.EmoticonReportUtil;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.model.IBasePanelModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes12.dex */
public class BasePanelModel implements IBasePanelModel {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "BasePanelModel";
    static boolean sIsRecommendExist;
    public static int sLastSelectedSecondTabIndex;
    public static int sOldSelectedSecondTabIndex;
    List<EmoticonPackage> addEmoPkgList;
    private QQEmoticonMainPanelApp app;
    public int businessType;
    private final EmoticonPanelController mController;
    private EmoticonListProvider mEmoticonListProvider;
    com.tencent.mobileqq.i mEmotionPanelInjectionInfoManager;
    EmoticonPanelParams mParams;
    com.tencent.mobileqq.hitrate.d mWebPreloadHitSession;
    public List<EmotionPanelInfo> panelDataList;
    int sessionType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        sOldSelectedSecondTabIndex = -1;
        sLastSelectedSecondTabIndex = -1;
        sIsRecommendExist = true;
    }

    public BasePanelModel(IEmoticonPanelController iEmoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iEmoticonPanelController);
            return;
        }
        this.sessionType = 0;
        this.businessType = 0;
        this.addEmoPkgList = new ArrayList();
        this.mWebPreloadHitSession = new com.tencent.mobileqq.hitrate.d("emoticon_panel", "com.tencent.mobileqq:tool");
        EmoticonPanelController emoticonPanelController = (EmoticonPanelController) iEmoticonPanelController;
        this.mController = emoticonPanelController;
        this.app = emoticonPanelController.app;
    }

    private void hideItemByType(int i3, List<EmotionPanelInfo> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    if (list.get(i16).type == i3) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 != -1) {
                list.remove(i16);
            }
            EmoticonPanelTabSortHelper emoticonPanelTabSortHelper = (EmoticonPanelTabSortHelper) this.mController.getHelper(7);
            if (emoticonPanelTabSortHelper != null) {
                EmoticonStoreTabEntryUtils.removeDisSelectedDataByType(emoticonPanelTabSortHelper.getFrontDisSelectedDataList(), i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.model.IBasePanelModel
    public int findIndexByPanelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        List<EmotionPanelInfo> list = this.panelDataList;
        if (list != null && !list.isEmpty()) {
            int i16 = 0;
            for (EmotionPanelInfo emotionPanelInfo : this.panelDataList) {
                if (emotionPanelInfo != null && emotionPanelInfo.type == i3) {
                    return i16;
                }
                i16++;
            }
        }
        return -1;
    }

    protected void getCommonUsedSmallYellowEmoitonRequest(SharedPreferences sharedPreferences) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) sharedPreferences);
        } else {
            ThreadManagerV2.excute(new Runnable(sharedPreferences) { // from class: com.tencent.mobileqq.emoticonview.BasePanelModel.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SharedPreferences val$sp;

                {
                    this.val$sp = sharedPreferences;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePanelModel.this, (Object) sharedPreferences);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((EmoticonHandlerProxy) BasePanelModel.this.app.getBusinessHandler(EmoticonHandler.F)).getCommonUsedSmallYellowEmoitonRequest();
                        this.val$sp.edit().putLong(CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, System.currentTimeMillis()).apply();
                    }
                }
            }, 64, null, true);
        }
    }

    public EmoticonListProvider getEmoticonListProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EmoticonListProvider) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mEmoticonListProvider;
    }

    public EmotionInjectionInfo getEmotionInjectionInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EmotionInjectionInfo) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (this.mEmotionPanelInjectionInfoManager == null) {
            return null;
        }
        return this.mEmotionPanelInjectionInfoManager.c(com.tencent.mobileqq.config.business.n.b(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFromType(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, z16)).intValue();
        }
        int i3 = this.sessionType;
        if (i3 != -1) {
            int intValue = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(i3)).intValue();
            if (intValue == 0) {
                return 1;
            }
            if (intValue != 1) {
                if (intValue != 3) {
                    if (z16) {
                        return 4;
                    }
                } else {
                    return 2;
                }
            }
            return 3;
        }
        return 0;
    }

    public void hideItemByTypeIfNeed(int i3, boolean z16, List<EmotionPanelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), list);
            return;
        }
        if (list == null) {
            return;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.app;
        if (qQEmoticonMainPanelApp != null && qQEmoticonMainPanelApp.getQQAppInterface() == null) {
            z16 = true;
        }
        if (z16) {
            hideItemByType(i3, list);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.model.IBasePanelModel
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            initPanelInjectInfo();
        }
    }

    protected void initPanelInjectInfo() {
        Map<String, EmotionInjectionInfo> d16;
        AbsEmoticonPanelLifecycleObserver absEmoticonPanelLifecycleObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.i iVar = this.mEmotionPanelInjectionInfoManager;
        if (iVar != null && (d16 = iVar.d()) != null) {
            Iterator<Map.Entry<String, EmotionInjectionInfo>> it = d16.entrySet().iterator();
            while (it.hasNext()) {
                EmotionInjectionInfo value = it.next().getValue();
                if (value != null && (absEmoticonPanelLifecycleObserver = value.lifecycleObserver) != null && absEmoticonPanelLifecycleObserver.providerID > 0) {
                    absEmoticonPanelLifecycleObserver.setPanelController(this.mController);
                    EmoticonHelperProvider helperProvider = this.mController.getHelperProvider();
                    AbsEmoticonPanelLifecycleObserver absEmoticonPanelLifecycleObserver2 = value.lifecycleObserver;
                    helperProvider.register(absEmoticonPanelLifecycleObserver2.providerID, absEmoticonPanelLifecycleObserver2);
                }
            }
        }
    }

    public void initParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mParams = new EmoticonPanelParams(this.mController);
        }
    }

    public boolean isEmoticonOnShow(int i3) {
        int i16;
        EmotionPanelInfo emotionPanelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        List<EmotionPanelInfo> list = this.panelDataList;
        if (list != null && (i16 = sLastSelectedSecondTabIndex) >= 0 && i16 < list.size() && (emotionPanelInfo = this.panelDataList.get(sLastSelectedSecondTabIndex)) != null && emotionPanelInfo.type == i3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.model.IBasePanelModel
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        List<EmotionPanelInfo> list = this.panelDataList;
        if (list != null) {
            list.clear();
        }
        com.tencent.mobileqq.emoticon.c.c().b();
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.app;
        if (qQEmoticonMainPanelApp != null) {
            SharedPreferences sharedPreferences = qQEmoticonMainPanelApp.getApplication().getSharedPreferences(CommonUsedSystemEmojiManagerConstants.SP_FILE_NAME, 0);
            long j3 = sharedPreferences.getLong(CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, 0L);
            if (System.currentTimeMillis() - j3 > 43200000 || System.currentTimeMillis() - j3 < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "onDestroy commonused send");
                }
                getCommonUsedSmallYellowEmoitonRequest(sharedPreferences);
            }
            EmoticonManagerServiceProxy emoticonManagerServiceProxy = (EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class);
            if (emoticonManagerServiceProxy != null) {
                emoticonManagerServiceProxy.pushRecommendExposeInfoToSP();
            }
        }
        this.mWebPreloadHitSession.b();
        this.mEmotionPanelInjectionInfoManager = null;
    }

    public void reportDeleteEmoticonClick() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        List<EmotionPanelInfo> list = this.panelDataList;
        if (list != null && (i3 = sLastSelectedSecondTabIndex) >= 0 && i3 < list.size()) {
            int i16 = this.panelDataList.get(sLastSelectedSecondTabIndex).type;
            if (i16 == 7) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
            } else if (i16 == 10) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
            }
        }
    }

    public void setCurType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.sessionType = i3;
        switch (i3) {
            case 99999:
                this.businessType = 1;
                return;
            case 100000:
            default:
                this.businessType = 0;
                return;
            case 100001:
                this.businessType = 2;
                return;
            case 100002:
                this.businessType = 3;
                return;
            case 100003:
                this.businessType = 4;
                return;
            case 100004:
                this.businessType = 5;
                return;
            case 100005:
                this.businessType = 6;
                return;
        }
    }

    public void setEmoticonApp(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQEmoticonMainPanelApp);
        } else {
            this.app = qQEmoticonMainPanelApp;
        }
    }

    public void setEmoticonListProvider(EmoticonListProvider emoticonListProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonListProvider);
        } else {
            this.mEmoticonListProvider = emoticonListProvider;
        }
    }

    public void syncInitPanelDataList(boolean z16) {
        EmoticonListProvider emoticonListProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        if (!this.mController.isSecondTabInited() && (emoticonListProvider = this.mEmoticonListProvider) != null) {
            this.panelDataList = this.mController.mPanelTabSortHelper.getSortEmotionPanelInfoList(emoticonListProvider.getEmotionPanelInfo(z16, this.mController.getParams().onlySysAndEmoji));
            QLog.i(LOG_TAG, 1, "syncInitPanelDataList, data=" + this.panelDataList.size());
        }
    }

    public void updateLastSelectedSecondTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (sLastSelectedSecondTabIndex != findIndexByPanelType(12)) {
            int deleteLeftPkgCount = sLastSelectedSecondTabIndex - this.mController.getDeleteLeftPkgCount();
            sLastSelectedSecondTabIndex = deleteLeftPkgCount;
            if (deleteLeftPkgCount < 0) {
                sLastSelectedSecondTabIndex = this.mController.mPanelTabSortHelper.getFrontDisSelectedTabSize();
            }
        }
    }

    public void webPreloadHitSessionBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mWebPreloadHitSession.a();
        }
    }

    public void webPreloadHitSessionHit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.mWebPreloadHitSession.d();
        }
    }
}
