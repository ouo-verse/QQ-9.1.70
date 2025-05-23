package com.tencent.kuikly.core.render.android.performace.frame;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import d01.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/frame/KRFrameDetector;", "Landroid/view/Choreographer$FrameCallback;", "", "c", "d", "Lcom/tencent/kuikly/core/render/android/performace/frame/a;", "listener", "f", "g", "e", "", "frameTimeNanos", "doFrame", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "callbackList", "Landroid/view/Choreographer;", "Landroid/view/Choreographer;", "choreographer", "", "Z", "isStart", h.F, "isInit", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "Companion", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRFrameDetector implements Choreographer.FrameCallback {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final KRFrameDetector f118148i = new KRFrameDetector();

    /* renamed from: m, reason: collision with root package name */
    private static final Handler f118149m = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashSet<a> callbackList = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Choreographer choreographer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isStart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/frame/KRFrameDetector$Companion;", "", "Lcom/tencent/kuikly/core/render/android/performace/frame/a;", "listener", "", "a", "b", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/kuikly/core/render/android/performace/frame/KRFrameDetector;", "frameManager", "Lcom/tencent/kuikly/core/render/android/performace/frame/KRFrameDetector;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(@NotNull final a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
                KRFrameDetector.f118148i.f(listener);
            } else {
                KRFrameDetector.f118149m.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.performace.frame.KRFrameDetector$Companion$register$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRFrameDetector.f118148i.f(a.this);
                    }
                });
            }
        }

        public final void b(@NotNull final a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
                KRFrameDetector.f118148i.g(listener);
            } else {
                KRFrameDetector.f118149m.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.performace.frame.KRFrameDetector$Companion$unRegister$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRFrameDetector.f118148i.g(a.this);
                    }
                });
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void c() {
        if (!this.isStart && this.callbackList.size() != 0) {
            if (!this.isInit) {
                e();
            }
            Choreographer choreographer = this.choreographer;
            if (choreographer != null) {
                try {
                    choreographer.postFrameCallback(this);
                    this.isStart = true;
                } catch (Throwable th5) {
                    w.f392617a.b("KRFrameManager", com.tencent.kuikly.core.render.android.css.ktx.b.u(th5));
                }
                w.f392617a.a("KRFrameManager", "checkAndStart");
            }
        }
    }

    private final void d() {
        if (this.isStart && this.callbackList.size() <= 0) {
            try {
                Choreographer choreographer = this.choreographer;
                if (choreographer != null) {
                    choreographer.removeFrameCallback(this);
                }
                this.isStart = false;
            } catch (Throwable th5) {
                w.f392617a.b("KRFrameManager", com.tencent.kuikly.core.render.android.css.ktx.b.u(th5));
            }
            w.f392617a.a("KRFrameManager", "checkAndStop");
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        Choreographer choreographer;
        HashSet<a> hashSet = this.callbackList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : hashSet) {
            if (((a) obj).isOpen()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).doFrame(frameTimeNanos);
        }
        if (this.isStart && (choreographer = this.choreographer) != null) {
            choreographer.postFrameCallback(this);
        }
    }

    @UiThread
    public final void e() {
        if (this.isInit) {
            return;
        }
        try {
            this.choreographer = Choreographer.getInstance();
            this.isInit = true;
        } catch (Throwable th5) {
            w.f392617a.b("KRFrameManager", com.tencent.kuikly.core.render.android.css.ktx.b.u(th5));
        }
    }

    public final void f(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.callbackList.add(listener);
        c();
    }

    public final void g(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.callbackList.remove(listener);
        d();
    }
}
