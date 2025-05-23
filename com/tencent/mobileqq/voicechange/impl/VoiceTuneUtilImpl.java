package com.tencent.mobileqq.voicechange.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoiceTuneUtilImpl implements IVoiceTuneUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "VoiceTuneUtilImpl";

    public VoiceTuneUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncDeleteOtherTmpFile$0(String str, String str2, int i3, Runnable runnable) {
        deleteOtherTmpFiles(str, str2, i3);
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public void asyncDeleteOtherTmpFile(final String str, final String str2, final int i3, final Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), runnable);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.voicechange.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceTuneUtilImpl.this.lambda$asyncDeleteOtherTmpFile$0(str, str2, i3, runnable);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public void deleteAllFiles(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        new File(str).delete();
        new File(str2).delete();
        for (int i3 = 0; i3 < IVoiceTuneUtil.MAX_TYPES; i3++) {
            new File(((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(str, i3)).delete();
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public void deleteAllFilesOnExit(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        new File(str).deleteOnExit();
        new File(str2).deleteOnExit();
        for (int i3 = 0; i3 < IVoiceTuneUtil.MAX_TYPES; i3++) {
            new File(((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(str, i3)).deleteOnExit();
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public void deleteOtherTmpFiles(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
            return;
        }
        new File(str).delete();
        new File(str2).delete();
        String str3 = null;
        for (int i16 = 0; i16 < IVoiceTuneUtil.MAX_TYPES; i16++) {
            String changedSoundFilePath = getChangedSoundFilePath(str, i16);
            if (i16 == i3) {
                str3 = changedSoundFilePath;
            } else {
                new File(changedSoundFilePath).delete();
            }
        }
        if (str3 != null) {
            new File(str3).renameTo(new File(str));
        }
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public String getChangedSoundFilePath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        int lastIndexOf = str.lastIndexOf(".");
        return str.substring(0, lastIndexOf).concat("_" + i3).concat(str.substring(lastIndexOf, str.length()));
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceTuneUtil
    public String renameFileToPcm(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        String concat = str.substring(0, str.lastIndexOf(".")).concat(MediaConfig.AUDIO_PCM_FILE_POSTFIX);
        new File(str).renameTo(new File(concat));
        return concat;
    }
}
