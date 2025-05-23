package com.tencent.qqinterface;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface QQBaseAbilityInterface {
    void beaconReportData(Bundle bundle, int i3);

    void doCgiReq(Bundle bundle, CommonCallback<Bundle> commonCallback);

    void download(Bundle bundle, DownloadCallback downloadCallback);

    Future<Bundle> getA1(String str, String str2, String str3, String str4);

    Future<Bundle> getAccessToken(String str, String str2);

    String getSelfUin();

    Bundle getTickets();

    void hasPluginLoaded();

    boolean isMobileNet();

    void jumpAction(String str);

    void openWebView(Bundle bundle);

    void printQLog(Bundle bundle);

    void reportData(Bundle bundle);

    String reqDns(String str);

    void sendSSOTask(Bundle bundle, CommonCallback<Bundle> commonCallback);

    void showToast(Context context, CharSequence charSequence, int i3);

    boolean useIpDirectConnect();
}
