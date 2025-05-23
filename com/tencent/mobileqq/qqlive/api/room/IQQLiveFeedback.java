package com.tencent.mobileqq.qqlive.api.room;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveFeedback extends QRouteApi {
    String getUrl(IQQLiveSDK iQQLiveSDK);

    void openFeedbackActivity(Activity activity, IQQLiveSDK iQQLiveSDK);

    void openFeedbackActivity(Context context, String str);
}
