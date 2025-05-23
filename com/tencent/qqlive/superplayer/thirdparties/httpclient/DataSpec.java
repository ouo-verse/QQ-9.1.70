package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DataSpec {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f345404a;

    /* renamed from: b, reason: collision with root package name */
    public final int f345405b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final byte[] f345406c;

    /* renamed from: d, reason: collision with root package name */
    public final long f345407d;

    /* renamed from: e, reason: collision with root package name */
    public final long f345408e;

    /* renamed from: f, reason: collision with root package name */
    public final long f345409f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f345410g;

    /* renamed from: h, reason: collision with root package name */
    public final int f345411h;

    /* compiled from: P */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface Flags {
    }

    /* compiled from: P */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface HttpMethod {
    }

    public DataSpec(Uri uri, int i3, @Nullable byte[] bArr, long j3, long j16, long j17, @Nullable String str, int i16) {
        boolean z16;
        boolean z17;
        byte[] bArr2 = bArr;
        boolean z18 = true;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        a.b(z16);
        if (j16 >= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        a.b(z17);
        if (j17 <= 0 && j17 != -1) {
            z18 = false;
        }
        a.b(z18);
        this.f345404a = uri;
        this.f345405b = i3;
        this.f345406c = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f345407d = j3;
        this.f345408e = j16;
        this.f345409f = j17;
        this.f345410g = str;
        this.f345411h = i16;
    }

    public static String b(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return "DELETE";
                        }
                        throw new AssertionError(i3);
                    }
                    return HttpPut.METHOD_NAME;
                }
                return "HEAD";
            }
            return "POST";
        }
        return "GET";
    }

    public final String a() {
        return b(this.f345405b);
    }

    public boolean c(int i3) {
        if ((this.f345411h & i3) == i3) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "DataSpec[" + a() + " " + this.f345404a + ", " + Arrays.toString(this.f345406c) + ", " + this.f345407d + ", " + this.f345408e + ", " + this.f345409f + ", " + this.f345410g + ", " + this.f345411h + "]";
    }
}
