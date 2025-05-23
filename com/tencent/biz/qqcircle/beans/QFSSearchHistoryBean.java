package com.tencent.biz.qqcircle.beans;

import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchHistoryBean extends QCircleInitBean {
    private List<QFSSearchHistoryItemInfo> mHistoryList;

    public List<QFSSearchHistoryItemInfo> getHistoryList() {
        return this.mHistoryList;
    }

    public void setHistoryList(List<QFSSearchHistoryItemInfo> list) {
        this.mHistoryList = list;
    }
}
