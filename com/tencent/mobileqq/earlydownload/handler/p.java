package com.tencent.mobileqq.earlydownload.handler;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p extends b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static final String G;
    private Handler E;
    private ArrayList<String> F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            G = SystemFaceData.class.getSimpleName();
        }
    }

    private void N(String str) {
        URL url;
        try {
            url = new URL("emotion", String.format("f%03d", Integer.valueOf(Integer.parseInt(str))), "");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "reloadFaceOnUI() ", th5);
            }
            url = null;
        }
        if (url == null) {
            return;
        }
        Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.mar);
        URLDrawable drawable2 = URLDrawable.getDrawable(url, drawable, drawable, true);
        if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "reloadFaceOnUI() idx=" + str + " d.status!=successed||loading. go to restartDownload");
            }
            drawable2.addHeader(EmotcationConstants.IDX, str);
            drawable2.restartDownload();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(G, 2, "reloadFaceOnUI() idx=" + str + " d.status=" + drawable2.getStatus() + " do nothing..");
        }
    }

    public void M(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "");
        iEarlyDownloadService.setEarlyDownloadLock();
        try {
            if (this.F == null) {
                this.F = new ArrayList<>();
            }
            if (!this.F.contains(str)) {
                this.F.add(0, str);
                if (QLog.isColorLevel()) {
                    QLog.d(G, 2, "addWaittingFace idx=" + str);
                }
            }
        } finally {
            iEarlyDownloadService.setEarlyDownloadUnLock();
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList<String> arrayList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 196864 && (arrayList = this.F) != null && arrayList.size() > 0) {
            IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) this.f203921f.getRuntimeService(IEarlyDownloadService.class, "");
            iEarlyDownloadService.setEarlyDownloadLock();
            try {
                if (this.F.size() > 0) {
                    str = this.F.remove(0);
                } else {
                    str = null;
                }
                if (str != null && str.length() > 0) {
                    N(str);
                    if (this.F.size() > 0) {
                        this.E.sendEmptyMessageDelayed(196864, 2000L);
                    }
                }
            } finally {
                iEarlyDownloadService.setEarlyDownloadUnLock();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        try {
            File dir = BaseApplication.getContext().getDir("systemface", 0);
            FileUtils.uncompressZip(str, dir.getAbsolutePath(), true);
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "doOnDownloadFinish() uncompressZip to:" + dir.getAbsolutePath());
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        super.i(str);
        this.E.sendEmptyMessage(196864);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 10055;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return SystemFaceData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "actEarlySysFaceGif";
    }
}
