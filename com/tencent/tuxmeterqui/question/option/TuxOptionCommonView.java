package com.tencent.tuxmeterqui.question.option;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.profileskin.widget.QUIRecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.config.TuxComponentParamsKey;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import com.tencent.tuxmetersdk.model.BlankConfig;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TuxOptionCommonView extends FrameLayout implements ITuxQuestionView {
    static IPatchRedirector $redirector_ = null;
    protected static final int DEFAULT_LINE_ITEMS = 3;
    protected static final int MAX_SELECT = 1;
    protected static final String OPTION_STYLE_1 = "1";
    protected static final String OPTION_STYLE_2 = "2";
    protected static final String OPTION_STYLE_3 = "3";
    protected static final int WARNING_GONE_TIME = 1500;
    protected OnOptionItemClickListener clickListener;
    protected HashMap<String, String> componentParams;
    protected EditText extraEdittext;
    protected final Handler handler;
    protected String hasExtraTextForMultiByOptionID;
    protected boolean isVirtualLine;
    protected List<Option> lastSelectedOptions;
    protected int lineItems;
    protected int maxSelect;
    protected boolean multiple;
    protected Question optionQuestion;
    protected TextView questionDesc;
    protected TextView questionRequired;
    protected TextView questionTips;
    protected TextView questionTitle;
    protected TextView questionWarning;
    protected Resource resource;
    protected QUIRecyclerView selectRecyclerView;
    protected int tempQuestionNumber;
    protected final Runnable warningGoneRunnable;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnOptionItemClickListener {
        void onItemClick(List<Option> list);
    }

    public TuxOptionCommonView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int getForceMax(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawMultiExtraTextView(SelectOptionModel selectOptionModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) selectOptionModel);
            return;
        }
        if (!this.isVirtualLine && selectOptionModel != null && !TextUtils.isEmpty(this.hasExtraTextForMultiByOptionID) && this.extraEdittext != null) {
            Option option = selectOptionModel.getOption();
            if (option != null && option.getId().equals(this.hasExtraTextForMultiByOptionID)) {
                if (option.isAddBlank() && option.getBlankConfig() != null) {
                    if (selectOptionModel.isSelect()) {
                        this.extraEdittext.setVisibility(0);
                        BlankConfig blankConfig = option.getBlankConfig();
                        this.extraEdittext.setHint(blankConfig.getTip());
                        this.extraEdittext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(blankConfig.getMaxLen())});
                        this.extraEdittext.addTextChangedListener(new TextWatcher(option) { // from class: com.tencent.tuxmeterqui.question.option.TuxOptionCommonView.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Option val$option;

                            {
                                this.val$option = option;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxOptionCommonView.this, (Object) option);
                                }
                            }

                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) editable);
                                } else {
                                    this.val$option.setOtherText(editable.toString());
                                }
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                                }
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                    iPatchRedirector2.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                                }
                            }
                        });
                        return;
                    }
                    this.extraEdittext.setVisibility(8);
                    return;
                }
                return;
            }
            this.extraEdittext.setVisibility(8);
            return;
        }
        EditText editText = this.extraEdittext;
        if (editText != null) {
            editText.setVisibility(8);
        }
    }

    protected int getForceLineItemsInt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        if ("1".equals(str)) {
            return 1;
        }
        if ("2".equals(str)) {
            return 2;
        }
        if ("3".equals(str)) {
            return 3;
        }
        return -1;
    }

    public List<Option> getLastSelectedOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.lastSelectedOptions == null) {
            this.lastSelectedOptions = new ArrayList();
        }
        return this.lastSelectedOptions;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public Question getQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Question) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.optionQuestion;
    }

    public int getQuestionNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.tempQuestionNumber;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.optionQuestion.isRequired()) {
            return true;
        }
        if (this.lastSelectedOptions == null) {
            return false;
        }
        return !r0.isEmpty();
    }

    public boolean isMultiple() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.multiple;
    }

    protected void parseRenderStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        try {
            String style = this.optionQuestion.getStyle();
            if (!TextUtils.isEmpty(style)) {
                JSONObject jSONObject = new JSONObject(style);
                this.lineItems = jSONObject.optInt(TuxQuestionType.OPTION_QUESTION_LINE_ITEMS, 3);
                this.maxSelect = jSONObject.optInt("max", -1);
                this.multiple = jSONObject.optBoolean("multiple", false);
            }
        } catch (Exception unused) {
        }
        try {
            String str = this.componentParams.get(TuxComponentParamsKey.OPTION_TYPE_LINE_ITEMS);
            String str2 = this.componentParams.get(TuxComponentParamsKey.OPTION_TYPE_MAX);
            int forceLineItemsInt = getForceLineItemsInt(str);
            if (forceLineItemsInt > 0 && forceLineItemsInt <= 3) {
                this.lineItems = forceLineItemsInt;
            }
            int forceMax = getForceMax(str2);
            if (forceMax > 0) {
                this.maxSelect = forceMax;
            }
        } catch (Exception unused2) {
        }
        if (this.lineItems == -1) {
            this.lineItems = 3;
        }
        if (this.maxSelect == -1) {
            this.maxSelect = this.optionQuestion.getOptionMaxCut();
        }
    }

    public void setClickListener(OnOptionItemClickListener onOptionItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onOptionItemClickListener);
        } else {
            this.clickListener = onOptionItemClickListener;
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        }
        setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startGoneWarning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.handler.removeCallbacks(this.warningGoneRunnable);
            this.handler.postDelayed(this.warningGoneRunnable, 1500L);
        }
    }

    protected abstract void updateLayoutOrViews();

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateQuestionNumber(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateView(Question question, Resource resource, TuxQuestionConfig tuxQuestionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, question, resource, tuxQuestionConfig);
            return;
        }
        this.optionQuestion = question;
        setTag(question);
        this.resource = resource;
        if (resource != null) {
            this.componentParams = resource.getComponentParams();
        }
        if (this.optionQuestion != null) {
            parseRenderStyle();
            updateLayoutOrViews();
        }
    }

    public TuxOptionCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxOptionCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.handler = new Handler();
        this.warningGoneRunnable = new Runnable() { // from class: com.tencent.tuxmeterqui.question.option.TuxOptionCommonView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxOptionCommonView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TextView textView = TuxOptionCommonView.this.questionWarning;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        };
        this.lineItems = -1;
        this.maxSelect = -1;
        this.multiple = false;
        this.lastSelectedOptions = new ArrayList();
    }
}
