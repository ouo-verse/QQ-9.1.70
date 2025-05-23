package com.tencent.mobileqq.vas.api;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes20.dex */
public class RemoteProxy {
    public static final String KEY_RESULT = "result";
    public static final String KEY_RESULT_TYPE = "resultType";
    public static final String SPLIT_CHAR = "$";
    static final String TAG = "RemoteProxy";
    private static HashMap<String, Class> sCacheClass = new HashMap<>();
    private static HashMap<String, Object> sProxyCacheClass = new HashMap<>();
    private static HashMap<String, Method> sCacheMethod = new HashMap<>();
    private static HashMap<String, Object> sCacheClassObject = new HashMap<>();
    private static String CLASS_NAME_EPIC_MODULE = EIPCModule.class.getName();
    private static String CLASS_NAME_EIPC_RESULTCALLBACK = EIPCResultCallback.class.getName();
    private static boolean sCallFromMainThread = MobileQQ.processName.equals(BaseApplication.getContext().getPackageName());

    /* loaded from: classes20.dex */
    public static class QIPCHandler implements InvocationHandler {
        private Class cls;
        public Object object;

        public QIPCHandler(Class cls) {
            this.cls = cls;
            try {
                this.object = cls.newInstance();
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            }
        }

        Object callMainDirect(String str, String str2, Bundle bundle) {
            Bundle bundle2;
            EIPCResult onCall = RemoteProxy.onCall(null, str, bundle, 0);
            if (onCall != null && (bundle2 = onCall.data) != null) {
                String string = bundle2.getString(RemoteProxy.KEY_RESULT_TYPE);
                if (string.endsWith("void")) {
                    return null;
                }
                return RemoteProxy.getBundleParameter(onCall.data, string, "result");
            }
            if (PoiListCacheRecord.WEIGHT_TYPE.equals(str2)) {
                return 0;
            }
            if (!PoiListCacheRecord.TIMESTAMP_TYPE.equals(str2)) {
                return null;
            }
            return 0L;
        }

        Object callMainIPC(String str, String str2, Bundle bundle) {
            Bundle bundle2;
            EIPCResult callServerSync = RemoteProxy.callServerSync(str, bundle);
            if (callServerSync != null && (bundle2 = callServerSync.data) != null) {
                String string = bundle2.getString(RemoteProxy.KEY_RESULT_TYPE);
                if (!string.endsWith("void")) {
                    return RemoteProxy.getBundleParameter(callServerSync.data, string, "result");
                }
                return null;
            }
            if (PoiListCacheRecord.WEIGHT_TYPE.equals(str2)) {
                return 0;
            }
            if (!PoiListCacheRecord.TIMESTAMP_TYPE.equals(str2)) {
                return null;
            }
            return 0L;
        }

        void callMainIPCAsync(String str, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
            RemoteProxy.callServerAsync(str, bundle, eIPCResultCallback);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList<String> methodAndParameter = setMethodAndParameter(method, objArr, bundle);
            if (QLog.isDebugVersion()) {
                QLog.d(RemoteProxy.TAG, 2, "invoke getReturnType:" + method.getReturnType());
            }
            String name = method.getReturnType().getName();
            String str = this.cls.getName() + "$" + method.getName();
            boolean z16 = false;
            for (int i3 = 0; i3 < methodAndParameter.size(); i3++) {
                String str2 = methodAndParameter.get(i3);
                if (str2.equals(RemoteProxy.CLASS_NAME_EPIC_MODULE) || str2.equals(RemoteProxy.CLASS_NAME_EIPC_RESULTCALLBACK)) {
                    if (QLog.isColorLevel()) {
                        VasNtCommonReporter.getHistoryFeature("old_ipc").setValue2(str).report();
                    }
                    z16 = true;
                }
            }
            if (RemoteProxy.sCallFromMainThread && VasNtToggle.INSTANCE.getBUG_103285925().isEnable(true) && !z16) {
                return callMainDirect(str, name, bundle);
            }
            if (name.equals("void") && objArr != null && (objArr[objArr.length - 1] instanceof EIPCResultCallback)) {
                callMainIPCAsync(str, bundle, (EIPCResultCallback) objArr[objArr.length - 1]);
                return null;
            }
            return callMainIPC(str, name, bundle);
        }

