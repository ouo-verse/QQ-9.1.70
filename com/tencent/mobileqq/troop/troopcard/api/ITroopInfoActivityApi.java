package com.tencent.mobileqq.troop.troopcard.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopInfoActivityApi extends QRouteApi {
    Class<?> getParserClass();

    void openTroopProfile(Context context, Bundle bundle);

    void openTroopProfileForResult(Activity activity, Bundle bundle, int i3);
}
