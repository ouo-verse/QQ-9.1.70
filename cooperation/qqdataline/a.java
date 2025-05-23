package cooperation.qqdataline;

import android.content.Context;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static AppInterface a(BaseApplicationImpl baseApplicationImpl, String str) {
        Class<?> cls;
        QLog.i("DatalineHelper", 1, "createDatalineAppInterface processName:" + str);
        if (baseApplicationImpl != null && str != null) {
            try {
                try {
                    cls = Class.forName("com.qqdataline.app.DatalineAppInterface");
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
            } catch (ClassNotFoundException e28) {
                try {
                    ClassLoader b16 = b(baseApplicationImpl);
                    Class<?> loadClass = b16.loadClass("com.qqdataline.app.DatalineAppInterface");
                    BasicClassTypeUtil.setClassLoader(true, b16);
                    e28.printStackTrace();
                    cls = loadClass;
                } catch (ClassNotFoundException e29) {
                    e29.printStackTrace();
                }
            }
            if (cls == null) {
                QLog.e("DatalineHelper", 1, "createDatalineAppInterface cls is null");
                return null;
            }
            Object newInstance = cls.getDeclaredConstructor(baseApplicationImpl.getClass(), str.getClass()).newInstance(baseApplicationImpl, str);
            c(baseApplicationImpl);
            if (newInstance != null && (newInstance instanceof AppInterface)) {
                return (AppInterface) newInstance;
            }
            QLog.e("DatalineHelper", 1, "createDatalineAppInterface obj is not AppInterface instance");
            return null;
        }
        QLog.e("DatalineHelper", 1, "createDatalineAppInterface content is null");
        return null;
    }

    public static ClassLoader b(Context context) throws Exception {
        return PluginStatic.getOrCreateClassLoader(context, "qqdataline.apk");
    }

    private static void c(Context context) {
        IPluginAdapterProxy proxy = IPluginAdapterProxy.getProxy();
        if (proxy == null) {
            IPluginAdapterProxy.setProxy(new c());
            proxy = IPluginAdapterProxy.getProxy();
        }
        try {
            proxy.initSkinEngine(context);
            QLog.d("DatalineHelper", 1, "initSkinEngine over.");
        } catch (Exception e16) {
            QLog.e("DatalineHelper", 1, "initSkinEngine err.", e16);
        }
    }
}
