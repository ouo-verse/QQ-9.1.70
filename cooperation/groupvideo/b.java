package cooperation.groupvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.groupvideo.api.IGroupVideoWrapper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final IGroupVideoWrapper f390127a = (IGroupVideoWrapper) QRoute.api(IGroupVideoWrapper.class);

    public b(AppInterface appInterface) {
        f390127a.init(appInterface);
    }

    public void a(IGroupVideoWrapper.a aVar) {
        f390127a.initialize(aVar);
    }
}
