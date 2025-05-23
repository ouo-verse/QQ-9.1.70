package com.tencent.mobileqq.activity.verifysms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerifyCodeView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View f186620a;

    /* renamed from: b, reason: collision with root package name */
    private VerifyCodeView f186621b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f186622c;

    public b(LayoutInflater layoutInflater, ViewGroup viewGroup, VerifyCodeView.a aVar, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, layoutInflater, viewGroup, aVar, onClickListener);
            return;
        }
        View inflate = layoutInflater.inflate(R.layout.i39, viewGroup, false);
        g(inflate, aVar, onClickListener);
        viewGroup.addView(inflate);
    }

    private void g(View view, VerifyCodeView.a aVar, View.OnClickListener onClickListener) {
        this.f186620a = view;
        VerifyCodeView verifyCodeView = (VerifyCodeView) view.findViewById(R.id.f116566z3);
        this.f186621b = verifyCodeView;
        verifyCodeView.setDigitTextColorNormal(ContextCompat.getColor(view.getContext(), R.color.qui_common_text_primary));
        this.f186621b.setDigitTextColorWrong(ContextCompat.getColor(view.getContext(), R.color.qui_common_feedback_error));
        this.f186621b.e(aVar);
        TextView textView = (TextView) view.findViewById(R.id.aji);
        this.f186622c = textView;
        textView.setOnClickListener(onClickListener);
        if (AppSetting.f99565y) {
            TextView textView2 = this.f186622c;
            textView2.setContentDescription(textView2.getContext().getString(R.string.f172945g10));
        }
        e();
    }

    private void h(View view, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = ViewUtils.dpToPx(i3);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f186621b.i();
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.string.f172948g20;
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void c(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            this.f186622c.setEnabled(true);
            this.f186622c.setClickable(true);
            if (z17) {
                this.f186622c.setText(R.string.f172945g10);
            } else {
                this.f186622c.setText(R.string.f216635yu);
            }
            TextView textView = this.f186622c;
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_link));
            return;
        }
        this.f186622c.setEnabled(false);
        this.f186622c.setClickable(false);
        this.f186622c.setText(this.f186622c.getContext().getString(R.string.f172945g10) + "(" + i3 + "s)");
        TextView textView2 = this.f186622c;
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qui_common_text_secondary));
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void clearWrongCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f186621b.g();
        }
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public boolean d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (z.b(this.f186620a.getContext())) {
            z.w(this.f186620a.findViewById(R.id.h0w));
            h(this.f186620a.findViewById(R.id.kes), 0);
            h(this.f186620a.findViewById(R.id.f116566z3), 0);
            h(this.f186620a.findViewById(R.id.aji), 0);
            return;
        }
        z.A(this.f186620a.findViewById(R.id.h0w));
        h(this.f186620a.findViewById(R.id.kes), 32);
        h(this.f186620a.findViewById(R.id.f116566z3), 32);
        h(this.f186620a.findViewById(R.id.aji), 32);
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
