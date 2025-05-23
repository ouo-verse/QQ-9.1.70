package com.tencent.qqinterface;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface NowBizInterface {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface Constants {
        public static final String PATH = "path";
        public static final String URL = "url";
    }

    void doActionResult(long j3, String str);

    Bitmap getCoverImg(String str);

    ExecutorService getFixedThreadPool(int i3);

    void getRecordInfo(Bundle bundle, CommonCallback<Bundle> commonCallback);

    boolean isNowLivePushEnable();

    void notifyCoreAction(Bundle bundle);

    void onEnterRoom(Bundle bundle);

    void onFirstFrameShow(Bundle bundle);

    void onLiveOverIsInstalled(boolean z16);

    void onLoginExpired(int i3);

    void onNoLogin();

    void onPluginActivityLifecycleEvent(Bundle bundle);

    void onRoomActivityOnCreate(Bundle bundle);

    void openLiveHall();

    void openNowLivePushSetting(CommonCallback<Bundle> commonCallback);

    void openPayPage(Bundle bundle, CommonCallback commonCallback);

    void openPhoneAuthPage();

    void openWxMiniProgram(String str);

    void queryPhoneAuthState();

    void reportData(Bundle bundle);

    void reportWelfareTask(String str, String str2);

    void setBizIntent(Intent intent);

    void setHostCallback(IHostCallback iHostCallback);

    void share(Bundle bundle);

    void shareToQQ(Bundle bundle);

    void showBiuComponent(Bundle bundle);
}
