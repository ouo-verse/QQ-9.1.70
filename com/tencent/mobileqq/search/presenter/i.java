package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends n {
    public i(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    @Override // com.tencent.mobileqq.search.presenter.n, qn2.d
    /* renamed from: d */
    public void a(v vVar, sn2.b bVar) {
        int i3;
        x xVar = (x) vVar;
        j(bVar, xVar);
        int n3 = xVar.n();
        List<sn2.c> e16 = bVar.e();
        if (e16 != null) {
            List<y> o16 = xVar.o();
            if (o16 != null) {
                int min = Math.min(Math.min(e16.size(), o16.size()), n3);
                for (int i16 = 0; i16 < min; i16++) {
                    e16.get(i16).getView().setVisibility(0);
                    e16.get(i16).getView().setTag(R.id.kxb, o16.get(i16));
                    e16.get(i16).getView().setTag(R.id.kxg, e16.get(i16));
                    e16.get(i16).getView().setTag(R.id.kxc, Integer.valueOf(i16));
                    e16.get(i16).getView().setTag(R.id.kxa, Integer.valueOf(e16.size()));
                    e16.get(i16).getView().setTag(R.id.kxd, this.f283674e);
                    rn2.k.e(o16.get(i16), min, i16);
                    int p16 = o16.get(i16).p();
                    int q16 = o16.get(i16).q();
                    View view = e16.get(i16).getView();
                    if (o16.get(i16) instanceof z) {
                        i3 = ((z) o16.get(i16)).f283548i;
                    } else {
                        i3 = 0;
                    }
                    rn2.k.b(p16, q16, view, i3);
                    this.f283674e.a(o16.get(i16), e16.get(i16));
                }
                for (int min2 = Math.min(o16.size(), n3); min2 < e16.size(); min2++) {
                    e16.get(min2).getView().setVisibility(8);
                }
            } else {
                for (int i17 = 0; i17 < e16.size(); i17++) {
                    e16.get(i17).getView().setVisibility(8);
                }
            }
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.presenter.n
    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new j(iFaceDecoder);
    }
}
