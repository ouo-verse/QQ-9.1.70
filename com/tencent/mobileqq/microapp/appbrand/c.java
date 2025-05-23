package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements OnUpdateListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f245993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f245993a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.microapp.sdk.OnUpdateListener
    public void onCheckForUpdate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                jSONObject.put("state", IXWebBroadcastListener.STAGE_PROGRESSED);
            } else {
                jSONObject.put("state", "noUpdate");
            }
            this.f245993a.a(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.mobileqq.microapp.sdk.OnUpdateListener
    public void onUpdateSucc(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                jSONObject.put("state", "updateready");
            } else {
                jSONObject.put("state", "updatefailed");
            }
            this.f245993a.a(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }
}
