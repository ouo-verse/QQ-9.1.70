package com.tencent.mobileqq.auto.engine.enter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qqcircle.report.ASEngineQualityReport;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements PluginManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private DynamicPluginManager f199840a;

    /* renamed from: b, reason: collision with root package name */
    private PluginManagerUpdater f199841b;

    /* renamed from: c, reason: collision with root package name */
    private ASPluginBean f199842c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f199843d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements PluginManagerUpdater {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.auto.engine.enter.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class CallableC7426a implements Callable<File> {
            static IPatchRedirector $redirector_;

            CallableC7426a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public File call() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (File) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return new File(b.this.f199842c.getPluginMangerApkPath());
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
        public File getLatest() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (File) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new File(b.this.f199842c.getPluginMangerApkPath());
        }

        @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
        public Future<Boolean> isAvailable(File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) file);
            }
            return null;
        }

        @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
        public Future<File> update() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Future) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return b.this.f199843d.submit(new CallableC7426a());
        }

        @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
        public boolean wasUpdating() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public b(@NonNull ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
            return;
        }
        this.f199843d = ProxyExecutors.newSingleThreadExecutor();
        this.f199842c = aSPluginBean;
        d();
        c();
    }

    private void c() {
        this.f199840a = new DynamicPluginManager(this.f199841b);
    }

    private void d() {
        this.f199841b = new a();
    }

    private boolean f() {
        if (this.f199842c == null || !((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(this.f199842c.getPluginZipPath()) || !((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(this.f199842c.getPluginMangerApkPath())) {
            return false;
        }
        return true;
    }

    private void g() {
        if (this.f199842c == null) {
            return;
        }
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.f199842c.getBusinessKey()).setPluginVersion(this.f199842c.getVersionCode()).setPluginType(this.f199842c.getType()).setEventId(ASEngineQualityReport.EVENT_PLUGIN_LOAD).setRetCode(2L));
    }

    public void e(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aSEnterBean);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("pluginZipPath", this.f199842c.getPluginZipPath());
        bundle.putString("KEY_PLUGIN_PART_KEY", this.f199842c.getBusinessKey());
        Bundle bundle2 = new Bundle();
        if (aSEnterBean.getLoadAction() == 0) {
            aSEnterBean.setLoadAction(1001);
        }
        bundle2.putSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN, aSEnterBean);
        bundle2.putSerializable(ASEngineConstants.ShadowEngineKey.KEY_PLUGIN_EXTRAS_HASH_MAP, aSEnterBean.getAttrs());
        bundle.putBundle("KEY_EXTRAS", bundle2);
        enter(RFWApplication.getApplication(), aSEnterBean.getLoadAction(), bundle, null);
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManager
    public void enter(Context context, long j3, Bundle bundle, EnterCallback enterCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Long.valueOf(j3), bundle, enterCallback);
            return;
        }
        try {
            if (f()) {
                QLog.d(ASDynamicEngine.q(this.f199842c.getBusinessKey()), 1, "enter plugin:" + this.f199842c);
                this.f199840a.enter(context, j3, bundle, enterCallback);
                return;
            }
            QLog.d(ASDynamicEngine.q(this.f199842c.getBusinessKey()), 1, "enter plugin failed , files not exits");
            g();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
