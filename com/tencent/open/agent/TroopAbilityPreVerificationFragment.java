package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60$ClientInfo;
import tencent.im.oidb.oidb_0xb60$ReqBody;
import tencent.im.oidb.oidb_0xb60$RspBody;

/* loaded from: classes22.dex */
public abstract class TroopAbilityPreVerificationFragment extends PublicBaseFragment {
    private static long T;
    private static long U;
    private static oidb_0xb60$RspBody V;
    protected QQAppInterface C;
    protected BaseActivity D;
    protected QQProgressDialog E;
    protected Bundle G;
    protected QQCustomDialog Q;
    protected DialogInterface.OnClickListener R;
    protected Handler F = new Handler();
    protected String H = "";
    protected String I = "";
    protected String J = "";
    protected String K = "";
    protected String L = "";
    protected String M = "";
    protected String N = "";
    protected int P = 1;
    private com.tencent.biz.common.util.i S = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            TroopAbilityPreVerificationFragment troopAbilityPreVerificationFragment = TroopAbilityPreVerificationFragment.this;
            if (troopAbilityPreVerificationFragment.Q == dialogInterface) {
                if (i3 == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("key_params", TroopAbilityPreVerificationFragment.this.G);
                    intent.putExtra("is_change_account", true);
                    intent.putExtra("fromThirdAppByOpenSDK", true);
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    RouteUtils.startActivity(TroopAbilityPreVerificationFragment.this.getBaseActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
                    TroopAbilityPreVerificationFragment.this.getBaseActivity().finish();
                    return;
                }
                if (i3 == 0) {
                    troopAbilityPreVerificationFragment.getBaseActivity().setResult(0);
                    TroopAbilityPreVerificationFragment.this.getBaseActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class b extends com.tencent.biz.common.util.i {
        b() {
        }

        @Override // com.tencent.biz.common.util.i
        protected void a(boolean z16, OpenID openID) {
            String str;
            QLog.d("TroopAbility.PreVerification", 1, "-->onGetOpenId, isSuccess: " + z16 + " data: " + openID);
            if (z16 && openID != null && (str = openID.openID) != null) {
                if (!str.equals(TroopAbilityPreVerificationFragment.this.I)) {
                    TroopAbilityPreVerificationFragment.this.U7();
                    TroopAbilityPreVerificationFragment.this.Ch();
                    return;
                } else {
                    TroopAbilityPreVerificationFragment.this.zh();
                    return;
                }
            }
            TroopAbilityPreVerificationFragment.this.yh(HardCodeUtil.qqStr(R.string.u_e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0135  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            String str2;
            QLog.i("TroopAbility.PreVerification", 1, "onResult type=" + TroopAbilityPreVerificationFragment.this.P + ", appid=" + TroopAbilityPreVerificationFragment.this.J + ", code=" + i3);
            if (i3 == 0 && bArr != null) {
                oidb_0xb60$RspBody oidb_0xb60_rspbody = new oidb_0xb60$RspBody();
                try {
                    oidb_0xb60_rspbody.mergeFrom(bArr);
                    if (oidb_0xb60_rspbody.get_privilege_rsp.api_groups.has() && oidb_0xb60_rspbody.get_privilege_rsp.next_req_duration.has()) {
                        TroopAbilityPreVerificationFragment.V = oidb_0xb60_rspbody;
                        QLog.d("TroopAbility.PreVerification", 1, "receive api_groups:" + oidb_0xb60_rspbody.get_privilege_rsp.api_groups.get() + ", api_names:" + oidb_0xb60_rspbody.get_privilege_rsp.api_names.get());
                        HashSet hashSet = new HashSet();
                        Iterator<Integer> it = oidb_0xb60_rspbody.get_privilege_rsp.api_groups.get().iterator();
                        while (it.hasNext()) {
                            hashSet.add(it.next());
                        }
                        boolean vh5 = TroopAbilityPreVerificationFragment.this.vh(hashSet);
                        QLog.i("TroopAbility.PreVerification", 1, "check permission result:" + vh5);
                        TroopAbilityPreVerificationFragment.this.Ah(vh5);
                        TroopAbilityPreVerificationFragment.U = (long) oidb_0xb60_rspbody.get_privilege_rsp.next_req_duration.get();
                        TroopAbilityPreVerificationFragment.T = NetConnInfoCenter.getServerTime();
                        return;
                    }
                    QLog.i("TroopAbility.PreVerification", 1, "rsp invalid");
                    TroopAbilityPreVerificationFragment.this.yh(HardCodeUtil.qqStr(R.string.u_b));
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.i("TroopAbility.PreVerification", 1, "parse rsp error", e16);
                    TroopAbilityPreVerificationFragment.this.yh(HardCodeUtil.qqStr(R.string.u_f));
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                if (bArr != null) {
                    try {
                        str = new oidb_0xb60$RspBody().mergeFrom(bArr).wording.get();
                    } catch (InvalidProtocolBufferMicroException unused) {
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("req error code=");
                    sb5.append(i3);
                    if (bArr != null) {
                        str2 = ", data=null";
                    } else {
                        str2 = ", msg=" + str;
                    }
                    sb5.append(str2);
                    QLog.i("TroopAbility.PreVerification", 1, sb5.toString());
                }
                str = "";
                StringBuilder sb52 = new StringBuilder();
                sb52.append("req error code=");
                sb52.append(i3);
                if (bArr != null) {
                }
                sb52.append(str2);
                QLog.i("TroopAbility.PreVerification", 1, sb52.toString());
            }
            TroopAbilityPreVerificationFragment.this.yh(HardCodeUtil.qqStr(R.string.u_i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        QQCustomDialog qQCustomDialog = this.Q;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            this.Q.show();
            return;
        }
        if (this.Q == null) {
            this.Q = DialogUtil.createCustomDialog(getBaseActivity(), 230);
            this.R = new a();
        }
        this.Q.setMessage(R.string.d65);
        this.Q.setTitle(R.string.b1v);
        this.Q.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), this.R);
        this.Q.setPositiveButton(HardCodeUtil.qqStr(R.string.u_h), this.R);
        this.Q.show();
    }

    private void uh() {
        OpenID b36 = this.C.getMsgHandler().b3(this.J);
        this.G.putString("uin", this.C.getCurrentAccountUin());
        if (b36 != null && !TextUtils.isEmpty(b36.openID)) {
            if (!this.I.equals(b36.openID)) {
                QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
                Ch();
                return;
            } else {
                zh();
                QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, mOpenId.equals(openId.openID)");
                return;
            }
        }
        Dh(HardCodeUtil.qqStr(R.string.u_g));
        com.tencent.mobileqq.app.handler.a.a(this.C.getMsgHandler(), this.J);
        QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, get openId from server.");
    }

    private void wh() {
        if (NetConnInfoCenter.getServerTime() - T < U && V != null) {
            QLog.d("TroopAbility.PreVerification", 1, "use case receive api_groups:" + V.get_privilege_rsp.api_groups.get() + ", api_names:" + V.get_privilege_rsp.api_names.get());
            HashSet hashSet = new HashSet();
            Iterator<Integer> it = V.get_privilege_rsp.api_groups.get().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            boolean vh5 = vh(hashSet);
            QLog.i("TroopAbility.PreVerification", 1, "use cache check permission result:" + vh5);
            Ah(vh5);
            return;
        }
        QLog.i("TroopAbility.PreVerification", 1, "getThirdAppPermissions.");
        oidb_0xb60$ReqBody oidb_0xb60_reqbody = new oidb_0xb60$ReqBody();
        oidb_0xb60_reqbody.get_privilege_req.setHasFlag(true);
        oidb_0xb60_reqbody.get_privilege_req.appid.set(Integer.valueOf(this.J).intValue());
        oidb_0xb60_reqbody.get_privilege_req.app_type.set(this.P);
        oidb_0xb60$ClientInfo oidb_0xb60_clientinfo = new oidb_0xb60$ClientInfo();
        oidb_0xb60_clientinfo.android_package_name.set(this.K);
        oidb_0xb60_clientinfo.android_signature.set(this.L);
        oidb_0xb60_clientinfo.sdk_version.set(this.M);
        oidb_0xb60_clientinfo.platform.set(1);
        QLog.i("TroopAbility.PreVerification", 1, "send type=" + this.P + ", appid=" + this.J);
        ProtoUtils.c(this.C, new c(), oidb_0xb60_reqbody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
    }

    private boolean xh() {
        Bundle bundleExtra = this.D.getIntent().getBundleExtra("key_params");
        this.G = bundleExtra;
        if (bundleExtra == null) {
            QLog.i("TroopAbility.PreVerification", 1, "doOnCreate params is null.");
            return false;
        }
        this.J = bundleExtra.getString("appid");
        this.I = this.G.getString("openid");
        this.H = this.G.getString("app_name");
        this.N = this.G.getString("organization_id");
        this.K = this.G.getString("pkg_name");
        this.L = this.G.getString("pkg_sig");
        this.M = this.G.getString("sdk_version");
        if (!TextUtils.isEmpty(this.J) && !TextUtils.isEmpty(this.I)) {
            try {
                Integer.valueOf(this.J);
                Integer.valueOf(this.N);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        QLog.d("TroopAbility.PreVerification", 1, "appId: " + this.J + ", openId: " + this.I + ", return.");
        return false;
    }

    protected abstract void Ah(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh() {
        this.C.removeObserver(this.S);
    }

    protected void Dh(String str) {
        if (this.E == null) {
            this.E = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
        }
        U7();
        this.E.setMessage(str);
        if (getBaseActivity().isResume()) {
            this.E.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U7() {
        QQProgressDialog qQProgressDialog = this.E;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && getBaseActivity().isResume()) {
            this.E.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.requestWindowFeature(1);
        activity.getWindow().addFlags(1024);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = getBaseActivity().app;
        this.D = getBaseActivity();
        th();
        if (!xh()) {
            showFailToast(HardCodeUtil.qqStr(R.string.u_c));
        } else {
            uh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bh();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        baseActivity.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showFailToast(String str) {
        QQToast.makeText(getBaseActivity(), 1, str, 0).show(getBaseActivity().getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void th() {
        this.C.addObserver(this.S);
    }

    protected abstract boolean vh(Set<Integer> set);

    protected void yh(String str) {
        U7();
        showFailToast(str);
        this.F.postDelayed(new Runnable() { // from class: com.tencent.open.agent.TroopAbilityPreVerificationFragment.3
            @Override // java.lang.Runnable
            public void run() {
                TroopAbilityPreVerificationFragment.this.getBaseActivity().setResult(0);
                TroopAbilityPreVerificationFragment.this.getBaseActivity().finish();
            }
        }, 2000L);
    }

    protected void zh() {
        Dh(HardCodeUtil.qqStr(R.string.u_j));
        wh();
    }
}
