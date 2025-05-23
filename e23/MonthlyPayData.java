package e23;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000e\u0010!R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010&\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b%\u0010!R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u001f\u0010\fR\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b\u0018\u0010\f\u00a8\u0006+"}, d2 = {"Le23/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "offerId", "b", "I", "i", "()I", "saveValue", "l", "userId", "d", "j", "serviceCode", "e", "k", "serviceName", "f", "aid", "g", QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, h.F, "Z", "()Z", "autoPay", AdParam.PF, QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isCanChange", "remark", "productId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e23.b, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class MonthlyPayData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String offerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int saveValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String serviceCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String serviceName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String aid;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String provideUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoPay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pf;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String provideType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCanChange;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String remark;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String productId;

    public MonthlyPayData(@NotNull String offerId, int i3, @NotNull String userId, @NotNull String serviceCode, @NotNull String serviceName, @NotNull String aid, @NotNull String provideUin, boolean z16, @NotNull String pf5, @NotNull String provideType, boolean z17, @NotNull String remark, @Nullable String str) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(provideUin, "provideUin");
        Intrinsics.checkNotNullParameter(pf5, "pf");
        Intrinsics.checkNotNullParameter(provideType, "provideType");
        Intrinsics.checkNotNullParameter(remark, "remark");
        this.offerId = offerId;
        this.saveValue = i3;
        this.userId = userId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.aid = aid;
        this.provideUin = provideUin;
        this.autoPay = z16;
        this.pf = pf5;
        this.provideType = provideType;
        this.isCanChange = z17;
        this.remark = remark;
        this.productId = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAutoPay() {
        return this.autoPay;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getOfferId() {
        return this.offerId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPf() {
        return this.pf;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonthlyPayData)) {
            return false;
        }
        MonthlyPayData monthlyPayData = (MonthlyPayData) other;
        if (Intrinsics.areEqual(this.offerId, monthlyPayData.offerId) && this.saveValue == monthlyPayData.saveValue && Intrinsics.areEqual(this.userId, monthlyPayData.userId) && Intrinsics.areEqual(this.serviceCode, monthlyPayData.serviceCode) && Intrinsics.areEqual(this.serviceName, monthlyPayData.serviceName) && Intrinsics.areEqual(this.aid, monthlyPayData.aid) && Intrinsics.areEqual(this.provideUin, monthlyPayData.provideUin) && this.autoPay == monthlyPayData.autoPay && Intrinsics.areEqual(this.pf, monthlyPayData.pf) && Intrinsics.areEqual(this.provideType, monthlyPayData.provideType) && this.isCanChange == monthlyPayData.isCanChange && Intrinsics.areEqual(this.remark, monthlyPayData.remark) && Intrinsics.areEqual(this.productId, monthlyPayData.productId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getProvideType() {
        return this.provideType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getProvideUin() {
        return this.provideUin;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((this.offerId.hashCode() * 31) + this.saveValue) * 31) + this.userId.hashCode()) * 31) + this.serviceCode.hashCode()) * 31) + this.serviceName.hashCode()) * 31) + this.aid.hashCode()) * 31) + this.provideUin.hashCode()) * 31;
        boolean z16 = this.autoPay;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode3 = (((((hashCode2 + i16) * 31) + this.pf.hashCode()) * 31) + this.provideType.hashCode()) * 31;
        boolean z17 = this.isCanChange;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int hashCode4 = (((hashCode3 + i3) * 31) + this.remark.hashCode()) * 31;
        String str = this.productId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode4 + hashCode;
    }

    /* renamed from: i, reason: from getter */
    public final int getSaveValue() {
        return this.saveValue;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getServiceCode() {
        return this.serviceCode;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsCanChange() {
        return this.isCanChange;
    }

    @NotNull
    public String toString() {
        return "MonthlyPayData(offerId=" + this.offerId + ", saveValue=" + this.saveValue + ", userId=" + this.userId + ", serviceCode=" + this.serviceCode + ", serviceName=" + this.serviceName + ", aid=" + this.aid + ", provideUin=" + this.provideUin + ", autoPay=" + this.autoPay + ", pf=" + this.pf + ", provideType=" + this.provideType + ", isCanChange=" + this.isCanChange + ", remark=" + this.remark + ", productId=" + this.productId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MonthlyPayData(String str, int i3, String str2, String str3, String str4, String str5, String str6, boolean z16, String str7, String str8, boolean z17, String str9, String str10, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, str3, r7, r8, r9, r10, r11, r12, r13, r14, (i16 & 4096) != 0 ? null : str10);
        String str11;
        String str12 = (i16 & 16) != 0 ? "\u8d85\u7ea7\u4f1a\u5458" : str4;
        String str13 = (i16 & 32) != 0 ? IVipPayApi.AID : str5;
        String str14 = (i16 & 64) != 0 ? str2 : str6;
        boolean z18 = (i16 & 128) != 0 ? false : z16;
        String c16 = (i16 & 256) != 0 ? d.c(str13, false, 2, null) : str7;
        String str15 = (i16 & 512) != 0 ? "uin" : str8;
        boolean z19 = (i16 & 1024) != 0 ? false : z17;
        if ((i16 & 2048) != 0) {
            String encode = URLEncoder.encode("aid=" + str13);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(\"aid=$aid\")");
            str11 = encode;
        } else {
            str11 = str9;
        }
    }
}
