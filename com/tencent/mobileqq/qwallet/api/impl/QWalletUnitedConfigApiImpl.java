package com.tencent.mobileqq.qwallet.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J)\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletUnitedConfigApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletUnitedConfigApi;", "", "name", "", "isSwitchOn", "default", "", "T", "getConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getStringConfig", "Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "getConfigManager", "()Lcom/tencent/mobileqq/unitedconfig_android/api/IUnitedConfigManager;", "configManager", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletUnitedConfigApiImpl implements IQWalletUnitedConfigApi {

    @NotNull
    private static final String TAG = "IQWalletUnitedConfigApi";

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gson;

    public QWalletUnitedConfigApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletUnitedConfigApiImpl$gson$2
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

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi
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

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi
    @NotNull
    public String getStringConfig(@NotNull String name, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(r56, "default");
        boolean z16 = false;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(name, new byte[0]);
        if (loadRawConfig.length == 0) {
            z16 = true;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new String(loadRawConfig, UTF_8);
        }
        return r56;
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi
    public boolean isSwitchOn(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getConfigManager().isSwitchOn(name, false);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi
    public boolean isSwitchOn(@NotNull String name, boolean r36) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getConfigManager().isSwitchOn(name, r36);
    }
}
