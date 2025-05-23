package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectMemberFromFriendGroup extends SelectMemberInnerFrame {
    static IPatchRedirector $redirector_;
    private hx3.b D;
    private final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> E;
    List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> F;
    ListAdapter G;
    List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ListAdapter extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListAdapter.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    b bVar = (b) view.getTag();
                    if (SelectMemberFromFriendGroup.this.F.contains(bVar.f285768b)) {
                        SelectMemberFromFriendGroup.this.F.remove(bVar.f285768b);
                        bVar.f285771e.setChecked(false);
                        SelectMemberFromFriendGroup.this.B(bVar.f285768b, false);
                    } else {
                        SelectMemberFromFriendGroup.this.F.add(bVar.f285768b);
                        bVar.f285771e.setChecked(true);
                        SelectMemberFromFriendGroup.this.B(bVar.f285768b, true);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            int f285767a;

            /* renamed from: b, reason: collision with root package name */
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b f285768b;

            /* renamed from: c, reason: collision with root package name */
            TextView f285769c;

            /* renamed from: d, reason: collision with root package name */
            TextView f285770d;

            /* renamed from: e, reason: collision with root package name */
            CheckBox f285771e;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListAdapter.this);
                }
            }
        }

        ListAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberFromFriendGroup.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return SelectMemberFromFriendGroup.this.E.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return SelectMemberFromFriendGroup.this.E.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(SelectMemberFromFriendGroup.this.f285782h).inflate(R.layout.acv, (ViewGroup) null);
                    bVar = new b();
                    bVar.f285771e = (CheckBox) view.findViewById(R.id.axa);
                    bVar.f285769c = (TextView) view.findViewById(R.id.cxb);
                    bVar.f285770d = (TextView) view.findViewById(R.id.cxc);
                    view.setTag(bVar);
                    view.setOnClickListener(new a());
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.f285767a = i3;
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getItem(i3);
                bVar.f285768b = bVar2;
                int e16 = bVar2.e();
                bVar.f285770d.setText("" + e16);
                bVar.f285769c.setText(bVar.f285768b.f());
                bVar.f285771e.setTag(bVar);
                SelectMemberFromFriendGroup.this.A(bVar.f285768b, new hx3.b<Boolean>(bVar) { // from class: com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.ListAdapter.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ b f285762a;

                    {
                        this.f285762a = bVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ListAdapter.this, (Object) bVar);
                        }
                    }

                    @Override // hx3.b
                    public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.ListAdapter.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f285764d;

                                {
                                    this.f285764d = eVar;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) eVar);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (this.f285764d.a() == 0) {
                                        AnonymousClass2.this.f285762a.f285771e.setEnabled(false);
                                        AnonymousClass2.this.f285762a.f285771e.setChecked(false);
                                    } else {
                                        AnonymousClass2.this.f285762a.f285771e.setEnabled(true);
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        b bVar3 = anonymousClass2.f285762a;
                                        bVar3.f285771e.setChecked(SelectMemberFromFriendGroup.this.F.contains(bVar3.f285768b));
                                    }
                                }
                            });
                        }
                    }
                });
                if (SelectMemberFromFriendGroup.this.E.size() == 1) {
                    view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                } else if (SelectMemberFromFriendGroup.this.E.size() == 2) {
                    if (i3 == 0) {
                        view.setBackgroundResource(R.drawable.common_strip_setting_top);
                    } else {
                        view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                    }
                } else if (i3 == 0) {
                    view.setBackgroundResource(R.drawable.common_strip_setting_top);
                } else if (i3 == SelectMemberFromFriendGroup.this.E.size() - 1) {
                    view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                } else {
                    view.setBackgroundResource(R.drawable.common_strip_setting_middle);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements hx3.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberFromFriendGroup.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (eVar.a() == 0) {
                arrayList = eVar.b();
            }
            SelectMemberFromFriendGroup.this.v();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) arrayList.get(size);
                if (bVar.e() != 0) {
                    SelectMemberFromFriendGroup.this.E.add(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.b f285774a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f285775b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List[] f285776c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f285777d;

        b(hx3.b bVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar, List[] listArr, List list) {
            this.f285774a = bVar;
            this.f285775b = eVar;
            this.f285776c = listArr;
            this.f285777d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberFromFriendGroup.this, bVar, eVar, listArr, list);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar.a() != 0) {
                eVar.d(-1);
                this.f285774a.onQueryResult(this.f285775b);
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = eVar.b();
            if (b16 != null && b16.size() != 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = b16.get(0);
                if (bVar == null) {
                    eVar.d(-1);
                    this.f285774a.onQueryResult(this.f285775b);
                    return;
                } else {
                    this.f285776c[0] = bVar.b();
                    SelectMemberFromFriendGroup.x(this.f285774a, this.f285777d, this.f285775b, this.f285776c);
                    return;
                }
            }
            eVar.d(-1);
            this.f285774a.onQueryResult(this.f285775b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List[] f285779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f285780b;

        c(List[] listArr, boolean z16) {
            this.f285779a = listArr;
            this.f285780b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberFromFriendGroup.this, listArr, Boolean.valueOf(z16));
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar.a() != 0) {
                this.f285779a[0] = new ArrayList();
                SelectMemberFromFriendGroup.this.w(this.f285780b, this.f285779a);
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = eVar.b();
            if (b16 != null && b16.size() != 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = b16.get(0);
                if (bVar == null) {
                    this.f285779a[0] = new ArrayList();
                } else {
                    this.f285779a[0] = bVar.b();
                }
            } else {
                this.f285779a[0] = new ArrayList();
            }
            SelectMemberFromFriendGroup.this.w(this.f285780b, this.f285779a);
        }
    }

    public SelectMemberFromFriendGroup(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = new a();
        this.E = new ArrayList<>();
        this.F = new ArrayList();
        this.H = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        List<RecentUser> recentList;
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.f285784m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (recentUserCache != null && (recentList = recentUserCache.getRecentList(true)) != null) {
            String currentAccountUin = this.f285784m.getCurrentAccountUin();
            ArrayList arrayList = new ArrayList();
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            for (RecentUser recentUser : recentList) {
                if (recentUser != null) {
                    try {
                        if (recentUser.getType() == 0 && Long.parseLong(recentUser.uin) >= 10000 && !recentUser.uin.equals(currentAccountUin) && !this.f285782h.mUinsToHide.contains(recentUser.uin)) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(iRelationNTUinAndUidApi.getUidFromUin(recentUser.uin), "SelectMemberFromFriendGroup");
                            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                                arrayList.add(friendsSimpleInfoWithUid);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                bVar.j(1003);
                bVar.l(this.f285782h.getString(R.string.f173057gz1));
                bVar.k(arrayList.size());
                bVar.n((byte) 0);
                this.E.add(0, bVar);
                this.H = arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>[] listArr) {
        ArrayList<String> arrayList = this.f285782h.mUinsSelectedDefault;
        ArrayList arrayList2 = new ArrayList();
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : listArr[0]) {
            if (arrayList == null || !arrayList.contains(dVar.x())) {
                aVar.d(iRelationNTUinAndUidApi.getUidFromUin(dVar.x()));
                arrayList2.add(SelectMemberActivity.constructAResultRecord(dVar.x(), ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar), 0, "-1"));
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16, arrayList2) { // from class: com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f285759d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ List f285760e;

            {
                this.f285759d = z16;
                this.f285760e = arrayList2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SelectMemberFromFriendGroup.this, Boolean.valueOf(z16), arrayList2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f285759d) {
                    SelectMemberFromFriendGroup.this.f285782h.addFriendResults(this.f285760e, false);
                } else {
                    Iterator it = this.f285760e.iterator();
                    while (it.hasNext()) {
                        SelectMemberFromFriendGroup.this.f285782h.removeFriendFromResultList(((ResultRecord) it.next()).uin);
                    }
                    SelectMemberFromFriendGroup.this.f285782h.mSelectedAndSearchBar.p(false);
                    SelectMemberFromFriendGroup.this.f285782h.setupDoneBtn();
                    SelectMemberFromFriendGroup.this.f285782h.onResultListChanged();
                }
                SelectMemberFromFriendGroup.this.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(hx3.b<Boolean> bVar, List<String> list, com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>[] listArr) {
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = listArr[0].iterator();
        while (it.hasNext()) {
            if (!list.contains(it.next().x())) {
                eVar.d(-1);
                bVar.onQueryResult(eVar);
                return;
            }
        }
        bVar.onQueryResult(eVar);
    }

    void A(com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar, hx3.b<Boolean> bVar2) {
        ArrayList<String> arrayList = this.f285782h.mUinsSelectedDefault;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        if (arrayList == null) {
            eVar.d(-1);
            bVar2.onQueryResult(eVar);
            return;
        }
        List[] listArr = {null};
        if (bVar.d() == 1003) {
            listArr[0] = this.H;
            x(bVar2, arrayList, eVar, listArr);
        } else {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(bVar.d(), "SelectMemberFromFriendGroup", new b(bVar2, eVar, listArr, arrayList));
        }
    }

    public void B(com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bVar, Boolean.valueOf(z16));
            return;
        }
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>[] listArr = {null};
        if (bVar.d() == 1003) {
            listArr[0] = this.H;
            w(z16, listArr);
        } else {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(bVar.d(), "SelectMemberFromFriendGroup", new c(listArr, z16));
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        y();
        z();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.l();
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(true, selectMemberActivity.getString(R.string.hdd), this.f285782h.getString(R.string.f170107gb));
        p();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), kVar);
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        return iSearchViewCreator.createContactSearchFragment(-1, 1, null, selectMemberActivity.mUinsToHide, selectMemberActivity, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onDestroy();
            this.D = null;
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        List b16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SelectMemberActivity selectMemberActivity = this.f285782h;
        ArrayList<ResultRecord> arrayList = selectMemberActivity.mResultList;
        ArrayList<String> arrayList2 = selectMemberActivity.mUinsSelectedDefault;
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> it = this.E.iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = it.next();
            if (next.d() == 1003) {
                b16 = this.H;
            } else {
                b16 = next.b();
            }
            Iterator it5 = b16.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it5.next();
                    if (arrayList2 == null || !arrayList2.contains(dVar.x())) {
                        Iterator<ResultRecord> it6 = arrayList.iterator();
                        boolean z18 = false;
                        while (it6.hasNext()) {
                            if (it6.next().uin.equals(dVar.x())) {
                                z18 = true;
                            }
                        }
                        if (!z18) {
                            z16 = false;
                            break;
                        }
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                if (this.F.contains(next)) {
                    this.F.remove(next);
                    z17 = true;
                }
            } else if (!this.F.contains(next)) {
                this.F.add(next);
                z17 = true;
            }
        }
        if (z17) {
            this.G.notifyDataSetChanged();
        }
    }

    void y() {
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "SelectMemberFromFriendGroup", false, this.D);
    }

    void z() {
        LinearLayout linearLayout = new LinearLayout(this.f285782h);
        XListView xListView = new XListView(this.f285782h);
        xListView.setDivider(null);
        linearLayout.addView(xListView);
        xListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ListAdapter listAdapter = new ListAdapter();
        this.G = listAdapter;
        xListView.setAdapter((android.widget.ListAdapter) listAdapter);
        setContentView(linearLayout);
    }

    public SelectMemberFromFriendGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = new a();
        this.E = new ArrayList<>();
        this.F = new ArrayList();
        this.H = new ArrayList();
    }

    public SelectMemberFromFriendGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = new a();
        this.E = new ArrayList<>();
        this.F = new ArrayList();
        this.H = new ArrayList();
    }
}
