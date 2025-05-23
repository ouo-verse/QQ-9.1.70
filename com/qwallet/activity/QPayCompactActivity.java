package com.qwallet.activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.qwallet.pay.b;
import com.qwallet.pay.s;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;

/* loaded from: classes3.dex */
public class QPayCompactActivity extends QWalletBaseFragment implements b.a {
    protected QWalletPayProgressDialog C = null;
    boolean D = false;
    protected boolean E = false;
    protected long F;

    public static void ph(Context context, int i3) {
        Intent intent = new Intent();
        intent.putExtra("logic_tag", i3);
        if (context instanceof Service) {
            intent.setFlags(268435456);
        }
        com.tencent.mobileqq.base.c.d(context, intent, QPayCompactActivity.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.E && !isFinishing()) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            long j3 = this.F;
            if (serverTimeMillis > j3 && serverTimeMillis - j3 > 5000) {
                VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "PayBridge", "click.qwallet", "invokeId=" + s.f(getIntent()) + "&which=qpay", 0, null);
                com.qwallet.pay.b g16 = s.e().g(getIntent().getExtras().getInt("logic_tag"));
                if (g16 instanceof com.qwallet.pay.a) {
                    ((com.qwallet.pay.a) g16).f(-94);
                }
                finish();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isFullTransparent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        com.qwallet.pay.b g16 = s.e().g(getIntent().getExtras().getInt("logic_tag"));
        if (g16 != null) {
            g16.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.QPayCompactActivity", 2, "onCreate@" + hashCode());
        }
        boolean z16 = false;
        if (bundle != null && bundle.getBoolean("has_execute_logic", false)) {
            z16 = true;
        }
        this.D = z16;
        if (z16) {
            finish();
            return;
        }
        s.e().d(getActivity(), getIntent().getExtras().getInt("logic_tag"), this);
        this.D = true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s.e().h(getIntent().getExtras().getInt("logic_tag"));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.QPayCompactActivity", 2, "onPause@" + hashCode());
        }
        this.E = false;
        super.onPause();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.QPayCompactActivity", 2, "onResume@" + hashCode());
        }
        this.E = true;
        this.F = NetConnInfoCenter.getServerTimeMillis();
        super.onResume();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("has_execute_logic", this.D);
    }

    @Override // com.qwallet.pay.b.a
    public void x2(Context context) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.QPayCompactActivity", 2, "onFinishPay");
        }
        finish();
    }
}
