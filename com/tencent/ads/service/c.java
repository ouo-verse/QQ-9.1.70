package com.tencent.ads.service;

import java.net.HttpCookie;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private HttpCookie f61695a;

    /* renamed from: b, reason: collision with root package name */
    private Date f61696b;

    public c(HttpCookie httpCookie, Date date) {
        this.f61695a = httpCookie;
        this.f61696b = date;
    }

    public final HttpCookie a() {
        return this.f61695a;
    }

    public final Date b() {
        return this.f61696b;
    }

    private void a(HttpCookie httpCookie) {
        this.f61695a = httpCookie;
    }

    private void a(Date date) {
        this.f61696b = date;
    }
}
