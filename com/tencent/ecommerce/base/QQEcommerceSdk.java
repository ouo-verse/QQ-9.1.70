package com.tencent.ecommerce.base;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.ecommerce.base.plugin.ECPluginServiceEvent;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH\u0002J,\u0010\r\u001a\u00020\u000b2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH\u0007J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007JB\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0007J>\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016H\u0007J^\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0007J6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007JZ\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0019\u001a\u00020\u00132\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007JZ\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0014\u001a\u00020\u00132\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016H\u0007J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$R\u0014\u0010'\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u0010/\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010-R0\u00104\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R0\u00106\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00105R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010:\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00028\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006@"}, d2 = {"Lcom/tencent/ecommerce/base/QQEcommerceSdk;", "", "Lcom/tencent/ecommerce/base/a;", ReadInJoyMMapKvStorage.NAME_DEFAULT, "init", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "", "callService", "callServiceInNative", "url", "jumpScheme", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "callback", "extData", "", "logicType", "hashMap", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callLogic", "createSchemeRequestParams", "target", "createLogicRequestParams", "", "isInitialized", "releaseAllCallbacks", "releaseAllSchemeCallbacks", "releaseLogicCallback", "hashCode", "Lcom/tencent/ecommerce/base/plugin/d;", "event", "onEvent", "Landroid/os/Message;", "msg", "handleMessage", "TAG", "Ljava/lang/String;", "MSG_RELEASE_ALL_SCHEME_CALLBACK", "I", "", "DELAY_RELEASE_ALL_SCHEME_CALLBACK", "J", "<set-?>", "hasInited", "Z", "getHasInited", "()Z", "createGlobalExternalCost", "schemeCallbacks", "Ljava/util/HashMap;", "logicCallbacks", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "globalInternalSdk", "Lcom/tencent/ecommerce/base/a;", "getGlobalInternalSdk", "()Lcom/tencent/ecommerce/base/a;", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class QQEcommerceSdk {
    private static final long DELAY_RELEASE_ALL_SCHEME_CALLBACK = 5000;
    private static final int MSG_RELEASE_ALL_SCHEME_CALLBACK = 1;
    private static final String TAG = "QQEcommerceSdk";
    private static long createGlobalExternalCost;
    private static QQECGlobalInternalSdk globalInternalSdk;
    private static boolean hasInited;

    @NotNull
    public static final QQEcommerceSdk INSTANCE = new QQEcommerceSdk();
    private static final HashMap<String, IECSchemeCallback> schemeCallbacks = new HashMap<>();
    private static final HashMap<String, IECLogicCallback> logicCallbacks = new HashMap<>();
    private static final Handler handler = new Handler(Looper.getMainLooper(), a.f100556d);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "msg", "Landroid/os/Message;", "handleMessage"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    static final class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        public static final a f100556d = new a();

        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(@NotNull Message message) {
            return QQEcommerceSdk.INSTANCE.handleMessage(message);
        }
    }

    QQEcommerceSdk() {
    }

    public static final /* synthetic */ QQECGlobalInternalSdk access$getGlobalInternalSdk$p(QQEcommerceSdk qQEcommerceSdk) {
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        return qQECGlobalInternalSdk;
    }

    @JvmStatic
    public static final void callLogic(int logicType, @NotNull HashMap<String, String> hashMap, @Nullable IECLogicCallback callback) {
        HashMap<String, String> createLogicRequestParams = createLogicRequestParams(logicType, hashMap, callback);
        QQEcommerceSdk qQEcommerceSdk = INSTANCE;
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        qQEcommerceSdk.callService(qQECGlobalInternalSdk.getRuntime().getExternalApplicationContext(), createLogicRequestParams);
    }

    private final void callService(Context context, HashMap<String, String> params) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.tencent.ecommerce.base.plugin.ECPluginService");
            intent.putExtra(ASEngineConstants.ShadowEngineKey.KEY_PLUGIN_EXTRAS_HASH_MAP, params);
            context.getApplicationContext().startService(intent);
        } catch (Exception e16) {
            QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
            if (qQECGlobalInternalSdk == null) {
                Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
            }
            qQECGlobalInternalSdk.getLogger().logError(TAG, "callService error, package=" + context.getPackageName() + ", service=com.tencent.ecommerce.base.plugin.ECPluginService, params=" + params + ", exception=" + e16);
        }
    }

    @JvmStatic
    public static final void callServiceInNative(@NotNull HashMap<String, String> params) {
        QQEcommerceSdk qQEcommerceSdk = INSTANCE;
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        qQEcommerceSdk.callService(qQECGlobalInternalSdk.getRuntime().getExternalApplicationContext(), params);
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> createLogicRequestParams(int logicType, @NotNull HashMap<String, String> hashMap, @Nullable IECLogicCallback callback) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.putAll(hashMap);
        hashMap2.put(TraeConstants.KEY_OPERATION, "LOGIC");
        hashMap2.put("KEY_LOGIC_TYPE", String.valueOf(logicType));
        if (callback != null) {
            String valueOf = String.valueOf(callback.hashCode());
            hashMap2.put("KEY_CALLBACK", valueOf);
            logicCallbacks.put(valueOf, callback);
        }
        return hashMap2;
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> createSchemeRequestParams(@NotNull String url, @Nullable IECSchemeCallback callback, @Nullable HashMap<String, String> extData) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (extData != null) {
            hashMap.put("KEY_SCHEME_EXT_DATA", String.valueOf(true));
            hashMap.putAll(extData);
        }
        hashMap.put(TraeConstants.KEY_OPERATION, "SCHEME");
        hashMap.put("KEY_SCHEME", url);
        if (callback != null) {
            handler.removeMessages(1);
            String valueOf = String.valueOf(callback.hashCode());
            hashMap.put("KEY_CALLBACK", valueOf);
            schemeCallbacks.put(valueOf, callback);
        }
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final QQEcommerceSdk init(@NotNull QQECGlobalInternalSdk global) {
        QQEcommerceSdk qQEcommerceSdk = INSTANCE;
        hasInited = true;
        globalInternalSdk = global;
        if (global == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        global.getLogger().logInfo(TAG, "[init] createGlobalExternalCost=" + createGlobalExternalCost);
        return qQEcommerceSdk;
    }

    @JvmStatic
    public static final void jumpScheme(@NotNull String url) {
        jumpScheme(url, null);
    }

    @NotNull
    public final QQECGlobalInternalSdk getGlobalInternalSdk() {
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        return qQECGlobalInternalSdk;
    }

    public final boolean getHasInited() {
        return hasInited;
    }

    public final boolean handleMessage(@NotNull Message msg2) {
        if (msg2.what != 1) {
            return false;
        }
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        qQECGlobalInternalSdk.getLogger().logInfo(TAG, "[handleMessage] MSG_RELEASE_ALL_SCHEME_CALLBACK");
        schemeCallbacks.clear();
        return true;
    }

    public final boolean isInitialized() {
        if (globalInternalSdk != null) {
            return true;
        }
        return false;
    }

    public final void onEvent(@NotNull ECPluginServiceEvent event) {
        boolean z16;
        IECSchemeCallback iECSchemeCallback;
        Boolean bool;
        String str = event.a().get(TraeConstants.KEY_OPERATION);
        String str2 = event.a().get("KEY_CALLBACK");
        if (str2 != null) {
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1854658139) {
                    if (hashCode == 72611646 && str.equals("LOGIC")) {
                        HashMap<String, IECLogicCallback> hashMap = logicCallbacks;
                        IECLogicCallback iECLogicCallback = hashMap.get(str2);
                        if (iECLogicCallback != null) {
                            Object result = event.getResult();
                            if (result != null) {
                                iECLogicCallback.onResult((HashMap) result);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
                            }
                        }
                        String str3 = event.a().get("KEY_KEEP_CALLBACK");
                        if (str3 != null) {
                            bool = Boolean.valueOf(Boolean.parseBoolean(str3));
                        } else {
                            bool = null;
                        }
                        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                            hashMap.remove(str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (str.equals("SCHEME") && (iECSchemeCallback = schemeCallbacks.get(str2)) != null) {
                    Object result2 = event.getResult();
                    if (result2 != null) {
                        iECSchemeCallback.onCallbackFinished((JSONObject) result2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        }
    }

    public final void releaseAllCallbacks() {
        schemeCallbacks.clear();
        logicCallbacks.clear();
    }

    public final void releaseAllSchemeCallbacks() {
        handler.sendEmptyMessageDelayed(1, 5000L);
    }

    public final void releaseLogicCallback(@NotNull IECLogicCallback callback) {
        releaseLogicCallback(String.valueOf(callback.hashCode()));
    }

    @JvmStatic
    public static final void jumpScheme(@NotNull String url, @Nullable IECSchemeCallback callback) {
        jumpScheme(url, callback, null);
    }

    public final void releaseLogicCallback(@NotNull String hashCode) {
        logicCallbacks.remove(hashCode);
    }

    @JvmStatic
    public static final void jumpScheme(@NotNull String url, @Nullable IECSchemeCallback callback, @Nullable HashMap<String, String> extData) {
        HashMap<String, String> createSchemeRequestParams = createSchemeRequestParams(url, callback, extData);
        QQEcommerceSdk qQEcommerceSdk = INSTANCE;
        QQECGlobalInternalSdk qQECGlobalInternalSdk = globalInternalSdk;
        if (qQECGlobalInternalSdk == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalInternalSdk");
        }
        qQEcommerceSdk.callService(qQECGlobalInternalSdk.getRuntime().getExternalApplicationContext(), createSchemeRequestParams);
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> createSchemeRequestParams(@NotNull String url, @Nullable IECSchemeCallback callback) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TraeConstants.KEY_OPERATION, "SCHEME");
        hashMap.put("KEY_SCHEME", url);
        if (callback != null) {
            handler.removeMessages(1);
            String valueOf = String.valueOf(callback.hashCode());
            hashMap.put("KEY_CALLBACK", valueOf);
            schemeCallbacks.put(valueOf, callback);
        }
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> createSchemeRequestParams(int target, @NotNull HashMap<String, String> hashMap, @Nullable IECSchemeCallback callback) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.putAll(hashMap);
        hashMap2.put(TraeConstants.KEY_OPERATION, "SCHME_BY_TARGET");
        hashMap2.put("KEY_TARGET", String.valueOf(target));
        if (callback != null) {
            handler.removeMessages(1);
            String valueOf = String.valueOf(callback.hashCode());
            hashMap2.put("KEY_CALLBACK", valueOf);
            schemeCallbacks.put(valueOf, callback);
        }
        return hashMap2;
    }
}
