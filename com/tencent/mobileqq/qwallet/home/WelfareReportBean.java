package com.tencent.mobileqq.qwallet.home;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/aq;", "", "", "eventCode", "", "a", "toString", "", "hashCode", "other", "", "equals", "I", "opType", "b", "marketId", "c", "customRedPointId", "d", "Z", "isNewPage", "e", "marketType", "f", "Ljava/lang/String;", "systemRedPointId", "<init>", "(IIIZILjava/lang/String;)V", "g", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.home.aq, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class WelfareReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int opType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int marketId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int customRedPointId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNewPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int marketType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String systemRedPointId;

    public WelfareReportBean(int i3, int i16, int i17, boolean z16, int i18, @NotNull String systemRedPointId) {
        Intrinsics.checkNotNullParameter(systemRedPointId, "systemRedPointId");
        this.opType = i3;
        this.marketId = i16;
        this.customRedPointId = i17;
        this.isNewPage = z16;
        this.marketType = i18;
        this.systemRedPointId = systemRedPointId;
    }

    @NotNull
    public final Map<String, String> a(@NotNull String eventCode) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to("op_name", eventCode);
        pairArr[1] = TuplesKt.to(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, "Vip_pay_mywallet");
        pairArr[2] = TuplesKt.to("op_type", String.valueOf(this.opType));
        pairArr[3] = TuplesKt.to("ext1", String.valueOf(this.marketId));
        pairArr[4] = TuplesKt.to("ext2", String.valueOf(this.customRedPointId));
        if (this.isNewPage) {
            str = QCircleDaTongConstant.ElementParamValue.NEW;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD;
        }
        pairArr[5] = TuplesKt.to("pvsrc", str);
        pairArr[6] = TuplesKt.to("ext10", String.valueOf(this.marketType));
        pairArr[7] = TuplesKt.to("ext16", this.systemRedPointId);
        pairArr[8] = TuplesKt.to("pvid", String.valueOf(System.currentTimeMillis()));
        pairArr[9] = TuplesKt.to("plat", "android");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WelfareReportBean)) {
            return false;
        }
        WelfareReportBean welfareReportBean = (WelfareReportBean) other;
        if (this.opType == welfareReportBean.opType && this.marketId == welfareReportBean.marketId && this.customRedPointId == welfareReportBean.customRedPointId && this.isNewPage == welfareReportBean.isNewPage && this.marketType == welfareReportBean.marketType && Intrinsics.areEqual(this.systemRedPointId, welfareReportBean.systemRedPointId)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((this.opType * 31) + this.marketId) * 31) + this.customRedPointId) * 31;
        boolean z16 = this.isNewPage;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + this.marketType) * 31) + this.systemRedPointId.hashCode();
    }

    @NotNull
    public String toString() {
        return "WelfareReportBean(opType=" + this.opType + ", marketId=" + this.marketId + ", customRedPointId=" + this.customRedPointId + ", isNewPage=" + this.isNewPage + ", marketType=" + this.marketType + ", systemRedPointId=" + this.systemRedPointId + ")";
    }
}
