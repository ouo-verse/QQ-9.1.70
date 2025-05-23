package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ak extends h {

    /* renamed from: a, reason: collision with root package name */
    private MotionEvent f86147a;

    /* renamed from: b, reason: collision with root package name */
    private String f86148b;

    public ak(String str, MotionEvent motionEvent) {
        this.f86148b = str;
        this.f86147a = motionEvent;
    }

    public MotionEvent a() {
        return this.f86147a;
    }

    public String b() {
        return this.f86148b;
    }
}
