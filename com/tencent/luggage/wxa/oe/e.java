package com.tencent.luggage.wxa.oe;

import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ParcelUuid f136381a;

    /* renamed from: b, reason: collision with root package name */
    public static final ParcelUuid f136382b;

    /* renamed from: c, reason: collision with root package name */
    public static final ParcelUuid f136383c;

    /* renamed from: d, reason: collision with root package name */
    public static final ParcelUuid f136384d;

    /* renamed from: e, reason: collision with root package name */
    public static final ParcelUuid f136385e;

    /* renamed from: f, reason: collision with root package name */
    public static final ParcelUuid f136386f;

    /* renamed from: g, reason: collision with root package name */
    public static final ParcelUuid f136387g;

    /* renamed from: h, reason: collision with root package name */
    public static final ParcelUuid f136388h;

    /* renamed from: i, reason: collision with root package name */
    public static final ParcelUuid f136389i;

    /* renamed from: j, reason: collision with root package name */
    public static final ParcelUuid f136390j;

    /* renamed from: k, reason: collision with root package name */
    public static final ParcelUuid f136391k;

    /* renamed from: l, reason: collision with root package name */
    public static final ParcelUuid f136392l;

    /* renamed from: m, reason: collision with root package name */
    public static final ParcelUuid f136393m;

    /* renamed from: n, reason: collision with root package name */
    public static final ParcelUuid f136394n;

    /* renamed from: o, reason: collision with root package name */
    public static final ParcelUuid f136395o;

    /* renamed from: p, reason: collision with root package name */
    public static final ParcelUuid f136396p;

    /* renamed from: q, reason: collision with root package name */
    public static final ParcelUuid f136397q;

    /* renamed from: r, reason: collision with root package name */
    public static final ParcelUuid f136398r;

    /* renamed from: s, reason: collision with root package name */
    public static final ParcelUuid f136399s;

    /* renamed from: t, reason: collision with root package name */
    public static final ParcelUuid f136400t;

    /* renamed from: u, reason: collision with root package name */
    public static final ParcelUuid[] f136401u;

    static {
        ParcelUuid fromString = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        f136381a = fromString;
        ParcelUuid fromString2 = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        f136382b = fromString2;
        ParcelUuid fromString3 = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        f136383c = fromString3;
        ParcelUuid fromString4 = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        f136384d = fromString4;
        f136385e = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString5 = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        f136386f = fromString5;
        f136387g = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString6 = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        f136388h = fromString6;
        ParcelUuid fromString7 = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        f136389i = fromString7;
        ParcelUuid fromString8 = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        f136390j = fromString8;
        f136391k = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
        f136392l = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
        ParcelUuid fromString9 = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        f136393m = fromString9;
        ParcelUuid fromString10 = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        f136394n = fromString10;
        f136395o = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
        f136396p = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString11 = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
        f136397q = fromString11;
        ParcelUuid fromString12 = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
        f136398r = fromString12;
        ParcelUuid fromString13 = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
        f136399s = fromString13;
        f136400t = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        f136401u = new ParcelUuid[]{fromString, fromString2, fromString3, fromString4, fromString5, fromString6, fromString7, fromString8, fromString9, fromString10, fromString11, fromString12, fromString13};
    }

    public static ParcelUuid a(byte[] bArr) {
        long j3;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            }
            if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            }
            if (length == 2) {
                j3 = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
            } else {
                j3 = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
            }
            ParcelUuid parcelUuid = f136400t;
            return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j3 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }
}
