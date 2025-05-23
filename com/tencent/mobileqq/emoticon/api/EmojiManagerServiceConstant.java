package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmojiManagerServiceConstant {
    static IPatchRedirector $redirector_ = null;
    public static int EMOTION_DOWNLOAD_TIMEOUT = 0;
    public static boolean EMOTION_TRY_DOWNLOAD = false;
    public static final long ENCRYPT_KEY_TIMEOUT = 35000;
    public static final long FETCH_PACKAGE_TIMEOUT = 35000;
    public static final int FETCH_RETRY_MAX = 3;
    public static final String H5MAGIC_SP_ISPLAY_KEY = "h5magic_sp_isplay_key";
    public static final String H5MAGIC_SP_NAME = "h5magic_sp_name";
    public static final long INIT_FAV_TIMEOUT = 35000;
    public static int JSON_EMOSM_KEYWORD = 0;
    public static int JSON_EMOSM_MALL = 0;
    public static final String KEY_PRE = "vipEmoticonKey_";
    public static final int MAGIC_FACE_SEND_INTERVAL = 15000;
    public static final String PARAMS_BUSINESS_TYPE = "businessType";
    public static final String PARAMS_EMOTICON_EID = "emoticonId";
    public static final String PARAMS_EMOTICON_LIST = "emoticonList";
    public static final String PARAMS_IS_SMALLEMOTION = "isSmallEmotion";
    public static final String PARAMS_IS_UPDATE = "isUpdate";
    public static final String PARAMS_JSON_TYPE = "jsonType";
    public static final String PARAMS_KEY_EMOTICONPKG = "emoticonPackage";
    public static final String PARAMS_KEY_MAGIC_ROAMING = "magic_roaming";
    public static final String PARAMS_PKG_NEW_ADD = "newPkgAdd";
    public static final String PARAMS_REQ = "jsonReqParams";
    public static final String PARAMS_SWITCH_TAB = "wifiAutoDownload";
    public static final int S_MAX_CONTINUOUS_PLAY_TIMES = 4;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        JSON_EMOSM_MALL = 1;
        JSON_EMOSM_KEYWORD = 1 + 1;
        EMOTION_DOWNLOAD_TIMEOUT = 60000;
        EMOTION_TRY_DOWNLOAD = false;
    }

    public EmojiManagerServiceConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static TaskStatus getStatus(BaseQQAppInterface baseQQAppInterface, String str) {
        IEmojiManagerService iEmojiManagerService;
        if (baseQQAppInterface != null && (iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class)) != null) {
            return iEmojiManagerService.getStatusMap().get(str);
        }
        return null;
    }

    public static boolean isCover(int i3) {
        if (i3 != 3 && i3 != 4 && i3 != 2) {
            return false;
        }
        return true;
    }

    public static void printStackTraces(int i3) {
        if (i3 <= 0) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int min = Math.min(i3, stackTrace.length);
        String str = "";
        for (int i16 = 2; i16 < min; i16++) {
            StackTraceElement stackTraceElement = stackTrace[i16];
            str = str + " " + (stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.emoji.EmoDown", 4, "epId illegal,stacktrace:" + str);
        }
    }
}
