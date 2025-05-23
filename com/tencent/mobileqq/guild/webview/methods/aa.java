package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class aa extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        Bundle bundle = new Bundle();
        String g16 = g("url", "");
        QLog.d("Guild.jump.JS.OpenGuildShareURLMethod", 1, "[onInvoke] shareUrl = " + g16);
        if (TextUtils.isEmpty(g16.trim())) {
            QLog.d("Guild.jump.JS.OpenGuildShareURLMethod", 1, "[onInvoke] shareUrl is empty");
            return true;
        }
        bundle.putString("url", g16);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "openGuildShareURL", bundle, null);
        return true;
    }
}
