package com.tencent.mobileqq.qcircle.api;

import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleRFWApi extends QRouteApi {
    void checkExceptionWhetherCauseByQCircle(String str);

    void clearQCircleCache();

    String getDefaultSavePath(String str);

    String getUniKeyFromUrl(String str);

    void notifyAccountChange();

    void notifyClearQCircleCache();

    void setNumberTypeface(TextView textView, boolean z16);
}
