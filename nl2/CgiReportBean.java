package nl2;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010)\u001a\u00020\u001e\u0012\b\b\u0002\u0010+\u001a\u00020\u001e\u0012\b\b\u0002\u0010-\u001a\u00020\u001e\u0012\b\b\u0002\u0010/\u001a\u00020\u001e\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\b\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b\u0018\u0010$R\"\u0010-\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b&\u0010$R\"\u0010/\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b\u0015\u0010$R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\r\u001a\u0004\b1\u0010\u000f\"\u0004\b\u001f\u00102R\"\u00109\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b\u001b\u00108R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u00102\u00a8\u0006@"}, d2 = {"Lnl2/a;", "", "", "url", "a", "", "k", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "eventCode", "getCmd", "cmd", "c", "retCode", "d", "getRetMsg", "retMsg", "e", "getErrorDetail", "errorDetail", "f", "getRequestBody", "requestBody", "", "g", "J", "getRequestTime", "()J", "j", "(J)V", "requestTime", h.F, "getHttpTime", "i", "httpTime", "getDhCostTime", "dhCostTime", "getEncryptTime", "encryptTime", "getDecryptTime", "decryptTime", "l", "getEncryptAlgorithm", "(Ljava/lang/String;)V", "encryptAlgorithm", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getDhCtrlCode", "()I", "(I)V", "dhCtrlCode", DomainData.DOMAIN_NAME, "getNetSvrType", "setNetSvrType", "netSvrType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJLjava/lang/String;ILjava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nl2.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class CgiReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String eventCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String cmd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String retCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String retMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorDetail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String requestBody;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long requestTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long httpTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long dhCostTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long encryptTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long decryptTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String encryptAlgorithm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int dhCtrlCode;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String netSvrType;

    public CgiReportBean(@NotNull String eventCode, @NotNull String cmd, @NotNull String retCode, @NotNull String retMsg, @NotNull String errorDetail, @NotNull String requestBody, long j3, long j16, long j17, long j18, long j19, @NotNull String encryptAlgorithm, int i3, @NotNull String netSvrType) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(retMsg, "retMsg");
        Intrinsics.checkNotNullParameter(errorDetail, "errorDetail");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(encryptAlgorithm, "encryptAlgorithm");
        Intrinsics.checkNotNullParameter(netSvrType, "netSvrType");
        this.eventCode = eventCode;
        this.cmd = cmd;
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.errorDetail = errorDetail;
        this.requestBody = requestBody;
        this.requestTime = j3;
        this.httpTime = j16;
        this.dhCostTime = j17;
        this.encryptTime = j18;
        this.decryptTime = j19;
        this.encryptAlgorithm = encryptAlgorithm;
        this.dhCtrlCode = i3;
        this.netSvrType = netSvrType;
    }

    private final String a(String url) {
        List split$default;
        Object last;
        int indexOf$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        String str = (String) last;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str;
        }
        return str.subSequence(0, indexOf$default).toString();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getEventCode() {
        return this.eventCode;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRetCode() {
        return this.retCode;
    }

    public final void d(long j3) {
        this.decryptTime = j3;
    }

    public final void e(long j3) {
        this.dhCostTime = j3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CgiReportBean)) {
            return false;
        }
        CgiReportBean cgiReportBean = (CgiReportBean) other;
        if (Intrinsics.areEqual(this.eventCode, cgiReportBean.eventCode) && Intrinsics.areEqual(this.cmd, cgiReportBean.cmd) && Intrinsics.areEqual(this.retCode, cgiReportBean.retCode) && Intrinsics.areEqual(this.retMsg, cgiReportBean.retMsg) && Intrinsics.areEqual(this.errorDetail, cgiReportBean.errorDetail) && Intrinsics.areEqual(this.requestBody, cgiReportBean.requestBody) && this.requestTime == cgiReportBean.requestTime && this.httpTime == cgiReportBean.httpTime && this.dhCostTime == cgiReportBean.dhCostTime && this.encryptTime == cgiReportBean.encryptTime && this.decryptTime == cgiReportBean.decryptTime && Intrinsics.areEqual(this.encryptAlgorithm, cgiReportBean.encryptAlgorithm) && this.dhCtrlCode == cgiReportBean.dhCtrlCode && Intrinsics.areEqual(this.netSvrType, cgiReportBean.netSvrType)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.dhCtrlCode = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encryptAlgorithm = str;
    }

    public final void h(long j3) {
        this.encryptTime = j3;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.eventCode.hashCode() * 31) + this.cmd.hashCode()) * 31) + this.retCode.hashCode()) * 31) + this.retMsg.hashCode()) * 31) + this.errorDetail.hashCode()) * 31) + this.requestBody.hashCode()) * 31) + androidx.fragment.app.a.a(this.requestTime)) * 31) + androidx.fragment.app.a.a(this.httpTime)) * 31) + androidx.fragment.app.a.a(this.dhCostTime)) * 31) + androidx.fragment.app.a.a(this.encryptTime)) * 31) + androidx.fragment.app.a.a(this.decryptTime)) * 31) + this.encryptAlgorithm.hashCode()) * 31) + this.dhCtrlCode) * 31) + this.netSvrType.hashCode();
    }

    public final void i(long j3) {
        this.httpTime = j3;
    }

    public final void j(long j3) {
        this.requestTime = j3;
    }

    @NotNull
    public final Map<String, String> k() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("kcgi_cmd", a(this.cmd)), TuplesKt.to("kcgi_ret_code", this.retCode), TuplesKt.to("kcgi_ret_msg", this.retMsg), TuplesKt.to("kcgi_error", this.errorDetail), TuplesKt.to("kcgi_req_body", this.requestBody), TuplesKt.to("kcgi_requset_time", String.valueOf(this.requestTime)), TuplesKt.to("kcgi_http_time", String.valueOf(this.httpTime)), TuplesKt.to("kcgi_dh_cost_time", String.valueOf(this.dhCostTime)), TuplesKt.to("kcgi_encrypt_time", String.valueOf(this.encryptTime)), TuplesKt.to("kcgi_decrypt_time", String.valueOf(this.decryptTime)), TuplesKt.to("kcgi_algorithm", this.encryptAlgorithm), TuplesKt.to("kcgi_dh_ctrl_code", String.valueOf(this.dhCtrlCode)), TuplesKt.to("kcgi_net_svr_type", this.netSvrType));
        return mutableMapOf;
    }

    @NotNull
    public String toString() {
        return "CgiReportBean(eventCode=" + this.eventCode + ", cmd=" + this.cmd + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", errorDetail=" + this.errorDetail + ", requestBody=" + this.requestBody + ", requestTime=" + this.requestTime + ", httpTime=" + this.httpTime + ", dhCostTime=" + this.dhCostTime + ", encryptTime=" + this.encryptTime + ", decryptTime=" + this.decryptTime + ", encryptAlgorithm=" + this.encryptAlgorithm + ", dhCtrlCode=" + this.dhCtrlCode + ", netSvrType=" + this.netSvrType + ')';
    }

    public /* synthetic */ CgiReportBean(String str, String str2, String str3, String str4, String str5, String str6, long j3, long j16, long j17, long j18, long j19, String str7, int i3, String str8, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "e_cgi" : str, str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? "" : str5, (i16 & 32) != 0 ? "" : str6, (i16 & 64) != 0 ? -1L : j3, (i16 & 128) != 0 ? -1L : j16, (i16 & 256) != 0 ? -1L : j17, (i16 & 512) != 0 ? -1L : j18, (i16 & 1024) != 0 ? -1L : j19, (i16 & 2048) != 0 ? "" : str7, (i16 & 4096) != 0 ? -1 : i3, (i16 & 8192) != 0 ? "" : str8);
    }
}
