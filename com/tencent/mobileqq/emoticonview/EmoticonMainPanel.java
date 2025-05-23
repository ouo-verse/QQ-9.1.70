package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.fragment.app.Argus;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.argus.EmoticonMainPanelCreator;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.view.IBasePanelView;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.HotPicSearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import java.util.List;
import java.util.Map;

/* loaded from: classes12.dex */
public class EmoticonMainPanel extends RelativeLayout implements EmotionPanelListView.PullAndFastScrollListener, IEmoticonPackageDownloadListener, IEmoticonMainPanel {
    static IPatchRedirector $redirector_ = null;
    protected static final String LOG_TAG = "EmoticonMainPanel";
    public static long sOpenStartTime;

    @Deprecated
    public boolean disableAutoDownload;

    @Deprecated
    public boolean disableGuide;

    @Deprecated
    public boolean disableGuideOneTime;

    @Deprecated
    public boolean disableMoreEmotionButton;

    @Deprecated
    public boolean hasBigEmotion;
    public boolean isHiden;
    private IEmoticonMainPanel.DispatchKeyEventListener mDispatchKeyEventListener;
    private EmoticonPanelController mEmoController;
    public HorizontalListViewEx mEmoticonTabs;
    public int mEmotionType;
    private boolean mEnablePullPanel;
    public int mLocalId;
    public boolean mSecondTabInited;

    @Deprecated
    public boolean onlySysAndEmoji;
    public boolean showStickerGuide;
    public View stickerMaskLayout;
    private IEmoticonMainPanel.OnPanelTabSelectedCallBack tabSelectedCallBack;

