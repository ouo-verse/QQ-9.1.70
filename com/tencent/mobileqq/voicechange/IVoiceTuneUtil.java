package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVoiceTuneUtil extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final int CHANGE_VOICE_TYPE_NORMAL = 0;
    public static final int MAX_TYPES;
    public static final int[] VOICE_TYPES;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(25783), (Class<?>) IVoiceTuneUtil.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        int[] iArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        VOICE_TYPES = iArr;
        MAX_TYPES = iArr.length;
    }

    void asyncDeleteOtherTmpFile(String str, String str2, int i3, Runnable runnable);

    void deleteAllFiles(String str, String str2);

    void deleteAllFilesOnExit(String str, String str2);

    void deleteOtherTmpFiles(String str, String str2, int i3);

    String getChangedSoundFilePath(String str, int i3);

    String renameFileToPcm(String str);
}
