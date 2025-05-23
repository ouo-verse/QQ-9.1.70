package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.methods.ak;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ac extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        com.tencent.mobileqq.guild.util.y.g(ak.class, f("guildId"), Boolean.valueOf(b("openStandalone")), f("backUrl"), f("dialogTitle"));
        return true;
    }
}
