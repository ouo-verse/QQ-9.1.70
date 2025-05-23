package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.slf4j.Marker;

/* loaded from: classes12.dex */
public class EmoticonPanelSettingHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> implements View.OnClickListener, PopupWindow.OnDismissListener {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelSettingHelper";
    private Runnable hiddenGuide;
    private int mBtnStatus;
    private EmoticonStoreTabGuideView mGuideView;
    private boolean mHideMoreButton;
    private ImageView mMoreEmoticonButton;
    private Handler uiHandler;

    public EmoticonPanelSettingHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonPanelController);
        } else {
            this.hiddenGuide = new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelSettingHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelSettingHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (EmoticonPanelSettingHelper.this.mGuideView != null && EmoticonPanelSettingHelper.this.mGuideView.isShowing()) {
                        EmoticonPanelSettingHelper.this.mGuideView.dismiss();
                    }
                }
            };
        }
    }

    private int getMoreBtnStatusByEmotionInfo(EmotionPanelInfo emotionPanelInfo) {
        if (emotionPanelInfo == null) {
            QLog.e(LOG_TAG, 1, "getMoreBtnStatusByEmotionInfo info = null");
            return -1;
        }
        int i3 = emotionPanelInfo.type;
        if (i3 != 7 && i3 != 10) {
            return 1;
        }
        return 2;
    }

    private static void updateIndividuationRedPoint(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        GameCenterManagerImpProxy gameCenterManagerImpProxy = (GameCenterManagerImpProxy) qQEmoticonMainPanelApp.getManager(((IEmosmService) QRoute.api(IEmosmService.class)).getManagerID(IEmosmService.GAMECENTER_MANAGER));
        if (gameCenterManagerImpProxy != null) {
            boolean z36 = true;
            if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100001") != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100003") != -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100002") != -1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100006") != -1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100018") != -1) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100020") != -1) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (gameCenterManagerImpProxy.checkNewFlagByPath("100005.100021") != -1) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                boolean isSupportFont = ((FontManagerProxy) qQEmoticonMainPanelApp.getRuntimeService(IFontManagerService.class)).isSupportFont();
                if (isSupportFont && gameCenterManagerImpProxy.checkNewFlagByPath("100005.100011") != -1) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if ((isSupportFont && !z17 && !z18 && !z19 && !z29 && !z26 && !z27 && !z28) || (!isSupportFont && !z17 && !z18 && !z19 && !z26 && !z27 && !z28)) {
                    if (gameCenterManagerImpProxy.checkNewFlagByPath("100005") == -1) {
                        z36 = false;
                    }
                    if (z36) {
                        ((RedTouchManagerProxy) qQEmoticonMainPanelApp.getRuntimeService(IRedTouchManager.class)).onRedTouchItemClick("100005");
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return LOG_TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ImageView imageView = (ImageView) ((EmoticonPanelController) this.mPanelController).getPanel().findViewById(R.id.btn_more_emoticon);
        this.mMoreEmoticonButton = imageView;
        imageView.setOnClickListener(this);
        if (!((EmoticonPanelController) this.mPanelController).getParams().disableMoreEmotionButton && !this.mHideMoreButton && !((EmoticonPanelController) this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
            this.mMoreEmoticonButton.setVisibility(0);
        } else {
            this.mMoreEmoticonButton.setVisibility(8);
        }
    }

    public void initGuideView(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            return;
        }
        if (view != null && this.mGuideView == null) {
            EmoticonStoreTabGuideView emoticonStoreTabGuideView = new EmoticonStoreTabGuideView(view.getContext());
            this.mGuideView = emoticonStoreTabGuideView;
            emoticonStoreTabGuideView.initUI(z16);
            this.mGuideView.setOnDismissListener(this);
            this.uiHandler = view.getHandler();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new int[]{1};
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else {
            T t16 = this.mPanelController;
            QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
            Context context = ((EmoticonPanelController) t16).context;
            boolean z17 = ((EmoticonPanelController) t16).getBasePanelView().hasBigEmotion;
            EmoticonCallback emoticonCallback = ((EmoticonPanelController) this.mPanelController).callback;
            if (view.getId() == R.id.btn_more_emoticon) {
                if (this.mBtnStatus == 2 && !z17) {
                    if (emoticonCallback != null) {
                        emoticonCallback.delete();
                    }
                } else {
                    ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(Marker.ANY_NON_NULL_MARKER, "4", SearchConstants.PLATFORM, "6", "1", 102, 1, System.currentTimeMillis());
                    ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
                    if (((EmoticonPanelController) this.mPanelController).getNewFlag().getVisibility() == 0) {
                        ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
                        ((EmoticonPanelController) this.mPanelController).getNewFlag().setVisibility(8);
                        ((RedTouchManagerProxy) qQEmoticonMainPanelApp.getRuntimeService(IRedTouchManager.class)).onRedTouchItemClick("100610.100611");
                        if (context != null) {
                            context.getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
                        }
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    updateIndividuationRedPoint(qQEmoticonMainPanelApp);
                    ((EmoticonPanelController) this.mPanelController).getBasePanelModel().webPreloadHitSessionHit();
                    ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiHomePage(((EmoticonPanelController) this.mPanelController).context, qQEmoticonMainPanelApp, qQEmoticonMainPanelApp.getAccount(), 1, z16, "", true);
                    ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
                    if (context != null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + qQEmoticonMainPanelApp.getCurrentAccountUin(), 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, System.currentTimeMillis()).apply();
                        }
                    }
                    VasWebviewUtil.reportVasStatus(VasWebviewConstants.REPORT_KEY_PERSONAL_WEB_PRELOAD_HIT_RIT, VasWebviewConstants.REPORT_NAME_EMOTICON_PANEL_PLUS_ENTRANCE, "0", 0, 0, ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist() ? 1 : 0, 0, "", "");
                    ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
                    int fromType = ((EmoticonPanelController) this.mPanelController).getFromType(false);
                    if (fromType != 0) {
                        ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0X800AE0E", "0X800AE0E", fromType, 0, "", "", "", "");
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.hiddenGuide);
            this.uiHandler = null;
        }
        super.onDestory();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.hiddenGuide);
        }
        EmoticonStoreTabEntryUtils.doOnStoryGuideShowed();
    }

    public boolean performClick(int i3) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (i3 == 13 && (imageView = this.mMoreEmoticonButton) != null) {
            imageView.performClick();
            return true;
        }
        return false;
    }

    public void prepareShowGuideView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mMoreEmoticonButton = null;
            this.uiHandler = null;
        }
    }

    public void setHideMoreAndSettingButton(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.mHideMoreButton = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMoreSettingVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        ImageView imageView = this.mMoreEmoticonButton;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public void setmGuideView(EmoticonStoreTabGuideView emoticonStoreTabGuideView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonStoreTabGuideView);
        } else {
            this.mGuideView = emoticonStoreTabGuideView;
        }
    }

    public void showGuideView(View view, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (view == null) {
            return;
        }
        if (this.mGuideView == null) {
            initGuideView(view, z16);
        }
        EmoticonStoreTabGuideView emoticonStoreTabGuideView = this.mGuideView;
        if (emoticonStoreTabGuideView != null) {
            ImageView imageView = this.mMoreEmoticonButton;
            if (imageView != null) {
                if (z16) {
                    emoticonStoreTabGuideView.showAsDropDown(imageView, i3, i16, 83);
                } else {
                    emoticonStoreTabGuideView.showAsDropDown(imageView, i3, -i16, 51);
                }
            } else {
                emoticonStoreTabGuideView.showAtLocation(view, 83, i3, i16);
            }
        }
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacks(this.hiddenGuide);
            this.uiHandler.postDelayed(this.hiddenGuide, 5000L);
        }
    }

    public void switchMoreSettingStyle(EmotionPanelInfo emotionPanelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) emotionPanelInfo);
            return;
        }
        if (emotionPanelInfo == null) {
            return;
        }
        boolean z16 = ((EmoticonPanelController) this.mPanelController).getBasePanelView().hasBigEmotion;
        EmoticonPanelParams params = ((EmoticonPanelController) this.mPanelController).getParams();
        int moreBtnStatusByEmotionInfo = getMoreBtnStatusByEmotionInfo(emotionPanelInfo);
        if (this.mBtnStatus != moreBtnStatusByEmotionInfo) {
            this.mBtnStatus = moreBtnStatusByEmotionInfo;
            if (z16 && !params.disableMoreEmotionButton) {
                if (this.mHideMoreButton) {
                    this.mMoreEmoticonButton.setVisibility(8);
                } else {
                    this.mMoreEmoticonButton.setVisibility(0);
                    this.mMoreEmoticonButton.setImageResource(R.drawable.f162107ao0);
                }
            } else if (!((EmoticonPanelExtendHelper) ((EmoticonPanelController) this.mPanelController).getHelper(1)).isShowExtendPanel() && this.mBtnStatus == 2 && !params.disableMoreEmotionButton) {
                this.mMoreEmoticonButton.setVisibility(0);
                this.mMoreEmoticonButton.setImageResource(R.drawable.fnx);
                this.mMoreEmoticonButton.setPadding((int) (((EmoticonPanelController) this.mPanelController).getBasePanelView().density * 10.0f), 0, 0, 0);
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "onPageSelected, show del pic");
                }
            } else {
                this.mMoreEmoticonButton.setVisibility(8);
            }
            if (((EmoticonPanelController) this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
                this.mMoreEmoticonButton.setVisibility(8);
            }
        }
    }

    public void switchSettingBtnStyle(EmotionPanelInfo emotionPanelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emotionPanelInfo);
            return;
        }
        if (emotionPanelInfo == null) {
            return;
        }
        boolean z16 = ((EmoticonPanelController) this.mPanelController).getBasePanelView().hasBigEmotion;
        EmoticonPanelParams params = ((EmoticonPanelController) this.mPanelController).getParams();
        int moreBtnStatusByEmotionInfo = getMoreBtnStatusByEmotionInfo(emotionPanelInfo);
        if (this.mBtnStatus != moreBtnStatusByEmotionInfo) {
            this.mBtnStatus = moreBtnStatusByEmotionInfo;
            if (z16 && !params.disableMoreEmotionButton) {
                if (this.mHideMoreButton) {
                    this.mMoreEmoticonButton.setVisibility(8);
                } else {
                    this.mMoreEmoticonButton.setVisibility(0);
                    this.mMoreEmoticonButton.setImageResource(R.drawable.f162107ao0);
                    this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            } else if (!((EmoticonPanelExtendHelper) ((EmoticonPanelController) this.mPanelController).getHelper(1)).isShowExtendPanel() && this.mBtnStatus == 2 && !params.disableMoreEmotionButton) {
                this.mMoreEmoticonButton.setVisibility(0);
                this.mMoreEmoticonButton.setImageResource(R.drawable.fnx);
                this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER);
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "onPageSelected, show del pic");
                }
            } else {
                this.mMoreEmoticonButton.setVisibility(8);
            }
            if (((EmoticonPanelController) this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
                this.mMoreEmoticonButton.setVisibility(8);
            }
        }
    }
}
