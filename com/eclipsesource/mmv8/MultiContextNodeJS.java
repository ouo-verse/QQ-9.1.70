package com.eclipsesource.mmv8;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.snapshot.CreateSnapshotResult;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MultiContextNodeJS {
    private static final String GLOBAL = "global";

    @Nullable
    public CreateStats createStats = null;

    @NonNull
    private final V8Context mainContext;

    @NonNull
    private final MultiContextV8 mv8;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class CreateStats {
        public final long isolateCreateDurationMills;
        public final long mainContextCreateDurationMills;
        public final long nodeEnvCreateDurationMills;

        public CreateStats(long j3, long j16, long j17) {
            this.isolateCreateDurationMills = j3;
            this.mainContextCreateDurationMills = j16;
            this.nodeEnvCreateDurationMills = j17;
        }
    }

    MultiContextNodeJS(MultiContextV8 multiContextV8, V8Context v8Context) {
        this.mv8 = multiContextV8;
        this.mainContext = v8Context;
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i3) {
        return createMultiContextNodeJS(i3, null, null, false);
    }

    public void closeUVLoop() {
        this.mv8.getV8().closeUVLoop();
    }

    public void debugDestroy() {
        this.mv8.debugDestroy();
    }

    public void debuggerMessageLoop() {
        this.mv8.debuggerMessageLoop();
    }

    public V8Context getMainContext() {
        return this.mainContext;
    }

    public MultiContextV8 getRuntime() {
        return this.mv8;
    }

    public boolean handleMessage(boolean z16) {
        this.mv8.getV8().checkThread();
        return this.mv8.getV8().pumpMessageLoop(z16);
    }

    public boolean isRunning() {
        this.mv8.getV8().checkThread();
        return this.mv8.getV8().isRunning();
    }

    public void nativeDispatch() {
        this.mv8.getV8().nativeDispatch();
    }

    public void nativeMessageLoop() {
        this.mv8.getV8().checkThread();
        this.mv8.getV8().nativeMessageLoop();
    }

    public void release() {
        this.mv8.getV8().checkThread();
        if (!this.mainContext.isReleased()) {
            this.mainContext.release();
        }
        this.mv8.release();
    }

    public void waitForDebugger(String str, boolean z16) {
        this.mv8.waitForDebugger(str, z16);
    }

    public void wakeUpUVLoop() {
        this.mv8.getV8().wakeUpUVLoop();
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i3, String str, byte[] bArr, boolean z16) {
        return createMultiContextNodeJS(i3, CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX, str, bArr, null, false, z16, 2);
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i3, int i16, String str, byte[] bArr, String str2, boolean z16, boolean z17, int i17) {
        V8Context createContext;
        MultiContextV8 createMultiContextV8 = MultiContextV8.createMultiContextV8("global", str, bArr, str2, z16, i17);
        long j3 = createMultiContextV8.getV8().isolateCreateDurationMills;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX != i16) {
            if (z16 && CreateSnapshotResult.Success.NODE_MAIN_CONTEXT_INDEX != i16) {
                createMultiContextV8.release();
                throw new V8RuntimeException("Node is snapshot but main context snapshot index is not 0");
            }
            if (z16) {
                createContext = createMultiContextV8.createNodeMainContextFromSnapshot(i3);
            } else {
                createContext = createMultiContextV8.createContextFromSnapshot(i3, i16);
            }
            if (createContext == null) {
                createMultiContextV8.release();
                throw new V8RuntimeException("Create mainContext from snapshot fail");
            }
        } else {
            createContext = createMultiContextV8.createContext(i3);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        MultiContextNodeJS multiContextNodeJS = new MultiContextNodeJS(createMultiContextV8, createContext);
        if (z17) {
            createMultiContextV8.getV8().enableNativeTrans();
        }
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        try {
            V8TracerAccessible.beginSection("CreateNode");
            if (!createMultiContextV8.getV8Locker().hasLock()) {
                createMultiContextV8.getV8Locker().acquire();
            }
            createMultiContextV8.getV8().createNodeRuntime();
            createMultiContextV8.getV8Locker().release();
            V8TracerAccessible.endSection();
            multiContextNodeJS.createStats = new CreateStats(j3, elapsedRealtime2, SystemClock.elapsedRealtime() - elapsedRealtime3);
            return multiContextNodeJS;
        } catch (Throwable th5) {
            createMultiContextV8.getV8Locker().release();
            V8TracerAccessible.endSection();
            throw th5;
        }
    }
}
