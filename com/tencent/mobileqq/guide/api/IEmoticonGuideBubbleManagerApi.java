package com.tencent.mobileqq.guide.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonGuideBubbleManagerApi extends QRouteApi {
    View createEmoticonGuideBubble(Context context);

    View generateGuideBubble(View view, ViewGroup viewGroup, ViewGroup viewGroup2, View view2, Map<String, Object> map);

    boolean isGradientBubbleAvailable();

    void removeGuideBubble(View view, ViewGroup viewGroup);
}
