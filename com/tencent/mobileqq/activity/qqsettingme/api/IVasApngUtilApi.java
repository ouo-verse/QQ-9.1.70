package com.tencent.mobileqq.activity.qqsettingme.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface IVasApngUtilApi extends QRouteApi {
    String getAnimatePathByTag(int i3);

    URLDrawable getApngDrawable(AppRuntime appRuntime, String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle);

    URLDrawable getApngURLDrawable(String str, Drawable drawable, Bundle bundle, URLDrawable.URLDrawableListener uRLDrawableListener);

    boolean isNowThemeIsAnimate();

    boolean isSoundEffectsEnable(AppRuntime appRuntime, Context context);

    boolean updateIsDefaultTheme();
}
