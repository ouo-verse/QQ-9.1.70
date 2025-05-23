package com.tencent.mobileqq.util;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0006\u0016\u001d=!>%B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u001c\u0010,\u001a\b\u0018\u00010)R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u000606R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "", "Landroid/view/View;", "view", "", "t", "v", "", ReportConstant.COSTREPORT_PREFIX, "D", BdhLogUtil.LogTag.Tag_Conn, "B", "G", "E", "y", "w", "u", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "mCallback", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "a", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "b", "Ljava/lang/ref/WeakReference;", "mViewRef", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "mInternalTask", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "mMainHandler", "e", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$d;", "f", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$d;", "mStatusChangeListener", "g", "Z", "mIsViewOnForeground", tl.h.F, "mIsViewDestroyed", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$ViewStatus;", "i", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$ViewStatus;", "mStatus", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$c;", "j", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$c;", "scrollChangedListener", "<init>", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "k", "InternalTask", "ViewStatus", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QZoneAdExposureChecker {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final HashSet<String> f306451l = new HashSet<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mViewRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mInternalTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mMainHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<b> mCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mStatusChangeListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mIsViewOnForeground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsViewDestroyed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewStatus mStatus;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c scrollChangedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$InternalTask;", "Ljava/lang/Runnable;", "", "f", "", "e", TencentLocation.RUN_MODE, "", "d", "J", "mStartCheckTime", "<init>", "(Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class InternalTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long mStartCheckTime;

        public InternalTask() {
            f();
        }

        private final int e() {
            View view;
            long currentTimeMillis = System.currentTimeMillis() - this.mStartCheckTime;
            AdLog.i("TianshuAdExposureChecker", " status: " + QZoneAdExposureChecker.this.mStatus + " totalExposureTime " + currentTimeMillis + " thread :" + Thread.currentThread());
            if (!QZoneAdExposureChecker.f306451l.contains(QZoneAdExposureChecker.this.getId())) {
                WeakReference weakReference = QZoneAdExposureChecker.this.mViewRef;
                b bVar = null;
                if (weakReference != null) {
                    view = (View) weakReference.get();
                } else {
                    view = null;
                }
                WeakReference weakReference2 = QZoneAdExposureChecker.this.mCallback;
                if (weakReference2 != null) {
                    bVar = (b) weakReference2.get();
                }
                if (view != null && bVar != null && !QZoneAdExposureChecker.this.mIsViewDestroyed && QZoneAdExposureChecker.this.mIsViewOnForeground && QZoneAdExposureChecker.this.mStatus == ViewStatus.CHECKING) {
                    if (!QZoneAdExposureChecker.INSTANCE.b(view)) {
                        f();
                        return 0;
                    }
                    if (currentTimeMillis < 1000) {
                        return 0;
                    }
                    QZoneAdExposureChecker.f306451l.add(QZoneAdExposureChecker.this.getId());
                    bVar.onExposure(QZoneAdExposureChecker.this.mViewRef);
                    QZoneAdExposureChecker.this.mStatus = ViewStatus.CHECKED;
                    AdLog.d("TianshuAdExposureChecker", "exposure success stop check");
                    return 1;
                }
                AdLog.e("TianshuAdExposureChecker", "check failed : isViewDestroyed " + QZoneAdExposureChecker.this.mIsViewDestroyed + " isViewOnForeground " + QZoneAdExposureChecker.this.mIsViewOnForeground + " status " + QZoneAdExposureChecker.this.mStatus + " no callback :" + bVar);
                return 1;
            }
            AdLog.e("TianshuAdExposureChecker", "trace id is already exposured ");
            return 1;
        }

        private final void f() {
            this.mStartCheckTime = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            int e16 = e();
            if (e16 == 0) {
                Runnable runnable = QZoneAdExposureChecker.this.mInternalTask;
                if (runnable != null) {
                    QZoneAdExposureChecker.this.mMainHandler.postDelayed(runnable, 100L);
                    return;
                } else {
                    AdLog.e("TianshuAdExposureChecker", "checkInternal failed!");
                    return;
                }
            }
            if (e16 == 1) {
                QZoneAdExposureChecker.this.G();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$ViewStatus;", "", "(Ljava/lang/String;I)V", "NONE", "CHECKING", "CHECKED", "END", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum ViewStatus {
        NONE,
        CHECKING,
        CHECKED,
        END
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0014j\b\u0012\u0004\u0012\u00020\u0011`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$a;", "", "Landroid/view/View;", "view", "", "b", "", "AD_REPORT_SATISFIED_VISIBLE_AREA", "D", "", "CHECK_CONTINUE", "I", "", "CHECK_EXPOSURE_TOTAL_MILLIS", "J", "CHECK_STOP", "DURATION_MILLIS", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mExposedTiansuAdCache", "Ljava/util/HashSet;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.QZoneAdExposureChecker$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b(View view) {
            if (view != null && view.getVisibility() == 0 && view.isShown() && AdUIUtils.getPercentageOfGlobalVisibleRect(view) >= 0.5d) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "view", "", "onExposure", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    @AdKeep
    /* loaded from: classes20.dex */
    public interface b {
        void onExposure(@Nullable WeakReference<View> view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u00a2\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H&R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$c;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "", "onScrollChanged", "a", "", "d", "J", "duration", "e", "lastActionTime", "<init>", "(Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;J)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public abstract class c implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private volatile long lastActionTime;

        public c(long j3) {
            this.duration = j3;
        }

        public abstract void a();

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (this.lastActionTime == 0) {
                this.lastActionTime = System.currentTimeMillis();
                a();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastActionTime >= this.duration) {
                a();
                this.lastActionTime = currentTimeMillis;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$d;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "<init>", "(Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class d implements View.OnAttachStateChangeListener {
        public d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewAttachedToWindow ");
            if (v3 != null) {
                i3 = v3.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            AdLog.i("TianshuAdExposureChecker", sb5.toString());
            QZoneAdExposureChecker.this.D();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onViewDetachedFromWindow ");
            if (v3 != null) {
                i3 = v3.hashCode();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            AdLog.e("TianshuAdExposureChecker", sb5.toString());
            QZoneAdExposureChecker.this.C();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/util/QZoneAdExposureChecker$e", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$c;", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e extends c {
        e() {
            super(100L);
        }

        @Override // com.tencent.mobileqq.util.QZoneAdExposureChecker.c
        public void a() {
            View view;
            QZoneAdExposureChecker qZoneAdExposureChecker = QZoneAdExposureChecker.this;
            WeakReference weakReference = qZoneAdExposureChecker.mViewRef;
            if (weakReference != null) {
                view = (View) weakReference.get();
            } else {
                view = null;
            }
            if (!qZoneAdExposureChecker.s(view)) {
                AdLog.e("TianshuAdExposureChecker", "onScrollChangedOverDuration view invisible");
                QZoneAdExposureChecker.this.G();
            }
        }
    }

    public QZoneAdExposureChecker(@NotNull String id5, @Nullable WeakReference<View> weakReference) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.mViewRef = weakReference;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsViewOnForeground = true;
        this.mStatus = ViewStatus.NONE;
        this.scrollChangedListener = new e();
        if (this.mStatusChangeListener == null) {
            this.mStatusChangeListener = new d();
        }
    }

    private final void B() {
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null && weakReference.get() != null) {
            G();
            this.mViewRef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null && weakReference.get() != null) {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QZoneAdExposureChecker this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<View> weakReference = this$0.mViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            ViewStatus viewStatus = this$0.mStatus;
            ViewStatus viewStatus2 = ViewStatus.CHECKING;
            if (viewStatus != viewStatus2) {
                this$0.t(view);
                if (this$0.mInternalTask == null) {
                    this$0.mInternalTask = new InternalTask();
                }
                this$0.mStatus = viewStatus2;
                Runnable runnable = this$0.mInternalTask;
                if (runnable != null) {
                    this$0.mMainHandler.post(runnable);
                    return;
                }
                return;
            }
        }
        AdLog.e("TianshuAdExposureChecker", "startCheck: " + this$0.mStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        View view;
        Runnable runnable = this.mInternalTask;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
        }
        this.mInternalTask = null;
        WeakReference<View> weakReference = this.mViewRef;
        if (weakReference != null && weakReference != null && (view = weakReference.get()) != null) {
            view.removeOnAttachStateChangeListener(this.mStatusChangeListener);
            view.getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        }
        this.mStatus = ViewStatus.END;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(View v3) {
        if (v3 == null) {
            return false;
        }
        return v3.getGlobalVisibleRect(new Rect());
    }

    private final void t(View view) {
        if (view != null && view.getViewTreeObserver() != null) {
            view.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            view.addOnAttachStateChangeListener(this.mStatusChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QZoneAdExposureChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdLog.e("TianshuAdExposureChecker", "onActivityDestroy");
        this$0.mIsViewDestroyed = true;
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QZoneAdExposureChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdLog.e("TianshuAdExposureChecker", "onActivityPause");
        this$0.mIsViewOnForeground = false;
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QZoneAdExposureChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdLog.d("TianshuAdExposureChecker", "onActivityResume");
        this$0.mIsViewOnForeground = true;
        this$0.D();
    }

    public final void A(@Nullable WeakReference<b> mCallback) {
        this.mCallback = mCallback;
    }

    public final void E() {
        AdLog.i("TianshuAdExposureChecker", "startCheck:" + hashCode());
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.mobileqq.util.bu
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdExposureChecker.F(QZoneAdExposureChecker.this);
            }
        }, 0);
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final void u() {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.util.bt
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdExposureChecker.v(QZoneAdExposureChecker.this);
            }
        });
    }

    public final void w() {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.util.br
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdExposureChecker.x(QZoneAdExposureChecker.this);
            }
        });
    }

    public final void y() {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.util.bs
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAdExposureChecker.z(QZoneAdExposureChecker.this);
            }
        });
    }
}
