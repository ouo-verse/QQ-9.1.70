package e23;

import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u00dd\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010!R\u0017\u0010(\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b#\u0010\rR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b)\u0010\rR\u0017\u0010-\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b,\u0010\rR\u0017\u0010/\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b.\u0010\rR\u0017\u00102\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\rR\u0019\u00104\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u0019\u00105\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b0\u0010\rR\u0017\u00107\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b6\u0010\rR\u0017\u00109\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b8\u0010\rR\u0017\u0010:\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010;\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b'\u0010\rR\u0017\u0010<\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b3\u0010\r\u00a8\u0006?"}, d2 = {"Le23/a;", "", "", "g", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "offerId", "b", ReportConstant.COSTREPORT_PREFIX, "serviceCode", "c", "t", "serviceName", "d", "u", "uinParam", "e", "I", "()I", "continuousMonth", "f", "aid", "asParma", h.F, "v", "(Ljava/lang/String;)V", "cParma", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "payType", "j", "cmn", "k", "mParma", "nParma", DomainData.DOMAIN_NAME, AdParam.PF, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sandbox", "o", "r", "sdkpay", "p", FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "productId", "getVipMa", "vipMa", "getBillno", "billno", "continuousMonthType", "mpid", "reportData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String offerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uinParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int continuousMonth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String aid;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String asParma;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cParma;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String payType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String cmn;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mParma;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nParma;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pf;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sandbox;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sdkpay;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String groupid;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String productId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String vipMa;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String billno;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String continuousMonthType;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mpid;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reportData;

    public a(@NotNull String offerId, @NotNull String serviceCode, @NotNull String serviceName, @NotNull String uinParam, int i3, @NotNull String aid, @NotNull String asParma, @NotNull String cParma, @NotNull String payType, @NotNull String cmn, @NotNull String mParma, @NotNull String nParma, @NotNull String pf5, @NotNull String sandbox, @NotNull String sdkpay, @Nullable String str, @Nullable String str2, @NotNull String vipMa, @NotNull String billno, @NotNull String continuousMonthType, @NotNull String mpid, @NotNull String reportData) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(uinParam, "uinParam");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(asParma, "asParma");
        Intrinsics.checkNotNullParameter(cParma, "cParma");
        Intrinsics.checkNotNullParameter(payType, "payType");
        Intrinsics.checkNotNullParameter(cmn, "cmn");
        Intrinsics.checkNotNullParameter(mParma, "mParma");
        Intrinsics.checkNotNullParameter(nParma, "nParma");
        Intrinsics.checkNotNullParameter(pf5, "pf");
        Intrinsics.checkNotNullParameter(sandbox, "sandbox");
        Intrinsics.checkNotNullParameter(sdkpay, "sdkpay");
        Intrinsics.checkNotNullParameter(vipMa, "vipMa");
        Intrinsics.checkNotNullParameter(billno, "billno");
        Intrinsics.checkNotNullParameter(continuousMonthType, "continuousMonthType");
        Intrinsics.checkNotNullParameter(mpid, "mpid");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.offerId = offerId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.uinParam = uinParam;
        this.continuousMonth = i3;
        this.aid = aid;
        this.asParma = asParma;
        this.cParma = cParma;
        this.payType = payType;
        this.cmn = cmn;
        this.mParma = mParma;
        this.nParma = nParma;
        this.pf = pf5;
        this.sandbox = sandbox;
        this.sdkpay = sdkpay;
        this.groupid = str;
        this.productId = str2;
        this.vipMa = vipMa;
        this.billno = billno;
        this.continuousMonthType = continuousMonthType;
        this.mpid = mpid;
        this.reportData = reportData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAsParma() {
        return this.asParma;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCParma() {
        return this.cParma;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCmn() {
        return this.cmn;
    }

    /* renamed from: e, reason: from getter */
    public final int getContinuousMonth() {
        return this.continuousMonth;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.offerId, aVar.offerId) && Intrinsics.areEqual(this.serviceCode, aVar.serviceCode) && Intrinsics.areEqual(this.serviceName, aVar.serviceName) && Intrinsics.areEqual(this.uinParam, aVar.uinParam) && this.continuousMonth == aVar.continuousMonth && Intrinsics.areEqual(this.aid, aVar.aid) && Intrinsics.areEqual(this.asParma, aVar.asParma) && Intrinsics.areEqual(this.cParma, aVar.cParma) && Intrinsics.areEqual(this.payType, aVar.payType) && Intrinsics.areEqual(this.cmn, aVar.cmn) && Intrinsics.areEqual(this.mParma, aVar.mParma) && Intrinsics.areEqual(this.nParma, aVar.nParma) && Intrinsics.areEqual(this.pf, aVar.pf) && Intrinsics.areEqual(this.sandbox, aVar.sandbox) && Intrinsics.areEqual(this.sdkpay, aVar.sdkpay) && Intrinsics.areEqual(this.groupid, aVar.groupid) && Intrinsics.areEqual(this.productId, aVar.productId) && Intrinsics.areEqual(this.vipMa, aVar.vipMa) && Intrinsics.areEqual(this.billno, aVar.billno) && Intrinsics.areEqual(this.continuousMonthType, aVar.continuousMonthType) && Intrinsics.areEqual(this.mpid, aVar.mpid) && Intrinsics.areEqual(this.reportData, aVar.reportData)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getContinuousMonthType() {
        return this.continuousMonthType;
    }

    @NotNull
    public final String g() {
        boolean startsWith$default;
        String str;
        if (!TextUtils.isEmpty(this.vipMa)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.vipMa, "MD", false, 2, null);
            if (startsWith$default) {
                str = "month_group=" + this.vipMa + "&extend=" + this.billno;
            } else {
                str = "mpid=" + this.vipMa;
            }
            String encode = URLEncoder.encode(str, "utf-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(\n            if (\u2026     }, \"utf-8\"\n        )");
            return encode;
        }
        return "";
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getGroupid() {
        return this.groupid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((((((((((((this.offerId.hashCode() * 31) + this.serviceCode.hashCode()) * 31) + this.serviceName.hashCode()) * 31) + this.uinParam.hashCode()) * 31) + this.continuousMonth) * 31) + this.aid.hashCode()) * 31) + this.asParma.hashCode()) * 31) + this.cParma.hashCode()) * 31) + this.payType.hashCode()) * 31) + this.cmn.hashCode()) * 31) + this.mParma.hashCode()) * 31) + this.nParma.hashCode()) * 31) + this.pf.hashCode()) * 31) + this.sandbox.hashCode()) * 31) + this.sdkpay.hashCode()) * 31;
        String str = this.groupid;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.productId;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((((((((i16 + i3) * 31) + this.vipMa.hashCode()) * 31) + this.billno.hashCode()) * 31) + this.continuousMonthType.hashCode()) * 31) + this.mpid.hashCode()) * 31) + this.reportData.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getMParma() {
        return this.mParma;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getMpid() {
        return this.mpid;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getNParma() {
        return this.nParma;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getOfferId() {
        return this.offerId;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getPayType() {
        return this.payType;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getPf() {
        return this.pf;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getSandbox() {
        return this.sandbox;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final String getSdkpay() {
        return this.sdkpay;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getServiceCode() {
        return this.serviceCode;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    @NotNull
    public String toString() {
        return c.INSTANCE.b(this);
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getUinParam() {
        return this.uinParam;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cParma = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payType = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i3, r8, r9, r10, r11, r12, r13, r14, r15, (i16 & 8192) != 0 ? "0" : str13, (i16 & 16384) != 0 ? "1" : str14, (32768 & i16) != 0 ? null : str15, (65536 & i16) != 0 ? null : str16, (131072 & i16) != 0 ? "" : str17, (262144 & i16) != 0 ? "" : str18, (524288 & i16) != 0 ? "" : str19, (1048576 & i16) != 0 ? "" : str20, (i16 & 2097152) != 0 ? "" : str21);
        String str22;
        String b16;
        String str23 = (i16 & 32) != 0 ? IVipPayApi.AID : str5;
        String str24 = (i16 & 64) != 0 ? "1" : str6;
        String str25 = (i16 & 128) != 0 ? QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING : str7;
        String str26 = (i16 & 256) != 0 ? "mqq" : str8;
        String str27 = (i16 & 512) != 0 ? "1" : str9;
        String str28 = (i16 & 1024) != 0 ? "buy" : str10;
        String str29 = (i16 & 2048) != 0 ? "1" : str11;
        if ((i16 & 4096) != 0) {
            b16 = d.b(str23, true);
            str22 = b16;
        } else {
            str22 = str12;
        }
    }
}
