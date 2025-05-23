package com.tencent.guild.api.emoji;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface ISouGouEmoProxyApi extends QRouteApi {
    String getOpenId(Context context, String str);

    void pullMultipleEmojiKey(Activity activity, String str, String str2, List<String> list);

    void sendIMEEXpression(Activity activity, String str, String str2, String str3, String str4);

    void sendNewExp(Context context, a aVar, Uri uri, String str);

    void trySend(Activity activity, String str, String str2, int i3, String str3);
}
