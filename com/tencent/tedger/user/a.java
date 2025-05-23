package com.tencent.tedger.user;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedgecontext.b;
import com.tencent.tedgecontext.c;
import com.tencent.tedger.TEdgeBusinessCenter;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ve4.o;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends b implements o {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final String f375347i;

    /* renamed from: a, reason: collision with root package name */
    private String f375348a;

    /* renamed from: b, reason: collision with root package name */
    private int f375349b;

    /* renamed from: c, reason: collision with root package name */
    private int f375350c;

    /* renamed from: d, reason: collision with root package name */
    private String f375351d;

    /* renamed from: e, reason: collision with root package name */
    private String f375352e;

    /* renamed from: f, reason: collision with root package name */
    private long f375353f;

    /* renamed from: g, reason: collision with root package name */
    private long f375354g;

    /* renamed from: h, reason: collision with root package name */
    private EdgeUser f375355h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f375347i = a.class.getSimpleName();
        }
    }

    public a(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375348a = "TEdge_tab_user_";
        this.f375349b = 50;
        this.f375350c = 20;
        this.f375351d = "sdk_user_center_max_action_count_key";
        this.f375352e = "sdk_user_center_max_item_count_key";
        this.f375354g = 10000L;
        this.f375348a += getContext().p() + "_" + getContext().c();
        getContext().h().a(this.f375348a, TEdgeBusinessCenter.DB_VERSION);
    }

    private synchronized void H(boolean z16) {
        if (!z16) {
            if (System.currentTimeMillis() - this.f375353f < this.f375354g) {
                return;
            }
        }
        this.f375353f = System.currentTimeMillis();
        int d16 = getContext().h().d(this.f375348a, "dataId=?", new String[]{getContext().p()});
        this.mLog.c(f375347i, "saveData delete count = " + d16);
        if (this.f375355h != null) {
            ArrayList arrayList = new ArrayList();
            com.tencent.tedger.outapi.beans.a aVar = new com.tencent.tedger.outapi.beans.a();
            aVar.f375273a = this.f375355h.getUserID();
            aVar.f375274b = this.f375355h.readBussinessData();
            aVar.f375275c = System.currentTimeMillis();
            arrayList.add(aVar);
            getContext().h().b(this.f375348a, arrayList);
        }
    }

    @Override // ve4.o
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f375349b = (int) getRouter().f375304b.h("sdk.user_center." + this.f375351d, this.f375349b);
        this.f375350c = (int) getRouter().f375304b.h("sdk.user_center." + this.f375352e, this.f375350c);
    }

    @Override // com.tencent.tedger.outapi.api.o
    public synchronized void d(EdgeAction edgeAction, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) edgeAction, (Object) edgeStatus);
            return;
        }
        if (edgeAction != null) {
            if (this.f375355h == null) {
                this.f375355h = u(edgeStatus);
                edgeStatus.setCode(0L);
            }
            this.mLog.c(f375347i, "addUserAction action = " + edgeAction.getItemID());
            ArrayList<EdgeAction> actions = this.f375355h.getActions();
            if (actions.size() > 0) {
                Iterator<EdgeAction> it = actions.iterator();
                while (it.hasNext()) {
                    EdgeAction next = it.next();
                    if (next.getItemID().equals(edgeAction.getItemID())) {
                        Iterator<TEdgeEvent$Event> it5 = next.getEvents().iterator();
                        while (it5.hasNext()) {
                            TEdgeEvent$Event next2 = it5.next();
                            if (next2.timestamp.get() == edgeAction.getEvents().get(0).timestamp.get()) {
                                this.mLog.c(f375347i, "addUserBehavior timestamp same = " + next2.timestamp.get());
                                return;
                            }
                        }
                        ArrayList<TEdgeEvent$Event> events = next.getEvents();
                        events.add(edgeAction.getEvents().get(0));
                        if (next.getEvents().size() > this.f375350c) {
                            next.getEvents().remove(0);
                        }
                        next.setEvents(events);
                        this.f375355h.setActions(actions);
                        H(false);
                        return;
                    }
                }
            }
            actions.add(edgeAction);
            if (actions.size() > this.f375349b) {
                actions.remove(0);
            }
            this.f375355h.setActions(actions);
            H(false);
        } else {
            edgeStatus.setCode(-1L);
            this.mLog.c(f375347i, "addUserBehavior action is null");
        }
    }

    @Override // com.tencent.tedger.outapi.api.o
    public EdgeUser u(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EdgeUser) iPatchRedirector.redirect((short) 2, (Object) this, (Object) edgeStatus);
        }
        EdgeUser edgeUser = this.f375355h;
        if (edgeUser == null) {
            List<com.tencent.tedger.outapi.beans.a> e16 = getContext().h().e(this.f375348a, null, true);
            if (e16 != null && e16.size() > 0) {
                for (com.tencent.tedger.outapi.beans.a aVar : e16) {
                    if (getContext().p().equals(aVar.f375273a) && aVar.f375274b != null) {
                        this.mLog.d(f375347i, "getUserInfo from db");
                        EdgeUser a16 = getContext().g().a(aVar.f375274b);
                        edgeStatus.setCode(0L);
                        this.f375355h = a16;
                        return a16;
                    }
                }
            }
            c cVar = this.mLog;
            String str = f375347i;
            cVar.d(str, "mUser is null");
            edgeUser = getContext().g().a(null);
            if (edgeUser != null) {
                this.mLog.d(str, "user is not null create new user");
                edgeUser.setUserID(getContext().p());
                edgeStatus.setCode(0L);
            } else {
                this.mLog.d(str, "create new user failed");
                edgeStatus.setCode(-108L);
            }
            this.f375355h = edgeUser;
        }
        return edgeUser;
    }

    @Override // com.tencent.tedger.outapi.api.o
    public synchronized void updateUserBaseInfo(EdgeUser edgeUser, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) edgeUser, (Object) edgeStatus);
            return;
        }
        if (edgeUser == null) {
            edgeStatus.setCode(-1L);
            this.mLog.c(f375347i, "updateUserBaseInfo userInfo is null");
            return;
        }
        if (this.f375355h == null) {
            this.f375355h = u(edgeStatus);
        }
        EdgeUser edgeUser2 = this.f375355h;
        if (edgeUser2 != null) {
            edgeUser2.updateProfile(edgeUser);
        } else {
            this.f375355h = edgeUser;
            this.mLog.c(f375347i, "updateUserBaseInfo no data local");
        }
        H(false);
    }
}
