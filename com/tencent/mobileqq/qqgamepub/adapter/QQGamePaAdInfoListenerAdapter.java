package com.tencent.mobileqq.qqgamepub.adapter;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;

/* loaded from: classes16.dex */
public class QQGamePaAdInfoListenerAdapter implements WadlTrpcListener {
    static IPatchRedirector $redirector_;

    public QQGamePaAdInfoListenerAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashSet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new HashSet<String>() { // from class: com.tencent.mobileqq.qqgamepub.adapter.QQGamePaAdInfoListenerAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGamePaAdInfoListenerAdapter.this);
                } else {
                    add("/v1/62");
                }
            }
        };
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
        }
    }
}
