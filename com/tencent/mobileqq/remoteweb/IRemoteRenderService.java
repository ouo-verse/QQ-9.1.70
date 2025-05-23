package com.tencent.mobileqq.remoteweb;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "", "onBind", "Landroid/os/IBinder;", "service", "Landroid/app/Service;", "intent", "Landroid/content/Intent;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onLowMemory", "onStartCommand", "", WadlProxyConsts.FLAGS, "startId", "onTaskRemoved", "onTrimMemory", "level", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public interface IRemoteRenderService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        @Nullable
        public static IBinder a(@NotNull IRemoteRenderService iRemoteRenderService, @NotNull Service service, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(intent, "intent");
            return null;
        }

        public static void b(@NotNull IRemoteRenderService iRemoteRenderService, @NotNull Service service) {
            Intrinsics.checkNotNullParameter(service, "service");
        }

        public static void c(@NotNull IRemoteRenderService iRemoteRenderService, @NotNull Service service, @Nullable Intent intent) {
            Intrinsics.checkNotNullParameter(service, "service");
        }

        public static void d(@NotNull IRemoteRenderService iRemoteRenderService, @NotNull Service service, int i3) {
            Intrinsics.checkNotNullParameter(service, "service");
        }
    }

    @Nullable
    IBinder onBind(@NotNull Service service, @NotNull Intent intent);

    void onDestroy(@NotNull Service service);

    void onLowMemory(@NotNull Service service);

    int onStartCommand(@NotNull Service service, @NotNull Intent intent, int flags, int startId);

    void onTaskRemoved(@NotNull Service service, @Nullable Intent intent);

    void onTrimMemory(@NotNull Service service, int level);
}
