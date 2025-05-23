package com.tencent.mm.appbrand.commonjni;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.a9.a;
import com.tencent.luggage.wxa.a9.b;
import com.tencent.luggage.wxa.a9.f;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class AppBrandCommonBindingJni {
    private static final String TAG = "MicroMsg.AppBrandCommonBindingJni";

    @NonNull
    private a mAppBrandDelegate;
    private long mNativeHandle = 0;
    public long isolatePtr = 0;
    public long contextPtr = 0;
    public long uvPtr = 0;

    static {
        b.a("wxa-runtime-binding");
    }

    public AppBrandCommonBindingJni(@NonNull a aVar) {
        Objects.requireNonNull(aVar);
        this.mAppBrandDelegate = aVar;
    }

    private native void nativeBindConsoleTo(long j3, long j16, long j17, long j18);

    private native void nativeBindTo(long j3, long j16, long j17, long j18);

    public static native boolean nativeBrotliDecompress(String str, String str2);

    private native long nativeCreate(AppBrandCommonBindingJniParams appBrandCommonBindingJniParams);

    private native void nativeDestroy(long j3);

    private native void nativeEvaluateScript(long j3, String str, Runnable runnable);

    private native int nativeGenerateBufferId(long j3);

    private native Object nativeGetJSByteDataAndRemove(long j3, int i3, boolean z16);

    private native void nativeInvokeCallbackHandler(long j3, int i3, String str, String str2);

    private native void nativeNotifyContextCreated(long j3, long j16, long j17, String str);

    private native void nativePause(long j3);

    private native void nativePostRuntimeReady(long j3, long j16, Class cls);

    private native void nativePostToJsThread(long j3, Runnable runnable, boolean z16, boolean z17);

    private native void nativePutByteData(long j3, int i3, Object obj, boolean z16, int i16, int i17);

    private native void nativeReleaseDirectBuffer(ByteBuffer byteBuffer);

    private native void nativeRequestV8GarbageCollectionForTest(long j3);

    private native void nativeResume(long j3);

    private native void nativeRuntimeReady(long j3, String str, String str2, String str3);

    private native void nativeSendInspectorMsg(long j3, String str);

    private native void nativeSetInstanceId(long j3, String str);

    private native void nativeStartInspector(long j3);

    private native void nativeStartInspectorOnJS(long j3);

    private native void nativeStopInspector(long j3);

    private native void nativeSubscribeHandler(long j3, String str, String str2, int i3, String str3);

    private native void nativeSuspend(long j3);

    @Nullable
    @Keep
    public BatchRequestWxaFileDescriptorsResponse batchRequestWxaFileDescriptors(String[] strArr, Object obj) {
        Map map;
        if (obj != null) {
            map = (Map) obj;
        } else {
            map = null;
        }
        return this.mAppBrandDelegate.a(strArr, map);
    }

    @Keep
    public boolean doInnerLoopTask() {
        return this.mAppBrandDelegate.c();
    }

    public synchronized void evaluateScript(String str, Runnable runnable) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeEvaluateScript(j3, str, runnable);
        }
    }

    public synchronized int generateBufferId() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            return nativeGenerateBufferId(j3);
        }
        return 0;
    }

    @Keep
    public String[] getAsyncableJsApis() {
        return this.mAppBrandDelegate.d();
    }

    public synchronized ByteBuffer getJSByteBufferAndRemove(int i3, boolean z16) {
        long j3 = this.mNativeHandle;
        if (j3 == 0) {
            return null;
        }
        Object nativeGetJSByteDataAndRemove = nativeGetJSByteDataAndRemove(j3, i3, z16);
        if (nativeGetJSByteDataAndRemove == null) {
            return null;
        }
        if (z16) {
            return (ByteBuffer) nativeGetJSByteDataAndRemove;
        }
        return ByteBuffer.wrap((byte[]) nativeGetJSByteDataAndRemove);
    }

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public void invokeCallbackHandler(int i3, String str) {
        invokeCallbackHandler(i3, str, "");
    }

    @Keep
    public String nativeInvokeHandler(String str, String str2, String str3, int i3, boolean z16, int i16) {
        return this.mAppBrandDelegate.a(str, str2, str3, i3, z16, i16);
    }

    public void notifyBindConsoleTo(long j3, long j16, long j17) {
        long j18 = this.mNativeHandle;
        if (j18 != 0) {
            nativeBindConsoleTo(j18, j3, j16, j17);
        }
    }

    public void notifyBindTo(long j3, long j16, long j17) {
        long j18 = this.mNativeHandle;
        if (j18 != 0) {
            nativeBindTo(j18, j3, j16, j17);
        }
    }

    public void notifyContextCreated(long j3, long j16, String str) {
        synchronized (this) {
            long j17 = this.mNativeHandle;
            if (j17 != 0) {
                nativeNotifyContextCreated(j17, j3, j16, str);
            }
        }
    }

    public void notifyCreate(AppBrandCommonBindingJniParams appBrandCommonBindingJniParams) {
        long nativeCreate = nativeCreate(appBrandCommonBindingJniParams);
        this.mNativeHandle = nativeCreate;
        f.b(TAG, "hy: created with %d", Long.valueOf(nativeCreate));
    }

    public void notifyDestroy() {
        long j3;
        synchronized (this) {
            j3 = this.mNativeHandle;
            this.mNativeHandle = 0L;
        }
        if (j3 != 0) {
            nativeDestroy(j3);
        }
        this.mAppBrandDelegate = null;
    }

    public void notifyPause() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativePause(j3);
        }
    }

    public void notifyPostRuntimeReady(long j3, Class cls) {
        long j16 = this.mNativeHandle;
        if (j16 != 0) {
            nativePostRuntimeReady(j16, j3, cls);
        }
    }

    public void notifyResume() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeResume(j3);
        }
    }

    public void notifyRuntimeReady(String str, String str2, String str3) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeRuntimeReady(j3, str, str2, str3);
        }
    }

    public void notifySetInstanceId(String str) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeSetInstanceId(j3, str);
        }
    }

    public void notifySuspend() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeSuspend(j3);
        }
    }

    @Keep
    public void onInspectorMsg(String str) {
        this.mAppBrandDelegate.d(str);
    }

    @Keep
    public void onJSRuntimeReady(long j3, long j16, long j17) {
        this.isolatePtr = j3;
        this.contextPtr = j16;
        this.uvPtr = j17;
    }

    public synchronized void postCleanupJob(@NonNull Runnable runnable) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativePostToJsThread(j3, runnable, true, false);
        }
    }

    public synchronized void postToJsThread(@NonNull Runnable runnable, boolean z16) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativePostToJsThread(j3, runnable, false, z16);
        }
    }

    public synchronized void putJavaByteBuffer(int i3, @NonNull ByteBuffer byteBuffer) {
        if (this.mNativeHandle == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            nativePutByteData(this.mNativeHandle, i3, byteBuffer, true, 0, byteBuffer.capacity());
        } else if (byteBuffer.hasArray()) {
            nativePutByteData(this.mNativeHandle, i3, byteBuffer.array(), false, byteBuffer.arrayOffset(), byteBuffer.capacity());
        }
    }

    @Nullable
    @Keep
    public ByteBuffer readCommLibFile(String str) {
        return this.mAppBrandDelegate.c(str);
    }

    @Nullable
    @Keep
    public String readCommLibFileScript(String str) {
        return this.mAppBrandDelegate.b(str);
    }

    @Nullable
    @Keep
    public ByteBuffer readWeAppFile(String str) {
        return this.mAppBrandDelegate.a(str);
    }

    public void releaseDirectBuffer(@NonNull ByteBuffer byteBuffer) {
        nativeReleaseDirectBuffer(byteBuffer);
    }

    @Keep
    public void reportIDKey(int i3, int i16, int i17) {
        this.mAppBrandDelegate.a(i3, i16, i17);
    }

    @Keep
    public void reportKV(int i3, String str) {
        this.mAppBrandDelegate.a(i3, str);
    }

    public void requestV8GarbageCollectionForTest() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeRequestV8GarbageCollectionForTest(j3);
        }
    }

    @Keep
    public void resumeLoopTasks() {
        this.mAppBrandDelegate.b();
    }

    public void sendInspectorMsg(String str) {
        synchronized (this) {
            long j3 = this.mNativeHandle;
            if (j3 != 0) {
                nativeSendInspectorMsg(j3, str);
            }
        }
    }

    public void startInspector() {
        synchronized (this) {
            long j3 = this.mNativeHandle;
            if (j3 != 0) {
                nativeStartInspector(j3);
            }
        }
    }

    public void startInspectorOnJS() {
        synchronized (this) {
            long j3 = this.mNativeHandle;
            if (j3 != 0) {
                nativeStartInspectorOnJS(j3);
            }
        }
    }

    public void stopInspector() {
        synchronized (this) {
            long j3 = this.mNativeHandle;
            if (j3 != 0) {
                nativeStopInspector(j3);
            }
        }
    }

    public synchronized void subscribeHandler(String str, String str2, int i3, String str3) {
        long j3 = this.mNativeHandle;
        if (j3 == 0) {
            return;
        }
        nativeSubscribeHandler(j3, str, str2, i3, str3);
    }

    @Keep
    public boolean syncInitModule(String str, String str2) {
        f.b(TAG, "hy: request init %s with params %s", str, str2);
        try {
            return this.mAppBrandDelegate.a(str, str2);
        } catch (Throwable th5) {
            String format = String.format("hy: syncInitModule %s crashed!!", str);
            f.a(TAG, th5, format, new Object[0]);
            this.mAppBrandDelegate.e(format);
            return false;
        }
    }

    public synchronized void invokeCallbackHandler(int i3, String str, String str2) {
        long j3 = this.mNativeHandle;
        if (j3 == 0) {
            return;
        }
        nativeInvokeCallbackHandler(j3, i3, str, str2);
    }
}
