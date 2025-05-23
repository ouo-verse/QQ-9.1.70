package com.qzone.reborn.part.plusnew;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Bc\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u00a2\u0006\u0004\b6\u00107J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\"\u0010&\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00105\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b4\u0010\u0010\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/part/plusnew/d;", "", "other", "", "c", "", "toString", "hashCode", "", "", "equals", "d", "I", tl.h.F, "()I", "o", "(I)V", "iAdId", "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "mainPicUrl", "f", "k", "r", "mainItemTitle", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, WadlProxyConsts.KEY_JUMP_URL, "i", "getTriggerInfo", "v", "triggerInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "itemId", BdhLogUtil.LogTag.Tag_Conn, "getReportEtag", "setReportEtag", "reportEtag", "Lcom/qzone/reborn/part/plusnew/h;", "D", "Lcom/qzone/reborn/part/plusnew/h;", DomainData.DOMAIN_NAME, "()Lcom/qzone/reborn/part/plusnew/h;", "u", "(Lcom/qzone/reborn/part/plusnew/h;)V", "redPointInfo", "E", "t", "orderNum", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/qzone/reborn/part/plusnew/h;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.part.plusnew.d, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class QzoneNewPlusItemData implements Comparable<QzoneNewPlusItemData> {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private String reportEtag;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private QzoneNewPlusRedItemData redPointInfo;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private int orderNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int iAdId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String mainPicUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String mainItemTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String triggerInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int itemId;

    public QzoneNewPlusItemData() {
        this(0, null, null, null, null, 0, null, null, 0, 511, null);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(QzoneNewPlusItemData other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = this.orderNum - other.orderNum;
        if (i3 > 0) {
            return 1;
        }
        return i3 < 0 ? -1 : 0;
    }

    /* renamed from: h, reason: from getter */
    public final int getIAdId() {
        return this.iAdId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.iAdId * 31) + this.mainPicUrl.hashCode()) * 31) + this.mainItemTitle.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.triggerInfo.hashCode()) * 31) + this.itemId) * 31) + this.reportEtag.hashCode()) * 31;
        QzoneNewPlusRedItemData qzoneNewPlusRedItemData = this.redPointInfo;
        return ((hashCode + (qzoneNewPlusRedItemData == null ? 0 : qzoneNewPlusRedItemData.hashCode())) * 31) + this.orderNum;
    }

    /* renamed from: i, reason: from getter */
    public final int getItemId() {
        return this.itemId;
    }

    /* renamed from: j, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: k, reason: from getter */
    public final String getMainItemTitle() {
        return this.mainItemTitle;
    }

    /* renamed from: l, reason: from getter */
    public final String getMainPicUrl() {
        return this.mainPicUrl;
    }

    /* renamed from: m, reason: from getter */
    public final int getOrderNum() {
        return this.orderNum;
    }

    /* renamed from: n, reason: from getter */
    public final QzoneNewPlusRedItemData getRedPointInfo() {
        return this.redPointInfo;
    }

    public final void o(int i3) {
        this.iAdId = i3;
    }

    public final void p(int i3) {
        this.itemId = i3;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainItemTitle = str;
    }

    public final void s(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainPicUrl = str;
    }

    public final void t(int i3) {
        this.orderNum = i3;
    }

    public String toString() {
        return "QzoneNewPlusItemData(iAdId=" + this.iAdId + ", mainPicUrl=" + this.mainPicUrl + ", mainItemTitle=" + this.mainItemTitle + ", jumpUrl=" + this.jumpUrl + ", triggerInfo=" + this.triggerInfo + ", itemId=" + this.itemId + ", reportEtag=" + this.reportEtag + ", redPointInfo=" + this.redPointInfo + ", orderNum=" + this.orderNum + ")";
    }

    public final void u(QzoneNewPlusRedItemData qzoneNewPlusRedItemData) {
        this.redPointInfo = qzoneNewPlusRedItemData;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.triggerInfo = str;
    }

    public QzoneNewPlusItemData(int i3, String mainPicUrl, String mainItemTitle, String jumpUrl, String triggerInfo, int i16, String reportEtag, QzoneNewPlusRedItemData qzoneNewPlusRedItemData, int i17) {
        Intrinsics.checkNotNullParameter(mainPicUrl, "mainPicUrl");
        Intrinsics.checkNotNullParameter(mainItemTitle, "mainItemTitle");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        Intrinsics.checkNotNullParameter(reportEtag, "reportEtag");
        this.iAdId = i3;
        this.mainPicUrl = mainPicUrl;
        this.mainItemTitle = mainItemTitle;
        this.jumpUrl = jumpUrl;
        this.triggerInfo = triggerInfo;
        this.itemId = i16;
        this.reportEtag = reportEtag;
        this.redPointInfo = qzoneNewPlusRedItemData;
        this.orderNum = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QzoneNewPlusItemData)) {
            return false;
        }
        QzoneNewPlusItemData qzoneNewPlusItemData = (QzoneNewPlusItemData) other;
        return this.iAdId == qzoneNewPlusItemData.iAdId && Intrinsics.areEqual(this.mainPicUrl, qzoneNewPlusItemData.mainPicUrl) && Intrinsics.areEqual(this.mainItemTitle, qzoneNewPlusItemData.mainItemTitle) && Intrinsics.areEqual(this.jumpUrl, qzoneNewPlusItemData.jumpUrl) && Intrinsics.areEqual(this.triggerInfo, qzoneNewPlusItemData.triggerInfo) && this.itemId == qzoneNewPlusItemData.itemId && Intrinsics.areEqual(this.reportEtag, qzoneNewPlusItemData.reportEtag) && Intrinsics.areEqual(this.redPointInfo, qzoneNewPlusItemData.redPointInfo) && this.orderNum == qzoneNewPlusItemData.orderNum;
    }

    public /* synthetic */ QzoneNewPlusItemData(int i3, String str, String str2, String str3, String str4, int i16, String str5, QzoneNewPlusRedItemData qzoneNewPlusRedItemData, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? -1 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? "" : str3, (i18 & 16) != 0 ? "" : str4, (i18 & 32) == 0 ? i16 : -1, (i18 & 64) == 0 ? str5 : "", (i18 & 128) != 0 ? null : qzoneNewPlusRedItemData, (i18 & 256) != 0 ? 0 : i17);
    }
}
