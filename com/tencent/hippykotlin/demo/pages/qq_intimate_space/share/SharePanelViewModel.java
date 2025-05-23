package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;

/* loaded from: classes37.dex */
public final class SharePanelViewModel {
    public MutableState<Boolean> showPanel;

    public SharePanelViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.showPanel = mutableStateOf$default;
    }
}
