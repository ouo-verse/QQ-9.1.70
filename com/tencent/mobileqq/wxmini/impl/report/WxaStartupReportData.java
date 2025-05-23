package com.tencent.mobileqq.wxmini.impl.report;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b5\u0018\u0000 X2\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\bU\u0010VB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bU\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u001a\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u001a\u001a\u0004\b>\u0010\u001c\"\u0004\b9\u0010\u001eR\"\u0010B\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001a\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\bC\u0010\u0010R\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\f\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R\"\u0010L\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u001a\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010\u001eR\"\u0010N\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\bM\u0010\u001c\"\u0004\b/\u0010\u001eR\"\u0010P\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\bO\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\f\u001a\u0004\bR\u0010\u000e\"\u0004\bS\u0010\u0010\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "N", "(Ljava/lang/String;)V", "startupId", "e", "f", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AdMetricTag.EVENT_NAME, "l", "E", QQCustomArkDialogUtil.META_DATA, h.F, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", UserInfo.SEX_FEMALE, "(I)V", "metaType", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "V", "startupScene", "", "J", "g", "()J", "B", "(J)V", "eventTime", BdhLogUtil.LogTag.Tag_Conn, "v", "d0", "wxappInstallFlag", "D", ReportConstant.COSTREPORT_PREFIX, "a0", "versionType", "r", "Z", "tidUserId", "o", "M", "sceneNote", "G", "a", "w", "authType", "H", DomainData.DOMAIN_NAME, "relativeResult", "c", "y", "errCode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "errMsg", "K", "t", "b0", "wxAppId", "L", "b", HippyTKDListViewAdapter.X, "coldLaunch", "k", "hitPreload", "j", "hitPkgCache", "P", "u", "c0", "wxVersion", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxaStartupReportData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int wxappInstallFlag;

    /* renamed from: D, reason: from kotlin metadata */
    private int versionType;

    /* renamed from: E, reason: from kotlin metadata */
    private String tidUserId;

    /* renamed from: F, reason: from kotlin metadata */
    private String sceneNote;

    /* renamed from: G, reason: from kotlin metadata */
    private int authType;

    /* renamed from: H, reason: from kotlin metadata */
    private int relativeResult;

    /* renamed from: I, reason: from kotlin metadata */
    private int errCode;

    /* renamed from: J, reason: from kotlin metadata */
    private String errMsg;

    /* renamed from: K, reason: from kotlin metadata */
    private String wxAppId;

    /* renamed from: L, reason: from kotlin metadata */
    private int coldLaunch;

    /* renamed from: M, reason: from kotlin metadata */
    private int hitPreload;

    /* renamed from: N, reason: from kotlin metadata */
    private int hitPkgCache;

    /* renamed from: P, reason: from kotlin metadata */
    private String wxVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String startupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String eventName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String metaData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int metaType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int startupScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long eventTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "Landroid/os/Parcel;", "parcel", "b", "", "size", "", "c", "(I)[Lcom/tencent/mobileqq/wxmini/impl/report/WxaStartupReportData;", "data", "a", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.impl.report.WxaStartupReportData$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion implements Parcelable.Creator<WxaStartupReportData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WxaStartupReportData a(WxaStartupReportData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            WxaStartupReportData wxaStartupReportData = new WxaStartupReportData();
            wxaStartupReportData.N(data.getStartupId());
            wxaStartupReportData.A(data.getEventName());
            wxaStartupReportData.E(data.getMetaData());
            wxaStartupReportData.F(data.getMetaType());
            wxaStartupReportData.V(data.getStartupScene());
            wxaStartupReportData.B(data.getEventTime());
            wxaStartupReportData.a0(data.getVersionType());
            wxaStartupReportData.Z(data.getTidUserId());
            wxaStartupReportData.d0(data.getWxappInstallFlag());
            wxaStartupReportData.M(data.getSceneNote());
            return wxaStartupReportData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WxaStartupReportData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WxaStartupReportData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public WxaStartupReportData[] newArray(int size) {
            return new WxaStartupReportData[size];
        }

        Companion() {
        }
    }

    public WxaStartupReportData() {
        this.startupId = "";
        this.eventName = "";
        this.metaData = "";
        this.tidUserId = "";
        this.sceneNote = "";
        this.errMsg = "";
        this.wxAppId = "";
        this.wxVersion = "";
    }

    public final void A(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    public final void B(long j3) {
        this.eventTime = j3;
    }

    public final void C(int i3) {
        this.hitPkgCache = i3;
    }

    public final void D(int i3) {
        this.hitPreload = i3;
    }

    public final void E(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.metaData = str;
    }

    public final void F(int i3) {
        this.metaType = i3;
    }

    public final void G(int i3) {
        this.relativeResult = i3;
    }

    public final void M(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sceneNote = str;
    }

    public final void N(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startupId = str;
    }

    public final void V(int i3) {
        this.startupScene = i3;
    }

    public final void Z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tidUserId = str;
    }

    /* renamed from: a, reason: from getter */
    public final int getAuthType() {
        return this.authType;
    }

    public final void a0(int i3) {
        this.versionType = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getColdLaunch() {
        return this.coldLaunch;
    }

    public final void b0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wxAppId = str;
    }

    /* renamed from: c, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    public final void c0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wxVersion = str;
    }

    public final void d0(int i3) {
        this.wxappInstallFlag = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: f, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: g, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    /* renamed from: j, reason: from getter */
    public final int getHitPkgCache() {
        return this.hitPkgCache;
    }

    /* renamed from: k, reason: from getter */
    public final int getHitPreload() {
        return this.hitPreload;
    }

    /* renamed from: l, reason: from getter */
    public final String getMetaData() {
        return this.metaData;
    }

    /* renamed from: m, reason: from getter */
    public final int getMetaType() {
        return this.metaType;
    }

    /* renamed from: n, reason: from getter */
    public final int getRelativeResult() {
        return this.relativeResult;
    }

    /* renamed from: o, reason: from getter */
    public final String getSceneNote() {
        return this.sceneNote;
    }

    /* renamed from: p, reason: from getter */
    public final String getStartupId() {
        return this.startupId;
    }

    /* renamed from: q, reason: from getter */
    public final int getStartupScene() {
        return this.startupScene;
    }

    /* renamed from: r, reason: from getter */
    public final String getTidUserId() {
        return this.tidUserId;
    }

    /* renamed from: s, reason: from getter */
    public final int getVersionType() {
        return this.versionType;
    }

    /* renamed from: t, reason: from getter */
    public final String getWxAppId() {
        return this.wxAppId;
    }

    public String toString() {
        return "[eventName:" + this.eventName + ",metaData:" + this.metaData + ",metaType:" + this.metaType + ",startupScene:" + this.startupScene + ",sceneNote:" + this.sceneNote + ",wxappInstallFlag:" + this.wxappInstallFlag + ",relativeResult:" + this.relativeResult + ",authType:" + this.authType + ",errCode:" + this.errCode + ",errMsg:" + this.errMsg + ']';
    }

    /* renamed from: u, reason: from getter */
    public final String getWxVersion() {
        return this.wxVersion;
    }

    /* renamed from: v, reason: from getter */
    public final int getWxappInstallFlag() {
        return this.wxappInstallFlag;
    }

    public final void w(int i3) {
        this.authType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.startupId);
        parcel.writeString(this.eventName);
        parcel.writeString(this.metaData);
        parcel.writeInt(this.metaType);
        parcel.writeInt(this.startupScene);
        parcel.writeLong(this.eventTime);
        parcel.writeInt(this.wxappInstallFlag);
        parcel.writeInt(this.versionType);
        parcel.writeString(this.tidUserId);
        parcel.writeString(this.sceneNote);
    }

    public final void x(int i3) {
        this.coldLaunch = i3;
    }

    public final void y(int i3) {
        this.errCode = i3;
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WxaStartupReportData(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.startupId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.eventName = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.metaData = readString3 == null ? "" : readString3;
        this.metaType = parcel.readInt();
        this.startupScene = parcel.readInt();
        this.eventTime = parcel.readLong();
        this.wxappInstallFlag = parcel.readInt();
        this.versionType = parcel.readInt();
        String readString4 = parcel.readString();
        this.tidUserId = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.sceneNote = readString5 != null ? readString5 : "";
    }
}
