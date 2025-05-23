package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameDLReportService extends QRouteApi {
    void onAutoDownloadStart(WadlParams wadlParams);

    void onAutoUpdateStart(WadlParams wadlParams);

    void onDeleteLowVersionTask(WadlParams wadlParams, WadlParams wadlParams2);

    void onDownloadStatusChange(int i3, WadlResult wadlResult);

    void onFilterExpireTask(WadlParams wadlParams);

    void onGetAutoDownloadInfo(QQGameAutoDownloadTask$PreDownloadInfo qQGameAutoDownloadTask$PreDownloadInfo);

    void onGetAutoUpdateInfo(QQGameAutoUpdateTask$PreUpdateInfo qQGameAutoUpdateTask$PreUpdateInfo);

    void onNotificationClick(ArrayList<WadlResult> arrayList);

    void onNotificationShow(WadlResult wadlResult, int i3);

    void onPreAutoDownloadCheck(String str, String str2, String str3, int i3, boolean z16, boolean z17, boolean z18, boolean z19, String str4);

    void onPreAutoUpdateCheck(String str, String str2, String str3, int i3, boolean z16, boolean z17, boolean z18, boolean z19, String str4);

    void onReceivePush(int i3, String str);

    void onRequestInstall(WadlParams wadlParams, boolean z16);

    void onResumeAction(WadlParams wadlParams);

    void onStartDownload(WadlParams wadlParams);
}
