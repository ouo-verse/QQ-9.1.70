package com.tencent.open.agent;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.notify.CommonAuthorityEvent;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.model.AppInfo;
import com.tencent.open.sdk.data.AuthoritySdkJumpInfo;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import hq3.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xf26.oidb_0xf26$AuthItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthorityControlAppDetailsFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    private View C;
    private View D;
    private int E;
    private Activity F;
    private QQAppInterface G;
    private AppInfo H;
    private OpenAgentHandler I;
    private com.tencent.open.manager.a J;
    private QQProgressDialog K;
    private int L;
    private AuthoritySdkJumpInfo M;
    private long N;
    private long P;
    private BroadcastReceiver Q;
    private RelativeLayout S;
    private boolean R = false;
    private Runnable T = new Runnable() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.7
        @Override // java.lang.Runnable
        public void run() {
            AuthorityControlAppDetailsFragment.this.showLoadingDialog();
        }
    };
    private Runnable U = new Runnable() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.8
        @Override // java.lang.Runnable
        public void run() {
            AuthorityControlAppDetailsFragment.this.E = 2;
            AuthorityControlAppDetailsFragment.this.Nh();
            QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, HardCodeUtil.qqStr(R.string.f172922rr), 0).show();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f339554d;

        a(f fVar) {
            this.f339554d = fVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onCheckedChanged name=", this.f339554d.f339562b, ", isChecked=", Boolean.valueOf(z16));
            f fVar = this.f339554d;
            fVar.f339564d = z16;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            AuthorityControlAppDetailsFragment.this.ci(i3, fVar.f339561a);
            com.tencent.open.agent.util.g.P(AuthorityControlAppDetailsFragment.this.G, "0X800B930", z16 ? 1 : 0, AuthorityControlAppDetailsFragment.this.Ph(), new String[]{String.valueOf(AuthorityControlAppDetailsFragment.this.H.c()), "", AuthorityControlAppDetailsFragment.this.H.e(), this.f339554d.f339562b});
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("appId", 0L);
            long longExtra2 = intent.getLongExtra("launchTime", 0L);
            if (longExtra > 0 && AuthorityControlAppDetailsFragment.this.P == longExtra && AuthorityControlAppDetailsFragment.this.N < longExtra2) {
                QLog.d("AuthorityControlAppDetailsActivity", 1, "mLaunchReceiver.onReceive: finish self");
                AuthorityControlAppDetailsFragment.this.R = true;
                AuthorityControlAppDetailsFragment.this.F.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f339557d;

        c(g gVar) {
            this.f339557d = gVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onReceive: isSuccess = ", Boolean.valueOf(z16));
            if (!z16) {
                int i16 = bundle.getInt("code", -1);
                String string = bundle.getString("errorMsg", "");
                this.f339557d.onFail(i16, string);
                QLog.d("AuthorityControlAppDetailsActivity", 1, "onReceive: errorCode=" + i16 + " errorMsg=" + string);
                return;
            }
            try {
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                    getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                    this.f339557d.a(com.tencent.mobileqq.forward.b.a(getAppInfoProto$GetAppinfoResponse));
                } else {
                    QLog.e("AuthorityControlAppDetailsActivity", 1, "onReceive: data=null");
                    this.f339557d.onFail(-1, "data is null!");
                }
            } catch (Exception e16) {
                QLog.e("AuthorityControlAppDetailsActivity", 1, "onReceive: " + e16.getMessage());
                this.f339557d.onFail(-1, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d extends com.tencent.open.manager.a {
        d() {
        }

        private void d(OpenAgentHandler.a aVar) {
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemError errorCode=", Integer.valueOf(aVar.f341597b), ", errorMessage=", aVar.f341598c);
            int i3 = aVar.f341597b;
            if (i3 == 36004) {
                QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, 1, R.string.f170501z82, 0).show();
                AuthorityControlAppDetailsFragment.this.F.finish();
                com.tencent.open.agent.util.g.P(AuthorityControlAppDetailsFragment.this.G, "0X800BAE2", 0, AuthorityControlAppDetailsFragment.this.Ph(), new String[]{String.valueOf(AuthorityControlAppDetailsFragment.this.H.c()), "", AuthorityControlAppDetailsFragment.this.H.e(), ""});
            } else if (i3 != 0 && !TextUtils.isEmpty(aVar.f341598c)) {
                QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, String.format(AuthorityControlAppDetailsFragment.this.getString(R.string.e0_), aVar.f341598c, Integer.valueOf(aVar.f341597b)), 0).show();
            } else {
                QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, HardCodeUtil.qqStr(R.string.f172922rr), 0).show();
            }
        }

        private void e(OpenAgentHandler.a aVar) {
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemSuccess type=", Integer.valueOf(aVar.f341596a));
            if (aVar.f341596a == 1) {
                AuthorityControlAppDetailsFragment.this.fi(aVar.f341599d.query_rsp.auth_item.get());
            }
        }

        @Override // com.tencent.open.manager.a
        protected void a(boolean z16, OpenAgentHandler.a aVar) {
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemResult isSuccess=", Boolean.valueOf(z16), ", mStatus=", Integer.valueOf(AuthorityControlAppDetailsFragment.this.E));
            if (AuthorityControlAppDetailsFragment.this.F != null && !AuthorityControlAppDetailsFragment.this.F.isFinishing()) {
                if (AuthorityControlAppDetailsFragment.this.Zh()) {
                    return;
                }
                if (z16) {
                    e(aVar);
                    return;
                } else {
                    d(aVar);
                    return;
                }
            }
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onAuthItemResult activity finishing");
        }

        @Override // com.tencent.open.manager.a
        protected void b(boolean z16, List<AppInfo> list) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.i("AuthorityControlAppDetailsActivity", 2, "onDelApp: invoked.  isSuccess: " + z16 + " infos: " + list);
            }
            if (z16) {
                if (list != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new CommonAuthorityEvent(list));
                }
                QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, 2, HardCodeUtil.qqStr(R.string.jsy) + AuthorityControlAppDetailsFragment.this.H.e() + HardCodeUtil.qqStr(R.string.jsw), 0).show();
                Intent intent = new Intent();
                if (list != null && list.size() == 1) {
                    intent.putExtra("KEY_DELETED_INFO", list.get(0));
                    AuthorityControlAppDetailsFragment.this.F.setResult(-1, intent);
                }
                AuthorityControlAppDetailsFragment.this.Xh(list);
                AuthorityControlAppDetailsFragment.this.F.finish();
            } else {
                QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, 1, HardCodeUtil.qqStr(R.string.jsx), 0).show();
            }
            QQAppInterface qQAppInterface = AuthorityControlAppDetailsFragment.this.G;
            if (z16) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009E1C", "0X8009E1C", 0, 0, str, "", String.valueOf(AuthorityControlAppDetailsFragment.this.H.c()), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements QQProgressDialog.b {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            QLog.d("AuthorityControlAppDetailsActivity", 1, "onBackPressed");
            BaseActivity baseActivity = AuthorityControlAppDetailsFragment.this.getBaseActivity();
            if (baseActivity != null) {
                baseActivity.doOnBackPressed();
            }
            AuthorityControlAppDetailsFragment.this.K.O(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f339561a;

        /* renamed from: b, reason: collision with root package name */
        public String f339562b;

        /* renamed from: c, reason: collision with root package name */
        public String f339563c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f339564d;

        f() {
        }

        public String toString() {
            return "AuthPermission{name='" + this.f339562b + "', desc='" + this.f339563c + "', isChecked=" + this.f339564d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface g {
        void a(com.tencent.mobileqq.forward.b bVar);

        void onFail(int i3, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(final AppInfo appInfo) {
        hq3.a aVar = new hq3.a(this.G);
        Yh();
        aVar.a(this.M.a().b(), this.M.a().e(), new b.InterfaceC10469b() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.4

            /* compiled from: P */
            /* renamed from: com.tencent.open.agent.AuthorityControlAppDetailsFragment$4$a */
            /* loaded from: classes22.dex */
            class a extends b.a.c {
                a() {
                }

                @Override // hq3.b.a.c
                public void a() {
                    AuthorityControlAppDetailsFragment.this.F.finish();
                }

                @Override // hq3.b.a.c
                public void c() {
                    AuthorityControlAppDetailsFragment.this.F.finish();
                }
            }

            @Override // hq3.b.InterfaceC10469b
            public void onError(int i3, String str) {
                if (AuthorityControlAppDetailsFragment.this.F != null && !AuthorityControlAppDetailsFragment.this.F.isFinishing()) {
                    if (AuthorityControlAppDetailsFragment.this.Zh()) {
                        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
                        return;
                    }
                    QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: onError " + i3 + " " + str);
                    QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, HardCodeUtil.qqStr(R.string.f172922rr), 0).show();
                    AuthorityControlAppDetailsFragment.this.F.finish();
                }
            }

            @Override // hq3.b.InterfaceC10469b
            public void onSuccess(boolean z16) {
                if (AuthorityControlAppDetailsFragment.this.F != null && !AuthorityControlAppDetailsFragment.this.F.isFinishing()) {
                    QLog.i("AuthorityControlAppDetailsActivity", 1, "checkAccount: onSuccess same=" + z16);
                    if (AuthorityControlAppDetailsFragment.this.Zh()) {
                        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
                    } else {
                        if (z16) {
                            AuthorityControlAppDetailsFragment.this.G.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AuthorityControlAppDetailsFragment.this.D.setVisibility(0);
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    AuthorityControlAppDetailsFragment.this.Qh(appInfo);
                                }
                            });
                            return;
                        }
                        new b.a(AuthorityControlAppDetailsFragment.this.F, String.format(AuthorityControlAppDetailsFragment.this.F.getString(R.string.f170500z81), appInfo.e()), 1).a(new a());
                        com.tencent.open.agent.util.g.P(AuthorityControlAppDetailsFragment.this.G, "0X800BAE1", 0, AuthorityControlAppDetailsFragment.this.Ph(), new String[]{String.valueOf(appInfo.c()), "", appInfo.e(), ""});
                    }
                }
            }
        });
    }

    private View Mh(f fVar, ViewGroup viewGroup) {
        View inflate = this.F.getLayoutInflater().inflate(R.layout.dze, viewGroup, false);
        if (!TextUtils.isEmpty(fVar.f339563c)) {
            TextView textView = (TextView) inflate.findViewById(R.id.a0z);
            textView.setVisibility(0);
            textView.setText(fVar.f339563c);
        }
        ((TextView) inflate.findViewById(R.id.sxm)).setText(fVar.f339562b);
        Switch r06 = (Switch) inflate.findViewById(R.id.sxy);
        r06.setChecked(fVar.f339564d);
        r06.setOnCheckedChangeListener(new a(fVar));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        QLog.d("AuthorityControlAppDetailsActivity", 1, "dismissLoadingDialog");
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.K.dismiss();
        }
    }

    private void Oh(BasicSdkJumpInfo basicSdkJumpInfo, g gVar) {
        String o16;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String f16 = basicSdkJumpInfo.f();
        if (TextUtils.isEmpty(f16)) {
            o16 = "";
        } else {
            o16 = com.tencent.open.agent.util.g.o(this.F, f16, currentTimeMillis + "");
        }
        QQAppInterface qQAppInterface = this.G;
        Share.m(qQAppInterface, this.F, qQAppInterface.getCurrentAccountUin(), basicSdkJumpInfo.b(), o16, 0L, currentTimeMillis, new c(gVar), f16, 15000L, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ph() {
        int i3 = this.L;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(AppInfo appInfo) {
        this.H = appInfo;
        setTitle(appInfo.e());
        gi();
        this.I = (OpenAgentHandler) this.G.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER);
        ci(1, 0);
    }

    private void Rh(AuthoritySdkJumpInfo authoritySdkJumpInfo) {
        this.D.setVisibility(8);
        setTitle("");
        this.M = authoritySdkJumpInfo;
        final BasicSdkJumpInfo a16 = authoritySdkJumpInfo.a();
        Yh();
        Oh(a16, new g() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.2
            @Override // com.tencent.open.agent.AuthorityControlAppDetailsFragment.g
            public void a(com.tencent.mobileqq.forward.b bVar) {
                if (AuthorityControlAppDetailsFragment.this.F != null && !AuthorityControlAppDetailsFragment.this.F.isFinishing()) {
                    QLog.i("AuthorityControlAppDetailsActivity", 1, "getAppInfo: success");
                    if (AuthorityControlAppDetailsFragment.this.Zh()) {
                        QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
                        return;
                    }
                    final AppInfo appInfo = new AppInfo((int) a16.b(), bVar.f(), bVar.i());
                    AuthorityControlAppDetailsFragment.this.G.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AuthorityControlAppDetailsFragment.this.setTitle(appInfo.e());
                        }
                    });
                    AuthorityControlAppDetailsFragment.this.di(appInfo.c(), appInfo.e());
                    AuthorityControlAppDetailsFragment.this.Lh(appInfo);
                }
            }

            @Override // com.tencent.open.agent.AuthorityControlAppDetailsFragment.g
            public void onFail(int i3, String str) {
                if (AuthorityControlAppDetailsFragment.this.F != null && !AuthorityControlAppDetailsFragment.this.F.isFinishing()) {
                    QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: error code=" + i3 + ", " + str);
                    if (!AuthorityControlAppDetailsFragment.this.Zh()) {
                        AuthorityControlAppDetailsFragment.this.E = 0;
                        QQToast.makeText(AuthorityControlAppDetailsFragment.this.F, R.string.f170502z83, 0).show();
                        AuthorityControlAppDetailsFragment.this.F.finish();
                        return;
                    }
                    QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
                }
            }
        });
    }

    private void Sh() {
        b bVar = new b();
        this.Q = bVar;
        this.F.registerReceiver(bVar, new IntentFilter("action_opensdk_app_detail_open"));
    }

    private void Th() {
        this.J = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uh(ActionSheet actionSheet, View view, int i3) {
        if (i3 == 0) {
            this.I.D2(new ArrayList<AppInfo>() { // from class: com.tencent.open.agent.AuthorityControlAppDetailsFragment.6
                {
                    add(AuthorityControlAppDetailsFragment.this.H);
                }
            }, this.J);
            actionSheet.dismiss();
        }
    }

    public static void Vh(Activity activity, AppInfo appInfo) {
        Intent intent = new Intent(activity, (Class<?>) AuthorityControlAppDetailsFragment.class);
        intent.putExtra("KEY_APP_INFO", appInfo);
        intent.putExtra("from", 1);
        PublicFragmentActivity.startForResult(activity, intent, AuthorityControlAppDetailsFragment.class, 996);
    }

    public static void Wh(Context context, AuthoritySdkJumpInfo authoritySdkJumpInfo) {
        QLog.i("AuthorityControlAppDetailsActivity", 1, "launchFromSdk");
        Intent intent = new Intent(context, (Class<?>) AuthorityControlAppDetailsFragment.class);
        intent.putExtra("KEY_SDK_INFO", authoritySdkJumpInfo);
        intent.putExtra("from", 2);
        PublicFragmentActivity.start(context, intent, AuthorityControlAppDetailsFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(List<AppInfo> list) {
        MqqHandler handler;
        if (this.L == 2 && list != null && list.size() != 0 && (handler = this.G.getHandler(AuthorityControlFragment.class)) != null) {
            handler.sendMessage(handler.obtainMessage(1, list));
        }
    }

    private void Yh() {
        this.E = 1;
        ThreadManager.getUIHandler().postDelayed(this.T, 400L);
        ThreadManager.getUIHandler().postDelayed(this.U, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zh() {
        boolean z16;
        if (this.E == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.E = 0;
        ThreadManager.getUIHandler().removeCallbacks(this.T);
        ThreadManager.getUIHandler().removeCallbacks(this.U);
        Nh();
        return z16;
    }

    private void ai(View view) {
        String string = this.F.getString(R.string.f173060h10, this.H.e());
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.F, null);
        actionSheet.setRoundCornerTop(true);
        actionSheet.setMainTitle(string);
        actionSheet.addButton(R.string.j2t, 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.open.agent.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                AuthorityControlAppDetailsFragment.this.Uh(actionSheet, view2, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        try {
            actionSheet.show();
        } catch (Throwable unused) {
        }
        ReportController.o(this.G, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.H.c()), "");
        com.tencent.open.agent.util.g.P(this.G, "0X800B931", 0, Ph(), new String[]{String.valueOf(this.H.c()), "", this.H.e(), ""});
    }

    private void bi() {
        Intent intent = new Intent();
        intent.putExtra(ThirdPartyMiniApiImpl.KEY_GAME_APP_ID, this.H.c());
        PublicFragmentActivity.startForResult(getActivity(), intent, GameCenterAuthFrament4QQSetting.class, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(int i3, int i16) {
        QLog.d("AuthorityControlAppDetailsActivity", 1, "operateAuthItem type=", Integer.valueOf(i3), ", id=", Integer.valueOf(i16), ", mStatus=", Integer.valueOf(this.E));
        if (!NetworkUtil.isNetworkAvailable(this.F)) {
            QQToast.makeText(this.F, HardCodeUtil.qqStr(R.string.f171155cp4), 0).show();
            return;
        }
        if (this.E != 0) {
            return;
        }
        this.E = 1;
        if (this.L == 2) {
            BasicSdkJumpInfo a16 = this.M.a();
            this.I.L2(this.H.c(), i3, Collections.singletonList(Integer.valueOf(i16)), a16.e(), a16.a(), this.J);
        } else {
            this.I.K2(this.H.c(), i3, Collections.singletonList(Integer.valueOf(i16)), this.J);
        }
        Yh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i3, String str) {
        com.tencent.open.agent.util.g.P(this.G, "0X800BADE", 0, Ph(), new String[]{String.valueOf(i3), "", str, ""});
    }

    private void ei() {
        Intent intent = new Intent("action_opensdk_app_detail_open");
        intent.setPackage(this.F.getPackageName());
        intent.putExtra("appId", this.P);
        intent.putExtra("launchTime", this.N);
        this.F.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(List<oidb_0xf26$AuthItem> list) {
        boolean z16;
        QLog.d("AuthorityControlAppDetailsActivity", 1, "showAuthItems size=", Integer.valueOf(list.size()));
        if (list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.sxl);
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        int min = Math.min(list.size(), 20);
        boolean z17 = false;
        for (int i3 = 0; i3 < min; i3++) {
            oidb_0xf26$AuthItem oidb_0xf26_authitem = list.get(i3);
            f fVar = new f();
            fVar.f339561a = oidb_0xf26_authitem.auth_group_id.get();
            fVar.f339562b = oidb_0xf26_authitem.auth_group_name.get().toStringUtf8();
            fVar.f339563c = oidb_0xf26_authitem.auth_group_desc.get().toStringUtf8();
            if (oidb_0xf26_authitem.auth_result.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.f339564d = z16;
            QLog.d("AuthorityControlAppDetailsActivity", 1, "showAuthItems ", fVar);
            linearLayout.addView(Mh(fVar, linearLayout), new LinearLayout.LayoutParams(-1, -2));
            z17 = !TextUtils.isEmpty(fVar.f339563c);
        }
        if (z17) {
            View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166783i74);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = 0;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    private void gi() {
        AppInfo appInfo = this.H;
        if (appInfo != null && this.S != null) {
            boolean g16 = appInfo.g();
            QLog.i("AuthorityControlAppDetailsActivity", 1, "isCompetitiveGame:" + g16);
            if (g16) {
                this.S.setVisibility(0);
            } else {
                this.S.setVisibility(8);
            }
        }
    }

    private void initData() {
        Intent intent = this.F.getIntent();
        int intExtra = intent.getIntExtra("from", 1);
        this.L = intExtra;
        if (intExtra != 1) {
            if (intExtra == 2) {
                AuthoritySdkJumpInfo authoritySdkJumpInfo = (AuthoritySdkJumpInfo) intent.getParcelableExtra("KEY_SDK_INFO");
                this.P = authoritySdkJumpInfo.a().b();
                Rh(authoritySdkJumpInfo);
                return;
            }
            return;
        }
        AppInfo appInfo = (AppInfo) intent.getParcelableExtra("KEY_APP_INFO");
        Qh(appInfo);
        this.P = appInfo.c();
        di(appInfo.c(), appInfo.e());
    }

    private void initViews() {
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166783i74);
        this.C = findViewById;
        findViewById.setOnClickListener(this);
        this.D = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.sy5);
        RelativeLayout relativeLayout = (RelativeLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165317vi4);
        this.S = relativeLayout;
        relativeLayout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        QLog.d("AuthorityControlAppDetailsActivity", 1, "showLoadingDialog");
        if (this.K == null) {
            Activity activity = this.F;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.K = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.f171618jt0));
            this.K.O(new e());
        }
        if (this.K.isShowing()) {
            return;
        }
        this.K.show();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        if (this.L == 2 && !this.R && (SplashActivity.sWeakInstance == null || SplashActivity.sWeakInstance.get() == null)) {
            RouteUtils.startActivity(this.F, new Intent(), RouterConstants.UI_ROUTER_SPLASH);
        }
        BroadcastReceiver broadcastReceiver = this.Q;
        if (broadcastReceiver != null) {
            this.F.unregisterReceiver(broadcastReceiver);
            this.Q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167543a9;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f166783i74) {
            ai(view);
        } else if (id5 == R.id.f165317vi4) {
            bi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("AuthorityControlAppDetailsActivity", 1, "onDestroyView");
        this.E = 0;
        ThreadManager.getUIHandler().removeCallbacks(this.T);
        ThreadManager.getUIHandler().removeCallbacks(this.U);
        Nh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.F = baseActivity;
        if (baseActivity == null) {
            QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: mActivity is null");
            return;
        }
        if (baseActivity.getIntent() == null) {
            QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: intent is null");
            this.F.finish();
        }
        this.G = getBaseActivity().app;
        this.N = System.currentTimeMillis();
        Th();
        initViews();
        initData();
        gi();
        ei();
        Sh();
        ReportController.o(this.G, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
    }
}
