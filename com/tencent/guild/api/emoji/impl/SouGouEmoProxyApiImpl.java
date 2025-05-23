package com.tencent.guild.api.emoji.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.aio.api.runtime.a;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.emoji.ISouGouEmoProxyApi;
import com.tencent.mobileqq.guild.temp.api.ISouGouEmoDiffApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class SouGouEmoProxyApiImpl implements ISouGouEmoProxyApi {
    private BaseQQAppInterface getAppRuntime() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.guild.api.emoji.ISouGouEmoProxyApi
    public String getOpenId(Context context, String str) {
        return ((ISouGouEmoDiffApi) QRoute.api(ISouGouEmoDiffApi.class)).getOpenId(context, getAppRuntime().getCurrentAccountUin(), str);
    }

    @Override // com.tencent.guild.api.emoji.ISouGouEmoProxyApi
    public void pullMultipleEmojiKey(Activity activity, String str, String str2, List<String> list) {
        ((ISouGouEmoDiffApi) QRoute.api(ISouGouEmoDiffApi.class)).pullMultipleEmojiKey(activity, getAppRuntime(), str, str2, list);
    }

    @Override // com.tencent.guild.api.emoji.ISouGouEmoProxyApi
    public void sendIMEEXpression(Activity activity, String str, String str2, String str3, String str4) {
        ((ISouGouEmoDiffApi) QRoute.api(ISouGouEmoDiffApi.class)).sendIMEEXpression(getAppRuntime(), activity, str, str2, str3, str4);
    }

    @Override // com.tencent.guild.api.emoji.ISouGouEmoProxyApi
    public void sendNewExp(Context context, a aVar, Uri uri, String str) {
        ((ISouGouEmoDiffApi) QRoute.api(ISouGouEmoDiffApi.class)).sendNewExp(context, aVar, uri, str);
    }

    @Override // com.tencent.guild.api.emoji.ISouGouEmoProxyApi
    public void trySend(Activity activity, String str, String str2, int i3, String str3) {
        ((ISouGouEmoDiffApi) QRoute.api(ISouGouEmoDiffApi.class)).trySend(activity, getAppRuntime(), str, str2, i3, str3);
    }
}
