package com.tencent.mobileqq.icgame.api;

import android.content.Context;
import android.os.Bundle;
import au0.c;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import s22.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQLiveUtil extends QRouteApi {
    public static final String LIVE_TRACEID = "live_traceid";

    void clearAutoSwitchFlags();

    IQQLiveEndView getAudienceEndLiveView(Context context, IQQLiveSDK iQQLiveSDK, QQLiveEndPageInfo qQLiveEndPageInfo, c cVar, a aVar);

    void openCommonWebDialog(Context context, String str, Bundle bundle);

    void preloadICGameRoom();
}
