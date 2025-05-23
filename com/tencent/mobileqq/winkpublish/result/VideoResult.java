package com.tencent.mobileqq.winkpublish.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/result/VideoResult;", "Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoId", "", "coverResult", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "(Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/result/ImageResult;)V", "getCoverResult", "()Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "setCoverResult", "(Lcom/tencent/mobileqq/winkpublish/result/ImageResult;)V", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class VideoResult extends MediaUploadResult {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private ImageResult coverResult;

    @NotNull
    private String videoId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/result/VideoResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/result/VideoResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/winkpublish/result/VideoResult;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.winkpublish.result.VideoResult$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<VideoResult> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoResult[] newArray(int size) {
            return new VideoResult[size];
        }
    }

    public VideoResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VideoResult copy$default(VideoResult videoResult, String str, ImageResult imageResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = videoResult.videoId;
        }
        if ((i3 & 2) != 0) {
            imageResult = videoResult.coverResult;
        }
        return videoResult.copy(str, imageResult);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final ImageResult getCoverResult() {
        return this.coverResult;
    }

    @NotNull
    public final VideoResult copy(@NotNull String videoId, @Nullable ImageResult coverResult) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return new VideoResult(videoId, coverResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoResult)) {
            return false;
        }
        VideoResult videoResult = (VideoResult) other;
        if (Intrinsics.areEqual(this.videoId, videoResult.videoId) && Intrinsics.areEqual(this.coverResult, videoResult.coverResult)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ImageResult getCoverResult() {
        return this.coverResult;
    }

    @NotNull
    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.videoId.hashCode() * 31;
        ImageResult imageResult = this.coverResult;
        if (imageResult == null) {
            hashCode = 0;
        } else {
            hashCode = imageResult.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setCoverResult(@Nullable ImageResult imageResult) {
        this.coverResult = imageResult;
    }

    public final void setVideoId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoId = str;
    }

    @NotNull
    public String toString() {
        return "VideoResult(videoId=" + this.videoId + ", coverResult=" + this.coverResult + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.videoId);
        parcel.writeParcelable(this.coverResult, flags);
    }

    public /* synthetic */ VideoResult(String str, ImageResult imageResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : imageResult);
    }

    public VideoResult(@NotNull String videoId, @Nullable ImageResult imageResult) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoId = videoId;
        this.coverResult = imageResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoResult(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, (ImageResult) parcel.readParcelable(ImageResult.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
