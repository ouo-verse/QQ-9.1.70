package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterAuthApi extends QRouteApi {
    b getGameAuthHelper(Context context, String str, com.tencent.mobileqq.gamecenter.data.k kVar);

    b getGameAuthHelper(Context context, String str, com.tencent.mobileqq.gamecenter.data.k kVar, int i3);

    String getRangeString(Context context, int i3);

    String getYuanMengRangeString(Context context, int i3);

    void jump2AuthFragmentWhenLogin(Activity activity, Intent intent, Class<? extends QPublicFragmentActivity> cls, int i3);
}
