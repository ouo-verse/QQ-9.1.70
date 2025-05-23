package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.vivo.push.PushClient;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VUpsManager {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static VUpsManager f387853a = new VUpsManager();
    }

    public static VUpsManager getInstance() {
        return a.f387853a;
    }

    public void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOnPush(new com.vivo.push.ups.a(this, uPSRegisterCallback));
    }

    public void turnOffPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOffPush(new d(this, uPSTurnCallback));
    }

    public void turnOnPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOnPush(new c(this, uPSTurnCallback));
    }

    public void unRegisterToken(Context context, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOffPush(new b(this, uPSRegisterCallback));
    }

    public void onCommandResult(Context context, Bundle bundle) {
    }
}
