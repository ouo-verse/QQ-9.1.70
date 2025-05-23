package com.qzone.reborn.intimate.layer.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001e\u0018\u0000 D2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\bA\u0010BB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010CJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00101\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b0\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "lLoc", "e", "g", "r", "sLoc", "k", "w", "videoId", "", h.F, "Z", "l", "()Z", "v", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "i", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "albumId", "b", DomainData.DOMAIN_NAME, AEEditorConstants.ALBUMNAME, "", BdhLogUtil.LogTag.Tag_Conn, "J", "c", "()J", "o", "(J)V", "batchId", "D", "p", "desc", "E", "j", "u", "uploadUid", UserInfo.SEX_FEMALE, "getSpaceId", ReportConstant.COSTREPORT_PREFIX, "spaceId", "G", "I", "getSpaceType", "()I", "t", "(I)V", "spaceType", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateLayerExtraInfoBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long batchId;

    /* renamed from: D, reason: from kotlin metadata */
    private String desc;

    /* renamed from: E, reason: from kotlin metadata */
    private String uploadUid;

    /* renamed from: F, reason: from kotlin metadata */
    private String spaceId;

    /* renamed from: G, reason: from kotlin metadata */
    private int spaceType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String lLoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String sLoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String videoId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isVideo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZIntimateLayerExtraInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZIntimateLayerExtraInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZIntimateLayerExtraInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZIntimateLayerExtraInfoBean[] newArray(int size) {
            return new QZIntimateLayerExtraInfoBean[size];
        }

        Companion() {
        }
    }

    public QZIntimateLayerExtraInfoBean() {
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
    public final long getBatchId() {
        return this.batchId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: f, reason: from getter */
    public final String getLLoc() {
        return this.lLoc;
    }

    /* renamed from: g, reason: from getter */
    public final String getSLoc() {
        return this.sLoc;
    }

    /* renamed from: j, reason: from getter */
    public final String getUploadUid() {
        return this.uploadUid;
    }

    /* renamed from: k, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void m(String str) {
        this.albumId = str;
    }

    public final void n(String str) {
        this.albumName = str;
    }

    public final void o(long j3) {
        this.batchId = j3;
    }

    public final void p(String str) {
        this.desc = str;
    }

    public final void q(String str) {
        this.lLoc = str;
    }

    public final void r(String str) {
        this.sLoc = str;
    }

    public final void s(String str) {
        this.spaceId = str;
    }

    public final void t(int i3) {
        this.spaceType = i3;
    }

    public final void u(String str) {
        this.uploadUid = str;
    }

    public final void v(boolean z16) {
        this.isVideo = z16;
    }

    public final void w(String str) {
        this.videoId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.lLoc);
        parcel.writeString(this.sLoc);
        parcel.writeString(this.videoId);
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeLong(this.batchId);
        parcel.writeString(this.desc);
        parcel.writeString(this.uploadUid);
        parcel.writeString(this.spaceId);
        parcel.writeInt(this.spaceType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZIntimateLayerExtraInfoBean(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.lLoc = parcel.readString();
        this.sLoc = parcel.readString();
        this.videoId = parcel.readString();
        this.isVideo = parcel.readByte() != 0;
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.batchId = parcel.readLong();
        this.desc = parcel.readString();
        this.uploadUid = parcel.readString();
        this.spaceId = parcel.readString();
        this.spaceType = parcel.readInt();
    }
}
