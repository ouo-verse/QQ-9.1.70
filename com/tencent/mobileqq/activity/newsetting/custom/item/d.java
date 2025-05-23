package com.tencent.mobileqq.activity.newsetting.custom.item;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d<T extends View> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected T f183667a;

    /* renamed from: b, reason: collision with root package name */
    protected g71.a<T> f183668b;

    /* renamed from: c, reason: collision with root package name */
    protected String f183669c;

    /* renamed from: d, reason: collision with root package name */
    protected int f183670d;

    /* renamed from: e, reason: collision with root package name */
    protected View.OnClickListener f183671e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183670d = 0;
        }
    }

    private void d() {
        T t16 = this.f183667a;
        if (t16 == null) {
            QLog.d("SettingViewItem", 1, "[notifyViewUpdate] view should not be null.");
            return;
        }
        g71.a<T> aVar = this.f183668b;
        if (aVar == null) {
            QLog.d("SettingViewItem", 1, "[notifyViewUpdate] view ");
        } else {
            aVar.a(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        e(this.f183669c);
        g(this.f183670d);
        f(this.f183671e);
    }

    public boolean b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view)).booleanValue();
        }
        if (this.f183667a == view) {
            return true;
        }
        return false;
    }

    public void c(@NonNull g71.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f183668b = aVar;
            d();
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != null) {
            t16.setContentDescription(str);
        }
        this.f183669c = str;
    }

    public void f(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != null) {
            t16.setOnClickListener(onClickListener);
        }
        this.f183671e = onClickListener;
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.f183670d = i3;
        T t16 = this.f183667a;
        if (t16 != null) {
            t16.setVisibility(i3);
        }
    }

    public void h(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            return;
        }
        this.f183667a = t16;
        a();
        d();
    }
}
