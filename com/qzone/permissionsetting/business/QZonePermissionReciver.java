package com.qzone.permissionsetting.business;

import a8.a;
import a8.b;
import android.content.Context;
import android.content.Intent;
import com.qzone.common.account.LoginData;
import com.qzone.common.broadcast.QzoneBaseBroadcastReceiver;
import mqq.app.MobileQQ;

/* loaded from: classes39.dex */
public class QZonePermissionReciver extends QzoneBaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private b f49128a;

    private boolean a(long j3) {
        return j3 != LoginData.getInstance().getUin();
    }

    private void b(String str, boolean z16) {
        try {
            long longValue = Long.valueOf(str).longValue();
            if (a(longValue)) {
                if (this.f49128a == null) {
                    this.f49128a = b.O();
                }
                a aVar = new a(longValue, str);
                if (z16) {
                    this.f49128a.E(LoginData.getInstance().getUin(), aVar, null);
                } else {
                    this.f49128a.b0(LoginData.getInstance().getUin(), aVar, null);
                }
            }
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.qzone.common.broadcast.QzoneBaseBroadcastReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("com.tencent.qzone.action.OperateQZonePermission")) {
            return;
        }
        MobileQQ.getMobileQQ().waitAppRuntime(null);
        b(intent.getStringExtra("qzone_permission_uin"), Boolean.valueOf(intent.getBooleanExtra("qzone_permission_value", true)).booleanValue());
    }
}
