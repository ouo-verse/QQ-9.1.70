package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.mobileqq.search.rich.o;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import com.tencent.mobileqq.search.view.p;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends qn2.f implements com.tencent.mobileqq.search.rich.g {

    /* renamed from: e, reason: collision with root package name */
    private d f283656e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f283657f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<jn2.c> f283658h;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            k.this.f283656e.onAction();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f283660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.rich.c f283661b;

        b(z zVar, com.tencent.mobileqq.search.rich.c cVar) {
            this.f283660a = zVar;
            this.f283661b = cVar;
        }

        @Override // com.tencent.mobileqq.search.presenter.k.d
        public void onAction() {
            al.b(this.f283660a);
            VideoReport.reportEvent("clck", this.f283661b.j(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f283663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f283664b;

        c(p pVar, z zVar) {
            this.f283663a = pVar;
            this.f283664b = zVar;
        }

        @Override // com.tencent.mobileqq.search.presenter.k.d
        public void onAction() {
            String q16;
            if (TextUtils.isEmpty(this.f283663a.q())) {
                q16 = String.valueOf(this.f283664b.getTitleSpans());
            } else {
                q16 = this.f283663a.q();
            }
            z zVar = this.f283664b;
            al.a(zVar.C, zVar.x(), this.f283664b.getKeyword(), q16);
            try {
                VideoReport.reportEvent("clck", this.f283663a.j(), null);
            } catch (Exception e16) {
                QLog.i("RichSearchResultPresenter", 1, "RichTemplateOneSearchResultView reportEvent", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void onAction();
    }

    public k(IFaceDecoder iFaceDecoder, jn2.c cVar) {
        super(iFaceDecoder);
        this.f283656e = null;
        this.f283657f = true;
        this.f283658h = new WeakReference<>(cVar);
    }

    private void p(int i3, int i16, com.tencent.mobileqq.search.rich.h hVar) {
        if (!(hVar instanceof o)) {
            return;
        }
        o oVar = (o) hVar;
        oVar.m(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
        if (i3 == 1) {
            oVar.p(true);
            return;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    oVar.p(true);
                    return;
                }
                return;
            }
            oVar.p(true);
            return;
        }
        oVar.p(true);
    }

    private void r() {
        jn2.c cVar;
        WeakReference<jn2.c> weakReference = this.f283658h;
        if (weakReference == null || (cVar = weakReference.get()) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    @Override // qn2.f, qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        am.n(view, i3, x.d(vVar), x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
    }

    @Override // com.tencent.mobileqq.search.rich.g
    public void e(com.tencent.mobileqq.search.rich.f fVar) {
        r();
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (!(yVar instanceof lo2.am) || !(cVar instanceof com.tencent.mobileqq.search.rich.h)) {
            return;
        }
        com.tencent.mobileqq.search.rich.h hVar = (com.tencent.mobileqq.search.rich.h) cVar;
        com.tencent.mobileqq.search.rich.f i3 = hVar.i();
        lo2.am amVar = (lo2.am) yVar;
        i3.f(amVar.Z(), amVar.Y(), amVar.X());
        i3.d(this);
        if (i3 instanceof com.tencent.mobileqq.search.rich.d) {
            if (hVar instanceof com.tencent.mobileqq.search.rich.c) {
                hVar.update();
            }
            ((com.tencent.mobileqq.search.rich.d) i3).k(true);
        }
        try {
            o(yVar, cVar);
        } catch (Exception e16) {
            QLog.i("RichSearchResultPresenter", 1, "bindChildDaTong", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void h(y yVar, sn2.c cVar) {
        if (this.f283656e != null) {
            if (cVar.getView() != null) {
                cVar.getView().setOnClickListener(new a());
            }
        } else {
            q((z) yVar, cVar);
            super.h(yVar, cVar);
        }
    }

    @Override // qn2.f, qn2.c
    /* renamed from: l */
    public void f(y yVar, sn2.c cVar, Bitmap bitmap) {
        super.f(yVar, cVar, bitmap);
    }

    @Override // qn2.f
    public void m(y yVar, sn2.c cVar) {
        if ((cVar instanceof com.tencent.mobileqq.search.rich.h) && this.f283657f) {
            p(yVar.p(), yVar.q(), (com.tencent.mobileqq.search.rich.h) cVar);
        }
    }

    protected void o(y yVar, sn2.c cVar) {
        View j3;
        String str;
        String str2 = "";
        if (cVar instanceof com.tencent.mobileqq.search.rich.c) {
            View j16 = ((com.tencent.mobileqq.search.rich.c) cVar).j();
            if (j16 == null) {
                return;
            }
            if (!(yVar instanceof lo2.am)) {
                str = "";
            } else {
                str = yVar.getTitleSpans().toString();
            }
            am.r(j16, str, x.e(yVar), "", 0, yVar.e(), String.valueOf(yVar.hashCode()), yVar.getRecallReason());
        }
        if (!(cVar instanceof p) || (j3 = ((p) cVar).j()) == null) {
            return;
        }
        if (yVar instanceof lo2.am) {
            str2 = yVar.getTitleSpans().toString();
        }
        am.r(j3, str2, x.e(yVar), "", 0, yVar.e(), String.valueOf(yVar.hashCode()), yVar.getRecallReason());
    }

    protected void q(z zVar, sn2.c cVar) {
        if (cVar instanceof com.tencent.mobileqq.search.rich.c) {
            com.tencent.mobileqq.search.rich.c cVar2 = (com.tencent.mobileqq.search.rich.c) cVar;
            ((ArkAppView) cVar2.s()).setOnActionListener(new b(zVar, cVar2));
        }
        if (cVar instanceof p) {
            p pVar = (p) cVar;
            pVar.t(new c(pVar, zVar));
        }
    }

    @Override // com.tencent.mobileqq.search.rich.g
    public void d(com.tencent.mobileqq.search.rich.f fVar, String str, String str2) {
    }
}
