package com.tencent.mobileqq.troop.api;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopNickEdit extends QRouteApi {
    void onDetachedFromWindow(Drawable drawable);

    void setCustomCloth(TextView textView, Context context, int i3, boolean z16);

    void updateDrawablePadding(Drawable drawable, PointF pointF);
}
