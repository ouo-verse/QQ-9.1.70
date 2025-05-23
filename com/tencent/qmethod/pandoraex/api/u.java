package com.tencent.qmethod.pandoraex.api;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class u {

    @NotNull
    public LinkedHashSet<yr3.c> C;
    public List<String> D;

    /* renamed from: a, reason: collision with root package name */
    public String f343964a;

    /* renamed from: b, reason: collision with root package name */
    public String f343965b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f343966c;

    /* renamed from: d, reason: collision with root package name */
    public String f343967d;

    /* renamed from: e, reason: collision with root package name */
    public String f343968e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343969f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343970g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f343971h;

    /* renamed from: i, reason: collision with root package name */
    public long f343972i;

    /* renamed from: j, reason: collision with root package name */
    public long f343973j;

    /* renamed from: k, reason: collision with root package name */
    public long f343974k;

    /* renamed from: l, reason: collision with root package name */
    public long f343975l;

    /* renamed from: m, reason: collision with root package name */
    public c f343976m;

    /* renamed from: n, reason: collision with root package name */
    public long f343977n;

    /* renamed from: o, reason: collision with root package name */
    public String f343978o;

    /* renamed from: p, reason: collision with root package name */
    public String f343979p;

    /* renamed from: q, reason: collision with root package name */
    public List<t> f343980q;

    /* renamed from: r, reason: collision with root package name */
    public s[] f343981r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f343982s;

    /* renamed from: w, reason: collision with root package name */
    public JSONObject f343986w;

    /* renamed from: t, reason: collision with root package name */
    public int f343983t = 1;

    /* renamed from: u, reason: collision with root package name */
    public String f343984u = "";

    /* renamed from: v, reason: collision with root package name */
    public boolean f343985v = false;

    /* renamed from: x, reason: collision with root package name */
    public int f343987x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f343988y = 0;

    /* renamed from: z, reason: collision with root package name */
    public int f343989z = 0;
    public String A = "";
    public boolean B = false;
    public int E = 100;

    public u(String str, String str2) {
        this.f343964a = str;
        this.f343965b = str2;
    }

    public boolean a() {
        return false;
    }

    public String toString() {
        return "CurrentStrategy{moduleName[" + this.f343964a + "], apiName[" + this.f343965b + "], permission[" + Arrays.toString(this.f343966c) + "], count[" + this.f343983t + "], scene[" + this.f343967d + "], strategy[" + this.f343968e + "], isAgreed[" + this.f343971h + "], isAppForeground[" + this.f343970g + "], isCallSystemApi[" + this.f343969f + "], cacheTime[" + this.f343972i + "], silenceTime[" + this.f343973j + "], actualSilenceTime[" + this.f343974k + "], backgroundTime[" + this.f343975l + "], highFreq[" + this.f343976m + "], time[" + this.f343977n + "], overCallTimes[" + this.f343987x + "], sdkVersion[" + this.f343978o + "], processName[" + this.f343979p + "], reportStackItems[" + this.f343980q + "], currentPages[" + Arrays.toString(this.f343982s) + "], recentScenes[" + Arrays.toString(this.f343981r) + "], exInfo[" + this.f343986w + "], nextAppStatus[" + this.f343988y + "], nextIntervalTime[" + this.f343989z + "], reportType[" + this.f343984u + "], constitution=[" + this.f343985v + "], splitModules[" + this.C + "]], shipTag[" + this.A + "], splitPermissions[" + this.D + "]}";
    }
}
