package com.tencent.kuikly.core.exception;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/exception/PagerCreatorNotFundException;", "Lcom/tencent/kuikly/core/exception/PagerNotFoundException;", "message", "", "pagerId", "pageName", ISchemeApi.KEY_PAGE_DATA, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageData", "()Ljava/lang/String;", "getPageName", "getPagerId", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PagerCreatorNotFundException extends PagerNotFoundException {
    private final String pageData;
    private final String pageName;
    private final String pagerId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerCreatorNotFundException(String message, String pagerId, String pageName, String pageData) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.pagerId = pagerId;
        this.pageName = pageName;
        this.pageData = pageData;
    }

    public final String getPageData() {
        return this.pageData;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPagerId() {
        return this.pagerId;
    }
}
