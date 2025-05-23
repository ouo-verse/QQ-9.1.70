package com.tencent.could.component.common.ai.eventreport.entry;

import android.text.TextUtils;
import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class NetWorkParam {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_TIME_OUT = 30000;
    private static final int RETRY_TIMES = 3;
    private String backUpIpStringUrl;
    private String[] backUpIpStringUrls;
    private String deputy;
    private HttpMethod httpMethod;
    private String httpsVerifyHost;
    private boolean isGzip;
    private String requestData;
    private HashMap<String, String> requestHeaders;
    private int retryTimes;
    private int timeOutTimes;
    private String url;

    /* loaded from: classes5.dex */
    public static class NetWorkParamBuilder {
        static IPatchRedirector $redirector_;
        private String backUpIpStringUrl;
        private String[] backUpIpStringUrls;
        private String deputy;
        private HttpMethod httpMethod;
        private String httpsVerifyHost;
        private boolean isGzip;
        private String requestData;
        private HashMap<String, String> requestHeaders;
        private int retryTimes;
        private int timeOutTimes;
        private String url;

        public NetWorkParamBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            String str = EventReportConfig.STRING_INIT;
            this.url = str;
            this.deputy = str;
            this.httpsVerifyHost = str;
            this.backUpIpStringUrl = str;
            this.httpMethod = HttpMethod.POST;
            this.requestData = null;
            this.requestHeaders = null;
            this.isGzip = false;
            this.timeOutTimes = 30000;
            this.retryTimes = 3;
        }

        public static NetWorkParamBuilder newBuilder() {
            return new NetWorkParamBuilder();
        }

        public NetWorkParam createNetWorkParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (NetWorkParam) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return new NetWorkParam(this);
        }

        public NetWorkParamBuilder setBackUpIpStringUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.backUpIpStringUrl = str;
            return this;
        }

        public NetWorkParamBuilder setBackUpIpStringUrls(String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr);
            }
            this.backUpIpStringUrls = strArr;
            return this;
        }

        public NetWorkParamBuilder setDeputyUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.deputy = str;
            }
            return this;
        }

        public NetWorkParamBuilder setGzip(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.isGzip = z16;
            return this;
        }

        public NetWorkParamBuilder setHttpMethod(HttpMethod httpMethod) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) httpMethod);
            }
            this.httpMethod = httpMethod;
            return this;
        }

        public NetWorkParamBuilder setHttpsVerifyHost(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.httpsVerifyHost = str;
            return this;
        }

        public NetWorkParamBuilder setRequestData(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.requestData = str;
            return this;
        }

        public NetWorkParamBuilder setRequestHeaders(HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
            }
            this.requestHeaders = hashMap;
            return this;
        }

        public NetWorkParamBuilder setRetryTimes(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.retryTimes = i3;
            return this;
        }

        public NetWorkParamBuilder setTimeOutTimes(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.timeOutTimes = i3;
            return this;
        }

        public NetWorkParamBuilder setUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NetWorkParamBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.url = str;
            return this;
        }
    }

    public NetWorkParam(NetWorkParamBuilder netWorkParamBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) netWorkParamBuilder);
            return;
        }
        this.deputy = "";
        this.timeOutTimes = 30000;
        this.retryTimes = 3;
        this.httpsVerifyHost = "";
        this.backUpIpStringUrl = "";
        this.url = netWorkParamBuilder.url;
        this.httpMethod = netWorkParamBuilder.httpMethod;
        this.requestData = netWorkParamBuilder.requestData;
        this.requestHeaders = netWorkParamBuilder.requestHeaders;
        this.isGzip = netWorkParamBuilder.isGzip;
        this.timeOutTimes = netWorkParamBuilder.timeOutTimes;
        this.retryTimes = netWorkParamBuilder.retryTimes;
        this.deputy = netWorkParamBuilder.deputy;
        this.httpsVerifyHost = netWorkParamBuilder.httpsVerifyHost;
        this.backUpIpStringUrl = netWorkParamBuilder.backUpIpStringUrl;
        this.backUpIpStringUrls = netWorkParamBuilder.backUpIpStringUrls;
    }

    public String getBackUpIpStringUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.backUpIpStringUrl;
    }

    public String[] getBackUpIpStringUrls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.backUpIpStringUrls;
    }

    public String getDeputyUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.deputy;
    }

    public HttpMethod getHttpMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HttpMethod) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.httpMethod;
    }

    public String getHttpsVerifyHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.httpsVerifyHost;
    }

    public String getRequestData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.requestData;
    }

    public HashMap<String, String> getRequestHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.requestHeaders;
    }

    public int getRetryTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.retryTimes;
    }

    public int getTimeOutTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.timeOutTimes;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.url;
    }

    public boolean isGzip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isGzip;
    }
}
