package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TabViewModel<T extends FeedListViewModel> {
    public float lastListScrollOffsetYForMainList;
    public final MutableState<Float> listContentHeight;
    public final MutableState<Float> listOffsetY;
    public String tabTitle = "";

    public TabViewModel() {
        MutableState<Float> mutableStateOf$default;
        MutableState<Float> mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(800.0f), null, 2, null);
        this.listContentHeight = mutableStateOf$default;
        SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.listOffsetY = mutableStateOf$default2;
    }
}
