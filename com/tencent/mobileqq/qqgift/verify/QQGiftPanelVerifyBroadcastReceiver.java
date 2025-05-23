package com.tencent.mobileqq.qqgift.verify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class QQGiftPanelVerifyBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f265038a;

    /* loaded from: classes16.dex */
    public interface a {
        void a(String str, long j3, int i3);
    }

    public QQGiftPanelVerifyBroadcastReceiver(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f265038a = aVar;
        }
    }

    public static final void a(String str, long j3, int i3) {
        try {
            Intent intent = new Intent("action_gift_panel_verify");
            intent.putExtra("intent_key_app_id", str);
            intent.putExtra("intent_key_req_flag", j3);
            intent.putExtra("intent_key_result_code", i3);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.e("GiftPanel_VBR", 1, "send broadcast error, ", th5);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null || !"action_gift_panel_verify".equals(intent.getAction())) {
            return;
        }
        String stringExtra = intent.getStringExtra("intent_key_app_id");
        long longExtra = intent.getLongExtra("intent_key_req_flag", 0L);
        int intExtra = intent.getIntExtra("intent_key_result_code", 0);
        a aVar = this.f265038a;
        if (aVar != null) {
            aVar.a(stringExtra, longExtra, intExtra);
        }
    }
}
