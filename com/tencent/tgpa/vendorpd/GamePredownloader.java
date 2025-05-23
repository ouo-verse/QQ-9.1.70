package com.tencent.tgpa.vendorpd;

import android.content.Context;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes26.dex */
public interface GamePredownloader {

    /* loaded from: classes26.dex */
    public interface Callback {
        int getPreDownloadVersionInfo(String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes26.dex */
    public static final class CombinationError {
        private static final /* synthetic */ CombinationError[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CombinationError CDNUrlOrMD5IsNULL;
        public static final CombinationError ChannelIsNULL;
        public static final CombinationError CloudChannelTagIsNotCorrect;
        public static final CombinationError CloudChannelTagSizeNotMatch;
        public static final CombinationError CodeRunTimeException;
        public static final CombinationError ContentDecryptException;
        public static final CombinationError ContextIsNULL;
        public static final CombinationError GamePackageNameIsNULL;
        public static final CombinationError JsonParseFailed;
        public static final CombinationError LocalFileMd5IsNotMatched;
        public static final CombinationError NetWorkRequestFailed;
        public static final CombinationError OperationExecuteFailed;
        public static final CombinationError PredownFilePathIsNULL;
        public static final CombinationError PredownFilePathNotExsit;
        public static final CombinationError ReadPredownloadFileException;
        public static final CombinationError ServerCheckError;
        public static final CombinationError ServerForbidCombineApk;
        public static final CombinationError ServerForbidCombineApkOverChannels;
        public static final CombinationError Success;
        private final int code;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            CombinationError combinationError = new CombinationError("Success", 0, 0);
            Success = combinationError;
            CombinationError combinationError2 = new CombinationError("ContextIsNULL", 1, -1);
            ContextIsNULL = combinationError2;
            CombinationError combinationError3 = new CombinationError("ChannelIsNULL", 2, -2);
            ChannelIsNULL = combinationError3;
            CombinationError combinationError4 = new CombinationError("CDNUrlOrMD5IsNULL", 3, -3);
            CDNUrlOrMD5IsNULL = combinationError4;
            CombinationError combinationError5 = new CombinationError("GamePackageNameIsNULL", 4, -4);
            GamePackageNameIsNULL = combinationError5;
            CombinationError combinationError6 = new CombinationError("PredownFilePathIsNULL", 5, -5);
            PredownFilePathIsNULL = combinationError6;
            CombinationError combinationError7 = new CombinationError("PredownFilePathNotExsit", 6, -6);
            PredownFilePathNotExsit = combinationError7;
            CombinationError combinationError8 = new CombinationError("NetWorkRequestFailed", 7, -7);
            NetWorkRequestFailed = combinationError8;
            CombinationError combinationError9 = new CombinationError("JsonParseFailed", 8, -8);
            JsonParseFailed = combinationError9;
            CombinationError combinationError10 = new CombinationError("CodeRunTimeException", 9, -9);
            CodeRunTimeException = combinationError10;
            CombinationError combinationError11 = new CombinationError("ServerForbidCombineApk", 10, -10);
            ServerForbidCombineApk = combinationError11;
            CombinationError combinationError12 = new CombinationError("CloudChannelTagIsNotCorrect", 11, -11);
            CloudChannelTagIsNotCorrect = combinationError12;
            CombinationError combinationError13 = new CombinationError("CloudChannelTagSizeNotMatch", 12, -12);
            CloudChannelTagSizeNotMatch = combinationError13;
            CombinationError combinationError14 = new CombinationError("ContentDecryptException", 13, -13);
            ContentDecryptException = combinationError14;
            CombinationError combinationError15 = new CombinationError("OperationExecuteFailed", 14, -14);
            OperationExecuteFailed = combinationError15;
            CombinationError combinationError16 = new CombinationError("LocalFileMd5IsNotMatched", 15, -15);
            LocalFileMd5IsNotMatched = combinationError16;
            CombinationError combinationError17 = new CombinationError("ServerForbidCombineApkOverChannels", 16, -16);
            ServerForbidCombineApkOverChannels = combinationError17;
            CombinationError combinationError18 = new CombinationError("ServerCheckError", 17, -17);
            ServerCheckError = combinationError18;
            CombinationError combinationError19 = new CombinationError("ReadPredownloadFileException", 18, -18);
            ReadPredownloadFileException = combinationError19;
            $VALUES = new CombinationError[]{combinationError, combinationError2, combinationError3, combinationError4, combinationError5, combinationError6, combinationError7, combinationError8, combinationError9, combinationError10, combinationError11, combinationError12, combinationError13, combinationError14, combinationError15, combinationError16, combinationError17, combinationError18, combinationError19};
        }

        CombinationError(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.code = i16;
            }
        }

        public static CombinationError valueOf(String str) {
            return (CombinationError) Enum.valueOf(CombinationError.class, str);
        }

        public static CombinationError[] values() {
            return (CombinationError[]) $VALUES.clone();
        }

        public int getCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.code;
        }
    }

    /* loaded from: classes26.dex */
    public interface LibLoader {
        boolean loadLibrary(String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes26.dex */
    public static final class RetMsg {
        private static final /* synthetic */ RetMsg[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RetMsg NetworkException;
        public static final RetMsg ResponseDataIsNotJson;
        public static final RetMsg ResponseDataJsonFormatException;
        public static final RetMsg Success;

        /* renamed from: msg, reason: collision with root package name */
        private final String f375983msg;
        private final int ret;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12582);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            RetMsg retMsg = new RetMsg("Success", 0, 0, "get predownload info success!");
            Success = retMsg;
            RetMsg retMsg2 = new RetMsg("NetworkException", 1, 2, "network request exception!");
            NetworkException = retMsg2;
            RetMsg retMsg3 = new RetMsg("ResponseDataIsNotJson", 2, 3, "response content parse to json exception!");
            ResponseDataIsNotJson = retMsg3;
            RetMsg retMsg4 = new RetMsg("ResponseDataJsonFormatException", 3, 4, "response content's json format is not correct!");
            ResponseDataJsonFormatException = retMsg4;
            $VALUES = new RetMsg[]{retMsg, retMsg2, retMsg3, retMsg4};
        }

        RetMsg(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                this.ret = i16;
                this.f375983msg = str2;
            }
        }

        public static RetMsg valueOf(String str) {
            return (RetMsg) Enum.valueOf(RetMsg.class, str);
        }

        public static RetMsg[] values() {
            return (RetMsg[]) $VALUES.clone();
        }

        public String getJsonData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.format(Locale.getDefault(), "{\"ret\": %d,\"data\":{},\"msg\": \"%s\"}", Integer.valueOf(this.ret), this.f375983msg);
        }

        public String getMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f375983msg;
        }

        public int getRet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.ret;
        }
    }

    int combinePackage(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void enableDebug(boolean z16);

    void getGameVersionUpdateInfo(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback);

    void reportPreDownladInfo(Context context, HashMap<String, String> hashMap);

    void setApiKey(String str);

    void setApiSecret(String str);

    void setDeviceIdentifier(String str);

    void setLogAble(boolean z16);
}
