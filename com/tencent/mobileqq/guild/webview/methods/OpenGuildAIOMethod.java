package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.ipc.methods.as;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class OpenGuildAIOMethod extends a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes14.dex */
    public static class InvokeResult {

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

    private String m(EIPCResult eIPCResult) {
        Bundle bundle = eIPCResult.data;
        if (bundle == null) {
            return "";
        }
        return bundle.getString("msg", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(EIPCResult eIPCResult) {
        if (eIPCResult.isSuccess()) {
            i(InvokeResult.create(0, "OK").toJson());
            return;
        }
        String m3 = m(eIPCResult);
        i(InvokeResult.create(eIPCResult.code, "\u8df3\u8f6c\u5931\u8d25 " + m3).toJson());
    }

    private EIPCResultCallback o() {
        return new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.webview.methods.s
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                OpenGuildAIOMethod.this.n(eIPCResult);
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        com.tencent.mobileqq.guild.util.y.b(as.class, o(), g("key", f("guildId")), f("packageId"));
        return true;
    }
}
