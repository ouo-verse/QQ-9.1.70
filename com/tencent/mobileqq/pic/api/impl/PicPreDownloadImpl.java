package com.tencent.mobileqq.pic.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.b;
import com.tencent.mobileqq.pic.n;
import com.tencent.mobileqq.pic.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PicPreDownloadImpl implements IPicPreDownload {
    static IPatchRedirector $redirector_;
    AppInterface app;
    public PicPreDownloader picPreDownloader;
    public s picStatisticsManager;

    public PicPreDownloadImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public int calcUinType(AppInterface appInterface, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, appInterface, Integer.valueOf(i3), str)).intValue();
        }
        return n.i(appInterface, i3, str);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void clearAIORequests() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.picPreDownloader.m();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void commitTrafficPref() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            b.h();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public IPicPreDownload.a getConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IPicPreDownload.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.picPreDownloader.f258523h.p();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public HashMap<String, String> getDebugPreDownloadReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.picPreDownloader.f258523h.s();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public boolean getPreDownSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return b.f258636h;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void increaseTroopCountWhenEnterAIO(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.picPreDownloader.f258523h.t(str);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public boolean isScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return PicPreDownloader.D;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = (AppInterface) appRuntime;
        this.picStatisticsManager = new s(this.app);
        this.picPreDownloader = new PicPreDownloader(this.app, this.picStatisticsManager);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.picPreDownloader.onDestroy();
            this.picStatisticsManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void payPicFlow(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic);
            return;
        }
        this.picStatisticsManager.j(messageForPic);
        this.picPreDownloader.s().a(messageForPic, messageForPic.size);
        this.picPreDownloader.n();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void productFromAIO(MessageForPic messageForPic, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) messageForPic, i3);
        } else {
            this.picPreDownloader.A(messageForPic, i3);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void productFromAIODynamicPic(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageForPic);
        } else {
            this.picPreDownloader.B(messageForPic, 2);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void productFromMsg(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) messageRecord, i3);
        } else {
            this.picPreDownloader.C(messageRecord, i3);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void switchOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.picPreDownloader.v();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void switchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.picPreDownloader.w();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicPreDownload
    public void updateConfigs(IPicPreDownload.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.picPreDownloader.f258523h.D(aVar);
        }
    }
}
