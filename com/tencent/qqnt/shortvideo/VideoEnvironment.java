package com.tencent.qqnt.shortvideo;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoEnvironment {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f362201a = new int[16];

    /* renamed from: b, reason: collision with root package name */
    public static String f362202b = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");

    /* renamed from: c, reason: collision with root package name */
    private static final Object f362203c = new Object();

    static {
        File file = new File(com.tencent.qqnt.shortvideo.compress.c.b(c()));
        if (!file.exists()) {
            file.mkdirs();
            a("VideoEnvironment:[static]loadPathFile not exist");
        }
    }

    public static void a(String str) {
        b(com.tencent.mobileqq.shortvideo.VideoEnvironment.TAG, str, null);
    }

    public static void b(String str, String str2, Throwable th5) {
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (!bVar.isGrayVersion() && bVar.isPublicVersion()) {
            if (QLog.isColorLevel()) {
                QLog.i(str, 2, str2, th5);
                return;
            }
            return;
        }
        QLog.i(str, 1, str2, th5);
    }

    public static Context c() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public static String d() {
        return null;
    }

    public static synchronized int e() {
        int f16;
        synchronized (VideoEnvironment.class) {
            int a16 = com.tencent.qqnt.shortvideo.compress.c.a();
            if (a16 == 0) {
                a("loadAVCodecSo[already loaded], status=" + a16);
                return a16;
            }
            synchronized (f362203c) {
                f16 = f();
                a("loadAVCodecSo[loaded End], load code=" + f16);
            }
            return f16;
        }
    }

    private static int f() {
        return -11;
    }

    private static native void getAVCodecLibMetadata(int[] iArr);
}
