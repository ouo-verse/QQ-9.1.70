package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface ITempChatSigListener {
    byte[] getTempChatSig(int i3, String str);

    void onRecvTempChatSig(int i3, String str, byte[] bArr);
}
