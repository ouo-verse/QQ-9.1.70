package com.tencent.aiosharemusic;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f70086d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void b(String str, JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.aiosharemusic.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0667b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static b f70087a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64604);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f70087a = new b();
            }
        }
    }

    b() {
        super("AioShareMusicIPCWebClient");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JSONObject jSONObject, String str, EIPCResultCallback eIPCResultCallback) {
        Bundle bundle = new Bundle();
        bundle.putString("data", jSONObject.toString());
        QIPCClientHelper.getInstance().getClient().callServer("AioShareMusicIPCMainClient", str, bundle, eIPCResultCallback);
    }

    public static b c() {
        return C0667b.f70087a;
    }

    public void d(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (this.f70086d != null) {
            return;
        }
        try {
            b c16 = c();
            this.f70086d = aVar;
            QIPCClientHelper.getInstance().register(c16);
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "register real");
            }
        } catch (Exception e16) {
            QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "register ipc module error.", e16);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 5, this, str, bundle, Integer.valueOf(i3));
        }
        try {
            JSONObject jSONObject = new JSONObject(bundle.getString("data"));
            a aVar = this.f70086d;
            if (aVar != null) {
                aVar.b(str, jSONObject);
                return null;
            }
            return null;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void unregister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            this.f70086d = null;
            if (QIPCClientHelper.getInstance().getClient() != null) {
                QIPCClientHelper.getInstance().getClient().unRegisterModule(c());
                if (QLog.isColorLevel()) {
                    QLog.d("AioShareMusic.AioShareMusicIPCWebClient", 2, "unregister real");
                }
            }
        } catch (Exception e16) {
            QLog.e("AioShareMusic.AioShareMusicIPCWebClient", 1, "unregister ipc module error.", e16);
        }
    }
}
