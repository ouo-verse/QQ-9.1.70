package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.entity.p;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public a f240587a;

    /* renamed from: b, reason: collision with root package name */
    public RedTouch f240588b;

    /* renamed from: c, reason: collision with root package name */
    public View f240589c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f240590d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f240591e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public n f240592a;

        /* renamed from: b, reason: collision with root package name */
        public Context f240593b;

        /* renamed from: c, reason: collision with root package name */
        public LebaRedTouchBase f240594c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public k(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, layoutInflater, viewGroup, Integer.valueOf(i3));
            return;
        }
        if (i3 == 2) {
            this.f240589c = layoutInflater.inflate(R.layout.gxg, viewGroup, false);
        } else {
            this.f240589c = layoutInflater.inflate(R.layout.gxf, viewGroup, false);
        }
        this.f240590d = (TextView) this.f240589c.findViewById(R.id.tv_name);
        this.f240591e = (ImageView) this.f240589c.findViewById(R.id.dvu);
        this.f240588b = new RedTouch(context, this.f240589c.findViewById(R.id.u6u)).setGravity(17).setLeftMargin(12).setButtomMargin(12).applyTo();
    }

    public void a(@NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f240587a = aVar;
        n nVar = aVar.f240592a;
        com.tencent.mobileqq.leba.utils.e.b(this.f240591e, this.f240590d, this.f240589c, nVar, false);
        c(aVar);
        b(this.f240589c, nVar);
    }

    void b(View view, n nVar) {
        if (view != null && nVar != null) {
            com.tencent.mobileqq.leba.report.d.i(view, nVar);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }

    public void c(@NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        n nVar = aVar.f240592a;
        Context context = aVar.f240593b;
        LebaRedTouchBase lebaRedTouchBase = aVar.f240594c;
        RedTouch redTouch = this.f240588b;
        if (redTouch == null) {
            return;
        }
        if (nVar != null && nVar.f240505b != null && lebaRedTouchBase != null && nVar.f240507d != 2) {
            p pVar = new p();
            pVar.f240520a = context;
            pVar.f240521b = this.f240588b;
            pVar.f240523d = nVar.f240504a;
            pVar.f240524e = nVar.f240505b.strPkgName;
            pVar.f240526g = true;
            lebaRedTouchBase.k(pVar);
            return;
        }
        redTouch.clearRedTouch();
    }
}
