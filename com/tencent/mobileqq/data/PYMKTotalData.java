package com.tencent.mobileqq.data;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes10.dex */
public class PYMKTotalData {
    public CopyOnWriteArrayList<MayKnowRecommend> mayKnowRecommends;
    public CopyOnWriteArrayList<PYMKBizEntryInfo> pymkBizEntryInfos;

    public PYMKTotalData() {
        this.pymkBizEntryInfos = new CopyOnWriteArrayList<>();
        this.mayKnowRecommends = new CopyOnWriteArrayList<>();
    }

    public PYMKTotalData(CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList, CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2) {
        this.pymkBizEntryInfos = new CopyOnWriteArrayList<>();
        this.mayKnowRecommends = new CopyOnWriteArrayList<>();
        if (copyOnWriteArrayList2 != null) {
            this.mayKnowRecommends = copyOnWriteArrayList2;
        }
        if (copyOnWriteArrayList != null) {
            this.pymkBizEntryInfos = copyOnWriteArrayList;
        }
    }
}
