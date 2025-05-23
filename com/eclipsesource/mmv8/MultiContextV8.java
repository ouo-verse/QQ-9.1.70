package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;
import com.eclipsesource.mmv8.utils.MemoryManager;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MultiContextV8 {

    @NonNull
    private final V8ContextSessionMgr contextSessionMgr;

    /* renamed from: v8, reason: collision with root package name */
    @NonNull
    private final V8 f32582v8;

    MultiContextV8() {
        this(null);
    }

    public static MultiContextV8 createMultiContextV8() {
        return new MultiContextV8();
    }

    public V8Context createContext(int i3) {
        try {
            V8TracerAccessible.beginSection("CreateContext");
            long createV8Context = this.f32582v8.createV8Context(i3);
            V8TracerAccessible.endSection();
            return new V8ContextWrapper(this, createV8Context).context();
        } catch (Throwable th5) {
            V8TracerAccessible.endSection();
            throw th5;
        }
    }

    public V8Context createContextFromSnapshot(int i3, int i16) {
        try {
            V8TracerAccessible.beginSection("CreateContextFromSnapshot");
            long createV8ContextFromSnapshot = this.f32582v8.createV8ContextFromSnapshot(i3, i16);
            V8TracerAccessible.endSection();
            if (0 == createV8ContextFromSnapshot) {
                return null;
            }
            return new V8ContextWrapper(this, createV8ContextFromSnapshot).context();
        } catch (Throwable th5) {
            V8TracerAccessible.endSection();
            throw th5;
        }
    }

    public MemoryManager createMemoryManager() {
        return new MemoryManager(this.f32582v8);
    }

    public V8Context createNodeMainContextFromSnapshot(int i3) {
        try {
            V8TracerAccessible.beginSection("CreateNodeMainContextFromSnapshot");
            long createV8NodeMainContextFromSnapshot = this.f32582v8.createV8NodeMainContextFromSnapshot(i3);
            V8TracerAccessible.endSection();
            if (0 == createV8NodeMainContextFromSnapshot) {
                return null;
            }
            return new V8ContextWrapper(this, createV8NodeMainContextFromSnapshot).context();
        } catch (Throwable th5) {
            V8TracerAccessible.endSection();
            throw th5;
        }
    }

    public void debugDestroy() {
        this.f32582v8.debugDestroy();
    }

    public void debuggerMessageLoop() {
        this.f32582v8.debuggerMessageLoop();
    }

    public void enterContext(V8ContextWrapper v8ContextWrapper) {
        this.contextSessionMgr.enterContext(v8ContextWrapper);
    }

    public long getIsolatePtr() {
        return this.f32582v8.getIsolatePtr();
    }

    public long getUVLoopPtr() {
        return this.f32582v8.getUVLoopPtr();
    }

    public V8 getV8() {
        return this.f32582v8;
    }

    public V8Locker getV8Locker() {
        return this.f32582v8.getLocker();
    }

    public void markSnapshotNotNeed() {
        this.f32582v8.markSnapshotNotNeed();
    }

    public void memoryPressureNotification(int i3) {
        this.f32582v8.memoryPressureNotification(i3);
    }

    public void release() {
        this.f32582v8.release();
    }

    public void releaseContext(V8ContextWrapper v8ContextWrapper) {
        this.contextSessionMgr.releaseContext(v8ContextWrapper);
    }

    public void setMinimalCodeLength(int i3) {
        this.f32582v8.setMinimalCodeLength(i3);
    }

    public void waitForDebugger(String str, boolean z16) {
        this.f32582v8.waitForDebugger(str, z16);
    }

    public void waitForDebuggerWithContexts(String str, long[] jArr, String[] strArr) {
        this.f32582v8.waitForDebuggerWithContexts(str, jArr, strArr);
    }

    MultiContextV8(String str) {
        this(str, null, null, 2);
    }

    public static MultiContextV8 createMultiContextV8(String str) {
        return new MultiContextV8(str);
    }

    MultiContextV8(String str, String str2, byte[] bArr, int i3) {
        this(str, str2, bArr, null, false, i3);
    }

    public static MultiContextV8 createMultiContextV8(String str, byte[] bArr, int i3) {
        return new MultiContextV8(null, str, bArr, i3);
    }

    MultiContextV8(String str, String str2, byte[] bArr, String str3, boolean z16, int i3) {
        this.f32582v8 = V8.createV8Runtime(str, null, false, str2, bArr, str3, z16, i3);
        this.contextSessionMgr = new V8ContextSessionMgr(getV8());
    }

    public static MultiContextV8 createMultiContextV8(String str, String str2, byte[] bArr, int i3) {
        return new MultiContextV8(str, str2, bArr, i3);
    }

    public static MultiContextV8 createMultiContextV8(String str, String str2, byte[] bArr, String str3, boolean z16, int i3) {
        return new MultiContextV8(str, str2, bArr, str3, z16, i3);
    }
}
