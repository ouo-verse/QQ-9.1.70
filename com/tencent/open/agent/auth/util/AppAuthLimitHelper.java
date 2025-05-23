package com.tencent.open.agent.auth.util;

import android.os.Looper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.agent.auth.model.a;
import com.tencent.open.agent.util.t;
import com.tencent.qphone.base.util.QLog;
import fp3.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007R\u001b\u0010\u0010\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/open/agent/auth/util/AppAuthLimitHelper;", "", "", "d", "", "code", "", "appId", "Lfp3/b;", "authResponse", "", "b", "c", "Lkotlin/Lazy;", "a", "()Z", "featureSwitch", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AppAuthLimitHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AppAuthLimitHelper f340338a = new AppAuthLimitHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy featureSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.auth.util.AppAuthLimitHelper$featureSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openauth_app_auth_limit_feature_switch", true);
                t.f("AppAuthLimitHelper", "featureSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        featureSwitch = lazy;
    }

    AppAuthLimitHelper() {
    }

    private final boolean a() {
        return ((Boolean) featureSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void b(int code, @Nullable String appId, @Nullable b authResponse) {
        int i3;
        if (!d() || appId == null || authResponse == null || code != 110517) {
            return;
        }
        PBUInt32Field pBUInt32Field = authResponse.f400246t;
        if (pBUInt32Field != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        t.f("AppAuthLimitHelper", "setAppLoginLimitInfo: " + appId + ", " + i3);
        if (i3 > 0) {
            a.b(appId, System.currentTimeMillis(), i3 * 1000);
        }
    }

    @JvmStatic
    public static final void c(@Nullable String appId) {
        if (!d() || appId == null) {
            return;
        }
        long a16 = a.a(appId);
        if (a16 <= 0) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            QLog.e("AppAuthLimitHelper", 1, "handleOnSendAuthProtocol delay but runOnMainThread. delay: " + a16);
            return;
        }
        try {
            t.f("AppAuthLimitHelper", "handleOnSendAuthProtocol delay : " + a16);
            LockMethodProxy.sleep(a16);
            t.f("AppAuthLimitHelper", "handleOnSendAuthProtocol delay end");
        } catch (InterruptedException unused) {
            QLog.e("AppAuthLimitHelper", 1, "handleOnSendAuthProtocol delay but sleep fail. delay: " + a16);
        }
    }

    @JvmStatic
    public static final boolean d() {
        return f340338a.a();
    }
}
