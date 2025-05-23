package com.tencent.mobileqq.vas.font;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISysEmoApi extends QRouteApi {
    Drawable getEmoDrawable(int i3, int i16);

    Drawable getEmoDrawableFromEMCode(String str);

    String getEmoString(int i3, int i16);

    Drawable getEmojiDrawable(int i3);

    Drawable getSysFaceDrawable(int i3, boolean z16);

    boolean isSysFaceStatic(int i3);

    boolean isSysFaceValid(int i3);
}
