package com.tencent.tuxmeterqui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.TuxMeterUI;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.config.TuxRect;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.config.Utils;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmeterqui.question.TuxQuestionViewFactory;
import com.tencent.tuxmeterqui.question.TuxSensitiveInputView;
import com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener;
import com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView;
import com.tencent.tuxmeterqui.question.option.TuxOptionCommonView;
import com.tencent.tuxmeterqui.question.star.TuxStarCommonView;
import com.tencent.tuxmeterqui.question.text.TuxTextView;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import com.tencent.tuxmetersdk.export.config.TuxSurveyType;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.SubTitle;
import com.tencent.tuxmetersdk.model.Survey;
import ie0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxNativeSurveyView extends TuxBaseNativeView {
    static IPatchRedirector $redirector_;
    private final HashMap<String, List<String>> answerQuestionDisplaysUI;
    private List<Question> questionList;
    private TextView submitButton;
    private View submitView;
    private LinearLayout tuxQuestionContainer;

    public TuxNativeSurveyView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndUpdateSubmit() {
        boolean z16;
        if (TuxUIUtils.checkAndGetNoAnswerQuestion(this.tuxQuestionContainer) == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setSubmitEnable(z16);
    }

    private void createQuestionPage() {
        TuxQuestionConfig tuxQuestionConfig;
        List<Question> list = this.questionList;
        if (list != null && !list.isEmpty()) {
            this.tuxQuestionContainer.removeAllViews();
            Set<String> findDisplayQuestionIDs = TuxUIUtils.findDisplayQuestionIDs(this.questionList);
            int size = this.questionList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Question question = this.questionList.get(i3);
                String type = question.getType();
                if (i3 == 0 && !"star".equals(type)) {
                    this.submitView.setVisibility(0);
                }
                ITuxQuestionView createQuestionView = TuxQuestionViewFactory.createQuestionView(getContext(), question);
                if (createQuestionView != null) {
                    if (createQuestionView instanceof TuxStarCommonView) {
                        TuxStarCommonView tuxStarCommonView = (TuxStarCommonView) createQuestionView;
                        tuxStarCommonView.setClickListener(new TuxStarCommonView.TuxOnStarItemClickListener(question, findDisplayQuestionIDs) { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Set val$displaysSets;
                            final /* synthetic */ Question val$question;

                            {
                                this.val$question = question;
                                this.val$displaysSets = findDisplayQuestionIDs;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, TuxNativeSurveyView.this, question, findDisplayQuestionIDs);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.star.TuxStarCommonView.TuxOnStarItemClickListener
                            public void onItemClick(Option option, String str) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) option, (Object) str);
                                    return;
                                }
                                TuxNativeSurveyView.this.submitView.setVisibility(0);
                                if (Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                    TuxNativeSurveyView tuxNativeSurveyView2 = TuxNativeSurveyView.this;
                                    if (!tuxNativeSurveyView2.hasPreSubmit) {
                                        TuxMeterSDK.getInstance().submitAnswer(TuxNativeSurveyView.this.surveyConfig, TuxUIUtils.generateAnswer(tuxNativeSurveyView2.tuxQuestionContainer, TuxNativeSurveyView.this.surveyConfig), TuxSurveyType.SELF_RENDING_WITH_TUXH5);
                                        TuxNativeSurveyView.this.hasPreSubmit = true;
                                    }
                                }
                                TuxNativeSurveyView.this.doCommonQuestionClick(this.val$question.getId(), Collections.singletonList(option), this.val$displaysSets);
                                TuxEventListener tuxEventListener = TuxNativeSurveyView.this.tuxEventListener;
                                if (tuxEventListener != null) {
                                    tuxEventListener.onStarQuestionClick(this.val$question, option, str);
                                }
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxStarCommonView);
                    } else if (createQuestionView instanceof TuxOptionCommonView) {
                        TuxOptionCommonView tuxOptionCommonView = (TuxOptionCommonView) createQuestionView;
                        tuxOptionCommonView.setClickListener(new TuxOptionCommonView.OnOptionItemClickListener(tuxOptionCommonView, question, findDisplayQuestionIDs) { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.3
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Set val$displaysSets;
                            final /* synthetic */ Question val$question;
                            final /* synthetic */ TuxOptionCommonView val$tuxOptionView;

                            {
                                this.val$tuxOptionView = tuxOptionCommonView;
                                this.val$question = question;
                                this.val$displaysSets = findDisplayQuestionIDs;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, TuxNativeSurveyView.this, tuxOptionCommonView, question, findDisplayQuestionIDs);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.option.TuxOptionCommonView.OnOptionItemClickListener
                            public void onItemClick(List<Option> list2) {
                                List<Option> list3;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list2);
                                    return;
                                }
                                if (list2 == null) {
                                    return;
                                }
                                if (Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                }
                                if (!this.val$tuxOptionView.isMultiple() && !list2.isEmpty()) {
                                    list3 = Collections.singletonList(list2.get(0));
                                } else {
                                    list3 = list2;
                                }
                                TuxNativeSurveyView.this.doCommonQuestionClick(this.val$question.getId(), list3, this.val$displaysSets);
                                TuxUIUtils.updateLinkMatrix(TuxNativeSurveyView.this.tuxQuestionContainer, this.val$tuxOptionView, list2);
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxOptionCommonView);
                    } else if (createQuestionView instanceof TuxTextView) {
                        TuxTextView tuxTextView = (TuxTextView) createQuestionView;
                        tuxTextView.setFocusListener(new TuxTextView.OnTuxTextFocusListener() { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.4
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeSurveyView.this);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.text.TuxTextView.OnTuxTextFocusListener
                            public void onFocusChange(boolean z16) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                                } else if (z16 && Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                }
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxTextView);
                    } else if (createQuestionView instanceof TuxSensitiveInputView) {
                        TuxSensitiveInputView tuxSensitiveInputView = (TuxSensitiveInputView) createQuestionView;
                        tuxSensitiveInputView.setOnSensitiveChangeListener(new TuxSensitiveInputView.OnSensitiveChangeListener() { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.5
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeSurveyView.this);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.TuxSensitiveInputView.OnSensitiveChangeListener
                            public void onSensitiveChange(String str, boolean z16) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                                    return;
                                }
                                if (Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                }
                                TuxNativeSurveyView.this.checkAndUpdateSubmit();
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxSensitiveInputView);
                    } else if (createQuestionView instanceof TuxMatrixCommonView) {
                        TuxMatrixCommonView tuxMatrixCommonView = (TuxMatrixCommonView) createQuestionView;
                        tuxMatrixCommonView.updateLinkReferInfo(TuxUIUtils.findMatrixReferNumber(this.tuxQuestionContainer, question), new ArrayList());
                        tuxMatrixCommonView.setClickListener(new OnMatrixItemClickListener(question, findDisplayQuestionIDs) { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.6
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Set val$displaysSets;
                            final /* synthetic */ Question val$question;

                            {
                                this.val$question = question;
                                this.val$displaysSets = findDisplayQuestionIDs;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, TuxNativeSurveyView.this, question, findDisplayQuestionIDs);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                            public void onItemClick(SubTitle subTitle, List<Option> list2) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) subTitle, (Object) list2);
                                    return;
                                }
                                if (Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                }
                                TuxNativeSurveyView.this.doCommonQuestionClick(this.val$question.getId(), list2, this.val$displaysSets);
                            }

                            @Override // com.tencent.tuxmeterqui.question.matrix.OnMatrixItemClickListener
                            public void onLimitClick(SubTitle subTitle, int i16) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) subTitle, i16);
                                }
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxMatrixCommonView);
                    } else if (createQuestionView instanceof TuxTimeView) {
                        TuxTimeView tuxTimeView = (TuxTimeView) createQuestionView;
                        tuxTimeView.setOnTimeChangeListener(new TuxTimeView.OnTimeChangeListener() { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.7
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxNativeSurveyView.this);
                                }
                            }

                            @Override // com.tencent.tuxmeterqui.question.time.TuxTimeView.OnTimeChangeListener
                            public void onTimeChange(@NonNull String str) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                                    return;
                                }
                                if (Utils.canReportSurveyEvent(TuxNativeSurveyView.this.surveyEventCallback)) {
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    tuxNativeSurveyView.surveyEventCallback.onClick(tuxNativeSurveyView.surveyConfig);
                                }
                                TuxNativeSurveyView.this.checkAndUpdateSubmit();
                            }
                        });
                        this.tuxQuestionContainer.addView(tuxTimeView);
                    }
                    TuxNativeSurveySetting tuxNativeSurveySetting = this.nativeSurveySetting;
                    if (tuxNativeSurveySetting != null) {
                        tuxQuestionConfig = tuxNativeSurveySetting.getQuestionConfigMap().get(question.getSubType());
                    } else {
                        tuxQuestionConfig = null;
                    }
                    createQuestionView.updateView(question, this.surveyConfig.getResource(), tuxQuestionConfig);
                    if (i3 != 0) {
                        if (findDisplayQuestionIDs.contains(question.getId())) {
                            createQuestionView.setViewVisibility(false);
                        } else {
                            createQuestionView.setViewVisibility(true);
                            if (question.isRequired()) {
                                setSubmitEnable(false);
                            }
                        }
                    } else {
                        createQuestionView.setViewVisibility(true);
                        if (question.isRequired()) {
                            setSubmitEnable(false);
                        }
                    }
                }
            }
            mockFirstStarQuestionClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCommonQuestionClick(String str, List<Option> list, Set<String> set) {
        showQuestionByIDs(str, list, set);
        TuxUIUtils.updateQuestionListNumber(this.tuxQuestionContainer);
        checkAndUpdateSubmit();
        TuxUIUtils.clearQuestionViewFocus(this.tuxQuestionContainer);
    }

    private void mockFirstStarQuestionClick() {
        LinearLayout linearLayout;
        if (this.firstQuestionOption != null && (linearLayout = this.tuxQuestionContainer) != null && linearLayout.getChildCount() > 0) {
            View childAt = this.tuxQuestionContainer.getChildAt(0);
            if (childAt instanceof TuxStarCommonView) {
                this.hasPreSubmit = true;
                ((TuxStarCommonView) childAt).mockQuestionSelect(this.firstQuestionOption);
            }
        }
    }

    private void setSubmitEnable(boolean z16) {
        this.submitButton.setEnabled(z16);
    }

    private void showQuestionByIDs(String str, List<Option> list, Set<String> set) {
        if (list != null && set != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<Option> it = list.iterator();
            while (it.hasNext()) {
                String[] displays = it.next().getDisplays();
                if (displays != null) {
                    linkedHashSet.addAll(Arrays.asList(displays));
                }
            }
            List<String> arrayList = new ArrayList<>(linkedHashSet);
            if (arrayList.contains("-1")) {
                TuxMeterSDK.getInstance().submitAnswer(this.surveyConfig, TuxUIUtils.generateAnswer(this.tuxQuestionContainer, this.surveyConfig), TuxSurveyType.ALL_SELF_RENDERING);
                TuxEventListener tuxEventListener = this.tuxEventListener;
                if (tuxEventListener != null) {
                    tuxEventListener.onSurveySubmit(this.surveyConfig);
                    return;
                }
                return;
            }
            this.answerQuestionDisplaysUI.put(str, arrayList);
            int childCount = this.tuxQuestionContainer.getChildCount();
            boolean z16 = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.tuxQuestionContainer.getChildAt(i3);
                Object tag = childAt.getTag();
                if (tag instanceof Question) {
                    String id5 = ((Question) tag).getId();
                    if (str.equals(id5)) {
                        z16 = true;
                    } else if (z16) {
                        if (arrayList.contains(id5)) {
                            childAt.setVisibility(0);
                            if (childAt instanceof TuxOptionCommonView) {
                                TuxOptionCommonView tuxOptionCommonView = (TuxOptionCommonView) childAt;
                                List<Option> lastSelectedOptions = tuxOptionCommonView.getLastSelectedOptions();
                                if (!tuxOptionCommonView.isMultiple() && !lastSelectedOptions.isEmpty()) {
                                    lastSelectedOptions = Collections.singletonList(lastSelectedOptions.get(0));
                                }
                                if (!lastSelectedOptions.isEmpty()) {
                                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                    Iterator<Option> it5 = lastSelectedOptions.iterator();
                                    while (it5.hasNext()) {
                                        String[] displays2 = it5.next().getDisplays();
                                        if (displays2 != null) {
                                            linkedHashSet2.addAll(Arrays.asList(displays2));
                                        }
                                    }
                                    this.answerQuestionDisplaysUI.put(id5, new ArrayList(linkedHashSet2));
                                }
                            }
                        } else if (TuxUIUtils.checkQuestionInShowQuestionOptions(this.answerQuestionDisplaysUI, id5)) {
                            if (TuxUIUtils.getPreShowQuestionAnswerSet(str, this.tuxQuestionContainer, this.answerQuestionDisplaysUI).contains(id5)) {
                                childAt.setVisibility(0);
                            } else {
                                childAt.setVisibility(8);
                                Iterator<String> it6 = this.answerQuestionDisplaysUI.keySet().iterator();
                                while (it6.hasNext()) {
                                    List<String> list2 = this.answerQuestionDisplaysUI.get(it6.next());
                                    if (list2 != null && list2.contains(id5)) {
                                        childAt.setVisibility(0);
                                    }
                                }
                            }
                        } else if (set.contains(id5)) {
                            childAt.setVisibility(8);
                        } else {
                            childAt.setVisibility(0);
                        }
                    }
                }
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = this.tuxQuestionContainer.getChildAt(i16);
                Object tag2 = childAt2.getTag();
                if (childAt2.getVisibility() == 8 && (tag2 instanceof Question)) {
                    this.answerQuestionDisplaysUI.remove(((Question) tag2).getId());
                }
            }
            HashSet hashSet = new HashSet();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = this.tuxQuestionContainer.getChildAt(i17);
                Object tag3 = childAt3.getTag();
                if (childAt3.getVisibility() == 0 && (tag3 instanceof Question)) {
                    if (childAt3 instanceof TuxStarCommonView) {
                        String[] displays3 = ((TuxStarCommonView) childAt3).getSelectOption().getDisplays();
                        if (displays3 != null) {
                            hashSet.addAll(Arrays.asList(displays3));
                        }
                    } else if (childAt3 instanceof TuxOptionCommonView) {
                        Iterator<Option> it7 = ((TuxOptionCommonView) childAt3).getLastSelectedOptions().iterator();
                        while (it7.hasNext()) {
                            String[] displays4 = it7.next().getDisplays();
                            if (displays4 != null) {
                                hashSet.addAll(Arrays.asList(displays4));
                            }
                        }
                    }
                }
            }
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt4 = this.tuxQuestionContainer.getChildAt(i18);
                Object tag4 = childAt4.getTag();
                if (childAt4.getVisibility() == 0 && (tag4 instanceof Question)) {
                    Question question = (Question) tag4;
                    if ((childAt4 instanceof TuxTextView) && !hashSet.contains(question.getId())) {
                        childAt4.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.i1w, (ViewGroup) this, true);
        this.tuxQuestionContainer = (LinearLayout) inflate.findViewById(R.id.f10470641);
        this.submitView = inflate.findViewById(R.id.f1049764r);
        this.submitButton = (TextView) inflate.findViewById(R.id.f1049664q);
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    public void reportSurveyExposureEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.reportSurveyExposureEvent();
        if (this.firstQuestionOption == null) {
            TuxMeterUI.getInstance().reportSurveyExposureEvent(this.surveyConfig);
        } else {
            TuxMeterUI.getInstance().reportHalfFloatingLayerExposeEvent(this.surveyConfig);
        }
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    public void setSurveyData(TuxSurveyConfig tuxSurveyConfig, TuxNativeSurveySetting tuxNativeSurveySetting, TuxEventListener tuxEventListener, Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, option);
        } else {
            super.setSurveyData(tuxSurveyConfig, tuxNativeSurveySetting, tuxEventListener, option);
            reportSurveyExposureEvent();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:9:0x000f, B:11:0x0013, B:14:0x001a, B:15:0x0042, B:17:0x005e, B:20:0x006a, B:22:0x0070, B:26:0x0077, B:29:0x0081, B:31:0x0089, B:35:0x0090, B:41:0x0035), top: B:8:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void updateUIWithData() {
        float[] conerRadii;
        TuxSurveyConfig tuxSurveyConfig;
        List<Page> pages;
        Page page;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            TuxNativeSurveySetting tuxNativeSurveySetting = this.nativeSurveySetting;
            if (tuxNativeSurveySetting != null && tuxNativeSurveySetting.getViewRect() != null) {
                TuxRect viewRect = this.nativeSurveySetting.getViewRect();
                conerRadii = Utils.getConerRadii(getResources().getDisplayMetrics(), viewRect.leftTop, viewRect.rightTop, viewRect.leftBottom, viewRect.rightBottom);
                setBackground(Utils.generateGradientDrawable(a.f().g(getContext(), R.color.qui_common_bg_middle_light, 1000), conerRadii));
                tuxSurveyConfig = this.surveyConfig;
                if (tuxSurveyConfig == null) {
                    com.tencent.tuxmetersdk.impl.Utils.randomTuxSurveyConfigServery(tuxSurveyConfig);
                    Survey survey = this.surveyConfig.getSurvey();
                    if (survey == null || (pages = survey.getPages()) == null || pages.isEmpty() || (page = pages.get(0)) == null) {
                        return;
                    }
                    List<Question> questions = page.getQuestions();
                    this.questionList = questions;
                    if (questions != null && !questions.isEmpty()) {
                        this.submitView.setVisibility(8);
                        setSubmitEnable(true);
                        createQuestionPage();
                        TuxUIUtils.updateQuestionListNumber(this.tuxQuestionContainer);
                        this.submitButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.tuxmeterqui.view.TuxNativeSurveyView.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxNativeSurveyView.this);
                                }
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EventCollector.getInstance().onViewClickedBefore(view);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                                } else {
                                    TuxMeterSDK.getInstance().submitAnswer(TuxNativeSurveyView.this.surveyConfig, TuxUIUtils.generateAnswer(TuxNativeSurveyView.this.tuxQuestionContainer, TuxNativeSurveyView.this.surveyConfig), TuxSurveyType.ALL_SELF_RENDERING);
                                    TuxNativeSurveyView tuxNativeSurveyView = TuxNativeSurveyView.this;
                                    TuxEventListener tuxEventListener = tuxNativeSurveyView.tuxEventListener;
                                    if (tuxEventListener != null) {
                                        tuxEventListener.onSurveySubmit(tuxNativeSurveyView.surveyConfig);
                                    }
                                }
                                EventCollector.getInstance().onViewClicked(view);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            conerRadii = Utils.getConerRadii(getResources().getDisplayMetrics(), 0.0f, 0.0f, 0.0f, 0.0f);
            setBackground(Utils.generateGradientDrawable(a.f().g(getContext(), R.color.qui_common_bg_middle_light, 1000), conerRadii));
            tuxSurveyConfig = this.surveyConfig;
            if (tuxSurveyConfig == null) {
            }
        } catch (Exception unused) {
        }
    }

    public TuxNativeSurveyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxNativeSurveyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.answerQuestionDisplaysUI = new HashMap<>();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
