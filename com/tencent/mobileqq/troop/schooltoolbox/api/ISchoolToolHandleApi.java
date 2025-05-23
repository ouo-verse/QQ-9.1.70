package com.tencent.mobileqq.troop.schooltoolbox.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ISchoolToolHandleApi extends QRouteApi {
    void handlerAppAction(Context context, Activity activity, String str, long j3, String str2, int i3, int i16, boolean z16);
}
