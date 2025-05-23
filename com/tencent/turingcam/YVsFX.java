package com.tencent.turingcam;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YVsFX {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382107a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382108b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f382109c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12088);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382107a = LwgsO.a(LwgsO.A0);
        f382108b = LwgsO.a(LwgsO.B0);
        f382109c = false;
    }

    public static void a(Context context, XStYH xStYH) {
        try {
            if (f382109c) {
                return;
            }
            f382109c = true;
            long a16 = xStYH.a(context, "502");
            int myUid = Process.myUid();
            if (a16 == 0 || myUid == 0 || myUid == a16) {
                return;
            }
            xStYH.a(context, "101", "", true);
            xStYH.b(context, 0L);
            HashMap hashMap = new HashMap();
            hashMap.put("901", "");
            XStYH.a(context, hashMap);
            new File(a(context)).delete();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static String a(Context context) {
        File dir = context.getDir(f382107a, 0);
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
        return file.getAbsolutePath() + str + f382108b;
    }
}
