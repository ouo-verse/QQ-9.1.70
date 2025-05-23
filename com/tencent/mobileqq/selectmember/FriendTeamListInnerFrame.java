package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FriendTeamListInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private PinnedFooterExpandableListView D;
    private SelectMemberBuddyListAdapter E;
    List<Entity> F;
    private LinearLayout G;
    private RelativeLayout H;
    private Button I;
    private TextView J;
    private Button K;
    private Button L;
    private Button M;
    private Button N;
    private Button P;
    boolean Q;
    boolean R;
    private String S;
    private com.tencent.mobileqq.friend.observer.b T;
    RelationFriendsTroopViewHelper U;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements PinnedFooterExpandableListView.FooterExpandListViewListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this);
            }
        }

        @Override // com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener
        public void onClickHeader(PinnedFooterExpandableListView pinnedFooterExpandableListView, View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, pinnedFooterExpandableListView, view, Integer.valueOf(i3));
                return;
            }
            if (!FriendTeamListInnerFrame.this.Q) {
                int i16 = i3 - 1;
                if (i16 >= 0) {
                    pinnedFooterExpandableListView.collapseGroup(i16);
                } else if (QLog.isColorLevel()) {
                    QLog.d("FriendTeamListInnerFrameNew", 2, "header group unusal: " + i3);
                }
                FriendTeamListInnerFrame.this.Q = true;
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
                FriendTeamListInnerFrame.this.Q = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements IRelationFriendsTroopViewHelper.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public ArrayList<ResultRecord> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return FriendTeamListInnerFrame.this.f285782h.getResultRecordList();
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public ArrayList<String> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return FriendTeamListInnerFrame.this.f285782h.getSelectedUinList();
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            FriendTeamListInnerFrame.this.E.notifyDataSetChanged();
            if (FriendTeamListInnerFrame.this.E.getGroupCount() > 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b A = FriendTeamListInnerFrame.this.E.A(1007L);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b A2 = FriendTeamListInnerFrame.this.E.A(1008L);
                if (A != null || A2 != null) {
                    FriendTeamListInnerFrame.this.D.expandGroup(0);
                    FriendTeamListInnerFrame.this.D.setIsNeedScrollPositionTop(true);
                    FriendTeamListInnerFrame.this.D.smoothScrollToPositionFromTop(1, 0, 0);
                    if (A != null) {
                        FriendTeamListInnerFrame.this.U.l();
                    }
                    if (A2 != null) {
                        FriendTeamListInnerFrame.this.U.n();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements com.tencent.mobileqq.friend.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this);
            }
        }

        protected void a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                FriendTeamListInnerFrame.this.E.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 1) {
                if (z16 && ((Boolean) obj).booleanValue()) {
                    z17 = true;
                }
                a(z16, z17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements com.tencent.qqnt.troopmemberlist.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean z16, @NonNull List<? extends TroopMemberInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
            } else {
                FriendTeamListInnerFrame.this.t(new ArrayList(list));
            }
        }
    }

    public FriendTeamListInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.F = new ArrayList();
        this.Q = false;
        this.R = false;
    }

    @Override // com.tencent.common.app.InnerFrame
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.i(i3, i16, intent);
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
        Activity e16 = e();
        this.D = (PinnedFooterExpandableListView) e16.getLayoutInflater().inflate(R.layout.acu, (ViewGroup) null);
        this.Q = false;
        if (QLog.isColorLevel()) {
            QLog.d("FriendTeamListInnerFrameNew", 2, "firstUserClicked is " + this.Q);
        }
        this.D.setListener(new a());
        LinearLayout linearLayout = (LinearLayout) this.f285782h.getLayoutInflater().inflate(R.layout.acw, (ViewGroup) null);
        this.D.addHeaderView(linearLayout);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, ViewUtils.dpToPx(12.0f));
        View view = new View(this.f285782h);
        view.setLayoutParams(layoutParams);
        this.D.addHeaderView(view);
        QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
        this.E = new SelectMemberBuddyListAdapter(e16, this.f285784m, this.D, new View.OnClickListener() { // from class: com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object obj;
                String str;
                boolean onListViewItemClick;
                EventCollector.getInstance().onViewClickedBefore(view2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2);
                } else {
                    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
                    com.tencent.mobileqq.selectmember.d dVar = (com.tencent.mobileqq.selectmember.d) view2.getTag();
                    if (dVar != null && dVar.C != null && (obj = dVar.D) != null) {
                        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
                            str = ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).m();
                        } else if (obj instanceof Friends) {
                            str = ((Friends) obj).getFriendNickWithAlias();
                        } else if (obj instanceof PhoneContact) {
                            str = ((PhoneContact) obj).name;
                        } else if (obj instanceof RelationTroopEntity) {
                            FriendTeamListInnerFrame.this.f285782h.onRelationTroopItemClick(((RelationTroopEntity) obj).troopInfo.troopuin);
                            FriendTeamListInnerFrame.this.U.m();
                        } else if (obj instanceof RobotCoreInfo) {
                            str = ((RobotCoreInfo) obj).name;
                        } else if (obj instanceof TroopMemberInfo) {
                            str = ((TroopMemberInfo) obj).nickInfo.getShowName();
                        } else {
                            str = "";
                        }
                        if (dVar.C.isEnabled()) {
                            if (dVar.f187210d.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                onListViewItemClick = FriendTeamListInnerFrame.this.f285782h.onListViewItemClick(dVar.f187210d, str, 4, "-1");
                            } else {
                                onListViewItemClick = FriendTeamListInnerFrame.this.f285782h.onListViewItemClick(dVar.f187210d, str, 0, "-1");
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + onListViewItemClick);
                            }
                            if (dVar.F == 1007) {
                                FriendTeamListInnerFrame.this.U.k();
                            }
                            dVar.C.setChecked(onListViewItemClick);
                            if (AppSetting.f99565y) {
                                if (dVar.C.isChecked()) {
                                    view2.setContentDescription(dVar.f285963i.getText().toString() + HardCodeUtil.qqStr(R.string.mu5));
                                } else {
                                    view2.setContentDescription(dVar.f285963i.getText().toString() + HardCodeUtil.qqStr(R.string.f172032mu4));
                                }
                            }
                            FriendTeamListInnerFrame.this.p();
                            if (AppSetting.f99565y) {
                                view2.postDelayed(new Runnable(view2) { // from class: com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.2.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ View f285670d;

                                    {
                                        this.f285670d = view2;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) view2);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            this.f285670d.sendAccessibilityEvent(8);
                                        }
                                    }
                                }, 2000L);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        }, this.f285782h.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAMS_KEY_IS_EXPAND_FIRST, true));
        boolean isInviteMemberFromTroopSetting = this.f285782h.isInviteMemberFromTroopSetting();
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = this.E;
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberBuddyListAdapter.y(isInviteMemberFromTroopSetting, selectMemberActivity.mGroupCode, selectMemberActivity.mUinsSelectedDefault);
        this.D.setAdapter(this.E);
        this.D.setSelector(R.color.ajr);
        this.D.setGroupIndicator(null);
        this.D.setOnScrollListener(this.E);
        setContentView(this.D);
        RelationFriendsTroopViewHelper relationFriendsTroopViewHelper = new RelationFriendsTroopViewHelper(this.f285784m, this.D, new b());
        this.U = relationFriendsTroopViewHelper;
        this.E.L(relationFriendsTroopViewHelper);
        this.G = (LinearLayout) linearLayout.findViewById(R.id.ann);
        this.I = (Button) linearLayout.findViewById(R.id.agi);
        this.J = (TextView) linearLayout.findViewById(R.id.jgf);
        this.H = (RelativeLayout) linearLayout.findViewById(R.id.agj);
        this.K = (Button) linearLayout.findViewById(R.id.ahk);
        this.L = (Button) linearLayout.findViewById(R.id.ahp);
        this.P = (Button) linearLayout.findViewById(R.id.ahj);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f285784m.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && !iPhoneContactService.isBindContactOk()) {
            iPhoneContactService.getSelfBindState();
        }
        SelectMemberActivity selectMemberActivity2 = this.f285782h;
        if (selectMemberActivity2.mOnlyFriends) {
            this.G.setVisibility(8);
            if (this.f285782h.isSupportSelectFriendGroup) {
                this.P.setVisibility(0);
                this.P.setOnClickListener(this);
            } else {
                this.P.setVisibility(8);
            }
        } else {
            if (selectMemberActivity2.mDonotNeedContacts) {
                this.H.setVisibility(8);
            } else if (selectMemberActivity2.getSharedPreferences(this.f285784m.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.SELECT_MEMBER_CONTACTS_FLAG, 0) == 1) {
                this.I.setOnClickListener(this);
            } else {
                this.H.setVisibility(8);
            }
            this.K.setOnClickListener(this);
            this.L.setOnClickListener(this);
        }
        if (AppSetting.f99565y) {
            this.I.setContentDescription(this.f285782h.getString(R.string.f170109gf));
            this.K.setContentDescription(this.f285782h.getString(R.string.f170110gi));
        }
        Button button = (Button) linearLayout.findViewById(R.id.agm);
        this.M = button;
        button.setOnClickListener(this);
        this.M.setText(this.f285782h.getString(R.string.f170105g7));
        this.M.setContentDescription(this.f285782h.getString(R.string.f170105g7));
        if (!this.f285782h.getIntent().getBooleanExtra(ISelectMemberActivityConstants.MULTICHAT, false)) {
            this.M.setVisibility(8);
            this.L.setVisibility(8);
        }
        SelectMemberActivity selectMemberActivity3 = this.f285782h;
        if (selectMemberActivity3.mDonotNeedTroop && selectMemberActivity3.mDonotNeedDiscussion) {
            this.K.setVisibility(8);
        }
        c cVar = new c();
        this.T = cVar;
        this.f285784m.addObserver(cVar);
        boolean booleanExtra = this.f285782h.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAM_FACE_TO_FACE_INVITE, false);
        String stringExtra = this.f285782h.getIntent().getStringExtra("group_uin");
        this.S = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.S = this.f285782h.mGroupCode;
        }
        if (booleanExtra) {
            Button button2 = (Button) linearLayout.findViewById(R.id.agl);
            this.N = button2;
            button2.setVisibility(0);
            this.N.setContentDescription(this.f285782h.getString(R.string.f170104g6));
            this.N.setOnClickListener(this);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void l() {
        AppInterface appInterface;
        IPhoneContactService iPhoneContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.l();
        if (this.R && (appInterface = this.f285784m) != null && (iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")) != null) {
            int selfBindState = iPhoneContactService.getSelfBindState();
            if (selfBindState == 8 || selfBindState == 9) {
                try {
                    this.f285783i.i(1);
                } finally {
                    this.R = false;
                }
            }
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        selectMemberActivity.setupTitleBar(false, selectMemberActivity.getString(R.string.f173096hd0), this.f285782h.mTitleString);
        p();
        SelectMemberActivity selectMemberActivity2 = this.f285782h;
        if (selectMemberActivity2.mEntrance == 11 && selectMemberActivity2.mType == 1) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(selectMemberActivity2.getIntent().getStringExtra("group_uin"), this.f285782h, true, "FriendTeamListInnerFrameNew", new d());
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), kVar);
        }
        if (this.f285782h.mInnerFrameManager.b() == 0) {
            this.Q = true;
        }
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (!selectMemberActivity.mOnlyFriends) {
            if (!selectMemberActivity.mDonotNeedDiscussion) {
                i3 = 5;
            }
            if (!selectMemberActivity.mDonotNeedContacts) {
                i3 |= 256;
            }
            if (!selectMemberActivity.mDonotNeedTroop) {
                i3 |= 4194304;
            }
        }
        int i16 = selectMemberActivity.mEntrance;
        if (i16 == 42 || i16 == 41) {
            i3 = 16777216 | 8388608 | i3;
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        SelectMemberActivity selectMemberActivity2 = this.f285782h;
        return iSearchViewCreator.createContactSearchFragment(-1, i3, null, selectMemberActivity2.mUinsToHide, selectMemberActivity2, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TroopInfo i3;
        TroopInfo i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int i17 = 0;
            if (view == this.I) {
                this.f285783i.i(1);
                this.R = false;
                ReportController.o(this.f285784m, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
                if (this.f285782h.mEntrance == 11) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
                }
            } else if (view == this.K) {
                this.f285783i.i(3);
                if (this.f285782h.mSubType == 0) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
                } else {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
                }
                if (this.f285782h.mEntrance == 12) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
                }
                if (this.f285782h.mSubType == 1 && (i16 = com.tencent.mobileqq.selectmember.util.a.i(this.f285784m, this.S)) != null) {
                    String currentUin = this.f285784m.getCurrentUin();
                    if (!i16.isTroopOwner(currentUin)) {
                        if (i16.isTroopAdmin(currentUin)) {
                            i17 = 1;
                        } else {
                            i17 = 2;
                        }
                    }
                    ReportController.o(this.f285784m, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.S, String.valueOf(i17), "", "");
                }
            } else if (view == this.L) {
                com.tencent.mobileqq.troop.troopcreate.a.f(e());
                ReportController.o(this.f285784m, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
            } else if (view == this.M) {
                ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateFaceToFaceDiscussionActivity(this.f285782h);
                ReportController.o(this.f285784m, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
                if (this.f285782h.mEntrance == 12) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
                }
            } else if (view == this.P) {
                this.f285783i.i(8);
            } else if (view == this.N) {
                ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateCreateFaceToFaceInviteActivity(this.f285782h, this.S);
                if (this.f285782h.mSubType == 1 && (i3 = com.tencent.mobileqq.selectmember.util.a.i(this.f285784m, this.S)) != null) {
                    String currentUin2 = this.f285784m.getCurrentUin();
                    if (!i3.isTroopOwner(currentUin2)) {
                        if (i3.isTroopAdmin(currentUin2)) {
                            i17 = 1;
                        } else {
                            i17 = 2;
                        }
                    }
                    ReportController.o(this.f285784m, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.S, String.valueOf(i17), "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = this.E;
        if (selectMemberBuddyListAdapter != null) {
            selectMemberBuddyListAdapter.destroy();
        }
        this.f285784m.removeObserver(this.T);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        System.out.println("----->notifyDataSetChanged");
        SelectMemberBuddyListAdapter selectMemberBuddyListAdapter = this.E;
        if (selectMemberBuddyListAdapter != null) {
            selectMemberBuddyListAdapter.M();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void q(ResultRecord resultRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) resultRecord, i3);
        } else {
            super.q(resultRecord, i3);
            this.U.j(resultRecord, i3);
        }
    }

    protected void t(List<TroopMemberInfo> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onFetchMemberListData, troopMemberInfoList[");
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        sb5.append("]");
        QLog.w("FriendTeamListInnerFrameNew", 1, sb5.toString());
        String currentAccountUin = this.f285784m.getCurrentAccountUin();
        ArrayList arrayList = new ArrayList();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) this.f285784m.getRuntimeService(ITroopRobotService.class, "all");
        if (list != null) {
            for (TroopMemberInfo troopMemberInfo : list) {
                if (troopMemberInfo != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, memberuin[" + troopMemberInfo.memberuin + "]");
                    }
                    if (!TextUtils.equals(troopMemberInfo.memberuin, currentAccountUin)) {
                        if (!iTroopRobotService.isRobotUin(troopMemberInfo.memberuin) && !com.tencent.mobileqq.selectmember.util.a.m(this.f285784m, troopMemberInfo.memberuin)) {
                            arrayList.add(troopMemberInfo);
                        } else if (QLog.isDevelopLevel()) {
                            QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, isRobotUin");
                        }
                    }
                }
            }
        }
        ThreadManager.getUIHandler().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f285672d;

            {
                this.f285672d = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendTeamListInnerFrame.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                FriendTeamListInnerFrame.this.f285782h.setGroupMembers(this.f285672d);
                FriendTeamListInnerFrame.this.E.K(this.f285672d);
                FriendTeamListInnerFrame.this.E.notifyDataSetChanged();
            }
        });
    }

    public FriendTeamListInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.F = new ArrayList();
        this.Q = false;
        this.R = false;
    }

    public FriendTeamListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.F = new ArrayList();
        this.Q = false;
        this.R = false;
    }
}
