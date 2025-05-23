package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ay;", "", "", "key", "", "default", "b", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ay {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ay f326693a = new ay();

    ay() {
    }

    public final double a(@NotNull String key, double r65) {
        Intrinsics.checkNotNullParameter(key, "key");
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        try {
            return Double.parseDouble(((IUnitedConfigManager) api).loadAsString(key, String.valueOf(r65)));
        } catch (NumberFormatException e16) {
            w53.b.d("WinkUnitedConfigManager", "\u89e3\u6790\u5c0f\u6570\u9519\u8bef\uff0c\u952e\u4e3a: " + key, e16);
            return r65;
        } catch (Exception e17) {
            w53.b.d("WinkUnitedConfigManager", "\u952e\u4e3a " + key + " \u7684\u610f\u5916\u9519\u8bef", e17);
            return r65;
        }
    }

    public final int b(@NotNull String key, int r65) {
        Intrinsics.checkNotNullParameter(key, "key");
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        try {
            return Integer.parseInt(((IUnitedConfigManager) api).loadAsString(key, String.valueOf(r65)));
        } catch (NumberFormatException e16) {
            w53.b.d("WinkUnitedConfigManager", "\u89e3\u6790\u6574\u6570\u9519\u8bef\uff0c\u952e\u4e3a: " + key, e16);
            return r65;
        } catch (Exception e17) {
            w53.b.d("WinkUnitedConfigManager", "\u952e\u4e3a " + key + " \u7684\u610f\u5916\u9519\u8bef", e17);
            return r65;
        }
    }
}
