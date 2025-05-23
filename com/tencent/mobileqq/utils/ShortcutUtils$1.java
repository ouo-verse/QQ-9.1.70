package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
class ShortcutUtils$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f307325d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f307326e;

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        String str;
        int i16;
        Context context = this.f307325d;
        boolean k3 = ec.k(context, new String[]{context.getString(R.string.f170384pb)});
        if (QLog.isColorLevel()) {
            str = ec.f307692a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createShortcut ");
            sb5.append(k3);
            sb5.append(", ");
            i16 = ec.f307693b;
            sb5.append(i16);
            QLog.d(str, 2, sb5.toString());
        }
        if (k3) {
            i3 = ec.f307693b;
            ec.f307693b = i3 + 1;
            if (i3 < 3) {
                ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(this.f307325d, this.f307326e);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.addFlags(2097152);
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", this.f307325d.getResources().getString(R.string.f170384pb));
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.f307325d.getApplicationContext(), R.drawable.icon));
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        this.f307325d.sendOrderedBroadcast(intent2, null);
    }
}
