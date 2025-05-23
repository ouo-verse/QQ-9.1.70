package com.tencent.rmonitor.sla;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\t\n\u0002\bQ\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010|\u001a\u00020\u0005\u00a2\u0006\u0004\b}\u0010\u0019J'\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\u00020\t2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010$\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b \u0010\u0017R\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\"\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010&\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010&\u001a\u0004\b\u000e\u00100\"\u0004\b5\u00102R\"\u00109\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b8\u0010\u0019R\"\u0010<\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\"\u0010@\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0015\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\"\u0010C\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019R\"\u0010F\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\bD\u0010\u0017\"\u0004\bE\u0010\u0019R\"\u0010H\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0015\u001a\u0004\b=\u0010\u0017\"\u0004\bG\u0010\u0019R\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\bI\u0010\u0012R\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\bK\u0010\u0012R\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u000e\u001a\u0004\b)\u0010\u0010\"\u0004\bN\u0010\u0012R\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\bQ\u0010\u0012R\"\u0010U\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u0015\u001a\u0004\bM\u0010\u0017\"\u0004\bT\u0010\u0019R\"\u0010X\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u0015\u001a\u0004\bP\u0010\u0017\"\u0004\bW\u0010\u0019R\"\u0010\\\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u0015\u001a\u0004\bZ\u0010\u0017\"\u0004\b[\u0010\u0019R\"\u0010`\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\u0015\u001a\u0004\b^\u0010\u0017\"\u0004\b_\u0010\u0019R\"\u0010c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0015\u001a\u0004\ba\u0010\u0017\"\u0004\bb\u0010\u0019R\"\u0010f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010\u0015\u001a\u0004\bd\u0010\u0017\"\u0004\be\u0010\u0019R\"\u0010i\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010\u0015\u001a\u0004\bg\u0010\u0017\"\u0004\bh\u0010\u0019R\"\u0010l\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u0015\u001a\u0004\bj\u0010\u0017\"\u0004\bk\u0010\u0019R\"\u0010o\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010\u0015\u001a\u0004\bm\u0010\u0017\"\u0004\bn\u0010\u0019R\"\u0010r\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010\u0015\u001a\u0004\bp\u0010\u0017\"\u0004\bq\u0010\u0019R\"\u0010t\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\u0015\u001a\u0004\bS\u0010\u0017\"\u0004\bs\u0010\u0019R\"\u0010v\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010\u0015\u001a\u0004\bV\u0010\u0017\"\u0004\bu\u0010\u0019R\"\u0010x\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u0015\u001a\u0004\bY\u0010\u0017\"\u0004\bw\u0010\u0019R\"\u0010z\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b]\u0010\u0017\"\u0004\by\u0010\u0019R\"\u0010|\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b{\u0010\u0019\u00a8\u0006~"}, d2 = {"Lcom/tencent/rmonitor/sla/c;", "", "", "index", "", "", "params", "r", "(I[Ljava/lang/String;)Ljava/lang/String;", "", "o0", "([Ljava/lang/String;)V", "toString", "a", "I", DomainData.DOMAIN_NAME, "()I", "W", "(I)V", "id", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "N", "(Ljava/lang/String;)V", "appVersion", "c", "M", "appName", "K", "appBundleId", "e", "L", com.heytap.mcssdk.a.a.f36102l, "f", "clientType", "g", "J", "s0", "userId", tl.h.F, "H", "q0", "sdkVersion", "", "i", "l", "()J", "U", "(J)V", "eventTime", "j", "r0", PhotoCategorySinglePicInfo.UPLOAD_TIME, "k", "P", Constants.SP_DEVICE_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "osVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "X", "manufacturer", "p", "Y", "model", "G", "p0", "productId", "V", "fullOSVersion", "T", "eventResult", ExifInterface.LATITUDE_SOUTH, "eventCost", ReportConstant.COSTREPORT_PREFIX, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "errorCode", "t", "O", "debug", "u", "a0", "param0", "v", "b0", "param1", "w", "y", "g0", "param2", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "h0", "param3", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "i0", "param4", "B", "j0", "param5", BdhLogUtil.LogTag.Tag_Conn, "k0", "param6", "D", "l0", "param7", "E", "m0", "param8", UserInfo.SEX_FEMALE, "n0", "param9", "c0", "param10", "d0", "param11", "e0", "param12", "f0", "param13", BdhLogUtil.LogTag.Tag_Req, "eventCode", "<init>", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.rmonitor.sla.c, reason: from toString */
/* loaded from: classes25.dex */
public final class AttaEvent {

    /* renamed from: A, reason: from kotlin metadata and from toString */
    @NotNull
    private String param6;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    @NotNull
    private String param7;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String param8;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private String param9;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private String param10;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @NotNull
    private String param11;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private String param12;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String param13;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String eventCode;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appBundleId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String clientType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String userId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String sdkVersion;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long eventTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long uploadTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String deviceId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String osVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String manufacturer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String model;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String productId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String fullOSVersion;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int eventResult;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int eventCost;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int errorCode;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private int debug;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param0;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param1;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param2;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param3;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param4;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String param5;

