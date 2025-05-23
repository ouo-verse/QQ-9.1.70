package com.qwallet.temp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qwallet.plugin.ipc.TickReq;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQWalletApiProxy extends QRouteApi {
    boolean getAppForground(Context context);

    Drawable getDrawableForWallet(String str, Drawable drawable, Bundle bundle);

    boolean launchPlugin(Context context, Bundle bundle);

    void onSetBaseActivityUnlockSuceess();

    void setAppForground(Context context, boolean z16);

    void setLastExitWalletTime(long j3, TickReq tickReq);
}
