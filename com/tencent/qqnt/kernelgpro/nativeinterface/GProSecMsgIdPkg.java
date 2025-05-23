package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSecMsgIdPkg {
    public boolean debugMode;
    public String messageId = "";
    public byte[] opaque = new byte[0];
    public String scene = "";

    public boolean getDebugMode() {
        return this.debugMode;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public byte[] getOpaque() {
        return this.opaque;
    }

    public String getScene() {
        return this.scene;
    }

    public String toString() {
        return "GProSecMsgIdPkg{messageId=" + this.messageId + ",opaque=" + this.opaque + ",scene=" + this.scene + ",debugMode=" + this.debugMode + ",}";
    }
}
