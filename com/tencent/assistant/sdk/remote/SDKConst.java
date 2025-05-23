package com.tencent.assistant.sdk.remote;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SDKConst {
    static IPatchRedirector $redirector_ = null;
    public static final String COMMAND_REALTED_UPDATE_DOWNLOAD = "cmd_updatedownload";
    public static final int IPC_REGISTE_FAIL = 2;
    public static final int IPC_UNREGISTE_FAIL = 2;
    public static final String KEY_REALTED_COMMAND = "command";
    public static final String KEY_REALTED_URL = "relatedurl";
    public static final String QQDOWNLOADER_FIRST_START_ACTION_NAME = "com.tencent.assistant.ipc.firststart.action";
    public static final int REQUEST_TYPE_APPDETAIL_PAUSE = 4;
    public static final int REQUEST_TYPE_APPDETAIL_START = 1;
    public static final int REQUEST_TYPE_AUTHORIZED = 3;
    public static final int REQUEST_TYPE_DOWNLOADLIST_PAUSE = 5;
    public static final int REQUEST_TYPE_DOWNLOADLIST_START = 2;
    public static final String SDK_APILEVEL = "com.tencent.android.qqdownloader.sdk.apilevel";
    public static final int SDK_LEVEL_SUPPORT_TIMEPOINTS = 6;
    public static final int SDK_LEVEL_SUPPORT_TMAST_CALL_LIVE = 7;
    public static final String SDK_RELATED_ACTION = "com.tencent.android.qqdownloader.action.RELATED";
    public static final String SELF_PACKAGENAME = "com.tencent.android.qqdownloader";
    public static final String SERVICE_NAME = "com.tencent.android.qqdownloader.SDKService";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DownloadState {
        public static final int DELETED = 9;
        public static final int DOWNLOADING = 1;
        public static final int FAIL = 3;
        public static final int INSTALLING = 8;
        public static final int PAUSED = 2;
        public static final int QUEUING = 6;
        public static final int SUCC = 4;
    }

    public SDKConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
