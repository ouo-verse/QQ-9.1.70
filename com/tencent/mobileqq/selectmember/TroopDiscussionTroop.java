package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopDiscussionTroop extends TroopDiscussionBaseV implements View.OnClickListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    private TroopDiscussionMemSelectAdapter C;
    TextView D;
    int E;
    private d F;
    private b G;
    private e H;
    private MyTroopObserver I;
    private c J;
    private AutomatorObserver K;

    /* renamed from: m, reason: collision with root package name */
    private SwipPinnedHeaderExpandableListView f285861m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class MyTroopObserver extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        protected MyTroopObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGenNewTroopName(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else if (TroopDiscussionTroop.this.C != null) {
                TroopDiscussionTroop.this.C.z();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                TroopDiscussionTroop.this.i();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                TroopDiscussionTroop.this.i();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopDiscussionTroop", 2, "onUpdateTroopList " + z16);
            }
            if (z16) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyTroopObserver.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyTroopObserver.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TroopDiscussionTroop.this.i();
                        }
                    }
                }, 500L);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopNickname(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                TroopDiscussionTroop.this.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends AutomatorObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.app.AutomatorObserver
        protected void onCacheInited(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopDiscussionTroop", 2, "onCacheInited " + i3);
                }
                if (TroopDiscussionTroop.this.C != null) {
                    TroopDiscussionTroop.this.C.w();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                TroopDiscussionTroop.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends BaseMessageObserver {
        static IPatchRedirector $redirector_;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 2001) {
                onUpdateTroopList();
            }
        }

        protected void onUpdateTroopList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopDiscussionTroop.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void c(String str, GroupMsgMask groupMsgMask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) groupMsgMask);
            } else {
                TroopDiscussionTroop.this.i();
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                TroopDiscussionTroop.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        protected e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            if (i3 == 6) {
                if (i16 == 0) {
                    TroopDiscussionTroop.this.i();
                }
            } else if (i3 == 2) {
                if (i16 == 0) {
                    TroopDiscussionTroop.this.i();
                }
            } else if (i3 == 9 && i16 == 0) {
                TroopDiscussionTroop.this.i();
            }
        }
    }

    public TroopDiscussionTroop(SelectMemberActivity selectMemberActivity) {
        super(selectMemberActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectMemberActivity);
            return;
        }
        this.D = null;
        this.K = new a();
        this.E = getResources().getDimensionPixelSize(R.dimen.f159607b14);
    }

    private void h() {
        if (this.F == null) {
            this.F = new d();
        }
        if (this.G == null) {
            this.G = new b();
        }
        if (this.H == null) {
            this.H = new e();
        }
        if (this.I == null) {
            this.I = new MyTroopObserver();
        }
        if (this.J == null) {
            this.J = new c();
        }
        this.f285850f.addObserver(this.F);
        this.f285850f.addObserver(this.G);
        this.f285850f.addObserver(this.H);
        this.f285850f.addObserver(this.I);
        this.f285850f.addObserver(this.J);
        this.f285850f.addObserver(this.K);
    }

    private void j() {
        this.f285850f.removeObserver(this.F);
        this.f285850f.removeObserver(this.G);
        this.f285850f.removeObserver(this.H);
        this.f285850f.removeObserver(this.I);
        this.f285850f.removeObserver(this.J);
        this.f285850f.removeObserver(this.K);
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        f(R.layout.acy);
        this.f285861m = (SwipPinnedHeaderExpandableListView) findViewById(R.id.f167137l64);
        this.D = (TextView) findViewById(R.id.k1f);
        this.f285861m.setSelector(R.color.ajr);
        this.f285861m.setNeedCheckSpringback(true);
        this.f285861m.setGroupIndicator(null);
        this.f285861m.setDivider(null);
        this.f285861m.setPadding(0, 0, 0, com.tencent.mobileqq.selectmember.util.a.a(54.0f, getResources()));
        this.f285861m.setChildDivider(null);
        this.f285861m.setClipToPadding(false);
        this.f285861m.setScrollBarStyle(33554432);
        TroopDiscussionMemSelectAdapter troopDiscussionMemSelectAdapter = new TroopDiscussionMemSelectAdapter(this.f285848d, this.f285850f, bundle, this.f285861m, this);
        this.C = troopDiscussionMemSelectAdapter;
        this.f285861m.setAdapter(troopDiscussionMemSelectAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.d();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void e(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            h();
            this.f285861m.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.TroopDiscussionTroop.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDiscussionTroop.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopDiscussionTroop.this.C.notifyDataSetChanged();
                    }
                }
            }, 200L);
        }
    }

    void i() {
        TroopDiscussionMemSelectAdapter troopDiscussionMemSelectAdapter = this.C;
        if (troopDiscussionMemSelectAdapter != null) {
            troopDiscussionMemSelectAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DiscussionInfo discussionInfo;
        TroopInfo troopInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            TroopDiscussionMemSelectAdapter.c cVar = (TroopDiscussionMemSelectAdapter.c) view.getTag();
            if (cVar != null && (troopInfo = cVar.C) != null) {
                int i3 = 1;
                if ((this.f285848d instanceof SelectMemberActivity) && !troopInfo.isAllowCreateDiscuss() && !troopInfo.isTroopOwner(this.f285850f.getCurrentAccountUin()) && !troopInfo.isTroopAdmin(this.f285850f.getCurrentAccountUin())) {
                    SelectMemberActivity selectMemberActivity = this.f285848d;
                    QQToast.makeText(selectMemberActivity, 1, selectMemberActivity.getString(R.string.f171403es0), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("group_uin", troopInfo.troopuin);
                    bundle.putString("group_name", troopInfo.getTroopDisplayName());
                    this.f285851h.j(6, bundle);
                    int i16 = cVar.E;
                    if (i16 != 1) {
                        if (i16 != 3) {
                            if (i16 != 5) {
                                if (i16 == 7) {
                                    i3 = 2;
                                }
                            }
                        } else {
                            i3 = 3;
                        }
                        ReportController.o(this.f285850f, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, troopInfo.troopuin + "", String.valueOf(i3), "", "");
                    }
                    i3 = 0;
                    ReportController.o(this.f285850f, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, troopInfo.troopuin + "", String.valueOf(i3), "", "");
                }
            } else if (cVar != null && (discussionInfo = cVar.D) != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("group_uin", discussionInfo.uin);
                bundle2.putString("group_name", discussionInfo.discussionName);
                this.f285851h.j(7, bundle2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
        }
        TroopDiscussionMemSelectAdapter troopDiscussionMemSelectAdapter = this.C;
        if (troopDiscussionMemSelectAdapter != null) {
            troopDiscussionMemSelectAdapter.destroy();
        }
        j();
        super.onDestroy();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
        }
    }
}
