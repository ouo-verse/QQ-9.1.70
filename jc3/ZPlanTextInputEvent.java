package jc3;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Ljc3/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "action", "I", "getAction", "()I", "newTxt", "Ljava/lang/String;", "getNewTxt", "()Ljava/lang/String;", "reqInfo", "getReqInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jc3.g, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanTextInputEvent {

    @SerializedName(Action.TAG)
    private final int action;

    @SerializedName("NewTxt")
    private final String newTxt;

    @SerializedName("ReqInfo")
    private final String reqInfo;

    public ZPlanTextInputEvent(int i3, String newTxt, String reqInfo) {
        Intrinsics.checkNotNullParameter(newTxt, "newTxt");
        Intrinsics.checkNotNullParameter(reqInfo, "reqInfo");
        this.action = i3;
        this.newTxt = newTxt;
        this.reqInfo = reqInfo;
    }

    public int hashCode() {
        return (((this.action * 31) + this.newTxt.hashCode()) * 31) + this.reqInfo.hashCode();
    }

    public String toString() {
        return "ZPlanTextInputEvent(action=" + this.action + ", newTxt=" + this.newTxt + ", reqInfo=" + this.reqInfo + ")";
    }

    public ZPlanTextInputEvent() {
        this(2, "", "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTextInputEvent)) {
            return false;
        }
        ZPlanTextInputEvent zPlanTextInputEvent = (ZPlanTextInputEvent) other;
        return this.action == zPlanTextInputEvent.action && Intrinsics.areEqual(this.newTxt, zPlanTextInputEvent.newTxt) && Intrinsics.areEqual(this.reqInfo, zPlanTextInputEvent.reqInfo);
    }
}
