package com.tencent.centaur.host.loader.inject;

import android.annotation.SuppressLint;
import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Method f99141a;

    /* renamed from: b, reason: collision with root package name */
    private static Field f99142b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f99143c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f99144d;

    /* renamed from: e, reason: collision with root package name */
    private static Class<?> f99145e;

    /* renamed from: f, reason: collision with root package name */
    private static Class<?> f99146f;

    /* renamed from: g, reason: collision with root package name */
    private static Collection<WeakReference<Resources>> f99147g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16659);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99147g = null;
            e();
        }
    }

    private static Resources a(Context context, List<String> list) throws CentaurInjectFailException {
        try {
            AssetManager assets = context.getAssets();
            Object obj = f99144d.get(assets);
            int length = Array.getLength(obj);
            Class<?> cls = obj.getClass();
            Class<?> componentType = cls.getComponentType();
            Method declaredMethod = componentType.getDeclaredMethod("loadFromPath", String.class);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(declaredMethod.invoke(null, it.next()));
            }
            f(obj, length, assets, list, arrayList, cls, componentType);
            return context.getResources();
        } catch (Exception e16) {
            Log.e("CentaurResInjector", "addAssetApkPath error:" + e16.getMessage(), e16);
            Log.d("CentaurResInjector", "try addResourcesExtra");
            b(context, context.getResources(), list);
            return null;
        }
    }

    private static Resources b(Context context, Resources resources, List<String> list) throws CentaurInjectFailException {
        if (resources == null || list == null || list.isEmpty()) {
            return null;
        }
        if (f99141a != null) {
            try {
                AssetManager assets = context.getAssets();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    f99141a.invoke(assets, it.next());
                }
                j(assets, list);
                Log.d("CentaurResInjector", "inject success");
                return resources;
            } catch (Exception e16) {
                throw new CentaurInjectFailException(1, e16);
            }
        }
        throw new CentaurInjectFailException(1, new Throwable("Can't get addAssetPath function."));
    }

    public static Resources c(Context context, List<String> list) throws CentaurInjectFailException {
        if (list != null && list.size() != 0) {
            if (i(context)) {
                return a(context, list);
            }
            return b(context, context.getResources(), list);
        }
        return null;
    }

    private static boolean d(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    private static void e() {
        if (f99141a == null || f99142b == null) {
            Log.d("CentaurResInjector", "METHOD_ADD_ASSET and FIELD_ASSETS init");
            try {
                Class<?> cls = Class.forName("android.content.res.Resources");
                Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
                f99141a = declaredMethod;
                declaredMethod.setAccessible(true);
                if (h()) {
                    f99145e = Class.forName("android.content.res.ResourcesImpl");
                    Field declaredField = cls.getDeclaredField("mResourcesImpl");
                    f99143c = declaredField;
                    declaredField.setAccessible(true);
                    f99142b = f99145e.getDeclaredField("mAssets");
                } else {
                    f99142b = cls.getDeclaredField("mAssets");
                }
                f99142b.setAccessible(true);
            } catch (Exception e16) {
                Log.e("CentaurResInjector", "prepare inject df plugin error: ", e16);
            }
        }
        if (f99147g == null) {
            Log.d("CentaurResInjector", "references init");
            try {
                if (g()) {
                    f99146f = ResourcesManager.class;
                    Object invoke = ResourcesManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    try {
                        Field declaredField2 = f99146f.getDeclaredField("mActiveResources");
                        declaredField2.setAccessible(true);
                        f99147g = ((ArrayMap) declaredField2.get(invoke)).values();
                    } catch (NoSuchFieldException unused) {
                        Field declaredField3 = f99146f.getDeclaredField("mResourceReferences");
                        declaredField3.setAccessible(true);
                        f99147g = (Collection) declaredField3.get(invoke);
                    }
                }
            } catch (Exception e17) {
                Log.e("CentaurResInjector", "prepare inject df plugin error: ", e17);
            }
        }
        if (f99144d == null) {
            Log.d("CentaurResInjector", "FIELD_APK_ASSET init");
            try {
                Field declaredField4 = AssetManager.class.getDeclaredField("mApkAssets");
                f99144d = declaredField4;
                declaredField4.setAccessible(true);
            } catch (Exception e18) {
                Log.e("CentaurResInjector", "prepare inject df plugin error: ", e18);
            }
        }
    }

    private static void f(Object obj, int i3, AssetManager assetManager, List<String> list, List<Object> list2, Class cls, Class cls2) throws Exception {
        for (int i16 = 0; i16 < i3; i16++) {
            Object obj2 = Array.get(obj, i16);
            if (obj2 != null) {
                String obj3 = obj2.toString();
                if (!obj3.contains(QQPermissionConstants.Permission.STORAGE_GROUP) || !d(list, obj3)) {
                    list2.add(obj2);
                }
            }
        }
        Object newInstance = Array.newInstance((Class<?>) cls2, list2.size());
        for (int i17 = 0; i17 < list2.size(); i17++) {
            Array.set(newInstance, i17, list2.get(i17));
        }
        AssetManager.class.getDeclaredMethod("setApkAssets", cls, Boolean.TYPE).invoke(assetManager, newInstance, Boolean.TRUE);
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean g() {
        return true;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean h() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean i(Context context) {
        if (Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion < 28) {
            return true;
        }
        return false;
    }

    private static void j(AssetManager assetManager, List<String> list) throws Exception {
        try {
            Log.i("CentaurResInjector", "reset start");
            if (f99144d == null) {
                e();
            }
            Object obj = f99144d.get(assetManager);
            ArrayList arrayList = new ArrayList();
            Class<?> cls = obj.getClass();
            Class<?> componentType = cls.getComponentType();
            int length = Array.getLength(obj);
            for (String str : list) {
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    Object obj2 = Array.get(obj, i3);
                    if (obj2 != null && obj2.toString().contains(str)) {
                        arrayList.add(obj2);
                    }
                }
            }
            f(obj, length, assetManager, list, arrayList, cls, componentType);
        } catch (Exception e16) {
            Log.e("CentaurResInjector", "reset error:" + e16.getMessage(), e16);
        }
    }
}
