package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "success", "Z", "getSuccess", "()Z", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "errorMsg", "getErrorMsg", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.kuikly.module.t, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class KuiklyRenderCallbackData {

    @SerializedName("data")
    @Nullable
    private final String data;

    @SerializedName("errorMsg")
    @Nullable
    private final String errorMsg;

    @SerializedName("success")
    private final boolean success;

    public KuiklyRenderCallbackData(boolean z16, @Nullable String str, @Nullable String str2) {
        this.success = z16;
        this.data = str;
        this.errorMsg = str2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KuiklyRenderCallbackData)) {
            return false;
        }
        KuiklyRenderCallbackData kuiklyRenderCallbackData = (KuiklyRenderCallbackData) other;
        if (this.success == kuiklyRenderCallbackData.success && Intrinsics.areEqual(this.data, kuiklyRenderCallbackData.data) && Intrinsics.areEqual(this.errorMsg, kuiklyRenderCallbackData.errorMsg)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.data;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.errorMsg;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "KuiklyRenderCallbackData(success=" + this.success + ", data=" + this.data + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ KuiklyRenderCallbackData(boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
