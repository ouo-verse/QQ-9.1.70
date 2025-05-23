package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;

/* compiled from: P */
/* loaded from: classes22.dex */
public class YybDownloadSdkCallBack {
    private static final String TAG = "YybDownloadSdkCallBack";
    private static YybDownloadSdkCallBack mYybDownloadSdkCallBack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                try {
                    if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF) && d.f()) {
                        com.tencent.open.base.f.a("TAMST_WAKE", "ACTION_SCREEN_OFF:" + action);
                        MyAppApi.m0();
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.c("TAMST_WAKE", "ACTION_SCREEN_OFF:" + e16);
                }
            }
        }
    }

    YybDownloadSdkCallBack() {
        registerBroadcastReceiver();
    }

    public static YybDownloadSdkCallBack getInstance() {
        if (!MyAppApi.O()) {
            return null;
        }
        if (mYybDownloadSdkCallBack == null) {
            synchronized (YybDownloadSdkCallBack.class) {
                if (mYybDownloadSdkCallBack == null) {
                    mYybDownloadSdkCallBack = new YybDownloadSdkCallBack();
                }
            }
        }
        return mYybDownloadSdkCallBack;
    }

    public void registerBroadcastReceiver() {
        com.tencent.open.base.f.a(TAG, "registerBroadcastReceiver: isMainProcess=" + MyAppApi.O());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        com.tencent.open.adapter.a.f().e().registerReceiver(new a(), intentFilter);
    }

    public static void preInit() {
    }
}
