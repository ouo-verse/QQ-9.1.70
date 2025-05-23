package com.tencent.now.pkgame.pkgame.pktoprank;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.bc;
import g55.g;
import g55.s;
import java.math.BigDecimal;
import java.util.ArrayList;
import kotlin.Triple;

/* loaded from: classes22.dex */
public class PkTopRankViewModel extends mo3.d {
    private e E;
    private Triple<com.tencent.now.pkgame.pkgame.pktoprank.a, com.tencent.now.pkgame.pkgame.pktoprank.a, Integer> F;

    /* renamed from: m, reason: collision with root package name */
    private Context f339052m;
    private com.tencent.now.pkgame.pkgame.pktoprank.a C = new com.tencent.now.pkgame.pkgame.pktoprank.a();
    private com.tencent.now.pkgame.pkgame.pktoprank.a D = new com.tencent.now.pkgame.pkgame.pktoprank.a();
    protected MutableLiveData<Triple<com.tencent.now.pkgame.pkgame.pktoprank.a, com.tencent.now.pkgame.pkgame.pktoprank.a, Integer>> G = new MutableLiveData<>();
    protected MutableLiveData<Boolean> H = new MutableLiveData<>();
    private boolean I = false;
    private Runnable J = new Runnable() { // from class: com.tencent.now.pkgame.pkgame.pktoprank.PkTopRankViewModel.2
        @Override // java.lang.Runnable
        public void run() {
            PkTopRankViewModel pkTopRankViewModel = PkTopRankViewModel.this;
            pkTopRankViewModel.G.postValue(pkTopRankViewModel.F);
        }
    };
    private Runnable K = new Runnable() { // from class: com.tencent.now.pkgame.pkgame.pktoprank.PkTopRankViewModel.3
        @Override // java.lang.Runnable
        public void run() {
            PkTopRankViewModel.this.H.postValue(Boolean.TRUE);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements ko3.c<s> {
        a() {
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(s sVar) {
            PkTopRankViewModel.this.f2(sVar);
        }

        @Override // ko3.c
        public void fail(int i3, String str) {
            AegisLogger.e("PK_Biz|PkTopRankViewModel", "fetchContributeList", "fail, code:" + i3 + ", msg:" + str);
        }
    }

    /* loaded from: classes22.dex */
    class b implements com.tencent.now.pkgame.pkgame.pklib.model.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f339054a;

        b(e eVar) {
            this.f339054a = eVar;
        }

        @Override // com.tencent.now.pkgame.pkgame.pklib.model.b
        public void a() {
            PkTopRankViewModel pkTopRankViewModel = PkTopRankViewModel.this;
            e eVar = this.f339054a;
            pkTopRankViewModel.X1(eVar, eVar.h(), 3);
        }
    }

    private com.tencent.now.pkgame.pkgame.pktoprank.a U1(g gVar) {
        com.tencent.now.pkgame.pkgame.pktoprank.a aVar = new com.tencent.now.pkgame.pkgame.pktoprank.a();
        aVar.k(gVar.f401364a.f401359b);
        aVar.h(Z1(gVar.f401364a.f401359b));
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            bc[] bcVarArr = gVar.f401365b;
            if (i3 < bcVarArr.length) {
                arrayList.add(bcVarArr[i3]);
                i3++;
            } else {
                aVar.g(arrayList);
                return aVar;
            }
        }
    }

    private int b2(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                return 3;
            }
        }
        return i16;
    }

    private g d2(g gVar) {
        g gVar2;
        g55.e eVar;
        bc[] bcVarArr;
        if (gVar != null) {
            gVar2 = gVar;
        } else {
            gVar2 = new g();
        }
        if (gVar != null && (bcVarArr = gVar.f401365b) != null) {
            gVar2.f401365b = bcVarArr;
        } else {
            gVar2.f401365b = new bc[0];
        }
        if (gVar != null && (eVar = gVar.f401364a) != null) {
            gVar2.f401364a = eVar;
        } else {
            gVar2.f401364a = new g55.e();
        }
        return gVar2;
    }

    private s e2(s sVar) {
        s sVar2 = new s();
        sVar2.f401387b = d2(sVar.f401387b);
        sVar2.f401388c = d2(sVar.f401388c);
        return sVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(s sVar) {
        if (this.I) {
            QLog.i("PK_Biz|PkTopRankViewModel", 1, "\u5df2\u7ecfreset\uff0c \u4e0d\u9700\u8981\u5904\u7406\u8d21\u732e\u699c\u6570\u636e");
            return;
        }
        s e26 = e2(sVar);
        com.tencent.now.pkgame.pkgame.pktoprank.a U1 = U1(e26.f401387b);
        this.C = U1;
        U1.l(this.f339052m.getString(R.string.f224066hx));
        com.tencent.now.pkgame.pkgame.pktoprank.a U12 = U1(e26.f401388c);
        this.D = U12;
        U12.l(this.f339052m.getString(R.string.f224076hy));
        int i26 = i2(this.C, this.D);
        W1(this.C);
        W1(this.D);
        this.F = new Triple<>(this.C, this.D, Integer.valueOf(i26));
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.J, 1000L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.K, 7000L);
    }

    @Override // mo3.d
    public void M1() {
        super.M1();
        g2();
    }

    @Override // mo3.d
    public void O1() {
        super.O1();
        g2();
    }

    @Override // mo3.d
    public void R1(e eVar) {
        super.R1(eVar);
        this.E = eVar;
        this.I = false;
        eVar.c(new b(eVar));
    }

    @VisibleForTesting
    protected void W1(com.tencent.now.pkgame.pkgame.pktoprank.a aVar) {
        int size = aVar.a().size();
        int i3 = 3 - size;
        for (int i16 = 0; i16 < i3; i16++) {
            bc bcVar = new bc();
            bcVar.f401355c = b2(size + i16 + 1);
            aVar.a().add(bcVar);
        }
    }

    public void X1(e eVar, long j3, int i3) {
        eVar.e(i3, new a());
    }

    @VisibleForTesting
    protected String Z1(long j3) {
        String string = this.f339052m.getString(R.string.f13569025);
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        return String.format(string, new BigDecimal((((float) j3) * 1.0f) / 10000.0f).setScale(1, 1).toString());
    }

    public LiveData<Boolean> a2() {
        return this.H;
    }

    public LiveData<Triple<com.tencent.now.pkgame.pkgame.pktoprank.a, com.tencent.now.pkgame.pkgame.pktoprank.a, Integer>> c2() {
        return this.G;
    }

    protected void g2() {
        this.I = true;
        this.G = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.J);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.K);
    }

    public void h2(Context context) {
        this.f339052m = context;
    }

    public int i2(com.tencent.now.pkgame.pkgame.pktoprank.a aVar, com.tencent.now.pkgame.pkgame.pktoprank.a aVar2) {
        int i3;
        QLog.i("PK_Biz|PkTopRankViewModel", 1, "left: " + aVar.e() + ", right: " + aVar2.e());
        if (aVar.e() == aVar2.e()) {
            aVar.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDXC9pkh5whbLk26JcFrWxh7dVazThCrbCpNvHiaEjRhcw/", (URLDrawable.URLDrawableOptions) null));
            aVar.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLCKgL9CZLNNZ1d9nIoROQmPicMk2sjKCticdgXNnFTptQtA/", (URLDrawable.URLDrawableOptions) null));
            aVar2.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLCDINRTdmTqU7zgVI2krEpy0hLy4f0cicguHPhdTmib8Ftg/", (URLDrawable.URLDrawableOptions) null));
            aVar2.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIbOoKGb80LNoTHDQ9Q35wlZ7icRMRTm2ucNuUh5pErClQ/", (URLDrawable.URLDrawableOptions) null));
            i3 = 0;
        } else if (aVar.e() > aVar2.e()) {
            aVar.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKrDAmW5QuB4FvEvAeiaNTG1fErqjQAHFajl7Ba982bxAw/", (URLDrawable.URLDrawableOptions) null));
            aVar.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLCKgL9CZLNNZ1d9nIoROQmPicMk2sjKCticdgXNnFTptQtA/", (URLDrawable.URLDrawableOptions) null));
            aVar2.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/Q3auHgzwzM429XssL951gUMqQbcRAqVutXeI0EbBMNfbkatFfwZ6BA/", (URLDrawable.URLDrawableOptions) null));
            aVar2.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLB246Xe4BQlaFM30n8ibTLicOQaxr2PV5G3rsOZyxS7VC6g/", (URLDrawable.URLDrawableOptions) null));
            i3 = 1;
        } else {
            aVar.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIZkIE5KicDGebPAcUFNpgF7haX9HrfbJwG0dEFW0hTjAw/", (URLDrawable.URLDrawableOptions) null));
            aVar.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLB246Xe4BQlaFM30n8ibTLicOQaxr2PV5G3rsOZyxS7VC6g/", (URLDrawable.URLDrawableOptions) null));
            aVar2.i(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaELVITDdAAyV2rtQvH6Y6s1WicRBJtls9lH4nARvLpjVcWQ/", (URLDrawable.URLDrawableOptions) null));
            aVar2.j(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIbOoKGb80LNoTHDQ9Q35wlZ7icRMRTm2ucNuUh5pErClQ/", (URLDrawable.URLDrawableOptions) null));
            i3 = 2;
        }
        QLog.i("PK_Biz|PkTopRankViewModel", 1, "pk game ends: result=" + i3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        g2();
    }
}