    public AttaEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final String r(int index, String[] params) {
        if (params.length > index) {
            return params[index];
        }
        return "";
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final String getParam4() {
        return this.param4;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final String getParam5() {
        return this.param5;
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final String getParam6() {
        return this.param6;
    }

    @NotNull
    /* renamed from: D, reason: from getter */
    public final String getParam7() {
        return this.param7;
    }

    @NotNull
    /* renamed from: E, reason: from getter */
    public final String getParam8() {
        return this.param8;
    }

    @NotNull
    /* renamed from: F, reason: from getter */
    public final String getParam9() {
        return this.param9;
    }

    @NotNull
    /* renamed from: G, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: I, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    @NotNull
    /* renamed from: J, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final void K(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appBundleId = str;
    }

    public final void L(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appKey = str;
    }

    public final void M(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appName = str;
    }

    public final void N(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appVersion = str;
    }

    public final void O(int i3) {
        this.debug = i3;
    }

    public final void P(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.deviceId = str;
    }

    public final void Q(int i3) {
        this.errorCode = i3;
    }

    public final void R(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.eventCode = str;
    }

    public final void S(int i3) {
        this.eventCost = i3;
    }

    public final void T(int i3) {
        this.eventResult = i3;
    }

    public final void U(long j3) {
        this.eventTime = j3;
    }

    public final void V(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.fullOSVersion = str;
    }

    public final void W(int i3) {
        this.id = i3;
    }

    public final void X(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.manufacturer = str;
    }

    public final void Y(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.model = str;
    }

    public final void Z(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.osVersion = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppBundleId() {
        return this.appBundleId;
    }

    public final void a0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param0 = str;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    public final void b0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param1 = str;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    public final void c0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param10 = str;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void d0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param11 = str;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getClientType() {
        return this.clientType;
    }

    public final void e0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param12 = str;
    }

    /* renamed from: f, reason: from getter */
    public final int getDebug() {
        return this.debug;
    }

    public final void f0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param13 = str;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void g0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param2 = str;
    }

    /* renamed from: h, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void h0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param3 = str;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getEventCode() {
        return this.eventCode;
    }

    public final void i0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param4 = str;
    }

    /* renamed from: j, reason: from getter */
    public final int getEventCost() {
        return this.eventCost;
    }

    public final void j0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param5 = str;
    }

    /* renamed from: k, reason: from getter */
    public final int getEventResult() {
        return this.eventResult;
    }

    public final void k0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param6 = str;
    }

    /* renamed from: l, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    public final void l0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param7 = str;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getFullOSVersion() {
        return this.fullOSVersion;
    }

    public final void m0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param8 = str;
    }

    /* renamed from: n, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final void n0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.param9 = str;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void o0(@NotNull String... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.param0 = r(0, params);
        this.param1 = r(1, params);
        this.param2 = r(2, params);
        this.param3 = r(3, params);
        this.param4 = r(4, params);
        this.param5 = r(5, params);
        this.param6 = r(6, params);
        this.param7 = r(7, params);
        this.param8 = r(8, params);
        this.param9 = r(9, params);
        this.param10 = r(10, params);
        this.param11 = r(11, params);
        this.param12 = r(12, params);
        this.param13 = r(13, params);
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final void p0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.productId = str;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void q0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final void r0(long j3) {
        this.uploadTime = j3;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getParam0() {
        return this.param0;
    }

    public final void s0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getParam1() {
        return this.param1;
    }

    @NotNull
    public String toString() {
        return "AttaEvent(eventCode='" + this.eventCode + "', id=" + this.id + ", appVersion='" + this.appVersion + "', appName='" + this.appName + "', appBundleId='" + this.appBundleId + "', appKey='" + this.appKey + "', clientType='" + this.clientType + "', userId='" + this.userId + "', sdkVersion='" + this.sdkVersion + "', eventTime=" + this.eventTime + ", uploadTime=" + this.uploadTime + ", deviceId='" + this.deviceId + "', osVersion='" + this.osVersion + "', manufacturer='" + this.manufacturer + "', model='" + this.model + "', productId='" + this.productId + "', fullOSVersion='" + this.fullOSVersion + "', eventResult=" + this.eventResult + ", eventCost=" + this.eventCost + ", errorCode=" + this.errorCode + ", debug=" + this.debug + ", param0='" + this.param0 + "', param1='" + this.param1 + "', param2='" + this.param2 + "', param3='" + this.param3 + "', param4='" + this.param4 + "', param5='" + this.param5 + "', param6='" + this.param6 + "', param7='" + this.param7 + "', param8='" + this.param8 + "', param9='" + this.param9 + "', param10='" + this.param10 + "', param11='" + this.param11 + "', param12='" + this.param12 + "', param13='" + this.param13 + "')";
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getParam10() {
        return this.param10;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getParam11() {
        return this.param11;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final String getParam12() {
        return this.param12;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final String getParam13() {
        return this.param13;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getParam2() {
        return this.param2;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getParam3() {
        return this.param3;
    }

    public AttaEvent(@NotNull String eventCode) {
        Intrinsics.checkParameterIsNotNull(eventCode, "eventCode");
        this.eventCode = eventCode;
        this.id = -1;
        this.appVersion = "";
        this.appName = "";
        this.appBundleId = "";
        this.appKey = "";
        this.clientType = "android";
        this.userId = "";
        this.sdkVersion = "";
        this.deviceId = "";
        this.osVersion = "";
        this.manufacturer = "";
        this.model = "";
        this.productId = "";
        this.fullOSVersion = "";
        this.eventResult = 1;
        this.param0 = "";
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.param4 = "";
        this.param5 = "";
        this.param6 = "";
        this.param7 = "";
        this.param8 = "";
        this.param9 = "";
        this.param10 = "";
        this.param11 = "";
        this.param12 = "";
        this.param13 = "";
    }

    public /* synthetic */ AttaEvent(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
