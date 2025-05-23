package com.tencent.tuxmeterqui.question.text;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.config.TuxUIUtils;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmetersdk.impl.utils.TuxQuestionUtils;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxTextView extends FrameLayout implements ITuxQuestionView {
    static IPatchRedirector $redirector_;
    private EditText editText;
    private OnTuxTextFocusListener focusListener;
    private int tempQuestionNumber;
    private Question textQuestion;
    private TextView textQuestionDesc;
    private TextView textQuestionRequired;
    private TextView textQuestionTitle;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnTuxTextFocusListener {
        void onFocusChange(boolean z16);
    }

    public TuxTextView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canVerticalScroll(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        if (scrollY <= 0 && scrollY >= height - 1) {
            return false;
        }
        return true;
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169168i25, (ViewGroup) this, true);
        this.textQuestionRequired = (TextView) inflate.findViewById(R.id.f1044263_);
        this.textQuestionTitle = (TextView) inflate.findViewById(R.id.f1044563c);
        TextView textView = (TextView) inflate.findViewById(R.id.f10441639);
        this.textQuestionDesc = textView;
        textView.setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.f1049964t);
        this.editText = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.tuxmeterqui.question.text.TuxTextView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxTextView.this);
                }
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
                } else if (TuxTextView.this.focusListener != null) {
                    TuxTextView.this.focusListener.onFocusChange(z16);
                }
            }
        });
        this.editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.tuxmeterqui.question.text.TuxTextView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxTextView.this);
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
                }
                if (view.getId() == R.id.f1049964t) {
                    TuxTextView tuxTextView = TuxTextView.this;
                    if (tuxTextView.canVerticalScroll(tuxTextView.editText)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
        });
    }

    private void updateLayoutOrViews() {
        if (this.textQuestion.isRequired()) {
            this.textQuestionRequired.setVisibility(0);
        } else {
            this.textQuestionRequired.setVisibility(8);
        }
        this.textQuestionTitle.setText(this.textQuestion.getTitle());
        if (!isTextSingleLine()) {
            this.editText.setHeight(TuxUIUtils.dpToPx(getContext(), 124));
        } else {
            this.editText.setHeight(TuxUIUtils.dpToPx(getContext(), 48));
        }
        this.editText.setHint(this.textQuestion.getDescription());
    }

    public String getFillText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.editText.getText().toString();
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public Question getQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Question) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.textQuestion;
    }

    public int getQuestionNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.tempQuestionNumber;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!this.textQuestion.isRequired()) {
            return true;
        }
        return !TextUtils.isEmpty(getFillText());
    }

    public boolean isTextSingleLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        Question question = this.textQuestion;
        if (question == null) {
            return false;
        }
        return TuxQuestionUtils.isTextSingleLine(question);
    }

    public void setFocusListener(OnTuxTextFocusListener onTuxTextFocusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onTuxTextFocusListener);
        } else {
            this.focusListener = onTuxTextFocusListener;
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateView(Question question, Resource resource, TuxQuestionConfig tuxQuestionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, question, resource, tuxQuestionConfig);
            return;
        }
        this.textQuestion = question;
        setTag(question);
        if (this.textQuestion != null) {
            updateLayoutOrViews();
        }
    }

    public TuxTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            initView(context);
        } else {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
