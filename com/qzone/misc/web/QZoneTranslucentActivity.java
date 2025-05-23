package com.qzone.misc.web;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.qzone.common.activities.base.BaseFragment;
import com.tencent.mobileqq.R;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTranslucentActivity extends BaseFragment {
    public static boolean D = false;
    private boolean C = false;

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Intent intent = getIntent();
        if (intent == null) {
            QZLog.w("QZoneTranslucentActivity", "intent is null");
            finish();
            return;
        }
        D = intent.getBooleanExtra("QZoneExtra.Plugin.isloading", false);
        QZoneWebPluginHandler.f(getActivity(), intent);
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneTranslucentActivity", 2, "action:" + intent.getAction() + " cmd:" + intent.getStringExtra("cmd") + " bNeedCallback:" + intent.getBooleanExtra(QZoneHelper.bNEEDCALLBACK, false));
        }
        if (intent.getBooleanExtra(QZoneHelper.bNEEDCALLBACK, false)) {
            return;
        }
        finish();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.C = true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (this.C) {
            finish();
        }
        System.out.println("--------share:hasFocus=" + z16 + ",hasShow=" + this.C);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.f173748jk);
    }
}
