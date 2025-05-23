package cooperation.plugin;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginConst;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.er;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginUpdater;
import cooperation.plugin.d;
import cooperation.plugin.f;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class g extends IPluginManager implements Handler.Callback, PluginUpdater.b, d.c, f.c {
    private PluginUpdater C;
    private cooperation.plugin.d D;
    private cooperation.plugin.a E;
    private ConcurrentHashMap<String, PluginInfo> F;
    private ConcurrentHashMap<String, OnPluginInstallListener> G;
    private ArrayList<PluginUpdater.b> H;
    private volatile boolean I;
    private boolean J;
    private ArrayList<e> K = new ArrayList<>();
    private Object L = new Object();
    private boolean M;
    private Handler N;
    private QQAppInterface P;
    private Application Q;
    private f R;

    /* renamed from: i, reason: collision with root package name */
    private cooperation.plugin.f f390283i;

    /* renamed from: m, reason: collision with root package name */
    private cooperation.plugin.h f390284m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f390286d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f390286d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f390286d.onClick(dialogInterface, i3);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private String f390287d;

        c(String str) {
            this.f390287d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == -2) {
                g.this.cancelInstall(this.f390287d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        IPluginManager.g f390289d;

        /* renamed from: e, reason: collision with root package name */
        boolean f390290e;

        /* renamed from: f, reason: collision with root package name */
        Context f390291f;

        /* renamed from: h, reason: collision with root package name */
        IPluginManager.i f390292h;

        /* renamed from: i, reason: collision with root package name */
        boolean f390293i;

        /* renamed from: m, reason: collision with root package name */
        String f390294m;

        d(IPluginManager.g gVar, boolean z16, Context context, IPluginManager.i iVar, boolean z17, String str) {
            this.f390289d = gVar;
            this.f390290e = z16;
            this.f390291f = context;
            this.f390292h = iVar;
            this.f390293i = z17;
            this.f390294m = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            if (i3 != -2) {
                if (i3 == -1) {
                    g.this.V5(1, this.f390291f, this.f390292h, this.f390289d);
                    return;
                }
                return;
            }
            int i17 = 0;
            if (!this.f390290e && this.f390293i) {
                i17 = 2;
                if (g.f6()) {
                    boolean c16 = Dex2Oat.c(this.f390294m);
                    if (c16) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "dialog needOTA :" + c16);
                    }
                    i17 = i16;
                }
            }
            g.this.V5(i17, this.f390291f, this.f390292h, this.f390289d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public SoftReference<Context> f390295a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f390296b = true;

        /* renamed from: c, reason: collision with root package name */
        public IPluginManager.i f390297c;

        /* renamed from: d, reason: collision with root package name */
        public IPluginManager.g f390298d;

        /* renamed from: e, reason: collision with root package name */
        public ProgressDialog f390299e;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class f implements INetEventHandler {

        /* renamed from: d, reason: collision with root package name */
        private Context f390300d = BaseApplicationImpl.getApplication();

        /* renamed from: e, reason: collision with root package name */
        private boolean f390301e;

        public f() {
        }

        public void a() {
            if (this.f390301e) {
                return;
            }
            this.f390301e = true;
            try {
                AppNetConnInfo.registerNetChangeReceiver(this.f390300d, this);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, e16, new Object[0]);
                }
            }
        }

        public void b() {
            if (!this.f390301e) {
                return;
            }
            this.f390301e = false;
            try {
                AppNetConnInfo.unregisterNetEventHandler(this);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, e16, new Object[0]);
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            g.this.N.sendEmptyMessage(66304);
        }
    }

    /* compiled from: P */
    /* renamed from: cooperation.plugin.g$g, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    private static class C10102g implements OnPluginInstallListener {

        /* renamed from: d, reason: collision with root package name */
        private d.c f390303d;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
            d.c cVar = this.f390303d;
            if (cVar != null) {
                cVar.j(str);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
            d.c cVar = this.f390303d;
            if (cVar != null) {
                cVar.E3(i3, i16, str);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            d.c cVar = this.f390303d;
            if (cVar != null) {
                cVar.v(false, str);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            d.c cVar = this.f390303d;
            if (cVar != null) {
                cVar.v(true, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class h extends OnPluginInstallListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        private e f390304d;

        /* renamed from: e, reason: collision with root package name */
        long f390305e = 0;

        /* renamed from: f, reason: collision with root package name */
        boolean f390306f;

        public h(e eVar) {
            this.f390304d = eVar;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) {
            ProgressDialog progressDialog;
            QLog.d("plugin_tag", 1, "onInstallBegin." + str);
            e eVar = this.f390304d;
            if (!eVar.f390296b && (progressDialog = eVar.f390299e) != null) {
                progressDialog.show();
            }
            this.f390305e = System.currentTimeMillis();
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) {
            ProgressDialog progressDialog;
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "onInstallDownloadProgress." + str + MsgSummary.STR_COLON + i3 + "/" + i16);
            }
            e eVar = this.f390304d;
            if (!eVar.f390296b && (progressDialog = eVar.f390299e) != null) {
                progressDialog.setMax(i16);
                this.f390304d.f390299e.setProgress(i3);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) {
            String str2;
            boolean z16 = true;
            QLog.d("plugin_tag", 1, "onInstallError." + str + "," + i3);
            e eVar = this.f390304d;
            if (eVar != null && eVar.f390298d != null) {
                PluginInfo queryPlugin = g.this.queryPlugin(str);
                if (queryPlugin != null && (str2 = queryPlugin.mInstalledPath) != null) {
                    eVar.f390297c.f390200f = str2;
                }
                if (!this.f390306f) {
                    IPluginManager.g gVar = eVar.f390298d;
                    if (i3 != 2) {
                        z16 = false;
                    }
                    gVar.a(z16, BaseApplication.context, eVar.f390297c);
                }
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) {
            String str2;
            ProgressDialog progressDialog;
            QLog.d("plugin_tag", 1, "onInstallFinish." + str);
            e eVar = this.f390304d;
            if (eVar != null && !eVar.f390296b && (progressDialog = eVar.f390299e) != null) {
                progressDialog.dismiss();
            }
            if (eVar != null && eVar.f390298d != null) {
                PluginInfo i3 = g.this.f390283i.i(eVar.f390297c.f390198d);
                if (i3 != null && (str2 = i3.mInstalledPath) != null) {
                    IPluginManager.i iVar = eVar.f390297c;
                    iVar.f390200f = str2;
                    iVar.b(i3);
                }
                if (!this.f390306f) {
                    Context context = eVar.f390295a.get();
                    if (context == null) {
                        context = BaseApplication.context;
                    }
                    eVar.f390298d.a(true, context, eVar.f390297c);
                    g.this.i6(eVar.f390297c);
                }
            }
            long j3 = 0;
            if (this.f390305e != 0) {
                j3 = System.currentTimeMillis() - this.f390305e;
            }
            g.this.s1(this.f390304d.f390297c.f390198d, PluginConst.STAT_EXTRACT_DOWNLOAD_COST, j3);
        }
    }

    public g(QQAppInterface qQAppInterface) {
        QLog.d("plugin_tag", 1, "init plugin manager");
        this.P = qQAppInterface;
        this.Q = qQAppInterface.getApp();
        this.N = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        Q5();
        this.C = new PluginUpdater(this.Q, this.N);
        this.f390284m = new cooperation.plugin.h(this.Q, this, this.P);
        this.C.m(this);
        this.D = new cooperation.plugin.d(this.Q, this.P);
        try {
            Application application = this.Q;
            this.f390283i = new cooperation.plugin.f(application, cooperation.plugin.d.i(application).getCanonicalPath());
        } catch (IOException unused) {
        }
        this.F = new ConcurrentHashMap<>();
        this.G = new ConcurrentHashMap<>();
        this.H = new ArrayList<>();
        this.E = cooperation.plugin.a.b(this.Q);
        f fVar = new f();
        this.R = fVar;
        fVar.a();
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        pluginCommunicationHandler.setCommunicationChannel(new l());
        pluginCommunicationHandler.register(new s05.a(qQAppInterface));
        PluginManageHandler pluginManageHandler = PluginManageHandler.getInstance();
        if (this.P.isLogin()) {
            pluginManageHandler.setPluginManagerProvider(this.P, false);
        }
        PluginInfo Z5 = Z5(FSPublishConstants.PLUGIN_NAME);
        if (Z5 != null && MobileQQ.sProcessId == 1) {
            if (Z5.mState == 4) {
                com.tencent.mobileqq.app.compact.a.k().o(FSPublishConstants.PLUGIN_NAME, this.Q);
            } else {
                installPlugin(FSPublishConstants.PLUGIN_NAME, new a());
            }
        }
        QLog.d("plugin_tag", 1, "init plugin manager end");
    }

    private void P5(Context context, IPluginManager.i iVar, IPluginManager.g gVar) {
        PluginInfo pluginInfo;
        boolean z16;
        if (iVar == null) {
            return;
        }
        boolean z17 = true;
        QLog.d("plugin_tag", 1, "checkUpdate:" + iVar.f390198d + ", " + iVar.f390202h);
        if (!g6(iVar)) {
            if (gVar != null) {
                gVar.a(false, context, iVar);
                return;
            }
            return;
        }
        String str = iVar.f390198d;
        PluginInfo g16 = this.C.g(str);
        if (g16 == null) {
            V5(0, context, iVar, gVar);
            return;
        }
        boolean p16 = this.f390283i.p(str);
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "installed :" + p16);
        }
        String str2 = null;
        if (p16) {
            pluginInfo = this.f390283i.i(str);
            boolean a16 = this.C.a(pluginInfo);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "up to day :" + a16);
            }
            if (a16) {
                if (f6() && pluginInfo.mSubType == 0 && Dex2Oat.c(pluginInfo.mFingerPrint)) {
                    if (cooperation.plugin.e.e(g16, this.Q)) {
                        QLog.d("plugin_tag", 1, "systemOTA but running " + str);
                    } else {
                        QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
                        i3 = 4;
                    }
                }
                V5(i3, context, iVar, gVar);
                return;
            }
        } else {
            pluginInfo = null;
        }
        if (cooperation.plugin.e.e(g16, this.Q) && pluginInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "plugin still running");
            }
            if (gVar != null) {
                iVar.f390200f = pluginInfo.mInstalledPath;
                iVar.b(pluginInfo);
                gVar.a(true, context, iVar);
                i6(iVar);
                return;
            }
            return;
        }
        if (g16.mUpdateType == 0 && p16) {
            z17 = false;
            z16 = false;
        } else {
            z16 = true;
            if (g16.mInstallType == 1) {
                z17 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "forceUpdate, deamonInstall\uff1a" + z16 + ", " + z17);
        }
        if (z17) {
            V5(3, context, iVar, gVar);
            return;
        }
        if (pluginInfo != null) {
            str2 = pluginInfo.mFingerPrint;
        }
        d dVar = new d(gVar, z16, context, iVar, p16, str2);
        R5(context, g16.mName, g16.mLength, dVar, dVar, z16).show();
    }

    private void Q5() {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
        }
        File dir = this.Q.getDir("plugins", 0);
        File dir2 = this.Q.getDir("NetPlugins", 0);
        try {
            FileUtils.deleteDirectory(dir.getCanonicalPath());
            FileUtils.deleteDirectory(dir2.getCanonicalPath());
        } catch (IOException unused) {
        }
    }

    private static AlertDialog R5(Context context, String str, long j3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, boolean z16) {
        String str2;
        if (z16) {
            str2 = HardCodeUtil.qqStr(R.string.p_c) + str + "\uff08" + cooperation.plugin.b.a(j3) + HardCodeUtil.qqStr(R.string.p__);
        } else {
            str2 = str + "\uff08" + cooperation.plugin.b.a(j3) + HardCodeUtil.qqStr(R.string.p_b);
        }
        return new AlertDialog.Builder(context).setMessage(str2).setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), onClickListener2).setPositiveButton(HardCodeUtil.qqStr(R.string.p_e), onClickListener).create();
    }

    private static ProgressDialog S5(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context);
        reportProgressDialog.setProgressStyle(1);
        reportProgressDialog.setIndeterminate(false);
        reportProgressDialog.setTitle(str);
        reportProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.p_d));
        reportProgressDialog.setCancelable(false);
        reportProgressDialog.setButton(-2, HardCodeUtil.qqStr(R.string.j6l), new b(onClickListener));
        return reportProgressDialog;
    }

    private void U5() {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doClose");
        }
        this.F.clear();
        synchronized (this.H) {
            this.H.clear();
        }
        this.P = null;
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V5(int i3, Context context, IPluginManager.i iVar, IPluginManager.g gVar) {
        String str;
        String str2;
        QLog.d("plugin_tag", 1, "doInstallAndLaunch. confirmCode, pluginId:" + i3 + "," + iVar.f390198d + ", " + this.M);
        if (!g6(iVar)) {
            if (gVar != null) {
                gVar.a(false, context, iVar);
                return;
            }
            return;
        }
        if (i3 == 0) {
            if (gVar != null) {
                gVar.a(false, context, iVar);
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (gVar != null) {
                PluginInfo i16 = this.f390283i.i(iVar.f390198d);
                if (i16 != null && (str2 = i16.mInstalledPath) != null) {
                    iVar.f390200f = str2;
                    iVar.b(i16);
                }
                gVar.a(true, context, iVar);
                i6(iVar);
                return;
            }
            return;
        }
        if (i3 == 4) {
            String str3 = iVar.f390198d;
            e eVar = new e();
            eVar.f390295a = new SoftReference<>(context);
            eVar.f390297c = iVar;
            eVar.f390298d = gVar;
            eVar.f390296b = true;
            T5(str3, new h(eVar));
            return;
        }
        if (i3 == 1) {
            String str4 = iVar.f390198d;
            PluginInfo g16 = this.C.g(str4);
            if (g16 == null) {
                str = "";
            } else {
                str = g16.mName;
            }
            e eVar2 = new e();
            eVar2.f390295a = new SoftReference<>(context);
            eVar2.f390297c = iVar;
            eVar2.f390298d = gVar;
            eVar2.f390296b = false;
            eVar2.f390299e = S5(context, str, new c(iVar.f390198d));
            installPlugin(str4, new h(eVar2));
            return;
        }
        if (i3 == 3) {
            String str5 = iVar.f390198d;
            e eVar3 = new e();
            eVar3.f390295a = new SoftReference<>(context);
            eVar3.f390297c = iVar;
            eVar3.f390298d = gVar;
            eVar3.f390296b = true;
            if (iVar.f390204j.getExtras() != null) {
                c6(str5, new h(eVar3), iVar.f390204j.getExtras().getBoolean("preload"), iVar.f390204j.getExtras());
            } else {
                installPlugin(str5, new h(eVar3));
            }
        }
    }

    private void W5() {
        for (PluginInfo pluginInfo : this.F.values()) {
            if (pluginInfo != null && pluginInfo.mState == 1 && pluginInfo.startDownloadNetType == 1) {
                cancelInstall(pluginInfo.mID);
            }
        }
    }

    private void X5() {
        if (NetworkState.isMobile()) {
            W5();
        } else if (NetworkState.isWifiConn() && this.M) {
            this.f390284m.h();
        }
    }

    private void Y5(String str, IPluginManager.h hVar) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doQueryPlugin: " + str + ", " + hVar);
        }
        PluginInfo Z5 = Z5(str);
        if (Z5 != null) {
            Z5 = Z5.mo210clone();
        }
        b6();
        hVar.a(str, Z5, this);
    }

    private PluginInfo Z5(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "fetchPlugin: " + str);
        }
        PluginInfo pluginInfo = this.F.get(str);
        if (pluginInfo == null) {
            PluginInfo i3 = this.f390283i.i(str);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "installed info: " + i3);
            }
            if (i3 != null && this.C.a(i3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "up to day info");
                }
                pluginInfo = i3;
            }
        } else {
            int i16 = pluginInfo.mState;
            if (i16 == -1 || i16 == 4 || i16 == -2) {
                this.F.remove(str);
            }
        }
        if (pluginInfo == null) {
            return this.C.g(str);
        }
        return pluginInfo;
    }

    private synchronized void a6() {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "getPluginList");
        }
        if (this.J) {
            return;
        }
        if (this.I) {
            return;
        }
        this.I = true;
        if (!NetworkUtil.isNetworkAvailable(this.Q)) {
            z1(false);
        } else {
            this.C.n(this.P);
        }
    }

    private boolean b6() {
        if (!this.I) {
            this.N.sendEmptyMessage(66049);
            return true;
        }
        return false;
    }

    private boolean e6(String str) {
        PluginInfo a16 = this.E.a(str);
        if (a16 == null) {
            return false;
        }
        return this.C.a(a16);
    }

    public static boolean f6() {
        boolean z16 = !((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_dex2oat.name());
        if (z16) {
            boolean d16 = Dex2Oat.d();
            if (z16 && d16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 1, "isPluginSupportDex2Oat = " + z16 + ", " + d16);
            }
        }
        return z16;
    }

    private boolean g6(IPluginManager.i iVar) {
        if (!this.M && !cooperation.plugin.a.d(iVar.f390198d) && !h6(iVar.f390198d)) {
            return false;
        }
        return true;
    }

    private boolean h6(String str) {
        PluginInfo queryPlugin = queryPlugin(str);
        boolean z16 = false;
        if (queryPlugin == null) {
            QLog.d("plugin_tag", 1, "noinfo");
            return false;
        }
        if (queryPlugin.mSubType != 1) {
            QLog.d("plugin_tag", 1, "noshadow");
            return false;
        }
        if (queryPlugin.mState == 4) {
            z16 = true;
        }
        QLog.d("plugin_tag", 1, "isShadowAndHasInstalled " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i6(IPluginManager.i iVar) {
        Message obtain = Message.obtain();
        obtain.what = 67328;
        obtain.obj = iVar;
        this.N.sendMessageDelayed(obtain, 2500L);
    }

    @Override // cooperation.plugin.IPluginManager, com.tencent.mobileqq.pluginsdk.RemotePluginManager
    /* renamed from: D5 */
    public PluginInfo queryPlugin(String str) {
        if (!PluginIdUtil.isQPluginId(str)) {
            str = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        PluginInfo Z5 = Z5(str);
        if (Z5 != null) {
            Z5 = Z5.mo210clone();
        }
        if (Z5 != null && FSPublishConstants.PLUGIN_NAME.equals(str) && Z5.mState == 4) {
            com.tencent.mobileqq.app.compact.a.k().o(str, this.Q);
        }
        b6();
        return Z5;
    }

    @Override // cooperation.plugin.d.c
    public void E3(int i3, int i16, String str) {
        PluginInfo pluginInfo = this.F.get(str);
        if (pluginInfo != null && pluginInfo.mState == 1 && i16 > 0) {
            pluginInfo.mDownloadProgress = i3 / i16;
        }
        OnPluginInstallListener onPluginInstallListener = this.G.get(str);
        if (onPluginInstallListener != null) {
            try {
                onPluginInstallListener.onInstallDownloadProgress(str, i3, i16);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.IPluginManager
    public void E5(Context context, IPluginManager.i iVar, IPluginManager.g gVar) {
        if (!g6(iVar)) {
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "not ready");
            }
            synchronized (this.L) {
                if (!this.K.isEmpty()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
                    }
                    e eVar = new e();
                    eVar.f390295a = new SoftReference<>(context);
                    eVar.f390297c = iVar;
                    eVar.f390298d = gVar;
                    this.K.add(eVar);
                    return;
                }
                synchronized (this.L) {
                    b6();
                    e eVar2 = new e();
                    eVar2.f390295a = new SoftReference<>(context);
                    eVar2.f390297c = iVar;
                    eVar2.f390298d = gVar;
                    this.K.add(eVar2);
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "set mPendingLaunchStateList");
                    }
                }
                return;
            }
        }
        P5(context, iVar, gVar);
    }

    @Override // cooperation.plugin.IPluginManager
    public void F5(PluginUpdater.b bVar) {
        synchronized (this.H) {
            this.H.remove(bVar);
        }
    }

    @Override // cooperation.plugin.IPluginManager
    public void G5() {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "setReadyToNetworking");
        }
        b6();
    }

    @Override // cooperation.plugin.IPluginManager
    public void I5() {
        this.f390283i.v();
    }

    public void T5(String str, OnPluginInstallListener onPluginInstallListener) {
        QLog.d("plugin_tag", 1, "dex2oatPlugin." + str);
        PluginInfo i3 = this.f390283i.i(str);
        if (i3 == null) {
            return;
        }
        if (cooperation.plugin.e.e(i3, this.Q)) {
            QLog.d("plugin_tag", 1, "dex2oatPlugin plugin still running " + str);
            return;
        }
        if (onPluginInstallListener != null) {
            this.G.put(str, onPluginInstallListener);
        }
        i3.mState = 5;
        this.F.put(str, i3);
        this.f390283i.d(i3, this);
    }

    @Override // cooperation.plugin.d.c
    public void Z2(String str) {
        PluginInfo pluginInfo = this.F.get(str);
        this.F.remove(str);
        pluginInfo.mState = -2;
        pluginInfo.installCode = 4;
        OnPluginInstallListener remove = this.G.remove(str);
        if (remove != null) {
            try {
                remove.onInstallError(str, 4);
            } catch (RemoteException unused) {
            }
        }
    }

    public void c6(String str, OnPluginInstallListener onPluginInstallListener, boolean z16, Bundle bundle) {
        d6(str, false, z16, onPluginInstallListener, bundle);
    }

    @Override // cooperation.plugin.IPluginManager, com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public void cancelInstall(String str) {
        if (!PluginIdUtil.isQPluginId(str)) {
            str = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        this.D.a(str);
        this.f390283i.w(str);
    }

    public void d6(String str, boolean z16, boolean z17, OnPluginInstallListener onPluginInstallListener, Bundle bundle) {
        PluginInfo pluginInfo;
        if (!PluginIdUtil.isQPluginId(str)) {
            str = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        QLog.d("plugin_tag", 1, "installPlugin." + str);
        if (z16) {
            pluginInfo = this.E.a(str);
        } else {
            PluginInfo g16 = this.C.g(str);
            if (g16 != null) {
                pluginInfo = g16.mo210clone();
            } else {
                pluginInfo = null;
            }
        }
        if (pluginInfo == null) {
            if (onPluginInstallListener != null) {
                try {
                    onPluginInstallListener.onInstallError(str, 1);
                    return;
                } catch (RemoteException unused) {
                    return;
                }
            }
            return;
        }
        if (cooperation.plugin.e.e(pluginInfo, this.Q)) {
            QLog.d("plugin_tag", 1, "plugin still running");
            if (onPluginInstallListener != null) {
                try {
                    onPluginInstallListener.onInstallError(str, 2);
                    return;
                } catch (RemoteException unused2) {
                    return;
                }
            }
            return;
        }
        PluginInfo pluginInfo2 = this.F.get(str);
        if (pluginInfo2 != null && pluginInfo2.mState == 3 && !er.c(this.Q, "KEY_DISABLE_SAVE_PLUGIN_INFO", true, false)) {
            QLog.d("plugin_tag", 1, "plugin " + str + " is installing");
            OnPluginInstallListener onPluginInstallListener2 = this.G.get(str);
            if (onPluginInstallListener != null && onPluginInstallListener2 != null) {
                try {
                    QLog.d("plugin_tag", 1, "cancel last install listener: " + str);
                    onPluginInstallListener2.onInstallError(str, 3);
                } catch (RemoteException unused3) {
                }
            }
            if (onPluginInstallListener != null) {
                try {
                    QLog.d("plugin_tag", 1, "call new install listener onInstallBegin: " + str);
                    onPluginInstallListener.onInstallBegin(str);
                } catch (RemoteException unused4) {
                }
                this.G.put(str, onPluginInstallListener);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "plugin not run");
        }
        if (onPluginInstallListener != null) {
            this.G.put(str, onPluginInstallListener);
        }
        PluginInfo i3 = this.f390283i.i(str);
        if (i3 != null && this.C.a(i3) && i3.mState == 2) {
            pluginInfo = i3;
        } else {
            pluginInfo.mState = 5;
        }
        this.F.put(str, pluginInfo);
        if (!e6(str) && !z16 && pluginInfo.mState != 2) {
            this.D.f(pluginInfo, this, z17, bundle);
        } else {
            this.f390283i.t(pluginInfo, this);
        }
    }

    @Override // cooperation.plugin.PluginUpdater.b
    public boolean h1(PluginInfo pluginInfo) {
        this.D.a(pluginInfo.mID);
        boolean w3 = this.f390283i.w(pluginInfo.mID);
        synchronized (this.H) {
            Iterator<PluginUpdater.b> it = this.H.iterator();
            while (it.hasNext()) {
                it.next().h1(pluginInfo);
            }
        }
        return w3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.J) {
            return true;
        }
        switch (message.what) {
            case 65536:
                Y5(message.getData().getString("index_for_id"), (IPluginManager.h) message.obj);
                break;
            case 65537:
                U5();
                break;
            case 66049:
                a6();
                break;
            case 66304:
                X5();
                break;
            case 67328:
                j.e((IPluginManager.i) message.obj);
                break;
        }
        return true;
    }

    @Override // cooperation.plugin.IPluginManager, com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) {
        d6(str, false, false, onPluginInstallListener, null);
    }

    @Override // cooperation.plugin.IPluginManager, com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public boolean isPlugininstalled(String str) {
        if (!PluginIdUtil.isQPluginId(str)) {
            str = PluginIdUtil.convertQShadowId2QPluginId(str);
        }
        PluginInfo queryPlugin = queryPlugin(str);
        if (queryPlugin == null || queryPlugin.mState != 4 || queryPlugin.mInstalledPath == null || !new File(queryPlugin.mInstalledPath).exists()) {
            return false;
        }
        return true;
    }

    @Override // cooperation.plugin.IPluginManager, com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public boolean isReady() {
        return this.M;
    }

    @Override // cooperation.plugin.d.c
    public void j(String str) {
        PluginInfo pluginInfo = this.F.get(str);
        OnPluginInstallListener onPluginInstallListener = this.G.get(str);
        if (pluginInfo != null) {
            pluginInfo.mState = 1;
            pluginInfo.startDownloadNetType = NetworkState.getNetworkType();
            pluginInfo.installCode = 0;
            if (!(onPluginInstallListener instanceof C10102g)) {
                pluginInfo.downloadDuration = System.currentTimeMillis();
            }
        }
        if (onPluginInstallListener != null) {
            try {
                onPluginInstallListener.onInstallBegin(str);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.f.c
    public void j2(String str) {
        PluginInfo pluginInfo = this.F.get(str);
        this.F.remove(str);
        if (pluginInfo != null) {
            pluginInfo.mState = -2;
            pluginInfo.installCode = 4;
        }
        OnPluginInstallListener remove = this.G.remove(str);
        if (remove != null) {
            try {
                remove.onInstallError(str, 6);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.IPluginManager
    public void m5(PluginUpdater.b bVar) {
        if (bVar != null) {
            synchronized (this.H) {
                this.H.add(bVar);
            }
        }
    }

    @Override // cooperation.plugin.IPluginManager
    public long n5() {
        return this.f390283i.a();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.N.obtainMessage(65537).sendToTarget();
        this.R.b();
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        pluginCommunicationHandler.setCommunicationChannel(null);
        pluginCommunicationHandler.unregister("common.get_qq_app_interface_data");
        synchronized (this.L) {
            this.K.clear();
        }
    }

    @Override // cooperation.plugin.f.c
    public void p4(boolean z16, String str) {
        int i3;
        OnPluginInstallListener remove = this.G.remove(str);
        PluginInfo pluginInfo = this.F.get(str);
        this.F.remove(str);
        if (pluginInfo != null) {
            if (z16) {
                i3 = 4;
            } else {
                i3 = -2;
            }
            pluginInfo.mState = i3;
        }
        if (remove != null) {
            try {
                if (z16) {
                    remove.onInstallFinish(str);
                } else {
                    remove.onInstallError(str, 7);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.f.d
    public void s1(String str, String str2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, " recordPluginStartupTime " + str + ", key = " + str2 + ", span = " + j3);
        }
        PluginInfo i3 = this.f390283i.i(str);
        if (i3 != null) {
            if (PluginConst.STAT_EXTRACT_APK_COST.equals(str2)) {
                i3.costApk = j3;
                return;
            }
            if (PluginConst.STAT_EXTRACT_DEX2OAT_COST.equals(str2)) {
                i3.costDex2Oat = j3;
            } else if (PluginConst.STAT_EXTRACT_DOWNLOAD_COST.equals(str2)) {
                i3.costDownload = j3;
            } else if (PluginConst.STAT_EXTRACT_LIB_COST.equals(str2)) {
                i3.costLib = j3;
            }
        }
    }

    @Override // cooperation.plugin.f.c
    public void u0(String str) {
        PluginInfo pluginInfo = this.F.get(str);
        if (pluginInfo != null) {
            pluginInfo.mState = 3;
        }
    }

    @Override // cooperation.plugin.d.c
    public void v(boolean z16, String str) {
        QLog.d("plugin_tag", 1, "onDownloadFinish:" + z16);
        PluginInfo pluginInfo = this.F.get(str);
        if (pluginInfo != null) {
            if (pluginInfo.downloadDuration != 0 && !(this.G.get(str) instanceof C10102g)) {
                pluginInfo.downloadDuration = System.currentTimeMillis() - pluginInfo.downloadDuration;
            }
            try {
                if (z16) {
                    pluginInfo.mState = 2;
                    pluginInfo.mDownloadProgress = 1.0f;
                    if (PluginUpdater.h(this.Q) && this.C.d(str) != null) {
                        PluginInfo d16 = this.C.d(str);
                        File file = new File(cooperation.plugin.d.i(this.Q), pluginInfo.mID);
                        d16.mLength = file.length();
                        d16.mMD5 = PluginStatic.encodeFile(file.getAbsolutePath());
                        this.C.l(d16);
                    }
                    if (this.G.get(str) instanceof C10102g) {
                        C10102g c10102g = (C10102g) this.G.remove(str);
                        if (c10102g != null) {
                            c10102g.onInstallFinish(str);
                        }
                        this.F.remove(str);
                        this.f390283i.r(pluginInfo);
                        return;
                    }
                    if (!er.c(this.Q, "KEY_DISABLE_SAVE_PLUGIN_INFO", true, false)) {
                        QLog.d("plugin_tag", 1, "download finish, save plugin info, state: " + pluginInfo.mState);
                        this.f390283i.r(pluginInfo);
                    }
                    this.f390283i.t(pluginInfo, this);
                    return;
                }
                pluginInfo.mState = -2;
                this.F.remove(str);
                OnPluginInstallListener remove = this.G.remove(str);
                pluginInfo.installCode = 5;
                if (remove != null) {
                    remove.onInstallError(str, 5);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.d.c
    public void x(String str) {
        PluginInfo pluginInfo = this.F.get(str);
        this.F.remove(str);
        if (pluginInfo != null && pluginInfo.mState == 1) {
            pluginInfo.mState = -1;
            pluginInfo.installCode = 3;
            pluginInfo.downloadDuration = 0L;
        }
        OnPluginInstallListener remove = this.G.remove(str);
        if (remove != null) {
            try {
                remove.onInstallError(str, 3);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // cooperation.plugin.IPluginManager
    public void x5(String str) {
        installPlugin(str, null);
    }

    @Override // cooperation.plugin.IPluginManager
    public void y5(String str, OnPluginInstallListener onPluginInstallListener, boolean z16) {
        d6(str, false, z16, onPluginInstallListener, null);
    }

    @Override // cooperation.plugin.PluginUpdater.b
    public void z1(boolean z16) {
        this.M = true;
        if (!z16) {
            this.I = false;
        } else {
            this.f390284m.g();
        }
        synchronized (this.L) {
            if (!this.K.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
                }
                Iterator<e> it = this.K.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    P5(BaseApplication.context, next.f390297c, next.f390298d);
                }
                this.K.clear();
            } else if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
            }
        }
        synchronized (this.H) {
            Iterator<PluginUpdater.b> it5 = this.H.iterator();
            while (it5.hasNext()) {
                it5.next().z1(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends OnPluginInstallListener.Stub {
        a() {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            com.tencent.mobileqq.app.compact.a.k().o(FSPublishConstants.PLUGIN_NAME, g.this.Q);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
    public void setListener(RemotePluginManager remotePluginManager) throws RemoteException {
    }
}
