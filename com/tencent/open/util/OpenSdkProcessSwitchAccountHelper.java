package com.tencent.open.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.agent.util.t;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/open/util/OpenSdkProcessSwitchAccountHelper;", "", "", "b", "Lkotlin/Lazy;", "a", "()Z", "featureSwitch", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenSdkProcessSwitchAccountHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OpenSdkProcessSwitchAccountHelper f341748a = new OpenSdkProcessSwitchAccountHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy featureSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.util.OpenSdkProcessSwitchAccountHelper$featureSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_process_switch_account_switch", true);
                t.f("OpenSdkProcessSwitchAccountHelper", "feature switch on: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        featureSwitch = lazy;
    }

    OpenSdkProcessSwitchAccountHelper() {
    }

    private final boolean a() {
        return ((Boolean) featureSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return f341748a.a();
    }
}
