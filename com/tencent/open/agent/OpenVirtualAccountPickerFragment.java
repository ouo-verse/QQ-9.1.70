package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.CommonCardContainer;
import com.tencent.open.agent.auth.model.k;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes22.dex */
public class OpenVirtualAccountPickerFragment extends QPublicBaseFragment implements View.OnClickListener, ep3.e {
    private Button D;
    private Button E;
    private QQProgressDialog F;
    private QQProgressDialog G;
    private CommonCardContainer H;
    private View I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ep3.i N;
    private ep3.d P;
    private long C = 0;
    private Runnable Q = new Runnable() { // from class: com.tencent.open.agent.OpenVirtualAccountPickerFragment.3

        /* renamed from: com.tencent.open.agent.OpenVirtualAccountPickerFragment$3$a */
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
            if (OpenVirtualAccountPickerFragment.this.Ch()) {
                t.e("OpenVirtualAccountPickerFragment", " activity is isInvalid");
                return;
            }
            OpenVirtualAccountPickerFragment.this.P.j();
            OpenVirtualAccountPickerFragment.this.dismissProgressDialog();
            OpenVirtualAccountPickerFragment.this.H7(true);
            AuthUIUtil.f(OpenVirtualAccountPickerFragment.this.getQBaseActivity(), OpenVirtualAccountPickerFragment.this.getResources().getString(R.string.f171155cp4), new a());
        }
    };
    private Handler R = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements CommonCardContainer.f {
        a() {
        }

        @Override // com.tencent.open.agent.CommonCardContainer.f
        public void a() {
            OpenVirtualAccountPickerFragment.this.Mh();
        }
    }

    private void Ah() {
        ((ImmersiveTitleBar2) this.H.findViewById(R.id.jq6)).resetBkColor(0);
        this.H.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        this.I = this.H.findViewById(R.id.jpy);
        this.J = (TextView) this.H.findViewById(R.id.ivTitleName);
        TextView textView = (TextView) this.H.findViewById(R.id.ivTitleBtnRightText);
        this.K = textView;
        textView.setText(R.string.cancel);
        this.K.setOnClickListener(this);
    }

    private void Bh(View view, Bundle bundle) {
        Activity qBaseActivity;
        Button button = (Button) view.findViewById(R.id.fds);
        this.E = button;
        button.setTextColor(-1);
        this.L = (TextView) view.findViewById(R.id.kku);
        TextView textView = (TextView) view.findViewById(R.id.asz);
        this.M = textView;
        textView.setOnClickListener(this);
        CommonCardContainer commonCardContainer = (CommonCardContainer) view.findViewById(R.id.arb);
        this.H = commonCardContainer;
        commonCardContainer.setOnUpdateStatusBarListener(new a());
        Ah();
        if (com.tencent.open.agent.util.c.b(getQBaseActivity().getIntent(), "internal_authority", false)) {
            this.H.setTag(Boolean.TRUE);
            this.H.findViewById(R.id.f9a).setVisibility(8);
            this.H.setVisibility(4);
        }
        this.E.setOnClickListener(this);
        H7(false);
        yh(xh(bundle));
        this.H.setPresenter(this.P, this.N);
        this.H.setCurrentAppId(xh(bundle));
        if (com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false)) {
            this.M.setVisibility(4);
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
            this.H.o(i3, null);
        }
        final String i16 = com.tencent.open.agent.util.c.i(bundle, "app_icon_url");
        if (i16 != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.g
                @Override // java.lang.Runnable
                public final void run() {
                    OpenVirtualAccountPickerFragment.this.Eh(i16);
                }
            }, 128, null, false);
        }
        Button button2 = (Button) view.findViewById(R.id.aou);
        this.D = button2;
        button2.setOnClickListener(this);
        zh(view);
        refreshUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ch() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh(Bitmap bitmap) {
        this.H.o(null, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(String str) {
        final Bitmap q16 = com.tencent.open.agent.util.g.q(str);
        if (q16 == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.i
            @Override // java.lang.Runnable
            public final void run() {
                OpenVirtualAccountPickerFragment.this.Dh(q16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(List list, String str) {
        H7(true);
        com.tencent.open.model.e eVar = new com.tencent.open.model.e();
        eVar.f341695c = new ArrayList<>(list);
        long a16 = up3.a.a(str);
        eVar.f341694b = a16;
        hp3.b.e().p("0", eVar);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VirtualInfo virtualInfo = (VirtualInfo) it.next();
            hp3.h hVar = new hp3.h(virtualInfo);
            if (virtualInfo.f341675d == a16) {
                hVar.f405844d = true;
            }
            arrayList.add(hVar);
        }
        gf(arrayList, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(final String str, boolean z16, final List list, int i3) {
        if (z16 && list != null) {
            getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.h
                @Override // java.lang.Runnable
                public final void run() {
                    OpenVirtualAccountPickerFragment.this.Fh(list, str);
                }
            });
        }
    }

    private void Ih(final String str) {
        com.tencent.open.agent.auth.model.k.b(str, com.tencent.open.agent.util.p.m(), new k.b() { // from class: com.tencent.open.agent.f
            @Override // com.tencent.open.agent.auth.model.k.b
            public final void a(boolean z16, List list, int i3) {
                OpenVirtualAccountPickerFragment.this.Gh(str, z16, list, i3);
            }
        });
    }

    private void Jh(String str) {
        if (str == null || !str.equals(this.H.E.f339765e)) {
            gf(new ArrayList(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        if (getQBaseActivity() == null) {
            t.e("OpenVirtualAccountPickerFragment", "updateTitleColor activity is null");
            return;
        }
        int color = getResources().getColor(R.color.f157443pk);
        ColorStateList colorStateList = getResources().getColorStateList(R.color.f157443pk);
        TextView textView = this.J;
        if (textView != null) {
            textView.setTextColor(color);
            this.J.setText("");
        }
        TextView textView2 = this.K;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    private void refreshUI() {
        int i3;
        boolean c16;
        ep3.i iVar = this.N;
        int i16 = 0;
        if (iVar != null) {
            i3 = iVar.d();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            this.I.setVisibility(0);
            this.D.setVisibility(8);
        } else {
            this.I.setVisibility(8);
            this.D.setVisibility(0);
        }
        ep3.i iVar2 = this.N;
        if (iVar2 == null) {
            c16 = false;
        } else {
            c16 = iVar2.c();
        }
        if (!c16) {
            i16 = 8;
        }
        this.M.setVisibility(i16);
        this.L.setVisibility(i16);
    }

    private String xh(Bundle bundle) {
        if (bundle == null) {
            t.e("OpenVirtualAccountPickerFragment", "getRealAppId param is null");
            return "";
        }
        String i3 = com.tencent.open.agent.util.c.i(bundle, CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        String i16 = com.tencent.open.agent.util.c.i(bundle, "key_proxy_appid");
        if (!TextUtils.isEmpty(i16)) {
            return i16;
        }
        return i3;
    }

    private void yh(String str) {
        com.tencent.open.model.e j3 = hp3.b.e().j(str);
        if (j3 == null) {
            return;
        }
        ArrayList<VirtualInfo> arrayList = j3.f341695c;
        long j16 = j3.f341694b;
        if (arrayList == null) {
            return;
        }
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

    private void zh(View view) {
        int i3;
        if (!OpenConfig.o()) {
            return;
        }
        boolean isNowThemeIsNight = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
        if (isNowThemeIsNight) {
            view.setBackgroundColor(getResources().getColor(R.color.bfz));
        }
        Button button = this.D;
        if (isNowThemeIsNight) {
            i3 = -1;
        } else {
            i3 = -16777216;
        }
        button.setTextColor(i3);
    }

    @Override // ep3.e
    public boolean A9(List<hp3.e> list, String str) {
        return this.H.g(list, str);
    }

    @Override // ep3.c
    public void H7(boolean z16) {
        this.E.setEnabled(z16);
    }

    public void Hh(Intent intent) {
        this.P.g(intent);
    }

    public void Kh(ep3.i iVar) {
        this.N = iVar;
    }

    public void Lh(long j3) {
        this.H.E.e(j3);
    }

    @Override // ep3.e
    public void M1(String str, boolean z16) {
        AuthUIUtil.l(getQBaseActivity(), str, z16);
    }

    @Override // ep3.e
    public void Me() {
        this.H.r(1);
    }

    @Override // ep3.e
    public void T7(String str) {
        this.H.q(str);
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
            t.d("OpenVirtualAccountPickerFragment", "dismissLoading error", e16);
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
            return Integer.valueOf(this.H.E.getCount());
        }
        return getQBaseActivity();
    }

    @Override // ep3.e
    public void gf(List<hp3.h> list, String str) {
        this.H.q(str);
        this.H.E.d(list, str);
    }

    @Override // ep3.e
    public long ia() {
        return this.H.h();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // ep3.c
    public void ld(long j3) {
        this.R.removeCallbacks(this.Q);
        this.R.postDelayed(this.Q, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        t.b("OpenVirtualAccountPickerFragment", "--onActivityResult, requestCode: " + i3 + " | resultCode:" + i16 + " | data: " + intent);
        if (i3 == 101 && intent != null) {
            this.P.g(intent);
        } else if (i3 == 102 && intent != null) {
            this.P.h(intent);
            return;
        } else if (i3 == 100) {
            this.P.f(i16, intent);
            return;
        } else if (i3 == 104 && i16 == -1) {
            this.P.c();
            return;
        }
        dismissProgressDialog();
        if (i16 == 0) {
            this.P.a(i16, intent);
        } else {
            if (-1 != i16 || com.tencent.open.agent.util.g.M(getActivity(), intent)) {
                return;
            }
            this.R.post(new Runnable() { // from class: com.tencent.open.agent.OpenVirtualAccountPickerFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    OpenVirtualAccountPickerFragment.this.H.f339753d.r();
                }
            });
            this.P.a(i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j3;
        hp3.g gVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != this.K && view != this.D) {
            if (view == this.E) {
                t.b("OpenVirtualAccountPickerFragment", "onClick authorize btn");
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (view) {
                    if (currentTimeMillis - this.C < 500) {
                        t.b("OpenVirtualAccountPickerFragment", "onClick btn repeat click");
                    } else {
                        this.C = currentTimeMillis;
                        hp3.h i3 = this.H.i();
                        if (this.N != null) {
                            if (i3 == null) {
                                gVar = new hp3.g(false, this.H.j(), "", 0L);
                            } else {
                                gVar = new hp3.g(true, i3.f405842b, i3.f405841a, i3.f405843c);
                            }
                            this.N.b(gVar);
                        } else {
                            this.P.c();
                        }
                        String account = getQBaseActivity().getAppRuntime().getAccount();
                        if (i3 == null) {
                            j3 = 0;
                        } else {
                            j3 = i3.f405843c;
                        }
                        up3.a.b(account, j3);
                    }
                }
            } else if (view == this.M) {
                t.b("OpenVirtualAccountPickerFragment", "onClick showAccountSheet");
                this.H.f339753d.o();
                com.tencent.open.agent.util.g.O("0X800BA78");
                com.tencent.open.agent.util.g.O("0X800BA7B");
            }
        } else {
            t.b("OpenVirtualAccountPickerFragment", "onClick cancel");
            ep3.i iVar = this.N;
            if (iVar != null) {
                iVar.cancel();
            } else {
                this.P.k();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        t.b("OpenVirtualAccountPickerFragment", "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.fqx, viewGroup, false);
        ep3.a.b(this, getContext());
        ep3.i iVar = this.N;
        if (iVar != null) {
            bundle2 = iVar.e();
        } else {
            bundle2 = null;
        }
        if (bundle2 == null) {
            bundle2 = com.tencent.open.agent.util.c.d(getQBaseActivity().getIntent(), "key_params");
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        Bh(inflate, bundle2);
        this.P.onCreate(bundle2);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        t.b("OpenVirtualAccountPickerFragment", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        dismissProgressDialog();
        dismissLoading();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.P.doOnPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
        Ih(getQBaseActivity().getAppRuntime().getAccount());
        this.H.l();
        this.P.doOnResume();
    }

    @Override // ep3.c
    public void p0(String str, Bitmap bitmap) {
        this.H.o(str, bitmap);
    }

    @Override // ep3.e
    public void showLoading() {
        t.b("OpenVirtualAccountPickerFragment", UIJsPlugin.EVENT_SHOW_LOADING);
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
            Jh(account);
            return;
        }
        if (list == null) {
            Jh(account);
            return;
        }
        gf(list, account);
        if (j3 != 0) {
            this.H.E.e(j3);
        }
    }

    @Override // ep3.e
    public void w2(String str, DialogInterface.OnClickListener onClickListener) {
        AuthUIUtil.g(getQBaseActivity(), HardCodeUtil.qqStr(R.string.f197714kr), str, onClickListener);
    }

    @Override // ep3.e
    public void y2(ep3.d dVar) {
        this.P = dVar;
    }
}
