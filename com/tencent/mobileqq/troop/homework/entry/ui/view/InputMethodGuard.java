package com.tencent.mobileqq.troop.homework.entry.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class InputMethodGuard extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f297057d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f297058e;

    /* renamed from: f, reason: collision with root package name */
    private int f297059f;

    /* renamed from: h, reason: collision with root package name */
    private a f297060h;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void Xb(boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputMethodGuard.this);
            }
        }

        private int a() {
            return ((WindowManager) InputMethodGuard.this.getContext().getSystemService("window")).getDefaultDisplay().getHeight();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                boolean z16 = InputMethodGuard.this.f297058e;
                Rect rect = new Rect();
                ((Activity) InputMethodGuard.this.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int a16 = a();
                int i3 = a16 - rect.bottom;
                if (Math.abs(i3) > a16 / 5) {
                    InputMethodGuard.this.f297058e = true;
                    InputMethodGuard.this.f297059f = i3;
                } else {
                    InputMethodGuard.this.f297058e = false;
                    InputMethodGuard.this.f297059f = 0;
                }
                if (InputMethodGuard.this.f297060h != null && (z16 != InputMethodGuard.this.f297058e || InputMethodGuard.this.f297057d)) {
                    InputMethodGuard.this.f297060h.Xb(InputMethodGuard.this.f297058e, InputMethodGuard.this.f297059f);
                }
                if (InputMethodGuard.this.f297057d) {
                    InputMethodGuard.this.f297057d = false;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public InputMethodGuard(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f297059f;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f297058e;
    }

    public void setOnInputMethodChangeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f297060h = aVar;
        }
    }

    public InputMethodGuard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public InputMethodGuard(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f297057d = true;
        this.f297058e = false;
        this.f297059f = 0;
        this.f297060h = null;
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }
}
