package com.tencent.mobileqq.qcircle.api;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.PageParams;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleReportApi extends QRouteApi {
    Map<String, Object> buildElementParams();

    PageParams buildPageParams(String str);

    String desc();

    String eExtractVideoCover();

    String ePickerExitCancel();

    String ePickerExitNormal();

    String ePickerExpose();

    String ePublishCancelUpload();

    String ePublishClickDraft();

    String ePublishRetryPublish();

    String ext1();

    String ext2();

    String ext3();

    String ext4();

    String getQCircleDaTongBasePageId();

    String getReportId(String str);

    String keyAutoTemplateToEditPage();

    String keyExportPic();

    String keyNextStepToEditPage();

    String keyRetCode();

    String keySwitchToCameraTab();

    void mapReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);

    FeedCloudCommon$Entry newEntry(String str, String str2);

    void onEnterBackground();

    void onEnterForeground();

    String pExportEnd();

    String pExportStart();

    String pJumpPageTimeCost();

    String pMaterialCostEnd();

    String pMaterialCostStart();

    String pMaterialDownloadFinish();

    String pPublishAllCost();

    void qualityReport(int i3, ArrayList<FeedCloudCommon$Entry> arrayList);

    void removeKey(String str);

    void report5504(QCircleLpReportDc05504DataBuilder qCircleLpReportDc05504DataBuilder);

    void report5507(b bVar);

    void reportCacheDataListToServerWithSession(byte[] bArr);

    void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder);

    void reportDc010001(QCircleLpReportDc010001DataBuilder qCircleLpReportDc010001DataBuilder);

    void reportEnd(String str, String str2, List<FeedCloudCommon$Entry> list);

    void reportFolderFunnelPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder);

    void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder);

    void reportLog(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder);

    void reportLog(String str, QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder);

    void reportPublishQuality(String str, List<FeedCloudCommon$Entry> list);

    void reportQualityEvent(String str, List list, boolean z16);

    String sceneCopyFile();

    String sceneForExportVideoError();

    String sceneForKillProcessInEditor();

    void setFlutterLauncherParams(Intent intent);

    void startKey(String str);

    String tCatchImportantInfo();

    String tVideoInfo();

    String traceId();

    void uploadQualityReport(int i3, QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);

    void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);
}
