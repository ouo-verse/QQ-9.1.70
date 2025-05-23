package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CommonUsedSystemEmojiManagerConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String COMMONUSED_SYSTEM_EMOJI_FILE_NAME_ = "commonusedSystemEmojiInfoFile_v2_";
    public static final String COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ = "commonusedSystemEmojiInfoFile_v3_";
    public static final long EMOJI_UPDATE_TIME_660 = 1476413876;
    public static final String LAST_REQUEST_TIME = "lastRequestTime";
    public static final String SP_FILE_NAME = "commonUsedSystemEmoji_sp";
    public static final int TYPE_EMOJI = 2;
    public static final int TYPE_SYSTEM = 1;

    public CommonUsedSystemEmojiManagerConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
