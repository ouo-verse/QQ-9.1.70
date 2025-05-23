package ex4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lex4/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "b", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "getCommonAction", "()Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "commonAction", "c", "I", "getErrorCode", "()I", "errorCode", "d", "getErrorMessage", "errorMessage", "<init>", "(Ljava/lang/String;Lcom/tencent/zplan/meme/action/MemeZPlanAction;ILjava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: ex4.c, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class LocalRecordFailedResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MemeZPlanAction commonAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMessage;

    public LocalRecordFailedResult(@NotNull String taskId, @NotNull MemeZPlanAction commonAction, int i3, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(commonAction, "commonAction");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.taskId = taskId;
        this.commonAction = commonAction;
        this.errorCode = i3;
        this.errorMessage = errorMessage;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LocalRecordFailedResult) {
                LocalRecordFailedResult localRecordFailedResult = (LocalRecordFailedResult) other;
                if (!Intrinsics.areEqual(this.taskId, localRecordFailedResult.taskId) || !Intrinsics.areEqual(this.commonAction, localRecordFailedResult.commonAction) || this.errorCode != localRecordFailedResult.errorCode || !Intrinsics.areEqual(this.errorMessage, localRecordFailedResult.errorMessage)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.taskId;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        MemeZPlanAction memeZPlanAction = this.commonAction;
        if (memeZPlanAction != null) {
            i16 = memeZPlanAction.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (((i18 + i16) * 31) + this.errorCode) * 31;
        String str2 = this.errorMessage;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "LocalRecordFailedResult(taskId=" + this.taskId + ", commonAction=" + this.commonAction + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}
