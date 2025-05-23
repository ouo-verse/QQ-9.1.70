package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f303785a;

    /* renamed from: b, reason: collision with root package name */
    private String f303786b;

    /* renamed from: c, reason: collision with root package name */
    private String f303787c;

    /* renamed from: d, reason: collision with root package name */
    private String f303788d;

    /* renamed from: e, reason: collision with root package name */
    private int f303789e;

    /* renamed from: f, reason: collision with root package name */
    private String f303790f;

    /* renamed from: g, reason: collision with root package name */
    private String f303791g;

    /* renamed from: h, reason: collision with root package name */
    private String f303792h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f303793i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    @QADDownloadSceneType
    private int f303794j = 0;

    public void a(String str, Object obj) {
        this.f303793i.put(str, obj);
    }

    public String b() {
        return this.f303785a;
    }

    public Map<String, Object> c() {
        return this.f303793i;
    }

    public String d() {
        return this.f303788d;
    }

    public String e() {
        return this.f303786b;
    }

    public void f(String str) {
        this.f303787c = str;
    }

    public void g(String str) {
        this.f303790f = str;
    }

    public void h(String str) {
        this.f303785a = str;
    }

    public void i(String str) {
        this.f303791g = str;
    }

    public void j(String str) {
        this.f303788d = str;
    }

    public void k(String str) {
        this.f303792h = str;
    }

    public void l(String str) {
        this.f303786b = str;
    }

    public void m(@QADDownloadSceneType int i3) {
        this.f303794j = i3;
    }

    public void n(int i3) {
        this.f303789e = i3;
    }
}
