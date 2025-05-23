package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APIabResult {
    String mMessage;
    int mResponse;

    public APIabResult(int i3, String str) {
        this.mResponse = i3;
        if (str != null && str.trim().length() != 0) {
            this.mMessage = str + " (response: " + getResponseDesc(i3) + ")";
            return;
        }
        this.mMessage = getResponseDesc(i3);
    }

    public static String getResponseDesc(int i3) {
        return "";
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getResponse() {
        return this.mResponse;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public boolean isPendig() {
        if (this.mResponse == 101) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.mResponse == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "IabResult: " + getMessage();
    }
}
