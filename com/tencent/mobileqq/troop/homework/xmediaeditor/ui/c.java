package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.f;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a<a, com.tencent.mobileqq.troop.homework.xmediaeditor.model.d> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f297482f;

    /* renamed from: h, reason: collision with root package name */
    private Context f297483h;

    /* renamed from: i, reason: collision with root package name */
    private View f297484i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a extends b.a<f> {
        static IPatchRedirector $redirector_;

        public a(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }
    }

    public c(XMediaEditor xMediaEditor, Context context) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor, (Object) context);
        } else {
            this.f297483h = context;
            this.f297482f = LayoutInflater.from(context);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void a(a aVar, com.tencent.mobileqq.troop.homework.xmediaeditor.model.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aVar, dVar, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        }
        return new a(this.f297484i);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void e(View view, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) aVar);
        }
    }

    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.f297484i = view;
        }
    }
}
