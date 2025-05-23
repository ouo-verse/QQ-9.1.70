package com.tencent.ads.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ReportClickItem implements Serializable {
    private static final long serialVersionUID = 6687233265038780146L;

    /* renamed from: a, reason: collision with root package name */
    private String f61632a;

    /* renamed from: b, reason: collision with root package name */
    private int f61633b;

    /* renamed from: c, reason: collision with root package name */
    private int f61634c;

    public ReportClickItem() {
        this.f61634c = 1;
    }

    public final int a() {
        return this.f61633b;
    }

    public final int b() {
        return this.f61634c;
    }

    public final String c() {
        return this.f61632a;
    }

    public ReportClickItem(String str, int i3, int i16) {
        this.f61632a = str;
        this.f61634c = i3;
        this.f61633b = i16;
    }

    private void a(int i3) {
        this.f61633b = i3;
    }

    private void b(int i3) {
        this.f61634c = i3;
    }

    private void a(String str) {
        this.f61632a = str;
    }
}
