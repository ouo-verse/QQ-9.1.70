package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@ServletImpl(impl = ZootopiaDownloadRemoteManagerImpl.class)
/* loaded from: classes35.dex */
public interface n {
    void cancelMapDownload(String str);

    void deleteOldTaskDataWhenClearCache(List<String> list);

    void downloadResByPath(ZPlanResDownloadReq zPlanResDownloadReq, e eVar);

    void getDressDownloadInfo(b bVar);

    void handleDownloadedFileBroken(int i3, String str, String str2);

    boolean needCheckNet();

    void pauseFileDownload(int i3, String str, ah ahVar);

    void pauseMapDownload(String str, ah ahVar);

    void queryDownloadData(int i3, m mVar);

    void queryDownloadResInfo(int i3, p pVar);

    void queryDownloadResInfo(ArrayList<Integer> arrayList, o oVar);

    void queryFileDownloadInfo(int i3, String str, b bVar);

    void setLuaDownloadMaxLimit(String str, int i3);

    void setNeedCheckNet(boolean z16);

    void startDownload(ZootopiaDownloadParams zootopiaDownloadParams, boolean z16);

    void startFileDownload(int i3, String str, String str2, String str3, String str4);

    void startMapDownload(String str, ah ahVar);

    void updateDownloadDataFilePath(int i3, String str, String str2);
}
