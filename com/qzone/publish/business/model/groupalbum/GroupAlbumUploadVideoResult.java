package com.qzone.publish.business.model.groupalbum;

import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadImageResult;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*B1\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\bH\u00c6\u0003J3\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$\u00a8\u0006+"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;", "Ljava/io/Serializable;", "Lqzone/QZoneBaseMeta$StMedia;", "toStMedia", "", "component1", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "component2", "", "component3", "component4", "vid", "coverResult", "width", "height", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "getCoverResult", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "setCoverResult", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;)V", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "<init>", "(Ljava/lang/String;Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;II)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadVideoResult implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558775L;
    private GroupAlbumUploadImageResult coverResult;
    private int height;
    private String vid;
    private int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult$a;", "", "Lqzone/QZoneBaseMeta$StMedia;", "stMedia", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.groupalbum.GroupAlbumUploadVideoResult$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GroupAlbumUploadVideoResult a(QZoneBaseMeta$StMedia stMedia) {
            Intrinsics.checkNotNullParameter(stMedia, "stMedia");
            String str = stMedia.video.f430340id.get();
            Intrinsics.checkNotNullExpressionValue(str, "stMedia.video.id.get()");
            GroupAlbumUploadImageResult.Companion companion = GroupAlbumUploadImageResult.INSTANCE;
            QZoneBaseMeta$StImage qZoneBaseMeta$StImage = stMedia.video.cover;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "stMedia.video.cover");
            return new GroupAlbumUploadVideoResult(str, companion.a(qZoneBaseMeta$StImage), stMedia.video.width.get(), stMedia.video.height.get());
        }

        Companion() {
        }
    }

    public GroupAlbumUploadVideoResult() {
        this(null, null, 0, 0, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    /* renamed from: component2, reason: from getter */
    public final GroupAlbumUploadImageResult getCoverResult() {
        return this.coverResult;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final GroupAlbumUploadVideoResult copy(String vid, GroupAlbumUploadImageResult coverResult, int width, int height) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        return new GroupAlbumUploadVideoResult(vid, coverResult, width, height);
    }

    public final GroupAlbumUploadImageResult getCoverResult() {
        return this.coverResult;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getVid() {
        return this.vid;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = this.vid.hashCode() * 31;
        GroupAlbumUploadImageResult groupAlbumUploadImageResult = this.coverResult;
        return ((((hashCode + (groupAlbumUploadImageResult == null ? 0 : groupAlbumUploadImageResult.hashCode())) * 31) + this.width) * 31) + this.height;
    }

    public final void setCoverResult(GroupAlbumUploadImageResult groupAlbumUploadImageResult) {
        this.coverResult = groupAlbumUploadImageResult;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setVid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vid = str;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public final QZoneBaseMeta$StMedia toStMedia() {
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        qZoneBaseMeta$StMedia.type.set(1);
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia.video;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo2 = new QZoneBaseMeta$StVideo();
        qZoneBaseMeta$StVideo2.f430340id.set(this.vid);
        GroupAlbumUploadImageResult groupAlbumUploadImageResult = this.coverResult;
        if (groupAlbumUploadImageResult != null) {
            qZoneBaseMeta$StVideo2.cover.set(groupAlbumUploadImageResult.toStImage());
        }
        qZoneBaseMeta$StVideo2.width.set(this.width);
        qZoneBaseMeta$StVideo2.height.set(this.height);
        qZoneBaseMeta$StVideo.set(qZoneBaseMeta$StVideo2);
        return qZoneBaseMeta$StMedia;
    }

    public String toString() {
        return "GroupAlbumUploadVideoResult(vid=" + this.vid + ", coverResult=" + this.coverResult + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public GroupAlbumUploadVideoResult(String vid, GroupAlbumUploadImageResult groupAlbumUploadImageResult, int i3, int i16) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.vid = vid;
        this.coverResult = groupAlbumUploadImageResult;
        this.width = i3;
        this.height = i16;
    }

    public static /* synthetic */ GroupAlbumUploadVideoResult copy$default(GroupAlbumUploadVideoResult groupAlbumUploadVideoResult, String str, GroupAlbumUploadImageResult groupAlbumUploadImageResult, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = groupAlbumUploadVideoResult.vid;
        }
        if ((i17 & 2) != 0) {
            groupAlbumUploadImageResult = groupAlbumUploadVideoResult.coverResult;
        }
        if ((i17 & 4) != 0) {
            i3 = groupAlbumUploadVideoResult.width;
        }
        if ((i17 & 8) != 0) {
            i16 = groupAlbumUploadVideoResult.height;
        }
        return groupAlbumUploadVideoResult.copy(str, groupAlbumUploadImageResult, i3, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadVideoResult)) {
            return false;
        }
        GroupAlbumUploadVideoResult groupAlbumUploadVideoResult = (GroupAlbumUploadVideoResult) other;
        return Intrinsics.areEqual(this.vid, groupAlbumUploadVideoResult.vid) && Intrinsics.areEqual(this.coverResult, groupAlbumUploadVideoResult.coverResult) && this.width == groupAlbumUploadVideoResult.width && this.height == groupAlbumUploadVideoResult.height;
    }

    public /* synthetic */ GroupAlbumUploadVideoResult(String str, GroupAlbumUploadImageResult groupAlbumUploadImageResult, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? null : groupAlbumUploadImageResult, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}
