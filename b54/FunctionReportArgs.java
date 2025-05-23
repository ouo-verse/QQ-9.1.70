package b54;

import android.view.View;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\nB7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u0010\u0010\u001fR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u0019\u0010\u001f\u00a8\u0006%"}, d2 = {"Lb54/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "itemView", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "functionInfo", "d", "Z", "f", "()Z", "isRecent", "I", "()I", "functionType", "position", "<init>", "(Landroid/view/View;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;ZII)V", "g", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: b54.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class FunctionReportArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View itemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CommonBotInfo robotInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CommonBotFeatureInfo functionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRecent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int functionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int position;

    public FunctionReportArgs(@NotNull View itemView, @NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, boolean z16, int i3, int i16) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        this.itemView = itemView;
        this.robotInfo = robotInfo;
        this.functionInfo = functionInfo;
        this.isRecent = z16;
        this.functionType = i3;
        this.position = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CommonBotFeatureInfo getFunctionInfo() {
        return this.functionInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getFunctionType() {
        return this.functionType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getItemView() {
        return this.itemView;
    }

    /* renamed from: d, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final CommonBotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionReportArgs)) {
            return false;
        }
        FunctionReportArgs functionReportArgs = (FunctionReportArgs) other;
        if (Intrinsics.areEqual(this.itemView, functionReportArgs.itemView) && Intrinsics.areEqual(this.robotInfo, functionReportArgs.robotInfo) && Intrinsics.areEqual(this.functionInfo, functionReportArgs.functionInfo) && this.isRecent == functionReportArgs.isRecent && this.functionType == functionReportArgs.functionType && this.position == functionReportArgs.position) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsRecent() {
        return this.isRecent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.itemView.hashCode() * 31) + this.robotInfo.hashCode()) * 31) + this.functionInfo.hashCode()) * 31;
        boolean z16 = this.isRecent;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.functionType) * 31) + this.position;
    }

    @NotNull
    public String toString() {
        return "FunctionReportArgs(itemView=" + this.itemView + ", robotInfo=" + this.robotInfo + ", functionInfo=" + this.functionInfo + ", isRecent=" + this.isRecent + ", functionType=" + this.functionType + ", position=" + this.position + ")";
    }
}
