package com.tencent.tuxmeterqui.question.star;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TuxStarCommonView extends FrameLayout implements ITuxQuestionView {
    static IPatchRedirector $redirector_ = null;
    public static final String STAR_OPTION_ID = "option_id";
    protected TuxOnStarItemClickListener clickListener;
    protected HashMap<String, String> componentParams;
    protected TuxQuestionConfig questionConfig;
    protected TextView questionDesc;
    protected TextView questionRequired;
    protected TextView questionTitle;
    protected Resource resource;
    protected Option selectOption;
    protected Question starQuestion;
    protected int tempQuestionNumber;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface TuxOnStarItemClickListener {
        void onItemClick(Option option, String str);
    }

    public TuxStarCommonView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public Question getQuestion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Question) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.starQuestion;
    }

    public int getQuestionNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.tempQuestionNumber;
    }

    public Option getSelectOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Option) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Option option = this.selectOption;
        if (option == null) {
            return new Option();
        }
        return option;
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public boolean hasAnsweredInRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.starQuestion.isRequired()) {
            return true;
        }
        Option option = this.selectOption;
        if (option != null && !TextUtils.isEmpty(option.getText())) {
            return true;
        }
        return false;
    }

    public abstract void mockQuestionSelect(Option option);

    public void setClickListener(TuxOnStarItemClickListener tuxOnStarItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tuxOnStarItemClickListener);
        } else {
            this.clickListener = tuxOnStarItemClickListener;
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void setViewVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    protected abstract void updateLayoutOrViews();

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateQuestionNumber(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateQuestionRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.starQuestion.isRequired()) {
            this.questionRequired.setVisibility(0);
        } else {
            this.questionRequired.setVisibility(8);
        }
    }

    @Override // com.tencent.tuxmeterqui.question.ITuxQuestionView
    public void updateView(Question question, Resource resource, TuxQuestionConfig tuxQuestionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, question, resource, tuxQuestionConfig);
            return;
        }
        this.starQuestion = question;
        setTag(question);
        this.resource = resource;
        if (resource != null) {
            this.componentParams = resource.getComponentParams();
        }
        this.questionConfig = tuxQuestionConfig;
        if (this.starQuestion != null) {
            updateLayoutOrViews();
        }
    }

    public TuxStarCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxStarCommonView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, context, attributeSet, Integer.valueOf(i3));
    }
}
