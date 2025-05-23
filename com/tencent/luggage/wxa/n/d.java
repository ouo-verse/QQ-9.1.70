package com.tencent.luggage.wxa.n;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f134912a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Exception {
        public a(int i3, int i16, int i17) {
            super("Unhandled format: " + i3 + " Hz, " + i16 + " channels in encoding " + i17);
        }
    }

    ByteBuffer a();

    void a(ByteBuffer byteBuffer);

    boolean a(int i3, int i16, int i17);

    boolean b();

    int c();

    int d();

    void e();

    void flush();

    boolean isActive();

    void reset();
}
