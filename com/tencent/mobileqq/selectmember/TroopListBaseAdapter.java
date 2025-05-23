package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
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
/* loaded from: classes18.dex */
public class TroopListBaseAdapter extends com.tencent.mobileqq.selectmember.adapter.a {
    static IPatchRedirector $redirector_;
    protected Context C;
    protected Set<String> D;
    protected List<Integer> E;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> F;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> G;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> H;
    protected List<com.tencent.mobileqq.troop.adapter.contact.d> I;
    protected HashSet<Integer> J;
    protected int K;
    private boolean L;
    protected com.tencent.mobileqq.troop.api.observer.a M;

    /* renamed from: i, reason: collision with root package name */
    protected Bundle f285880i;

    /* renamed from: m, reason: collision with root package name */
    protected AppInterface f285881m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
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
            Bitmap faceBitmap = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getFaceBitmap(TroopListBaseAdapter.this.f285881m, 113, str, false, 0);
            if (faceBitmap != null) {
                TroopListBaseAdapter.this.b(str, faceBitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Object f285887a;

        /* renamed from: b, reason: collision with root package name */
        public int f285888b;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopListBaseAdapter.this);
            }
        }
    }

    public TroopListBaseAdapter(Context context, AppInterface appInterface, ExpandableListView expandableListView, Bundle bundle) {
        super(context, appInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, expandableListView, bundle);
            return;
        }
        this.D = new HashSet();
        this.E = new ArrayList(6);
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = new HashSet<>(6);
        this.K = 0;
        this.L = true;
        this.M = new a();
        this.f285880i = bundle;
        this.f285881m = appInterface;
        this.C = context;
        this.K = com.tencent.mobileqq.selectmember.util.a.a(44.0f, context.getResources());
        this.f285881m.addObserver(this.M);
    }

    private void q() {
        ThreadManagerV2.post(new Runnable(((IRecentUserProxyService) this.f285881m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()) { // from class: com.tencent.mobileqq.selectmember.TroopListBaseAdapter.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecentUserProxy f285882d;

            {
                this.f285882d = r5;
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
                ArrayList<DiscussionInfo> arrayList = (ArrayList) ((IDiscussionService) TroopListBaseAdapter.this.f285881m.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
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
                        } else if (((IDiscussionService) TroopListBaseAdapter.this.f285881m.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(discussionInfo.uin) > 0) {
                            arrayList2.add(discussionInfo);
                            i3++;
                        } else {
                            i3++;
                            QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + discussionInfo);
                        }
                    }
                }
                QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i3 + "  org_discussions.size:" + arrayList.size() + "  discussions.size:" + arrayList2.size());
                ThreadManager.getUIHandler().post(new Runnable(sortedJoinedValidTroopInfoFromCache, arrayList2) { // from class: com.tencent.mobileqq.selectmember.TroopListBaseAdapter.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f285883d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f285884e;

                    {
                        this.f285883d = sortedJoinedValidTroopInfoFromCache;
                        this.f285884e = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, sortedJoinedValidTroopInfoFromCache, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean z16;
                        boolean z17;
                        boolean z18;
                        boolean z19;
                        boolean z26;
                        int i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopListBaseAdapter", 2, "load data troopListInfo.size: " + this.f285883d.size() + " discussions.size:" + this.f285884e.size());
                        }
                        Bundle bundle = TroopListBaseAdapter.this.f285880i;
                        boolean z27 = true;
                        if (bundle == null) {
                            str = "";
                            z16 = true;
                            z17 = true;
                            z18 = true;
                            z19 = true;
                            z26 = true;
                        } else {
                            z16 = bundle.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_RECENT_TROOP, true);
                            z17 = TroopListBaseAdapter.this.f285880i.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
                            z18 = TroopListBaseAdapter.this.f285880i.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, true);
                            z19 = TroopListBaseAdapter.this.f285880i.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, true);
                            str = TroopListBaseAdapter.this.f285880i.getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, "");
                            z26 = TroopListBaseAdapter.this.f285880i.getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_BLOCK_OR_GAG_TROOP, true);
                        }
                        TroopListBaseAdapter.this.E.clear();
                        TroopListBaseAdapter.this.F.clear();
                        TroopListBaseAdapter.this.H.clear();
                        TroopListBaseAdapter.this.G.clear();
                        TroopListBaseAdapter.this.I.clear();
                        for (TroopInfo troopInfo : this.f285883d) {
                            if (!z26) {
                                com.tencent.mobileqq.troop.troopgag.data.d selfGagInfo = ((ITroopGagService) TroopListBaseAdapter.this.f285881m.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(troopInfo.troopuin, true);
                                if (!troopInfo.isTroopBlocked && !selfGagInfo.f300235b) {
                                }
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TroopListBaseAdapter.this.x(troopInfo, anonymousClass2.f285882d);
                            int troopMaskPriority = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMaskPriority(troopInfo.troopuin);
                            if (troopInfo.isOwner()) {
                                if (!troopInfo.troopuin.equals(str)) {
                                    TroopListBaseAdapter.this.F.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                                }
                            } else if (troopInfo.isAdmin()) {
                                TroopListBaseAdapter.this.G.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                            } else {
                                TroopListBaseAdapter.this.H.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                            }
                            if (TroopListBaseAdapter.this.u(troopInfo.troopuin, 1)) {
                                TroopListBaseAdapter.this.I.add(new com.tencent.mobileqq.troop.adapter.contact.d(troopMaskPriority, troopInfo));
                            }
                        }
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fetch_all_troop_privilege_flag", true)) {
                            TroopListBaseAdapter.this.s(this.f285883d);
                        }
                        for (DiscussionInfo discussionInfo2 : this.f285884e) {
                            discussionInfo2.lastMsgTime = AnonymousClass2.this.f285882d.findRecentUserByUin(discussionInfo2.uin, 3000).lastmsgtime;
                            if (TroopListBaseAdapter.this.f285881m.getCurrentUin().equals(discussionInfo2.ownerUin)) {
                                TroopListBaseAdapter.this.F.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo2));
                            } else {
                                TroopListBaseAdapter.this.H.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo2));
                            }
                            if (TroopListBaseAdapter.this.u(discussionInfo2.uin, 3000)) {
                                TroopListBaseAdapter.this.I.add(new com.tencent.mobileqq.troop.adapter.contact.d(1, discussionInfo2));
                            }
                        }
                        com.tencent.mobileqq.troop.adapter.contact.b bVar = new com.tencent.mobileqq.troop.adapter.contact.b();
                        Collections.sort(TroopListBaseAdapter.this.F, bVar);
                        Collections.sort(TroopListBaseAdapter.this.G, bVar);
                        Collections.sort(TroopListBaseAdapter.this.H, bVar);
                        Collections.sort(TroopListBaseAdapter.this.I, bVar);
                        TroopListBaseAdapter troopListBaseAdapter = TroopListBaseAdapter.this;
                        troopListBaseAdapter.y(troopListBaseAdapter.F, bVar);
                        if (!TroopListBaseAdapter.this.I.isEmpty() && z16) {
                            TroopListBaseAdapter.this.E.add(13);
                            i16 = TroopListBaseAdapter.this.I.size() + 0;
                        } else {
                            i16 = 0;
                        }
                        int size = TroopListBaseAdapter.this.F.size();
                        if (size > 0 && z17) {
                            TroopListBaseAdapter.this.E.add(4);
                            i16 += size;
                        }
                        int size2 = TroopListBaseAdapter.this.G.size();
                        if (size2 > 0 && z18) {
                            TroopListBaseAdapter.this.E.add(6);
                            i16 += size2;
                        }
                        int size3 = TroopListBaseAdapter.this.H.size();
                        if (size3 > 0 && z19) {
                            TroopListBaseAdapter.this.E.add(2);
                            i16 += size3;
                        }
                        HashSet<Integer> hashSet = new HashSet<>(5);
                        Iterator<Integer> it = TroopListBaseAdapter.this.J.iterator();
                        while (it.hasNext()) {
                            Integer next = it.next();
                            if (TroopListBaseAdapter.this.E.contains(next)) {
                                hashSet.add(next);
                            }
                        }
                        TroopListBaseAdapter troopListBaseAdapter2 = TroopListBaseAdapter.this;
                        troopListBaseAdapter2.J = hashSet;
                        troopListBaseAdapter2.v(troopListBaseAdapter2.getGroupCount(), i16);
                        TroopListBaseAdapter.super.notifyDataSetChanged();
                        if (TroopListBaseAdapter.this.L) {
                            if (TroopListBaseAdapter.this.E.size() > 0) {
                                TroopListBaseAdapter troopListBaseAdapter3 = TroopListBaseAdapter.this;
                                troopListBaseAdapter3.J.add(troopListBaseAdapter3.E.get(0));
                                ((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f.expandGroup(0);
                            }
                            TroopListBaseAdapter.this.L = false;
                        } else if (TroopListBaseAdapter.this.E.size() == 1) {
                            ((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f.expandGroup(0);
                            TroopListBaseAdapter troopListBaseAdapter4 = TroopListBaseAdapter.this;
                            troopListBaseAdapter4.J.add(troopListBaseAdapter4.E.get(0));
                        } else {
                            for (int i17 = 0; i17 < TroopListBaseAdapter.this.E.size(); i17++) {
                                TroopListBaseAdapter troopListBaseAdapter5 = TroopListBaseAdapter.this;
                                if (troopListBaseAdapter5.J.contains(troopListBaseAdapter5.E.get(i17))) {
                                    ((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f.expandGroup(i17);
                                } else {
                                    ((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f.collapseGroup(i17);
                                }
                            }
                        }
                        if (((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f instanceof PinnedHeaderExpandableListView) {
                            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) ((com.tencent.mobileqq.selectmember.adapter.a) TroopListBaseAdapter.this).f285924f;
                            if (TroopListBaseAdapter.this.E.size() <= 1) {
                                z27 = false;
                            }
                            pinnedHeaderExpandableListView.setHeaderViewShouldShow(z27);
                        }
                        TroopListBaseAdapter troopListBaseAdapter6 = TroopListBaseAdapter.this;
                        troopListBaseAdapter6.r(troopListBaseAdapter6.F);
                    }
                });
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str, int i3) {
        return this.D.contains(str + "_" + i3);
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.destroy();
        this.f285881m.removeObserver(this.M);
        ExpandableListView expandableListView = this.f285924f;
        if (expandableListView != null) {
            int childCount = expandableListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f285924f.getChildAt(i3);
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
        if (i3 >= 0 && i3 < this.E.size()) {
            int intValue = this.E.get(i3).intValue();
            if (intValue != 2) {
                if (intValue != 4) {
                    if (intValue != 6) {
                        if (intValue == 13) {
                            i16 = this.I.size();
                        }
                    } else {
                        i16 = this.G.size();
                    }
                } else {
                    i16 = this.F.size();
                }
            } else {
                i16 = this.H.size();
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
        if (QLog.isColorLevel()) {
            QLog.d("TroopListBaseAdapter", 2, "getChildrenCount mGroups.size():" + this.E.size());
        }
        return this.E.size();
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a, android.widget.ExpandableListAdapter
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

    protected void r(List<com.tencent.mobileqq.troop.adapter.contact.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        }
    }

    protected void s(List<TroopInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        }
    }

    public b t(int i3, int i16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        int intValue = this.E.get(i3).intValue();
        if (intValue != 2) {
            if (intValue != 4) {
                if (intValue != 6) {
                    if (intValue != 13) {
                        return null;
                    }
                    Object obj = this.I.get(i16).f293809b;
                    bVar = new b();
                    bVar.f285887a = obj;
                    bVar.f285888b = 13;
                } else {
                    Object obj2 = this.G.get(i16).f293809b;
                    bVar = new b();
                    bVar.f285887a = obj2;
                    bVar.f285888b = 6;
                }
            } else {
                Object obj3 = this.F.get(i16).f293809b;
                bVar = new b();
                bVar.f285887a = obj3;
                bVar.f285888b = 4;
            }
        } else {
            Object obj4 = this.H.get(i16).f293809b;
            bVar = new b();
            bVar.f285887a = obj4;
            bVar.f285888b = 2;
        }
        return bVar;
    }

    protected void v(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.L = true;
        this.J.clear();
        notifyDataSetChanged();
    }

    public void x(TroopInfo troopInfo, RecentUserProxy recentUserProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) troopInfo, (Object) recentUserProxy);
            return;
        }
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(this.f285881m, troopInfo.troopuin) == GroupMsgMask.ASSISTANT) {
            troopInfo.lastMsgTime = ((IMessageFacade) this.f285881m.getRuntimeService(IMessageFacade.class, "")).getLastMessage(troopInfo.troopuin, 1).time;
            return;
        }
        long j3 = recentUserProxy.findRecentUserByUin(troopInfo.troopuin, 1).lastmsgtime;
        if (j3 != 0) {
            troopInfo.lastMsgTime = j3;
        }
    }

    protected void y(List<com.tencent.mobileqq.troop.adapter.contact.d> list, com.tencent.mobileqq.troop.adapter.contact.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) list, (Object) bVar);
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.TroopListBaseAdapter.1
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
