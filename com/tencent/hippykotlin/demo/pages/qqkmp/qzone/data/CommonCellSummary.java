package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;", "", "()V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "summary", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "getSummary", "()Ljava/util/List;", "setSummary", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellSummary {
    public static final int $stable = 8;
    private boolean hasMore;
    private List<CommonRichMsg> summary;

    public CommonCellSummary() {
        List<CommonRichMsg> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.summary = emptyList;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<CommonRichMsg> getSummary() {
        return this.summary;
    }

    public final void setHasMore(boolean z16) {
        this.hasMore = z16;
    }

    public final void setSummary(List<CommonRichMsg> list) {
        this.summary = list;
    }
}
