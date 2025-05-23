package com.tencent.mobileqq.guild.open;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.x;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.security.api.ISecurityTipHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.cj;
import com.tencent.mobileqq.qqguildsdk.data.fa;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.Pair;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd55$RspBody;
import vh2.u;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildOpenVerifyFragment extends QPublicBaseFragment {
    protected QQAppInterface C;
    protected QBaseActivity D;
    protected QQProgressDialog E;
    protected QQCustomDialog F;
    protected DialogInterface.OnClickListener G;
    private boolean H = false;
    private boolean I = true;
    private Bundle J;
    private QQGuildOpenData K;
    private com.tencent.mobileqq.forward.b L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        a() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            GuildOpenVerifyFragment.this.U7();
            if (GuildOpenVerifyFragment.this.getQBaseActivity() == null) {
                QLog.e("QQGuildOpenVerifyFragment", 1, "activity is destroy");
                return;
            }
            com.tencent.mobileqq.forward.b bVar = new com.tencent.mobileqq.forward.b();
            oidb_0xd55$RspBody a06 = ForwardUtils.a0(bArr);
            if (a06 != null) {
                com.tencent.mobileqq.forward.b.b(a06, GuildOpenVerifyFragment.this.K.packageId, bVar);
            }
            if (i3 == 0) {
                GuildOpenVerifyFragment.this.wh(bVar, true);
                return;
            }
            if (i3 == 25501) {
                GuildOpenVerifyFragment.this.wh(bVar, false);
                return;
            }
            String g16 = bVar.g();
            if (TextUtils.isEmpty(g16)) {
                g16 = "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            GuildOpenVerifyFragment.this.showFailToast(g16);
            QLog.e("QQGuildOpenVerifyFragment", 1, "checkOpenIdAndScheme error:", Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GuildOpenVerifyFragment guildOpenVerifyFragment = GuildOpenVerifyFragment.this;
            if (guildOpenVerifyFragment.F == dialogInterface) {
                if (i3 == 1) {
                    if (!guildOpenVerifyFragment.I) {
                        GuildOpenVerifyFragment.this.yh();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_params", GuildOpenVerifyFragment.this.J);
                    intent.putExtra("is_change_account", true);
                    intent.putExtra("fromGuildOpen", true);
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    RouteUtils.startActivity(GuildOpenVerifyFragment.this.getQBaseActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
                    GuildOpenVerifyFragment.this.getQBaseActivity().finish();
                    return;
                }
                if (i3 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errCode", -1);
                        jSONObject.put("errMsg", "user cancel");
                        if (OperateCustomButton.OPERATE_CREATE.equals(GuildOpenVerifyFragment.this.J.getString("extra_action"))) {
                            jSONObject.put("action", "guildOpenCreate");
                        } else if (IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE.equals(GuildOpenVerifyFragment.this.J.getString("extra_action"))) {
                            jSONObject.put("action", "guildOpenJoin");
                        }
                        ((IGuildOpenApi) GuildOpenVerifyFragment.this.C.getRuntimeService(IGuildOpenApi.class, "")).handleGuildOpenResult(GuildOpenVerifyFragment.this.K.packageId, jSONObject.toString(), GuildOpenVerifyFragment.this.K.appId, GuildOpenVerifyFragment.this.K.openId);
                        GuildOpenVerifyFragment.this.getQBaseActivity().finish();
                    } catch (Exception e16) {
                        QLog.e("QQGuildOpenVerifyFragment", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements QQProgressDialog.b {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            QLog.d("QQGuildOpenVerifyFragment", 1, "onBackPressed");
            QBaseActivity qBaseActivity = GuildOpenVerifyFragment.this.getQBaseActivity();
            if (qBaseActivity != null) {
                qBaseActivity.doOnBackPressed();
            }
            GuildOpenVerifyFragment.this.E.O(null);
        }
    }

    private void Bh() {
        QQCustomDialog qQCustomDialog = this.F;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            this.F.show();
            return;
        }
        if (this.F == null) {
            this.F = DialogUtil.createCustomDialog(getQBaseActivity(), 230);
            this.G = new b();
        }
        this.F.setMessage(this.I ? R.string.f17636312 : R.string.d65);
        this.F.setTitle(R.string.b1v);
        this.F.setNegativeButton(getString(R.string.cancel), this.G);
        this.F.setPositiveButton(getString(this.I ? R.string.f170711zm : R.string.ans), this.G);
        this.F.show();
    }

    private void vh(Bundle bundle, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        bundle.putString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (this.H) {
            ((IGuildOpenApi) this.C.getRuntimeService(IGuildOpenApi.class, "")).gotoGuildOpenCreateAction(getQBaseActivity(), this.L.j(), this.L.l(), this.K);
            return;
        }
        IGPSService iGPSService = (IGPSService) this.C.getRuntimeService(IGPSService.class, "");
        QQGuildOpenData qQGuildOpenData = this.K;
        cj cjVar = new cj(qQGuildOpenData.appId, qQGuildOpenData.orgId, qQGuildOpenData.worldId);
        QQGuildOpenData qQGuildOpenData2 = this.K;
        iGPSService.fetchGuildInfoByAppIdentity(cjVar, qQGuildOpenData2.guildOpenId, qQGuildOpenData2.rawUrl, new u() { // from class: iv1.a
            @Override // vh2.u
            public final void a(int i3, String str, fa faVar, IGProSecurityResult iGProSecurityResult) {
                GuildOpenVerifyFragment.this.Ah(i3, str, faVar, iGProSecurityResult);
            }
        });
    }

    private boolean zh() {
        Bundle bundleExtra = this.D.getIntent().getBundleExtra("key_params");
        this.J = bundleExtra;
        if (bundleExtra == null) {
            QLog.i("QQGuildOpenVerifyFragment", 1, "doOnCreate params is null.");
            return false;
        }
        this.H = OperateCustomButton.OPERATE_CREATE.equals(bundleExtra.getString("extra_action"));
        String string = this.J.getString("force_account_equal");
        this.I = TextUtils.isEmpty(string) || "1".equals(string);
        QQGuildOpenData qQGuildOpenData = new QQGuildOpenData();
        this.K = qQGuildOpenData;
        qQGuildOpenData.rawUrl = this.J.getString("extra_raw_url");
        this.K.appId = ForwardUtils.Z(this.J.getString("appid"));
        this.K.appName = this.J.getString("app_name");
        this.K.openId = this.J.getString("openid");
        this.K.packageId = this.J.getString("package_id");
        this.K.guildOpenId = this.J.getString("guild_openid");
        this.K.orgId = this.J.getString("guild_id");
        this.K.worldId = this.J.getString("zone_id");
        this.K.isFromSDK = "1".equals(this.J.getString("from_open_sdk"));
        QQGuildOpenData qQGuildOpenData2 = this.K;
        if (qQGuildOpenData2.appId > 0 && !TextUtils.isEmpty(qQGuildOpenData2.openId)) {
            return true;
        }
        QLog.d("QQGuildOpenVerifyFragment", 1, "appId: " + this.K.appId + ", openId: " + this.K.openId + ", return.");
        return false;
    }

    protected void Ch(String str) {
        if (this.E == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
            this.E = qQProgressDialog;
            qQProgressDialog.O(new c());
        }
        U7();
        this.E.setMessage(str);
        this.E.show();
    }

    protected void U7() {
        QQProgressDialog qQProgressDialog = this.E;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.E.dismiss();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.requestWindowFeature(1);
        activity.getWindow().addFlags(1024);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.D = getQBaseActivity();
        if (!zh()) {
            showFailToast("\u53c2\u6570\u9519\u8bef\u3002");
        } else {
            xh(this.H);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        qBaseActivity.overridePendingTransition(0, 0);
    }

    protected void showFailToast(String str) {
        QQToast.makeText(getQBaseActivity(), 1, str, 0).show(getQBaseActivity().getTitleBarHeight());
        this.D.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(int i3, String str, fa faVar, IGProSecurityResult iGProSecurityResult) {
        QLog.d("QQGuildOpenVerifyFragment", 1, "goToGuildAction result:", Integer.valueOf(i3), " errMsg:", str, " info:", faVar);
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).checkSecurityValid(iGProSecurityResult) && i3 == 0 && faVar != null) {
                Bundle bundle = new Bundle();
                Uri parse = Uri.parse(this.K.rawUrl);
                String queryParameter = parse.getQueryParameter("version");
                Pair<String, String> c16 = QQGuildJumpSource.c(queryParameter, "QQGuildOpenVerifyFragment");
                JumpGuildParam jumpGuildParam = new JumpGuildParam(faVar.getGuildID(), "");
                jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(faVar.getJoinSig(), c16.first, c16.second));
                bundle.putString(AppConstants.Key.GUILD_FROM, "guildOpenJoin");
                bundle.putString(AppConstants.Key.GUILD_FROM_APP_NAME, this.K.appName);
                vh(bundle, "appid", parse.getQueryParameter("appid"));
                vh(bundle, "template_id", parse.getQueryParameter("template_id"));
                vh(bundle, "version", queryParameter);
                jumpGuildParam.extras = bundle;
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(getContext(), jumpGuildParam);
                getActivity().finish();
                return;
            }
            ((ISecurityTipHelper) QRoute.api(ISecurityTipHelper.class)).showSecurityTip(getContext(), i3, str, iGProSecurityResult, "");
            getActivity().finish();
            return;
        }
        QLog.w("QQGuildOpenVerifyFragment", 1, "goToGuildAction activity status error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(com.tencent.mobileqq.forward.b bVar, boolean z16) {
        QLog.d("QQGuildOpenVerifyFragment", 1, "checkAccount isSame:", Boolean.valueOf(z16));
        this.L = bVar;
        if (z16) {
            yh();
        } else {
            Bh();
        }
    }

    private void xh(boolean z16) {
        QLog.d("QQGuildOpenVerifyFragment", 1, "checkOpenIdAndScheme isCreate:", Boolean.valueOf(z16));
        Ch(HardCodeUtil.qqStr(R.string.f171618jt0));
        MessageHandler msgHandler = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getMsgHandler();
        QQGuildOpenData qQGuildOpenData = this.K;
        msgHandler.N2(true, qQGuildOpenData.openId, false, 0L, qQGuildOpenData.appId, 1, 2005, qQGuildOpenData.packageId, true, x.k(), this.K.rawUrl, new a());
    }
}
