package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.g;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a> f297480a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a<D extends com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public D f297481d;

        public a(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        return this.f297480a.get(i3);
    }

    public void b(@NonNull RecyclerView.ViewHolder viewHolder, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, viewHolder, bVar, Integer.valueOf(i3));
            return;
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(bVar.c());
        if (a16 != null) {
            ((a) viewHolder).f297481d = bVar;
            a16.a(viewHolder, bVar, i3);
        }
    }

    @NonNull
    public RecyclerView.ViewHolder c(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(i3);
        if (a16 != null) {
            return a16.b(viewGroup);
        }
        return null;
    }

    public void d(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(bVar.c());
        if (a16 != null) {
            a16.c(bVar);
        }
    }

    public void e(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(bVar.c());
        if (a16 != null) {
            a16.d(bVar);
        }
    }

    public void f(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(bVar.c());
        if (a16 != null) {
            a16.f(bVar);
        }
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder);
            return;
        }
        a aVar = (a) viewHolder;
        D d16 = aVar.f297481d;
        if (d16 != 0 && (a16 = a(d16.c())) != null) {
            a16.g(aVar);
        }
    }

    public void h(RecyclerView.ViewHolder viewHolder) {
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder);
            return;
        }
        a aVar = (a) viewHolder;
        D d16 = aVar.f297481d;
        if (d16 != 0 && (a16 = a(d16.c())) != null) {
            a16.h(aVar);
        }
    }

    public void i(RecyclerView.ViewHolder viewHolder) {
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder);
            return;
        }
        a aVar = (a) viewHolder;
        D d16 = aVar.f297481d;
        if (d16 != 0 && (a16 = a(d16.c())) != null) {
            a16.i(aVar);
        }
    }

    public void j(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) gVar);
            return;
        }
        com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a a16 = a(gVar.c());
        if (a16 != null && (a16 instanceof d)) {
            ((d) a16).m(gVar);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.f297480a.size(); i3++) {
            this.f297480a.valueAt(i3).j();
        }
    }

    public void l(SparseArray<com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sparseArray);
        } else {
            this.f297480a = sparseArray;
        }
    }
}
