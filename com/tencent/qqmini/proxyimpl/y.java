package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.mobileqq.mini.guild.JoinGuildHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.GuildProxy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class y implements GuildProxy {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AsyncResult asyncResult, boolean z16, String str) {
        JSONObject jSONObject = new JSONObject();
        QLog.e("GuildProxyImpl", 2, "joinGuild\uff1a " + z16 + ",msg = " + str);
        if (!z16) {
            try {
                jSONObject.put("err_msg", str);
            } catch (Exception e16) {
                QLog.e("GuildProxyImpl", 2, "joinGuildHelper.joinGuild exception = " + e16);
            }
        }
        if (asyncResult != null) {
            asyncResult.onReceiveResult(z16, jSONObject);
        } else {
            QLog.e("GuildProxyImpl", 2, "asyncResult is null");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.GuildProxy
    public void jumpToJoinGuild(String str, String str2, final AsyncResult asyncResult, Context context) {
        new JoinGuildHelper().joinGuild(str, str2, new JoinGuildHelper.ResultCallback() { // from class: com.tencent.qqmini.proxyimpl.x
            @Override // com.tencent.mobileqq.mini.guild.JoinGuildHelper.ResultCallback
            public final void onResult(boolean z16, String str3) {
                y.b(AsyncResult.this, z16, str3);
            }
        }, context);
    }
}
