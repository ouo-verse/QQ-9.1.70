package com.tencent.luggage.wxa.id;

import android.util.ArraySet;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8Inspector;
import com.tencent.luggage.wxa.hn.ac;
import com.tencent.luggage.wxa.hn.ad;
import com.tencent.luggage.wxa.hn.bc;
import com.tencent.luggage.wxa.hn.bd;
import com.tencent.luggage.wxa.hn.cc;
import com.tencent.luggage.wxa.hn.dc;
import com.tencent.luggage.wxa.hn.dd;
import com.tencent.luggage.wxa.hn.ec;
import com.tencent.luggage.wxa.hn.fc;
import com.tencent.luggage.wxa.hn.gc;
import com.tencent.luggage.wxa.hn.hc;
import com.tencent.luggage.wxa.hn.ic;
import com.tencent.luggage.wxa.hn.jd;
import com.tencent.luggage.wxa.hn.ld;
import com.tencent.luggage.wxa.hn.md;
import com.tencent.luggage.wxa.hn.nc;
import com.tencent.luggage.wxa.hn.pc;
import com.tencent.luggage.wxa.hn.sc;
import com.tencent.luggage.wxa.hn.uc;
import com.tencent.luggage.wxa.hn.wc;
import com.tencent.luggage.wxa.hn.xc;
import com.tencent.luggage.wxa.hn.yc;
import com.tencent.luggage.wxa.hn.zb;
import com.tencent.luggage.wxa.id.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: n, reason: collision with root package name */
    public static final Map f130065n;

    /* renamed from: a, reason: collision with root package name */
    public k f130066a;

    /* renamed from: b, reason: collision with root package name */
    public e f130067b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.mm.plugin.appbrand.debugger.a f130068c;

    /* renamed from: h, reason: collision with root package name */
    public long f130073h;

    /* renamed from: m, reason: collision with root package name */
    public Future f130078m;

    /* renamed from: d, reason: collision with root package name */
    public x f130069d = new x(100);

    /* renamed from: e, reason: collision with root package name */
    public boolean f130070e = false;

    /* renamed from: f, reason: collision with root package name */
    public ArraySet f130071f = new ArraySet();

    /* renamed from: g, reason: collision with root package name */
    public boolean f130072g = false;

    /* renamed from: i, reason: collision with root package name */
    public LinkedList f130074i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public final int f130075j = 5000;

    /* renamed from: k, reason: collision with root package name */
    public int f130076k = 0;

    /* renamed from: l, reason: collision with root package name */
    public long f130077l = 0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements V8Inspector.JsInspectorChannelServer {
        public a() {
        }

        @Override // com.eclipsesource.mmv8.V8Inspector.JsInspectorChannelServer
        public int notify(long j3, long j16, String str) {
            return 0;
        }

        @Override // com.eclipsesource.mmv8.V8Inspector.JsInspectorChannelServer
        public int sendData(long j3, String str) {
            i.this.a(j3, str);
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ic icVar, ic icVar2) {
            if (icVar != null && icVar2 != null) {
                return icVar.f127891d - icVar2.f127891d;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList linkedList = new LinkedList();
            synchronized (i.this.f130067b.j()) {
                linkedList.addAll(i.this.f130074i);
                i.this.f130074i.clear();
                i.this.f130072g = false;
            }
            i.this.a(linkedList, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f130067b.y() && i.this.l()) {
                w.d("MicroMsg.RemoteDebugMsgMrg", "testServer");
            } else {
                i.this.m();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - i.this.f130067b.g() >= 10000) {
                    i.this.h();
                }
                if (i.this.f130067b.C() && currentTimeMillis - i.this.f130067b.i() >= 30000) {
                    i iVar = i.this;
                    iVar.b(iVar.f130067b.n(), Integer.MAX_VALUE);
                }
            }
            i.this.f130068c.l();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f130065n = hashMap;
        hashMap.put(DebugUtils.Method.PUBLISHHANDLER, new String[]{Entry.DATA_TYPE_STRING, Entry.DATA_TYPE_STRING, Entry.DATA_TYPE_STRING});
        hashMap.put(DebugUtils.Method.INVOKEHANDLER, new String[]{Entry.DATA_TYPE_STRING, Entry.DATA_TYPE_STRING, "Number"});
    }

    public void e(String str) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "sendClientNavigatorEvent  event:%s", str);
        fc fcVar = new fc();
        fcVar.f127631d = str;
        a(l.a(fcVar, this.f130067b, "clientNavigatorEvent"));
    }

    public final void f() {
        this.f130067b.b(4);
        this.f130066a.a(1000, "quit");
    }

    public synchronized void g() {
        w.a("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f130067b.r().iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            ic icVar = hVar.f130063b;
            if (icVar == null) {
                linkedList.add(hVar);
            } else if (icVar.f127891d <= this.f130067b.p()) {
                linkedList.add(hVar);
            }
        }
        this.f130067b.r().removeAll(linkedList);
    }

    public void h() {
        dd ddVar = new dd();
        ddVar.f127510d = this.f130067b.b();
        ddVar.f127511e = this.f130067b.n();
        this.f130066a.a(l.a(1001, ddVar));
    }

    public void i() {
        j();
        this.f130078m = com.tencent.luggage.wxa.zp.h.f146825d.a(new d(), 100L, 1000L);
    }

    public void j() {
        w.d("MicroMsg.RemoteDebugMsgMrg", "onClose");
        Future future = this.f130078m;
        if (future != null) {
            future.cancel(false);
        }
    }

    public synchronized void k() {
        int i3;
        for (int i16 = 0; i16 < this.f130067b.l().size(); i16++) {
            if (i16 == 0) {
                i3 = this.f130067b.n();
            } else {
                i3 = ((ic) this.f130067b.l().get(i16 - 1)).f127891d;
            }
            int i17 = ((ic) this.f130067b.l().get(i16)).f127891d;
            if (i3 - i17 != 1) {
                b(i3 + 1, i17 - 1);
            }
        }
    }

    public synchronized boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.f130077l;
        int i3 = this.f130076k;
        if (j3 < i3) {
            return false;
        }
        this.f130077l = currentTimeMillis;
        if (i3 < 5000) {
            this.f130076k = i3 + 1000;
        } else {
            this.f130076k = 2000;
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f130067b.r().iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (currentTimeMillis - hVar.f130062a > 5000) {
                hVar.a();
                linkedList.add(hVar);
                a(linkedList, false, true);
                return true;
            }
        }
        if (this.f130067b.r().size() <= 0) {
            return false;
        }
        h hVar2 = (h) this.f130067b.r().get(0);
        hVar2.a();
        linkedList.add(hVar2);
        a(linkedList, false, true);
        return true;
    }

    public synchronized void m() {
        if (this.f130067b.y()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f130067b.r().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (currentTimeMillis - hVar.f130062a > 5000) {
                hVar.a();
                linkedList.add(hVar);
                i3 += hVar.f130064c;
                if (i3 >= 65536 || linkedList.size() > 800) {
                    w.d("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                    a(linkedList, false);
                    linkedList.clear();
                    break;
                }
            }
        }
        if (!w0.a((List) linkedList)) {
            w.d("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
            a(linkedList, false);
        }
    }

    public void b(int i3, int i16) {
        w.d("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 > i16) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f130069d.get(Integer.valueOf(i3)) != null && currentTimeMillis - ((Long) this.f130069d.get(Integer.valueOf(i3))).longValue() < 3000) {
            w.d("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
            return;
        }
        this.f130069d.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis));
        ld ldVar = new ld();
        ldVar.f128082d = this.f130067b.b();
        ldVar.f128083e = i3;
        ldVar.f128084f = i16;
        this.f130066a.a(l.a(1005, ldVar));
        this.f130067b.I();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2.equals(com.tencent.qqmini.miniapp.util.DebugUtils.Command.EVALUATE_JAVASCRIPT_RESULT) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(LinkedList linkedList) {
        byte[] a16;
        if (w0.a((List) linkedList)) {
            w.f("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            return;
        }
        Iterator it = b(linkedList).iterator();
        while (true) {
            char c16 = 1;
            if (it.hasNext()) {
                ic icVar = (ic) it.next();
                if (l.a(icVar.f127895h)) {
                    a16 = com.tencent.luggage.wxa.y8.j.b(icVar.f127894g.a());
                } else {
                    a16 = icVar.f127894g.a();
                }
                String str = icVar.f127893f;
                str.hashCode();
                switch (str.hashCode()) {
                    case -1680221061:
                        if (str.equals(DebugUtils.Command.CALL_INTERFACE)) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -217209181:
                        break;
                    case 3441010:
                        if (str.equals("ping")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 52537216:
                        if (str.equals(DebugUtils.Command.CHROME_DEVTOOLS)) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 95766211:
                        if (str.equals(DebugUtils.Command.DOM_OP)) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 907832012:
                        if (str.equals("clientNavigator")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 1319027697:
                        if (str.equals(DebugUtils.Command.BREAK_POINT)) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 1972337494:
                        if (str.equals("customMessage")) {
                            c16 = 7;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        a((ac) new ac().a(a16));
                        break;
                    case 1:
                        a((pc) new pc().a(a16));
                        break;
                    case 2:
                        a((wc) new wc().a(a16));
                        break;
                    case 3:
                        a((cc) new cc().a(a16));
                        break;
                    case 4:
                        a((nc) new nc().a(a16));
                        break;
                    case 5:
                        a((ec) new ec().a(a16));
                        break;
                    case 6:
                        a((zb) new zb().a(a16));
                        break;
                    case 7:
                        a((gc) new gc().a(a16));
                        break;
                }
            } else {
                w.d("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.f130067b.n()));
                this.f130067b.a(linkedList.size());
                k();
                return;
            }
        }
    }

    public void d(String str) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onReceiveNetworkHeader data:%s", str);
        this.f130067b.t().getJsRuntime().evaluateJavascript("typeof DebuggerConnection.onReceiveNetworkHeader === 'function' && DebuggerConnection.onReceiveNetworkHeader('" + com.tencent.luggage.wxa.uk.w.a(str) + "')", null);
    }

    public void a(k kVar, e eVar, com.tencent.mm.plugin.appbrand.debugger.a aVar) {
        this.f130066a = kVar;
        this.f130067b = eVar;
        this.f130068c = aVar;
        V8Inspector.setServer(new a());
    }

    public void d() {
        w.d("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
        f();
        this.f130068c.a();
    }

    public void e() {
        w.d("MicroMsg.RemoteDebugMsgMrg", "quit");
        jd jdVar = new jd();
        jdVar.f127956d = this.f130067b.b();
        this.f130066a.a(l.a(1004, jdVar));
    }

    public void a(boolean z16) {
        this.f130070e = z16;
    }

    public void a(yc ycVar) {
        ycVar.f129093d = "WeixinJSCore";
        for (String str : f130065n.keySet()) {
            if (((String[]) f130065n.get(str)).length > 5) {
                w.b("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
            } else {
                uc ucVar = new uc();
                ucVar.f128839d = str;
                int i3 = 0;
                while (true) {
                    Map map = f130065n;
                    if (i3 >= ((String[]) map.get(str)).length) {
                        break;
                    }
                    ucVar.f128840e.add(((String[]) map.get(str))[i3]);
                    i3++;
                }
                ycVar.f129094e.add(ucVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        e eVar = this.f130067b;
        if (eVar == null || eVar.t() == null || this.f130067b.t().getRuntime() == null || this.f130067b.t().getRuntime().H) {
            return;
        }
        this.f130067b.t().getRuntime().H = true;
        this.f130067b.t().getRuntime().d1();
    }

    public final void a(ac acVar) {
        String str;
        w.d("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", acVar.f127293e, Integer.valueOf(acVar.f127295g));
        String str2 = acVar.f127293e;
        LinkedList linkedList = acVar.f127294f;
        Map map = f130065n;
        if (!map.containsKey(str2)) {
            w.f("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
            return;
        }
        String[] strArr = (String[]) map.get(str2);
        if (linkedList.size() < strArr.length) {
            w.f("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if ("Number".equals(strArr[i3])) {
                arrayList.add(Integer.valueOf(w0.a((String) linkedList.get(i3), 0)));
            } else if ("Boolean".equals(strArr[i3])) {
                arrayList.add(Boolean.valueOf((String) linkedList.get(i3)));
            } else {
                arrayList.add(linkedList.get(i3));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        str2.hashCode();
        if (!str2.equals(DebugUtils.Method.PUBLISHHANDLER)) {
            if (!str2.equals(DebugUtils.Method.INVOKEHANDLER)) {
                w.f("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                return;
            }
            str = this.f130067b.t().a((String) String.class.cast(arrayList.get(0)), (String) String.class.cast(arrayList.get(1)), arrayList.size() >= 4 ? (String) String.class.cast(arrayList.get(3)) : "", ((Integer) Integer.class.cast(arrayList.get(2))).intValue());
        } else {
            this.f130067b.t().a((String) String.class.cast(arrayList.get(0)), (String) String.class.cast(arrayList.get(1)), a((String) String.class.cast(arrayList.get(2))));
            str = null;
        }
        String str3 = str != null ? str : "";
        if (!w0.c(str3)) {
            a(acVar.f127295g, str3);
        }
        j.a(str2, linkedList, currentTimeMillis, acVar.a(), str3.length());
    }

    public synchronized LinkedList b(LinkedList linkedList) {
        if (linkedList == null) {
            return null;
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        this.f130067b.l().addAll(linkedList);
        Collections.sort(this.f130067b.l(), new b());
        int n3 = this.f130067b.n();
        Iterator it = this.f130067b.l().iterator();
        while (it.hasNext()) {
            ic icVar = (ic) it.next();
            if (icVar != null) {
                int i3 = icVar.f127891d;
                if (i3 > n3) {
                    if (i3 - n3 != 1) {
                        break;
                    }
                    linkedList2.add(icVar);
                    n3 = icVar.f127891d;
                } else {
                    linkedList3.add(icVar);
                }
            }
        }
        this.f130067b.c(n3);
        this.f130067b.l().removeAll(linkedList2);
        this.f130067b.l().removeAll(linkedList3);
        w.a("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", Integer.valueOf(linkedList2.size()));
        return linkedList2;
    }

    public boolean c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("id")) {
                int i3 = jSONObject.getInt("id");
                if (this.f130071f.contains(Integer.valueOf(i3))) {
                    String format = String.format(Locale.ENGLISH, "ProfileGlobal.onInspectMessage('%s')", com.tencent.luggage.wxa.uk.w.a(str));
                    this.f130071f.remove(Integer.valueOf(i3));
                    w.a("MicroMsg.RemoteDebugMsgMrg", "onInspectorMsg data :%s", str);
                    e eVar = this.f130067b;
                    if (eVar != null && eVar.t() != null && this.f130067b.t().getJsRuntime() != null) {
                        this.f130067b.t().getJsRuntime().evaluateJavascript(format, null);
                        return true;
                    }
                    w.f("MicroMsg.RemoteDebugMsgMrg", "onInspectorMsg null");
                    return false;
                }
            }
        } catch (JSONException e16) {
            w.b("MicroMsg.RemoteDebugMsgMrg", "sendInspectorMsg  e:%s", e16);
        }
        return false;
    }

    public final void b(String str) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onExternalInspectMessage data:%s", str);
        String format = String.format(Locale.ENGLISH, "ProfileGlobal.onExternalInspectMessage('%s')", com.tencent.luggage.wxa.uk.w.a(str));
        e eVar = this.f130067b;
        if (eVar != null && eVar.t() != null && this.f130067b.t().getJsRuntime() != null) {
            this.f130067b.t().getJsRuntime().evaluateJavascript(format, null);
        } else {
            w.f("MicroMsg.RemoteDebugMsgMrg", "onExternalInspectMessage null");
        }
    }

    public void c() {
        w.d("MicroMsg.RemoteDebugMsgMrg", "onQuit");
        f();
        this.f130068c.f();
    }

    public void a(int i3, String str) {
        bc bcVar = new bc();
        bcVar.f127354e = i3;
        bcVar.f127353d = str;
        a(l.a(bcVar, this.f130067b, DebugUtils.Command.CALL_INTERFACE_RESULT));
    }

    public void a(md mdVar, hc hcVar) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onSync");
        if (l.a(this.f130067b, hcVar, mdVar.f128204d, this.f130068c, this)) {
            c(mdVar.f128205e);
            this.f130067b.d(mdVar.f128206f);
            g();
        }
    }

    public void a(sc scVar) {
        c(scVar.f128685d);
    }

    public final void a(ec ecVar) {
        w.d("MicroMsg.RemoteDebugMsgMrg", "onClientNavigator method %s", ecVar.f127569d);
        if (this.f130070e && "relaunchForProfile".equals(ecVar.f127569d)) {
            com.tencent.luggage.wxa.tk.l.a(new Runnable() { // from class: s21.a
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.b();
                }
            });
        }
    }

    public final void a(zb zbVar) {
        boolean A = this.f130067b.A();
        boolean z16 = zbVar.f129146d;
        if (A == z16) {
            return;
        }
        if (z16) {
            this.f130067b.b(true);
        } else {
            this.f130067b.b(false);
        }
        this.f130068c.h();
        this.f130068c.k();
    }

    public final void a(nc ncVar) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onDomOp, param:%s", ncVar.f128294d);
        int componentId = this.f130067b.t().getRuntime().Y().getCurrentPage().getCurrentPageView().getComponentId();
        if (ncVar.f128295e == componentId || this.f130067b.c().f130059i == 1) {
            this.f130067b.t().a("remoteDebugCommand", ncVar.f128294d, (int[]) null);
        } else {
            w.h("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", Integer.valueOf(ncVar.f128295e), Integer.valueOf(componentId));
        }
    }

    public final void a(cc ccVar) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onDevTools op_id:%d, payload:%s", Long.valueOf(ccVar.f127412d), ccVar.f127413e);
        if (ccVar.f127413e.contains("Tracing.")) {
            b(ccVar.f127413e);
        } else {
            V8Inspector.onReceiveData(ccVar.f127412d, ccVar.f127413e);
        }
    }

    public final void a(gc gcVar) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onCustomMsg method:%s, payload:%s", gcVar.f127712d, gcVar.f127713e);
        String str = "typeof DebuggerConnection.onCustomMessage === 'function' && DebuggerConnection.onCustomMessage('" + gcVar.f127712d + "', '" + com.tencent.luggage.wxa.uk.w.a(gcVar.f127713e) + "')";
        e eVar = this.f130067b;
        if (eVar != null && eVar.t() != null && this.f130067b.t().getJsRuntime() != null) {
            this.f130067b.t().getJsRuntime().evaluateJavascript(str, null);
        } else {
            w.f("MicroMsg.RemoteDebugMsgMrg", "onCustomMsg null");
        }
    }

    public void a(String str, String str2) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "sendCustomMsg payload:%s", str2);
        gc gcVar = new gc();
        gcVar.f127712d = str;
        gcVar.f127713e = str2;
        a(l.a(gcVar, this.f130067b, "customMessage"));
    }

    public void a(long j3, String str) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "onDevToolsResult op_id:%d, payload:%s", Long.valueOf(j3), str);
        if (c(str)) {
            return;
        }
        dc dcVar = new dc();
        dcVar.f127508d = j3;
        dcVar.f127509e = str;
        a(l.a(dcVar, this.f130067b, DebugUtils.Command.CHROME_DEVTOOLS_RESULT));
    }

    public final void a(wc wcVar) {
        xc xcVar = new xc();
        xcVar.f129033d = wcVar.f128969d;
        int b16 = j.b();
        xcVar.f129034e = b16;
        w.d("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", Integer.valueOf(b16));
        a(l.a(xcVar, this.f130067b, "pong"));
    }

    public final void a(pc pcVar) {
        w.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", Integer.valueOf(pcVar.f128433e));
        int i3 = pcVar.f128433e;
        String str = pcVar.f128432d;
        com.tencent.luggage.wxa.id.a aVar = (com.tencent.luggage.wxa.id.a) this.f130067b.d().remove(Integer.valueOf(i3));
        if (aVar == null) {
            return;
        }
        ValueCallback valueCallback = aVar.f130019a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(str);
        }
        w.a("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i3 + " ret: " + str);
        j.a(aVar, pcVar.a());
    }

    public void a(h hVar) {
        if (!this.f130067b.x()) {
            synchronized (this.f130067b.j()) {
                if (System.currentTimeMillis() - this.f130067b.h() > 16 && !this.f130072g) {
                }
                this.f130074i.add(hVar);
                a();
                return;
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(hVar);
        a(linkedList, true);
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f130067b.j()) {
            if (!this.f130072g || currentTimeMillis - this.f130073h >= 32) {
                this.f130073h = currentTimeMillis;
                if (w0.a((List) this.f130074i)) {
                    return;
                }
                this.f130072g = true;
                int currentTimeMillis2 = (int) (16 - (System.currentTimeMillis() - this.f130067b.h()));
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = 16;
                }
                com.tencent.luggage.wxa.uk.j.a().b(new c(), currentTimeMillis2);
            }
        }
    }

    public final synchronized void a(LinkedList linkedList, boolean z16) {
        a(linkedList, z16, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f A[Catch: all -> 0x008d, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0009, B:9:0x0022, B:11:0x0028, B:13:0x0036, B:17:0x0048, B:19:0x006f, B:20:0x0072, B:22:0x0086, B:23:0x0088, B:27:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086 A[Catch: all -> 0x008d, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0009, B:9:0x0022, B:11:0x0028, B:13:0x0036, B:17:0x0048, B:19:0x006f, B:20:0x0072, B:22:0x0086, B:23:0x0088, B:27:0x0052), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(LinkedList linkedList, boolean z16, boolean z17) {
        if (w0.a((List) linkedList)) {
            return;
        }
        ad adVar = new ad();
        adVar.f127296d = this.f130067b.b();
        adVar.f127298f = this.f130067b.n();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            adVar.f127297e.add(((h) it.next()).f130063b);
        }
        hc a16 = l.a(1006, adVar);
        if (this.f130067b.y() && !z17) {
            w.a("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            if (z16) {
                a(linkedList);
            }
            this.f130068c.a(a16.f127796d);
            this.f130067b.H();
            if (!this.f130067b.y()) {
                this.f130076k = 0;
            }
            a(a16);
        }
        w.a("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", Integer.valueOf(linkedList.size()));
        this.f130066a.a(a16);
        if (z16) {
        }
        this.f130068c.a(a16.f127796d);
        this.f130067b.H();
        if (!this.f130067b.y()) {
        }
        a(a16);
    }

    public final void a(hc hcVar) {
        com.tencent.luggage.wxa.id.d dVar = new com.tencent.luggage.wxa.id.d();
        dVar.f130023a = hcVar.a();
        dVar.f130024b = System.currentTimeMillis();
        this.f130067b.q().put(hcVar.f127797e, dVar);
    }

    public void a(bd bdVar, hc hcVar) {
        if (l.a(this.f130067b, hcVar, bdVar.f127355d, this.f130068c, this)) {
            w.a("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", Integer.valueOf(bdVar.f127356e), Integer.valueOf(bdVar.f127357f));
            this.f130067b.a(bdVar.f127356e, bdVar.f127357f);
            a(bdVar.f127356e, bdVar.f127357f);
        }
    }

    public final synchronized void a(LinkedList linkedList) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (w0.a((List) linkedList)) {
            return;
        }
        this.f130067b.r().addAll(linkedList);
    }

    public synchronized void a(int i3, int i16) {
        w.a("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f130067b.r().iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            ic icVar = hVar.f130063b;
            if (icVar == null) {
                linkedList.add(hVar);
            } else {
                int i17 = icVar.f127891d;
                if (i17 >= i3 && i17 <= i16) {
                    linkedList.add(hVar);
                }
            }
        }
        this.f130067b.r().removeAll(linkedList);
    }

    public final int[] a(String str) {
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                iArr[i3] = jSONArray.getInt(i3);
            }
        } catch (Exception e16) {
            w.b("MicroMsg.RemoteDebugMsgMrg", e16.getMessage());
        }
        return iArr;
    }
}
