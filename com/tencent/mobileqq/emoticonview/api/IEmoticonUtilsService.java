package com.tencent.mobileqq.emoticonview.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonUtilsService extends QRouteApi {
    void bindStickersRecommendBar(View view, String str);

    void setNeedSwitchToHotPicTab();
}
