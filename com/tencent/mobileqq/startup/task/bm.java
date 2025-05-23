package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteConfigBuilder;
import com.tencent.mobileqq.qroute.utils.ProcessChecker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bm;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "", "blockUntilFinish", "Lcom/tencent/mobileqq/qroute/route/g;", "d", "Lcom/tencent/mobileqq/qroute/route/g;", "mQRouteLogger", "Lcom/tencent/mobileqq/qroute/utils/c;", "e", "Lcom/tencent/mobileqq/qroute/utils/c;", "mQRouterProcessCheck", "Lcom/tencent/mobileqq/qroute/remote/a;", "f", "Lcom/tencent/mobileqq/qroute/remote/a;", "mQRouteRemoteProxy", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bm extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qroute.route.g mQRouteLogger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qroute.utils.c mQRouterProcessCheck;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qroute.remote.a mQRouteRemoteProxy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/startup/task/bm$a", "Lcom/tencent/mobileqq/qroute/route/g;", "", "isColorLevel", "", "tag", "message", "", "debug", "info", "a", "", "throwable", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.mobileqq.qroute.route.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void a(@NotNull String tag, @NotNull String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) message);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            QLog.w(tag, 1, message);
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void b(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, tag, message, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            if (throwable == null) {
                QLog.w(tag, 1, message);
            } else {
                QLog.w(tag, 1, message, throwable);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void debug(@NotNull String tag, @NotNull String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) message);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            QLog.d(tag, 4, message);
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void info(@NotNull String tag, @NotNull String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) message);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            QLog.i(tag, 1, message);
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/startup/task/bm$b", "Lcom/tencent/mobileqq/qroute/remote/a;", "", "action", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/qroute/remote/c;", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.qroute.remote.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.remote.a
        @NotNull
        public com.tencent.mobileqq.qroute.remote.c a(@NotNull String action, @NotNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.qroute.remote.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, (Object) bundle);
            }
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", action, bundle);
            com.tencent.mobileqq.qroute.remote.c cVar = new com.tencent.mobileqq.qroute.remote.c();
            cVar.f276474a = callServer.code;
            cVar.f276475b = callServer.data;
            cVar.f276476c = callServer.f396321e;
            return cVar;
        }
    }

    public bm() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mQRouteLogger = new a();
        this.mQRouterProcessCheck = new com.tencent.mobileqq.qroute.utils.c() { // from class: com.tencent.mobileqq.startup.task.bl
            @Override // com.tencent.mobileqq.qroute.utils.c
            public final boolean a(Class cls, String str, boolean z16) {
                boolean b16;
                b16 = bm.b(cls, str, z16);
                return b16;
            }
        };
        this.mQRouteRemoteProxy = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Class cls, String str, boolean z16) {
        return ProcessChecker.check(cls, str, z16);
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            QRoute.init(new QRouteConfigBuilder(MobileQQ.getProcessSuffix(BaseApplication.processName, MobileQQ.PACKAGE_NAME)).setForceCheck(false).setLogger(this.mQRouteLogger).setProcessCheck(this.mQRouterProcessCheck).setRemoteProxy(this.mQRouteRemoteProxy).setPluginFactory(new cooperation.plugin.i()).setModules(((IBuildConfig) QRoute.api(IBuildConfig.class)).getRouteModules()).create());
        }
    }
}
