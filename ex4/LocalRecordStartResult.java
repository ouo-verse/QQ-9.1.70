package ex4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lex4/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "b", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "()Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "commonAction", "getTaskHash", "taskHash", "d", "uploadPath", "e", "Z", "()Z", "needUpload", "<init>", "(Ljava/lang/String;Lcom/tencent/zplan/meme/action/MemeZPlanAction;Ljava/lang/String;Ljava/lang/String;Z)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: ex4.d, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class LocalRecordStartResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MemeZPlanAction commonAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskHash;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uploadPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needUpload;

    public LocalRecordStartResult(@NotNull String taskId, @NotNull MemeZPlanAction commonAction, @NotNull String taskHash, @NotNull String uploadPath, boolean z16) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(commonAction, "commonAction");
        Intrinsics.checkNotNullParameter(taskHash, "taskHash");
        Intrinsics.checkNotNullParameter(uploadPath, "uploadPath");
        this.taskId = taskId;
        this.commonAction = commonAction;
        this.taskHash = taskHash;
        this.uploadPath = uploadPath;
        this.needUpload = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MemeZPlanAction getCommonAction() {
        return this.commonAction;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedUpload() {
        return this.needUpload;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUploadPath() {
        return this.uploadPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LocalRecordStartResult) {
                LocalRecordStartResult localRecordStartResult = (LocalRecordStartResult) other;
                if (!Intrinsics.areEqual(this.taskId, localRecordStartResult.taskId) || !Intrinsics.areEqual(this.commonAction, localRecordStartResult.commonAction) || !Intrinsics.areEqual(this.taskHash, localRecordStartResult.taskHash) || !Intrinsics.areEqual(this.uploadPath, localRecordStartResult.uploadPath) || this.needUpload != localRecordStartResult.needUpload) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.taskId;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        MemeZPlanAction memeZPlanAction = this.commonAction;
        if (memeZPlanAction != null) {
            i16 = memeZPlanAction.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.taskHash;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str3 = this.uploadPath;
        if (str3 != null) {
            i18 = str3.hashCode();
        }
        int i28 = (i27 + i18) * 31;
        boolean z16 = this.needUpload;
        int i29 = z16;
        if (z16 != 0) {
            i29 = 1;
        }
        return i28 + i29;
    }

    @NotNull
    public String toString() {
        return "LocalRecordStartResult(taskId=" + this.taskId + ", commonAction=" + this.commonAction + ", taskHash=" + this.taskHash + ", uploadPath=" + this.uploadPath + ", needUpload=" + this.needUpload + ")";
    }
}
