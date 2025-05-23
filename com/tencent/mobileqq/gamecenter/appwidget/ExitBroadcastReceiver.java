package com.tencent.mobileqq.gamecenter.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.util.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExitBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static ExitBroadcastReceiver f211949a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f211950b = false;

    public static void a(Context context) {
        if (f211950b) {
            return;
        }
        f211950b = true;
        if (f211949a == null) {
            f211949a = new ExitBroadcastReceiver();
        }
        try {
            context.getApplicationContext().registerReceiver(f211949a, new IntentFilter("com.tencent.process.exit"));
        } catch (Exception e16) {
            QLog.e("ExitBroadcastReceiver", 1, "registerReceiver error\uff1a", e16);
        }
    }

    public static void b(Context context) {
        f211950b = false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (QLog.isColorLevel()) {
            QLog.i("ExitBroadcastReceiver", 2, "onReceive");
        }
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
        String string = extras.getString("verify");
        if (stringArrayList != null && stringArrayList.size() != 0 && o.e(string, stringArrayList) && o.c(stringArrayList, context)) {
            b(context);
            if (QLog.isColorLevel()) {
                QLog.i("ExitBroadcastReceiver", 2, "kill process");
            }
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.otherProcessExit(false);
            } else {
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }
}
