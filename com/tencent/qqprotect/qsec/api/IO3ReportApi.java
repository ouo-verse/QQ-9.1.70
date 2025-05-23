package com.tencent.qqprotect.qsec.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IO3ReportApi extends QRouteApi {
    void report(String str, String str2, String str3);

    void reportAIOExposure(String str, String str2);

    void reportAction(String str, String str2, String str3, ArrayList<String> arrayList);

    void reportAddFriendClick(int i3);

    void reportAddFriendExposure(int i3);

    void reportAddGroupClick(int i3);

    void reportAddGroupExposure(int i3);

    void reportLoginClick(String str, int i3, int i16);

    void reportLoginExposure(int i3, int i16);

    void reportSendMessageAction(String str);
}
