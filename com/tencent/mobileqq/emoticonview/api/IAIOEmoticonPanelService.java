package com.tencent.mobileqq.emoticonview.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IAIOEmoticonPanelService extends QRouteApi {
    void destroyViewPool();

    void removeStickerMask(View view);

    void setOpenStartTime(long j3);
}
