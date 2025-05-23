package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.search.view.q;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends n {
    public d(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder, 268435456);
    }

    @Override // com.tencent.mobileqq.search.presenter.n, qn2.d
    /* renamed from: d */
    public void a(v vVar, sn2.b bVar) {
        List<y> o16;
        x xVar = (x) vVar;
        bo2.a aVar = (bo2.a) bVar;
        LinearLayout a16 = aVar.a();
        if (a16 != null && (o16 = xVar.o()) != null) {
            a16.removeAllViews();
            int min = Math.min(o16.size(), xVar.n());
            for (int i3 = 0; i3 < min; i3++) {
                q qVar = new q(aVar.j(), 268435456);
                View view = qVar.getView();
                y yVar = o16.get(i3);
                view.setTag(R.id.kxb, yVar);
                view.setTag(R.id.kxg, qVar);
                view.setTag(R.id.kxc, Integer.valueOf(i3));
                view.setTag(R.id.kxa, Integer.valueOf(o16.size()));
                view.setTag(R.id.kxd, this.f283674e);
                if (yVar instanceof lo2.c) {
                    rn2.k.e((lo2.c) yVar, min, i3);
                }
                if (aq.a()) {
                    qVar.n(qVar.b(), R.color.qui_common_icon_primary);
                    view.findViewById(R.id.f166799ic3).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                }
                a16.addView(qVar.getView(), new LinearLayout.LayoutParams(-1, -2));
                this.f283674e.a(yVar, qVar);
                qn2.c cVar = this.f283674e;
                if (cVar instanceof qn2.b) {
                    ((qn2.b) cVar).b(yVar, view, i3, vVar.e() + i3);
                }
            }
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
    }
}
