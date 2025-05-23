package com.tencent.mobileqq.vas.comm.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.comm.api.ResCallback;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J)\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/comm/api/impl/GameCenterUnitedConfigApiImpl;", "Lcom/tencent/mobileqq/vas/comm/api/IGameCenterUnitedConfigApi;", "", "name", "", "isSwitchOn", "default", "", "T", "getConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "getConfigJsonObj", "Lcom/tencent/mobileqq/vas/comm/api/ResCallback;", "callback", "", "loadResConfigJsonObjAsync", "Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "getConfigManager", "()Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "configManager", "<init>", "()V", "Companion", "a", "qqvas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class GameCenterUnitedConfigApiImpl implements IGameCenterUnitedConfigApi {

    @NotNull
    private static final String TAG = "GameCenterUnitedConfigApiImpl";

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/comm/api/impl/GameCenterUnitedConfigApiImpl$b", "Lpy2/a;", "", DownloadInfo.spKey_Config, "", "b", "qqvas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements py2.a<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResCallback f308929a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f308930b;

        b(ResCallback resCallback, String str) {
            this.f308929a = resCallback;
            this.f308930b = str;
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable String config) {
            boolean z16;
            JSONObject jSONObject;
            if (config != null && config.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                ResCallback resCallback = this.f308929a;
                if (resCallback != null) {
                    resCallback.onLoad(new JSONObject());
                    return;
                }
                return;
            }
            try {
                jSONObject = new JSONObject(config);
            } catch (Throwable th5) {
                QLog.e(GameCenterUnitedConfigApiImpl.TAG, 1, "getConfigJsonObj " + this.f308930b + " fail.", th5);
                jSONObject = new JSONObject();
            }
            ResCallback resCallback2 = this.f308929a;
            if (resCallback2 != null) {
                resCallback2.onLoad(jSONObject);
            }
        }
    }

    public GameCenterUnitedConfigApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.vas.comm.api.impl.GameCenterUnitedConfigApiImpl$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new GsonBuilder().create();
            }
        });
        this.gson = lazy;
    }

    private final IUnitedConfigManager getConfigManager() {
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        return (IUnitedConfigManager) api;
    }

    private final Gson getGson() {
        Object value = this.gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
        return (Gson) value;
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi
    @NotNull
    public <T> T getConfig(@NotNull String name, @NotNull T r65) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(r65, "default");
        try {
            boolean z16 = false;
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(name, new byte[0]);
            if (loadRawConfig.length == 0) {
                z16 = true;
            }
            if (!z16) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                obj = getGson().fromJson(new String(loadRawConfig, UTF_8), (Class<Object>) r65.getClass());
            } else {
                obj = r65;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getConfig " + name + " fail.", th5);
            obj = null;
        }
        if (obj != null) {
            return (T) obj;
        }
        return r65;
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi
    @NotNull
    public JSONObject getConfigJsonObj(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            boolean z16 = false;
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(name, new byte[0]);
            if (loadRawConfig.length == 0) {
                z16 = true;
            }
            if (!z16) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new JSONObject(new String(loadRawConfig, UTF_8));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getConfigJsonObj " + name + " fail.", th5);
        }
        return new JSONObject();
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi
    public boolean isSwitchOn(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getConfigManager().isSwitchOn(name, false);
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi
    public void loadResConfigJsonObjAsync(@NotNull String name, @Nullable ResCallback callback) {
        Intrinsics.checkNotNullParameter(name, "name");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync(name, "", new b(callback, name));
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi
    public boolean isSwitchOn(@NotNull String name, boolean r36) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getConfigManager().isSwitchOn(name, r36);
    }
}
