package com.tencent.mobileqq.qcircle.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleConfigApi extends QRouteApi {
    String getPluginMark();

    String getPluginQUA();

    SharedPreferences getQCircleSp();

    boolean isNeedToShowGalleryNewUserGuideVideo();

    boolean isShowQCircleEnter(boolean z16);

    boolean isShowQQCircleMainTabEntrance();

    boolean isWezoneJoy();

    void tryGetNewUserGuideVideoAsync();
}
