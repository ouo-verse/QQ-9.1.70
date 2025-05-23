package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import ws3.ac;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileListFilterInfo {
    public ac categoryInfo = new ac();
    public MutableState<Boolean> isSelected;

    public QQFTFileListFilterInfo() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isSelected = mutableStateOf$default;
    }
}
