package com.tencent.mobileqq.richstatus.topic;

import android.R;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.profile.view.ClickPreventableTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends ClickableSpan implements ITopic {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f282423d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f282424e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f282425f;

    /* renamed from: h, reason: collision with root package name */
    private Object f282426h;

    /* renamed from: i, reason: collision with root package name */
    private ITopic.OnTopicClickListener f282427i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f282428m;

    public a(ITopic.OnTopicClickListener onTopicClickListener, ColorStateList colorStateList, ColorStateList colorStateList2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, onTopicClickListener, colorStateList, colorStateList2, obj);
            return;
        }
        this.f282427i = onTopicClickListener;
        this.f282424e = colorStateList;
        this.f282425f = colorStateList2;
        this.f282426h = obj;
    }

    @Override // com.tencent.mobileqq.text.ITopic
    public Object getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f282426h;
    }

    @Override // android.text.style.ClickableSpan, com.tencent.mobileqq.text.ITopic
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if (view instanceof ClickPreventableTextView) {
            ClickPreventableTextView clickPreventableTextView = (ClickPreventableTextView) view;
            if (clickPreventableTextView.a()) {
                return;
            } else {
                clickPreventableTextView.b();
            }
        }
        ITopic.OnTopicClickListener onTopicClickListener = this.f282427i;
        if (onTopicClickListener != null) {
            onTopicClickListener.onClick(this, view);
        }
    }

    @Override // com.tencent.mobileqq.text.ITopic
    public void setCustomFont(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (this.f282428m != z16) {
            this.f282428m = z16;
        }
    }

    @Override // com.tencent.mobileqq.text.ITopic
    public void setPressed(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ClickColorTopicSpan", 2, String.format("setPressed %b", Boolean.valueOf(z16)));
        }
        if (this.f282423d != z16) {
            this.f282423d = z16;
            view.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Object obj = this.f282426h;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            sb5.append("id=");
            sb5.append(pair.first);
            sb5.append(",");
            sb5.append("topic=");
            sb5.append((String) pair.second);
            sb5.append(",");
        }
        return sb5.toString();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int colorForState;
        int colorForState2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) textPaint);
            return;
        }
        super.updateDrawState(textPaint);
        if (this.f282428m) {
            return;
        }
        textPaint.setUnderlineText(false);
        ColorStateList colorStateList = this.f282424e;
        if (colorStateList != null) {
            if (this.f282423d) {
                colorForState2 = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, 0);
            } else {
                colorForState2 = colorStateList.getColorForState(new int[0], 0);
            }
            textPaint.setColor(colorForState2);
        } else {
            textPaint.setColor(-16777216);
        }
        ColorStateList colorStateList2 = this.f282425f;
        if (colorStateList2 != null) {
            if (this.f282423d) {
                colorForState = colorStateList2.getColorForState(new int[]{R.attr.state_pressed}, 0);
            } else {
                colorForState = colorStateList2.getColorForState(new int[0], 0);
            }
            textPaint.bgColor = colorForState;
            return;
        }
        textPaint.bgColor = 0;
    }

    public a(ITopic.OnTopicClickListener onTopicClickListener, ColorStateList colorStateList, Object obj) {
        this(onTopicClickListener, colorStateList, null, obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, onTopicClickListener, colorStateList, obj);
    }
}
