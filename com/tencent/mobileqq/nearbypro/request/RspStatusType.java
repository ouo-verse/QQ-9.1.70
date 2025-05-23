package com.tencent.mobileqq.nearbypro.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SSO_ERROR' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/RspStatusType;", "", "success", "", "(Ljava/lang/String;IZ)V", "getSuccess", "()Z", "SUCCESS", "LOCAL_PARAMS_ERROR", "LOCAL_NET_ERROR", "SSO_ERROR", "RPC_ERROR", "RPC_FUNC_ERROR", "UNKNOWN_ERROR", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class RspStatusType {
    public static final RspStatusType RPC_ERROR;
    public static final RspStatusType RPC_FUNC_ERROR;
    public static final RspStatusType SSO_ERROR;
    public static final RspStatusType UNKNOWN_ERROR;
    private final boolean success;
    public static final RspStatusType SUCCESS = new RspStatusType("SUCCESS", 0, true);
    public static final RspStatusType LOCAL_PARAMS_ERROR = new RspStatusType("LOCAL_PARAMS_ERROR", 1, false, 1, null);
    public static final RspStatusType LOCAL_NET_ERROR = new RspStatusType("LOCAL_NET_ERROR", 2, false, 1, null);
    private static final /* synthetic */ RspStatusType[] $VALUES = $values();

    private static final /* synthetic */ RspStatusType[] $values() {
        return new RspStatusType[]{SUCCESS, LOCAL_PARAMS_ERROR, LOCAL_NET_ERROR, SSO_ERROR, RPC_ERROR, RPC_FUNC_ERROR, UNKNOWN_ERROR};
    }

    static {
        boolean z16 = false;
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        SSO_ERROR = new RspStatusType("SSO_ERROR", 3, z16, i3, defaultConstructorMarker);
        boolean z17 = false;
        int i16 = 1;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        RPC_ERROR = new RspStatusType("RPC_ERROR", 4, z17, i16, defaultConstructorMarker2);
        RPC_FUNC_ERROR = new RspStatusType("RPC_FUNC_ERROR", 5, z16, i3, defaultConstructorMarker);
        UNKNOWN_ERROR = new RspStatusType("UNKNOWN_ERROR", 6, z17, i16, defaultConstructorMarker2);
    }

    RspStatusType(String str, int i3, boolean z16) {
        this.success = z16;
    }

    public static RspStatusType valueOf(String str) {
        return (RspStatusType) Enum.valueOf(RspStatusType.class, str);
    }

    public static RspStatusType[] values() {
        return (RspStatusType[]) $VALUES.clone();
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* synthetic */ RspStatusType(String str, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 1) != 0 ? false : z16);
    }
}
