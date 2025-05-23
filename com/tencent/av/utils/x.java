package com.tencent.av.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<Long> f77185a = new HashSet<>();

    public static synchronized void a(long j3) {
        synchronized (x.class) {
            f77185a.add(Long.valueOf(j3));
        }
    }

    public static boolean b(Bundle bundle) {
        long j3 = bundle.getLong("cmd_seq");
        if (bundle.getByteArray("cmd_content") == null) {
            QLog.e("MavSSOPushVideoHelper", 1, "handleMultiSSOPush buffer empty");
            return false;
        }
        return !c("videoMsgBroadCast", j3);
    }

    public static synchronized boolean c(String str, long j3) {
        boolean z16;
        synchronized (x.class) {
            if (f77185a.contains(Long.valueOf(j3)) && j3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.e("MavSSOPushVideoHelper", 1, "hasSameSeq from:=" + str + ",seq:=" + j3 + ", same:=" + z16);
        }
        return z16;
    }

    public static boolean d(String str) {
        return "tencent.video.q2v.RecvMultiVideoSSOPush".equals(str);
    }
}
