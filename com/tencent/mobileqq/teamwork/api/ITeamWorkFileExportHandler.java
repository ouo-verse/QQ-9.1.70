package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkFileExportHandler extends QRouteApi {
    void fileExportDownloadRequest(String str, String str2, String str3, String str4);

    void notifyUI(int i3, boolean z16, Object obj);

    void notifyUI(int i3, boolean z16, Object obj, boolean z17);

    void notifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj);
}
