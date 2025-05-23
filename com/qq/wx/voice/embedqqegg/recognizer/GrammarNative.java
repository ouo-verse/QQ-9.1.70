package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GrammarNative {
    public static native int begin();

    public static native int destroy();

    public static native int end();

    public static native int getResult(Grammar grammar);

    public static native int getVersion(Grammar grammar);

    public static native int init(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int recognize(byte[] bArr, int i3);

    public static native int setKeywordSetIndex(int i3);

    public static native int setTranThres(int i3);
}
