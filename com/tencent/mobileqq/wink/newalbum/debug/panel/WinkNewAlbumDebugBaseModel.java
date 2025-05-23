package com.tencent.mobileqq.wink.newalbum.debug.panel;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b \u0018\u0000 C2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b@\u0010AB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b@\u0010BJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\u0012\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010&\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\"\u00109\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\"\u0010<\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b;\u0010\u0017R\"\u0010?\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001f\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "[F", "a", "()[F", DomainData.DOMAIN_NAME, "([F)V", "imageFeature", "", "e", UserInfo.SEX_FEMALE, "g", "()F", ReportConstant.COSTREPORT_PREFIX, "(F)V", LocalPhotoFaceInfo.SCORE, "", "f", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "photoID", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "photoPath", "", "i", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "w", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "I", "b", "()I", "o", "(I)V", "mediaType", BdhLogUtil.LogTag.Tag_Conn, "k", "t", "isShown", "D", "l", "v", "isTextShift", "E", "r", "photoSimilarity", "j", "u", "similarityPhotoID", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumDebugBaseModel implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isShown;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isTextShift;

    /* renamed from: E, reason: from kotlin metadata */
    private float photoSimilarity;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String similarityPhotoID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] imageFeature;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float score;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String photoID;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String photoPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mediaType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugBaseModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkNewAlbumDebugBaseModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumDebugBaseModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkNewAlbumDebugBaseModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumDebugBaseModel[] newArray(int size) {
            return new WinkNewAlbumDebugBaseModel[size];
        }

        Companion() {
        }
    }

    public WinkNewAlbumDebugBaseModel() {
        this.imageFeature = new float[0];
        this.photoID = "";
        this.photoPath = "";
        this.similarityPhotoID = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final float[] getImageFeature() {
        return this.imageFeature;
    }

    /* renamed from: b, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPhotoID() {
        return this.photoID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPhotoPath() {
        return this.photoPath;
    }

    /* renamed from: f, reason: from getter */
    public final float getPhotoSimilarity() {
        return this.photoSimilarity;
    }

    /* renamed from: g, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getSimilarityPhotoID() {
        return this.similarityPhotoID;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsShown() {
        return this.isShown;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsTextShift() {
        return this.isTextShift;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void n(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.imageFeature = fArr;
    }

    public final void o(int i3) {
        this.mediaType = i3;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoID = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoPath = str;
    }

    public final void r(float f16) {
        this.photoSimilarity = f16;
    }

    public final void s(float f16) {
        this.score = f16;
    }

    public final void t(boolean z16) {
        this.isShown = z16;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.similarityPhotoID = str;
    }

    public final void v(boolean z16) {
        this.isTextShift = z16;
    }

    public final void w(boolean z16) {
        this.isVideo = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeFloatArray(this.imageFeature);
        parcel.writeFloat(this.score);
        parcel.writeString(this.photoID);
        parcel.writeString(this.photoPath);
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mediaType);
        parcel.writeByte(this.isShown ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTextShift ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.photoSimilarity);
        parcel.writeString(this.similarityPhotoID);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumDebugBaseModel(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        float[] createFloatArray = parcel.createFloatArray();
        this.imageFeature = createFloatArray == null ? this.imageFeature : createFloatArray;
        this.score = parcel.readFloat();
        String readString = parcel.readString();
        this.photoID = readString == null ? this.photoID : readString;
        String readString2 = parcel.readString();
        this.photoPath = readString2 == null ? this.photoPath : readString2;
        this.isVideo = parcel.readByte() != 0;
        this.mediaType = parcel.readInt();
        this.isShown = parcel.readByte() != 0;
        this.isTextShift = parcel.readByte() != 0;
        this.photoSimilarity = parcel.readFloat();
        String readString3 = parcel.readString();
        this.similarityPhotoID = readString3 == null ? this.similarityPhotoID : readString3;
    }
}
