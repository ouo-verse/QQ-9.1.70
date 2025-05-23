package com.google.android.filament.utils;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RemoteServer {

    /* renamed from: a, reason: collision with root package name */
    private long f33075a;

    private static native void nAcquireReceivedMessage(long j3, ByteBuffer byteBuffer, int i3);

    private static native long nCreate(int i3);

    private static native void nDestroy(long j3);

    private static native String nPeekIncomingLabel(long j3);

    private static native int nPeekReceivedBufferLength(long j3);

    private static native String nPeekReceivedLabel(long j3);

    protected void finalize() throws Throwable {
        nDestroy(this.f33075a);
        super.finalize();
    }
}
