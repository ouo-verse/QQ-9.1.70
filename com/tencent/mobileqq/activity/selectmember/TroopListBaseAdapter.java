package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.adapter.contact.d;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopListBaseAdapter extends com.tencent.mobileqq.adapter.c {
    static IPatchRedirector $redirector_;
    protected Set<String> C;
    protected List<Integer> D;
    protected List<d> E;
    protected List<d> F;
    protected List<d> G;
    protected List<d> H;
    protected List<d> I;
    protected HashSet<Integer> J;
    protected int K;
    private boolean L;
    protected com.tencent.mobileqq.troop.api.observer.a M;

    /* renamed from: i, reason: collision with root package name */
    protected AppInterface f186177i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f186178m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListBaseAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                return;
            }
            Bitmap faceBitmap = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getFaceBitmap(TroopListBaseAdapter.this.f186177i, 113, str, false, 0);
            if (faceBitmap != null) {
                TroopListBaseAdapter.this.b(str, faceBitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Object f186184a;

        /* renamed from: b, reason: collision with root package name */
        public int f186185b;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListBaseAdapter.this);
            }
        }
    }

    public TroopListBaseAdapter(Context context, AppInterface appInterface, ExpandableListView expandableListView) {
        super(context, (QQAppInterface) appInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, expandableListView);
            return;
        }
        this.C = new HashSet();
        this.D = new ArrayList(6);
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = new HashSet<>(6);
        this.K = 0;
        this.L = true;
        this.M = new a();
        this.f186177i = appInterface;
        this.f186178m = context;
        this.K = BaseAIOUtils.f(44.0f, context.getResources());
        this.f186177i.addObserver(this.M);
    }

    private void q() {
        ThreadManagerV2.post(new Runnable(((IRecentUserProxyService) this.f186177i.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()) { // from class: com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecentUserProxy f186179d;

            {
                this.f186179d = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListBaseAdapter.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                List<TroopInfo> sortedJoinedValidTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedValidTroopInfoFromCache();
                ArrayList<DiscussionInfo> arrayList = (ArrayList) ((IDiscussionService) TroopListBaseAdapter.this.f186177i.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
                ArrayList arrayList2 = new ArrayList();
                int i3 = 0;
                for (DiscussionInfo discussionInfo : arrayList) {
                    if (discussionInfo != null && !TextUtils.isEmpty(discussionInfo.uin)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopListBaseAdapter", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + discussionInfo);
                        }
                        if (!TextUtils.isEmpty(discussionInfo.discussionName)) {
                            arrayList2.add(discussionInfo);
                        } else if (i3 >= 40) {
                            arrayList2.add(discussionInfo);
                        } else if (((IDiscussionService) TroopListBaseAdapter.this.f186177i.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin) > 0) {
                            arrayList2.add(discussionInfo);
                            i3++;
                        } else {
                            i3++;
                            QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + discussionInfo);
                        }
                    }
                }
                QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i3 + "  org_discussions.size:" + arrayList.size() + "  discussions.size:" + arrayList2.size());
                ThreadManager.getUIHandler().post(new Runnable(sortedJoinedValidTroopInfoFromCache, arrayList2) { // from class: com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f186180d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f186181e;

                    {
                        this.f186180d = sortedJoinedValidTroopInfoFromCache;
                        this.f186181e = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, sortedJoinedValidTroopInfoFromCache, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopListBaseAdapter", 2, "load data troopListInfo.size: " + this.f186180d.size() + " discussions.size:" + this.f186181e.size());
                        }
                        TroopListBaseAdapter.this.D.clear();
                        TroopListBaseAdapter.this.E.clear();
                        TroopListBaseAdapter.this.G.clear();
                        TroopListBaseAdapter.this.F.clear();
                        TroopListBaseAdapter.this.I.clear();
                        Iterator it = this.f186180d.iterator();
                        while (true) {
                            z16 = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            TroopInfo troopInfo = (TroopInfo) it.next();
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TroopListBaseAdapter.this.u(troopInfo, anonymousClass2.f186179d);
                            int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo.troopuin);
                            if (troopInfo.isOwner()) {
                                TroopListBaseAdapter.this.E.add(new d(troopMaskPriority, troopInfo));
                            } else if (troopInfo.isAdmin()) {
                                TroopListBaseAdapter.this.F.add(new d(troopMaskPriority, troopInfo));
                            } else {
                                TroopListBaseAdapter.this.G.add(new d(troopMaskPriority, troopInfo));
                            }
                            if (TroopListBaseAdapter.this.s(troopInfo.troopuin, 1)) {
                                TroopListBaseAdapter.this.I.add(new d(troopMaskPriority, troopInfo));
                            }
                        }
                        for (DiscussionInfo discussionInfo2 : this.f186181e) {
                            discussionInfo2.lastMsgTime = AnonymousClass2.this.f186179d.findRecentUserByUin(discussionInfo2.uin, 3000).lastmsgtime;
                            if (TroopListBaseAdapter.this.f186177i.getCurrentUin().equals(discussionInfo2.ownerUin)) {
                                TroopListBaseAdapter.this.E.add(new d(1, discussionInfo2));
                            } else {
                                TroopListBaseAdapter.this.G.add(new d(1, discussionInfo2));
                            }
                            if (TroopListBaseAdapter.this.s(discussionInfo2.uin, 3000)) {
                                TroopListBaseAdapter.this.I.add(new d(1, discussionInfo2));
                            }
                        }
                        com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
                        Collections.sort(TroopListBaseAdapter.this.E, bVar);
                        Collections.sort(TroopListBaseAdapter.this.F, bVar);
                        Collections.sort(TroopListBaseAdapter.this.G, bVar);
                        Collections.sort(TroopListBaseAdapter.this.I, bVar);
                        if (!TroopListBaseAdapter.this.I.isEmpty()) {
                            TroopListBaseAdapter.this.D.add(13);
                        }
                        if (TroopListBaseAdapter.this.E.size() > 0) {
                            TroopListBaseAdapter.this.D.add(4);
                        }
                        if (TroopListBaseAdapter.this.F.size() > 0) {
                            TroopListBaseAdapter.this.D.add(6);
                        }
                        if (TroopListBaseAdapter.this.G.size() > 0) {
                            TroopListBaseAdapter.this.D.add(2);
                        }
                        HashSet<Integer> hashSet = new HashSet<>(5);
                        Iterator<Integer> it5 = TroopListBaseAdapter.this.J.iterator();
                        while (it5.hasNext()) {
                            Integer next = it5.next();
                            if (TroopListBaseAdapter.this.D.contains(next)) {
                                hashSet.add(next);
                            }
                        }
                        TroopListBaseAdapter troopListBaseAdapter = TroopListBaseAdapter.this;
                        troopListBaseAdapter.J = hashSet;
                        TroopListBaseAdapter.super.notifyDataSetChanged();
                        if (TroopListBaseAdapter.this.L) {
                            if (TroopListBaseAdapter.this.D.size() > 0) {
                                TroopListBaseAdapter troopListBaseAdapter2 = TroopListBaseAdapter.this;
                                troopListBaseAdapter2.J.add(troopListBaseAdapter2.D.get(0));
                                ((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f.expandGroup(0);
                            }
                            TroopListBaseAdapter.this.L = false;
                        } else if (TroopListBaseAdapter.this.D.size() == 1) {
                            ((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f.expandGroup(0);
                            TroopListBaseAdapter troopListBaseAdapter3 = TroopListBaseAdapter.this;
                            troopListBaseAdapter3.J.add(troopListBaseAdapter3.D.get(0));
                        } else {
                            for (int i16 = 0; i16 < TroopListBaseAdapter.this.D.size(); i16++) {
                                TroopListBaseAdapter troopListBaseAdapter4 = TroopListBaseAdapter.this;
                                if (troopListBaseAdapter4.J.contains(troopListBaseAdapter4.D.get(i16))) {
                                    ((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f.expandGroup(i16);
                                } else {
                                    ((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f.collapseGroup(i16);
                                }
                            }
                        }
                        if (((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f instanceof PinnedHeaderExpandableListView) {
                            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) ((com.tencent.mobileqq.adapter.c) TroopListBaseAdapter.this).f187153f;
                            if (TroopListBaseAdapter.this.D.size() <= 1) {
                                z16 = false;
                            }
                            pinnedHeaderExpandableListView.setHeaderViewShouldShow(z16);
                        }
                    }
                });
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(String str, int i3) {
        return this.C.contains(str + "_" + i3);
    }

    @Override // com.tencent.mobileqq.adapter.c
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.destroy();
        this.f186177i.removeObserver(this.M);
        ExpandableListView expandableListView = this.f187153f;
        if (expandableListView != null) {
            int childCount = expandableListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f187153f.getChildAt(i3);
                if (childAt != null) {
                    childAt.setOnClickListener(null);
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return Integer.valueOf(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        int i16 = 0;
        if (i3 >= 0 && i3 < this.D.size()) {
            int intValue = this.D.get(i3).intValue();
            if (intValue != 2) {
                if (intValue != 4) {
                    if (intValue != 6) {
                        if (intValue == 13) {
                            i16 = this.I.size();
                        }
                    } else {
                        i16 = this.F.size();
                    }
                } else {
                    i16 = this.E.size();
                }
            } else {
                i16 = this.G.size();
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopListBaseAdapter", 2, "getChildrenCount count:" + i16 + "  groupPosition:" + i3);
            }
        }
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.D.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            q();
        }
    }

    public b r(int i3, int i16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        int intValue = this.D.get(i3).intValue();
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue != 13) {
                        return null;
                    }
                    Object obj = this.I.get(i16).f293809b;
                    bVar = new b();
                    bVar.f186184a = obj;
                    bVar.f186185b = 13;
                } else {
                    Object obj2 = this.F.get(i16).f293809b;
                    bVar = new b();
                    bVar.f186184a = obj2;
                    bVar.f186185b = 6;
                }
            } else {
                Object obj3 = this.E.get(i16).f293809b;
                bVar = new b();
                bVar.f186184a = obj3;
                bVar.f186185b = 4;
            }
        } else {
            Object obj4 = this.G.get(i16).f293809b;
            bVar = new b();
            bVar.f186184a = obj4;
            bVar.f186185b = 2;
        }
        return bVar;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.L = true;
        this.J.clear();
        notifyDataSetChanged();
    }

    public void u(TroopInfo troopInfo, RecentUserProxy recentUserProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) troopInfo, (Object) recentUserProxy);
            return;
        }
        if (SearchUtils.x0(this.f186177i, troopInfo.troopuin) == GroupMsgMask.ASSISTANT) {
            troopInfo.lastMsgTime = ((IMessageFacade) this.f186177i.getRuntimeService(IMessageFacade.class, "")).getLastMessage(troopInfo.troopuin, 1).time;
            return;
        }
        long j3 = recentUserProxy.findRecentUserByUin(troopInfo.troopuin, 1).lastmsgtime;
        if (j3 != 0) {
            troopInfo.lastMsgTime = j3;
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopListBaseAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopListBaseAdapter.super.notifyDataSetChanged();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
