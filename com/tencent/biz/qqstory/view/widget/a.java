package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    protected ILoadMoreLayout f94522b;

    /* renamed from: d, reason: collision with root package name */
    Context f94524d;

    /* renamed from: a, reason: collision with root package name */
    protected int f94521a = 5;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f94523c = false;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.view.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0947a {
    }

    public a(ILoadMoreLayout iLoadMoreLayout, Context context) {
        this.f94522b = iLoadMoreLayout;
        this.f94524d = context;
    }

    public int a() {
        return this.f94521a;
    }

    public void b(boolean z16) {
        if (!this.f94523c || this.f94522b.getState() == 0 || !this.f94522b.checkState(2)) {
            return;
        }
        this.f94522b.setState(2);
    }
}
