package au;

import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.audioprocess.api.IAudioProcessHelperApi;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static IAudioProcessApi a(IAVEngineCommon iAVEngineCommon, f fVar) {
        return ((IAudioProcessHelperApi) QRoute.api(IAudioProcessHelperApi.class)).createInstance(iAVEngineCommon, fVar);
    }

    public static void b() {
        ((IAudioProcessHelperApi) QRoute.api(IAudioProcessHelperApi.class)).destroyInstance();
    }

    public static IAudioProcessApi c() {
        return ((IAudioProcessHelperApi) QRoute.api(IAudioProcessHelperApi.class)).getInstance();
    }

    public static boolean d() {
        return ((IAudioProcessHelperApi) QRoute.api(IAudioProcessHelperApi.class)).hasInstance();
    }
}
