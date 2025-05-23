package com.tencent.mobileqq.qqvideoedit.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQVideoEditResourcePreloader extends QRouteApi {
    View getPreloadView(int i3);

    void preload(Context context);
}
