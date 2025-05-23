package oicq.wlogin_sdk.pow;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f422798a;

    /* renamed from: b, reason: collision with root package name */
    public int f422799b;

    /* renamed from: c, reason: collision with root package name */
    public int f422800c;

    /* renamed from: d, reason: collision with root package name */
    public int f422801d;

    /* renamed from: e, reason: collision with root package name */
    public int f422802e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f422803f;

    /* renamed from: g, reason: collision with root package name */
    public int f422804g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f422805h;

    /* renamed from: i, reason: collision with root package name */
    public int f422806i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f422807j;

    /* renamed from: k, reason: collision with root package name */
    public int f422808k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f422809l;

    /* renamed from: m, reason: collision with root package name */
    public int f422810m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f422811n;

    /* renamed from: o, reason: collision with root package name */
    public int f422812o;

    /* renamed from: p, reason: collision with root package name */
    public int f422813p;

    public int a(byte b16, byte b17) {
        return ByteBuffer.wrap(new byte[]{b16, b17}).getShort();
    }

    public int a(byte[] bArr, int i3) {
        return ByteBuffer.wrap(new byte[]{bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]}).getInt();
    }
}
