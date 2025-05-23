package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a<T> extends b<T> {
    static IPatchRedirector $redirector_;
    protected int H;
    protected LayoutInflater I;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8665a implements com.tencent.mobileqq.troop.adapter.base.a<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f293778a;

        C8665a(int i3) {
            this.f293778a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.adapter.base.a
        public boolean a(T t16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16, i3)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.troop.adapter.base.a
        public void b(com.tencent.mobileqq.troop.adapter.base.c cVar, T t16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cVar, t16, Integer.valueOf(i3));
            } else {
                a.this.P(cVar, t16, i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.adapter.base.a
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f293778a;
        }
    }

    public a(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.I = LayoutInflater.from(context);
        this.H = i3;
        q(new C8665a(i3));
    }

    protected abstract void P(com.tencent.mobileqq.troop.adapter.base.c cVar, T t16, int i3);

    protected abstract com.tencent.mobileqq.troop.adapter.base.c Q(Context context, ViewGroup viewGroup, int i3);

    @Override // com.tencent.mobileqq.troop.adapter.b
    public com.tencent.mobileqq.troop.adapter.base.c t(Context context, ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.adapter.base.c) iPatchRedirector.redirect((short) 2, this, context, viewGroup, Integer.valueOf(i3));
        }
        return Q(context, viewGroup, i3);
    }
}
