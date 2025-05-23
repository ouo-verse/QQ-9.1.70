package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        String g16 = g("targetTab", "recommend");
        QLog.i("Guild.jump.JS.JumpToGuildDiscoverMeth", 1, "[onInvoke] url=" + str + " targetTab=" + g16);
        com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.ac.class, g16);
        return true;
    }
}
