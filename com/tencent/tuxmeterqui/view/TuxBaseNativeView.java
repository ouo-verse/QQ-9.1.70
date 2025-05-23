package com.tencent.tuxmeterqui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Option;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TuxBaseNativeView extends FrameLayout {
    static IPatchRedirector $redirector_;
    protected Option firstQuestionOption;
    protected boolean hasPreSubmit;
    protected TuxNativeSurveySetting nativeSurveySetting;
    protected TuxSurveyConfig surveyConfig;
    protected final ITuxSurveyEventCallback surveyEventCallback;
    protected TuxEventListener tuxEventListener;

    public TuxBaseNativeView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public TuxSurveyConfig getTuxSurveyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TuxSurveyConfig) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.surveyConfig;
    }

    abstract void initView(Context context);

    public void reportSurveyDisappearEvent(DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) disappearReason);
        }
    }

    public void reportSurveyExposureEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void setSurveyData(TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, null);
        } else {
            iPatchRedirector.redirect((short) 4, this, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener);
        }
    }

    protected abstract void updateUIWithData();

    public TuxBaseNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setSurveyData(TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener, Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, option);
            return;
        }
        this.surveyConfig = tuxSurveyConfig;
        this.nativeSurveySetting = tuxNativeSurveySetting;
        this.tuxEventListener = tuxEventListener;
        this.firstQuestionOption = option;
        if (tuxEventListener != null) {
            tuxEventListener.onSurveyDisplayed(tuxSurveyConfig);
        }
        updateUIWithData();
    }

    public TuxBaseNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        this.hasPreSubmit = false;
        initView(context);
    }
}
