package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b!\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00011B?\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u001f\u001a\u00020\u000eH\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0018\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b\u001a\u0010(R\u0017\u0010\u001b\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b\u001b\u0010(R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b,\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "other", "", "equals", "hashCode", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "component7", "path", "photoId", "imageFeature", "isPic", "isLast", "mediaWidth", "mediaHeight", "copy", "toString", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPhotoId", "[F", "getImageFeature", "()[F", "Z", "()Z", "I", "getMediaWidth", "()I", "getMediaHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;[FZZII)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MediaScanForwardResult implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final float[] imageFeature;
    private final boolean isLast;
    private final boolean isPic;
    private final int mediaHeight;
    private final int mediaWidth;

    @NotNull
    private final String path;

    @NotNull
    private final String photoId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.MediaScanForwardResult$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MediaScanForwardResult> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaScanForwardResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaScanForwardResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaScanForwardResult[] newArray(int size) {
            return new MediaScanForwardResult[size];
        }

        Companion() {
        }
    }

    public MediaScanForwardResult(@NotNull String path, @NotNull String photoId, @NotNull float[] imageFeature, boolean z16, boolean z17, int i3, int i16) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        Intrinsics.checkNotNullParameter(imageFeature, "imageFeature");
        this.path = path;
        this.photoId = photoId;
        this.imageFeature = imageFeature;
        this.isPic = z16;
        this.isLast = z17;
        this.mediaWidth = i3;
        this.mediaHeight = i16;
    }

    public static /* synthetic */ MediaScanForwardResult copy$default(MediaScanForwardResult mediaScanForwardResult, String str, String str2, float[] fArr, boolean z16, boolean z17, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = mediaScanForwardResult.path;
        }
        if ((i17 & 2) != 0) {
            str2 = mediaScanForwardResult.photoId;
        }
        String str3 = str2;
        if ((i17 & 4) != 0) {
            fArr = mediaScanForwardResult.imageFeature;
        }
        float[] fArr2 = fArr;
        if ((i17 & 8) != 0) {
            z16 = mediaScanForwardResult.isPic;
        }
        boolean z18 = z16;
        if ((i17 & 16) != 0) {
            z17 = mediaScanForwardResult.isLast;
        }
        boolean z19 = z17;
        if ((i17 & 32) != 0) {
            i3 = mediaScanForwardResult.mediaWidth;
        }
        int i18 = i3;
        if ((i17 & 64) != 0) {
            i16 = mediaScanForwardResult.mediaHeight;
        }
        return mediaScanForwardResult.copy(str, str3, fArr2, z18, z19, i18, i16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPhotoId() {
        return this.photoId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final float[] getImageFeature() {
        return this.imageFeature;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsPic() {
        return this.isPic;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    @NotNull
    public final MediaScanForwardResult copy(@NotNull String path, @NotNull String photoId, @NotNull float[] imageFeature, boolean isPic, boolean isLast, int mediaWidth, int mediaHeight) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        Intrinsics.checkNotNullParameter(imageFeature, "imageFeature");
        return new MediaScanForwardResult(path, photoId, imageFeature, isPic, isLast, mediaWidth, mediaHeight);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MediaScanForwardResult.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.wink.model.MediaScanForwardResult");
        MediaScanForwardResult mediaScanForwardResult = (MediaScanForwardResult) other;
        if (Intrinsics.areEqual(this.path, mediaScanForwardResult.path) && this.isPic == mediaScanForwardResult.isPic && this.isLast == mediaScanForwardResult.isLast && this.mediaWidth == mediaScanForwardResult.mediaWidth && this.mediaHeight == mediaScanForwardResult.mediaHeight && Arrays.equals(this.imageFeature, mediaScanForwardResult.imageFeature)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final float[] getImageFeature() {
        return this.imageFeature;
    }

    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getPhotoId() {
        return this.photoId;
    }

    public int hashCode() {
        return (((((((((this.path.hashCode() * 31) + com.tencent.aio.widget.textView.param.a.a(this.isPic)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isLast)) * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + Arrays.hashCode(this.imageFeature);
    }

    public final boolean isLast() {
        return this.isLast;
    }

    public final boolean isPic() {
        return this.isPic;
    }

    @NotNull
    public String toString() {
        return "MediaScanForwardResult(path=" + this.path + ", photoId=" + this.photoId + ", imageFeature=" + Arrays.toString(this.imageFeature) + ", isPic=" + this.isPic + ", isLast=" + this.isLast + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.path);
        parcel.writeString(this.photoId);
        parcel.writeFloatArray(this.imageFeature);
        parcel.writeByte(this.isPic ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isLast ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mediaWidth);
        parcel.writeInt(this.mediaHeight);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaScanForwardResult(@NotNull Parcel parcel) {
        this(r3, r4, r0 == null ? new float[0] : r0, parcel.readByte() != 0, parcel.readByte() != 0, parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        float[] createFloatArray = parcel.createFloatArray();
    }
}
