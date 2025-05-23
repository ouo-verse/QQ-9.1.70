package com.tencent.mobileqq.guild.nt.emoticon.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQSysFaceUtilsApi extends QRouteApi {
    boolean containsExpression(String str);

    int convertToLocal(int i3);

    int convertToServer(int i3);

    Bitmap getDefaultFaceBitmap(boolean z16);

    String getEMCode(int i3);

    String getEmojiString(int i3);

    String getFaceDescription(int i3);

    Drawable getFaceDrawable(int i3);

    Drawable getFaceGifDrawable(int i3);

    String getFaceString(int i3);

    int getLocalIdFromEMCode(String str);

    boolean isAllSystemEmoticon(String str);
}
