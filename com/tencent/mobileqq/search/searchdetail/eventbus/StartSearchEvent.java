package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/StartSearchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "keyword", "", "pageMode", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "refreshType", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "sugTraceId", "wxPreSearchId", "parentType", "source", "(Ljava/lang/String;IILcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "getPageMode", "()I", "getParentType", "getQuerySource", "getRefreshType", "()Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "getSource", "getSugTraceId", "getWxPreSearchId", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class StartSearchEvent extends SimpleBaseEvent {

    @NotNull
    private final String keyword;
    private final int pageMode;
    private final int parentType;
    private final int querySource;

    @NotNull
    private final RefreshType refreshType;

    @NotNull
    private final String source;

    @NotNull
    private final String sugTraceId;

    @NotNull
    private final String wxPreSearchId;

    public /* synthetic */ StartSearchEvent(String str, int i3, int i16, RefreshType refreshType, String str2, String str3, int i17, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, refreshType, str2, str3, i17, (i18 & 128) != 0 ? "startSearchEvent" : str4);
    }

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    public final int getPageMode() {
        return this.pageMode;
    }

    public final int getParentType() {
        return this.parentType;
    }

    public final int getQuerySource() {
        return this.querySource;
    }

    @NotNull
    public final RefreshType getRefreshType() {
        return this.refreshType;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final String getSugTraceId() {
        return this.sugTraceId;
    }

    @NotNull
    public final String getWxPreSearchId() {
        return this.wxPreSearchId;
    }

    @NotNull
    public String toString() {
        return "StartSearchEvent(keyword='" + this.keyword + "', pageMode=" + this.pageMode + ", querySource=" + this.querySource + ", refreshType=" + this.refreshType + ", sugTraceId=" + this.sugTraceId + ", wxPreSearchId=" + this.wxPreSearchId + ", parentType=" + this.parentType + ")";
    }

    public StartSearchEvent(@NotNull String keyword, int i3, int i16, @NotNull RefreshType refreshType, @NotNull String sugTraceId, @NotNull String wxPreSearchId, int i17, @NotNull String source) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(sugTraceId, "sugTraceId");
        Intrinsics.checkNotNullParameter(wxPreSearchId, "wxPreSearchId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.keyword = keyword;
        this.pageMode = i3;
        this.querySource = i16;
        this.refreshType = refreshType;
        this.sugTraceId = sugTraceId;
        this.wxPreSearchId = wxPreSearchId;
        this.parentType = i17;
        this.source = source;
    }
}
