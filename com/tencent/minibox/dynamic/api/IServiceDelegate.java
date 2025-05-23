package com.tencent.minibox.dynamic.api;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J3\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001cH&J\"\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001cH&J\u0012\u0010#\u001a\u00020$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/minibox/dynamic/api/IServiceDelegate;", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dump", IjkMediaPlayer.OnNativeInvokeListener.ARG_FD, "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "", "", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLowMemory", "onRebind", "onStart", "startId", "", "onStartCommand", WadlProxyConsts.FLAGS, "onTaskRemoved", "rootIntent", "onTrimMemory", "level", "onUnbind", "", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface IServiceDelegate {
    void attachBaseContext(@Nullable Context newBase);

    void dump(@Nullable FileDescriptor fd5, @Nullable PrintWriter writer, @Nullable String[] args);

    @Nullable
    IBinder onBind(@Nullable Intent intent);

    void onConfigurationChanged(@NotNull Configuration newConfig);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(@Nullable Intent intent);

    void onStart(@Nullable Intent intent, int startId);

    int onStartCommand(@Nullable Intent intent, int flags, int startId);

    void onTaskRemoved(@Nullable Intent rootIntent);

    void onTrimMemory(int level);

    boolean onUnbind(@Nullable Intent intent);
}
