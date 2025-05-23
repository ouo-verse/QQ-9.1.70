package com.tencent.mobileqq.vas.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IVasH5PayUtil extends QRouteApi {
    void openH5Page(String str, String str2, Context context);

    void openH5PayByURL(Context context, String str);
}
