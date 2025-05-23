package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.util.URLUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BindGroupFragment extends PublicBaseFragment {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private ListView G;
    private Bundle H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private QQProgressDialog P;
    private BindGroupAdapter Q;
    private QQAppInterface R;
    private BaseActivity S;
    private View T;
    private List<TroopInfo> U = new ArrayList();
    private com.tencent.mobileqq.troop.api.observer.e V = new e();
    private int W = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BindGroupFragment.this.S.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BindGroupFragment.this.Jh(HardCodeUtil.qqStr(R.string.k1i));
            ((com.tencent.mobileqq.troop.api.handler.j) BindGroupFragment.this.R.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).D0(Integer.valueOf(BindGroupFragment.this.L).intValue(), Integer.valueOf(BindGroupFragment.this.N).intValue());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            TroopInfo troopInfo = ((BindGroupAdapter.a) view.getTag()).C;
            if (troopInfo.isThirdAppBind()) {
                BindGroupFragment.this.showFailToast(HardCodeUtil.qqStr(R.string.k1k));
            } else if (troopInfo.isNewTroop()) {
                BindGroupFragment.this.Ih(HardCodeUtil.qqStr(R.string.k17), troopInfo.troopuin);
            } else {
                BindGroupFragment.this.Jh(HardCodeUtil.qqStr(R.string.k1_));
                ((com.tencent.mobileqq.troop.api.handler.j) BindGroupFragment.this.R.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).X0(Integer.valueOf(BindGroupFragment.this.L).intValue(), Integer.valueOf(BindGroupFragment.this.N).intValue(), Long.valueOf(troopInfo.troopuin).longValue(), BindGroupFragment.this.J);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f339693d;

        d(String str) {
            this.f339693d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                BindGroupFragment.this.Jh(HardCodeUtil.qqStr(R.string.k1c));
                ((com.tencent.mobileqq.troop.api.handler.j) BindGroupFragment.this.R.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).X0(Integer.valueOf(BindGroupFragment.this.L).intValue(), Integer.valueOf(BindGroupFragment.this.N).intValue(), Long.valueOf(this.f339693d).longValue(), BindGroupFragment.this.J);
            } else if (i3 == 0) {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class e extends com.tencent.mobileqq.troop.api.observer.e {
        e() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onBindTroopForThirdApp(boolean z16, int i3, long j3) {
            QLog.i("TroopAbility.BindGroup.Fragment", 1, "onBindTroopForThirdApp, isSuccess: " + z16 + " bindFlag: " + i3 + "  troopUin: " + j3);
            BindGroupFragment.this.U7();
            if (z16) {
                BindGroupFragment.this.Kh(HardCodeUtil.qqStr(R.string.k1a));
                BindGroupFragment.this.Dh(String.valueOf(j3), 1);
                BindGroupFragment.this.S.finish();
                return;
            }
            BindGroupFragment.this.showFailToast(HardCodeUtil.qqStr(R.string.k1g));
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetCreateTroopTokenForThirdApp(boolean z16, String str) {
            QLog.i("TroopAbility.BindGroup.Fragment", 1, "onGetCreateTroopTokenForThirdApp isSuccess: " + z16 + " url: " + str);
            BindGroupFragment.this.U7();
            if (!z16) {
                BindGroupFragment.this.showFailToast(HardCodeUtil.qqStr(R.string.k16));
                return;
            }
            Intent intent = new Intent(BindGroupFragment.this.S, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", URLUtil.addParameter(str, "gname", BindGroupFragment.this.J));
            BindGroupFragment.this.startActivity(intent);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetOnePageTroopInfo(boolean z16, boolean z17) {
            QLog.i("TroopAbility.BindGroup.Fragment", 1, "onGetOnePageTroopInfo, isSuccess: " + z16 + " isLastPage: " + z17);
            if (!z16) {
                BindGroupFragment.this.U7();
                BindGroupFragment.this.showFailToast(HardCodeUtil.qqStr(R.string.k1j));
            } else {
                if (z17) {
                    BindGroupFragment.this.U7();
                    if (BindGroupFragment.this.Q != null) {
                        BindGroupFragment.this.Q.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                BindGroupFragment.this.Fh();
            }
        }
    }

    private void Ch() {
        this.R.addObserver(this.V);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str, int i3) {
        QLog.i("TroopAbility.BindGroup.Fragment", 1, "enterAIO, troopUin: " + str + " action: " + i3);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.S), new int[]{2});
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 1);
        m3.putExtra("fromThirdAppByOpenSDK", true);
        m3.putExtra("action", i3);
        m3.putExtra("appid", this.L);
        m3.putExtra("app_name", this.I);
        m3.putExtra("pkg_name", this.M);
        startActivity(m3);
    }

    private List<TroopInfo> Eh() {
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        ArrayList arrayList = new ArrayList();
        for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
            if (troopInfo.isOwner()) {
                arrayList.add(troopInfo);
            }
        }
        QLog.i("TroopAbility.BindGroup.Fragment", 1, "getCreateTroopList list size: " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        int i3;
        int size = this.U.size();
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            i3 = this.W + 1;
            this.W = i3;
            if (i3 >= size || i16 > 100) {
                break;
            }
            arrayList.add(this.U.get(i3));
            i16++;
        }
        if (i3 == size) {
            z16 = true;
        }
        ((com.tencent.mobileqq.troop.api.handler.j) this.R.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).o(arrayList, z16);
        QLog.i("TroopAbility.BindGroup.Fragment", 1, "getTroopProfilePageByPage isLastPage: " + z16);
    }

    private boolean Gh() {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundleExtra = this.S.getIntent().getBundleExtra("key_params");
        this.H = bundleExtra;
        if (bundleExtra == null) {
            QLog.i("TroopAbility.BindGroup.Fragment", 1, "doOnCreate params is null.");
            return false;
        }
        this.L = bundleExtra.getString("appid");
        this.K = this.H.getString("openid");
        String str = "app_name_url_encode";
        if (!TextUtils.isEmpty(this.H.getString("app_name_url_encode"))) {
            bundle = this.H;
        } else {
            bundle = this.H;
            str = "app_name";
        }
        this.I = bundle.getString(str);
        String str2 = "organization_name_url_encode";
        if (!TextUtils.isEmpty(this.H.getString("organization_name_url_encode"))) {
            bundle2 = this.H;
        } else {
            bundle2 = this.H;
            str2 = "organization_name";
        }
        this.J = bundle2.getString(str2);
        this.N = this.H.getString("organization_id");
        this.M = this.H.getString("pkg_name");
        if (!TextUtils.isEmpty(this.L) && !TextUtils.isEmpty(this.K)) {
            try {
                Integer.valueOf(this.L);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        QLog.d("TroopAbility.BindGroup.Fragment", 1, "appId: " + this.L + ", openId: " + this.K + ", return.");
        return false;
    }

    private void Hh() {
        this.R.removeObserver(this.V);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(String str, String str2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.S, 230);
        d dVar = new d(str2);
        createCustomDialog.setMessage(str);
        createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.k1h), dVar);
        createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.k18), dVar);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(String str) {
        if (this.P == null) {
            this.P = new QQProgressDialog(this.S, getTitleBarHeight());
        }
        U7();
        this.P.setMessage(str);
        if (this.S.isResume()) {
            this.P.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(String str) {
        QQToast.makeText(this.S, 2, str, 0).show(getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U7() {
        QQProgressDialog qQProgressDialog = this.P;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && this.S.isResume()) {
            this.P.dismiss();
        }
    }

    private int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    private void initViews() {
        this.C = (TextView) this.T.findViewById(R.id.ivTitleBtnLeft);
        this.D = (TextView) this.T.findViewById(R.id.ivTitleBtnLeftButton);
        this.E = (TextView) this.T.findViewById(R.id.ivTitleBtnRightText);
        this.F = (TextView) this.T.findViewById(R.id.ivTitleName);
        this.G = (ListView) this.T.findViewById(R.id.f166157ei4);
        this.C.setVisibility(0);
        this.C.setText(this.I);
        this.C.setOnClickListener(new a());
        this.D.setVisibility(4);
        this.E.setVisibility(4);
        this.F.setText(getResources().getString(R.string.f170587uz));
        TextView textView = new TextView(this.S);
        textView.setText(HardCodeUtil.qqStr(R.string.k1b));
        textView.setTextSize(1, 14.0f);
        textView.setGravity(16);
        textView.setTextColor(getResources().getColor(R.color.skin_gray2_theme_version2));
        textView.setPadding(BaseAIOUtils.f(16.0f, getResources()), BaseAIOUtils.f(16.0f, getResources()), 0, BaseAIOUtils.f(8.0f, getResources()));
        this.G.addHeaderView(textView);
        View inflate = LayoutInflater.from(this.S).inflate(R.layout.a3o, (ViewGroup) null);
        this.G.addHeaderView(inflate);
        BindGroupAdapter bindGroupAdapter = new BindGroupAdapter(this.S, this.R, this.G, 4, true);
        this.Q = bindGroupAdapter;
        this.G.setAdapter((ListAdapter) bindGroupAdapter);
        this.U.addAll(Eh());
        this.Q.j(this.U);
        inflate.setOnClickListener(new b());
        this.G.setOnItemClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFailToast(String str) {
        QQToast.makeText(this.S, 1, str, 0).show(getTitleBarHeight());
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        QLog.i("TroopAbility.BindGroup.Fragment", 1, "onCreateView.");
        this.R = getBaseActivity().app;
        this.S = getBaseActivity();
        this.T = layoutInflater.inflate(R.layout.a3m, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.T.setFitsSystemWindows(true);
            this.T.setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
        }
        if (!Gh()) {
            this.S.finish();
            view = this.T;
        } else {
            initViews();
            Ch();
            Jh(HardCodeUtil.qqStr(R.string.k1e));
            Fh();
            view = this.T;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Hh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnNewIntent intent is null: ");
        if (intent == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("TroopAbility.BindGroup.Fragment", 1, sb5.toString());
        super.onNewIntent(intent);
        if (intent != null) {
            int intExtra = intent.getIntExtra("action", 0);
            String stringExtra = intent.getStringExtra("troop_uin");
            if (intExtra == 2) {
                Dh(stringExtra, 2);
                this.S.finish();
            }
        }
    }
}
