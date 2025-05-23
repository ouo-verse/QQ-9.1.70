package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends DomNodeRecord {

    /* renamed from: a, reason: collision with root package name */
    public double f337378a;

    /* renamed from: b, reason: collision with root package name */
    public double f337379b;

    /* renamed from: c, reason: collision with root package name */
    public double f337380c;

    /* renamed from: d, reason: collision with root package name */
    public double f337381d;

    /* renamed from: e, reason: collision with root package name */
    public String f337382e;

    /* renamed from: f, reason: collision with root package name */
    public HippyMap f337383f;

    /* renamed from: g, reason: collision with root package name */
    public HippyMap f337384g;

    public a(int i3, int i16, int i17, int i18, String str, String str2, HippyMap hippyMap) {
        this.rootId = i3;
        this.f337371id = i16;
        this.pid = i17;
        this.index = i18;
        this.className = str;
        this.tagName = str2;
        if (hippyMap != null) {
            this.f337383f = hippyMap.getMap("style");
            this.f337382e = hippyMap.getString("text");
            this.f337384g = hippyMap.getMap("attributes");
        }
    }

    public void a(double d16, double d17, double d18, double d19) {
        this.f337378a = d16;
        this.f337379b = d17;
        this.f337380c = d18;
        this.f337381d = d19;
    }
}
