package com.tencent.tuxmeterqui;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView;
import com.tencent.tuxmeterqui.common.TuxCommonPopupDialog;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.tuxmeterqui.config.Utils;
import com.tencent.tuxmeterqui.view.TuxBaseNativeView;
import com.tencent.tuxmeterqui.view.TuxNativeStarView;
import com.tencent.tuxmeterqui.view.TuxNativeSurveyView;
import com.tencent.tuxmeterqui.view.TuxSurveyWebView;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.TriggerErrorCode;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxMeterUI {
    static IPatchRedirector $redirector_;
    private TuxCommonPopupDialog commonPopupDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TuxMeterSDKHolder {
        static IPatchRedirector $redirector_;
        private static final TuxMeterUI SINGLETON;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10027);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                SINGLETON = new TuxMeterUI(null);
            }
        }

        TuxMeterSDKHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ TuxMeterUI(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) anonymousClass1);
    }

    public static TuxMeterUI getInstance() {
        return TuxMeterSDKHolder.SINGLETON;
    }

    public TuxBaseNativeView getTuxNativeSurveyView(Context context, TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getTuxNativeSurveyView(context, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, null) : (TuxBaseNativeView) iPatchRedirector.redirect((short) 3, this, context, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
    }

    public boolean isTuxSurveyTipsStyle(TuxSurveyConfig tuxSurveyConfig) {
        Resource resource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tuxSurveyConfig)).booleanValue();
        }
        if (!Utils.isValidNativeSurveyConfig(tuxSurveyConfig) || (resource = tuxSurveyConfig.getResource()) == null) {
            return false;
        }
        return TuxUIConstants.isTriggerStyleTips(resource.getComponentType());
    }

    public boolean isTuxUIDialog(TuxSurveyConfig tuxSurveyConfig) {
        Resource resource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tuxSurveyConfig)).booleanValue();
        }
        if (!Utils.isValidNativeSurveyConfig(tuxSurveyConfig) || (resource = tuxSurveyConfig.getResource()) == null) {
            return false;
        }
        return TuxUIConstants.isDialogTrigger(resource.getComponentType());
    }

    public boolean isTuxUIEmbeddedFloat(TuxSurveyConfig tuxSurveyConfig) {
        Resource resource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tuxSurveyConfig)).booleanValue();
        }
        if (!Utils.isValidNativeSurveyConfig(tuxSurveyConfig) || (resource = tuxSurveyConfig.getResource()) == null) {
            return false;
        }
        return TuxUIConstants.isEmbeddedTrigger(resource.getComponentType());
    }

    public boolean isTuxUINative(TuxSurveyConfig tuxSurveyConfig) {
        Resource resource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tuxSurveyConfig)).booleanValue();
        }
        if (!Utils.isValidNativeSurveyConfig(tuxSurveyConfig) || (resource = tuxSurveyConfig.getResource()) == null) {
            return false;
        }
        return TuxUIConstants.isNativeTrigger(resource.getComponentType());
    }

    public void reportHalfFloatingLayerExposeEvent(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onHalfFloatingLayerShow(tuxSurveyConfig);
        }
    }

    public void reportOnHalfFloatingLayerDisappear(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) tuxSurveyConfig, (Object) disappearReason);
            return;
        }
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onHalfFloatingLayerDisappear(tuxSurveyConfig, disappearReason);
        }
    }

    public void reportSurveyDisappearEvent(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tuxSurveyConfig, (Object) disappearReason);
            return;
        }
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onDisappear(tuxSurveyConfig, disappearReason);
        }
    }

    public void reportSurveyExposureEvent(TuxSurveyConfig tuxSurveyConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tuxSurveyConfig);
            return;
        }
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onShow(tuxSurveyConfig);
            surveyEventCallback.onReceiveTriggerErrorCode(tuxSurveyConfig, TriggerErrorCode.SUCCESS);
        }
    }

    public void reportSurveyFailedEvent(TuxSurveyConfig tuxSurveyConfig, TriggerErrorCode triggerErrorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) tuxSurveyConfig, (Object) triggerErrorCode);
            return;
        }
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onReceiveTriggerErrorCode(tuxSurveyConfig, triggerErrorCode);
        }
    }

    public void showTuxSurveyDialog(Context context, TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
            return;
        }
        try {
            if (isTuxUIEmbeddedFloat(tuxSurveyConfig)) {
                return;
            }
            TuxCommonPopupDialog tuxCommonPopupDialog = new TuxCommonPopupDialog(context, getInstance().getTuxNativeSurveyView(context, tuxSurveyConfig, tuxNativeSurveySetting, new TuxEventListener(tuxEventListener) { // from class: com.tencent.tuxmeterqui.TuxMeterUI.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ TuxEventListener val$tuxEventListener;

                {
                    this.val$tuxEventListener = tuxEventListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxMeterUI.this, (Object) tuxEventListener);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onStarQuestionClick(Question question, Option option, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, question, option, str);
                        return;
                    }
                    TuxEventListener tuxEventListener2 = this.val$tuxEventListener;
                    if (tuxEventListener2 != null) {
                        tuxEventListener2.onStarQuestionClick(question, option, str);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveyClose(TuxSurveyConfig tuxSurveyConfig2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) tuxSurveyConfig2);
                        return;
                    }
                    if (TuxMeterUI.this.commonPopupDialog != null) {
                        TuxMeterUI.this.commonPopupDialog.dismiss();
                    }
                    TuxEventListener tuxEventListener2 = this.val$tuxEventListener;
                    if (tuxEventListener2 != null) {
                        tuxEventListener2.onSurveyClose(tuxSurveyConfig2);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveyDisplayed(TuxSurveyConfig tuxSurveyConfig2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) tuxSurveyConfig2);
                        return;
                    }
                    TuxEventListener tuxEventListener2 = this.val$tuxEventListener;
                    if (tuxEventListener2 != null) {
                        tuxEventListener2.onSurveyDisplayed(tuxSurveyConfig2);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveySubmit(TuxSurveyConfig tuxSurveyConfig2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) tuxSurveyConfig2);
                        return;
                    }
                    if (TuxMeterUI.this.commonPopupDialog != null) {
                        TuxMeterUI.this.commonPopupDialog.dismiss();
                    }
                    TuxEventListener tuxEventListener2 = this.val$tuxEventListener;
                    if (tuxEventListener2 != null) {
                        tuxEventListener2.onSurveySubmit(tuxSurveyConfig2);
                    }
                }
            }), new QUIBaseHalfScreenFloatingView.l() { // from class: com.tencent.tuxmeterqui.TuxMeterUI.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxMeterUI.this);
                    }
                }

                @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView.l
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
            this.commonPopupDialog = tuxCommonPopupDialog;
            tuxCommonPopupDialog.show();
        } catch (Exception unused) {
        }
    }

    TuxMeterUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public TuxBaseNativeView getTuxNativeSurveyView(Context context, TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener, Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TuxBaseNativeView) iPatchRedirector.redirect((short) 4, this, context, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, option);
        }
        try {
            if (!Utils.checkAndFormatSurveyConfig(tuxSurveyConfig)) {
                return null;
            }
            if (option != null) {
                TuxNativeSurveyView tuxNativeSurveyView = new TuxNativeSurveyView(context);
                tuxNativeSurveyView.setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, option);
                return tuxNativeSurveyView;
            }
            if (isTuxSurveyTipsStyle(tuxSurveyConfig)) {
                TuxSurveyWebView tuxSurveyWebView = new TuxSurveyWebView(context);
                tuxSurveyWebView.setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
                return tuxSurveyWebView;
            }
            if (isTuxUIEmbeddedFloat(tuxSurveyConfig)) {
                TuxNativeStarView tuxNativeStarView = new TuxNativeStarView(context);
                tuxNativeStarView.setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
                return tuxNativeStarView;
            }
            TuxNativeSurveyView tuxNativeSurveyView2 = new TuxNativeSurveyView(context);
            tuxNativeSurveyView2.setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
            return tuxNativeSurveyView2;
        } catch (Exception unused) {
            reportSurveyFailedEvent(tuxSurveyConfig, TriggerErrorCode.SCENE_ID_NOT_MATCH);
            return null;
        }
    }
}
