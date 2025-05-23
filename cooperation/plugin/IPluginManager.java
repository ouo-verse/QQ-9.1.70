package cooperation.plugin;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;
import cooperation.peak.PeakConstants;
import cooperation.plugin.PluginUpdater;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* loaded from: classes28.dex */
public abstract class IPluginManager extends RemotePluginManager.Stub implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private static PluginManagerHelper.OnPluginManagerLoadedListener f390174d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile PluginManagerClient f390175e;

    /* renamed from: f, reason: collision with root package name */
    private static ConcurrentLinkedQueue<j> f390176f = new ConcurrentLinkedQueue<>();

    /* renamed from: h, reason: collision with root package name */
    public static long f390177h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f390187a;

        /* renamed from: cooperation.plugin.IPluginManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        class C10101a implements nk2.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f390188a;

            C10101a(i iVar) {
                this.f390188a = iVar;
            }

            @Override // nk2.a
            public void a(boolean z16, QShadowLoadInfo qShadowLoadInfo) {
                cooperation.plugin.j.f(this.f390188a, qShadowLoadInfo, z16);
                f fVar = a.this.f390187a;
                if (fVar != null) {
                    fVar.a(z16);
                }
            }
        }

        a(f fVar) {
            this.f390187a = fVar;
        }

        @Override // cooperation.plugin.IPluginManager.g
        public void a(boolean z16, Context context, i iVar) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + z16);
            }
            if (z16) {
                int i3 = iVar.f390196b;
                if (i3 == 1) {
                    QShadow.getInstance().startActivity(iVar.f390199e, iVar.f390202h, iVar.f390204j.getExtras(), new C10101a(iVar));
                    return;
                }
                if (i3 == 2) {
                    IPluginManager.v5(context, iVar, this.f390187a);
                    return;
                }
                cooperation.plugin.j.d(iVar, true);
                IPluginManager.u5(context, iVar);
                f fVar = this.f390187a;
                if (fVar != null) {
                    fVar.a(true);
                    return;
                }
                return;
            }
            f fVar2 = this.f390187a;
            if (fVar2 != null) {
                fVar2.a(false);
            }
            cooperation.plugin.j.d(iVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class b implements PluginManagerHelper.OnPluginManagerLoadedListener {
        b() {
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener
        public void onPluginManagerLoaded(PluginManagerClient pluginManagerClient) {
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
            }
            IPluginManager.f390175e = pluginManagerClient;
            IPluginManager.f390174d = null;
            while (!IPluginManager.f390176f.isEmpty()) {
                j jVar = (j) IPluginManager.f390176f.poll();
                if (jVar != null) {
                    IPluginManager.p5(jVar.f390218a, jVar.f390219b, jVar.f390220c);
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    class d implements g {
        d() {
        }

        @Override // cooperation.plugin.IPluginManager.g
        public void a(boolean z16, Context context, i iVar) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + z16);
            }
            if (z16) {
                if (iVar.f390196b == 2) {
                    IPluginManager.q5(context, iVar);
                    return;
                } else {
                    IPluginManager.s5(context, iVar);
                    return;
                }
            }
            cooperation.plugin.j.d(iVar, false);
        }
    }

    /* loaded from: classes28.dex */
    class e implements g {

        /* loaded from: classes28.dex */
        class a implements nk2.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f390193a;

            a(i iVar) {
                this.f390193a = iVar;
            }

            @Override // nk2.a
            public void a(boolean z16, QShadowLoadInfo qShadowLoadInfo) {
                cooperation.plugin.j.f(this.f390193a, qShadowLoadInfo, z16);
            }
        }

        e() {
        }

        @Override // cooperation.plugin.IPluginManager.g
        public void a(boolean z16, Context context, i iVar) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + z16);
            }
            if (z16) {
                int i3 = iVar.f390196b;
                if (i3 == 1) {
                    QShadow.getInstance().startService(iVar.f390199e, iVar.f390202h, iVar.f390204j.getExtras(), new a(iVar));
                    return;
                } else if (i3 == 2) {
                    IPluginManager.r5(context, iVar);
                    return;
                } else {
                    IPluginManager.t5(context, iVar);
                    return;
                }
            }
            cooperation.plugin.j.d(iVar, false);
        }
    }

    /* loaded from: classes28.dex */
    public interface f {
        void a(boolean z16);
    }

    /* loaded from: classes28.dex */
    public interface g {
        void a(boolean z16, Context context, i iVar);
    }

    /* loaded from: classes28.dex */
    public interface h {
        void a(String str, PluginInfo pluginInfo, IPluginManager iPluginManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        Context f390218a;

        /* renamed from: b, reason: collision with root package name */
        i f390219b;

        /* renamed from: c, reason: collision with root package name */
        g f390220c;

        j(Context context, i iVar, g gVar) {
            this.f390218a = context;
            this.f390219b = iVar;
            this.f390220c = gVar;
        }
    }

    public static void A5(Context context, i iVar) {
        if (iVar == null) {
            QLog.e("plugin_tag", 1, "launchPluginService, pp is null");
            return;
        }
        if (iVar.f390196b == 1) {
            String str = iVar.f390198d;
            iVar.f390199e = str;
            iVar.f390198d = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        iVar.f390216v = 1;
        e eVar = new e();
        iVar.f390204j.putExtra(PluginConst.STAT_LAUNCH_TIME_START, System.currentTimeMillis());
        com.tencent.mobileqq.hitrate.b bVar = iVar.f390207m;
        if (bVar != null) {
            bVar.a();
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            w5(context, iVar, eVar);
        } else {
            ((IPluginManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.MGR_PLUGIN)).E5(context, iVar, eVar);
        }
    }

    public static void B5(Context context, i iVar) {
        C5(context, iVar, null);
    }

    public static void C5(Context context, i iVar, f fVar) {
        if (iVar == null) {
            QLog.e("plugin_tag", 1, "openActivityForResult, pp is null");
            return;
        }
        if (iVar.f390196b == 1) {
            String str = iVar.f390198d;
            iVar.f390199e = str;
            iVar.f390198d = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        QLog.d("plugin_tag", 1, "openActivityForResult." + iVar.f390198d);
        if (iVar.f390211q != null) {
            Toast makeText = Toast.makeText(BaseApplication.getContext(), iVar.f390211q, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        iVar.f390216v = 0;
        iVar.f390204j.putExtra(PluginConst.STAT_LAUNCH_TIME_START, System.currentTimeMillis());
        a aVar = new a(fVar);
        if ((context instanceof Activity) && iVar.f390206l != null && !((Activity) context).isFinishing()) {
            new SplashDialogWrapper(context, iVar.f390206l, iVar.f390201g, iVar.f390198d, iVar.f390210p, iVar.f390212r).show();
        }
        com.tencent.mobileqq.hitrate.b bVar = iVar.f390207m;
        if (bVar != null) {
            if (TextUtils.equals(bVar.f236847f, iVar.f390198d)) {
                iVar.f390207m.d();
                iVar.f390207m.b();
            }
        } else {
            com.tencent.mobileqq.hitrate.a.g(iVar.f390198d);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            w5(context, iVar, aVar);
        } else {
            ((IPluginManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.MGR_PLUGIN)).E5(context, iVar, aVar);
        }
    }

    public static void H5(String str, String str2) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.contains(HardCodeUtil.qqStr(R.string.f172117nh2)) && !lowerCase.contains("space")) {
                QQToast.makeText(BaseApplication.getContext(), str2 + HardCodeUtil.qqStr(R.string.nh5), 0).show();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f172119nh4) + str2 + HardCodeUtil.qqStr(R.string.f172118nh3), 0).show();
        }
    }

    static void J5(List<RemoteCommand> list) {
        if (list != null && !list.isEmpty()) {
            PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                RemoteCommand remoteCommand = list.get(i3);
                if (remoteCommand != null && !pluginCommunicationHandler.containsCmd(remoteCommand.getCmd())) {
                    pluginCommunicationHandler.register(list.get(i3));
                }
            }
        }
    }

    public static IPluginManager o5(QQAppInterface qQAppInterface) {
        return new cooperation.plugin.g(qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p5(Context context, i iVar, g gVar) {
        if (f390175e == null) {
            gVar.a(false, context, iVar);
            return;
        }
        PluginBaseInfo queryPlugin = f390175e.queryPlugin(iVar.f390198d);
        if (queryPlugin != null && queryPlugin.mState == 4) {
            if (gVar != null) {
                iVar.f390200f = queryPlugin.mInstalledPath;
                iVar.b(queryPlugin);
                gVar.a(true, context, iVar);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("plugin_tag", 4, "doHandleOtherProcess: " + f390175e.useful());
            QLog.i("plugin_tag", 4, "doHandleOtherProcess isPluginInstalled false");
        }
        f390175e.installPlugin(iVar.f390198d, new c(gVar, iVar, context));
    }

    static void q5(final Context context, final i iVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.plugin.IPluginManager.7
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.app.compact.a.k().o(i.this.f390198d, (Application) context.getApplicationContext());
                context.sendBroadcast(i.this.f390204j);
                cooperation.plugin.j.d(i.this, true);
                i.this.a();
            }
        }, 16, null, false);
    }

    static void r5(final Context context, final i iVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.plugin.IPluginManager.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.app.compact.a.k().o(i.this.f390198d, (Application) context.getApplicationContext());
                try {
                    i iVar2 = i.this;
                    ServiceConnection serviceConnection = iVar2.f390209o;
                    if (serviceConnection != null) {
                        context.bindService(iVar2.f390204j, serviceConnection, 1);
                    } else {
                        context.startService(iVar2.f390204j);
                    }
                    cooperation.plugin.j.d(i.this, true);
                } catch (Exception e16) {
                    QLog.e("plugin_tag", 1, "launch df plugin service error! ", e16);
                    cooperation.plugin.j.d(i.this, false);
                }
                i.this.a();
            }
        }, 16, null, false);
    }

    static void s5(Context context, i iVar) {
        J5(iVar.f390215u);
        cooperation.plugin.j.d(iVar, true);
        iVar.a();
        if (TextUtils.isEmpty(iVar.f390204j.getStringExtra("uin")) && !TextUtils.isEmpty(iVar.f390197c)) {
            iVar.f390204j.putExtra("uin", iVar.f390197c);
            iVar.f390204j.putExtra("qzone_uin", iVar.f390197c);
        }
        iVar.f390204j.putExtra(PluginStatic.PARAM_UIN, iVar.f390197c);
        iVar.f390204j.putExtra("clsUploader", com.tencent.mobileqq.statistics.j.class.getName());
        PluginProxyBroadcastReceiver.sendBroadcastReceiver(context, iVar.f390201g, iVar.f390198d, iVar.f390200f, iVar.f390202h, iVar.f390204j);
    }

    static void t5(final Context context, final i iVar) {
        J5(iVar.f390215u);
        cooperation.plugin.j.d(iVar, true);
        iVar.a();
        if (TextUtils.isEmpty(iVar.f390204j.getStringExtra("uin")) && !TextUtils.isEmpty(iVar.f390197c)) {
            iVar.f390204j.putExtra("uin", iVar.f390197c);
            iVar.f390204j.putExtra("qzone_uin", iVar.f390197c);
        }
        iVar.f390204j.putExtra(PluginStatic.PARAM_UIN, iVar.f390197c);
        iVar.f390204j.putExtra("clsUploader", com.tencent.mobileqq.statistics.j.class.getName());
        ServiceConnection serviceConnection = iVar.f390209o;
        if (serviceConnection != null) {
            PluginProxyService.bindService(context, iVar.f390201g, iVar.f390198d, iVar.f390200f, iVar.f390202h, iVar.f390204j, serviceConnection);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.plugin.IPluginManager.9
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    i iVar2 = iVar;
                    PluginProxyService.openService(context2, iVar2.f390201g, iVar2.f390198d, iVar2.f390200f, iVar2.f390202h, iVar2.f390204j);
                }
            }, 16, null, false);
        }
    }

    static void u5(Context context, i iVar) {
        int i3;
        if (context == null) {
            return;
        }
        J5(iVar.f390215u);
        iVar.f390204j.setClass(context, iVar.f390203i);
        if (TextUtils.isEmpty(iVar.f390204j.getStringExtra("uin"))) {
            iVar.f390204j.putExtra("uin", iVar.f390197c);
            iVar.f390204j.putExtra("qzone_uin", iVar.f390197c);
        }
        iVar.f390204j.putExtra(PluginStatic.PARAM_UIN, iVar.f390197c);
        iVar.f390204j.putExtra("clsUploader", com.tencent.mobileqq.statistics.j.class.getName());
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doOpenActivityForResult do start activity");
        }
        iVar.a();
        boolean z16 = context instanceof Activity;
        if (z16) {
            PluginProxyActivity.openActivityForResult((Activity) context, iVar.f390201g, iVar.f390198d, iVar.f390200f, iVar.f390202h, iVar.f390204j, iVar.f390205k);
        } else {
            PluginProxyActivity.openActivity(context, iVar.f390201g, iVar.f390198d, iVar.f390200f, iVar.f390202h, iVar.f390204j);
        }
        if (z16) {
            if (iVar.f390204j.getBooleanExtra(PeakConstants.EXTRA_IS_FROM_P2V_EDIT, false)) {
                ((Activity) context).overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
                return;
            }
            int i16 = iVar.f390213s;
            if (i16 > 0 && (i3 = iVar.f390214t) > 0) {
                ((Activity) context).overridePendingTransition(i16, i3);
            }
        }
    }

    static void v5(final Context context, final i iVar, final f fVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.plugin.IPluginManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.app.compact.a.k().o(i.this.f390198d, (Application) context.getApplicationContext());
                i.this.f390204j.putExtra("extra_is_plugin", true);
                i iVar2 = i.this;
                iVar2.f390204j.putExtra("extra_plugin_id", iVar2.f390198d);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.plugin.IPluginManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            Context context2 = context;
                            if (context2 instanceof Activity) {
                                i iVar3 = i.this;
                                ((Activity) context2).startActivityForResult(iVar3.f390204j, iVar3.f390205k);
                            } else {
                                context2.startActivity(i.this.f390204j);
                            }
                            f fVar2 = fVar;
                            if (fVar2 != null) {
                                fVar2.a(true);
                            }
                            cooperation.plugin.j.d(i.this, true);
                        } catch (Exception e16) {
                            QLog.e("plugin_tag", 1, "launch df plugin service error! ", e16);
                            cooperation.plugin.j.d(i.this, false);
                            f fVar3 = fVar;
                            if (fVar3 != null) {
                                fVar3.a(false);
                            }
                        }
                        i.this.a();
                    }
                });
            }
        }, 16, null, false);
    }

    private static void w5(Context context, i iVar, g gVar) {
        if (f390174d != null && System.currentTimeMillis() - f390177h < 500) {
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "handleOtherProcessWait");
            }
            f390177h = System.currentTimeMillis();
            f390176f.add(new j(context, iVar, gVar));
            return;
        }
        f390177h = 0L;
        if (f390175e != null && f390175e.useful()) {
            p5(context, iVar, gVar);
            return;
        }
        f390176f.add(new j(context, iVar, gVar));
        if (f390174d == null) {
            f390174d = new b();
        }
        PluginManagerHelper.getPluginInterface(context, f390174d);
    }

    public static void z5(Context context, i iVar) {
        if (iVar == null) {
            QLog.e("plugin_tag", 1, "launchPluginBroadcast, pp is null");
            return;
        }
        if (iVar.f390196b == 1) {
            String str = iVar.f390198d;
            iVar.f390199e = str;
            iVar.f390198d = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        iVar.f390216v = 2;
        d dVar = new d();
        iVar.f390204j.putExtra(PluginConst.STAT_LAUNCH_TIME_START, System.currentTimeMillis());
        com.tencent.mobileqq.hitrate.b bVar = iVar.f390207m;
        if (bVar != null) {
            bVar.a();
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            w5(context, iVar, dVar);
        } else {
            ((IPluginManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.MGR_PLUGIN)).E5(context, iVar, dVar);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    /* renamed from: D5, reason: merged with bridge method [inline-methods] */
    public abstract PluginInfo queryPlugin(String str);

    public abstract void E5(Context context, i iVar, g gVar);

    public abstract void F5(PluginUpdater.b bVar);

    public abstract void G5();

    public abstract void I5();

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public abstract void cancelInstall(String str);

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public abstract void installPlugin(String str, OnPluginInstallListener onPluginInstallListener);

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public abstract boolean isPlugininstalled(String str);

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public abstract boolean isReady();

    public abstract void m5(PluginUpdater.b bVar);

    public abstract long n5();

    public abstract void x5(String str);

    public abstract void y5(String str, OnPluginInstallListener onPluginInstallListener, boolean z16);

    /* loaded from: classes28.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        int f390195a;

        /* renamed from: b, reason: collision with root package name */
        int f390196b;

        /* renamed from: c, reason: collision with root package name */
        public String f390197c;

        /* renamed from: d, reason: collision with root package name */
        public String f390198d;

        /* renamed from: e, reason: collision with root package name */
        String f390199e;

        /* renamed from: f, reason: collision with root package name */
        String f390200f;

        /* renamed from: g, reason: collision with root package name */
        public String f390201g;

        /* renamed from: h, reason: collision with root package name */
        public String f390202h;

        /* renamed from: i, reason: collision with root package name */
        public Class<? extends Activity> f390203i;

        /* renamed from: j, reason: collision with root package name */
        public Intent f390204j;

        /* renamed from: k, reason: collision with root package name */
        public int f390205k;

        /* renamed from: l, reason: collision with root package name */
        public Dialog f390206l;

        /* renamed from: m, reason: collision with root package name */
        public com.tencent.mobileqq.hitrate.b f390207m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f390208n;

        /* renamed from: o, reason: collision with root package name */
        public ServiceConnection f390209o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f390210p;

        /* renamed from: q, reason: collision with root package name */
        public String f390211q;

        /* renamed from: r, reason: collision with root package name */
        public int f390212r;

        /* renamed from: s, reason: collision with root package name */
        public int f390213s;

        /* renamed from: t, reason: collision with root package name */
        public int f390214t;

        /* renamed from: u, reason: collision with root package name */
        public List<RemoteCommand> f390215u;

        /* renamed from: v, reason: collision with root package name */
        public int f390216v;

        /* renamed from: w, reason: collision with root package name */
        PluginBaseInfo f390217w;

        public i(int i3) {
            this.f390195a = 0;
            this.f390196b = 0;
            this.f390205k = -1;
            this.f390208n = false;
            this.f390210p = true;
            this.f390212r = 10000;
            this.f390213s = 0;
            this.f390214t = 0;
            this.f390215u = new ArrayList();
            this.f390195a = i3;
        }

        public void a() {
            if (this.f390217w != null) {
                QLog.d("plugin_tag", 1, "pluginStartupAttachInfo dex2Oat " + this.f390217w.costDex2Oat + "lib " + this.f390217w.costLib + "download " + this.f390217w.costDownload + "apk " + this.f390217w.costApk);
                PluginBaseInfo pluginBaseInfo = this.f390217w;
                if (pluginBaseInfo.costDex2Oat != 0 || pluginBaseInfo.costLib != 0 || pluginBaseInfo.costDownload != 0 || pluginBaseInfo.costApk != 0) {
                    pluginBaseInfo.costDex2Oat = 0L;
                    pluginBaseInfo.costLib = 0L;
                    pluginBaseInfo.costDownload = 0L;
                    pluginBaseInfo.costApk = 0L;
                }
            }
            PluginBaseInfo pluginBaseInfo2 = this.f390217w;
            if (pluginBaseInfo2 != null) {
                pluginBaseInfo2.downloadDuration = 0L;
                pluginBaseInfo2.costDex2Oat = 0L;
                pluginBaseInfo2.installCode = 0;
            }
        }

        public void b(PluginBaseInfo pluginBaseInfo) {
            this.f390217w = pluginBaseInfo;
        }

        public i(int i3, int i16) {
            this.f390195a = 0;
            this.f390196b = 0;
            this.f390205k = -1;
            this.f390208n = false;
            this.f390210p = true;
            this.f390212r = 10000;
            this.f390213s = 0;
            this.f390214t = 0;
            this.f390215u = new ArrayList();
            this.f390195a = i3;
            this.f390196b = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class c extends OnPluginInstallListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f390190d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f390191e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f390192f;

        c(g gVar, i iVar, Context context) {
            this.f390190d = gVar;
            this.f390191e = iVar;
            this.f390192f = context;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            if (QLog.isDevelopLevel()) {
                QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
            }
            g gVar = this.f390190d;
            if (gVar != null) {
                gVar.a(false, this.f390192f, this.f390191e);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            if (QLog.isDevelopLevel()) {
                QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
            }
            if (this.f390190d != null) {
                PluginBaseInfo queryPlugin = IPluginManager.f390175e.queryPlugin(this.f390191e.f390198d);
                if (queryPlugin != null) {
                    i iVar = this.f390191e;
                    iVar.f390200f = queryPlugin.mInstalledPath;
                    iVar.b(queryPlugin);
                }
                this.f390190d.a(true, this.f390192f, this.f390191e);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }
}
