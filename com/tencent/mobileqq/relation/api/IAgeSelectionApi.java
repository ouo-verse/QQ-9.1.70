package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IAgeSelectionApi extends QRouteApi {
    void startAgeSelectionActivity(Activity activity, Intent intent, int i3);
}
