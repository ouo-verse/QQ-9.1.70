package com.eclipsesource.v8;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.inspector.V8InspectorDelegate;
import com.eclipsesource.v8.utils.V8Runnable;
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

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8 extends V8Object {
    private static boolean initialized = false;
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError;
    private static Exception nativeLoadException;
    private static volatile int runtimeCounter;
    private static String v8Flags;
    private Map<String, Object> data;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    private final V8Locker locker;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private SignatureProvider signatureProvider;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;
    private static Object lock = new Object();
    private static V8Value undefined = new V8Object.Undefined();
    private static Object invalid = new Object();

    /* JADX INFO: Access modifiers changed from: private */
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

    protected V8() {
        this(null);
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

    private native void _clearWeak(long j3, long j16);

    private native boolean _contains(long j3, long j16, String str);

    private native long _createInspector(long j3, V8InspectorDelegate v8InspectorDelegate, String str);

    private native long _createIsolate(String str);

    private native void _createTwin(long j3, long j16, long j17);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j3, long j16, int i3);

    private native void _dispatchProtocolMessage(long j3, long j16, String str);

    private native boolean _equals(long j3, long j16, long j17);

    private native boolean _executeBooleanFunction(long j3, long j16, String str, long j17);

    private native boolean _executeBooleanScript(long j3, String str, String str2, int i3);

    private native double _executeDoubleFunction(long j3, long j16, String str, long j17);

    private native double _executeDoubleScript(long j3, String str, String str2, int i3);

    private native Object _executeFunction(long j3, int i3, long j16, String str, long j17);

    private native Object _executeFunction(long j3, long j16, long j17, long j18);

    private native int _executeIntegerFunction(long j3, long j16, String str, long j17);

    private native int _executeIntegerScript(long j3, String str, String str2, int i3);

    private native Object _executeScript(long j3, int i3, String str, String str2, int i16);

    private native String _executeStringFunction(long j3, long j16, String str, long j17);

    private native String _executeStringScript(long j3, String str, String str2, int i3);

    private native void _executeVoidFunction(long j3, long j16, String str, long j17);

    private native void _executeVoidScript(long j3, String str, String str2, int i3);

    private native Object _get(long j3, int i3, long j16, String str);

    private native int _getArrayType(long j3, long j16);

    private native boolean _getBoolean(long j3, long j16, String str);

    private static native long _getBuildID();

    private native String _getConstructorName(long j3, long j16);

    private native double _getDouble(long j3, long j16, String str);

    private native long _getGlobalObject(long j3);

    private native int _getInteger(long j3, long j16, String str);

    private native String[] _getKeys(long j3, long j16);

    private native String _getString(long j3, long j16, String str);

    private native int _getType(long j3, long j16);

    private native int _getType(long j3, long j16, int i3);

    private native int _getType(long j3, long j16, int i3, int i16);

    private native int _getType(long j3, long j16, String str);

    private static native String _getVersion();

    private native int _identityHash(long j3, long j16);

    private native long _initEmptyContainer(long j3);

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

    private static native boolean _isNodeCompatible();

    private static native boolean _isRunning(long j3);

    private native boolean _isWeak(long j3, long j16);

    private native void _lowMemoryNotification(long j3);

    private static native boolean _pumpMessageLoop(long j3);

    private native long _registerJavaMethod(long j3, long j16, String str, boolean z16);

    private native void _release(long j3, long j16);

    private native void _releaseLock(long j3);

    private native void _releaseMethodDescriptor(long j3, long j16);

    private native void _releaseRuntime(long j3);

    private native boolean _sameValue(long j3, long j16, long j17);

    private native void _schedulePauseOnNextStatement(long j3, long j16, String str);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j3, long j16, long j17);

    private native void _setWeak(long j3, long j16);

    private static native void _startNodeJS(long j3, String str);

    private native boolean _strictEquals(long j3, long j16, long j17);

    private native void _terminateExecution(long j3);

    private native String _toString(long j3, long j16);

    private void checkArgs(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == invalid) {
                throw new IllegalArgumentException("argument type mismatch");
            }
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

    static void checkScript(String str) {
        if (str != null) {
        } else {
            throw new NullPointerException("Script is null");
        }
    }

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

    public static long getBuildID() {
        return _getBuildID();
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

    public static String getSCMRevision() {
        return "Unknown revision ID";
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

    private boolean isVoidMethod(Method method) {
        if (method.getReturnType().equals(Void.TYPE)) {
            return true;
        }
        return false;
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

    private void populateParamters(V8Array v8Array, int i3, Object[] objArr, List<Object> list, boolean z16) {
        for (int i16 = z16 ? 1 : 0; i16 < v8Array.length() + (z16 ? 1 : 0); i16++) {
            if (i16 >= i3) {
                list.add(getArrayItem(v8Array, i16 - (z16 ? 1 : 0)));
            } else {
                objArr[i16] = getArrayItem(v8Array, i16 - (z16 ? 1 : 0));
            }
        }
    }

    private void releaseArguments(Object[] objArr, boolean z16) {
        if (z16 && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : (Object[]) objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).close();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).close();
            }
        }
    }

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
        initialized = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acquireLock(long j3) {
        _acquireLock(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j3, long j16, String str, int i3) {
        _add(j3, j16, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayBooleanItem(long j3, long j16, boolean z16) {
        _addArrayBooleanItem(j3, j16, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayDoubleItem(long j3, long j16, double d16) {
        _addArrayDoubleItem(j3, j16, d16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayIntItem(long j3, long j16, int i3) {
        _addArrayIntItem(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayNullItem(long j3, long j16) {
        _addArrayNullItem(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayObjectItem(long j3, long j16, long j17) {
        _addArrayObjectItem(j3, j16, j17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayStringItem(long j3, long j16, String str) {
        _addArrayStringItem(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addArrayUndefinedItem(long j3, long j16) {
        _addArrayUndefinedItem(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addNull(long j3, long j16, String str) {
        _addNull(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addObjRef(V8Value v8Value) {
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addObject(long j3, long j16, String str, long j17) {
        _addObject(j3, j16, str, j17);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.add(0, referenceHandler);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.add(v8Runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addUndefined(long j3, long j16, String str) {
        _addUndefined(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object arrayGet(long j3, int i3, long j16, int i16) {
        return _arrayGet(j3, i3, j16, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arrayGetBoolean(long j3, long j16, int i3) {
        return _arrayGetBoolean(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean[] arrayGetBooleans(long j3, long j16, int i3, int i16) {
        return _arrayGetBooleans(j3, j16, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte arrayGetByte(long j3, long j16, int i3) {
        return _arrayGetByte(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] arrayGetBytes(long j3, long j16, int i3, int i16) {
        return _arrayGetBytes(j3, j16, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double arrayGetDouble(long j3, long j16, int i3) {
        return _arrayGetDouble(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double[] arrayGetDoubles(long j3, long j16, int i3, int i16) {
        return _arrayGetDoubles(j3, j16, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetInteger(long j3, long j16, int i3) {
        return _arrayGetInteger(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] arrayGetIntegers(long j3, long j16, int i3, int i16) {
        return _arrayGetIntegers(j3, j16, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetSize(long j3, long j16) {
        return _arrayGetSize(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String arrayGetString(long j3, long j16, int i3) {
        return _arrayGetString(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] arrayGetStrings(long j3, long j16, int i3, int i16) {
        return _arrayGetStrings(j3, j16, i3, i16);
    }

    protected Object callObjectJavaMethod(long j3, V8Object v8Object, V8Array v8Array) throws Throwable {
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

    protected void callVoidJavaMethod(long j3, V8Object v8Object, V8Array v8Array) throws Throwable {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkRuntime(V8Value v8Value) {
        if (v8Value != null && !v8Value.isUndefined()) {
            V8 runtime = v8Value.getRuntime();
            if (runtime != null && !runtime.isReleased() && runtime == this) {
            } else {
                throw new Error("Invalid target runtime");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkThread() {
        this.locker.checkThread();
        if (!isReleased()) {
        } else {
            throw new Error("Runtime disposed error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearWeak(long j3, long j16) {
        _clearWeak(j3, j16);
    }

    @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean contains(long j3, long j16, String str) {
        return _contains(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j3) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j3), methodDescriptor);
    }

    public long createInspector(V8InspectorDelegate v8InspectorDelegate, String str) {
        return _createInspector(this.v8RuntimePtr, v8InspectorDelegate, str);
    }

    void createNodeRuntime(String str) {
        _startNodeJS(this.v8RuntimePtr, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer createV8ArrayBufferBackingStore(long j3, long j16, int i3) {
        return _createV8ArrayBufferBackingStore(j3, j16, i3);
    }

    public void dispatchProtocolMessage(long j3, String str) {
        checkThread();
        _dispatchProtocolMessage(this.v8RuntimePtr, j3, str);
    }

    protected void disposeMethodID(long j3) {
        this.functionRegistry.remove(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(long j3, long j16, long j17) {
        return _equals(j3, j16, j17);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean executeBooleanFunction(long j3, long j16, String str, long j17) {
        return _executeBooleanFunction(j3, j16, str, j17);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double executeDoubleFunction(long j3, long j16, String str, long j17) {
        return _executeDoubleFunction(j3, j16, str, j17);
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object executeFunction(long j3, int i3, long j16, String str, long j17) {
        return _executeFunction(j3, i3, j16, str, j17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int executeIntegerFunction(long j3, long j16, String str, long j17) {
        return _executeIntegerFunction(j3, j16, str, j17);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, null, 0);
    }

    public Object executeModule(String str, String str2, String str3, String str4) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str2 + str + str3, str4, 0);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, null, 0);
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String executeStringFunction(long j3, long j16, String str, long j17) {
        return _executeStringFunction(j3, j16, str, j17);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeVoidFunction(long j3, long j16, String str, long j17) {
        _executeVoidFunction(j3, j16, str, j17);
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object get(long j3, int i3, long j16, String str) {
        return _get(j3, i3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getArrayType(long j3, long j16) {
        return _getArrayType(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getBoolean(long j3, long j16, String str) {
        return _getBoolean(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getConstructorName(long j3, long j16) {
        return _getConstructorName(j3, j16);
    }

    public Object getData(String str) {
        Map<String, Object> map = this.data;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double getDouble(long j3, long j16, String str) {
        return _getDouble(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInteger(long j3, long j16, String str) {
        return _getInteger(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getKeys(long j3, long j16) {
        return _getKeys(j3, j16);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - this.v8WeakReferences.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(long j3, long j16, String str) {
        return _getString(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j3, long j16) {
        return _getType(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int identityHash(long j3, long j16) {
        return _identityHash(j3, j16);
    }

    protected long initEmptyContainer(long j3) {
        return _initEmptyContainer(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8Array(long j3) {
        return _initNewV8Array(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long initNewV8ArrayBuffer(long j3, ByteBuffer byteBuffer, int i3) {
        return _initNewV8ArrayBuffer(j3, byteBuffer, i3);
    }

    public long initNewV8Float32Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Float32Array(j3, j16, i3, i16);
    }

    public long initNewV8Float64Array(long j3, long j16, int i3, int i16) {
        return _initNewV8Float64Array(j3, j16, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
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

    boolean isRunning() {
        return _isRunning(this.v8RuntimePtr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isWeak(long j3, long j16) {
        return _isWeak(j3, j16);
    }

    public void lowMemoryNotification() {
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
    }

    boolean pumpMessageLoop() {
        return _pumpMessageLoop(this.v8RuntimePtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerCallback(Object obj, Method method, long j3, String str, boolean z16) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z16;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j3, str, isVoidMethod(method))), methodDescriptor);
    }

    protected long registerJavaMethod(long j3, long j16, String str, boolean z16) {
        return _registerJavaMethod(j3, j16, str, z16);
    }

    public void registerResource(Releasable releasable) {
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j3, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j3, str, true)), methodDescriptor);
    }

    @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable
    @Deprecated
    public void release() {
        release(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseLock(long j3) {
        _releaseLock(j3);
    }

    protected void releaseMethodDescriptor(long j3, long j16) {
        _releaseMethodDescriptor(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseObjRef(V8Value v8Value) {
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.remove(referenceHandler);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.remove(v8Runnable);
    }

    protected boolean sameValue(long j3, long j16, long j17) {
        return _sameValue(j3, j16, j17);
    }

    public void schedulePauseOnNextStatement(long j3, String str) {
        checkThread();
        _schedulePauseOnNextStatement(this.v8RuntimePtr, j3, str);
    }

    public synchronized void setData(String str, Object obj) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrototype(long j3, long j16, long j17) {
        _setPrototype(j3, j16, j17);
    }

    public void setSignatureProvider(SignatureProvider signatureProvider) {
        this.signatureProvider = signatureProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWeak(long j3, long j16) {
        _setWeak(j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean strictEquals(long j3, long j16, long j17) {
        return _strictEquals(j3, j16, j17);
    }

    public void terminateExecution() {
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toString(long j3, long j16) {
        return _toString(j3, j16);
    }

    protected void weakReferenceReleased(long j3) {
        V8Value v8Value = this.v8WeakReferences.get(Long.valueOf(j3));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j3));
            try {
                v8Value.close();
            } catch (Exception unused) {
            }
        }
    }

    protected V8(String str) {
        super(null);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.signatureProvider = null;
        this.objectReferences = 0L;
        this.v8RuntimePtr = 0L;
        this.resources = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        this.releaseHandlers = new LinkedList<>();
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str);
        this.locker = new V8Locker(this);
        checkThread();
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j3, long j16, String str, boolean z16) {
        _add(j3, j16, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetBooleans(long j3, long j16, int i3, int i16, boolean[] zArr) {
        return _arrayGetBooleans(j3, j16, i3, i16, zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetBytes(long j3, long j16, int i3, int i16, byte[] bArr) {
        return _arrayGetBytes(j3, j16, i3, i16, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetDoubles(long j3, long j16, int i3, int i16, double[] dArr) {
        return _arrayGetDoubles(j3, j16, i3, i16, dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetIntegers(long j3, long j16, int i3, int i16, int[] iArr) {
        return _arrayGetIntegers(j3, j16, i3, i16, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int arrayGetStrings(long j3, long j16, int i3, int i16, String[] strArr) {
        return _arrayGetStrings(j3, j16, i3, i16, strArr);
    }

    public V8Array executeArrayScript(String str, String str2, int i3) {
        checkThread();
        Object executeScript = executeScript(str, str2, i3);
        if (executeScript instanceof V8Array) {
            return (V8Array) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        return executeBooleanScript(this.v8RuntimePtr, str, str2, i3);
    }

    public double executeDoubleScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        return executeDoubleScript(this.v8RuntimePtr, str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object executeFunction(long j3, long j16, long j17, long j18) {
        return _executeFunction(j3, j16, j17, j18);
    }

    public int executeIntegerScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        return executeIntegerScript(this.v8RuntimePtr, str, str2, i3);
    }

    public V8Object executeObjectScript(String str, String str2, int i3) {
        checkThread();
        Object executeScript = executeScript(str, str2, i3);
        if (executeScript instanceof V8Object) {
            return (V8Object) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str, String str2) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, 0);
    }

    public String executeStringScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        return executeStringScript(this.v8RuntimePtr, str, str2, i3);
    }

    public void executeVoidScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j3, long j16, String str) {
        return _getType(j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
            }
            _releaseRuntime(this.v8RuntimePtr);
            this.v8RuntimePtr = 0L;
            this.released = true;
            if (!z16 || getObjectReferenceCount() <= 0) {
                return;
            }
            throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
        } catch (Throwable th5) {
            releaseResources();
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                runtimeCounter--;
                _releaseRuntime(this.v8RuntimePtr);
                this.v8RuntimePtr = 0L;
                this.released = true;
                if (z16 && getObjectReferenceCount() > 0) {
                    throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
                }
                throw th5;
            }
        }
    }

    public static V8 createV8Runtime(String str, String str2) {
        if (!initialized) {
            _setFlags(v8Flags);
            initialized = true;
        }
        V8 v85 = new V8(str);
        synchronized (lock) {
            runtimeCounter++;
        }
        return v85;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j3, long j16, String str, double d16) {
        _add(j3, j16, str, d16);
    }

    protected void createTwin(long j3, long j16, long j17) {
        _createTwin(j3, j16, j17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j3, long j16, int i3) {
        return _getType(j3, j16, i3);
    }

    protected void lowMemoryNotification(long j3) {
        _lowMemoryNotification(j3);
    }

    protected void terminateExecution(long j3) {
        _terminateExecution(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add(long j3, long j16, String str, String str2) {
        _add(j3, j16, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getType(long j3, long j16, int i3, int i16) {
        return _getType(j3, j16, i3, i16);
    }

    protected boolean executeBooleanScript(long j3, String str, String str2, int i3) {
        return _executeBooleanScript(j3, str, str2, i3);
    }

    protected double executeDoubleScript(long j3, String str, String str2, int i3) {
        return _executeDoubleScript(j3, str, str2, i3);
    }

    protected int executeIntegerScript(long j3, String str, String str2, int i3) {
        return _executeIntegerScript(j3, str, str2, i3);
    }

    public Object executeScript(String str, String str2, int i3) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i3);
    }

    protected String executeStringScript(long j3, String str, String str2, int i3) {
        return _executeStringScript(j3, str, str2, i3);
    }

    protected void executeVoidScript(long j3, String str, String str2, int i3) {
        _executeVoidScript(j3, str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerCallback(JavaCallback javaCallback, long j3, String str) {
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j3, str, false));
    }

    protected Object executeScript(long j3, int i3, String str, String str2, int i16) {
        return _executeScript(j3, i3, str, str2, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release(long j3, long j16) {
        _release(j3, j16);
    }
}
