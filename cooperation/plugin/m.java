package cooperation.plugin;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static Class<AssetManager> f390324a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f390325b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f390326c;

    /* renamed from: d, reason: collision with root package name */
    private static Class f390327d;

    /* renamed from: e, reason: collision with root package name */
    private static Class f390328e;

    /* renamed from: f, reason: collision with root package name */
    private static Field f390329f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f390330g;

    /* renamed from: h, reason: collision with root package name */
    private static Collection<WeakReference<Resources>> f390331h;

    static {
        try {
            f390326c = Class.forName("android.content.res.Resources");
            f390324a = AssetManager.class;
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            f390325b = declaredMethod;
            declaredMethod.setAccessible(true);
            if (d()) {
                f390327d = Class.forName("android.content.res.ResourcesImpl");
                Field declaredField = f390326c.getDeclaredField("mResourcesImpl");
                f390330g = declaredField;
                declaredField.setAccessible(true);
                f390329f = f390327d.getDeclaredField("mAssets");
            } else {
                f390329f = f390326c.getDeclaredField("mAssets");
            }
            f390329f.setAccessible(true);
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "prepare inject df plugin error: ", e16);
        }
        try {
            if (c()) {
                f390328e = ResourcesManager.class;
                Object invoke = ResourcesManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                try {
                    Field declaredField2 = f390328e.getDeclaredField("mActiveResources");
                    declaredField2.setAccessible(true);
                    f390331h = ((ArrayMap) declaredField2.get(invoke)).values();
                } catch (NoSuchFieldException unused) {
                    Field declaredField3 = f390328e.getDeclaredField("mResourceReferences");
                    declaredField3.setAccessible(true);
                    f390331h = (Collection) declaredField3.get(invoke);
                }
            }
        } catch (Exception e17) {
            QLog.e("plugin_tag", 1, "prepare inject df plugin error: ", e17);
        }
    }

    public static Resources a(Context context, Resources resources, List<String> list) throws InjectFailException {
        if (resources == null || list == null || list.isEmpty()) {
            return null;
        }
        if (f390325b != null) {
            try {
                AssetManager assets = context.getAssets();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    f390325b.invoke(assets, it.next());
                }
                if (d()) {
                    f390329f.set(f390330g.get(resources), assets);
                } else {
                    f390329f.set(resources, assets);
                }
                Iterator<WeakReference<Resources>> it5 = f390331h.iterator();
                while (it5.hasNext()) {
                    Resources resources2 = it5.next().get();
                    if (resources2 != null) {
                        AssetManager assets2 = resources2.getAssets();
                        Iterator<String> it6 = list.iterator();
                        while (it6.hasNext()) {
                            f390325b.invoke(assets2, it6.next());
                        }
                    }
                }
                return resources;
            } catch (Exception e16) {
                throw new InjectFailException(1, e16);
            }
        }
        throw new InjectFailException(1, new Throwable("Can't get addAssetPath function."));
    }

    public static Resources b(Context context, List<String> list) throws InjectFailException {
        return a(context, context.getResources(), list);
    }

    private static boolean c() {
        return true;
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }
}
