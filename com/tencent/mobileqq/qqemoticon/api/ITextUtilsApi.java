package com.tencent.mobileqq.qqemoticon.api;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ITextUtilsApi extends QRouteApi {
    String emoticonToTextForTalkBack(String str);

    Drawable getResourceDrawableThroughImageCache(Resources resources, int i3);
}
