package com.tencent.minibox.loader.base;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.dynamic.api.IServiceDelegate;
import com.tencent.minibox.loader.core.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J3\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0012H\u0014\u00a2\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010 \u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\"H\u0016J\u0012\u0010)\u001a\u00020*2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/minibox/loader/base/DelegatorService;", "Landroid/app/Service;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mServiceImpl", "Lcom/tencent/minibox/dynamic/api/IServiceDelegate;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dump", IjkMediaPlayer.OnNativeInvokeListener.ARG_FD, "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "getServiceImpl", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLowMemory", "onRebind", "onStart", "startId", "", "onStartCommand", WadlProxyConsts.FLAGS, "onTaskRemoved", "rootIntent", "onTrimMemory", "level", "onUnbind", "", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class DelegatorService extends Service {
    private final String TAG = getClass().getSimpleName();
    private IServiceDelegate mServiceImpl;

    private final IServiceDelegate getServiceImpl() {
        IServiceDelegate iServiceDelegate = this.mServiceImpl;
        if (iServiceDelegate != null) {
            return iServiceDelegate;
        }
        a aVar = a.f151655b;
        if (!aVar.b()) {
            return null;
        }
        IServiceDelegate serviceImpl = aVar.a().getServiceImpl(this);
        this.mServiceImpl = serviceImpl;
        return serviceImpl;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(@Nullable Context newBase) {
        super.attachBaseContext(newBase);
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.attachBaseContext(newBase);
        }
    }

    @Override // android.app.Service
    protected void dump(@Nullable FileDescriptor fd5, @Nullable PrintWriter writer, @Nullable String[] args) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.dump(fd5, writer, args);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            return serviceImpl.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "onCreate");
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(@Nullable Intent intent) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public void onStart(@Nullable Intent intent, int startId) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onStart(intent, startId);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            return serviceImpl.onStartCommand(intent, flags, startId);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onTaskRemoved(rootIntent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            serviceImpl.onTrimMemory(level);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(@Nullable Intent intent) {
        IServiceDelegate serviceImpl = getServiceImpl();
        if (serviceImpl != null) {
            return serviceImpl.onUnbind(intent);
        }
        return false;
    }
}
