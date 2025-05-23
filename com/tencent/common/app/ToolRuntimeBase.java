package com.tencent.common.app;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ToolRuntimeBase extends PluginRuntime {
    static IPatchRedirector $redirector_ = null;
    static final int ACTION_CLEAR_CACHE = 2;
    static final int ACTION_DEFAULT = 0;
    static final int ACTION_KILL_PROCESS = 3;
    static final int ACTION_RELEASE_LARGE_CACHE = 1;
    static final String TAG = "ToolRuntimeBase";
    ComponentCallbacks componentCallbacks;
    long mLastTrimTime;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ComponentCallbacks2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ToolRuntimeBase.this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                ToolRuntimeBase.this.onTrimMemory(i3);
            }
        }
    }

    public ToolRuntimeBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    void clearCache(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.mLastTrimTime) < 2000) {
            return;
        }
        this.mLastTrimTime = currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearCache, " + i3);
        }
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                ImageCacheHelper.f98636a.e();
                return;
            }
            return;
        }
        ImageCacheHelper.f98636a.d(Priority.Low);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    @TargetApi(14)
    public void exitToolProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QIPCClientHelper.getInstance().disconnect();
        try {
            if (this.componentCallbacks != null) {
                getApplication().unregisterComponentCallbacks(this.componentCallbacks);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", th5);
            }
        }
        super.exitToolProc();
    }

    @TargetApi(14)
    public void onTrimMemory(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onTrimMemory, " + i3);
        }
        if (i3 != 5) {
            if (i3 != 10) {
                if (i3 != 15) {
                    if (i3 != 20) {
                        if (i3 != 40 && i3 != 60) {
                            if (i3 == 80) {
                                clearCache(3);
                                return;
                            }
                            return;
                        }
                        clearCache(2);
                        return;
                    }
                    clearCache(1);
                    return;
                }
                clearCache(0);
                return;
            }
            clearCache(0);
            return;
        }
        clearCache(0);
    }

    @Override // mqq.app.AppRuntime
    @TargetApi(14)
    public void setAsToolRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.setAsToolRuntime();
        try {
            if (this.componentCallbacks == null) {
                this.componentCallbacks = new a();
                BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.componentCallbacks);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", th5);
            }
        }
    }
}
