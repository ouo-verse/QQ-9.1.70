package com.tencent.open.filedownload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.YybUpgradeDialog;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton;
import com.tencent.open.filedownload.ui.NormalDownloadButton;
import com.tencent.open.filedownload.ui.SafeDownloadButton;
import com.tencent.open.filedownload.ui.WhiteListDownloadButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ApkFileDownloadFragment extends IphoneTitleBarFragment {
    private ImageView C;
    private TextView D;
    private TextView E;
    private NormalDownloadButton F;
    private SafeDownloadButton G;
    private WhiteListDownloadButton H;
    private TextView I;
    private boolean J;
    private com.tencent.open.filedownload.b K;
    private com.tencent.open.filedownload.b L;
    private c M;
    private BaseActivity N;
    private String P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v("200").n(ApkFileDownloadFragment.this.M.f341560b).l("1").o("0").t(ApkFileDownloadFragment.this.M.f341559a).i(ApkFileDownloadFragment.this.K.f341570i).m(ApkFileDownloadFragment.this.K.f341567f).r(ApkFileDownloadFragment.this.K.f341566e));
            ApkFileDownloadFragment.this.N.finish();
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
            ApkFileDownloadFragment.this.yh(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f341556c = new c("ANDROID.QQ.WLISTAPK", "7003");

        /* renamed from: d, reason: collision with root package name */
        static final c f341557d = new c("ANDROID.QQ.YYBAPK", "7002");

        /* renamed from: e, reason: collision with root package name */
        static final c f341558e = new c("ANDROID.QQ.NEWYYBAPK", "7001");

        /* renamed from: a, reason: collision with root package name */
        public String f341559a;

        /* renamed from: b, reason: collision with root package name */
        public String f341560b;

        c(String str, String str2) {
            this.f341559a = str;
            this.f341560b = str2;
        }
    }

    private void Ah() {
        f.e("ApkFileDownloadFragment_", ">specialCode " + this.J + "|" + this.K.f341567f + "|" + NetworkUtil.isNetworkAvailable(getBaseActivity()) + "|" + NetworkUtil.isWifiConnected(getBaseActivity()));
        if (this.J && TextUtils.equals(this.K.f341567f, QQBridgeModule.WEISHI_PAKG_NAME) && NetworkUtil.isNetworkAvailable(getBaseActivity()) && NetworkUtil.isWifiConnected(getBaseActivity())) {
            this.H.z(true, true);
        }
    }

    private void Bh(com.tencent.open.filedownload.b bVar) {
        DownloadInfo S;
        com.tencent.open.filedownload.a.e(this.C, bVar.f341568g);
        this.D.setText(bVar.f341570i);
        if (bVar.f341569h <= 0 && (S = DownloadManagerV2.V().S(bVar.f341566e)) != null) {
            bVar.f341569h = S.f341180b0;
        }
        if (bVar.f341569h > 0) {
            this.E.setVisibility(0);
            this.E.setText(YybUpgradeDialog.g0((float) bVar.f341569h, true, 2));
        } else {
            this.E.setVisibility(8);
        }
    }

    private <T extends View> T findViewById(int i3) {
        return (T) ((IphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    private void initData() {
        this.G.setSource(this.P);
        this.H.setSource(this.P);
        this.F.setSource(this.P);
        if (this.J) {
            this.H.setVisibility(0);
            com.tencent.open.filedownload.b bVar = this.K;
            bVar.f341563b = "3";
            this.H.setApkInfo(bVar);
            this.I.setVisibility(8);
        } else {
            com.tencent.open.filedownload.b a16 = com.tencent.open.filedownload.b.a(this.K);
            this.L = a16;
            a16.f341566e = "https://a.app.qq.com/o/myapp-down?g_f=1005234";
            a16.f341567f = SDKConst.SELF_PACKAGENAME;
            a16.f341570i = HardCodeUtil.qqStr(R.string.jef);
            this.L.f341569h = 0L;
            this.G.setVisibility(8);
            com.tencent.open.filedownload.b bVar2 = this.K;
            bVar2.f341563b = "3";
            this.G.setOriApkInfo(bVar2);
            com.tencent.open.filedownload.b bVar3 = this.L;
            bVar3.f341563b = "3";
            this.G.setApkInfo(bVar3);
            this.G.setEventCallback(new ApkFileDownloadButton.c() { // from class: com.tencent.open.filedownload.ApkFileDownloadFragment.2
                @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton.c
                public void d() {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ApkFileDownloadFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadFragment.this.I.setVisibility(0);
                        }
                    });
                }
            });
            com.tencent.open.filedownload.b bVar4 = this.K;
            bVar4.f341563b = "4";
            this.F.setApkInfo(bVar4);
            this.F.setEventCallback(new ApkFileDownloadButton.c() { // from class: com.tencent.open.filedownload.ApkFileDownloadFragment.3
                @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton.c
                public void d() {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ApkFileDownloadFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ApkFileDownloadFragment.this.I.setVisibility(0);
                            ApkFileDownloadFragment.this.F.setVisibility(4);
                            ApkFileDownloadFragment.this.G.setVisibility(8);
                        }
                    });
                }
            });
            this.I.setText(HardCodeUtil.qqStr(R.string.jeo));
            this.I.setOnClickListener(new b());
        }
        Bh(this.K);
    }

    private void initView() {
        this.leftView.setText(HardCodeUtil.qqStr(R.string.f171898lr0));
        this.leftView.setOnClickListener(new a());
        setTitle(HardCodeUtil.qqStr(R.string.jen));
        this.C = (ImageView) findViewById(R.id.dbn);
        this.D = (TextView) findViewById(R.id.key);
        this.E = (TextView) findViewById(R.id.kex);
        this.F = (NormalDownloadButton) findViewById(R.id.aio);
        this.G = (SafeDownloadButton) findViewById(R.id.ajp);
        this.H = (WhiteListDownloadButton) findViewById(R.id.al8);
        this.I = (TextView) findViewById(R.id.kfd);
    }

    private void parseIntent() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.jel));
            this.N.finish();
            return;
        }
        boolean z16 = arguments.getBoolean("param_in_white_list", false);
        this.J = z16;
        if (z16) {
            this.M = c.f341556c;
        } else if (com.tencent.open.filedownload.a.d()) {
            this.M = c.f341557d;
        } else {
            this.M = c.f341558e;
        }
        String string = arguments.getString("param_ext_info");
        com.tencent.open.filedownload.b bVar = new com.tencent.open.filedownload.b();
        this.K = bVar;
        c cVar = this.M;
        bVar.f341562a = cVar.f341560b;
        bVar.f341565d = cVar.f341559a;
        bVar.f341566e = arguments.getString("param_url");
        f.e("ApkFileDownloadFragment_", "RealUrl:" + this.K.f341566e);
        this.K.f341569h = arguments.getLong("_filesize");
        try {
            if (!TextUtils.isEmpty(string)) {
                f.e("ApkFileDownloadFragment_", "appInfoJson:" + string);
                JSONObject jSONObject = new JSONObject(string);
                if (TextUtils.isEmpty(this.K.f341566e)) {
                    this.K.f341566e = jSONObject.optString("url");
                }
                this.K.f341568g = jSONObject.optString(MiniConst.WxMiniAppInfoConst.EXTRA_ICON);
                this.K.f341570i = jSONObject.optString("app_name");
                com.tencent.open.filedownload.b bVar2 = this.K;
                if (bVar2.f341569h <= 0) {
                    bVar2.f341569h = jSONObject.optLong("app_filesize");
                }
                this.K.f341567f = jSONObject.optString("packagename");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(this.K.f341566e)) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.jei));
            this.N.finish();
            return;
        }
        if (TextUtils.isEmpty(this.K.f341570i)) {
            com.tencent.open.filedownload.b bVar3 = this.K;
            bVar3.f341570i = com.tencent.open.filedownload.a.c(bVar3.f341566e);
        }
        this.P = arguments.getString("big_brother_source_key");
        f.e("ApkFileDownloadFragment_", "mPageType:" + this.M + "\nTaskInfo:" + this.K + "\nmSource:" + this.P);
    }

    private void xh() {
        String str;
        String str2;
        AppCenterReporter.n(com.tencent.open.appstore.report.a.u().n(this.M.f341560b).l("0").o("0").t(this.M.f341559a).i(this.K.f341570i).m(this.K.f341567f).r(this.K.f341566e));
        if (this.J) {
            QQAppInterface qQAppInterface = getBaseActivity().app;
            String str3 = this.K.f341570i;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009AC3", "0X8009AC3", 0, 0, "", "", str2, "");
            return;
        }
        QQAppInterface qQAppInterface2 = getBaseActivity().app;
        String str4 = this.K.f341570i;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        ReportController.o(qQAppInterface2, "dc00898", "", "", "0X8009AC2", "0X8009AC2", 0, 0, "", "", str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(boolean z16) {
        this.F.setVisibility(0);
        this.F.z(z16, true);
        this.G.t();
        this.G.setVisibility(8);
        this.I.setVisibility(4);
        QQAppInterface qQAppInterface = getBaseActivity().app;
        String str = this.K.f341570i;
        if (str == null) {
            str = "";
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009AC5", "0X8009AC5", 0, 0, "", "", str, "");
    }

    private boolean zh() {
        if (this.J || this.F.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        BaseActivity baseActivity = getBaseActivity();
        this.N = baseActivity;
        QAppCenterPluginProxyActivityTools.F2(baseActivity);
        parseIntent();
        initView();
        initData();
        xh();
        Ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168442w9;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (zh()) {
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v(ThemeSwitchUtil.FROM_LOGIN_RESULT).n(this.M.f341560b).l("2").o("0").t(this.M.f341559a).i(this.K.f341570i).m(this.K.f341567f).r(this.K.f341566e));
            this.F.A(false, true);
            return true;
        }
        AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v("200").n(this.M.f341560b).l("2").o("0").t(this.M.f341559a).i(this.K.f341570i).m(this.K.f341567f).r(this.K.f341566e));
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        f.e("ApkFileDownloadFragment_", "[onDestroy]");
        NormalDownloadButton normalDownloadButton = this.F;
        if (normalDownloadButton != null) {
            normalDownloadButton.destroy();
        }
        WhiteListDownloadButton whiteListDownloadButton = this.H;
        if (whiteListDownloadButton != null) {
            whiteListDownloadButton.destroy();
        }
        SafeDownloadButton safeDownloadButton = this.G;
        if (safeDownloadButton != null) {
            safeDownloadButton.destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        f.e("ApkFileDownloadFragment_", "[onResume]");
        this.G.I();
        super.onResume();
    }
}
