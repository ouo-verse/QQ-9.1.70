package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQBaseService extends QRouteApi {
    void attachConditionSearchManager();

    int checkSupportMediaCodecFeature();

    String decodeRemoteCode(long j3);

    void detachConditionSearchManager();

    int encodeLocCode(String str);

    IEmoticonMainPanelApp getEmotionImpl();

    Intent getQQBrowserDelegationActivityIntent(Context context, String str);

    Intent getQQSplashIntent(Context context);

    Intent handleQCircleHybirdActivityIntent(Context context, String str, Intent intent, int i3);

    Intent handleTVideoAdHybirdActivityIntent(Context context, String str, Intent intent);

    boolean isNoActivityInForegroundExceptJumpActivity();

    void openLocationSelectActivity(Context context, Bundle bundle);

    void openSplashActivity(Context context, HashMap<String, String> hashMap);

    void setNewSsoAndRestartApp(String str);

    void setQCircleToBottomTab(HashMap<String, Boolean> hashMap);

    Intent startUnlockActivityIntent(Context context);
}
