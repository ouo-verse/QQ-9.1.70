package com.tencent.mobileqq.popanim;

import android.graphics.Typeface;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public abstract class PopOutAnimConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int POP_EMO_BUSINESS_TYPE = 13;
    public boolean apngSoLoaded;
    public int[] itemCountRecShowAppear;
    public int[] itemCountShowAppear;
    public int maxSendCount;
    public boolean supportFeedBack;
    public Typeface typeface;

    public PopOutAnimConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void sendPopEmoMsg(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3);

    public abstract void startShakeAnimation();

    public abstract void stopShakeAnimation();
}
