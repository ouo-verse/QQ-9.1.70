package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellComment;", "", "()V", "comments", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", WidgetCacheConstellationData.NUM, "", "getNum", "()I", "setNum", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellComment {
    public static final int $stable = 8;
    private List<CommonComment> comments = new ArrayList();
    private int num;

    public final List<CommonComment> getComments() {
        return this.comments;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setComments(List<CommonComment> list) {
        this.comments = list;
    }

    public final void setNum(int i3) {
        this.num = i3;
    }
}
