package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004Bc\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0006H\u00c6\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003Ju\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u00c6\u0001J\b\u00102\u001a\u00020\bH\u0016J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u00d6\u0003J\b\u00107\u001a\u00020\bH\u0016J\t\u00108\u001a\u00020\bH\u00d6\u0001J\t\u00109\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010:\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\bH\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "localPath", "", CustomImageProps.QUALITY, "", "width", "height", "fileSize", "", "originWidth", "originHeight", "originFileSize", "mimetype", "materialParamsList", "", "Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams;", "(Ljava/lang/String;IIIJIIJLjava/lang/String;Ljava/util/List;)V", "getFileSize", "()J", "getHeight", "()I", "getLocalPath", "()Ljava/lang/String;", "getMaterialParamsList", "()Ljava/util/List;", "getMimetype", "getOriginFileSize", "getOriginHeight", "getOriginWidth", "getQuality", "setQuality", "(I)V", "type", "getType", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "getMediaType", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ImageParams extends MediaParams {

    @NotNull
    private static final String TAG = "ImageParams";
    private final long fileSize;
    private final int height;

    @NotNull
    private final String localPath;

    @Nullable
    private final List<MaterialParams> materialParamsList;

    @NotNull
    private final String mimetype;
    private final long originFileSize;
    private final int originHeight;
    private final int originWidth;
    private int quality;
    private final int type;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ImageParams> CREATOR = new Parcelable.Creator<ImageParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.ImageParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ImageParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ImageParams[] newArray(int size) {
            return new ImageParams[size];
        }
    };

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ*\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "TAG", "", "from", "localMediaInfo", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "records", "", "Lcom/tencent/mobileqq/winkreport/datong/WinkPublishMediaRecord;", "wrapper", "Lcom/tencent/mobileqq/winkpublish/model/MediaWrapper;", "photoQuality", "", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ImageParams from(@Nullable MediaWrapper wrapper, int photoQuality, @Nullable List<? extends WinkPublishMediaRecord> records) {
            ImageInfo imageInfo;
            String str;
            String str2;
            if (wrapper != null && (imageInfo = wrapper.getImageInfo()) != null) {
                String str3 = imageInfo.mPath;
                if (str3 == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "it.mPath ?: \"\"");
                    str = str3;
                }
                int i3 = imageInfo.photoWidth;
                int i16 = imageInfo.photoHeight;
                long j3 = imageInfo.mSize;
                int i17 = imageInfo.photoOriginWidth;
                int i18 = imageInfo.photoOriginHeight;
                long j16 = imageInfo.photoOriginSize;
                String str4 = imageInfo.mimeType;
                if (str4 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str4, "it.mimeType ?: \"\"");
                    str2 = str4;
                }
                ImageParams imageParams = new ImageParams(str, photoQuality, i3, i16, j3, i17, i18, j16, str2, MaterialParams.INSTANCE.from(records));
                QLog.i(ImageParams.TAG, 1, "[fromMediaWrapper] " + imageParams);
                return imageParams;
            }
            QLog.i(ImageParams.TAG, 1, "[fromMediaWrapper] invalid params");
            return null;
        }

        Companion() {
        }

        @NotNull
        public final ImageParams from(@NotNull LocalMediaInfo localMediaInfo, @Nullable List<? extends WinkPublishMediaRecord> records) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
            String str3 = localMediaInfo.path;
            if (str3 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.path ?: \"\"");
                str = str3;
            }
            int i3 = localMediaInfo.mediaWidth;
            int i16 = localMediaInfo.mediaHeight;
            long j3 = localMediaInfo.fileSize;
            int i17 = localMediaInfo.mediaOriginWidth;
            int i18 = localMediaInfo.mediaOriginHeight;
            long j16 = localMediaInfo.mediaOriginSize;
            String str4 = localMediaInfo.mMimeType;
            if (str4 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str4, "it.mMimeType ?: \"\"");
                str2 = str4;
            }
            ImageParams imageParams = new ImageParams(str, 3, i3, i16, j3, i17, i18, j16, str2, MaterialParams.INSTANCE.from(records));
            QLog.i(ImageParams.TAG, 1, "[fromMediaWrapper] " + imageParams);
            return imageParams;
        }
    }

    public /* synthetic */ ImageParams(String str, int i3, int i16, int i17, long j3, int i18, int i19, long j16, String str2, List list, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i26 & 2) != 0 ? 3 : i3, i16, i17, j3, i18, i19, j16, (i26 & 256) != 0 ? "" : str2, (i26 & 512) != 0 ? null : list);
    }

    public static /* synthetic */ ImageParams copy$default(ImageParams imageParams, String str, int i3, int i16, int i17, long j3, int i18, int i19, long j16, String str2, List list, int i26, Object obj) {
        String str3;
        int i27;
        int i28;
        int i29;
        long j17;
        int i36;
        int i37;
        long j18;
        String str4;
        List list2;
        if ((i26 & 1) != 0) {
            str3 = imageParams.localPath;
        } else {
            str3 = str;
        }
        if ((i26 & 2) != 0) {
            i27 = imageParams.quality;
        } else {
            i27 = i3;
        }
        if ((i26 & 4) != 0) {
            i28 = imageParams.width;
        } else {
            i28 = i16;
        }
        if ((i26 & 8) != 0) {
            i29 = imageParams.height;
        } else {
            i29 = i17;
        }
        if ((i26 & 16) != 0) {
            j17 = imageParams.fileSize;
        } else {
            j17 = j3;
        }
        if ((i26 & 32) != 0) {
            i36 = imageParams.originWidth;
        } else {
            i36 = i18;
        }
        if ((i26 & 64) != 0) {
            i37 = imageParams.originHeight;
        } else {
            i37 = i19;
        }
        if ((i26 & 128) != 0) {
            j18 = imageParams.originFileSize;
        } else {
            j18 = j16;
        }
        if ((i26 & 256) != 0) {
            str4 = imageParams.mimetype;
        } else {
            str4 = str2;
        }
        if ((i26 & 512) != 0) {
            list2 = imageParams.materialParamsList;
        } else {
            list2 = list;
        }
        return imageParams.copy(str3, i27, i28, i29, j17, i36, i37, j18, str4, list2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final List<MaterialParams> component10() {
        return this.materialParamsList;
    }

    /* renamed from: component2, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component5, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component6, reason: from getter */
    public final int getOriginWidth() {
        return this.originWidth;
    }

    /* renamed from: component7, reason: from getter */
    public final int getOriginHeight() {
        return this.originHeight;
    }

    /* renamed from: component8, reason: from getter */
    public final long getOriginFileSize() {
        return this.originFileSize;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getMimetype() {
        return this.mimetype;
    }

    @NotNull
    public final ImageParams copy(@NotNull String localPath, int quality, int width, int height, long fileSize, int originWidth, int originHeight, long originFileSize, @NotNull String mimetype, @Nullable List<MaterialParams> materialParamsList) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        return new ImageParams(localPath, quality, width, height, fileSize, originWidth, originHeight, originFileSize, mimetype, materialParamsList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageParams)) {
            return false;
        }
        ImageParams imageParams = (ImageParams) other;
        if (Intrinsics.areEqual(this.localPath, imageParams.localPath) && this.quality == imageParams.quality && this.width == imageParams.width && this.height == imageParams.height && this.fileSize == imageParams.fileSize && this.originWidth == imageParams.originWidth && this.originHeight == imageParams.originHeight && this.originFileSize == imageParams.originFileSize && Intrinsics.areEqual(this.mimetype, imageParams.mimetype) && Intrinsics.areEqual(this.materialParamsList, imageParams.materialParamsList)) {
            return true;
        }
        return false;
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

    @Override // com.tencent.mobileqq.winkpublish.model.params.MediaParams
    /* renamed from: getMediaType, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    public final String getMimetype() {
        return this.mimetype;
    }

    public final long getOriginFileSize() {
        return this.originFileSize;
    }

    public final int getOriginHeight() {
        return this.originHeight;
    }

    public final int getOriginWidth() {
        return this.originWidth;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((this.localPath.hashCode() * 31) + this.quality) * 31) + this.width) * 31) + this.height) * 31) + a.a(this.fileSize)) * 31) + this.originWidth) * 31) + this.originHeight) * 31) + a.a(this.originFileSize)) * 31) + this.mimetype.hashCode()) * 31;
        List<MaterialParams> list = this.materialParamsList;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setQuality(int i3) {
        this.quality = i3;
    }

    @NotNull
    public String toString() {
        return "ImageParams(localPath=" + this.localPath + ", quality=" + this.quality + ", width=" + this.width + ", height=" + this.height + ", fileSize=" + this.fileSize + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", originFileSize=" + this.originFileSize + ", mimetype=" + this.mimetype + ", materialParamsList=" + this.materialParamsList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.localPath);
        parcel.writeInt(this.quality);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.originWidth);
        parcel.writeInt(this.originHeight);
        parcel.writeLong(this.originFileSize);
        parcel.writeString(this.mimetype);
        parcel.writeTypedList(this.materialParamsList);
    }

    public ImageParams(@NotNull String localPath, int i3, int i16, int i17, long j3, int i18, int i19, long j16, @NotNull String mimetype, @Nullable List<MaterialParams> list) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        this.localPath = localPath;
        this.quality = i3;
        this.width = i16;
        this.height = i17;
        this.fileSize = j3;
        this.originWidth = i18;
        this.originHeight = i19;
        this.originFileSize = j16;
        this.mimetype = mimetype;
        this.materialParamsList = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageParams(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r10, r11, r12, r1 == null ? "" : r1, parcel.createTypedArrayList(MaterialParams.CREATOR));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        long readLong = parcel.readLong();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        long readLong2 = parcel.readLong();
        String readString2 = parcel.readString();
    }
}
