package com.tencent.freesia;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class SsoReportReq {
    static IPatchRedirector $redirector_;
    public final DeviceInfo mDeviceInfo;
    public final byte[] mExtInfo;
    public final ArrayList<GroupInfo> mGroupInfos;
    public final ReportType mReportType;

    public SsoReportReq(@NonNull ReportType reportType, @NonNull DeviceInfo deviceInfo, @NonNull ArrayList<GroupInfo> arrayList, @NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, reportType, deviceInfo, arrayList, bArr);
            return;
        }
        this.mReportType = reportType;
        this.mDeviceInfo = deviceInfo;
        this.mGroupInfos = arrayList;
        this.mExtInfo = bArr;
    }

    @NonNull
    public DeviceInfo getDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DeviceInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mDeviceInfo;
    }

    @NonNull
    public byte[] getExtInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mExtInfo;
    }

    @NonNull
    public ArrayList<GroupInfo> getGroupInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mGroupInfos;
    }

    @NonNull
    public ReportType getReportType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReportType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mReportType;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SsoReportReq{mReportType=" + this.mReportType + ",mDeviceInfo=" + this.mDeviceInfo + ",mGroupInfos=" + this.mGroupInfos + ",mExtInfo=" + this.mExtInfo + "}";
    }
}
