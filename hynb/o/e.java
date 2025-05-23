package hynb.o;

import android.content.Context;
import android.text.TextUtils;
import com.huya.huyasdk.jce.UserId;
import com.huya.huyasdk.service.api.ILoginService;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import hynb.b.l;
import hynb.p.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f406796a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f406796a)) {
            return f406796a;
        }
        if (context == null) {
            return "";
        }
        f406796a = "";
        try {
            f406796a = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            g.f406799a.a("HuyaUtils", "getVersionName: ", e16);
        }
        return f406796a;
    }

    public static UserId a(long j3) {
        UserId userId = new UserId();
        String g16 = l.i().g();
        if (g16 == null) {
            userId.sGuid = "";
        } else {
            userId.sGuid = g16;
        }
        userId.sHuYaUA = l.i().n();
        userId.lUid = j3;
        userId.sDeviceInfo = hynb.m.a.c();
        userId.iTokenType = 2;
        userId.sToken = ((ILoginService) hynb.j.d.a(ILoginService.class)).getToken();
        return userId;
    }
}
