package com.tencent.mobileqq.selectmember;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.adapter.c;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopListAdapter extends com.tencent.mobileqq.selectmember.adapter.c {
    static IPatchRedirector $redirector_;
    protected List<b> E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    protected LayoutInflater K;
    protected QBaseActivity L;
    AppInterface M;
    protected XListView N;
    protected View.OnClickListener P;
    private int Q;
    private int R;
    private int S;
    com.tencent.mobileqq.troop.api.observer.a T;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            Bitmap faceBitmap = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getFaceBitmap(TroopListAdapter.this.M, 113, str, false, 0);
            if (faceBitmap != null) {
                TroopListAdapter.this.e(str, faceBitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends c.a {
        static IPatchRedirector $redirector_;
        public DiscussionInfo C;
        public int D;
        public ImageView E;
        public ImageView F;

        /* renamed from: h, reason: collision with root package name */
        public TextView f285877h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f285878i;

        /* renamed from: m, reason: collision with root package name */
        public TroopInfo f285879m;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListAdapter.this);
            }
        }
    }

    public TroopListAdapter(QBaseActivity qBaseActivity, AppInterface appInterface, XListView xListView, int i3, boolean z16, View.OnClickListener onClickListener) {
        super(qBaseActivity, appInterface, xListView, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qBaseActivity, appInterface, xListView, Integer.valueOf(i3), Boolean.valueOf(z16), onClickListener);
            return;
        }
        this.E = new ArrayList();
        this.T = new a();
        this.L = qBaseActivity;
        this.M = appInterface;
        this.K = LayoutInflater.from(qBaseActivity);
        this.N = xListView;
        this.P = onClickListener;
        this.R = qBaseActivity.getResources().getColor(R.color.skin_black);
        this.S = Color.parseColor("#808080");
        appInterface.addObserver(this.T);
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.M.removeObserver(this.T);
            super.a();
        }
    }

    public void g(List<String> list) {
        List<String> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list.size() > 50) {
            List<String> subList = list.subList(0, 49);
            list2 = list.subList(50, list.size());
            list = subList;
        } else {
            list2 = null;
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopCreateTroopPrivilegeFlag(list, "TroopListAdapter", this.L, new Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>(list2) { // from class: com.tencent.mobileqq.selectmember.TroopListAdapter.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f285868d;

            {
                this.f285868d = list2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopListAdapter.this, (Object) list2);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool, Integer num, String str, List<? extends TroopInfo> list3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, this, bool, num, str, list3);
                }
                if (bool.booleanValue()) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.TroopListAdapter.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                TroopListAdapter.this.notifyDataSetChanged();
                            }
                        }
                    });
                    return null;
                }
                List<String> list4 = this.f285868d;
                if (list4 != null) {
                    TroopListAdapter.this.g(list4);
                    return null;
                }
                return null;
            }
        });
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        List<b> list = this.E;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        List<b> list = this.E;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.E.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    @TargetApi(16)
    public View getView(int i3, View view, ViewGroup viewGroup) {
        c cVar;
        String str;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            b bVar = (b) getItem(i3);
            if (bVar != null) {
                if (view != null && view.getTag() != null) {
                    cVar = (c) view.getTag();
                } else {
                    view = this.K.inflate(R.layout.byl, (ViewGroup) this.N, false);
                    cVar = new c();
                    cVar.f285950f = (ImageView) view.findViewById(R.id.c0o);
                    cVar.E = (ImageView) view.findViewById(R.id.c1c);
                    cVar.f285877h = (TextView) view.findViewById(R.id.k0i);
                    cVar.f285878i = (TextView) view.findViewById(R.id.k08);
                    cVar.F = (ImageView) view.findViewById(R.id.f164472yw);
                    view.setTag(cVar);
                }
                View findViewById = view.findViewById(R.id.jzo);
                TextView textView = (TextView) view.findViewById(R.id.k1f);
                int i16 = bVar.f285872a;
                if (i16 == 0) {
                    findViewById.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.L.getString(R.string.dsw, String.valueOf(this.I)));
                } else if (i16 == 2) {
                    findViewById.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.L.getString(R.string.dt7, String.valueOf(this.H)));
                } else if (i16 == 4) {
                    findViewById.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.L.getString(R.string.f171286dr4, String.valueOf(this.F)));
                } else if (i16 == 6) {
                    findViewById.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.L.getString(R.string.ds6, String.valueOf(this.G)));
                } else if (i16 == 8) {
                    findViewById.setVisibility(8);
                    textView.setVisibility(0);
                    textView.setText(this.L.getString(R.string.dvq, String.valueOf(this.J)));
                } else if (bVar.f285873b != null) {
                    findViewById.setVisibility(0);
                    textView.setVisibility(8);
                    TroopInfo troopInfo = bVar.f285873b;
                    cVar.f285948d = troopInfo.troopuin;
                    TextView textView2 = cVar.f285877h;
                    if (troopInfo.getTroopDisplayName() != null) {
                        str = troopInfo.getTroopDisplayName();
                    } else {
                        str = troopInfo.troopcode;
                    }
                    textView2.setText(str);
                    cVar.f285950f.setImageBitmap(c(4, troopInfo.troopuin));
                    cVar.f285879m = troopInfo;
                    cVar.C = null;
                    cVar.D = bVar.f285872a;
                    if (!troopInfo.hasSetTroopName() && troopInfo.getMemberNumClient() > 0) {
                        cVar.f285878i.setVisibility(0);
                        cVar.f285878i.setText(String.format("(%d)", Integer.valueOf(troopInfo.getMemberNumClient())));
                    } else {
                        cVar.f285878i.setVisibility(8);
                    }
                    if (!troopInfo.isAllowCreateDiscuss() && !troopInfo.isTroopOwner(this.M.getCurrentAccountUin()) && !troopInfo.isTroopAdmin(this.M.getCurrentAccountUin())) {
                        findViewById.setEnabled(false);
                        cVar.E.setVisibility(0);
                        cVar.F.setVisibility(8);
                        cVar.f285877h.setTextColor(this.S);
                    } else {
                        cVar.E.setVisibility(8);
                        cVar.F.setVisibility(0);
                        cVar.f285877h.setTextColor(this.R);
                    }
                    view.setOnClickListener(this.P);
                } else if (bVar.f285874c != null) {
                    findViewById.setVisibility(0);
                    textView.setVisibility(8);
                    DiscussionInfo discussionInfo = bVar.f285874c;
                    cVar.f285948d = discussionInfo.uin;
                    cVar.f285877h.setText(com.tencent.mobileqq.selectmember.util.a.e(this.L, discussionInfo));
                    cVar.f285950f.setImageBitmap(c(101, discussionInfo.uin));
                    if (!discussionInfo.hasRenamed()) {
                        cVar.f285878i.setVisibility(0);
                        cVar.f285878i.setText(String.format("(%d)", Integer.valueOf(((IDiscussionService) this.M.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin))));
                    }
                    cVar.C = discussionInfo;
                    cVar.f285879m = null;
                    cVar.D = bVar.f285872a;
                    cVar.E.setVisibility(8);
                    cVar.F.setVisibility(0);
                    cVar.f285877h.setTextColor(this.R);
                    view.setOnClickListener(this.P);
                }
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    public void h(AppInterface appInterface, List<TroopInfo> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) list);
            return;
        }
        this.E.clear();
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        for (TroopInfo troopInfo : ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTopTroopInfoFromCache()) {
            if (troopInfo != null && !troopInfo.isQidianPrivateTroop()) {
                arrayList.add(troopInfo);
            }
        }
        this.I = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (TroopInfo troopInfo2 : list) {
            if (!troopInfo2.isQidianPrivateTroop()) {
                int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo2.troopuin);
                if (troopInfo2.isOwner()) {
                    arrayList2.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo2));
                } else if (troopInfo2.isAdmin()) {
                    arrayList3.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo2));
                } else {
                    arrayList4.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo2));
                }
                if (!troopInfo2.hasSetTroopName()) {
                    arrayList5.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo2));
                }
            }
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        for (DiscussionInfo discussionInfo : (ArrayList) ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList()) {
            RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(discussionInfo.uin, 3000);
            String str3 = str2;
            discussionInfo.lastMsgTime = findRecentUserByUin.lastmsgtime;
            if (findRecentUserByUin.showUpTime != 0) {
                arrayList.add(discussionInfo);
            }
            if (appInterface.getCurrentUin().equals(discussionInfo.ownerUin)) {
                arrayList2.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
            } else {
                arrayList4.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
            }
            if (!discussionInfo.hasRenamed()) {
                arrayList5.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo));
            }
            str2 = str3;
        }
        String str4 = str2;
        this.I = arrayList.size();
        this.F = arrayList2.size();
        this.H = arrayList4.size();
        this.J = arrayList5.size();
        com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
        Collections.sort(arrayList2, bVar);
        Collections.sort(arrayList3, bVar);
        Collections.sort(arrayList4, bVar);
        Collections.sort(arrayList5, bVar);
        if (this.I > 0) {
            this.E.add(new b(0, null));
            for (Object obj : arrayList) {
                if (obj instanceof TroopInfo) {
                    this.E.add(new b(1, obj));
                } else if (obj instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo2 = (DiscussionInfo) obj;
                    str = str4;
                    this.E.add(new b(1, discussionInfo2, ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, str)).getDiscussionMemberNum(discussionInfo2.uin)));
                    str4 = str;
                }
                str = str4;
                str4 = str;
            }
        }
        String str5 = str4;
        if (this.J > 0) {
            this.E.add(new b(8, null));
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                Object obj2 = ((com.tencent.mobileqq.troop.adapter.contact.d) it.next()).f293809b;
                if (obj2 instanceof TroopInfo) {
                    this.E.add(new b(3, obj2));
                } else if (obj2 instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo3 = (DiscussionInfo) obj2;
                    this.E.add(new b(3, discussionInfo3, ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, str5)).getDiscussionMemberNum(discussionInfo3.uin)));
                }
            }
        }
        if (this.F > 0) {
            this.E.add(new b(4, null));
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                Object obj3 = ((com.tencent.mobileqq.troop.adapter.contact.d) it5.next()).f293809b;
                if (obj3 instanceof TroopInfo) {
                    this.E.add(new b(5, obj3));
                } else if (obj3 instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo4 = (DiscussionInfo) obj3;
                    this.E.add(new b(5, discussionInfo4, ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, str5)).getDiscussionMemberNum(discussionInfo4.uin)));
                }
            }
        }
        int size = arrayList3.size();
        this.G = size;
        if (size > 0) {
            this.E.add(new b(6, null));
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                this.E.add(new b(7, ((com.tencent.mobileqq.troop.adapter.contact.d) it6.next()).f293809b));
            }
        }
        if (this.H > 0) {
            this.E.add(new b(2, null));
            Iterator it7 = arrayList4.iterator();
            while (it7.hasNext()) {
                Object obj4 = ((com.tencent.mobileqq.troop.adapter.contact.d) it7.next()).f293809b;
                if (obj4 instanceof TroopInfo) {
                    this.E.add(new b(3, obj4));
                } else if (obj4 instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo5 = (DiscussionInfo) obj4;
                    this.E.add(new b(3, discussionInfo5, ((IDiscussionService) appInterface.getRuntimeService(IDiscussionService.class, str5)).getDiscussionMemberNum(discussionInfo5.uin)));
                }
            }
        }
        QBaseActivity qBaseActivity = this.L;
        if (qBaseActivity instanceof SelectMemberActivity) {
            int type = ((SelectMemberActivity) qBaseActivity).getType();
            this.Q = type;
            if (type == 3000) {
                ArrayList arrayList6 = new ArrayList();
                Iterator<TroopInfo> it8 = list.iterator();
                while (it8.hasNext()) {
                    arrayList6.add(it8.next().troopuin);
                }
                g(arrayList6);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f285872a;

        /* renamed from: b, reason: collision with root package name */
        public TroopInfo f285873b;

        /* renamed from: c, reason: collision with root package name */
        public DiscussionInfo f285874c;

        /* renamed from: d, reason: collision with root package name */
        public int f285875d;

        public b(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopListAdapter.this, Integer.valueOf(i3), obj);
                return;
            }
            this.f285872a = i3;
            if (obj instanceof TroopInfo) {
                this.f285873b = (TroopInfo) obj;
            } else if (obj instanceof DiscussionInfo) {
                this.f285874c = (DiscussionInfo) obj;
            }
        }

        public b(int i3, DiscussionInfo discussionInfo, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, TroopListAdapter.this, Integer.valueOf(i3), discussionInfo, Integer.valueOf(i16));
                return;
            }
            this.f285872a = i3;
            this.f285874c = discussionInfo;
            this.f285875d = i16;
        }
    }
}
