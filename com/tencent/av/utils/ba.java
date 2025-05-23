package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ba extends AVCoreUtil {

    /* renamed from: d, reason: collision with root package name */
    public static final a f77070d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f77071e = true;

    /* renamed from: f, reason: collision with root package name */
    public static int f77072f = -1;

    /* renamed from: h, reason: collision with root package name */
    public static int f77073h = -1;

    public static boolean a(MotionEvent motionEvent, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (rawX < iArr[0] || rawX > r3 + view.getWidth()) {
            return false;
        }
        if (rawY < iArr[1] || rawY > r0 + view.getHeight()) {
            return false;
        }
        return true;
    }

    public static int avRalationType2DAVRelationType(int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).avRalationType2DAVRelationType(i3);
    }

    public static int avRelationType2UinType(int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).avRelationType2UinType(i3);
    }

    public static boolean canShowAudioShareTips() {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).canShowAudioShareTips();
    }

    public static void clearAudioShareTipsFlag() {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).clearAudioShareTipsFlag();
    }

    public static void clearPressSpeakerGuiderFlag(boolean z16) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).clearPressSpeakerGuiderFlag(z16);
    }

    public static void clearSpeakerStatus(Context context) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).clearSpeakerStatus(context);
    }

    public static void disableShowTips(int i3) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).disableShowTips(i3);
    }

    public static float dp2px(Context context, float f16) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(context, f16);
    }

    public static Bitmap drawBitmapCoverLayer(Bitmap bitmap, String str, boolean z16) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).drawBitmapCoverLayer(bitmap, str, z16);
    }

    public static boolean equals(String str, String str2) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).equals(str, str2);
    }

    public static String formatTime(long j3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).formatTime(j3);
    }

    public static Bitmap getBitmapFromResourceId(Context context, int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getBitmapFromResourceId(context, i3);
    }

    public static float getMeasureTextWidth(TextView textView) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getMeasureTextWidth(textView);
    }

    public static String getNameMaxMaseaured(Context context, String str, TextView textView, float f16) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getNameMaxMaseaured(context, str, textView, f16);
    }

    public static Drawable getOvalDrawable(float f16, Context context) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getOvalDrawable(f16, context);
    }

    public static String getPhoneNumberByUinInMainThread(BaseQQAppInterface baseQQAppInterface, String str) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getPhoneNumberByUinInMainThread(baseQQAppInterface, str);
    }

    public static boolean getPressSpeakerGuiderFlag(boolean z16) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getPressSpeakerGuiderFlag(z16);
    }

    public static int getQQVersion() {
        return AVCoreUtil.strVersionToInt(AppSetting.f99551k);
    }

    public static float getScreenDensity(Context context) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenDensity(context);
    }

    public static int getScreenHeight(Context context) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenHeight(context);
    }

    public static int getScreenWidth(Context context) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getScreenWidth(context);
    }

    public static String getTimeDesc(String str) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).getTimeDesc(str);
    }

    public static boolean gotoSetting(Activity activity) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).gotoSetting(activity);
    }

    public static boolean hasSmartBar() {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).hasSmartBar();
    }

    public static boolean isEnableShowTips(int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).isEnableShowTips(i3);
    }

    public static void openPermissionActivity(Activity activity) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).openPermissionActivity(activity);
    }

    public static float px2dp(Context context, float f16) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).px2dp(context, f16);
    }

    public static void setAccText(View view, String str) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).setAccText(view, str);
    }

    @TargetApi(11)
    public static void setViewAlpha(View view, float f16) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).setViewAlpha(view, f16);
    }

    public static int uinType2AVRelationType(int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).uinType2AVRelationType(i3);
    }

    public static int uinType2MultiAVType(int i3) {
        return ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).uinType2MultiAVType(i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private View.OnClickListener f77074d;

        public a() {
            this.f77074d = null;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    ba.setViewAlpha(view, 1.0f);
                    if (this.f77074d != null && ba.a(motionEvent, view)) {
                        this.f77074d.onClick(view);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            ba.setViewAlpha(view, 0.5f);
            return false;
        }

        public a(View.OnClickListener onClickListener) {
            this.f77074d = onClickListener;
        }
    }

    public static void setAccText(View view, String str, int i3) {
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).setAccText(view, str, i3);
    }
}
