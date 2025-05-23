package com.tencent.imsdk.message;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    private int atAll;
    private String atUserID;

    public String getAtUserID() {
        if (this.atAll != 0) {
            this.atUserID = "__kImSDK_MesssageAtALL__";
        }
        return this.atUserID;
    }

    public void setAtUserID(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("__kImSDK_MesssageAtALL__")) {
            this.atAll = 1;
        } else {
            this.atUserID = str;
        }
    }
}
