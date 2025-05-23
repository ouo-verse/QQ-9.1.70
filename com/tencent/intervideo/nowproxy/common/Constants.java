package com.tencent.intervideo.nowproxy.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Constants {
    static IPatchRedirector $redirector_ = null;
    public static final int PROXY_VERSION = 12;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class CheckFlag {
        static IPatchRedirector $redirector_ = null;
        public static final int CHECK_FAIL = 2;
        public static final int CHECK_SUCCESS = 1;
        public static final int NO_FLAG = 0;

        public CheckFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Command {
        static IPatchRedirector $redirector_ = null;
        public static final String IPC_CMD_OPENROOM_RESULT = "cmd_openroom_result";

        public Command() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DownloadEngine {
        static IPatchRedirector $redirector_ = null;
        public static final int DOWNLOAD_ENGINE_DEFAULT = 0;
        public static final int DOWNLOAD_ENGINE_HOST_DEFAULT = 1;
        public static final int DOWNLOAD_ENGINE_HOST_HELLY = 2;

        public DownloadEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DownloadFlag {
        static IPatchRedirector $redirector_ = null;
        public static final int FIRST_DOWNLOAD = 1;
        public static final int FORCE_DOWNLOAD = 3;
        public static final int NORMAL_DOWNLOAD = 2;
        public static final int NO_FLAG = 0;
        public static final int RETRY_DOWNLOAD = 4;

        public DownloadFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ErrorCode {
        static IPatchRedirector $redirector_ = null;
        public static final int ERROR_START_FAIL = 1002;
        public static final int ERR_DOWNLOAD_FAIL = 1000;
        public static final int ERR_LOAD_FAIL = 1001;
        public static final int ERR_OPENPARAMS_INVALID = 1;

        public ErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Flag {
        static IPatchRedirector $redirector_ = null;
        public static final int FLAG_STOP_EXCECUTE_NEXT = 1000;

        public Flag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public Constants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
