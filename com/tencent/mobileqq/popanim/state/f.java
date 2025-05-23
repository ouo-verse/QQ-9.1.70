package com.tencent.mobileqq.popanim.state;

import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.popanim.c f259136a;

    /* renamed from: b, reason: collision with root package name */
    public EmoticonInfo f259137b;

    /* renamed from: c, reason: collision with root package name */
    public PopOutAnimConfig f259138c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f259139d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f259140e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f259141f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference<QQEmoticonPanelLinearLayoutHelper> f259142g;

    /* renamed from: h, reason: collision with root package name */
    public IPanelInteractionListener f259143h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f259144i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f259145j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f259146k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f259147l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f259148m;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public QQEmoticonPanelLinearLayoutHelper a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQEmoticonPanelLinearLayoutHelper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<QQEmoticonPanelLinearLayoutHelper> weakReference = this.f259142g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.popanim.util.a.d(this.f259137b);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f259144i = false;
        this.f259145j = false;
        this.f259146k = false;
        this.f259147l = false;
        this.f259148m = false;
        this.f259136a.g();
    }
}
