package cooperation.vip.common;

import android.app.Activity;
import c15.a;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VipClass extends a {

    /* renamed from: b, reason: collision with root package name */
    private static VipClass f391240b = new VipClass();

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f391241c = 0;

    public static VipClass getInstance() {
        return f391240b;
    }

    @Override // c15.a
    public void c(Activity activity, String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2004, null);
    }
}
