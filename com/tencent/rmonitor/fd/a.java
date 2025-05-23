package com.tencent.rmonitor.fd;

import android.text.TextUtils;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.DebugInterfaceProxy;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.e;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static File f365567a;

    public static boolean a() {
        if (DebugInterfaceProxy.a()) {
            return true;
        }
        return d().D;
    }

    public static File b() {
        String j3 = FileUtil.j();
        if (f365567a == null && !TextUtils.isEmpty(j3)) {
            f365567a = new File(j3, BuglyMonitorName.FD_ANALYZE);
        }
        return f365567a;
    }

    public static com.tencent.rmonitor.base.config.d c() {
        return ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.FD_ANALYZE);
    }

    public static e d() {
        return (e) c().com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
    }

    public static int e() {
        if (DebugInterfaceProxy.a()) {
            return 400;
        }
        return d().threshold;
    }

    public static boolean f() {
        if (DebugInterfaceProxy.a()) {
            return true;
        }
        if (AndroidVersion.isOverO() && (d().f365312m & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        if ((d().C & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        if (DebugInterfaceProxy.a()) {
            return true;
        }
        if (AndroidVersion.isOverR() && d().E) {
            return true;
        }
        return false;
    }
}
