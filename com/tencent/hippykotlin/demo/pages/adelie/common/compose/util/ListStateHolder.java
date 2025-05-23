package com.tencent.hippykotlin.demo.pages.adelie.common.compose.util;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ListStateHolder<T> {
    public final SnapshotStateList<T> _stateList = SnapshotStateKt.mutableStateListOf();

    public final void updateValueList(List<? extends T> list) {
        this._stateList.clear();
        this._stateList.addAll(list);
    }
}
