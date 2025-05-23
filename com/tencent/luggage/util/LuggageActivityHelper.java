package com.tencent.luggage.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.rj.i;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LuggageActivityHelper {
    protected static final String KEY_INSTANCE_ID = "Luggage.LuggageActivityHelperinstance_id";
    protected static final String KEY_PROC_NAME = "Luggage.LuggageActivityHelperproc_name";
    protected static final String KEY_REQ_CODE = "Luggage.LuggageActivityHelperreq_code";
    private static final String TAG = "Luggage.LuggageActivityHelper";
    private static i sCheckPermissionDelegate;
    protected static final Map<Activity, c> sHelpers = new WeakHashMap();

    @Nullable
    private WeakReference<Activity> mActivity;
    private b mActivityFinishInterceptCallback;
    protected final SparseArray<d> mActivityResultCallbacks = new SparseArray<>();
    private final SparseArray<h> mPermissionResultCallbacks = new SparseArray<>();
    private final Set<e> mInterceptResultCallbacks = Collections.newSetFromMap(new ConcurrentHashMap());
    private Random mRand = new Random();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class ActivityAutoRelease {

        /* renamed from: a, reason: collision with root package name */
        public static Set f120364a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        public static boolean f120365b;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        public static class a extends com.tencent.luggage.wxa.tk.a {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (ActivityAutoRelease.f120364a.remove(activity)) {
                    LuggageActivityHelper.a(activity);
                    if (ActivityAutoRelease.f120364a.isEmpty()) {
                        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                        boolean unused = ActivityAutoRelease.f120365b = false;
                    }
                }
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public static void a(final Activity activity, final LuggageActivityHelper luggageActivityHelper) {
            if (activity instanceof AppCompatActivity) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    c0.a(new Runnable() { // from class: com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!activity.isFinishing() && !activity.isDestroyed()) {
                                ((AppCompatActivity) activity).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.1.1
                                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                                    public void cleanUp() {
                                        luggageActivityHelper.cleanUp();
                                    }
                                });
                            } else {
                                luggageActivityHelper.cleanUp();
                            }
                        }
                    });
                    return;
                } else {
                    ((AppCompatActivity) activity).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public void cleanUp() {
                            LuggageActivityHelper.this.cleanUp();
                        }
                    });
                    return;
                }
            }
            f120364a.add(activity);
            if (f120365b) {
                return;
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new a(null));
            f120365b = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f120370a;

        public a(e eVar) {
            this.f120370a = eVar;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.e
        public boolean a(int i3, int i16, Intent intent) {
            LuggageActivityHelper.this.removeInterceptActivityResultCallback(this);
            return this.f120370a.a(i3, i16, intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map f120372a = new HashMap();

        public Map a() {
            return this.f120372a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d extends f {
        void a(int i3, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e extends f {
        boolean a(int i3, int i16, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface g {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface h extends f {
        void a(String[] strArr, int[] iArr);
    }

    public LuggageActivityHelper(@Nullable Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }

    public static LuggageActivityHelper FOR(Context context) {
        return FOR(context, LuggageActivityHelper.class);
    }

    public static void REMOVE(Context context) {
        a(context);
    }

    public final boolean a() {
        return true;
    }

    public final int b() {
        return (this.mRand.nextInt(2147483646) + 1) & 65535;
    }

    public boolean checkRequestPermission(String str, h hVar) {
        return checkRequestPermission(null, str, hVar);
    }

    public void cleanUp() {
        a(getActivity());
    }

    public void finish() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && a()) {
            activity.finish();
        }
    }

    public int genRandomCodeFor(SparseArray sparseArray) {
        int b16;
        do {
            b16 = b();
        } while (sparseArray.get(b16) != null);
        return b16;
    }

    @Nullable
    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void interceptActivityPermissionResult(int i3, h hVar) {
        if (hVar == null) {
            return;
        }
        this.mPermissionResultCallbacks.put(i3, hVar);
    }

    public void interceptActivityResult(e eVar) {
        if (eVar == null) {
            return;
        }
        this.mInterceptResultCallbacks.add(eVar);
    }

    public void interceptActivityResultOnce(e eVar) {
        if (eVar == null) {
            return;
        }
        interceptActivityResult(new a(eVar));
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        Iterator<e> it = this.mInterceptResultCallbacks.iterator();
        while (it.hasNext()) {
            if (it.next().a(i3, i16, intent)) {
                return;
            }
        }
        d dVar = this.mActivityResultCallbacks.get(i3);
        this.mActivityResultCallbacks.delete(i3);
        if (dVar != null) {
            dVar.a(i16, intent);
        }
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        h hVar = this.mPermissionResultCallbacks.get(i3);
        this.mPermissionResultCallbacks.delete(i3);
        if (hVar != null) {
            hVar.a(strArr, iArr);
        }
    }

    public void removeInterceptActivityPermissionResult(int i3, h hVar) {
        if (hVar == null) {
            return;
        }
        this.mPermissionResultCallbacks.remove(i3);
    }

    public void removeInterceptActivityResultCallback(e eVar) {
        if (eVar == null) {
            return;
        }
        this.mInterceptResultCallbacks.remove(eVar);
    }

    @TargetApi(23)
    public void requestPermissions(String[] strArr, h hVar) {
        requestPermissions(null, strArr, hVar);
    }

    public void startActivityForResult(Intent intent, d dVar) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int genRandomCodeFor = genRandomCodeFor(this.mActivityResultCallbacks);
        this.mActivityResultCallbacks.put(genRandomCodeFor, dVar);
        activity.startActivityForResult(intent, genRandomCodeFor);
    }

    public void startActivityForResultThrows(Intent intent, d dVar) {
        startActivityForResult(intent, dVar);
    }

    public static <T extends LuggageActivityHelper> T FOR(Context context, Class<T> cls) {
        com.tencent.luggage.wxa.er.a.a("must implements ILuggageActivityHelper", false);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if ((activity.isFinishing() || activity.isDestroyed()) && cls == LuggageActivityHelper.class) {
                w.b(TAG, "FOR(%s, %s) instance destroyed, return DUMMY", activity, cls.getCanonicalName());
                return (T) a(LuggageActivityHelper.class, activity);
            }
            Map<Activity, c> map = sHelpers;
            c cVar = map.get(activity);
            if (cVar == null) {
                cVar = new c();
                map.put(activity, cVar);
            }
            if (((LuggageActivityHelper) cVar.f120372a.get(cls)) == null) {
                LuggageActivityHelper luggageActivityHelper = (LuggageActivityHelper) Reflect.on((Class<?>) cls).create(activity).get();
                cVar.f120372a.put(cls, luggageActivityHelper);
                ActivityAutoRelease.a(activity, luggageActivityHelper);
            }
            return (T) cVar.f120372a.get(cls);
        }
        com.tencent.luggage.wxa.er.a.a(false);
        return (T) a(cls, null);
    }

    public static Object a(Class cls, Activity activity) {
        return (LuggageActivityHelper) Reflect.on((Class<?>) cls).create(activity).get();
    }

    public boolean checkRequestPermission(com.tencent.luggage.wxa.xd.d dVar, String str, h hVar) {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        try {
            if (ContextCompat.checkSelfPermission(activity, str) == 0) {
                return true;
            }
            requestPermissions(new String[]{str}, hVar);
            return false;
        } catch (Exception e16) {
            w.b(TAG, "check mpermission exception:%s.", e16);
            return true;
        }
    }

    @TargetApi(23)
    public void requestPermissions(com.tencent.luggage.wxa.xd.d dVar, String[] strArr, h hVar) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int genRandomCodeFor = genRandomCodeFor(this.mPermissionResultCallbacks);
        this.mPermissionResultCallbacks.put(genRandomCodeFor, hVar);
        PermissionMonitor.requestPermissions(activity, strArr, genRandomCodeFor);
    }

    public static void a(Context context) {
        c remove;
        if (!(context instanceof Activity) || (remove = sHelpers.remove(context)) == null) {
            return;
        }
        for (Map.Entry entry : remove.a().entrySet()) {
            LuggageActivityHelper luggageActivityHelper = (LuggageActivityHelper) entry.getValue();
            w.d(TAG, "FOR: put" + ((Class) entry.getKey()).getCanonicalName() + MsgSummary.STR_COLON + context.getClass().getCanonicalName());
            luggageActivityHelper.mActivityResultCallbacks.clear();
            luggageActivityHelper.mInterceptResultCallbacks.clear();
            luggageActivityHelper.mPermissionResultCallbacks.clear();
        }
    }

    public static void setCheckPermissionDelegate(i iVar) {
    }

    public void interceptActivityFinish(b bVar) {
    }
}
