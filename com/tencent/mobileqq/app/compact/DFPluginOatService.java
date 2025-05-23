package com.tencent.mobileqq.app.compact;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.e;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class DFPluginOatService extends Service {
    static IPatchRedirector $redirector_;

    public DFPluginOatService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        QLog.i("plugin_tag", 1, "start oat plugins in oat process!");
        for (String str : ((IBuildConfig) QRoute.api(IBuildConfig.class)).getDynamicFeaturePlugins()) {
            e j3 = QRoute.plugin(str).j();
            if (j3 != null && j3.d() == 4) {
                a.k().p(str);
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onCreate();
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.compact.DFPluginOatService.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DFPluginOatService.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            DFPluginOatService.this.b();
                            Runtime.getRuntime().exit(-1);
                            return;
                        } catch (Exception e16) {
                            PluginRuntime.handleCrash(e16, "sample_feature.apk", DFPluginOatService.this);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 3, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
    }
}
