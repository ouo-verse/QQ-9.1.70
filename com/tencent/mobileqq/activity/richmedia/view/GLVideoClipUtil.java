package com.tencent.mobileqq.activity.richmedia.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GLVideoClipUtil {

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f186059l;

    /* renamed from: m, reason: collision with root package name */
    private static float[] f186060m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f186061n;

    /* renamed from: o, reason: collision with root package name */
    private static final FloatBuffer f186062o;

    /* renamed from: p, reason: collision with root package name */
    private static int f186063p;

    /* renamed from: a, reason: collision with root package name */
    private int[] f186064a = new int[1];

    /* renamed from: b, reason: collision with root package name */
    private int[] f186065b = new int[2];

    /* renamed from: c, reason: collision with root package name */
    public int f186066c = 0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f186067d = new float[16];

    /* renamed from: e, reason: collision with root package name */
    private int f186068e = 125;

    /* renamed from: f, reason: collision with root package name */
    private final int f186069f = 256;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f186070g = new int[256];

    /* renamed from: h, reason: collision with root package name */
    public int f186071h = 0;

    /* renamed from: i, reason: collision with root package name */
    private a f186072i = new a();

    /* renamed from: j, reason: collision with root package name */
    private ByteBuffer[] f186073j = new ByteBuffer[2];

    /* renamed from: k, reason: collision with root package name */
    private AtomicBoolean f186074k = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        public int f186075a = 0;

        a() {
        }
    }

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        f186059l = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
        f186060m = fArr2;
        int length = (fArr.length * 4) + (fArr2.length * 4);
        f186061n = length;
        f186062o = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f186063p = -1;
    }

    private native int allocNativeMemory(int i3, int i16, int i17, ByteBuffer[] byteBufferArr);

    private native int getNativeSize();

    private native int initClipSpec(int i3, int i16);

    public native int memoryCopy(byte[] bArr);
}
