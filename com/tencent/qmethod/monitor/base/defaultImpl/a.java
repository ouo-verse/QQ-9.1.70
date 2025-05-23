package com.tencent.qmethod.monitor.base.defaultImpl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.monitor.base.util.ProcessForegroundHelper;
import com.tencent.qmethod.pandoraex.api.f;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.monitor.MethodMonitor;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op.AppStateInfo;
import op.Config;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0002\u001b\u001e\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J,\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qmethod/monitor/base/defaultImpl/a;", "Lcom/tencent/qmethod/pandoraex/api/f;", "Lcom/tencent/qmethod/monitor/base/defaultImpl/c;", "Lcom/tencent/qmethod/pandoraex/api/a;", "", "init", "Lcom/tencent/qmethod/monitor/base/defaultImpl/b;", "callback", "b", "", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "a", "intent", "c", "", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "appStateCallbacks", "com/tencent/qmethod/monitor/base/defaultImpl/a$a", "Lcom/tencent/qmethod/monitor/base/defaultImpl/a$a;", "foregroundStateChangeListener", "com/tencent/qmethod/monitor/base/defaultImpl/a$b", "Lcom/tencent/qmethod/monitor/base/defaultImpl/a$b;", "loggerBridge", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a implements f, c, com.tencent.qmethod.pandoraex.api.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f343502e = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = TAG;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<com.tencent.qmethod.monitor.base.defaultImpl.b> appStateCallbacks = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final C9330a foregroundStateChangeListener = new C9330a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final b loggerBridge = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qmethod/monitor/base/defaultImpl/a$a", "Lop/e;", "", "appState", "Lcom/tdsrightly/tds/fg/observer/d;", "observer", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.base.defaultImpl.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9330a implements op.e {
        C9330a() {
        }

        @Override // op.e
        public void a(int appState, @NotNull com.tdsrightly.tds.fg.observer.d observer) {
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            a aVar = a.f343502e;
            o.a(a.f(aVar), "appState=" + appState + ", observer=" + observer.getName());
            if (appState != 1) {
                if (appState == 2) {
                    Iterator it = a.e(aVar).iterator();
                    while (it.hasNext()) {
                        ((com.tencent.qmethod.monitor.base.defaultImpl.b) it.next()).a(observer);
                    }
                    return;
                }
                return;
            }
            Iterator it5 = a.e(aVar).iterator();
            while (it5.hasNext()) {
                ((com.tencent.qmethod.monitor.base.defaultImpl.b) it5.next()).b(observer);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qmethod/monitor/base/defaultImpl/a$b", "Lop/f;", "", "tag", "msg", "", "d", "e", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements op.f {
        b() {
        }

        @Override // op.f
        public void d(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            o.a(tag, msg2);
        }

        @Override // op.f
        public void e(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            o.c(tag, msg2);
        }
    }

    a() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList e(a aVar) {
        return appStateCallbacks;
    }

    public static final /* synthetic */ String f(a aVar) {
        return TAG;
    }

    @Override // com.tencent.qmethod.pandoraex.api.a
    public void a(@Nullable Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        np.a.c(activity, 1);
    }

    @Override // com.tencent.qmethod.monitor.base.defaultImpl.c
    public void b(@NotNull com.tencent.qmethod.monitor.base.defaultImpl.b callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        appStateCallbacks.add(callback);
    }

    @Override // com.tencent.qmethod.pandoraex.api.a
    public void c(@Nullable Activity activity, @Nullable Intent intent) {
        np.a.c(activity, 0);
    }

    @Override // com.tencent.qmethod.pandoraex.api.f
    public boolean d() {
        boolean z16;
        AppStateInfo a16 = np.a.a();
        if (2 != a16.getState()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ProcessForegroundHelper.f343520g.k(z16, a16.getName());
        return z16;
    }

    @Override // com.tencent.qmethod.monitor.base.defaultImpl.c
    public void init() {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        Application context = aVar.g().getContext();
        Config config = new Config(aVar.g().getDebug());
        config.f(loggerBridge);
        config.g(foregroundStateChangeListener);
        config.e(null);
        np.a.b(context, config);
        MethodMonitor.registerImplClass(this);
        o.a(TAG, com.tencent.tmdownloader.a.CONNTECTSTATE_INIT);
    }
}
