package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u00a1\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u001bJ\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\bH\u00c6\u0003J\t\u00108\u001a\u00020\u0006H\u00c6\u0003J\t\u00109\u001a\u00020\u0014H\u00c6\u0003J\t\u0010:\u001a\u00020\u0014H\u00c6\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017H\u00c6\u0003J\t\u0010>\u001a\u00020\bH\u00c6\u0003J\t\u0010?\u001a\u00020\bH\u00c6\u0003J\t\u0010@\u001a\u00020\u000bH\u00c6\u0003J\t\u0010A\u001a\u00020\u000bH\u00c6\u0003J\t\u0010B\u001a\u00020\u0006H\u00c6\u0003J\t\u0010C\u001a\u00020\bH\u00c6\u0003J\t\u0010D\u001a\u00020\bH\u00c6\u0003J\t\u0010E\u001a\u00020\u000bH\u00c6\u0003J\u00b9\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017H\u00c6\u0001J\b\u0010G\u001a\u00020\bH\u0016J\u0013\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010JH\u00d6\u0003J\b\u0010K\u001a\u00020\bH\u0016J\t\u0010L\u001a\u00020\bH\u00d6\u0001J\t\u0010M\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010N\u001a\u00020O2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\bH\u0016R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010(R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010(R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u0011\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u00101R\u0011\u0010\u0011\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0014\u00103\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001f\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "localPath", "", "width", "", "height", "fileSize", "", "bitrate", QQWinkConstants.COVER_PATH, "coverWidth", "coverHeight", "duration", BasicAnimation.KeyPath.ROTATION, "mimetype", "isHEVC", "", "isHDR", "originVideoParams", "", "md5", "materialParamsList", "Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams;", "(Ljava/lang/String;IIJJLjava/lang/String;IIJILjava/lang/String;ZZLjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getBitrate", "()J", "getCoverHeight", "()I", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "getCoverWidth", "getDuration", "getFileSize", "getHeight", "()Z", "getLocalPath", "getMaterialParamsList", "()Ljava/util/List;", "getMd5", "setMd5", "getMimetype", "getOriginVideoParams", "setOriginVideoParams", "(Ljava/util/List;)V", "getRotation", "type", "getType", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getMediaType", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class VideoParams extends MediaParams {

    @NotNull
    private static final String TAG = "VideoParams";
    private final long bitrate;
    private final int coverHeight;

    @NotNull
    private String coverPath;
    private final int coverWidth;
    private final long duration;
    private final long fileSize;
    private final int height;
    private final boolean isHDR;
    private final boolean isHEVC;

    @NotNull
    private final String localPath;

    @Nullable
    private final List<MaterialParams> materialParamsList;

    @NotNull
    private String md5;

    @NotNull
    private final String mimetype;

    @Nullable
    private List<VideoParams> originVideoParams;
    private final int rotation;
    private final int type;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<VideoParams> CREATOR = new Parcelable.Creator<VideoParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.VideoParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoParams[] newArray(int size) {
            return new VideoParams[size];
        }
    };

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "TAG", "", "from", "localMediaInfo", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "records", "", "Lcom/tencent/mobileqq/winkreport/datong/WinkPublishMediaRecord;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoParams from(@NotNull LocalMediaInfo localMediaInfo, @Nullable List<? extends WinkPublishMediaRecord> records) {
            String str;
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            String str4 = localMediaInfo.path;
            if (str4 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "it.path ?: \"\"");
                str = str4;
            }
            int i3 = localMediaInfo.mediaWidth;
            int i16 = localMediaInfo.mediaHeight;
            long j3 = localMediaInfo.fileSize;
            long j16 = localMediaInfo.mediaBitrate;
            String str5 = localMediaInfo.thumbnailPath;
            if (str5 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str5, "it.thumbnailPath ?: \"\"");
                str2 = str5;
            }
            int i17 = localMediaInfo.thumbWidth;
            int i18 = localMediaInfo.thumbHeight;
            long j17 = localMediaInfo.mDuration;
            int i19 = localMediaInfo.rotation;
            String str6 = localMediaInfo.mMimeType;
            if (str6 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "it.mMimeType ?: \"\"");
                str3 = str6;
            }
            VideoParams videoParams = new VideoParams(str, i3, i16, j3, j16, str2, i17, i18, j17, i19, str3, Intrinsics.areEqual("video/hevc", localMediaInfo.videoMimeType), localMediaInfo.isHDRVideo, null, null, MaterialParams.INSTANCE.from(records), 24576, null);
            QLog.i(VideoParams.TAG, 1, "[from] " + videoParams);
            return videoParams;
        }

        Companion() {
        }
    }

    public /* synthetic */ VideoParams(String str, int i3, int i16, long j3, long j16, String str2, int i17, int i18, long j17, int i19, String str3, boolean z16, boolean z17, List list, String str4, List list2, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, j3, j16, str2, i17, i18, j17, i19, (i26 & 1024) != 0 ? "" : str3, (i26 & 2048) != 0 ? false : z16, (i26 & 4096) != 0 ? false : z17, (i26 & 8192) != 0 ? null : list, (i26 & 16384) != 0 ? "" : str4, (i26 & 32768) != 0 ? null : list2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component10, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getMimetype() {
        return this.mimetype;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsHEVC() {
        return this.isHEVC;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsHDR() {
        return this.isHDR;
    }

    @Nullable
    public final List<VideoParams> component14() {
        return this.originVideoParams;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    public final List<MaterialParams> component16() {
        return this.materialParamsList;
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
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBitrate() {
        return this.bitrate;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCoverWidth() {
        return this.coverWidth;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCoverHeight() {
        return this.coverHeight;
    }

    /* renamed from: component9, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final VideoParams copy(@NotNull String localPath, int width, int height, long fileSize, long bitrate, @NotNull String coverPath, int coverWidth, int coverHeight, long duration, int rotation, @NotNull String mimetype, boolean isHEVC, boolean isHDR, @Nullable List<VideoParams> originVideoParams, @NotNull String md5, @Nullable List<MaterialParams> materialParamsList) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new VideoParams(localPath, width, height, fileSize, bitrate, coverPath, coverWidth, coverHeight, duration, rotation, mimetype, isHEVC, isHDR, originVideoParams, md5, materialParamsList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoParams)) {
            return false;
        }
        VideoParams videoParams = (VideoParams) other;
        if (Intrinsics.areEqual(this.localPath, videoParams.localPath) && this.width == videoParams.width && this.height == videoParams.height && this.fileSize == videoParams.fileSize && this.bitrate == videoParams.bitrate && Intrinsics.areEqual(this.coverPath, videoParams.coverPath) && this.coverWidth == videoParams.coverWidth && this.coverHeight == videoParams.coverHeight && this.duration == videoParams.duration && this.rotation == videoParams.rotation && Intrinsics.areEqual(this.mimetype, videoParams.mimetype) && this.isHEVC == videoParams.isHEVC && this.isHDR == videoParams.isHDR && Intrinsics.areEqual(this.originVideoParams, videoParams.originVideoParams) && Intrinsics.areEqual(this.md5, videoParams.md5) && Intrinsics.areEqual(this.materialParamsList, videoParams.materialParamsList)) {
            return true;
        }
        return false;
    }

    public final long getBitrate() {
        return this.bitrate;
    }

    public final int getCoverHeight() {
        return this.coverHeight;
    }

    @NotNull
    public final String getCoverPath() {
        return this.coverPath;
    }

    public final int getCoverWidth() {
        return this.coverWidth;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final List<MaterialParams> getMaterialParamsList() {
        return this.materialParamsList;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @Override // com.tencent.mobileqq.winkpublish.model.params.MediaParams
    /* renamed from: getMediaType, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    public final String getMimetype() {
        return this.mimetype;
    }

    @Nullable
    public final List<VideoParams> getOriginVideoParams() {
        return this.originVideoParams;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((((this.localPath.hashCode() * 31) + this.width) * 31) + this.height) * 31) + a.a(this.fileSize)) * 31) + a.a(this.bitrate)) * 31) + this.coverPath.hashCode()) * 31) + this.coverWidth) * 31) + this.coverHeight) * 31) + a.a(this.duration)) * 31) + this.rotation) * 31) + this.mimetype.hashCode()) * 31;
        boolean z16 = this.isHEVC;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isHDR;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        List<VideoParams> list = this.originVideoParams;
        int i19 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int hashCode3 = (((i18 + hashCode) * 31) + this.md5.hashCode()) * 31;
        List<MaterialParams> list2 = this.materialParamsList;
        if (list2 != null) {
            i19 = list2.hashCode();
        }
        return hashCode3 + i19;
    }

    public final boolean isHDR() {
        return this.isHDR;
    }

    public final boolean isHEVC() {
        return this.isHEVC;
    }

    public final void setCoverPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final void setMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void setOriginVideoParams(@Nullable List<VideoParams> list) {
        this.originVideoParams = list;
    }

    @NotNull
    public String toString() {
        return "VideoParams(localPath=" + this.localPath + ", width=" + this.width + ", height=" + this.height + ", fileSize=" + this.fileSize + ", bitrate=" + this.bitrate + ", coverPath=" + this.coverPath + ", coverWidth=" + this.coverWidth + ", coverHeight=" + this.coverHeight + ", duration=" + this.duration + ", rotation=" + this.rotation + ", mimetype=" + this.mimetype + ", isHEVC=" + this.isHEVC + ", isHDR=" + this.isHDR + ", originVideoParams=" + this.originVideoParams + ", md5=" + this.md5 + ", materialParamsList=" + this.materialParamsList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.localPath);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.bitrate);
        parcel.writeString(this.coverPath);
        parcel.writeInt(this.coverWidth);
        parcel.writeInt(this.coverHeight);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.rotation);
        parcel.writeString(this.mimetype);
        parcel.writeByte(this.isHEVC ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHDR ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.originVideoParams);
        parcel.writeString(this.md5);
        parcel.writeTypedList(this.materialParamsList);
    }

    public VideoParams(@NotNull String localPath, int i3, int i16, long j3, long j16, @NotNull String coverPath, int i17, int i18, long j17, int i19, @NotNull String mimetype, boolean z16, boolean z17, @Nullable List<VideoParams> list, @NotNull String md5, @Nullable List<MaterialParams> list2) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.localPath = localPath;
        this.width = i3;
        this.height = i16;
        this.fileSize = j3;
        this.bitrate = j16;
        this.coverPath = coverPath;
        this.coverWidth = i17;
        this.coverHeight = i18;
        this.duration = j17;
        this.rotation = i19;
        this.mimetype = mimetype;
        this.isHEVC = z16;
        this.isHDR = z17;
        this.originVideoParams = list;
        this.md5 = md5;
        this.materialParamsList = list2;
        this.type = 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoParams(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r1, r19, r20, r3 == null ? "" : r3, parcel.createTypedArrayList(MaterialParams.CREATOR));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        long readLong3 = parcel.readLong();
        int readInt5 = parcel.readInt();
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        boolean z16 = parcel.readByte() != 0;
        boolean z17 = parcel.readByte() != 0;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CREATOR);
        String readString4 = parcel.readString();
    }
}
