package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import nl0.d;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameDLService extends IRuntimeService {
    void deleteDownload(int i3, String str);

    void doAppSystemReceiver(String str, String str2);

    void doDownloadAction(int i3, WadlParams wadlParams);

    void doInstallAction(int i3, String str);

    void doPauseAction(int i3, String str);

    void doQueryAllTask(int i3);

    void doResumeAction(int i3, String str);

    void onQueryCallback(ArrayList<WadlResult> arrayList);

    void onWadlTaskStatusChanged(WadlResult wadlResult);

    void receiveVMAction(Intent intent);

    void registerDownloadCallBack(d dVar);

    void setSpeedBuffer(int i3, int i16);

    void unRegisterDownloadCallBack(d dVar);
}
