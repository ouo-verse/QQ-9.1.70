package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import e25.af;

/* loaded from: classes37.dex */
public final class LevelProgressModel {
    public MutableState<Float> heightProgress;
    public MutableState<af> treeProgress;

    public LevelProgressModel() {
        MutableState<Float> mutableStateOf$default;
        MutableState<af> mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.heightProgress = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new af(0.0f, 0.0f, null, null, 0L, 0.0f, 0L, 127, null), null, 2, null);
        this.treeProgress = mutableStateOf$default2;
    }
}