    /* loaded from: classes12.dex */
    public interface OnPanelTabSelectedCallBack {
        void onPanelTabSelected(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 80)) {
            redirector.redirect((short) 80);
        } else {
            Argus.INSTANCE.addBlockCreator(new EmoticonMainPanelCreator());
        }
    }

    public EmoticonMainPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.hasBigEmotion = true;
        this.onlySysAndEmoji = false;
        this.disableGuide = false;
        this.disableGuideOneTime = false;
        this.disableAutoDownload = false;
        this.disableMoreEmotionButton = false;
        this.isHiden = false;
        this.showStickerGuide = false;
        this.mLocalId = -1;
        this.mEmotionType = -1;
        this.mEnablePullPanel = true;
        EmoticonPanelController emoticonPanelController = new EmoticonPanelController(context);
        this.mEmoController = emoticonPanelController;
        emoticonPanelController.setBasePanelView(new BasePanelView(this));
        this.mEmoController.setBasePanelModel(new BasePanelModel(this.mEmoController));
        this.mEmoController.getBasePanelModel().initParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onShow$0() {
        boolean a16 = HotPicSearchUtils.f306386a.a();
        QLog.i(LOG_TAG, 1, "onShow  hotPicSearchUseLibra:" + a16);
        if (a16) {
            QQEmoticonPicLoader.f356316a.b();
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener
    public void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) emoticonPackageDownloadListener);
        } else {
            com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(emoticonPackageDownloadListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void addTabListAdditionalView(boolean z16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), view);
        } else {
            this.mEmoController.addTabListAdditionalView(z16, view);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void deleteEmoticonClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
        } else {
            this.mEmoController.deleteEmoticonClick();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void disableHorizontalScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this);
            return;
        }
        EmoticonPanelController emoticonPanelController = this.mEmoController;
        if (emoticonPanelController != null) {
            emoticonPanelController.disableHorizontalScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.dispatchDraw(canvas);
            this.mEmoController.dispatchDraw(canvas);
        } catch (Throwable th5) {
            QLog.e(LOG_TAG, 1, "dispatchDraw error, stack:" + MsfSdkUtils.getStackTraceString(th5));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this, (Object) keyEvent)).booleanValue();
        }
        IEmoticonMainPanel.DispatchKeyEventListener dispatchKeyEventListener = this.mDispatchKeyEventListener;
        if (dispatchKeyEventListener != null && dispatchKeyEventListener.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void doAutoDownload(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "func doAutoDownload begins.");
        }
        com.tencent.mobileqq.emoticon.c.c().d(i3);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "func doAutoDownload ends.");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void enableHorizontalScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
            return;
        }
        EmoticonPanelController emoticonPanelController = this.mEmoController;
        if (emoticonPanelController != null) {
            emoticonPanelController.enableHorizontalScroll();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void followHand(MotionEvent motionEvent) {
        EmoticonPanelExtendHelper emoticonPanelExtendHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.mEnablePullPanel) {
            return;
        }
        if ((getPanelInteractionListener() == null || getPanelInteractionListener().supportExtendPanel()) && (emoticonPanelExtendHelper = this.mEmoController.mPanelExtendHelper) != null) {
            emoticonPanelExtendHelper.refreshPanel(motionEvent);
        }
    }

    public EmoticonMainPanel getEmoPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (EmoticonMainPanel) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public int getEmoticonTab(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        return this.mEmoController.getEmoticonTab(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public int getLastPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return BasePanelModel.sLastSelectedSecondTabIndex;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public IPanelInteractionListener getPanelInteractionListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (IPanelInteractionListener) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.mEmoController.getInteractionListener();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public View getStickerMaskLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.stickerMaskLayout;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @NonNull
    public RelativeLayout getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void hideAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
        } else {
            this.mEmoController.hideAllTabs();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            init(baseQQAppInterface, i3, context, i16, str, -1, iPanelInteractionListener, false, new DefaultEmoticonListProvider(this.mEmoController));
        } else {
            iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, iPanelInteractionListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void initEmoticonView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            this.mEmoController.initEmoticonView(i3);
        } else {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        }
    }

    public boolean isFilterSysFaceBeyond255Enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mEmoController.isFilterSysFaceBeyond255Enable();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public boolean isHiden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isHiden;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public boolean isOnlySysAndEmoji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return this.onlySysAndEmoji;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public boolean isPanelOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        return this.mEmoController.isPanelOpen();
    }

    public boolean isShowExtendPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.mEmoController.isShowExtendPanel();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public boolean isTabVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        View findViewById = findViewById(R.id.f166941ja2);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mEmoController.onAttachedToWindow();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        QLog.i(LOG_TAG, 1, "onDestory");
        this.mEmoController.onDestory();
        if (HotPicSearchUtils.f306386a.a()) {
            QQEmoticonPicLoader.f356316a.b().release();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
        } else {
            super.onDetachedFromWindow();
            this.mEmoController.onDetachedFromWindow();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
            return;
        }
        QLog.i(LOG_TAG, 1, "onHide");
        this.mEmoController.onHide(z16);
        this.mEnablePullPanel = false;
        Argus.INSTANCE.updatePage(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) motionEvent)).booleanValue();
        }
        ViewParent parent = getParent();
        if (parent != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                parent.requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            this.mEmoController.onMeasureMainPanel();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onPanelTabSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, i3);
            return;
        }
        IEmoticonMainPanel.OnPanelTabSelectedCallBack onPanelTabSelectedCallBack = this.tabSelectedCallBack;
        if (onPanelTabSelectedCallBack != null) {
            onPanelTabSelectedCallBack.onPanelTabSelected(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            this.mEmoController.onPause();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener, com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onPullDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
        } else {
            if (!this.mEnablePullPanel) {
                return;
            }
            this.mEmoController.onPullDown();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void onPullUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        } else {
            if (!this.mEnablePullPanel) {
                return;
            }
            this.mEmoController.onPullUp();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            this.mEmoController.onResume();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        QLog.i(LOG_TAG, 1, "onShow");
        this.mEmoController.onShow();
        this.mEnablePullPanel = true;
        Argus.INSTANCE.updatePage(this);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.c
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonMainPanel.lambda$onShow$0();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void preloadWebProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
        } else {
            this.mEmoController.preloadWebProcess();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void refreshEmoticonList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, i3);
            return;
        }
        EmoticonPanelController emoticonPanelController = this.mEmoController;
        if (emoticonPanelController != null && emoticonPanelController.findIndexByPanelType(i3) == BasePanelModel.sLastSelectedSecondTabIndex) {
            QLog.i(LOG_TAG, 1, "match current emoticon panel, emoticonType:" + i3);
            if (i3 == 20) {
                ((EmoticonPanelAIHelper) this.mEmoController.getHelper(13)).loadPicData();
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener
    public void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) emoticonPackageDownloadListener);
        } else {
            com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(emoticonPackageDownloadListener);
        }
    }

    public void removePopupGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.mEmoController.removePopupGuide();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonCallback);
        } else {
            this.mEmoController.setCallBack(emoticonCallback);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setDisableAutoDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.disableAutoDownload = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setDisableGuide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, z16);
        } else {
            this.disableGuide = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setDisableGuideOneTime(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        } else {
            this.disableGuideOneTime = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setDisableMoreEmotionButton(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        } else {
            this.disableMoreEmotionButton = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setDispatchKeyEventListener(IEmoticonMainPanel.DispatchKeyEventListener dispatchKeyEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) dispatchKeyEventListener);
        } else {
            this.mDispatchKeyEventListener = dispatchKeyEventListener;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void setEmoSettingVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }

    public void setFilterSysFaceBeyond255Enable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mEmoController.setFilterSysFaceBeyond255Enable(z16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setHasBigEmotion(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.hasBigEmotion = z16;
        }
    }

    public void setHideAllSettingTabs(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mEmoController.setHideAllSettingTabs(z16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setIsHiden(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
        } else {
            this.isHiden = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setOnlySysAndEmoji(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
        } else {
            this.onlySysAndEmoji = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setOnlySysEmotionEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mEmoController.setOnlySysEmotionEnable(z16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setSecondTabInited(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mSecondTabInited = z16;
        }
    }

    public void setSysEmotionOrder(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) iArr);
        } else {
            this.mEmoController.setSysEmotionOrder(iArr);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setTabListOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mEmoController.setOverScrollMode(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setTabSecondaryEmoticonPadding(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            View findViewById = findViewById(R.id.container_secondary_tab);
            findViewById.setPadding(i3, findViewById.getPaddingTop(), i16, findViewById.getPaddingBottom());
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void setTabSelectedCallBack(IEmoticonMainPanel.OnPanelTabSelectedCallBack onPanelTabSelectedCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) onPanelTabSelectedCallBack);
        } else {
            this.tabSelectedCallBack = onPanelTabSelectedCallBack;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, i3);
        } else {
            this.mEmoController.setVisibility(i3);
            super.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void showAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        EmoticonPanelController emoticonPanelController = this.mEmoController;
        if (emoticonPanelController != null) {
            emoticonPanelController.showAllTabs();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public boolean showStickerGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.showStickerGuide;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void switchSystemEmojiTabLocationPos(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mEmoController.switchSystemEmojiTabLocationPos(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void switchTabMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.mEmoController.switchTabMode(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void switchToAnonymous(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateDeleteBtnVisibility(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) charSequence);
        } else {
            ((EmoticonPanelExtendHelper) this.mEmoController.getHelper(1)).updateDeleteBtnVisibility(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateFavEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mEmoController.updateFavEmoticonPanel();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateLastEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        } else {
            this.mEmoController.updateLastEmoticonPanel();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateMagicPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        } else {
            this.mEmoController.updateMagicPanel();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updatePanelBusinessParam(int i3, BaseEmotionPanelBusinessParam baseEmotionPanelBusinessParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3, (Object) baseEmotionPanelBusinessParam);
            return;
        }
        EmoticonPanelParams params = this.mEmoController.getParams();
        if (params == null) {
            return;
        }
        if (baseEmotionPanelBusinessParam == null) {
            params.businessParamMap.remove(Integer.valueOf(i3));
        } else {
            params.businessParamMap.put(Integer.valueOf(i3), baseEmotionPanelBusinessParam);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateRecentEmoji(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
        } else {
            this.mEmoController.updateRecentEmoji(list);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void updateSystemAndEmojiPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.mEmoController.updateSystemAndEmojiPanel();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public EmoticonPanelController getEmoController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.mEmoController : (EmoticonPanelController) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            init(baseQQAppInterface, i3, context, i16, str, i17, iPanelInteractionListener, false, new DefaultEmoticonListProvider(this.mEmoController));
        } else {
            iPatchRedirector.redirect((short) 5, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, Integer.valueOf(i17), iPanelInteractionListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void initEmoticonView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            this.mEmoController.initEmoticonView(str);
        } else {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener, boolean z16, EmoticonListProvider emoticonListProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            init(baseQQAppInterface, i3, context, i16, str, -1, iPanelInteractionListener, z16, emoticonListProvider);
        } else {
            iPatchRedirector.redirect((short) 6, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, iPanelInteractionListener, Boolean.valueOf(z16), emoticonListProvider);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17, IPanelInteractionListener iPanelInteractionListener, boolean z16, EmoticonListProvider emoticonListProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, Integer.valueOf(i17), iPanelInteractionListener, Boolean.valueOf(z16), emoticonListProvider);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "init");
        }
        new EmoticonPanelBuilder(new BasePanelView(this), new QQEmoticonMainPanelApp(baseQQAppInterface), i3).setEmoticonListProvider(emoticonListProvider).setKanDianBiu(z16).setDefaultEpId(str).setDefaultPanelType(i17).setToastOffset(i16).setPanelInteractionListener(iPanelInteractionListener).setDisableMoreEmotionButton(this.disableMoreEmotionButton).setHasBigEmotion(this.hasBigEmotion).setOnlySysAndEmoji(this.onlySysAndEmoji).setDisableGuide(this.disableGuide).setDisableGuideOneTime(this.disableGuideOneTime).setDisableAutoDownload(this.disableAutoDownload).setFilterSysFaceBeyond255Enable(isFilterSysFaceBeyond255Enable()).show();
        Argus.INSTANCE.getNode(this, this, true);
    }

    /* loaded from: classes12.dex */
    public static class EmoticonPanelBuilder {
        static IPatchRedirector $redirector_;
        private final EmoticonPanelParams mPanelParams;

        public EmoticonPanelBuilder(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Context context, com.tencent.aio.api.runtime.a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQEmoticonMainPanelApp, context, aVar, Integer.valueOf(i3));
                return;
            }
            EmoticonPanelParams emoticonPanelParams = new EmoticonPanelParams();
            this.mPanelParams = emoticonPanelParams;
            emoticonPanelParams.app = qQEmoticonMainPanelApp;
            emoticonPanelParams.context = context;
            emoticonPanelParams.ntAioContext = aVar;
            emoticonPanelParams.sessionType = i3;
        }

        public EmoticonPanelBuilder addEmotionInjectionInfo(String str, EmotionInjectionInfo emotionInjectionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) emotionInjectionInfo);
            }
            EmoticonPanelParams emoticonPanelParams = this.mPanelParams;
            if (emoticonPanelParams.emoInjectionInfoManager == null) {
                emoticonPanelParams.emoInjectionInfoManager = new com.tencent.mobileqq.i();
            }
            this.mPanelParams.emoInjectionInfoManager.a(str, emotionInjectionInfo);
            com.tencent.mobileqq.config.business.n.a(emotionInjectionInfo.emotionType, str);
            return this;
        }

        public void addTabLRPadding() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                iPatchRedirector.redirect((short) 37, (Object) this);
            } else {
                this.mPanelParams.isAddLRPadding = true;
            }
        }

        public IEmoticonMainPanel create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 29, (Object) this);
            }
            return this.mPanelParams.create();
        }

        public IEmoticonMainPanelApp getEmoticonMainPanelApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IEmoticonMainPanelApp) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mPanelParams.app;
        }

        public void keepLottieMerged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, (Object) this, z16);
            } else {
                this.mPanelParams.keepLottieMerged = z16;
            }
        }

        public EmoticonPanelBuilder setAIOContext(a61.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) bVar);
            }
            this.mPanelParams.aioContext = bVar;
            return this;
        }

        public EmoticonPanelBuilder setAdjustColumn(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            this.mPanelParams.adjustColumn = z16;
            return this;
        }

        public EmoticonPanelBuilder setCallBack(EmoticonCallback emoticonCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) emoticonCallback);
            }
            this.mPanelParams.callback = emoticonCallback;
            return this;
        }

        public EmoticonPanelBuilder setContainerStyleSheet(IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet panelContainerStyleSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) panelContainerStyleSheet);
            }
            this.mPanelParams.containerStyleSheet = panelContainerStyleSheet;
            return this;
        }

        public void setCustomEmotionData(int i3, List<EmotionPanelData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                iPatchRedirector.redirect((short) 34, (Object) this, i3, (Object) list);
            } else {
                this.mPanelParams.mCustomEmotionDataMap.put(Integer.valueOf(i3), list);
            }
        }

        public EmoticonPanelBuilder setDefaultEpId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.mPanelParams.defaultEpId = str;
            return this;
        }

        public EmoticonPanelBuilder setDefaultPanelType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.mPanelParams.defaultPanelType = i3;
            return this;
        }

        public EmoticonPanelBuilder setDisableAutoDownload(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 20, (Object) this, z16);
            }
            this.mPanelParams.disableAutoDownload = z16;
            return this;
        }

        public EmoticonPanelBuilder setDisableGuide(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.mPanelParams.disableGuide = z16;
            return this;
        }

        public EmoticonPanelBuilder setDisableGuideOneTime(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.mPanelParams.disableGuideOneTime = z16;
            return this;
        }

        public EmoticonPanelBuilder setDisableMoreEmotionButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.mPanelParams.disableMoreEmotionButton = z16;
            return this;
        }

        public EmoticonPanelBuilder setEmoticonListProvider(EmoticonListProvider emoticonListProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonListProvider);
            }
            this.mPanelParams.emoticonListProvider = emoticonListProvider;
            return this;
        }

        public void setFilterEmotionData(int i3, List<EmotionPanelData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                iPatchRedirector.redirect((short) 35, (Object) this, i3, (Object) list);
            } else {
                this.mPanelParams.mFilterEmotionDataMap.put(Integer.valueOf(i3), list);
            }
        }

        public EmoticonPanelBuilder setFilterSysFaceBeyond255Enable(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 22, (Object) this, z16);
            }
            this.mPanelParams.isFilterSysFaceBeyond255 = z16;
            return this;
        }

        public void setGuildChatPieScene(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                iPatchRedirector.redirect((short) 30, (Object) this, i3);
            } else {
                this.mPanelParams.guildChatPieScene = i3;
            }
        }

        public void setGuildTextSafeSwitch(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, z16);
            } else {
                this.mPanelParams.isTextGifOpen = z16;
            }
        }

        public EmoticonPanelBuilder setHasBigEmotion(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.mPanelParams.hasBigEmotion = z16;
            return this;
        }

        public EmoticonPanelBuilder setHideAllSettingTabs(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 24, (Object) this, z16);
            }
            this.mPanelParams.hideAllSettingTabs = z16;
            return this;
        }

        public EmoticonPanelBuilder setHideEmoSettingBtn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            this.mPanelParams.hideSettingBtn = true;
            return this;
        }

        public EmoticonPanelBuilder setIsOnlySysEmotion(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.mPanelParams.mIsOnlySysEmotion = z16;
            return this;
        }

        public EmoticonPanelBuilder setKanDianBiu(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.mPanelParams.kanDianBiu = z16;
            return this;
        }

        public EmoticonPanelBuilder setOnlySysAndEmoji(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.mPanelParams.onlySysAndEmoji = z16;
            return this;
        }

        public EmoticonPanelBuilder setPanelBusinessParam(Map<Integer, BaseEmotionPanelBusinessParam> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) map);
            }
            this.mPanelParams.businessParamMap.clear();
            if (map != null) {
                this.mPanelParams.businessParamMap.putAll(map);
            }
            return this;
        }

        public EmoticonPanelBuilder setPanelInteractionListener(IPanelInteractionListener iPanelInteractionListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 26, (Object) this, (Object) iPanelInteractionListener);
            }
            this.mPanelParams.interactionListener = iPanelInteractionListener;
            return this;
        }

        public EmoticonPanelBuilder setShowEmotionPanelDeleteButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            this.mPanelParams.showEmotionPanelDeleteButton = z16;
            return this;
        }

        public void setStyleChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, z16);
            } else {
                this.mPanelParams.styleChange = z16;
            }
        }

        public EmoticonPanelBuilder setSysEmotionOrder(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 25, (Object) this, (Object) iArr);
            }
            this.mPanelParams.sysEmotionOrder = iArr;
            return this;
        }

        public EmoticonPanelBuilder setToastOffset(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.mPanelParams.toastOffset = i3;
            return this;
        }

        public void setTopTab() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                iPatchRedirector.redirect((short) 36, (Object) this);
            } else {
                this.mPanelParams.isTopTab = true;
            }
        }

        void show() {
            this.mPanelParams.show();
        }

        public EmoticonPanelBuilder showDescribeInPreview(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (EmoticonPanelBuilder) iPatchRedirector.redirect((short) 27, (Object) this, z16);
            }
            this.mPanelParams.showDescInPreview = z16;
            return this;
        }

        EmoticonPanelBuilder(IBasePanelView iBasePanelView, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, iBasePanelView, qQEmoticonMainPanelApp, Integer.valueOf(i3));
                return;
            }
            EmoticonPanelParams emoticonPanelParams = new EmoticonPanelParams(iBasePanelView.getController());
            this.mPanelParams = emoticonPanelParams;
            emoticonPanelParams.app = qQEmoticonMainPanelApp;
            emoticonPanelParams.context = iBasePanelView.getContext();
            emoticonPanelParams.sessionType = i3;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    @Deprecated
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, IPanelInteractionListener iPanelInteractionListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            init(baseQQAppInterface, i3, context, i16, str, -1, iPanelInteractionListener, z16, new DefaultEmoticonListProvider(this.mEmoController));
        } else {
            iPatchRedirector.redirect((short) 8, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, iPanelInteractionListener, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void init(BaseQQAppInterface baseQQAppInterface, int i3, Context context, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 60)) {
            init(baseQQAppInterface, i3, context, i16, str, i17, this.mEmoController.getInteractionListener());
        } else {
            iPatchRedirector.redirect((short) 60, this, baseQQAppInterface, Integer.valueOf(i3), context, Integer.valueOf(i16), str, Integer.valueOf(i17));
        }
    }
}
