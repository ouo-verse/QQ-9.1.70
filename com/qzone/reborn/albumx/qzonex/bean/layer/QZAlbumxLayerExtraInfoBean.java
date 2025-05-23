package com.qzone.reborn.albumx.qzonex.bean.layer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 r2\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\bo\u0010pB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bo\u0010qJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R$\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R$\u00100\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b\u000b\u0010!R$\u00102\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b\u0011\u0010\u001f\"\u0004\b1\u0010!R$\u00106\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\"\u0010:\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\"\u0010>\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010@\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b?\u0010\u001f\"\u0004\b.\u0010!R$\u0010D\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\"\u0010K\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010O\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010A\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR$\u0010Q\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\bP\u0010!R$\u0010T\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u001d\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010!R$\u0010W\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u001d\u001a\u0004\bV\u0010\u001f\"\u0004\b3\u0010!R$\u0010_\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010b\u001a\u00020E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010A\u001a\u0004\ba\u0010H\"\u0004\b7\u0010JR$\u0010f\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010\u001d\u001a\u0004\bd\u0010\u001f\"\u0004\be\u0010!R\"\u0010j\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR\"\u0010n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010\u000b\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000f\u00a8\u0006s"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Z", "v", "()Z", "M", "(Z)V", "isPraise", "e", "I", DomainData.DOMAIN_NAME, "()I", "V", "(I)V", "praiseNum", "f", BdhLogUtil.LogTag.Tag_Conn, "commentNum", "", h.F, "Ljava/lang/String;", "r", "()Ljava/lang/String;", "d0", "(Ljava/lang/String;)V", "uin", "i", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "albumId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AEEditorConstants.ALBUMNAME, "j", "E", "lLoc", "D", "o", "sLoc", "B", "batchId", UserInfo.SEX_FEMALE, "u", "i0", "videoId", "G", HippyTKDListViewAdapter.X, "h0", BaseProfileQZoneComponent.KEY_IS_VIDEO, "H", "w", "c0", "isShowRepair", "g", "desc", "J", "t", "f0", "uploadUid", "", "K", ReportConstant.COSTREPORT_PREFIX, "()J", "e0", "(J)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "L", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b0", "shootTime", "N", "praiseKey", "getUploadUserName", "g0", "uploadUserName", "P", "k", "lbs", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "p", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "a0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;)V", "shareInfo", BdhLogUtil.LogTag.Tag_Req, "l", "linkId", ExifInterface.LATITUDE_SOUTH, "a", "y", "albumCreatorUin", "T", "getHasQQCode", "setHasQQCode", "hasQQCode", "U", "getHasQRCode", "setHasQRCode", "hasQRCode", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxLayerExtraInfoBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String lLoc;

    /* renamed from: D, reason: from kotlin metadata */
    private String sLoc;

    /* renamed from: E, reason: from kotlin metadata */
    private String batchId;

    /* renamed from: F, reason: from kotlin metadata */
    private String videoId;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isVideo;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isShowRepair;

    /* renamed from: I, reason: from kotlin metadata */
    private String desc;

    /* renamed from: J, reason: from kotlin metadata */
    private String uploadUid;

    /* renamed from: K, reason: from kotlin metadata */
    private long uploadTime;

    /* renamed from: L, reason: from kotlin metadata */
    private long shootTime;

    /* renamed from: M, reason: from kotlin metadata */
    private String praiseKey;

    /* renamed from: N, reason: from kotlin metadata */
    private String uploadUserName;

    /* renamed from: P, reason: from kotlin metadata */
    private String lbs;

    /* renamed from: Q, reason: from kotlin metadata */
    private CommonStShare shareInfo;

    /* renamed from: R, reason: from kotlin metadata */
    private long linkId;

    /* renamed from: S, reason: from kotlin metadata */
    private String albumCreatorUin;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean hasQQCode;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasQRCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPraise;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int praiseNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int commentNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZAlbumxLayerExtraInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZAlbumxLayerExtraInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZAlbumxLayerExtraInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZAlbumxLayerExtraInfoBean[] newArray(int size) {
            return new QZAlbumxLayerExtraInfoBean[size];
        }

        Companion() {
        }
    }

    public QZAlbumxLayerExtraInfoBean() {
    }

    public final void A(String str) {
        this.albumName = str;
    }

    public final void B(String str) {
        this.batchId = str;
    }

    public final void C(int i3) {
        this.commentNum = i3;
    }

    public final void D(String str) {
        this.desc = str;
    }

    public final void E(String str) {
        this.lLoc = str;
    }

    public final void F(String str) {
        this.lbs = str;
    }

    public final void G(long j3) {
        this.linkId = j3;
    }

    public final void M(boolean z16) {
        this.isPraise = z16;
    }

    public final void N(String str) {
        this.praiseKey = str;
    }

    public final void V(int i3) {
        this.praiseNum = i3;
    }

    public final void Z(String str) {
        this.sLoc = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumCreatorUin() {
        return this.albumCreatorUin;
    }

    public final void a0(CommonStShare commonStShare) {
        this.shareInfo = commonStShare;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final void b0(long j3) {
        this.shootTime = j3;
    }

    /* renamed from: c, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    public final void c0(boolean z16) {
        this.isShowRepair = z16;
    }

    public final void d0(String str) {
        this.uin = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    public final void e0(long j3) {
        this.uploadTime = j3;
    }

    /* renamed from: f, reason: from getter */
    public final int getCommentNum() {
        return this.commentNum;
    }

    public final void f0(String str) {
        this.uploadUid = str;
    }

    /* renamed from: g, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final void g0(String str) {
        this.uploadUserName = str;
    }

    public final void h0(boolean z16) {
        this.isVideo = z16;
    }

    public final void i0(String str) {
        this.videoId = str;
    }

    /* renamed from: j, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: k, reason: from getter */
    public final String getLbs() {
        return this.lbs;
    }

    /* renamed from: l, reason: from getter */
    public final long getLinkId() {
        return this.linkId;
    }

    /* renamed from: m, reason: from getter */
    public final String getPraiseKey() {
        return this.praiseKey;
    }

    /* renamed from: n, reason: from getter */
    public final int getPraiseNum() {
        return this.praiseNum;
    }

    /* renamed from: o, reason: from getter */
    public final String getSLoc() {
        return this.sLoc;
    }

    /* renamed from: p, reason: from getter */
    public final CommonStShare getShareInfo() {
        return this.shareInfo;
    }

    /* renamed from: q, reason: from getter */
    public final long getShootTime() {
        return this.shootTime;
    }

    /* renamed from: r, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: s, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    /* renamed from: t, reason: from getter */
    public final String getUploadUid() {
        return this.uploadUid;
    }

    /* renamed from: u, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsPraise() {
        return this.isPraise;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIsShowRepair() {
        return this.isShowRepair;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isPraise ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.praiseNum);
        parcel.writeInt(this.commentNum);
        parcel.writeString(this.uin);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeString(this.lLoc);
        parcel.writeString(this.sLoc);
        parcel.writeString(this.batchId);
        parcel.writeString(this.videoId);
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isShowRepair ? (byte) 1 : (byte) 0);
        parcel.writeString(this.desc);
        parcel.writeString(this.uploadUid);
        parcel.writeLong(this.uploadTime);
        parcel.writeString(this.praiseKey);
        parcel.writeString(this.uploadUserName);
        parcel.writeString(this.albumCreatorUin);
        parcel.writeByte(this.hasQQCode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasQRCode ? (byte) 1 : (byte) 0);
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void y(String str) {
        this.albumCreatorUin = str;
    }

    public final void z(String str) {
        this.albumId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZAlbumxLayerExtraInfoBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isPraise = parcel.readByte() != 0;
        this.praiseNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.uin = parcel.readString();
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.lLoc = parcel.readString();
        this.sLoc = parcel.readString();
        this.batchId = parcel.readString();
        this.videoId = parcel.readString();
        this.isVideo = parcel.readByte() != 0;
        this.isShowRepair = parcel.readByte() != 0;
        this.desc = parcel.readString();
        this.uploadUid = parcel.readString();
        this.uploadTime = parcel.readLong();
        this.praiseKey = parcel.readString();
        this.uploadUserName = parcel.readString();
        this.albumCreatorUin = parcel.readString();
        this.hasQQCode = parcel.readByte() != 0;
        this.hasQRCode = parcel.readByte() != 0;
    }
}
