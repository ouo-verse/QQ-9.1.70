package com.qzone.reborn.feedpro.layer.router;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0001*B\u00a1\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010)\u001a\u00020\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u00107\u001a\u000201\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010=\u001a\u000201\u0012\b\b\u0002\u0010A\u001a\u00020\u000e\u0012\b\b\u0002\u0010H\u001a\u00020\u0004\u0012\b\b\u0002\u0010J\u001a\u00020\u0004\u0012\b\b\u0002\u0010L\u001a\u000201\u00a2\u0006\u0004\b^\u0010_B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b^\u0010`J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010)\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b8\u0010\u0015R\"\u0010=\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\"\u0010A\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010$\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010J\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010C\u001a\u0004\b\u0017\u0010E\"\u0004\bI\u0010GR\"\u0010L\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00102\u001a\u0004\bK\u00104\"\u0004\b-\u00106R$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR2\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00040Uj\b\u0012\u0004\u0012\u00020\u0004`V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "name", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "sLoc", "f", "g", "v", "lLoc", h.F, "getVideoId", "E", "videoId", "i", "Z", "p", "()Z", "D", "(Z)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "albumId", BdhLogUtil.LogTag.Tag_Conn, "b", "r", AEEditorConstants.ALBUMNAME, "", "J", "c", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "batchId", "u", "desc", UserInfo.SEX_FEMALE, "k", "y", "ownerUin", "G", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isPraise", "H", "I", "l", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "praiseNum", "t", "commentNum", DomainData.DOMAIN_NAME, "shootTime", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "getLbs", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "w", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;)V", "lbs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "L", "Ljava/util/ArrayList;", "j", "()Ljava/util/ArrayList;", "setOpMask", "(Ljava/util/ArrayList;)V", "opMask", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JZIIJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class QzoneFeedProLayerExtraInfoBean implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private String albumName;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private long batchId;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private String desc;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private long ownerUin;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private boolean isPraise;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private int praiseNum;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private int commentNum;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private long shootTime;

    /* renamed from: K, reason: from kotlin metadata */
    private StLBS lbs;

    /* renamed from: L, reason: from kotlin metadata */
    private ArrayList<Integer> opMask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String sLoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String lLoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String videoId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVideo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String albumId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QzoneFeedProLayerExtraInfoBean> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QzoneFeedProLayerExtraInfoBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QzoneFeedProLayerExtraInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneFeedProLayerExtraInfoBean[] newArray(int size) {
            return new QzoneFeedProLayerExtraInfoBean[size];
        }

        Companion() {
        }
    }

    public QzoneFeedProLayerExtraInfoBean() {
        this(null, null, null, null, false, null, null, 0L, null, 0L, false, 0, 0, 0L, 16383, null);
    }

    public final void A(int i3) {
        this.praiseNum = i3;
    }

    public final void B(String str) {
        this.sLoc = str;
    }

    public final void C(long j3) {
        this.shootTime = j3;
    }

    public final void D(boolean z16) {
        this.isVideo = z16;
    }

    public final void E(String str) {
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
    public final long getBatchId() {
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
    public final String getLLoc() {
        return this.lLoc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sLoc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lLoc;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z16 = this.isVideo;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode4 + i3) * 31;
        String str5 = this.albumId;
        int hashCode5 = (i16 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.albumName;
        int hashCode6 = (((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + n.a(this.batchId)) * 31;
        String str7 = this.desc;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + n.a(this.ownerUin)) * 31;
        boolean z17 = this.isPraise;
        return ((((((hashCode7 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.praiseNum) * 31) + this.commentNum) * 31) + n.a(this.shootTime);
    }

    public final ArrayList<Integer> j() {
        return this.opMask;
    }

    /* renamed from: k, reason: from getter */
    public final long getOwnerUin() {
        return this.ownerUin;
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
    public final long getShootTime() {
        return this.shootTime;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsPraise() {
        return this.isPraise;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final void q(String str) {
        this.albumId = str;
    }

    public final void r(String str) {
        this.albumName = str;
    }

    public final void s(long j3) {
        this.batchId = j3;
    }

    public final void t(int i3) {
        this.commentNum = i3;
    }

    public final void u(String str) {
        this.desc = str;
    }

    public final void v(String str) {
        this.lLoc = str;
    }

    public final void w(StLBS stLBS) {
        this.lbs = stLBS;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.sLoc);
        parcel.writeString(this.lLoc);
        parcel.writeString(this.videoId);
        parcel.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeLong(this.batchId);
        parcel.writeString(this.desc);
        parcel.writeLong(this.ownerUin);
        parcel.writeByte(this.isPraise ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.praiseNum);
        parcel.writeInt(this.commentNum);
        parcel.writeLong(this.shootTime);
    }

    public final void x(String str) {
        this.name = str;
    }

    public final void y(long j3) {
        this.ownerUin = j3;
    }

    public final void z(boolean z16) {
        this.isPraise = z16;
    }

    public QzoneFeedProLayerExtraInfoBean(String str, String str2, String str3, String str4, boolean z16, String str5, String str6, long j3, String str7, long j16, boolean z17, int i3, int i16, long j17) {
        this.name = str;
        this.sLoc = str2;
        this.lLoc = str3;
        this.videoId = str4;
        this.isVideo = z16;
        this.albumId = str5;
        this.albumName = str6;
        this.batchId = j3;
        this.desc = str7;
        this.ownerUin = j16;
        this.isPraise = z17;
        this.praiseNum = i3;
        this.commentNum = i16;
        this.shootTime = j17;
        this.opMask = new ArrayList<>();
    }

    public String toString() {
        return "QzoneFeedProLayerExtraInfoBean(name=" + this.name + ", sLoc=" + this.sLoc + ", lLoc=" + this.lLoc + ", videoId=" + this.videoId + ", isVideo=" + this.isVideo + ", albumId=" + this.albumId + ", albumName=" + this.albumName + ", batchId=" + this.batchId + ", desc=" + this.desc + ", ownerUin=" + this.ownerUin + ", isPraise=" + this.isPraise + ", praiseNum=" + this.praiseNum + ", commentNum=" + this.commentNum + ", shootTime=" + this.shootTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QzoneFeedProLayerExtraInfoBean)) {
            return false;
        }
        QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = (QzoneFeedProLayerExtraInfoBean) other;
        return Intrinsics.areEqual(this.name, qzoneFeedProLayerExtraInfoBean.name) && Intrinsics.areEqual(this.sLoc, qzoneFeedProLayerExtraInfoBean.sLoc) && Intrinsics.areEqual(this.lLoc, qzoneFeedProLayerExtraInfoBean.lLoc) && Intrinsics.areEqual(this.videoId, qzoneFeedProLayerExtraInfoBean.videoId) && this.isVideo == qzoneFeedProLayerExtraInfoBean.isVideo && Intrinsics.areEqual(this.albumId, qzoneFeedProLayerExtraInfoBean.albumId) && Intrinsics.areEqual(this.albumName, qzoneFeedProLayerExtraInfoBean.albumName) && this.batchId == qzoneFeedProLayerExtraInfoBean.batchId && Intrinsics.areEqual(this.desc, qzoneFeedProLayerExtraInfoBean.desc) && this.ownerUin == qzoneFeedProLayerExtraInfoBean.ownerUin && this.isPraise == qzoneFeedProLayerExtraInfoBean.isPraise && this.praiseNum == qzoneFeedProLayerExtraInfoBean.praiseNum && this.commentNum == qzoneFeedProLayerExtraInfoBean.commentNum && this.shootTime == qzoneFeedProLayerExtraInfoBean.shootTime;
    }

    public /* synthetic */ QzoneFeedProLayerExtraInfoBean(String str, String str2, String str3, String str4, boolean z16, String str5, String str6, long j3, String str7, long j16, boolean z17, int i3, int i16, long j17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? null : str2, (i17 & 4) != 0 ? null : str3, (i17 & 8) != 0 ? null : str4, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? null : str5, (i17 & 64) != 0 ? null : str6, (i17 & 128) != 0 ? 0L : j3, (i17 & 256) == 0 ? str7 : null, (i17 & 512) != 0 ? 0L : j16, (i17 & 1024) != 0 ? false : z17, (i17 & 2048) != 0 ? 0 : i3, (i17 & 4096) != 0 ? 0 : i16, (i17 & 8192) != 0 ? 0L : j17);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProLayerExtraInfoBean(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readByte() != 0, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readByte() != 0, parcel.readInt(), parcel.readInt(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
