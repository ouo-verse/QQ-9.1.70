package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IScanDaTongApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScanDaTongApiImpl implements IScanDaTongApi {
    static IPatchRedirector $redirector_;

    public ScanDaTongApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanDaTongApi
    public void setFlashlightBtnInfo(View view, String str, boolean z16, boolean z17) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, IScanDaTongApi.ELEM_FLASHLIGHT_BTN);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        String str2 = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "2";
        }
        VideoReport.setPageParams(view, IScanDaTongApi.KEY_PAGE_VERSION, obj);
        if (!z17) {
            str2 = "2";
        }
        VideoReport.setElementParam(view, IScanDaTongApi.KEY_FLASHLIGHT_SWITCH, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanDaTongApi
    public void setGalleryBtnInfo(View view, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, str, Boolean.valueOf(z16));
            return;
        }
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, str);
        VideoReport.setElementId(view, IScanDaTongApi.ELEM_GALLERY_BTN);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        VideoReport.setPageParams(view, IScanDaTongApi.KEY_PAGE_VERSION, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanDaTongApi
    public void setHelpBtnInfo(View view, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, str, Boolean.valueOf(z16));
            return;
        }
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, str);
        VideoReport.setElementId(view, IScanDaTongApi.ELEM_HELP_BTN);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        VideoReport.setPageParams(view, IScanDaTongApi.KEY_PAGE_VERSION, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanDaTongApi
    public void setMyQrCodeInfo(View view, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, str, Boolean.valueOf(z16));
            return;
        }
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, str);
        VideoReport.setElementId(view, IScanDaTongApi.ELEM_MY_QR_BTN);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        VideoReport.setPageParams(view, IScanDaTongApi.KEY_PAGE_VERSION, str2);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScanDaTongApi
    public void setPageParams(Activity activity, View view, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, view, str, Boolean.valueOf(z16));
            return;
        }
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        VideoReport.setPageParams(view, IScanDaTongApi.KEY_PAGE_VERSION, str2);
    }
}
