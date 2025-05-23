package com.tencent.open.ticket;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.agent.util.t;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/open/ticket/NtTicketInvalidFixUtils;", "", "", "b", "Lkotlin/Lazy;", "a", "()Z", "getFixSwitch$annotations", "()V", "fixSwitch", "<init>", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NtTicketInvalidFixUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NtTicketInvalidFixUtils f341728a = new NtTicketInvalidFixUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fixSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.ticket.NtTicketInvalidFixUtils$fixSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_ntlogin_ticket_invalid_fix", true);
                t.f("NtTicketInvalidFixUtils", "fixSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        fixSwitch = lazy;
    }

    NtTicketInvalidFixUtils() {
    }

    public static final boolean a() {
        return ((Boolean) fixSwitch.getValue()).booleanValue();
    }
}
