package com.tencent.mobileqq.qqgift.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGiftUtil extends QRouteApi {
    boolean checkIsQQGiftUrl(String str, String str2, Intent intent);

    Intent getOpenQQGiftUrlIntent(Activity activity, String str, String str2, Intent intent, Bundle bundle);

    boolean isQQGiftCountDowning(d dVar, String str);
}
