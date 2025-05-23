package cooperation.ilive.manager;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.util.Pair;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ILiveRedManagerApi extends QRouteApi {
    String getDrawerLiveReportStr2(BusinessInfoCheckUpdate.AppInfo appInfo);

    Pair<String, String> getIliveRecomRedInfo();

    long getRedAdId(BusinessInfoCheckUpdate.AppInfo appInfo);

    boolean isRecomRedJumpUrl(String str);

    String parseShopRedBuffer(BusinessInfoCheckUpdate.AppInfo appInfo);
}
