package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterSgameApi extends QRouteApi {
    void createSgameTeam(Activity activity, AIOParam aIOParam);

    void handleUrlForCreatingSgameTeam(String str);
}
