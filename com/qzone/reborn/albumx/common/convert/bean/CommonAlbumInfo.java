package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00ae\u00012\u00020\u0001:\u0001\bB\t\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ad\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0000J\b\u0010\t\u001a\u00020\u0004H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010-\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\"\u00101\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010D\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010 \u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010R\u001a\u00020L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010W\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010T\u001a\u0004\b\u0012\u0010U\"\u0004\bT\u0010VR\"\u0010[\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010T\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010VR\"\u0010^\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b]\u0010\u0010R\"\u0010`\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bA\u0010U\"\u0004\b_\u0010VR\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010l\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010F\u001a\u0004\bj\u0010H\"\u0004\bk\u0010JR\"\u0010t\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010|\u001a\u00020u8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R#\u0010\u0080\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010F\u001a\u0004\b~\u0010H\"\u0004\b\u007f\u0010JR)\u0010\u0087\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0005\b*\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R)\u0010\u008e\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0005\b:\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R$\u0010\u0090\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u000f\u0010\f\u001a\u0004\b&\u0010\u000e\"\u0005\b\u008f\u0001\u0010\u0010R*\u0010\u0098\u0001\u001a\u00030\u0091\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R)\u0010\u009f\u0001\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0005\bb\u0010\u009e\u0001R*\u0010\u00a7\u0001\u001a\u00030\u00a0\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001R%\u0010\u00aa\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bT\u0010F\u001a\u0005\b\u00a8\u0001\u0010H\"\u0005\b\u00a9\u0001\u0010J\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "a", "describeContents", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "V", "(Ljava/lang/String;)V", "albumId", "e", "v", "o0", "owner", "f", "t", "m0", "name", h.F, DomainData.DOMAIN_NAME, "g0", "desc", "", "i", "J", "k", "()J", "d0", "(J)V", WadlProxyConsts.CREATE_TIME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "l0", "modifyTime", BdhLogUtil.LogTag.Tag_Conn, "p", "i0", "lastUploadTime", "D", "E", "y0", "uploadNumber", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "g", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "b0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;)V", "cover", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "l", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "e0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "creator", "G", "B", "w0", "topFlag", "H", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "u0", "(I)V", "status", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "w", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "p0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;)V", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "Z", "()Z", "(Z)V", "allowShare", "K", "M", "v0", "isSubscribe", "L", "a0", MimeHelper.IMAGE_SUBTYPE_BITMAP, "s0", "isShareAlbum", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "N", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "y", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", "r0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;)V", "shareAlbum", "P", HippyTKDListViewAdapter.X, "q0", "qzAlbumType", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonFamilyAlbumMeta;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonFamilyAlbumMeta;", "o", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonFamilyAlbumMeta;", "h0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonFamilyAlbumMeta;)V", "familyAlbum", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonLoverAlbumMeta;", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonLoverAlbumMeta;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonLoverAlbumMeta;", "j0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonLoverAlbumMeta;)V", "loverAlbum", ExifInterface.LATITUDE_SOUTH, "j", "c0", "coverType", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonTravelAlbumMeta;", "T", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonTravelAlbumMeta;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonTravelAlbumMeta;", "x0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonTravelAlbumMeta;)V", "travelAlbum", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "U", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "z0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;)V", "visitorInfo", "f0", "defaultDesc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "W", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "u", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "n0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;)V", "opInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonActiveAlbumInfo;", "X", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonActiveAlbumInfo;", "b", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonActiveAlbumInfo;", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonActiveAlbumInfo;)V", "activeAlbumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryInfo;", "Y", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryInfo;", "r", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryInfo;", "k0", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryInfo;)V", "memoryInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t0", "sortType", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long lastUploadTime;

    /* renamed from: D, reason: from kotlin metadata */
    private long uploadNumber;

    /* renamed from: E, reason: from kotlin metadata */
    private CommonStMedia cover;

    /* renamed from: F, reason: from kotlin metadata */
    private CommonStUser creator;

    /* renamed from: G, reason: from kotlin metadata */
    private long topFlag;

    /* renamed from: H, reason: from kotlin metadata */
    private int status;

    /* renamed from: I, reason: from kotlin metadata */
    private CommonAlbumAccessPermission permission;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean allowShare;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isSubscribe;

    /* renamed from: L, reason: from kotlin metadata */
    private String bitmap;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isShareAlbum;

    /* renamed from: N, reason: from kotlin metadata */
    private CommonShareAlbumMeta shareAlbum;

    /* renamed from: P, reason: from kotlin metadata */
    private int qzAlbumType;

    /* renamed from: Q, reason: from kotlin metadata */
    private CommonFamilyAlbumMeta familyAlbum;

    /* renamed from: R, reason: from kotlin metadata */
    private CommonLoverAlbumMeta loverAlbum;

    /* renamed from: S, reason: from kotlin metadata */
    private int coverType;

    /* renamed from: T, reason: from kotlin metadata */
    private CommonTravelAlbumMeta travelAlbum;

    /* renamed from: U, reason: from kotlin metadata */
    private CommonStFeedCellVisitor visitorInfo;

    /* renamed from: V, reason: from kotlin metadata */
    private String defaultDesc;

    /* renamed from: W, reason: from kotlin metadata */
    private CommonAlbumOpInfo opInfo;

    /* renamed from: X, reason: from kotlin metadata */
    private CommonActiveAlbumInfo activeAlbumInfo;

    /* renamed from: Y, reason: from kotlin metadata */
    private CommonMemoryInfo memoryInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    private int sortType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String name;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long createTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long modifyTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonAlbumInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonAlbumInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonAlbumInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonAlbumInfo[] newArray(int size) {
            return new CommonAlbumInfo[size];
        }

        Companion() {
        }
    }

    public CommonAlbumInfo() {
        this.albumId = "";
        this.owner = "";
        this.name = "";
        this.desc = "";
        this.cover = new CommonStMedia();
        this.creator = new CommonStUser();
        this.permission = new CommonAlbumAccessPermission();
        this.bitmap = "";
        this.shareAlbum = new CommonShareAlbumMeta();
        this.familyAlbum = new CommonFamilyAlbumMeta();
        this.loverAlbum = new CommonLoverAlbumMeta();
        this.travelAlbum = new CommonTravelAlbumMeta();
        this.visitorInfo = new CommonStFeedCellVisitor();
        this.defaultDesc = "";
        this.opInfo = new CommonAlbumOpInfo();
        this.activeAlbumInfo = new CommonActiveAlbumInfo();
        this.memoryInfo = new CommonMemoryInfo();
    }

    /* renamed from: A, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: B, reason: from getter */
    public final long getTopFlag() {
        return this.topFlag;
    }

    /* renamed from: C, reason: from getter */
    public final CommonTravelAlbumMeta getTravelAlbum() {
        return this.travelAlbum;
    }

    /* renamed from: E, reason: from getter */
    public final long getUploadNumber() {
        return this.uploadNumber;
    }

    /* renamed from: F, reason: from getter */
    public final CommonStFeedCellVisitor getVisitorInfo() {
        return this.visitorInfo;
    }

    /* renamed from: G, reason: from getter */
    public final boolean getIsShareAlbum() {
        return this.isShareAlbum;
    }

    /* renamed from: M, reason: from getter */
    public final boolean getIsSubscribe() {
        return this.isSubscribe;
    }

    public final void N(CommonActiveAlbumInfo commonActiveAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonActiveAlbumInfo, "<set-?>");
        this.activeAlbumInfo = commonActiveAlbumInfo;
    }

    public final void V(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void Z(boolean z16) {
        this.allowShare = z16;
    }

    public final CommonAlbumInfo a() {
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.albumId = this.albumId;
        commonAlbumInfo.owner = this.owner;
        commonAlbumInfo.name = this.name;
        commonAlbumInfo.desc = this.desc;
        commonAlbumInfo.createTime = this.createTime;
        commonAlbumInfo.modifyTime = this.modifyTime;
        commonAlbumInfo.lastUploadTime = this.lastUploadTime;
        commonAlbumInfo.uploadNumber = this.uploadNumber;
        commonAlbumInfo.cover = this.cover;
        commonAlbumInfo.creator = this.creator;
        commonAlbumInfo.topFlag = this.topFlag;
        commonAlbumInfo.status = this.status;
        commonAlbumInfo.permission = this.permission;
        commonAlbumInfo.allowShare = this.allowShare;
        commonAlbumInfo.isSubscribe = this.isSubscribe;
        commonAlbumInfo.bitmap = this.bitmap;
        commonAlbumInfo.isShareAlbum = this.isShareAlbum;
        commonAlbumInfo.shareAlbum = this.shareAlbum;
        commonAlbumInfo.qzAlbumType = this.qzAlbumType;
        commonAlbumInfo.familyAlbum = this.familyAlbum;
        commonAlbumInfo.loverAlbum = this.loverAlbum;
        commonAlbumInfo.coverType = this.coverType;
        commonAlbumInfo.travelAlbum = this.travelAlbum;
        commonAlbumInfo.visitorInfo = this.visitorInfo;
        commonAlbumInfo.defaultDesc = this.defaultDesc;
        commonAlbumInfo.opInfo = this.opInfo;
        commonAlbumInfo.activeAlbumInfo = this.activeAlbumInfo;
        commonAlbumInfo.memoryInfo = this.memoryInfo;
        commonAlbumInfo.sortType = this.sortType;
        return commonAlbumInfo;
    }

    public final void a0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bitmap = str;
    }

    /* renamed from: b, reason: from getter */
    public final CommonActiveAlbumInfo getActiveAlbumInfo() {
        return this.activeAlbumInfo;
    }

    public final void b0(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<set-?>");
        this.cover = commonStMedia;
    }

    /* renamed from: c, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final void c0(int i3) {
        this.coverType = i3;
    }

    public final void d0(long j3) {
        this.createTime = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getAllowShare() {
        return this.allowShare;
    }

    public final void e0(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.creator = commonStUser;
    }

    /* renamed from: f, reason: from getter */
    public final String getBitmap() {
        return this.bitmap;
    }

    public final void f0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultDesc = str;
    }

    /* renamed from: g, reason: from getter */
    public final CommonStMedia getCover() {
        return this.cover;
    }

    public final void g0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void h0(CommonFamilyAlbumMeta commonFamilyAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonFamilyAlbumMeta, "<set-?>");
        this.familyAlbum = commonFamilyAlbumMeta;
    }

    public final void i0(long j3) {
        this.lastUploadTime = j3;
    }

    /* renamed from: j, reason: from getter */
    public final int getCoverType() {
        return this.coverType;
    }

    public final void j0(CommonLoverAlbumMeta commonLoverAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonLoverAlbumMeta, "<set-?>");
        this.loverAlbum = commonLoverAlbumMeta;
    }

    /* renamed from: k, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    public final void k0(CommonMemoryInfo commonMemoryInfo) {
        Intrinsics.checkNotNullParameter(commonMemoryInfo, "<set-?>");
        this.memoryInfo = commonMemoryInfo;
    }

    /* renamed from: l, reason: from getter */
    public final CommonStUser getCreator() {
        return this.creator;
    }

    public final void l0(long j3) {
        this.modifyTime = j3;
    }

    /* renamed from: m, reason: from getter */
    public final String getDefaultDesc() {
        return this.defaultDesc;
    }

    public final void m0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    /* renamed from: n, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final void n0(CommonAlbumOpInfo commonAlbumOpInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumOpInfo, "<set-?>");
        this.opInfo = commonAlbumOpInfo;
    }

    /* renamed from: o, reason: from getter */
    public final CommonFamilyAlbumMeta getFamilyAlbum() {
        return this.familyAlbum;
    }

    public final void o0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.owner = str;
    }

    /* renamed from: p, reason: from getter */
    public final long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public final void p0(CommonAlbumAccessPermission commonAlbumAccessPermission) {
        Intrinsics.checkNotNullParameter(commonAlbumAccessPermission, "<set-?>");
        this.permission = commonAlbumAccessPermission;
    }

    /* renamed from: q, reason: from getter */
    public final CommonLoverAlbumMeta getLoverAlbum() {
        return this.loverAlbum;
    }

    public final void q0(int i3) {
        this.qzAlbumType = i3;
    }

    /* renamed from: r, reason: from getter */
    public final CommonMemoryInfo getMemoryInfo() {
        return this.memoryInfo;
    }

    public final void r0(CommonShareAlbumMeta commonShareAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonShareAlbumMeta, "<set-?>");
        this.shareAlbum = commonShareAlbumMeta;
    }

    /* renamed from: s, reason: from getter */
    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final void s0(boolean z16) {
        this.isShareAlbum = z16;
    }

    /* renamed from: t, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final void t0(int i3) {
        this.sortType = i3;
    }

    /* renamed from: u, reason: from getter */
    public final CommonAlbumOpInfo getOpInfo() {
        return this.opInfo;
    }

    public final void u0(int i3) {
        this.status = i3;
    }

    /* renamed from: v, reason: from getter */
    public final String getOwner() {
        return this.owner;
    }

    public final void v0(boolean z16) {
        this.isSubscribe = z16;
    }

    /* renamed from: w, reason: from getter */
    public final CommonAlbumAccessPermission getPermission() {
        return this.permission;
    }

    public final void w0(long j3) {
        this.topFlag = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.albumId);
        parcel.writeString(this.owner);
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.modifyTime);
        parcel.writeLong(this.lastUploadTime);
        parcel.writeLong(this.uploadNumber);
        parcel.writeParcelable(this.cover, flags);
        parcel.writeParcelable(this.creator, flags);
        parcel.writeLong(this.topFlag);
        parcel.writeInt(this.status);
        parcel.writeParcelable(this.permission, flags);
        parcel.writeInt(this.allowShare ? 1 : 0);
        parcel.writeInt(this.isSubscribe ? 1 : 0);
        parcel.writeString(this.bitmap);
        parcel.writeInt(this.isShareAlbum ? 1 : 0);
        parcel.writeParcelable(this.shareAlbum, flags);
        parcel.writeInt(this.qzAlbumType);
        parcel.writeParcelable(this.familyAlbum, flags);
        parcel.writeParcelable(this.loverAlbum, flags);
        parcel.writeInt(this.coverType);
        parcel.writeParcelable(this.travelAlbum, flags);
        parcel.writeParcelable(this.visitorInfo, flags);
        parcel.writeString(this.defaultDesc);
        parcel.writeParcelable(this.opInfo, flags);
        parcel.writeParcelable(this.activeAlbumInfo, flags);
        parcel.writeParcelable(this.memoryInfo, flags);
        parcel.writeInt(this.sortType);
    }

    /* renamed from: x, reason: from getter */
    public final int getQzAlbumType() {
        return this.qzAlbumType;
    }

    public final void x0(CommonTravelAlbumMeta commonTravelAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonTravelAlbumMeta, "<set-?>");
        this.travelAlbum = commonTravelAlbumMeta;
    }

    /* renamed from: y, reason: from getter */
    public final CommonShareAlbumMeta getShareAlbum() {
        return this.shareAlbum;
    }

    public final void y0(long j3) {
        this.uploadNumber = j3;
    }

    /* renamed from: z, reason: from getter */
    public final int getSortType() {
        return this.sortType;
    }

    public final void z0(CommonStFeedCellVisitor commonStFeedCellVisitor) {
        Intrinsics.checkNotNullParameter(commonStFeedCellVisitor, "<set-?>");
        this.visitorInfo = commonStFeedCellVisitor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonAlbumInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.albumId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.owner = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.name = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.desc = readString4 == null ? "" : readString4;
        this.createTime = parcel.readLong();
        this.modifyTime = parcel.readLong();
        this.lastUploadTime = parcel.readLong();
        this.uploadNumber = parcel.readLong();
        CommonStMedia commonStMedia = (CommonStMedia) parcel.readParcelable(CommonStMedia.class.getClassLoader());
        this.cover = commonStMedia == null ? new CommonStMedia() : commonStMedia;
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.creator = commonStUser == null ? new CommonStUser() : commonStUser;
        this.topFlag = parcel.readLong();
        this.status = parcel.readInt();
        CommonAlbumAccessPermission commonAlbumAccessPermission = (CommonAlbumAccessPermission) parcel.readParcelable(CommonAlbumAccessPermission.class.getClassLoader());
        this.permission = commonAlbumAccessPermission == null ? new CommonAlbumAccessPermission() : commonAlbumAccessPermission;
        this.allowShare = parcel.readInt() == 1;
        this.isSubscribe = parcel.readInt() == 1;
        String readString5 = parcel.readString();
        this.bitmap = readString5 == null ? "" : readString5;
        this.isShareAlbum = parcel.readInt() == 1;
        CommonShareAlbumMeta commonShareAlbumMeta = (CommonShareAlbumMeta) parcel.readParcelable(CommonShareAlbumMeta.class.getClassLoader());
        this.shareAlbum = commonShareAlbumMeta == null ? new CommonShareAlbumMeta() : commonShareAlbumMeta;
        this.qzAlbumType = parcel.readInt();
        CommonFamilyAlbumMeta commonFamilyAlbumMeta = (CommonFamilyAlbumMeta) parcel.readParcelable(CommonFamilyAlbumMeta.class.getClassLoader());
        this.familyAlbum = commonFamilyAlbumMeta == null ? new CommonFamilyAlbumMeta() : commonFamilyAlbumMeta;
        CommonLoverAlbumMeta commonLoverAlbumMeta = (CommonLoverAlbumMeta) parcel.readParcelable(CommonLoverAlbumMeta.class.getClassLoader());
        this.loverAlbum = commonLoverAlbumMeta == null ? new CommonLoverAlbumMeta() : commonLoverAlbumMeta;
        this.coverType = parcel.readInt();
        CommonTravelAlbumMeta commonTravelAlbumMeta = (CommonTravelAlbumMeta) parcel.readParcelable(CommonTravelAlbumMeta.class.getClassLoader());
        this.travelAlbum = commonTravelAlbumMeta == null ? new CommonTravelAlbumMeta() : commonTravelAlbumMeta;
        CommonStFeedCellVisitor commonStFeedCellVisitor = (CommonStFeedCellVisitor) parcel.readParcelable(CommonStFeedCellVisitor.class.getClassLoader());
        this.visitorInfo = commonStFeedCellVisitor == null ? new CommonStFeedCellVisitor() : commonStFeedCellVisitor;
        String readString6 = parcel.readString();
        this.defaultDesc = readString6 != null ? readString6 : "";
        CommonAlbumOpInfo commonAlbumOpInfo = (CommonAlbumOpInfo) parcel.readParcelable(CommonAlbumOpInfo.class.getClassLoader());
        this.opInfo = commonAlbumOpInfo == null ? new CommonAlbumOpInfo() : commonAlbumOpInfo;
        CommonActiveAlbumInfo commonActiveAlbumInfo = (CommonActiveAlbumInfo) parcel.readParcelable(CommonActiveAlbumInfo.class.getClassLoader());
        this.activeAlbumInfo = commonActiveAlbumInfo == null ? new CommonActiveAlbumInfo() : commonActiveAlbumInfo;
        CommonMemoryInfo commonMemoryInfo = (CommonMemoryInfo) parcel.readParcelable(CommonMemoryInfo.class.getClassLoader());
        this.memoryInfo = commonMemoryInfo == null ? new CommonMemoryInfo() : commonMemoryInfo;
        this.sortType = parcel.readInt();
    }
}
