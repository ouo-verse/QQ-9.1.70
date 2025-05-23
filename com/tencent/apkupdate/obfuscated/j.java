package com.tencent.apkupdate.obfuscated;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.protocol.BaseHttpRequest;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoRequest;
import com.tencent.apkupdate.logic.protocol.jce.ReportApkFileInfoResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j extends BaseHttpRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final List<ApkFileInfo> f72533d;

    public j(List<ApkFileInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.f72533d = list;
        }
    }

    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    public void onDataReceiveFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Message obtainMessage = g.a().obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    public void onFinished(JceStruct jceStruct, JceStruct jceStruct2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jceStruct, (Object) jceStruct2);
            return;
        }
        if (jceStruct2 != null && (jceStruct2 instanceof ReportApkFileInfoResponse)) {
            ReportApkFileInfoResponse reportApkFileInfoResponse = (ReportApkFileInfoResponse) jceStruct2;
            p.a("UploadApkHttpRequest", "UploadApkHttpRequest:onFinished; ret=" + reportApkFileInfoResponse.ret);
            if (reportApkFileInfoResponse.ret == 0) {
                Message obtainMessage = g.a().obtainMessage();
                obtainMessage.what = 3;
                obtainMessage.sendToTarget();
                if (jceStruct != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<ApkFileInfo> it = ((ReportApkFileInfoRequest) jceStruct).apkFileInfoList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().packageName);
                    }
                    if (arrayList.size() > 0) {
                        Message obtainMessage2 = g.a().obtainMessage();
                        obtainMessage2.what = 8;
                        obtainMessage2.obj = arrayList;
                        obtainMessage2.sendToTarget();
                    }
                }
            }
        }
    }

    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    public void prepareData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.prepareData();
        ReportApkFileInfoRequest reportApkFileInfoRequest = new ReportApkFileInfoRequest();
        reportApkFileInfoRequest.apkFileInfoList = (ArrayList) this.f72533d;
        setData(reportApkFileInfoRequest);
        StringBuffer stringBuffer = new StringBuffer("UploadApkHttpRequest:prepareData;apkFileInfoList= [");
        for (ApkFileInfo apkFileInfo : this.f72533d) {
            stringBuffer.append("pkgname=" + apkFileInfo.packageName + ";apkId=" + apkFileInfo.apkId + "| \n\r");
        }
        p.a("UploadApkHttpRequest", stringBuffer.toString() + "]");
    }
}
