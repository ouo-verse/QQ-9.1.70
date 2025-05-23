package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.webview.methods.util.CommentInvokeResult;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends a {
    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.k.class, f("guildId"), f("bannerId"));
        if (!g16.isSuccess()) {
            i(CommentInvokeResult.create(g16.code, "\u5237\u65b0\u5f02\u5e38 ").toJson());
            ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).finishWebViewIfExist(this.f235756e.mRuntime.f());
            return true;
        }
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).finishWebViewIfExist(this.f235756e.mRuntime.f());
        return true;
    }
}
