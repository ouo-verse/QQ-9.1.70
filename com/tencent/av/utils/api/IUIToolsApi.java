package com.tencent.av.utils.api;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.qphone.base.util.BaseApplication;
import ew.a;
import ew.b;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IUIToolsApi extends QRouteApi {
    void avLog(String str, String str2);

    int avRalationType2DAVRelationType(int i3);

    int avRelationType2UinType(int i3);

    boolean canShowAudioShareTips();

    void cancelSetPermission(Activity activity, AppInterface appInterface);

    Bitmap captureFrameBySelf(int i3, int i16, int i17);

    void clearAudioShareTipsFlag();

    void clearPressSpeakerGuiderFlag(boolean z16);

    void clearSpeakerStatus(Context context);

    void disableShowTips(int i3);

    Bitmap doBlur(Bitmap bitmap, Context context, int i3, boolean z16);

    void doScreenShareReport(String str);

    void doScreenShareReport(String str, int i3);

    float dp2px(Context context, float f16);

    Bitmap drawBitmapCoverLayer(Bitmap bitmap, String str, boolean z16);

    void enableLenovoNotch();

    boolean equals(String str, String str2);

    String formatTime(long j3);

    int getAudioShareBgResId();

    int getAudioShareBtnStartResId();

    int getAudioShareBtnStopResId();

    Bitmap getBitmapFromResourceId(Context context, int i3);

    float getMeasureTextWidth(TextView textView);

    int getMobileQQLastSyncVersion();

    String getNameMaxMaseaured(Context context, String str, TextView textView, float f16);

    Drawable getOvalDrawable(float f16, Context context);

    String getPhoneNumberByUinInMainThread(BaseQQAppInterface baseQQAppInterface, String str);

    boolean getPressSpeakerGuiderFlag(boolean z16);

    SharedPreferences getQavSP(AppInterface appInterface);

    float getScreenBrightness();

    float getScreenDensity(Context context);

    int getScreenHeight(Context context);

    int getScreenShareBgResId();

    int getScreenWidth(Context context);

    String getTimeDesc(String str);

    boolean gotoSetting(Activity activity);

    void handleBitmapToGaussianBg(BaseApplication baseApplication, a aVar, Bitmap bitmap, b bVar);

    boolean hasSmartBar();

    boolean isEnableShowTips(int i3);

    boolean isFeatureSupportRounedScreen(Activity activity);

    boolean isFilterProcessPostRenderUserShader();

    boolean isFilterProcessRenderUseSurface();

    boolean isFirstTimeShowUserGuideForFace(AppInterface appInterface);

    boolean isNeedShowSVIPDialog();

    boolean isSupportSurfaceMode();

    boolean isVIPPayProcessExist(Context context);

    void openPermissionActivity(Activity activity);

    void printStacktrace(String str);

    float px2dp(Context context, float f16);

    void recordHasShowSVIPDialog();

    void setAccText(View view, String str);

    void setAccText(View view, String str, int i3);

    void setFilterProcessRenderMode(boolean z16);

    void setFirstTimeShowUserGuideForFace(AppInterface appInterface);

    void setScreenBrightness(Activity activity, float f16);

    @TargetApi(11)
    void setViewAlpha(View view, float f16);

    void showCustomDialog(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2);

    boolean startRing(AppInterface appInterface, int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener);

    Bitmap takeScreenShot(Activity activity);

    int uinType2AVRelationType(int i3);

    int uinType2MultiAVType(int i3);
}
