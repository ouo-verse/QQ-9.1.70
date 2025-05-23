package com.tencent.hippykotlin.demo.pages.qqflash_transfer.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.List;
import ws3.ab;
import ws3.cx;

/* loaded from: classes37.dex */
public final class DeviceStateProcessInfo {
    public cx callback;
    public String fileSetId = "";
    public List<ab> files;
    public MutableState<Boolean> isDownloadPause;
    public MutableState<Boolean> isSwitchToXgAndNoticeChanged;
    public boolean needDownloadAllFiles;
    public String notice;
    public MutableState<Boolean> showAlertDialog;
    public MutableState<Boolean> showAskDialog;

    public DeviceStateProcessInfo() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showAskDialog = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showAlertDialog = mutableStateOf$default2;
        this.notice = "";
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isSwitchToXgAndNoticeChanged = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isDownloadPause = mutableStateOf$default4;
    }
}
