package com.tencent.mobileqq.forward;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class o extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private AnimationTextView f211043h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f211044i;

    /* renamed from: j, reason: collision with root package name */
    private int f211045j;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (o.this.f211044i != null) {
                o.this.f211044i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (o.this.f211043h != null) {
                    o oVar = o.this;
                    if (oVar.f211033e != null) {
                        if (oVar.f211043h.getLineCount() > 1) {
                            o.this.f211043h.setGravity(19);
                        } else {
                            o.this.f211043h.setGravity(17);
                        }
                        if (o.this.f211043h.getHeight() >= ViewUtils.dip2px(o.this.f211045j + 2)) {
                            o.this.f211033e.setMaxHeight(ViewUtils.dip2px(450.0f));
                            o.this.f211033e.requestLayout();
                            if (QLog.isColorLevel()) {
                                QLog.d("ForwardPreviewTextController", 2, " reset height ");
                            }
                        }
                    }
                }
            }
        }
    }

    public o(QQCustomDialog qQCustomDialog) {
        super(qQCustomDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQCustomDialog);
        }
    }

    @Override // com.tencent.mobileqq.forward.m
    protected View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f211030b).inflate(R.layout.f167837j7, (ViewGroup) null);
        this.f211044i = viewGroup;
        AnimationTextView animationTextView = (AnimationTextView) viewGroup.findViewById(R.id.jfo);
        this.f211043h = animationTextView;
        if (animationTextView != null && SimpleModeHelper.A()) {
            this.f211043h.setTextColor(-1);
        }
        this.f211044i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f211044i.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        return this.f211044i;
    }

    @Override // com.tencent.mobileqq.forward.m
    protected int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.f211045j == 0) {
            this.f211045j = (int) ((this.f211035g.getRootViewHeight() - this.f211030b.getResources().getDimensionPixelSize(R.dimen.f158884rk)) / ViewUtils.mDensity);
        }
        return this.f211045j;
    }

    public void m(String str, String str2) {
        AnimationTextView animationTextView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardPreviewTextController", 2, " bindData ");
        }
        if (str != null) {
            h(str);
        }
        if (str2 != null && (animationTextView = this.f211043h) != null) {
            animationTextView.setText(new QQText(str2, 5, 20));
        }
    }
}
