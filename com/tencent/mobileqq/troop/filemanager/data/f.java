package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.history.compat.s;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.troop.filemanager.data.c;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends BaseAdapter implements q, AbsListView.OnScrollListener, Handler.Callback, c.e {
    static IPatchRedirector $redirector_;
    public static String V;
    private Map<UUID, c> C;
    private TroopFileManager D;
    private TroopFileTransferManager E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private b K;
    private List<n> L;
    public Handler M;
    public String N;
    public long P;
    public int Q;
    public int R;
    private c.e S;
    private s T;
    public boolean U;

    /* renamed from: d, reason: collision with root package name */
    private long f295840d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f295841e;

    /* renamed from: f, reason: collision with root package name */
    private Context f295842f;

    /* renamed from: h, reason: collision with root package name */
    private int f295843h;

    /* renamed from: i, reason: collision with root package name */
    private int f295844i;

    /* renamed from: m, reason: collision with root package name */
    private List<n> f295845m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            V = "TroopFileExpandableListAdapter<QFile>";
        }
    }

    public f(QQAppInterface qQAppInterface, Context context, long j3, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f295845m = new ArrayList();
        this.C = new HashMap();
        this.F = false;
        this.G = false;
        this.H = false;
        this.L = new ArrayList(20);
        this.P = 0L;
        this.Q = 0;
        this.R = 0;
        this.S = null;
        this.f295840d = j3;
        this.f295842f = context;
        this.N = str;
        this.f295843h = i3;
        this.f295841e = qQAppInterface;
        this.f295844i = i16;
        this.M = new Handler(this);
        this.E = TroopFileTransferManager.O(this.f295841e, this.f295840d);
        TroopFileManager F = TroopFileManager.F(this.f295841e, this.f295840d);
        this.D = F;
        F.f301899k = this.N;
        if (!F.q(this)) {
            this.D.registerObserver(this);
        }
    }

    private List<n> b(List<n> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList<n> arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (n nVar : arrayList) {
                if (TextUtils.isEmpty(nVar.f294916b) || !nVar.f294916b.contains("online_doc_folder_")) {
                    list.add(nVar);
                }
            }
        }
        return list;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.data.c.e
    public void B0(boolean z16, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Boolean.valueOf(z16), nVar);
            return;
        }
        if (this.L == null) {
            return;
        }
        if (nVar == null) {
            QLog.i(V, 1, "onSelected. fileInfo is null.");
        }
        if (z16) {
            if (!this.L.contains(nVar)) {
                this.L.add(nVar);
                Iterator<n> it = this.L.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().f294918d < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                        z17 = true;
                        break;
                    }
                }
                s sVar = this.T;
                if (sVar != null) {
                    sVar.p7(true, z17);
                }
            }
        } else {
            this.L.remove(nVar);
            if (this.T != null) {
                if (this.L.size() == 0) {
                    this.T.p7(false, false);
                } else {
                    Iterator<n> it5 = this.L.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        } else if (it5.next().f294918d < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                            z17 = true;
                            break;
                        }
                    }
                    this.T.p7(true, z17);
                }
            }
        }
        c.e eVar = this.S;
        if (eVar != null) {
            eVar.B0(z16, nVar);
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void B1(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) nVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void D1(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) nVar);
            return;
        }
        if (nVar.A && nVar.f294930p == 6) {
            n nVar2 = this.D.f301893e.get(nVar.f294929o);
            if (nVar2 != null && this.N.equals(nVar2.f294929o) && nVar2.B) {
                TroopFileManager.e eVar = this.D.f301895g.get(nVar2.f294929o + this.P);
                if (eVar != null && eVar.f301924g != null) {
                    if (TextUtils.isEmpty(nVar.g())) {
                        if (nVar.f294920f == 0) {
                            QQAppInterface qQAppInterface = this.f295841e;
                            nVar.f294928n = ac.s(qQAppInterface, qQAppInterface.getCurrentAccountUin(), this.f295840d + "", 1, 0);
                        } else {
                            nVar.r(this.f295841e, this.f295840d);
                        }
                    }
                    eVar.f301924g.remove(nVar2);
                    nVar2.j(nVar.f());
                    nVar2.C++;
                    eVar.f301924g.add(0, nVar2);
                    d(eVar.f301924g, eVar.f301920c, 0, false);
                    eVar.f301923f = null;
                } else {
                    return;
                }
            }
            if (this.N.equals(nVar.f294929o)) {
                TroopFileManager.e eVar2 = this.D.f301895g.get(nVar.f294929o + this.P);
                if (eVar2 != null && eVar2.f301924g != null) {
                    boolean z16 = eVar2.f301920c;
                    int size = this.f295845m.size();
                    if (TextUtils.isEmpty(nVar.g())) {
                        if (nVar.f294920f == 0) {
                            QQAppInterface qQAppInterface2 = this.f295841e;
                            nVar.f294928n = ac.s(qQAppInterface2, qQAppInterface2.getCurrentAccountUin(), this.f295840d + "", 1, 0);
                        } else {
                            nVar.r(this.f295841e, this.f295840d);
                        }
                    }
                    if (this.f295845m.size() == 0) {
                        eVar2.f301924g.add(nVar);
                        eVar2.f301925h.put(nVar.f294916b, nVar);
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            if (!this.f295845m.get(i3).B && nVar.f() >= this.f295845m.get(i3).f()) {
                                eVar2.f301924g.add(i3, nVar);
                                eVar2.f301925h.put(nVar.f294916b, nVar);
                                notifyDataSetChanged();
                                break;
                            } else {
                                if (i3 == size - 1 && z16) {
                                    eVar2.f301924g.add(nVar);
                                    eVar2.f301925h.put(nVar.f294916b, nVar);
                                }
                                i3++;
                            }
                        } else {
                            break;
                        }
                    }
                    eVar2.f301923f = null;
                    d(eVar2.f301924g, eVar2.f301920c, 0, false);
                    return;
                }
                return;
            }
            this.I = false;
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void I0(n nVar) {
        int i3;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) nVar);
            return;
        }
        if (nVar != null && (i3 = nVar.f294930p) != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 12) {
                if (this.N.equals(nVar.f294929o) || this.P != 0) {
                    c cVar2 = this.C.get(nVar.f294915a);
                    if (cVar2 != null && cVar2.f295803n.f294915a.equals(nVar.f294915a)) {
                        cVar2.f295803n = nVar;
                        cVar2.q(this.f295840d, this.f295842f, this.f295841e, this.F);
                    } else {
                        return;
                    }
                }
                n nVar2 = this.D.f301893e.get(nVar.f294929o);
                if (nVar2 == null || (cVar = this.C.get(nVar2.f294915a)) == null) {
                    return;
                }
                cVar.q(this.f295840d, this.f295842f, this.f295841e, this.F);
                return;
            }
            if (this.C.remove(nVar.f294915a) != null) {
                this.I = false;
                notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void N0(List<n> list, boolean z16, String str, long j3, ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, Boolean.valueOf(z16), str, Long.valueOf(j3), arrayList);
            return;
        }
        if (this.N.equals(str) && this.P == j3) {
            if (list == null) {
                b bVar = this.K;
                if (bVar != null) {
                    bVar.se(3);
                }
                com.tencent.mobileqq.filemanager.util.d.e(R.string.eq8);
                if (this.f295845m.isEmpty()) {
                    l(1);
                    return;
                }
                return;
            }
            b bVar2 = this.K;
            if (bVar2 != null) {
                bVar2.se(4);
            }
            d(list, z16, 0, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void X0(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) nVar);
            return;
        }
        if (nVar.B && "/".equals(this.N) && this.P == 0) {
            UUID randomUUID = UUID.randomUUID();
            nVar.f294915a = randomUUID;
            this.D.f301892d.put(randomUUID, nVar);
            this.D.f301893e.put(nVar.f294916b, nVar);
            TroopFileManager.e eVar = this.D.f301895g.get(this.N + this.P);
            if (eVar != null) {
                List<n> list = eVar.f301924g;
                if (list != null && eVar.f301925h != null) {
                    list.add(0, nVar);
                    eVar.f301925h.put(nVar.f294916b, nVar);
                }
                this.D.f301893e.put(nVar.f294916b, nVar);
                d(eVar.f301924g, eVar.f301920c, 0, false);
                eVar.f301923f = null;
            }
        }
    }

    public boolean a(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) nVar)).booleanValue();
        }
        List<n> list = this.L;
        if (list != null && !list.isEmpty()) {
            return this.L.contains(nVar);
        }
        return false;
    }

    public List<n> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.L;
    }

    public void d(List<n> list, boolean z16, int i3, boolean z17) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, list, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
            return;
        }
        if (list == null) {
            return;
        }
        this.C.clear();
        this.f295845m.clear();
        this.f295845m.addAll(b(list));
        if (list.size() == 0) {
            if ("/".equals(this.N)) {
                l(3);
                return;
            } else {
                l(6);
                return;
            }
        }
        this.I = false;
        notifyDataSetChanged();
        l(4);
        if (z16 && this.D.H(this.N, this.P) && (bVar = this.K) != null) {
            bVar.se(7);
        }
    }

    public void e() {
        int i3;
        int i16;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        b bVar = this.K;
        if (bVar != null) {
            i3 = bVar.za();
            i16 = this.K.Y2();
        } else {
            i3 = 0;
            i16 = 0;
        }
        while (i3 <= i16 - 1 && i3 < this.f295845m.size()) {
            n nVar = this.f295845m.get(i3);
            if (nVar != null && (cVar = this.C.get(nVar.f294915a)) != null) {
                cVar.n(this.f295840d, this.f295841e);
                cVar.p(this.f295840d, this.f295841e);
            }
            i3++;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        TroopFileManager troopFileManager = this.D;
        if (troopFileManager != null) {
            troopFileManager.unregisterObserver(this);
        }
        List<n> list = this.L;
        if (list != null) {
            list.clear();
        }
    }

    public void g(int i3, int i16) {
        boolean z16;
        List<n> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(this.f295842f);
        if (isNetworkAvailable && this.D.P(i3, this.N, this.P, null)) {
            z16 = true;
        } else {
            z16 = false;
        }
        TroopFileManager.e eVar = this.D.f301895g.get(this.N + this.P);
        if (eVar != null) {
            list = eVar.f301924g;
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (!isNetworkAvailable) {
                l(0);
                d(list, true, i16, true);
                return;
            }
            return;
        }
        if (isNetworkAvailable) {
            if (z16) {
                i17 = 0;
            }
            l(i17);
        } else {
            l(1);
            TroopFileUtils.F(this.f295841e, this.f295840d);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f295845m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return this.f295845m.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view3 = view;
            view4 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (i3 >= this.f295845m.size()) {
                QLog.i(V, 1, "getView: error. position[" + i3 + "] fileListSize[" + this.f295845m.size() + "]");
            }
            n nVar = this.f295845m.get(i3);
            c cVar2 = null;
            if (view == null) {
                c cVar3 = new c(this.f295841e, this.f295842f, this.f295840d, R.layout.ami, this.f295843h, this.f295844i);
                cVar3.l(this);
                cVar3.A = this.U;
                view2 = cVar3.f295802m;
                if (view2 == null) {
                    view4 = null;
                    view3 = view2;
                } else {
                    view2.setTag(cVar3);
                    cVar = cVar3;
                }
            } else {
                Object tag = view.getTag();
                if (tag instanceof c) {
                    cVar2 = (c) tag;
                }
                view2 = view;
                cVar = cVar2;
            }
            this.C.put(nVar.f294915a, cVar);
            if (cVar != null) {
                cVar.f295803n = nVar;
                cVar.m(this.J);
                cVar.p(this.f295840d, this.f295841e);
                if (this.J && a(nVar)) {
                    z16 = true;
                }
                cVar.k(z16);
                cVar.q(this.f295840d, this.f295842f, this.f295841e, this.F);
            }
            view3 = view2;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }

    public void h(s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) sVar);
        } else {
            this.T = sVar;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1 && this.G) {
            this.F = false;
            e();
        }
        return true;
    }

    public void i(c.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) eVar);
        } else {
            this.S = eVar;
        }
    }

    public void j(boolean z16) {
        List<n> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
            return;
        }
        this.J = z16;
        if (!z16 && (list = this.L) != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    public void k(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.K = bVar;
        }
    }

    protected void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        b bVar = this.K;
        if (bVar != null) {
            bVar.Da(i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void m0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.R = i17;
            this.Q = ((i3 + i16) - 1) - 1;
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        TroopFileManager troopFileManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 == 0) {
            this.G = true;
            QLog.e(V, 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
            this.M.sendEmptyMessageDelayed(1, 1000L);
            if (this.Q == this.R - 2 && (troopFileManager = this.D) != null) {
                if (troopFileManager.H(this.N, this.P)) {
                    b bVar = this.K;
                    if (bVar != null) {
                        bVar.se(8);
                        return;
                    }
                    return;
                }
                this.K.se(7);
                if (TroopFileUtils.d(this.f295841e, this.f295842f, this.f295840d) != 0) {
                    this.D.J(this.N, this.P, null);
                    return;
                }
                return;
            }
            return;
        }
        this.G = false;
        this.F = true;
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void p1(n nVar) {
        Map<String, n> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) nVar);
            return;
        }
        int i3 = nVar.f294930p;
        if (i3 != 2 && i3 != 3) {
            int size = this.f295845m.size();
            n nVar2 = this.D.f301893e.get(nVar.f294929o);
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                if (this.f295845m.get(i16) != null && this.f295845m.get(i16).f294916b.equals(nVar.f294916b)) {
                    TroopFileManager.e eVar = this.D.f301895g.get(this.N + this.P);
                    if (eVar != null) {
                        if (eVar.f301924g != null && (map = eVar.f301925h) != null) {
                            map.remove(this.f295845m.get(i16).f294916b);
                            if (i16 < eVar.f301924g.size()) {
                                n remove = eVar.f301924g.remove(i16);
                                if (remove != null && remove.f294930p != 12 && nVar2 != null) {
                                    nVar2.C--;
                                }
                                if (remove != null && remove.f294930p != 12) {
                                    eVar.f301923f = null;
                                }
                                this.I = false;
                                d(eVar.f301924g, eVar.f301920c, 0, false);
                            } else {
                                QLog.e(V, 1, "<TroopFile> onDelete remove has err.index>size" + i16);
                            }
                        }
                    }
                }
                i16++;
            }
            if (nVar2 != null && "/".equals(this.N) && this.P == 0 && nVar2.B) {
                nVar2.j((int) NetConnInfoCenter.getServerTime());
                TroopFileManager.e eVar2 = this.D.f301895g.get(nVar2.f294929o + this.P);
                if (eVar2 != null) {
                    List<n> list = eVar2.f301924g;
                    if (list != null) {
                        list.remove(nVar2);
                        eVar2.f301924g.add(0, nVar2);
                    }
                    eVar2.f301923f = null;
                    d(eVar2.f301924g, eVar2.f301920c, 0, false);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void x0(n nVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) nVar, (Object) str);
            return;
        }
        if (nVar == null) {
            return;
        }
        if (this.N.equals("/")) {
            TroopFileManager.e eVar = this.D.f301895g.get("/" + this.P);
            if (eVar != null && eVar.f301924g != null) {
                n nVar2 = this.D.f301893e.get(str);
                if (nVar2 != null && nVar2.B) {
                    nVar2.C++;
                    nVar2.j((int) NetConnInfoCenter.getServerTime());
                    int size = this.f295845m.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        if (nVar2 == this.f295845m.get(i3)) {
                            eVar.f301924g.remove(i3);
                            break;
                        }
                        i3++;
                    }
                    eVar.f301924g.add(0, nVar2);
                    eVar.f301923f = null;
                    d(eVar.f301924g, eVar.f301920c, 0, false);
                }
            } else {
                return;
            }
        }
        if (this.N.equals(str)) {
            TroopFileManager.e eVar2 = this.D.f301895g.get(str + this.P);
            if (eVar2 != null && eVar2.f301924g != null) {
                boolean z16 = eVar2.f301920c;
                int size2 = this.f295845m.size();
                int i16 = 0;
                while (true) {
                    if (i16 < size2) {
                        if (!this.f295845m.get(i16).B && nVar.f() >= this.f295845m.get(i16).f()) {
                            eVar2.f301924g.add(i16, nVar);
                            eVar2.f301925h.put(nVar.f294916b, nVar);
                            d(eVar2.f301924g, eVar2.f301920c, 0, false);
                            break;
                        } else {
                            if (i16 == size2 - 1 && z16) {
                                eVar2.f301924g.add(nVar);
                                eVar2.f301925h.put(nVar.f294916b, nVar);
                                d(eVar2.f301924g, eVar2.f301920c, 0, false);
                            }
                            i16++;
                        }
                    } else {
                        break;
                    }
                }
                eVar2.f301923f = null;
            }
        }
    }
}
