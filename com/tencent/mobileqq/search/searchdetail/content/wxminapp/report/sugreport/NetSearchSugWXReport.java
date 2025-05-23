package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport;

import com.google.gson.annotations.SerializedName;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.UfsQQSugReportParams;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchCommParams;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportResp;
import cooperation.qzone.QZoneHelper;
import java.net.URLEncoder;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u001e\u001f \bB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ>\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsQQSugReportParams;", "param", "", h.F, "", "reqJson", "b", c.G, "displayPos", "sugWord", "d", "", "sugWordType", "Lorg/json/JSONObject;", "jsonReportExtData", "", "f", "e", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$ReqBusinessType;", "businessType", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$SugReportActionType;", "action", "pageSessionId", "itempos", "query", "g", "<init>", "()V", "a", "ReqBusinessType", "SugReportActionType", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchSugWXReport {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NetSearchSugWXReport f284428a = new NetSearchSugWXReport();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$ReqBusinessType;", "", "id", "", "(Ljava/lang/String;IJ)V", "getId", "()J", "LOCAL_SEARCH", "NET_SERACH", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum ReqBusinessType {
        LOCAL_SEARCH(0),
        NET_SERACH(64);

        private final long id;

        ReqBusinessType(long j3) {
            this.id = j3;
        }

        public final long getId() {
            return this.id;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$SugReportActionType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", MyNearbyProBizScene.CLICK, "IMPL", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum SugReportActionType {
        CLICK(3004),
        IMPL(2000);

        private final int id;

        SugReportActionType(int i3) {
            this.id = i3;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\fR\u001a\u0010(\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010\fR\u001a\u0010-\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "searchid", "getSearchid", "suggestionid", "getSuggestionid", "requestid", "getRequestid", "actionid", "I", "getActionid", "()I", "iteminfo", "getIteminfo", "docinfo", "getDocinfo", "h5version", "getH5version", "scene", "getScene", "", "reqbusinesstype", "J", "getReqbusinesstype", "()J", "scenetype", "getScenetype", QZoneHelper.INTENT_EXTINFO, "getExtinfo", "iscache", "getIscache", "query", "getQuery", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$b;", "userAttr", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$b;", "getUserAttr", "()Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$b;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIJILjava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$b;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.NetSearchSugWXReport$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class NetSearchSugReportParams {

        @SerializedName("actionid")
        private final int actionid;

        @SerializedName("docinfo")
        @NotNull
        private final String docinfo;

        @SerializedName(QZoneHelper.INTENT_EXTINFO)
        @NotNull
        private final String extinfo;

        @SerializedName("h5version")
        private final int h5version;

        @SerializedName("iscache")
        private final int iscache;

        @SerializedName("iteminfo")
        @NotNull
        private final String iteminfo;

        @SerializedName("query")
        @NotNull
        private final String query;

        @SerializedName("reqbusinesstype")
        private final long reqbusinesstype;

        @SerializedName("requestid")
        @NotNull
        private final String requestid;

        @SerializedName("scene")
        private final int scene;

        @SerializedName("scenetype")
        private final int scenetype;

        @SerializedName("searchid")
        @NotNull
        private final String searchid;

        @SerializedName("sessionid")
        @NotNull
        private final String sessionId;

        @SerializedName("suggestionid")
        @NotNull
        private final String suggestionid;

        @SerializedName("user_attr")
        @NotNull
        private final UfsUserAttr userAttr;

        public NetSearchSugReportParams(@NotNull String sessionId, @NotNull String searchid, @NotNull String suggestionid, @NotNull String requestid, int i3, @NotNull String iteminfo, @NotNull String docinfo, int i16, int i17, long j3, int i18, @NotNull String extinfo, int i19, @NotNull String query, @NotNull UfsUserAttr userAttr) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(searchid, "searchid");
            Intrinsics.checkNotNullParameter(suggestionid, "suggestionid");
            Intrinsics.checkNotNullParameter(requestid, "requestid");
            Intrinsics.checkNotNullParameter(iteminfo, "iteminfo");
            Intrinsics.checkNotNullParameter(docinfo, "docinfo");
            Intrinsics.checkNotNullParameter(extinfo, "extinfo");
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(userAttr, "userAttr");
            this.sessionId = sessionId;
            this.searchid = searchid;
            this.suggestionid = suggestionid;
            this.requestid = requestid;
            this.actionid = i3;
            this.iteminfo = iteminfo;
            this.docinfo = docinfo;
            this.h5version = i16;
            this.scene = i17;
            this.reqbusinesstype = j3;
            this.scenetype = i18;
            this.extinfo = extinfo;
            this.iscache = i19;
            this.query = query;
            this.userAttr = userAttr;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetSearchSugReportParams)) {
                return false;
            }
            NetSearchSugReportParams netSearchSugReportParams = (NetSearchSugReportParams) other;
            if (Intrinsics.areEqual(this.sessionId, netSearchSugReportParams.sessionId) && Intrinsics.areEqual(this.searchid, netSearchSugReportParams.searchid) && Intrinsics.areEqual(this.suggestionid, netSearchSugReportParams.suggestionid) && Intrinsics.areEqual(this.requestid, netSearchSugReportParams.requestid) && this.actionid == netSearchSugReportParams.actionid && Intrinsics.areEqual(this.iteminfo, netSearchSugReportParams.iteminfo) && Intrinsics.areEqual(this.docinfo, netSearchSugReportParams.docinfo) && this.h5version == netSearchSugReportParams.h5version && this.scene == netSearchSugReportParams.scene && this.reqbusinesstype == netSearchSugReportParams.reqbusinesstype && this.scenetype == netSearchSugReportParams.scenetype && Intrinsics.areEqual(this.extinfo, netSearchSugReportParams.extinfo) && this.iscache == netSearchSugReportParams.iscache && Intrinsics.areEqual(this.query, netSearchSugReportParams.query) && Intrinsics.areEqual(this.userAttr, netSearchSugReportParams.userAttr)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.sessionId.hashCode() * 31) + this.searchid.hashCode()) * 31) + this.suggestionid.hashCode()) * 31) + this.requestid.hashCode()) * 31) + this.actionid) * 31) + this.iteminfo.hashCode()) * 31) + this.docinfo.hashCode()) * 31) + this.h5version) * 31) + this.scene) * 31) + androidx.fragment.app.a.a(this.reqbusinesstype)) * 31) + this.scenetype) * 31) + this.extinfo.hashCode()) * 31) + this.iscache) * 31) + this.query.hashCode()) * 31) + this.userAttr.getDeviceTypeId();
        }

        @NotNull
        public String toString() {
            return "NetSearchSugReportParams(sessionId=" + this.sessionId + ", searchid=" + this.searchid + ", suggestionid=" + this.suggestionid + ", requestid=" + this.requestid + ", actionid=" + this.actionid + ", iteminfo=" + this.iteminfo + ", docinfo=" + this.docinfo + ", h5version=" + this.h5version + ", scene=" + this.scene + ", reqbusinesstype=" + this.reqbusinesstype + ", scenetype=" + this.scenetype + ", extinfo=" + this.extinfo + ", iscache=" + this.iscache + ", query=" + this.query + ", userAttr=" + this.userAttr + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/sugreport/NetSearchSugWXReport$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "deviceTypeId", "I", "getDeviceTypeId", "()I", "<init>", "(I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.NetSearchSugWXReport$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class UfsUserAttr {

        @SerializedName("device_type_id")
        private final int deviceTypeId;

        public UfsUserAttr(int i3) {
            this.deviceTypeId = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UfsUserAttr) && this.deviceTypeId == ((UfsUserAttr) other).deviceTypeId) {
                return true;
            }
            return false;
        }

        /* renamed from: hashCode, reason: from getter */
        public int getDeviceTypeId() {
            return this.deviceTypeId;
        }

        @NotNull
        public String toString() {
            return "UfsUserAttr(deviceTypeId=" + this.deviceTypeId + ")";
        }
    }

    NetSearchSugWXReport() {
    }

    private final void b(String reqJson) {
        String str;
        UfsWxaSearchReportReq ufsWxaSearchReportReq = new UfsWxaSearchReportReq();
        UfsWxaSearchCommParams ufsWxaSearchCommParams = ufsWxaSearchReportReq.commParams;
        if (ufsWxaSearchCommParams != null) {
            try {
                ufsWxaSearchCommParams.requestId = UUID.randomUUID().toString();
            } catch (Throwable th5) {
                QLog.e("QQSearch.sugwxreport.NetSearchSugWXReport", 1, "[doWXSearchReport]", th5);
            }
        }
        ufsWxaSearchReportReq.reqActionType = 2;
        d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo != null) {
            str = bindingWeChatUserInfo.h();
        } else {
            str = null;
        }
        ufsWxaSearchReportReq.wxFuncToken = str;
        ufsWxaSearchReportReq.reqJson = reqJson;
        IKernelUnifySearchService c16 = n.c();
        if (c16 != null) {
            c16.wxSearchReport(ufsWxaSearchReportReq, new IWxSearchReportCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback
                public final void onResult(int i3, String str2, UfsWxaSearchReportResp ufsWxaSearchReportResp) {
                    NetSearchSugWXReport.c(i3, str2, ufsWxaSearchReportResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String str, UfsWxaSearchReportResp ufsWxaSearchReportResp) {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.sugwxreport.NetSearchSugWXReport", 1, "report end. code=" + i3 + " msg=" + str, null);
    }

    private final String d(String pos, String displayPos, String sugWord) {
        return pos + "|" + displayPos + "|" + URLEncoder.encode(sugWord) + "||||||suggest_word|";
    }

    private final void h(UfsQQSugReportParams param) {
        String str = param.sessionid;
        Intrinsics.checkNotNullExpressionValue(str, "param.sessionid");
        String str2 = param.searchid;
        Intrinsics.checkNotNullExpressionValue(str2, "param.searchid");
        String str3 = param.suggestionid;
        Intrinsics.checkNotNullExpressionValue(str3, "param.suggestionid");
        String str4 = param.requestid;
        Intrinsics.checkNotNullExpressionValue(str4, "param.requestid");
        int i3 = param.actionid;
        String str5 = param.iteminfo;
        Intrinsics.checkNotNullExpressionValue(str5, "param.iteminfo");
        String str6 = param.docinfo;
        Intrinsics.checkNotNullExpressionValue(str6, "param.docinfo");
        int i16 = param.h5version;
        int i17 = param.scene;
        long j3 = param.reqbusinesstype;
        int i18 = param.scenetype;
        String str7 = param.extinfo;
        Intrinsics.checkNotNullExpressionValue(str7, "param.extinfo");
        int i19 = param.iscache;
        String str8 = param.query;
        Intrinsics.checkNotNullExpressionValue(str8, "param.query");
        String jsonString = op2.a.e(new NetSearchSugReportParams(str, str2, str3, str4, i3, str5, str6, i16, i17, j3, i18, str7, i19, str8, new UfsUserAttr(2)), "{}");
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
        b(jsonString);
    }

    @Nullable
    public final String e(@NotNull JSONObject jsonReportExtData) {
        Intrinsics.checkNotNullParameter(jsonReportExtData, "jsonReportExtData");
        JSONObject optJSONObject = jsonReportExtData.optJSONObject("report_data");
        if (optJSONObject != null) {
            return optJSONObject.optString("recall_reason");
        }
        return null;
    }

    public final boolean f(int sugWordType, @NotNull JSONObject jsonReportExtData) {
        Intrinsics.checkNotNullParameter(jsonReportExtData, "jsonReportExtData");
        if (sugWordType == 2 || Intrinsics.areEqual(e(jsonReportExtData), "wx_recall")) {
            return true;
        }
        return false;
    }

    public final void g(@NotNull ReqBusinessType businessType, @NotNull SugReportActionType action, @NotNull String pageSessionId, int itempos, @NotNull String query, @NotNull String sugWord, @NotNull JSONObject jsonReportExtData) {
        boolean isBlank;
        int i3;
        Intrinsics.checkNotNullParameter(businessType, "businessType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(pageSessionId, "pageSessionId");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(sugWord, "sugWord");
        Intrinsics.checkNotNullParameter(jsonReportExtData, "jsonReportExtData");
        UfsQQSugReportParams ufsQQSugReportParams = new UfsQQSugReportParams();
        isBlank = StringsKt__StringsJVMKt.isBlank(pageSessionId);
        if (isBlank) {
            s.e("QQSearch.sugwxreport.NetSearchSugWXReport", "pageSessionId is null", new RuntimeException("report businessType=" + businessType + " action=" + action));
        }
        ufsQQSugReportParams.sessionid = pageSessionId;
        ufsQQSugReportParams.timestampms = System.currentTimeMillis();
        ufsQQSugReportParams.actionid = action.getId();
        ufsQQSugReportParams.reqbusinesstype = 65L;
        ufsQQSugReportParams.scene = 6002;
        if (businessType == ReqBusinessType.LOCAL_SEARCH) {
            i3 = 7;
        } else {
            i3 = 3;
        }
        ufsQQSugReportParams.scenetype = i3;
        ufsQQSugReportParams.iscache = 0;
        ufsQQSugReportParams.query = URLEncoder.encode(query);
        JSONObject optJSONObject = jsonReportExtData.optJSONObject("report_data");
        if (optJSONObject != null) {
            ufsQQSugReportParams.searchid = optJSONObject.optString("search_id");
            ufsQQSugReportParams.suggestionid = optJSONObject.optString("suggestion_id");
            ufsQQSugReportParams.requestid = optJSONObject.optString("query_id");
            String pos = optJSONObject.optString("index");
            NetSearchSugWXReport netSearchSugWXReport = f284428a;
            Intrinsics.checkNotNullExpressionValue(pos, "pos");
            ufsQQSugReportParams.docinfo = netSearchSugWXReport.d(pos, String.valueOf(itempos), sugWord);
            ufsQQSugReportParams.iteminfo = "1|1|SUG";
            ufsQQSugReportParams.extinfo = optJSONObject.optString("ext_info");
        }
        h(ufsQQSugReportParams);
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            QLog.d("QS.QQSearch.sugwxreport.NetSearchSugWXReport", 2, "report start. " + ufsQQSugReportParams, (Throwable) null);
        }
    }
}
