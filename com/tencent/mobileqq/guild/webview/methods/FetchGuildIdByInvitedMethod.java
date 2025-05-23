package com.tencent.mobileqq.guild.webview.methods;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FetchGuildIdByInvitedMethod extends com.tencent.mobileqq.guild.webview.methods.a {

    /* compiled from: P */
    @Keep
    /* loaded from: classes14.dex */
    private static class InvokeResult {

        @SerializedName("result")
        public int code;

        @SerializedName("guildId")
        public String guildId;

        @SerializedName("msg")
        public String message;

        InvokeResult() {
        }

        public static InvokeResult create(int i3, String str, String str2) {
            InvokeResult invokeResult = new InvokeResult();
            invokeResult.code = i3;
            invokeResult.message = str;
            invokeResult.guildId = str2;
            return invokeResult;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@NonNull EIPCResult eIPCResult) {
            if (!eIPCResult.isSuccess()) {
                FetchGuildIdByInvitedMethod.this.i(InvokeResult.create(-201, "IPC\u9519\u8bef: " + eIPCResult.code, "").toJson());
                return;
            }
            FetchGuildIdByInvitedMethod.this.i(InvokeResult.create(eIPCResult.data.getInt("errCode"), eIPCResult.data.getString("errMsg"), ((FetchGuildInfoUseCase.GuildInfo) eIPCResult.data.getParcelable("data")).f235311d).toJson());
        }
    }

    private EIPCResultCallback l() {
        return new a();
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        com.tencent.mobileqq.guild.util.y.b(com.tencent.mobileqq.guild.ipc.methods.e.class, l(), f("inviteCode"));
        return true;
    }
}
