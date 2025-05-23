package com.tencent.ams.hippo.quickjs.android;

import com.tencent.ams.hippo.quickjs.android.JSRuntime;
import com.tencent.ams.hippo.quickjs.android.QuickJS;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QuickJS {
    static IPatchRedirector $redirector_;
    private static final List<TypeAdapter.Factory> BUILT_IN_FACTORIES;
    private final Map<Type, TypeAdapter<?>> adapterCache;
    private final List<TypeAdapter.Factory> factories;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final List<TypeAdapter.Factory> factories;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.factories = new ArrayList();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TypeAdapter lambda$registerTypeAdapter$0(Type type, TypeAdapter typeAdapter, QuickJS quickJS, Type type2) {
            if (JavaTypes.equals(type, type2)) {
                return typeAdapter;
            }
            return null;
        }

        public QuickJS build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (QuickJS) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new QuickJS(this, null);
        }

        public <T> Builder registerTypeAdapter(final Type type, final TypeAdapter<T> typeAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type, (Object) typeAdapter);
            }
            return registerTypeAdapterFactory(new TypeAdapter.Factory() { // from class: com.tencent.ams.hippo.quickjs.android.d
                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
                public final TypeAdapter create(QuickJS quickJS, Type type2) {
                    TypeAdapter lambda$registerTypeAdapter$0;
                    lambda$registerTypeAdapter$0 = QuickJS.Builder.lambda$registerTypeAdapter$0(type, typeAdapter, quickJS, type2);
                    return lambda$registerTypeAdapter$0;
                }
            });
        }

        public Builder registerTypeAdapterFactory(TypeAdapter.Factory factory) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) factory);
            }
            this.factories.add(factory);
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        BUILT_IN_FACTORIES = arrayList;
        arrayList.add(StandardTypeAdapters.FACTORY);
        arrayList.add(JSValueAdapter.FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(InterfaceTypeAdapter.FACTORY);
    }

    /* synthetic */ QuickJS(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createContext(long j3);

    static native long createRuntime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArray(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferB(long j3, byte[] bArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferC(long j3, char[] cArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferD(long j3, double[] dArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferF(long j3, float[] fArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferI(long j3, int[] iArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferJ(long j3, long[] jArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferS(long j3, short[] sArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueArrayBufferZ(long j3, boolean[] zArr, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueBoolean(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFloat64(long j3, double d16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunction(long j3, JSContext jSContext, Object obj, String str, String str2, Type type, Type[] typeArr, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueFunctionS(long j3, JSContext jSContext, String str, String str2, String str3, Type type, Type[] typeArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueInt(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueJavaObject(long j3, Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueNull(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueObject(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long[] createValuePromise(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueString(long j3, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long createValueUndefined(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j3, long j16, int i3, long j17, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean defineValueProperty(long j3, long j16, String str, long j17, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyContext(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyRuntime(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyValue(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long evaluate(long j3, String str, String str2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long evaluateBytecode(long j3, byte[] bArr, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int executePendingJob(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native JSException getException(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getGlobalObject(long j3);

    public static native String getQuickJSSoVersion();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean getValueBoolean(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native double getValueFloat64(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueInt(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Object getValueJavaObject(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j3, long j16, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long getValueProperty(long j3, long j16, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String getValueString(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getValueTag(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long invokeValueFunction(long j3, long j16, long j17, long[] jArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueArrayBuffer(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean isValueFunction(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeInterruptHandler(long j3, JSRuntime.InterruptHandler interruptHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setRuntimeMallocLimit(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j3, long j16, int i3, long j17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setValueProperty(long j3, long j16, String str, long j17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean[] toBooleanArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] toByteArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native char[] toCharArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native double[] toDoubleArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native float[] toFloatArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int[] toIntArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long[] toLongArray(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native short[] toShortArray(long j3, long j16);

    public JSRuntime createJSRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long createRuntime = createRuntime();
        if (createRuntime != 0) {
            return new JSRuntime(createRuntime, this);
        }
        throw new IllegalStateException("Cannot create JSRuntime instance");
    }

    public <T> TypeAdapter<T> getAdapter(Type type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TypeAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
        }
        Type removeSubtypeWildcard = JavaTypes.removeSubtypeWildcard(JavaTypes.canonicalize(type));
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.adapterCache.get(removeSubtypeWildcard);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        int size = this.factories.size();
        for (int i3 = 0; i3 < size; i3++) {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter<T>) this.factories.get(i3).create(this, removeSubtypeWildcard);
            if (typeAdapter2 != null) {
                this.adapterCache.put(removeSubtypeWildcard, typeAdapter2);
                return typeAdapter2;
            }
        }
        throw new IllegalArgumentException("Can't find TypeAdapter for " + type);
    }

    QuickJS(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        int size = builder.factories.size();
        List<TypeAdapter.Factory> list = BUILT_IN_FACTORIES;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.factories);
        arrayList.addAll(list);
        this.factories = Collections.unmodifiableList(arrayList);
        this.adapterCache = new ConcurrentHashMap();
    }
}
