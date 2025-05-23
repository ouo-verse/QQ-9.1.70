package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R!\u0010\r\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\u000f\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\b\u0012\u0004\b\u000e\u0010\f\u001a\u0004\b\u0007\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ToggleConfig;", "", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "d", "b", "Lkotlin/Lazy;", "c", "()Z", "isDisableBundleClassLoader$annotations", "()V", "isDisableBundleClassLoader", "getCanReleaseLogicContext$annotations", "canReleaseLogicContext", "<init>", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ToggleConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ToggleConfig f277011a = new ToggleConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isDisableBundleClassLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy canReleaseLogicContext;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.ToggleConfig$isDisableBundleClassLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean d16;
                d16 = ToggleConfig.f277011a.d(IQWalletFeatureApi.QWALLET_DISABLE_BUNDLE_CLASSLOADER, false);
                return Boolean.valueOf(d16);
            }
        });
        isDisableBundleClassLoader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.ToggleConfig$canReleaseLogicContext$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean d16;
                d16 = ToggleConfig.f277011a.d(IQWalletFeatureApi.QWALLET_RELEASE_LOGIC_CONTEXT, true);
                return Boolean.valueOf(d16);
            }
        });
        canReleaseLogicContext = lazy2;
    }

    ToggleConfig() {
    }

    public static final boolean b() {
        return ((Boolean) canReleaseLogicContext.getValue()).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) isDisableBundleClassLoader.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(String key, boolean defaultValue) {
        return ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(key, defaultValue);
    }
}
