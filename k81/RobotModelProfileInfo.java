package k81;

import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lk81/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "appID", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "robotName", "e", "robotUin", "d", "robotUid", "Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "()Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;", "inputBox", "<init>", "(JLjava/lang/String;JLjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/InputBox;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: k81.c, reason: from toString */
/* loaded from: classes11.dex */
public final /* data */ class RobotModelProfileInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long appID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long robotUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final InputBox inputBox;

    public RobotModelProfileInfo() {
        this(0L, null, 0L, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getAppID() {
        return this.appID;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final InputBox getInputBox() {
        return this.inputBox;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRobotName() {
        return this.robotName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRobotUid() {
        return this.robotUid;
    }

    /* renamed from: e, reason: from getter */
    public final long getRobotUin() {
        return this.robotUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotModelProfileInfo)) {
            return false;
        }
        RobotModelProfileInfo robotModelProfileInfo = (RobotModelProfileInfo) other;
        if (this.appID == robotModelProfileInfo.appID && Intrinsics.areEqual(this.robotName, robotModelProfileInfo.robotName) && this.robotUin == robotModelProfileInfo.robotUin && Intrinsics.areEqual(this.robotUid, robotModelProfileInfo.robotUid) && Intrinsics.areEqual(this.inputBox, robotModelProfileInfo.inputBox)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((androidx.fragment.app.a.a(this.appID) * 31) + this.robotName.hashCode()) * 31) + androidx.fragment.app.a.a(this.robotUin)) * 31) + this.robotUid.hashCode()) * 31) + this.inputBox.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotModelProfileInfo(appID=" + this.appID + ", robotName=" + this.robotName + ", robotUin=" + this.robotUin + ", robotUid=" + this.robotUid + ", inputBox=" + this.inputBox + ")";
    }

    public RobotModelProfileInfo(long j3, @NotNull String robotName, long j16, @NotNull String robotUid, @NotNull InputBox inputBox) {
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(inputBox, "inputBox");
        this.appID = j3;
        this.robotName = robotName;
        this.robotUin = j16;
        this.robotUid = robotUid;
        this.inputBox = inputBox;
    }

    public /* synthetic */ RobotModelProfileInfo(long j3, String str, long j16, String str2, InputBox inputBox, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) == 0 ? j16 : 0L, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? new InputBox() : inputBox);
    }
}
