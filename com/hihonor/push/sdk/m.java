package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f36410a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f36411b;

    public m(s sVar, boolean z16) {
        this.f36411b = sVar;
        this.f36410a = z16;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f36411b.f36428b.getClass();
        try {
            e1 e1Var = new e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            e1Var.f36383e = b.a();
            String pushToken = ((PushTokenResult) b.a(z.f36460c.a(e1Var))).getPushToken();
            if (this.f36410a) {
                s sVar = this.f36411b;
                sVar.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(CGNonAgeReport.EVENT_TYPE, DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    g0 g0Var = new g0();
                    Context context = sVar.f36427a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        g0Var.f36388c = applicationContext;
                        g0Var.f36387b = bundle;
                        if (applicationContext.bindService(intent, g0Var, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e16) {
                        e16.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e17) {
            throw b.a(e17);
        }
    }
}
