package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InterfaceTypeAdapter extends TypeAdapter<Object> {
    static IPatchRedirector $redirector_;
    static final TypeAdapter.Factory FACTORY;
    private static final JSValueHolderTag JS_VALUE_HOLDER_TAG;
    private final Map<String, JavaMethod> methods;
    private final Class<?> rawType;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface JSValueHolder {
        JSValue getJSValue(JSValueHolderTag jSValueHolderTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class JSValueHolderTag {
        static IPatchRedirector $redirector_;

        JSValueHolderTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ JSValueHolderTag(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13932);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            FACTORY = new TypeAdapter.Factory() { // from class: com.tencent.ams.hippo.quickjs.android.c
                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
                public final TypeAdapter create(QuickJS quickJS, Type type) {
                    TypeAdapter lambda$static$0;
                    lambda$static$0 = InterfaceTypeAdapter.lambda$static$0(quickJS, type);
                    return lambda$static$0;
                }
            };
            JS_VALUE_HOLDER_TAG = new JSValueHolderTag(null);
        }
    }

    InterfaceTypeAdapter(Class<?> cls, Map<String, JavaMethod> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, (Object) map);
        } else {
            this.rawType = cls;
            this.methods = map;
        }
    }

    @Nullable
    static Map<String, JavaMethod> getInterfaceMethods(Type type) {
        Class<?> rawType = JavaTypes.getRawType(type);
        if (!rawType.isInterface()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Method method : rawType.getMethods()) {
            Type resolve = JavaTypes.resolve(type, rawType, method.getGenericReturnType());
            if (resolve instanceof TypeVariable) {
                return null;
            }
            String name = method.getName();
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            int length = genericParameterTypes.length;
            Type[] typeArr = new Type[length];
            for (int i3 = 0; i3 < length; i3++) {
                Type resolve2 = JavaTypes.resolve(type, rawType, genericParameterTypes[i3]);
                typeArr[i3] = resolve2;
                if (resolve2 instanceof TypeVariable) {
                    return null;
                }
            }
            JavaMethod javaMethod = (JavaMethod) hashMap.get(name);
            if (javaMethod != null) {
                if (!Arrays.equals(javaMethod.parameterTypes, typeArr)) {
                    return null;
                }
                if (!resolve.equals(javaMethod.returnType)) {
                    if (JavaTypes.getRawType(resolve).isAssignableFrom(JavaTypes.getRawType(javaMethod.returnType))) {
                    }
                }
            }
            hashMap.put(name, new JavaMethod(resolve, name, typeArr, method.getModifiers()));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$fromJSValue$1(JSValue jSValue, JSContext jSContext, JSObject jSObject, Object obj, Method method, Object[] objArr) throws Throwable {
        int i3;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr != null && objArr.length == 1 && objArr[0] == JS_VALUE_HOLDER_TAG) {
            return jSValue;
        }
        String name = method.getName();
        JavaMethod javaMethod = this.methods.get(name);
        if (javaMethod != null) {
            if (objArr != null) {
                i3 = objArr.length;
            } else {
                i3 = 0;
            }
            if (i3 == javaMethod.parameterTypes.length) {
                JSValue[] jSValueArr = new JSValue[i3];
                for (int i16 = 0; i16 < i3; i16++) {
                    jSValueArr[i16] = jSContext.quickJS.getAdapter(javaMethod.parameterTypes[i16]).toJSValue(jSContext, objArr[i16]);
                }
                return jSContext.quickJS.getAdapter(javaMethod.returnType).fromJSValue(jSContext, ((JSFunction) jSObject.getProperty(name).cast(JSFunction.class)).invoke(jSObject, jSValueArr));
            }
            throw new IllegalStateException("Parameter number doesn't match: " + name);
        }
        throw new NoSuchMethodException("Can't find method: " + name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeAdapter lambda$static$0(QuickJS quickJS, Type type) {
        Map<String, JavaMethod> interfaceMethods = getInterfaceMethods(type);
        if (interfaceMethods == null) {
            return null;
        }
        return new InterfaceTypeAdapter(JavaTypes.getRawType(type), interfaceMethods).nullable();
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public Object fromJSValue(final JSContext jSContext, final JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
        }
        final JSObject jSObject = (JSObject) jSValue.cast(JSObject.class);
        Object javaObject = jSObject.getJavaObject();
        if (this.rawType.isInstance(javaObject)) {
            return javaObject;
        }
        return Proxy.newProxyInstance(this.rawType.getClassLoader(), new Class[]{this.rawType, JSValueHolder.class}, new InvocationHandler() { // from class: com.tencent.ams.hippo.quickjs.android.b
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object lambda$fromJSValue$1;
                lambda$fromJSValue$1 = InterfaceTypeAdapter.this.lambda$fromJSValue$1(jSValue, jSContext, jSObject, obj, method, objArr);
                return lambda$fromJSValue$1;
            }
        });
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(JSContext jSContext, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, obj);
        }
        if (obj instanceof JSValueHolder) {
            return ((JSValueHolder) obj).getJSValue(JS_VALUE_HOLDER_TAG);
        }
        JSObject createJSObject = jSContext.createJSObject(obj);
        for (JavaMethod javaMethod : this.methods.values()) {
            createJSObject.setProperty(javaMethod.name, jSContext.createJSFunction(obj, javaMethod));
        }
        return createJSObject;
    }
}
