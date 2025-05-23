package e93;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Le93/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "albumNum", "b", "Ljava/lang/String;", "()Ljava/lang/String;", AEEditorConstants.ALBUMNAME, "albumId", "d", "coverUrl", "e", "coverUrlBackup", "f", "Z", "()Z", "g", "(Z)V", "isChecked", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e93.k, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class QZoneAlbumStruct {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int albumNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String albumName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String albumId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrlBackup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isChecked;

    public QZoneAlbumStruct(int i3, @NotNull String albumName, @NotNull String albumId, @NotNull String coverUrl, @NotNull String coverUrlBackup, boolean z16) {
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverUrlBackup, "coverUrlBackup");
        this.albumNum = i3;
        this.albumName = albumName;
        this.albumId = albumId;
        this.coverUrl = coverUrl;
        this.coverUrlBackup = coverUrlBackup;
        this.isChecked = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final int getAlbumNum() {
        return this.albumNum;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getCoverUrlBackup() {
        return this.coverUrlBackup;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneAlbumStruct)) {
            return false;
        }
        QZoneAlbumStruct qZoneAlbumStruct = (QZoneAlbumStruct) other;
        if (this.albumNum == qZoneAlbumStruct.albumNum && Intrinsics.areEqual(this.albumName, qZoneAlbumStruct.albumName) && Intrinsics.areEqual(this.albumId, qZoneAlbumStruct.albumId) && Intrinsics.areEqual(this.coverUrl, qZoneAlbumStruct.coverUrl) && Intrinsics.areEqual(this.coverUrlBackup, qZoneAlbumStruct.coverUrlBackup) && this.isChecked == qZoneAlbumStruct.isChecked) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void g(boolean z16) {
        this.isChecked = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.albumNum * 31) + this.albumName.hashCode()) * 31) + this.albumId.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.coverUrlBackup.hashCode()) * 31;
        boolean z16 = this.isChecked;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "QZoneAlbumStruct(albumNum=" + this.albumNum + ", albumName=" + this.albumName + ", albumId=" + this.albumId + ", coverUrl=" + this.coverUrl + ", coverUrlBackup=" + this.coverUrlBackup + ", isChecked=" + this.isChecked + ")";
    }
}
