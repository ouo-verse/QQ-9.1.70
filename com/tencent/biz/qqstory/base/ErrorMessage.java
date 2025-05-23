package com.tencent.biz.qqstory.base;

import android.annotation.TargetApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class ErrorMessage extends Error {
    public static final int NO_ERROR = 0;
    public static final int NO_ERROR_FROM_MSF = 1000;
    public int errorCode;
    public String errorMsg;
    public String extraMsg;

    public ErrorMessage() {
        this.errorCode = 0;
        this.errorMsg = "";
    }

    public String getErrorMessage() {
        return String.format("%s(%d)", this.errorMsg, Integer.valueOf(this.errorCode));
    }

    public String getErrorMessageForReport() {
        return String.format("%d:%s", Integer.valueOf(this.errorCode), this.errorMsg);
    }

    public boolean isFail() {
        if (this.errorCode != 0) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.errorCode == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ErrorMessage{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', extraMsg='" + this.extraMsg + "'}";
    }

    public String getErrorMessage(String str) {
        if (str == null || str.isEmpty()) {
            str = HardCodeUtil.qqStr(R.string.ma6);
        }
        return String.format("%s(%d)", str, Integer.valueOf(this.errorCode));
    }

    public ErrorMessage(int i3, String str) {
        this.errorCode = i3 == 1000 ? 0 : i3;
        this.errorMsg = str;
    }

    public ErrorMessage(ErrorMessage errorMessage) {
        if (errorMessage != null) {
            this.errorCode = errorMessage.errorCode;
            this.errorMsg = errorMessage.errorMsg;
            this.extraMsg = errorMessage.extraMsg;
            return;
        }
        throw new IllegalArgumentException("errorMessage should not be null");
    }
}
