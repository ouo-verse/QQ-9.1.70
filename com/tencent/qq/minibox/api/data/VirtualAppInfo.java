package com.tencent.qq.minibox.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bQ\b\u0016\u0018\u0000 ]2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\bZ\u0010[B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\bZ\u0010\\J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\"\u0010#\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\"\u0010\u0014R\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\"\u0010*\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\"\u0010-\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b.\u0010\u0012\"\u0004\b'\u0010\u0014R\"\u00103\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\"\u00109\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010?\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00104\u001a\u0004\b>\u00106\"\u0004\b0\u00108R\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R\"\u0010K\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0010\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u00104\u001a\u0004\bN\u00106\"\u0004\bA\u00108R\"\u0010R\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0010\u001a\u0004\bP\u0010\u0012\"\u0004\bQ\u0010\u0014R\"\u0010V\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u0010\u001a\u0004\bT\u0010\u0012\"\u0004\bU\u0010\u0014R\"\u0010Y\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0010\u001a\u0004\bX\u0010\u0012\"\u0004\bM\u0010\u0014\u00a8\u0006^"}, d2 = {"Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "Landroid/os/Parcelable;", "", "b", "a", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "appIcon", "e", "f", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "appName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "G", "label", h.F, "j", "D", "desc", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "appId", "o", "N", "packageName", BdhLogUtil.LogTag.Tag_Conn, "r", "c0", "versionCode", "k", "E", "downloadUrl", "g", "coverUrl", UserInfo.SEX_FEMALE, "v", "f0", AppConstants.Key.KEY_QZONE_VIDEO_URL, "I", "u", "()I", "e0", "(I)V", "videoHeight", "H", "w", "g0", "videoWidth", "l", "gameState", "J", "Z", HippyTKDListViewAdapter.X, "()Z", "B", "(Z)V", "isBlocked", "K", "isSupportQQPay", "b0", "L", "isSupportLogin", "a0", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "scene", "t", "d0", "via", "P", "p", "V", "reportData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, DomainData.DOMAIN_NAME, "md5", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qq.minibox.api.data.MiniBoxAppDataInfo, reason: from toString */
/* loaded from: classes22.dex */
public class VirtualAppInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String versionCode;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private String downloadUrl;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private String coverUrl;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private String videoUrl;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private int videoHeight;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private int videoWidth;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private int gameState;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isBlocked;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String isSupportQQPay;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String isSupportLogin;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private int scene;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @NotNull
    private String via;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    @NotNull
    private String reportData;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    @NotNull
    private String md5;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String label;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String desc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String packageName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "LAUNCH_SCENE_UNKNOWN", "I", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qq.minibox.api.data.MiniBoxAppDataInfo$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion implements Parcelable.Creator<VirtualAppInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VirtualAppInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VirtualAppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VirtualAppInfo[] newArray(int size) {
            return new VirtualAppInfo[size];
        }

        Companion() {
        }
    }

    public VirtualAppInfo() {
        this.appIcon = "";
        this.appName = "";
        this.label = "";
        this.desc = "";
        this.appId = "";
        this.packageName = "";
        this.versionCode = "";
        this.downloadUrl = "";
        this.coverUrl = "";
        this.videoUrl = "";
        this.videoHeight = -1;
        this.videoWidth = -1;
        this.gameState = 1;
        this.isSupportQQPay = "";
        this.isSupportLogin = "";
        this.scene = 9999;
        this.via = "";
        this.reportData = "";
        this.md5 = "";
    }

    public final void A(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void B(boolean z16) {
        this.isBlocked = z16;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void E(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadUrl = str;
    }

    public final void F(int i3) {
        this.gameState = i3;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    public final void M(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void N(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void V(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportData = str;
    }

    public final void Z(int i3) {
        this.scene = i3;
    }

    public final boolean a() {
        return Intrinsics.areEqual("1", this.isSupportLogin);
    }

    public final void a0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isSupportLogin = str;
    }

    public final boolean b() {
        return Intrinsics.areEqual("1", this.isSupportQQPay);
    }

    public final void b0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isSupportQQPay = str;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppIcon() {
        return this.appIcon;
    }

    public final void c0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionCode = str;
    }

    public final void d0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.via = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final void e0(int i3) {
        this.videoHeight = i3;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    public final void f0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final void g0(int i3) {
        this.videoWidth = i3;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: l, reason: from getter */
    public final int getGameState() {
        return this.gameState;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    /* renamed from: q, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getVersionCode() {
        return this.versionCode;
    }

    public final int s() {
        Integer intOrNull = StringsKt.toIntOrNull(this.versionCode);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getVia() {
        return this.via;
    }

    @NotNull
    public String toString() {
        return "VirtualAppInfo(appIcon=" + this.appIcon + ", appName=" + this.appName + ", label=" + this.label + ", desc=" + this.desc + ", appId=" + this.appId + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", md5=" + this.md5 + ", downloadUrl=" + this.downloadUrl + ", coverUrl=" + this.coverUrl + ", videoUrl=" + this.videoUrl + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", gameState=" + this.gameState + ", scene=" + this.scene + ", via=" + this.via + ", reportData=" + this.reportData + ')';
    }

    /* renamed from: u, reason: from getter */
    public final int getVideoHeight() {
        return this.videoHeight;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* renamed from: w, reason: from getter */
    public final int getVideoWidth() {
        return this.videoWidth;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.appIcon);
        parcel.writeString(this.appName);
        parcel.writeString(this.label);
        parcel.writeString(this.desc);
        parcel.writeString(this.appId);
        parcel.writeString(this.packageName);
        parcel.writeString(this.versionCode);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.videoUrl);
        parcel.writeValue(Integer.valueOf(this.videoHeight));
        parcel.writeValue(Integer.valueOf(this.videoWidth));
        parcel.writeInt(this.gameState);
        parcel.writeString(this.isSupportQQPay);
        parcel.writeString(this.isSupportLogin);
        parcel.writeInt(this.scene);
        parcel.writeString(this.via);
        parcel.writeString(this.reportData);
        parcel.writeString(this.md5);
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appIcon = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualAppInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.appIcon = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.appName = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.label = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.desc = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.appId = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.packageName = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        this.versionCode = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        this.downloadUrl = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        this.coverUrl = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        this.videoUrl = readString10 == null ? "" : readString10;
        Class cls = Integer.TYPE;
        Object readValue = parcel.readValue(cls.getClassLoader());
        Integer num = readValue instanceof Integer ? (Integer) readValue : null;
        Intrinsics.checkNotNull(num);
        this.videoHeight = num.intValue();
        Object readValue2 = parcel.readValue(cls.getClassLoader());
        Integer num2 = readValue2 instanceof Integer ? (Integer) readValue2 : null;
        Intrinsics.checkNotNull(num2, "null cannot be cast to non-null type kotlin.Int");
        this.videoWidth = num2.intValue();
        this.gameState = parcel.readInt();
        String readString11 = parcel.readString();
        this.isSupportQQPay = readString11 == null ? "" : readString11;
        String readString12 = parcel.readString();
        this.isSupportLogin = readString12 == null ? "" : readString12;
        this.scene = parcel.readInt();
        String readString13 = parcel.readString();
        this.via = readString13 == null ? "" : readString13;
        String readString14 = parcel.readString();
        this.reportData = readString14 == null ? "" : readString14;
        String readString15 = parcel.readString();
        this.md5 = readString15 != null ? readString15 : "";
    }
}
