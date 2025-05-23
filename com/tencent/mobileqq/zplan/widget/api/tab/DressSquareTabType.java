package com.tencent.mobileqq.zplan.widget.api.tab;

import com.tencent.lbssearch.object.result.DrivingResultObject;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/api/tab/DressSquareTabType;", "", "tabName", "", "listType", "", "tabKey", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getListType", "()I", "getTabKey", "()Ljava/lang/String;", "getTabName", "FOLLOW", DrivingResultObject.RECOMMEND, "COMMUNITY", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum DressSquareTabType {
    FOLLOW("\u5173\u6ce8", 1, "follow"),
    RECOMMEND("\u63a8\u8350", 2, "recommend"),
    COMMUNITY("\u793e\u533a", 2, "community");

    private final int listType;
    private final String tabKey;
    private final String tabName;

    DressSquareTabType(String str, int i3, String str2) {
        this.tabName = str;
        this.listType = i3;
        this.tabKey = str2;
    }

    public final int getListType() {
        return this.listType;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public final String getTabName() {
        return this.tabName;
    }
}
