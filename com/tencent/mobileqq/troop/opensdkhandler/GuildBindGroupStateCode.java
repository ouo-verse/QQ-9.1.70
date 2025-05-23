package com.tencent.mobileqq.troop.opensdkhandler;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'GROUP_DISSOLVED' uses external variables
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/opensdkhandler/GuildBindGroupStateCode;", "", "code", "", "msg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", RequestApplyFragment.ERROR_CODE, "SUCCESS_CODE", "OPEN_ID_EMPTY", "GROUP_DISSOLVED", "GUILD_NO_BIND_GROUP", "GROUP_FREEZE", "GROUP_SUSPENDED", "GUILD_ID_EMPTY", "BIZ_TYPE_INVALIDATE", "SWITCH_CONFIG_CLOSED", "USER_IS_NOT_GROUP_MEMBER", "NETWORK_FAIL", "CONNECTION_TIMEOUT", "UNBIND_GROUP_CANCELED", "UNBIND_GROUP_SUCCESS", "UNBIND_GROUP_FAIL", "E_USER_NOT_SAME", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class GuildBindGroupStateCode {
    private static final /* synthetic */ GuildBindGroupStateCode[] $VALUES;
    public static final GuildBindGroupStateCode BIZ_TYPE_INVALIDATE;
    public static final GuildBindGroupStateCode CONNECTION_TIMEOUT;
    public static final GuildBindGroupStateCode E_USER_NOT_SAME;
    public static final GuildBindGroupStateCode GROUP_DISSOLVED;
    public static final GuildBindGroupStateCode GROUP_FREEZE;
    public static final GuildBindGroupStateCode GROUP_SUSPENDED;
    public static final GuildBindGroupStateCode GUILD_ID_EMPTY;
    public static final GuildBindGroupStateCode GUILD_NO_BIND_GROUP;
    public static final GuildBindGroupStateCode NETWORK_FAIL;
    public static final GuildBindGroupStateCode SWITCH_CONFIG_CLOSED;
    public static final GuildBindGroupStateCode UNBIND_GROUP_CANCELED;
    public static final GuildBindGroupStateCode UNBIND_GROUP_FAIL;
    public static final GuildBindGroupStateCode UNBIND_GROUP_SUCCESS;
    public static final GuildBindGroupStateCode USER_IS_NOT_GROUP_MEMBER;
    private final int code;

    @NotNull
    private final String msg;
    public static final GuildBindGroupStateCode ERROR_CODE = new GuildBindGroupStateCode(RequestApplyFragment.ERROR_CODE, 0, -1, "failed");
    public static final GuildBindGroupStateCode SUCCESS_CODE = new GuildBindGroupStateCode("SUCCESS_CODE", 1, 0, "success");
    public static final GuildBindGroupStateCode OPEN_ID_EMPTY = new GuildBindGroupStateCode("OPEN_ID_EMPTY", 2, 1001, "");

    private static final /* synthetic */ GuildBindGroupStateCode[] $values() {
        return new GuildBindGroupStateCode[]{ERROR_CODE, SUCCESS_CODE, OPEN_ID_EMPTY, GROUP_DISSOLVED, GUILD_NO_BIND_GROUP, GROUP_FREEZE, GROUP_SUSPENDED, GUILD_ID_EMPTY, BIZ_TYPE_INVALIDATE, SWITCH_CONFIG_CLOSED, USER_IS_NOT_GROUP_MEMBER, NETWORK_FAIL, CONNECTION_TIMEOUT, UNBIND_GROUP_CANCELED, UNBIND_GROUP_SUCCESS, UNBIND_GROUP_FAIL, E_USER_NOT_SAME};
    }

    static {
        String qqStr = HardCodeUtil.qqStr(R.string.f146260tp);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_group_dissolved)");
        GROUP_DISSOLVED = new GuildBindGroupStateCode("GROUP_DISSOLVED", 3, 1002, qqStr);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f146300tt);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_group_no_bind_group)");
        GUILD_NO_BIND_GROUP = new GuildBindGroupStateCode("GUILD_NO_BIND_GROUP", 4, 1003, qqStr2);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f146270tq);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.guild_group_freeze)");
        GROUP_FREEZE = new GuildBindGroupStateCode("GROUP_FREEZE", 5, 1004, qqStr3);
        String qqStr4 = HardCodeUtil.qqStr(R.string.f146390u2);
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.guild_group_suspended)");
        GROUP_SUSPENDED = new GuildBindGroupStateCode("GROUP_SUSPENDED", 6, 1005, qqStr4);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f146280tr);
        Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.guild_group_guild_id_empty)");
        GUILD_ID_EMPTY = new GuildBindGroupStateCode("GUILD_ID_EMPTY", 7, 1006, qqStr5);
        String qqStr6 = HardCodeUtil.qqStr(R.string.f146190ti);
        Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.guild_group_biz_type_invalidate)");
        BIZ_TYPE_INVALIDATE = new GuildBindGroupStateCode("BIZ_TYPE_INVALIDATE", 8, 1007, qqStr6);
        String qqStr7 = HardCodeUtil.qqStr(R.string.f146400u3);
        Intrinsics.checkNotNullExpressionValue(qqStr7, "qqStr(R.string.guild_group_sync_status_close)");
        SWITCH_CONFIG_CLOSED = new GuildBindGroupStateCode("SWITCH_CONFIG_CLOSED", 9, 1008, qqStr7);
        String qqStr8 = HardCodeUtil.qqStr(R.string.f146450u8);
        Intrinsics.checkNotNullExpressionValue(qqStr8, "qqStr(R.string.guild_group_user_not_group_member)");
        USER_IS_NOT_GROUP_MEMBER = new GuildBindGroupStateCode("USER_IS_NOT_GROUP_MEMBER", 10, 1009, qqStr8);
        String qqStr9 = HardCodeUtil.qqStr(R.string.f146290ts);
        Intrinsics.checkNotNullExpressionValue(qqStr9, "qqStr(R.string.guild_group_network_fail)");
        NETWORK_FAIL = new GuildBindGroupStateCode("NETWORK_FAIL", 11, 1010, qqStr9);
        String qqStr10 = HardCodeUtil.qqStr(R.string.f146220tl);
        Intrinsics.checkNotNullExpressionValue(qqStr10, "qqStr(R.string.guild_group_connection_timeout)");
        CONNECTION_TIMEOUT = new GuildBindGroupStateCode("CONNECTION_TIMEOUT", 12, 1011, qqStr10);
        String qqStr11 = HardCodeUtil.qqStr(R.string.f146410u4);
        Intrinsics.checkNotNullExpressionValue(qqStr11, "qqStr(R.string.guild_group_unbind_canceled)");
        UNBIND_GROUP_CANCELED = new GuildBindGroupStateCode("UNBIND_GROUP_CANCELED", 13, 1012, qqStr11);
        String qqStr12 = HardCodeUtil.qqStr(R.string.f146430u6);
        Intrinsics.checkNotNullExpressionValue(qqStr12, "qqStr(R.string.guild_group_unbind_success)");
        UNBIND_GROUP_SUCCESS = new GuildBindGroupStateCode("UNBIND_GROUP_SUCCESS", 14, 1013, qqStr12);
        String qqStr13 = HardCodeUtil.qqStr(R.string.f146420u5);
        Intrinsics.checkNotNullExpressionValue(qqStr13, "qqStr(R.string.guild_group_unbind_fail)");
        UNBIND_GROUP_FAIL = new GuildBindGroupStateCode("UNBIND_GROUP_FAIL", 15, 1014, qqStr13);
        String qqStr14 = HardCodeUtil.qqStr(R.string.b1v);
        Intrinsics.checkNotNullExpressionValue(qqStr14, "qqStr(com.tencent.mobile\u2026re_qzone_open_id_confirm)");
        E_USER_NOT_SAME = new GuildBindGroupStateCode("E_USER_NOT_SAME", 16, 25501, qqStr14);
        $VALUES = $values();
    }

    GuildBindGroupStateCode(String str, int i3, int i16, String str2) {
        this.code = i16;
        this.msg = str2;
    }

    public static GuildBindGroupStateCode valueOf(String str) {
        return (GuildBindGroupStateCode) Enum.valueOf(GuildBindGroupStateCode.class, str);
    }

    public static GuildBindGroupStateCode[] values() {
        return (GuildBindGroupStateCode[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }
}
