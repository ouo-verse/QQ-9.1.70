package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.ipc.methods.ah;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

/* loaded from: classes14.dex */
public class OpenGuildPageByInvitedMethod extends a {

    @Keep
    /* loaded from: classes14.dex */
    private static class InvokeResult {

        @SerializedName("result")
        public int code;

        @SerializedName("msg")
        public String message;

        InvokeResult() {
        }

        public static InvokeResult create(int i3, String str) {
            InvokeResult invokeResult = new InvokeResult();
            invokeResult.code = i3;
            invokeResult.message = str;
            return invokeResult;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).finishWebViewIfExist(this.f235756e.mRuntime.f());
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        EIPCResult g16 = com.tencent.mobileqq.guild.util.y.g(ah.class, f("inviteCode"), Integer.valueOf(d("from")), f("contentID"), f("appChannel"), f("pginSource"));
        if (g16.isSuccess()) {
            str4 = "OK";
        } else {
            str4 = "\u8df3\u8f6c\u5f02\u5e38 " + g16.code;
        }
        i(InvokeResult.create(g16.code, str4).toJson());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.webview.methods.y
            @Override // java.lang.Runnable
            public final void run() {
                OpenGuildPageByInvitedMethod.this.m();
            }
        }, 400L);
        return true;
    }
}
