package com.tencent.offline.utils;

import android.text.TextUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.storage.StorageCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f339499a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f339500b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f339501c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23289);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f339499a = new Object();
        f339500b = new HashSet<>();
        f339501c = new String[]{"0", "1"};
    }

    public static String a(String str) {
        if (l(str)) {
            return g();
        }
        return b();
    }

    public static String b() {
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            LogUtil.e("Offline_FileUtils", "get backup dir data root dir is null", new Object[0]);
            return null;
        }
        return d16 + "backup/";
    }

    public static String c() {
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            return null;
        }
        return d16 + "html5/";
    }

    public static String d() {
        try {
            return ul3.b.d().getApplicationContext().getFilesDir().toString() + File.separator + "qbiz/";
        } catch (Exception e16) {
            LogUtil.printStackTrace(e16);
            return null;
        }
    }

    public static String e() {
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            LogUtil.e("Offline_FileUtils", "get temp dir data root dir is null", new Object[0]);
            return null;
        }
        return d16 + "tmp/";
    }

    public static String f(String str) {
        if (l(str)) {
            return h();
        }
        return c();
    }

    public static String g() {
        String i3 = i();
        if (TextUtils.isEmpty(i3)) {
            LogUtil.e("Offline_FileUtils", "get backup dir sd root dir is null", new Object[0]);
            return null;
        }
        return i3 + "backup/";
    }

    public static String h() {
        String i3 = i();
        if (TextUtils.isEmpty(i3)) {
            return null;
        }
        return i3 + "html5/";
    }

    public static String i() {
        try {
            return (ul3.b.d().getApplicationContext().getFilesDir().getPath() + File.separator) + "tencent/now/offline/";
        } catch (Exception e16) {
            LogUtil.printStackTrace(e16);
            return null;
        }
    }

    public static String j() {
        String i3 = i();
        if (TextUtils.isEmpty(i3)) {
            return null;
        }
        return i3 + "tmp/";
    }

    public static String k(String str) {
        if (l(str)) {
            return j();
        }
        return e();
    }

    public static boolean l(String str) {
        int i3 = StorageCenter.getInt("Offline_FileUtils", -1);
        if (i3 == -1) {
            if (a.a(ul3.b.d().getApplicationContext().getFilesDir().toString()) >= 209715200) {
                StorageCenter.putInt("Offline_FileUtils", 0);
            } else {
                StorageCenter.putInt("Offline_FileUtils", 1);
                return true;
            }
        } else if (i3 != 0) {
            return true;
        }
        return false;
    }
}
