package com.tencent.mobileqq.activity.qqsettingme.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qqsettingme.k;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import i71.a;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface IQQSettingMeApi extends QRouteApi {
    boolean canShowNamePlateInSimpleMode();

    void checkAndGetSelfNickName(AppRuntime appRuntime);

    void closeDrawer();

    void getCover(k kVar, boolean z16);

    void getCover(Card card, k kVar);

    Drawable getDefaultCoverDrawable(Resources resources);

    int getDrawerType();

    URLDrawable getGameCardIcon(View view, long j3, int i3, boolean z16, int i16);

    @Nullable
    View getOnlineStatusEntranceView(Context context);

    Integer getPlateColor(String str);

    long getQQBigMemberId();

    int getStrokeVisible(String str, AppRuntime appRuntime);

    boolean hasCover(AppRuntime appRuntime, Card card);

    View.OnTouchListener headVipReport(AppRuntime appRuntime, String str);

    boolean isBigVipClub(int i3);

    boolean isCanOpenHippy(String str);

    boolean isSettingMeViewBackground();

    boolean isSuperVip(int i3);

    SpannableString parseQQLevel(Resources resources, int i3, int i16, int i17);

    SpannableString parseQQLevel(Resources resources, int i3, int i16, int i17, boolean z16);

    void reportCoverBg(AppRuntime appRuntime, Card card);

    void setAvatarDrawable(View view);

    void setAvatarDrawableV3(View view);

    void setIsToCloseDrawer(int i3);

    void setTextForAnimation(View view, SpannableStringBuilder spannableStringBuilder, TextView.BufferType bufferType);

    void setVipCardDrawable(Resources resources, ImageView imageView, String[] strArr, Drawable drawable);

    void setVipCardDrawable(Resources resources, ImageView imageView, String[] strArr, Drawable drawable, boolean z16);

    void setVipExtIcon(Context context, ImageView imageView, int i3);

    void setVipExtIcon(Context context, ImageView imageView, int i3, boolean z16);

    void updateOnlineStatusViewPadding(View view);

    void updateOnlineTextColor(@ColorRes int i3, View view);

    void updateTextColorGradientWithColor(TextView textView, String str, ColorStateList colorStateList, boolean z16);

    boolean userSetThemeAction(Activity activity, a aVar);
}
