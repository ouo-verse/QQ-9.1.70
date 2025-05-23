package com.tencent.tuxmeterqui.question;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSensitiveInputView extends FrameLayout implements ITuxQuestionView {
    static IPatchRedirector $redirector_ = null;
    private static final String LICENSE_KEY = "license";
    private EditText editText;
    private boolean hasShowSensitiveProtocol;
    private OnSensitiveChangeListener onSensitiveChangeListener;
    private View protocolFooterView;
    private CheckBox sensitiveCheckBox;
    private TextView sensitiveProtocol;
    private Question sensitiveQuestion;
    private TextView sensitiveQuestionDesc;
    private TextView sensitiveQuestionRequired;
    private TextView sensitiveQuestionTitle;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnSensitiveChangeListener {
        void onSensitiveChange(String str, boolean z16);
    }

    public TuxSensitiveInputView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    private void fillSensitiveProtocol() {
        int g16 = ie0.a.f().g(getContext(), R.color.qui_common_brand_standard, 1000);
        String string = getResources().getString(R.string.f236987fu);
        SpannableString spannableString = new SpannableString(string);
        ClickableSpan clickableSpan = new ClickableSpan(g16) { // from class: com.tencent.tuxmeterqui.question.TuxSensitiveInputView.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$primaryColor;

            {
                this.val$primaryColor = g16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxSensitiveInputView.this, g16);
                }
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    return;
                }
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(TuxUIConstants.SENSITIVE_ANSWER_URL));
                if (intent.resolveActivity(TuxSensitiveInputView.this.getContext().getPackageManager()) != null) {
                    TuxSensitiveInputView.this.getContext().startActivity(intent);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                    return;
                }
                super.updateDrawState(textPaint);
                textPaint.setColor(this.val$primaryColor);
                textPaint.setUnderlineText(false);
            }
        };
        String string2 = getResources().getString(R.string.f236997fv);
        int indexOf = string.indexOf(string2);
        spannableString.setSpan(clickableSpan, indexOf, string2.length() + indexOf, 33);
        ClickableSpan clickableSpan2 = new ClickableSpan(g16) { // from class: com.tencent.tuxmeterqui.question.TuxSensitiveInputView.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$primaryColor;

            {
                this.val$primaryColor = g16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxSensitiveInputView.this, g16);
                }
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    return;
                }
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(TuxUIConstants.SENSITIVE_INFO_URL));
                if (intent.resolveActivity(TuxSensitiveInputView.this.getContext().getPackageManager()) != null) {
                    TuxSensitiveInputView.this.getContext().startActivity(intent);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                    return;
                }
                super.updateDrawState(textPaint);
                textPaint.setColor(this.val$primaryColor);
                textPaint.setUnderlineText(false);
            }
        };
        String string3 = getResources().getString(R.string.f237007fw);
        int indexOf2 = string.indexOf(string3);
        spannableString.setSpan(clickableSpan2, indexOf2, string3.length() + indexOf2, 33);
        this.sensitiveProtocol.setText(spannableString);
        this.sensitiveProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        this.sensitiveProtocol.setHighlightColor(0);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169165i22, (ViewGroup) this, true);
        this.sensitiveQuestionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.sensitiveQuestionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        TextView textView = (TextView) inflate.findViewById(R.id.f10441639);
        this.sensitiveQuestionDesc = textView;
        textView.setVisibility(8);
        this.editText = (EditText) inflate.findViewById(R.id.f1048964j);
        this.protocolFooterView = inflate.findViewById(R.id.f1048864i);
        this.sensitiveProtocol = (TextView) inflate.findViewById(R.id.f1048764h);
        this.sensitiveCheckBox = (CheckBox) inflate.findViewById(R.id.f1048664g);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.tuxmeterqui.question.TuxSensitiveInputView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxSensitiveInputView.this);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                } else if (TuxSensitiveInputView.this.onSensitiveChangeListener != null) {
                    TuxSensitiveInputView.this.onSensitiveChangeListener.onSensitiveChange(editable.toString(), TuxSensitiveInputView.this.sensitiveCheckBox.isChecked());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                }
            }
        });
        this.sensitiveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.tuxmeterqui.question.TuxSensitiveInputView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxSensitiveInputView.this);
                }
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
                } else if (TuxSensitiveInputView.this.onSensitiveChangeListener != null) {
                    TuxSensitiveInputView.this.onSensitiveChangeListener.onSensitiveChange(TuxSensitiveInputView.this.getFillText(), z16);
                }
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        });
    }

    private String parseRenderStyleWithLicenseDefault() {
        Question question = this.sensitiveQuestion;
        if (question == null) {
            return "";
        }
        String style = question.getStyle();
        if (TextUtils.isEmpty(style)) {
            return "";
        }
        try {
            return new JSONObject(style).optString(LICENSE_KEY, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private void updateLayoutOrViews() {
        if (this.sensitiveQuestion.isRequired()) {
            this.sensitiveQuestionRequired.setVisibility(0);
        } else {
            this.sensitiveQuestionRequired.setVisibility(8);
        }
        this.sensitiveQuestionTitle.setText(this.sensitiveQuestion.getTitle());
        this.editText.setHint(this.sensitiveQuestion.getDescription());
        boolean equals = "1".equals(parseRenderStyleWithLicenseDefault());
        this.hasShowSensitiveProtocol = equals;
        if (equals) {
            this.protocolFooterView.setVisibility(0);
            fillSensitiveProtocol();
        } else {
            this.protocolFooterView.setVisibility(8);
        }
    }

    public String getFillText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.editText.getText().toString();
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public Question getQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Question) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.sensitiveQuestion;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        String fillText = getFillText();
        boolean isChecked = this.sensitiveCheckBox.isChecked();
        boolean z16 = !TextUtils.isEmpty(fillText);
        if (this.sensitiveQuestion.isRequired()) {
            if (z16 && isChecked) {
                return true;
            }
            return false;
        }
        if (!z16 || !this.hasShowSensitiveProtocol) {
            return true;
        }
        return isChecked;
    }

    public void setOnSensitiveChangeListener(OnSensitiveChangeListener onSensitiveChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onSensitiveChangeListener);
        } else {
            this.onSensitiveChangeListener = onSensitiveChangeListener;
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, question, resource, tuxQuestionConfig);
            return;
        }
        this.sensitiveQuestion = question;
        setTag(question);
        if (this.sensitiveQuestion != null) {
            updateLayoutOrViews();
        }
    }

    public TuxSensitiveInputView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxSensitiveInputView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            initView(context);
        } else {
            iPatchRedirector.redirect((short) 9, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
