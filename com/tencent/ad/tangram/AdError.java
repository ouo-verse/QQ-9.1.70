package com.tencent.ad.tangram;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdError {
    public static final int ERROR_ABI_UNSUPPORTED = 9;
    public static final int ERROR_APP_INSTALLED = 19;
    public static final int ERROR_APP_NOT_INSTLLED = 12;
    public static final int ERROR_APP_PREORDER_QQREMINDER_RESCHEDULE_TOO_FREQUENTLY = 221;
    public static final int ERROR_APP_PREORDER_QQREMINDER_SWITCH_ON_TOO_FREQUENTLY = 220;
    public static final int ERROR_ARK_INVALID_VIEW = 207;
    public static final int ERROR_ARK_NOT_PUBLISHED = 209;
    public static final int ERROR_ARK_UPDATE = 208;
    public static final int ERROR_BROWSER_UNSUPPORTED = 301;
    public static final int ERROR_CANVAS_UNSUPPORTED = 302;
    public static final int ERROR_CHARSET_UNSUPPORTED = 11;
    public static final int ERROR_CRASH = 15;
    public static final int ERROR_CREATE_VIDEO_PLAYER = 310;
    public static final int ERROR_CREATE_VIDEO_VIEW = 312;
    public static final int ERROR_DEVICE_UNSUPPORTED = 10;
    public static final int ERROR_EXTERNAL_STORAGE_STATE = 213;
    public static final int ERROR_FRONTEND = 21;
    public static final int ERROR_GET_LAUNCH_INTENT_FOR_PACKAGE = 203;
    public static final int ERROR_HALF_SCREEN_DOWNLOAD_UNSUPPORTED = 300;
    public static final int ERROR_HALF_SCREEN_PAGE_UNSUPPORTED = 306;
    public static final int ERROR_INIT_VIDEO_SDK = 309;
    public static final int ERROR_INTERNAL = 1;
    public static final int ERROR_INVALID_PARAMS = 4;
    public static final int ERROR_KUIKLY_ON_PAGE_LOAD_FAILED = 402;
    public static final int ERROR_KUIKLY_SHOW_ERROR_VIEW = 401;
    public static final int ERROR_LOAD_LIBRARY = 6;
    public static final int ERROR_LOCK = 18;
    public static final int ERROR_MULTI_VIDEO_PREPARED = 313;
    public static final int ERROR_NETWORK = 3;
    public static final int ERROR_NETWORK_ON_MAIN_THREAD = 8;
    public static final int ERROR_NOT_EXISTS = 16;
    public static final int ERROR_NO_CACHE = 7;
    public static final int ERROR_NO_FILL = 101;
    public static final int ERROR_NO_SETTINGS = 106;
    public static final int ERROR_OLYMPIC_INTER_PAGE_UNSUPPORTED = 400;
    public static final int ERROR_PROCESS = 20;
    public static final int ERROR_QQ_MINI_PROGRAM_UNSUPPORTED = 304;
    public static final int ERROR_RESOLVE_ACTIVITY = 204;
    public static final int ERROR_SERVER = 5;
    public static final int ERROR_START_ACTIVITY = 202;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_TAIDSDK_GET_ID = 206;
    public static final int ERROR_TAIDSDK_INIT = 205;
    public static final int ERROR_THREAD = 22;
    public static final int ERROR_TIMEOUT = 13;
    public static final int ERROR_TOO_FREQUENTLY = 2;
    public static final int ERROR_TRIPLE_LINK_UNSUPPORTED = 309;
    public static final int ERROR_UNSUPPORTED_VERSION = 14;
    public static final int ERROR_URI_PARSE = 201;
    public static final int ERROR_VIDEO_CEILING_UNSUPPORTED = 303;
    public static final int ERROR_VIDEO_SPLICE_UNSUPPORTED = 305;
    public static final int ERROR_VIDEO_URL_INFO = 311;
    public static final int ERROR_WITHOUT_PERMISSION = 17;
    public static final int ERROR_WX_CANVAS_UNSUPPORTED = 307;
    public static final int ERROR_WX_MINI_PROGRAM_UNSUPPORTED = 308;
    public static final int ERROR_WX_SEND_REQ = 151;
    private int errorCode;

    @Nullable
    private Throwable throwable;

    public AdError(int i3) {
        this.errorCode = i3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean isSuccess() {
        if (getErrorCode() == 0) {
            return true;
        }
        return false;
    }

    public AdError(int i3, @Nullable Throwable th5) {
        this.errorCode = i3;
        this.throwable = th5;
    }
}
