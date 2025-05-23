package com.tencent.zplan.mod.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\nBQ\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u001b\u0010 \"\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0012\u001a\u0004\b\n\u0010\u0014\"\u0004\b$\u0010\u0016R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/tencent/zplan/mod/data/a;", "", "", "i", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", h.F, "(I)V", "type", "b", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "openId", "c", "setModId", "modId", "d", "g", "msg", "", "J", "()J", "setTimeStamp", "(J)V", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "f", "cmd", "getExtraData", "setExtraData", WadlProxyConsts.EXTRA_DATA, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.mod.data.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class ZPlanModRPCData {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String openId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String modId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String msg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long timeStamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String cmd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String extraData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/zplan/mod/data/a$a;", "", "Lcom/tencent/zplan/mod/data/a;", "data", "a", "", "CMD_CG_GAME_EVENT_SEND_MSG_2_MOD", "Ljava/lang/String;", "CMD_CG_GAME_EVENT_SEND_MSG_2_QQ", "", "TYPE_FIRST_FRAME_NOTIFY", "I", "TYPE_REQ", "TYPE_RSP", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.mod.data.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ZPlanModRPCData a(@NotNull ZPlanModRPCData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            data.h(1);
            data.f("CG_GAME_EVENT_SEND_MSG_2_QQ");
            return data;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ZPlanModRPCData(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, long j3, @NotNull String cmd, @NotNull String extraData) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.type = i3;
        this.openId = str;
        this.modId = str2;
        this.msg = str3;
        this.timeStamp = j3;
        this.cmd = cmd;
        this.extraData = extraData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getModId() {
        return this.modId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: d, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanModRPCData) {
                ZPlanModRPCData zPlanModRPCData = (ZPlanModRPCData) other;
                if (this.type != zPlanModRPCData.type || !Intrinsics.areEqual(this.openId, zPlanModRPCData.openId) || !Intrinsics.areEqual(this.modId, zPlanModRPCData.modId) || !Intrinsics.areEqual(this.msg, zPlanModRPCData.msg) || this.timeStamp != zPlanModRPCData.timeStamp || !Intrinsics.areEqual(this.cmd, zPlanModRPCData.cmd) || !Intrinsics.areEqual(this.extraData, zPlanModRPCData.extraData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    public final void g(@Nullable String str) {
        this.msg = str;
    }

    public final void h(int i3) {
        this.type = i3;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.type * 31;
        String str = this.openId;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = (i19 + i3) * 31;
        String str2 = this.modId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.msg;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        long j3 = this.timeStamp;
        int i29 = (((i28 + i17) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str4 = this.cmd;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        String str5 = this.extraData;
        if (str5 != null) {
            i26 = str5.hashCode();
        }
        return i36 + i26;
    }

    @NotNull
    public final String i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.type);
        jSONObject.put("msg", this.msg);
        jSONObject.put("openId", this.openId);
        jSONObject.put("modId", this.modId);
        jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, this.timeStamp);
        jSONObject.put("cmd", this.cmd);
        jSONObject.put(WadlProxyConsts.EXTRA_DATA, this.extraData);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    @NotNull
    public String toString() {
        return "ZPlanModRPCData(type=" + this.type + ", openId=" + this.openId + ", modId=" + this.modId + ", msg=" + this.msg + ", timeStamp=" + this.timeStamp + ", cmd=" + this.cmd + ", extraData=" + this.extraData + ")";
    }

    public /* synthetic */ ZPlanModRPCData(int i3, String str, String str2, String str3, long j3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? UserInfoApi.INSTANCE.a().c() : str, (i16 & 4) != 0 ? UserInfoApi.INSTANCE.a().b() : str2, str3, (i16 & 16) != 0 ? System.currentTimeMillis() : j3, (i16 & 32) != 0 ? "CG_GAME_EVENT_SEND_MSG_2_QQ" : str4, (i16 & 64) != 0 ? "" : str5);
    }
}
