package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GLVideoClipUtil {

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f66536l;

    /* renamed from: m, reason: collision with root package name */
    private static float[] f66537m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f66538n;

    /* renamed from: o, reason: collision with root package name */
    private static final FloatBuffer f66539o;

    /* renamed from: p, reason: collision with root package name */
    private static int f66540p;

    /* renamed from: a, reason: collision with root package name */
    private int[] f66541a = new int[1];

    /* renamed from: b, reason: collision with root package name */
    private int[] f66542b = new int[2];

    /* renamed from: c, reason: collision with root package name */
    public int f66543c = 0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f66544d = new float[16];

    /* renamed from: e, reason: collision with root package name */
    private int f66545e = 125;

    /* renamed from: f, reason: collision with root package name */
    private final int f66546f = 256;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f66547g = new int[256];

    /* renamed from: h, reason: collision with root package name */
    public int f66548h = 0;

    /* renamed from: i, reason: collision with root package name */
    private a f66549i = new a();

    /* renamed from: j, reason: collision with root package name */
    private ByteBuffer[] f66550j = new ByteBuffer[2];

    /* renamed from: k, reason: collision with root package name */
    private AtomicBoolean f66551k = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        public int f66552a = 0;

        a() {
        }
    }

    public static boolean a() {
        return f66540p > 0;
    }

    private native int allocNativeMemory(int i3, int i16, int i17, ByteBuffer[] byteBufferArr);

    private native int getNativeSize();

    private native int initClipSpec(int i3, int i16);

    public native int memoryCopy(byte[] bArr);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        f66536l = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
        f66537m = fArr2;
        int length = (fArr.length * 4) + (fArr2.length * 4);
        f66538n = length;
        f66539o = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        f66540p = -1;
    }
}
