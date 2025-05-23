package com.pay.http;

import com.huawei.hms.framework.common.ContainerUtils;
import com.pay.tool.APMidasTools;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APIPConfig;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class APBaseHttpParam {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 15000;
    public static final int TRY_TIMES = 2;
    public String domain;
    public String url;
    public String reqType = "http://";
    public String sendType = "GET";
    public String defaultDomain = "";
    public String port = "";
    public String urlName = "";
    public String urlParams = "";
    public int connectTimeout = 15000;
    public int readTimeout = 15000;
    public int requestTimes = 0;
    public int reTryTimes = 2;
    public long begTime = 0;
    public long endTime = 0;
    public HashMap<String, String> reqParam = new HashMap<>();

    public APBaseHttpParam() {
        this.domain = "";
        this.domain = APMidasTools.getSysServerDomain();
    }

    public void constructParams() {
        StringBuilder sb5 = new StringBuilder("");
        HashMap<String, String> hashMap = this.reqParam;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
                this.urlParams = sb5.toString();
            }
        }
        APLog.i("APBaseHttpReq", "urlParams=" + this.urlParams);
    }

    public void constructReTryUrl() {
        if (this.requestTimes < this.reTryTimes) {
            this.domain = this.defaultDomain;
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
            this.requestTimes = this.requestTimes + 1;
        }
    }

    public void constructUrl() {
        constructParams();
        if (this.sendType.equals("GET")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.url);
            if (!this.url.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                stringBuffer.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            }
            stringBuffer.append(this.urlParams.toString());
            this.url = stringBuffer.toString();
        }
    }

    public void setReportUrl(String str, String str2, String str3) {
        String str4 = APMidasPayAPI.env;
        if (APMidasPayHelper.isPayCenterSDK) {
            this.domain = APIPConfig.getDomain(str4);
            this.urlName = str3;
        } else if (str4.equals(APMidasPayAPI.ENV_DEV)) {
            this.domain = APPluginUrlConf.UNIPAY_DEV_DOMAIN;
            this.urlName = str;
        } else if (str4.equals("test")) {
            this.domain = APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            this.urlName = str2;
        } else if (str4.equals("release")) {
            this.domain = APPluginUrlConf.UNIPAY_RELEASE_REPORT_DOMAIN;
            this.urlName = str3;
        } else if (str4.equals(APMidasPayAPI.ENV_TESTING)) {
            this.domain = APPluginUrlConf.UNIPAY_RELEASE_REPORT_DOMAIN;
            this.urlName = str3;
        }
        this.reTryTimes = 1;
        this.defaultDomain = this.domain;
        if (str4.equals(APMidasPayAPI.ENV_DEV)) {
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
            return;
        }
        if (str4.equals("test")) {
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
            return;
        }
        if (str4.equals("release")) {
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
            return;
        }
        if (str4.equals(APMidasPayAPI.ENV_TESTING)) {
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + this.urlName;
        }
    }

    public void setReqWithHttp() {
        this.reqType = "http://";
    }

    public void setReqWithHttps() {
        this.reqType = "https://";
    }

    public void setSendWithGet() {
        this.sendType = "GET";
    }

    public void setSendWithPost() {
        this.sendType = "POST";
    }

    public void setUrl(String str, String str2, String str3, String str4) {
        String str5 = APMidasPayAPI.env;
        if (str5.equals(APMidasPayAPI.ENV_DEV)) {
            this.urlName = str2;
            this.defaultDomain = APPluginUrlConf.UNIPAY_DEV_DOMAIN;
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + str2;
            return;
        }
        if (str5.equals("test")) {
            this.urlName = str3;
            this.defaultDomain = APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + str3;
            return;
        }
        if (str5.equals(APMidasPayAPI.ENV_TESTING)) {
            this.urlName = str3;
            this.defaultDomain = APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + str3;
            return;
        }
        if (str5.equals("release")) {
            this.urlName = str4;
            this.defaultDomain = "api.unipay.qq.com";
            this.url = this.reqType + APToolNetwork.joinDomainPort(this.domain, this.port) + str4;
        }
    }

    public void setUrlNotMidas(String str, String str2, String str3, String str4) {
        String str5 = APMidasPayAPI.env;
        this.defaultDomain = "";
        if (str5.equals(APMidasPayAPI.ENV_TESTING)) {
            this.urlName = str2;
            this.url = str2;
        } else if (str5.equals("test")) {
            this.urlName = str3;
            this.url = str3;
        } else if (str5.equals("release")) {
            this.urlName = str4;
            this.url = str4;
        }
    }
}
