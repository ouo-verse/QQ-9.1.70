package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f383378a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f383379b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f383380c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f383378a = Ccontinue.a(Ccontinue.A0);
        f383379b = Ccontinue.a(Ccontinue.B0);
        f383380c = false;
    }

    public static void a(Context context, Walnut walnut) {
        try {
            if (f383380c) {
                return;
            }
            f383380c = true;
            long a16 = walnut.a(context, "502");
            int myUid = Process.myUid();
            if (a16 == 0 || myUid == 0 || myUid == a16) {
                return;
            }
            walnut.a(context, "101", "", true);
            walnut.b(context, 0L);
            HashMap hashMap = new HashMap();
            hashMap.put("901", "");
            Walnut.a(context, hashMap);
            new File(a(context)).delete();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static String a(Context context) {
        File dir = context.getDir(f383378a, 0);
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
        return file.getAbsolutePath() + str + f383379b;
    }
}
