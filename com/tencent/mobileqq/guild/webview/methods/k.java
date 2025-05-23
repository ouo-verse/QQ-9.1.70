package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.webview.methods.util.CommentInvokeResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.jump.JS.GuildUpdateGlobalNoticeMethod", 2, String.format("onInvoke: %s, pkgName: %s, method: %s, guild: %s", str, str2, str3, f("guildId")));
        }
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.l.class, f("guildId"));
        if (!g16.isSuccess()) {
            i(CommentInvokeResult.create(g16.code, "\u5237\u65b0\u5f02\u5e38 ").toJson());
        }
        return true;
    }
}
