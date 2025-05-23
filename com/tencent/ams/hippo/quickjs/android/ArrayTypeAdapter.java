package com.tencent.ams.hippo.quickjs.android;

import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
class ArrayTypeAdapter extends TypeAdapter<Object> {
    static IPatchRedirector $redirector_;
    public static final TypeAdapter.Factory FACTORY;
    private final TypeAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            FACTORY = new TypeAdapter.Factory() { // from class: com.tencent.ams.hippo.quickjs.android.a
                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
                public final TypeAdapter create(QuickJS quickJS, Type type) {
                    TypeAdapter lambda$static$0;
                    lambda$static$0 = ArrayTypeAdapter.lambda$static$0(quickJS, type);
                    return lambda$static$0;
                }
            };
        }
    }

    ArrayTypeAdapter(Class<?> cls, TypeAdapter<Object> typeAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, (Object) typeAdapter);
        } else {
            this.elementClass = cls;
            this.elementAdapter = typeAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeAdapter lambda$static$0(QuickJS quickJS, Type type) {
        Type arrayComponentType = JavaTypes.arrayComponentType(type);
        if (arrayComponentType == null) {
            return null;
        }
        return new ArrayTypeAdapter(JavaTypes.getRawType(arrayComponentType), quickJS.getAdapter(arrayComponentType)).nullable();
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public Object fromJSValue(JSContext jSContext, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
        }
        JSArray jSArray = (JSArray) jSValue.cast(JSArray.class);
        int length = jSArray.getLength();
        Object newInstance = Array.newInstance(this.elementClass, length);
        for (int i3 = 0; i3 < length; i3++) {
            Array.set(newInstance, i3, this.elementAdapter.fromJSValue(jSContext, jSArray.getProperty(i3)));
        }
        return newInstance;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(JSContext jSContext, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, obj);
        }
        JSArray createJSArray = jSContext.createJSArray();
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            createJSArray.setProperty(i3, this.elementAdapter.toJSValue(jSContext, Array.get(obj, i3)));
        }
        return createJSArray;
    }
}
