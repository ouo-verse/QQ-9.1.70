package com.tencent.mobileqq.vasgift.mvvm.business.anim;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.GiftBannerContainer;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.d;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import qh2.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SingleBannerGiftAnimationEngineImpl extends com.tencent.mobileqq.vasgift.mvvm.business.anim.a implements e, d {
    public static LinkedHashMap<String, com.tencent.mobileqq.qqgift.mvvm.business.anim.a> N = new LinkedHashMap() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.SingleBannerGiftAnimationEngineImpl.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            if (size() > 20) {
                return true;
            }
            return false;
        }
    };
    private final Map<String, com.tencent.mobileqq.qqgift.mvvm.business.anim.a> D;
    private final Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> E;
    private final Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> F;
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a G;
    private boolean H;
    private boolean I;
    private boolean J;
    private GiftBannerContainer K;
    private int L;
    private final com.tencent.mobileqq.vasgift.utils.a M;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements th2.a {

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.mobileqq.vasgift.mvvm.business.view.a f311692a = null;

        a() {
        }

        @Override // th2.a
        public sh2.a a(Context context, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            if (!aVar.f264930u && aVar.f264929t) {
                if (this.f311692a == null) {
                    this.f311692a = new com.tencent.mobileqq.vasgift.mvvm.business.view.a(context);
                }
                return this.f311692a;
            }
            return null;
        }
    }

    public SingleBannerGiftAnimationEngineImpl(Context context, nh2.c cVar) {
        super(context, cVar);
        this.D = new HashMap();
        this.E = new Vector<>();
        this.F = new Vector<>();
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = 0;
        this.M = new com.tencent.mobileqq.vasgift.utils.a();
    }

    private void o(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData dataType:" + r(aVar));
        if (u(aVar)) {
            String s16 = s(aVar);
            if (s16.equals(s(this.G))) {
                int i16 = aVar.f264926q;
                if (i16 > this.G.f264926q) {
                    if (this.K.t(i16)) {
                        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData but just update playing num");
                        return;
                    }
                    QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData and update playing num failed");
                } else {
                    QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData but playingNum is big");
                    return;
                }
            }
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.D.get(s16);
            if (aVar2 != null) {
                aVar2.f264926q = Math.max(aVar.f264926q, aVar2.f264926q);
                QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData but just update waiting num");
                return;
            }
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar3 = N.get(s16);
            if (aVar3 != null) {
                int i17 = aVar3.f264926q;
                if (i17 >= aVar.f264926q) {
                    QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to addData but complete is big");
                    return;
                }
                aVar.f264928s = i17 + 1;
                this.D.put(s16, aVar);
                p(aVar, i3, this.E);
                QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "addData to high priority and origNum:" + aVar.f264928s);
                return;
            }
            this.D.put(s16, aVar);
        }
        if (t(aVar)) {
            QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "addData to high queue");
            p(aVar, i3, this.E);
            Collections.sort(this.E, this.M);
        } else {
            QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "addData to normal queue");
            p(aVar, i3, this.F);
        }
        if (v(aVar)) {
            y();
        }
    }

    private void p(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3, Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> vector) {
        if (i3 >= 0 && i3 <= vector.size()) {
            vector.add(i3, aVar);
        } else {
            vector.add(aVar);
        }
    }

    private void q(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.G) {
            QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "checkDismissBanner but data not match");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "checkNeedDismissBanner " + this.I + "::" + this.J);
        }
        if (aVar.f264911b == 0) {
            x();
            return;
        }
        if (aVar.f264924o == 1) {
            if (this.J) {
                if (this.I) {
                    this.K.l();
                    return;
                } else {
                    if (!this.H) {
                        QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "banner is over but giftAnimation is not start");
                        this.f311694d.u();
                        this.K.l();
                        return;
                    }
                    return;
                }
            }
            if (this.I && aVar.f264931v) {
                QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "checkNeedDismissBanner isGiftAnimationOver and isOnlyShowEffectAnim.");
                x();
                return;
            }
            return;
        }
        N.put(s(aVar), aVar);
        this.K.l();
    }

    private String r(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        return "dataType\uff1a" + aVar.f264911b + " level:" + aVar.f264924o + " origNum:" + aVar.f264928s + " num:" + aVar.f264926q;
    }

    private String s(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar == null) {
            return "";
        }
        return "" + aVar.f264918i + aVar.f264920k + aVar.f264925p;
    }

    private boolean t(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264916g == 100) {
            return true;
        }
        return false;
    }

    private boolean u(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264911b == 1 && aVar.f264924o == 0 && aVar.f264926q > 0) {
            return true;
        }
        return false;
    }

    private boolean v(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.G;
        if (aVar2 != null && aVar2.f264916g != 100 && aVar.f264916g == 100) {
            return true;
        }
        return false;
    }

    private void w(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264926q == 0) {
            aVar.f264926q = 1;
        }
        this.I = false;
        this.J = false;
        this.H = false;
        this.G = aVar;
        if (aVar.f264911b == 0) {
            this.f311694d.m(aVar);
            return;
        }
        if (aVar.f264924o == 1) {
            this.f311694d.m(aVar);
        }
        if (!aVar.f264931v) {
            this.K.o(aVar, aVar.f264928s);
        }
    }

    private void x() {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar;
        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "onPlayEnd " + r(this.G));
        if (this.E.size() > 0) {
            aVar = this.E.remove(0);
        } else if (this.F.size() > 0) {
            aVar = this.F.remove(0);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "play next: " + r(aVar));
            this.D.remove(s(aVar));
            this.L = 1;
            w(aVar);
            return;
        }
        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "queue is play complete");
        this.L = 0;
    }

    private void y() {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.G;
        if (aVar != null && this.L != 2) {
            this.L = 2;
            if (aVar.f264911b != 0) {
                if (aVar.f264924o == 0) {
                    this.K.s();
                    return;
                } else {
                    this.K.s();
                    this.f311694d.u();
                    return;
                }
            }
            this.f311694d.u();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public View b() {
        return this.K;
    }

    @Override // qh2.e
    public synchronized void c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.G) {
            QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "giftAnimation end but data not match");
            return;
        }
        this.f311694d.setVisibility(4);
        this.I = true;
        q(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ void d(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        super.d(aVar);
    }

    @Override // qh2.e
    public void e(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.G) {
            QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "giftAnimation start but data not match");
        }
        this.f311694d.setVisibility(0);
        this.H = true;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ sh2.a f(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        return super.f(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public synchronized void g(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        if (aVar != this.G) {
            QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "bannerAnimation end but data not match");
        } else {
            this.J = true;
            q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public synchronized void h(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.G) {
            QLog.e("SingleBannerGiftAnimationEngineImpl", 1, "bannerAnimation start but data not match");
        }
        this.J = false;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ View i() {
        return super.i();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.d
    public synchronized void j() {
        x();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ View k() {
        return super.k();
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public synchronized void l(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2;
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.ADD_GIFT_ANIM, String.valueOf(aVar.f264910a));
        if (this.f311699m) {
            return;
        }
        if (this.L != 0) {
            o(aVar, i3);
        } else {
            if (u(aVar) && (aVar2 = N.get(s(aVar))) != null) {
                if (aVar2.f264926q >= aVar.f264926q) {
                    QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to play but hitSeq is over");
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "try to play hitSeq is old updateOriginalNum");
                    }
                    aVar.f264928s = aVar2.f264926q + 1;
                }
            }
            this.L = 1;
            QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "startPlay " + r(aVar));
            w(aVar);
        }
        VasLogReporter.getVasGift().report("addGiftAnimation index=" + i3 + "," + aVar, VasLogReportProxy.LEVEL.HIGHEST);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ nh2.c m() {
        return super.m();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a
    public /* bridge */ /* synthetic */ void n(th2.a aVar) {
        super.n(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public void prepare() {
        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "prepare");
        super.prepare();
        if (this.f311697h == null) {
            return;
        }
        BannerResManager y16 = BannerResManager.y(this.f311696f.b());
        y16.G(this.f311696f.getSDKConfig());
        GiftBannerContainer giftBannerContainer = new GiftBannerContainer(this.f311697h, y16);
        this.K = giftBannerContainer;
        giftBannerContainer.setBannerListener(this);
        this.f311694d.r(this);
        n(new a());
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public synchronized void release() {
        reset();
        super.release();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public synchronized void reset() {
        QLog.i("SingleBannerGiftAnimationEngineImpl", 1, "reset");
        super.reset();
        this.F.clear();
        this.E.clear();
        this.D.clear();
        QQGiftView qQGiftView = this.f311694d;
        if (qQGiftView != null) {
            qQGiftView.u();
        }
        this.K.s();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.d
    public void a() {
    }
}
