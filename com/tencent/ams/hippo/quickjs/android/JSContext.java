package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSContext implements Closeable {
    static IPatchRedirector $redirector_ = null;
    private static final int EVAL_FLAG_MASK = 24;
    public static final int EVAL_FLAG_STRICT = 8;
    public static final int EVAL_FLAG_STRIP = 16;
    public static final int EVAL_TYPE_GLOBAL = 0;
    public static final int EVAL_TYPE_MODULE = 1;
    static final int TYPE_BOOLEAN = 1;
    static final int TYPE_EXCEPTION = 6;
    static final int TYPE_FLOAT64 = 7;
    static final int TYPE_INT = 0;
    static final int TYPE_NULL = 2;
    static final int TYPE_OBJECT = -1;
    static final int TYPE_STRING = -7;
    static final int TYPE_SYMBOL = -8;
    static final int TYPE_UNDEFINED = 3;
    private final NativeCleaner<JSValue> cleaner;
    final JSRuntime jsRuntime;
    long pointer;
    public final QuickJS quickJS;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class JSValueCleaner extends NativeCleaner<JSValue> {
        static IPatchRedirector $redirector_;

        JSValueCleaner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) JSContext.this);
        }

        @Override // com.tencent.ams.hippo.quickjs.android.NativeCleaner
        public void onRemove(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                QuickJS.destroyValue(JSContext.this.pointer, j3);
            }
        }

        /* synthetic */ JSValueCleaner(JSContext jSContext, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSContext(long j3, QuickJS quickJS, JSRuntime jSRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), quickJS, jSRuntime);
            return;
        }
        this.pointer = j3;
        this.quickJS = quickJS;
        this.jsRuntime = jSRuntime;
        this.cleaner = new JSValueCleaner(this, null);
    }

    private void checkArrayBounds(int i3, int i16, int i17) {
        if (i16 >= 0 && i17 > 0 && i16 + i17 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("start = " + i16 + ", length = " + i17 + ", but array.length = " + i3);
    }

    private <T> T evaluateBytecodeInternal(byte[] bArr, String str, TypeAdapter<T> typeAdapter) {
        synchronized (this.jsRuntime) {
            checkClosed();
            long evaluateBytecode = QuickJS.evaluateBytecode(this.pointer, bArr, str);
            if (typeAdapter != null) {
                return typeAdapter.fromJSValue(this, wrapAsJSValue(evaluateBytecode));
            }
            try {
                if (QuickJS.getValueTag(evaluateBytecode) != 6) {
                    return null;
                }
                throw new JSEvaluationException(QuickJS.getException(this.pointer));
            } finally {
                QuickJS.destroyValue(this.pointer, evaluateBytecode);
            }
        }
    }

    private <T> T evaluateInternal(String str, String str2, int i3, int i16, @Nullable TypeAdapter<T> typeAdapter) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Invalid type: " + i3);
        }
        if ((i16 & (-25)) == 0) {
            synchronized (this.jsRuntime) {
                checkClosed();
                long evaluate = QuickJS.evaluate(this.pointer, str, str2, i3 | i16);
                if (typeAdapter != null) {
                    return typeAdapter.fromJSValue(this, wrapAsJSValue(evaluate));
                }
                try {
                    if (QuickJS.getValueTag(evaluate) != 6) {
                        return null;
                    }
                    throw new JSEvaluationException(QuickJS.getException(this.pointer));
                } finally {
                    QuickJS.destroyValue(this.pointer, evaluate);
                }
            }
        }
        throw new IllegalArgumentException("Invalid flags: " + i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long checkClosed() {
        if (this.pointer != 0) {
            this.cleaner.clean();
            return this.pointer;
        }
        throw new IllegalStateException("The JSContext is closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        synchronized (this.jsRuntime) {
            if (this.pointer != 0) {
                this.cleaner.forceClean();
                long j3 = this.pointer;
                this.pointer = 0L;
                QuickJS.destroyContext(j3);
            }
        }
    }

    public JSArray createJSArray() {
        JSArray jSArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (JSArray) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArray = (JSArray) wrapAsJSValue(QuickJS.createValueArray(this.pointer)).cast(JSArray.class);
        }
        return jSArray;
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? createJSArrayBuffer(zArr, 0, zArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) zArr);
    }

    public JSBoolean createJSBoolean(boolean z16) {
        JSBoolean jSBoolean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (JSBoolean) iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSBoolean = (JSBoolean) wrapAsJSValue(QuickJS.createValueBoolean(this.pointer, z16)).cast(JSBoolean.class);
        }
        return jSBoolean;
    }

    public JSFunction createJSFunction(Object obj, JavaMethod javaMethod) {
        JSFunction jSFunction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (JSFunction) iPatchRedirector.redirect((short) 39, (Object) this, obj, (Object) javaMethod);
        }
        if (obj == null) {
            throw new NullPointerException("instance == null");
        }
        if (javaMethod != null) {
            synchronized (this.jsRuntime) {
                checkClosed();
                jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, obj, javaMethod.name, javaMethod.getSignature(), javaMethod.returnType, javaMethod.parameterTypes, false)).cast(JSFunction.class);
            }
            return jSFunction;
        }
        throw new NullPointerException("method == null");
    }

    public JSFunction createJSFunctionS(Class<?> cls, JavaMethod javaMethod) {
        JSFunction jSFunction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (JSFunction) iPatchRedirector.redirect((short) 41, (Object) this, (Object) cls, (Object) javaMethod);
        }
        if (cls != null) {
            if (javaMethod != null) {
                String name = cls.getName();
                StringBuilder sb5 = new StringBuilder(name.length());
                for (int i3 = 0; i3 < name.length(); i3++) {
                    char charAt = name.charAt(i3);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    sb5.append(charAt);
                }
                String sb6 = sb5.toString();
                synchronized (this.jsRuntime) {
                    checkClosed();
                    jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunctionS(this.pointer, this, sb6, javaMethod.name, javaMethod.getSignature(), javaMethod.returnType, javaMethod.parameterTypes)).cast(JSFunction.class);
                }
                return jSFunction;
            }
            throw new NullPointerException("method == null");
        }
        throw new NullPointerException("clazz == null");
    }

    public JSNull createJSNull() {
        JSNull jSNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (JSNull) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNull = (JSNull) wrapAsJSValue(QuickJS.createValueNull(this.pointer)).cast(JSNull.class);
        }
        return jSNull;
    }

    public JSNumber createJSNumber(int i3) {
        JSNumber jSNumber;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (JSNumber) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueInt(this.pointer, i3)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    public JSObject createJSObject() {
        JSObject jSObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (JSObject) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSObject createJSPromise(PromiseExecutor promiseExecutor) {
        JSValue wrapAsJSValue;
        JSValue wrapAsJSValue2;
        JSValue wrapAsJSValue3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (JSObject) iPatchRedirector.redirect((short) 42, (Object) this, (Object) promiseExecutor);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            long[] createValuePromise = QuickJS.createValuePromise(this.pointer);
            if (createValuePromise != null) {
                for (long j3 : createValuePromise) {
                    if (QuickJS.getValueTag(j3) == 6) {
                        for (long j16 : createValuePromise) {
                            QuickJS.destroyValue(this.pointer, j16);
                        }
                        throw new JSEvaluationException(QuickJS.getException(this.pointer));
                    }
                }
                wrapAsJSValue = wrapAsJSValue(createValuePromise[0]);
                wrapAsJSValue2 = wrapAsJSValue(createValuePromise[1]);
                wrapAsJSValue3 = wrapAsJSValue(createValuePromise[2]);
            } else {
                throw new NullPointerException("result == null");
            }
        }
        promiseExecutor.execute((JSFunction) wrapAsJSValue2.cast(JSFunction.class), (JSFunction) wrapAsJSValue3.cast(JSFunction.class));
        return (JSObject) wrapAsJSValue.cast(JSObject.class);
    }

    public JSString createJSString(String str) {
        JSString jSString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (JSString) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSString = (JSString) wrapAsJSValue(QuickJS.createValueString(this.pointer, str)).cast(JSString.class);
        }
        return jSString;
    }

    public JSUndefined createJSUndefined() {
        JSUndefined jSUndefined;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (JSUndefined) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSUndefined = (JSUndefined) wrapAsJSValue(QuickJS.createValueUndefined(this.pointer)).cast(JSUndefined.class);
        }
        return jSUndefined;
    }

    public void evaluate(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            evaluateInternal(str, str2, 0, 0, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    public void evaluateBytecode(byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            evaluateBytecodeInternal(bArr, str, null);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr, (Object) str);
        }
    }

    public boolean executePendingJob() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            int executePendingJob = QuickJS.executePendingJob(this.pointer);
            if (executePendingJob >= 0) {
                if (executePendingJob != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            } else {
                throw new JSEvaluationException(QuickJS.getException(this.pointer));
            }
        }
        return z16;
    }

    public JSObject getGlobalObject() {
        JSObject jSObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (JSObject) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.getGlobalObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    int getNotRemovedJSValueCount() {
        int size;
        synchronized (this.jsRuntime) {
            size = this.cleaner.size();
        }
        return size;
    }

    public QuickJS getQuickJS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QuickJS) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.quickJS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue wrapAsJSValue(long j3) {
        JSValue jSSymbol;
        if (j3 != 0) {
            int valueTag = QuickJS.getValueTag(j3);
            if (valueTag != -8) {
                if (valueTag != -7) {
                    if (valueTag != -1) {
                        if (valueTag != 0) {
                            if (valueTag != 1) {
                                if (valueTag != 2) {
                                    if (valueTag != 3) {
                                        if (valueTag != 6) {
                                            if (valueTag != 7) {
                                                jSSymbol = new JSInternal(j3, this);
                                            } else {
                                                jSSymbol = new JSFloat64(j3, this, QuickJS.getValueFloat64(j3));
                                            }
                                        } else {
                                            QuickJS.destroyValue(this.pointer, j3);
                                            throw new JSEvaluationException(QuickJS.getException(this.pointer));
                                        }
                                    } else {
                                        jSSymbol = new JSUndefined(j3, this);
                                    }
                                } else {
                                    jSSymbol = new JSNull(j3, this);
                                }
                            } else {
                                jSSymbol = new JSBoolean(j3, this, QuickJS.getValueBoolean(j3));
                            }
                        } else {
                            jSSymbol = new JSInt(j3, this, QuickJS.getValueInt(j3));
                        }
                    } else if (QuickJS.isValueFunction(this.pointer, j3)) {
                        jSSymbol = new JSFunction(j3, this);
                    } else if (QuickJS.isValueArray(this.pointer, j3)) {
                        jSSymbol = new JSArray(j3, this);
                    } else if (QuickJS.isValueArrayBuffer(this.pointer, j3)) {
                        jSSymbol = new JSArrayBuffer(j3, this);
                    } else {
                        jSSymbol = new JSObject(j3, this, QuickJS.getValueJavaObject(this.pointer, j3));
                    }
                } else {
                    jSSymbol = new JSString(j3, this, QuickJS.getValueString(this.pointer, j3));
                }
            } else {
                jSSymbol = new JSSymbol(j3, this);
            }
            this.cleaner.register(jSSymbol, j3);
            return jSSymbol;
        }
        throw new IllegalStateException("Can't wrap null pointer as JSValue");
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 24, this, zArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(zArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferZ(this.pointer, zArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public void evaluate(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            evaluateInternal(str, str2, i3, i16, null);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public <T> T evaluateBytecode(byte[] bArr, String str, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? (T) evaluateBytecodeInternal(bArr, str, this.quickJS.getAdapter(cls)) : (T) iPatchRedirector.redirect((short) 11, this, bArr, str, cls);
    }

    public <T> T evaluate(String str, String str2, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (T) evaluateInternal(str, str2, 0, 0, this.quickJS.getAdapter(cls)) : (T) iPatchRedirector.redirect((short) 5, this, str, str2, cls);
    }

    public <T> T evaluate(String str, String str2, Type type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? (T) evaluateInternal(str, str2, 0, 0, this.quickJS.getAdapter(type)) : (T) iPatchRedirector.redirect((short) 6, this, str, str2, type);
    }

    public <T> T evaluate(String str, String str2, TypeAdapter<T> typeAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? (T) evaluateInternal(str, str2, 0, 0, typeAdapter) : (T) iPatchRedirector.redirect((short) 7, this, str, str2, typeAdapter);
    }

    public JSNumber createJSNumber(double d16) {
        JSNumber jSNumber;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (JSNumber) iPatchRedirector.redirect((short) 18, this, Double.valueOf(d16));
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueFloat64(this.pointer, d16)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    public JSObject createJSObject(Object obj) {
        JSObject jSObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (JSObject) iPatchRedirector.redirect((short) 21, (Object) this, obj);
        }
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueJavaObject(this.pointer, obj)).cast(JSObject.class);
        }
        return jSObject;
    }

    public <T> T evaluate(String str, String str2, int i3, int i16, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? (T) evaluateInternal(str, str2, i3, i16, this.quickJS.getAdapter(cls)) : (T) iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), cls);
    }

    public <T> T evaluate(String str, String str2, int i3, int i16, TypeAdapter<T> typeAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? (T) evaluateInternal(str, str2, i3, i16, typeAdapter) : (T) iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), typeAdapter);
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? createJSArrayBuffer(bArr, 0, bArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) bArr);
    }

    public JSFunction createJSFunction(JSFunctionCallback jSFunctionCallback) {
        JSFunction jSFunction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (JSFunction) iPatchRedirector.redirect((short) 40, (Object) this, (Object) jSFunctionCallback);
        }
        if (jSFunctionCallback != null) {
            synchronized (this.jsRuntime) {
                checkClosed();
                jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, jSFunctionCallback, "invoke", "(Lcom/tencent/ams/hippo/quickjs/android/JSContext;[Lcom/tencent/ams/hippo/quickjs/android/JSValue;)Lcom/tencent/ams/hippo/quickjs/android/JSValue;", JSValue.class, new Class[]{JSContext.class, JSValue[].class}, true)).cast(JSFunction.class);
            }
            return jSFunction;
        }
        throw new NullPointerException("callback == null");
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 26, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(bArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferB(this.pointer, bArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) ? createJSArrayBuffer(cArr, 0, cArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) cArr);
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 28, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(cArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferC(this.pointer, cArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? createJSArrayBuffer(sArr, 0, sArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) sArr);
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 30, this, sArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(sArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferS(this.pointer, sArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? createJSArrayBuffer(iArr, 0, iArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) iArr);
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 32, this, iArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(iArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferI(this.pointer, iArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? createJSArrayBuffer(jArr, 0, jArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 33, (Object) this, (Object) jArr);
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 34, this, jArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(jArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferJ(this.pointer, jArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) ? createJSArrayBuffer(fArr, 0, fArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 35, (Object) this, (Object) fArr);
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 36, this, fArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(fArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferF(this.pointer, fArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) ? createJSArrayBuffer(dArr, 0, dArr.length) : (JSArrayBuffer) iPatchRedirector.redirect((short) 37, (Object) this, (Object) dArr);
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr, int i3, int i16) {
        JSArrayBuffer jSArrayBuffer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (JSArrayBuffer) iPatchRedirector.redirect((short) 38, this, dArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        checkArrayBounds(dArr.length, i3, i16);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferD(this.pointer, dArr, i3, i16)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }
}
