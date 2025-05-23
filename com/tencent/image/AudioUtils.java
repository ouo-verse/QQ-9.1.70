package com.tencent.image;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioUtils {
    static IPatchRedirector $redirector_;

    public AudioUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void abandonAudioFoucus() {
        Context context = URLDrawable.depImp.mTool.getContext();
        if (context != null) {
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public static void requesetAudioFoucus() {
        Context context = URLDrawable.depImp.mTool.getContext();
        if (context != null) {
            ((AudioManager) context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
        }
    }
}
