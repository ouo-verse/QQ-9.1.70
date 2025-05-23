package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.QZoneVideoCommonUtils;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneVideoCommonUtilsProxy extends QRouteApi {
    QZoneVideoCommonUtils.VideoSupport getTrimHWSupport();

    void gotoRecordPreview(Activity activity, int i3, String str, long j3, Bundle bundle);

    void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str);

    void installVideoActivity(long j3, Activity activity, boolean z16, boolean z17, String str, boolean z18, boolean z19, String str2, boolean z26, String str3, String str4, Intent intent);

    void installVideoActivity(boolean z16, boolean z17, Activity activity, String str, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, String str2, String str3, Intent intent);

    void installVideoActivityForOther(long j3, Activity activity, boolean z16, boolean z17, String str, Bundle bundle);
}
