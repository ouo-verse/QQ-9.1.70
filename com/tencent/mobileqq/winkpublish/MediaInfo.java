package com.tencent.mobileqq.winkpublish;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mediaPath", "", "uploadResult", "Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", "(Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;)V", "getMediaPath", "()Ljava/lang/String;", "getUploadResult", "()Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MediaInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String mediaPath;

    @Nullable
    private final MediaUploadResult uploadResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/MediaInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/winkpublish/MediaInfo;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.winkpublish.MediaInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MediaInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MediaInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MediaInfo[] newArray(int size) {
            return new MediaInfo[size];
        }
    }

    public MediaInfo(@NotNull String mediaPath, @Nullable MediaUploadResult mediaUploadResult) {
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        this.mediaPath = mediaPath;
        this.uploadResult = mediaUploadResult;
    }

    public static /* synthetic */ MediaInfo copy$default(MediaInfo mediaInfo, String str, MediaUploadResult mediaUploadResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mediaInfo.mediaPath;
        }
        if ((i3 & 2) != 0) {
            mediaUploadResult = mediaInfo.uploadResult;
        }
        return mediaInfo.copy(str, mediaUploadResult);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMediaPath() {
        return this.mediaPath;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final MediaUploadResult getUploadResult() {
        return this.uploadResult;
    }

    @NotNull
    public final MediaInfo copy(@NotNull String mediaPath, @Nullable MediaUploadResult uploadResult) {
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        return new MediaInfo(mediaPath, uploadResult);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if (Intrinsics.areEqual(this.mediaPath, mediaInfo.mediaPath) && Intrinsics.areEqual(this.uploadResult, mediaInfo.uploadResult)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getMediaPath() {
        return this.mediaPath;
    }

    @Nullable
    public final MediaUploadResult getUploadResult() {
        return this.uploadResult;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.mediaPath.hashCode() * 31;
        MediaUploadResult mediaUploadResult = this.uploadResult;
        if (mediaUploadResult == null) {
            hashCode = 0;
        } else {
            hashCode = mediaUploadResult.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "MediaInfo(mediaPath=" + this.mediaPath + ", uploadResult=" + this.uploadResult + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.mediaPath);
        parcel.writeParcelable(this.uploadResult, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaInfo(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, (MediaUploadResult) parcel.readParcelable(MediaUploadResult.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
