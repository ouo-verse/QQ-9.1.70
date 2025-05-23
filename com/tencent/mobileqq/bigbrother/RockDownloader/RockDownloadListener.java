package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class RockDownloadListener implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_BLOCK_IN_GP = 10012;
    public static final int ERROR_CODE_CKV_ERROR = 10005;
    public static final int ERROR_CODE_DOWNLOAD_INFO_VERIFY_FAIL = 10001;
    public static final int ERROR_CODE_GET_PERMISSION_ERROR = 10002;
    public static final int ERROR_CODE_HIDDEN_APK_ERROR = 10007;
    public static final int ERROR_CODE_NOT_WIFI_NETWORK_ERROR = 10009;
    public static final int ERROR_CODE_OVER_THRESHOLD_ERROR = 10006;
    public static final int ERROR_CODE_PARSE_APK_ERROR = 10008;
    public static final int ERROR_CODE_REPEATED_TASK_ERROR = 10011;
    public static final int ERROR_CODE_SERVER_ERROR = 10003;
    public static final int ERROR_CODE_TMA_NOT_READY_ERROR = 10010;
    public static final int ERROR_CODE_UNKNOW_COMMAND = 10004;

    public RockDownloadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onDownloadCancel(RockDownloadInfo rockDownloadInfo);

    public abstract void onDownloadFail(RockDownloadInfo rockDownloadInfo, String str, int i3);

    public abstract void onDownloadFinish(RockDownloadInfo rockDownloadInfo);

    public abstract void onDownloadProceedOn(RockDownloadInfo rockDownloadInfo, int i3);

    public abstract void onDownloadStart(RockDownloadInfo rockDownloadInfo);

    public abstract void onDownloadSuccess(RockDownloadInfo rockDownloadInfo);

    public abstract void onDownloadWait(RockDownloadInfo rockDownloadInfo);

    public abstract void onPermissionDeny(RockDownloadInfo rockDownloadInfo);

    public abstract void onPermissionPermit(RockDownloadInfo rockDownloadInfo);
}
