package com.tencent.rmonitor.fd.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdBaseResult implements Serializable {
    public static final int REASON_DUMP_FAILED = 1;
    public static final int REASON_DUMP_FILE_PATH_INVALID = 3;
    public static final int REASON_DUMP_IO_EXCEPTION = 5;
    public static final int REASON_DUMP_NO_DUMPER = 2;
    public static final int REASON_DUMP_PARSE_EXCEPTION = 6;
    public static final int REASON_DUMP_PARSE_OOM = 7;
    public static final int REASON_DUMP_ZIP_FAILED = 4;
    public static final int REASON_FD_DUMP_EMPTY = 11;
    public static final int REASON_NULL_DUMP_RESULT = 8;
    public static final int REASON_START_SERVICE_FAILED = 9;
    public static final int REASON_UNEXPECTED_EXCEPTION = 10;
    public static final int REASON_UNKNOWN = -1;
    protected int errorCode;
    protected String errorMessage = "";

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean isSuccess() {
        if (this.errorCode == 0) {
            return true;
        }
        return false;
    }

    public void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
