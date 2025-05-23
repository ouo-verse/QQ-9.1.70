package cooperation.qzone.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQzoneZplanApi extends QRouteApi {
    boolean qzoneEnvInit(@NonNull AppRuntime appRuntime);

    void sendChangePicUrlRequest(String str);
}
