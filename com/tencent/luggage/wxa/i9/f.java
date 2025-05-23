package com.tencent.luggage.wxa.i9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public short[][] f129649a = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 1, 1);

    /* renamed from: b, reason: collision with root package name */
    public int f129650b = 1;

    /* renamed from: c, reason: collision with root package name */
    public int f129651c = 1;

    /* renamed from: d, reason: collision with root package name */
    public short[] f129652d = new short[1];

    /* renamed from: e, reason: collision with root package name */
    public int f129653e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f129654f = 32767;

    /* renamed from: g, reason: collision with root package name */
    public int f129655g = -32768;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.c9.b f129656h;

    @Override // com.tencent.luggage.wxa.i9.h
    public boolean a(com.tencent.luggage.wxa.c9.b bVar, List list) {
        if (list != null && list.size() != 0) {
            byte[][] bArr = new byte[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                bArr[i3] = ((com.tencent.luggage.wxa.c9.e) list.get(i3)).f123439f;
            }
            this.f129656h = bVar;
            byte[] a16 = a(bArr);
            if (a16 == null) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
                return false;
            }
            bVar.f123417d = a16;
            bVar.f123415b = ((com.tencent.luggage.wxa.c9.e) list.get(0)).f123436c;
            bVar.f123414a = ((com.tencent.luggage.wxa.c9.e) list.get(0)).f123435b;
            return true;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
        return false;
    }

    public abstract byte[] a(int i3, int i16, int i17);

    public byte[] a() {
        com.tencent.luggage.wxa.c9.b bVar = this.f129656h;
        if (bVar != null) {
            return bVar.f123417d;
        }
        return null;
    }

    public final byte[] a(byte[][] bArr) {
        byte[] bArr2;
        if (bArr == null || bArr.length == 0 || (bArr2 = bArr[0]) == null || bArr2.length == 0) {
            return null;
        }
        if (bArr.length == 1) {
            byte[] a16 = a();
            if (a16 == null || a16.length != bArr2.length) {
                a16 = new byte[bArr2.length];
            }
            System.arraycopy(bArr2, 0, a16, 0, bArr2.length);
            return a16;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3].length != bArr2.length) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.BaseAudioMixAlgorithm", "column of the road of audio + " + i3 + " is different.");
                return null;
            }
        }
        int length = bArr.length;
        int length2 = bArr2.length / 2;
        if (length != this.f129650b || length2 != this.f129651c) {
            this.f129649a = (short[][]) Array.newInstance((Class<?>) Short.TYPE, length, length2);
            this.f129650b = length;
            this.f129651c = length2;
        }
        for (int i16 = 0; i16 < length; i16++) {
            Arrays.fill(this.f129649a[i16], 0, length2 - 1, (short) 0);
            for (int i17 = 0; i17 < length2; i17++) {
                short[] sArr = this.f129649a[i16];
                byte[] bArr3 = bArr[i16];
                int i18 = i17 * 2;
                sArr[i17] = (short) (((bArr3[i18 + 1] & 255) << 8) | (bArr3[i18] & 255));
            }
        }
        if (this.f129653e != length2) {
            this.f129653e = length2;
            this.f129652d = new short[length2];
        }
        Arrays.fill(this.f129652d, 0, length2 - 1, (short) 0);
        return a(length, length2, bArr2.length);
    }

    @Override // com.tencent.luggage.wxa.i9.h
    public void release() {
    }

    public short a(int i3) {
        int i16 = this.f129654f;
        if (i3 > i16) {
            return (short) i16;
        }
        int i17 = this.f129655g;
        return i3 < i17 ? (short) i17 : (short) i3;
    }

    public byte[] a(int i3, int i16) {
        byte[] a16 = a();
        if (a16 == null || a16.length != i3) {
            a16 = new byte[i3];
        }
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i17 * 2;
            short s16 = this.f129652d[i17];
            a16[i18] = (byte) (s16 & 255);
            a16[i18 + 1] = (byte) ((s16 & 65280) >> 8);
        }
        return a16;
    }
}
