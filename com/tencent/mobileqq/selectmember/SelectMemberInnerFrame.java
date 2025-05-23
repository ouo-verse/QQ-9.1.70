package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.k;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class SelectMemberInnerFrame extends InnerFrame {
    static IPatchRedirector $redirector_;
    protected LayoutInflater C;

    /* renamed from: h, reason: collision with root package name */
    protected SelectMemberActivity f285782h;

    /* renamed from: i, reason: collision with root package name */
    protected InnerFrameManager f285783i;

    /* renamed from: m, reason: collision with root package name */
    protected AppInterface f285784m;

    public SelectMemberInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        this.f285782h = (SelectMemberActivity) e();
        this.f285783i = g();
        if (f() instanceof AppInterface) {
            this.f285784m = f();
        } else {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof AppInterface) {
                this.f285784m = (AppInterface) waitAppRuntime;
            }
        }
        this.C = this.f285782h.getLayoutInflater();
    }

    public abstract com.tencent.mobileqq.search.view.f n(boolean z16, k kVar);

    public abstract String o();

    public abstract void p();

    public void q(ResultRecord resultRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) resultRecord, i3);
        }
    }

    public SelectMemberInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SelectMemberInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
