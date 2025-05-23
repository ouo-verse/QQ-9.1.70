package com.tencent.mobileqq.nearby.now.utils;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IStoryRelayoutUtil extends QRouteApi {
    boolean dynamicChangeStoryContainerView(Object obj, float f16, float f17);

    boolean dynamicLayoutStoryImageContainerView(Object obj, float f16, float f17, Object obj2, Object obj3);

    boolean isSameHeight(View view, Rect rect);

    boolean reLayoutPreBkg(Object obj, int i3, int i16);

    boolean updateLayoutForTxtFeeds(Object obj);
}
