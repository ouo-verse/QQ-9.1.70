package com.tencent.gdtad.basics.motivevideo.report;

import android.text.TextUtils;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.params.GdtSsoReportMiniParam;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    public void a(int i3, long j3, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).reportMiniAdEvent(new GdtSsoReportMiniParam.Builder().setActionType(i3).setActionTime(j3).setAId(str).setAppId(str2).build());
        }
    }
}
