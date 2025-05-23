package com.tencent.mobileqq.icgame.api.room;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQLiveFeedback extends QRouteApi {
    String getUrl(IQQLiveSDK iQQLiveSDK);

    void openFeedbackActivity(Activity activity, IQQLiveSDK iQQLiveSDK);

    void openFeedbackActivity(Context context, String str);
}
