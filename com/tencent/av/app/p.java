package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73192a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f73193b = false;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f73194c = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || com.tencent.av.r.h0() == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GVipFunCallMonitor", 2, "recv vipfuncall msg broadcast: " + intent.getAction());
            }
            if (intent.getAction().equals("tencent.video.q2v.AnnimateDownloadFinish")) {
                if (QLog.isColorLevel()) {
                    QLog.d("GVipFunCallMonitor", 2, "ACTION_ANNIMATE_DOWNLOAD_FINISH");
                }
                VideoAppInterface.N().k0(new Object[]{39, Integer.valueOf(intent.getIntExtra(VipFunCallConstants.FUN_CALL_ID, 0))});
            }
        }
    }

    public p(VideoAppInterface videoAppInterface) {
        this.f73192a = videoAppInterface;
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
        intentFilter.addAction("tencent.video.q2v.AnnimateDownloadFinish");
        if (this.f73192a.getApplication().registerReceiver(this.f73194c, intentFilter) != null) {
            this.f73193b = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GVipFunCallMonitor", 2, "regist vipFunCall " + this.f73193b);
        }
    }

    public void b() {
        if (this.f73193b) {
            this.f73192a.getApplication().unregisterReceiver(this.f73194c);
            this.f73193b = false;
        }
    }
}
