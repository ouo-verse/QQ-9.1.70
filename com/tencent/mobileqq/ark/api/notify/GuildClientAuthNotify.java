package com.tencent.mobileqq.ark.api.notify;

import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuildClientAuthNotify implements g {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f199119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f199120f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f199121h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f199122i;
        final /* synthetic */ GuildClientAuthNotify this$0;

        @Override // java.lang.Runnable
        public void run() {
            ((IGuildClientAuthApi) QRoute.api(IGuildClientAuthApi.class)).openClientAuthorizationDialog(this.f199122i, new GuildClientParams().e0(this.f199118d).l(this.f199119e).b(this.f199120f).c(this.f199121h).l0(4).e());
        }
    }

    public static void a(final String str, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", 0);
            jSONObject.put("arkId", str2);
        } catch (JSONException unused) {
        }
        QLog.i("GuildClientAuthNotify", 1, "sendClientAuthSuccessToArk appName: " + str + " arkId: " + str2);
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread("gpro_bind_app", new Runnable() { // from class: com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify.2
            @Override // java.lang.Runnable
            public void run() {
                ark.arkNotify(str, "", "gpro_bind_app_callback", jSONObject.toString(), ark.ARKMETADATA_JSON);
            }
        });
    }
}
