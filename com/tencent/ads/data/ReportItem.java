package com.tencent.ads.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ReportItem implements Serializable {
    private static final long serialVersionUID = 5592076173502819895L;

    /* renamed from: a, reason: collision with root package name */
    private String f61635a;

    /* renamed from: b, reason: collision with root package name */
    private int f61636b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f61637c = false;

    public ReportItem(String str, int i3) {
        this.f61635a = str;
        this.f61636b = i3;
    }

    public final String a() {
        return this.f61635a;
    }

    public final int b() {
        return this.f61636b;
    }

    public final boolean c() {
        return this.f61637c;
    }

    private void a(int i3) {
        this.f61636b = i3;
    }

    private void a(String str) {
        this.f61635a = str;
    }

    public final void a(boolean z16) {
        this.f61637c = z16;
    }
}
