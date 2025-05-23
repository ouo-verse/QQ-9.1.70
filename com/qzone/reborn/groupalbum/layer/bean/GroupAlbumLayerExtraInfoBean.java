package com.qzone.reborn.groupalbum.layer.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 Q2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\bN\u0010OB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bN\u0010PJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R$\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R$\u0010/\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\b.\u0010!R$\u00103\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R$\u00107\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u001d\u001a\u0004\b\u0018\u0010\u001f\"\u0004\b=\u0010!R$\u0010@\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b?\u0010\u001f\"\u0004\b4\u0010!R\"\u0010F\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010B\u001a\u0004\bC\u0010D\"\u0004\b0\u0010ER$\u0010J\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u001d\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010!R$\u0010M\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u001d\u001a\u0004\bL\u0010\u001f\"\u0004\b8\u0010!\u00a8\u0006R"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Z", "r", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "isPraise", "e", "I", "l", "()I", BdhLogUtil.LogTag.Tag_Conn, "(I)V", "praiseNum", "f", "w", "commentNum", "", h.F, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "groupId", "i", "a", "t", "albumId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "u", AEEditorConstants.ALBUMNAME, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "lLoc", "D", "sLoc", "E", "c", "v", "batchId", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "N", "videoId", "G", ReportConstant.COSTREPORT_PREFIX, "M", BaseProfileQZoneComponent.KEY_IS_VIDEO, "H", HippyTKDListViewAdapter.X, "desc", "o", "uploadUid", "", "J", DomainData.DOMAIN_NAME, "()J", "(J)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "K", "k", "B", "praiseKey", "L", "p", "uploadUserName", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumLayerExtraInfoBean implements Parcelable {

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
    private String desc;

    /* renamed from: I, reason: from kotlin metadata */
    private String uploadUid;

    /* renamed from: J, reason: from kotlin metadata */
    private long uploadTime;

    /* renamed from: K, reason: from kotlin metadata */
    private String praiseKey;

    /* renamed from: L, reason: from kotlin metadata */
    private String uploadUserName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isPraise;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int praiseNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int commentNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<GroupAlbumLayerExtraInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupAlbumLayerExtraInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupAlbumLayerExtraInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupAlbumLayerExtraInfoBean[] newArray(int size) {
            return new GroupAlbumLayerExtraInfoBean[size];
        }

        Companion() {
        }
    }

    public GroupAlbumLayerExtraInfoBean() {
    }

    public final void A(boolean z16) {
        this.isPraise = z16;
    }

    public final void B(String str) {
        this.praiseKey = str;
    }

    public final void C(int i3) {
        this.praiseNum = i3;
    }

    public final void D(String str) {
        this.sLoc = str;
    }

    public final void E(long j3) {
        this.uploadTime = j3;
    }

    public final void F(String str) {
        this.uploadUid = str;
    }

    public final void G(String str) {
        this.uploadUserName = str;
    }

    public final void M(boolean z16) {
        this.isVideo = z16;
    }

    public final void N(String str) {
        this.videoId = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getCommentNum() {
        return this.commentNum;
    }

    /* renamed from: f, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: g, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: j, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: k, reason: from getter */
    public final String getPraiseKey() {
        return this.praiseKey;
    }

    /* renamed from: l, reason: from getter */
    public final int getPraiseNum() {
        return this.praiseNum;
    }

    /* renamed from: m, reason: from getter */
    public final String getSLoc() {
        return this.sLoc;
    }

    /* renamed from: n, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    /* renamed from: o, reason: from getter */
    public final String getUploadUid() {
        return this.uploadUid;
    }

    /* renamed from: p, reason: from getter */
    public final String getUploadUserName() {
        return this.uploadUserName;
    }

    /* renamed from: q, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsPraise() {
        return this.isPraise;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void t(String str) {
        this.albumId = str;
    }

    public final void u(String str) {
        this.albumName = str;
    }

    public final void v(String str) {
        this.batchId = str;
    }

    public final void w(int i3) {
        this.commentNum = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.isPraise ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.praiseNum);
        parcel.writeInt(this.commentNum);
        parcel.writeString(this.groupId);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeString(this.lLoc);
        parcel.writeString(this.sLoc);
        parcel.writeString(this.batchId);
        parcel.writeString(this.videoId);
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeString(this.desc);
        parcel.writeString(this.uploadUid);
        parcel.writeLong(this.uploadTime);
        parcel.writeString(this.praiseKey);
        parcel.writeString(this.uploadUserName);
    }

    public final void x(String str) {
        this.desc = str;
    }

    public final void y(String str) {
        this.groupId = str;
    }

    public final void z(String str) {
        this.lLoc = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAlbumLayerExtraInfoBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isPraise = parcel.readByte() != 0;
        this.praiseNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.groupId = parcel.readString();
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.lLoc = parcel.readString();
        this.sLoc = parcel.readString();
        this.batchId = parcel.readString();
        this.videoId = parcel.readString();
        this.isVideo = parcel.readByte() != 0;
        this.desc = parcel.readString();
        this.uploadUid = parcel.readString();
        this.uploadTime = parcel.readLong();
        this.praiseKey = parcel.readString();
        this.uploadUserName = parcel.readString();
    }
}
