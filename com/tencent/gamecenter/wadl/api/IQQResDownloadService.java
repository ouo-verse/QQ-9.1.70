package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import nl0.g;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQResDownloadService extends IRuntimeService {
    void deleteResDownload(String str, String str2, String str3);

    void downloadRes(WadlParams wadlParams);

    void onQueryCallback(ArrayList<WadlResult> arrayList);

    void onWadlTaskStatusChanged(WadlResult wadlResult);

    void pauseResDownload(String str);

    void queryAllResTask();

    void registerResCallBack(g gVar);

    void resumeResDownload(String str);

    void unRegisterResCallBack(g gVar);
}
