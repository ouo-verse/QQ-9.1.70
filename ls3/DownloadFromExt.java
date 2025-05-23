package ls3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lls3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "scene", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "via", "reportData", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ls3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class DownloadFromExt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String via;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String reportData;

    public DownloadFromExt(int i3, @NotNull String via, @NotNull String reportData) {
        Intrinsics.checkNotNullParameter(via, "via");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.scene = i3;
        this.via = via;
        this.reportData = reportData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    /* renamed from: b, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getVia() {
        return this.via;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadFromExt)) {
            return false;
        }
        DownloadFromExt downloadFromExt = (DownloadFromExt) other;
        if (this.scene == downloadFromExt.scene && Intrinsics.areEqual(this.via, downloadFromExt.via) && Intrinsics.areEqual(this.reportData, downloadFromExt.reportData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.scene * 31) + this.via.hashCode()) * 31) + this.reportData.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadFromExt(scene=" + this.scene + ", via=" + this.via + ", reportData=" + this.reportData + ')';
    }
}
