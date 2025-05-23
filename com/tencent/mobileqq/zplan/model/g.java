package com.tencent.mobileqq.zplan.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f334838a;

    /* renamed from: b, reason: collision with root package name */
    private String f334839b;

    /* renamed from: c, reason: collision with root package name */
    private long f334840c;

    /* renamed from: d, reason: collision with root package name */
    private int f334841d;

    /* renamed from: e, reason: collision with root package name */
    private int f334842e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f334843f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f334844g;

    public g() {
        this.f334843f = new HashMap();
        this.f334844g = false;
    }

    public String a() {
        if (this.f334842e != 5) {
            return null;
        }
        return this.f334843f.get("name");
    }

    public String b() {
        return this.f334839b;
    }

    public boolean c() {
        return this.f334844g;
    }

    public int d() {
        return this.f334842e;
    }

    public int e() {
        return this.f334841d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        g gVar = (g) obj;
        if (TextUtils.equals(this.f334838a, gVar.f334838a) && TextUtils.equals(this.f334839b, gVar.f334839b)) {
            return true;
        }
        return false;
    }

    public String f() {
        if (this.f334842e != 5) {
            return null;
        }
        return this.f334843f.get("jumpURL");
    }

    public String g(Boolean bool) {
        if (bool.booleanValue() && !TextUtils.isEmpty(this.f334839b)) {
            return this.f334839b;
        }
        return this.f334838a;
    }

    public long h() {
        return this.f334840c;
    }

    public String i() {
        return this.f334838a;
    }

    @Nullable
    public String j(Boolean bool) {
        if (this.f334842e != 5) {
            return null;
        }
        if (bool.booleanValue()) {
            return this.f334843f.get("videoDarkURL");
        }
        return this.f334843f.get("videoLightURL");
    }

    public boolean k() {
        if (this.f334842e == 5 && !m() && l()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        String str;
        if (this.f334842e != 5 || (str = this.f334843f.get("isActivityTime")) == null || !str.equals("1")) {
            return false;
        }
        return true;
    }

    public boolean m() {
        String str;
        if (this.f334842e != 5 || (str = this.f334843f.get("isBought")) == null || !str.equals("1")) {
            return false;
        }
        return true;
    }

    public boolean n() {
        int i3 = this.f334842e;
        if (i3 != 4 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean o() {
        if (this.f334842e == 5 && !m() && !l()) {
            return true;
        }
        return false;
    }

    public void p(boolean z16) {
        this.f334844g = z16;
    }

    public void q(int i3) {
        this.f334841d = i3;
    }

    public void r(long j3) {
        this.f334840c = j3;
    }

    public String toString() {
        return "ZPlanBgInfo{url='" + this.f334838a + "', darkUrl='" + this.f334839b + "', updateTime=" + this.f334840c + ", isSelect=" + this.f334841d + ", imageType=" + this.f334842e + ", extinfos size=" + this.f334843f.size() + '}';
    }

    public g(String str, String str2, long j3, int i3, int i16, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.f334843f = hashMap;
        this.f334844g = false;
        this.f334838a = str;
        this.f334839b = str2;
        this.f334840c = j3;
        this.f334841d = i3;
        this.f334842e = i16;
        if (map == null || map.size() <= 0) {
            return;
        }
        hashMap.putAll(map);
    }
}
