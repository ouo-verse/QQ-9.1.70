package com.tencent.karaoke.encodesdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a {
    public static final int BIT_MODE_CONSTANT = 0;
    public static final int BIT_MODE_HIGHT = 5;
    public static final int BIT_MODE_NORMAL = 4;
    protected InterfaceC5861a mListener;

    /* compiled from: P */
    /* renamed from: com.tencent.karaoke.encodesdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5861a {
    }

    public abstract int aacEncode(byte[] bArr, int i3);

    public abstract int init(int i3, int i16, int i17, int i18, int i19);

    public abstract int init(int i3, int i16, int i17, int i18, int i19, int i26);

    public abstract int release();

    public void setOnAacDataRecvListener(InterfaceC5861a interfaceC5861a) {
    }
}
