package bh3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\u00a8\u0006&"}, d2 = {"Lbh3/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "category", "Ljava/lang/String;", "g", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "c", h.F, "url", "d", "path", "e", "f", "state", "", UserInfo.SEX_FEMALE, "()F", "progress", "realTimeSpeed", "averageSpeed", "i", "Z", "()Z", "isSilentDownload", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFIIZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bh3.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class DownloadTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int category;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float progress;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int realTimeSpeed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int averageSpeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSilentDownload;

    public DownloadTask(int i3, @NotNull String taskId, @NotNull String url, @NotNull String path, int i16, float f16, int i17, int i18, boolean z16) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(path, "path");
        this.category = i3;
        this.taskId = taskId;
        this.url = url;
        this.path = path;
        this.state = i16;
        this.progress = f16;
        this.realTimeSpeed = i17;
        this.averageSpeed = i18;
        this.isSilentDownload = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getAverageSpeed() {
        return this.averageSpeed;
    }

    /* renamed from: b, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: d, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: e, reason: from getter */
    public final int getRealTimeSpeed() {
        return this.realTimeSpeed;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadTask)) {
            return false;
        }
        DownloadTask downloadTask = (DownloadTask) other;
        if (this.category == downloadTask.category && Intrinsics.areEqual(this.taskId, downloadTask.taskId) && Intrinsics.areEqual(this.url, downloadTask.url) && Intrinsics.areEqual(this.path, downloadTask.path) && this.state == downloadTask.state && Float.compare(this.progress, downloadTask.progress) == 0 && this.realTimeSpeed == downloadTask.realTimeSpeed && this.averageSpeed == downloadTask.averageSpeed && this.isSilentDownload == downloadTask.isSilentDownload) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.category * 31) + this.taskId.hashCode()) * 31) + this.url.hashCode()) * 31) + this.path.hashCode()) * 31) + this.state) * 31) + Float.floatToIntBits(this.progress)) * 31) + this.realTimeSpeed) * 31) + this.averageSpeed) * 31;
        boolean z16 = this.isSilentDownload;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsSilentDownload() {
        return this.isSilentDownload;
    }

    @NotNull
    public String toString() {
        return "DownloadTask(category=" + this.category + ", taskId=" + this.taskId + ", url=" + this.url + ", path=" + this.path + ", state=" + this.state + ", progress=" + this.progress + ", realTimeSpeed=" + this.realTimeSpeed + ", averageSpeed=" + this.averageSpeed + ", isSilentDownload=" + this.isSilentDownload + ')';
    }
}
