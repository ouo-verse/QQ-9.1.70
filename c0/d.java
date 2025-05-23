package c0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f30200a;

    public d(Context context) {
        this.f30200a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b b(String str) {
        Object obj;
        try {
            Class<?> cls = Class.forName(str);
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e16) {
                c(cls, e16);
                obj = null;
                if (obj instanceof b) {
                }
            } catch (InstantiationException e17) {
                c(cls, e17);
                obj = null;
                if (obj instanceof b) {
                }
            } catch (NoSuchMethodException e18) {
                c(cls, e18);
                obj = null;
                if (obj instanceof b) {
                }
            } catch (InvocationTargetException e19) {
                c(cls, e19);
                obj = null;
                if (obj instanceof b) {
                }
            }
            if (obj instanceof b) {
                return (b) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e26) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e26);
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<b> a() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f30200a.getPackageManager().getApplicationInfo(this.f30200a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(b(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e16) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e16);
        }
    }
}
