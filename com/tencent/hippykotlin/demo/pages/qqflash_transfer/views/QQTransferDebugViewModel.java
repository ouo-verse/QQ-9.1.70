package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.ntcompose.lifecycle.viewmodel.g;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQTransferDebugViewModel extends g {
    public static final Companion Companion = new Companion();
    public int customExpireTime;
    public final MutableState<Integer> isCustomExpireTimeOn;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class Companion {
    }

    public QQTransferDebugViewModel() {
        MutableState<Integer> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.isCustomExpireTimeOn = mutableStateOf$default;
    }
}
