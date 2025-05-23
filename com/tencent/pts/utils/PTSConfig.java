package com.tencent.pts.utils;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSNodeVirtualUtil;
import com.tencent.pts.utils.PTSReportUtil;

/* loaded from: classes22.dex */
public class PTSConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PTSConfig";
    private static a applicationContextFetcher;
    private PTSLogger logger;
    private PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo onBindNodeInfo;
    private PTSNodeVirtualUtil.INodeVirtualOnViewClick onViewClick;
    private PTSReportUtil.IPTSReport ptsReport;
    private HandlerThread subHandlerThread;

    /* loaded from: classes22.dex */
    public static class PTSConfigBuilder {
        static IPatchRedirector $redirector_;
        private PTSConfig ptsConfig;

        public PTSConfigBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.ptsConfig = new PTSConfig();
            }
        }

        public PTSConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (PTSConfig) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.ptsConfig;
        }

        public PTSConfigBuilder withHandlerThread(HandlerThread handlerThread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.ptsConfig.subHandlerThread = handlerThread;
                return this;
            }
            return (PTSConfigBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) handlerThread);
        }

        public PTSConfigBuilder withLogger(PTSLogger pTSLogger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.ptsConfig.logger = pTSLogger;
                return this;
            }
            return (PTSConfigBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSLogger);
        }

        public PTSConfigBuilder withOnBindNodeInfo(PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo iNodeVirtualOnBindNodeInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.ptsConfig.onBindNodeInfo = iNodeVirtualOnBindNodeInfo;
                return this;
            }
            return (PTSConfigBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iNodeVirtualOnBindNodeInfo);
        }

        public PTSConfigBuilder withOnViewClick(PTSNodeVirtualUtil.INodeVirtualOnViewClick iNodeVirtualOnViewClick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.ptsConfig.onViewClick = iNodeVirtualOnViewClick;
                return this;
            }
            return (PTSConfigBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iNodeVirtualOnViewClick);
        }

        public PTSConfigBuilder withPtsReport(PTSReportUtil.IPTSReport iPTSReport) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.ptsConfig.ptsReport = iPTSReport;
                return this;
            }
            return (PTSConfigBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iPTSReport);
        }
    }

    /* loaded from: classes22.dex */
    public interface a {
        Context getApplicationContext();
    }

    public PTSConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Context getApplicationContext() {
        return applicationContextFetcher.getApplicationContext();
    }

    public static void init(PTSConfig pTSConfig) {
        if (pTSConfig == null) {
            return;
        }
        PTSThreadUtil.registerSubHandlerThread(pTSConfig.subHandlerThread);
        PTSLog.registerLogger(pTSConfig.logger);
        PTSReportUtil.registerPtsReport(pTSConfig.ptsReport);
        PTSNodeVirtualUtil.register(pTSConfig.onBindNodeInfo, pTSConfig.onViewClick);
    }

    public static void setApplicationContextFetcher(a aVar) {
        applicationContextFetcher = aVar;
    }
}
