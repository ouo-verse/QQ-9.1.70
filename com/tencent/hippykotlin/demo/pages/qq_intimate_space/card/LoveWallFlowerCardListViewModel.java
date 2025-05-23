package com.tencent.hippykotlin.demo.pages.qq_intimate_space.card;

import e25.i;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFlowerCardListViewModel {
    public final long defaultFlowerId;
    public final List<i> flowerList;

    public LoveWallFlowerCardListViewModel(List<i> list, long j3) {
        this.flowerList = list;
        this.defaultFlowerId = j3;
    }

    public final int getDefaultFlowerIndex() {
        int size = this.flowerList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.flowerList.get(i3).f395478d == this.defaultFlowerId) {
                return i3;
            }
        }
        return 0;
    }
}
