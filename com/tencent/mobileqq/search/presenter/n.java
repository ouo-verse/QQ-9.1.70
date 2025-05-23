package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n implements qn2.d<v, sn2.b>, qn2.b {

    /* renamed from: d, reason: collision with root package name */
    private IFaceDecoder f283673d;

    /* renamed from: e, reason: collision with root package name */
    protected qn2.c f283674e;

    public n(IFaceDecoder iFaceDecoder) {
        this.f283673d = iFaceDecoder;
        this.f283674e = g(iFaceDecoder);
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        am.n(view, i3, x.d(vVar), x.h(vVar), String.valueOf(vVar.hashCode()), vVar.h());
    }

    @Override // qn2.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(v vVar, sn2.b bVar) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.search.model.x xVar = (com.tencent.mobileqq.search.model.x) vVar;
        j(bVar, xVar);
        int n3 = xVar.n();
        List<sn2.c> e16 = bVar.e();
        if (e16 != null) {
            List<y> o16 = xVar.o();
            if (o16 != null) {
                int i3 = 0;
                while (true) {
                    boolean z18 = true;
                    if (i3 < e16.size()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i3 < o16.size()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    boolean z19 = z16 & z17;
                    if (i3 >= n3) {
                        z18 = false;
                    }
                    if (!z19 || !z18) {
                        break;
                    }
                    e16.get(i3).getView().setVisibility(0);
                    e16.get(i3).getView().setTag(R.id.kxb, o16.get(i3));
                    e16.get(i3).getView().setTag(R.id.kxg, e16.get(i3));
                    e16.get(i3).getView().setTag(R.id.kxc, Integer.valueOf(i3));
                    e16.get(i3).getView().setTag(R.id.kxa, Integer.valueOf(e16.size()));
                    e16.get(i3).getView().setTag(R.id.kxd, this.f283674e);
                    this.f283674e.a(o16.get(i3), e16.get(i3));
                    qn2.c cVar = this.f283674e;
                    if (cVar instanceof qn2.b) {
                        ((qn2.b) cVar).b(o16.get(i3), e16.get(i3).getView(), i3, xVar.e() + i3);
                    }
                    i3++;
                }
                for (int min = Math.min(o16.size(), n3); min < e16.size(); min++) {
                    e16.get(min).getView().setVisibility(8);
                }
            } else {
                for (int i16 = 0; i16 < e16.size(); i16++) {
                    e16.get(i16).getView().setVisibility(8);
                }
            }
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
    }

    public qn2.c e() {
        return this.f283674e;
    }

    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new qn2.f(iFaceDecoder);
    }

    protected qn2.c<y, sn2.c> h(IFaceDecoder iFaceDecoder, int i3) {
        return new b(iFaceDecoder, i3);
    }

    protected qn2.c<y, sn2.c> i(IFaceDecoder iFaceDecoder, boolean z16) {
        if (!z16) {
            return g(iFaceDecoder);
        }
        return new c(iFaceDecoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(sn2.b bVar, com.tencent.mobileqq.search.model.x xVar) {
        if (bVar.b() != null) {
            bVar.b().setText(xVar.l());
        }
    }

    public n(IFaceDecoder iFaceDecoder, boolean z16) {
        this.f283673d = iFaceDecoder;
        this.f283674e = i(iFaceDecoder, z16);
    }

    public n(IFaceDecoder iFaceDecoder, int i3) {
        this.f283673d = iFaceDecoder;
        this.f283674e = h(iFaceDecoder, i3);
    }
}
