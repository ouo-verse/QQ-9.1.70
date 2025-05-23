package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.picker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0018\b\u0087\b\u0018\u0000 72\u00020\u0001:\u00010Bi\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020 \u0012\b\b\u0002\u0010(\u001a\u00020 \u0012\b\b\u0002\u0010+\u001a\u00020 \u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0017\u0010+\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018R\u0019\u00101\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u0019\u00104\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u0010\u0018\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/picker/MediaData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "getType", "()I", "type", "e", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "mimeType", "f", "getWidth", "width", h.F, "getHeight", "height", "", "i", "J", "getSelectStart", "()J", "selectStart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSelectDuration", "selectDuration", BdhLogUtil.LogTag.Tag_Conn, "b", "duration", "D", "c", "mediaPath", "E", "a", "compressPath", UserInfo.SEX_FEMALE, "getDisplayName", CommonConstant.KEY_DISPLAY_NAME, "<init>", "(ILjava/lang/String;IIJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "G", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class MediaData implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final String mediaPath;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private final String compressPath;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private final String displayName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mimeType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final long selectDuration;

    @NotNull
    public static final Parcelable.Creator<MediaData> CREATOR = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class b implements Parcelable.Creator<MediaData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaData(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MediaData[] newArray(int i3) {
            return new MediaData[i3];
        }
    }

    public MediaData(int i3, @NotNull String mimeType, int i16, int i17, long j3, long j16, long j17, @NotNull String mediaPath, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        this.type = i3;
        this.mimeType = mimeType;
        this.width = i16;
        this.height = i17;
        this.selectStart = j3;
        this.selectDuration = j16;
        this.duration = j17;
        this.mediaPath = mediaPath;
        this.compressPath = str;
        this.displayName = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCompressPath() {
        return this.compressPath;
    }

    /* renamed from: b, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMediaPath() {
        return this.mediaPath;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaData)) {
            return false;
        }
        MediaData mediaData = (MediaData) other;
        if (this.type == mediaData.type && Intrinsics.areEqual(this.mimeType, mediaData.mimeType) && this.width == mediaData.width && this.height == mediaData.height && this.selectStart == mediaData.selectStart && this.selectDuration == mediaData.selectDuration && this.duration == mediaData.duration && Intrinsics.areEqual(this.mediaPath, mediaData.mediaPath) && Intrinsics.areEqual(this.compressPath, mediaData.compressPath) && Intrinsics.areEqual(this.displayName, mediaData.displayName)) {
            return true;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((this.type * 31) + this.mimeType.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + a.a(this.selectStart)) * 31) + a.a(this.selectDuration)) * 31) + a.a(this.duration)) * 31) + this.mediaPath.hashCode()) * 31;
        String str = this.compressPath;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.displayName;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "MediaData(type=" + this.type + ", mimeType=" + this.mimeType + ", width=" + this.width + ", height=" + this.height + ", selectStart=" + this.selectStart + ", selectDuration=" + this.selectDuration + ", duration=" + this.duration + ", mediaPath=" + this.mediaPath + ", compressPath=" + this.compressPath + ", displayName=" + this.displayName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.type);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.selectStart);
        parcel.writeLong(this.selectDuration);
        parcel.writeLong(this.duration);
        parcel.writeString(this.mediaPath);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.displayName);
    }
}
