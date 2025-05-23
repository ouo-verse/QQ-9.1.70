package cooperation.qzone.report.lp;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_DC01796 implements LpReportInfo {
    private static String TAG = "LpReport.LpReportInfo_DC01796";
    private ReportHandler.DownloadReportObject reportObj;

    public LpReportInfo_DC01796(ReportHandler.DownloadReportObject downloadReportObject) {
        this.reportObj = downloadReportObject;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "DC01796";
    }

    public String getStringDate() {
        Date date = new Date();
        ReportHandler.DownloadReportObject downloadReportObject = this.reportObj;
        if (downloadReportObject != null) {
            date.setTime(downloadReportObject.endTime);
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.reportObj != null) {
            hashMap.put("Uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
            hashMap.put("tabletype", String.valueOf(12));
            LpReportUtils.safePut(hashMap, "LogTime", getStringDate());
            hashMap.put("Event", "download");
            hashMap.put("RetCode", String.valueOf(this.reportObj.retCode));
            hashMap.put("TimeCost", String.valueOf(this.reportObj.elapse));
            hashMap.put("network", String.valueOf(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getNetworkType()));
            LpReportUtils.safePut(hashMap, "url", URLEncoder.encode(this.reportObj.url));
            hashMap.put("size", String.valueOf(this.reportObj.fileSize));
            hashMap.put("terminal", "Android-QzoneInQQ");
            LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
            LpReportUtils.safePut(hashMap, "client_ip", this.reportObj.clientip);
            hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, String.valueOf(this.reportObj.retry));
            hashMap.put("flow", String.valueOf(this.reportObj.flow));
            LpReportUtils.safePut(hashMap, "content_type", this.reportObj.content_type);
            hashMap.put("TotalTime", String.valueOf(this.reportObj.totaltime));
            int config = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_LINK_REPORT_SAMPLE, 2);
            if (this.reportObj.retCode == 0) {
                i3 = 100 / config;
            } else {
                i3 = 1;
            }
            hashMap.put("freq", String.valueOf(i3));
            LpReportUtils.safePut(hashMap, TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.reportObj.serverIp);
            String str = "";
            if (!TextUtils.isEmpty(this.reportObj.strategyInfo)) {
                str = "" + this.reportObj.strategyInfo + "|";
            }
            Throwable th5 = this.reportObj.f99898t;
            if (th5 != null) {
                String stackTraceString = Log.getStackTraceString(th5);
                if (!TextUtils.isEmpty(stackTraceString)) {
                    stackTraceString = stackTraceString.replaceAll("\n\t", "--");
                }
                str = str + stackTraceString + "|";
            }
            LpReportUtils.safePut(hashMap, QFSEdgeItem.KEY_EXTEND, str);
            LpReportUtils.safePut(hashMap, "client_log", URLEncoder.encode(this.reportObj.logInfo));
        }
        return hashMap;
    }
}
