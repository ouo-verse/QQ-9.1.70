package com.tencent.mobileqq.guild.vas;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.guild.r;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildGiftManager extends QRouteApi {
    void hideGiftPanel();

    void initGiftPanel(a aVar, ActivityResultCallback<ActivityResult> activityResultCallback);

    void onFreeGiftCountDownEnd();

    void onFreeGiftCountDownStart();

    void playGiftAnim();

    void preLoadGiftData(String str);

    void setGiftPanelAction(r rVar);

    void setReceiverInfo(String str, String str2, Drawable drawable);

    void showGiftPanel(Activity activity);

    void stopGiftAnim();
}
