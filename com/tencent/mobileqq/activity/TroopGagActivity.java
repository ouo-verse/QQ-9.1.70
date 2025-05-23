package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopGagUtils;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TroopGagActivity extends IphoneTitleBarActivity implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    XListView f177322a0;

    /* renamed from: b0, reason: collision with root package name */
    b f177323b0;

    /* renamed from: c0, reason: collision with root package name */
    String f177324c0;

    /* renamed from: d0, reason: collision with root package name */
    TroopInfo f177325d0;

    /* renamed from: e0, reason: collision with root package name */
    LinearLayout f177326e0;

    /* renamed from: f0, reason: collision with root package name */
    View f177327f0;

    /* renamed from: g0, reason: collision with root package name */
    LinearLayout f177328g0;

    /* renamed from: h0, reason: collision with root package name */
    Switch f177329h0;

    /* renamed from: i0, reason: collision with root package name */
    List<TroopMemberInfo> f177330i0;

    /* renamed from: j0, reason: collision with root package name */
    private List<String> f177331j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f177332k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f177338a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f177339b;

        a(long j3, String str) {
            this.f177338a = j3;
            this.f177339b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopGagActivity.this, Long.valueOf(j3), str);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            if (!z16) {
                com.tencent.mobileqq.troop.api.config.aa.a().d(com.tencent.mobileqq.troop.utils.bg.e(), this.f177338a);
            }
            AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
            if (e16 == null) {
                QLog.e("TroopGagActivity", 1, "[doGagTroop] app in null");
                return;
            }
            Object businessHandler = e16.getBusinessHandler(TroopGagHandler.class.getName());
            if (businessHandler instanceof com.tencent.mobileqq.troop.troopgag.api.a) {
                ((com.tencent.mobileqq.troop.troopgag.api.a) businessHandler).C(new com.tencent.mobileqq.troop.troopgag.data.a(this.f177339b, new com.tencent.mobileqq.troop.troopgag.data.c(z16, this.f177338a)));
            } else {
                QLog.e("TroopGagActivity", 1, "[doGagTroop] busHandler illegal");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends com.tencent.mobileqq.adapter.j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        private class a extends com.tencent.mobileqq.adapter.k {
            static IPatchRedirector $redirector_;
            Button C;

            /* renamed from: i, reason: collision with root package name */
            TextView f177341i;

            /* renamed from: m, reason: collision with root package name */
            TextView f177342m;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }
        }

        public b() {
            super(TroopGagActivity.this, TroopGagActivity.this.app, TroopGagActivity.this.f177322a0, 1, false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGagActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int size = TroopGagActivity.this.f177330i0.size();
            if (size > 0) {
                return size + 1;
            }
            return size;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (i3 > 0) {
                return TroopGagActivity.this.f177330i0.get(i3 - 1);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            View view3;
            MemberRole memberRole;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                view2 = (View) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (i3 > 0) {
                    if (view != null && view.getTag() != null) {
                        aVar = (a) view.getTag();
                    } else {
                        view = ((LayoutInflater) TroopGagActivity.this.getSystemService("layout_inflater")).inflate(R.layout.a1y, viewGroup, false);
                        aVar = new a();
                        aVar.f187212f = (ImageView) view.findViewById(R.id.f163821d);
                        aVar.f177341i = (TextView) view.findViewById(R.id.nickname);
                        aVar.f177342m = (TextView) view.findViewById(R.id.cqh);
                        aVar.C = (Button) view.findViewById(R.id.f166881iv1);
                        view.setTag(aVar);
                    }
                    TroopMemberInfo troopMemberInfo = (TroopMemberInfo) getItem(i3);
                    aVar.f187212f.setImageBitmap(c(1, troopMemberInfo.memberuin));
                    aVar.f177341i.setText(troopMemberInfo.nickInfo.getShowName());
                    aVar.C.setTag(troopMemberInfo);
                    aVar.f177342m.setText(h(troopMemberInfo.gagTimeStamp));
                    aVar.C.setOnClickListener(this);
                    aVar.C.setEnabled(true);
                    aVar.f187210d = troopMemberInfo.memberuin;
                    if (!TroopGagActivity.this.f177325d0.isOwner() && ((memberRole = troopMemberInfo.role) == MemberRole.ADMIN || memberRole == MemberRole.OWNER)) {
                        aVar.C.setEnabled(false);
                    }
                    if (getCount() == 1) {
                        com.tencent.mobileqq.widget.o.m(view, 0, true);
                    } else if (i3 == 1) {
                        com.tencent.mobileqq.widget.o.m(view, 1, true);
                    } else if (i3 == getCount() - 1) {
                        com.tencent.mobileqq.widget.o.m(view, 3, true);
                    } else {
                        com.tencent.mobileqq.widget.o.m(view, 2, true);
                    }
                    view2 = view;
                    view3 = view2;
                    EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                    return view2;
                }
                view2 = TroopGagActivity.this.f177326e0;
            }
            view3 = view;
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        protected String h(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
            String transformGagTimeForSettingUI = ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).transformGagTimeForSettingUI(j3);
            if (TextUtils.isEmpty(transformGagTimeForSettingUI)) {
                return "";
            }
            return "" + transformGagTimeForSettingUI;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof TroopMemberInfo) {
                    TroopMemberInfo troopMemberInfo = (TroopMemberInfo) tag;
                    TroopGagActivity.this.M2(troopMemberInfo);
                    TroopGagActivity.this.f177330i0.remove(troopMemberInfo);
                    TroopGagActivity.this.f177331j0.add(troopMemberInfo.memberuin);
                    notifyDataSetChanged();
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + troopMemberInfo.memberuin);
                    }
                    ReportController.o(TroopGagActivity.this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, TroopGagActivity.this.f177324c0 + "", ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getTroopOwnerReportStr(TroopGagActivity.this.f177324c0), "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopGagActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177330i0 = new ArrayList();
        this.f177331j0 = new ArrayList();
        this.f177332k0 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(TroopMemberInfo troopMemberInfo) {
        ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).setMemberShutUp(this.f177324c0, troopMemberInfo.memberUid, 0L, this, "TroopGagActivity", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.activity.TroopGagActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGagActivity.this);
                }
            }

            @Override // com.tencent.qqnt.troop.i
            public void onResult(boolean z16, int i3, @NonNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable(z16, i3, str) { // from class: com.tencent.mobileqq.activity.TroopGagActivity.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f177334d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f177335e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f177336f;

                        {
                            this.f177334d = z16;
                            this.f177335e = i3;
                            this.f177336f = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                TroopGagActivity.this.P2(this.f177334d, this.f177335e, this.f177336f);
                            }
                        }
                    });
                }
            }
        });
    }

    private void N2(String str, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f177332k0 < 200) {
            QLog.e("TroopGagActivity", 1, "doGagTroop: click over limit, troopCode=" + str + ", timestamp=" + j3, new Throwable());
            return;
        }
        this.f177332k0 = currentTimeMillis;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopShutUpTime(str, j3, this, new a(j3, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(List list) {
        this.f177330i0.clear();
        this.f177330i0.addAll(list);
        this.f177323b0.notifyDataSetChanged();
        if (this.f177323b0.getCount() == 0) {
            this.f177327f0.setVisibility(8);
        } else {
            this.f177327f0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(List list) {
        if (list != null && !list.isEmpty()) {
            this.f177330i0.clear();
            this.f177330i0.addAll(list);
        }
        this.f177323b0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2(final List list) {
        ArrayList arrayList = new ArrayList();
        List<String> list2 = this.f177331j0;
        if (list2 != null) {
            for (String str : list2) {
                Iterator<TroopMemberInfo> it = this.f177330i0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        TroopMemberInfo next = it.next();
                        if (next.memberuin.equals(str)) {
                            arrayList.add(next);
                            break;
                        }
                    }
                }
            }
            list.removeAll(arrayList);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.fv
            @Override // java.lang.Runnable
            public final void run() {
                TroopGagActivity.this.R2(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2(final List<TroopMemberInfo> list) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ft
            @Override // java.lang.Runnable
            public final void run() {
                TroopGagActivity.this.Q2(list);
            }
        });
        getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.app.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.f177324c0, System.currentTimeMillis()).commit();
        if (QLog.isColorLevel()) {
            QLog.d("TroopGagActivity", 2, "onFetchMemberListData: ");
        }
    }

    private void U2() {
        ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).fetchGagListFromDB(this.f177324c0, this, new fs2.a() { // from class: com.tencent.mobileqq.activity.fu
            @Override // fs2.a
            public final void onResult(List list) {
                TroopGagActivity.this.S2(list);
            }
        });
    }

    private void V2(boolean z16) {
        String str;
        String str2 = getResources().getString(R.string.drs) + " \u5f00\u5173 ";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        if (z16) {
            str = "\u5df2\u5f00\u542f";
        } else {
            str = "\u5df2\u5173\u95ed";
        }
        sb5.append(str);
        this.f177329h0.setContentDescription(sb5.toString());
    }

    protected void P2(boolean z16, int i3, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        QLog.d("TroopGagActivity", 2, "[handleMemberShutUp], isSuccess:" + z16 + ", code:" + i3 + ", errMsg:" + str);
        if (z16) {
            U2();
        }
        if (this.f177330i0.size() == 0) {
            this.f177327f0.setVisibility(8);
        } else {
            this.f177327f0.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        String stringExtra = getIntent().getStringExtra("troopuin");
        this.f177324c0 = stringExtra;
        this.f177325d0 = troopManager.B(stringExtra);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.a2a, (ViewGroup) null);
        XListView xListView = (XListView) inflate.findViewById(R.id.common_xlistview);
        this.f177322a0 = xListView;
        boolean z16 = false;
        xListView.setVerticalScrollBarEnabled(false);
        this.f177322a0.setDivider(null);
        this.f177322a0.setFocusable(false);
        this.f177326e0 = new LinearLayout(this);
        this.f177326e0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f177326e0.setOrientation(1);
        this.f177326e0.addView(View.inflate(this, R.layout.b4b, null));
        TextView textView = new TextView(this);
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.f159492al3), 0, getResources().getDimensionPixelSize(R.dimen.f159492al3), getResources().getDimensionPixelSize(R.dimen.f159486al0));
        textView.setTextAppearance(this, R.style.f174334w4);
        textView.setText(getResources().getString(R.string.drr));
        this.f177326e0.addView(textView);
        this.f177328g0 = new LinearLayout(this);
        this.f177328g0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f177328g0.setOrientation(1);
        View inflate2 = View.inflate(this, R.layout.b4b, null);
        this.f177327f0 = inflate2;
        inflate2.setVisibility(8);
        this.f177328g0.addView(this.f177327f0);
        View inflate3 = View.inflate(this, R.layout.a1w, null);
        com.tencent.mobileqq.widget.o.m(inflate3.findViewById(R.id.ipl), 0, true);
        this.f177329h0 = (Switch) inflate3.findViewById(R.id.ipm);
        com.tencent.mobileqq.troop.troopgag.data.e troopGagInfo = ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getTroopGagInfo(this.f177324c0);
        if (troopGagInfo != null && troopGagInfo.f300239b != 0) {
            this.f177329h0.setChecked(true);
        } else {
            this.f177329h0.setChecked(false);
        }
        V2(this.f177329h0.isChecked());
        this.f177329h0.setOnCheckedChangeListener(this);
        this.f177328g0.addView(inflate3);
        this.f177328g0.addView(View.inflate(this, R.layout.b4b, null));
        this.f177322a0.addFooterView(this.f177328g0);
        b bVar = new b();
        this.f177323b0 = bVar;
        this.f177322a0.setAdapter((ListAdapter) bVar);
        this.f177322a0.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        super.setContentView(inflate);
        setTitle(HardCodeUtil.qqStr(R.string.ugc));
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(this, R.string.f171137ci2, 0).show(getTitleBarHeight());
        }
        if (System.currentTimeMillis() - getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.app.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.f177324c0, 0L) > 86400000) {
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).fetchGagListWithMemberInfoFromNet(this.f177324c0, this, new fs2.a() { // from class: com.tencent.mobileqq.activity.fs
                @Override // fs2.a
                public final void onResult(List list) {
                    TroopGagActivity.this.T2(list);
                }
            });
            z16 = true;
        } else {
            U2();
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).fetchGagListFromNet(this.f177324c0, this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGagActivity", 2, "doOnCreate: isRequestedTroopList=" + z16);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b bVar = this.f177323b0;
        if (bVar != null) {
            bVar.destroy();
        }
        super.doOnDestroy();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, compoundButton, Boolean.valueOf(z16));
        } else {
            String troopOwnerReportStr = ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getTroopOwnerReportStr(this.f177324c0);
            if (z16) {
                N2(this.f177324c0, 268435455L);
                ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.f177324c0 + "", troopOwnerReportStr, "", "");
            } else {
                N2(this.f177324c0, 0L);
                ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.f177324c0 + "", troopOwnerReportStr, "", "");
            }
            V2(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
