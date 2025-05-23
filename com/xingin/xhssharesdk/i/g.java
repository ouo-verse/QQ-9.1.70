package com.xingin.xhssharesdk.i;

import a05.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class g extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final wz4.c f389998a;

    public g(wz4.c cVar) {
        this.f389998a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && TextUtils.equals(intent.getAction(), "com.xingin.xhs.action.VOLLEY_SHARE_RESULT")) {
            b bVar = new b(intent.getBooleanExtra("success", false), intent.getIntExtra("error_code", 1), intent.getStringExtra("error_message"), intent.getStringExtra(ServiceConst.PARA_SESSION_ID));
            XhsShareSdk.b("XhsShare_XhsShareResultReceiver", "Receive the share result, the result is " + bVar);
            wz4.c cVar = this.f389998a;
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }
}
