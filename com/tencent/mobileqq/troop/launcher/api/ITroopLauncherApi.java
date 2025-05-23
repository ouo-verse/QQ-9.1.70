package com.tencent.mobileqq.troop.launcher.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopLauncherApi extends QRouteApi {
    Class getEditInfoActivityClass();

    boolean startActivity(Context context, Intent intent, String str);
}
