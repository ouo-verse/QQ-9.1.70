package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.wx.voice.vad.WXVadSeg;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AudioSlice2TextController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AudioSlice2TextProcessor";
    private TransProcessorHandler pttTransProcessorHandler;
    private ITransFileController transFileController;

    public AudioSlice2TextController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pttTransProcessorHandler = new TransProcessorHandler() { // from class: com.tencent.mobileqq.transfile.AudioSlice2TextController.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioSlice2TextController.this);
                    }
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    }
                }
            };
        }
    }

    private void sendSttRequest(String str, List<WXVadSeg> list) {
        if (list != null) {
            list.isEmpty();
        }
    }

    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
