package com.qzone.publish.business.model.intimate;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "albumId", AEEditorConstants.ALBUMNAME, "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "getAlbumName", "setAlbumName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadAlbumInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 1948538260691651088L;
    private String albumId;
    private String albumName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo$a;", "", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.intimate.IntimateUploadAlbumInfo$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntimateUploadAlbumInfo a(QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
            Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
            String str = albumInfo.album_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "albumInfo.album_id.get()");
            String str2 = albumInfo.name.get();
            Intrinsics.checkNotNullExpressionValue(str2, "albumInfo.name.get()");
            return new IntimateUploadAlbumInfo(str, str2);
        }

        Companion() {
        }
    }

    public IntimateUploadAlbumInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    public final IntimateUploadAlbumInfo copy(String albumId, String albumName) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        return new IntimateUploadAlbumInfo(albumId, albumName);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public int hashCode() {
        return (this.albumId.hashCode() * 31) + this.albumName.hashCode();
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public String toString() {
        return "IntimateUploadAlbumInfo(albumId=" + this.albumId + ", albumName=" + this.albumName + ")";
    }

    public IntimateUploadAlbumInfo(String albumId, String albumName) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public /* synthetic */ IntimateUploadAlbumInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ IntimateUploadAlbumInfo copy$default(IntimateUploadAlbumInfo intimateUploadAlbumInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = intimateUploadAlbumInfo.albumId;
        }
        if ((i3 & 2) != 0) {
            str2 = intimateUploadAlbumInfo.albumName;
        }
        return intimateUploadAlbumInfo.copy(str, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadAlbumInfo)) {
            return false;
        }
        IntimateUploadAlbumInfo intimateUploadAlbumInfo = (IntimateUploadAlbumInfo) other;
        return Intrinsics.areEqual(this.albumId, intimateUploadAlbumInfo.albumId) && Intrinsics.areEqual(this.albumName, intimateUploadAlbumInfo.albumName);
    }
}
