package cooperation.qzone.api;

import android.content.Context;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IQZoneIntimateSpaceApi extends QRouteApi {
    void dispatchDestroyIntimateBubbleEvent();

    BaseRequest getRedDotReaderRequest(long j3, boolean z16, int i3, String str);

    int handleScheme(String str, Context context, String str2);

    int handleSchemeWithSpaceId(String str, String str2, Context context, String str3);

    boolean isPartnerSpaceEntranceSwitchOpen();

    void releaseGuideBubbleResources(Runnable runnable);
}
