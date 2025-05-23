package com.tencent.mobileqq.activity.contacts.troop;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ExpandableListAdapter;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.widget.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopFragment extends ContactsBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected ContactsTroopAdapter N;
    protected ContactsGroupPinnedHeaderExpandableListView P;
    protected d Q;
    protected c R;
    protected e S;
    protected n T;
    protected boolean U;
    private boolean V;
    private boolean W;
    private final SimpleEventReceiver<UpdateTroopListEvent> X;
    private final Observer<List<TroopInfo>> Y;
    private final Observer<Boolean> Z;

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f181805a0;

    /* renamed from: b0, reason: collision with root package name */
    private final ContactsTroopAdapter.i f181806b0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ContactsGroupPinnedHeaderExpandableListView extends ContactsPinnedHeaderExpandableListView {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private f f181807e;

        public ContactsGroupPinnedHeaderExpandableListView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // com.tencent.widget.PinnedHeaderExpandableListView
        public View initHeaderView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (getHeaderView() != null) {
                return getHeaderView();
            }
            if (isUseReplaceHeaderView()) {
                return this.f181807e.b();
            }
            return super.initHeaderView();
        }

        @Override // com.tencent.widget.PinnedHeaderExpandableListView
        public boolean isUseReplaceHeaderView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (AppSetting.f99565y && this.f181807e != null) {
                return true;
            }
            return false;
        }

        public void setListener(f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            } else {
                this.f181807e = fVar;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements SimpleEventReceiver<UpdateTroopListEvent> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<UpdateTroopListEvent>> getEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ArrayList<Class<UpdateTroopListEvent>> arrayList = new ArrayList<>();
            arrayList.add(UpdateTroopListEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof UpdateTroopListEvent) {
                try {
                    TroopFragment.this.Oh();
                } catch (Exception e16) {
                    QLog.e("contacts.fragment.TroopFragment", 1, "onReceive UpdateTroopListEvent", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ContactsTroopAdapter.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
            }
        }

        private void d(boolean z16, boolean z17) {
            if (z16) {
                TroopFragment.this.Oh();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit e(boolean z16, Boolean bool) {
            d(bool.booleanValue(), z16);
            return null;
        }

        @Override // com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.i
        public void a(DiscussionInfo discussionInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, discussionInfo, Boolean.valueOf(z16));
            } else {
                ((DiscussionHandler) ((ContactsBaseFragment) TroopFragment.this).E.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).p4(discussionInfo, !z16);
                d(true, false);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.i
        public void b(TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            } else {
                final boolean z16 = troopInfo.isTop;
                ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).requestSetTroopTop(TroopFragment.this, troopInfo.troopuin, !z16, true, new Function1() { // from class: com.tencent.mobileqq.activity.contacts.troop.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e16;
                        e16 = TroopFragment.b.this.e(z16, (Boolean) obj);
                        return e16;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopHead: isSuccess=" + z16 + ", uin=" + str);
            }
            if (z16) {
                TroopFragment.this.Oh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void c(String str, GroupMsgMask groupMsgMask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) groupMsgMask);
            } else {
                TroopFragment.this.Oh();
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                TroopFragment.this.Oh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends com.tencent.mobileqq.troop.onlinepush.api.b {
        static IPatchRedirector $redirector_;

        protected e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinepush.api.b
        protected void onTroopBlockStatusChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                TroopFragment.this.Oh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface f {
        View b();
    }

    public TroopFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.V = false;
        this.W = true;
        this.X = new a();
        this.Y = new Observer() { // from class: com.tencent.mobileqq.activity.contacts.troop.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFragment.this.Mh((List) obj);
            }
        };
        this.Z = new Observer() { // from class: com.tencent.mobileqq.activity.contacts.troop.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFragment.this.Nh((Boolean) obj);
            }
        };
        this.f181806b0 = new b();
    }

    private void Kh() {
        this.V = true;
        ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).fetchTroopList(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ View Lh() {
        LayoutInflater.from(this.K).inflate(QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z), (ViewGroup) this.f181805a0, true);
        if (this.f181805a0.getChildCount() > 1) {
            return this.f181805a0.getChildAt(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(List list) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "troopListObserver: ");
        }
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(Boolean bool) {
        ContactsBaseFragment.c cVar;
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "fetchTroopListResultObserver: result:" + bool);
        }
        if (this.V && (cVar = this.C) != null) {
            cVar.c(th(), bool.booleanValue(), null);
            this.V = false;
        }
    }

    private void Ph() {
        if (this.P != null) {
            ContactsTroopAdapter contactsTroopAdapter = this.N;
            if (contactsTroopAdapter != null) {
                contactsTroopAdapter.destroy();
            }
            ContactsTroopAdapter contactsTroopAdapter2 = new ContactsTroopAdapter(this.K, this.E, this.P, this.f181806b0);
            this.N = contactsTroopAdapter2;
            this.P.setAdapter(contactsTroopAdapter2);
            this.P.setOnGroupClickListener(this.N);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.E.removeObserver(this.Q);
        this.E.removeObserver(this.R);
        this.E.removeObserver(this.S);
        SimpleEventBus.getInstance().unRegisterReceiver(this.X);
    }

    void Oh() {
        ContactsTroopAdapter contactsTroopAdapter;
        if (this.W && (contactsTroopAdapter = this.N) != null) {
            contactsTroopAdapter.I();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
        }
        ContactsTroopAdapter contactsTroopAdapter = this.N;
        if (contactsTroopAdapter != null) {
            contactsTroopAdapter.destroy();
        }
        Ah();
        n nVar = this.T;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.P;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else if (this.E == null) {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.H) {
            if (this.Q == null) {
                this.Q = new d();
            }
            if (this.R == null) {
                this.R = new c();
            }
            if (this.S == null) {
                this.S = new e();
            }
            this.E.addObserver(this.Q);
            this.E.addObserver(this.R);
            SimpleEventBus.getInstance().registerReceiver(this.X);
            fx3.a<List<TroopInfo>> troopListLiveData = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopListLiveData();
            if (troopListLiveData != null) {
                troopListLiveData.observe(this, this.Y);
            }
            ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getFetchTroopListResultLiveData().observe(this, this.Z);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.W = false;
        ContactsGroupPinnedHeaderExpandableListView contactsGroupPinnedHeaderExpandableListView = this.P;
        if (contactsGroupPinnedHeaderExpandableListView != null) {
            contactsGroupPinnedHeaderExpandableListView.hideCurShowingRightView();
        }
        ContactsTroopAdapter contactsTroopAdapter = this.N;
        if (contactsTroopAdapter != null) {
            contactsTroopAdapter.G();
        }
        if (z16) {
            Ah();
        }
        if (this.U) {
            this.T.h();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Kh();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        ContactsTroopAdapter contactsTroopAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
        }
        Ph();
        if (this.H && (contactsTroopAdapter = this.N) != null) {
            contactsTroopAdapter.I();
        }
        this.T = new n(this.E, null, "Grp_time", "Grp_contactlist", "visit_time");
        if (isResumed()) {
            this.T.g();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "onResume:" + z16);
        }
        this.W = true;
        if (this.P == null) {
            return;
        }
        if (z16) {
            ph();
        }
        if (this.N == null) {
            Ph();
        }
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.troop.TroopFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopFragment.this.N.I();
                }
            }
        }, 200L);
        this.U = true;
        this.T.g();
        new q(this.E).i("dc00899").a("Grp_listNew").f("Grp_contactlist").d("exp").g();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        ViewParent parent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.TroopFragment", 2, "getView");
        }
        FrameLayout frameLayout = this.f181805a0;
        if (frameLayout == null && this.K != null) {
            this.f181805a0 = new FrameLayout(this.K);
            ContactsGroupPinnedHeaderExpandableListView contactsGroupPinnedHeaderExpandableListView = new ContactsGroupPinnedHeaderExpandableListView(this.K);
            this.P = contactsGroupPinnedHeaderExpandableListView;
            contactsGroupPinnedHeaderExpandableListView.setId(R.id.qb_troop_list_view);
            this.P.setSelector(R.color.ajr);
            this.P.setNeedCheckSpringback(true);
            this.P.setGroupIndicator(null);
            this.P.setDivider(null);
            Resources resources = getResources();
            if (resources != null) {
                this.P.setPadding(0, 0, 0, BaseAIOUtils.f(54.0f, resources));
            }
            this.P.setClipToPadding(false);
            this.P.setScrollBarStyle(33554432);
            ContactsGroupPinnedHeaderExpandableListView contactsGroupPinnedHeaderExpandableListView2 = this.P;
            contactsGroupPinnedHeaderExpandableListView2.mForContacts = true;
            contactsGroupPinnedHeaderExpandableListView2.setOnScrollListener(this);
            this.f181805a0.addView(this.P);
            this.P.setListener(new f() { // from class: com.tencent.mobileqq.activity.contacts.troop.e
                @Override // com.tencent.mobileqq.activity.contacts.troop.TroopFragment.f
                public final View b() {
                    View Lh;
                    Lh = TroopFragment.this.Lh();
                    return Lh;
                }
            });
        } else if (frameLayout != null && (parent = frameLayout.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f181805a0);
        }
        this.T = new n(this.E, null, "Grp_time", "Grp_contactlist", "visit_time");
        return this.f181805a0;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void wh() {
        ContactsTroopAdapter contactsTroopAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.H && (contactsTroopAdapter = this.N) != null) {
            contactsTroopAdapter.G();
        }
        n nVar = this.T;
        if (nVar != null) {
            nVar.h();
        }
        super.wh();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void xh() {
        ContactsTroopAdapter contactsTroopAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.P != null && (contactsTroopAdapter = this.N) != null) {
            contactsTroopAdapter.m();
            if (this.P.getFirstVisiblePosition() > 0) {
                this.P.setSelection(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ContactsPinnedHeaderExpandableListView extends SwipPinnedHeaderExpandableListView {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f181808d;

        public ContactsPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f181808d = true;
            } else {
                iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView
        protected void scrollItemView(int i3, int i16, View view, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), view, Integer.valueOf(i17));
            } else if (this.f181808d) {
                super.scrollItemView(i3, i16, view, i17);
            }
        }

        public void setChildViewCanAction(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
                return;
            }
            ExpandableListAdapter expandableListAdapter = getExpandableListAdapter();
            if (expandableListAdapter instanceof BuddyListAdapter) {
                ((BuddyListAdapter) expandableListAdapter).y(z16);
            }
            this.f181808d = z16;
        }

        public ContactsPinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f181808d = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            }
        }

        public ContactsPinnedHeaderExpandableListView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f181808d = true;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
        }
    }
}
