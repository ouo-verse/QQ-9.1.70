package com.tencent.mobileqq.activity.newsetting.custom.config;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.v;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<QUIListItemAdapter> f183645l;

    /* renamed from: m, reason: collision with root package name */
    private View f183646m;

    /* renamed from: n, reason: collision with root package name */
    private String f183647n;

    /* renamed from: o, reason: collision with root package name */
    private InterfaceC7183a f183648o;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.custom.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7183a {
        void a();
    }

    public a(int i3, QUIListItemAdapter qUIListItemAdapter) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
        } else {
            this.f183645l = new WeakReference<>(qUIListItemAdapter);
        }
    }

    private void M() {
        if (this.f183645l.get() == null) {
            return;
        }
        this.f183645l.get().l0(this);
    }

    private void N() {
        InterfaceC7183a interfaceC7183a = this.f183648o;
        if (interfaceC7183a == null) {
            return;
        }
        interfaceC7183a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void D(@NonNull View view, @NonNull Group.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) cVar);
            return;
        }
        super.D(view, cVar);
        cVar.c(cVar.getLeft() + K() + Utils.n(12.0f, view.getResources()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NonNull View view, int i3, @NonNull List<?> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), list);
        } else {
            super.F(view, i3, list);
            O(this.f183647n);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
    @NonNull
    public View H(@NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        }
        View H = super.H(viewGroup);
        this.f183646m = H;
        View J = J(H);
        N();
        return J;
    }

    protected abstract View J(@NonNull View view);

    protected int K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean L(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view)).booleanValue();
        }
        if (this.f183646m == view) {
            return true;
        }
        return false;
    }

    public void O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        View view = this.f183646m;
        if (view != null) {
            view.setContentDescription(str);
        }
        this.f183647n = str;
    }

    public void P(InterfaceC7183a interfaceC7183a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) interfaceC7183a);
        } else {
            this.f183648o = interfaceC7183a;
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            x(onClickListener);
            M();
        }
    }

    public void R(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        QUIListItemAdapter qUIListItemAdapter = this.f183645l.get();
        if (qUIListItemAdapter != null) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qUIListItemAdapter.m0(this, z16);
        }
    }
}
