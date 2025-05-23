package com.tencent.mobileqq.wink.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00014BK\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010!\u0012\b\u0010)\u001a\u0004\u0018\u00010!\u0012\u0006\u0010/\u001a\u00020*\u00a2\u0006\u0004\b0\u00101B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\t\u0010\u000b\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010)\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "hashCode", "", "other", "", "equals", "d", "I", "getColorStandard", "()I", "colorStandard", "e", "getColorTransfer", "colorTransfer", "f", "getProfile", "profile", tl.h.F, "getLevel", "level", "i", "getBitrate", "bitrate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "getHdrStaticInfo", "()[B", "hdrStaticInfo", BdhLogUtil.LogTag.Tag_Conn, "getHdr10PlusInfo", "hdr10PlusInfo", "", "D", "J", "getDurationMs", "()J", "durationMs", "<init>", "(IIIII[B[BJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.WinkVideoParameter, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class VideoFormatInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private final byte[] hdr10PlusInfo;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorStandard;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorTransfer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int profile;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int level;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bitrate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final byte[] hdrStaticInfo;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/picker/WinkVideoParameter;", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.WinkVideoParameter$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<VideoFormatInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoFormatInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoFormatInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoFormatInfo[] newArray(int size) {
            return new VideoFormatInfo[size];
        }

        Companion() {
        }
    }

    public VideoFormatInfo(int i3, int i16, int i17, int i18, int i19, @Nullable byte[] bArr, @Nullable byte[] bArr2, long j3) {
        this.colorStandard = i3;
        this.colorTransfer = i16;
        this.profile = i17;
        this.level = i18;
        this.bitrate = i19;
        this.hdrStaticInfo = bArr;
        this.hdr10PlusInfo = bArr2;
        this.duration = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoFormatInfo)) {
            return false;
        }
        VideoFormatInfo videoFormatInfo = (VideoFormatInfo) other;
        if (this.colorStandard == videoFormatInfo.colorStandard && this.colorTransfer == videoFormatInfo.colorTransfer && this.profile == videoFormatInfo.profile && this.level == videoFormatInfo.level && this.bitrate == videoFormatInfo.bitrate && Intrinsics.areEqual(this.hdrStaticInfo, videoFormatInfo.hdrStaticInfo) && Intrinsics.areEqual(this.hdr10PlusInfo, videoFormatInfo.hdr10PlusInfo) && this.duration == videoFormatInfo.duration) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((((((((this.colorStandard * 31) + this.colorTransfer) * 31) + this.profile) * 31) + this.level) * 31) + this.bitrate) * 31;
        byte[] bArr = this.hdrStaticInfo;
        int i16 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i17 = (i3 + hashCode) * 31;
        byte[] bArr2 = this.hdr10PlusInfo;
        if (bArr2 != null) {
            i16 = Arrays.hashCode(bArr2);
        }
        return ((i17 + i16) * 31) + androidx.fragment.app.a.a(this.duration);
    }

    @NotNull
    public String toString() {
        return "VideoFormatInfo(colorStandard=" + this.colorStandard + ", colorTransfer=" + this.colorTransfer + ", profile=" + this.profile + ", level=" + this.level + ", bitrate=" + this.bitrate + ", hdrStaticInfo=" + this.hdrStaticInfo + ", hdr10PlusInfo=" + this.hdr10PlusInfo + ", duration=" + this.duration + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.colorStandard);
        parcel.writeInt(this.colorTransfer);
        parcel.writeInt(this.profile);
        parcel.writeInt(this.level);
        parcel.writeInt(this.bitrate);
        parcel.writeByteArray(this.hdrStaticInfo);
        parcel.writeByteArray(this.hdr10PlusInfo);
        parcel.writeLong(this.duration);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoFormatInfo(@NotNull Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
