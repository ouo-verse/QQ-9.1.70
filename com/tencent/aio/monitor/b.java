package com.tencent.aio.monitor;

import android.view.Choreographer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.monitor.sampler.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J$\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aio/monitor/b;", "Lcom/tencent/aio/monitor/a;", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "lines", "slowMethods", "", "l", "e", "f", "doFrame", "Lcom/tencent/aio/monitor/frame/b;", "Lcom/tencent/aio/monitor/frame/b;", "mFrameCallbackCycle", BdhLogUtil.LogTag.Tag_Conn, "J", "mStartSampleTimeInNs", "Lcom/tencent/aio/monitor/c;", "mMonitorArgs", "<init>", "(Lcom/tencent/aio/monitor/c;)V", UserInfo.SEX_FEMALE, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b extends a implements Choreographer.FrameCallback {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final List<String> D;

    @NotNull
    private static final List<String> E;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mStartSampleTimeInNs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.monitor.frame.b mFrameCallbackCycle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/monitor/b$a;", "", "", "blackMethod", "", "a", "b", "", "sBlackMethods", "Ljava/util/List;", "c", "()Ljava/util/List;", "sWhiteMethods", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.monitor.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final void a(@NotNull String blackMethod) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) blackMethod);
            } else {
                Intrinsics.checkNotNullParameter(blackMethod, "blackMethod");
                c().add(blackMethod);
            }
        }

        public final void b(@NotNull String blackMethod) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) blackMethod);
            } else {
                Intrinsics.checkNotNullParameter(blackMethod, "blackMethod");
                d().add(blackMethod);
            }
        }

        @NotNull
        public final List<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return b.D;
            }
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final List<String> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.E;
            }
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        List<String> mutableListOf;
        List<String> mutableListOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("java.lang.Object.wait", "java.lang.String.format", "java.lang.Thread.nativeCreate", "sun.misc.Unsafe.park", "java.io.File.exists", "java.io.FileInputStream.close", "java.lang.Class.getAnnotation", "java.lang.Class.getDeclaredAnnotation", "java.lang.Class.getDeclaredField", "java.lang.Class.getDeclaredMethods", "java.lang.Exception.printStackTrace", "android.app.ContextImpl.getFilesDir", "android.app.ContextImpl.getSharedPreferences", "android.app.SharedPerferencesImpl.edit", "android.graphics.Paint.measureText", "android.os.HandlerThread.getLooper", "android.util.Log.getStackTraceString", "android.view.LayoutInflater.inflate", "com.google.gson.Gson.fromJson", "java.text.DateFormat.is24HourFormat", "java.text.SimpleDateFromate.<init>", "java.text.SimpleDateFromate.format", "java.util.concurrent.CountDownLatch.await", "java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire", "java.util.concurrent.locks.LockSupport.park", "java.util.concurrent.locks.ReentrantLock.lock", "java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock.lock", "java.util.Timer.init", "org.json.JSONObject.writeTo");
        D = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("android.os.MessageQueue.nativePollOnce", "android.content.res.Resource.loadDrawable", "android.widget.Button.<init>", "android.widget.CheckBox.<init>", "android.widget.ProgressBar.<init>", "android.os.BinderProxy.transact", "java.lang.Class.forName", "android.content.res.AssetManager.getResourceValue", "android.content.res.AssetManager.nativeOpenNonAsset", "android.content.res.AssetManager.nativeGetResourceValue", "android.content.res.AssetManager.nativeOpenXmlAsset");
        E = mutableListOf2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull c mMonitorArgs) {
        super(mMonitorArgs);
        Intrinsics.checkNotNullParameter(mMonitorArgs, "mMonitorArgs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mMonitorArgs);
        } else {
            this.mFrameCallbackCycle = new com.tencent.aio.monitor.frame.b(mMonitorArgs, this);
        }
    }

    private final boolean l(List<String> lines, List<String> slowMethods) {
        boolean startsWith$default;
        for (String str : lines) {
            Iterator<String> it = slowMethods.iterator();
            while (it.hasNext()) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, it.next(), false, 2, null);
                if (startsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void m() {
        long currentTimeMillis = System.currentTimeMillis();
        LinkedHashMap<Long, a.b> i3 = c().i(d(), currentTimeMillis);
        if (i3.isEmpty()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("thread : " + c().j());
        sb5.append(", \u603b\u5361\u987f:");
        sb5.append(currentTimeMillis - d());
        sb5.append(" ms ");
        sb5.append("******************************");
        sb5.append(" \r\n ");
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "strBuilder.toString()");
        aVar.d("MainThreadMonitor", sb6);
        for (Long l3 : i3.keySet()) {
            a.b bVar = i3.get(l3);
            if (bVar != null) {
                Intrinsics.checkNotNullExpressionValue(bVar, "stacks[entryTime] ?: continue");
                String format = com.tencent.aio.monitor.helper.a.f69420b.c().format(l3);
                sb5.setLength(0);
                sb5.append(format);
                sb5.append(", ");
                sb5.append(bVar);
                sb5.append(" \r\n ");
                if (bVar.a() > com.tencent.aio.monitor.sampler.a.INSTANCE.a()) {
                    com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
                    String sb7 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb7, "strBuilder.toString()");
                    aVar2.e("MainThreadMonitor_serious", sb7);
                } else if (l(bVar.c(), E)) {
                    com.tencent.aio.base.log.a aVar3 = com.tencent.aio.base.log.a.f69187b;
                    String sb8 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb8, "strBuilder.toString()");
                    aVar3.d("MainThreadMonitor_white", sb8);
                } else if (l(bVar.c(), D)) {
                    com.tencent.aio.base.log.a aVar4 = com.tencent.aio.base.log.a.f69187b;
                    String sb9 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb9, "strBuilder.toString()");
                    aVar4.e("MainThreadMonitor_black", sb9);
                } else {
                    com.tencent.aio.base.log.a aVar5 = com.tencent.aio.base.log.a.f69187b;
                    String sb10 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb10, "strBuilder.toString()");
                    aVar5.e("MainThreadMonitor_vague", sb10);
                }
            }
        }
    }

    private final void n(long frameTimeNanos) {
        if (com.tencent.aio.monitor.helper.a.f69420b.a(this.mStartSampleTimeInNs, frameTimeNanos, b().b()) <= b().a()) {
            return;
        }
        m();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, frameTimeNanos);
            return;
        }
        if (this.mStartSampleTimeInNs != 0 && d() != 0) {
            n(frameTimeNanos);
        }
        this.mStartSampleTimeInNs = frameTimeNanos;
        g(System.currentTimeMillis());
        c().d();
    }

    @Override // com.tencent.aio.monitor.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFrameCallbackCycle.a();
        }
    }

    @Override // com.tencent.aio.monitor.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mFrameCallbackCycle.b();
        }
    }
}
