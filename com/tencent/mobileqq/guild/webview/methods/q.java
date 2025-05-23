package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.webview.methods.util.CommentInvokeResult;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.z.class, f("guildId"), Integer.valueOf(d("dialogType")));
        if (g16.isSuccess()) {
            str4 = "OK";
        } else {
            str4 = "\u8df3\u8f6c\u5f02\u5e38 " + g16.code;
        }
        i(CommentInvokeResult.create(g16.code, str4).toJson());
        return true;
    }
}
