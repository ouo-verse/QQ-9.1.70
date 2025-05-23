package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRScanAbilityApi extends QRouteApi {
    Bitmap decodeSharpP(String str);

    int getEarlyDownBusId(int i3);

    String getFriendDisplayNameJustCache(AppRuntime appRuntime, String str);

    int getQmcfGpuSupportType();

    int getQmcfGpuSupportTypeWithoutGPURule();

    String getUin(String str);

    boolean isMiniCodeDecodeSwitchOn();

    boolean isMiniCodeDetectSwitchOn();

    boolean isQmcfSupport(int i3);

    boolean isQmcfSupportGLElseCL(int i3);

    boolean isRingEqualsZero(AppRuntime appRuntime);

    boolean isRingerSilent(AppRuntime appRuntime);

    boolean isRingerVibrate(AppRuntime appRuntime);

    boolean isVideoChatting(AppRuntime appRuntime);

    void launchAR(Activity activity, AppRuntime appRuntime, String str, long j3, boolean z16, boolean z17, long j16, boolean z18, boolean z19, JSONObject jSONObject, ScannerParams scannerParams);

    void reportQBarSoLoadFail(boolean z16);

    void setTalkbackSwitch();

    void speak(String str);

    void startActivity(Context context, boolean z16, String str, boolean z17);
}
