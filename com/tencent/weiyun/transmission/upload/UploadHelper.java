package com.tencent.weiyun.transmission.upload;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.xplatform.UploadError;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.NetworkUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadHelper {
    static IPatchRedirector $redirector_ = null;
    private static final long NETWORK_CHANGE_WAIT_TIME = 60000;
    private static final String TAG = "UploadHelper";
    private static volatile int sCurrNetworkType;
    private static volatile long sNetworkChangeTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCurrNetworkType = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
            sNetworkChangeTime = SystemClock.elapsedRealtime();
        }
    }

    public UploadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void acquireWakeLockIfNot() {
        WeiyunTransmissionGlobal.getInstance().acquireWakeLockIfNot();
    }

    public static String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag) {
        return UploadManager.getInstance().calSliceSha1(str, canceledFlag);
    }

    public static String convertErrorMessage(int i3, String str) {
        if (i3 != 0 && TextUtils.isEmpty(str)) {
            String errorMsg = ErrorCodeUtil.getErrorMsg(i3);
            if (TextUtils.isEmpty(errorMsg)) {
                errorMsg = ErrorCodeUtil.getErrorMsg(ErrorCode.TRAN_UNKNOWN_EXCEPTION);
            }
            return "(" + i3 + ")" + errorMsg;
        }
        return str;
    }

    private static boolean isNetworkChange() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - sNetworkChangeTime;
        TsLog.d(TAG, "change wait time = " + elapsedRealtime);
        if (60000 > elapsedRealtime) {
            return true;
        }
        if (sCurrNetworkType != NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext())) {
            return true;
        }
        return false;
    }

    public static int parseUploadResponse(UploadResponse uploadResponse) {
        if (uploadResponse == null) {
            return ErrorCode.CMD_INVALID_RSP;
        }
        int code = uploadResponse.code();
        if (UploadError.isCurlError(code) && isNetworkChange()) {
            return ErrorCode.TRAN_NO_NETWORK;
        }
        return code;
    }

    public static void releaseWakeLockIfExist() {
        WeiyunTransmissionGlobal.getInstance().releaseWakeLockIfExist();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldRetry(int i3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateNetworkChange() {
        sCurrNetworkType = NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext());
        sNetworkChangeTime = SystemClock.elapsedRealtime();
    }
}
