package com.tencent.mobileqq.vas.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasCommonAdapter extends QRouteApi {
    String addParamToUrl(String str, String str2);

    void clearMagicFontCache(AppRuntime appRuntime);

    Bitmap decodeFileWithBufferedStream(String str, BitmapFactory.Options options);

    yc2.a getBaseChatPieAdapter(Context context);

    int getChatTextSize(AppRuntime appRuntime);

    String getKeyIsKandianEmoticon();

    String getKeyIsShowAD();

    String getKeyIsSmallEmoticon();

    QQProgressDialog getProgressDialog(Context context);

    Class<?> getQQBrowserActivityClass();

    void getRichTextChatConfig(AppInterface appInterface);

    String getUserDataString();

    boolean hasSysEmotion(String str);

    String insertMtype(String str, String str2);

    Intent insertWbPlugin(Intent intent, String str);

    boolean isFragmentStyleOrEmoStore(Intent intent);

    boolean isLaterVersionByUrlConfig(String str, String str2);

    String isShowAdKey();

    void parseURLJson(AppRuntime appRuntime);

    String processEmoStoreHomeUrl(String str);

    Bundle putSrcType(Bundle bundle);

    Intent putWebViewTitleStyle(Intent intent, String str);

    void reportClickEventTo644(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String[] strArr);

    void reportClickEventTo644V2(AppInterface appInterface, String str, String str2, String str3, String str4, int i3, int i16, String[] strArr);

    void reportRedPacket(AppRuntime appRuntime);

    void resolveFunnyPicJson(AppRuntime appRuntime);

    Intent setBrowserTitleStyle(Intent intent, String str);

    void setColorNickEnabke(boolean z16);

    void setSignatureEnable(boolean z16);

    void startWebSoRequest(String str);

    void updateMsgFieldByUniseq(String str, int i3, long j3, String str2, String str3);
}
