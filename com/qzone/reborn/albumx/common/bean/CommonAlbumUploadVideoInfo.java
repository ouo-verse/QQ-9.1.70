package com.qzone.reborn.albumx.common.bean;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.QZoneRequestEncoder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001(B1\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J3\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "component4", "path", "width", "height", "cover", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;", "setCover", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;)V", "<init>", "(Ljava/lang/String;IILcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadImageInfo;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadVideoInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -247543015658803680L;
    private CommonAlbumUploadImageInfo cover;
    private int height;
    private String path;
    private int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo$a;", "", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadVideoInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumUploadVideoInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final CommonAlbumUploadVideoInfo a(ShuoshuoVideoInfo videoInfo) {
            if (videoInfo == null) {
                return null;
            }
            String str = videoInfo.mVideoPath;
            Intrinsics.checkNotNullExpressionValue(str, "videoInfo.mVideoPath");
            int i3 = videoInfo.mVideoWidth;
            int i16 = videoInfo.mVideoHeight;
            String str2 = videoInfo.mCoverUrl;
            if (str2 == null) {
                str2 = "";
            }
            return new CommonAlbumUploadVideoInfo(str, i3, i16, new CommonAlbumUploadImageInfo(str2, videoInfo.mVideoWidth, videoInfo.mVideoHeight));
        }
    }

    public CommonAlbumUploadVideoInfo() {
        this(null, 0, 0, null, 15, null);
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

    /* renamed from: component4, reason: from getter */
    public final CommonAlbumUploadImageInfo getCover() {
        return this.cover;
    }

    public final CommonAlbumUploadVideoInfo copy(String path, int width, int height, CommonAlbumUploadImageInfo cover) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new CommonAlbumUploadVideoInfo(path, width, height, cover);
    }

    public final CommonAlbumUploadImageInfo getCover() {
        return this.cover;
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
        int hashCode = ((((this.path.hashCode() * 31) + this.width) * 31) + this.height) * 31;
        CommonAlbumUploadImageInfo commonAlbumUploadImageInfo = this.cover;
        return hashCode + (commonAlbumUploadImageInfo == null ? 0 : commonAlbumUploadImageInfo.hashCode());
    }

    public final void setCover(CommonAlbumUploadImageInfo commonAlbumUploadImageInfo) {
        this.cover = commonAlbumUploadImageInfo;
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
        return "CommonAlbumUploadVideoInfo(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", cover=" + this.cover + ")";
    }

    public CommonAlbumUploadVideoInfo(String path, int i3, int i16, CommonAlbumUploadImageInfo commonAlbumUploadImageInfo) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.width = i3;
        this.height = i16;
        this.cover = commonAlbumUploadImageInfo;
    }

    public static /* synthetic */ CommonAlbumUploadVideoInfo copy$default(CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo, String str, int i3, int i16, CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = commonAlbumUploadVideoInfo.path;
        }
        if ((i17 & 2) != 0) {
            i3 = commonAlbumUploadVideoInfo.width;
        }
        if ((i17 & 4) != 0) {
            i16 = commonAlbumUploadVideoInfo.height;
        }
        if ((i17 & 8) != 0) {
            commonAlbumUploadImageInfo = commonAlbumUploadVideoInfo.cover;
        }
        return commonAlbumUploadVideoInfo.copy(str, i3, i16, commonAlbumUploadImageInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonAlbumUploadVideoInfo)) {
            return false;
        }
        CommonAlbumUploadVideoInfo commonAlbumUploadVideoInfo = (CommonAlbumUploadVideoInfo) other;
        return Intrinsics.areEqual(this.path, commonAlbumUploadVideoInfo.path) && this.width == commonAlbumUploadVideoInfo.width && this.height == commonAlbumUploadVideoInfo.height && Intrinsics.areEqual(this.cover, commonAlbumUploadVideoInfo.cover);
    }

    public /* synthetic */ CommonAlbumUploadVideoInfo(String str, int i3, int i16, CommonAlbumUploadImageInfo commonAlbumUploadImageInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? -1 : i16, (i17 & 8) != 0 ? null : commonAlbumUploadImageInfo);
    }
}
