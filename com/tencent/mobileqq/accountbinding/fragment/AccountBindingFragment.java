package com.tencent.mobileqq.accountbinding.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.accountbinding.component.o;
import com.tencent.mobileqq.accountbinding.fragment.AccountBindingFragment;
import com.tencent.mobileqq.accountbinding.net.AccountBindingHandler;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.mobileqq.wxsetting.api.IWxMiniSettingProvider;
import com.tencent.open.agent.api.IAuthorityControlApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AccountBindingFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private static final Long K;
    private static boolean L;
    private Activity C;
    private QBaseActivity D;
    private AppInterface E;
    private QUIListItemAdapter F;
    private com.tencent.mobileqq.accountbinding.widget.a G;
    private AccountBindingHandler H;
    private com.tencent.mobileqq.accountbinding.data.b I;
    private Long J;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class a implements AccountBindingHandler.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AccountBindingFragment> f174638a;

        a(AccountBindingFragment accountBindingFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) accountBindingFragment);
            } else {
                this.f174638a = new WeakReference<>(accountBindingFragment);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.b
        public void a(com.tencent.mobileqq.accountbinding.data.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            QLog.d("AccountBindingFragment", 4, "bind onSuccess info: " + bVar);
            if (bVar != null) {
                bVar.j(true);
                AccountBindingFragment accountBindingFragment = this.f174638a.get();
                if (accountBindingFragment != null) {
                    accountBindingFragment.zh(bVar);
                }
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.b
        public void onFail(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            QLog.w("AccountBindingFragment", 1, "account binding is fail, fail type is " + i3);
            final AccountBindingFragment accountBindingFragment = this.f174638a.get();
            if (accountBindingFragment == null) {
                return;
            }
            if (i3 == 1) {
                accountBindingFragment.Ah();
            } else if (i3 != -1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountBindingFragment.sh(AccountBindingFragment.this, 1, R.string.f200114r9);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements AccountBindingHandler.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AccountBindingFragment> f174639a;

        b(AccountBindingFragment accountBindingFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) accountBindingFragment);
            } else {
                this.f174639a = new WeakReference<>(accountBindingFragment);
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.c
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AccountBindingFragment accountBindingFragment = this.f174639a.get();
            if (accountBindingFragment == null) {
                return;
            }
            QLog.d("AccountBindingFragment", 1, "initData | fail");
            accountBindingFragment.zh(new com.tencent.mobileqq.accountbinding.data.b().j(false));
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.c
        public void onSuccess(List<com.tencent.mobileqq.accountbinding.data.b> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            AccountBindingFragment accountBindingFragment = this.f174639a.get();
            if (accountBindingFragment == null) {
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                com.tencent.mobileqq.accountbinding.data.b bVar = list.get(i3);
                bVar.j(true);
                if (bVar.a() == 1) {
                    QLog.d("AccountBindingFragment", 4, "query onSuccess info: " + bVar);
                    accountBindingFragment.zh(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c implements AccountBindingHandler.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AccountBindingFragment> f174640a;

        c(AccountBindingFragment accountBindingFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) accountBindingFragment);
            } else {
                this.f174640a = new WeakReference<>(accountBindingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(AccountBindingFragment accountBindingFragment) {
            accountBindingFragment.zh(new com.tencent.mobileqq.accountbinding.data.b().j(false));
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.e
        public void onFail(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            final AccountBindingFragment accountBindingFragment = this.f174640a.get();
            if (accountBindingFragment == null) {
                return;
            }
            QLog.d("AccountBindingFragment", 1, "unBinding fail type is " + i3);
            if (i3 != -1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountBindingFragment.sh(AccountBindingFragment.this, 1, R.string.f200884tb);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.accountbinding.net.AccountBindingHandler.e
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            final AccountBindingFragment accountBindingFragment = this.f174640a.get();
            if (accountBindingFragment == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    AccountBindingFragment.c.d(AccountBindingFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d implements IWXAuthApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AccountBindingFragment> f174641a;

        d(AccountBindingFragment accountBindingFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) accountBindingFragment);
            } else {
                this.f174641a = new WeakReference<>(accountBindingFragment);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
        public void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            AccountBindingFragment accountBindingFragment = this.f174641a.get();
            if (accountBindingFragment == null) {
                return;
            }
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reportWXAuthResult(2, i3);
            if (i3 != 0) {
                QLog.d("AccountBindingFragment", 1, "can not get wechat authCode, errorMsg | " + str);
                return;
            }
            new com.tencent.mobileqq.accountbinding.component.f(accountBindingFragment.getQBaseActivity()).p("", 1, new com.tencent.mobileqq.accountbinding.data.b().i(((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId()).k(str2), "", new a(accountBindingFragment));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            K = 2000L;
            L = true;
        }
    }

    public AccountBindingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.J = 0L;
        }
    }

    private void Bh() {
        if (!NetworkUtil.isNetworkAvailable()) {
            xh(1, R.string.f200494s_);
            return;
        }
        ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXAppId();
        if (!((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isWXAppInstalled()) {
            xh(1, R.string.f200504sa);
        } else {
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).reqWXAuthCode(new d(this));
        }
    }

    private void Ch() {
        if (!NetworkUtil.isNetworkAvailable()) {
            xh(1, R.string.f200494s_);
        } else {
            new o(this.C).t(Long.parseLong(this.E.getCurrentAccountUin()), this.I, false, 1, "", "", new c(this));
        }
    }

    private void initData() {
        if (!NetworkUtil.isNetworkAvailable()) {
            xh(1, R.string.f200494s_);
            return;
        }
        try {
            this.H.J2(Long.parseLong(this.E.getCurrentAccountUin()), new b(this));
        } catch (NullPointerException | NumberFormatException e16) {
            QLog.d("AccountBindingFragment", 1, "number format exception| " + e16);
        }
    }

    private void initUI() {
        setTitle(HardCodeUtil.qqStr(R.string.f200854t9));
        this.G = new com.tencent.mobileqq.accountbinding.widget.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountBindingFragment.this.uh(view);
            }
        });
        Group group = new Group("\u7b2c\u4e09\u65b9\u8d26\u53f7\u7ed1\u5b9a", this.G);
        Group wxMiniSettingConfig = ((IWxMiniSettingProvider) QRoute.api(IWxMiniSettingProvider.class)).getWxMiniSettingConfig();
        ((IWxMiniSettingProvider) QRoute.api(IWxMiniSettingProvider.class)).registerWxMiniGroupLifecycle(wxMiniSettingConfig, getLifecycle());
        Group[] groupArr = {group, wxMiniSettingConfig, ((IAuthorityControlApi) QRoute.api(IAuthorityControlApi.class)).getSettingListGroup(this.C)};
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false);
        this.F = qUIListItemAdapter;
        qUIListItemAdapter.t0(groupArr);
        ((QUISettingsRecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m)).setAdapter(this.F);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void sh(AccountBindingFragment accountBindingFragment, int i3, int i16) {
        accountBindingFragment.xh(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.accountbinding.data.b bVar = this.I;
        if (bVar != null && bVar.g()) {
            Ch();
        } else {
            Bh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(com.tencent.mobileqq.accountbinding.data.b bVar) {
        this.G.J(bVar);
        this.F.l0(this.G);
    }

    private static void wh(Context context) {
        i.e(context, new Bundle(), AccountBindingFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(int i3, int i16) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() - this.J.longValue() > K.longValue()) {
            QQToastUtil.showQQToast(i3, i16);
            this.J = valueOf;
        }
    }

    public static void yh(Context context, boolean z16, Intent intent) {
        L = z16;
        if (z16 && AppSetting.t(context)) {
            wh(context);
        } else {
            QPublicFragmentActivity.start(context, intent, AccountBindingFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(final com.tencent.mobileqq.accountbinding.data.b bVar) {
        if (bVar == null) {
            return;
        }
        QLog.d("AccountBindingFragment", 2, "info : " + bVar);
        boolean g16 = bVar.g();
        this.I = bVar;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                AccountBindingFragment.this.vh(bVar);
            }
        });
        if (g16) {
            com.tencent.mobileqq.accountbinding.e.f(bVar.e());
            com.tencent.mobileqq.accountbinding.e.e(bVar.d());
        } else {
            com.tencent.mobileqq.accountbinding.e.f("");
            com.tencent.mobileqq.accountbinding.e.e("");
        }
    }

    public void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.accountbinding.fragment.AccountBindingFragment.1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.accountbinding.fragment.AccountBindingFragment$1$a */
                /* loaded from: classes9.dex */
                class a implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        } else {
                            dialogInterface.cancel();
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountBindingFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!AccountBindingFragment.this.D.isFinishing() && !AccountBindingFragment.this.D.isDestroyed()) {
                        try {
                            DialogUtil.createCustomDialog(AccountBindingFragment.this.D, HardCodeUtil.qqStr(R.string.f200744sy), HardCodeUtil.qqStr(R.string.f200734sx), null, HardCodeUtil.qqStr(R.string.f200764t0), new a(), null).show();
                            return;
                        } catch (Exception e16) {
                            QLog.e("AccountBindingFragment", 1, "show dialog exception", e16);
                            return;
                        }
                    }
                    QLog.e("AccountBindingFragment", 1, "weChatBindingFailDialog context is invalid");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = getActivity();
        this.E = (AppInterface) getQBaseActivity().getAppRuntime();
        this.D = getQBaseActivity();
        this.H = (AccountBindingHandler) this.E.getBusinessHandler(AccountBindingHandler.class.getName());
        initUI();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gxw;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (getActivity() == null) {
            return true;
        }
        if (L && AppSetting.t(getActivity())) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        } else {
            getActivity().finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onResume();
            com.tencent.mobileqq.accountbinding.e.f174633a.d(true);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
