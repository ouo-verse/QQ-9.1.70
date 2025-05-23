package com.tencent.ecommerce.base.ui;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0014\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/base/ui/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "b", "setPageName", "pageName", "c", "d", "proteusData", "Lcom/tencent/pts/core/PTSComposer;", "Lcom/tencent/pts/core/PTSComposer;", "()Lcom/tencent/pts/core/PTSComposer;", "e", "(Lcom/tencent/pts/core/PTSComposer;)V", "ptsComposer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/pts/core/PTSComposer;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.ui.b, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class ECBasePtsViewData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String uniqueId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String pageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String proteusData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private PTSComposer ptsComposer;

    public ECBasePtsViewData() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    /* renamed from: b, reason: from getter */
    public final String getProteusData() {
        return this.proteusData;
    }

    /* renamed from: c, reason: from getter */
    public final PTSComposer getPtsComposer() {
        return this.ptsComposer;
    }

    public final void d(String str) {
        this.proteusData = str;
    }

    public final void e(PTSComposer pTSComposer) {
        this.ptsComposer = pTSComposer;
    }

    public int hashCode() {
        String str = this.uniqueId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pageName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.proteusData;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PTSComposer pTSComposer = this.ptsComposer;
        return hashCode3 + (pTSComposer != null ? pTSComposer.hashCode() : 0);
    }

    public String toString() {
        return "ECBasePtsViewData(uniqueId=" + this.uniqueId + ", pageName=" + this.pageName + ", proteusData=" + this.proteusData + ", ptsComposer=" + this.ptsComposer + ")";
    }

    public ECBasePtsViewData(String str, String str2, String str3, PTSComposer pTSComposer) {
        this.uniqueId = str;
        this.pageName = str2;
        this.proteusData = str3;
        this.ptsComposer = pTSComposer;
    }

    public /* synthetic */ ECBasePtsViewData(String str, String str2, String str3, PTSComposer pTSComposer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : pTSComposer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECBasePtsViewData)) {
            return false;
        }
        ECBasePtsViewData eCBasePtsViewData = (ECBasePtsViewData) other;
        return Intrinsics.areEqual(this.uniqueId, eCBasePtsViewData.uniqueId) && Intrinsics.areEqual(this.pageName, eCBasePtsViewData.pageName) && Intrinsics.areEqual(this.proteusData, eCBasePtsViewData.proteusData) && Intrinsics.areEqual(this.ptsComposer, eCBasePtsViewData.ptsComposer);
    }
}
