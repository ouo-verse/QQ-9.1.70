package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes12.dex */
public class EmoticonPanelController implements EmotionPanelListView.PullAndFastScrollListener, IEmoticonPanelController {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelController";
    QQEmoticonMainPanelApp app;
    EmoticonCallback callback;
    final Context context;
    BasePanelModel mBasePanelModel;
    BasePanelView mBasePanelView;
    final EmoticonReportDtHelper mDtReportHelper;
    private EmoticonHelperProvider mHelperProvider;
    IPanelInteractionListener mInteractionListener;
    final EmoticonPanelExtendHelper mPanelExtendHelper;
    final EmoticonPanelFavHelper mPanelFavHelper;
    final EmoticonPanelHotPicSearchHelper mPanelHotPicSearchHelper;
    final EmoticonPanelMallHelper mPanelMallHelper;
    final EmoticonPanelSettingHelper mPanelSettingHelper;
    final EmoticonPanelSystemAndEmojiHelper mPanelSystemAndEmojiHelper;
    final EmoticonPanelTabSortHelper mPanelTabSortHelper;

    /* loaded from: classes12.dex */
    public interface PanelDataCallback {
        void callbackInMainThread();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EmoticonPanelController(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.mHelperProvider = new EmoticonHelperProvider(this);
        this.mPanelExtendHelper = (EmoticonPanelExtendHelper) getHelper(1);
        this.mPanelFavHelper = (EmoticonPanelFavHelper) getHelper(2);
        this.mPanelSystemAndEmojiHelper = (EmoticonPanelSystemAndEmojiHelper) getHelper(3);
        this.mPanelMallHelper = (EmoticonPanelMallHelper) getHelper(4);
        this.mPanelSettingHelper = (EmoticonPanelSettingHelper) getHelper(5);
        this.mPanelTabSortHelper = (EmoticonPanelTabSortHelper) getHelper(7);
        this.mPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) getHelper(6);
        this.mDtReportHelper = (EmoticonReportDtHelper) getHelper(9);
    }

    private void registerOtherProcessCallback() {
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp;
        if (!QQEmoticonMainPanelApp.isMainProcess() && (qQEmoticonMainPanelApp = this.app) != null) {
            qQEmoticonMainPanelApp.registerOtherProcessCallback();
        }
    }

