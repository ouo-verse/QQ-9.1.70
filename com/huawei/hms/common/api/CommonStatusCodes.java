package com.huawei.hms.common.api;

import com.tencent.raft.codegenmeta.utils.RLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 17;
    public static final int CANCELED = 16;
    public static final int DEVELOPER_ERROR = 10;
    public static final int ERROR = 13;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_ACCOUNT = 5;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;

    @Deprecated
    public static final int SERVICE_DISABLED = 3;

    @Deprecated
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TIMEOUT = 15;

    public static String getStatusCodeString(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 10) {
                    if (i3 != 9004) {
                        switch (i3) {
                            case 2:
                                return "SERVICE_VERSION_UPDATE_REQUIRED";
                            case 3:
                                return "SERVICE_DISABLED";
                            case 4:
                                return "SIGN_IN_REQUIRED";
                            case 5:
                                return "INVALID_ACCOUNT";
                            case 6:
                                return "RESOLUTION_REQUIRED";
                            case 7:
                                return "NETWORK_ERROR";
                            case 8:
                                return "INTERNAL_ERROR";
                            default:
                                switch (i3) {
                                    case 13:
                                        return RLog.ERROR;
                                    case 14:
                                        return "INTERRUPTED";
                                    case 15:
                                        return "TIMEOUT";
                                    case 16:
                                        return "CANCELED";
                                    case 17:
                                        return "API_NOT_CONNECTED";
                                    default:
                                        return "unknown status code: " + i3;
                                }
                        }
                    }
                    return "DEAD_CLIENT";
                }
                return "DEVELOPER_ERROR";
            }
            return "SUCCESS";
        }
        return "SUCCESS_CACHE";
    }
}
