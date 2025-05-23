package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import c45.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellFeedDeco;", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonBytesEntry;", "mapInfoData", "Ljava/util/List;", "getMapInfoData", "()Ljava/util/List;", "setMapInfoData", "(Ljava/util/List;)V", "Lc45/a;", "userDecoration", "Lc45/a;", "getUserDecoration", "()Lc45/a;", "setUserDecoration", "(Lc45/a;)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonCellFeedDeco {
    public static final int $stable = 8;
    private List<CommonBytesEntry> mapInfoData = new ArrayList();
    private a userDecoration;

    public final List<CommonBytesEntry> getMapInfoData() {
        return this.mapInfoData;
    }

    public final a getUserDecoration() {
        return this.userDecoration;
    }

    public final void setMapInfoData(List<CommonBytesEntry> list) {
        this.mapInfoData = list;
    }

    public final void setUserDecoration(a aVar) {
        this.userDecoration = aVar;
    }
}
