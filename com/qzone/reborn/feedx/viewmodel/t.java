package com.qzone.reborn.feedx.viewmodel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.util.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends tc.b {
    private String F;
    private String G;
    private g H;
    private d I;
    private f J;
    private h K;
    private e L;
    private HashSet<c> M;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f55917d;

        a(int i3) {
            this.f55917d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (t.this.M != null) {
                Iterator it = t.this.M.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).g0(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.f55917d);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void g0(int i3, int i16);

        void onEnd();

        void onStart(int i3);

        void s0();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
        void a(QZoneResult qZoneResult);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface f {
        void a(QZoneResult qZoneResult);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface g {
        void a(QZoneResult qZoneResult);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface h {
        void a(QZoneResult qZoneResult);
    }

    private void u2() {
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeletedVisitRecord", "\u5df2\u5220\u9664\u672c\u6b21\u8bbf\u95ee\u8bb0\u5f55"), 5);
        d dVar = this.I;
        if (dVar != null) {
            dVar.a();
        }
    }

    private void x2(QZoneResult qZoneResult) {
        e eVar = this.L;
        if (eVar != null) {
            eVar.a(qZoneResult);
        }
    }

    public void B2() {
        HashSet<c> hashSet = this.M;
        if (hashSet == null) {
            return;
        }
        Iterator<c> it = hashSet.iterator();
        while (it.hasNext()) {
            it.next().s0();
        }
    }

    public void C2(String str) {
        this.G = str;
    }

    public void D2(d dVar) {
        this.I = dVar;
    }

    public void E2(e eVar) {
        this.L = eVar;
    }

    public void F2(g gVar) {
        this.H = gVar;
    }

    public void G2(f fVar) {
        this.J = fVar;
    }

    public void H2(h hVar) {
        this.K = hVar;
    }

    public void I2(String str) {
        this.F = str;
    }

    public void K2(long j3, Handler handler) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.s("\u65e0\u7f51\u7edc\u8fde\u63a5", 0);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("question", this.F);
        hashMap.put("answer", this.G);
        z5.a f16 = z5.a.f();
        if (f16 != null) {
            f16.b(LoginData.getInstance().getUin(), j3, this.F, this.G, handler);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneUserHomeForbiddenPageViewModel";
    }

    @Override // tc.b
    public void i2(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        int i3 = unpack.what;
        if (i3 == 999929) {
            z2(unpack);
            return;
        }
        if (i3 == 999946) {
            y2(unpack);
            return;
        }
        if (i3 == 1000042) {
            t2(unpack);
            return;
        }
        if (i3 == 1000105) {
            u2();
            return;
        }
        if (i3 == 1000205) {
            v2(unpack);
            return;
        }
        if (i3 == 1000002) {
            w2(unpack);
        } else if (i3 == 1000112 || i3 == 1000001) {
            x2(unpack);
        }
    }

    @Override // tc.b
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public QZoneFeedService R1() {
        return null;
    }

    public Handler s2() {
        return getMHandler();
    }

    public void J2(int i3, long j3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new a(i3));
        ofInt.addListener(new b(i3));
        ofInt.start();
    }

    private void v2(QZoneResult qZoneResult) {
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            f fVar = this.J;
            if (fVar != null) {
                fVar.a(qZoneResult);
                return;
            }
            return;
        }
        QLog.e("QZoneUserHomeForbiddenPageViewModel", 1, "onGetBottomNaviInfo() error! result in wrong state");
    }

    private void w2(QZoneResult qZoneResult) {
        if (qZoneResult == null || !qZoneResult.getSucceed()) {
            QLog.e("QZoneUserHomeForbiddenPageViewModel", 1, "SpecialFollowAndPush error! result in wrong state");
        }
        h hVar = this.K;
        if (hVar != null) {
            hVar.a(qZoneResult);
        }
    }

    private void t2(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSendVisitApply", "\u5df2\u53d1\u9001\u8bbf\u95ee\u7533\u8bf7");
        if (qZoneResult.getSucceed()) {
            ToastUtil.s(config, 5);
        } else {
            ToastUtil.s(qZoneResult.getMessage(), 4);
        }
    }

    private void y2(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (qZoneResult.getSucceed()) {
            ToastUtil.s("\u9080\u8bf7\u5f00\u901a\u6210\u529f", 5);
        } else {
            ToastUtil.s(qZoneResult.getMessage(), 4);
        }
    }

    private void z2(QZoneResult qZoneResult) {
        g gVar;
        if (qZoneResult == null || (gVar = this.H) == null) {
            return;
        }
        gVar.a(qZoneResult);
    }

    public void q2(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.M == null) {
            this.M = new HashSet<>();
        }
        this.M.add(cVar);
    }

    public void A2(int i3, Intent intent) {
        if (i3 != -1 || intent == null) {
            return;
        }
        Long valueOf = Long.valueOf(intent.getLongExtra("access_apply_uin", 0L));
        z5.a.f().c(valueOf.longValue(), intent.getStringExtra("apply_content"), s2());
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f55919d;

        b(int i3) {
            this.f55919d = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (t.this.M != null) {
                Iterator it = t.this.M.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onEnd();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (t.this.M != null) {
                Iterator it = t.this.M.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onStart(this.f55919d);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
