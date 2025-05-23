package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    private final ViewStub f62392d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f62393e = false;

    /* renamed from: f, reason: collision with root package name */
    private Queue<Runnable> f62394f = new LinkedList();

    public a(ViewStub viewStub) {
        this.f62392d = viewStub;
    }

    private void h() {
        while (true) {
            Runnable poll = this.f62394f.poll();
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
    public final void i() {
        if (this.f62393e) {
            return;
        }
        View inflate = this.f62392d.inflate();
        this.f62393e = true;
        l(inflate);
        h();
    }

    public ViewStub j() {
        return this.f62392d;
    }

    public boolean k() {
        return this.f62393e;
    }

    protected abstract void l(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Runnable runnable) {
        if (this.f62393e) {
            runnable.run();
        } else if (runnable != null) {
            this.f62394f.add(runnable);
        }
    }
}
