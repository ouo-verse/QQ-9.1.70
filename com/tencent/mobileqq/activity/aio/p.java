package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {
    public String C;
    public int N;
    public int S;
    public String T;
    public boolean W;
    public String X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public long f179552a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f179553b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f179554c0;

    /* renamed from: d, reason: collision with root package name */
    public int f179555d;

    /* renamed from: d0, reason: collision with root package name */
    private String f179556d0;

    /* renamed from: e, reason: collision with root package name */
    public String f179557e;

    /* renamed from: e0, reason: collision with root package name */
    private String f179558e0;

    /* renamed from: f, reason: collision with root package name */
    public String f179559f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f179560f0;

    /* renamed from: g0, reason: collision with root package name */
    private Bundle f179561g0;

    /* renamed from: h, reason: collision with root package name */
    public String f179562h;

    /* renamed from: i, reason: collision with root package name */
    public String f179563i;

    /* renamed from: m, reason: collision with root package name */
    public String f179564m;
    public long D = -1;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;
    public int P = 0;
    public int Q = BuddySource.DEFAULT;
    public String R = "";
    public boolean U = false;
    public boolean V = false;

    private int a(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = ((i3 * 31) + this.S) * 31;
        String str = this.T;
        int i27 = 0;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (((((((i26 + i16) * 31) + (this.U ? 1 : 0)) * 31) + (this.V ? 1 : 0)) * 31) + (this.W ? 1 : 0)) * 31;
        String str2 = this.X;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (((((i28 + i17) * 31) + this.Y) * 31) + this.Z) * 31;
        long j3 = this.f179552a0;
        int i36 = (i29 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.f179553b0;
        int i37 = (((i36 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.f179554c0 ? 1 : 0)) * 31;
        String str3 = this.f179556d0;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        String str4 = this.f179558e0;
        if (str4 != null) {
            i19 = str4.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (((i38 + i19) * 31) + (this.f179560f0 ? 1 : 0)) * 31;
        Bundle bundle = this.f179561g0;
        if (bundle != null) {
            i27 = bundle.hashCode();
        }
        return i39 + i27;
    }

    public Bundle b() {
        if (this.f179561g0 == null) {
            this.f179561g0 = new Bundle();
        }
        return this.f179561g0;
    }

    public String c() {
        return this.f179558e0;
    }

    public String e() {
        return this.f179556d0;
    }

    public void f(Bundle bundle) {
        this.f179561g0 = bundle;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = this.f179555d * 31;
        String str = this.f179557e;
        int i28 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = (i27 + i3) * 31;
        String str2 = this.f179559f;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        String str3 = this.f179562h;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        String str4 = this.f179563i;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        String str5 = this.f179564m;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        String str6 = this.C;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        long j3 = this.D;
        int i46 = (((((((((((((((((((((((((((i39 + i26) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + this.N) * 31) + this.P) * 31) + this.Q) * 31;
        String str7 = this.R;
        if (str7 != null) {
            i28 = str7.hashCode();
        }
        return a(i46 + i28);
    }

    public void j(String str) {
        this.f179558e0 = str;
    }

    public void k(String str) {
        this.f179556d0 = str;
    }
}
