package com.tencent.tuxmeterqui.question;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.question.matrix.TuxMatrixCheckboxView;
import com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView;
import com.tencent.tuxmeterqui.question.matrix.TuxMatrixRadioView;
import com.tencent.tuxmeterqui.question.option.TuxOptionCheckBoxView;
import com.tencent.tuxmeterqui.question.option.TuxOptionCommonView;
import com.tencent.tuxmeterqui.question.option.TuxOptionRadioView;
import com.tencent.tuxmeterqui.question.star.TuxStarCommonView;
import com.tencent.tuxmeterqui.question.star.TuxStarStarView;
import com.tencent.tuxmeterqui.question.star.TuxStarTextViewView;
import com.tencent.tuxmeterqui.question.text.TuxTextView;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import com.tencent.tuxmetersdk.impl.utils.TuxQuestionUtils;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxQuestionViewFactory {
    static IPatchRedirector $redirector_;
    private static final Map<QuestionMatcher, ViewCreator> VIEW_CREATORS;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    interface QuestionMatcher {
        boolean matches(Question question);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    interface ViewCreator {
        ITuxQuestionView create(Context context);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        VIEW_CREATORS = hashMap;
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.a
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isStarStar(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.c
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxStarStarView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.d
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isStarText(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.e
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxStarTextViewView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.f
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isOptionCheckBox(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.g
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxOptionCheckBoxView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.h
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isOptionRadio(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.i
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxOptionRadioView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.j
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isTextSingleLine(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.l
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxTextView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.k
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isTextArea(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.l
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxTextView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.m
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isOptionTime(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.n
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxTimeView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.o
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isSensitiveInput(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.p
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxSensitiveInputView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.q
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isMatrixCheckbox(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.r
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxMatrixCheckboxView(context);
            }
        });
        hashMap.put(new QuestionMatcher() { // from class: com.tencent.tuxmeterqui.question.s
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.QuestionMatcher
            public final boolean matches(Question question) {
                return TuxQuestionUtils.isMatrixRadio(question);
            }
        }, new ViewCreator() { // from class: com.tencent.tuxmeterqui.question.b
            @Override // com.tencent.tuxmeterqui.question.TuxQuestionViewFactory.ViewCreator
            public final ITuxQuestionView create(Context context) {
                return new TuxMatrixRadioView(context);
            }
        });
    }

    public TuxQuestionViewFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Question createQuestionAnswer(View view) {
        if (view != null && view.getVisibility() == 0) {
            try {
                if (view instanceof TuxStarCommonView) {
                    TuxStarCommonView tuxStarCommonView = (TuxStarCommonView) view;
                    Question question = (Question) tuxStarCommonView.getTag();
                    String text = tuxStarCommonView.getSelectOption().getText();
                    Question createSimpleQuestion = TuxUIUtils.createSimpleQuestion(question);
                    createSimpleQuestion.setText(text);
                    return createSimpleQuestion;
                }
                if (view instanceof TuxOptionCommonView) {
                    TuxOptionCommonView tuxOptionCommonView = (TuxOptionCommonView) view;
                    Question question2 = (Question) tuxOptionCommonView.getTag();
                    ArrayList arrayList = new ArrayList();
                    for (Option option : tuxOptionCommonView.getLastSelectedOptions()) {
                        Option option2 = new Option();
                        option2.setId(option.getId());
                        option2.setText(option.getText());
                        option2.setOtherText(option.getOtherText());
                        arrayList.add(option2);
                    }
                    Question createSimpleQuestion2 = TuxUIUtils.createSimpleQuestion(question2);
                    createSimpleQuestion2.setOptions(arrayList);
                    return createSimpleQuestion2;
                }
                if (view instanceof TuxTextView) {
                    TuxTextView tuxTextView = (TuxTextView) view;
                    String fillText = tuxTextView.getFillText();
                    Question createSimpleQuestion3 = TuxUIUtils.createSimpleQuestion((Question) tuxTextView.getTag());
                    createSimpleQuestion3.setText(fillText);
                    return createSimpleQuestion3;
                }
                if (view instanceof TuxSensitiveInputView) {
                    TuxSensitiveInputView tuxSensitiveInputView = (TuxSensitiveInputView) view;
                    String fillText2 = tuxSensitiveInputView.getFillText();
                    Question createSimpleQuestion4 = TuxUIUtils.createSimpleQuestion((Question) tuxSensitiveInputView.getTag());
                    createSimpleQuestion4.setText(fillText2);
                    return createSimpleQuestion4;
                }
                if (view instanceof TuxMatrixCommonView) {
                    TuxMatrixCommonView tuxMatrixCommonView = (TuxMatrixCommonView) view;
                    Question createSimpleQuestion5 = TuxUIUtils.createSimpleQuestion((Question) tuxMatrixCommonView.getTag());
                    createSimpleQuestion5.setGroups(tuxMatrixCommonView.getSelectedGroups());
                    return createSimpleQuestion5;
                }
                if (view instanceof TuxTimeView) {
                    TuxTimeView tuxTimeView = (TuxTimeView) view;
                    Question createSimpleQuestion6 = TuxUIUtils.createSimpleQuestion((Question) tuxTimeView.getTag());
                    createSimpleQuestion6.setTime(tuxTimeView.getAnswerTime());
                    createSimpleQuestion6.setUtcOffset(tuxTimeView.getUTCOffsetString());
                    return createSimpleQuestion6;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static ITuxQuestionView createQuestionView(Context context, Question question) {
        for (Map.Entry<QuestionMatcher, ViewCreator> entry : VIEW_CREATORS.entrySet()) {
            if (entry.getKey().matches(question)) {
                return entry.getValue().create(context);
            }
        }
        return null;
    }
}
