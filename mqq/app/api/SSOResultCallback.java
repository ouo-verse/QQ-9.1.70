package mqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface SSOResultCallback extends QRouteApi {
    void callback(SSOResponse sSOResponse);
}
