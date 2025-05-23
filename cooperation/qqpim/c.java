package cooperation.qqpim;

import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {
    public static AppRuntime a(BaseApplicationImpl baseApplicationImpl, String str) {
        Class<?> cls;
        if (baseApplicationImpl != null && str != null) {
            try {
                try {
                    try {
                        cls = Class.forName("com.qqpim.application.QQPimPluginRuntime");
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (IllegalArgumentException e17) {
                        e17.printStackTrace();
                    } catch (InstantiationException e18) {
                        e18.printStackTrace();
                    } catch (NoSuchMethodException e19) {
                        e19.printStackTrace();
                    } catch (InvocationTargetException e26) {
                        e26.printStackTrace();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                } catch (ClassNotFoundException unused) {
                    ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(baseApplicationImpl, "qqpim_plugin.apk");
                    Class<?> loadClass = orCreateClassLoader.loadClass("com.qqpim.application.QQPimPluginRuntime");
                    BasicClassTypeUtil.setClassLoader(true, orCreateClassLoader);
                    cls = loadClass;
                }
            } catch (ClassNotFoundException e28) {
                e28.printStackTrace();
            }
            if (cls == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(a.f390797a, 2, "createQQPimRuntime() cls == null");
                }
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(a.f390797a, 2, "createQQPimRuntime() 1 ");
            }
            Object newInstance = cls.getDeclaredConstructor(BaseApplicationImpl.class, String.class).newInstance(baseApplicationImpl, str);
            if (newInstance != null && (newInstance instanceof AppRuntime)) {
                if (QLog.isColorLevel()) {
                    QLog.d(a.f390797a, 2, "createQQPimRuntime() succ");
                }
                return (AppRuntime) newInstance;
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(a.f390797a, 2, "createQQPimRuntime() application == null || processName == null");
        }
        return null;
    }
}
