package com.tencent.mobileqq.perf.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly3.c;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0002J2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0004H\u0002J(\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00040\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0002J\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011`\u0012R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0014R\u001a\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0017\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/perf/receiver/a;", "", "b", "activityThread", "Landroid/util/ArrayMap;", "", "Ljava/lang/ref/WeakReference;", "f", "mPackages", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "loadedApk", "Landroid/content/Context;", "Landroid/content/BroadcastReceiver;", "e", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/lang/String;", "TAG", "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "activityThreadClazz", "loadedApkClazz", "Ljava/lang/reflect/Field;", "Ljava/lang/reflect/Field;", "mPackagesField", "mReceiversField", "g", "Ljava/lang/Object;", "", h.F, "Z", "()Z", "initSuccess", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"PrivateApi"})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257954a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Class<?> activityThreadClazz;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Class<?> loadedApkClazz;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Field mPackagesField;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Field mReceiversField;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object activityThread;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final boolean initSuccess;

    static {
        Object obj;
        Object b16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        a aVar = new a();
        f257954a = aVar;
        TAG = "CountReceiversUtil";
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Intrinsics.checkNotNullExpressionValue(cls, "forName(\"android.app.ActivityThread\")");
            activityThreadClazz = cls;
            Class<?> cls2 = Class.forName("android.app.LoadedApk");
            Intrinsics.checkNotNullExpressionValue(cls2, "forName(\"android.app.LoadedApk\")");
            loadedApkClazz = cls2;
            Class<?> cls3 = activityThreadClazz;
            Class<?> cls4 = null;
            if (cls3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityThreadClazz");
                cls3 = null;
            }
            Field declaredField = cls3.getDeclaredField("mPackages");
            Intrinsics.checkNotNullExpressionValue(declaredField, "activityThreadClazz.getDeclaredField(\"mPackages\")");
            mPackagesField = declaredField;
            Class<?> cls5 = loadedApkClazz;
            if (cls5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadedApkClazz");
            } else {
                cls4 = cls5;
            }
            Field declaredField2 = cls4.getDeclaredField("mReceivers");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "loadedApkClazz.getDeclaredField(\"mReceivers\")");
            mReceiversField = declaredField2;
            b16 = aVar.b();
        } catch (Throwable th5) {
            try {
                QLog.e(TAG, 1, "ReflectReceivers init failed.", th5);
                obj = new Object();
            } catch (Throwable th6) {
                activityThread = new Object();
                initSuccess = false;
                throw th6;
            }
        }
        if (b16 == null) {
            obj = new Object();
            activityThread = obj;
            initSuccess = false;
        } else {
            activityThread = b16;
            initSuccess = true;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Object b() {
        Class<?> cls = activityThreadClazz;
        if (cls == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityThreadClazz");
            cls = null;
        }
        return ly3.c.b(cls, "currentActivityThread", new c.b[0]);
    }

    private final ArrayList<Object> d(ArrayMap<String, WeakReference<Object>> mPackages) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, WeakReference<Object>>> it = mPackages.entrySet().iterator();
        while (it.hasNext()) {
            Object obj = it.next().getValue().get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final ArrayMap<Context, ArrayMap<BroadcastReceiver, Object>> e(Object loadedApk) {
        Field field = mReceiversField;
        if (field == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReceiversField");
            field = null;
        }
        Object g16 = ly3.c.g(loadedApk, field);
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.util.ArrayMap<android.content.Context, android.util.ArrayMap<android.content.BroadcastReceiver, kotlin.Any>>");
        return (ArrayMap) g16;
    }

    private final ArrayMap<String, WeakReference<Object>> f(Object activityThread2) {
        Field field = mPackagesField;
        if (field == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPackagesField");
            field = null;
        }
        Object g16 = ly3.c.g(activityThread2, field);
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, java.lang.ref.WeakReference<kotlin.Any>>");
        return (ArrayMap) g16;
    }

    @NotNull
    public final HashMap<String, Integer> a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!initSuccess) {
            QLog.e(TAG, 1, "ReflectReceivers init failed. countReceivers return empty.");
            return new HashMap<>();
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<T> it = d(f(activityThread)).iterator();
            while (it.hasNext()) {
                for (Map.Entry<Context, ArrayMap<BroadcastReceiver, Object>> entry : f257954a.e(it.next()).entrySet()) {
                    Context key = entry.getKey();
                    ArrayMap<BroadcastReceiver, Object> arrayMap = entry.getValue();
                    String name = key.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(arrayMap, "arrayMap");
                    Iterator<Map.Entry<BroadcastReceiver, Object>> it5 = arrayMap.entrySet().iterator();
                    while (it5.hasNext()) {
                        String str = name + util.base64_pad_url + it5.next().getKey().getClass().getName();
                        Integer num = hashMap.get(str);
                        if (num != null) {
                            i3 = num.intValue() + 1;
                        } else {
                            i3 = 1;
                        }
                        hashMap.put(str, Integer.valueOf(i3));
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i(TAG, 4, "receiverToCount: " + hashMap + ", cost: " + currentTimeMillis2 + " ms");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "countReceivers failed.", th5);
        }
        return hashMap;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return initSuccess;
    }
}
