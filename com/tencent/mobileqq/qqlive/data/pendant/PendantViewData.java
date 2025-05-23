package com.tencent.mobileqq.qqlive.data.pendant;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cr4.g;

/* loaded from: classes17.dex */
public class PendantViewData {
    static IPatchRedirector $redirector_ = null;
    private static final int LOCATION_LEFT_TOP = 0;
    private static final int LOCATION_RIGHT_BOTTOM = 2;
    private static final int LOCATION_RIGHT_TOP = 1;
    public static final int PIC_URL_TYPE = 2;
    public static final int UNKOWN_DEFAULT_TYPE = 0;
    public static final int WEBVIEW_TYPE = 1;
    public String dataCmd;
    public g[] pendantInfoArray;
    public String pendantUrl;
    public float viewHeightDp;
    public long viewPosition;
    public float viewWidthDp;
    public String webData;

    public PendantViewData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getViewPositionMsg() {
        long j3 = this.viewPosition;
        if (j3 == 5) {
            return "\u5de6\u4e0a";
        }
        if (j3 == 1) {
            return "\u53f3\u4e0a";
        }
        if (j3 == 4) {
            return "\u53f3\u4e0b";
        }
        return "\u672a\u77e5";
    }

    public int getLocationForReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        long j3 = this.viewPosition;
        if (j3 == 5) {
            return 0;
        }
        if (j3 == 1) {
            return 1;
        }
        if (j3 == 4) {
            return 2;
        }
        return -1;
    }

    public String getWebData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (TextUtils.isEmpty(this.webData)) {
            return "";
        }
        return this.webData;
    }

    public boolean modifyTimeChanged(PendantViewData pendantViewData) {
        long j3;
        long j16;
        g[] gVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pendantViewData)).booleanValue();
        }
        g[] gVarArr2 = this.pendantInfoArray;
        long j17 = 0;
        if (gVarArr2 != null) {
            j3 = gVarArr2.length;
        } else {
            j3 = 0;
        }
        if (pendantViewData != null && (gVarArr = pendantViewData.pendantInfoArray) != null) {
            j16 = gVarArr.length;
        } else {
            j16 = 0;
        }
        if (j3 != j16) {
            return true;
        }
        long j18 = 0;
        for (g gVar : gVarArr2) {
            j18 += gVar.f391751q;
        }
        if (pendantViewData != null) {
            for (g gVar2 : pendantViewData.pendantInfoArray) {
                j17 += gVar2.f391751q;
            }
        }
        if (j18 != j17) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PendantViewData{dataCmd='" + this.dataCmd + "', viewPosition=" + this.viewPosition + ", posMsg=" + getViewPositionMsg() + ", viewWidthDp=" + this.viewWidthDp + ", viewHeightDp=" + this.viewHeightDp + ", pendantUrl='" + this.pendantUrl + "', webData='" + this.webData + "'}";
    }
}
