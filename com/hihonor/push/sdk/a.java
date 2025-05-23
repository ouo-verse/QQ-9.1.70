package com.hihonor.push.sdk;

import android.util.Log;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements k0<HonorPushDataMsg> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorMessageService f36351a;

    public a(HonorMessageService honorMessageService) {
        this.f36351a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<HonorPushDataMsg> a1Var) {
        if (a1Var.e()) {
            HonorPushDataMsg c16 = a1Var.c();
            if (c16 != null) {
                Log.i("HonorMessageService", "onMessageReceived. msgId is " + c16.getMsgId());
                this.f36351a.onMessageReceived(c16);
                return;
            }
            Log.i("HonorMessageService", "parse remote data failed.");
            return;
        }
        boolean z16 = a1Var.b() instanceof JSONException;
    }
}
