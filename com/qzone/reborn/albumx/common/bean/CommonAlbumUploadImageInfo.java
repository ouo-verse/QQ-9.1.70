package com.qzone.reborn.albumx.common.bean;

import com.qzone.util.image.ImageInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "path", "width", "height", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadImageInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -932549397364543341L;
    private int height;
    private String path;
    private int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo$a;", "", "Lcom/qzone/util/image/ImageInfo;", "imageInfo", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumUploadImageInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final CommonAlbumUploadImageInfo a(ImageInfo imageInfo) {
            if (imageInfo == null) {
                return null;
            }
            String str = imageInfo.mPath;
            Intrinsics.checkNotNullExpressionValue(str, "imageInfo.mPath");
            return new CommonAlbumUploadImageInfo(str, imageInfo.photoWidth, imageInfo.photoHeight);
        }
    }

    public CommonAlbumUploadImageInfo() {
        this(null, 0, 0, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final CommonAlbumUploadImageInfo copy(String path, int width, int height) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new CommonAlbumUploadImageInfo(path, width, height);
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + this.width) * 31) + this.height;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public String toString() {
        return "CommonAlbumUploadImageInfo(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public CommonAlbumUploadImageInfo(String path, int i3, int i16) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.width = i3;
        this.height = i16;
    }

    public static /* synthetic */ CommonAlbumUploadImageInfo copy$default(CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = commonAlbumUploadImageInfo.path;
        }
        if ((i17 & 2) != 0) {
            i3 = commonAlbumUploadImageInfo.width;
        }
        if ((i17 & 4) != 0) {
            i16 = commonAlbumUploadImageInfo.height;
        }
        return commonAlbumUploadImageInfo.copy(str, i3, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonAlbumUploadImageInfo)) {
            return false;
        }
        CommonAlbumUploadImageInfo commonAlbumUploadImageInfo = (CommonAlbumUploadImageInfo) other;
        return Intrinsics.areEqual(this.path, commonAlbumUploadImageInfo.path) && this.width == commonAlbumUploadImageInfo.width && this.height == commonAlbumUploadImageInfo.height;
    }

    public /* synthetic */ CommonAlbumUploadImageInfo(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? -1 : i16);
    }
}
