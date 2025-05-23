package com.tencent.mobileqq.emoticonview;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VoiceGifFactory {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "VoiceGifFactory";

    public VoiceGifFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AbstractGifImage getVoiceGifObject(File file, int i3, boolean z16) {
        AbstractGifImage voiceGifImage;
        try {
            if (NativeGifFactory.isUseNewGif()) {
                voiceGifImage = new VoiceGifImageV2(file, i3, z16);
            } else {
                voiceGifImage = new VoiceGifImage(file, i3, z16);
            }
            return voiceGifImage;
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getVoiceGifObject exception. msg:" + e16.getMessage());
            }
            return null;
        }
    }
}
