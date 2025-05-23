package com.tencent.mobileqq.fragment.blacklist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.fragment.blacklist.BlackListAdapter;
import com.tencent.mobileqq.fragment.blacklist.e;
import com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.UserDisplayData;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.relation.common.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BlackListFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private RelativeLayout C;
    private PinnedDividerListView D;
    protected IndexBar E;
    protected IndexBarTipsLayout F;
    protected RelativeLayout G;
    private IFaceDecoder H;
    private BlackListAdapter I;
    private TextView J;
    protected FormSimpleItem K;
    private BlackListViewModel L;
    private String M;
    private AppRuntime N;
    private DecodeTaskCompletionListener P;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            BlackListAdapter.d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BlackListFragment", 2, "uin=" + str + ", type=" + i16 + ",avatar= " + bitmap);
            }
            if (bitmap == null) {
                return;
            }
            int childCount = BlackListFragment.this.D.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = BlackListFragment.this.D.getChildAt(i17);
                if (childAt != null && (childAt.getTag() instanceof BlackListAdapter.d) && (dVar = (BlackListAdapter.d) childAt.getTag()) != null && !TextUtils.isEmpty(str) && str.equals(dVar.f211270f)) {
                    dVar.f211265a.setBackgroundDrawable(new BitmapDrawable(bitmap));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QPublicFragmentActivity.startForResult(BlackListFragment.this, (Class<? extends QPublicBaseFragment>) ShieldFriendsListFragmentV2.class, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 2) {
                BlackListFragment.this.I.j();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Observer<UserDisplayManager.a> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UserDisplayManager.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (BlackListFragment.this.L == null) {
                return;
            }
            if (aVar != null && aVar.f211350b != null) {
                ArrayList arrayList = new ArrayList();
                for (UserDisplayData userDisplayData : aVar.f211350b) {
                    if (ShieldFriendsListFragmentV2.uh(userDisplayData.uin)) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime == null || !(peekAppRuntime instanceof AppInterface)) {
                            QLog.e("BlackListFragment", 1, "AppInterface get faild, stop update");
                            userDisplayData.nickName = userDisplayData.uin;
                        }
                        userDisplayData.nickName = ac.Q((AppInterface) peekAppRuntime, userDisplayData.uin, 0);
                    } else if (TextUtils.isEmpty(userDisplayData.nickName)) {
                        userDisplayData.nickName = userDisplayData.uin;
                    }
                    arrayList.add(new e.a(userDisplayData.uin, userDisplayData.nickName, userDisplayData.avatar));
                }
                BlackListFragment.this.L.T1().postValue(BlackListFragment.this.L.b2(arrayList));
                return;
            }
            BlackListFragment.this.L.T1().postValue(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements Observer<com.tencent.mobileqq.fragment.blacklist.e> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.fragment.blacklist.e eVar) {
            LinkedHashMap<String, List<e.a>> linkedHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar != null && (linkedHashMap = eVar.f211316c) != null && !linkedHashMap.isEmpty()) {
                BlackListFragment.this.I.r(eVar);
                BlackListFragment.this.G.setVisibility(8);
                BlackListFragment.this.C.setVisibility(0);
            } else {
                BlackListFragment.this.G.setVisibility(0);
                BlackListFragment.this.C.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements IndexBar.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
        public void m(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (!z16) {
                BlackListFragment.this.M = "";
            }
            IndexBarTipsLayout indexBarTipsLayout = BlackListFragment.this.F;
            if (indexBarTipsLayout != null) {
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                indexBarTipsLayout.setVisibility(i3);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
        public void p1(String str, int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Float.valueOf(f16));
                return;
            }
            IndexBarTipsLayout indexBarTipsLayout = BlackListFragment.this.F;
            if (indexBarTipsLayout != null) {
                indexBarTipsLayout.setText(str, f16);
            }
            if (!BlackListFragment.this.M.equals(str)) {
                BlackListFragment.this.M = str;
                if ("\u2605".equals(str)) {
                    BlackListFragment.this.D.setSelection(0);
                    return;
                }
                int l3 = BlackListFragment.this.I.l(str);
                if (l3 != -1) {
                    BlackListFragment.this.D.setSelection(l3 + BlackListFragment.this.D.getHeaderViewsCount());
                }
            }
        }
    }

    public BlackListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.L = null;
        this.M = "";
        this.P = new a();
    }

    private void Ah() {
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
        builder.setImageType(10);
        builder.setTitle(getResources().getString(R.string.f201264uc));
        builder.setHalfScreenState(false);
        builder.setBackgroundColorType(0);
        builder.build();
        this.G = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f61802z4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        this.G.addView(builder.build(), layoutParams);
    }

    private void Bh() {
        this.E = (IndexBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.djh);
        this.F = (IndexBarTipsLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.dji);
        this.E.setOnIndexBarTouchListener(new f());
    }

    private void Ch() {
        this.C = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f59142rx);
        PinnedDividerListView pinnedDividerListView = (PinnedDividerListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ebs);
        this.D = pinnedDividerListView;
        pinnedDividerListView.mForContacts = true;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) getQBaseActivity().getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime());
        this.H = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this.P);
        BlackListAdapter blackListAdapter = new BlackListAdapter(getQBaseActivity(), this.H, this.E, this.L);
        this.I = blackListAdapter;
        this.D.setAdapter((ListAdapter) blackListAdapter);
        this.D.setOnTouchListener(new c());
    }

    private void Dh() {
        this.K = (FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.gsp);
        this.J = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.z6r);
        this.K.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setOnClickListener(new b());
        VideoReport.setElementId(this.K, "em_block_user_enter");
    }

    private void Eh() {
        this.L.P1();
        this.L.R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(int i3) {
        this.K.setRightText(i3 + HardCodeUtil.qqStr(R.string.p0g));
        this.K.setBgType(0);
    }

    private void initViewModel() {
        this.L.X1().observe(getQBaseActivity(), new d());
        this.L.a2();
        this.L.T1().observe(getQBaseActivity(), new e());
        this.L.U1().observe(getQBaseActivity(), new Observer<Integer>() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListFragment.7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.fragment.blacklist.BlackListFragment$7$a */
            /* loaded from: classes12.dex */
            public class a implements RelationBlacklistListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                public void onResult(boolean z16, Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() > 0) {
                    if (i.c().b()) {
                        if (((QIphoneTitleBarFragment) BlackListFragment.this).mContentView != null) {
                            VideoReport.setPageParams(((QIphoneTitleBarFragment) BlackListFragment.this).mContentView, new PageParams(new HashMap<String, String>() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListFragment.7.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                    } else {
                                        put("is_removing", "1");
                                    }
                                }
                            }));
                            VideoReport.reportPgIn(((QIphoneTitleBarFragment) BlackListFragment.this).mContentView);
                        }
                        BlackListFragment.this.K.setVisibility(8);
                        BlackListFragment.this.J.setVisibility(0);
                        ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendShieldListTransferRequest(new a());
                        return;
                    }
                    BlackListFragment.this.K.setVisibility(0);
                    BlackListFragment.this.J.setVisibility(8);
                    BlackListFragment.this.Fh(num.intValue());
                    return;
                }
                BlackListFragment.this.K.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        super.setTitle(HardCodeUtil.qqStr(R.string.f20415525));
        VideoReport.addToDetectionWhitelist(getActivity());
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        this.N = getQBaseActivity().getAppRuntime();
        this.L = (BlackListViewModel) getViewModel(BlackListViewModel.class);
        Dh();
        Bh();
        Ch();
        Ah();
        initViewModel();
        this.L.O1();
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_blacklist_manage");
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(new HashMap<String, String>() { // from class: com.tencent.mobileqq.fragment.blacklist.BlackListFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BlackListFragment.this);
                } else {
                    put("is_removing", "2");
                }
            }
        }));
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h08;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            this.N = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        Eh();
        BlackListAdapter blackListAdapter = this.I;
        if (blackListAdapter != null) {
            blackListAdapter.j();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
