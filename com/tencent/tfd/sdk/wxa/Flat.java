package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Flat {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f375614a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f375615b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f375616c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62574);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375614a = Cswitch.a(Cswitch.A0);
        f375615b = Cswitch.a(Cswitch.B0);
        f375616c = false;
    }

    public static String a(Context context) {
        File dir = context.getDir(f375614a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(dir.getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("1");
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + f375615b;
    }

    public static void b(Context context, Chestnut chestnut) {
        long a16 = chestnut.a(context, "502");
        int myUid = Process.myUid();
        if (a16 == 0) {
            chestnut.c(context, 0L);
        } else if (a16 != 0 && myUid != a16) {
            chestnut.c(context, -1L);
        } else {
            chestnut.c(context, 1L);
        }
    }

    public static void c(Context context, Chestnut chestnut) {
        try {
            if (f375616c) {
                return;
            }
            f375616c = true;
            long a16 = chestnut.a(context, "502");
            int myUid = Process.myUid();
            if (a16 != 0 && myUid != 0 && myUid != a16) {
                chestnut.a(context, "101", "", true);
                chestnut.b(context, 0L);
                HashMap hashMap = new HashMap();
                hashMap.put("901", "");
                Chestnut.a(context, hashMap);
                new File(a(context)).delete();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void a(Context context, Chestnut chestnut) {
        long a16 = chestnut.a(context, "502");
        long myUid = Process.myUid();
        if (a16 != myUid) {
            chestnut.a(context, "502", "" + myUid, false);
        }
    }
}
