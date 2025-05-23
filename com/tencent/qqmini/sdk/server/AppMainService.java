package com.tencent.qqmini.sdk.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@MiniKeep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/sdk/server/AppMainService;", "Landroid/app/Service;", "", "onCreate", "Landroid/content/Intent;", "intent", "", "startId", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onUnbind", "Landroid/os/IBinder;", "onBind", "<init>", "()V", "Companion", "a", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class AppMainService extends Service {
    private static final String TAG = "AppMainService";

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String stringExtra = intent.getStringExtra("mini_process_name");
        Messenger messenger = (Messenger) intent.getParcelableExtra(IPCConst.BUNDLE_KEY_MESSENGER);
        QMLog.i(TAG, "AppMainService onBind pName=" + stringExtra + ", messenger:" + messenger + ", type: " + intent.getType());
        AppLoaderFactory g16 = AppLoaderFactory.g();
        Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
        IMiniServer miniServer = g16.getMiniServer();
        miniServer.registerClientMessenger(stringExtra, messenger);
        Intrinsics.checkExpressionValueIsNotNull(miniServer, "miniServer");
        return miniServer.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        MiniSDK.init(getApplicationContext());
        QMLog.i(TAG, "AppMainService Service onCreate~~~");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        QMLog.i(TAG, "AppMainService Service onDestroy~~~");
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(@NotNull Intent intent, int startId) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        QMLog.i(TAG, "AppMainService Service onStart~~~");
        super.onStart(intent, startId);
    }

    @Override // android.app.Service
    public boolean onUnbind(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        QMLog.i(TAG, "AppMainService Service onUnbind pName=" + intent.getStringExtra("mini_process_name"));
        return super.onUnbind(intent);
    }
}
