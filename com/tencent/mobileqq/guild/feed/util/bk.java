package com.tencent.mobileqq.guild.feed.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public class bk implements Executor {

    /* renamed from: d, reason: collision with root package name */
    final Queue<Runnable> f223889d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    final Executor f223890e;

    /* renamed from: f, reason: collision with root package name */
    Runnable f223891f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Executor executor) {
        this.f223890e = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            c();
        }
    }

    protected synchronized void c() {
        Runnable poll = this.f223889d.poll();
        this.f223891f = poll;
        if (poll != null) {
            this.f223890e.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f223889d.add(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.bj
            @Override // java.lang.Runnable
            public final void run() {
                bk.this.b(runnable);
            }
        });
        if (this.f223891f == null) {
            c();
        }
    }
}
