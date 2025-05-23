package com.tencent.av.utils;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Long f77184a;

    public static synchronized long a() {
        long longValue;
        synchronized (w.class) {
            if (f77184a == null) {
                f77184a = Long.valueOf(System.currentTimeMillis());
            }
            Long valueOf = Long.valueOf(f77184a.longValue() + 1);
            f77184a = valueOf;
            longValue = valueOf.longValue();
        }
        return longValue;
    }

    public static void b(AppInterface appInterface, int i3, long j3, byte[] bArr) {
        if (appInterface == null) {
            QLog.e("MavSSOPushMainHelper", 1, "sendCMD appInterface null");
            return;
        }
        Intent intent = new Intent("tencent.video.q2v.RecvMultiVideoSSOPush");
        intent.putExtra("uin", appInterface.getCurrentAccountUin());
        intent.putExtra("cmd_type", i3);
        intent.putExtra("cmd_seq", j3);
        intent.putExtra("cmd_content", bArr);
        appInterface.getApp().sendBroadcast(intent);
    }
}
