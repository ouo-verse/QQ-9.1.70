package com.tencent.mobileqq.search.presenter;

import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends qn2.f {
    public c(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (yVar instanceof ep2.d) {
            ep2.d dVar = (ep2.d) yVar;
            ao2.a aVar = (ao2.a) cVar;
            TextView r16 = aVar.r();
            TextView q16 = aVar.q();
            TextView p16 = aVar.p();
            boolean z16 = false;
            if (r16 != null) {
                CharSequence H = dVar.H();
                if (H == null) {
                    r16.setText("");
                    if (p16 != null) {
                        p16.setVisibility(8);
                    }
                } else {
                    r16.setText(H);
                    if (p16 != null) {
                        p16.setVisibility(0);
                    }
                }
            }
            if (q16 != null) {
                CharSequence G = dVar.G();
                if (G == null) {
                    q16.setText("");
                } else {
                    q16.setText(G);
                }
            }
            if ((yVar instanceof vn2.b) && ((vn2.b) yVar).getSearchChatSummaryItem().getMsgCount() > 1) {
                z16 = true;
            }
            if (z16) {
                rn2.j.f431768a.h(aVar.k());
                return;
            } else {
                rn2.j.f431768a.l(aVar.k());
                return;
            }
        }
        if (yVar instanceof ep2.c) {
            ep2.c cVar2 = (ep2.c) yVar;
            ao2.a aVar2 = (ao2.a) cVar;
            TextView o16 = aVar2.o();
            rn2.j.f431768a.l(aVar2.c());
            if (o16 != null) {
                CharSequence H2 = cVar2.H();
                if (H2 == null) {
                    o16.setText("");
                } else {
                    o16.setText(H2);
                }
            }
        }
    }
}
