package com.tencent.mobileqq.search.searchdetail.content.wxminapp.report;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106Jw\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001a\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/k;", "", "", "query", "searchId", "", "scene", "parentSearchId", "reqBusinessType", "eventId", "", "eventTimeStamp", "stayTime", "pageType", "sessionId", "clickId", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "getSearchId", tl.h.F, "I", "getScene", "()I", "g", "(I)V", "getParentSearchId", "d", "getReqBusinessType", "f", "getEventId", "setEventId", "J", "getEventTimeStamp", "()J", "setEventTimeStamp", "(J)V", "getStayTime", "setStayTime", "getPageType", "setPageType", "getSessionId", "i", "getClickId", "setClickId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIJJILjava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.k, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SearchStayReportParam {

    @SerializedName("clickId")
    @NotNull
    private String clickId;

    @SerializedName("eventId")
    private int eventId;

    @SerializedName("eventTimeStamp")
    private long eventTimeStamp;

    @SerializedName("pageType")
    private int pageType;

    @SerializedName("parentSearchId")
    @NotNull
    private String parentSearchId;

    @SerializedName("query")
    @NotNull
    private String query;

    @SerializedName("reqBusinessType")
    private int reqBusinessType;

    @SerializedName("scene")
    private int scene;

    @SerializedName("searchId")
    @NotNull
    private String searchId;

    @SerializedName("sessionId")
    @NotNull
    private String sessionId;

    @SerializedName("stayTime")
    private long stayTime;

    public SearchStayReportParam() {
        this(null, null, 0, null, 0, 0, 0L, 0L, 0, null, null, 2047, null);
    }

    public static /* synthetic */ SearchStayReportParam b(SearchStayReportParam searchStayReportParam, String str, String str2, int i3, String str3, int i16, int i17, long j3, long j16, int i18, String str4, String str5, int i19, Object obj) {
        String str6;
        String str7;
        int i26;
        String str8;
        int i27;
        int i28;
        long j17;
        long j18;
        int i29;
        String str9;
        String str10;
        if ((i19 & 1) != 0) {
            str6 = searchStayReportParam.query;
        } else {
            str6 = str;
        }
        if ((i19 & 2) != 0) {
            str7 = searchStayReportParam.searchId;
        } else {
            str7 = str2;
        }
        if ((i19 & 4) != 0) {
            i26 = searchStayReportParam.scene;
        } else {
            i26 = i3;
        }
        if ((i19 & 8) != 0) {
            str8 = searchStayReportParam.parentSearchId;
        } else {
            str8 = str3;
        }
        if ((i19 & 16) != 0) {
            i27 = searchStayReportParam.reqBusinessType;
        } else {
            i27 = i16;
        }
        if ((i19 & 32) != 0) {
            i28 = searchStayReportParam.eventId;
        } else {
            i28 = i17;
        }
        if ((i19 & 64) != 0) {
            j17 = searchStayReportParam.eventTimeStamp;
        } else {
            j17 = j3;
        }
        if ((i19 & 128) != 0) {
            j18 = searchStayReportParam.stayTime;
        } else {
            j18 = j16;
        }
        if ((i19 & 256) != 0) {
            i29 = searchStayReportParam.pageType;
        } else {
            i29 = i18;
        }
        if ((i19 & 512) != 0) {
            str9 = searchStayReportParam.sessionId;
        } else {
            str9 = str4;
        }
        if ((i19 & 1024) != 0) {
            str10 = searchStayReportParam.clickId;
        } else {
            str10 = str5;
        }
        return searchStayReportParam.a(str6, str7, i26, str8, i27, i28, j17, j18, i29, str9, str10);
    }

    @NotNull
    public final SearchStayReportParam a(@NotNull String query, @NotNull String searchId, int scene, @NotNull String parentSearchId, int reqBusinessType, int eventId, long eventTimeStamp, long stayTime, int pageType, @NotNull String sessionId, @NotNull String clickId) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        return new SearchStayReportParam(query, searchId, scene, parentSearchId, reqBusinessType, eventId, eventTimeStamp, stayTime, pageType, sessionId, clickId);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentSearchId = str;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchStayReportParam)) {
            return false;
        }
        SearchStayReportParam searchStayReportParam = (SearchStayReportParam) other;
        if (Intrinsics.areEqual(this.query, searchStayReportParam.query) && Intrinsics.areEqual(this.searchId, searchStayReportParam.searchId) && this.scene == searchStayReportParam.scene && Intrinsics.areEqual(this.parentSearchId, searchStayReportParam.parentSearchId) && this.reqBusinessType == searchStayReportParam.reqBusinessType && this.eventId == searchStayReportParam.eventId && this.eventTimeStamp == searchStayReportParam.eventTimeStamp && this.stayTime == searchStayReportParam.stayTime && this.pageType == searchStayReportParam.pageType && Intrinsics.areEqual(this.sessionId, searchStayReportParam.sessionId) && Intrinsics.areEqual(this.clickId, searchStayReportParam.clickId)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.reqBusinessType = i3;
    }

    public final void g(int i3) {
        this.scene = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchId = str;
    }

    public int hashCode() {
        return (((((((((((((((((((this.query.hashCode() * 31) + this.searchId.hashCode()) * 31) + this.scene) * 31) + this.parentSearchId.hashCode()) * 31) + this.reqBusinessType) * 31) + this.eventId) * 31) + androidx.fragment.app.a.a(this.eventTimeStamp)) * 31) + androidx.fragment.app.a.a(this.stayTime)) * 31) + this.pageType) * 31) + this.sessionId.hashCode()) * 31) + this.clickId.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    @NotNull
    public String toString() {
        return "SearchStayReportParam(query=" + this.query + ", searchId=" + this.searchId + ", scene=" + this.scene + ", parentSearchId=" + this.parentSearchId + ", reqBusinessType=" + this.reqBusinessType + ", eventId=" + this.eventId + ", eventTimeStamp=" + this.eventTimeStamp + ", stayTime=" + this.stayTime + ", pageType=" + this.pageType + ", sessionId=" + this.sessionId + ", clickId=" + this.clickId + ")";
    }

    public SearchStayReportParam(@NotNull String query, @NotNull String searchId, int i3, @NotNull String parentSearchId, int i16, int i17, long j3, long j16, int i18, @NotNull String sessionId, @NotNull String clickId) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clickId, "clickId");
        this.query = query;
        this.searchId = searchId;
        this.scene = i3;
        this.parentSearchId = parentSearchId;
        this.reqBusinessType = i16;
        this.eventId = i17;
        this.eventTimeStamp = j3;
        this.stayTime = j16;
        this.pageType = i18;
        this.sessionId = sessionId;
        this.clickId = clickId;
    }

    public /* synthetic */ SearchStayReportParam(String str, String str2, int i3, String str3, int i16, int i17, long j3, long j16, int i18, String str4, String str5, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? "" : str2, (i19 & 4) != 0 ? -1 : i3, (i19 & 8) != 0 ? "" : str3, (i19 & 16) != 0 ? -1 : i16, (i19 & 32) == 0 ? i17 : -1, (i19 & 64) != 0 ? 0L : j3, (i19 & 128) == 0 ? j16 : 0L, (i19 & 256) != 0 ? 2 : i18, (i19 & 512) != 0 ? "" : str4, (i19 & 1024) == 0 ? str5 : "");
    }
}
