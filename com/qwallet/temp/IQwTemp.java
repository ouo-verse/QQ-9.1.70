package com.qwallet.temp;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import d4.e;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQwTemp extends QRouteApi {
    int AIOUtils$getLifeConst(String str);

    String ContactUtils$getBuddyName(AppRuntime appRuntime, String str, boolean z16);

    String ContactUtils$getDateNickName(AppInterface appInterface, String str);

    List<WebViewPlugin> getQWalletJsPlugins();

    boolean isUinSilencedInTroop(String str);

    void mediaPlayer_doStop(boolean z16, AppRuntime appRuntime);

    void mixSong(byte[] bArr, String str, String str2, RecordParams.RecorderParam recorderParam, String str3);

    e newIChatActivityFacadeTemp();

    long uploadPtt(p pVar, String str, int i3, int i16);
}
