package com.tencent.hippykotlin.demo.pages.qqfile.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.lifecycle.viewmodel.g;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileExpiringListViewModel extends g {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int fetchOffset;
    public boolean hasFetchMore;
    public boolean isFetchEnd;
    public MutableState<Boolean> isFilelistEmpty;
    public SnapshotStateList<KTFileInfo> fileInfoList = SnapshotStateKt.mutableStateListOf();
    public SnapshotStateList<KTFileDownloadStatus> fileDownloadStatusList = SnapshotStateKt.mutableStateListOf();

    public QQFileExpiringListViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isFilelistEmpty = mutableStateOf$default;
        KLog.INSTANCE.e("QQFileExpiringListViewModel", "init refreshData");
        refreshData();
    }

    public final void loadMoreData() {
        if (this.isFetchEnd || this.hasFetchMore) {
            return;
        }
        this.hasFetchMore = true;
        KLog.INSTANCE.e("QQFileExpiringListViewModel", "loadMoreData is not fetchEnd");
        BuildersKt.e(e.f117232d, null, null, new QQFileExpiringListViewModel$loadMoreData$1(this, null), 3, null);
    }

    public final void refreshData() {
        KLog.INSTANCE.e("QQFileExpiringListViewModel", "refreshData");
        this.fetchOffset = 0;
        this.isFetchEnd = false;
        loadMoreData();
    }

    public final void updateFileDownloadStatus$enumunboxing$(int i3, int i16, float f16) {
        if (i3 >= 0 && i3 < this.fileDownloadStatusList.size()) {
            this.fileDownloadStatusList.set(i3, new KTFileDownloadStatus(f16, i16));
        }
    }
}
