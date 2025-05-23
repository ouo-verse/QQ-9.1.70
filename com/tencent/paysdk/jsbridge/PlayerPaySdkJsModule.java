package com.tencent.paysdk.jsbridge;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.api.o;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes22.dex */
public class PlayerPaySdkJsModule extends PaySdkJsModule {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PlayerPaySdkJsModule";

    public PlayerPaySdkJsModule(Context context, o oVar, com.tencent.paysdk.api.c cVar, com.tencent.paysdk.vipauth.b bVar, l lVar) {
        super(context, oVar, cVar, bVar, lVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, oVar, cVar, bVar, lVar);
        }
    }

    @Override // com.tencent.paysdk.jsbridge.PaySdkJsModule
    @JavascriptInterface
    public void closeH5(@NotNull Map<String, ?> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else {
            com.tencent.paysdk.util.a.b(new Runnable() { // from class: com.tencent.paysdk.jsbridge.PlayerPaySdkJsModule.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayerPaySdkJsModule.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        o oVar = PlayerPaySdkJsModule.this.mWebView;
                        if (oVar != null) {
                            oVar.k().setVisibility(4);
                        }
                    } catch (Throwable th5) {
                        com.tencent.paysdk.log.c.a(PlayerPaySdkJsModule.TAG, th5.toString());
                    }
                }
            });
        }
    }
}
