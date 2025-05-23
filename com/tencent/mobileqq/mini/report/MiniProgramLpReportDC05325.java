package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.RangeDownloadReport;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC05325 {
    public static final int RESOURCE_TYPE_APKG_MAIN = 1;
    public static final int RESOURCE_TYPE_APKG_SUB = 2;
    public static final int RESOURCE_TYPE_BASELIB = 4;
    public static final int RESOURCE_TYPE_IMAGE_MAIN = 3;
    public static final int RESOURCE_TYPE_OTHER = 10;
    public static final int RESOURCE_TYPE_PLUGIN = 5;
    private static ImageDownloadReporter downloadReporter;
    private static Map<Long, Boolean> reportedList = new HashMap();

    public static String getHeader(DownloadResult downloadResult, String str) {
        Header[] allHeaders;
        HttpResponse httpResponse = downloadResult.getReport().response;
        Response response = downloadResult.getReport().okResponse;
        int i3 = 0;
        if (response != null) {
            Headers headers = response.headers();
            if (headers != null) {
                int size = headers.size();
                while (i3 < size) {
                    if (str.equalsIgnoreCase(headers.name(i3))) {
                        return headers.value(i3);
                    }
                    i3++;
                }
                return "";
            }
            return "";
        }
        if (httpResponse != null && (allHeaders = httpResponse.getAllHeaders()) != null) {
            int length = allHeaders.length;
            while (i3 < length) {
                if (str.equalsIgnoreCase(allHeaders[i3].getName())) {
                    return allHeaders[i3].getValue();
                }
                i3++;
            }
            return "";
        }
        return "";
    }

    public static String getNetworkType() {
        String netWorkTypeByStr = HttpUtil.getNetWorkTypeByStr();
        if (netWorkTypeByStr == null) {
            return "unknown";
        }
        return netWorkTypeByStr.toLowerCase();
    }

    public static String getProtocol(DownloadResult downloadResult) {
        if (downloadResult.getReport() == null) {
            return "";
        }
        if (downloadResult.getReport().isHttp2) {
            return "http2.0";
        }
        if (downloadResult.getReport().isHttps) {
            return "https";
        }
        return "http1.1";
    }

    public static int getRetCode(DownloadResult downloadResult) {
        if (downloadResult.getReport() == null) {
            return -9999;
        }
        if (downloadReporter == null) {
            downloadReporter = new ImageDownloadReporter();
        }
        ReportHandler.DownloadReportObject obtainReportObj = downloadReporter.obtainReportObj(downloadResult, downloadResult.getReport());
        if (obtainReportObj != null) {
            return obtainReportObj.retCode;
        }
        return -9999;
    }

    public static void reportApiReport(DownloadResult downloadResult) {
        reportApiReport(downloadResult, 10, null);
    }

    public static void reportApiReport(DownloadResult downloadResult, int i3) {
        reportApiReport(downloadResult, i3, null);
    }

    public static void reportApiReport(final DownloadResult downloadResult, final int i3, final MiniAppConfig miniAppConfig) {
        if (downloadResult == null || 10 == i3) {
            return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325.1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13 = "range_id";
                String str14 = "content_length";
                try {
                    if (MiniProgramLpReportDC05325.reportedList.containsKey(Long.valueOf(DownloadResult.this.getProcess().startTimestamp))) {
                        QLog.w("MiniProgramLpReportDC05325", 1, "It has been reported! url=" + DownloadResult.this.getUrl());
                        return;
                    }
                    MiniProgramLpReportDC05325.reportedList.put(Long.valueOf(DownloadResult.this.getProcess().startTimestamp), Boolean.TRUE);
                    String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppConfig);
                    COMM.Entry[] entryArr = new COMM.Entry[35];
                    entryArr[0] = MiniProgramReportHelper.newEntry("uid", String.valueOf(com.tencent.open.adapter.a.f().l()));
                    entryArr[1] = MiniProgramReportHelper.newEntry("launchid", launchIdForMiniAppConfig);
                    entryArr[2] = MiniProgramReportHelper.newEntry("timestamp", "" + DownloadResult.this.getProcess().startTimestamp);
                    entryArr[3] = MiniProgramReportHelper.newEntry("qua", QUA.getQUA3());
                    entryArr[4] = MiniProgramReportHelper.newEntry("deviceinfo", PlatformInfor.g().getDeviceInfor());
                    entryArr[5] = MiniProgramReportHelper.newEntry("network_type", MiniProgramLpReportDC05325.getNetworkType());
                    entryArr[6] = MiniProgramReportHelper.newEntry("userip", DownloadResult.this.getContent().clientip);
                    MiniAppConfig miniAppConfig2 = miniAppConfig;
                    if (miniAppConfig2 == null) {
                        str = "";
                    } else {
                        str = miniAppConfig2.config.appId;
                    }
                    entryArr[7] = MiniProgramReportHelper.newEntry("appid", str);
                    if (miniAppConfig == null) {
                        str2 = "";
                    } else {
                        str2 = "" + miniAppConfig.config.getReportType();
                    }
                    entryArr[8] = MiniProgramReportHelper.newEntry("app_type", str2);
                    entryArr[9] = MiniProgramReportHelper.newEntry("resource_type", "" + i3);
                    entryArr[10] = MiniProgramReportHelper.newEntry("download_url", DownloadResult.this.getUrl());
                    entryArr[11] = MiniProgramReportHelper.newEntry("ret_code", "" + MiniProgramLpReportDC05325.getRetCode(DownloadResult.this));
                    entryArr[12] = MiniProgramReportHelper.newEntry("download_channel", MiniProgramLpReportDC05325.getProtocol(DownloadResult.this));
                    if (DownloadResult.this.getReport() == null) {
                        str3 = "";
                    } else {
                        str3 = DownloadResult.this.getReport().remoteAddress;
                    }
                    entryArr[13] = MiniProgramReportHelper.newEntry("download_ip", str3);
                    if (DownloadResult.this.getReport() == null) {
                        str4 = "";
                    } else {
                        str4 = DownloadResult.this.getReport().content_type;
                    }
                    entryArr[14] = MiniProgramReportHelper.newEntry("download_ip_type", str4);
                    if (DownloadResult.this.getReport() == null) {
                        str5 = "";
                    } else {
                        str5 = "" + DownloadResult.this.getReport().currAttempCount;
                    }
                    entryArr[15] = MiniProgramReportHelper.newEntry("retry_count", str5);
                    if (!TextUtils.isEmpty(DownloadResult.this.getContent().redirectUrl)) {
                        str6 = "1";
                    } else {
                        str6 = "0";
                    }
                    try {
                        entryArr[16] = MiniProgramReportHelper.newEntry("redirect_count", str6);
                        entryArr[17] = MiniProgramReportHelper.newEntry("direct_out_ip_count", "-1");
                        entryArr[18] = MiniProgramReportHelper.newEntry("x_nws_log_uuid", MiniProgramLpReportDC05325.getHeader(DownloadResult.this, HttpMsg.CDN_LOG_UUID));
                        if (DownloadResult.this.getReport() == null) {
                            str7 = "";
                        } else {
                            str7 = DownloadResult.this.getReport().content_type;
                        }
                        entryArr[19] = MiniProgramReportHelper.newEntry("content_type", str7);
                        entryArr[20] = MiniProgramReportHelper.newEntry("content_length", "" + DownloadResult.this.getContent().length);
                        entryArr[21] = MiniProgramReportHelper.newEntry("content_encoding", DownloadResult.this.getContent().encoding);
                        entryArr[22] = MiniProgramReportHelper.newEntry("time_cost", "" + DownloadResult.this.getProcess().duration);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("");
                        String str15 = "1";
                        sb5.append(DownloadResult.this.getProcess().totalDuration);
                        entryArr[23] = MiniProgramReportHelper.newEntry("time_cost_queue", sb5.toString());
                        if (DownloadResult.this.getReport() == null) {
                            str8 = "";
                        } else {
                            str8 = "" + DownloadResult.this.getReport().t_recvrsp;
                        }
                        entryArr[24] = MiniProgramReportHelper.newEntry("time_cost_header", str8);
                        if (DownloadResult.this.getReport() == null) {
                            str9 = "";
                        } else {
                            str9 = "" + DownloadResult.this.getReport().t_recvdata;
                        }
                        entryArr[25] = MiniProgramReportHelper.newEntry("time_cost_data", str9);
                        entryArr[26] = MiniProgramReportHelper.newEntry("download_mode", String.valueOf(DownloadResult.this.getReport().downloadMode));
                        entryArr[27] = MiniProgramReportHelper.newEntry("time_cost_range_receive", String.valueOf(DownloadResult.this.getReport().timeCostForRangeReceivePhase));
                        entryArr[28] = MiniProgramReportHelper.newEntry("time_cost_range_merge", String.valueOf(DownloadResult.this.getReport().timeCostForRangeMergePhase));
                        entryArr[29] = MiniProgramReportHelper.newEntry(AudienceReportConst.PROTOCOL, DownloadResult.this.getReport().f99896protocol);
                        entryArr[30] = MiniProgramReportHelper.newEntry("perf_level", String.valueOf(DeviceInfoUtils.getPerfLevel()));
                        entryArr[31] = MiniProgramReportHelper.newEntry("range_number", String.valueOf(DownloadResult.this.getReport().rangeNumber));
                        entryArr[32] = MiniProgramReportHelper.newEntry("range_type", "0");
                        entryArr[33] = MiniProgramReportHelper.newEntry("download_id", String.valueOf(com.tencent.open.adapter.a.f().l()) + DownloadResult.this.getProcess().startTimestamp);
                        entryArr[34] = MiniProgramReportHelper.newEntry("range_id", "0");
                        ArrayList arrayList = new ArrayList(Arrays.asList(entryArr));
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(arrayList);
                        if (DownloadResult.this.getReport().downloadMode == Downloader.DownloadMode.RangeMode.ordinal() && DownloadResult.this.getReport().rangeDownloadReports != null) {
                            for (RangeDownloadReport rangeDownloadReport : DownloadResult.this.getReport().rangeDownloadReports) {
                                ArrayList arrayList3 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    COMM.Entry mergeFrom = new COMM.Entry().mergeFrom(((COMM.Entry) it.next()).toByteArray());
                                    if (str14.equals(mergeFrom.key.get())) {
                                        str10 = str14;
                                        mergeFrom.value.set(String.valueOf(rangeDownloadReport.getContentLength()));
                                    } else {
                                        str10 = str14;
                                    }
                                    if ("time_cost".equals(mergeFrom.key.get())) {
                                        mergeFrom.value.set(String.valueOf(rangeDownloadReport.getTimeCost()));
                                    }
                                    if ("time_cost_header".equals(mergeFrom.key.get())) {
                                        mergeFrom.value.set(String.valueOf(rangeDownloadReport.getTimeCostHeader()));
                                    }
                                    if ("time_cost_data".equals(mergeFrom.key.get())) {
                                        mergeFrom.value.set(String.valueOf(rangeDownloadReport.getTimeCostData()));
                                    }
                                    if ("range_type".equals(mergeFrom.key.get())) {
                                        str11 = str15;
                                        mergeFrom.value.set(str11);
                                    } else {
                                        str11 = str15;
                                    }
                                    if (str13.equals(mergeFrom.key.get())) {
                                        str12 = str13;
                                        mergeFrom.value.set(String.valueOf(rangeDownloadReport.getRangeId()));
                                    } else {
                                        str12 = str13;
                                    }
                                    arrayList3.add(mergeFrom);
                                    str15 = str11;
                                    str13 = str12;
                                    str14 = str10;
                                }
                                arrayList2.add(arrayList3);
                                str15 = str15;
                                str13 = str13;
                                str14 = str14;
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            arrayList4.add(MiniProgramReportHelper.newSingleReportData(10, (List) it5.next(), null));
                        }
                        MiniProgramReporter.getInstance().batchAddAll(arrayList4);
                    } catch (Throwable th5) {
                        th = th5;
                        i16 = 1;
                        QLog.e("MiniProgramLpReportDC05325", i16, "", th);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i16 = 1;
                }
            }
        });
    }
}
