package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class ReportService implements IReportService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReportService";

    public ReportService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void reportEvent(String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) map);
            return;
        }
        Log.i(TAG, "reportEvent map : " + map);
        VideoReport.reportEvent(str, map);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setElementClickPolicy(Object obj, ClickPolicy clickPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj, (Object) clickPolicy);
            return;
        }
        com.tencent.qqlive.module.videoreport.constants.ClickPolicy clickPolicy2 = com.tencent.qqlive.module.videoreport.constants.ClickPolicy.REPORT_NONE;
        if (clickPolicy == ClickPolicy.REPORT_ALL) {
            clickPolicy2 = com.tencent.qqlive.module.videoreport.constants.ClickPolicy.REPORT_ALL;
        }
        VideoReport.setElementClickPolicy(obj, clickPolicy2);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setElementEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj, (Object) endExposurePolicy);
            return;
        }
        com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy endExposurePolicy2 = com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy.REPORT_NONE;
        if (endExposurePolicy == EndExposurePolicy.REPORT_ALL) {
            endExposurePolicy2 = com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy.REPORT_ALL;
        }
        VideoReport.setElementEndExposePolicy(obj, endExposurePolicy2);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setElementExposePolicy(Object obj, ExposurePolicy exposurePolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj, (Object) exposurePolicy);
            return;
        }
        com.tencent.qqlive.module.videoreport.constants.ExposurePolicy exposurePolicy2 = com.tencent.qqlive.module.videoreport.constants.ExposurePolicy.REPORT_NONE;
        if (exposurePolicy == ExposurePolicy.REPORT_FIRST) {
            exposurePolicy2 = com.tencent.qqlive.module.videoreport.constants.ExposurePolicy.REPORT_FIRST;
        } else if (exposurePolicy == ExposurePolicy.REPORT_ALL) {
            exposurePolicy2 = com.tencent.qqlive.module.videoreport.constants.ExposurePolicy.REPORT_ALL;
        }
        VideoReport.setElementExposePolicy(obj, exposurePolicy2);
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setElementId(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj, (Object) str);
        } else {
            VideoReport.setElementId(obj, str);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setElementParams(Object obj, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) map);
        } else {
            VideoReport.setElementParams(obj, map);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setPageId(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, obj, (Object) str);
        } else {
            VideoReport.setPageId(obj, str);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void setPageParams(Object obj, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, obj, (Object) map);
        } else {
            VideoReport.setPageParams(obj, new PageParams((Map<String, ?>) map));
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IReportService
    public void reportEvent(String str, Object obj, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            VideoReport.reportEvent(str, obj, map);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, obj, map);
        }
    }
}
