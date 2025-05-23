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
import com.tencent.mobileqq.search.model.z;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends n {
    public e(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    @Override // com.tencent.mobileqq.search.presenter.n, qn2.d
    /* renamed from: d */
    public void a(v vVar, sn2.b bVar) {
        List<y> o16;
        int i3;
        x xVar = (x) vVar;
        LinearLayout a16 = ((io2.a) bVar).a();
        if (a16 != null && (o16 = xVar.o()) != null) {
            a16.removeAllViews();
            int min = Math.min(o16.size(), xVar.n());
            for (int i16 = 0; i16 < min; i16++) {
                y yVar = o16.get(i16);
                View inflate = LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxw, (ViewGroup) null);
                io2.b bVar2 = new io2.b(inflate);
                inflate.setTag(R.id.kxb, yVar);
                inflate.setTag(R.id.kxg, bVar2);
                inflate.setTag(R.id.kxc, Integer.valueOf(i16));
                inflate.setTag(R.id.kxa, Integer.valueOf(o16.size()));
                inflate.setTag(R.id.kxd, this.f283674e);
                rn2.k.e(yVar, min, i16);
                int p16 = yVar.p();
                int q16 = yVar.q();
                if (yVar instanceof z) {
                    i3 = ((z) yVar).f283548i;
                } else {
                    i3 = 0;
                }
                rn2.k.b(p16, q16, inflate, i3);
                a16.addView(inflate);
                this.f283674e.a(yVar, bVar2);
            }
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.presenter.n
    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new f(iFaceDecoder);
    }
}
