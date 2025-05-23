package com.tencent.mobileqq.vasgift.mvvm.business.anim;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.lang.ref.SoftReference;
import qh2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public class QQGiftView extends FrameLayout {
    private final oh2.a C;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.qqgift.mvvm.business.anim.b f311674d;

    /* renamed from: e, reason: collision with root package name */
    private e f311675e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311676f;

    /* renamed from: h, reason: collision with root package name */
    private CheckTimeOutRunnable f311677h;

    /* renamed from: i, reason: collision with root package name */
    private final qh2.a f311678i;

    /* renamed from: m, reason: collision with root package name */
    private sh2.a f311679m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class CheckTimeOutRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311683d;

        /* renamed from: e, reason: collision with root package name */
        private final b f311684e;

        /* renamed from: f, reason: collision with root package name */
        private final SoftReference<QQGiftView> f311685f;

        CheckTimeOutRunnable(QQGiftView qQGiftView, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, b bVar) {
            this.f311683d = aVar;
            this.f311684e = bVar;
            this.f311685f = new SoftReference<>(qQGiftView);
        }

        @Override // java.lang.Runnable
        public void run() {
            QQGiftView qQGiftView = this.f311685f.get();
            if (qQGiftView != null) {
                qQGiftView.i(this.f311683d, this.f311684e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements qh2.a {
        a() {
        }

        @Override // qh2.a
        public void onAnimationEnd() {
            if (QQGiftView.this.f311676f != null && QQGiftView.this.f311676f.a()) {
                AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "onAnimationEnd", "materialId=" + QQGiftView.this.f311676f.f264914e + ", giftId=" + QQGiftView.this.f311676f.f264910a + ", giftName=" + QQGiftView.this.f311676f.f264913d, true);
            }
            if (QQGiftView.this.f311675e != null) {
                QQGiftView.this.f311675e.c(QQGiftView.this.f311676f);
            }
        }

        @Override // qh2.a
        public void onAnimationStart() {
            if (QQGiftView.this.f311676f != null && QQGiftView.this.f311676f.a()) {
                AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "onAnimationStart", "materialId=" + QQGiftView.this.f311676f.f264914e + ", giftId=" + QQGiftView.this.f311676f.f264910a + ", giftName=" + QQGiftView.this.f311676f.f264913d, true);
            }
            if (QQGiftView.this.f311675e != null) {
                QQGiftView.this.f311675e.e(QQGiftView.this.f311676f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements qh2.b {

        /* renamed from: d, reason: collision with root package name */
        private final SoftReference<QQGiftView> f311687d;

        /* renamed from: e, reason: collision with root package name */
        private final com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311688e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f311689f = false;

        public b(QQGiftView qQGiftView, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f311687d = new SoftReference<>(qQGiftView);
            this.f311688e = aVar;
        }

        @Override // qh2.g
        public void onLoadFail(int i3, int i16, int i17, String str) {
            VasLogReporter.getVasGift().report("QQGiftView load failed:" + this.f311688e.f264914e, VasLogReportProxy.LEVEL.HIGHEST);
            if (this.f311689f) {
                QLog.e("QQGiftView", 1, "load " + this.f311688e.f264914e + " success but timeOut");
                return;
            }
            QQGiftView qQGiftView = this.f311687d.get();
            if (qQGiftView != null) {
                qQGiftView.j(str, this.f311688e);
            }
        }

        @Override // qh2.b
        public void onLoadSuccess(int i3, String str) {
            if (this.f311689f) {
                QLog.e("QQGiftView", 1, "load " + this.f311688e.f264914e + " failed and timeOut");
                return;
            }
            QQGiftView qQGiftView = this.f311687d.get();
            if (qQGiftView != null) {
                qQGiftView.k(str, this.f311688e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c implements qh2.c {

        /* renamed from: d, reason: collision with root package name */
        private final SoftReference<QQGiftView> f311690d;

        /* renamed from: e, reason: collision with root package name */
        private final com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311691e;

        public c(QQGiftView qQGiftView, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f311690d = new SoftReference<>(qQGiftView);
            this.f311691e = aVar;
        }

        @Override // qh2.g
        public void onLoadFail(int i3, int i16, int i17, String str) {
            QQGiftView qQGiftView = this.f311690d.get();
            if (qQGiftView != null) {
                qQGiftView.j(str, this.f311691e);
            }
            QLog.w("QQGiftView", 1, "load " + this.f311691e.f264914e + " failed");
        }

        @Override // qh2.c
        public void onLoadSuccess(int i3, String str) {
            QQGiftView qQGiftView = this.f311690d.get();
            if (qQGiftView != null && !TextUtils.isEmpty(str)) {
                qQGiftView.k(str + File.separator + "staticPreviewImage.png", this.f311691e);
            }
        }
    }

    public QQGiftView(Context context, com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar) {
        super(context);
        this.f311676f = null;
        this.f311677h = null;
        this.f311678i = new a();
        this.f311674d = bVar;
        this.C = bVar.m().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, b bVar) {
        if (aVar != null) {
            if (aVar == this.f311676f) {
                if (bVar != null) {
                    bVar.f311689f = true;
                }
                QLog.e("QQGiftView", 1, "load " + aVar.f264914e + " timeOut");
                e eVar = this.f311675e;
                if (eVar != null) {
                    eVar.c(aVar);
                }
                return;
            }
        }
        QLog.e("QQGiftView", 1, "checkDownload data is match");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(String str, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        VasLogReporter.getVasGift().report("QQGiftView load failed:" + aVar, VasLogReportProxy.LEVEL.HIGHEST);
        if (aVar != this.f311676f) {
            QLog.e("QQGiftView", 1, aVar.f264914e + ": onLoadFailed and data is not match");
            return;
        }
        q();
        QLog.e("QQGiftView", 1, "[playAnimation] load " + aVar.f264914e + " gift failed " + str);
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "onLoadFailed", ", errorMsg=" + str + "materialId=" + aVar.f264914e + ", giftId=" + this.f311676f.f264910a + ", giftName=" + this.f311676f.f264913d, true);
        }
        e eVar = this.f311675e;
        if (eVar != null) {
            eVar.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(final String str, final com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (aVar != this.f311676f) {
            QLog.e("QQGiftView", 1, aVar.f264914e + ": onLoadSuccess but data is not match");
            return;
        }
        q();
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftView", 1, "[playAnimation] " + aVar.f264914e + " giftPath is " + str);
        }
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "onLoadSuccess", "materialId=" + aVar.f264914e + ", giftId=" + this.f311676f.f264910a + ", giftName=" + this.f311676f.f264913d, true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.QQGiftView.4
            @Override // java.lang.Runnable
            public void run() {
                if (aVar.a()) {
                    AegisLogger.i("Recv_Gift_Monitor|QQGiftView", QZoneJsConstants.METHOD_PLAY, "materialId=" + aVar.f264914e + ", giftId=" + QQGiftView.this.f311676f.f264910a + ", giftName=" + QQGiftView.this.f311676f.f264913d, true);
                }
                QQGiftView.this.f311679m.c(str);
                VasLogReporter.getVasGift().report("QQGiftView play:" + str, VasLogReportProxy.LEVEL.HIGHEST);
            }
        });
    }

    private void l(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        q();
        b bVar = new b(this, aVar);
        CheckTimeOutRunnable checkTimeOutRunnable = new CheckTimeOutRunnable(this, aVar, bVar);
        this.f311677h = checkTimeOutRunnable;
        ThreadManager.b(checkTimeOutRunnable, 15000L);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftView", 1, "[playAnimation] materialId is " + aVar.f264914e);
        }
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "play", "materialId=" + aVar.f264914e, true);
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_NEED_PLAY, String.valueOf(aVar.f264910a));
        if (aVar.f264929t) {
            if (!aVar.f264930u) {
                this.C.R(aVar.f264914e, new c(this, aVar));
                return;
            } else {
                this.C.E(aVar.f264914e, bVar);
                return;
            }
        }
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "play", "getGiftAnimationResourceNew, materialId=" + aVar.f264914e, true);
        }
        this.C.E(aVar.f264914e, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        this.f311676f = aVar;
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftView", 1, "playAnimation type is " + aVar.f264911b + " level:" + aVar.f264924o);
        }
        if (aVar.a()) {
            AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "realPlay", "materialId=" + aVar.f264914e + ", giftId=" + aVar.f264910a + ", giftName=" + aVar.f264913d, true);
        }
        t(aVar);
        if (this.f311679m == null) {
            QLog.e("QQGiftView", 1, "giftAnimationView is null and called onAnimationEnd callback");
            if (aVar.a()) {
                AegisLogger.i("Recv_Gift_Monitor|QQGiftView", "realPlay", "play exception, currentView == null", true);
            }
            e eVar = this.f311675e;
            if (eVar != null) {
                eVar.c(aVar);
            }
            return;
        }
        s(aVar);
        l(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() {
        sh2.a aVar = this.f311679m;
        if (aVar != null) {
            aVar.stop();
        }
    }

    private void q() {
        CheckTimeOutRunnable checkTimeOutRunnable = this.f311677h;
        if (checkTimeOutRunnable != null) {
            checkTimeOutRunnable.f311683d = null;
            ThreadManager.d(this.f311677h);
        }
    }

    private void s(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        this.f311679m.d().setLayoutParams(this.f311679m.a(aVar));
    }

    private void t(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        sh2.a f16 = this.f311674d.f(aVar);
        if (this.f311679m != f16) {
            removeAllViews();
            this.f311679m = f16;
            if (f16 != null) {
                f16.b(this.f311678i);
                addView(this.f311679m.d());
            }
        }
    }

    public void m(final com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            n(aVar);
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.QQGiftView.2
                @Override // java.lang.Runnable
                public void run() {
                    QQGiftView.this.n(aVar);
                }
            });
        }
    }

    public void p() {
        q();
        this.f311675e = null;
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void r(e eVar) {
        this.f311675e = eVar;
    }

    public void u() {
        QLog.i("QQGiftView", 1, "stop");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            o();
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.anim.QQGiftView.3
                @Override // java.lang.Runnable
                public void run() {
                    QQGiftView.this.o();
                }
            });
        }
    }
}
