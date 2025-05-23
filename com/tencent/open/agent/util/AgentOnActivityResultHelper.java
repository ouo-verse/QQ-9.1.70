package com.tencent.open.agent.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R!\u0010\u000b\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\bR\u001b\u0010\r\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/open/agent/util/AgentOnActivityResultHelper;", "", "", "requestCode", "", "a", "b", "Lkotlin/Lazy;", "()Z", "getCallSuperMethodSwitch$annotations", "()V", "callSuperMethodSwitch", "c", "fixSwitch", "<init>", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AgentOnActivityResultHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AgentOnActivityResultHelper f340587a = new AgentOnActivityResultHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy callSuperMethodSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fixSwitch;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.util.AgentOnActivityResultHelper$callSuperMethodSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openauth_agent_act_result_call_super_method_switch", true);
                QLog.i("AgentOnActivityResultHelper", 1, "openauth_agent_act_result_call_super_method_switch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        callSuperMethodSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.util.AgentOnActivityResultHelper$fixSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openauth_agent_act_result_ignore_request_code", true);
                QLog.i("AgentOnActivityResultHelper", 1, "openauth_agent_act_result_ignore_request_code: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        fixSwitch = lazy2;
    }

    AgentOnActivityResultHelper() {
    }

    @JvmStatic
    public static final boolean a(int requestCode) {
        if (!f340587a.c() || requestCode <= 0 || requestCode <= 65535) {
            return false;
        }
        QLog.i("AgentOnActivityResultHelper", 1, "shouldIgnore requestCode: " + requestCode);
        return true;
    }

    public static final boolean b() {
        return ((Boolean) callSuperMethodSwitch.getValue()).booleanValue();
    }

    private final boolean c() {
        return ((Boolean) fixSwitch.getValue()).booleanValue();
    }
}
