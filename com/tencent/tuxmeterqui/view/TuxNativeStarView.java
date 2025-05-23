package com.tencent.tuxmeterqui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView;
import com.tencent.tuxmeterqui.TuxMeterUI;
import com.tencent.tuxmeterqui.common.TuxCommonPopupDialog;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.config.TuxRect;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.config.Utils;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmeterqui.question.TuxQuestionViewFactory;
import com.tencent.tuxmeterqui.question.star.TuxStarCommonView;
import com.tencent.tuxmeterqui.question.star.TuxStarStarView;
import com.tencent.tuxmeterqui.question.star.TuxStarTextViewView;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.TuxSurveyType;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Survey;
import ie0.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxNativeStarView extends TuxBaseNativeView {
    static IPatchRedirector $redirector_;
    private TuxCommonPopupDialog commonPopupDialog;
    private DisappearReason disappearReason;
    private View rootView;
    private LinearLayout tuxQuestionContainer;

    public TuxNativeStarView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShowDialogOrSubmit(Option option) {
        if (isOptionNeedSubmit(option)) {
            submitAnswer();
            TuxEventListener tuxEventListener = this.tuxEventListener;
            if (tuxEventListener != null) {
                tuxEventListener.onSurveySubmit(this.surveyConfig);
                return;
            }
            return;
        }
        showHalfDialog(option);
    }

    private void createStarQuestion(Question question) {
        TuxQuestionConfig tuxQuestionConfig;
        ITuxQuestionView createQuestionView = TuxQuestionViewFactory.createQuestionView(getContext(), question);
        if (createQuestionView != null) {
            createQuestionView.setViewVisibility(true);
            TuxNativeSurveySetting tuxNativeSurveySetting = this.nativeSurveySetting;
            if (tuxNativeSurveySetting != null) {
                tuxQuestionConfig = tuxNativeSurveySetting.getQuestionConfigMap().get(question.getSubType());
            } else {
                tuxQuestionConfig = null;
            }
            createQuestionView.updateView(question, this.surveyConfig.getResource(), tuxQuestionConfig);
            if (createQuestionView instanceof TuxStarStarView) {
                TuxStarStarView tuxStarStarView = (TuxStarStarView) createQuestionView;
                tuxStarStarView.setClickListener(new TuxStarCommonView.TuxOnStarItemClickListener(question) { // from class: com.tencent.tuxmeterqui.view.TuxNativeStarView.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Question val$question;

                    {
                        this.val$question = question;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeStarView.this, (Object) question);
                        }
                    }

                    @Override // com.tencent.tuxmeterqui.question.star.TuxStarCommonView.TuxOnStarItemClickListener
                    public void onItemClick(Option option, String str) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) option, (Object) str);
                            return;
                        }
                        if (Utils.canReportSurveyEvent(TuxNativeStarView.this.surveyEventCallback)) {
                            TuxNativeStarView tuxNativeStarView = TuxNativeStarView.this;
                            tuxNativeStarView.surveyEventCallback.onClick(tuxNativeStarView.surveyConfig);
                            TuxNativeStarView tuxNativeStarView2 = TuxNativeStarView.this;
                            if (!tuxNativeStarView2.hasPreSubmit) {
                                TuxMeterSDK.getInstance().submitAnswer(TuxNativeStarView.this.surveyConfig, TuxUIUtils.generateAnswer(tuxNativeStarView2.tuxQuestionContainer, TuxNativeStarView.this.surveyConfig), TuxSurveyType.SELF_RENDING_WITH_TUXH5);
                                TuxNativeStarView.this.hasPreSubmit = true;
                            }
                        }
                        TuxEventListener tuxEventListener = TuxNativeStarView.this.tuxEventListener;
                        if (tuxEventListener != null) {
                            tuxEventListener.onStarQuestionClick(this.val$question, option, str);
                        }
                        TuxNativeStarView.this.checkShowDialogOrSubmit(option);
                    }
                });
                this.tuxQuestionContainer.addView(tuxStarStarView);
            } else if (createQuestionView instanceof TuxStarTextViewView) {
                TuxStarTextViewView tuxStarTextViewView = (TuxStarTextViewView) createQuestionView;
                tuxStarTextViewView.setClickListener(new TuxStarCommonView.TuxOnStarItemClickListener(question) { // from class: com.tencent.tuxmeterqui.view.TuxNativeStarView.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Question val$question;

                    {
                        this.val$question = question;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeStarView.this, (Object) question);
                        }
                    }

                    @Override // com.tencent.tuxmeterqui.question.star.TuxStarCommonView.TuxOnStarItemClickListener
                    public void onItemClick(Option option, String str) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) option, (Object) str);
                            return;
                        }
                        if (Utils.canReportSurveyEvent(TuxNativeStarView.this.surveyEventCallback)) {
                            TuxNativeStarView tuxNativeStarView = TuxNativeStarView.this;
                            tuxNativeStarView.surveyEventCallback.onClick(tuxNativeStarView.surveyConfig);
                            TuxNativeStarView tuxNativeStarView2 = TuxNativeStarView.this;
                            if (!tuxNativeStarView2.hasPreSubmit) {
                                TuxMeterSDK.getInstance().submitAnswer(TuxNativeStarView.this.surveyConfig, TuxUIUtils.generateAnswer(tuxNativeStarView2.tuxQuestionContainer, TuxNativeStarView.this.surveyConfig), TuxSurveyType.SELF_RENDING_WITH_TUXH5);
                            }
                        }
                        TuxEventListener tuxEventListener = TuxNativeStarView.this.tuxEventListener;
                        if (tuxEventListener != null) {
                            tuxEventListener.onStarQuestionClick(this.val$question, option, str);
                        }
                        TuxNativeStarView.this.checkShowDialogOrSubmit(option);
                    }
                });
                this.tuxQuestionContainer.addView(tuxStarTextViewView);
            }
        }
    }

    private boolean isOptionNeedSubmit(Option option) {
        if (option == null) {
            return false;
        }
        for (String str : option.getDisplays()) {
            if ("-1".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void showHalfDialog(Option option) {
        try {
            TuxCommonPopupDialog tuxCommonPopupDialog = new TuxCommonPopupDialog(getContext(), TuxMeterUI.getInstance().getTuxNativeSurveyView(getContext(), this.surveyConfig, new TuxNativeSurveySetting.Builder().build(), new TuxEventListener() { // from class: com.tencent.tuxmeterqui.view.TuxNativeStarView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeStarView.this);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onStarQuestionClick(Question question, Option option2, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, question, option2, str);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveyClose(TuxSurveyConfig tuxSurveyConfig) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) tuxSurveyConfig);
                    } else if (TuxNativeStarView.this.commonPopupDialog != null) {
                        TuxNativeStarView.this.commonPopupDialog.dismiss();
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveyDisplayed(TuxSurveyConfig tuxSurveyConfig) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) tuxSurveyConfig);
                    }
                }

                @Override // com.tencent.tuxmeterqui.config.TuxEventListener
                public void onSurveySubmit(TuxSurveyConfig tuxSurveyConfig) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) tuxSurveyConfig);
                        return;
                    }
                    TuxNativeStarView.this.disappearReason = DisappearReason.SUBMIT;
                    if (TuxNativeStarView.this.commonPopupDialog != null) {
                        TuxNativeStarView.this.commonPopupDialog.dismiss();
                    }
                    TuxEventListener tuxEventListener = TuxNativeStarView.this.tuxEventListener;
                    if (tuxEventListener != null) {
                        tuxEventListener.onSurveySubmit(tuxSurveyConfig);
                    }
                }
            }, option), new QUIBaseHalfScreenFloatingView.l() { // from class: com.tencent.tuxmeterqui.view.TuxNativeStarView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeStarView.this);
                    }
                }

                @Override // com.tencent.qui.quibottomfloatingview.QUIBaseHalfScreenFloatingView.l
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    TuxMeterUI tuxMeterUI = TuxMeterUI.getInstance();
                    TuxNativeStarView tuxNativeStarView = TuxNativeStarView.this;
                    tuxMeterUI.reportOnHalfFloatingLayerDisappear(tuxNativeStarView.surveyConfig, tuxNativeStarView.disappearReason);
                    TuxNativeStarView tuxNativeStarView2 = TuxNativeStarView.this;
                    TuxEventListener tuxEventListener = tuxNativeStarView2.tuxEventListener;
                    if (tuxEventListener != null) {
                        tuxEventListener.onSurveyClose(tuxNativeStarView2.surveyConfig);
                    }
                }
            });
            this.commonPopupDialog = tuxCommonPopupDialog;
            tuxCommonPopupDialog.show();
        } catch (Exception unused) {
            TuxEventListener tuxEventListener = this.tuxEventListener;
            if (tuxEventListener != null) {
                tuxEventListener.onSurveySubmit(this.surveyConfig);
            }
        }
    }

    private void submitAnswer() {
        TuxMeterSDK.getInstance().submitAnswer(this.surveyConfig, TuxUIUtils.generateAnswer(this.tuxQuestionContainer, this.surveyConfig), TuxSurveyType.ALL_SELF_RENDERING);
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1v, (ViewGroup) this, true);
        this.rootView = inflate;
        this.tuxQuestionContainer = (LinearLayout) inflate.findViewById(R.id.f10470641);
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    public void reportSurveyDisappearEvent(DisappearReason disappearReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) disappearReason);
        } else {
            super.reportSurveyDisappearEvent(disappearReason);
            TuxMeterUI.getInstance().reportSurveyDisappearEvent(this.surveyConfig, disappearReason);
        }
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    public void reportSurveyExposureEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.reportSurveyExposureEvent();
            TuxMeterUI.getInstance().reportSurveyExposureEvent(this.surveyConfig);
        }
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    protected void updateUIWithData() {
        Survey survey;
        List<Page> pages;
        Page page;
        List<Question> questions;
        TuxQuestionConfig.TuxUIConfig tuxUIConfig;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            float[] conerRadii = Utils.getConerRadii(getResources().getDisplayMetrics(), 0.0f, 0.0f, 0.0f, 0.0f);
            int g16 = a.f().g(getContext(), R.color.qui_common_bg_middle_light, 1000);
            TuxNativeSurveySetting tuxNativeSurveySetting = this.nativeSurveySetting;
            if (tuxNativeSurveySetting != null) {
                TuxRect viewRect = tuxNativeSurveySetting.getViewRect();
                if (viewRect != null) {
                    conerRadii = Utils.getConerRadii(getResources().getDisplayMetrics(), viewRect.leftTop, viewRect.rightTop, viewRect.leftBottom, viewRect.rightBottom);
                }
                TuxQuestionConfig viewQuestionConfig = this.nativeSurveySetting.getViewQuestionConfig();
                if (viewQuestionConfig != null && (tuxUIConfig = viewQuestionConfig.uiConfig) != null && (i3 = tuxUIConfig.parentViewBackgroundColor) != -1) {
                    g16 = i3;
                }
            }
            setBackground(Utils.generateGradientDrawable(g16, conerRadii));
            TuxSurveyConfig tuxSurveyConfig = this.surveyConfig;
            if (tuxSurveyConfig != null && tuxSurveyConfig.getFrontSurvey() != null && (survey = this.surveyConfig.getFrontSurvey().getSurvey()) != null && (pages = survey.getPages()) != null && !pages.isEmpty() && (page = pages.get(0)) != null && (questions = page.getQuestions()) != null && !questions.isEmpty()) {
                createStarQuestion(questions.get(0));
            }
        } catch (Exception unused) {
        }
    }

    public TuxNativeStarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxNativeStarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.disappearReason = DisappearReason.OTHER;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
