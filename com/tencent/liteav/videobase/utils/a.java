package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<Runnable> f119370a = new LinkedList<>();

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f119370a) {
            if (!this.f119370a.isEmpty()) {
                linkedList = new LinkedList(this.f119370a);
                this.f119370a.clear();
            } else {
                linkedList = null;
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }
}
