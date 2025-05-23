package com.tencent.luggage.wxa.q7;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f138016a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static String f138017b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f138018c;

    public final void a(Context context, String dynamicPkgPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dynamicPkgPath, "dynamicPkgPath");
        if (f138018c) {
            Log.w("Luggage.PluginManager", "path list already prepared");
            com.tencent.luggage.wxa.tn.w.f("Luggage.PluginManager", "path list already prepared");
            return;
        }
        f138017b = dynamicPkgPath;
        if (com.tencent.luggage.wxa.tn.z.m()) {
            Log.w("Luggage.PluginManager", "init been called in main process");
            com.tencent.luggage.wxa.tn.w.f("Luggage.PluginManager", "init been called in main process");
        } else {
            ClassLoader classLoader = context.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "context.classLoader");
            f138018c = a(classLoader, dynamicPkgPath);
        }
    }

    public final void b(Context context, String str) {
        try {
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            Intrinsics.checkNotNullExpressionValue(method, "AssetManager::class.java\u2026ath\", String::class.java)");
            com.tencent.luggage.wxa.tn.w.d("Luggage.PluginManager", "assets path num: " + method.invoke(context.getAssets(), str + "wxa_library.zip"));
        } catch (IllegalAccessException e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "IllegalAccessException", e16);
            e16.printStackTrace();
        } catch (InstantiationException e17) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "InstantiationException", e17);
            e17.printStackTrace();
        } catch (NoSuchMethodException e18) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "NoSuchMethodException", e18);
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "InvocationTargetException", e19);
            e19.printStackTrace();
        }
    }

    public final boolean a(ClassLoader classLoader, String str) {
        return a(new File(str), classLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    public final boolean a(File file, ClassLoader classLoader) {
        ?? r26;
        ?? r27;
        ?? r28;
        ?? r95;
        Method declaredMethod;
        Object invoke;
        Field declaredField;
        Object[] objArr;
        boolean z16;
        Intrinsics.checkNotNull(classLoader, "null cannot be cast to non-null type dalvik.system.BaseDexClassLoader");
        BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) classLoader;
        com.tencent.luggage.wxa.tn.w.d("Luggage.PluginManager", "pathClassLoader: " + baseDexClassLoader);
        Object obj = Reflect.on(baseDexClassLoader).field("pathList").get();
        if (obj == null) {
            return false;
        }
        try {
            try {
                r95 = Build.VERSION.SDK_INT;
                if (r95 > 25) {
                    declaredMethod = obj.getClass().getDeclaredMethod("makePathElements", List.class);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "{\n                      \u2026va)\n                    }");
                } else {
                    declaredMethod = obj.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "{\n                      \u2026va)\n                    }");
                }
                declaredMethod.setAccessible(true);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(file);
                ArrayList arrayList3 = new ArrayList(arrayList2);
                Field declaredField2 = obj.getClass().getDeclaredField("systemNativeLibraryDirectories");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<java.io.File>");
                List list = (List) obj2;
                StringBuilder sb5 = new StringBuilder();
                try {
                    sb5.append("systemNativeLibraryDirectories ");
                    sb5.append(list);
                    com.tencent.luggage.wxa.tn.w.d("insertNativeLibrary", sb5.toString());
                    arrayList3.addAll(list);
                    try {
                        if (r95 > 25) {
                            Object[] objArr2 = new Object[1];
                            objArr2[0] = arrayList3;
                            invoke = declaredMethod.invoke(baseDexClassLoader, objArr2);
                        } else {
                            Object[] objArr3 = new Object[3];
                            objArr3[0] = arrayList3;
                            objArr3[1] = null;
                            objArr3[2] = arrayList;
                            invoke = declaredMethod.invoke(baseDexClassLoader, objArr3);
                        }
                        Intrinsics.checkNotNullExpressionValue(invoke, "if (buildVersion > Build\u2026ptions)\n                }");
                        com.tencent.luggage.wxa.tn.w.d("insertNativeLibrary", "makePathElements " + invoke);
                        Field declaredField3 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
                        declaredField3.setAccessible(true);
                        Object obj3 = declaredField3.get(obj);
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<java.io.File>");
                        List list2 = (List) obj3;
                        com.tencent.luggage.wxa.tn.w.d("insertNativeLibrary", "nativeLibraryDirectories " + list2);
                        ArrayList arrayList4 = new ArrayList(arrayList2);
                        arrayList4.addAll(list2);
                        declaredField3.set(obj, arrayList4);
                        declaredField = obj.getClass().getDeclaredField("nativeLibraryPathElements");
                        declaredField.setAccessible(true);
                        r95 = declaredField.get(obj);
                        com.tencent.luggage.wxa.tn.w.d("insertNativeLibrary", "nativeLibraryPathElements " + r95);
                        Class<?> componentType = invoke.getClass().getComponentType();
                        int length = ((Object[]) invoke).length;
                        Intrinsics.checkNotNull(r95, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                        Object newInstance = Array.newInstance(componentType, length + ((Object[]) r95).length);
                        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                        objArr = (Object[]) newInstance;
                        z16 = false;
                    } catch (IllegalAccessException e16) {
                        e = e16;
                        r28 = r95;
                    } catch (NoSuchFieldException e17) {
                        e = e17;
                        r27 = r95;
                    } catch (NoSuchMethodException e18) {
                        e = e18;
                        r26 = r95;
                    }
                } catch (IllegalAccessException e19) {
                    e = e19;
                    r28 = 0;
                } catch (NoSuchFieldException e26) {
                    e = e26;
                    r27 = 0;
                } catch (NoSuchMethodException e27) {
                    e = e27;
                    r26 = 0;
                }
            } catch (IllegalAccessException e28) {
                e = e28;
                r28 = 0;
            } catch (NoSuchFieldException e29) {
                e = e29;
                r27 = 0;
            } catch (NoSuchMethodException e36) {
                e = e36;
                r26 = 0;
            }
            try {
                System.arraycopy(r95, 0, objArr, 0, ((Object[]) r95).length);
                z16 = false;
                System.arraycopy(invoke, 0, objArr, ((Object[]) r95).length, ((Object[]) invoke).length);
                declaredField.set(obj, objArr);
                n.f138019a.a(baseDexClassLoader, "pathList", obj);
                com.tencent.luggage.wxa.tn.w.d("Luggage.PluginManager", "pathClassLoader end: " + baseDexClassLoader);
                return true;
            } catch (IllegalAccessException e37) {
                e = e37;
                r28 = z16;
                Object[] objArr4 = new Object[1];
                objArr4[r28] = e;
                com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "IllegalAccessException", objArr4);
                e.printStackTrace();
                return r28;
            } catch (NoSuchFieldException e38) {
                e = e38;
                r27 = z16;
                Object[] objArr5 = new Object[1];
                objArr5[r27] = e;
                com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "NoSuchFieldException", objArr5);
                e.printStackTrace();
                return r27;
            } catch (NoSuchMethodException e39) {
                e = e39;
                r26 = z16;
                Object[] objArr6 = new Object[1];
                objArr6[r26] = e;
                com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "NoSuchMethodException", objArr6);
                e.printStackTrace();
                return r26;
            }
        } catch (InvocationTargetException e46) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.PluginManager", "InvocationTargetException", e46);
            e46.printStackTrace();
            return false;
        }
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = f138017b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDynamicPkgPath");
            str = null;
        }
        b(context, str);
    }
}
