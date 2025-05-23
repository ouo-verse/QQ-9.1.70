package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AppletsSettingFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private XListView C;
    private com.tencent.mobileqq.adapter.a D;
    private QQAppInterface E;
    private RelativeLayout F;
    private TextView G;
    private Switch H;
    private TextView I;
    private TextView J;
    private AppletItem K;
    private HashMap<String, AppletItem> L;
    AppletsFolderManager M;
    private QQProgressDialog N;
    protected QQCustomDialog P;
    private boolean Q;
    private com.tencent.mobileqq.utils.ad R;
    private View.OnClickListener S;
    private Runnable T;
    private com.tencent.mobileqq.applets.a U;
    private d V;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppletsSettingFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AppletsSettingFragment.this.Q = !r0.Q;
                AppletsSettingFragment appletsSettingFragment = AppletsSettingFragment.this;
                appletsSettingFragment.Eh(appletsSettingFragment.Q);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.applets.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppletsSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.applets.a
        protected void onGetAppletsSettingSwitch(boolean z16, List<com.tencent.mobileqq.applets.data.a> list) {
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AppletsSettingFragment", 2, "onGetAppletsSettingSwitch:  isSuccess: " + z16);
            }
            if (z16) {
                HashSet hashSet = new HashSet();
                if (list != null && z16 && list.size() > 0) {
                    for (com.tencent.mobileqq.applets.data.a aVar : list) {
                        List<AppletItem> list2 = aVar.f196768b;
                        if (list2 != null && list2.size() > 0 && aVar.f196768b.get(0) != null && aVar.f196768b.get(0).b() == 1) {
                            AppletsSettingFragment.this.K = aVar.f196768b.get(0);
                            if (!TextUtils.isEmpty(AppletsSettingFragment.this.K.c())) {
                                AppletsSettingFragment.this.G.setText(AppletsSettingFragment.this.K.c());
                                AppletsSettingFragment appletsSettingFragment = AppletsSettingFragment.this;
                                appletsSettingFragment.M.z(appletsSettingFragment.K.c());
                            }
                            AppletsSettingFragment appletsSettingFragment2 = AppletsSettingFragment.this;
                            if (appletsSettingFragment2.K.e() == 1) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            appletsSettingFragment2.Q = z17;
                            Switch r16 = AppletsSettingFragment.this.H;
                            if (AppletsSettingFragment.this.K.e() == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            r16.setChecked(z18);
                            if (AppletsSettingFragment.this.K.e() == 1) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            com.tencent.mobileqq.applets.b.c(z19);
                            if (!TextUtils.isEmpty(aVar.f196767a)) {
                                AppletsSettingFragment.this.I.setText(aVar.f196767a);
                                AppletsSettingFragment.this.M.y(aVar.f196767a);
                            }
                        } else {
                            if (!TextUtils.isEmpty(aVar.f196767a)) {
                                AppletsSettingFragment.this.J.setText(aVar.f196767a);
                                AppletsSettingFragment.this.M.A(aVar.f196767a);
                            }
                            List<AppletItem> list3 = aVar.f196768b;
                            if (list3 != null && list3.size() > 0) {
                                AppletsSettingFragment.this.L.clear();
                                for (AppletItem appletItem : aVar.f196768b) {
                                    AppletsSettingFragment.this.L.put(AppletsSettingFragment.this.Hh(appletItem), appletItem);
                                    if (appletItem.b() != 1 && appletItem.e() != 1) {
                                        hashSet.add(String.valueOf(appletItem.b()));
                                    }
                                }
                                AppletsSettingFragment.this.Jh(new ArrayList(AppletsSettingFragment.this.L.values()));
                            }
                        }
                    }
                }
                AppletsSettingFragment.this.M.B(hashSet);
                return;
            }
            AppletsSettingFragment.this.Fh(R.string.f170411pm);
        }

        @Override // com.tencent.mobileqq.applets.a
        protected void onSetAppletsSettingSwitch(boolean z16, List<AppletItem> list) {
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AppletsSettingFragment", 2, "onSetAppletsSettingSwitch:  isSuccess: " + z16);
            }
            if (list != null) {
                for (AppletItem appletItem : list) {
                    AppletsSettingFragment.this.Kh(false);
                    if (!z16) {
                        AppletsSettingFragment.this.Fh(R.string.f170412pn);
                    }
                    if (appletItem.b() == 1) {
                        AppletItem appletItem2 = AppletsSettingFragment.this.K;
                        int e16 = appletItem.e();
                        if (!z16) {
                            if (e16 == 1) {
                                e16 = 0;
                            } else {
                                e16 = 1;
                            }
                        }
                        appletItem2.g(e16);
                        AppletsSettingFragment appletsSettingFragment = AppletsSettingFragment.this;
                        if (appletsSettingFragment.K.e() == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        appletsSettingFragment.Q = z17;
                        Switch r06 = AppletsSettingFragment.this.H;
                        if (AppletsSettingFragment.this.K.e() == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        r06.setChecked(z18);
                        if (AppletsSettingFragment.this.K.e() == 1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        com.tencent.mobileqq.applets.b.c(z19);
                    } else {
                        AppletItem appletItem3 = (AppletItem) AppletsSettingFragment.this.L.get(AppletsSettingFragment.this.Hh(appletItem));
                        if (appletItem3 != null) {
                            int e17 = appletItem.e();
                            if (!z16) {
                                if (e17 == 1) {
                                    e17 = 0;
                                } else {
                                    e17 = 1;
                                }
                            }
                            appletItem3.g(e17);
                        }
                        AppletsSettingFragment.this.Gh();
                        AppletsSettingFragment.this.Jh(new ArrayList(AppletsSettingFragment.this.L.values()));
                        if (AppletsSettingFragment.this.M != null && appletItem3 != null) {
                            if (appletItem3.e() == 0) {
                                AppletsSettingFragment.this.M.g(String.valueOf(appletItem3.b()));
                            } else {
                                AppletsSettingFragment.this.M.t(String.valueOf(appletItem3.b()));
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppletsSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.fragment.AppletsSettingFragment.d
        public void a(CompoundButton compoundButton, boolean z16, AppletItem appletItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16), appletItem);
                return;
            }
            if (appletItem != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppletsSettingFragment", 2, "OnChangeSwitchListener onChangeSwitchListener " + appletItem.toString() + ",  isChecked:" + z16);
                }
                AppletsSettingFragment.this.Kh(true);
                compoundButton.setChecked(z16);
                AppletsHandler appletsHandler = (AppletsHandler) AppletsSettingFragment.this.E.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
                ArrayList<AppletItem> arrayList = new ArrayList<>();
                appletItem.g(z16 ? 1 : 0);
                arrayList.add(appletItem);
                appletsHandler.U2(arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void a(CompoundButton compoundButton, boolean z16, AppletItem appletItem);
    }

    public AppletsSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.L = new HashMap<>();
        this.P = null;
        this.S = new a();
        this.T = new Runnable() { // from class: com.tencent.mobileqq.fragment.AppletsSettingFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AppletsSettingFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AppletsSettingFragment.this.Kh(false);
                }
            }
        };
        this.U = new b();
        this.V = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + z16);
        }
        this.H.setChecked(z16);
        AppletsHandler appletsHandler = (AppletsHandler) this.E.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        ArrayList<AppletItem> arrayList = new ArrayList<>();
        this.K.g(z16 ? 1 : 0);
        arrayList.add(this.K);
        appletsHandler.U2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        Iterator<Map.Entry<String, AppletItem>> it = this.L.entrySet().iterator();
        while (it.hasNext()) {
            AppletItem value = it.next().getValue();
            if (value != null && value.e() == 1) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Hh(AppletItem appletItem) {
        return appletItem.b() + ContainerUtils.FIELD_DELIMITER + appletItem.getType();
    }

    private void Ih() {
        boolean z16;
        AppletItem.b bVar = new AppletItem.b();
        bVar.c(1L);
        String m3 = this.M.m();
        if (!TextUtils.isEmpty(m3)) {
            bVar.d(m3);
        } else {
            bVar.d(getBaseActivity().getString(R.string.f170410pl));
        }
        bVar.b(null);
        boolean z17 = false;
        bVar.e(0);
        bVar.f(com.tencent.mobileqq.applets.b.a() ? 1 : 0);
        AppletItem a16 = bVar.a();
        this.K = a16;
        if (a16.e() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.Q = z16;
        this.G.setText(this.K.c());
        Switch r06 = this.H;
        if (this.K.e() == 1) {
            z17 = true;
        }
        r06.setChecked(z17);
        String l3 = this.M.l();
        String n3 = this.M.n();
        if (!TextUtils.isEmpty(l3)) {
            this.I.setText(l3);
        } else {
            this.I.setText(getBaseActivity().getString(R.string.f170414pp));
        }
        if (!TextUtils.isEmpty(n3)) {
            this.J.setText(n3);
        } else {
            this.J.setText(getBaseActivity().getString(R.string.f170408pj));
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setCenterText(this.K.c());
        }
        ((AppletsHandler) this.E.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)).E2();
        Jh(new ArrayList(this.L.values()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(List<AppletItem> list) {
        com.tencent.mobileqq.adapter.a aVar = this.D;
        if (aVar != null) {
            aVar.b(list);
        }
        if (this.J != null) {
            if (list != null && list.size() >= 1) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
        }
    }

    private void initUI() {
        this.R = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), null);
        TextView textView = this.leftView;
        if (textView != null) {
            textView.setText("");
        }
        XListView xListView = (XListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164409wi);
        this.C = xListView;
        xListView.setDivider(null);
        this.C.setVerticalScrollBarEnabled(false);
        this.F = (RelativeLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164408wh);
        this.G = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164403wc);
        this.H = (Switch) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164402wb);
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164401wa);
        TextView textView2 = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.w_);
        this.J = textView2;
        textView2.setVisibility(8);
        this.H.setOnClickListener(this.S);
        if (this.D == null) {
            com.tencent.mobileqq.adapter.a aVar = new com.tencent.mobileqq.adapter.a(this.E, getBaseActivity(), this.V);
            this.D = aVar;
            this.C.setAdapter((ListAdapter) aVar);
        }
        if (this.N == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            this.N = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.f170409pk);
            this.N.setCanceledOnTouchOutside(true);
        }
    }

    public void Fh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            QQToast.makeText(getBaseActivity().getApplicationContext(), i3, 0).show();
        }
    }

    public void Kh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        QQProgressDialog qQProgressDialog = this.N;
        if (qQProgressDialog != null) {
            if (z16 && !qQProgressDialog.isShowing()) {
                this.N.show();
                this.R.postDelayed(this.T, 500L);
            } else if (!z16 && this.N.isShowing()) {
                this.N.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            this.E = (QQAppInterface) getBaseActivity().getAppRuntime();
        }
        this.E.addObserver(this.U);
        this.M = (AppletsFolderManager) this.E.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
        initUI();
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f168864b21;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.utils.ad adVar = this.R;
        if (adVar != null) {
            adVar.removeCallbacks(this.T);
        }
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.U);
        }
        this.E = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
