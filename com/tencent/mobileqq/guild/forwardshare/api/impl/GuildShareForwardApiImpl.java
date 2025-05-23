package com.tencent.mobileqq.guild.forwardshare.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import st1.h;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildShareForwardApiImpl implements IGuildShareForwardApi {
    private static final String TAG = "GuildShareForwardApiImpl";
    private AppInterface mApp;
    private HashMap<Long, h.a> mLeaveMessageMap = new HashMap<>();
    private n mMessageObserver = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends n {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.message.n
        protected void f(String str, long j3) {
            String str2;
            if (GuildShareForwardApiImpl.this.mLeaveMessageMap != null && GuildShareForwardApiImpl.this.mLeaveMessageMap.containsKey(Long.valueOf(j3))) {
                h.a aVar = (h.a) GuildShareForwardApiImpl.this.mLeaveMessageMap.get(Long.valueOf(j3));
                if (aVar != null) {
                    ((h) GuildShareForwardApiImpl.this.mApp.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).j0(GuildShareForwardApiImpl.this.mApp, aVar);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("uinque:");
                    sb5.append(j3);
                    sb5.append("params:");
                    if (aVar != null) {
                        str2 = aVar.f434701c;
                    } else {
                        str2 = "null";
                    }
                    sb5.append(str2);
                    QLog.i(GuildShareForwardApiImpl.TAG, 2, sb5.toString());
                }
                GuildShareForwardApiImpl.this.mLeaveMessageMap.remove(Long.valueOf(j3));
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi
    public void ShareForwardMsg(String str, String str2, Bundle bundle) {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        h hVar = (h) appInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName());
        h.a aVar = new h.a();
        String string = bundle.getString("detail_url");
        aVar.f434700b = str;
        aVar.f434699a = str2;
        aVar.f434701c = string;
        aVar.f434702d = new ArrayList<>();
        long j06 = hVar.j0(this.mApp, aVar);
        String string2 = bundle.getString(IGuildShareForwardApi.SHARE_LEAVE_MESSAGE);
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        aVar.f434701c = string2;
        this.mLeaveMessageMap.put(Long.valueOf(j06), aVar);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "uinque:" + j06 + "params:" + aVar.f434701c);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            AppInterface appInterface = (AppInterface) appRuntime;
            this.mApp = appInterface;
            appInterface.addObserver(this.mMessageObserver);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.removeObserver(this.mMessageObserver);
        }
    }
}
