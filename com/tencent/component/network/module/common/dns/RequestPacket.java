package com.tencent.component.network.module.common.dns;

/* loaded from: classes5.dex */
public class RequestPacket {
    private static byte[] header = {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0};
    private static byte[] question = {0, 0, 1, 0, 1};
    private String domain;
    private int reqId = AtomicRequestId.getInstance().getId();

    public RequestPacket(String str) {
        this.domain = str;
    }

    private void warpReqId(byte[] bArr) {
        int i3 = this.reqId;
        bArr[0] = (byte) ((i3 >>> 8) & 255);
        bArr[1] = (byte) (i3 & 255);
    }

    public byte[] getQueryData() {
        String str = this.domain;
        if (str == null) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase();
        this.domain = lowerCase;
        if (lowerCase.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[header.length + question.length + this.domain.length() + 1];
        String[] split = this.domain.split("\\.");
        int length = header.length;
        for (int i3 = 0; i3 < split.length; i3++) {
            bArr[length] = (byte) split[i3].length();
            int i16 = length + 1;
            byte[] bytes = split[i3].getBytes();
            System.arraycopy(bytes, 0, bArr, i16, bytes.length);
            length = i16 + bytes.length;
        }
        byte[] bArr2 = header;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = question;
        System.arraycopy(bArr3, 0, bArr, length, bArr3.length);
        warpReqId(bArr);
        return bArr;
    }

    public int getReqId() {
        return this.reqId;
    }

    public int getType() {
        return 1;
    }
}
