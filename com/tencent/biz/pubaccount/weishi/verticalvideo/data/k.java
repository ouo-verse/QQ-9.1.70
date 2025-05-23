package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends jz.a {

    /* renamed from: c, reason: collision with root package name */
    private final int f82022c;

    /* renamed from: d, reason: collision with root package name */
    private String f82023d;

    /* renamed from: e, reason: collision with root package name */
    private String f82024e;

    /* renamed from: f, reason: collision with root package name */
    private Object f82025f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<String> f82026g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Integer> f82027h;

    public k(int i3, boolean z16, boolean z17) {
        super(z17, z16);
        this.f82023d = "";
        this.f82024e = "";
        this.f82022c = i3;
    }

    public ArrayList<String> c() {
        return this.f82026g;
    }

    public Object d() {
        return this.f82025f;
    }

    public String e() {
        return this.f82023d;
    }

    public int f() {
        return this.f82022c;
    }

    public String g() {
        return this.f82024e;
    }

    public Map<String, Integer> h() {
        Map<String, Integer> map = this.f82027h;
        return map != null ? map : new HashMap();
    }

    public boolean i() {
        return a();
    }

    public boolean j() {
        return b();
    }

    public k k(ArrayList<String> arrayList) {
        this.f82026g = arrayList;
        return this;
    }

    public k l(Object obj) {
        this.f82025f = obj;
        return this;
    }

    public k m(String str) {
        if (!i()) {
            str = "";
        }
        this.f82023d = str;
        return this;
    }

    public k n(String str) {
        this.f82024e = str;
        return this;
    }

    public k o(Map<String, Integer> map) {
        this.f82027h = map;
        return this;
    }

    public String toString() {
        return "WSVerticalRequestParams{mScene=" + this.f82022c + ", mIsRefresh=" + b() + ", mIsFirst=" + a() + ", mPushInfo='" + this.f82023d + "', mContextFeedIds=" + this.f82026g + '}';
    }
}
