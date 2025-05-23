package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Intent;
import android.os.Build;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rfw.common.api.IRFWCommonConfigService;
import com.tencent.mobileqq.winkpublish.api.IZhenYanApi;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.PageParams;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleReportApiImpl implements IQCircleReportApi {
    private static final String TAG = "QCircleReportServiceImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public Map<String, Object> buildElementParams() {
        return new QCircleDTParamBuilder().buildElementParams();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public PageParams buildPageParams(String str) {
        return new QCircleDTParamBuilder().buildPageParams(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String desc() {
        return "desc";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String eExtractVideoCover() {
        return QCirclePublishQualityReporter.E_EXTRACT_VIDEO_COVER;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePickerExitCancel() {
        return QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePickerExitNormal() {
        return QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePickerExpose() {
        return QCirclePublishQualityReporter.E_PICKER_EXPOSE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePublishCancelUpload() {
        return QCirclePublishQualityReporter.E_PUBLISH_CANCEL_UPLOAD;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePublishClickDraft() {
        return QCirclePublishQualityReporter.E_PUBLISH_CLICK_DRAFT;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ePublishRetryPublish() {
        return QCirclePublishQualityReporter.E_PUBLISH_RETRY_PUBLISH;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ext1() {
        return "ext1";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ext2() {
        return "ext2";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ext3() {
        return "ext3";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String ext4() {
        return "ext4";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String getQCircleDaTongBasePageId() {
        return QCircleDaTongConstant.PageId.BASE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String getReportId(String str) {
        return WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE + str;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String keyAutoTemplateToEditPage() {
        return QCirclePublishQualityReporter.KEY_AUTO_TEMPLATE_TO_EDIT_PAGE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String keyExportPic() {
        return QCirclePublishQualityReporter.KEY_EXPORT_PIC;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String keyNextStepToEditPage() {
        return QCirclePublishQualityReporter.KEY_NEXT_STEP_TO_EDIT_PAGE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String keyRetCode() {
        return "ret_code";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String keySwitchToCameraTab() {
        return QCirclePublishQualityReporter.KEY_SWITCH_TO_CAMERA_TAB;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void mapReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        QCircleMapReporter.getInstance().reportEnd(qCirclePublishQualityDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public FeedCloudCommon$Entry newEntry(String str, String str2) {
        return QCircleReportHelper.newEntry(str, str2);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void onEnterBackground() {
        QCircleReportHelper.getInstance().onEnterBackground();
        QCircleFolderFunnelCollect.recordExtra(QCircleFolderFunnelCollect.EXTRA_ENTER_BACKGROUND);
        QCircleListenerProxyManager.getInstance().onQQEnterBackground();
        ((IZhenYanApi) QRoute.api(IZhenYanApi.class)).recordLeftCache();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void onEnterForeground() {
        QCircleReportHelper.getInstance().onEnterForeground();
        QCircleFolderFunnelCollect.recordExtra(QCircleFolderFunnelCollect.EXTRA_ENTER_FOREGROUND);
        QCircleListenerProxyManager.getInstance().onQQEnterForeground();
        ((IRFWCommonConfigService) QRoute.api(IRFWCommonConfigService.class)).onSend(2);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pExportEnd() {
        return QCirclePublishQualityReporter.P_EXPORT_END;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pExportStart() {
        return QCirclePublishQualityReporter.P_EXPORT_START;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pJumpPageTimeCost() {
        return QCirclePublishQualityReporter.P_JUMP_PAGE_TIME_COST;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pMaterialCostEnd() {
        return QCirclePublishQualityReporter.P_MATERIAL_COST_END;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pMaterialCostStart() {
        return QCirclePublishQualityReporter.P_MATERIAL_COST_START;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pMaterialDownloadFinish() {
        return QCirclePublishQualityReporter.P_MATERIAL_DOWNLOAD_FINISH;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String pPublishAllCost() {
        return QCirclePublishQualityReporter.P_PUBLISH_ALL_COST;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void qualityReport(int i3, ArrayList<FeedCloudCommon$Entry> arrayList) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
        arrayList.add(QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount()));
        arrayList.add(QCircleReportHelper.newEntry("qua", QUA.getQUA3()));
        arrayList.add(QCircleReportHelper.newEntry("client_time", format));
        arrayList.add(QCircleReportHelper.newEntry("device_model", QCircleHostStubUtil.getDeviceName()));
        arrayList.add(QCircleReportHelper.newEntry("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(QCircleReportHelper.newEntry("network_type", NetworkState.getNetworkTypeString()));
        arrayList.add(QCircleReportHelper.newEntry("appid", QQLiveReportConstants.VALUE_APPID));
        QCircleQualityReporter.reportQualityEvent(i3, arrayList);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void removeKey(String str) {
        QCircleMapReporter.getInstance().removeKey(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void report5504(QCircleLpReportDc05504DataBuilder qCircleLpReportDc05504DataBuilder) {
        if (qCircleLpReportDc05504DataBuilder == null) {
            QLog.e(TAG, 1, "report5504: dataBuilder is null");
        } else {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder(qCircleLpReportDc05504DataBuilder));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void report5507(com.tencent.mobileqq.qcircle.api.constant.b bVar) {
        if (bVar == null) {
            QLog.e(TAG, 1, "report5507: dataBuilder is null");
        } else {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(bVar));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportCacheDataListToServerWithSession(byte[] bArr) {
        QCircleReporter.getInstance().reportCacheDataListToServerWithSession(bArr);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QCircleAlphaUserReporter.reportCmdSuccessRateEvent(qCircleAlphaUserReportDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportDc010001(QCircleLpReportDc010001DataBuilder qCircleLpReportDc010001DataBuilder) {
        if (qCircleLpReportDc010001DataBuilder == null) {
            QLog.e(TAG, 1, "reportDc010001: dataBuilder is null");
        } else {
            QCircleLpReportDc010001.report(new QCircleLpReportDc010001.DataBuilder(qCircleLpReportDc010001DataBuilder));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportEnd(String str, String str2, List<FeedCloudCommon$Entry> list) {
        QCircleMapReporter.getInstance().reportEnd(str, str2, list);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportFolderFunnelPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QCircleAlphaUserReporter.reportFolderFunnelPeriodEvent(qCircleAlphaUserReportDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QCircleAlphaUserReporter.reportLaunchPeriodEvent(qCircleAlphaUserReportDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportLog(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QCircleAlphaUserReporter.reportLog(qCircleAlphaUserReportDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportPublishQuality(String str, List<FeedCloudCommon$Entry> list) {
        QCirclePublishQualityReporter.report(str, list);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportQualityEvent(String str, List list, boolean z16) {
        QCircleQualityReporter.reportQualityEvent(str, list, z16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String sceneCopyFile() {
        return QCirclePublishQualityReporter.Scene.SCENE_COPY_FILE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String sceneForExportVideoError() {
        return QCirclePublishQualityReporter.Scene.ERROR_EXPORT_VIDEO;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String sceneForKillProcessInEditor() {
        return QCirclePublishQualityReporter.Scene.SCENE_KILL_PROCESS_IN_EDITOR;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void setFlutterLauncherParams(Intent intent) {
        if (QCircleReportHelper.getInstance().isPageStackEmpty()) {
            QCircleReportHelper.getInstance().setLaunchParms((QCircleReportHelper.LaunchParam) intent.getParcelableExtra("report_launch_param"));
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void startKey(String str) {
        QCircleMapReporter.getInstance().startKey(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String tCatchImportantInfo() {
        return QCirclePublishQualityReporter.T_CATCH_IMPORTANT_INFO;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String tVideoInfo() {
        return QCirclePublishQualityReporter.T_VIDEO_INFO;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public String traceId() {
        return "traceid";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        QCirclePublishQualityReporter.report(qCirclePublishQualityDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void reportLog(String str, QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QCircleAlphaUserReporter.reportLog(str, qCircleAlphaUserReportDataBuilder);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleReportApi
    public void uploadQualityReport(int i3, QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        QCirclePublishQualityReporter.report(i3, qCirclePublishQualityDataBuilder);
    }
}
