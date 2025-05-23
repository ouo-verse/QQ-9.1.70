package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class TroopDiscussionBaseV extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected SelectMemberActivity f285848d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f285849e;

    /* renamed from: f, reason: collision with root package name */
    protected AppInterface f285850f;

    /* renamed from: h, reason: collision with root package name */
    protected InnerFrameManager f285851h;

    /* renamed from: i, reason: collision with root package name */
    protected LayoutInflater f285852i;

    public TroopDiscussionBaseV(SelectMemberActivity selectMemberActivity) {
        super(selectMemberActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectMemberActivity);
            return;
        }
        this.f285850f = (AppInterface) selectMemberActivity.getAppRuntime();
        this.f285848d = selectMemberActivity;
        this.f285849e = selectMemberActivity;
        this.f285852i = selectMemberActivity.getLayoutInflater();
        this.f285851h = selectMemberActivity.mInnerFrameManager;
    }

    public void b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void e(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i3, (ViewGroup) this, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
