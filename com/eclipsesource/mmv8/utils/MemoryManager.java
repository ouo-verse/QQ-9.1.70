package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.ReferenceHandler;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MemoryManager {
    private MemoryManagerReferenceHandler memoryManagerReferenceHandler;

    /* renamed from: v8, reason: collision with root package name */
    private V8 f32588v8;
    private ArrayList<V8Value> references = new ArrayList<>();
    private boolean releasing = false;
    private boolean released = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class MemoryManagerReferenceHandler implements ReferenceHandler {
        MemoryManagerReferenceHandler() {
        }

        @Override // com.eclipsesource.mmv8.ReferenceHandler
        public void v8HandleCreated(V8Value v8Value) {
            MemoryManager.this.references.add(v8Value);
        }

        @Override // com.eclipsesource.mmv8.ReferenceHandler
        public void v8HandleDisposed(V8Value v8Value) {
            if (!MemoryManager.this.releasing) {
                Iterator it = MemoryManager.this.references.iterator();
                while (it.hasNext()) {
                    if (it.next() == v8Value) {
                        it.remove();
                        return;
                    }
                }
            }
        }
    }

    public MemoryManager(V8 v85) {
        this.f32588v8 = v85;
        MemoryManagerReferenceHandler memoryManagerReferenceHandler = new MemoryManagerReferenceHandler();
        this.memoryManagerReferenceHandler = memoryManagerReferenceHandler;
        v85.addReferenceHandler(memoryManagerReferenceHandler);
    }

    private void checkReleased() {
        if (!this.released) {
        } else {
            throw new IllegalStateException("Memory manager released");
        }
    }

    public int getObjectReferenceCount() {
        checkReleased();
        return this.references.size();
    }

    public boolean isReleased() {
        return this.released;
    }

    public void persist(V8Value v8Value) {
        this.f32588v8.getLocker().checkThread();
        checkReleased();
        this.references.remove(v8Value);
    }

    public void release() {
        this.f32588v8.getLocker().checkThread();
        if (this.released) {
            return;
        }
        this.releasing = true;
        try {
            Iterator<V8Value> it = this.references.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.f32588v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
            this.references.clear();
            this.releasing = false;
            this.released = true;
        } catch (Throwable th5) {
            this.releasing = false;
            throw th5;
        }
    }
}
