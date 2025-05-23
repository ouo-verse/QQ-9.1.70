package cooperation.ilive.host;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ILiveEnterGroupHostApi extends QRouteApi {
    void joinGroup(boolean z16, String str, String str2);
}
