package com.tencent.mobileqq.activity.photo.aiocomment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements ViewTreeObserver.OnGlobalLayoutListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private View f184152d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC7188a f184153e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f184154f;

    /* renamed from: h, reason: collision with root package name */
    private int f184155h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.photo.aiocomment.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7188a {
        void a(boolean z16);
    }

    public a(View view, InterfaceC7188a interfaceC7188a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) interfaceC7188a);
            return;
        }
        this.f184154f = false;
        this.f184152d = view;
        this.f184153e = interfaceC7188a;
        this.f184155h = UIUtils.b(view.getContext(), 160.0f);
        this.f184152d.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f184153e = null;
        try {
            this.f184152d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } catch (Throwable th5) {
            QLog.d("InputMethodObserver", 1, th5, new Object[0]);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Rect rect = new Rect();
        this.f184152d.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(this.f184152d.getRootView().getHeight() - (rect.bottom - rect.top));
        InterfaceC7188a interfaceC7188a = this.f184153e;
        if (interfaceC7188a != null) {
            if (abs >= this.f184155h) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 != this.f184154f) {
                this.f184154f = z16;
                interfaceC7188a.a(z16);
            }
        }
    }
}
