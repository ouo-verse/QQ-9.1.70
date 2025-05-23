package com.tencent.mobileqq.guild.webview.methods.util;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* compiled from: P */
@Keep
/* loaded from: classes14.dex */
public class CommentInvokeResult {

    @SerializedName("errorMsg")
    public String errorMsg;

    @SerializedName("retCode")
    public int retCode;

    public static CommentInvokeResult create(int i3, String str) {
        CommentInvokeResult commentInvokeResult = new CommentInvokeResult();
        commentInvokeResult.retCode = i3;
        commentInvokeResult.errorMsg = str;
        return commentInvokeResult;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
