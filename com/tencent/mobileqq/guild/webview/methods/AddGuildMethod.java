package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class AddGuildMethod extends a {

    /* compiled from: P */
    @Keep
    /* loaded from: classes14.dex */
    public static class AddGuildResult {

        @SerializedName("actionCode")
        public long actionCode;

        @SerializedName("guildId")
        public String guildId;

        @SerializedName("msg")
        public String message;

        @SerializedName("result")
        public int result;

        @SerializedName("strDetail")
        public String strDetail;

        @SerializedName("strPrompt")
        public String strPrompt;

        public static AddGuildResult fromIpcResult(Bundle bundle) {
            AddGuildResult addGuildResult = new AddGuildResult();
            addGuildResult.result = bundle.getInt("errCode");
            addGuildResult.message = bundle.getString("errMsg");
            addGuildResult.guildId = bundle.getString("guildId");
            addGuildResult.actionCode = bundle.getLong("actionCode");
            addGuildResult.strPrompt = bundle.getString("strPrompt");
            addGuildResult.strDetail = bundle.getString("strDetail");
            return addGuildResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(EIPCResult eIPCResult) {
        try {
            i(new Gson().toJson(AddGuildResult.fromIpcResult(eIPCResult.data)));
        } catch (Exception e16) {
            h(e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("inviteCode", f("inviteCode"));
        bundle.putInt("from", e("from", 246610));
        bundle.putString("sourceId", f("sourceId"));
        bundle.putString("subSourceId", f("subSourceId"));
        bundle.putInt("entranceId", d("entranceId"));
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "addGuild", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.webview.methods.c
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                AddGuildMethod.this.m(eIPCResult);
            }
        });
        return true;
    }
}
