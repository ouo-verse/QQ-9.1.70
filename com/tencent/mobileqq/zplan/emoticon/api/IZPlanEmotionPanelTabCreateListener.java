package com.tencent.mobileqq.zplan.emoticon.api;

import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlinx.coroutines.CoroutineScope;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEmotionPanelTabCreateListener extends QRouteApi {
    IEmotionTabCreateListener build(IEmoticonMainPanelApp iEmoticonMainPanelApp, CoroutineScope coroutineScope);
}
