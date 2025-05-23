package com.qzone.reborn.albumx.common.convert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ]2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bZ\u0010[B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bZ\u0010\\J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u0012\u0010'\"\u0004\b(\u0010)R(\u00103\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0013\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\"\u0010F\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u000b\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000fR(\u0010K\u001a\b\u0012\u0004\u0012\u00020G0+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010.\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\"\u0010R\u001a\u00020L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\b-\u0010O\"\u0004\bP\u0010QR\"\u0010Y\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "J", "f", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "linkId", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "desc", "k", "w", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", h.F, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "o", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", QCircleAlphaUserReporter.KEY_USER, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "r", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;)V", "lbs", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "j", "()Ljava/util/List;", "u", "(Ljava/util/List;)V", "medias", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "uploadNumber", "D", "I", "g", "()I", "t", "(I)V", "linkType", "E", "l", HippyTKDListViewAdapter.X, QQWinkConstants.TAB_SUBTITLE, UserInfo.SEX_FEMALE, "getOriginUploadNumber", "v", "originUploadNumber", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonEntry;", "G", "c", "setExt", "ext", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "H", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "y", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "timeLineEvent", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "a", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "p", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;)V", "banner", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonBatchInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private long uploadNumber;

    /* renamed from: D, reason: from kotlin metadata */
    private int linkType;

    /* renamed from: E, reason: from kotlin metadata */
    private String subTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private long originUploadNumber;

    /* renamed from: G, reason: from kotlin metadata */
    private List<CommonEntry> ext;

    /* renamed from: H, reason: from kotlin metadata */
    private CommonStTimeLineEvent timeLineEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private CommonBatchInfoBanner banner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long linkId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String showTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonStUser user;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonStLBS lbs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonStMedia> medias;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<CommonBatchInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonBatchInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonBatchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonBatchInfo[] newArray(int size) {
            return new CommonBatchInfo[size];
        }

        Companion() {
        }
    }

    public CommonBatchInfo() {
        this.desc = "";
        this.showTime = "";
        this.user = new CommonStUser();
        this.lbs = new CommonStLBS();
        this.medias = new ArrayList();
        this.subTitle = "";
        this.ext = new ArrayList();
        this.timeLineEvent = new CommonStTimeLineEvent();
        this.banner = new CommonBatchInfoBanner();
    }

    public final void A(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.user = commonStUser;
    }

    /* renamed from: a, reason: from getter */
    public final CommonBatchInfoBanner getBanner() {
        return this.banner;
    }

    /* renamed from: b, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final List<CommonEntry> c() {
        return this.ext;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final CommonStLBS getLbs() {
        return this.lbs;
    }

    /* renamed from: f, reason: from getter */
    public final long getLinkId() {
        return this.linkId;
    }

    /* renamed from: g, reason: from getter */
    public final int getLinkType() {
        return this.linkType;
    }

    public final List<CommonStMedia> j() {
        return this.medias;
    }

    /* renamed from: k, reason: from getter */
    public final String getShowTime() {
        return this.showTime;
    }

    /* renamed from: l, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: m, reason: from getter */
    public final CommonStTimeLineEvent getTimeLineEvent() {
        return this.timeLineEvent;
    }

    /* renamed from: n, reason: from getter */
    public final long getUploadNumber() {
        return this.uploadNumber;
    }

    /* renamed from: o, reason: from getter */
    public final CommonStUser getUser() {
        return this.user;
    }

    public final void p(CommonBatchInfoBanner commonBatchInfoBanner) {
        Intrinsics.checkNotNullParameter(commonBatchInfoBanner, "<set-?>");
        this.banner = commonBatchInfoBanner;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void r(CommonStLBS commonStLBS) {
        Intrinsics.checkNotNullParameter(commonStLBS, "<set-?>");
        this.lbs = commonStLBS;
    }

    public final void s(long j3) {
        this.linkId = j3;
    }

    public final void t(int i3) {
        this.linkType = i3;
    }

    public final void u(List<CommonStMedia> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.medias = list;
    }

    public final void v(long j3) {
        this.originUploadNumber = j3;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.linkId);
        parcel.writeString(this.desc);
        parcel.writeString(this.showTime);
        parcel.writeParcelable(this.user, flags);
        parcel.writeParcelable(this.lbs, flags);
        parcel.writeTypedList(this.medias);
        parcel.writeLong(this.uploadNumber);
        parcel.writeString(this.subTitle);
        parcel.writeLong(this.originUploadNumber);
        parcel.writeTypedList(this.ext);
        parcel.writeParcelable(this.banner, flags);
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void y(CommonStTimeLineEvent commonStTimeLineEvent) {
        Intrinsics.checkNotNullParameter(commonStTimeLineEvent, "<set-?>");
        this.timeLineEvent = commonStTimeLineEvent;
    }

    public final void z(long j3) {
        this.uploadNumber = j3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonBatchInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.linkId = parcel.readLong();
        String readString = parcel.readString();
        this.desc = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.showTime = readString2 == null ? "" : readString2;
        CommonStUser commonStUser = (CommonStUser) parcel.readParcelable(CommonStUser.class.getClassLoader());
        this.user = commonStUser == null ? new CommonStUser() : commonStUser;
        CommonStLBS commonStLBS = (CommonStLBS) parcel.readParcelable(CommonStLBS.class.getClassLoader());
        this.lbs = commonStLBS == null ? new CommonStLBS() : commonStLBS;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(CommonStMedia.INSTANCE);
        this.medias = createTypedArrayList == null ? new ArrayList() : createTypedArrayList;
        this.uploadNumber = parcel.readLong();
        String readString3 = parcel.readString();
        this.subTitle = readString3 != null ? readString3 : "";
        this.originUploadNumber = parcel.readLong();
        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(CommonEntry.INSTANCE);
        this.ext = createTypedArrayList2 == null ? new ArrayList() : createTypedArrayList2;
        CommonBatchInfoBanner commonBatchInfoBanner = (CommonBatchInfoBanner) parcel.readParcelable(CommonBatchInfoBanner.class.getClassLoader());
        this.banner = commonBatchInfoBanner == null ? new CommonBatchInfoBanner() : commonBatchInfoBanner;
    }
}
