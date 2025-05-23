package p04;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f424873a;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f424874b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f424875c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f424876d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f424877e;

    static {
        try {
            f424874b = Class.forName("com.facebook.drawee.generic.RootDrawable");
            f424875c = Class.forName("com.facebook.drawee.drawable.FadeDrawable");
            Method method = f424874b.getMethod("getCurrent", new Class[0]);
            f424873a = method;
            method.setAccessible(true);
            Field declaredField = f424875c.getDeclaredField("mIsLayerOn");
            f424876d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f424875c.getDeclaredField("mLayers");
            f424877e = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Throwable th5) {
            Logger.f365497g.w("RMonitor_BigBitmap_RootDrawableSizeProvider", th5.toString());
        }
    }

    @Nullable
    private n04.a d(Object obj) {
        try {
            boolean[] zArr = (boolean[]) f424876d.get(obj);
            Drawable[] drawableArr = (Drawable[]) f424877e.get(obj);
            if (zArr != null && drawableArr != null && zArr.length == drawableArr.length && drawableArr.length >= 6) {
                Drawable drawable = drawableArr[2];
                if (zArr[2] && drawable != null) {
                    return new n04.a(1, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            Logger.f365497g.w("RMonitor_BigBitmap_RootDrawableSizeProvider", th5.toString());
            return null;
        }
    }

    @Override // p04.a
    @Nullable
    public n04.a a(@Nullable Drawable drawable) {
        return null;
    }

    @Override // p04.a
    @Nullable
    public n04.a b(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getClass() == f424874b) {
            try {
                Drawable drawable2 = (Drawable) f424873a.invoke(drawable, new Object[0]);
                if (drawable2 != null && drawable2.getClass() == f424875c) {
                    return d(drawable2);
                }
                return null;
            } catch (Throwable th5) {
                Logger.f365497g.w("RMonitor_BigBitmap_RootDrawableSizeProvider", th5.toString());
                return null;
            }
        }
        return null;
    }
}
