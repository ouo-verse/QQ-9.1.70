package com.wx.voice.vad;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WXVadData {
    public int RET_STATE;
    public long blocksize;
    public ArrayList<WXVadSeg> offline_odata;
    public short[] online_odata;

    public void OfflineOutDataAdd(WXVadSeg wXVadSeg) {
        this.offline_odata.add(wXVadSeg);
    }

    public void OfflineOutDataInit() {
        this.offline_odata = new ArrayList<>();
    }

    public void OutDataInit(int i3) {
        this.online_odata = new short[i3];
    }
}
