package com.tencent.mobileqq.panel.bubble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.panel.FontBubbleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FontBubbleEventReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public FontBubbleEventReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(JSONObject jSONObject) {
        QLog.d("AIOFontBubble_FontBubbleEventReceiver", 1, "handleCancelPay data = " + jSONObject.toString());
    }

    private void b(JSONObject jSONObject) {
        QLog.d("AIOFontBubble_FontBubbleEventReceiver", 1, "handlePayComplete data = " + jSONObject.toString());
        if (jSONObject.optInt("ret") != 0) {
            return;
        }
        c();
    }

    private void c() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.panel.bubble.FontBubbleEventReceiver.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubbleEventReceiver.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
                    FontBubbleManager.j((QQAppInterface) peekAppRuntime).n(null);
                }
            }
        }, 1000L);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        BaseApplicationImpl.getApplication().registerReceiver(this, intentFilter, "com.tencent.msg.permission.pushnotify", null);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            BaseApplicationImpl.getApplication().unregisterReceiver(this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #0 {all -> 0x00a6, blocks: (B:19:0x0058, B:32:0x009a, B:34:0x009e, B:36:0x00a2, B:38:0x0071, B:41:0x007c, B:44:0x0087), top: B:18:0x0058 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (!intent.getBooleanExtra("broadcast", true)) {
            return;
        }
        String stringExtra = intent.getStringExtra("event");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("data");
        if (QLog.isColorLevel()) {
            QLog.d("AIOFontBubble_FontBubbleEventReceiver", 2, "checkDispatchEvent event:" + stringExtra + " dataStr:" + stringExtra2);
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra2);
            int hashCode = stringExtra.hashCode();
            if (hashCode != -829587912) {
                if (hashCode != 805993596) {
                    if (hashCode == 1093579329 && stringExtra.equals("openBeautyPaySuccess")) {
                        c16 = 1;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                if (c16 == 2) {
                                    c();
                                    return;
                                }
                                return;
                            }
                            b(jSONObject);
                            return;
                        }
                        a(jSONObject);
                        return;
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                } else {
                    if (stringExtra.equals("openBeautyPayCancel")) {
                        c16 = 0;
                        if (c16 == 0) {
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                }
            } else {
                if (stringExtra.equals("vipPaySuccess")) {
                    c16 = 2;
                    if (c16 == 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
            }
        } catch (Throwable th5) {
            QLog.e("AIOFontBubble_FontBubbleEventReceiver", 1, th5, new Object[0]);
        }
    }
}
