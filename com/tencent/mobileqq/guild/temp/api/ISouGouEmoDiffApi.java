package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ISouGouEmoDiffApi extends QRouteApi {
    String getOpenId(Context context, String str, String str2);

    void pullMultipleEmojiKey(Activity activity, BaseQQAppInterface baseQQAppInterface, String str, String str2, List<String> list);

    void sendIMEEXpression(BaseQQAppInterface baseQQAppInterface, Activity activity, String str, String str2, String str3, String str4);

    void sendNewExp(Context context, com.tencent.aio.api.runtime.a aVar, Uri uri, String str);

    void trySend(Activity activity, BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, String str3);
}
