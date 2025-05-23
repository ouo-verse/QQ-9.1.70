package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveEnterRoomRequest {
    public String bypassData;
    public String channelId;
    public String extData;
    public ArrayList<String> formats;
    public String fromSource;
    public String machineCode;
    public String programId;
    public String programNewId;
    public Long roomId;

    public String getBypassData() {
        return this.bypassData;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getExtData() {
        return this.extData;
    }

    public ArrayList<String> getFormats() {
        return this.formats;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public String getMachineCode() {
        return this.machineCode;
    }

    public String getProgramId() {
        return this.programId;
    }

    public String getProgramNewId() {
        return this.programNewId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProLiveEnterRoomRequest{roomId=" + this.roomId + ",machineCode=" + this.machineCode + ",fromSource=" + this.fromSource + ",formats=" + this.formats + ",extData=" + this.extData + ",programId=" + this.programId + ",channelId=" + this.channelId + ",bypassData=" + this.bypassData + ",programNewId=" + this.programNewId + ",}";
    }
}
