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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.x;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.impl.GuildWebApiImpl;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import tencent.im.oidb.oidb_0xd55$RspBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildVerifyAccountAndOpenH5Fragment extends QPublicBaseFragment {
    private QBaseActivity C;
    private QQProgressDialog D;
    private QQCustomDialog E;
    private DialogInterface.OnClickListener F;
    private QQGuildOpenData G;
    private Bundle H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f230947d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f230948e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f230949f;

        a(String str, String str2, String str3) {
            this.f230947d = str;
            this.f230948e = str2;
            this.f230949f = str3;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            PBStringField pBStringField;
            GuildVerifyAccountAndOpenH5Fragment.this.U7();
            if (GuildVerifyAccountAndOpenH5Fragment.this.getQBaseActivity() == null) {
                QLog.e("QQGuildOpenVerifyFragment", 1, "activity is destroy");
                return;
            }
            com.tencent.mobileqq.forward.b bVar = new com.tencent.mobileqq.forward.b();
            oidb_0xd55$RspBody a06 = ForwardUtils.a0(bArr);
            if (a06 != null) {
                com.tencent.mobileqq.forward.b.b(a06, GuildVerifyAccountAndOpenH5Fragment.this.G.packageId, bVar);
            }
            if (i3 == 0) {
                GuildVerifyAccountAndOpenH5Fragment guildVerifyAccountAndOpenH5Fragment = GuildVerifyAccountAndOpenH5Fragment.this;
                guildVerifyAccountAndOpenH5Fragment.wh(guildVerifyAccountAndOpenH5Fragment.getQBaseActivity(), this.f230947d, this.f230948e, this.f230949f, bVar);
                return;
            }
            if (i3 == 25501) {
                GuildVerifyAccountAndOpenH5Fragment.this.yh();
                return;
            }
            String g16 = bVar.g();
            if (a06 != null && (pBStringField = a06.wording) != null) {
                g16 = pBStringField.get();
            }
            if (TextUtils.isEmpty(g16)) {
                g16 = "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            GuildVerifyAccountAndOpenH5Fragment.this.showFailToast(g16);
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
            if (GuildVerifyAccountAndOpenH5Fragment.this.E == dialogInterface) {
                if (i3 != 1) {
                    if (i3 == 0) {
                        try {
                            GuildVerifyAccountAndOpenH5Fragment.this.getQBaseActivity().finish();
                            return;
                        } catch (Exception e16) {
                            QLog.e("QQGuildOpenVerifyFragment", 1, e16, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_params", GuildVerifyAccountAndOpenH5Fragment.this.H);
                intent.putExtra("is_change_account", true);
                intent.putExtra("fromGuildOpen", true);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                RouteUtils.startActivity(GuildVerifyAccountAndOpenH5Fragment.this.getQBaseActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
                GuildVerifyAccountAndOpenH5Fragment.this.getQBaseActivity().finish();
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
            QBaseActivity qBaseActivity = GuildVerifyAccountAndOpenH5Fragment.this.getQBaseActivity();
            if (qBaseActivity != null) {
                qBaseActivity.doOnBackPressed();
            }
            GuildVerifyAccountAndOpenH5Fragment.this.D.O(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(Activity activity, String str, String str2, String str3, com.tencent.mobileqq.forward.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            str = Uri.parse(str).buildUpon().appendQueryParameter("raw_url", str2).appendQueryParameter("package_id", str3).build().toString();
        }
        ((IGuildOpenApi) getQBaseActivity().getAppRuntime().getRuntimeService(IGuildOpenApi.class, "")).setPackageSchemeData(bVar.j(), bVar.l(), this.G);
        GuildWebApiImpl.guildOpenWebUrlOnly(activity, str, null, null, null);
        activity.finish();
    }

    private void xh() {
        Bundle bundleExtra = this.C.getIntent().getBundleExtra("key_params");
        this.H = bundleExtra;
        if (bundleExtra == null) {
            QLog.i("QQGuildOpenVerifyFragment", 1, "doOnCreate params is null.");
            showFailToast("\u53c2\u6570\u9519\u8bef\u3002");
            return;
        }
        vh(this.H.getString("openid"), ForwardUtils.Z(this.H.getString("appid")), this.H.getString("package_id"), bundleExtra.getString("extra_raw_url"), new String(PluginBaseInfoHelper.Base64Helper.decode(this.H.getString(TuxDialogBundleKey.WEB_URL), 0)));
        QQGuildOpenData qQGuildOpenData = new QQGuildOpenData();
        this.G = qQGuildOpenData;
        qQGuildOpenData.rawUrl = this.H.getString("extra_raw_url");
        this.G.appId = ForwardUtils.Z(this.H.getString("appid"));
        this.G.appName = this.H.getString("app_name");
        this.G.openId = this.H.getString("openid");
        this.G.packageId = this.H.getString("package_id");
        this.G.guildOpenId = this.H.getString("guild_openid");
        this.G.orgId = this.H.getString("guild_id");
        this.G.worldId = this.H.getString("zone_id");
        this.G.isFromSDK = "1".equals(this.H.getString("from_open_sdk"));
        QQGuildOpenData qQGuildOpenData2 = this.G;
        if (qQGuildOpenData2.appId <= 0 || TextUtils.isEmpty(qQGuildOpenData2.openId)) {
            QLog.d("QQGuildOpenVerifyFragment", 1, "appId: " + this.G.appId + ", openId: " + this.G.openId + ", return.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        QQCustomDialog qQCustomDialog = this.E;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            this.E.show();
            return;
        }
        if (this.E == null) {
            this.E = DialogUtil.createCustomDialog(getQBaseActivity(), 230);
            this.F = new b();
        }
        this.E.setMessage(R.string.f17636312);
        this.E.setTitle(R.string.b1v);
        this.E.setNegativeButton(getString(R.string.cancel), this.F);
        this.E.setPositiveButton(getString(R.string.f170711zm), this.F);
        this.E.show();
    }

    protected void U7() {
        QQProgressDialog qQProgressDialog = this.D;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.D.dismiss();
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
        this.C = getQBaseActivity();
        xh();
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
        this.C.finish();
    }

    protected void zh(String str) {
        if (this.D == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
            this.D = qQProgressDialog;
            qQProgressDialog.O(new c());
        }
        U7();
        this.D.setMessage(str);
        this.D.show();
    }

    private void vh(String str, long j3, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && j3 > 0 && !TextUtils.isEmpty(str4)) {
            zh(HardCodeUtil.qqStr(R.string.f171618jt0));
            ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getMsgHandler().N2(true, str, false, 0L, j3, 1, 2005, str2, true, x.k(), str3, new a(str4, str3, str2));
            return;
        }
        QLog.e("QQGuildOpenVerifyFragment", 1, "appId: " + j3 + ", openId: " + str + ", webUrl: " + str4 + ", return.");
        showFailToast("\u53c2\u6570\u9519\u8bef\u3002");
    }
}
