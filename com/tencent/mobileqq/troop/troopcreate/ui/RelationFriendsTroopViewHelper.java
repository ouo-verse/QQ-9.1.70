package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper;
import com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper;
import com.tencent.mobileqq.troop.api.troopcreate.impl.FacePreloadBaseAdapterHelperImpl;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RelationFriendsTroopViewHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    IRelationFriendsSearchHelper f300109a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Object> f300110b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Entity> f300111c;

    /* renamed from: d, reason: collision with root package name */
    private String f300112d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f300113e;

    /* renamed from: f, reason: collision with root package name */
    AppInterface f300114f;

    /* renamed from: g, reason: collision with root package name */
    PinnedFooterExpandableListView f300115g;

    /* renamed from: h, reason: collision with root package name */
    private IRelationFriendsTroopViewHelper.a f300116h;

    /* renamed from: i, reason: collision with root package name */
    private int f300117i;

    public RelationFriendsTroopViewHelper(AppInterface appInterface, PinnedFooterExpandableListView pinnedFooterExpandableListView, IRelationFriendsTroopViewHelper.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, pinnedFooterExpandableListView, aVar);
            return;
        }
        this.f300110b = new ArrayList<>();
        this.f300111c = new ArrayList<>();
        this.f300112d = "";
        this.f300113e = new HashMap<>();
        this.f300117i = -1;
        this.f300114f = appInterface;
        this.f300115g = pinnedFooterExpandableListView;
        this.f300116h = aVar;
        this.f300109a = (IRelationFriendsSearchHelper) QRoute.api(IRelationFriendsSearchHelper.class);
    }

    private int f() {
        int i3 = this.f300117i;
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 4) {
            return 4;
        }
        return 0;
    }

    private void o(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "updateRelationFriends");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f300118d;

            {
                this.f300118d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RelationFriendsTroopViewHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                RelationFriendsTroopViewHelper relationFriendsTroopViewHelper = RelationFriendsTroopViewHelper.this;
                ArrayList<Object> search = relationFriendsTroopViewHelper.f300109a.search(this.f300118d, relationFriendsTroopViewHelper.f300114f);
                if (search == null) {
                    QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 1, "updateRelationFriends searchend result null,uin:" + this.f300118d);
                    return;
                }
                QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 1, "updateRelationFriends startsearch uin:" + this.f300118d + ",resultsize:" + search.size());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(RelationFriendsTroopViewHelper.this.f300116h.b());
                int i3 = 0;
                for (int i16 = 0; i16 < search.size(); i16++) {
                    d dVar = (d) search.get(i16);
                    if (i3 >= 5) {
                        break;
                    }
                    if (!arrayList2.contains(dVar.x())) {
                        arrayList.add(dVar);
                        i3++;
                        if (QLog.isColorLevel()) {
                            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "updateRelationFriends relationuin:" + dVar.x());
                        }
                    }
                }
                PinnedFooterExpandableListView pinnedFooterExpandableListView = RelationFriendsTroopViewHelper.this.f300115g;
                if (pinnedFooterExpandableListView != null) {
                    pinnedFooterExpandableListView.post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList f300119d;

                        {
                            this.f300119d = arrayList;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) arrayList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            RelationFriendsTroopViewHelper.this.f300110b.clear();
                            if (this.f300119d.size() > 0) {
                                for (int i17 = 0; i17 < this.f300119d.size() && i17 < 5; i17++) {
                                    RelationFriendsTroopViewHelper.this.f300110b.add(this.f300119d.get(i17));
                                }
                            }
                            RelationFriendsTroopViewHelper.this.f300116h.c();
                        }
                    });
                }
            }
        });
    }

    private void p() {
        ArrayList<ResultRecord> a16;
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "updateRelationTroops");
        }
        if (((ITroopCreateService) this.f300114f.getRuntimeService(ITroopCreateService.class, "")) != null && (a16 = this.f300116h.a()) != null) {
            if (QLog.isColorLevel()) {
                QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "updateRelationTroops records size:" + a16.size());
            }
            ArrayList<ResultRecord> arrayList = new ArrayList<>(a16.size());
            arrayList.addAll(a16);
            ((ITroopSearchService) this.f300114f.getRuntimeService(ITroopSearchService.class, "")).search(arrayList, true, new ITroopSearchService.b() { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RelationFriendsTroopViewHelper.this);
                    }
                }

                @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.b
                public void onResult(ArrayList<ITroopSearchService.a> arrayList2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList2);
                        return;
                    }
                    PinnedFooterExpandableListView pinnedFooterExpandableListView = RelationFriendsTroopViewHelper.this.f300115g;
                    if (pinnedFooterExpandableListView != null) {
                        pinnedFooterExpandableListView.post(new Runnable(arrayList2) { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.4.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ArrayList f300122d;

                            {
                                this.f300122d = arrayList2;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) arrayList2);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                String troopDisplayName;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (this.f300122d != null) {
                                    RelationFriendsTroopViewHelper.this.f300111c.clear();
                                    for (int i3 = 0; i3 < this.f300122d.size() && i3 < 5; i3++) {
                                        TroopInfo troopInfo = ((ITroopSearchService.a) this.f300122d.get(i3)).f299977d;
                                        if (troopInfo != null) {
                                            RelationTroopEntity relationTroopEntity = new RelationTroopEntity();
                                            relationTroopEntity.troopInfo = ((ITroopSearchService.a) this.f300122d.get(i3)).f299977d;
                                            RelationFriendsTroopViewHelper.this.f300111c.add(relationTroopEntity);
                                        }
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("updateRelationTroops entityname:");
                                            if (troopInfo == null) {
                                                troopDisplayName = "null";
                                            } else {
                                                troopDisplayName = troopInfo.getTroopDisplayName();
                                            }
                                            sb5.append(troopDisplayName);
                                            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, sb5.toString());
                                        }
                                    }
                                    RelationFriendsTroopViewHelper.this.f300116h.c();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public View e(int i3, int i16, View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, RelationTroopEntity relationTroopEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), view, viewGroup, context, onClickListener, relationTroopEntity);
        }
        return ((IFacePreloadBaseAdapterHelper) this.f300114f.getRuntimeService(IFacePreloadBaseAdapterHelper.class, "")).getBuddyListRelationTroopView(view, viewGroup, context, onClickListener, relationTroopEntity);
    }

    public Long g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            return this.f300113e.get(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "getRelationTroopChildId troopUin empty");
        }
        return -1L;
    }

    public void h(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList, SparseArray<ArrayList<Object>> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) sparseArray);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "loadData");
        }
        if (!this.f300111c.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "loadData relationtroop");
            }
            this.f300113e.clear();
            ArrayList<Object> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < this.f300111c.size(); i3++) {
                RelationTroopEntity relationTroopEntity = (RelationTroopEntity) this.f300111c.get(i3);
                arrayList2.add(relationTroopEntity);
                this.f300113e.put(relationTroopEntity.troopInfo.troopuin, Long.valueOf(i3 + 1));
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
            bVar.j(1008);
            bVar.l(HardCodeUtil.qqStr(R.string.vxs));
            bVar.k(arrayList2.size());
            bVar.n((byte) 0);
            arrayList.add(bVar);
            sparseArray.put(bVar.d(), arrayList2);
        }
        if (!this.f300110b.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "loadData relationfriends");
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
            ArrayList<Object> arrayList3 = new ArrayList<>();
            for (int i16 = 0; i16 < this.f300110b.size(); i16++) {
                arrayList3.add(this.f300110b.get(i16));
            }
            bVar2.j(1007);
            bVar2.l(HardCodeUtil.qqStr(R.string.vxr));
            bVar2.k(arrayList3.size());
            bVar2.n((byte) 0);
            arrayList.add(bVar2);
            sparseArray.put(bVar2.d(), arrayList3);
        }
    }

    public void i(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) resultRecord);
            return;
        }
        this.f300117i = 1;
        if (resultRecord != null) {
            if (QLog.isColorLevel()) {
                QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "onSearchResult:,currentRelationUin:" + this.f300112d + ",lastrecordUIN:" + resultRecord.uin);
            }
            if (!this.f300112d.equals(resultRecord.uin)) {
                String str = resultRecord.uin;
                this.f300112d = str;
                if (!TextUtils.isEmpty(str)) {
                    o(this.f300112d);
                    p();
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "onSearchResult lastRecord null");
        }
        this.f300112d = "";
        PinnedFooterExpandableListView pinnedFooterExpandableListView = this.f300115g;
        if (pinnedFooterExpandableListView != null) {
            pinnedFooterExpandableListView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RelationFriendsTroopViewHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    RelationFriendsTroopViewHelper.this.f300110b.clear();
                    RelationFriendsTroopViewHelper.this.f300111c.clear();
                    RelationFriendsTroopViewHelper.this.f300116h.c();
                }
            });
        }
    }

    public void j(ResultRecord resultRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) resultRecord, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "onSearchResult:,param_entrance:" + i3);
        }
        if (i3 == 38 || i3 == 29 || i3 == 39) {
            if (i3 == 38) {
                this.f300117i = 3;
            } else if (i3 == 39) {
                this.f300117i = 4;
            } else {
                this.f300117i = 2;
            }
            if (resultRecord != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "onSearchResult:,currentRelationUin:" + this.f300112d + ",lastrecordUIN:" + resultRecord.uin);
                }
                if (!this.f300112d.equals(resultRecord.uin)) {
                    String str = resultRecord.uin;
                    this.f300112d = str;
                    if (!TextUtils.isEmpty(str)) {
                        o(this.f300112d);
                        if (i3 == 29 || i3 == 39) {
                            p();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            PinnedFooterExpandableListView pinnedFooterExpandableListView = this.f300115g;
            if (pinnedFooterExpandableListView != null) {
                pinnedFooterExpandableListView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RelationFriendsTroopViewHelper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(FacePreloadBaseAdapterHelperImpl.TAG, 2, "onSearchResult lastRecord null");
                        }
                        RelationFriendsTroopViewHelper.this.f300112d = "";
                        RelationFriendsTroopViewHelper.this.f300110b.clear();
                        RelationFriendsTroopViewHelper.this.f300111c.clear();
                        RelationFriendsTroopViewHelper.this.f300116h.c();
                    }
                });
            }
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ReportController.o(this.f300114f, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", f(), 0, "", "", "", "");
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ReportController.o(this.f300114f, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", f(), 0, "", "", "", "");
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ReportController.o(this.f300114f, "dc00899", "Grp_create", "", "grptab", "grplist_clk", f(), 0, "", "", "", "");
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            ReportController.o(this.f300114f, "dc00899", "Grp_create", "", "grptab", "grplist_exp", f(), 0, "", "", "", "");
        }
    }
}
