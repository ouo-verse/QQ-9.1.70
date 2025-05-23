package com.tencent.mobileqq.qwallet.sp;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.sp.QWalletSp;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/sp/QWalletSpFactory;", "", "", "spName", "", "spMode", "Lcom/tencent/mobileqq/qwallet/sp/QWalletSp;", "a", "Landroid/content/SharedPreferences;", "b", "Ljava/lang/Object;", "LOCK", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "autoMigrateSpPool", "Lorg/json/JSONObject;", "d", "Lkotlin/Lazy;", "()Lorg/json/JSONObject;", "toggleConfig", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletSpFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletSpFactory f279195a = new QWalletSpFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object LOCK = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, QWalletSp> autoMigrateSpPool = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy toggleConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.qwallet.sp.QWalletSpFactory$toggleConfig$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONObject invoke() {
                return ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).getJSONObject(IQWalletFeatureApi.QWALLET_SP_MIGRATE_CONFIG);
            }
        });
        toggleConfig = lazy;
    }

    QWalletSpFactory() {
    }

    @JvmStatic
    @NotNull
    public static final QWalletSp a(@NotNull String spName, int spMode) {
        boolean z16;
        QWalletSp qWalletSp;
        Intrinsics.checkNotNullParameter(spName, "spName");
        QWalletSpFactory qWalletSpFactory = f279195a;
        JSONObject c16 = qWalletSpFactory.c();
        boolean z17 = true;
        if (c16 != null && c16.getBoolean("is_force_legacy_sp")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new QWalletSp.a(qWalletSpFactory.b(spName, spMode));
        }
        SharedPreferences mmkvAdapter = QMMKV.fromSpAdapter(BaseApplication.context, spName, QMMKVFile.FILE_QWALLET);
        if (mmkvAdapter.getBoolean("is_sp_migrated_" + spName, false)) {
            Intrinsics.checkNotNullExpressionValue(mmkvAdapter, "mmkvAdapter");
            return new QWalletSp.b(mmkvAdapter);
        }
        JSONObject c17 = qWalletSpFactory.c();
        if (c17 == null || !c17.getBoolean("is_disable_auto_migrate")) {
            z17 = false;
        }
        if (z17) {
            return new QWalletSp.a(qWalletSpFactory.b(spName, spMode));
        }
        synchronized (LOCK) {
            ConcurrentHashMap<String, QWalletSp> concurrentHashMap = autoMigrateSpPool;
            QWalletSp qWalletSp2 = concurrentHashMap.get(spName);
            if (qWalletSp2 == null) {
                SharedPreferences b16 = qWalletSpFactory.b(spName, spMode);
                Intrinsics.checkNotNullExpressionValue(mmkvAdapter, "mmkvAdapter");
                qWalletSp2 = new QWalletSp.AutoMigrate(spName, b16, mmkvAdapter);
                QWalletSp putIfAbsent = concurrentHashMap.putIfAbsent(spName, qWalletSp2);
                if (putIfAbsent != null) {
                    qWalletSp2 = putIfAbsent;
                }
            }
            qWalletSp = qWalletSp2;
        }
        Intrinsics.checkNotNullExpressionValue(qWalletSp, "{\n            // \u672a\u8fc1\u79fb\u5230MMK\u2026}\n            }\n        }");
        return qWalletSp;
    }

    private final SharedPreferences b(String spName, int spMode) {
        SharedPreferences sharedPreferences = BaseApplication.context.getSharedPreferences(spName, spMode);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPreferences(spName, spMode)");
        return sharedPreferences;
    }

    private final JSONObject c() {
        return (JSONObject) toggleConfig.getValue();
    }
}
