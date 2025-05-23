package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellTitle;", "", "()V", "title", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "getTitle", "()Ljava/util/List;", "setTitle", "(Ljava/util/List;)V", "titleUrl", "", "getTitleUrl", "()Ljava/lang/String;", "setTitleUrl", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellTitle {
    public static final int $stable = 8;
    private List<CommonRichMsg> title;
    private String titleUrl;

    public CommonCellTitle() {
        List<CommonRichMsg> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.title = emptyList;
    }

    public final List<CommonRichMsg> getTitle() {
        return this.title;
    }

    public final String getTitleUrl() {
        return this.titleUrl;
    }

    public final void setTitle(List<CommonRichMsg> list) {
        this.title = list;
    }

    public final void setTitleUrl(String str) {
        this.titleUrl = str;
    }
}
