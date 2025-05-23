package com.tencent.luggage.wxa.l0;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f132782a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f132783b;

    /* renamed from: c, reason: collision with root package name */
    public final long f132784c;

    /* renamed from: d, reason: collision with root package name */
    public final long f132785d;

    /* renamed from: e, reason: collision with root package name */
    public final long f132786e;

    /* renamed from: f, reason: collision with root package name */
    public final String f132787f;

    /* renamed from: g, reason: collision with root package name */
    public final int f132788g;

    public j(Uri uri) {
        this(uri, 0);
    }

    public boolean a(int i3) {
        return (this.f132788g & i3) == i3;
    }

    public String toString() {
        return "DataSpec[" + this.f132782a + ", " + Arrays.toString(this.f132783b) + ", " + this.f132784c + ", " + this.f132785d + ", " + this.f132786e + ", " + this.f132787f + ", " + this.f132788g + "]";
    }

    public j(Uri uri, int i3) {
        this(uri, 0L, -1L, null, i3);
    }

    public j a(long j3) {
        long j16 = this.f132786e;
        return a(j3, j16 != -1 ? j16 - j3 : -1L);
    }

    public j(Uri uri, long j3, long j16, String str) {
        this(uri, j3, j3, j16, str, 0);
    }

    public j a(long j3, long j16) {
        return (j3 == 0 && this.f132786e == j16) ? this : new j(this.f132782a, this.f132783b, this.f132784c + j3, this.f132785d + j3, j16, this.f132787f, this.f132788g);
    }

    public j(Uri uri, long j3, long j16, String str, int i3) {
        this(uri, j3, j3, j16, str, i3);
    }

    public j(Uri uri, long j3, long j16, long j17, String str, int i3) {
        this(uri, null, j3, j16, j17, str, i3);
    }

    public j(Uri uri, byte[] bArr, long j3, long j16, long j17, String str, int i3) {
        boolean z16 = true;
        com.tencent.luggage.wxa.n0.a.a(j3 >= 0);
        com.tencent.luggage.wxa.n0.a.a(j16 >= 0);
        if (j17 <= 0 && j17 != -1) {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.a(z16);
        this.f132782a = uri;
        this.f132783b = bArr;
        this.f132784c = j3;
        this.f132785d = j16;
        this.f132786e = j17;
        this.f132787f = str;
        this.f132788g = i3;
    }
}
