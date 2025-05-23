package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class ContactSearchResultGroupPresenter extends n {
    public ContactSearchResultGroupPresenter(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    private void k(final sn2.b bVar, final int i3, final LinearLayout linearLayout, final List<y> list, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < i3; i17++) {
                    arrayList.add(LayoutInflater.from(bVar.getView().getContext()).inflate(R.layout.bxo, (ViewGroup) null));
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18;
                        StringBuilder sb5 = new StringBuilder();
                        linearLayout.removeAllViews();
                        for (int i19 = 0; i19 < i3; i19++) {
                            View view = (View) arrayList.get(i19);
                            y yVar = (y) list.get(i19);
                            yn2.c cVar = new yn2.c(view);
                            view.setTag(R.id.kxb, yVar);
                            view.setTag(R.id.kxg, cVar);
                            view.setTag(R.id.kxc, Integer.valueOf(i19));
                            view.setTag(R.id.kxa, Integer.valueOf(list.size()));
                            view.setTag(R.id.kxd, ContactSearchResultGroupPresenter.this.f283674e);
                            com.tencent.mobileqq.troop.blocktroop.k.G(view, 1, yVar.getUin(), 2);
                            rn2.k.e(yVar, i3, i19);
                            int p16 = yVar.p();
                            int q16 = yVar.q();
                            if (yVar instanceof z) {
                                i18 = ((z) yVar).f283548i;
                            } else {
                                i18 = 0;
                            }
                            rn2.k.b(p16, q16, view, i18);
                            linearLayout.addView(view);
                            ContactSearchResultGroupPresenter.this.f283674e.a(yVar, cVar);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            qn2.c cVar2 = ContactSearchResultGroupPresenter.this.f283674e;
                            if (cVar2 instanceof qn2.b) {
                                ((qn2.b) cVar2).b(yVar, view, i19, i16 + i19);
                            }
                            String uin = yVar.getUin();
                            if (!TextUtils.isEmpty(uin)) {
                                sb5.append(uin);
                                sb5.append(",faceType:" + yVar.k());
                                sb5.append(", itemView:");
                                sb5.append(view);
                                sb5.append(", contentView\uff1a");
                                sb5.append(cVar);
                            }
                        }
                        QLog.i("ContactSearchResultGroupPresenter_beryl", 4, sb5.toString());
                    }
                });
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.search.presenter.n, qn2.d
    /* renamed from: d */
    public void a(v vVar, sn2.b bVar) {
        x xVar = (x) vVar;
        List<y> o16 = xVar.o();
        LinearLayout j3 = ((yn2.a) bVar).j();
        if (j3 != null && o16 != null) {
            k(bVar, Math.min(o16.size(), xVar.n()), j3, o16, vVar.e());
        }
        if (bVar.getMoreView() != null) {
            bVar.getMoreView().setVisibility(8);
        }
        if (xVar instanceof do2.h) {
            y s16 = ((do2.h) xVar).s();
            sn2.c a16 = ((yn2.a) bVar).a();
            if (a16 != null) {
                if (s16 != null) {
                    a16.getView().setVisibility(0);
                    this.f283674e.a(s16, a16);
                } else {
                    a16.getView().setVisibility(8);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.search.presenter.n
    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new xn2.c(iFaceDecoder);
    }
}
