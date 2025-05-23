package com.tencent.mobileqq.tvideo.binge.data;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoBingeWatchUiData {
    private final String cid;

    @TVideoBingeWatchUiState
    private final int uiState;

    public TVideoBingeWatchUiData(String str, @TVideoBingeWatchUiState int i3) {
        this.cid = str;
        this.uiState = i3;
    }

    public String getCid() {
        return this.cid;
    }

    @TVideoBingeWatchUiState
    public int getUiState() {
        return this.uiState;
    }
}
