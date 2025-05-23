package com.tencent.tedger.trigger;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedgecontext.b;
import com.tencent.tedgecontext.c;
import com.tencent.tedger.event.EdgeUserActionEvent;
import com.tencent.tedger.event.TEdgeBaseEvent;
import com.tencent.tedger.outapi.api.f;
import com.tencent.tedger.outapi.api.g;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.video.decode.AVDecodeError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends b implements g, ue4.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<Integer> f375340a;

    /* renamed from: b, reason: collision with root package name */
    private String f375341b;

    /* renamed from: c, reason: collision with root package name */
    private String f375342c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tedger.trigger.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9902a implements h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f375343a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f375344b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EdgeAction f375345c;

        C9902a(int i3, long j3, EdgeAction edgeAction) {
            this.f375343a = i3;
            this.f375344b = j3;
            this.f375345c = edgeAction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, Integer.valueOf(i3), Long.valueOf(j3), edgeAction);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (a.this.getRouter().a()) {
                return;
            }
            if (edgeStatus.getCode() == 0) {
                int i3 = this.f375343a;
                if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                    ((b) a.this).mLog.h("EdgeTriggerCenter", "workflow = " + this.f375343a + " results = " + objArr);
                } else if (a.this.getContext().k() != null && objArr != null && objArr.length > 0) {
                    ((b) a.this).mLog.d("EdgeTriggerCenter", "trigger success workflow = " + this.f375343a + " resultsSize = " + ((List) objArr[0]).size() + " timeCost = " + (System.currentTimeMillis() - this.f375344b));
                    a.this.getContext().k().a(str, this.f375345c, (List) objArr[0]);
                } else {
                    ((b) a.this).mLog.h("EdgeTriggerCenter", "item delegate is null or results is empty");
                }
            } else {
                ((b) a.this).mLog.h("EdgeTriggerCenter", "trigger failed workflow = " + this.f375343a + " results = " + objArr + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg() + " timeCost = " + (System.currentTimeMillis() - this.f375344b));
            }
            if (a.this.getContext().s() && a.this.getRouter().f375304b.i(a.this.f375342c, true)) {
                HashMap hashMap = new HashMap();
                hashMap.put("event_id", "tedge_n_trigger_finish");
                hashMap.put("ret_code", Long.valueOf(edgeStatus.getCode()));
                hashMap.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
                hashMap.put("err_msg", edgeStatus.getMsg());
                hashMap.put(CheckForwardServlet.KEY_REQ_ID, str);
                hashMap.put("rerank_trace_id", Integer.valueOf(this.f375343a));
                hashMap.put("time_cost", Long.valueOf(System.currentTimeMillis() - this.f375344b));
                if (objArr != null && objArr.length > 0) {
                    List<EdgeItem> list = (List) objArr[0];
                    if (list.size() > 0) {
                        ((b) a.this).mLog.d("EdgeTriggerCenter", "workflow = " + this.f375343a + " itemSize = " + list.size());
                        String str2 = "";
                        for (EdgeItem edgeItem : list) {
                            if (edgeItem != null) {
                                str2 = str2 + edgeItem.getItemID() + "#";
                            }
                        }
                        hashMap.put("items", str2);
                    }
                }
                a.this.getContext().d().c(new HashMap(hashMap));
            }
        }
    }

    public a(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375340a = new ArrayList<>(Arrays.asList(-1));
        this.f375341b = "trigger.sdk_trigger_center_action_type";
        this.f375342c = "trigger.sdk_trigger_center_report_action";
        getRouter().f375309g.q(this);
    }

    private List<Integer> N(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (getContext().m().f375304b.a()) {
            this.mLog.h("EdgeTriggerCenter", "device is invalid = ");
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).intValue() != 2 && list.get(i3).intValue() != 3) {
                    arrayList.add(list.get(i3));
                } else {
                    arrayList.add(2);
                }
            }
            return arrayList;
        }
        return list;
    }

    private void O(EdgeAction edgeAction) {
        String str;
        String str2;
        int i3;
        EdgeStatus edgeStatus = new EdgeStatus();
        String str3 = "tedge_n_trigger_start";
        String str4 = "err_msg";
        boolean z16 = true;
        if (edgeAction != null && edgeAction.getEvents() != null && edgeAction.getEvents().size() != 0) {
            c cVar = this.mLog;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("start trigger itemId = ");
            sb5.append(edgeAction.getItemID());
            sb5.append(" actionType = ");
            int i16 = 0;
            sb5.append(edgeAction.getEvents().get(0).type.get());
            cVar.d("EdgeTriggerCenter", sb5.toString());
            List<Integer> dispatchAction = getRouter().f375316n.dispatchAction(edgeAction, getRouter().f375307e.u(edgeStatus), edgeStatus);
            if (edgeStatus.getCode() == 0 && dispatchAction.size() > 0) {
                List<Integer> N = N(dispatchAction);
                if (N.size() == 0) {
                    this.mLog.h("EdgeTriggerCenter", "no workflow need to trigger");
                    return;
                }
                Iterator<Integer> it = N.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (intValue != 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.mLog.d("EdgeTriggerCenter", "trigger start workflow = " + intValue);
                        if (getContext().s() && getRouter().f375304b.i(this.f375342c, z16)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("event_id", str3);
                            hashMap.put("ret_code", Long.valueOf(edgeStatus.getCode()));
                            hashMap.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
                            hashMap.put(str4, edgeStatus.getMsg());
                            hashMap.put("rerank_trace_id", Integer.valueOf(intValue));
                            hashMap.put("edge_recom_trace", Integer.valueOf(edgeAction.getEvents().get(i16).type.get()));
                            getContext().d().c(new HashMap(hashMap));
                        }
                        str = str3;
                        str2 = str4;
                        i3 = i16;
                        getRouter().f375309g.k(TEdgeBaseEvent.getEventForName(intValue, edgeAction, new C9902a(intValue, currentTimeMillis, edgeAction)));
                    } else {
                        str = str3;
                        str2 = str4;
                        i3 = i16;
                    }
                    i16 = i3;
                    str4 = str2;
                    str3 = str;
                    z16 = true;
                }
                return;
            }
            this.mLog.d("EdgeTriggerCenter", "trigger fail code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg() + " workflows = " + dispatchAction.size() + " actionType = " + edgeAction.getEvents().get(0).type.get());
            if (getContext().s() && getRouter().f375304b.i(this.f375342c, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event_id", "tedge_n_trigger_finish");
                hashMap2.put("ret_code", Long.valueOf(edgeStatus.getCode()));
                hashMap2.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
                hashMap2.put("err_msg", edgeStatus.getMsg());
                hashMap2.put("items", Integer.valueOf(edgeAction.getEvents().get(0).type.get()));
                getContext().d().c(new HashMap(hashMap2));
                return;
            }
            return;
        }
        edgeStatus.setCode(-100L);
        edgeStatus.setMsg("action or action.events is null");
        this.mLog.h("EdgeTriggerCenter", "trigger failed action or action.events is null");
        if (getContext().s() && getRouter().f375304b.i(this.f375342c, true)) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event_id", "tedge_n_trigger_start");
            hashMap3.put("ret_code", Long.valueOf(edgeStatus.getCode()));
            hashMap3.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
            hashMap3.put("err_msg", edgeStatus.getMsg());
            getContext().d().c(new HashMap(hashMap3));
        }
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Integer> getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f375340a;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(EdgeUserActionEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeUserActionEvent)) {
            try {
                O(fVar.getAction());
            } catch (Exception e16) {
                this.mLog.e("EdgeTriggerCenter", AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, "trigger error" + e16);
            }
        }
    }
}
