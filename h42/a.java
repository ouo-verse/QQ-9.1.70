package h42;

import android.content.Context;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f404301a = false;

    public static void a(Context context) {
        if (f404301a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).registerTGLiveQIPCModule();
        wt0.a.d(false);
        f404301a = true;
        QLog.i("ICGameInitStep", 1, "ICGame init done, cost " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
