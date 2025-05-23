package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualAccountCreatorDialog;
import com.tencent.open.virtual.OpenVirtualAccountCreatorDialog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenAuthorityFragment extends QPublicBaseFragment implements View.OnClickListener, ep3.e {
    private Button E;
    private QQProgressDialog F;
    private QQProgressDialog G;
    private OpenCardContainer H;
    private TextView I;
    private TextView J;
    private View K;
    private ep3.d L;
    private OpenSdkVirtualAccountCreatorDialog M;
    private long C = 0;
    private long D = 0;
    private Runnable N = new Runnable() { // from class: com.tencent.open.agent.OpenAuthorityFragment.5

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.OpenAuthorityFragment$5$a */
        /* loaded from: classes22.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthorityFragment.this.Eh()) {
                t.e("OpenAuthorityFragment", " activity is isInvalid");
                return;
            }
            OpenAuthorityFragment.this.L.j();
            OpenAuthorityFragment.this.dismissProgressDialog();
            OpenAuthorityFragment.this.H7(true);
            AuthUIUtil.f(OpenAuthorityFragment.this.getQBaseActivity(), OpenAuthorityFragment.this.getResources().getString(R.string.f171155cp4), new a());
        }
    };
    private Handler P = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements OpenCardContainer.d {
        b() {
        }

        @Override // com.tencent.open.agent.OpenCardContainer.d
        public void a() {
            OpenAuthorityFragment.this.Gh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f339860d;

        c(Bundle bundle) {
            this.f339860d = bundle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onAddVirtualAccountClick");
            if (OpenAuthorityFragment.this.M != null) {
                str = "";
            } else {
                str = ", dialog is null";
            }
            sb5.append(str);
            objArr[0] = sb5.toString();
            t.b("OpenAuthorityFragment", objArr);
            com.tencent.open.agent.util.g.R(null, "0X800C348", new String[]{OpenAuthorityFragment.this.zh(this.f339860d), "", OpenAuthorityFragment.this.yh(this.f339860d), ""});
            if (OpenAuthorityFragment.this.M != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - OpenAuthorityFragment.this.D >= 500) {
                    OpenAuthorityFragment.this.D = currentTimeMillis;
                    OpenAuthorityFragment.this.M.sh(OpenAuthorityFragment.this.getQBaseActivity());
                } else {
                    t.b("OpenAuthorityFragment", "onClick btn repeat click");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private GradientDrawable Ah() {
        int color = getResources().getColor(R.color.qui_common_bg_bottom_light);
        int[] iArr = {color, 16777215 & color};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setColors(iArr);
        return gradientDrawable;
    }

    private void Bh(Bundle bundle) {
        OpenSdkVirtualAccountCreatorDialog openSdkVirtualAccountCreatorDialog = new OpenSdkVirtualAccountCreatorDialog();
        this.M = openSdkVirtualAccountCreatorDialog;
        openSdkVirtualAccountCreatorDialog.wh(zh(bundle));
        this.M.rh(new a());
    }

    private void Ch() {
        ((ImmersiveTitleBar2) this.H.findViewById(R.id.jq6)).resetBkColor(0);
        TextView textView = (TextView) this.H.findViewById(R.id.ivTitleBtnRightText);
        this.I = textView;
        textView.setText(R.string.cancel);
        this.I.setOnClickListener(this);
    }

    private void Dh(View view, Bundle bundle) {
        Activity qBaseActivity;
        this.E = (Button) view.findViewById(R.id.fds);
        View findViewById = view.findViewById(R.id.f11993787);
        this.K = findViewById;
        findViewById.setBackground(Ah());
        TextView textView = (TextView) view.findViewById(R.id.asz);
        this.J = textView;
        textView.setOnClickListener(this);
        OpenCardContainer openCardContainer = (OpenCardContainer) view.findViewById(R.id.arb);
        this.H = openCardContainer;
        openCardContainer.setOnUpdateStatusBarListener(new b());
        Ch();
        if (com.tencent.open.agent.util.c.b(getQBaseActivity().getIntent(), "internal_authority", false)) {
            this.H.setTag(Boolean.TRUE);
            this.H.findViewById(R.id.f9a).setVisibility(8);
            this.H.setVisibility(4);
        }
        this.H.setAddVirtualAccountClickListener(new c(bundle));
        this.E.setOnClickListener(this);
        H7(false);
        com.tencent.open.model.e j3 = hp3.b.e().j(zh(bundle));
        if (j3 != null) {
            ArrayList<VirtualInfo> arrayList = j3.f341695c;
            long j16 = j3.f341694b;
            if (arrayList != null) {
                LinkedList linkedList = new LinkedList();
                for (VirtualInfo virtualInfo : arrayList) {
                    hp3.h hVar = new hp3.h(virtualInfo);
                    if (virtualInfo.f341675d == j16) {
                        hVar.f405844d = true;
                    }
                    linkedList.add(hVar);
                }
                gf(linkedList, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            }
        }
        this.H.setPresenter(this.L);
        this.H.setCurrentAppId(zh(bundle));
        if (com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false)) {
            this.J.setVisibility(4);
        }
        if (com.tencent.open.agent.util.c.m(getQBaseActivity().getIntent())) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getQBaseActivity(), 0, R.layout.b18, 17);
            this.F = qQProgressDialog;
            qQProgressDialog.setHeightParams(-1);
        } else {
            if (getQBaseActivity().isChild()) {
                qBaseActivity = getQBaseActivity().getParent();
            } else {
                qBaseActivity = getQBaseActivity();
            }
            this.F = new QQProgressDialog(qBaseActivity, getQBaseActivity().getTitleBarHeight());
        }
        String i3 = com.tencent.open.agent.util.c.i(bundle, "oauth_app_name");
        if (i3 != null) {
            this.H.u(i3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    private void Fh(String str) {
        if (str == null || !str.equals(this.H.P.f339865e)) {
            gf(new ArrayList(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        ColorStateList colorStateList;
        if (getQBaseActivity() == null) {
            t.e("OpenAuthorityFragment", "updateTitleColor activity is null");
            return;
        }
        if (AppSetting.o(getContext()) && getResources().getConfiguration().orientation == 2) {
            colorStateList = getResources().getColorStateList(R.color.qui_common_text_primary_selector);
        } else {
            colorStateList = getResources().getColorStateList(R.color.f157443pk);
        }
        TextView textView = this.I;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yh(Bundle bundle) {
        return com.tencent.open.agent.util.c.i(bundle, "oauth_app_name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zh(Bundle bundle) {
        String i3 = com.tencent.open.agent.util.c.i(bundle, CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        String i16 = com.tencent.open.agent.util.c.i(bundle, "key_proxy_appid");
        if (!TextUtils.isEmpty(i16)) {
            return i16;
        }
        return i3;
    }

    @Override // ep3.e
    public boolean A9(List<hp3.e> list, String str) {
        return this.H.q(list, str);
    }

    @Override // ep3.c
    public void H7(boolean z16) {
        this.E.setEnabled(z16);
    }

    @Override // ep3.e
    public void M1(String str, boolean z16) {
        AuthUIUtil.l(getQBaseActivity(), str, z16);
    }

    @Override // ep3.e
    public void Me() {
        this.H.x(1);
    }

    @Override // ep3.e
    public void T7(String str) {
        this.H.w(str);
    }

    @Override // ep3.e
    public void dismissLoading() {
        try {
            QQProgressDialog qQProgressDialog = this.G;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            this.G = null;
        } catch (Exception e16) {
            t.d("OpenAuthorityFragment", "dismissLoading error", e16);
        }
    }

    @Override // ep3.c
    public void dismissProgressDialog() {
        AuthUIUtil.c(getQBaseActivity(), this.F);
    }

    @Override // ep3.c
    public Object fe(int i3) {
        if (i3 != 3) {
            if (i3 != 5) {
                return null;
            }
            return Integer.valueOf(this.H.P.getCount());
        }
        return getQBaseActivity();
    }

    @Override // ep3.e
    public void gf(List<hp3.h> list, String str) {
        this.H.P.d(list, str);
    }

    @Override // ep3.e
    public long ia() {
        return this.H.r();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // ep3.c
    public void ld(long j3) {
        this.P.removeCallbacks(this.N);
        this.P.postDelayed(this.N, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        t.b("OpenAuthorityFragment", "--onActivityResult, requestCode: " + i3 + " | resultCode:" + i16 + " | data: " + intent);
        if (i3 == 102 && intent != null) {
            this.L.h(intent);
            return;
        }
        if (i3 == 100) {
            this.L.f(i16, intent);
            return;
        }
        if (i3 == 257) {
            OpenSdkVirtualAccountCreatorDialog openSdkVirtualAccountCreatorDialog = this.M;
            if (openSdkVirtualAccountCreatorDialog != null) {
                openSdkVirtualAccountCreatorDialog.onActivityResult(i3, i16, intent);
                return;
            }
            return;
        }
        if (i3 == 103 && intent != null) {
            this.L.h(intent);
            return;
        }
        if (i3 == 104 && i16 == -1) {
            this.L.c();
            return;
        }
        dismissProgressDialog();
        if (i16 == 0) {
            this.L.a(i16, intent);
        } else {
            if (-1 != i16 || com.tencent.open.agent.util.g.M(getActivity(), intent)) {
                return;
            }
            this.P.post(new Runnable() { // from class: com.tencent.open.agent.OpenAuthorityFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    OpenAuthorityFragment.this.H.H.r();
                }
            });
            this.L.a(i16, intent);
        }
    }

    public void onBackPressed() {
        t.b("OpenAuthorityFragment", "onBackPressed");
        this.L.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.I) {
            t.b("OpenAuthorityFragment", "onClick cancel");
            this.L.k();
            OpenAuthTelemetryProxy.c();
        } else if (view == this.E) {
            t.b("OpenAuthorityFragment", "onClick authorize btn");
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (view) {
                if (currentTimeMillis - this.C < 500) {
                    t.b("OpenAuthorityFragment", "onClick btn repeat click");
                } else {
                    this.C = currentTimeMillis;
                    this.L.c();
                    OpenAuthTelemetryProxy.d();
                }
            }
        } else if (view == this.J) {
            t.b("OpenAuthorityFragment", "onClick showAccountSheet");
            this.H.H.o();
            com.tencent.open.agent.util.g.O("0X800BA78");
            Bundle d16 = com.tencent.open.agent.util.c.d(getQBaseActivity().getIntent(), "key_params");
            com.tencent.open.agent.util.g.R(null, "0X800BA7B", new String[]{zh(d16), "", yh(d16), ""});
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        t.b("OpenAuthorityFragment", "onCreateView");
        View view2 = null;
        try {
            view = layoutInflater.inflate(R.layout.f168459wq, viewGroup, false);
        } catch (InflateException e16) {
            t.d("OpenAuthorityFragment", "inflateException", e16);
            view = null;
        }
        if (view == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(0);
                activity.finish();
            }
        } else {
            if (getQBaseActivity().getAppRuntime() instanceof AbstractOpenSdkAppInterface) {
                ep3.a.a(this, getContext());
                Bundle d16 = com.tencent.open.agent.util.c.d(getQBaseActivity().getIntent(), "key_params");
                Dh(view, d16);
                this.L.onCreate(d16);
                Bh(d16);
            }
            view2 = view;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        t.b("OpenAuthorityFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        dismissProgressDialog();
        dismissLoading();
        try {
            OpenSdkVirtualAccountCreatorDialog openSdkVirtualAccountCreatorDialog = this.M;
            if (openSdkVirtualAccountCreatorDialog != null) {
                openSdkVirtualAccountCreatorDialog.dismiss();
                this.M = null;
            }
        } catch (Exception e16) {
            t.d("OpenAuthorityFragment", "onDestroy dismiss dialog exception", e16);
        }
        com.tencent.open.base.h.a(getActivity());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        t.b("OpenAuthorityFragment", "doOnNewIntent====");
        super.onNewIntent(intent);
        OpenSdkVirtualAccountCreatorDialog openSdkVirtualAccountCreatorDialog = this.M;
        if (openSdkVirtualAccountCreatorDialog != null) {
            openSdkVirtualAccountCreatorDialog.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.L.doOnPause();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        this.K.setBackground(Ah());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getQBaseActivity().getWindow());
        this.H.s();
        this.L.doOnResume();
        OpenAuthTelemetryProxy.f();
    }

    @Override // ep3.c
    public void p0(String str, Bitmap bitmap) {
        this.H.u(str, bitmap);
    }

    @Override // ep3.e
    public void showLoading() {
        t.b("OpenAuthorityFragment", UIJsPlugin.EVENT_SHOW_LOADING);
        this.G = AuthUIUtil.k(getQBaseActivity(), null, R.layout.b17);
    }

    @Override // ep3.c
    public void showProgressDialog(int i3) {
        this.F.setMessage(getResources().getString(i3));
        AuthUIUtil.k(getQBaseActivity(), this.F, 0);
    }

    @Override // ep3.e
    public void ud(int i3, List<hp3.h> list, long j3) {
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (i3 != 0) {
            AuthUIUtil.l(getQBaseActivity(), HardCodeUtil.qqStr(R.string.oyn) + i3, false);
            Fh(account);
            return;
        }
        if (list == null) {
            Fh(account);
            return;
        }
        gf(list, account);
        if (j3 != 0) {
            this.H.P.e(j3);
        }
    }

    @Override // ep3.e
    public void w2(String str, DialogInterface.OnClickListener onClickListener) {
        AuthUIUtil.g(getQBaseActivity(), HardCodeUtil.qqStr(R.string.f197714kr), str, onClickListener);
    }

    @Override // ep3.e
    public void y2(ep3.d dVar) {
        this.L = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements OpenVirtualAccountCreatorDialog.b {
        a() {
        }

        @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
        public void a(long j3) {
            Intent intent = new Intent();
            intent.putExtra("createVirtualAccount", 1);
            intent.putExtra("createVirtualVid", j3);
            OpenAuthorityFragment.this.L.g(intent);
        }

        @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
        public void b(int i3) {
            if (i3 == 151) {
                Intent intent = new Intent();
                intent.putExtra("createVirtualAccount", 2);
                OpenAuthorityFragment.this.L.g(intent);
            }
        }

        @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
        public void onCancel() {
        }
    }
}
