package com.tencent.mobileqq.search.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.al;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQSearchApi extends QRouteApi {
    boolean enableDefaultSingleMode();

    CharSequence getHighLightApproximateMatchedMessageForMainTitle(AppInterface appInterface, String str, String str2, al alVar);

    CharSequence getHighLightMatchedMessage(String str, String str2);

    CharSequence getHighLightMatchedMessageForMainTitle(AppInterface appInterface, String str, String str2);

    String getKDSearchKeyword(String str);

    CharSequence getMessageWithParenthese(CharSequence charSequence);

    boolean isKDSearchUrl(String str);

    boolean isOptSearch();

    void jump2NetSearchPage(Context context, String str);

    void jump2SearchFromGuild(Context context);

    void openMinGameSearchPage(Context context, String str);

    boolean useNativeNetSearchPage();
}
