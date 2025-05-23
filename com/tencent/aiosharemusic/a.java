package com.tencent.aiosharemusic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.aiosharemusic.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0666a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f70085a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64601);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f70085a = new a();
            }
        }
    }

    a() {
        super("AioShareMusicIPCMainClient");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(JSONObject jSONObject, String str) {
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.AioShareMusicIPCMainClient", 2, "callWebClient data:" + jSONObject.toString() + "  isToolRunning:" + isProcessRunning);
        }
        if (isProcessRunning) {
            Bundle bundle = new Bundle();
            bundle.putString("data", jSONObject.toString());
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "AioShareMusicIPCWebClient", str, bundle, null);
        }
    }

    private void c(Bundle bundle) {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            try {
                ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).checkAndShowAioShareMusic(new JSONObject(bundle.getString("data")));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static a d() {
        return C0666a.f70085a;
    }

    private void e(Bundle bundle) {
        QQAppInterface qQAppInterface;
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            try {
                ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).startAioShareTogetherListen(new JSONObject(bundle.getString("data")));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, bundle, Integer.valueOf(i3));
        }
        if ("checkAioShareMusic".equals(str)) {
            c(bundle);
            return null;
        }
        if ("startListenAioShareMusic".equals(str)) {
            e(bundle);
            return null;
        }
        return null;
    }
}
