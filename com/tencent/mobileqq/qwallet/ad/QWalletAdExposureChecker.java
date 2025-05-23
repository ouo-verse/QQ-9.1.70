package com.tencent.mobileqq.qwallet.ad;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QWalletAdExposureChecker {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private WeakReference<View> f277025e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private d f277026f;

    /* renamed from: j, reason: collision with root package name */
    private Ad f277030j;

    /* renamed from: k, reason: collision with root package name */
    private final long f277031k;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private InternalTask f277021a = null;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f277022b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private WeakReference<AdExposureChecker.ExposureCallback> f277023c = null;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private WeakReference<b> f277024d = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f277027g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f277028h = false;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private int f277029i = 0;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private final c f277032l = new a(200);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class InternalTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f277036d = 0;

        /* renamed from: e, reason: collision with root package name */
        private long f277037e;

        InternalTask() {
            g();
        }

        private int e() {
            AdExposureChecker.ExposureCallback exposureCallback;
            long currentTimeMillis = System.currentTimeMillis() - this.f277037e;
            QLog.i("QWalletAdExposureChecker", 2, "count:" + this.f277036d + " totalTime:" + currentTimeMillis + " status: " + QWalletAdExposureChecker.this.f277029i);
            if (QWalletAdExposureChecker.this.f277030j == null || !AdExposureListHolder.getInstance().inCheckedList(QWalletAdExposureChecker.this.f277030j.getTraceId())) {
                View y16 = QWalletAdExposureChecker.this.y();
                String str = null;
                if (QWalletAdExposureChecker.this.f277023c != null) {
                    exposureCallback = (AdExposureChecker.ExposureCallback) QWalletAdExposureChecker.this.f277023c.get();
                } else {
                    exposureCallback = null;
                }
                if (y16 != null && exposureCallback != null && !QWalletAdExposureChecker.this.f277028h && QWalletAdExposureChecker.this.f277027g && QWalletAdExposureChecker.this.f277029i == 1) {
                    if (!y16.isShown()) {
                        QLog.w("QWalletAdExposureChecker", 2, "!mViewRef.get().isShown()" + y16.getParent());
                        return 1;
                    }
                    if (!QWalletAdExposureChecker.A(y16)) {
                        g();
                        QLog.w("QWalletAdExposureChecker", 2, "!isVisibleAreaSatisfied() reset timer");
                        return 0;
                    }
                    if (currentTimeMillis >= 1000) {
                        Context context = y16.getContext();
                        AdExposureListHolder adExposureListHolder = AdExposureListHolder.getInstance();
                        if (QWalletAdExposureChecker.this.f277030j != null) {
                            str = QWalletAdExposureChecker.this.f277030j.getTraceId();
                        }
                        adExposureListHolder.putExternalReportData(context, str);
                        exposureCallback.onExposure(QWalletAdExposureChecker.this.f277025e);
                        QWalletAdExposureChecker.this.f277029i = 2;
                        AdAnalysisHelperForUtil.reportForExposureCallback(context, QWalletAdExposureChecker.this.f277030j, 0);
                        QLog.d("QWalletAdExposureChecker", 2, "exposure success! totalExposureTime=" + currentTimeMillis);
                        return 2;
                    }
                    this.f277036d++;
                    QWalletAdExposureChecker.this.w(currentTimeMillis);
                    return 0;
                }
                QLog.w("QWalletAdExposureChecker", 2, "check failed : isViewDestroyed " + QWalletAdExposureChecker.this.f277028h + " isViewOnForeground " + QWalletAdExposureChecker.this.f277027g + " status " + QWalletAdExposureChecker.this.f277029i + " no callback :" + exposureCallback);
                return 1;
            }
            QLog.w("QWalletAdExposureChecker", 2, "trace id is already exposured " + QWalletAdExposureChecker.this.f277030j.getTraceId());
            return 2;
        }

        private long f() {
            return Math.max(0L, Math.min(200L, 1000 - (System.currentTimeMillis() - this.f277037e)));
        }

        private void g() {
            this.f277036d = 0;
            this.f277037e = System.currentTimeMillis();
            QWalletAdExposureChecker.this.w(0L);
        }

        public void h(long j3) {
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (currentTimeMillis > 0 && currentTimeMillis < this.f277037e) {
                this.f277037e = currentTimeMillis;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int e16 = e();
            if (e16 != 0) {
                if (e16 == 1) {
                    QWalletAdExposureChecker.this.P();
                    return;
                } else {
                    if (e16 == 2) {
                        QWalletAdExposureChecker.this.x();
                        return;
                    }
                    return;
                }
            }
            long f16 = f();
            QLog.d("QWalletAdExposureChecker", 2, "postDelay: " + f16);
            QWalletAdExposureChecker.this.f277022b.postDelayed(QWalletAdExposureChecker.this.f277021a, f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends c {
        a(long j3) {
            super(j3);
        }

        @Override // com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.c
        void a() {
            QWalletAdExposureChecker qWalletAdExposureChecker = QWalletAdExposureChecker.this;
            if (!qWalletAdExposureChecker.z(qWalletAdExposureChecker.y())) {
                QLog.w("QWalletAdExposureChecker", 2, "onScrollChangedOverDuration view invisible");
                QWalletAdExposureChecker.this.P();
            } else {
                QLog.i("QWalletAdExposureChecker", 2, "onScrollChangedOverDuration view visible");
                QWalletAdExposureChecker.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public abstract class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: d, reason: collision with root package name */
        private volatile long f277039d;

        /* renamed from: e, reason: collision with root package name */
        private long f277040e;

        c(long j3) {
            this.f277040e = j3;
        }

        abstract void a();

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (this.f277039d == 0) {
                this.f277039d = System.currentTimeMillis();
                a();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f277039d >= this.f277040e) {
                a();
                this.f277039d = currentTimeMillis;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewAttachedToWindow ");
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.i("QWalletAdExposureChecker", 2, sb5.toString());
            QWalletAdExposureChecker.this.M();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewDetachedFromWindow ");
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.w("QWalletAdExposureChecker", 2, sb5.toString());
            QWalletAdExposureChecker.this.L();
        }
    }

    public QWalletAdExposureChecker(Ad ad5, long j3, @Nullable WeakReference<View> weakReference) {
        this.f277026f = null;
        this.f277030j = ad5;
        this.f277031k = j3;
        this.f277025e = weakReference;
        if (this.f277026f == null) {
            this.f277026f = new d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean A(@Nullable View view) {
        if (view == null || view.getVisibility() != 0 || AdUIUtils.getPercentageOfGlobalVisibleRect(view) < 0.5d) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        View y16 = y();
        if (y16 != null && this.f277030j != null && this.f277029i != 1) {
            C(y16);
            O();
        } else {
            QLog.e("QWalletAdExposureChecker", 2, "startTimer: " + this.f277029i);
        }
    }

    private void C(@NonNull View view) {
        if (view.getViewTreeObserver() == null) {
            QLog.e("QWalletAdExposureChecker", 2, "listenViewStateChange fail");
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        QLog.d("QWalletAdExposureChecker", 2, "addOnScrollChangedListener: " + viewTreeObserver);
        viewTreeObserver.addOnScrollChangedListener(this.f277032l);
        view.addOnAttachStateChangeListener(this.f277026f);
    }

    public static void G(@Nullable final Context context, @Nullable final Ad ad5, @Nullable final WeakReference<AdExposureChecker.ExposureCallback> weakReference) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.4
            @Override // java.lang.Runnable
            public void run() {
                Ad ad6;
                if (context != null && weakReference != null && (ad6 = ad5) != null && ad6.isValid() && !TextUtils.isEmpty(ad5.getTraceId())) {
                    if (!AdExposureListHolder.getInstance().inCheckedList(ad5.getTraceId())) {
                        AdExposureListHolder.getInstance().putExternalReportData(context, ad5.getTraceId());
                        AdExposureChecker.ExposureCallback exposureCallback = (AdExposureChecker.ExposureCallback) weakReference.get();
                        if (exposureCallback != null) {
                            exposureCallback.onExposure(null);
                        }
                        AdAnalysisHelperForUtil.reportForExposureCallback(context, ad5, 1);
                        return;
                    }
                    return;
                }
                QLog.e("QWalletAdExposureChecker", 2, "onClick error");
            }
        }, 0);
    }

    private void H(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f277022b.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (y() != null) {
            x();
            this.f277025e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (y() != null) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (y() != null) {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        View y16 = y();
        if (y16 == null) {
            return;
        }
        if (!AdExposureListHolder.getInstance().containsTraceIdForAnalysis(this.f277030j.getTraceId())) {
            AdAnalysisHelperForUtil.reportForExposureApiInvoked(y16.getContext(), this.f277030j);
            AdExposureListHolder.getInstance().addTraceIdForAnalysis(this.f277030j.getTraceId());
        }
        if (this.f277021a == null) {
            InternalTask internalTask = new InternalTask();
            this.f277021a = internalTask;
            long j3 = this.f277031k;
            if (j3 > 0) {
                internalTask.h(j3);
            }
        }
        if (this.f277029i != 1) {
            this.f277029i = 1;
            this.f277021a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.f277021a != null) {
            QLog.d("QWalletAdExposureChecker", 2, "stopCheck");
            this.f277022b.removeCallbacks(this.f277021a);
            this.f277021a = null;
        }
        this.f277029i = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j3) {
        b bVar;
        WeakReference<b> weakReference = this.f277024d;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.a(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QLog.d("QWalletAdExposureChecker", 2, "destroyCheck");
        View y16 = y();
        if (y16 != null) {
            y16.removeOnAttachStateChangeListener(this.f277026f);
            ViewTreeObserver viewTreeObserver = y16.getViewTreeObserver();
            QLog.d("QWalletAdExposureChecker", 2, "removeOnScrollChangedListener: " + viewTreeObserver);
            viewTreeObserver.removeOnScrollChangedListener(this.f277032l);
        } else {
            QLog.e("QWalletAdExposureChecker", 2, "destroyCheck fail, view is null");
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public View y() {
        WeakReference<View> weakReference = this.f277025e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(@Nullable View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    public void D() {
        this.f277022b.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QWalletAdExposureChecker", 2, "onActivityDestroy");
                QWalletAdExposureChecker.this.f277028h = true;
                QWalletAdExposureChecker.this.K();
            }
        });
    }

    public void E() {
        this.f277022b.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QWalletAdExposureChecker", 2, "onActivityPause");
                QWalletAdExposureChecker.this.f277027g = false;
                QWalletAdExposureChecker.this.L();
            }
        });
    }

    public void F() {
        this.f277022b.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QWalletAdExposureChecker", 2, "onActivityResume");
                QWalletAdExposureChecker.this.f277027g = true;
                QWalletAdExposureChecker.this.M();
            }
        });
    }

    public void I(WeakReference<AdExposureChecker.ExposureCallback> weakReference) {
        this.f277023c = weakReference;
    }

    public void J(WeakReference<b> weakReference) {
        this.f277024d = weakReference;
    }

    public void N() {
        QLog.i("QWalletAdExposureChecker", 2, "startCheck");
        H(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.h
            @Override // java.lang.Runnable
            public final void run() {
                QWalletAdExposureChecker.this.B();
            }
        });
    }
}
