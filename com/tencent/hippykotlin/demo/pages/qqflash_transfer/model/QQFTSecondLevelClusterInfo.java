package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.UInt;
import ws3.j;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTSecondLevelClusterInfo {
    public SnapshotStateList<j> clusterList = SnapshotStateKt.mutableStateListOf();
    public int pollBatchSeq;
    public MutableState<UInt> totalCount;

    public QQFTSecondLevelClusterInfo() {
        MutableState<UInt> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UInt.m564boximpl(0), null, 2, null);
        this.totalCount = mutableStateOf$default;
    }
}
