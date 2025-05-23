package com.tencent.component.network.downloader.handler;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.component.network.module.report.ReportObj;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ReportHandler {
    void handleReport(DownloadResult downloadResult, DownloadReport downloadReport);

    DownloadReportObject obtainReportObj(DownloadResult downloadResult, DownloadReport downloadReport);

    void uploadReport(DownloadReportObject downloadReportObject);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DownloadReportObject extends ReportObj {
        private static final String QQ_QUN_FLAG = "store.qq.com/qun/";
        public int appIdType;
        public String clientip;
        public int concurrent;
        public String content_type;
        public String dnsIp;
        public String logInfo;
        public int realFilesize;
        public String refer;
        public int retry;
        public int sample;
        public String strategyInfo;

        /* renamed from: t, reason: collision with root package name */
        public Throwable f99898t;
        public long t_conn;
        public long t_prepare;
        public long t_process;
        public long t_recvdata;
        public long t_recvrsp;
        public long t_wait;
        public long totaltime;
        public int type;
        public String url;

        public DownloadReportObject() {
            this.appIdType = 0;
            this.type = 1;
            this.realFilesize = 0;
            this.sample = 100;
        }

        private void calculateAppIdType() {
            if (!TextUtils.isEmpty(this.url) && this.url.indexOf(QQ_QUN_FLAG) >= 0) {
                this.appIdType = 10;
            }
        }

        @Override // com.tencent.component.network.module.report.ReportObj
        protected String getRefer() {
            if (this.appIdType == 10) {
                return ReportObj.REPORT_REFER_QQ_QUN;
            }
            return super.getRefer();
        }

        public boolean needForceReport() {
            if (this.retry > 0) {
                return true;
            }
            return false;
        }

        public void setUrl(String str) {
            this.url = str;
            calculateAppIdType();
        }

        @Override // com.tencent.component.network.module.report.ReportObj
        public JSONObject toJSON() throws JSONException {
            JSONObject json = super.toJSON();
            json.put("url", this.url);
            json.put("dnsip", this.dnsIp);
            json.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, this.retry);
            json.put("clientip", this.clientip);
            json.put("t_wait", this.t_wait);
            json.put("t_prepare", this.t_prepare);
            json.put("t_conn", this.t_conn);
            json.put("t_recvrsp", this.t_recvrsp);
            json.put("t_recvdata", this.t_recvdata);
            json.put("t_process", this.t_process);
            json.put("content_type", this.content_type);
            json.put("concurrent", this.concurrent);
            String str = this.refer;
            if (str != null) {
                json.put("refer", str);
            }
            if (!TextUtils.isEmpty(this.strategyInfo)) {
                if (this.extend == null) {
                    this.extend = new ExtendData();
                }
                this.extend.put(10, this.strategyInfo);
                json.put(QFSEdgeItem.KEY_EXTEND, this.extend.getExtendString());
            }
            if (this.f99898t != null) {
                if (this.extend == null) {
                    this.extend = new ExtendData();
                }
                String stackTraceString = Log.getStackTraceString(this.f99898t);
                if (!TextUtils.isEmpty(stackTraceString)) {
                    stackTraceString = stackTraceString.replaceAll("\n\t", "--");
                }
                this.extend.put(11, stackTraceString);
                String extendString = this.extend.getExtendString();
                if (!TextUtils.isEmpty(extendString)) {
                    extendString = extendString.replaceAll(",", ";");
                }
                json.put(QFSEdgeItem.KEY_EXTEND, extendString);
            }
            if (this.type == 2) {
                json.put("orgurl", this.url);
                json.put("directip", this.serverIp);
                json.put("contentlen", this.fileSize);
                json.put("size", this.realFilesize);
                json.put("sample", this.sample);
                StringBuilder sb5 = this.errMsg;
                if (sb5 != null && sb5.length() > 0) {
                    if (json.has("msg")) {
                        json.remove("msg");
                    }
                    json.put("errdetail", this.errMsg.toString());
                }
            }
            return json;
        }

        public DownloadReportObject(String str, String str2, int i3, int i16, String str3, long j3, long j16, long j17, int i17, String str4, ExtendData extendData) {
            super(i3, i16, str3, j3, j16, j17, i17, str4, extendData);
            this.appIdType = 0;
            this.type = 1;
            this.realFilesize = 0;
            this.sample = 100;
            this.url = str;
            this.dnsIp = str2;
        }
    }
}
