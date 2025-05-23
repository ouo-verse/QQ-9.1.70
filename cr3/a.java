package cr3;

import android.content.Context;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.core.o;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static boolean a(Context context, String str, ClassLoader classLoader) {
        int i3 = 0;
        while (classLoader != null) {
            o.a("ClassLoaderHook", "count:" + i3 + " " + str + " parent classLoader equal context: " + classLoader.equals(context.getClassLoader()) + " classLoaderName:" + classLoader.getClass().getName());
            if (classLoader.equals(context.getClassLoader())) {
                o.a("ClassLoaderHook", str + " include host classLoader");
                return true;
            }
            classLoader = classLoader.getParent();
            i3++;
        }
        o.a("ClassLoaderHook", str + " no include host classLoader");
        return false;
    }

    public static void b(Context context, ClassLoader classLoader) {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField(HippyNestedScrollComponent.PRIORITY_PARENT);
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(classLoader, new b(classLoader.getParent(), context));
            }
            o.a("ClassLoaderHook", "replace Parent ClassLoader!");
        } catch (Exception e16) {
            o.d("ClassLoaderHook", "ReplaceParentClassLoader error: ", e16);
        }
    }
}
