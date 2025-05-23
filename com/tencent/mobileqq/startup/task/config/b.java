package com.tencent.mobileqq.startup.task.config;

import android.util.Log;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.startup.task.KernelInitTask;
import com.tencent.mobileqq.startup.task.MsgObserverTask;
import com.tencent.mobileqq.startup.task.VersionUpdateTask;
import com.tencent.mobileqq.startup.task.aa;
import com.tencent.mobileqq.startup.task.ah;
import com.tencent.mobileqq.startup.task.ai;
import com.tencent.mobileqq.startup.task.aj;
import com.tencent.mobileqq.startup.task.ao;
import com.tencent.mobileqq.startup.task.ap;
import com.tencent.mobileqq.startup.task.aq;
import com.tencent.mobileqq.startup.task.ar;
import com.tencent.mobileqq.startup.task.au;
import com.tencent.mobileqq.startup.task.av;
import com.tencent.mobileqq.startup.task.aw;
import com.tencent.mobileqq.startup.task.ax;
import com.tencent.mobileqq.startup.task.bb;
import com.tencent.mobileqq.startup.task.bc;
import com.tencent.mobileqq.startup.task.bd;
import com.tencent.mobileqq.startup.task.be;
import com.tencent.mobileqq.startup.task.bf;
import com.tencent.mobileqq.startup.task.bg;
import com.tencent.mobileqq.startup.task.bh;
import com.tencent.mobileqq.startup.task.bi;
import com.tencent.mobileqq.startup.task.bk;
import com.tencent.mobileqq.startup.task.bm;
import com.tencent.mobileqq.startup.task.bn;
import com.tencent.mobileqq.startup.task.bo;
import com.tencent.mobileqq.startup.task.bp;
import com.tencent.mobileqq.startup.task.bq;
import com.tencent.mobileqq.startup.task.br;
import com.tencent.mobileqq.startup.task.bt;
import com.tencent.mobileqq.startup.task.bu;
import com.tencent.mobileqq.startup.task.bv;
import com.tencent.mobileqq.startup.task.bw;
import com.tencent.mobileqq.startup.task.bx;
import com.tencent.mobileqq.startup.task.ca;
import com.tencent.mobileqq.startup.task.cb;
import com.tencent.mobileqq.startup.task.cc;
import com.tencent.mobileqq.startup.task.ce;
import com.tencent.mobileqq.startup.task.cf;
import com.tencent.mobileqq.startup.task.ch;
import com.tencent.mobileqq.startup.task.ci;
import com.tencent.mobileqq.startup.task.cj;
import com.tencent.mobileqq.startup.task.ck;
import com.tencent.mobileqq.startup.task.cm;
import com.tencent.mobileqq.startup.task.cn;
import com.tencent.mobileqq.startup.task.cp;
import com.tencent.mobileqq.startup.task.cr;
import com.tencent.mobileqq.startup.task.cs;
import com.tencent.mobileqq.startup.task.ct;
import com.tencent.mobileqq.startup.task.n;
import com.tencent.mobileqq.startup.task.o;
import com.tencent.mobileqq.startup.task.p;
import com.tencent.mobileqq.startup.task.q;
import com.tencent.mobileqq.startup.task.r;
import com.tencent.mobileqq.startup.task.s;
import com.tencent.mobileqq.startup.task.u;
import com.tencent.mobileqq.startup.task.w;
import com.tencent.mobileqq.startup.task.x;
import com.tencent.mobileqq.startup.task.y;
import com.tencent.mobileqq.startup.task.z;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016RB\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`\b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/b;", "Lcom/tencent/qqnt/startup/task/d;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/qqnt/startup/task/NtTask;", "createTask", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getSTaskClassMap$annotations", "()V", "sTaskClassMap", "<init>", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements com.tencent.qqnt.startup.task.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289850a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Startup/Inject_ColdStartupTaskFactory.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<NtTask>> sTaskClassMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f289850a = new b();
        HashMap<String, Class<NtTask>> hashMap = new HashMap<>();
        sTaskClassMap = hashMap;
        hashMap.put("WTRefreshNTSignTask", cn.class);
        hashMap.put("WTUpgradeTask", cr.class);
        hashMap.put("WTSigCheckTask", cp.class);
        hashMap.put("GuidLoadTask", aa.class);
        hashMap.put("AIOCorePreLoadTask", com.tencent.mobileqq.startup.task.a.class);
        hashMap.put("FreesiaBgFetchTask", w.class);
        hashMap.put("MMKVMonitorTask", aq.class);
        hashMap.put("RegProxyEndTask", bu.class);
        hashMap.put("MainPageShowEndTask", ar.class);
        hashMap.put("QimeiInitTask", bo.class);
        hashMap.put("LoadFeKitSoTask", aj.class);
        hashMap.put("MiniBoxInitTask", ax.class);
        hashMap.put("ApplicationCreateEndTask", com.tencent.mobileqq.startup.task.g.class);
        hashMap.put("LoadAllDtSampleConfigTask", ah.class);
        hashMap.put("UpdateFriendLocalInitTask", ck.class);
        hashMap.put("MSFAccountChangeRegisterTask", MSFAccountChangeRegisterTask.class);
        hashMap.put("BeaconSDKInitTask", com.tencent.mobileqq.startup.task.k.class);
        hashMap.put("ArgusPreloadTask", com.tencent.mobileqq.startup.task.h.class);
        hashMap.put("CentaurInitTask", o.class);
        hashMap.put("SafeO3InitTask", bw.class);
        hashMap.put("SafeModeTask", bv.class);
        hashMap.put("GroupVideoInitTask", x.class);
        hashMap.put("GuardRegisterTask", z.class);
        hashMap.put("CodeCheckTask", p.class);
        hashMap.put("WxMiniMainInitTask", ct.class);
        hashMap.put("WxMiniInitTask", cs.class);
        hashMap.put("PreloadAfterRuntimeTask", bf.class);
        hashMap.put("BusinessPreloadTask", n.class);
        hashMap.put("StartServiceTask", ce.class);
        hashMap.put("PreloadConversationTask", bg.class);
        hashMap.put("PreLoadUiTask", be.class);
        hashMap.put("RaftKitInitTask", br.class);
        hashMap.put("RdmInitTask", bt.class);
        hashMap.put("ThemeInitTask", ci.class);
        hashMap.put("SkinInitTask", bx.class);
        hashMap.put("UrlDrawableInitTask", cm.class);
        hashMap.put("GuardInitTask", y.class);
        hashMap.put("MsgObserverTask", MsgObserverTask.class);
        hashMap.put("NewRuntimeTask", bc.class);
        hashMap.put("SubKernelInitTask", cf.class);
        hashMap.put("KernelInitTask", KernelInitTask.class);
        hashMap.put("RUDataPreloadTask", bq.class);
        hashMap.put("VersionUpdateTask", VersionUpdateTask.class);
        hashMap.put("SplashShowTask", cc.class);
        hashMap.put("SplashSetupTask", cb.class);
        hashMap.put("BrowserGlobalSettingTask", com.tencent.mobileqq.startup.task.l.class);
        hashMap.put("BrowserPreloadTask", com.tencent.mobileqq.startup.task.m.class);
        hashMap.put("QFSInitTask", bh.class);
        hashMap.put("RFWInitTask", bp.class);
        hashMap.put("QShadowInitTask", bn.class);
        hashMap.put("MemoryCacheInitTask", aw.class);
        hashMap.put("NoLoginTabInitTask", bd.class);
        hashMap.put("MatrixBatteryInitTask", av.class);
        hashMap.put("TabSdkInitTask", ch.class);
        hashMap.put("TuxSdkInitTask", cj.class);
        hashMap.put("DtSdkInitTask", s.class);
        hashMap.put("ManagerThreadTask", au.class);
        hashMap.put("QIPCInitTask", bi.class);
        hashMap.put("MonitorInitTask", bb.class);
        hashMap.put("EarlySdkInitTask", u.class);
        hashMap.put("LoadModuleTask", ao.class);
        hashMap.put("LoadDexTask", ai.class);
        hashMap.put("AlbumInitTask", com.tencent.mobileqq.startup.task.e.class);
        hashMap.put("QRouteInitTask", bm.class);
        hashMap.put("ApplicationCreateCommonTask", com.tencent.mobileqq.startup.task.f.class);
        hashMap.put("SpInitTask", ca.class);
        hashMap.put("ArtTiHookTask", com.tencent.mobileqq.startup.task.i.class);
        hashMap.put("QLogInitTask", bk.class);
        hashMap.put("CrashDefenderEndTask", q.class);
        hashMap.put("CrashDefenderTask", r.class);
        hashMap.put("MMKVInitTask", ap.class);
        hashMap.put("AttachStageCommonTask", com.tencent.mobileqq.startup.task.j.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.d
    @NotNull
    public NtTask createTask(@NotNull String taskId) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NtTask) iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskId);
        }
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        HashMap<String, Class<NtTask>> hashMap = sTaskClassMap;
        Class<NtTask> cls = hashMap.get(taskId);
        int size = hashMap.size();
        if (cls != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Log.d("NtStartup", "map size:" + size + ", taskId:" + taskId + ", contain:" + z16);
        if (cls != null) {
            NtTask newInstance = cls.newInstance();
            NtTask ntTask = newInstance;
            ntTask.setTaskId(taskId);
            Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.newInstance().appl\u2026Id = taskId\n            }");
            return ntTask;
        }
        throw new RuntimeException("Not support task:" + taskId);
    }
}
