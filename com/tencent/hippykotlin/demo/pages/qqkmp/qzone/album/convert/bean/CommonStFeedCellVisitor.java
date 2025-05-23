package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStFeedCellVisitor;", "", "()V", "viewNum", "", "getViewNum", "()I", "setViewNum", "(I)V", "visitorNum", "getVisitorNum", "setVisitorNum", "visitors", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getVisitors", "()Ljava/util/List;", "setVisitors", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStFeedCellVisitor {
    public static final int $stable = 8;
    private int viewNum;
    private int visitorNum;
    private List<CommonStUser> visitors = new ArrayList();

    public final int getViewNum() {
        return this.viewNum;
    }

    public final int getVisitorNum() {
        return this.visitorNum;
    }

    public final List<CommonStUser> getVisitors() {
        return this.visitors;
    }

    public final void setViewNum(int i3) {
        this.viewNum = i3;
    }

    public final void setVisitorNum(int i3) {
        this.visitorNum = i3;
    }

    public final void setVisitors(List<CommonStUser> list) {
        this.visitors = list;
    }
}
