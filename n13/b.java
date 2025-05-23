package n13;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f417988d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f417989e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f417990a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private Object f417991b;

    /* renamed from: c, reason: collision with root package name */
    private c f417992c;

    private void d(HippyMap hippyMap, Object obj, String str, boolean z16) {
        if (j(hippyMap, obj, hippyMap.getString("method"))) {
            return;
        }
        try {
            if (l(hippyMap, obj, str, this.f417992c.onGetDispatchMethodName(str), this.f417992c.onGetDispatchArgsNameList(str))) {
                return;
            }
            QLog.e("HippyJSBHelper", 1, "doInvokeJSBMethod can`t findMethodFromSuper");
            this.f417992c.onCallError("doInvokeJSBMethod can`t findMethod");
        } catch (Exception e16) {
            QLog.e("HippyJSBHelper", 1, "doInvokeJSBMethod error", e16);
            this.f417992c.onCallError("doInvokeJSBMethod error:" + e16);
        }
    }

    public static b f() {
        if (f417988d == null) {
            synchronized (f417989e) {
                if (f417988d == null) {
                    f417988d = new b();
                }
            }
        }
        return f417988d;
    }

    private ArrayList<Method> g(Object obj, boolean z16) {
        ArrayList<Method> arrayList = new ArrayList<>();
        if (z16) {
            for (Class<? super Object> superclass = obj.getClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.addAll(Arrays.asList(superclass.getDeclaredMethods()));
                if ("WebViewPlugin".equals(superclass.getSimpleName())) {
                    break;
                }
            }
        } else {
            arrayList.addAll(Arrays.asList(obj.getClass().getDeclaredMethods()));
        }
        return arrayList;
    }

    @Nullable
    private synchronized Object h(String str) {
        Object obj;
        if (this.f417990a.containsKey(str) && this.f417990a.get(str) != null) {
            obj = this.f417990a.get(str);
        } else {
            Object onCreateWebViewPlugin = this.f417992c.onCreateWebViewPlugin(str);
            if (onCreateWebViewPlugin == null) {
                this.f417992c.onCallError("plugin create failed");
                return null;
            }
            this.f417990a.put(str, onCreateWebViewPlugin);
            obj = onCreateWebViewPlugin;
        }
        this.f417992c.onUpdateActivity(obj);
        return obj;
    }

    private Object[] i(String str, int i3, ArrayList<Object> arrayList, ArrayList<Method> arrayList2) {
        int parameterCount;
        Iterator<Method> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Method next = it.next();
            if (str.equals(next.getName())) {
                parameterCount = next.getParameterCount();
                if (parameterCount == i3) {
                    Class<?>[] parameterTypes = next.getParameterTypes();
                    int length = parameterTypes.length;
                    int i16 = 0;
                    for (int i17 = 0; i17 < length && parameterTypes[i17].isAssignableFrom(arrayList.get(i16).getClass()); i17++) {
                        i16++;
                    }
                    if (i16 == i3) {
                        return arrayList.toArray();
                    }
                }
            }
        }
        return null;
    }

    private boolean j(HippyMap hippyMap, Object obj, String str) {
        if (k(hippyMap, obj, false, str)) {
            return true;
        }
        return k(hippyMap, obj, true, str);
    }

    private boolean k(HippyMap hippyMap, Object obj, boolean z16, String str) {
        HippyMap map = hippyMap.getMap("args");
        if (map != null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            Object[] i3 = i(str, map.keySet().size(), arrayList, g(obj, z16));
            if (i3 != null) {
                Class<?>[] clsArr = new Class[i3.length];
                int length = i3.length;
                int i16 = 0;
                int i17 = 0;
                while (i16 < length) {
                    clsArr[i17] = i3[i16].getClass();
                    i16++;
                    i17++;
                }
                try {
                    Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(obj, i3);
                    return true;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean l(HippyMap hippyMap, Object obj, String str, String str2, String[] strArr) throws IllegalAccessException, InvocationTargetException {
        if (m(hippyMap, obj, str, str2, strArr, false)) {
            return true;
        }
        return m(hippyMap, obj, str, str2, strArr, true);
    }

    private boolean m(HippyMap hippyMap, Object obj, String str, String str2, String[] strArr, boolean z16) throws IllegalAccessException, InvocationTargetException {
        int i3;
        Method next;
        Iterator<Method> it = g(obj, z16).iterator();
        do {
            if (!it.hasNext()) {
                return false;
            }
            next = it.next();
        } while (!str2.equals(next.getName()));
        Class<?>[] parameterTypes = next.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (i3 = 0; i3 < parameterTypes.length; i3++) {
            Object onGetInvokeArgs = this.f417992c.onGetInvokeArgs(i3, parameterTypes[i3], obj, str);
            if (onGetInvokeArgs == null && strArr != null && strArr.length == parameterTypes.length) {
                onGetInvokeArgs = hippyMap.get(strArr[i3]);
            }
            objArr[i3] = onGetInvokeArgs;
        }
        next.setAccessible(true);
        next.invoke(obj, objArr);
        return true;
    }

    public void a(HippyMap hippyMap) {
        c cVar = this.f417992c;
        if (cVar == null) {
            QLog.e("HippyJSBHelper", 1, "callJsBridge error, need setHippyJsbCallbackAdapter first");
            return;
        }
        String onGetJsbNameSpace = cVar.onGetJsbNameSpace(hippyMap);
        String onGetJsbMethod = this.f417992c.onGetJsbMethod(hippyMap);
        if (!TextUtils.isEmpty(onGetJsbNameSpace) && !TextUtils.isEmpty(onGetJsbMethod)) {
            if (this.f417992c.isNeedIntercept(hippyMap)) {
                this.f417992c.onCallError("custom logic intercepted");
                return;
            }
            Object h16 = h(onGetJsbNameSpace);
            if (h16 == null) {
                this.f417992c.onCallError("plugin get failed");
                return;
            }
            if (this.f417991b == null) {
                Object onCreateFakeWebView = this.f417992c.onCreateFakeWebView(h16);
                if (onCreateFakeWebView == null) {
                    this.f417992c.onCallError("please impl method onCreateFakeWebView");
                    return;
                }
                this.f417991b = onCreateFakeWebView;
            }
            this.f417992c.onSetWebViewInternal(h16, this.f417991b);
            d(hippyMap, h16, onGetJsbNameSpace, false);
            return;
        }
        this.f417992c.onCallError("params namespace and method are both required");
    }

    public void b(HashMap<String, Object[]> hashMap) {
        Method method;
        for (Object obj : this.f417990a.values()) {
            try {
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                int length = declaredMethods.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        method = declaredMethods[i3];
                        if ("onActivityResult".equals(method.getName())) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        method = null;
                        break;
                    }
                }
                if (method != null) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    StringBuilder sb5 = new StringBuilder();
                    for (Class<?> cls : parameterTypes) {
                        sb5.append(cls.getSimpleName());
                        sb5.append(',');
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    if (hashMap.containsKey(sb5.toString())) {
                        method.invoke(obj, hashMap.get(sb5.toString()));
                    } else {
                        this.f417992c.onCallError("please adapt OnActivityResult args");
                        return;
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e16) {
                QLog.e("HippyJSBHelper", 1, "dispatchOnActivityResult error:", e16);
                this.f417992c.onCallError("dispatchOnActivityResult error:" + e16);
            }
        }
    }

    public void c(HashMap<String, Object[]> hashMap) {
        Method method;
        for (Object obj : this.f417990a.values()) {
            try {
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                int length = declaredMethods.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        method = declaredMethods[i3];
                        if ("onNewIntent".equals(method.getName())) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        method = null;
                        break;
                    }
                }
                if (method != null) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    StringBuilder sb5 = new StringBuilder();
                    for (Class<?> cls : parameterTypes) {
                        sb5.append(cls.getSimpleName());
                        sb5.append(',');
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    if (hashMap.containsKey(sb5.toString())) {
                        method.invoke(obj, hashMap.get(sb5.toString()));
                    } else {
                        this.f417992c.onCallError("please adapt onNewIntent args");
                        return;
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e16) {
                QLog.e("HippyJSBHelper", 1, "dispatchOnNewIntent error:", e16);
                this.f417992c.onCallError("dispatchOnNewIntent error:" + e16);
            }
        }
    }

    public c e() {
        return this.f417992c;
    }

    public void n() {
        Method method;
        try {
            if (!ar.b("linkliang", "2024-04-07", "vas_hippy_js_destroy").isEnable(true)) {
                QLog.d("HippyJSBHelper", 1, "onDestroy return");
                return;
            }
            for (Object obj : this.f417990a.values()) {
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                int length = declaredMethods.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        method = declaredMethods[i3];
                        if (MosaicConstants$JsFunction.FUNC_ON_DESTROY.equals(method.getName())) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        method = null;
                        break;
                    }
                }
                if (method != null) {
                    method.setAccessible(true);
                    method.invoke(obj, new Object[0]);
                }
            }
            this.f417990a.clear();
            QLog.d("HippyJSBHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        } catch (Exception e16) {
            QLog.e("HippyJSBHelper", 1, "onDestroy error:", e16);
        }
    }

    public void o(@NotNull c cVar) {
        this.f417992c = cVar;
    }
}
