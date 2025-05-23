package com.tencent.tedger.flow;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.outapi.api.ITEdgeRSServer;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.report.EdgeErrorEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class r extends com.tencent.tedgecontext.b implements com.tencent.tedger.outapi.api.g {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static AtomicBoolean f375232j;

    /* renamed from: a, reason: collision with root package name */
    public String f375233a;

    /* renamed from: b, reason: collision with root package name */
    protected String f375234b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.tedger.outapi.api.h f375235c;

    /* renamed from: d, reason: collision with root package name */
    public EdgeAction f375236d;

    /* renamed from: e, reason: collision with root package name */
    public String f375237e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, Object> f375238f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, Object> f375239g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<Integer> f375240h;

    /* renamed from: i, reason: collision with root package name */
    private long f375241i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f375232j = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375233a = getClass().getSimpleName();
        this.f375238f = new HashMap<>();
        this.f375239g = new HashMap<>();
        this.f375240h = new ArrayList<>(Arrays.asList(-1));
        this.f375241i = 0L;
        getRouter().f375309g.q(this);
    }

    public static List<r> K(com.tencent.tedgecontext.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new m(aVar));
        arrayList.add(new EdgeTrainingFlow(aVar));
        arrayList.add(new e(aVar));
        arrayList.add(new g(aVar));
        arrayList.add(new j(aVar));
        arrayList.add(new i(aVar));
        arrayList.add(new f(aVar));
        arrayList.add(new d(aVar));
        arrayList.add(new n(aVar));
        arrayList.add(new q(aVar));
        arrayList.add(new p(aVar));
        arrayList.add(new h(aVar));
        arrayList.add(new o(aVar));
        ITEdgeRSServer.TEdgeServerScene q16 = aVar.q();
        if (q16 != null && q16 != ITEdgeRSServer.TEdgeServerScene.ClientRank) {
            if (q16 == ITEdgeRSServer.TEdgeServerScene.CloudRank) {
                arrayList.add(new c(aVar));
            } else if (q16 == ITEdgeRSServer.TEdgeServerScene.CloudAndClientRank) {
                arrayList.add(new b(aVar));
                arrayList.add(new a(aVar));
                arrayList.add(new c(aVar));
                arrayList.add(new k(aVar));
                arrayList.add(new l(aVar));
            } else {
                ITEdgeRSServer.TEdgeServerScene tEdgeServerScene = ITEdgeRSServer.TEdgeServerScene.ClientRank;
            }
        } else {
            arrayList.add(new a(aVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) edgeStatus);
            return;
        }
        if (this.f375238f.size() != 0) {
            N(edgeStatus);
        }
        L();
        this.mLog.c(this.f375233a, "finish reqId = " + this.f375237e + " cost time = " + (System.currentTimeMillis() - this.f375241i));
        this.f375241i = 0L;
        this.f375236d = null;
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String config = getRouter().f375304b.getConfig(this.f375234b);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        try {
            for (String str : config.split(ContainerUtils.FIELD_DELIMITER)) {
                this.f375240h.add(Integer.valueOf(Integer.parseInt(str)));
            }
        } catch (Exception unused) {
            this.mLog.e(this.f375233a, -100, "get userCenter actionTypes error");
            EdgeStatus edgeStatus = new EdgeStatus();
            edgeStatus.setCode(-100L);
            edgeStatus.setMsg("get userCenter actionTypes error");
            getRouter().f375309g.k(new EdgeErrorEvent(edgeStatus));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
            return;
        }
        if (TextUtils.isEmpty(fVar.getReqId())) {
            this.f375237e = UUID.randomUUID().toString();
            this.mLog.d(this.f375233a, "create reqID  = " + this.f375237e + " eventName = " + fVar.getClass().getSimpleName());
            return;
        }
        this.f375237e = fVar.getReqId();
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f375238f.size() > 0) {
            getContext().d().c(new HashMap(this.f375238f));
            this.mLog.d(this.f375233a, "report data = " + this.f375238f.toString());
        }
        if (this.f375239g.size() > 0) {
            getContext().d().c(new HashMap(this.f375239g));
            this.mLog.d(this.f375233a, "report so data = " + this.f375239g.toString());
        }
        this.f375238f.clear();
        this.f375239g.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mLog.c(this.f375233a, "run reqId = " + this.f375237e);
        this.f375241i = System.currentTimeMillis();
    }

    protected void N(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) edgeStatus);
        } else if (edgeStatus != null) {
            this.f375238f.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
            this.f375238f.put("ret_code", Long.valueOf(edgeStatus.getCode()));
            this.f375238f.put("err_msg", edgeStatus.getMsg());
            this.f375238f.put("time_cost", Long.valueOf(System.currentTimeMillis() - this.f375241i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f375238f.put("event_id", str);
        this.f375238f.put("ret_code", 0);
        this.f375238f.put(CheckForwardServlet.KEY_REQ_ID, this.f375237e);
        L();
        this.f375238f.put("event_id", str2);
        this.f375238f.put(CheckForwardServlet.KEY_REQ_ID, this.f375237e);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mLog.c(this.f375233a, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        getRouter().f375309g.F(this);
        f375232j.set(false);
    }
}
