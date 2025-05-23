package com.tencent.mobileqq.wink.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001?BY\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010+\u001a\u00020#\u0012\u0006\u0010.\u001a\u00020#\u0012\u0006\u00104\u001a\u00020/\u0012\b\u0010:\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b;\u0010<B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010=J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010+\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0017\u0010.\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u0010:\u001a\u0004\u0018\u0001058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkMediaInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getLocalPath", "()Ljava/lang/String;", "localPath", "e", "getMimeType", "mimeType", "f", "I", "getMediaWidth", "()I", "mediaWidth", tl.h.F, "getMediaHeight", "mediaHeight", "i", "getRotation", BasicAnimation.KeyPath.ROTATION, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getFileSize", "()J", "fileSize", BdhLogUtil.LogTag.Tag_Conn, "getAddedTime", "addedTime", "D", "getModifiedTime", "modifiedTime", "Lcom/tencent/mobileqq/wink/picker/CoverInfo;", "E", "Lcom/tencent/mobileqq/wink/picker/CoverInfo;", "getCoverInfo", "()Lcom/tencent/mobileqq/wink/picker/CoverInfo;", "coverInfo", "Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", "getVideoParameter", "()Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", "videoParameter", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIJJJLcom/tencent/mobileqq/wink/picker/CoverInfo;Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkMediaInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final long addedTime;

    /* renamed from: D, reason: from kotlin metadata */
    private final long modifiedTime;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CoverInfo coverInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final VideoFormatInfo videoParameter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String localPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mimeType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mediaWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mediaHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int rotation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long fileSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkMediaInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/picker/WinkMediaInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/picker/WinkMediaInfo;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.WinkMediaInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkMediaInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkMediaInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkMediaInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkMediaInfo[] newArray(int size) {
            return new WinkMediaInfo[size];
        }

        Companion() {
        }
    }

    public WinkMediaInfo(@NotNull String localPath, @NotNull String mimeType, int i3, int i16, int i17, long j3, long j16, long j17, @NotNull CoverInfo coverInfo, @Nullable VideoFormatInfo videoFormatInfo) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(coverInfo, "coverInfo");
        this.localPath = localPath;
        this.mimeType = mimeType;
        this.mediaWidth = i3;
        this.mediaHeight = i16;
        this.rotation = i17;
        this.fileSize = j3;
        this.addedTime = j16;
        this.modifiedTime = j17;
        this.coverInfo = coverInfo;
        this.videoParameter = videoFormatInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkMediaInfo)) {
            return false;
        }
        WinkMediaInfo winkMediaInfo = (WinkMediaInfo) other;
        if (Intrinsics.areEqual(this.localPath, winkMediaInfo.localPath) && Intrinsics.areEqual(this.mimeType, winkMediaInfo.mimeType) && this.mediaWidth == winkMediaInfo.mediaWidth && this.mediaHeight == winkMediaInfo.mediaHeight && this.rotation == winkMediaInfo.rotation && this.fileSize == winkMediaInfo.fileSize && this.addedTime == winkMediaInfo.addedTime && this.modifiedTime == winkMediaInfo.modifiedTime && Intrinsics.areEqual(this.coverInfo, winkMediaInfo.coverInfo) && Intrinsics.areEqual(this.videoParameter, winkMediaInfo.videoParameter)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((this.localPath.hashCode() * 31) + this.mimeType.hashCode()) * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + this.rotation) * 31) + androidx.fragment.app.a.a(this.fileSize)) * 31) + androidx.fragment.app.a.a(this.addedTime)) * 31) + androidx.fragment.app.a.a(this.modifiedTime)) * 31) + this.coverInfo.hashCode()) * 31;
        VideoFormatInfo videoFormatInfo = this.videoParameter;
        if (videoFormatInfo == null) {
            hashCode = 0;
        } else {
            hashCode = videoFormatInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "localPath = " + this.localPath + ", mimeType = " + this.mimeType + ", mediaWidth = " + this.mediaWidth + ", mediaHeight = " + this.mediaHeight + ", rotation = " + this.rotation + ", fileSize = " + this.fileSize + ", videoParameter = " + this.videoParameter;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.localPath);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.mediaWidth);
        parcel.writeInt(this.mediaHeight);
        parcel.writeInt(this.rotation);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.addedTime);
        parcel.writeLong(this.modifiedTime);
        parcel.writeParcelable(this.coverInfo, flags);
        parcel.writeParcelable(this.videoParameter, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkMediaInfo(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r9, r11, r13, r1 == null ? new CoverInfo(null, 0, 0, 7, null) : r1, (VideoFormatInfo) parcel.readParcelable(VideoFormatInfo.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        long readLong3 = parcel.readLong();
        CoverInfo coverInfo = (CoverInfo) parcel.readParcelable(CoverInfo.class.getClassLoader());
    }
}
