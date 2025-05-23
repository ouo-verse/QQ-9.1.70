package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.view.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l implements qn2.d<v, sn2.b>, qn2.b {

    /* renamed from: d, reason: collision with root package name */
    private IFaceDecoder f283666d;

    /* renamed from: e, reason: collision with root package name */
    private n f283667e;

    /* renamed from: f, reason: collision with root package name */
    boolean f283668f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f283669d;

        a(x xVar) {
            this.f283669d = xVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f283669d.q(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public l(IFaceDecoder iFaceDecoder, boolean z16) {
        this.f283666d = iFaceDecoder;
        this.f283667e = new n(iFaceDecoder, z16);
        this.f283668f = z16;
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), com.tencent.mobileqq.search.util.x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
    }

    @Override // qn2.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(v vVar, sn2.b bVar) {
        View inflate;
        Object gVar;
        int i3;
        v vVar2;
        x xVar = (x) vVar;
        s sVar = (s) bVar;
        int n3 = xVar.n();
        LinearLayout a16 = sVar.a();
        char c16 = 3;
        char c17 = 2;
        char c18 = 1;
        char c19 = 0;
        if (a16 != null && a16.getTag(R.id.kxb) != null && (vVar2 = (v) a16.getTag(R.id.kxb)) == vVar) {
            QLog.d("SearchResultGroupMessagePresenter", 1, "bind same data return oldModel:", vVar2.toString(), " newModel:", vVar.toString(), " view:", Integer.valueOf(a16.hashCode()));
            return;
        }
        if (a16 != null) {
            a16.setTag(R.id.kxb, xVar);
            QLog.d("SearchResultGroupMessagePresenter", 4, "bind model:", vVar.toString(), " presenter:", Integer.valueOf(bVar.hashCode()), "", Integer.valueOf(a16.hashCode()));
            List<y> o16 = xVar.o();
            if (o16 != null && !o16.isEmpty()) {
                a16.removeAllViews();
                int min = Math.min(o16.size(), n3);
                int i16 = 0;
                while (i16 < min) {
                    y yVar = o16.get(i16);
                    Object[] objArr = new Object[8];
                    objArr[c19] = "bind item:";
                    objArr[c18] = Integer.valueOf(i16);
                    objArr[c17] = " isFts:";
                    objArr[c16] = Boolean.valueOf(this.f283668f);
                    objArr[4] = " itemModel:";
                    objArr[5] = yVar.toString();
                    objArr[6] = " presenter:";
                    objArr[7] = this.f283667e.e();
                    QLog.d("SearchResultGroupMessagePresenter", 4, objArr);
                    if (this.f283668f) {
                        inflate = LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxt, (ViewGroup) null);
                        gVar = new ao2.a(inflate);
                    } else {
                        inflate = LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxs, (ViewGroup) null);
                        gVar = new sn2.g(inflate);
                    }
                    inflate.setTag(R.id.kxb, yVar);
                    inflate.setTag(R.id.kxg, gVar);
                    inflate.setTag(R.id.kxc, Integer.valueOf(i16));
                    inflate.setTag(R.id.kxa, Integer.valueOf(o16.size()));
                    inflate.setTag(R.id.kxd, this.f283667e.e());
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
                    if (this.f283667e.e() != null) {
                        this.f283667e.e().a(o16.get(i16), gVar);
                        if (this.f283667e.e() instanceof qn2.b) {
                            ((qn2.b) this.f283667e.e()).b(yVar, inflate, i16, vVar.e() + i16);
                        }
                    }
                    i16++;
                    c16 = 3;
                    c17 = 2;
                    c18 = 1;
                    c19 = 0;
                }
            }
        }
        List<y> o17 = xVar.o();
        if (o17 != null && !o17.isEmpty()) {
            sVar.f285166i.setVisibility(8);
            return;
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
        sVar.f285166i.setVisibility(0);
        sVar.f285166i.setTag(R.id.kxc, -1);
        sVar.f285167m.setText(xVar.getKeyword());
        sVar.D.setText(HardCodeUtil.qqStr(R.string.t79));
        sVar.C.setImageResource(R.drawable.f87);
        sVar.f285166i.setOnClickListener(new a(xVar));
    }
}
