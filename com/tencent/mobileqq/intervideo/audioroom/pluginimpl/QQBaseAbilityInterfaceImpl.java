package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.troop.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQBaseAbilityInterfaceImpl implements QQBaseAbilityInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final b f238125a;

    public QQBaseAbilityInterfaceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QLog.d("QQBaseAbilityInterface", 4, "init");
        b A = b.A();
        this.f238125a = A;
        A.p();
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void beaconReportData(Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle, i3);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void doCgiReq(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle, (Object) commonCallback);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void download(Bundle bundle, DownloadCallback downloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) downloadCallback);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Future<Bundle> getA1(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Future) iPatchRedirector.redirect((short) 16, this, str, str2, str3, str4);
        }
        return null;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Future<Bundle> getAccessToken(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Future) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        return null;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public String getSelfUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Bundle getTickets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bundle) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void hasPluginLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            QLog.d("QQBaseAbilityInterface", 4, "hasPluginLoaded");
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public boolean isMobileNet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void jumpAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            AudioRoomJumpActionDispatcher.dispatch(str);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void openWebView(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else {
            AudioRoomOpenWebViewHandler.openWebView(bundle);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void printQLog(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void reportData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            this.f238125a.p0(bundle);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public String reqDns(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void sendSSOTask(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle, (Object) commonCallback);
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void showToast(Context context, CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, context, charSequence, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public boolean useIpDirectConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }
}
