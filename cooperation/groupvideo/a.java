package cooperation.groupvideo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:groupvideo".compareTo(it.next().processName) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(QQAppInterface qQAppInterface, Context context, Intent intent, int i3) {
        if (qQAppInterface == null || !(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        IPluginManager iPluginManager = (IPluginManager) qQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
        if (iPluginManager == null) {
            return false;
        }
        if (iPluginManager.isPlugininstalled("group_video_plugin.apk")) {
            return c(qQAppInterface, activity, intent, i3);
        }
        activity.startActivityForResult(intent, i3);
        return true;
    }

    public static void a(AppRuntime appRuntime, Class cls, ServiceConnection serviceConnection, String str) {
        if (appRuntime == null || serviceConnection == null) {
            return;
        }
        Intent intent = new Intent(appRuntime.getApplication(), (Class<?>) cls);
        intent.putExtra(PluginStatic.PARAM_USE_SKIN_ENGINE, 1);
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        IPluginManager.i iVar = new IPluginManager.i(1);
        iVar.f390198d = "group_video_plugin.apk";
        iVar.f390201g = PluginInfo.D;
        iVar.f390197c = appRuntime.getAccount();
        iVar.f390202h = str;
        iVar.f390204j = intent;
        iVar.f390209o = serviceConnection;
        IPluginManager.A5(appRuntime.getApplication(), iVar);
    }

    public static void f(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        if (appRuntime == null || serviceConnection == null) {
            return;
        }
        try {
            appRuntime.getApplication().unbindService(serviceConnection);
        } catch (IllegalArgumentException e16) {
            QLog.d("GroupVideoHelper", 2, "unbindService error" + e16.getMessage());
        }
    }

    public static AppRuntime b(BaseApplicationImpl baseApplicationImpl, String str) {
        Class<?> cls;
        if (baseApplicationImpl != null && str != null) {
            try {
                try {
                    try {
                        cls = Class.forName("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
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
                    ClassLoader orCreateClassLoader = PluginStatic.getOrCreateClassLoader(baseApplicationImpl, "group_video_plugin.apk");
                    Class<?> loadClass = orCreateClassLoader.loadClass("com.gvideo.com.tencent.av.app.GroupVideoAppInterface");
                    BasicClassTypeUtil.setClassLoader(true, orCreateClassLoader);
                    cls = loadClass;
                }
                if (cls == null) {
                    QLog.e("GroupVideoLog", 1, "*createGroupVideoAppInterface load class fail");
                    return null;
                }
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance != null && (newInstance instanceof AppInterface)) {
                    return (AppInterface) newInstance;
                }
            } catch (ClassNotFoundException e28) {
                e28.printStackTrace();
            }
        }
        return null;
    }

    public static boolean c(AppInterface appInterface, Activity activity, Intent intent, int i3) {
        if (appInterface == null || activity == null) {
            return false;
        }
        if (intent != null && intent.getIntExtra("Type", 0) == 0) {
            intent.putExtra("isInviteMode", true);
        }
        return true;
    }
}
