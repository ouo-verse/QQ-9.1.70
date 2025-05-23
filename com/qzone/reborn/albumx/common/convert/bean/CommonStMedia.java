package com.qzone.reborn.albumx.common.convert.bean;

import aa.e;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import k9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 h2\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\be\u0010fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\be\u0010gJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010\u0015R\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010P\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010'\u001a\u0004\bN\u0010)\"\u0004\bO\u0010+R\"\u0010S\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u00102\u001a\u0004\bR\u00104\"\u0004\b<\u00106R\"\u0010Y\u001a\u00020T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010U\u001a\u0004\b\u001f\u0010V\"\u0004\bW\u0010XR\"\u0010\\\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00102\u001a\u0004\bZ\u00104\"\u0004\b[\u00106R2\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u00040]j\b\u0012\u0004\u0012\u00020\u0004`^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\b8\u0010c\u00a8\u0006i"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "u", "l", "t", "k", "d", "I", "getType", "()I", "E", "(I)V", "type", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "e", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "y", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;)V", "image", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "V", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;)V", "video", h.F, "Ljava/lang/String;", "c", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "desc", "i", "p", UserInfo.SEX_FEMALE, JobDbManager.TBL_UPLOAD, "", "J", "a", "()J", "v", "(J)V", "batchId", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "M", PhotoCategorySinglePicInfo.UPLOAD_TIME, "D", "getUploadOrder", "G", "uploadOrder", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaLike;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaLike;", "g", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaLike;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaLike;)V", "like", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaComment;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaComment;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaComment;", "w", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMediaComment;)V", "comment", "r", "N", "uploadUserName", "H", "o", "shootTime", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;)V", "lbs", "j", "B", "linkId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "K", "Ljava/util/ArrayList;", DomainData.DOMAIN_NAME, "()Ljava/util/ArrayList;", "(Ljava/util/ArrayList;)V", "opMask", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStMedia implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long uploadTime;

    /* renamed from: D, reason: from kotlin metadata */
    private int uploadOrder;

    /* renamed from: E, reason: from kotlin metadata */
    private CommonStMediaLike like;

    /* renamed from: F, reason: from kotlin metadata */
    private CommonStMediaComment comment;

    /* renamed from: G, reason: from kotlin metadata */
    private String uploadUserName;

    /* renamed from: H, reason: from kotlin metadata */
    private long shootTime;

    /* renamed from: I, reason: from kotlin metadata */
    private CommonStLBS lbs;

    /* renamed from: J, reason: from kotlin metadata */
    private long linkId;

    /* renamed from: K, reason: from kotlin metadata */
    private ArrayList<Integer> opMask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonStImage image;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonStVideo video;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String upload;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long batchId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonStMedia$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonStMedia> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonStMedia createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonStMedia(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonStMedia[] newArray(int size) {
            return new CommonStMedia[size];
        }

        Companion() {
        }
    }

    public CommonStMedia() {
        this.image = new CommonStImage();
        this.video = new CommonStVideo();
        this.desc = "";
        this.upload = "";
        this.like = new CommonStMediaLike();
        this.comment = new CommonStMediaComment();
        this.uploadUserName = "";
        this.lbs = new CommonStLBS();
        this.opMask = new ArrayList<>();
    }

    public final void A(CommonStMediaLike commonStMediaLike) {
        Intrinsics.checkNotNullParameter(commonStMediaLike, "<set-?>");
        this.like = commonStMediaLike;
    }

    public final void B(long j3) {
        this.linkId = j3;
    }

    public final void C(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.opMask = arrayList;
    }

    public final void D(long j3) {
        this.shootTime = j3;
    }

    public final void E(int i3) {
        this.type = i3;
    }

    public final void F(String str) {
        this.upload = str;
    }

    public final void G(int i3) {
        this.uploadOrder = i3;
    }

    public final void M(long j3) {
        this.uploadTime = j3;
    }

    public final void N(String str) {
        this.uploadUserName = str;
    }

    public final void V(CommonStVideo commonStVideo) {
        Intrinsics.checkNotNullParameter(commonStVideo, "<set-?>");
        this.video = commonStVideo;
    }

    /* renamed from: a, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    /* renamed from: b, reason: from getter */
    public final CommonStMediaComment getComment() {
        return this.comment;
    }

    /* renamed from: c, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final CommonStImage getImage() {
        return this.image;
    }

    /* renamed from: f, reason: from getter */
    public final CommonStLBS getLbs() {
        return this.lbs;
    }

    /* renamed from: g, reason: from getter */
    public final CommonStMediaLike getLike() {
        return this.like;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: j, reason: from getter */
    public final long getLinkId() {
        return this.linkId;
    }

    public final String k() {
        if (this.type == 1) {
            return this.video.getCover().getLloc();
        }
        return this.image.getLloc();
    }

    public final String l() {
        String url;
        if (a.j(this)) {
            return this.video.getUrl();
        }
        CommonStPicUrl d16 = e.f25753a.d(this.image.e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
        return (d16 == null || (url = d16.getUrl()) == null) ? "" : url;
    }

    public final String m() {
        if (a.j(this)) {
            return this.video.getCover().getLloc();
        }
        return this.image.getLloc();
    }

    public final ArrayList<Integer> n() {
        return this.opMask;
    }

    /* renamed from: o, reason: from getter */
    public final long getShootTime() {
        return this.shootTime;
    }

    /* renamed from: p, reason: from getter */
    public final String getUpload() {
        return this.upload;
    }

    /* renamed from: q, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    /* renamed from: r, reason: from getter */
    public final String getUploadUserName() {
        return this.uploadUserName;
    }

    /* renamed from: s, reason: from getter */
    public final CommonStVideo getVideo() {
        return this.video;
    }

    public final String t() {
        CommonStPicUrl d16;
        String url;
        return (!a.j(this) || (d16 = e.f25753a.d(this.video.getCover().e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN)) == null || (url = d16.getUrl()) == null) ? "" : url;
    }

    public final boolean u() {
        return a.j(this);
    }

    public final void v(long j3) {
        this.batchId = j3;
    }

    public final void w(CommonStMediaComment commonStMediaComment) {
        Intrinsics.checkNotNullParameter(commonStMediaComment, "<set-?>");
        this.comment = commonStMediaComment;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.image, flags);
        parcel.writeParcelable(this.video, flags);
        parcel.writeString(this.desc);
        parcel.writeString(this.upload);
        parcel.writeLong(this.batchId);
        parcel.writeLong(this.uploadTime);
        parcel.writeInt(this.uploadOrder);
        parcel.writeParcelable(this.like, flags);
        parcel.writeParcelable(this.comment, flags);
        parcel.writeString(this.uploadUserName);
        parcel.writeLong(this.shootTime);
    }

    public final void x(String str) {
        this.desc = str;
    }

    public final void y(CommonStImage commonStImage) {
        Intrinsics.checkNotNullParameter(commonStImage, "<set-?>");
        this.image = commonStImage;
    }

    public final void z(CommonStLBS commonStLBS) {
        Intrinsics.checkNotNullParameter(commonStLBS, "<set-?>");
        this.lbs = commonStLBS;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonStMedia(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type = parcel.readInt();
        CommonStImage commonStImage = (CommonStImage) parcel.readParcelable(CommonStImage.class.getClassLoader());
        this.image = commonStImage == null ? new CommonStImage() : commonStImage;
        CommonStVideo commonStVideo = (CommonStVideo) parcel.readParcelable(CommonStVideo.class.getClassLoader());
        this.video = commonStVideo == null ? new CommonStVideo() : commonStVideo;
        this.desc = parcel.readString();
        this.upload = parcel.readString();
        this.batchId = parcel.readLong();
        this.uploadTime = parcel.readLong();
        this.uploadOrder = parcel.readInt();
        CommonStMediaLike commonStMediaLike = (CommonStMediaLike) parcel.readParcelable(CommonStMediaLike.class.getClassLoader());
        this.like = commonStMediaLike == null ? new CommonStMediaLike() : commonStMediaLike;
        CommonStMediaComment commonStMediaComment = (CommonStMediaComment) parcel.readParcelable(CommonStMediaComment.class.getClassLoader());
        this.comment = commonStMediaComment == null ? new CommonStMediaComment() : commonStMediaComment;
        this.uploadUserName = parcel.readString();
        this.shootTime = parcel.readLong();
    }
}
