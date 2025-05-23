package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleSkinHelperApi extends QRouteApi {
    int getColor(int i3);

    int getColor(String str);

    Drawable getDrawable(int i3);

    Drawable getDrawable(String str);

    Drawable getDrawable(String str, Option option);

    String getUrl(String str);

    void init(Context context);

    void loadResource();
}
