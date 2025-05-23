package com.tencent.ams.mosaic.jsengine;

import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSArray;
import com.tencent.ams.hippo.quickjs.android.JSBoolean;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFloat64;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSInt;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSString;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static Object[] a(JSContext jSContext, @NonNull JSArray jSArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSArray.getLength(); i3++) {
            Object g16 = g(jSContext, jSArray.getProperty(i3));
            if (g16 != null) {
                arrayList.add(g16);
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public static boolean b(Object obj, boolean z16) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z16;
    }

    public static JSFunction c(Object obj) {
        if (obj instanceof JSFunction) {
            return (JSFunction) obj;
        }
        return null;
    }

    public static String d(Object obj, String str) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return str;
    }

    public static String[] e(Object obj, String[] strArr) {
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        if (obj instanceof Object[]) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Object[]) obj) {
                arrayList.add(String.valueOf(obj2));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return strArr;
    }

    public static Map<String, Object> f(JSContext jSContext, JSObject jSObject) {
        if (jSContext != null && jSObject != null) {
            try {
                String[] strArr = (String[]) jSContext.quickJS.getAdapter(String[].class).fromJSValue(jSContext, ((JSFunction) ((JSObject) jSContext.getGlobalObject().getProperty(Entry.DATA_TYPE_OBJ).cast(JSObject.class)).getProperty("keys").cast(JSFunction.class)).invoke(null, new JSValue[]{jSObject}));
                HashMap hashMap = new HashMap();
                for (String str : strArr) {
                    hashMap.put(str, g(jSContext, jSObject.getProperty(str)));
                }
                return hashMap;
            } catch (Throwable th5) {
                f.i("QuickJSUtils", "covertJSObjectToMap failed", th5);
            }
        }
        return null;
    }

    public static Object g(JSContext jSContext, @NonNull JSValue jSValue) {
        if (jSValue instanceof JSString) {
            return ((JSString) jSValue.cast(JSString.class)).getString();
        }
        if (jSValue instanceof JSInt) {
            return Integer.valueOf(((JSInt) jSValue.cast(JSInt.class)).getInt());
        }
        if (jSValue instanceof JSFloat64) {
            return Float.valueOf(((JSFloat64) jSValue.cast(JSFloat64.class)).getFloat());
        }
        if (jSValue instanceof JSBoolean) {
            return Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean());
        }
        if (jSValue instanceof JSFunction) {
            return jSValue.cast(JSFunction.class);
        }
        if (jSValue instanceof JSArray) {
            return a(jSContext, (JSArray) jSValue.cast(JSArray.class));
        }
        if (jSValue instanceof JSObject) {
            return f(jSContext, (JSObject) jSValue.cast(JSObject.class));
        }
        return null;
    }

    public static JSValue h(JSContext jSContext, Object obj) {
        if (obj == null) {
            return jSContext.createJSNull();
        }
        if (obj instanceof String) {
            return jSContext.createJSString((String) obj);
        }
        if (obj instanceof Integer) {
            return jSContext.createJSNumber(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return jSContext.createJSNumber(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return jSContext.createJSNumber(((Float) obj).floatValue());
        }
        if (obj instanceof Boolean) {
            return jSContext.createJSBoolean(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Set keySet = map.keySet();
            JSObject createJSObject = jSContext.createJSObject(obj);
            for (Object obj2 : keySet) {
                if (obj2 instanceof String) {
                    createJSObject.setProperty((String) obj2, h(jSContext, map.get(obj2)));
                }
            }
            return createJSObject;
        }
        if (obj instanceof JSValue) {
            return (JSValue) obj;
        }
        return jSContext.createJSObject(obj);
    }

    public static JSValue[] i(Object[] objArr, JSContext jSContext) {
        if (objArr != null && objArr.length != 0) {
            JSValue[] jSValueArr = new JSValue[objArr.length];
            for (int i3 = 0; i3 < objArr.length; i3++) {
                jSValueArr[i3] = h(jSContext, objArr[i3]);
            }
            return jSValueArr;
        }
        return new JSValue[0];
    }
}
