package mqq.util;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.List;
import mqq.app.api.IRuntimeService;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RuntimeServiceHelper {
    public static final String TAG = "RuntimeServiceHelper";
    private static final HashSet<String> blackList = new HashSet<>();
    public static int debugSwitch;
    private static boolean enableSetNull;
    private static final HashSet<String> importantRuntimeService;

    static {
        HashSet<String> hashSet = new HashSet<>();
        importantRuntimeService = hashSet;
        enableSetNull = false;
        debugSwitch = 0;
        hashSet.add("com.tencent.qqnt.kernel.api.IKernelService");
    }

    public static <T> T createReturnProxy(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RuntimeServiceProxy());
    }

    public static <T extends IRuntimeService> T createRuntimeServiceProxy(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RuntimeServiceProxy());
    }

    public static boolean hitRuntimeServiceSetNullWhiteList(Class<?> cls) {
        int i3 = debugSwitch;
        if (i3 == -1) {
            return false;
        }
        if (enableSetNull || i3 == 1 || !MqqInjectorManager.instance().isPublicVersion()) {
            return !blackList.contains(cls.getName());
        }
        return false;
    }

    public static boolean isImportantRuntimeService(Class<?> cls) {
        return importantRuntimeService.contains(cls.getName());
    }

    public static boolean isRuntimeServiceProxy(Object obj) {
        return Proxy.isProxyClass(obj.getClass());
    }

    public static void updateBlackList(List<String> list) {
        QLog.i(TAG, 1, "updateBlackList: " + list.size());
        blackList.addAll(list);
    }

    public static void updateEnableSetNull(boolean z16) {
        QLog.i(TAG, 1, "updateEnableSetNull: " + z16);
        enableSetNull = z16;
    }

    public static boolean isImportantRuntimeService(String str) {
        return importantRuntimeService.contains(str);
    }

    public static boolean hitRuntimeServiceSetNullWhiteList(String str) {
        int i3 = debugSwitch;
        if (i3 == -1) {
            return false;
        }
        if (enableSetNull || i3 == 1 || !MqqInjectorManager.instance().isPublicVersion()) {
            return !blackList.contains(str);
        }
        return false;
    }
}
