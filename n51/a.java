package n51;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.WorkerThread;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.dynamic.api.IMiniBoxApi;
import com.tencent.minibox.loader.MiniBoxService;
import com.tencent.minibox.loader.core.PluginVersionManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p51.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u001c\u0010 \u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Ln51/a;", "Landroid/content/ServiceConnection;", "Landroid/content/Context;", "context", "", "b", "Landroid/os/IBinder;", "service", "d", "g", "i", "", "uin", "f", "Lcom/tencent/minibox/dynamic/api/IMiniBoxApi;", "c", "", "e", "Landroid/content/ComponentName;", "name", "onServiceConnected", "onServiceDisconnected", h.F, "a", "Lcom/tencent/minibox/dynamic/api/IMiniBoxApi;", "mMiniBoxApiImpl", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "mConnectLock", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/locks/Condition;", "mConnectCondition", "", "J", "startConnectTime", "Ln51/a$a;", "Ln51/a$a;", "exitReceiver", "Ljava/lang/ref/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "contextRef", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes9.dex */
public final class a implements ServiceConnection {
    public static final a C = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile IMiniBoxApi mMiniBoxApiImpl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock mConnectLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Condition mConnectCondition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long startConnectTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static C10825a exitReceiver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Context> contextRef;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ln51/a$a;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: n51.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C10825a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String str;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual("com.tencent.minibox.miniboxprocess.will.die", str)) {
                LogUtils.i("MiniBoxEngineLoader", "ExitVAReceiver unBindService");
                a.C.h();
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        mConnectLock = reentrantLock;
        mConnectCondition = reentrantLock.newCondition();
    }

    a() {
    }

    private final void b(Context context) {
        startConnectTime = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) MiniBoxService.class);
        try {
            LogUtils.i("MiniBoxEngineLoader", "connectMiniBoxService: begin bindService.");
            context.bindService(intent, this, 65);
            context.startService(intent);
            contextRef = new WeakReference<>(context);
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngineLoader", "connectMiniBoxService exception.", e16);
            d(null);
        }
    }

    private final void d(IBinder service) {
        if (service != null) {
            mMiniBoxApiImpl = IMiniBoxApi.Stub.asInterface(service);
            g();
            LogUtils.i("MiniBoxEngineLoader", "handleConnectResult: mMiniBoxApiImpl is ready.");
        } else {
            mMiniBoxApiImpl = null;
            i();
            LogUtils.e("MiniBoxEngineLoader", "handleConnectResult: mMiniBoxApiImpl is null.");
        }
        ReentrantLock reentrantLock = mConnectLock;
        reentrantLock.lock();
        try {
            try {
                mConnectCondition.signalAll();
            } catch (Exception e16) {
                LogUtils.e("MiniBoxEngineLoader", "handleConnectResult: countDown exception.", e16);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void g() {
        Context context;
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null && (context = weakReference.get()) != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.minibox.miniboxprocess.will.die");
            C10825a c10825a = new C10825a();
            exitReceiver = c10825a;
            context.registerReceiver(c10825a, intentFilter);
        }
    }

    private final void i() {
        Context context;
        if (exitReceiver == null) {
            return;
        }
        try {
            WeakReference<Context> weakReference = contextRef;
            if (weakReference != null && (context = weakReference.get()) != null) {
                context.unregisterReceiver(exitReceiver);
            }
            exitReceiver = null;
        } catch (Exception e16) {
            LogUtils.e("MiniBoxEngineLoader", "ExitVAReceiver unRegisterExitReceiver Exception:" + e16);
        }
    }

    public final synchronized boolean a(@NotNull Context context, @NotNull String uin) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        return PluginVersionManager.f151646b.e(context, uin);
    }

    @WorkerThread
    @Nullable
    public final IMiniBoxApi c(@NotNull Context context, @NotNull String uin) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        if (!c.f425348c.b()) {
            LogUtils.e("MiniBoxEngineLoader", "getMiniBoxApi: isArm64 false.");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (e()) {
            LogUtils.i("MiniBoxEngineLoader", "getMiniBoxApi: api valid!");
            return mMiniBoxApiImpl;
        }
        ReentrantLock reentrantLock = mConnectLock;
        reentrantLock.lock();
        try {
            a aVar = C;
            if (aVar.e()) {
                return mMiniBoxApiImpl;
            }
            try {
                if (aVar.a(context, uin)) {
                    aVar.b(context);
                    mConnectCondition.await(6000L, TimeUnit.MILLISECONDS);
                } else {
                    LogUtils.e("MiniBoxEngineLoader", "getMiniBoxApi: dex is not installed!");
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e16) {
                LogUtils.e("MiniBoxEngineLoader", "getMiniBoxApi: await exception.", e16);
                Unit unit2 = Unit.INSTANCE;
            }
            reentrantLock.unlock();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getMiniBoxApi: return isValid=");
            if (mMiniBoxApiImpl != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(',');
            sb5.append("cost=");
            sb5.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtils.i("MiniBoxEngineLoader", sb5.toString());
            return mMiniBoxApiImpl;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean e() {
        IBinder asBinder;
        IMiniBoxApi iMiniBoxApi = mMiniBoxApiImpl;
        if (iMiniBoxApi != null && (asBinder = iMiniBoxApi.asBinder()) != null && asBinder.isBinderAlive()) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull Context context, @NotNull String uin) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        c(context, uin);
    }

    public final void h() {
        Context context;
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null && (context = weakReference.get()) != null) {
            a aVar = C;
            context.unbindService(aVar);
            aVar.d(null);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
        LogUtils.i("MiniBoxEngineLoader", "onServiceConnected: total time=" + (System.currentTimeMillis() - startConnectTime));
        d(service);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@Nullable ComponentName name) {
        LogUtils.e("MiniBoxEngineLoader", "onServiceDisconnected");
        d(null);
    }
}
