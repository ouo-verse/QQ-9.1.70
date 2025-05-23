package com.tencent.gdtad.inject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.params.GetUserInfoCallback;
import tencent.gdt.qq_ad_get;

/* loaded from: classes6.dex */
public interface IGdtThirdProcessor {
    void addReadInJoyCb(Intent intent, String str);

    void c2sReportAsync(int i3, int i16, qq_ad_get.QQAdGetRsp.AdInfo adInfo);

    @Deprecated
    void doCallbackBeforeFinish(GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, long j16, boolean z16);

    @Nullable
    Drawable gdtADBoxItemDrawable(Context context, String str);

    void gdtGetCurrentUserInfo(GetUserInfoCallback getUserInfoCallback);

    Drawable gdtMvIcon(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, int i16);

    Drawable getPreViewImage(Context context, String str);

    String getProductId(Context context);
}
