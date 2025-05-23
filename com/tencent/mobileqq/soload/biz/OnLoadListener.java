package com.tencent.mobileqq.soload.biz;

import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface OnLoadListener {
    public static final int RES_CODE_ACCOUNT_CHANGE = 13;
    public static final int RES_CODE_CHECK_MD5_NOT_MATCH = 4;
    public static final int RES_CODE_CRC_AND_UNZIP_FAIL = 10;
    public static final int RES_CODE_DOWNLOAD_404 = 9;
    public static final int RES_CODE_DOWNLOAD_RELATED_FILE_FAIL = 11;
    public static final int RES_CODE_DOWNLOAD_SO_FAIL = 3;
    public static final int RES_CODE_FLOW_CONTROL_LIMITED = 15;
    public static final int RES_CODE_LOAD_CRASH = 8;
    public static final int RES_CODE_LOAD_PARAMS_INVALID = 1;
    public static final int RES_CODE_LOAD_SO_FAIL = 6;
    public static final int RES_CODE_LOAD_TIME_OUT = 7;
    public static final int RES_CODE_NO_SO_CONFIG = 2;
    public static final int RES_CODE_NO_UIN_FAILED = 12;
    public static final int RES_CODE_SO_FILE_NOT_EXIST = 5;
    public static final int RES_CODE_SUCC = 0;

    void onLoadResult(int i3, LoadExtResult loadExtResult);
}
