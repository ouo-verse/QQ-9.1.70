package com.tencent.mobileqq.icgame.sso;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/icgame/sso/m;", "", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "enable", "Z", "b", "()Z", "Lcom/google/gson/JsonArray;", "cmdArray", "Lcom/google/gson/JsonArray;", "getCmdArray", "()Lcom/google/gson/JsonArray;", "<init>", "(ZLcom/google/gson/JsonArray;)V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.sso.m, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class SsoCmdReportConfig {

    @SerializedName("cmd")
    @NotNull
    private final JsonArray cmdArray;

    @SerializedName("enable")
    private final boolean enable;

    public SsoCmdReportConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = this.cmdArray.iterator();
        while (it.hasNext()) {
            try {
                String asString = it.next().getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "it.asString");
                arrayList.add(asString);
            } catch (UnsupportedOperationException e16) {
                QLog.e("ICGameSsoCmdReportConfig", 1, "parse cmdArray failed ", e16);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add("trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr.PullMsgProxy");
        }
        return arrayList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SsoCmdReportConfig)) {
            return false;
        }
        SsoCmdReportConfig ssoCmdReportConfig = (SsoCmdReportConfig) other;
        if (this.enable == ssoCmdReportConfig.enable && Intrinsics.areEqual(this.cmdArray, ssoCmdReportConfig.cmdArray)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.cmdArray.hashCode();
    }

    @NotNull
    public String toString() {
        return "SsoCmdReportConfig(enable=" + this.enable + ", cmdArray=" + this.cmdArray + ")";
    }

    public SsoCmdReportConfig(boolean z16, @NotNull JsonArray cmdArray) {
        Intrinsics.checkNotNullParameter(cmdArray, "cmdArray");
        this.enable = z16;
        this.cmdArray = cmdArray;
    }

    public /* synthetic */ SsoCmdReportConfig(boolean z16, JsonArray jsonArray, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? new JsonArray() : jsonArray);
    }
}
