package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasSharpPFactoryForQzone extends QRouteApi {
    Drawable getSharpPURLDrawable(String str, String str2);
}
