package com.qzone.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qzone.common.event.EventCenter;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QQHeadChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static QQHeadChangeReceiver f44422a = new QQHeadChangeReceiver();
    }

    QQHeadChangeReceiver() {
    }

    public static QQHeadChangeReceiver a() {
        return a.f44422a;
    }

    public void b() {
        try {
            BaseApplication.getContext().registerReceiver(this, new IntentFilter(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_SELF_UPDATE));
        } catch (Throwable th5) {
            QZLog.w("QQHeadChangeReceiver", 2, "", th5);
        }
    }

    public void c() {
        try {
            BaseApplication.getContext().unregisterReceiver(this);
        } catch (Throwable th5) {
            QZLog.w("QQHeadChangeReceiver", 2, "", th5);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("faceType", 0);
            String stringExtra = intent.getStringExtra("uin");
            if (stringExtra != null) {
                ImageManager.invalidateMemCache("avatar://" + stringExtra);
                EventCenter.getInstance().post("QQHead", 1);
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QQHeadChangeReceiver", 2, "onReceive  faceType:" + intExtra + ",uinList:" + String.valueOf(stringExtra));
            }
        }
    }
}
