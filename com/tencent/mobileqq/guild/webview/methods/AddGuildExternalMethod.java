package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.webview.methods.AddGuildExternalMethod;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class AddGuildExternalMethod extends com.tencent.mobileqq.guild.webview.methods.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes14.dex */
    public static class AddGuildResult {

        @SerializedName("actionCode")
        public long actionCode;

        @SerializedName("guildId")
        public String guildId;

        @SerializedName("key")
        public String key;

        @SerializedName("msg")
        public String message;

        @SerializedName("result")
        public int result;

        @SerializedName("strDetail")
        public String strDetail;

        @SerializedName("strPrompt")
        public String strPrompt;

        AddGuildResult() {
        }

        public static AddGuildResult fromIpcResult(Bundle bundle) {
            AddGuildResult addGuildResult = new AddGuildResult();
            addGuildResult.result = bundle.getInt("errCode");
            addGuildResult.message = bundle.getString("errMsg");
            addGuildResult.guildId = bundle.getString("key", "");
            addGuildResult.key = bundle.getString("key", "");
            addGuildResult.actionCode = bundle.getLong("actionCode", 0L);
            addGuildResult.strPrompt = bundle.getString("strPrompt", "");
            addGuildResult.strDetail = bundle.getString("strDetail", "");
            return addGuildResult;
        }

        public String toString() {
            return "AddGuildResult{result=" + this.result + ", message='" + this.message + "', guildId='" + this.guildId + "', actionCode=" + this.actionCode + ", strPrompt='" + this.strPrompt + "', strDetail='" + this.strDetail + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(AddGuildResult addGuildResult, IGProSecurityResult iGProSecurityResult) {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(ch.i(), addGuildResult.result, addGuildResult.message, iGProSecurityResult);
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            try {
                final AddGuildResult fromIpcResult = AddGuildResult.fromIpcResult(eIPCResult.data);
                final IGProSecurityResult f16 = SecurityTipHelperKt.f(fromIpcResult.strPrompt, fromIpcResult.strDetail, fromIpcResult.actionCode);
                QLog.d("Guild.jump.JS.AddGuildExternalMethod", 1, "[AddGuildExternalMethod  onInvoke onCallback] " + fromIpcResult);
                if (!com.tencent.mobileqq.guild.channel.joinchannel.h.d(fromIpcResult.result, f16)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.webview.methods.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AddGuildExternalMethod.a.b(AddGuildExternalMethod.AddGuildResult.this, f16);
                        }
                    });
                }
                AddGuildExternalMethod.this.i(new Gson().toJson(fromIpcResult));
            } catch (Exception e16) {
                AddGuildExternalMethod.this.h(e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("inviteCode", f("inviteCode"));
        bundle.putInt("from", e("from", 246610));
        bundle.putString("sourceId", g("sourceId", "share"));
        bundle.putString("subSourceId", g("subSourceId", "others"));
        bundle.putInt("entranceId", e("entranceId", 4));
        bundle.putString("joinGuildSig", f("joinGuildSig"));
        bundle.putString("guildId", f("guildId"));
        bundle.putString("channelId", f("channelId"));
        bundle.putString("detailUrl", f("detailUrl"));
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "addGuildExternal", bundle, new a());
        return true;
    }
}
