package com.eclipsesource.mmv8;

import android.os.Environment;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.snapshot.CreateSnapshotParams;
import com.eclipsesource.mmv8.snapshot.CreateSnapshotResult;
import com.eclipsesource.mmv8.utils.V8Executor;
import com.eclipsesource.mmv8.utils.V8Map;
import com.eclipsesource.mmv8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8 extends V8Object {
    public static final int MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
    public static final int MEMORY_PRESSURE_LEVEL_MODERATE = 1;
    public static final int MEMORY_PRESSURE_LEVEL_NONE = 0;
    public static final int kMicrotasksPolicyAuto = 2;
    public static final int kMicrotasksPolicyExplicit = 0;
    public static final int kMicrotasksPolicyScoped = 1;
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError = null;
    private static Exception nativeLoadException = null;
    private static volatile int runtimeCounter = 0;
    private static String v8Flags = "";
    JavaTaskScheduler _javaTaskScheduler;
    private Map<String, Object> data;
    private V8Map<V8Executor> executors;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    protected final long isolateCreateDurationMills;
    private final V8Locker locker;
    Runnable nativeJavaCallback_;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;
    private static final Object lock = new Object();
    private static V8Value undefined = new V8Object.Undefined();
    private static Object invalid = new Object();
    private static String v8TracingConfig = "";
    private static String v8TracingResultFile = Environment.getExternalStorageDirectory().getPath() + "v8_trace.json";
    private static boolean v8TracingAutoStart = false;
    private static String[] v8TracingCategories = null;
    private static boolean v8TracingRunning = false;
    private static ILoadLibraryDelegate sLoadLibraryDelegate = new ILoadLibraryDelegate() { // from class: com.eclipsesource.mmv8.V8.1
        @Override // com.eclipsesource.mmv8.ILoadLibraryDelegate
        public void loadLibrary(String str) {
            LibraryLoader.loadLibrary(str);
        }
    };
    private static AtomicBoolean sCachedProtectCreateContextFromSnapshot = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface JavaTaskScheduler {
        void Schedule(Runnable runnable);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class MethodDescriptor {
        JavaCallback callback;
        boolean includeReceiver;
        Method method;
        Object object;
        JavaVoidCallback voidCallback;

        MethodDescriptor() {
        }
    }

    public V8() {
        this(null, true, null, null, false, 2);
    }

    private native void _acquireLock(long j3);

    private native void _add(long j3, long j16, String str, double d16);

    private native void _add(long j3, long j16, String str, int i3);

    private native void _add(long j3, long j16, String str, String str2);

    private native void _add(long j3, long j16, String str, boolean z16);

    private native void _addArrayBooleanItem(long j3, long j16, boolean z16);

    private native void _addArrayDoubleItem(long j3, long j16, double d16);

    private native void _addArrayIntItem(long j3, long j16, int i3);

    private native void _addArrayNullItem(long j3, long j16);

    private native void _addArrayObjectItem(long j3, long j16, long j17);

    private native void _addArrayStringItem(long j3, long j16, String str);

    private native void _addArrayUndefinedItem(long j3, long j16);

    private native void _addNull(long j3, long j16, String str);

    private native void _addObject(long j3, long j16, String str, long j17);

    private native void _addUndefined(long j3, long j16, String str);

    private native Object _arrayGet(long j3, int i3, long j16, int i16);

    private native boolean _arrayGetBoolean(long j3, long j16, int i3);

    private native int _arrayGetBooleans(long j3, long j16, int i3, int i16, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j3, long j16, int i3, int i16);

    private native byte _arrayGetByte(long j3, long j16, int i3);

    private native int _arrayGetBytes(long j3, long j16, int i3, int i16, byte[] bArr);

    private native byte[] _arrayGetBytes(long j3, long j16, int i3, int i16);

    private native double _arrayGetDouble(long j3, long j16, int i3);

    private native int _arrayGetDoubles(long j3, long j16, int i3, int i16, double[] dArr);

    private native double[] _arrayGetDoubles(long j3, long j16, int i3, int i16);

    private native int _arrayGetInteger(long j3, long j16, int i3);

    private native int _arrayGetIntegers(long j3, long j16, int i3, int i16, int[] iArr);

    private native int[] _arrayGetIntegers(long j3, long j16, int i3, int i16);

    private native int _arrayGetSize(long j3, long j16);

    private native String _arrayGetString(long j3, long j16, int i3);

    private native int _arrayGetStrings(long j3, long j16, int i3, int i16, String[] strArr);

    private native String[] _arrayGetStrings(long j3, long j16, int i3, int i16);

    private native Object _batchExecuteScripts(long j3, V8ScriptEvaluateRequest[] v8ScriptEvaluateRequestArr, String str, ExecuteDetails executeDetails);

    private native void _closeUVLoop(long j3);

    private native boolean _contains(long j3, long j16, String str);

    private native long _createContext(long j3, int i3);

    private native long _createContextFromSnapshot(long j3, int i3, int i16);

    private native long _createIsolate(String str, boolean z16, byte[] bArr, String str2, boolean z17, int i3);

    private native long _createNodeMainContextFromSnapshot(long j3, int i3);

    public static native CreateSnapshotResult _createSnapshot(CreateSnapshotParams createSnapshotParams);

    private native void _createTwin(long j3, long j16, long j17);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j3, long j16, int i3);

    private static native void _debugDestroy(long j3);

    private static native void _debugMessageLoop(long j3);

    private static native void _enableNativeTrans(long j3);

    private native boolean _equals(long j3, long j16, long j17);

    private native boolean _executeBooleanFunction(long j3, long j16, String str, long j17);

    private native boolean _executeBooleanScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails);

    private static native String _executeDebugScript(long j3, String str, String str2);

    private native double _executeDoubleFunction(long j3, long j16, String str, long j17);

    private native double _executeDoubleScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails);

    private native Object _executeFileScript(long j3, int i3, V8ScriptFileDescriptor v8ScriptFileDescriptor, String str, int i16, String str2, String str3, int i17, ExecuteDetails executeDetails);

    private native Object _executeFunction(long j3, int i3, long j16, String str, long j17);

    private native Object _executeFunction(long j3, long j16, long j17, long j18);

    private native int _executeIntegerFunction(long j3, long j16, String str, long j17);

    private native int _executeIntegerScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails);

    private native Object _executeScript(long j3, int i3, String str, String str2, int i16, String str3, String str4, int i17, ExecuteDetails executeDetails);

    private native String _executeStringFunction(long j3, long j16, String str, long j17);

    private native String _executeStringScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails);

    private native void _executeVoidFunction(long j3, long j16, String str, long j17);

    private native void _executeVoidScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails);

    private native Object _get(long j3, int i3, long j16, String str);

    private native int _getArrayType(long j3, long j16);

    private native ByteBuffer _getBackingStore(long j3, long j16);

    private native boolean _getBoolean(long j3, long j16, String str);

    private native long _getBuildID();

    private native double _getDouble(long j3, long j16, String str);

    private native long _getGlobalObject(long j3);

    private native int _getInteger(long j3, long j16, String str);

    private native long _getIsolatePtr(long j3);

    private native String[] _getKeys(long j3, long j16);

    private static native long _getMyLoopIdleTimeMs(long j3);

    private static native long _getNativeTransManager();

    private native String _getString(long j3, long j16, String str);

    private native int _getType(long j3, long j16);

    private native int _getType(long j3, long j16, int i3);

    private native int _getType(long j3, long j16, int i3, int i16);

    private native int _getType(long j3, long j16, String str);

    private native long _getUVLoopPtr(long j3);

    private static native String _getVersion();

    private native int _identityHash(long j3, long j16);

    @Deprecated
    private native long _initNewSharedV8ArrayBuffer(long j3, ByteBuffer byteBuffer, int i3);

    private native long _initNewV8Array(long j3);

    private native long _initNewV8ArrayBuffer(long j3, int i3);

    private native long _initNewV8ArrayBuffer(long j3, ByteBuffer byteBuffer, int i3);

    private native long _initNewV8Float32Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8Float64Array(long j3, long j16, int i3, int i16);

    private native long[] _initNewV8Function(long j3);

    private native long _initNewV8Int16Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8Int32Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8Int8Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8Object(long j3);

    private native long _initNewV8UInt16Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8UInt32Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8UInt8Array(long j3, long j16, int i3, int i16);

    private native long _initNewV8UInt8ClampedArray(long j3, long j16, int i3, int i16);

    private static native boolean _isRunning(long j3);

    private native boolean _isWeak(long j3, long j16);

    private native void _lowMemoryNotification(long j3);

    private static native void _markSnapshotNotNeed(long j3);

    private native void _memoryPressureNotification(long j3, int i3);

    private static native void _nativeDispatch(long j3);

    private static native void _nativeLoopStop(long j3);

    private static native void _nativeMessageLoop(long j3);

    private static native void _nativeTransBroadcastMessage(int i3, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _nativeTransHandleMessage(long j3);

    private static native void _nativeTransPostMessage(int i3, String str);

    private static native void _nativeTransSetJavaSchedule(long j3);

    private static native void _protectCreateContextFromSnapshot();

    private static native boolean _pumpMessageLoop(long j3, boolean z16);

    private static native void _pumpMessageLoopDirect(long j3);

    private native long _registerJavaMethod(long j3, long j16, String str, boolean z16);

    private native void _release(long j3, long j16);

    private native void _releaseContext(long j3, long j16);

    private native void _releaseLock(long j3);

    private native void _releaseMethodDescriptor(long j3, long j16);

    private native void _releaseRuntime(long j3);

    private native boolean _sameValue(long j3, long j16, long j17);

    private static native void _setBreakOnStart(boolean z16);

    private native void _setCodeCacheDir(long j3, String str);

    private native void _setDelaySaveCodeCache(long j3, boolean z16);

    private static native void _setFlags(String str);

    private native void _setMinimalCodeLength(long j3, int i3);

    private native void _setPrototype(long j3, long j16, long j17);

    private native void _setWeak(long j3, long j16);

    private static native void _startNodeJS(long j3);

    private native boolean _strictEquals(long j3, long j16, long j17);

    private native void _switchContext(long j3, long j16);

    private native void _terminateExecution(long j3);

    private native String _toString(long j3, long j16);

    private static native void _waitForDebuger(long j3, String str, boolean z16);

    private static native void _waitForDebuggerWithContexts(long j3, String str, long[] jArr, String[] strArr);

    private native void _wakeUpUVLoop(long j3);

    @Nullable
    public static native ByteBuffer allocateDirectByteBufferInSandbox(int i3);

    public static void broadcastMessage(int i3, String str) {
        _nativeTransBroadcastMessage(i3, str);
    }

    private void checkArgs(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == invalid) {
                throw new IllegalArgumentException("argument type mismatch");
            }
        }
    }

    private static void checkNativeLibraryLoaded() {
        if (!nativeLibraryLoaded) {
            if (nativeLoadError == null) {
                if (nativeLoadException != null) {
                    throw new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
                }
                throw new IllegalStateException("J2V8 native library not loaded");
            }
            throw new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
        }
    }

    private Object checkResult(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (!(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Boolean) && !(obj instanceof String)) {
            if (obj instanceof V8Value) {
                if (!((V8Value) obj).isReleased()) {
                    return obj;
                }
                throw new V8RuntimeException("V8Value already released");
            }
            throw new V8RuntimeException("Unknown return type: " + obj.getClass());
        }
        return obj;
    }

    public static void checkScript(String str) {
        if (str != null) {
        } else {
            throw new NullPointerException("Script is null");
        }
    }

    public static native void clearSnapshotCacheIfIdle();

    public static native void createNodeSnapshot(String str);

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null);
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z16) {
        int i3;
        int length = methodDescriptor.method.getParameterTypes().length;
        if (z16) {
            i3 = length - 1;
        } else {
            i3 = length;
        }
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        ArrayList arrayList = new ArrayList();
        populateParamters(v8Array, i3, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z16) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i3] = varArgContainer;
        }
        return defaultValues;
    }

    private Object getArrayItem(V8Array v8Array, int i3) {
        try {
            int type = v8Array.getType(i3);
            if (type != 10) {
                if (type != 99) {
                    switch (type) {
                        case 1:
                            return Integer.valueOf(v8Array.getInteger(i3));
                        case 2:
                            return Double.valueOf(v8Array.getDouble(i3));
                        case 3:
                            return Boolean.valueOf(v8Array.getBoolean(i3));
                        case 4:
                            return v8Array.getString(i3);
                        case 5:
                        case 8:
                            return v8Array.getArray(i3);
                        case 6:
                            return v8Array.getObject(i3);
                        case 7:
                            return v8Array.getObject(i3);
                        default:
                            return null;
                    }
                }
                return getUndefined();
            }
            return v8Array.get(i3);
        } catch (V8ResultUndefined unused) {
            return null;
        }
    }

    private Object getDefaultValue(Class<?> cls) {
        if (cls.equals(V8Object.class)) {
            return new V8Object.Undefined();
        }
        if (cls.equals(V8Array.class)) {
            return new V8Array.Undefined();
        }
        return invalid;
    }

    public static String getFlags() {
        return v8Flags;
    }

    public static long getNativeTransManager() {
        return _getNativeTransManager();
    }

    public static native String getNodeVersion();

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    public static String[] getTracingCategories() {
        return v8TracingCategories;
    }

    public static String getTracingResultFile() {
        return v8TracingResultFile;
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i3) {
        Class<?> cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return Array.newInstance(cls, i3);
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static boolean isTracingAutoStart() {
        return v8TracingAutoStart;
    }

    public static boolean isV8TracingRunning() {
        return v8TracingRunning;
    }

    private boolean isVoidMethod(Method method) {
        if (method.getReturnType().equals(Void.TYPE)) {
            return true;
        }
        return false;
    }

    private static synchronized void load(String str) {
        synchronized (V8.class) {
            try {
                try {
                    try {
                        V8TracerAccessible.beginSection("LoadSo");
                        sLoadLibraryDelegate.loadLibrary(str);
                        nativeLibraryLoaded = true;
                    } catch (Exception e16) {
                        nativeLoadException = e16;
                    }
                } catch (Error e17) {
                    nativeLoadError = e17;
                }
            } finally {
                V8TracerAccessible.endSection();
            }
        }
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleCreated(v8Value);
        }
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleDisposed(v8Value);
        }
    }

    private void notifyReleaseHandlers(V8 v85) {
        Iterator<V8Runnable> it = this.releaseHandlers.iterator();
        while (it.hasNext()) {
            it.next().run(v85);
        }
    }

    public static void onStartV8Tracing() {
        v8TracingRunning = true;
    }

    public static void onStopV8Tracing() {
        v8TracingRunning = false;
    }

    private void populateParamters(V8Array v8Array, int i3, Object[] objArr, List<Object> list, boolean z16) {
        for (int i16 = z16 ? 1 : 0; i16 < v8Array.length() + (z16 ? 1 : 0); i16++) {
            if (i16 >= i3) {
                list.add(getArrayItem(v8Array, i16 - (z16 ? 1 : 0)));
            } else {
                objArr[i16] = getArrayItem(v8Array, i16 - (z16 ? 1 : 0));
            }
        }
    }

    public static void postMessage(int i3, String str) {
        _nativeTransPostMessage(i3, str);
    }

    public static void protectCreateContextFromSnapshot() {
        if (nativeLibraryLoaded) {
            _protectCreateContextFromSnapshot();
        } else {
            sCachedProtectCreateContextFromSnapshot.set(true);
        }
    }

    private void releaseArguments(Object[] objArr, boolean z16) {
        if (z16 && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
    }

    public static native void releaseDirectByteBufferInSandbox(@NonNull ByteBuffer byteBuffer, int i3);

    private void releaseNativeMethodDescriptors() {
        Iterator<Long> it = this.functionRegistry.keySet().iterator();
        while (it.hasNext()) {
            releaseMethodDescriptor(this.v8RuntimePtr, it.next().longValue());
        }
    }

    private void releaseResources() {
        List<Releasable> list = this.resources;
        if (list != null) {
            Iterator<Releasable> it = list.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.resources.clear();
            this.resources = null;
        }
    }

    public static boolean requireSoLoaded(String str) {
        if (nativeLibraryLoaded) {
            return true;
        }
        synchronized (lock) {
            if (!nativeLibraryLoaded) {
                load(str);
            }
        }
        return nativeLibraryLoaded;
    }

    public static void setBreakOnStart(Boolean bool) {
        _setBreakOnStart(bool.booleanValue());
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z16) {
        int i3 = 0;
        if (z16) {
            objArr[0] = v8Object;
            i3 = 1;
        }
        while (i3 < objArr.length) {
            objArr[i3] = getDefaultValue(clsArr[i3]);
            i3++;
        }
        return objArr;
    }

    public static void setFlags(String str) {
        v8Flags = str;
    }

    public static void setLoadLibraryDelegate(ILoadLibraryDelegate iLoadLibraryDelegate) {
        if (iLoadLibraryDelegate != null) {
            sLoadLibraryDelegate = iLoadLibraryDelegate;
            return;
        }
        throw new IllegalArgumentException("setLoadLibraryDelegate: param delegate null");
    }

    public static void setTracingInfo(String str, String str2, boolean z16) throws JSONException {
        v8TracingConfig = str;
        v8TracingResultFile = str2;
        v8TracingAutoStart = z16;
        JSONArray jSONArray = new JSONObject(str).getJSONArray("included_categories");
        v8TracingCategories = new String[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            v8TracingCategories[i3] = jSONArray.getString(i3);
        }
    }

    public static native void startTracing();

    public static native void stopTracing();

    public void acquireLock(long j3) {
        _acquireLock(j3);
    }

    public void add(long j3, long j16, String str, int i3) {
        _add(j3, j16, str, i3);
    }

    public void addArrayBooleanItem(long j3, long j16, boolean z16) {
        _addArrayBooleanItem(j3, j16, z16);
    }

    public void addArrayDoubleItem(long j3, long j16, double d16) {
        _addArrayDoubleItem(j3, j16, d16);
    }

    public void addArrayIntItem(long j3, long j16, int i3) {
        _addArrayIntItem(j3, j16, i3);
    }

    public void addArrayNullItem(long j3, long j16) {
        _addArrayNullItem(j3, j16);
    }

    public void addArrayObjectItem(long j3, long j16, long j17) {
        _addArrayObjectItem(j3, j16, j17);
    }

    public void addArrayStringItem(long j3, long j16, String str) {
        _addArrayStringItem(j3, j16, str);
    }

    public void addArrayUndefinedItem(long j3, long j16) {
        _addArrayUndefinedItem(j3, j16);
    }

    public void addNull(long j3, long j16, String str) {
        _addNull(j3, j16, str);
    }

    public void addObjRef(V8Value v8Value) {
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
    }

    public void addObject(long j3, long j16, String str, long j17) {
        _addObject(j3, j16, str, j17);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.add(0, referenceHandler);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.add(v8Runnable);
    }

    public void addUndefined(long j3, long j16, String str) {
        _addUndefined(j3, j16, str);
    }

    public Object arrayGet(long j3, int i3, long j16, int i16) {
        return _arrayGet(j3, i3, j16, i16);
    }

    public boolean arrayGetBoolean(long j3, long j16, int i3) {
        return _arrayGetBoolean(j3, j16, i3);
    }

    public boolean[] arrayGetBooleans(long j3, long j16, int i3, int i16) {
        return _arrayGetBooleans(j3, j16, i3, i16);
    }

    public byte arrayGetByte(long j3, long j16, int i3) {
        return _arrayGetByte(j3, j16, i3);
    }

    public byte[] arrayGetBytes(long j3, long j16, int i3, int i16) {
        return _arrayGetBytes(j3, j16, i3, i16);
    }

    public double arrayGetDouble(long j3, long j16, int i3) {
        return _arrayGetDouble(j3, j16, i3);
    }

    public double[] arrayGetDoubles(long j3, long j16, int i3, int i16) {
        return _arrayGetDoubles(j3, j16, i3, i16);
    }

    public int arrayGetInteger(long j3, long j16, int i3) {
        return _arrayGetInteger(j3, j16, i3);
    }

    public int[] arrayGetIntegers(long j3, long j16, int i3, int i16) {
        return _arrayGetIntegers(j3, j16, i3, i16);
    }

    public int arrayGetSize(long j3, long j16) {
        return _arrayGetSize(j3, j16);
    }

    public String arrayGetString(long j3, long j16, int i3) {
        return _arrayGetString(j3, j16, i3);
    }

    public String[] arrayGetStrings(long j3, long j16, int i3, int i16) {
        return _arrayGetStrings(j3, j16, i3, i16);
    }

    public Object batchExecuteScripts(ArrayList<V8ScriptEvaluateRequest> arrayList, String str, ExecuteDetails executeDetails) {
        checkThread();
        if (arrayList != null && !arrayList.isEmpty()) {
            return batchExecuteScripts(getV8RuntimePtr(), (V8ScriptEvaluateRequest[]) arrayList.toArray(new V8ScriptEvaluateRequest[arrayList.size()]), str, executeDetails);
        }
        throw new IllegalArgumentException("Scripts is Empty");
    }

    public Object callObjectJavaMethod(long j3, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j3));
        JavaCallback javaCallback = methodDescriptor.callback;
        if (javaCallback != null) {
            return checkResult(javaCallback.invoke(v8Object, v8Array));
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            try {
                try {
                    try {
                        return checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
                    } catch (IllegalArgumentException e16) {
                        throw e16;
                    }
                } catch (IllegalAccessException e17) {
                    throw e17;
                }
            } catch (InvocationTargetException e18) {
                throw e18.getTargetException();
            }
        } finally {
            releaseArguments(args, isVarArgs);
        }
    }

    public void callVoidJavaMethod(long j3, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j3));
        JavaVoidCallback javaVoidCallback = methodDescriptor.voidCallback;
        if (javaVoidCallback != null) {
            javaVoidCallback.invoke(v8Object, v8Array);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            try {
                methodDescriptor.method.invoke(methodDescriptor.object, args);
            } catch (IllegalAccessException e16) {
                throw e16;
            } catch (IllegalArgumentException e17) {
                throw e17;
            } catch (InvocationTargetException e18) {
                throw e18.getTargetException();
            }
        } finally {
            releaseArguments(args, isVarArgs);
        }
    }

    public void checkRuntime(V8Value v8Value) {
        if (v8Value != null && !v8Value.isUndefined()) {
            V8 runtime = v8Value.getRuntime();
            if (runtime != null && !runtime.isReleased() && runtime == this) {
            } else {
                throw new Error("Invalid target runtime");
            }
        }
    }

    public void checkThread() {
        this.locker.checkThread();
        if (!isReleased()) {
        } else {
            throw new Error("Runtime disposed error");
        }
    }

    public void closeUVLoop() {
        _closeUVLoop(this.v8RuntimePtr);
    }

    public boolean contains(long j3, long j16, String str) {
        return _contains(j3, j16, str);
    }

    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j3) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j3), methodDescriptor);
    }

    public void createNodeRuntime() {
        _startNodeJS(this.v8RuntimePtr);
    }

    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
    }

    public ByteBuffer createV8ArrayBufferBackingStore(long j3, long j16, int i3) {
        return _createV8ArrayBufferBackingStore(j3, j16, i3);
    }

    public long createV8Context(int i3) {
        return _createContext(this.v8RuntimePtr, i3);
    }

    public long createV8ContextFromSnapshot(int i3, int i16) {
        return _createContextFromSnapshot(this.v8RuntimePtr, i3, i16);
    }

    public long createV8NodeMainContextFromSnapshot(int i3) {
        return _createNodeMainContextFromSnapshot(this.v8RuntimePtr, i3);
    }

    public void debugDestroy() {
        checkThread();
        _debugDestroy(this.v8RuntimePtr);
    }

    public void debuggerMessageLoop() {
        checkThread();
        _debugMessageLoop(this.v8RuntimePtr);
    }

    public void disposeMethodID(long j3) {
        this.functionRegistry.remove(Long.valueOf(j3));
    }

    public void enableNativeTrans() {
        _enableNativeTrans(this.v8RuntimePtr);
    }

    public boolean equals(long j3, long j16, long j17) {
        return _equals(j3, j16, j17);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, null, 0, null, null, 0, null);
    }

    public boolean executeBooleanFunction(long j3, long j16, String str, long j17) {
        return _executeBooleanFunction(j3, j16, str, j17);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, null, 0, null, null, 0, null);
    }

    public String executeDebugScript(String str, String str2) {
        checkThread();
        checkScript(str);
        return _executeDebugScript(this.v8RuntimePtr, str, str2);
    }

    public double executeDoubleFunction(long j3, long j16, String str, long j17) {
        return _executeDoubleFunction(j3, j16, str, j17);
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, null, 0, null, null, 0, null);
    }

    public Object executeFileScript(V8ScriptFileDescriptor v8ScriptFileDescriptor, String str, int i3, String str2, String str3, int i16, ExecuteDetails executeDetails) {
        checkThread();
        if (v8ScriptFileDescriptor != null) {
            return executeFileScript(getV8RuntimePtr(), 0, v8ScriptFileDescriptor, str, i3, str2, str3, i16, executeDetails);
        }
        throw new NullPointerException("Script is null");
    }

    public Object executeFunction(long j3, int i3, long j16, String str, long j17) {
        return _executeFunction(j3, i3, j16, str, j17);
    }

    public int executeIntegerFunction(long j3, long j16, String str, long j17) {
        return _executeIntegerFunction(j3, j16, str, j17);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, null, 0, null, null, 0, null);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, null, 0, null, null, 0, null);
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0, null, null, 0, null);
    }

    public String executeStringFunction(long j3, long j16, String str, long j17) {
        return _executeStringFunction(j3, j16, str, j17);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, null, 0, null, null, 0, null);
    }

    public void executeVoidFunction(long j3, long j16, String str, long j17) {
        _executeVoidFunction(j3, j16, str, j17);
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, null, 0, null, null, 0, null);
    }

    public Object get(long j3, int i3, long j16, String str) {
        return _get(j3, i3, j16, str);
    }

    public int getArrayType(long j3, long j16) {
        return _getArrayType(j3, j16);
    }

    public ByteBuffer getBackingStore(long j3, long j16) {
        return _getBackingStore(j3, j16);
    }

    public boolean getBoolean(long j3, long j16, String str) {
        return _getBoolean(j3, j16, str);
    }

    public long getBuildID() {
        return _getBuildID();
    }

    public Object getData(String str) {
        Map<String, Object> map = this.data;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public double getDouble(long j3, long j16, String str) {
        return _getDouble(j3, j16, str);
    }

    public V8Executor getExecutor(V8Object v8Object) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map == null) {
            return null;
        }
        return v8Map.get(v8Object);
    }

    public long getGlobalObject() {
        return _getGlobalObject(this.v8RuntimePtr);
    }

    public int getInteger(long j3, long j16, String str) {
        return _getInteger(j3, j16, str);
    }

    public long getIsolatePtr() {
        return _getIsolatePtr(this.v8RuntimePtr);
    }

    public String[] getKeys(long j3, long j16) {
        return _getKeys(j3, j16);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getMyLoopIdleTimeMs() {
        return _getMyLoopIdleTimeMs(this.v8RuntimePtr);
    }

    public String getObjectJavaMethodDescription(long j3) {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j3));
        if (methodDescriptor == null) {
            return "Unknown";
        }
        JavaCallback javaCallback = methodDescriptor.callback;
        if (javaCallback != null) {
            return javaCallback.getClass().getName();
        }
        JavaVoidCallback javaVoidCallback = methodDescriptor.voidCallback;
        if (javaVoidCallback != null) {
            return javaVoidCallback.getClass().getName();
        }
        return methodDescriptor.object.getClass().getName() + "." + methodDescriptor.method.getName();
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - this.v8WeakReferences.size();
    }

    public String getString(long j3, long j16, String str) {
        return _getString(j3, j16, str);
    }

    public int getType(long j3, long j16) {
        return _getType(j3, j16);
    }

    public long getUVLoopPtr() {
        return _getUVLoopPtr(this.v8RuntimePtr);
    }

    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public int identityHash(long j3, long j16) {
        return _identityHash(j3, j16);
    }

    @Deprecated
    public long initNewSharedV8ArrayBuffer(long j3, ByteBuffer byteBuffer, int i3) {
        return _initNewSharedV8ArrayBuffer(j3, byteBuffer, i3);
    }

    public long initNewV8Array(long j3) {
        return _initNewV8Array(j3);
    }

    public long initNewV8ArrayBuffer(long j3, ByteBuffer byteBuffer, int i3) {
        return _initNewV8ArrayBuffer(j3, byteBuffer, i3);
    }

    public long initNewV8Float32Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Float32Array(j3, j16, i3, i16);
    }

    public long initNewV8Float64Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Float64Array(j3, j16, i3, i16);
    }

    public long[] initNewV8Function(long j3) {
        checkThread();
        return _initNewV8Function(j3);
    }

    public long initNewV8Int16Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Int16Array(j3, j16, i3, i16);
    }

    public long initNewV8Int32Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Int32Array(j3, j16, i3, i16);
    }

    public long initNewV8Int8Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Int8Array(j3, j16, i3, i16);
    }

    public long initNewV8Object(long j3) {
        return _initNewV8Object(j3);
    }

    public long initNewV8UInt16Array(long j3, long j16, int i3, int i16) {
        return _initNewV8UInt16Array(j3, j16, i3, i16);
    }

    public long initNewV8UInt32Array(long j3, long j16, int i3, int i16) {
        return _initNewV8UInt32Array(j3, j16, i3, i16);
    }

    public long initNewV8UInt8Array(long j3, long j16, int i3, int i16) {
        return _initNewV8UInt8Array(j3, j16, i3, i16);
    }

    public long initNewV8UInt8ClampedArray(long j3, long j16, int i3, int i16) {
        return _initNewV8UInt8ClampedArray(j3, j16, i3, i16);
    }

    public boolean isRunning() {
        return _isRunning(this.v8RuntimePtr);
    }

    public boolean isWeak(long j3, long j16) {
        return _isWeak(j3, j16);
    }

    public void lowMemoryNotification() {
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
    }

    public void markSnapshotNotNeed() {
        _markSnapshotNotNeed(this.v8RuntimePtr);
    }

    public void memoryPressureNotification(int i3) {
        _memoryPressureNotification(this.v8RuntimePtr, i3);
    }

    public void nativeDispatch() {
        _nativeDispatch(this.v8RuntimePtr);
    }

    public void nativeLoopStop() {
        _nativeLoopStop(this.v8RuntimePtr);
    }

    public void nativeMessageLoop() {
        _nativeMessageLoop(this.v8RuntimePtr);
    }

    public void onNativeRunJavaTask() {
        Runnable runnable = this.nativeJavaCallback_;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void onNativeTransMsgDispatchByJava() {
        JavaTaskScheduler javaTaskScheduler = this._javaTaskScheduler;
        if (javaTaskScheduler != null) {
            javaTaskScheduler.Schedule(new Runnable() { // from class: com.eclipsesource.mmv8.V8.2
                @Override // java.lang.Runnable
                public void run() {
                    V8._nativeTransHandleMessage(V8.this.v8RuntimePtr);
                }
            });
        }
    }

    public boolean pumpMessageLoop(boolean z16) {
        return _pumpMessageLoop(this.v8RuntimePtr, z16);
    }

    public void pumpMessageLoopDirect() {
        _pumpMessageLoopDirect(this.v8RuntimePtr);
    }

    public void registerCallback(Object obj, Method method, long j3, String str, boolean z16) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z16;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j3, str, isVoidMethod(method))), methodDescriptor);
    }

    public long registerJavaMethod(long j3, long j16, String str, boolean z16) {
        return _registerJavaMethod(j3, j16, str, z16);
    }

    public void registerResource(Releasable releasable) {
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        checkThread();
        if (this.executors == null) {
            this.executors = new V8Map<>();
        }
        this.executors.put2((V8Value) v8Object, (V8Object) v8Executor);
    }

    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j3, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j3, str, true)), methodDescriptor);
    }

    @Override // com.eclipsesource.mmv8.V8Value, com.eclipsesource.mmv8.Releasable
    public void release() {
        release(true);
    }

    public void releaseLock(long j3) {
        _releaseLock(j3);
    }

    public void releaseMethodDescriptor(long j3, long j16) {
        _releaseMethodDescriptor(j3, j16);
    }

    public void releaseObjRef(V8Value v8Value) {
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
    }

    public void releaseV8Context(long j3) {
        _releaseContext(this.v8RuntimePtr, j3);
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map == null) {
            return null;
        }
        return v8Map.remove(v8Object);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.remove(referenceHandler);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.remove(v8Runnable);
    }

    public boolean sameValue(long j3, long j16, long j17) {
        return _sameValue(j3, j16, j17);
    }

    public synchronized void setData(String str, Object obj) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
    }

    public void setDelaySaveCodeCache(boolean z16) {
        _setDelaySaveCodeCache(this.v8RuntimePtr, z16);
    }

    public void setJavaTaskScheduler(JavaTaskScheduler javaTaskScheduler) {
        this._javaTaskScheduler = javaTaskScheduler;
        _nativeTransSetJavaSchedule(1L);
    }

    public void setMinimalCodeLength(int i3) {
        _setMinimalCodeLength(this.v8RuntimePtr, i3);
    }

    public void setNativeJavaCallback(Runnable runnable) {
        this.nativeJavaCallback_ = runnable;
    }

    public void setPrototype(long j3, long j16, long j17) {
        _setPrototype(j3, j16, j17);
    }

    public void setWeak(long j3, long j16) {
        _setWeak(j3, j16);
    }

    public void shutdownExecutors(boolean z16) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map == null) {
            return;
        }
        for (V8Executor v8Executor : v8Map.values()) {
            if (z16) {
                v8Executor.forceTermination();
            } else {
                v8Executor.shutdown();
            }
        }
    }

    public boolean strictEquals(long j3, long j16, long j17) {
        return _strictEquals(j3, j16, j17);
    }

    public void switchV8Context(long j3) {
        _switchContext(this.v8RuntimePtr, j3);
    }

    public void terminateExecution() {
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
    }

    public String toString(long j3, long j16) {
        return _toString(j3, j16);
    }

    public void waitForDebugger(String str, boolean z16) {
        checkThread();
        _waitForDebuger(this.v8RuntimePtr, str, z16);
    }

    public void waitForDebuggerWithContexts(String str, long[] jArr, String[] strArr) {
        checkThread();
        _waitForDebuggerWithContexts(this.v8RuntimePtr, str, jArr, strArr);
    }

    public void wakeUpUVLoop() {
        _wakeUpUVLoop(this.v8RuntimePtr);
    }

    public void weakReferenceReleased(long j3) {
        V8Value v8Value = this.v8WeakReferences.get(Long.valueOf(j3));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j3));
            try {
                v8Value.release();
            } catch (Exception unused) {
            }
        }
    }

    public V8(String str, boolean z16, byte[] bArr, String str2, boolean z17, int i3) {
        super(null);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.objectReferences = 0L;
        this.v8RuntimePtr = 0L;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        this.releaseHandlers = new LinkedList<>();
        this._javaTaskScheduler = null;
        this.released = false;
        try {
            V8TracerAccessible.beginSection("CreateIsolate");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.v8RuntimePtr = _createIsolate(str, z16, bArr, str2, z17, i3);
            this.isolateCreateDurationMills = SystemClock.elapsedRealtime() - elapsedRealtime;
            V8TracerAccessible.endSection();
            this.locker = new V8Locker(this);
            checkThread();
            if (z16) {
                this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
            }
        } catch (Throwable th5) {
            V8TracerAccessible.endSection();
            throw th5;
        }
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    public void add(long j3, long j16, String str, boolean z16) {
        _add(j3, j16, str, z16);
    }

    public int arrayGetBooleans(long j3, long j16, int i3, int i16, boolean[] zArr) {
        return _arrayGetBooleans(j3, j16, i3, i16, zArr);
    }

    public int arrayGetBytes(long j3, long j16, int i3, int i16, byte[] bArr) {
        return _arrayGetBytes(j3, j16, i3, i16, bArr);
    }

    public int arrayGetDoubles(long j3, long j16, int i3, int i16, double[] dArr) {
        return _arrayGetDoubles(j3, j16, i3, i16, dArr);
    }

    public int arrayGetIntegers(long j3, long j16, int i3, int i16, int[] iArr) {
        return _arrayGetIntegers(j3, j16, i3, i16, iArr);
    }

    public int arrayGetStrings(long j3, long j16, int i3, int i16, String[] strArr) {
        return _arrayGetStrings(j3, j16, i3, i16, strArr);
    }

    public V8Array executeArrayScript(String str, String str2, int i3) {
        return executeArrayScript(str, str2, i3, null, null, 0, null);
    }

    public boolean executeBooleanScript(String str, String str2, int i3) {
        return executeBooleanScript(str, str2, i3, null, null, 0, null);
    }

    public double executeDoubleScript(String str, String str2, int i3) {
        return executeDoubleScript(str, str2, i3, null, null, 0, null);
    }

    public Object executeFunction(long j3, long j16, long j17, long j18) {
        return _executeFunction(j3, j16, j17, j18);
    }

    public int executeIntegerScript(String str, String str2, int i3) {
        return executeIntegerScript(str, str2, i3, null, null, 0, null);
    }

    public V8Object executeObjectScript(String str, String str2, int i3) {
        return executeObjectScript(str, str2, i3, null, null, 0, null);
    }

    public Object executeScript(String str, String str2, int i3) {
        return executeScript(str, str2, i3, null, null, 0, null);
    }

    public String executeStringScript(String str, String str2, int i3) {
        return executeStringScript(str, str2, i3, null, null, 0, null);
    }

    public void executeVoidScript(String str, String str2, int i3) {
        executeVoidScript(str, str2, i3, null, null, 0, null);
    }

    public int getType(long j3, long j16, String str) {
        return _getType(j3, j16, str);
    }

    public long initNewV8ArrayBuffer(long j3, int i3) {
        return _initNewV8ArrayBuffer(j3, i3);
    }

    public void release(boolean z16) {
        if (isReleased()) {
            return;
        }
        checkThread();
        try {
            notifyReleaseHandlers(this);
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            V8Map<V8Executor> v8Map = this.executors;
            if (v8Map != null) {
                v8Map.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
            }
            this.locker.release();
            _releaseRuntime(this.v8RuntimePtr);
            this.v8RuntimePtr = 0L;
            this.released = true;
            if (!z16 || getObjectReferenceCount() <= 0) {
                return;
            }
            throw new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
        } catch (Throwable th5) {
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            if (this.executors != null) {
                this.executors.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
                this.locker.release();
                _releaseRuntime(this.v8RuntimePtr);
                this.v8RuntimePtr = 0L;
                this.released = true;
                if (z16 && getObjectReferenceCount() > 0) {
                    throw new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
                }
                throw th5;
            }
        }
    }

    public static V8 createV8Runtime(String str, String str2) {
        return createV8Runtime(str, str2, true, null, null);
    }

    public void add(long j3, long j16, String str, double d16) {
        _add(j3, j16, str, d16);
    }

    public void createTwin(long j3, long j16, long j17) {
        _createTwin(j3, j16, j17);
    }

    public V8Array executeArrayScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        Object executeScript = executeScript(str, str2, i3, str3, str4, i16, executeDetails);
        if (executeScript instanceof V8Array) {
            return (V8Array) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        return executeBooleanScript(this.v8RuntimePtr, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public double executeDoubleScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        return executeDoubleScript(this.v8RuntimePtr, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public int executeIntegerScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        return executeIntegerScript(this.v8RuntimePtr, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public V8Object executeObjectScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        Object executeScript = executeScript(str, str2, i3, str3, str4, i16, executeDetails);
        if (executeScript instanceof V8Object) {
            return (V8Object) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public String executeStringScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        return executeStringScript(this.v8RuntimePtr, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public void executeVoidScript(String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public int getType(long j3, long j16, int i3) {
        return _getType(j3, j16, i3);
    }

    public void lowMemoryNotification(long j3) {
        _lowMemoryNotification(j3);
    }

    public void terminateExecution(long j3) {
        _terminateExecution(j3);
    }

    public static V8 createV8Runtime(String str, String str2, boolean z16) {
        return createV8Runtime(str, str2, z16, null, null);
    }

    public void add(long j3, long j16, String str, String str2) {
        _add(j3, j16, str, str2);
    }

    public Object executeFileScript(long j3, int i3, V8ScriptFileDescriptor v8ScriptFileDescriptor, String str, int i16, String str2, String str3, int i17, ExecuteDetails executeDetails) {
        return _executeFileScript(j3, i3, v8ScriptFileDescriptor, str, i16, str2, str3, i17, executeDetails);
    }

    public int getType(long j3, long j16, int i3, int i16) {
        return _getType(j3, j16, i3, i16);
    }

    public static V8 createV8Runtime(String str, String str2, boolean z16, String str3, byte[] bArr) {
        return createV8Runtime(str, str2, z16, str3, bArr, null, false, 2);
    }

    public Object batchExecuteScripts(long j3, V8ScriptEvaluateRequest[] v8ScriptEvaluateRequestArr, String str, ExecuteDetails executeDetails) {
        return _batchExecuteScripts(j3, v8ScriptEvaluateRequestArr, str, executeDetails);
    }

    public static V8 createV8Runtime(String str, String str2, boolean z16, String str3, byte[] bArr, String str4, boolean z17, int i3) {
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                if (!nativeLibraryLoaded) {
                    load(str2);
                }
            }
        }
        checkNativeLibraryLoaded();
        if (sCachedProtectCreateContextFromSnapshot.compareAndSet(true, false)) {
            _protectCreateContextFromSnapshot();
        }
        V8 v85 = new V8(str, z16, bArr, str4, z17, i3);
        if (str3 != null) {
            v85._setCodeCacheDir(v85.v8RuntimePtr, str3);
        }
        synchronized (lock) {
            runtimeCounter++;
        }
        return v85;
    }

    public boolean executeBooleanScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        return _executeBooleanScript(j3, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public double executeDoubleScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        return _executeDoubleScript(j3, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public int executeIntegerScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        return _executeIntegerScript(j3, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public Object executeScript(long j3, int i3, String str, String str2, int i16, String str3, String str4, int i17, ExecuteDetails executeDetails) {
        return _executeScript(j3, i3, str, str2, i16, str3, str4, i17, executeDetails);
    }

    public String executeStringScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        return _executeStringScript(j3, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public void executeVoidScript(long j3, String str, String str2, int i3, String str3, String str4, int i16, ExecuteDetails executeDetails) {
        _executeVoidScript(j3, str, str2, i3, str3, str4, i16, executeDetails);
    }

    public void registerCallback(JavaCallback javaCallback, long j3, String str) {
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j3, str, false));
    }

    public void release(long j3, long j16) {
        _release(j3, j16);
    }
}
