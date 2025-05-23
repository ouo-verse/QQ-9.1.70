package com.tencent.mobileqq.wink.magicstudio.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b3\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\b\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010>\u001a\u00020\b\u00a2\u0006\u0004\b?\u0010@J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b&\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b5\u0010\u0015R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\"\u0010>\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u00100\"\u0004\b=\u00102\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "originFilePath", "e", "f", ReportConstant.COSTREPORT_PREFIX, "originFileMd5", "k", "v", "uploadUrl", tl.h.F, "a", DomainData.DOMAIN_NAME, "compressPath", "i", "b", "o", "compressUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "p", "cropFaceUrl", BdhLogUtil.LogTag.Tag_Conn, "j", "u", "safeId", "D", "Z", "()Z", "w", "(Z)V", "isVertical", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "cutImgPath", UserInfo.SEX_FEMALE, "getCutImgUrl", "setCutImgUrl", "cutImgUrl", "G", "l", "r", "isFromCamera", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioUploadImgInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MagicStudioUploadImgInfo> CREATOR = new a();

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String safeId;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private volatile boolean isVertical;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private volatile String cutImgPath;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private volatile String cutImgUrl;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private boolean isFromCamera;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String originFilePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String originFileMd5;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String uploadUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String compressPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String compressUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String cropFaceUrl;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<MagicStudioUploadImgInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MagicStudioUploadImgInfo createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            if (parcel.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            return new MagicStudioUploadImgInfo(readString, readString2, readString3, readString4, readString5, readString6, readString7, z16, readString8, readString9, z17);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MagicStudioUploadImgInfo[] newArray(int i3) {
            return new MagicStudioUploadImgInfo[i3];
        }
    }

    public MagicStudioUploadImgInfo() {
        this(null, null, null, null, null, null, null, false, null, null, false, 2047, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCompressPath() {
        return this.compressPath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCompressUrl() {
        return this.compressUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCropFaceUrl() {
        return this.cropFaceUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getCutImgPath() {
        return this.cutImgPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioUploadImgInfo)) {
            return false;
        }
        MagicStudioUploadImgInfo magicStudioUploadImgInfo = (MagicStudioUploadImgInfo) other;
        if (Intrinsics.areEqual(this.originFilePath, magicStudioUploadImgInfo.originFilePath) && Intrinsics.areEqual(this.originFileMd5, magicStudioUploadImgInfo.originFileMd5) && Intrinsics.areEqual(this.uploadUrl, magicStudioUploadImgInfo.uploadUrl) && Intrinsics.areEqual(this.compressPath, magicStudioUploadImgInfo.compressPath) && Intrinsics.areEqual(this.compressUrl, magicStudioUploadImgInfo.compressUrl) && Intrinsics.areEqual(this.cropFaceUrl, magicStudioUploadImgInfo.cropFaceUrl) && Intrinsics.areEqual(this.safeId, magicStudioUploadImgInfo.safeId) && this.isVertical == magicStudioUploadImgInfo.isVertical && Intrinsics.areEqual(this.cutImgPath, magicStudioUploadImgInfo.cutImgPath) && Intrinsics.areEqual(this.cutImgUrl, magicStudioUploadImgInfo.cutImgUrl) && this.isFromCamera == magicStudioUploadImgInfo.isFromCamera) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getOriginFileMd5() {
        return this.originFileMd5;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getOriginFilePath() {
        return this.originFilePath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.originFilePath.hashCode() * 31) + this.originFileMd5.hashCode()) * 31) + this.uploadUrl.hashCode()) * 31) + this.compressPath.hashCode()) * 31) + this.compressUrl.hashCode()) * 31) + this.cropFaceUrl.hashCode()) * 31) + this.safeId.hashCode()) * 31;
        boolean z16 = this.isVertical;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((((hashCode + i16) * 31) + this.cutImgPath.hashCode()) * 31) + this.cutImgUrl.hashCode()) * 31;
        boolean z17 = this.isFromCamera;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSafeId() {
        return this.safeId;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsFromCamera() {
        return this.isFromCamera;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.compressPath = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.compressUrl = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cropFaceUrl = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cutImgPath = str;
    }

    public final void r(boolean z16) {
        this.isFromCamera = z16;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originFileMd5 = str;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originFilePath = str;
    }

    @NotNull
    public String toString() {
        return "MagicStudioUploadImgInfo(originFilePath=" + this.originFilePath + ", originFileMd5=" + this.originFileMd5 + ", uploadUrl=" + this.uploadUrl + ", compressPath=" + this.compressPath + ", compressUrl=" + this.compressUrl + ", cropFaceUrl=" + this.cropFaceUrl + ", safeId=" + this.safeId + ", isVertical=" + this.isVertical + ", cutImgPath=" + this.cutImgPath + ", cutImgUrl=" + this.cutImgUrl + ", isFromCamera=" + this.isFromCamera + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.safeId = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadUrl = str;
    }

    public final void w(boolean z16) {
        this.isVertical = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.originFilePath);
        parcel.writeString(this.originFileMd5);
        parcel.writeString(this.uploadUrl);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.compressUrl);
        parcel.writeString(this.cropFaceUrl);
        parcel.writeString(this.safeId);
        parcel.writeInt(this.isVertical ? 1 : 0);
        parcel.writeString(this.cutImgPath);
        parcel.writeString(this.cutImgUrl);
        parcel.writeInt(this.isFromCamera ? 1 : 0);
    }

    public MagicStudioUploadImgInfo(@NotNull String originFilePath, @NotNull String originFileMd5, @NotNull String uploadUrl, @NotNull String compressPath, @NotNull String compressUrl, @NotNull String cropFaceUrl, @NotNull String safeId, boolean z16, @NotNull String cutImgPath, @NotNull String cutImgUrl, boolean z17) {
        Intrinsics.checkNotNullParameter(originFilePath, "originFilePath");
        Intrinsics.checkNotNullParameter(originFileMd5, "originFileMd5");
        Intrinsics.checkNotNullParameter(uploadUrl, "uploadUrl");
        Intrinsics.checkNotNullParameter(compressPath, "compressPath");
        Intrinsics.checkNotNullParameter(compressUrl, "compressUrl");
        Intrinsics.checkNotNullParameter(cropFaceUrl, "cropFaceUrl");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        Intrinsics.checkNotNullParameter(cutImgPath, "cutImgPath");
        Intrinsics.checkNotNullParameter(cutImgUrl, "cutImgUrl");
        this.originFilePath = originFilePath;
        this.originFileMd5 = originFileMd5;
        this.uploadUrl = uploadUrl;
        this.compressPath = compressPath;
        this.compressUrl = compressUrl;
        this.cropFaceUrl = cropFaceUrl;
        this.safeId = safeId;
        this.isVertical = z16;
        this.cutImgPath = cutImgPath;
        this.cutImgUrl = cutImgUrl;
        this.isFromCamera = z17;
    }

    public /* synthetic */ MagicStudioUploadImgInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, String str8, String str9, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? true : z16, (i3 & 256) != 0 ? "" : str8, (i3 & 512) == 0 ? str9 : "", (i3 & 1024) != 0 ? false : z17);
    }
}
