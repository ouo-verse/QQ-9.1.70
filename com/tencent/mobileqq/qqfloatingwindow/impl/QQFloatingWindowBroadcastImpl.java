package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQFloatingWindowBroadcastImpl implements IQQFloatingWindowBroadcast {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQFloatingWindowBroadcastImpl";

    public QQFloatingWindowBroadcastImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    @Deprecated
    public void sendWindowClosedBroadcast(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowClosedBroadcast");
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_curr_window_status", 104);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    @Deprecated
    public void sendWindowVisibleBroadcast(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowVisibleBroadcast:", Boolean.valueOf(z16));
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_curr_window_status", z16 ? 103 : 102);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    public void sendWindowClosedBroadcast(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowClosedBroadcast");
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_curr_window_status", 104);
        intent.putExtra("param_busitype", i3);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    public void sendWindowVisibleBroadcast(Context context, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowVisibleBroadcast:", Boolean.valueOf(z16), " ,busiType:", Integer.valueOf(i3));
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_curr_window_status", z16 ? 103 : 102);
        intent.putExtra("param_busitype", i3);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    public void sendWindowClosedBroadcast(Context context, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowClosedBroadcast");
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_concern_floating_type", i16);
        intent.putExtra("param_curr_window_status", 104);
        intent.putExtra("param_busitype", i3);
        context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast
    public void sendWindowVisibleBroadcast(Context context, boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendWindowVisibleBroadcast:", Boolean.valueOf(z16), " ,busiType:", Integer.valueOf(i3));
        }
        Intent intent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
        intent.setPackage(context.getPackageName());
        intent.putExtra("param_concern_floating_type", i16);
        intent.putExtra("param_curr_window_status", z16 ? 103 : 102);
        intent.putExtra("param_busitype", i3);
        context.sendBroadcast(intent);
    }
}
