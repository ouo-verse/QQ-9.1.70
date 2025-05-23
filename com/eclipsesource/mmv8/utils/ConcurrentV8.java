package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ConcurrentV8 {

    /* renamed from: v8, reason: collision with root package name */
    private V8 f32587v8;

    public ConcurrentV8() {
        this.f32587v8 = null;
        V8 createV8Runtime = V8.createV8Runtime();
        this.f32587v8 = createV8Runtime;
        createV8Runtime.getLocker().release();
    }

    public V8 getV8() {
        return this.f32587v8;
    }

    public void release() {
        V8 v85 = this.f32587v8;
        if (v85 != null && !v85.isReleased()) {
            run(new V8Runnable() { // from class: com.eclipsesource.mmv8.utils.ConcurrentV8.1
                @Override // com.eclipsesource.mmv8.utils.V8Runnable
                public void run(V8 v86) {
                    if (v86 != null && !v86.isReleased()) {
                        v86.release();
                    }
                }
            });
        }
    }

    public synchronized void run(V8Runnable v8Runnable) {
        try {
            this.f32587v8.getLocker().acquire();
            v8Runnable.run(this.f32587v8);
        } finally {
            V8 v85 = this.f32587v8;
            if (v85 != null && v85.getLocker() != null && this.f32587v8.getLocker().hasLock()) {
                this.f32587v8.getLocker().release();
            }
        }
    }
}
