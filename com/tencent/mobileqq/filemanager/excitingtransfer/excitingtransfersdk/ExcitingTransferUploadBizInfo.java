package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.commonsdk.util.HexUtil;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUploadBizInfo {
    public byte[] bufBusinessExt;
    public byte[] bufSig;
    public byte[] bufUploadKey;
    public byte[] bufUuid;
    public String clientVer;
    public String terminalVer;
    public ExcitingTransferHostInfo[] vecFtnLanIpV4AndPorts;
    public ExcitingTransferHostInfo[] vecFtnLanIpV6AndPorts;
    public int commandId = 0;
    public int businessType = 0;
    public int chateType = 4;
    public long senderUin = 0;
    public long receiverUin = 0;
    public long groupCode = 0;
    public int dangerLevel = 0;
    public long totalSpace = 0;
    public int clientType = 0;
    public int terminalType = 0;
    public boolean bUseMediaPlatform = false;

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("commandId:");
        sb5.append(this.commandId);
        sb5.append(" businessType:");
        sb5.append(this.businessType);
        sb5.append(" chateType:");
        sb5.append(this.chateType);
        sb5.append(" senderUin:");
        sb5.append(this.senderUin);
        sb5.append(" receiverUin:");
        sb5.append(this.receiverUin);
        sb5.append(" groupCode:");
        sb5.append(this.groupCode);
        sb5.append(" client_type:");
        sb5.append(this.clientType);
        sb5.append(" client_ver:");
        sb5.append(this.clientVer);
        sb5.append(" bUseMediaPlatform:");
        sb5.append(this.bUseMediaPlatform);
        sb5.append(" bufSig:");
        sb5.append(HexUtil.bytes2HexStr(this.bufSig));
        sb5.append(" bufUuid:");
        sb5.append(HexUtil.bytes2HexStr(this.bufUuid));
        sb5.append(" bufUploadKey:");
        sb5.append(HexUtil.bytes2HexStr(this.bufUploadKey));
        sb5.append(" bufBusinessExt_l:");
        byte[] bArr = this.bufBusinessExt;
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        return sb5.toString();
    }
}
