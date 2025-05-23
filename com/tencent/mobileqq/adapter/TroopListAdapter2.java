package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopListAdapter2 extends j {
    static IPatchRedirector $redirector_;
    Activity F;
    d G;
    QQAppInterface H;
    SlideDetectListView I;
    int J;
    public int K;
    public int L;
    public int M;
    public int N;
    protected LayoutInflater P;
    protected List<com.tencent.mobileqq.troop.adapter.contact.c> Q;
    protected List<TroopInfo> R;
    protected TroopManager S;
    protected boolean T;
    public boolean U;
    protected com.tencent.mobileqq.app.n V;
    protected boolean W;
    private final HashMap<Integer, Boolean> X;
    protected View.OnClickListener Y;
    protected View.OnClickListener Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f187067d;

        a(int i3) {
            this.f187067d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListAdapter2.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopListAdapter2.this.X.put(Integer.valueOf(this.f187067d), Boolean.valueOf(!Boolean.TRUE.equals(TroopListAdapter2.this.X.get(Integer.valueOf(this.f187067d)))));
                TroopListAdapter2.this.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListAdapter2.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(Boolean bool) {
            if (bool.booleanValue()) {
                TroopListAdapter2.this.notifyDataSetChanged();
                return null;
            }
            return null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LifecycleOwner lifecycleOwner;
            String str;
            String str2;
            String str3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopListAdapter2.this.I.j0();
                View view2 = (View) view.getParent();
                if (view2 instanceof ShaderAnimLayout) {
                    ((ShaderAnimLayout) view2).b();
                }
                Object tag = view.getTag();
                if (tag instanceof TroopInfo) {
                    TroopInfo troopInfo = (TroopInfo) tag;
                    boolean z16 = troopInfo.isTop;
                    ComponentCallbacks2 componentCallbacks2 = TroopListAdapter2.this.F;
                    if (componentCallbacks2 instanceof QBaseActivity) {
                        lifecycleOwner = (LifecycleOwner) componentCallbacks2;
                    } else {
                        lifecycleOwner = null;
                    }
                    ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).requestSetTroopTop(lifecycleOwner, troopInfo.troopuin, z16, true, new Function1() { // from class: com.tencent.mobileqq.adapter.ak
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit b16;
                            b16 = TroopListAdapter2.b.this.b((Boolean) obj);
                            return b16;
                        }
                    });
                    if (z16) {
                        str = "Clk_uncommgrp";
                    } else {
                        str = "Clk_setcommgrp";
                    }
                    ReportController.o(TroopListAdapter2.this.H, "P_CliOper", "Grp_set", "", "Grp_contactlist", str, 0, 0, troopInfo.troopuin, "", "", "");
                    com.tencent.mobileqq.statistics.q f16 = new com.tencent.mobileqq.statistics.q(TroopListAdapter2.this.H).i("dc00899").a("Grp_set").f("Grp_contactlist");
                    if (z16) {
                        str2 = "Clk_unstick";
                    } else {
                        str2 = "Clk_stick";
                    }
                    com.tencent.mobileqq.statistics.q d16 = f16.d(str2);
                    String[] strArr = new String[2];
                    strArr[0] = troopInfo.troopuin;
                    if (troopInfo.hasSetTroopHead()) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    strArr[1] = str3;
                    d16.b(strArr).g();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListAdapter2.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DiscussionInfo discussionInfo;
            TroopInfo troopInfo;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof e) {
                    e eVar = (e) tag;
                    com.tencent.mobileqq.troop.adapter.contact.c cVar = eVar.H;
                    if (cVar != null && (troopInfo = cVar.f293805b) != null) {
                        TroopListAdapter2.this.G.b(troopInfo, cVar.f293804a);
                    }
                    com.tencent.mobileqq.troop.adapter.contact.c cVar2 = eVar.H;
                    if (cVar2 != null && (discussionInfo = cVar2.f293806c) != null) {
                        TroopListAdapter2.this.G.a(discussionInfo);
                    }
                    new com.tencent.mobileqq.statistics.q(TroopListAdapter2.this.H).i("dc00899").a("Grp_listNew").f("send_to").d("clk_grp").b("1").g();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a(DiscussionInfo discussionInfo);

        void b(TroopInfo troopInfo, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e extends k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public TextView D;
        public RelativeLayout E;
        public TextView F;
        public ImageView G;
        public com.tencent.mobileqq.troop.adapter.contact.c H;
        public Switch I;
        public View J;
        public TextView K;
        public TextView L;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f187071i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f187072m;

        public e(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f187213h = (QQProAvatarView) view.findViewById(R.id.icon);
            this.f187072m = (ImageView) view.findViewById(R.id.enc);
            this.f187071i = (ImageView) view.findViewById(R.id.j1v);
            this.E = (RelativeLayout) view.findViewById(R.id.iea);
            this.C = (TextView) view.findViewById(R.id.text1);
            this.D = (TextView) view.findViewById(R.id.text2);
            TextView textView = (TextView) view.findViewById(R.id.f166334f21);
            this.F = textView;
            textView.setVisibility(8);
            this.G = (ImageView) view.findViewById(R.id.jxg);
            this.f187213h.setClickable(false);
            this.I = (Switch) view.findViewById(R.id.gje);
            this.J = view.findViewById(R.id.jzo);
            this.K = (TextView) view.findViewById(R.id.k1f);
            this.L = (TextView) view.findViewById(R.id.k1e);
        }
    }

    public TroopListAdapter2(Activity activity, QQAppInterface qQAppInterface, d dVar, XListView xListView, int i3, boolean z16) {
        super(activity, qQAppInterface, xListView, 4, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, qQAppInterface, dVar, xListView, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.J = 0;
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.T = false;
        this.U = true;
        this.W = true;
        this.X = new HashMap<>();
        this.Y = new b();
        this.Z = new c();
        this.H = qQAppInterface;
        this.G = dVar;
        this.F = activity;
        this.J = i3;
        this.I = (SlideDetectListView) xListView;
        this.P = LayoutInflater.from(activity);
        this.W = z16;
        this.S = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        this.V = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    }

    private void l(int i3, e eVar) {
        if (i3 != 2 && i3 != 4 && i3 != 6 && i3 != 10) {
            return;
        }
        eVar.E.setOnClickListener(new a(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.troop.adapter.contact.c> m() {
        ArrayList arrayList = new ArrayList();
        this.R = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedValidTroopInfoFromCache();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (TroopInfo troopInfo : this.R) {
            int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo.troopuin);
            if (troopInfo.isQidianPrivateTroop()) {
                arrayList5.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
            } else if (troopInfo.isOwner()) {
                arrayList2.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
            } else if (troopInfo.isAdmin()) {
                arrayList3.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
            } else {
                arrayList4.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
            }
        }
        RecentUserProxy m3 = this.H.getProxyManager().m();
        ArrayList<DiscussionInfo> k3 = ((com.tencent.mobileqq.app.n) this.H.getManager(QQManagerFactory.DISCUSSION_MANAGER)).k();
        if (this.W) {
            for (DiscussionInfo discussionInfo : k3) {
                discussionInfo.lastMsgTime = m3.findRecentUserByUin(discussionInfo.uin, 3000).lastmsgtime;
                if (this.H.getCurrentUin().equals(discussionInfo.ownerUin)) {
                    arrayList2.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
                } else {
                    arrayList4.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
                }
            }
        }
        if (this.J == 2) {
            arrayList4.clear();
            arrayList5.clear();
        }
        this.K = arrayList2.size();
        this.M = arrayList4.size();
        com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
        Collections.sort(arrayList2, bVar);
        Collections.sort(arrayList3, bVar);
        Collections.sort(arrayList4, bVar);
        Collections.sort(arrayList5, bVar);
        if (this.K > 0) {
            arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(4, null));
            if (Boolean.TRUE.equals(this.X.get(4))) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Object obj = ((com.tencent.mobileqq.troop.adapter.contact.d) it.next()).f293809b;
                    if (obj instanceof TroopInfo) {
                        arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(5, obj));
                    } else if (obj instanceof DiscussionInfo) {
                        DiscussionInfo discussionInfo2 = (DiscussionInfo) obj;
                        arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(5, discussionInfo2, this.V.q(discussionInfo2.uin)));
                    }
                }
            }
        }
        int size = arrayList3.size();
        this.L = size;
        if (size > 0) {
            arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(6, null));
            if (Boolean.TRUE.equals(this.X.get(6))) {
                Iterator it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(7, ((com.tencent.mobileqq.troop.adapter.contact.d) it5.next()).f293809b));
                }
            }
        }
        if (this.M > 0) {
            arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(2, null));
            if (Boolean.TRUE.equals(this.X.get(2))) {
                Iterator it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    Object obj2 = ((com.tencent.mobileqq.troop.adapter.contact.d) it6.next()).f293809b;
                    if (obj2 instanceof TroopInfo) {
                        arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(3, obj2));
                    } else if (obj2 instanceof DiscussionInfo) {
                        DiscussionInfo discussionInfo3 = (DiscussionInfo) obj2;
                        arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(3, discussionInfo3, this.V.q(discussionInfo3.uin)));
                    }
                }
            }
        }
        int size2 = arrayList5.size();
        this.N = size2;
        if (size2 > 0) {
            arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(10, null));
            if (Boolean.TRUE.equals(this.X.get(10))) {
                Iterator it7 = arrayList5.iterator();
                while (it7.hasNext()) {
                    arrayList.add(new com.tencent.mobileqq.troop.adapter.contact.c(11, ((com.tencent.mobileqq.troop.adapter.contact.d) it7.next()).f293809b));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.Q.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.Q.get(i3);
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    @TargetApi(16)
    public View getView(int i3, View view, ViewGroup viewGroup) {
        e eVar;
        View view2;
        String str;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view3 = view;
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            this.T = true;
            com.tencent.mobileqq.troop.adapter.contact.c cVar = (com.tencent.mobileqq.troop.adapter.contact.c) getItem(i3);
            if (view == null) {
                view2 = this.P.inflate(R.layout.a1x, viewGroup, false);
                eVar = new e(view2);
                view2.setTag(eVar);
                ((Button) view2.findViewById(R.id.jxm)).setOnClickListener(this.Y);
                view2.setOnClickListener(this.Z);
            } else {
                eVar = (e) view.getTag();
                view2 = view;
            }
            eVar.H = cVar;
            l(cVar.f293804a, eVar);
            int i16 = cVar.f293804a;
            if (i16 == 2) {
                eVar.J.setVisibility(8);
                eVar.E.setVisibility(0);
                eVar.K.setText(HardCodeUtil.qqStr(R.string.urw));
                eVar.L.setText(String.valueOf(this.M));
            } else if (i16 == 4) {
                eVar.J.setVisibility(8);
                eVar.E.setVisibility(0);
                eVar.K.setText(HardCodeUtil.qqStr(R.string.f172862us0));
                eVar.L.setText(String.valueOf(this.K));
            } else if (i16 == 6) {
                eVar.J.setVisibility(8);
                eVar.E.setVisibility(0);
                eVar.K.setText(HardCodeUtil.qqStr(R.string.f172863us3));
                eVar.L.setText(String.valueOf(this.L));
            } else if (i16 == 10) {
                eVar.J.setVisibility(8);
                eVar.E.setVisibility(0);
                eVar.K.setText(HardCodeUtil.qqStr(R.string.l3x));
                eVar.L.setText(String.valueOf(this.N));
            } else if (cVar.f293805b != null) {
                eVar.J.setVisibility(0);
                eVar.E.setVisibility(8);
                TroopInfo troopInfo = cVar.f293805b;
                String str2 = troopInfo.troopuin;
                eVar.f187210d = str2;
                if (this.H.getTroopMask(str2) != GroupMsgMask.SHIELD) {
                    eVar.f187071i.setVisibility(4);
                } else {
                    eVar.f187071i.setVisibility(0);
                    eVar.f187071i.setImageResource(R.drawable.h2e);
                }
                TextView textView = eVar.C;
                if (!TextUtils.isEmpty(troopInfo.getTroopDisplayName())) {
                    str = troopInfo.getTroopDisplayName();
                } else {
                    str = troopInfo.troopuin;
                }
                textView.setText(str);
                eVar.f187213h.x(4, troopInfo.troopuin, null);
                if (!troopInfo.hasSetTroopName() && troopInfo.getMemberNumClient() > 0) {
                    eVar.D.setVisibility(0);
                    eVar.D.setText(String.format("(%d)", Integer.valueOf(troopInfo.getMemberNumClient())));
                } else {
                    eVar.D.setVisibility(8);
                }
                if ((troopInfo.dwGroupFlagExt & 2048) != 0) {
                    long j3 = troopInfo.dwAuthGroupType;
                    if (j3 == 2) {
                        eVar.G.setVisibility(0);
                        eVar.G.setBackgroundResource(R.drawable.e5d);
                    } else if (j3 == 1) {
                        eVar.G.setVisibility(0);
                        eVar.G.setBackgroundResource(R.drawable.e5d);
                    } else {
                        eVar.G.setVisibility(8);
                    }
                } else {
                    eVar.G.setVisibility(8);
                }
                long j16 = troopInfo.troopCreditLevel;
                if (j16 == 2) {
                    eVar.f187072m.setVisibility(0);
                    eVar.f187071i.setVisibility(0);
                    eVar.f187071i.setImageResource(R.drawable.h2h);
                } else if (j16 == 1) {
                    eVar.f187072m.setVisibility(0);
                    eVar.f187071i.setVisibility(0);
                    eVar.f187071i.setImageResource(R.drawable.h2f);
                } else {
                    eVar.f187072m.setVisibility(4);
                }
            } else if (cVar.f293806c != null) {
                eVar.J.setVisibility(0);
                eVar.E.setVisibility(8);
                DiscussionInfo discussionInfo = cVar.f293806c;
                eVar.f187210d = discussionInfo.uin;
                eVar.f187071i.setVisibility(4);
                eVar.C.setText(com.tencent.mobileqq.utils.ac.o(this.F, discussionInfo));
                if (!discussionInfo.hasRenamed()) {
                    eVar.D.setVisibility(0);
                    eVar.D.setText(String.format("(%d)", Integer.valueOf(cVar.f293807d)));
                }
                eVar.f187213h.x(101, discussionInfo.uin, null);
            }
            this.T = false;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public TroopInfo k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.Q.size()) {
            return this.Q.get(i3).f293805b;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.adapter.TroopListAdapter2.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopListAdapter2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ThreadManager.getUIHandler().post(new Runnable(TroopListAdapter2.this.m()) { // from class: com.tencent.mobileqq.adapter.TroopListAdapter2.2.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f187065d;

                            {
                                this.f187065d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                TroopListAdapter2.this.Q.clear();
                                TroopListAdapter2.this.Q.addAll(this.f187065d);
                                TroopListAdapter2.super.notifyDataSetChanged();
                            }
                        });
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 8, null, true);
        }
    }
}
