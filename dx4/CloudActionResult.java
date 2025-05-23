package dx4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.cloud.record.api.Priority;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\u00a8\u0006&"}, d2 = {"Ldx4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "getTaskHash", "taskHash", "Lcom/tencent/zplan/cloud/record/api/Priority;", "d", "Lcom/tencent/zplan/cloud/record/api/Priority;", "getPriority", "()Lcom/tencent/zplan/cloud/record/api/Priority;", "priority", "e", "url", "f", "getRealDuration", "realDuration", "g", "appearanceKeySaved", h.F, "getAppearanceKeyNewSaved", "appearanceKeyNewSaved", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/cloud/record/api/Priority;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: dx4.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class CloudActionResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskHash;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Priority priority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int realDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appearanceKeySaved;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appearanceKeyNewSaved;

    public CloudActionResult(int i3, @NotNull String taskId, @NotNull String taskHash, @NotNull Priority priority, @NotNull String url, int i16, @NotNull String appearanceKeySaved, @NotNull String appearanceKeyNewSaved) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(taskHash, "taskHash");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(appearanceKeySaved, "appearanceKeySaved");
        Intrinsics.checkNotNullParameter(appearanceKeyNewSaved, "appearanceKeyNewSaved");
        this.actionId = i3;
        this.taskId = taskId;
        this.taskHash = taskHash;
        this.priority = priority;
        this.url = url;
        this.realDuration = i16;
        this.appearanceKeySaved = appearanceKeySaved;
        this.appearanceKeyNewSaved = appearanceKeyNewSaved;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAppearanceKeySaved() {
        return this.appearanceKeySaved;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudActionResult) {
                CloudActionResult cloudActionResult = (CloudActionResult) other;
                if (this.actionId != cloudActionResult.actionId || !Intrinsics.areEqual(this.taskId, cloudActionResult.taskId) || !Intrinsics.areEqual(this.taskHash, cloudActionResult.taskHash) || !Intrinsics.areEqual(this.priority, cloudActionResult.priority) || !Intrinsics.areEqual(this.url, cloudActionResult.url) || this.realDuration != cloudActionResult.realDuration || !Intrinsics.areEqual(this.appearanceKeySaved, cloudActionResult.appearanceKeySaved) || !Intrinsics.areEqual(this.appearanceKeyNewSaved, cloudActionResult.appearanceKeyNewSaved)) {
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
        int i17;
        int i18;
        int i19;
        int i26 = this.actionId * 31;
        String str = this.taskId;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        String str2 = this.taskHash;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        Priority priority = this.priority;
        if (priority != null) {
            i17 = priority.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (((i36 + i18) * 31) + this.realDuration) * 31;
        String str4 = this.appearanceKeySaved;
        if (str4 != null) {
            i19 = str4.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        String str5 = this.appearanceKeyNewSaved;
        if (str5 != null) {
            i27 = str5.hashCode();
        }
        return i38 + i27;
    }

    @NotNull
    public String toString() {
        return "CloudActionResult(actionId=" + this.actionId + ", taskId=" + this.taskId + ", taskHash=" + this.taskHash + ", priority=" + this.priority + ", url=" + this.url + ", realDuration=" + this.realDuration + ", appearanceKeySaved=" + this.appearanceKeySaved + ", appearanceKeyNewSaved=" + this.appearanceKeyNewSaved + ")";
    }
}
