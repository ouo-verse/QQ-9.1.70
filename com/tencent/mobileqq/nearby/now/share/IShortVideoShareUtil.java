package com.tencent.mobileqq.nearby.now.share;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppActivity;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IShortVideoShareUtil extends QRouteApi {
    public static final int NOW_SHORT_VIDEO_REQUEST_CODE = 123;
    public static final int NOW_SHORT_VIDEO_REQUEST_CODE_FOR_SHARE_QZONE = 124;

    Bitmap drawableToBitmap(Drawable drawable);

    Bitmap makeShareBitmap(String str);

    void showShareActionSheet(AppInterface appInterface, AppActivity appActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, URLDrawable uRLDrawable, DialogInterface.OnDismissListener onDismissListener);
}
