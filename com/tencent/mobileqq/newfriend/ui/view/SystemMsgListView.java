package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV3;
import com.tencent.mobileqq.newfriend.ui.builder.h;
import com.tencent.mobileqq.newfriend.ui.builder.k;
import com.tencent.mobileqq.newfriend.ui.builder.l;
import com.tencent.mobileqq.newfriend.ui.builder.m;
import com.tencent.mobileqq.newfriend.ui.fragment.NewFriendFragment;
import com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SystemMsgListView extends BaseNewFriendView implements Observer, od2.a, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    public static final int f254183i0;
    protected TextView C;
    protected SwipListView D;
    protected View E;
    private QQProgressDialog F;
    protected Context G;
    protected SystemMsgListAdapter H;
    protected NewFriendServiceImpl I;
    protected FlingHandler J;
    protected int K;
    protected ViewGroup L;
    protected ViewGroup M;
    protected ThemeTabLayout N;
    protected com.tencent.mobileqq.activity.contact.connections.b P;
    protected SparseArray<com.tencent.mobileqq.activity.contact.connections.b> Q;
    private SparseArray<Boolean> R;
    private boolean S;
    public boolean T;
    Handler U;
    private TabLayoutCompat.c V;
    com.tencent.mobileqq.friend.observer.a W;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.newfriend.observer.a f254184a0;

    /* renamed from: b0, reason: collision with root package name */
    com.tencent.mobileqq.discussion.observer.a f254185b0;

    /* renamed from: c0, reason: collision with root package name */
    com.tencent.mobileqq.newfriend.observer.b f254186c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.newfriend.observer.d f254187d0;

    /* renamed from: e0, reason: collision with root package name */
    public final int f254188e0;

    /* renamed from: f0, reason: collision with root package name */
    public AbsListView.OnScrollListener f254189f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f254190g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f254191h0;

    /* renamed from: m, reason: collision with root package name */
    protected RelativeLayout f254192m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SystemMsgListView.this.A(i3);
                SystemMsgListAdapter systemMsgListAdapter = SystemMsgListView.this.H;
                if (systemMsgListAdapter != null) {
                    systemMsgListAdapter.w(i3, i16, i17);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            SystemMsgListView systemMsgListView = SystemMsgListView.this;
            if (systemMsgListView.H != null && !systemMsgListView.S) {
                if (i3 != 0 && i3 != 1) {
                    SystemMsgListView.this.H.s();
                } else {
                    SystemMsgListView.this.H.x();
                    SystemMsgListView.this.H.y();
                }
                if (i3 == 0) {
                    SystemMsgListView.this.H.v();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1012) {
                if (i3 == 1016) {
                    QQToast.makeText(SystemMsgListView.this.G, 1, SystemMsgListView.this.G.getResources().getString(R.string.huj), 0).show(SystemMsgListView.this.r());
                    return;
                }
                return;
            }
            SystemMsgListView systemMsgListView = SystemMsgListView.this;
            if (systemMsgListView.H != null) {
                systemMsgListView.x();
                SystemMsgListView.this.H.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (baseQQAppInterface != null) {
                    ax c16 = bi.c(baseQQAppInterface, SystemMsgListView.this.G, "mqqapi://mayknown/homepage?from=7");
                    if (c16 != null) {
                        c16.b();
                    } else {
                        QLog.w("Q.newfriendSystemMsgListView", 1, "#jumpToXSJSearchPage: no jumpAction, jumpUrl=mqqapi://mayknown/homepage?from=7");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements androidx.lifecycle.Observer<Boolean> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
            } else {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("new_friend_sys_empty_builder", false)) {
                    return;
                }
                if (bool.booleanValue()) {
                    SystemMsgListView.this.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
                } else {
                    SystemMsgListView.this.setBackground(null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements TabLayoutCompat.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void J8(TabLayoutCompat.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void c(TabLayoutCompat.f fVar) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
                return;
            }
            if (fVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + fVar.d() + " tabid = " + ((Integer) fVar.f()));
                }
                SystemMsgListView.this.H.z(((Integer) fVar.f()).intValue(), fVar.d());
                com.tencent.mobileqq.activity.contact.connections.b bVar = SystemMsgListView.this.Q.get(SystemMsgListView.this.H.a());
                if (bVar != null) {
                    i3 = bVar.f181260b;
                    i16 = bVar.f181261c;
                } else {
                    com.tencent.mobileqq.activity.contact.connections.b bVar2 = SystemMsgListView.this.P;
                    i3 = bVar2.f181260b;
                    i16 = bVar2.f181261c;
                }
                SystemMsgListView.this.D.setSelectionFromTop(i3, i16);
                SystemMsgListView.this.H.h(0L);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void l3(TabLayoutCompat.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        public void onAddBatchPhoneFriend(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                SystemMsgListView.this.H.g();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (z16) {
                String string = bundle.getString("uin");
                int i3 = bundle.getInt("source_id");
                String string2 = bundle.getString("extra");
                if ((i3 == 3006 || i3 == 3075) && "ContactMatchBuilder".equals(string2)) {
                    SystemMsgListView.this.w(string);
                }
                if (friendlist.a.a(i3)) {
                    SystemMsgListView.this.H.g();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g extends com.tencent.mobileqq.newfriend.observer.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            SystemMsgListAdapter systemMsgListAdapter = SystemMsgListView.this.H;
            if (systemMsgListAdapter != null) {
                systemMsgListAdapter.g();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void d(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onCancelMayKnowRecommend " + str);
            }
            if (z16 && !((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData().isEmpty()) {
                SystemMsgListView.this.H.g();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void e(boolean z16, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetConnectionsPerson " + z16 + " " + i3 + " " + i16);
            }
            if (z16) {
                com.tencent.mobileqq.activity.contact.connections.c p16 = SystemMsgListView.this.H.p();
                if (p16 != null && p16.a() && p16.f181262a == i16 && !SystemMsgListView.this.u(i16, i17)) {
                    SystemMsgListView.this.H.h(0L);
                    return;
                }
                return;
            }
            if (i3 == 1205) {
                SystemMsgListView.this.H.h(0L);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetMayKnowRecommend " + z16);
            }
            if (z16) {
                SystemMsgListView.this.H.g();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        protected void i(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
            } else if (z16) {
                SystemMsgListView.this.H.g();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.a
        public void j(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onSuspiciousGetUnreadNum " + z16 + " " + i3 + " " + i16);
            }
            if (z16) {
                SystemMsgListView.this.H.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class h extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
            } else if (z16) {
                SystemMsgListView.this.H.n(j3);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void g(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                try {
                    SystemMsgListView.this.H.n(Long.parseLong(str));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            ArrayList arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16) {
                if (obj instanceof ArrayList) {
                    arrayList = (ArrayList) obj;
                } else {
                    arrayList = null;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next instanceof Long) {
                            SystemMsgListView.this.H.n(((Long) next).longValue());
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class i extends com.tencent.mobileqq.newfriend.observer.d {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.d
        public void b(boolean z16, List<AddFriendBlockedInfo> list, String str) {
            SystemMsgListAdapter systemMsgListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetAddFriendBlockedList, success=" + z16);
            }
            if (z16 && (systemMsgListAdapter = SystemMsgListView.this.H) != null) {
                systemMsgListAdapter.g();
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.d
        public void c(boolean z16, boolean z17, boolean z18, String str, boolean z19) {
            SystemMsgListAdapter systemMsgListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Boolean.valueOf(z19));
            } else if (!((Activity) SystemMsgListView.this.G).isFinishing() && z16 && (systemMsgListAdapter = SystemMsgListView.this.H) != null) {
                systemMsgListAdapter.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class j extends com.tencent.mobileqq.newfriend.observer.b {
        static IPatchRedirector $redirector_;

        public j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetDelSystemMsgError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgError");
            }
            SystemMsgListView.this.p();
            SystemMsgListView.this.U.sendEmptyMessage(1016);
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetDelSystemMsgFin(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.bengin");
            }
            SystemMsgListView.this.p();
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.success");
                }
                SystemMsgListAdapter systemMsgListAdapter = SystemMsgListView.this.H;
                if (systemMsgListAdapter != null) {
                    systemMsgListAdapter.g();
                    return;
                }
                return;
            }
            if (z17) {
                SystemMsgListView.this.U.sendEmptyMessage(1016);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
            }
            if (!((Activity) SystemMsgListView.this.G).isFinishing() && z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
                }
                try {
                    SystemMsgListAdapter systemMsgListAdapter = SystemMsgListView.this.H;
                    if (systemMsgListAdapter != null) {
                        systemMsgListAdapter.g();
                    }
                    SystemMsgListView.this.x();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onSendSystemMsgActionError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            if (SystemMsgListView.this.f254172d.stopProgress()) {
                QQToast.makeText(SystemMsgListView.this.G, 1, SystemMsgListView.this.G.getResources().getString(R.string.huv), 0).show(SystemMsgListView.this.r());
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionError");
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.b
        protected void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18));
                return;
            }
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            SystemMsgListView.this.U.sendEmptyMessage(1012);
            structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
            if (!SystemMsgListView.this.f254172d.stopProgress()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin");
                    return;
                }
                return;
            }
            if (!z16) {
                if (!TextUtils.isEmpty(str3)) {
                    string = str3;
                } else {
                    string = SystemMsgListView.this.G.getResources().getString(R.string.he7);
                }
                QQToast.makeText(SystemMsgListView.this.G, 1, string, 0).show(SystemMsgListView.this.r());
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActionsWhenFail(structMsgFromMap, i17, str2, str4);
                return;
            }
            QQToast.makeText(SystemMsgListView.this.G, 2, SystemMsgListView.this.G.getResources().getString(R.string.bcs), 0).show(SystemMsgListView.this.r());
            long currentUniseq = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrentUniseq();
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).changeStructMsgActions(structMsgFromMap, i3, str2, i16);
            if (currentUniseq != 0 && structMsgFromMap != null) {
                try {
                    ((IMessageFacade) SystemMsgListView.this.f254173e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, currentUniseq, structMsgFromMap.toByteArray());
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
                    }
                }
            }
            if (i3 == 0 && structMsgFromMap != null) {
                Bundle bundle = new Bundle();
                bundle.putString("base_uin", String.valueOf(structMsgFromMap.req_uin.get()));
                String str5 = structMsgFromMap.f436065msg.req_uin_nick.get();
                if (TextUtils.isEmpty(str5)) {
                    str5 = String.valueOf(structMsgFromMap.req_uin.get());
                }
                bundle.putString("base_nick", str5);
                bundle.putInt("verfy_type", structMsgFromMap.f436065msg.sub_type.get());
                bundle.putString("verfy_msg", structMsgFromMap.f436065msg.msg_additional.get());
                if (com.tencent.mobileqq.newfriend.msg.c.h(SystemMsgListView.this.f254173e, String.valueOf(structMsgFromMap.req_uin.get()), structMsgFromMap, false)) {
                    String str6 = new String(structMsgFromMap.f436065msg.bytes_game_nick.get().toByteArray());
                    if (!TextUtils.isEmpty(str6)) {
                        str5 = KplRoleInfo.WZRYUIinfo.buildNickName(str5, str6);
                    }
                    bundle.putString("base_nick", str5);
                    bundle.putBoolean("isFromWzry", true);
                }
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startRemarkAfterAgree(SystemMsgListView.this.f254172d.getActivity(), 0, String.valueOf(structMsgFromMap.req_uin.get()), currStructMsgKey, bundle);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35204);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            f254183i0 = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getRequestForSetting();
        }
    }

    public SystemMsgListView(Context context, FlingHandler flingHandler) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) flingHandler);
            return;
        }
        this.Q = new SparseArray<>();
        this.R = new SparseArray<>();
        this.S = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103159", true);
        this.T = false;
        this.U = new b();
        this.V = new e();
        this.W = new f();
        this.f254184a0 = new g();
        this.f254185b0 = new h();
        this.f254186c0 = new j();
        this.f254187d0 = new i();
        this.f254188e0 = 0;
        this.f254189f0 = new a();
        this.f254190g0 = -1;
        this.f254191h0 = 0.0f;
        this.G = context;
        this.J = flingHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3) {
        SystemMsgListAdapter systemMsgListAdapter;
        if (((NewFriendActivity) this.G) != null && (systemMsgListAdapter = this.H) != null) {
            if (i3 < 0) {
                this.M.setVisibility(4);
                return;
            }
            if (i3 >= systemMsgListAdapter.getCount()) {
                return;
            }
            Object item = this.H.getItem(i3);
            if (i3 == 0 && ((item instanceof com.tencent.mobileqq.newfriend.ui.builder.e) || (item instanceof NewFriendBindContactGuideBuilderV3))) {
                this.M.setVisibility(4);
                return;
            }
            if (item instanceof m) {
                this.M.setVisibility(4);
                return;
            }
            if (item instanceof l) {
                this.M.setVisibility(4);
            } else if (item instanceof k) {
                this.M.setVisibility(4);
            } else {
                v(i3);
            }
        }
    }

    private LifecycleOwner q() {
        BaseNewFriendView.a aVar = this.f254172d;
        if (aVar == null) {
            return null;
        }
        if (aVar instanceof NewFriendActivity) {
            return (NewFriendActivity) aVar;
        }
        if (!(aVar instanceof NewFriendFragment)) {
            return null;
        }
        return (NewFriendFragment) aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(int i3, int i16) {
        if (i16 == ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getMayKnowLoadConnectionBizTypeFirstLoad()) {
            Boolean bool = this.R.get(i3);
            if (bool != null && (bool instanceof Boolean)) {
                return bool.booleanValue();
            }
            this.R.put(i3, Boolean.TRUE);
            return false;
        }
        return false;
    }

    private void v(int i3) {
        TextView textView;
        if (((com.tencent.mobileqq.newfriend.ui.builder.d) this.H.getItem(i3)) instanceof com.tencent.mobileqq.newfriend.ui.builder.h) {
            this.f254190g0 = i3;
            View childAt = this.D.getChildAt(0);
            if (childAt != null && !this.M.isShown()) {
                this.M.setVisibility(0);
                Object tag = childAt.getTag();
                if ((tag instanceof h.b) && (textView = ((h.b) tag).f254124a) != null) {
                    float scrollX = textView.getScrollX();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.newfriendSystemMsgListView", 2, "visible position: scrollPosOffset = " + scrollX);
                    }
                }
                this.P.f181260b = this.D.getFirstVisiblePosition();
                this.P.f181261c = childAt.getTop();
                return;
            }
            return;
        }
        int i16 = this.f254190g0;
        if (i16 <= -1) {
            this.M.setVisibility(4);
        } else if (i3 > i16) {
            this.M.setVisibility(0);
        } else if (this.M.isShown()) {
            this.M.setVisibility(4);
        }
    }

    private void z() {
        this.f254173e.removeObserver(this.f254185b0);
        this.f254173e.removeObserver(this.f254184a0);
        this.f254173e.removeObserver(this.W);
        this.f254173e.removeObserver(this.f254186c0);
        this.f254173e.removeObserver(this.f254187d0);
        ((IMessageFacade) this.f254173e.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.F == null) {
            this.F = new QQProgressDialog(this.G, r());
        }
        this.F.setMessage(this.G.getString(R.string.hex));
        this.F.show();
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, j3);
        }
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.I.updateBindContactGuideState();
        if (this.I.isShowContactGuide()) {
            this.D.setOverscrollHeader(getResources().getDrawable(R.drawable.skin_header_bar_bg));
            ReportController.o(this.f254173e, "dc00898", "", "", "0X80077C6", "0X80077C6", 0, 0, "", "", "", "");
        } else {
            this.D.setOverscrollHeader(null);
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, "onBindStateChanged state: " + i3);
        }
        C();
        this.H.g();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void c(int i3, int i16, Intent intent) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 222 && i3 != 223 && i3 != 224 && i3 != 225 && i3 != 226 && i3 != 227 && i3 != 228 && i3 != 229 && i3 != 221 && i3 != 231 && i3 != 232) {
            if (i3 == 230) {
                if (QLog.isColorLevel()) {
                    QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + i3 + ", src: 15");
                }
                if (i16 == -1) {
                    this.H.g();
                }
            } else if (i3 == f254183i0) {
                if (QLog.isColorLevel()) {
                    QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
                }
                if (this.H.getCount() > 0) {
                    obj = this.H.getItem(0);
                } else {
                    obj = null;
                }
                if ((obj instanceof NewFriendBindContactGuideBuilderV3) && ((IPhoneContactService) this.f254173e.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.f254173e, -1, 2, null);
                }
            }
        } else {
            this.H.g();
        }
        super.c(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void d(Intent intent, BaseNewFriendView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) aVar);
            return;
        }
        super.d(intent, aVar);
        this.I = (NewFriendServiceImpl) this.f254173e.getRuntimeService(INewFriendService.class, "");
        ((IPhoneContactService) this.f254173e.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
        t();
        C();
        s(intent);
        o();
        this.D.setDragEnable(true);
        if (!AppSetting.t(this.G)) {
            this.D.setOnScrollListener(this.f254189f0);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.e();
        z();
        this.I.markAllDataReaded();
        this.Q.clear();
        this.R.clear();
        SystemMsgListAdapter systemMsgListAdapter = this.H;
        if (systemMsgListAdapter != null) {
            systemMsgListAdapter.destroy();
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).clearStructMsgMap();
        ((IPhoneContactService) this.f254173e.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
        this.G = null;
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.f();
        if (this.H.a() == 23) {
            this.H.B();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.g();
        if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, "onResume");
        }
        this.H.x();
        if (this.H.a() == 23) {
            this.H.A();
        }
        this.H.h(0L);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.i();
        this.H.s();
        ((INewFriendVerificationService) this.f254173e.getRuntimeService(INewFriendVerificationService.class, "")).leaveNewFriend();
        if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, DKHippyEvent.EVENT_STOP);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f254173e.addObserver(this.f254185b0, true);
        this.f254173e.addObserver(this.f254184a0);
        this.f254173e.addObserver(this.W);
        this.f254173e.addObserver(this.f254186c0);
        this.f254173e.addObserver(this.f254187d0);
        ((IMessageFacade) this.f254173e.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f166855m84) {
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity) this.G);
            ReportController.o(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    void p() {
        QQProgressDialog qQProgressDialog = this.F;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.F.dismiss();
        }
        this.F = null;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public void s(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
            return;
        }
        SystemMsgListAdapter systemMsgListAdapter = new SystemMsgListAdapter(this.G, this.f254173e, this.D, this, intent.getIntExtra("EntranceId", 0), this.J);
        this.H = systemMsgListAdapter;
        this.D.setAdapter((ListAdapter) systemMsgListAdapter);
        LifecycleOwner q16 = q();
        if (q16 != null) {
            this.H.L.observe(q16, new d());
        }
        x();
        this.P = new com.tencent.mobileqq.activity.contact.connections.b(23, 0, 0);
        if (((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).isSuspiciousSwitchOpen()) {
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getSuspiciousFriendsUnreadNum(this.f254173e);
        }
        ((INewFriendVerificationService) this.f254173e.getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedList(this.f254173e.getCurrentAccountUin());
    }

    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (i3 >= 0 && i3 < this.H.getCount()) {
            this.D.setSelection(i3);
        }
    }

    public void setStickHeadSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (this.N != null) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHeadSelection position : " + i3);
            }
            this.N.e(i3);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.j(R.layout.h5i);
        this.f254192m = (RelativeLayout) findViewById(R.id.ebg);
        this.C = (TextView) findViewById(R.id.title);
        this.L = (ViewGroup) findViewById(R.id.lgf);
        this.D = (SwipListView) findViewById(R.id.j9v);
        this.E = findViewById(R.id.f_a);
        this.K = getResources().getDimensionPixelSize(R.dimen.f159224xu);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f83304j7);
        this.M = viewGroup;
        viewGroup.setOnClickListener(new c());
        this.M.setVisibility(4);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) observable, obj);
        } else {
            this.f254173e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SystemMsgListView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SystemMsgListView.this.x();
                    }
                }
            });
        }
    }

    public void w(String str) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (!((IPhoneContactService) this.f254173e.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
            String string = this.f254173e.getPreferences().getString("systemmsg_addFriendCount", "");
            boolean z16 = false;
            if (TextUtils.isEmpty(string)) {
                split = new String[0];
            } else {
                split = string.split(":");
            }
            if (split.length >= 3) {
                return;
            }
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (TextUtils.equals(split[i3], str)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                if (split.length != 0) {
                    str = string + ":" + str;
                }
                string = str;
            }
            this.f254173e.getPreferences().edit().putString("systemmsg_addFriendCount", string).commit();
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            if (this.H.getCount() > 0) {
                this.f254192m.setVisibility(0);
                this.E.setVisibility(8);
            } else {
                this.E.setVisibility(0);
                this.f254192m.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public void y(ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList, i3);
            return;
        }
        ThemeTabLayout themeTabLayout = this.N;
        if (themeTabLayout != null) {
            themeTabLayout.c();
            this.N.d(this.V);
            this.N.a(arrayList, i3);
            this.N.setOnTabSelectedListener(this.V);
        }
    }
}
