package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.view.q;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends n {
    public g(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    @Override // com.tencent.mobileqq.search.presenter.n, qn2.d
    /* renamed from: d */
    public void a(v vVar, sn2.b bVar) {
        List<y> o16;
        View view;
        Object obj;
        x xVar = (x) vVar;
        LinearLayout a16 = ((jo2.a) bVar).a();
        if (a16 != null && (o16 = xVar.o()) != null) {
            a16.removeAllViews();
            int min = Math.min(o16.size(), 3);
            for (int i3 = 0; i3 < min; i3++) {
                y yVar = o16.get(i3);
                if (yVar instanceof com.tencent.mobileqq.search.model.k) {
                    com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) yVar;
                    View view2 = null;
                    if (com.tencent.mobileqq.search.util.m.a(kVar.H()) == 1) {
                        view2 = LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxo, (ViewGroup) null);
                        view = view2.findViewById(R.id.dpr);
                        obj = new yn2.c(view2);
                    } else if (com.tencent.mobileqq.search.util.m.a(kVar.H()) == 2) {
                        view2 = LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxw, (ViewGroup) null);
                        view = view2.findViewById(R.id.dpr);
                        obj = new io2.b(view2);
                    } else {
                        view = null;
                        obj = null;
                    }
                    if (view2 != null && view != null) {
                        view2.setTag(R.id.kxb, kVar);
                        view2.setTag(R.id.kxg, obj);
                        view2.setTag(R.id.kxc, Integer.valueOf(i3));
                        view2.setTag(R.id.kxa, Integer.valueOf(o16.size()));
                        view2.setTag(R.id.kxd, this.f283674e);
                        com.tencent.mobileqq.troop.blocktroop.k.G(view2, kVar.M(), kVar.getUin(), 1);
                        rn2.k.e(kVar, min, i3);
                        rn2.k.b(kVar.p(), kVar.q(), view2, kVar.f283548i);
                        a16.addView(view2);
                        this.f283674e.a(kVar, obj);
                        qn2.c cVar = this.f283674e;
                        if (cVar instanceof qn2.b) {
                            ((qn2.b) cVar).b(kVar, view2, i3, vVar.e() + i3);
                        }
                    } else {
                        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + kVar.H());
                    }
                } else if (yVar instanceof lo2.c) {
                    lo2.c cVar2 = (lo2.c) yVar;
                    q qVar = new q(a16, cVar2.J());
                    View view3 = qVar.getView();
                    view3.setTag(R.id.kxb, cVar2);
                    view3.setTag(R.id.kxg, qVar);
                    view3.setTag(R.id.kxc, Integer.valueOf(i3));
                    view3.setTag(R.id.kxa, Integer.valueOf(o16.size()));
                    view3.setTag(R.id.kxd, this.f283674e);
                    rn2.k.e(cVar2, min, i3);
                    a16.addView(qVar.getView(), new LinearLayout.LayoutParams(-1, -2));
                    this.f283674e.a(cVar2, qVar);
                    qn2.c cVar3 = this.f283674e;
                    if (cVar3 instanceof qn2.b) {
                        ((qn2.b) cVar3).b(cVar2, view3, i3, vVar.e() + i3);
                    }
                } else {
                    QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
                }
            }
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.presenter.n
    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new h(iFaceDecoder);
    }
}
