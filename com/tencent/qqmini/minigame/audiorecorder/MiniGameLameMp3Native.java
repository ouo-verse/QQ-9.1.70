package com.tencent.qqmini.minigame.audiorecorder;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGameLameMp3Native {
    public static native void close();

    public static native int encode(short[] sArr, short[] sArr2, int i3, byte[] bArr);

    public static native int flush(byte[] bArr);

    public static void init(int i3, int i16, int i17, int i18) {
        init(i3, i16, i17, i18, 7);
    }

    public static native void init(int i3, int i16, int i17, int i18, int i19);

    public static void jniClose() {
        close();
    }

    public static int jniEncode(short[] sArr, short[] sArr2, int i3, byte[] bArr) {
        return encode(sArr, sArr2, i3, bArr);
    }

    public static int jniFlush(byte[] bArr) {
        return flush(bArr);
    }

    public static void jniInit(int i3, int i16, int i17, int i18, int i19) {
        init(i3, i16, i17, i18, i19);
    }
}
