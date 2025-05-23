package com.qzone.publish.business.model.intimate;

import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.luggage.wxa.p004if.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b!\u0010\"J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010 \u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaInfo;", "Ljava/io/Serializable;", "Lcom/qzone/publish/business/model/intimate/IntimateUploadImageInfo;", "component1", "Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoInfo;", "component2", "imageInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/qzone/publish/business/model/intimate/IntimateUploadImageInfo;", "getImageInfo", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadImageInfo;", "setImageInfo", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadImageInfo;)V", "Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoInfo;", w.NAME, "()Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoInfo;", "setVideoInfo", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoInfo;)V", "isImage", "Z", "()Z", "getOriginalPath", "()Ljava/lang/String;", "originalPath", "<init>", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadImageInfo;Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoInfo;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadMediaInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558767L;
    private IntimateUploadImageInfo imageInfo;
    private final boolean isImage;
    private IntimateUploadVideoInfo videoInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaInfo$a;", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapper", "Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.intimate.IntimateUploadMediaInfo$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntimateUploadMediaInfo a(MediaWrapper mediaWrapper) {
            Intrinsics.checkNotNullParameter(mediaWrapper, "mediaWrapper");
            IntimateUploadMediaInfo intimateUploadMediaInfo = new IntimateUploadMediaInfo(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            if (mediaWrapper.isImage()) {
                intimateUploadMediaInfo.setImageInfo(IntimateUploadImageInfo.INSTANCE.a(mediaWrapper.getImageInfo()));
            } else if (mediaWrapper.isVideo()) {
                intimateUploadMediaInfo.setVideoInfo(IntimateUploadVideoInfo.INSTANCE.a(mediaWrapper.getVideoInfo()));
            }
            return intimateUploadMediaInfo;
        }

        Companion() {
        }
    }

    public IntimateUploadMediaInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final IntimateUploadImageInfo getImageInfo() {
        return this.imageInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final IntimateUploadVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final IntimateUploadMediaInfo copy(IntimateUploadImageInfo imageInfo, IntimateUploadVideoInfo videoInfo) {
        return new IntimateUploadMediaInfo(imageInfo, videoInfo);
    }

    public final IntimateUploadImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final String getOriginalPath() {
        String path;
        IntimateUploadImageInfo intimateUploadImageInfo = this.imageInfo;
        if (intimateUploadImageInfo != null && (path = intimateUploadImageInfo.getPath()) != null) {
            return path;
        }
        IntimateUploadVideoInfo intimateUploadVideoInfo = this.videoInfo;
        if (intimateUploadVideoInfo != null) {
            return intimateUploadVideoInfo.getPath();
        }
        return "";
    }

    public final IntimateUploadVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public int hashCode() {
        IntimateUploadImageInfo intimateUploadImageInfo = this.imageInfo;
        int hashCode = (intimateUploadImageInfo == null ? 0 : intimateUploadImageInfo.hashCode()) * 31;
        IntimateUploadVideoInfo intimateUploadVideoInfo = this.videoInfo;
        return hashCode + (intimateUploadVideoInfo != null ? intimateUploadVideoInfo.hashCode() : 0);
    }

    /* renamed from: isImage, reason: from getter */
    public final boolean getIsImage() {
        return this.isImage;
    }

    public final void setImageInfo(IntimateUploadImageInfo intimateUploadImageInfo) {
        this.imageInfo = intimateUploadImageInfo;
    }

    public final void setVideoInfo(IntimateUploadVideoInfo intimateUploadVideoInfo) {
        this.videoInfo = intimateUploadVideoInfo;
    }

    public String toString() {
        return "IntimateUploadMediaInfo(imageInfo=" + this.imageInfo + ", videoInfo=" + this.videoInfo + ")";
    }

    public IntimateUploadMediaInfo(IntimateUploadImageInfo intimateUploadImageInfo, IntimateUploadVideoInfo intimateUploadVideoInfo) {
        this.imageInfo = intimateUploadImageInfo;
        this.videoInfo = intimateUploadVideoInfo;
        this.isImage = intimateUploadImageInfo != null;
    }

    public static /* synthetic */ IntimateUploadMediaInfo copy$default(IntimateUploadMediaInfo intimateUploadMediaInfo, IntimateUploadImageInfo intimateUploadImageInfo, IntimateUploadVideoInfo intimateUploadVideoInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            intimateUploadImageInfo = intimateUploadMediaInfo.imageInfo;
        }
        if ((i3 & 2) != 0) {
            intimateUploadVideoInfo = intimateUploadMediaInfo.videoInfo;
        }
        return intimateUploadMediaInfo.copy(intimateUploadImageInfo, intimateUploadVideoInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadMediaInfo)) {
            return false;
        }
        IntimateUploadMediaInfo intimateUploadMediaInfo = (IntimateUploadMediaInfo) other;
        return Intrinsics.areEqual(this.imageInfo, intimateUploadMediaInfo.imageInfo) && Intrinsics.areEqual(this.videoInfo, intimateUploadMediaInfo.videoInfo);
    }

    public /* synthetic */ IntimateUploadMediaInfo(IntimateUploadImageInfo intimateUploadImageInfo, IntimateUploadVideoInfo intimateUploadVideoInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : intimateUploadImageInfo, (i3 & 2) != 0 ? null : intimateUploadVideoInfo);
    }
}