    public void addTabListAdditionalView(boolean z16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, this, Boolean.valueOf(z16), view);
        } else {
            this.mBasePanelView.addTabListAdditionalView(z16, view);
        }
    }

    public void deleteEmoticonClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        EmoticonCallback emoticonCallback = this.callback;
        if (emoticonCallback != null) {
            emoticonCallback.delete();
        }
        this.mBasePanelModel.reportDeleteEmoticonClick();
    }

    public void disableHorizontalScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this);
        } else if (getViewPager() != null) {
            getViewPager().setLeftScrollDisEnable(true);
            getViewPager().setRightScrollDisEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchDraw(Canvas canvas) {
        this.mBasePanelView.dispatchDraw(canvas);
    }

    public void enableHorizontalScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this);
        } else if (getViewPager() != null) {
            getViewPager().setLeftScrollDisEnable(false);
            getViewPager().setRightScrollDisEnable(false);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public int findIndexByPanelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this, i3)).intValue();
        }
        return this.mBasePanelModel.findIndexByPanelType(i3);
    }

    public int findTabIndexByEpId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str)).intValue();
        }
        return this.mPanelMallHelper.findTabIndexByEpId(this.app, str, getPanelDataList());
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void followHand(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) motionEvent);
        }
    }

    public BasePanelModel getBasePanelModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (BasePanelModel) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        return this.mBasePanelModel;
    }

    public BasePanelView getBasePanelView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (BasePanelView) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return this.mBasePanelView;
    }

    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Integer) iPatchRedirector.redirect((short) 72, (Object) this)).intValue();
        }
        return this.mBasePanelModel.businessType;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public List<EmotionPanelData> getCustomEmotionData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (List) iPatchRedirector.redirect((short) 85, (Object) this, i3);
        }
        return getParams().getCustomEmotionData(i3);
    }

    public int getDeleteLeftPkgCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Integer) iPatchRedirector.redirect((short) 78, (Object) this)).intValue();
        }
        return this.mBasePanelView.mDeleteLeftPkgCount;
    }

    public EmoticonListProvider getEmoticonListProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (EmoticonListProvider) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.mBasePanelModel.getEmoticonListProvider();
    }

    public int getEmoticonTab(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str)).intValue();
        }
        return this.mPanelMallHelper.getEmoticonTab(str, getPanelDataList(), BasePanelModel.sIsRecommendExist);
    }

    public EmoticonTabAdapter getEmoticonTabAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (EmoticonTabAdapter) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mBasePanelView.mEmoticonTabAdapter;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public EmotionInjectionInfo getEmotionInjectionInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (EmotionInjectionInfo) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        return this.mBasePanelModel.getEmotionInjectionInfo(i3);
    }

    public com.tencent.mobileqq.i getEmotionPanelManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBasePanelModel.mEmotionPanelInjectionInfoManager;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public List<EmotionPanelData> getFilterEmotionData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (List) iPatchRedirector.redirect((short) 86, (Object) this, i3);
        }
        return getParams().getFilterEmotionData(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFromType(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this, z16)).intValue();
        }
        return this.mBasePanelModel.getFromType(z16);
    }

    public String getGifEntranceIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return this.mPanelTabSortHelper.getGifEntranceIconUrl();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public <T extends AbstractEmoticonPanelHelper> T getHelper(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return (T) this.mHelperProvider.getHelper(i3);
    }

    public EmoticonHelperProvider getHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonHelperProvider) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mHelperProvider;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public IPanelInteractionListener getHostInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IPanelInteractionListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return getInteractionListener();
    }

    public IPanelInteractionListener getInteractionListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IPanelInteractionListener) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mInteractionListener;
    }

    public boolean getKanDianBiu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this)).booleanValue();
        }
        return this.mBasePanelView.kanDianBiu;
    }

    public ImageView getNewFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (ImageView) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return this.mBasePanelView.mNewFlag;
    }

    public EmotionPanelViewPagerAdapter getPageAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (EmotionPanelViewPagerAdapter) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.mBasePanelView.pageAdapter;
    }

    public EmoticonMainPanel getPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EmoticonMainPanel) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mBasePanelView.getMainPanel();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public BaseEmotionPanelBusinessParam getPanelBusinessParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (BaseEmotionPanelBusinessParam) iPatchRedirector.redirect((short) 87, (Object) this, i3);
        }
        return getParams().businessParamMap.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public List<EmotionPanelInfo> getPanelDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.mBasePanelModel.panelDataList;
    }

    public EmoticonPanelParams getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoticonPanelParams) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mBasePanelModel.mParams;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public int getSessionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this)).intValue();
        }
        return this.mBasePanelModel.sessionType;
    }

    public int[] getSysEmotionOrder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (int[]) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mBasePanelView.getSysEmotionOrder();
    }

    public AdapterView.OnItemClickListener getTabItemClickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (AdapterView.OnItemClickListener) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.mPanelMallHelper.tabItemClickListener;
    }

    public int getToastOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Integer) iPatchRedirector.redirect((short) 74, (Object) this)).intValue();
        }
        return this.mBasePanelView.toastOffset;
    }

    public EmoticonPanelViewPager getViewPager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (EmoticonPanelViewPager) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mBasePanelView.viewPager;
    }

    public void hideAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
        } else {
            this.mBasePanelView.hideAllTabs();
        }
    }

    public void hideItemByTypeIfNeed(int i3, boolean z16, List<EmotionPanelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16), list);
        } else {
            this.mBasePanelModel.hideItemByTypeIfNeed(i3, z16, list);
        }
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mBasePanelModel.init();
        this.mHelperProvider.dispatchLifeCycle(1);
        this.mBasePanelView.initView();
        this.mHelperProvider.dispatchLifeCycle(2);
        registerOtherProcessCallback();
    }

    public void initEmoticonView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            this.mBasePanelView.initEmoticonView(i3);
        } else {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        }
    }

    public void initPanelExtendHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        } else {
            this.mPanelExtendHelper.initPanelExtendHeight();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public boolean isEmoticonOnShow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, i3)).booleanValue();
        }
        return this.mBasePanelModel.isEmoticonOnShow(i3);
    }

    public boolean isFilterSysFaceBeyond255Enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mBasePanelView.isFilterSysFaceBeyond255Enable();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController, rg2.a
    public boolean isInAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null && iPanelInteractionListener.isInAio() && getBusinessType() == 0) {
            return true;
        }
        return false;
    }

    public boolean isInC2COrTroopAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        if (this.mInteractionListener != null && isInAIO() && (this.mInteractionListener.getCurType() == 0 || this.mInteractionListener.getCurType() == 1)) {
            return true;
        }
        return false;
    }

    public boolean isOnlySysEmotion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return ((Boolean) iPatchRedirector.redirect((short) 81, (Object) this)).booleanValue();
        }
        return this.mBasePanelView.mIsOnlySysEmotion;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public boolean isPanelOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.mPanelExtendHelper.isPanelOpen();
    }

    public boolean isResumed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Boolean) iPatchRedirector.redirect((short) 77, (Object) this)).booleanValue();
        }
        return this.mBasePanelView.isResumed;
    }

    public boolean isSecondTabInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        return this.mBasePanelView.getMainPanel().mSecondTabInited;
    }

    public boolean isShowExtendPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        return this.mPanelExtendHelper.isShowExtendPanel();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController
    public boolean keepLottieMerged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Boolean) iPatchRedirector.redirect((short) 90, (Object) this)).booleanValue();
        }
        return getParams().keepLottieMerged;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        this.mBasePanelView.onAttachedToWindow();
        this.mHelperProvider.dispatchLifeCycle(9);
    }

    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "OnDestory");
        }
        this.mHelperProvider.dispatchLifeCycle(8);
        this.mBasePanelView.onDestory();
        this.mBasePanelModel.onDestory();
        this.callback = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        this.mBasePanelView.onDetachedFromWindow();
        this.mHelperProvider.dispatchLifeCycle(10);
    }

    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.mHelperProvider.dispatchLifeCycle(4, -1, z16);
        }
    }

    public void onMeasureMainPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
        } else {
            this.mBasePanelView.onMeasureMainPanel();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            if (this.app == null) {
                return;
            }
            this.mBasePanelView.onPause();
            this.mHelperProvider.dispatchLifeCycle(7);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener, com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onPullDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.mHelperProvider.dispatchLifeCycle(11);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void onPullUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mHelperProvider.dispatchLifeCycle(12);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.mBasePanelView.onResume();
        }
    }

    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.mHelperProvider.dispatchLifeCycle(5);
            this.mBasePanelView.onShow();
        }
    }

    public void onShowPageFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
        } else {
            this.mHelperProvider.dispatchLifeCycle(14);
        }
    }

    public void preloadWebProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            this.mPanelMallHelper.preloadWebProcess();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelController, rg2.a
    public void removePopupGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.mPanelSystemAndEmojiHelper.removePopupGuide();
        }
    }

    public void setBasePanelModel(BasePanelModel basePanelModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) basePanelModel);
        } else {
            this.mBasePanelModel = basePanelModel;
        }
    }

    public void setBasePanelView(BasePanelView basePanelView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) basePanelView);
        } else {
            this.mBasePanelView = basePanelView;
        }
    }

    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) emoticonCallback);
        } else {
            this.callback = emoticonCallback;
            getParams().callback = emoticonCallback;
        }
    }

    public void setCurType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mBasePanelModel.setCurType(i3);
        }
    }

    public void setEmoticonApp(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) qQEmoticonMainPanelApp);
            return;
        }
        this.app = qQEmoticonMainPanelApp;
        this.mBasePanelView.setEmoticonApp(qQEmoticonMainPanelApp);
        this.mBasePanelModel.setEmoticonApp(qQEmoticonMainPanelApp);
    }

    public void setEmoticonListProvider(EmoticonListProvider emoticonListProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) emoticonListProvider);
        } else {
            this.mBasePanelModel.setEmoticonListProvider(emoticonListProvider);
        }
    }

    public void setFilterSysFaceBeyond255Enable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mBasePanelView.setFilterSysFaceBeyond255Enable(z16);
        }
    }

    public void setHideAllSettingTabs(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
        } else {
            this.mBasePanelView.mHideAllSettingTabs = z16;
        }
    }

    public void setKanDianBiu(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, z16);
        } else {
            this.mBasePanelView.kanDianBiu = z16;
        }
    }

    public void setOnlySysEmotionEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mBasePanelView.setOnlySysEmotionEnable(z16);
        }
    }

    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
        } else {
            this.mBasePanelView.setOverScrollMode(i3);
        }
    }

    public void setSysEmotionOrder(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iArr);
        } else {
            this.mBasePanelView.setSysEmotionOrder(iArr);
        }
    }

    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mBasePanelView.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowPanelAndSetSelection(int i3, int i16) {
        return this.mBasePanelView.shouldShowPanelAndSetSelection(i3, i16);
    }

    public void showAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
        } else {
            this.mBasePanelView.showAllTabs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showPanelByTabIndex(int i3) {
        this.mBasePanelView.showPanelByTabIndex(i3);
    }

    public void switchSystemEmojiTabLocationPos(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mPanelSystemAndEmojiHelper.switchSystemEmojiTabLocationPos(i3, i16);
        }
    }

    public void switchTabMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mBasePanelView.switchTabMode(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncInitPanelDataList(boolean z16) {
        this.mBasePanelModel.syncInitPanelDataList(z16);
    }

    public void updateEmojiMallRedpoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
        } else {
            this.mPanelSystemAndEmojiHelper.updateEmojiMallRedpoint();
        }
    }

    public void updateFavEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        } else {
            this.mPanelFavHelper.updateFavEmoticonPanel();
        }
    }

    public void updateLastEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.mPanelMallHelper.updateLastEmoticonPanel();
        }
    }

    public void updateLastSelectedSecondTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else if (this.mBasePanelView.mIsTabOrderChanged) {
            BasePanelModel.sLastSelectedSecondTabIndex = findIndexByPanelType(7);
            this.mBasePanelView.mIsTabOrderChanged = false;
        } else {
            this.mBasePanelModel.updateLastSelectedSecondTabIndex();
        }
    }

    public void updateMagicPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.mPanelMallHelper.updateMagicPanel();
        }
    }

    public void updateRecentEmoji(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) list);
        } else {
            this.mPanelSystemAndEmojiHelper.updateRecentEmoji(list);
        }
    }

    public void updateSystemAndEmojiPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
        } else {
            this.mPanelSystemAndEmojiHelper.updateSystemAndEmojiPanel();
        }
    }

    public void updateTabSortLastSelectedSecondTabIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this);
        } else {
            this.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
        }
    }

    public void initEmoticonView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) {
            this.mBasePanelView.initEmoticonView(str);
        } else {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        }
    }

    public void initEmoticonView(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) {
            this.mBasePanelView.initEmoticonView(i3, str);
        } else {
            iPatchRedirector.redirect((short) 45, (Object) this, i3, (Object) str);
        }
    }

    public void initEmoticonView(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 46)) {
            this.mBasePanelView.initEmoticonView(i3, i16, str);
        } else {
            iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
    }
}
