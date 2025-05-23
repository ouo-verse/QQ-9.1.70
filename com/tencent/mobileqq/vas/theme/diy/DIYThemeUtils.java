package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DIYThemeUtils {
    private static final String TAG = "DIYThemeUtils";

    public static Drawable getDIYDrawable(Context context, ResData resData, int i3, int i16, int i17, boolean z16) {
        Drawable drawable;
        String str;
        if (resData != null && context != null) {
            int i18 = resData.loadingType;
            if (1 == i18) {
                drawable = context.getResources().getDrawable(R.drawable.qq_setting_me_bg);
            } else if (2 == i18) {
                drawable = context.getResources().getDrawable(R.drawable.skin_background_theme_version2);
            } else if (3 == i18) {
                drawable = context.getResources().getDrawable(R.drawable.skin_chat_background);
            } else {
                drawable = context.getResources().getDrawable(R.drawable.apj);
            }
            try {
                String str2 = resData.path;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(resData.url);
                if (z16) {
                    str = "";
                } else {
                    str = "?play=false";
                }
                sb5.append(str);
                URL url = new URL(ThemeDIYDownloader.PROTOCAL_THEME_DIY_PIC, str2, sb5.toString());
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                if (i17 == 100) {
                    obtain.mExtraInfo = Integer.valueOf(i17);
                }
                obtain.mUseApngImage = z16;
                obtain.mRequestWidth = i3;
                obtain.mRequestHeight = i16;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                obtain.mUseSharpPImage = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).isFunctionAvaliable(context);
                return URLDrawable.getDrawable(url, obtain);
            } catch (MalformedURLException e16) {
                QLog.e(TAG, 1, "getDIYDrawable err:" + e16.getMessage());
                return drawable;
            }
        }
        QLog.e(TAG, 1, "getDIYDrawable null err:" + resData + ", ctx:" + context + ", pageIndex=" + i17);
        return null;
    }
}
