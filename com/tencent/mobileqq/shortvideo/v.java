package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v implements Comparable<v> {
    public p C;
    public ArrayList<p> D;
    public ab E;
    public MessageForShortVideo F;
    public int G;
    public int H;
    public boolean J;
    public ad K;
    public int L;
    public String[] M;
    public long N;

    /* renamed from: e, reason: collision with root package name */
    public int f288265e;

    /* renamed from: h, reason: collision with root package name */
    public String f288267h;

    /* renamed from: i, reason: collision with root package name */
    public n f288268i;

    /* renamed from: m, reason: collision with root package name */
    public aa f288269m;

    /* renamed from: d, reason: collision with root package name */
    public int f288264d = -1;
    public int I = 201;

    /* renamed from: f, reason: collision with root package name */
    public String f288266f = com.tencent.mobileqq.pic.p.i();

    public void c(n nVar) {
        int i3;
        if (nVar == null) {
            com.tencent.mobileqq.pic.f.c("PIC_TAG_ERROR", this.f288266f, "bindReqObj", "downInfo == null");
            return;
        }
        nVar.f288040c = this.f288265e;
        this.f288268i = nVar;
        int i16 = nVar.f288195s;
        if (i16 == 1002) {
            i3 = 7;
        } else if (i16 == 1006) {
            i3 = 18;
        } else if (i16 == 1004) {
            i3 = 16;
        } else {
            if (i16 != 1001) {
                if (i16 == 1005) {
                    i3 = 17;
                } else if (i16 == 1003) {
                    i3 = 9;
                } else if (i16 == 1008) {
                    i3 = 68;
                } else if (i16 == 1007) {
                    i3 = 67;
                }
            }
            i3 = 6;
        }
        this.f288267h = com.tencent.mobileqq.pic.f.a(nVar.f288041d, 0, i3);
    }

    public void d(p pVar) {
        if (pVar == null) {
            com.tencent.mobileqq.pic.f.c("PIC_TAG_ERROR", this.f288266f, "bindReqObj", "forwardInfo == null");
            return;
        }
        pVar.f288040c = this.f288265e;
        this.C = pVar;
        this.f288267h = com.tencent.mobileqq.pic.f.a(pVar.f288041d, 2, 20);
    }

    public void e(aa aaVar) {
        if (aaVar == null) {
            com.tencent.mobileqq.pic.f.c("PIC_TAG_ERROR", this.f288266f, "bindReqObj", "upInfo == null");
            return;
        }
        aaVar.f288040c = this.f288265e;
        this.f288269m = aaVar;
        int i3 = aaVar.f288041d;
        int i16 = 6;
        if (i3 != 0) {
            if (i3 == 3000) {
                i16 = 17;
            } else if (i3 == 1) {
                i16 = 9;
            }
        }
        this.f288267h = com.tencent.mobileqq.pic.f.a(i3, 1, i16);
    }

    public void f(ArrayList<p> arrayList) {
        this.D = arrayList;
    }

    public void g(MessageForShortVideo messageForShortVideo) {
        this.F = messageForShortVideo;
    }

    public void h(ab abVar) {
        this.E = abVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        int i3 = this.I;
        int i16 = vVar.I;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }
}
