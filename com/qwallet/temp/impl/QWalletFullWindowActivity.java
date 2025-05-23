package com.qwallet.temp.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QWalletFullWindowActivity extends QQTranslucentBrowserActivity {
    public static final String ACTION_CLOSE_CAMERA = "action_close_camera";
    public static final String ACTION_ONPAUSE = "action_onpause";
    public static final String ACTION_ONRESUME = "action_onresume";

    public QWalletFullWindowActivity() {
        this.mFragmentClass = QWalletFullWindowFragment.class;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        sendBroadcast(new Intent(ACTION_CLOSE_CAMERA));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        sendBroadcast(new Intent(ACTION_ONPAUSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        sendBroadcast(new Intent(ACTION_ONRESUME));
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        return super.showPreview();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class QWalletFullWindowFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {
        BroadcastReceiver C = new a();

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            if (this.C != null) {
                try {
                    BaseApplication.getContext().unregisterReceiver(this.C);
                } catch (Exception e16) {
                    QLog.e(WebViewFragment.TAG, 1, "onDestroy: ", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
        public void onFinalState(Bundle bundle, t tVar) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(QWalletFullWindowActivity.ACTION_CLOSE_CAMERA);
            intentFilter.addAction("cn.abel.action.broadcast");
            BaseApplication.getContext().registerReceiver(this.C, intentFilter);
            super.onFinalState(bundle, tVar);
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                if (QWalletFullWindowActivity.ACTION_CLOSE_CAMERA.equals(intent.getAction())) {
                    QWalletFullWindowFragment.super.getQBaseActivity().finish();
                } else {
                    if (!"cn.abel.action.broadcast".equals(intent.getAction()) || intent.getBooleanExtra(h.f248218g, false)) {
                        return;
                    }
                    QWalletFullWindowFragment.super.getQBaseActivity().finish();
                }
            }
        }
    }
}
