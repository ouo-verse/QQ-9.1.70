package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qwallet.activity.patternlock.PatternLockActivity;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: k, reason: collision with root package name */
    protected int f41644k;

    /* renamed from: l, reason: collision with root package name */
    protected OpenTenpayResultReceiver f41645l;

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<String> f41646m;

    public e(Context context, Intent intent) {
        super(context, intent);
        this.f41644k = 0;
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f41646m = sparseArray;
        sparseArray.put(4, "modifyPsw");
        sparseArray.put(5, "findPsw");
        sparseArray.put(6, "touchPayManage");
        sparseArray.put(7, "transferqrcode");
        sparseArray.put(10, "payCode");
        sparseArray.put(11, "payByFriendConfirm");
        sparseArray.put(12, "goldmsg_open");
    }

    private void o(Bundle bundle) {
        Bundle bundle2 = this.f41632d.getBundle("extra_pay_data");
        if (bundle2 != null) {
            String string = bundle2.getString("tokenid");
            String string2 = bundle2.getString("data");
            if (string != null && string2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pfa_req", "pfa?tokenid=" + string + ContainerUtils.FIELD_DELIMITER + "data" + ContainerUtils.KEY_VALUE_DELIMITER + string2);
                    jSONObject.put("token_id", string);
                    bundle.putString("extra_data", jSONObject.toString());
                } catch (Exception e16) {
                    QLog.w("Q.qwallet.BasePayPluginLogic", 2, "payByFriendConfirm:", e16);
                }
            }
        }
    }

    private void p(String str, Bundle bundle) {
        t.a().c(-1, null, false);
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                if (str.equals("2")) {
                    bundle.putString(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#20000001|bargainor_id#1000026901|channel#plus@0002");
                } else if (str.equals("1")) {
                    bundle.putString(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#20000001|bargainor_id#1000026901|channel#qrcode@0003");
                }
                jSONObject.put("entry", str);
                jSONObject.put(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, true);
                bundle.putString("extra_data", jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
            }
        }
    }

    private void q(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", com.tencent.mobileqq.base.a.b());
            jSONObject.put("entry", str);
        } catch (JSONException e16) {
            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
        }
        bundle.putString("extra_data", jSONObject.toString());
        com.tencent.mobileqq.qwallet.c.e("shouqianTCclick", "", "", "", "");
    }

    private boolean r(int i3) {
        if (i3 == -1) {
            e(null);
            return false;
        }
        if (this.f41644k == 0 && t(i3)) {
            v();
            return false;
        }
        return true;
    }

    private void s(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", com.tencent.mobileqq.base.b.b());
        bundle.putByteArray("guid", com.tencent.mobileqq.base.b.c());
        this.f41645l = new OpenTenpayResultReceiver(new Handler(), this, str);
        if (str.equals("transferqrcode")) {
            q(str2, bundle);
        } else if (str.equals("payCode")) {
            p(str2, bundle);
        } else if (str.equals("payByFriendConfirm")) {
            o(bundle);
        }
        TenpayInterface.gotoView(this.f41629a, str, com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), bundle, this.f41645l);
    }

    private boolean t(int i3) {
        if (i3 != 1 || !this.f41630b.getBooleanExtra(IQWalletHelper.QWALLET_HOMEPAGE_IS_NEED_OPEN_PATTERN_LOCK, false)) {
            return false;
        }
        if (!BaseGesturePWDUtil.getAppForground(this.f41629a)) {
            return PatternLockUtils.isPatternLockOpened(this.f41629a, QWalletUtils.h());
        }
        return PatternLockUtils.isNeedOpenPatternLock(this.f41629a, QWalletUtils.h());
    }

    private void u(int i3, String str) {
        new Intent();
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 8) {
                    if (i3 == 15) {
                        com.tencent.mobileqq.qwallet.setting.f.f279176a.a(this.f41629a, 1);
                        return;
                    }
                    return;
                } else {
                    Intent intent = new Intent(this.f41629a, (Class<?>) JumpActivity.class);
                    intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + str));
                    this.f41629a.startActivity(intent);
                    return;
                }
            }
            com.tencent.mobileqq.qwallet.setting.f.f279176a.a(this.f41629a, 2);
            return;
        }
        QWalletUtils.j(this.f41629a);
    }

    private void v() {
        this.f41644k = 1;
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.BasePayPluginLogic", 2, "Open PatternLock");
        }
        Intent intent = new Intent();
        intent.putExtra("action_mode", 1);
        intent.putExtra("is_for_entrance", true);
        intent.putExtra("is_from_background", false);
        intent.putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, true);
        try {
            com.tencent.mobileqq.base.c.g(this.f41629a, intent, PatternLockActivity.class, 2);
        } catch (Throwable th5) {
            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", th5);
        }
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public boolean b() {
        return true;
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        int i3;
        String str;
        super.g(context);
        try {
            i3 = Integer.parseInt(this.f41632d.getString("viewParam"));
        } catch (NumberFormatException e16) {
            QLog.w("Q.qwallet.BasePayPluginLogic", 2, "parseInt viewParam fail", e16);
            i3 = -1;
        }
        if (!r(i3)) {
            return;
        }
        String str2 = this.f41646m.get(i3);
        if (this.f41632d.containsKey("entry")) {
            str = this.f41632d.getString("entry");
        } else {
            str = null;
        }
        if (str2 != null) {
            s(str2, str);
        } else {
            u(i3, str);
        }
        e(null);
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 2) {
            if (i16 != -1) {
                this.f41644k = 3;
                e(null);
            } else {
                this.f41644k = 2;
                a(this.f41629a);
                PatternLockUtils.setNewCreatePatternLock(this.f41629a, QWalletUtils.h(), false);
            }
        }
    }
}
