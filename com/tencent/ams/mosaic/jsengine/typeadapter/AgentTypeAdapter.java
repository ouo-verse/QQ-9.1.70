package com.tencent.ams.mosaic.jsengine.typeadapter;

import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.hippo.quickjs.android.JavaMethod;
import com.tencent.ams.hippo.quickjs.android.JavaTypes;
import com.tencent.ams.hippo.quickjs.android.QuickJS;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AgentTypeAdapter extends TypeAdapter<Object> {
    static IPatchRedirector $redirector_ = null;
    public static final TypeAdapter.Factory FACTORY;
    private static final String TAG = "AgentTypeAdapter";
    private final List<Class<?>> mInterfaceList;
    private Map<String, List<JavaMethod>> mMethodCache;
    private final List<JavaMethod> mMethods;
    private final Class<?> mType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            FACTORY = new TypeAdapter.Factory() { // from class: com.tencent.ams.mosaic.jsengine.typeadapter.a
                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
                public final TypeAdapter create(QuickJS quickJS, Type type) {
                    TypeAdapter lambda$static$0;
                    lambda$static$0 = AgentTypeAdapter.lambda$static$0(quickJS, type);
                    return lambda$static$0;
                }
            };
        }
    }

    public AgentTypeAdapter(List<JavaMethod> list, List<Class<?>> list2, Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, list2, cls);
            return;
        }
        this.mMethods = list;
        this.mInterfaceList = list2;
        this.mType = cls;
        this.mMethodCache = new ConcurrentHashMap();
    }

    private static void filterInterfaceByClass(Class<?> cls, List<Class<?>> list) {
        if (cls != null && !cls.isInterface() && list != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                filterInterfaceByInterface(cls2, list);
            }
            filterInterfaceByClass(cls.getSuperclass(), list);
        }
    }

    private static void filterInterfaceByInterface(Class<?> cls, List<Class<?>> list) {
        if (cls != null && cls.isInterface() && list != null) {
            if (((JSAgent) cls.getAnnotation(JSAgent.class)) != null && !list.contains(cls)) {
                list.add(cls);
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                filterInterfaceByInterface(cls2, list);
            }
        }
    }

    private static List<Class<?>> getAllJSAgentInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (cls.isInterface()) {
            filterInterfaceByInterface(cls, arrayList);
        } else {
            filterInterfaceByClass(cls, arrayList);
        }
        return arrayList;
    }

    private static List<JavaMethod> getAllJSAgentMethods(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                List<JavaMethod> methods = getMethods(it.next());
                if (methods != null && methods.size() > 0) {
                    for (JavaMethod javaMethod : methods) {
                        if (!arrayList.contains(javaMethod)) {
                            arrayList.add(javaMethod);
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    private static List<JavaMethod> getMethods(Class<?> cls) {
        JSAgent jSAgent = (JSAgent) cls.getAnnotation(JSAgent.class);
        if (jSAgent == null) {
            return null;
        }
        MethodScope methodScope = jSAgent.methodScope();
        if (methodScope == MethodScope.ALL) {
            return getObjectMethods(cls);
        }
        if (methodScope == MethodScope.DECLARED) {
            return getObjectDeclaredMethods(cls);
        }
        if (methodScope != MethodScope.SPECIFIED) {
            return null;
        }
        return getObjectSpecifiedMethods(cls);
    }

    private static List<JavaMethod> getObjectDeclaredMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 1) != 0) {
                arrayList.add(JavaMethod.create(cls, method));
            }
        }
        return arrayList;
    }

    private static List<JavaMethod> getObjectMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getMethods()) {
            arrayList.add(JavaMethod.create(cls, method));
        }
        return arrayList;
    }

    private static List<JavaMethod> getObjectSpecifiedMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 1) != 0 && ((JSMethod) method.getAnnotation(JSMethod.class)) != null) {
                arrayList.add(JavaMethod.create(cls, method));
            }
        }
        return arrayList;
    }

    private void injectMethod(JSContext jSContext, JSObject jSObject, Object obj, JavaMethod javaMethod) {
        if (jSContext != null && jSObject != null && obj != null && javaMethod != null) {
            if (javaMethod.isStatic()) {
                jSObject.setProperty(javaMethod.name, jSContext.createJSFunctionS(obj.getClass(), javaMethod));
            } else {
                jSObject.setProperty(javaMethod.name, jSContext.createJSFunction(obj, javaMethod));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeAdapter lambda$static$0(QuickJS quickJS, Type type) {
        Class<?> rawType = JavaTypes.getRawType(type);
        List<Class<?>> allJSAgentInterfaces = getAllJSAgentInterfaces(rawType);
        List<JavaMethod> allJSAgentMethods = getAllJSAgentMethods(allJSAgentInterfaces);
        if (allJSAgentMethods != null && allJSAgentMethods.size() != 0) {
            return new AgentTypeAdapter(allJSAgentMethods, allJSAgentInterfaces, rawType).nullable();
        }
        return null;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public Object fromJSValue(JSContext jSContext, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
        }
        return ((JSObject) jSValue.cast(JSObject.class)).getJavaObject();
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(JSContext jSContext, Object obj) {
        List<Class<?>> allJSAgentInterfaces;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, obj);
        }
        JSObject createJSObject = jSContext.createJSObject(obj);
        Class<?> cls = obj.getClass();
        String name = cls.getName();
        List<JavaMethod> list = this.mMethodCache.get(name);
        if (list == null || list.size() == 0) {
            if (!this.mType.getName().equals(cls.getName()) && (allJSAgentInterfaces = getAllJSAgentInterfaces(cls)) != null) {
                List<Class<?>> list2 = this.mInterfaceList;
                if (list2 != null) {
                    allJSAgentInterfaces.removeAll(list2);
                }
                list = getAllJSAgentMethods(allJSAgentInterfaces);
            }
            if (list == null) {
                list = this.mMethods;
            } else {
                List<JavaMethod> list3 = this.mMethods;
                if (list3 != null) {
                    list.addAll(list3);
                }
            }
            if (list != null && list.size() > 0) {
                this.mMethodCache.put(name, list);
            }
        }
        if (list != null && list.size() > 0) {
            Iterator<JavaMethod> it = list.iterator();
            while (it.hasNext()) {
                injectMethod(jSContext, createJSObject, obj, it.next());
            }
        }
        return createJSObject;
    }
}
