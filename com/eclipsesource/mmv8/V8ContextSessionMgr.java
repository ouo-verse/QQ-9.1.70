package com.eclipsesource.mmv8;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class V8ContextSessionMgr {
    private V8ContextWrapper currentContext;

    /* renamed from: v8, reason: collision with root package name */
    private final V8 f32583v8;

    public V8ContextSessionMgr(V8 v85) {
        this.f32583v8 = v85;
    }

    public void enterContext(V8ContextWrapper v8ContextWrapper) {
        if (v8ContextWrapper == null || v8ContextWrapper.equals(this.currentContext)) {
            return;
        }
        this.f32583v8.switchV8Context(v8ContextWrapper.getPtr());
        this.currentContext = v8ContextWrapper;
    }

    public void releaseContext(V8ContextWrapper v8ContextWrapper) {
        if (v8ContextWrapper == null) {
            return;
        }
        this.f32583v8.releaseV8Context(v8ContextWrapper.getPtr());
    }
}
