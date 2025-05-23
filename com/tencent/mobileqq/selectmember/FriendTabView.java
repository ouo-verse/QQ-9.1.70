package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedFooterExpandableListView;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FriendTabView extends TroopDiscussionBaseV implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private SelectMemberBuddyListAdapter C;
    boolean D;
    boolean E;

    /* renamed from: m, reason: collision with root package name */
    private PinnedFooterExpandableListView f285663m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements PinnedFooterExpandableListView.FooterExpandListViewListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTabView.this);
            }
        }

        @Override // com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener
        public void onClickHeader(PinnedFooterExpandableListView pinnedFooterExpandableListView, View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, pinnedFooterExpandableListView, view, Integer.valueOf(i3));
                return;
            }
            if (!FriendTabView.this.D) {
                int i16 = i3 - 1;
                if (i16 >= 0) {
                    pinnedFooterExpandableListView.collapseGroup(i16);
                } else if (QLog.isColorLevel()) {
                    QLog.d("FriendTabView", 2, "header group unusal: " + i3);
                }
                FriendTabView.this.D = true;
                return;
            }
            if (pinnedFooterExpandableListView.isGroupExpanded(i3)) {
                pinnedFooterExpandableListView.collapseGroup(i3);
            } else {
                pinnedFooterExpandableListView.expandGroup(i3);
            }
        }

        @Override // com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener
        public void onHeaderDisable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                FriendTabView.this.D = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTabView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                FriendTabView.this.f285851h.i(1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FriendTabView(SelectMemberActivity selectMemberActivity) {
        super(selectMemberActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) selectMemberActivity);
            return;
        }
        this.D = false;
        this.E = false;
        this.f285848d = selectMemberActivity;
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.b(bundle);
        f(R.layout.acu);
        this.f285663m = (PinnedFooterExpandableListView) findViewById(R.id.bzf);
        this.D = false;
        if (QLog.isColorLevel()) {
            QLog.d("FriendTabView", 2, "firstUserClicked is " + this.D);
        }
        this.f285663m.setListener(new a());
        LinearLayout linearLayout = (LinearLayout) this.f285848d.getLayoutInflater().inflate(R.layout.c1k, (ViewGroup) null);
        this.f285663m.addHeaderView(linearLayout);
        linearLayout.findViewById(R.id.aku).setOnClickListener(new b());
        QLog.d("FriendTabView", 2, "----->onCreate");
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(this.f285848d, this.f285850f, this.f285663m, new View.OnClickListener() { // from class: com.tencent.mobileqq.selectmember.FriendTabView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendTabView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object obj;
                String str;
                boolean onListViewItemClick;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
                    d dVar = (d) view.getTag();
                    if (dVar != null && dVar.C != null && (obj = dVar.D) != null) {
                        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
                            str = ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).m();
                        } else if (obj instanceof PhoneContact) {
                            str = ((PhoneContact) obj).name;
                        } else {
                            str = "";
                        }
                        String str2 = str;
                        if (dVar.C.isEnabled()) {
                            if (dVar.f187210d.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                onListViewItemClick = FriendTabView.this.f285848d.onListViewItemClick(dVar.f187210d, str2, 4, "-1", "");
                            } else {
                                onListViewItemClick = FriendTabView.this.f285848d.onListViewItemClick(dVar.f187210d, str2, 0, "-1", "");
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + onListViewItemClick);
                            }
                            dVar.C.setChecked(onListViewItemClick);
                            if (AppSetting.f99565y) {
                                if (dVar.C.isChecked()) {
                                    view.setContentDescription(dVar.f285963i.getText().toString() + HardCodeUtil.qqStr(R.string.f172030mu2));
                                } else {
                                    view.setContentDescription(dVar.f285963i.getText().toString() + HardCodeUtil.qqStr(R.string.f172031mu3));
                                }
                            }
                            FriendTabView.this.g();
                            if (AppSetting.f99565y) {
                                view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.selectmember.FriendTabView.3.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ View f285665d;

                                    {
                                        this.f285665d = view;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) view);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            this.f285665d.sendAccessibilityEvent(8);
                                        }
                                    }
                                }, 2000L);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }, true);
        this.C = selectMemberBuddyListAdapter;
        this.f285663m.setAdapter(selectMemberBuddyListAdapter);
        this.f285663m.setSelector(R.color.ajr);
        this.f285663m.setGroupIndicator(this.f285848d.getResources().getDrawable(R.drawable.f160570ki));
        this.f285663m.setOnScrollListener(this.C);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f285850f.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && !iPhoneContactService.isBindContactOk()) {
            iPhoneContactService.getSelfBindState();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void d() {
        AppInterface appInterface;
        IPhoneContactService iPhoneContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.d();
        if (this.E && (appInterface = this.f285850f) != null && (iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")) != null) {
            int selfBindState = iPhoneContactService.getSelfBindState();
            if (selfBindState == 8 || selfBindState == 9) {
                try {
                    this.f285851h.i(0);
                } finally {
                    this.E = false;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void e(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.e(bundle);
            g();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = this.C;
        if (selectMemberBuddyListAdapter != null) {
            selectMemberBuddyListAdapter.M();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = this.C;
        if (selectMemberBuddyListAdapter != null) {
            selectMemberBuddyListAdapter.destroy();
        }
    }
}
