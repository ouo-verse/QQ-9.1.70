package com.tencent.qphone.base.remote;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ServiceMsgWrapper {
    private static final String TAG = "MSF.S.ServiceMsgWrapper";
    private FromServiceMsg fromServiceMsg;
    private byte[] tmpWupBuffer;
    private ToServiceMsg toServiceMsg;
    private int totalLength;
    private int hasTransLength = 0;
    private ArrayList<Integer> hasTransIndex = new ArrayList<>();

    public ServiceMsgWrapper(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3) {
        this.toServiceMsg = toServiceMsg;
        this.fromServiceMsg = fromServiceMsg;
        this.totalLength = i3;
        this.tmpWupBuffer = new byte[i3];
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "construct ServiceMsgWrapper: cmd = " + fromServiceMsg.getServiceCmd() + ", totalLength = " + i3);
        }
    }

    public synchronized boolean buildFromMsgWupBuffer(int i3, byte[] bArr) {
        if (i3 < this.hasTransLength) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "buildFromMsgWupBuffer but the startIndex has trans, startIndex = " + i3);
            }
            return false;
        }
        if (this.hasTransIndex.contains(Integer.valueOf(i3))) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "buildFromMsgWupBuffer but the index " + i3 + " repeat");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "buildFromMsgWupBuffer: cmd = " + this.fromServiceMsg.getServiceCmd() + ", hasTransLength = " + this.hasTransLength + ", startIndex = " + i3 + ", buffer.length = " + bArr.length);
        }
        int i16 = this.hasTransLength;
        if (bArr.length + i16 > this.totalLength) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "buildFromMsgWupBuffer fail with index out of bound");
            }
            return false;
        }
        this.hasTransLength = i16 + bArr.length;
        this.hasTransIndex.add(Integer.valueOf(i3));
        System.arraycopy(bArr, 0, this.tmpWupBuffer, i3, bArr.length);
        if (isFinishTransported()) {
            this.fromServiceMsg.putWupBuffer(this.tmpWupBuffer);
        }
        return true;
    }

    public FromServiceMsg getFromServiceMsg() {
        return this.fromServiceMsg;
    }

    public ToServiceMsg getToServiceMsg() {
        return this.toServiceMsg;
    }

    public boolean isFinishTransported() {
        if (this.hasTransLength == this.totalLength) {
            return true;
        }
        return false;
    }
}
