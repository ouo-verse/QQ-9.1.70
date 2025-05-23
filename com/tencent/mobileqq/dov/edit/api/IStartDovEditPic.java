package com.tencent.mobileqq.dov.edit.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IStartDovEditPic extends QRouteApi {
    void enterCropActivity(Activity activity, String str);
}
