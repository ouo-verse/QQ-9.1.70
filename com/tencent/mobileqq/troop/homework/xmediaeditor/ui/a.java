package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a<VH extends RecyclerView.ViewHolder, D extends com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public XMediaEditor f297478d;

    /* renamed from: e, reason: collision with root package name */
    protected InterfaceC8754a f297479e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8754a {
        void a(RecyclerView.ViewHolder viewHolder);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(int i3, int i16);

        void d(RecyclerView.ViewHolder viewHolder);

        void e(RecyclerView.ViewHolder viewHolder, boolean z16);

        void f(RecyclerView.ViewHolder viewHolder);
    }

    public a(XMediaEditor xMediaEditor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor);
        } else {
            this.f297478d = xMediaEditor;
        }
    }

    public abstract void a(VH vh5, D d16, int i3);

    public abstract VH b(ViewGroup viewGroup);

    public void c(D d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) d16);
        }
    }

    public void d(D d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) d16);
        }
    }

    public abstract void e(View view, VH vh5);

    public void f(D d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) d16);
        }
    }

    public void g(VH vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) vh5);
        }
    }

    public void h(VH vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) vh5);
        }
    }

    public void i(VH vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) vh5);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public a k(InterfaceC8754a interfaceC8754a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) interfaceC8754a);
        }
        this.f297479e = interfaceC8754a;
        return this;
    }

    public void l(View view, VH vh5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) vh5);
        } else {
            view.setTag(vh5);
            view.setOnClickListener(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            e(view, (RecyclerView.ViewHolder) view.getTag());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
