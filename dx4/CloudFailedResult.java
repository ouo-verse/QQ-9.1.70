package dx4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Ldx4/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "c", "errorCode", "errorMessage", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: dx4.b, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class CloudFailedResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMessage;

    public CloudFailedResult(int i3, @NotNull String taskId, int i16, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.actionId = i3;
        this.taskId = taskId;
        this.errorCode = i16;
        this.errorMessage = errorMessage;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudFailedResult) {
                CloudFailedResult cloudFailedResult = (CloudFailedResult) other;
                if (this.actionId != cloudFailedResult.actionId || !Intrinsics.areEqual(this.taskId, cloudFailedResult.taskId) || this.errorCode != cloudFailedResult.errorCode || !Intrinsics.areEqual(this.errorMessage, cloudFailedResult.errorMessage)) {
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
        int i16 = this.actionId * 31;
        String str = this.taskId;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (((i16 + i3) * 31) + this.errorCode) * 31;
        String str2 = this.errorMessage;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        return "CloudFailedResult(actionId=" + this.actionId + ", taskId=" + this.taskId + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}
