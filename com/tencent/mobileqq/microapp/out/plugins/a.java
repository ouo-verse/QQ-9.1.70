package com.tencent.mobileqq.microapp.out.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class a extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OtherJsPlugin f246026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(OtherJsPlugin otherJsPlugin) {
        this.f246026a = otherJsPlugin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) otherJsPlugin);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i3;
        BroadcastReceiver broadcastReceiver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String stringExtra = intent.getStringExtra(OtherJsPlugin.MICRO_APP_SCAN_DATA_RESULT);
        int intExtra = intent.getIntExtra(OtherJsPlugin.MICRO_APP_SCAN_RESULT_TYPE, 0);
        if (QLog.isColorLevel()) {
            QLog.d(OtherJsPlugin.TAG, 2, "scan_result: " + stringExtra + "----scan_type: " + intExtra);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", stringExtra);
            jSONObject.put("scanType", intExtra);
            OtherJsPlugin otherJsPlugin = this.f246026a;
            String jSONObject2 = jSONObject.toString();
            i3 = this.f246026a.mSeq;
            otherJsPlugin.handleNativeResponse("scanCode", jSONObject2, i3);
            broadcastReceiver = this.f246026a.scanResultReceiver;
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
        this.f246026a.scanResultReceiver = null;
    }
}
