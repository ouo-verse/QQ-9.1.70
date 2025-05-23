package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report;

import com.google.gson.annotations.SerializedName;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001B\u00cf\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\bL\u0010MJ\u00d1\u0001\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\bF\u0010 \"\u0004\bG\u0010\"R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\bH\u0010 \"\u0004\bI\u0010\"R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001e\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010\"\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/b;", "", "", "query", "searchId", "", "scene", "parentSearchId", "reqBusinessType", "businessType", QCircleLpReportDc010001.KEY_SUBTYPE, "boxInfo", "docInfo", "itemInfo", "itemPos", RemoteProxy.KEY_RESULT_TYPE, "actionType", "clickId", "pageNumber", "sessionId", "svrBoxExtInfo", "svrDocExtInfo", "qqClientVersion", "netWorkType", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "getSearchId", "r", "I", "getScene", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "getParentSearchId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getReqBusinessType", "o", "getBusinessType", "g", "getSubType", "t", "getBoxInfo", "f", "getDocInfo", "i", "getItemInfo", "j", "getItemPos", "k", "getResultType", "p", "getActionType", "e", "getClickId", tl.h.F, "c", "l", "getSessionId", ReportConstant.COSTREPORT_PREFIX, "getSvrBoxExtInfo", "u", "getSvrDocExtInfo", "v", "getQqClientVersion", "setQqClientVersion", "getNetWorkType", "setNetWorkType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchNormalReportParam {

    @SerializedName("actionType")
    private int actionType;

    @SerializedName("boxInfo")
    @NotNull
    private String boxInfo;

    @SerializedName("businessType")
    private int businessType;

    @SerializedName("clickId")
    @NotNull
    private String clickId;

    @SerializedName("docInfo")
    @NotNull
    private String docInfo;

    @SerializedName("itemInfo")
    @NotNull
    private String itemInfo;

    @SerializedName("itemPos")
    @NotNull
    private String itemPos;

    @SerializedName("netWorkType")
    @NotNull
    private String netWorkType;

    @SerializedName("pageNumber")
    private int pageNumber;

    @SerializedName("parentSearchId")
    @NotNull
    private String parentSearchId;

    @SerializedName("qqClientVersion")
    @NotNull
    private String qqClientVersion;

    @SerializedName("query")
    @NotNull
    private String query;

    @SerializedName("reqBusinessType")
    private int reqBusinessType;

    @SerializedName(RemoteProxy.KEY_RESULT_TYPE)
    private int resultType;

    @SerializedName("scene")
    private int scene;

    @SerializedName("searchId")
    @NotNull
    private String searchId;

    @SerializedName("sessionId")
    @NotNull
    private String sessionId;

    @SerializedName(QCircleLpReportDc010001.KEY_SUBTYPE)
    private int subType;

    @SerializedName("svrBoxExtInfo")
    @NotNull
    private String svrBoxExtInfo;

    @SerializedName("svrDocExtInfo")
    @NotNull
    private String svrDocExtInfo;

    public SearchNormalReportParam() {
        this(null, null, 0, null, 0, 0, 0, null, null, null, null, 0, 0, null, 0, null, null, null, null, null, 1048575, null);
    }

    @NotNull
    public final SearchNormalReportParam a(@NotNull String query, @NotNull String searchId, int scene, @NotNull String parentSearchId, int reqBusinessType, int businessType, int subType, @NotNull String boxInfo, @NotNull String docInfo, @NotNull String itemInfo, @NotNull String itemPos, int resultType, int actionType, @NotNull String clickId, int pageNumber, @NotNull String sessionId, @NotNull String svrBoxExtInfo, @NotNull String svrDocExtInfo, @NotNull String qqClientVersion, @NotNull String netWorkType) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(boxInfo, "boxInfo");
        Intrinsics.checkNotNullParameter(docInfo, "docInfo");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(itemPos, "itemPos");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(svrBoxExtInfo, "svrBoxExtInfo");
        Intrinsics.checkNotNullParameter(svrDocExtInfo, "svrDocExtInfo");
        Intrinsics.checkNotNullParameter(qqClientVersion, "qqClientVersion");
        Intrinsics.checkNotNullParameter(netWorkType, "netWorkType");
        return new SearchNormalReportParam(query, searchId, scene, parentSearchId, reqBusinessType, businessType, subType, boxInfo, docInfo, itemInfo, itemPos, resultType, actionType, clickId, pageNumber, sessionId, svrBoxExtInfo, svrDocExtInfo, qqClientVersion, netWorkType);
    }

    /* renamed from: c, reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final void e(int i3) {
        this.actionType = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchNormalReportParam)) {
            return false;
        }
        SearchNormalReportParam searchNormalReportParam = (SearchNormalReportParam) other;
        if (Intrinsics.areEqual(this.query, searchNormalReportParam.query) && Intrinsics.areEqual(this.searchId, searchNormalReportParam.searchId) && this.scene == searchNormalReportParam.scene && Intrinsics.areEqual(this.parentSearchId, searchNormalReportParam.parentSearchId) && this.reqBusinessType == searchNormalReportParam.reqBusinessType && this.businessType == searchNormalReportParam.businessType && this.subType == searchNormalReportParam.subType && Intrinsics.areEqual(this.boxInfo, searchNormalReportParam.boxInfo) && Intrinsics.areEqual(this.docInfo, searchNormalReportParam.docInfo) && Intrinsics.areEqual(this.itemInfo, searchNormalReportParam.itemInfo) && Intrinsics.areEqual(this.itemPos, searchNormalReportParam.itemPos) && this.resultType == searchNormalReportParam.resultType && this.actionType == searchNormalReportParam.actionType && Intrinsics.areEqual(this.clickId, searchNormalReportParam.clickId) && this.pageNumber == searchNormalReportParam.pageNumber && Intrinsics.areEqual(this.sessionId, searchNormalReportParam.sessionId) && Intrinsics.areEqual(this.svrBoxExtInfo, searchNormalReportParam.svrBoxExtInfo) && Intrinsics.areEqual(this.svrDocExtInfo, searchNormalReportParam.svrDocExtInfo) && Intrinsics.areEqual(this.qqClientVersion, searchNormalReportParam.qqClientVersion) && Intrinsics.areEqual(this.netWorkType, searchNormalReportParam.netWorkType)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.boxInfo = str;
    }

    public final void g(int i3) {
        this.businessType = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clickId = str;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.query.hashCode() * 31) + this.searchId.hashCode()) * 31) + this.scene) * 31) + this.parentSearchId.hashCode()) * 31) + this.reqBusinessType) * 31) + this.businessType) * 31) + this.subType) * 31) + this.boxInfo.hashCode()) * 31) + this.docInfo.hashCode()) * 31) + this.itemInfo.hashCode()) * 31) + this.itemPos.hashCode()) * 31) + this.resultType) * 31) + this.actionType) * 31) + this.clickId.hashCode()) * 31) + this.pageNumber) * 31) + this.sessionId.hashCode()) * 31) + this.svrBoxExtInfo.hashCode()) * 31) + this.svrDocExtInfo.hashCode()) * 31) + this.qqClientVersion.hashCode()) * 31) + this.netWorkType.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.docInfo = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemInfo = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemPos = str;
    }

    public final void l(int i3) {
        this.pageNumber = i3;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentSearchId = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void o(int i3) {
        this.reqBusinessType = i3;
    }

    public final void p(int i3) {
        this.resultType = i3;
    }

    public final void q(int i3) {
        this.scene = i3;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchId = str;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void t(int i3) {
        this.subType = i3;
    }

    @NotNull
    public String toString() {
        return "SearchNormalReportParam(query=" + this.query + ", searchId=" + this.searchId + ", scene=" + this.scene + ", parentSearchId=" + this.parentSearchId + ", reqBusinessType=" + this.reqBusinessType + ", businessType=" + this.businessType + ", subType=" + this.subType + ", boxInfo=" + this.boxInfo + ", docInfo=" + this.docInfo + ", itemInfo=" + this.itemInfo + ", itemPos=" + this.itemPos + ", resultType=" + this.resultType + ", actionType=" + this.actionType + ", clickId=" + this.clickId + ", pageNumber=" + this.pageNumber + ", sessionId=" + this.sessionId + ", svrBoxExtInfo=" + this.svrBoxExtInfo + ", svrDocExtInfo=" + this.svrDocExtInfo + ", qqClientVersion=" + this.qqClientVersion + ", netWorkType=" + this.netWorkType + ")";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrBoxExtInfo = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svrDocExtInfo = str;
    }

    public SearchNormalReportParam(@NotNull String query, @NotNull String searchId, int i3, @NotNull String parentSearchId, int i16, int i17, int i18, @NotNull String boxInfo, @NotNull String docInfo, @NotNull String itemInfo, @NotNull String itemPos, int i19, int i26, @NotNull String clickId, int i27, @NotNull String sessionId, @NotNull String svrBoxExtInfo, @NotNull String svrDocExtInfo, @NotNull String qqClientVersion, @NotNull String netWorkType) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(boxInfo, "boxInfo");
        Intrinsics.checkNotNullParameter(docInfo, "docInfo");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(itemPos, "itemPos");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(svrBoxExtInfo, "svrBoxExtInfo");
        Intrinsics.checkNotNullParameter(svrDocExtInfo, "svrDocExtInfo");
        Intrinsics.checkNotNullParameter(qqClientVersion, "qqClientVersion");
        Intrinsics.checkNotNullParameter(netWorkType, "netWorkType");
        this.query = query;
        this.searchId = searchId;
        this.scene = i3;
        this.parentSearchId = parentSearchId;
        this.reqBusinessType = i16;
        this.businessType = i17;
        this.subType = i18;
        this.boxInfo = boxInfo;
        this.docInfo = docInfo;
        this.itemInfo = itemInfo;
        this.itemPos = itemPos;
        this.resultType = i19;
        this.actionType = i26;
        this.clickId = clickId;
        this.pageNumber = i27;
        this.sessionId = sessionId;
        this.svrBoxExtInfo = svrBoxExtInfo;
        this.svrDocExtInfo = svrDocExtInfo;
        this.qqClientVersion = qqClientVersion;
        this.netWorkType = netWorkType;
    }

    public /* synthetic */ SearchNormalReportParam(String str, String str2, int i3, String str3, int i16, int i17, int i18, String str4, String str5, String str6, String str7, int i19, int i26, String str8, int i27, String str9, String str10, String str11, String str12, String str13, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? "" : str, (i28 & 2) != 0 ? "" : str2, (i28 & 4) != 0 ? -1 : i3, (i28 & 8) != 0 ? "" : str3, (i28 & 16) != 0 ? -1 : i16, (i28 & 32) != 0 ? -1 : i17, (i28 & 64) != 0 ? -1 : i18, (i28 & 128) != 0 ? "" : str4, (i28 & 256) != 0 ? "" : str5, (i28 & 512) != 0 ? "" : str6, (i28 & 1024) != 0 ? "" : str7, (i28 & 2048) != 0 ? -1 : i19, (i28 & 4096) != 0 ? -1 : i26, (i28 & 8192) != 0 ? "" : str8, (i28 & 16384) != 0 ? -1 : i27, (i28 & 32768) != 0 ? "" : str9, (i28 & 65536) != 0 ? "" : str10, (i28 & 131072) != 0 ? "" : str11, (i28 & 262144) != 0 ? String.valueOf(AppSetting.f()) : str12, (i28 & 524288) != 0 ? r.f284572a.l() : str13);
    }
}
