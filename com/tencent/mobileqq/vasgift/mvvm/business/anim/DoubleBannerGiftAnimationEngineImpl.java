package com.tencent.mobileqq.vasgift.mvvm.business.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.QQLiveGiftBannerContainer;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import qh2.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DoubleBannerGiftAnimationEngineImpl extends com.tencent.mobileqq.vasgift.mvvm.business.anim.a implements e, d {
    private final LinkedHashMap<String, com.tencent.mobileqq.qqgift.mvvm.business.anim.a> D;
    private final Map<String, com.tencent.mobileqq.qqgift.mvvm.business.anim.a> E;
    private final Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> F;
    private final Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> G;
    private final Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> H;
    private final Map<String, com.tencent.mobileqq.qqgift.mvvm.business.anim.a> I;
    private final com.tencent.mobileqq.vasgift.utils.a J;
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a K;
    private int L;
    private QQLiveGiftBannerContainer M;
    private QQLiveGiftBannerContainer N;
    private final th2.a P;
    private final int[] Q;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements th2.a {

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.mobileqq.vasgift.mvvm.business.view.a f311672a = null;

        a() {
        }

        @Override // th2.a
        public sh2.a a(Context context, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            if (!aVar.f264930u && aVar.f264929t) {
                if (this.f311672a == null) {
                    this.f311672a = new com.tencent.mobileqq.vasgift.mvvm.business.view.a(context);
                }
                return this.f311672a;
            }
            return null;
        }
    }

    public DoubleBannerGiftAnimationEngineImpl(Context context, nh2.c cVar) {
        super(context, cVar);
        this.D = new LinkedHashMap() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.DoubleBannerGiftAnimationEngineImpl.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry entry) {
                if (size() > 20) {
                    return true;
                }
                return false;
            }
        };
        this.E = new HashMap();
        this.F = new Vector<>();
        this.G = new Vector<>();
        this.H = new Vector<>();
        this.I = new HashMap();
        this.J = new com.tencent.mobileqq.vasgift.utils.a();
        this.L = 0;
        this.P = new a();
        this.Q = new int[]{R.drawable.f161945nm2, R.drawable.f161946nm3, R.drawable.f161947nm4, R.drawable.nm5, R.drawable.nm6, R.drawable.nm7, R.drawable.nm8, R.drawable.nm9, R.drawable.nm_, R.drawable.nma, R.drawable.nmb, R.drawable.nk6};
    }

    private boolean A(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        int i3 = aVar.f264924o;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean B(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (z(aVar) && (this.M.w(aVar) || this.N.w(aVar))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(BannerResManager bannerResManager) {
        SparseArray<Bitmap> sparseArray = new SparseArray<>();
        for (int i3 = 0; i3 < this.Q.length; i3++) {
            Drawable drawable = BaseApplication.getContext().getDrawable(this.Q[i3]);
            if (drawable instanceof BitmapDrawable) {
                sparseArray.put(i3, ((BitmapDrawable) BaseApplication.getContext().getDrawable(this.Q[i3])).getBitmap());
            } else if (drawable instanceof SkinnableBitmapDrawable) {
                sparseArray.put(i3, ((SkinnableBitmapDrawable) BaseApplication.getContext().getDrawable(this.Q[i3])).getBitmap());
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.outHeight = ImmersiveUtils.dpToPx(30.0f);
                options.outWidth = ImmersiveUtils.dpToPx(22.0f);
                sparseArray.put(i3, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), this.Q[i3], options));
            }
        }
        bannerResManager.M(11, sparseArray);
        QLog.i("DoubleBannerGiftAnimationEngineImpl", 1, "loadQQLiveBannerCustomRes for level:BANNER_CUSTOM_LEVEL1 done!");
    }

    private void D(final BannerResManager bannerResManager) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.b
            @Override // java.lang.Runnable
            public final void run() {
                DoubleBannerGiftAnimationEngineImpl.this.C(bannerResManager);
            }
        }, 64, null, true);
    }

    private void E(String str) {
        QLog.e("DoubleBannerGiftAnimationEngineImpl", 1, str);
    }

    private void F(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DoubleBannerGiftAnimationEngineImpl", 1, str);
        }
    }

    private void G(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DoubleBannerGiftAnimationEngineImpl", 1, str);
        }
    }

    private boolean H(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264916g == 100) {
            return true;
        }
        return false;
    }

    private boolean I(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if ((this.M.getCurData() != null && this.M.getCurData().f264916g < aVar.f264916g) || (this.N.getCurData() != null && this.N.getCurData().f264916g < aVar.f264916g)) {
            return true;
        }
        return false;
    }

    private boolean J(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        QQLiveGiftBannerContainer u16 = u();
        if (u16 != null) {
            F("\u65b0\u7248QQ\u76f4\u64ad\u793c\u7269\uff0c\u5148\u5c55\u793a\u98d8\u6761:" + t(aVar));
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "playBannerAnimation", "play giftAnimData for banner animation", true);
            }
            u16.y(aVar);
            return true;
        }
        E("\u5f02\u5e38\u60c5\u51b5\uff0c\u6ca1\u6709\u53ef\u7528\u7684\u98d8\u6761view");
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "playBannerAnimation", "play exception, idleBannerView = null", true);
            return false;
        }
        return false;
    }

    private void K() {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar;
        G("\u4e0a\u4e00\u4e2abanner\u52a8\u753b\u64ad\u653e\u5b8c\u6210\uff0c\u5f00\u59cb\u64ad\u653e\u4e0b\u4e00\u4e2abanner\u52a8\u753b");
        if (this.F.size() > 0) {
            aVar = this.F.remove(0);
            G("\u64ad\u653e\u9ad8\u4f18\u5148\u7ea7\u961f\u5217\u7684\u6570\u636e");
        } else if (this.G.size() > 0) {
            aVar = this.G.remove(0);
            G("\u64ad\u653e\u4e00\u822c\u4f18\u5148\u7ea7\u961f\u5217\u7684\u6570\u636e");
        } else {
            aVar = null;
        }
        if (aVar != null) {
            F("playNextBannerAnimation \u793c\u7269\u6570\u636e\uff1a" + t(aVar));
            this.E.remove(v(aVar));
            N(aVar);
            return;
        }
        F("playNextBannerAnimation\uff0c\u961f\u5217\u5747\u4e3a\u7a7a");
    }

    private void L() {
        if (this.L != 0 || this.H.size() <= 0) {
            return;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.H.get(0);
        int i3 = aVar.f264927r;
        if (i3 >= aVar.f264926q) {
            this.H.remove(aVar);
            this.I.remove(v(aVar));
            F("\u79fb\u9664\u52a8\u753b\u7b49\u5f85\u6570\u636e\uff0c" + t(aVar));
            L();
            return;
        }
        this.L = 1;
        aVar.f264927r = i3 + 1;
        this.K = aVar;
        F("\u7279\u6548\u52a8\u753b\u64ad\u653e\u4e2d\uff0c\u6b21\u6570:" + aVar.f264927r + ", " + t(aVar));
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "playNextScreenAnimation", "play giftAnimData for effect animation", true);
        }
        this.f311694d.m(aVar);
    }

    private void M(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264911b == 0) {
            x();
            return;
        }
        w();
        if (aVar.f264924o != 0) {
            x();
        }
    }

    private boolean N(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264926q == 0) {
            aVar.f264926q = 1;
        }
        F("\u64ad\u653e\u4e2d\uff0c\u793c\u7269\u4fe1\u606f:" + t(aVar));
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "startPlayGiftAnim", "", true);
        }
        if (aVar.f264911b != 0 && !aVar.f264931v) {
            return J(aVar);
        }
        F("\u53ea\u64ad\u653e\u7279\u6548\u52a8\u753b:" + t(aVar));
        s(aVar);
        return true;
    }

    private boolean O(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (this.f311699m) {
            return false;
        }
        if (!this.M.I(aVar) && !this.N.I(aVar)) {
            return false;
        }
        return true;
    }

    private void p(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        F("\u5f00\u59cb\u6dfb\u52a0\u6570\u636e\u5230\u793c\u7269\u961f\u5217:" + t(aVar));
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "", true);
        }
        if (z(aVar)) {
            if (O(aVar)) {
                F("\u76f4\u63a5\u66f4\u65b0\u961f\u5217\u91cc\u6570\u636e\u7684\u8fde\u51fb\u6570\uff0c\u4e0d\u518d\u91cd\u590d\u6dfb\u52a0\u6570\u636e:" + t(aVar));
                if (aVar.a()) {
                    AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "updateBannerHitNum", true);
                    return;
                }
                return;
            }
            String v3 = v(aVar);
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.E.get(v3);
            if (aVar2 != null) {
                aVar2.f264926q = Math.max(aVar.f264926q, aVar2.f264926q);
                F("\u7b49\u5f85\u961f\u5217\u6709\u76f8\u540c\u5e8f\u5217\u7684\u6570\u636e\uff0c\u66f4\u65b0\u7b49\u5f85\u961f\u5217\u6570\u636e:" + t(aVar));
                if (aVar.a()) {
                    AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "update waitAllHitNum", true);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar3 = this.D.get(v3);
            if (aVar3 != null) {
                int i16 = aVar3.f264926q;
                if (i16 >= aVar.f264926q) {
                    F("\u8be5\u6279\u6b21\u7684\u6570\u636e\u5df2\u7ecf\u64ad\u653e\u8fc7\uff0c\u64ad\u653e\u8fc7\u7684\u8fde\u51fb\u6570\u6bd4\u65b0\u6570\u636e\u5927.completeData:" + t(aVar3) + ", newData:" + t(aVar));
                    if (aVar.a()) {
                        AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "curAllHitNum >= recvAllHitNum, give up recvAllHitNum", true);
                        return;
                    }
                    return;
                }
                aVar.f264928s = i16 + 1;
                this.E.put(v3, aVar);
                q(aVar, i3, this.F);
                F("\u8be5\u6279\u6b21\u7684\u6570\u636e\u5df2\u7ecf\u64ad\u653e\u8fc7\uff0c\u5c5e\u4e8e\u8054\u673a\u4e2d\u65ad\u6570\u636e\uff0c\u9700\u8981\u66f4\u65b0\u8fde\u51fb\u6570.completeData:" + t(aVar3) + ", newData:" + t(aVar));
                if (aVar.a()) {
                    AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "waitAllHitNum +1", true);
                    return;
                }
                return;
            }
            this.E.put(v3, aVar);
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "add giftAnimData to waitingDataMap", true);
            }
        }
        if (H(aVar)) {
            F("\u9ad8\u4f18\u5148\u7ea7\u793c\u7269\uff0c\u6570\u636e\u52a0\u5165\u9ad8\u4f18\u5148\u7ea7\u961f\u5217:" + t(aVar));
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "add giftAnimData to highPriorityQueue", true);
            }
            q(aVar, i3, this.F);
            Collections.sort(this.F, this.J);
        } else {
            F("\u4e00\u822c\u4f18\u5148\u7ea7\u793c\u7269\uff0c\u6570\u636e\u52a0\u5165\u666e\u901a\u961f\u5217:" + t(aVar));
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "add giftAnimData to normalPriorityQueue", true);
            }
            q(aVar, i3, this.G);
        }
        if (I(aVar)) {
            F("\u7acb\u5373\u64ad\u653e\u793c\u7269\uff0c\u9700\u8981\u7ed3\u675f\u5f53\u524d\u52a8\u753b\uff0c\u7acb\u5373\u64ad\u653e\u65b0\u793c\u7269\u52a8\u753b:" + t(aVar));
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "addGiftAnimationToQueue", "need immediately play, releaseResourceForTargetData", true);
            }
            M(aVar);
        }
    }

    private void q(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3, Vector<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> vector) {
        if (i3 >= 0 && i3 <= vector.size()) {
            vector.add(i3, aVar);
        } else {
            vector.add(aVar);
        }
    }

    private void r(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar.f264911b == 0) {
            return;
        }
        F("\u52a8\u753b\u7ed3\u675f\u3001\u6216banner\u52a8\u753b\u7ed3\u675f\uff0c\u6570\u636e\u52a0\u5165\u5b8c\u6210\u961f\u5217: " + t(aVar));
        this.D.put(v(aVar), aVar);
    }

    private void s(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        F("\u64ad\u653e\u5168\u5c4f\u7279\u6548\uff0c\u793c\u7269\u6570\u636e\u8fdb\u5165\u7279\u6548\u961f\u5217\uff1a" + t(aVar));
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "enqueueScreenGiftData", "giftAnimData add to screenAnimationQueue", true);
        }
        AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", "biaomaAnmimDebug", t(aVar));
        String v3 = v(aVar);
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.I.get(v3);
        if (aVar2 != null) {
            aVar2.f264926q = aVar.f264926q;
        } else {
            this.I.put(v3, aVar);
            this.H.add(aVar);
        }
        L();
    }

    private String t(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar == null) {
            return "empty giftInfo";
        }
        return "giftName:" + aVar.f264913d + " dataType\uff1a" + aVar.f264911b + " level:" + aVar.f264924o + " origNum:" + aVar.f264928s + " num:" + aVar.f264926q + " price:" + aVar.f264912c + " key:" + v(aVar);
    }

    private QQLiveGiftBannerContainer u() {
        if (this.f311699m) {
            return null;
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer = this.M;
        if (qQLiveGiftBannerContainer != null && qQLiveGiftBannerContainer.v()) {
            return this.M;
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer2 = this.N;
        if (qQLiveGiftBannerContainer2 == null || !qQLiveGiftBannerContainer2.v()) {
            return null;
        }
        return this.N;
    }

    private String v(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar == null) {
            return "";
        }
        return "" + aVar.f264918i + aVar.f264920k + aVar.f264925p;
    }

    private void w() {
        if (this.f311699m) {
            return;
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer = this.M;
        if (qQLiveGiftBannerContainer != null && this.N != null) {
            if (qQLiveGiftBannerContainer.u() <= this.N.u()) {
                this.M.G();
                F("\u7acb\u5373\u505c\u6b62firstBannerView");
                return;
            } else {
                this.N.G();
                F("\u7acb\u5373\u505c\u6b62secondBannerView");
                return;
            }
        }
        E("\u6267\u884c\u7acb\u5373\u91ca\u653e\u64cd\u4f5c\u65f6\uff0cbannerView\u4e3a\u7a7a");
    }

    private void x() {
        if (this.K != null && this.L != 2) {
            F("\u505c\u6b62\u5f53\u524d\u7279\u6548\u52a8\u753b\u7684\u64ad\u653e");
            this.L = 2;
            this.f311694d.u();
        }
    }

    private boolean y() {
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer;
        if (this.f311699m) {
            return false;
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer2 = this.M;
        if ((qQLiveGiftBannerContainer2 == null || !qQLiveGiftBannerContainer2.v()) && ((qQLiveGiftBannerContainer = this.N) == null || !qQLiveGiftBannerContainer.v())) {
            return false;
        }
        return true;
    }

    private boolean z(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        int i3 = aVar.f264924o;
        if ((i3 == 0 || i3 == 1 || i3 == 2) && aVar.f264926q > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public View b() {
        return this.M;
    }

    @Override // qh2.e
    public synchronized void c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.K) {
            E("\u7279\u6548\u52a8\u753b\u7ed3\u675f\u64ad\u653e\u4e86\uff0c\u4f46\u662f\u6570\u636e\u4e0d\u5339\u914d");
            return;
        }
        F("\u7279\u6548\u52a8\u753b\u7ed3\u675f\u64ad\u653e\uff0c\u9690\u85cfgiftView\uff0cGiftData:" + t(aVar));
        this.f311694d.setVisibility(4);
        this.L = 0;
        L();
        r(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ void d(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        super.d(aVar);
    }

    @Override // qh2.e
    public void e(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.K) {
            E("\u7279\u6548\u52a8\u753b\u5f00\u59cb\u64ad\u653e\u4e86\uff0c\u4f46\u662f\u6570\u636e\u4e0d\u5339\u914d");
            return;
        }
        F("\u7279\u6548\u52a8\u753b\u5f00\u59cb\u64ad\u653e\uff0c\u5c55\u793agiftView\uff0cGiftData:" + t(aVar));
        this.f311694d.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public /* bridge */ /* synthetic */ sh2.a f(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        return super.f(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void g(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3) {
        F("banner\u5c55\u793a\u7ed3\u675f\uff0cGiftData:" + t(aVar));
        r(aVar);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void h(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (A(aVar)) {
            s(aVar);
            F("onBannerAnimationStart \u793c\u7269\u52a8\u753b\u5165\u961f\u5217:" + t(aVar));
        }
        F("banner\u5f00\u59cb\u5c55\u793a\uff0cGiftData:" + t(aVar));
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public View i() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.d
    public void j() {
        K();
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
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|DoubleBannerGiftAnimationEngineImpl", VasPerfReportUtils.ADD_GIFT_ANIM, "index=" + i3 + ", giftAnimData={" + aVar + "}", true);
        }
        G("\u5916\u90e8\u8c03\u7528\u89e6\u53d1\uff0c\u5f00\u59cb\u6dfb\u52a0\u793c\u7269\u52a8\u753b" + t(aVar));
        if (B(aVar)) {
            G("\u5916\u90e8\u4f20\u5165\u6570\u636e\u5c5e\u4e8e\u6b63\u5728\u64ad\u653e\u7684\u8fde\u51fb\u793c\u7269\uff0c\u5148\u52a0\u5165\u793c\u7269\u961f\u5217" + t(aVar));
            p(aVar, i3);
        } else if (!y()) {
            G("\u6ca1\u6709\u7a7a\u4f59banner\u4f4d\u7f6e\uff0c\u5148\u52a0\u5165\u793c\u7269\u961f\u5217" + t(aVar));
            p(aVar, i3);
        } else {
            if (z(aVar) && (aVar2 = this.D.get(v(aVar))) != null) {
                if (aVar2.f264926q >= aVar.f264926q) {
                    F("\u8be5\u8fde\u51fb\u5e8f\u5217\u5df2\u7ecf\u64ad\u653e\u5b8c\u4e86\uff0c\u6570\u636e\u76f4\u63a5\u4e22\u5f03\u6389:" + t(aVar));
                    return;
                }
                F("\u8be5\u8fde\u51fb\u5e8f\u5217\u64ad\u653e\u4e2d\u65ad\u8fc7\uff0c\u9700\u8981\u66f4\u65b0\u521d\u59cb\u8fde\u51fb\u6570:" + t(aVar));
                aVar.f264928s = aVar2.f264926q + 1;
            }
            if (!N(aVar)) {
                E("\u64ad\u653e\u52a8\u753b\u5931\u8d25\uff0c\u52a0\u5165\u961f\u5217 " + t(aVar));
                p(aVar, i3);
            }
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
        super.prepare();
        F("\u521d\u59cb\u5316\u53cc\u98d8\u6761\u793c\u7269\u5f15\u64ce");
        if (this.f311697h == null) {
            E("\u521d\u59cb\u5316\u793c\u7269\u5f15\u64ce\u5931\u8d25, context is null!");
            return;
        }
        BannerResManager y16 = BannerResManager.y(this.f311696f.b());
        y16.G(this.f311696f.getSDKConfig());
        D(y16);
        this.M = new QQLiveGiftBannerContainer(this.f311697h, y16);
        this.N = new QQLiveGiftBannerContainer(this.f311697h, y16);
        this.M.setBannerListener(this);
        this.N.setBannerListener(this);
        this.f311694d.r(this);
        n(this.P);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public synchronized void release() {
        reset();
        super.release();
        F("release");
        this.M = null;
        this.N = null;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.anim.a, com.tencent.mobileqq.qqgift.mvvm.business.anim.b
    public synchronized void reset() {
        super.reset();
        F("reset");
        this.G.clear();
        this.F.clear();
        this.E.clear();
        this.D.clear();
        this.H.clear();
        this.I.clear();
        QQGiftView qQGiftView = this.f311694d;
        if (qQGiftView != null) {
            qQGiftView.u();
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer = this.M;
        if (qQLiveGiftBannerContainer != null) {
            qQLiveGiftBannerContainer.G();
        }
        QQLiveGiftBannerContainer qQLiveGiftBannerContainer2 = this.N;
        if (qQLiveGiftBannerContainer2 != null) {
            qQLiveGiftBannerContainer2.G();
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.d
    public void a() {
    }
}
