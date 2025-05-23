package com.tencent.qzonehub.api;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneVideoSoDownloadModule extends QRouteApi {
    public static final String ACTION_CHECK_AVCODEC_IS_OK = "action_check_avcodec_is_ok";
    public static final String ACTION_DOWNLOAD_AVCODEC = "action_download_avcodec";
    public static final String KEY_DOWNLOAD_RESULT_RECEIVER = "key_download_result_receiver";
    public static final String KEY_ERROR_MESSAGE = "key_error_message";
    public static final String KEY_IS_AVCODEC_OK = "key_is_avcodec_ok";
    public static final String NAME = "QzoneVideoSoDownloadModule";
    public static final int RESULT_CODE_CONFIG_FAILED = -2;
    public static final int RESULT_CODE_DOWNLOAD_FAILED = -3;
    public static final int RESULT_CODE_FAILED = -1;
    public static final int RESULT_CODE_SUCCESS = 0;

    ResultReceiver getReceiverForSending(DownloadResultCallback downloadResultCallback);
}
