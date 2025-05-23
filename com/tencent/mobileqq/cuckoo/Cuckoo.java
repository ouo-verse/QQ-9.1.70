package com.tencent.mobileqq.cuckoo;

import android.os.Build;
import android.os.Debug;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.warbler.Warbler;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Cuckoo {
    static IPatchRedirector $redirector_ = null;
    private static final int CLASSLOAD_CLASSFILELOADHOOK = 2;
    private static final int CLASSLOAD_CLASSLOADFIRST = 1;
    private static final int CLASSLOAD_CLASSPREPARE = 3;
    private static final String TAG = "Cuckoo";
    private static final Map<String, String> TYPETOSIGNATURE;
    private static boolean isSOLoaded;
    private static Map<Integer, String> mRegistMethoForClass;
    private static Map<Integer, MethodCopyOnWriteSet> mRegistMethods;
    private static String packageCodePath;
    private static b registClassLoadCallback;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class a extends b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.b
        public void a(Class cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
                return;
            }
            Log.d(Cuckoo.TAG, cls.getName() + "  ClassLoad FileLoadHook");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.b
        public void b(Class cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
                return;
            }
            Log.d(Cuckoo.TAG, cls.getName() + "  ClassLoad First");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.cuckoo.b
        public void c(Class cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
                return;
            }
            Log.d(Cuckoo.TAG, cls.getName() + "  ClassLoad Prepare");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mRegistMethods = new ConcurrentHashMap();
        registClassLoadCallback = new a();
        mRegistMethoForClass = new ConcurrentHashMap();
        packageCodePath = "";
        isSOLoaded = false;
        HashMap hashMap = new HashMap();
        TYPETOSIGNATURE = hashMap;
        hashMap.put(HippyControllerProps.BOOLEAN, "Z");
        hashMap.put("byte", "B");
        hashMap.put(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, BdhLogUtil.LogTag.Tag_Conn);
        hashMap.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, ExifInterface.LATITUDE_SOUTH);
        hashMap.put(PoiListCacheRecord.WEIGHT_TYPE, "I");
        hashMap.put(PoiListCacheRecord.TIMESTAMP_TYPE, "J");
        hashMap.put("float", UserInfo.SEX_FEMALE);
        hashMap.put("double", "D");
    }

    public Cuckoo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void callbackClassLoadJNI(Class cls, int i3) {
        if (i3 == 1) {
            registClassLoadCallback.b(cls);
        }
        if (i3 == 2) {
            registClassLoadCallback.a(cls);
        }
        if (i3 == 3) {
            registClassLoadCallback.c(cls);
        }
    }

    private static Object[] callbackEntryJNI(int i3, String str, String str2, Object[] objArr, Object obj) {
        MethodCallback[] snapshot = mRegistMethods.get(Integer.valueOf(i3)).getSnapshot();
        int i16 = 1;
        Object[] objArr2 = new Object[objArr.length + 1];
        objArr2[0] = obj;
        int length = objArr.length;
        int i17 = 0;
        while (i17 < length) {
            objArr2[i16] = objArr[i17];
            i17++;
            i16++;
        }
        for (MethodCallback methodCallback : snapshot) {
            methodCallback.methodCallbackEntry(objArr);
            methodCallback.methodCallbackEntry(objArr, obj);
            methodCallback.methodCallbackEntry(mRegistMethoForClass.get(Integer.valueOf(i3)), str, str2, objArr2);
            objArr = methodCallback.methodCallbackSetArgs(objArr);
        }
        return objArr;
    }

    private static Object callbackExitJNI(int i3, Object obj) {
        for (MethodCallback methodCallback : mRegistMethods.get(Integer.valueOf(i3)).getSnapshot()) {
            if (obj == null) {
                methodCallback.methodCallbackExit(null);
            } else {
                methodCallback.methodCallbackExit(obj);
            }
            obj = methodCallback.methodCallbackSetResult(obj);
        }
        return obj;
    }

    private static void callbackThrowJNI(int i3, Object obj) {
        for (MethodCallback methodCallback : mRegistMethods.get(Integer.valueOf(i3)).getSnapshot()) {
            if (obj == null) {
                methodCallback.methodCallbackExitThrowable(null);
            } else {
                methodCallback.methodCallbackExitThrowable(obj);
            }
        }
    }

    public static void destoryClassCallback() {
        destoryClassJNI();
    }

    private static native void destoryClassJNI();

    public static void destoryMethod(Class<?> cls, String str, String str2) throws IllegalArgumentException {
        destoryRegistedSet(destoryMethodJNI(cls, str, str2));
        Log.i("erase success", str + " " + str2);
    }

    private static native int[] destoryMethodAllByClassNameJNI(String str, String str2);

    private static native int[] destoryMethodAllJNI(Class cls, String str);

    private static native int destoryMethodByClassNameJNI(String str, String str2, String str3);

    private static native int destoryMethodJNI(Class cls, String str, String str2);

    private static void destoryRegistedSet(int i3) throws IllegalArgumentException {
        if (mRegistMethods.containsKey(Integer.valueOf(i3))) {
            mRegistMethods.remove(Integer.valueOf(i3));
            return;
        }
        throw new IllegalArgumentException("not find method");
    }

    public static synchronized void init(boolean z16) {
        synchronized (Cuckoo.class) {
            if (isSOLoaded) {
                return;
            }
            if (z16) {
                Warbler.b();
            }
            System.loadLibrary("cuckoo");
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    Debug.attachJvmtiAgent("libcuckoo.so", "", Cuckoo.class.getClassLoader());
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            startCuckoo();
            isSOLoaded = true;
        }
    }

    private static void insertRegistedSet(int i3, com.tencent.mobileqq.cuckoo.a aVar) throws IllegalArgumentException {
        MethodCopyOnWriteSet methodCopyOnWriteSet;
        if (mRegistMethods.containsKey(Integer.valueOf(i3))) {
            methodCopyOnWriteSet = mRegistMethods.get(Integer.valueOf(i3));
            if (methodCopyOnWriteSet.indexOf(aVar) != -1) {
                throw new IllegalArgumentException("Callback has been registered");
            }
        } else {
            methodCopyOnWriteSet = new MethodCopyOnWriteSet();
        }
        methodCopyOnWriteSet.add((MethodCallback) aVar);
        mRegistMethods.put(Integer.valueOf(i3), methodCopyOnWriteSet);
    }

    public static void registClassCallback(b bVar) {
        registClassLoadCallback = bVar;
        registClassJNI();
    }

    private static native void registClassJNI();

    public static void registMethod(String str, String str2, String str3, com.tencent.mobileqq.cuckoo.a aVar) throws IllegalArgumentException {
        int registMethodByClassNameJNI = registMethodByClassNameJNI(str, str2, str3);
        if (registMethodByClassNameJNI != -1) {
            mRegistMethoForClass.put(Integer.valueOf(registMethodByClassNameJNI), str);
            insertRegistedSet(registMethodByClassNameJNI, aVar);
            return;
        }
        throw new IllegalArgumentException("not find method");
    }

    private static native int[] registMethodAllByClassNameJNI(String str, String str2);

    private static native int[] registMethodAllJNI(Class cls, String str);

    private static native int registMethodByClassNameJNI(String str, String str2, String str3);

    private static native int registMethodJNI(Class cls, String str, String str2);

    private static native void startCuckoo();

    public static void destoryMethod(String str, String str2, String str3) throws IllegalArgumentException {
        destoryRegistedSet(destoryMethodByClassNameJNI(str, str2, str3));
        Log.i("erase success", str2 + " " + str3);
    }

    public static void registMethod(Class<?> cls, String str, String str2, com.tencent.mobileqq.cuckoo.a aVar) throws IllegalArgumentException {
        int registMethodJNI = registMethodJNI(cls, str, str2);
        if (registMethodJNI != -1) {
            mRegistMethoForClass.put(Integer.valueOf(registMethodJNI), cls.getName());
            insertRegistedSet(registMethodJNI, aVar);
            return;
        }
        throw new IllegalArgumentException("not find method");
    }

    public static void destoryMethod(Class<?> cls, String str) throws IllegalArgumentException {
        for (int i3 : destoryMethodAllJNI(cls, str)) {
            Log.i(str, i3 + "");
            destoryRegistedSet(i3);
        }
    }

    public static void registMethod(Class<?> cls, String str, com.tencent.mobileqq.cuckoo.a aVar) throws IllegalArgumentException {
        int[] registMethodAllJNI = registMethodAllJNI(cls, str);
        if (registMethodAllJNI != null) {
            for (int i3 : registMethodAllJNI) {
                if (i3 != -1) {
                    mRegistMethoForClass.put(Integer.valueOf(i3), cls.getName());
                    insertRegistedSet(i3, aVar);
                } else {
                    throw new IllegalArgumentException("not find method");
                }
            }
            return;
        }
        throw new IllegalArgumentException("not find method");
    }

    public static void destoryMethod(String str, String str2) throws IllegalArgumentException {
        for (int i3 : destoryMethodAllByClassNameJNI(str, str2)) {
            Log.i(str2, i3 + "");
            destoryRegistedSet(i3);
        }
    }

    public static void registMethod(String str, String str2, com.tencent.mobileqq.cuckoo.a aVar) throws IllegalArgumentException {
        int[] registMethodAllByClassNameJNI = registMethodAllByClassNameJNI(str, str2);
        if (registMethodAllByClassNameJNI != null) {
            for (int i3 : registMethodAllByClassNameJNI) {
                if (i3 != -1) {
                    mRegistMethoForClass.put(Integer.valueOf(i3), str);
                    insertRegistedSet(i3, (MethodCallback) aVar);
                } else {
                    throw new IllegalArgumentException("not find method");
                }
            }
            return;
        }
        throw new IllegalArgumentException("not find method");
    }
}
