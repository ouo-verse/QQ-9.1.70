package com.tencent.kuikly.core.render.android.performace;

import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.e;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/b;", "T", "Lcom/tencent/kuikly/core/render/android/e;", "", "p", "", "onInit", "l", "j", "f", "k", "i", h.F, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "c", "a", "e", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "b", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class b<T> implements e {

    /* renamed from: d, reason: collision with root package name */
    private static volatile Looper f118136d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/b$a;", "", "Landroid/os/Looper;", "a", "", "MONITOR_THREAD_NAME", "Ljava/lang/String;", "monitorLooper", "Landroid/os/Looper;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.performace.b$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final Looper a() {
            if (b.f118136d == null) {
                synchronized (b.class) {
                    if (b.f118136d == null) {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Kuikly_Monitor");
                        baseHandlerThread.start();
                        b.f118136d = baseHandlerThread.getLooper();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Looper looper = b.f118136d;
            Intrinsics.checkNotNull(looper);
            return looper;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void b(@NotNull Throwable throwable, @NotNull ErrorReason errorReason) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
    }

    @NotNull
    public abstract String p();

    @Override // com.tencent.kuikly.core.render.android.e
    public void a() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void c() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void d() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void e() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void f() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void g() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void h() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void i() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void j() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void k() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void l() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void m() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onDestroy() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onInit() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onPause() {
    }

    @Override // com.tencent.kuikly.core.render.android.e
    public void onResume() {
    }
}
