package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import ws3.ab;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFailedFileInfo {
    public final MutableState downloadStatus$delegate;
    public ab failedFile = new ab();
    public final MutableState process$delegate;
    public final MutableState status$delegate;
    public final MutableState uploadStatus$delegate;

    public QQFTFailedFileInfo() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.status$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.uploadStatus$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.downloadStatus$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.process$delegate = mutableStateOf$default4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getDownloadStatus() {
        return ((Number) this.downloadStatus$delegate.getValue()).intValue();
    }

    public final void setDownloadStatus(int i3) {
        this.downloadStatus$delegate.setValue(Integer.valueOf(i3));
    }

    public final void setFailedFile(ab abVar) {
        this.failedFile = abVar;
        this.status$delegate.setValue(Integer.valueOf(abVar.A));
        this.uploadStatus$delegate.setValue(Integer.valueOf(abVar.B));
        setDownloadStatus(abVar.C);
    }
}
