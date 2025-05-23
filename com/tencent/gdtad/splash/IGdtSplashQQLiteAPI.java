package com.tencent.gdtad.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtSplashQQLiteAPI extends QRouteApi {
    boolean isStartFromLauncher(Activity activity);

    boolean startActivityForResult(Context context, int i3, Intent intent, v vVar);

    void updateGdtHotSplashData(Pair<Long, Long> pair);
}