        ArrayList<String> setMethodAndParameter(Method method, Object[] objArr, Bundle bundle) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                String name = parameterTypes[i3].getName();
                arrayList.add(name);
                RemoteProxy.setBundleParameter(bundle, name, "__arg+" + i3 + "__", objArr[i3]);
            }
            bundle.putStringArrayList("__parameterTypes__", arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callServerAsync(String str, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        QIPCClientHelper.getInstance().callServer(VasIPCModule.NAME, str, bundle, eIPCResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EIPCResult callServerSync(String str, Bundle bundle) {
        return QIPCClientHelper.getInstance().callServer(VasIPCModule.NAME, str, bundle);
    }

    @Nullable
    private static Object getBundleObject(Bundle bundle, String str, String str2, Class<?>[] clsArr) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls.getInterfaces().length > 0) {
                clsArr = cls.getInterfaces();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (clsArr != null) {
            for (Class<?> cls2 : clsArr) {
                String name = cls2.getName();
                if (name.equals("android.os.Parcelable")) {
                    return bundle.getParcelable(str2);
                }
                if (name.equals("java.io.Serializable")) {
                    return bundle.getSerializable(str2);
                }
                if (name.equals("java.util.Collection")) {
                    return getListObject(bundle, str2);
                }
                if (name.equals("java.util.HashMap")) {
                    return bundle.getSerializable(str2);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getBundleParameter(Bundle bundle, String str, String str2) {
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(str)) {
            return Integer.valueOf(bundle.getInt(str2));
        }
        if ("java.lang.String".equals(str)) {
            return bundle.getString(str2);
        }
        if ("java.lang.Boolean".equals(str)) {
            return Boolean.valueOf(bundle.getBoolean(str2));
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(str)) {
            return Long.valueOf(bundle.getLong(str2));
        }
        if (Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT.equals(str)) {
            return Short.valueOf(bundle.getShort(str2));
        }
        if ("float".equals(str)) {
            return Float.valueOf(bundle.getFloat(str2));
        }
        if (HippyControllerProps.BOOLEAN.equals(str)) {
            return Boolean.valueOf(bundle.getBoolean(str2));
        }
        if (!"java.util.List".equals(str) && !"java.util.ArrayList".equals(str)) {
            if ("java.util.HashMap".equals(str)) {
                return bundle.getSerializable(str2);
            }
            if ("eipc.EIPCCallback".equals(str)) {
                return EIPCCallback.Stub.asInterface(bundle.getBinder(str2));
            }
            if ("com.tencent.mobileqq.vas.api.EIPCCallbackWrapper".equals(str)) {
                return new EIPCCallbackWrapper(EIPCCallback.Stub.asInterface(bundle.getBinder(str2)));
            }
            return getBundleObject(bundle, str, str2, null);
        }
        return getListObject(bundle, str2);
    }

    private static Class getClassFromName(String str) throws ClassNotFoundException {
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(str)) {
            return Integer.TYPE;
        }
        if ("java.lang.String".equals(str)) {
            return String.class;
        }
        if ("java.lang.Boolean".equals(str)) {
            return Boolean.class;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(str)) {
            return Long.TYPE;
        }
        if (Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT.equals(str)) {
            return Short.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if (HippyControllerProps.BOOLEAN.equals(str)) {
            return Boolean.TYPE;
        }
        if ("java.util.ArrayList".equals(str)) {
            return ArrayList.class;
        }
        if ("java.io.Serializable".equals(str)) {
            return Serializable.class;
        }
        if ("java.util.HashMap".equals(str)) {
            return HashMap.class;
        }
        if ("android.os.Parcelable".equals(str)) {
            return Parcelable.class;
        }
        return Class.forName(str);
    }

    private static Object getListObject(Bundle bundle, String str) {
        Object parcelableArrayList = bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            parcelableArrayList = bundle.getStringArrayList(str);
        }
        if (parcelableArrayList == null) {
            parcelableArrayList = bundle.getIntegerArrayList(str);
        }
        if (parcelableArrayList == null) {
            return bundle.getSerializable(str);
        }
        return parcelableArrayList;
    }

    public static Object getProxy(Class cls) {
        String name = cls.getName();
        if (sProxyCacheClass.containsKey(name)) {
            return sProxyCacheClass.get(name);
        }
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new QIPCHandler(cls));
        sProxyCacheClass.put(name, newProxyInstance);
        return newProxyInstance;
    }

    public static EIPCResult onCall(QIPCModule qIPCModule, String str, Bundle bundle, int i3) {
        Class cls;
        Object obj;
        Method method;
        int i16 = 0;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "action:", str, "  callbackId:", Integer.valueOf(i3));
        }
        if (!TextUtils.isEmpty(str) && str.contains("$")) {
            String[] split = str.split("\\$");
            String str2 = split[0];
            for (int i17 = 1; i17 < split.length - 1; i17++) {
                str2 = str2 + "$" + split[i17];
            }
            String str3 = split[split.length - 1];
            try {
                if (sCacheClass.containsKey(str2)) {
                    cls = sCacheClass.get(str2);
                } else {
                    cls = Class.forName(str2);
                    sCacheClass.put(str2, cls);
                }
                if (sCacheClassObject.containsKey(str2)) {
                    obj = sCacheClassObject.get(str2);
                } else {
                    Object newInstance = cls.newInstance();
                    sCacheClassObject.put(str2, newInstance);
                    obj = newInstance;
                }
                if (obj == null) {
                    return null;
                }
                bundle.setClassLoader(cls.getClassLoader());
                ArrayList<String> stringArrayList = bundle.getStringArrayList("__parameterTypes__");
                int size = stringArrayList.size();
                Class<?>[] clsArr = new Class[size];
                Object[] objArr = new Object[size];
                while (i16 < stringArrayList.size()) {
                    String str4 = stringArrayList.get(i16);
                    clsArr[i16] = getClassFromName(str4);
                    objArr[i16] = getBundleParameter(bundle, str4, "__arg+" + i16 + "__");
                    if (str4.equals(CLASS_NAME_EPIC_MODULE)) {
                        objArr[i16] = qIPCModule;
                        i16++;
                        objArr[i16] = Integer.valueOf(i3);
                        clsArr[i16] = getClassFromName(stringArrayList.get(i16));
                    }
                    i16++;
                }
                if (sCacheMethod.get(str) != null) {
                    method = sCacheMethod.get(str);
                } else {
                    Method method2 = cls.getMethod(str3, clsArr);
                    sCacheMethod.put(str, method2);
                    method = method2;
                }
                Object invoke = method.invoke(obj, objArr);
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.data = bundle;
                setBundleParameter(bundle, method.getReturnType().getName(), "result", invoke);
                setBundleParameter(bundle, String.class.getName(), KEY_RESULT_TYPE, method.getReturnType().getName());
                bundle.putString(KEY_RESULT_TYPE, method.getReturnType().getName());
                return eIPCResult;
            } catch (Exception e16) {
                sCacheClassObject.clear();
                sCacheMethod.clear();
                e16.printStackTrace();
                QLog.d(TAG, 1, "onCall exception", e16);
            }
        }
        return null;
    }

    private static void putArrayList(Bundle bundle, String str, Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 0) {
                if (list.get(0) instanceof String) {
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                }
                if (list.get(0) instanceof Integer) {
                    bundle.putIntegerArrayList(str, (ArrayList) obj);
                } else if (list.get(0) instanceof Parcelable) {
                    bundle.putParcelableArrayList(str, (ArrayList) obj);
                } else if (obj instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setBundleParameter(Bundle bundle, String str, String str2, Object obj) {
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(str)) {
            bundle.putInt(str2, ((Integer) obj).intValue());
            return;
        }
        if ("java.lang.String".equals(str)) {
            bundle.putString(str2, (String) obj);
            return;
        }
        if ("java.lang.Boolean".equals(str)) {
            bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
            return;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(str)) {
            bundle.putLong(str2, ((Long) obj).longValue());
            return;
        }
        if (Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT.equals(str)) {
            bundle.putShort(str2, ((Short) obj).shortValue());
            return;
        }
        if ("float".equals(str)) {
            bundle.putFloat(str2, ((Float) obj).floatValue());
            return;
        }
        if (HippyControllerProps.BOOLEAN.equals(str)) {
            bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
            return;
        }
        if ("java.util.List".equals(str)) {
            putArrayList(bundle, str2, obj);
            return;
        }
        if ("eipc.EIPCCallback".equals(str)) {
            bundle.putBinder(str2, (IBinder) obj);
            return;
        }
        if ("com.tencent.mobileqq.vas.api.EIPCCallbackWrapper".equals(str)) {
            bundle.putBinder(str2, (IBinder) ((EIPCCallbackWrapper) obj).instance);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str2, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str2, (Serializable) obj);
        }
    }

    public void clear() {
        sCacheClass.clear();
        sProxyCacheClass.clear();
    }
}
