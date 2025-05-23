package com.tencent.luggage.wxa.yq;

import android.os.AsyncTask;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.yq.n;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebEmbedSetting;
import com.tencent.xweb.internal.ConstValue;
import java.util.Arrays;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class r extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public String f146128a = "0";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n.d f146130a;

        public b(n.d dVar) {
            this.f146130a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.ar.k a16 = com.tencent.luggage.wxa.ar.r.a(this.f146130a.f146102b);
            if (a16 == null) {
                x0.d("XWebRuntimeUpdateChecker", "onConfigDownloaded, parse config failed, retCode:" + this.f146130a.f146103c);
                s.a();
                n0.a(35L, 1);
                n.d dVar = this.f146130a;
                dVar.f146103c = -10006;
                com.tencent.luggage.wxa.wq.o.a(dVar, r.this.f146128a, "0");
                return;
            }
            x0.d("XWebRuntimeUpdateChecker", "onConfigDownloaded, costTime:" + this.f146130a.f146107g + "ms, configVersion:" + a16.f121701c + ", commands:" + Arrays.toString(a16.f121703e));
            n0.a(a16.f121701c, true);
            v0.g();
            if (w.b(u0.g())) {
                x0.d("XWebRuntimeUpdateChecker", "onConfigDownloaded, delete old config file success");
            }
            try {
                CommandCfg.getInstance().applyCommand(a16.f121703e, a16.f121701c);
                s.e();
            } catch (Throwable th5) {
                x0.a("XWebRuntimeUpdateChecker", "onConfigDownloaded, apply command error", th5);
            }
            n0.a(this.f146130a.f146107g);
            com.tencent.luggage.wxa.wq.o.a(this.f146130a, r.this.f146128a, a16.f121701c);
            m.f().a(a16);
            l.g().a(a16);
            r.this.b();
        }
    }

    public final void c() {
        n.b bVar = new n.b();
        bVar.f146095a = z0.b();
        bVar.f146096b = u0.f();
        bVar.f146097c = true;
        x0.d("XWebRuntimeUpdateChecker", "fetchConfig start, url:" + bVar.f146095a + ", path:" + bVar.f146096b);
        n.a(bVar, new a());
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        s.i();
    }

    public final void b() {
        String str = this.f146128a;
        if (str != null && str.equals("5")) {
            x0.f("XWebRuntimeUpdateChecker", "checkNeedUpdateRuntime, check config update only, return");
            s.b();
            return;
        }
        if (XWebEmbedSetting.getForbidDownloadCode()) {
            x0.d("XWebRuntimeUpdateChecker", "checkNeedUpdateRuntime, forbid download code");
            s.b();
            return;
        }
        if (t.c()) {
            x0.d("XWebRuntimeUpdateChecker", "checkNeedUpdateRuntime, already in updating process");
            s.g();
        } else if (m.f().isTimeToUpdate(true)) {
            a(m.f());
        } else if (l.g().isTimeToUpdate(true)) {
            a(l.g());
        } else {
            x0.f("XWebRuntimeUpdateChecker", "checkNeedUpdateRuntime, no scheduler is time to update");
            s.g();
        }
    }

    public final void a(HashMap hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get(ConstValue.XWEB_UPDATER_START_CHECK_TYPE);
            this.f146128a = str;
            if (str == null) {
                this.f146128a = "0";
            } else if (str.equals("1")) {
                m.f().resetLastUpdateTime();
            } else if (this.f146128a.equals("2")) {
                m.f().resetLastUpdateTime();
                n0.a(93L, 1);
            } else if (this.f146128a.equals("3")) {
                m.f().getCurSchedulerConfig().f121689q = true;
                n0.a(94L, 1);
            }
        }
        x0.d("XWebRuntimeUpdateChecker", "initConfigs, notifyType:" + this.f146128a + " [0:timer/1:notify/2:force/4:embed/5:config/7:auto]");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(HashMap... hashMapArr) {
        if (hashMapArr != null && hashMapArr.length > 0) {
            a(hashMapArr[0]);
        }
        if (a()) {
            return 1;
        }
        return 0;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (num.intValue() == 1) {
            c();
        } else {
            s.g();
        }
    }

    public boolean a() {
        if (!z.a()) {
            x0.d("XWebRuntimeUpdateChecker", "checkNeedFetchConfig, false because no network");
            return false;
        }
        if (!XWalkEnvironment.hasInstalledAvailableVersion() && !m.f().hasScheduler()) {
            x0.d("XWebRuntimeUpdateChecker", "checkNeedFetchConfig, true because no scheduler and no availableVersion");
            return true;
        }
        if (m.f().checkNeedFetchConfig() && !t.c()) {
            x0.d("XWebRuntimeUpdateChecker", "checkNeedFetchConfig, true because not in updating process and need fetch config");
            return true;
        }
        boolean isTimeToUpdate = m.f().isTimeToUpdate(false);
        boolean isTimeToUpdate2 = l.g().isTimeToUpdate(false);
        if (!isTimeToUpdate && !isTimeToUpdate2) {
            return false;
        }
        x0.d("XWebRuntimeUpdateChecker", "checkNeedFetchConfig, true because needUpdateRuntime:" + isTimeToUpdate + ", needUpdatePredownRuntime:" + isTimeToUpdate2);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.yq.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.yq.b
        public void onTaskFailed(n.d dVar) {
            x0.d("XWebRuntimeUpdateChecker", "fetchConfig onTaskFailed, get config fail, retCode:" + dVar.f146103c);
            s.a();
            n0.s();
            com.tencent.luggage.wxa.wq.o.a(dVar, r.this.f146128a, "0");
        }

        @Override // com.tencent.luggage.wxa.yq.b
        public void onTaskStarted() {
            x0.d("XWebRuntimeUpdateChecker", "fetchConfig onTaskStarted");
            m.f().onStartFetchConfig();
            n0.r();
        }

        @Override // com.tencent.luggage.wxa.yq.b
        public void onTaskSucceed(n.d dVar) {
            r.this.a(dVar);
        }

        @Override // com.tencent.luggage.wxa.yq.b
        public void onTaskProgressChanged(n.c cVar) {
        }
    }

    public final void a(n.d dVar) {
        com.tencent.luggage.wxa.lq.d.a(new b(dVar));
    }

    public final void a(m mVar) {
        x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, scheduler config:" + mVar.toString());
        n0.b(903L, 160L, 1L);
        s.f();
        q qVar = new q();
        x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, try update runtime from provider");
        if (qVar.a(mVar)) {
            return;
        }
        x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, continue try update runtime from remote");
        if (!z.a()) {
            x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, no network");
            s.b();
            return;
        }
        j0 curSchedulerConfig = mVar.getCurSchedulerConfig();
        if (!curSchedulerConfig.f121689q && !z.b()) {
            x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, not wifi and scheduler not support mobile data");
            s.b();
        } else {
            if (t.d()) {
                x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, start updating process");
                if (qVar.c(mVar.a(curSchedulerConfig))) {
                    return;
                }
                x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, update runtime failed");
                t.a();
                s.d();
                return;
            }
            x0.d("XWebRuntimeUpdateChecker", "startUpdateRuntime, start updating process failed");
            s.b();
        }
    }
}
