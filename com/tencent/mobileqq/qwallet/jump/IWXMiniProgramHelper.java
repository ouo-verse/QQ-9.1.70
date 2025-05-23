package com.tencent.mobileqq.qwallet.jump;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IWXMiniProgramHelper extends QRouteApi {
    void handleWXEntryActivityIntent(Activity activity, Intent intent);

    boolean isCanJumpToWxMiniProgram();

    void launchMiniProgram(Map<String, String> map, String str);
}
