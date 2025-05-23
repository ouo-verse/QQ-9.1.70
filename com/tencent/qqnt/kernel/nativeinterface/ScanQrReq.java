package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ScanQrReq {
    public QrScanScene scene = QrScanScene.values()[0];
    public byte[] qrSig = new byte[0];

    public byte[] getQrSig() {
        return this.qrSig;
    }

    public QrScanScene getScene() {
        return this.scene;
    }

    public String toString() {
        return "ScanQrReq{scene=" + this.scene + ",qrSig=" + this.qrSig + ",}";
    }
}
