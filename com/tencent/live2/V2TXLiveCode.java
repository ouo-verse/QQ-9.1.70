package com.tencent.live2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TXLiveCode {
    static IPatchRedirector $redirector_ = null;
    public static final int V2TXLIVE_ERROR_DISCONNECTED = -8;
    public static final int V2TXLIVE_ERROR_FAILED = -1;
    public static final int V2TXLIVE_ERROR_INVALID_LICENSE = -5;
    public static final int V2TXLIVE_ERROR_INVALID_PARAMETER = -2;
    public static final int V2TXLIVE_ERROR_NOT_SUPPORTED = -4;
    public static final int V2TXLIVE_ERROR_NO_AVAILABLE_HEVC_DECODERS = -2304;
    public static final int V2TXLIVE_ERROR_REFUSED = -3;
    public static final int V2TXLIVE_ERROR_REQUEST_TIMEOUT = -6;
    public static final int V2TXLIVE_ERROR_SERVER_PROCESS_FAILED = -7;
    public static final int V2TXLIVE_OK = 0;
    public static final int V2TXLIVE_WARNING_CAMERA_NO_PERMISSION = -1314;
    public static final int V2TXLIVE_WARNING_CAMERA_OCCUPIED = -1316;
    public static final int V2TXLIVE_WARNING_CAMERA_START_FAILED = -1301;
    public static final int V2TXLIVE_WARNING_CURRENT_DECODE_TYPE_CHANGED = 2008;
    public static final int V2TXLIVE_WARNING_CURRENT_ENCODE_TYPE_CHANGED = 1104;
    public static final int V2TXLIVE_WARNING_MICROPHONE_NO_PERMISSION = -1317;
    public static final int V2TXLIVE_WARNING_MICROPHONE_OCCUPIED = -1319;
    public static final int V2TXLIVE_WARNING_MICROPHONE_START_FAILED = -1302;
    public static final int V2TXLIVE_WARNING_NETWORK_BUSY = 1101;
    public static final int V2TXLIVE_WARNING_SCREEN_CAPTURE_INTERRUPTED = -7001;
    public static final int V2TXLIVE_WARNING_SCREEN_CAPTURE_NOT_SUPPORTED = -1309;
    public static final int V2TXLIVE_WARNING_SCREEN_CAPTURE_START_FAILED = -1308;
    public static final int V2TXLIVE_WARNING_VIDEO_BLOCK = 2105;

    public V2TXLiveCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
