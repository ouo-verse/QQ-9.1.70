package com.tencent.mobileqq.tianshu.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRedTouchTempApi extends QRouteApi {
    URLDrawable getApngDrawable(Context context, String str);

    Bitmap getDefaultFaceBitmap();

    Drawable getFaceDrawable(Context context, String str);

    void onProcessAddRedPoint(View view);

    void removeLebaIconAnim(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3);

    void startLebaIconAnim(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, boolean z16, long j3, long j16, String str);
}
