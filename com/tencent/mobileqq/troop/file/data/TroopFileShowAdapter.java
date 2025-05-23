package com.tencent.mobileqq.troop.file.data;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.x;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.file.data.j;
import com.tencent.mobileqq.troop.file.widget.TroopFileListView;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.m;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileShowAdapter extends BaseAdapter implements com.tencent.mobileqq.troop.data.q, AbsListView.OnScrollListener, Handler.Callback, m.a, j.b {
    private final TroopFileManager C;
    private String H;
    private long I;
    private int L;
    private x M;

    /* renamed from: d, reason: collision with root package name */
    private final long f295445d;

    /* renamed from: e, reason: collision with root package name */
    private final c f295446e;

    /* renamed from: f, reason: collision with root package name */
    private final QQAppInterface f295447f;

    /* renamed from: h, reason: collision with root package name */
    private final TroopFileListView f295448h;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.mobileqq.troop.data.n> f295449i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Map<UUID, j> f295450m = new HashMap();
    private boolean D = false;
    private boolean E = false;
    public boolean F = false;
    private int J = 0;
    private int K = 0;
    private boolean N = false;
    private final List<com.tencent.mobileqq.troop.data.n> P = new ArrayList(20);
    private final Handler G = new Handler(this);

    public TroopFileShowAdapter(long j3, c cVar, QQAppInterface qQAppInterface, TroopFileListView troopFileListView, String str, long j16, int i3) {
        this.H = "";
        this.I = 0L;
        this.f295445d = j3;
        this.f295446e = cVar;
        this.H = str;
        this.I = j16;
        this.f295447f = qQAppInterface;
        this.f295448h = troopFileListView;
        this.C = TroopFileManager.F(qQAppInterface, j3);
        troopFileListView.setSlidingListener(this);
        this.L = i3;
    }

    private boolean b(com.tencent.mobileqq.troop.data.n nVar) {
        List<com.tencent.mobileqq.troop.data.n> list = this.P;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return this.P.contains(nVar);
    }

    private void d(boolean z16) {
        this.f295446e.loadingProgress(z16);
    }

    private void f() {
        j jVar;
        int lastVisiblePosition = this.f295448h.getLastVisiblePosition();
        for (int firstVisiblePosition = this.f295448h.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition - 1 && firstVisiblePosition < this.f295449i.size(); firstVisiblePosition++) {
            com.tencent.mobileqq.troop.data.n nVar = this.f295449i.get(firstVisiblePosition);
            if (nVar != null && (jVar = this.f295450m.get(nVar.f294915a)) != null) {
                jVar.K();
                jVar.N(this.f295445d, this.f295447f);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.file.data.j.b
    public void B0(boolean z16, com.tencent.mobileqq.troop.data.n nVar) {
        if (this.P == null) {
            return;
        }
        if (nVar == null) {
            QLog.i("TroopFileShowAdapter", 1, "onSelected. fileInfo is null.");
        }
        if (z16) {
            if (!this.P.contains(nVar)) {
                this.P.add(nVar);
            }
        } else {
            this.P.remove(nVar);
        }
        x xVar = this.M;
        if (xVar != null) {
            xVar.e0(z16);
            if (this.P.isEmpty()) {
                this.M.A0();
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void N0(List<com.tencent.mobileqq.troop.data.n> list, boolean z16, String str, long j3, ArrayList<Long> arrayList) {
        if (this.H.equals(str) && this.I == j3) {
            this.f295446e.V();
            d(false);
            if (list == null) {
                this.f295446e.f4(1);
                com.tencent.mobileqq.filemanager.util.d.e(R.string.eq8);
                if (this.f295449i.isEmpty()) {
                    this.f295446e.I3(1);
                    return;
                }
                return;
            }
            this.f295446e.f4(0);
            e(list, z16, false);
        }
    }

    public List<com.tencent.mobileqq.troop.data.n> c() {
        return this.P;
    }

    public void g(int i3) {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(this.f295446e.getActivity());
        this.C.P(i3, this.H, this.I, null);
        d(isNetworkAvailable);
        TroopFileManager.e eVar = this.C.f301895g.get(this.H + this.I);
        List<com.tencent.mobileqq.troop.data.n> list = eVar != null ? eVar.f301924g : null;
        if (list != null && !list.isEmpty()) {
            d(false);
            e(list, true, true);
        } else if (isNetworkAvailable) {
            this.f295446e.I3(0);
        } else {
            this.f295446e.I3(1);
            TroopFileUtils.F(this.f295447f, this.f295445d);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f295449i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f295449i.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        j jVar;
        com.tencent.mobileqq.troop.data.n nVar = this.f295449i.get(i3);
        if (nVar == null) {
            return null;
        }
        if (view == null) {
            jVar = new j(new k(this.f295446e.getActivity(), R.layout.ami, this.f295447f, this.f295445d, this.L, this.I), this.f295446e);
            jVar.I(this);
            view = jVar.f295471k;
            if (view == null) {
                return null;
            }
            view.setTag(jVar);
            String str = nVar.f294916b;
            if (str != null && str.contains("online_doc_folder_") && this.f295446e.getActivity().getString(R.string.bo7).equals(nVar.f294917c)) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportClickWithTroopType(this.f295447f, "0X8009935", String.valueOf(this.f295445d));
            }
        } else {
            Object tag = view.getTag();
            jVar = tag instanceof j ? (j) tag : null;
        }
        this.f295450m.put(nVar.f294915a, jVar);
        if (jVar != null) {
            jVar.f295472l = nVar;
            jVar.J(this.N);
            jVar.N(this.f295445d, this.f295447f);
            jVar.H(this.N && b(nVar));
            jVar.O(this.f295445d, this.f295446e.getActivity(), this.f295447f, this.D);
        }
        d.j(view.findViewById(R.id.f167025k20), nVar);
        return view;
    }

    public void h(x xVar) {
        this.M = xVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && this.E) {
            this.D = false;
            RollangleImageView.setSuspendLoad(false);
            f();
        }
        return true;
    }

    public void i(boolean z16) {
        List<com.tencent.mobileqq.troop.data.n> list;
        this.N = z16;
        if (!z16 && (list = this.P) != null) {
            list.clear();
        }
        notifyDataSetChanged();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.TroopFileShowAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                TroopFileShowAdapter.this.notifyDataSetChanged();
            }
        }, 1L);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.K = i17;
        this.J = ((i3 + i16) - 1) - 1;
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void p1(com.tencent.mobileqq.troop.data.n nVar) {
        int i3;
        Map<String, com.tencent.mobileqq.troop.data.n> map;
        if (nVar != null) {
            QLog.i("TroopFileShowAdapter", 1, "onDelete fileInfo=" + nVar);
        }
        if (nVar == null || (i3 = nVar.f294930p) == 2 || i3 == 3) {
            return;
        }
        int size = this.f295449i.size();
        com.tencent.mobileqq.troop.data.n nVar2 = this.C.f301893e.get(nVar.f294929o);
        int i16 = 0;
        while (true) {
            if (i16 >= size) {
                break;
            }
            if (this.f295449i.get(i16) != null && this.f295449i.get(i16).f294916b.equals(nVar.f294916b)) {
                TroopFileManager.e eVar = this.C.f301895g.get(this.H + this.I);
                if (eVar != null) {
                    if (eVar.f301924g != null && (map = eVar.f301925h) != null) {
                        map.remove(this.f295449i.get(i16).f294916b);
                        if (i16 < eVar.f301924g.size()) {
                            com.tencent.mobileqq.troop.data.n remove = eVar.f301924g.remove(i16);
                            if (remove != null && remove.f294930p != 12 && nVar2 != null) {
                                nVar2.C--;
                            }
                            if (remove != null && remove.f294930p != 12) {
                                eVar.f301923f = null;
                            }
                            e(eVar.f301924g, eVar.f301920c, false);
                        } else {
                            QLog.e("TroopFileShowAdapter", 1, "<TroopFile> onDelete remove has err.index>size" + i16);
                        }
                    }
                }
            }
            i16++;
        }
        if (nVar2 != null && "/".equals(this.H) && this.I == 0 && nVar2.B) {
            nVar2.j((int) NetConnInfoCenter.getServerTime());
            TroopFileManager.e eVar2 = this.C.f301895g.get(nVar2.f294929o + this.I);
            if (eVar2 != null) {
                List<com.tencent.mobileqq.troop.data.n> list = eVar2.f301924g;
                if (list != null) {
                    list.remove(nVar2);
                    eVar2.f301924g.add(0, nVar2);
                }
                eVar2.f301923f = null;
                e(eVar2.f301924g, eVar2.f301920c, false);
            }
        }
    }

    private void e(List<com.tencent.mobileqq.troop.data.n> list, boolean z16, boolean z17) {
        boolean z18 = false;
        if (!z17) {
            d(false);
        }
        if (list == null) {
            return;
        }
        this.f295450m.clear();
        this.f295449i.clear();
        this.f295449i.addAll(list);
        if (list.size() == 0) {
            if ("/".equals(this.H)) {
                this.f295446e.I3(3);
                return;
            } else {
                this.f295446e.I3(6);
                return;
            }
        }
        notifyDataSetChanged();
        if (this.f295449i.size() - 1 > this.f295448h.getLastVisiblePosition()) {
            TroopFileListView troopFileListView = this.f295448h;
            final c cVar = this.f295446e;
            Objects.requireNonNull(cVar);
            troopFileListView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.file.data.q
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.P2();
                }
            });
        }
        this.f295446e.I3(4);
        this.f295446e.u0();
        if (z16 && this.C.H(this.H, this.I)) {
            this.f295446e.L7(8);
        }
        if (this.f295449i.size() > 0) {
            Iterator<com.tencent.mobileqq.troop.data.n> it = this.f295449i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.troop.data.n next = it.next();
                if (!TextUtils.isEmpty(next.f294916b) && next.f294916b.contains("online_doc_folder_")) {
                    z18 = true;
                    break;
                }
            }
            this.f295446e.I5(z18);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void D1(com.tencent.mobileqq.troop.data.n nVar) {
        if (nVar != null) {
            QLog.i("TroopFileShowAdapter", 1, "onFinishUpload fileInfo=" + nVar);
        }
        if (nVar != null && nVar.A && nVar.f294930p == 6) {
            this.f295446e.q8();
            com.tencent.mobileqq.troop.data.n nVar2 = this.C.f301893e.get(nVar.f294929o);
            if (nVar2 != null && this.H.equals(nVar2.f294929o) && nVar2.B) {
                TroopFileManager.e eVar = this.C.f301895g.get(nVar2.f294929o + this.I);
                if (eVar == null || eVar.f301924g == null) {
                    return;
                }
                if (TextUtils.isEmpty(nVar.g())) {
                    if (nVar.f294920f == 0) {
                        QQAppInterface qQAppInterface = this.f295447f;
                        nVar.f294928n = ac.s(qQAppInterface, qQAppInterface.getCurrentAccountUin(), this.f295445d + "", 1, 0);
                    } else {
                        nVar.r(this.f295447f, this.f295445d);
                    }
                }
                eVar.f301924g.remove(nVar2);
                nVar2.j(nVar.f());
                nVar2.C++;
                eVar.f301924g.add(0, nVar2);
                e(eVar.f301924g, eVar.f301920c, false);
                eVar.f301923f = null;
            }
            if (this.H.equals(nVar.f294929o)) {
                TroopFileManager.e eVar2 = this.C.f301895g.get(nVar.f294929o + this.I);
                if (eVar2 == null || eVar2.f301924g == null) {
                    return;
                }
                boolean z16 = eVar2.f301920c;
                int size = this.f295449i.size();
                if (TextUtils.isEmpty(nVar.g())) {
                    if (nVar.f294920f == 0) {
                        QQAppInterface qQAppInterface2 = this.f295447f;
                        nVar.f294928n = ac.s(qQAppInterface2, qQAppInterface2.getCurrentAccountUin(), this.f295445d + "", 1, 0);
                    } else {
                        nVar.r(this.f295447f, this.f295445d);
                    }
                }
                if (this.f295449i.size() == 0) {
                    eVar2.f301924g.add(nVar);
                    eVar2.f301925h.put(nVar.f294916b, nVar);
                }
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        if (!this.f295449i.get(i3).B && nVar.f() >= this.f295449i.get(i3).f()) {
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
                e(eVar2.f301924g, eVar2.f301920c, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void I0(com.tencent.mobileqq.troop.data.n nVar) {
        j jVar;
        if (nVar == null) {
            return;
        }
        int i3 = nVar.f294930p;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            this.f295446e.q8();
            return;
        }
        if (i3 != 12) {
            if (this.H.equals(nVar.f294929o) || this.I != 0) {
                j jVar2 = this.f295450m.get(nVar.f294915a);
                if (jVar2 != null && jVar2.f295472l.f294915a.equals(nVar.f294915a)) {
                    jVar2.f295472l = nVar;
                    jVar2.O(this.f295445d, this.f295446e.getActivity(), this.f295447f, this.D);
                    int size = this.f295449i.size();
                    int i16 = 0;
                    while (true) {
                        if (i16 < size) {
                            com.tencent.mobileqq.troop.data.n nVar2 = this.f295449i.get(i16);
                            if (nVar2 != null && nVar.f294915a.equals(nVar2.f294915a)) {
                                this.f295449i.set(i16, nVar);
                                break;
                            }
                            i16++;
                        } else {
                            break;
                        }
                    }
                } else {
                    return;
                }
            }
            com.tencent.mobileqq.troop.data.n nVar3 = this.C.f301893e.get(nVar.f294929o);
            if (nVar3 == null || (jVar = this.f295450m.get(nVar3.f294915a)) == null) {
                return;
            }
            jVar.O(this.f295445d, this.f295446e.getActivity(), this.f295447f, this.D);
            return;
        }
        this.f295446e.q8();
        if (this.f295450m.remove(nVar.f294915a) != null) {
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        if (r2.f294916b.contains("online_doc_folder_") != false) goto L26;
     */
    @Override // com.tencent.mobileqq.troop.data.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X0(com.tencent.mobileqq.troop.data.n nVar) {
        int i3 = 1;
        if (nVar != null) {
            QLog.i("TroopFileShowAdapter", 1, "onCreateFolder fileInfo=" + nVar);
        }
        if (nVar != null && nVar.B && "/".equals(this.H) && this.I == 0) {
            UUID randomUUID = UUID.randomUUID();
            nVar.f294915a = randomUUID;
            this.C.f301892d.put(randomUUID, nVar);
            this.C.f301893e.put(nVar.f294916b, nVar);
            TroopFileManager.e eVar = this.C.f301895g.get(this.H + this.I);
            if (eVar != null) {
                List<com.tencent.mobileqq.troop.data.n> list = eVar.f301924g;
                if (list != null && eVar.f301925h != null) {
                    if (list.size() > 0) {
                        com.tencent.mobileqq.troop.data.n nVar2 = eVar.f301924g.get(0);
                        if (!TextUtils.isEmpty(nVar2.f294916b)) {
                        }
                    }
                    i3 = 0;
                    eVar.f301924g.add(i3, nVar);
                    eVar.f301925h.put(nVar.f294916b, nVar);
                }
                this.C.f301893e.put(nVar.f294916b, nVar);
                e(eVar.f301924g, eVar.f301920c, false);
                eVar.f301923f = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.m.a
    public void a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.k28);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            QQAppInterface qQAppInterface = this.f295447f;
            String str2 = this.f295445d + "";
            if ("/".equals(this.H)) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(qQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_item", 0, 0, str2, str, "", "");
        }
        View findViewById2 = view.findViewById(R.id.k29);
        if (findViewById2 == null || findViewById2.getVisibility() != 0) {
            return;
        }
        ReportController.o(this.f295447f, "P_CliOper", "Grp_files", "", "file", "rename_item", 0, 0, this.f295445d + "", "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void x0(com.tencent.mobileqq.troop.data.n nVar, String str) {
        if (nVar == null) {
            return;
        }
        QLog.i("TroopFileShowAdapter", 1, "onMove fileInfo=" + nVar + ", targetParentId=" + str);
        if (this.H.equals("/")) {
            TroopFileManager.e eVar = this.C.f301895g.get("/" + this.I);
            if (eVar == null || eVar.f301924g == null) {
                return;
            }
            com.tencent.mobileqq.troop.data.n nVar2 = this.C.f301893e.get(str);
            if (nVar2 != null && nVar2.B) {
                nVar2.C++;
                nVar2.j((int) NetConnInfoCenter.getServerTime());
                int size = this.f295449i.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (nVar2 == this.f295449i.get(i3)) {
                        eVar.f301924g.remove(i3);
                        break;
                    }
                    i3++;
                }
                eVar.f301924g.add(0, nVar2);
                eVar.f301923f = null;
                e(eVar.f301924g, eVar.f301920c, false);
            }
        }
        if (this.H.equals(str)) {
            TroopFileManager.e eVar2 = this.C.f301895g.get(str + this.I);
            if (eVar2 == null || eVar2.f301924g == null) {
                return;
            }
            boolean z16 = eVar2.f301920c;
            int size2 = this.f295449i.size();
            int i16 = 0;
            while (true) {
                if (i16 < size2) {
                    if (!this.f295449i.get(i16).B && nVar.f() >= this.f295449i.get(i16).f()) {
                        eVar2.f301924g.add(i16, nVar);
                        eVar2.f301925h.put(nVar.f294916b, nVar);
                        e(eVar2.f301924g, eVar2.f301920c, false);
                        break;
                    } else {
                        if (i16 == size2 - 1 && z16) {
                            eVar2.f301924g.add(nVar);
                            eVar2.f301925h.put(nVar.f294916b, nVar);
                            e(eVar2.f301924g, eVar2.f301920c, false);
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

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        TroopFileManager troopFileManager;
        if (i3 == 0) {
            this.E = true;
            QLog.e("TroopFileShowAdapter", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
            this.G.sendEmptyMessageDelayed(1, 1000L);
            if (this.J != this.K - 2 || (troopFileManager = this.C) == null) {
                return;
            }
            if (troopFileManager.H(this.H, this.I)) {
                this.f295446e.Z2(true);
                return;
            }
            this.f295446e.Z2(false);
            if (TroopFileUtils.d(this.f295447f, this.f295446e.getActivity(), this.f295445d) != 0) {
                this.C.J(this.H, this.I, null);
                return;
            }
            return;
        }
        this.E = false;
        RollangleImageView.setSuspendLoad(true);
        this.D = true;
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void B1(com.tencent.mobileqq.troop.data.n nVar) {
    }

    @Override // com.tencent.mobileqq.troop.widget.m.a
    public void interceptTouchEvent(boolean z16) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void m0(int i3) {
    }
}
