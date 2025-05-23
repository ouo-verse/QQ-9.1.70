package com.qzone.publish.business.model.groupalbum;

import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadImageResult;
import com.qzone.publish.business.publishqueue.intimate.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u001f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadMediaResult;", "Ljava/io/Serializable;", "Lqzone/QZoneBaseMeta$StMedia;", "toStMedia", "", "isImageResult", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "component1", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;", "component2", "imageResult", "videoResult", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "getImageResult", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "setImageResult", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;)V", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;", "getVideoResult", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;", "setVideoResult", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;)V", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadVideoResult;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadMediaResult implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558769L;
    private GroupAlbumUploadImageResult imageResult;
    private GroupAlbumUploadVideoResult videoResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadMediaResult$a;", "", "Lqzone/QZoneBaseMeta$StMedia;", "stMedia", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadMediaResult;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.groupalbum.GroupAlbumUploadMediaResult$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GroupAlbumUploadMediaResult a(QZoneBaseMeta$StMedia stMedia) {
            GroupAlbumUploadImageResult groupAlbumUploadImageResult;
            Intrinsics.checkNotNullParameter(stMedia, "stMedia");
            if (b.c(stMedia)) {
                GroupAlbumUploadImageResult.Companion companion = GroupAlbumUploadImageResult.INSTANCE;
                QZoneBaseMeta$StImage qZoneBaseMeta$StImage = stMedia.image;
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "stMedia.image");
                groupAlbumUploadImageResult = companion.a(qZoneBaseMeta$StImage);
            } else {
                groupAlbumUploadImageResult = null;
            }
            return new GroupAlbumUploadMediaResult(groupAlbumUploadImageResult, b.d(stMedia) ? GroupAlbumUploadVideoResult.INSTANCE.a(stMedia) : null);
        }

        Companion() {
        }
    }

    public GroupAlbumUploadMediaResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final GroupAlbumUploadImageResult getImageResult() {
        return this.imageResult;
    }

    /* renamed from: component2, reason: from getter */
    public final GroupAlbumUploadVideoResult getVideoResult() {
        return this.videoResult;
    }

    public final GroupAlbumUploadMediaResult copy(GroupAlbumUploadImageResult imageResult, GroupAlbumUploadVideoResult videoResult) {
        return new GroupAlbumUploadMediaResult(imageResult, videoResult);
    }

    public final GroupAlbumUploadImageResult getImageResult() {
        return this.imageResult;
    }

    public final GroupAlbumUploadVideoResult getVideoResult() {
        return this.videoResult;
    }

    public int hashCode() {
        GroupAlbumUploadImageResult groupAlbumUploadImageResult = this.imageResult;
        int hashCode = (groupAlbumUploadImageResult == null ? 0 : groupAlbumUploadImageResult.hashCode()) * 31;
        GroupAlbumUploadVideoResult groupAlbumUploadVideoResult = this.videoResult;
        return hashCode + (groupAlbumUploadVideoResult != null ? groupAlbumUploadVideoResult.hashCode() : 0);
    }

    public final boolean isImageResult() {
        return this.imageResult != null;
    }

    public final void setImageResult(GroupAlbumUploadImageResult groupAlbumUploadImageResult) {
        this.imageResult = groupAlbumUploadImageResult;
    }

    public final void setVideoResult(GroupAlbumUploadVideoResult groupAlbumUploadVideoResult) {
        this.videoResult = groupAlbumUploadVideoResult;
    }

    public final QZoneBaseMeta$StMedia toStMedia() {
        QZoneBaseMeta$StMedia stMedia;
        GroupAlbumUploadImageResult groupAlbumUploadImageResult = this.imageResult;
        if (groupAlbumUploadImageResult != null && (stMedia = groupAlbumUploadImageResult.toStMedia()) != null) {
            return stMedia;
        }
        GroupAlbumUploadVideoResult groupAlbumUploadVideoResult = this.videoResult;
        if (groupAlbumUploadVideoResult != null) {
            return groupAlbumUploadVideoResult.toStMedia();
        }
        return null;
    }

    public String toString() {
        return "GroupAlbumUploadMediaResult(imageResult=" + this.imageResult + ", videoResult=" + this.videoResult + ")";
    }

    public GroupAlbumUploadMediaResult(GroupAlbumUploadImageResult groupAlbumUploadImageResult, GroupAlbumUploadVideoResult groupAlbumUploadVideoResult) {
        this.imageResult = groupAlbumUploadImageResult;
        this.videoResult = groupAlbumUploadVideoResult;
    }

    public /* synthetic */ GroupAlbumUploadMediaResult(GroupAlbumUploadImageResult groupAlbumUploadImageResult, GroupAlbumUploadVideoResult groupAlbumUploadVideoResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : groupAlbumUploadImageResult, (i3 & 2) != 0 ? null : groupAlbumUploadVideoResult);
    }

    public static /* synthetic */ GroupAlbumUploadMediaResult copy$default(GroupAlbumUploadMediaResult groupAlbumUploadMediaResult, GroupAlbumUploadImageResult groupAlbumUploadImageResult, GroupAlbumUploadVideoResult groupAlbumUploadVideoResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            groupAlbumUploadImageResult = groupAlbumUploadMediaResult.imageResult;
        }
        if ((i3 & 2) != 0) {
            groupAlbumUploadVideoResult = groupAlbumUploadMediaResult.videoResult;
        }
        return groupAlbumUploadMediaResult.copy(groupAlbumUploadImageResult, groupAlbumUploadVideoResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadMediaResult)) {
            return false;
        }
        GroupAlbumUploadMediaResult groupAlbumUploadMediaResult = (GroupAlbumUploadMediaResult) other;
        return Intrinsics.areEqual(this.imageResult, groupAlbumUploadMediaResult.imageResult) && Intrinsics.areEqual(this.videoResult, groupAlbumUploadMediaResult.videoResult);
    }
}
