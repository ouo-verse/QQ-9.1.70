package com.qzone.reborn.albumx.common.bean;

import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.luggage.wxa.p004if.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b!\u0010\"J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010 \u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadMediaInfo;", "Ljava/io/Serializable;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "component1", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;", "component2", "imageInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "getImageInfo", "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "setImageInfo", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;)V", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;", w.NAME, "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;", "setVideoInfo", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;)V", "isImage", "Z", "()Z", "getOriginalPath", "()Ljava/lang/String;", "originalPath", "<init>", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadMediaInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558768L;
    private CommonAlbumUploadImageInfo imageInfo;
    private final boolean isImage;
    private CommonAlbumUploadVideoInfo videoInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadMediaInfo$a;", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapper", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadMediaInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommonAlbumUploadMediaInfo a(MediaWrapper mediaWrapper) {
            Intrinsics.checkNotNullParameter(mediaWrapper, "mediaWrapper");
            CommonAlbumUploadMediaInfo commonAlbumUploadMediaInfo = new CommonAlbumUploadMediaInfo(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            if (mediaWrapper.isImage()) {
                commonAlbumUploadMediaInfo.setImageInfo(CommonAlbumUploadImageInfo.INSTANCE.a(mediaWrapper.getImageInfo()));
            } else if (mediaWrapper.isVideo()) {
                commonAlbumUploadMediaInfo.setVideoInfo(CommonAlbumUploadVideoInfo.INSTANCE.a(mediaWrapper.getVideoInfo()));
            }
            return commonAlbumUploadMediaInfo;
        }

        Companion() {
        }
    }

    public CommonAlbumUploadMediaInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final CommonAlbumUploadImageInfo getImageInfo() {
        return this.imageInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final CommonAlbumUploadVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final CommonAlbumUploadMediaInfo copy(CommonAlbumUploadImageInfo imageInfo, CommonAlbumUploadVideoInfo videoInfo) {
        return new CommonAlbumUploadMediaInfo(imageInfo, videoInfo);
    }

    public final CommonAlbumUploadImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final String getOriginalPath() {
        String path;
        CommonAlbumUploadImageInfo commonAlbumUploadImageInfo = this.imageInfo;
        if (commonAlbumUploadImageInfo != null && (path = commonAlbumUploadImageInfo.getPath()) != null) {
            return path;
        }
        CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo = this.videoInfo;
        if (commonAlbumUploadVideoInfo != null) {
            return commonAlbumUploadVideoInfo.getPath();
        }
        return "";
    }

    public final CommonAlbumUploadVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public int hashCode() {
        CommonAlbumUploadImageInfo commonAlbumUploadImageInfo = this.imageInfo;
        int hashCode = (commonAlbumUploadImageInfo == null ? 0 : commonAlbumUploadImageInfo.hashCode()) * 31;
        CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo = this.videoInfo;
        return hashCode + (commonAlbumUploadVideoInfo != null ? commonAlbumUploadVideoInfo.hashCode() : 0);
    }

    /* renamed from: isImage, reason: from getter */
    public final boolean getIsImage() {
        return this.isImage;
    }

    public final void setImageInfo(CommonAlbumUploadImageInfo commonAlbumUploadImageInfo) {
        this.imageInfo = commonAlbumUploadImageInfo;
    }

    public final void setVideoInfo(CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo) {
        this.videoInfo = commonAlbumUploadVideoInfo;
    }

    public String toString() {
        return "CommonAlbumUploadMediaInfo(imageInfo=" + this.imageInfo + ", videoInfo=" + this.videoInfo + ")";
    }

    public CommonAlbumUploadMediaInfo(CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo) {
        this.imageInfo = commonAlbumUploadImageInfo;
        this.videoInfo = commonAlbumUploadVideoInfo;
        this.isImage = commonAlbumUploadImageInfo != null;
    }

    public static /* synthetic */ CommonAlbumUploadMediaInfo copy$default(CommonAlbumUploadMediaInfo commonAlbumUploadMediaInfo, CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            commonAlbumUploadImageInfo = commonAlbumUploadMediaInfo.imageInfo;
        }
        if ((i3 & 2) != 0) {
            commonAlbumUploadVideoInfo = commonAlbumUploadMediaInfo.videoInfo;
        }
        return commonAlbumUploadMediaInfo.copy(commonAlbumUploadImageInfo, commonAlbumUploadVideoInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonAlbumUploadMediaInfo)) {
            return false;
        }
        CommonAlbumUploadMediaInfo commonAlbumUploadMediaInfo = (CommonAlbumUploadMediaInfo) other;
        return Intrinsics.areEqual(this.imageInfo, commonAlbumUploadMediaInfo.imageInfo) && Intrinsics.areEqual(this.videoInfo, commonAlbumUploadMediaInfo.videoInfo);
    }

    public /* synthetic */ CommonAlbumUploadMediaInfo(CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : commonAlbumUploadImageInfo, (i3 & 2) != 0 ? null : commonAlbumUploadVideoInfo);
    }
}
