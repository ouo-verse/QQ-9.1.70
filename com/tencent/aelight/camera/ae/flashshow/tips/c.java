package com.tencent.aelight.camera.ae.flashshow.tips;

import android.view.View;
import android.view.ViewStub;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private final ViewStub f64403a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f64404b = false;

    /* renamed from: c, reason: collision with root package name */
    private Queue<Runnable> f64405c = new LinkedList();

    public c(ViewStub viewStub) {
        this.f64403a = viewStub;
    }

    private void b() {
        while (true) {
            Runnable poll = this.f64405c.poll();
            if (poll == null) {
                return;
            }
            try {
                poll.run();
            } catch (Exception e16) {
                e16.printStackTrace();
                throw new RuntimeException("doPendingActions encounter an error", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f64404b) {
            return;
        }
        View inflate = this.f64403a.inflate();
        this.f64404b = true;
        e(inflate);
        b();
    }

    public boolean d() {
        return this.f64404b;
    }

    protected abstract void e(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Runnable runnable) {
        if (this.f64404b) {
            runnable.run();
        } else if (runnable != null) {
            this.f64405c.add(runnable);
        }
    }
}
