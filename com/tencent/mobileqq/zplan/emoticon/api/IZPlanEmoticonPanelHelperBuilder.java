package com.tencent.mobileqq.zplan.emoticon.api;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEmoticonPanelHelperBuilder extends QRouteApi {
    AbsEmoticonPanelLifecycleObserver build(int i3, int i16, String str);
}
