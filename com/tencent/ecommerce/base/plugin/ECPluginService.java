package com.tencent.ecommerce.base.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\"\u0010\u0011\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginService;", "Landroid/app/Service;", "Ljava/util/HashMap;", "", "params", "", "ptsReady", "", "a", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "onCreate", "", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "<init>", "()V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPluginService extends Service {
    private final void a(HashMap<String, String> params, boolean ptsReady) {
        HashMap<Object, Object> hashMapOf;
        c cVar = c.f100897c;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("pts_ready", Boolean.valueOf(ptsReady)));
        cVar.f("master-3318", params, hashMapOf);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited()) {
            Log.e("ECPluginService", "onCreate: QQEcommerceSdk have not inited");
            stopSelf();
            return;
        }
        ECPluginApplication.Companion companion = ECPluginApplication.INSTANCE;
        if (!companion.b()) {
            companion.c(getApplication());
        }
        IECPluginServiceDelegate pluginServiceDelegate = qQEcommerceSdk.getGlobalInternalSdk().getPluginServiceDelegate();
        if (pluginServiceDelegate != null) {
            pluginServiceDelegate.onCreate();
        }
        cg0.a.b("ECPluginService", "onCreate");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited()) {
            Log.e("ECPluginService", "onStartCommand: QQEcommerceSdk have not inited");
            return 2;
        }
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(ASEngineConstants.ShadowEngineKey.KEY_PLUGIN_EXTRAS_HASH_MAP) : null;
        HashMap<String, String> hashMap = (HashMap) (serializableExtra instanceof HashMap ? serializableExtra : null);
        IECPluginServiceDelegate pluginServiceDelegate = qQEcommerceSdk.getGlobalInternalSdk().getPluginServiceDelegate();
        if (pluginServiceDelegate != null) {
            pluginServiceDelegate.onStartCommand(hashMap);
        }
        cg0.a.b("ECPluginService", "onStartCommand, intent=" + intent + ", flags=" + flags + ", startId=" + startId + ", extra=" + hashMap);
        boolean a16 = xg0.a.f447957b.a();
        if (hashMap != null) {
            b.f100883a.f(hashMap);
            a(hashMap, a16);
        }
        return 2;
    }
}
