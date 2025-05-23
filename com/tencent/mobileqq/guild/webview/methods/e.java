package com.tencent.mobileqq.guild.webview.methods;

import com.google.gson.Gson;
import com.tencent.mobileqq.guild.webview.methods.AddGuildMethod;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/methods/e;", "Lcom/tencent/mobileqq/guild/webview/methods/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "k", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(e this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult != null) {
            try {
                this$0.i(new Gson().toJson(AddGuildMethod.AddGuildResult.fromIpcResult(eIPCResult.data)));
            } catch (Exception e16) {
                this$0.h(e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        com.tencent.mobileqq.guild.util.y.b(com.tencent.mobileqq.guild.ipc.methods.b.class, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.webview.methods.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                e.m(e.this, eIPCResult);
            }
        }, f("guildId"), f("joinSig"), f("sourceId"), f("subSourceId"), Integer.valueOf(d("entranceId")));
        return true;
    }
}
