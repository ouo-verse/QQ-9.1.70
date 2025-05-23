package com.wx.voice.vad;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WXVad {
    private long handle = 0;
    private WXVadNative gmmvad_inst = new WXVadNative();

    public WXVadData GetOnlineProcessDataSize() {
        long j3 = this.handle;
        if (j3 == 0) {
            WXVadData wXVadData = new WXVadData();
            wXVadData.RET_STATE = 1;
            return wXVadData;
        }
        return this.gmmvad_inst.GetOnlineProcessDataSize(j3);
    }

    public int Init(String str, String str2) {
        long Init = this.gmmvad_inst.Init(str, str2);
        this.handle = Init;
        return Init == 0 ? 1 : 0;
    }

    public WXVadData OfflineProcess(short[] sArr, long j3) {
        long j16 = this.handle;
        if (j16 == 0) {
            WXVadData wXVadData = new WXVadData();
            wXVadData.RET_STATE = 1;
            return wXVadData;
        }
        return this.gmmvad_inst.OfflineProcess(j16, sArr, j3);
    }

    public WXVadData OnlineProcess(short[] sArr, long j3, int i3) {
        long j16 = this.handle;
        if (j16 == 0) {
            WXVadData wXVadData = new WXVadData();
            wXVadData.RET_STATE = 1;
            return wXVadData;
        }
        return this.gmmvad_inst.OnlineProcess(j16, sArr, j3, i3);
    }

    public int Release() {
        long j3 = this.handle;
        if (j3 == 0) {
            return 1;
        }
        return this.gmmvad_inst.Release(j3);
    }

    public int Reset() {
        long j3 = this.handle;
        if (j3 == 0) {
            return 1;
        }
        return this.gmmvad_inst.Reset(j3);
    }

    public int Init(WXVadParam wXVadParam) {
        long InitUserParam = this.gmmvad_inst.InitUserParam(wXVadParam);
        this.handle = InitUserParam;
        return InitUserParam == 0 ? 1 : 0;
    }
}
