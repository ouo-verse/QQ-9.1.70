package com.tencent.mobileqq.guild.nt.emoticon.api;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQEmojiUtilsApi extends QRouteApi {
    boolean containsEmoji(String str);

    int convertToLocal(int i3);

    int convertToServer(int i3);

    String getEmoString(int i3, int i16);

    @NonNull
    String getEmojiDescription(int i3);

    Drawable getEmojiDrawable(int i3);

    int getLocalIdFromEMCode(String str);
}
