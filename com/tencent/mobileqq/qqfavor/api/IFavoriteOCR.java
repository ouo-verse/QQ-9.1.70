package com.tencent.mobileqq.qqfavor.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IFavoriteOCR extends QRouteApi {
    void favorite(Activity activity, String str);
}
