package com.tencent.mm.opensdk.diffdev;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
