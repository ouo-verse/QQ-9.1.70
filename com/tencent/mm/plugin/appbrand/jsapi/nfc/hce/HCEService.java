package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.wxa.sf.b;
import com.tencent.luggage.wxa.sf.c;
import com.tencent.luggage.wxa.tn.w;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes9.dex */
public class HCEService extends HostApduService {

    /* renamed from: a, reason: collision with root package name */
    public String f152144a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        w.d("MicroMsg.HCEService", "alvinluo HCEService onCreate");
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i3) {
        w.d("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", Integer.valueOf(i3));
        b.f140347n.b(false);
        b.f140347n.d(false);
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i3);
        b.f140347n.a(this.f152144a, 41, bundle);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        b.f140347n.c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        w.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        w.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", Long.valueOf(currentTimeMillis));
        if (intent == null) {
            return super.onStartCommand(intent, i3, i16);
        }
        try {
            b.f140347n.a(this, (ResultReceiver) intent.getParcelableExtra("HCE_Result_Receiver"));
            this.f152144a = intent.getStringExtra("key_appid");
            b.f140347n.a(intent);
            b.f140347n.a(this.f152144a, intent.getStringArrayListExtra("key_aid_list"));
            b.f140347n.b();
            b.f140347n.c(false);
            long currentTimeMillis2 = System.currentTimeMillis();
            w.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        } catch (Exception e16) {
            w.a("MicroMsg.HCEService", e16, "under dos attack(?): invalid key_result_receiver", new Object[0]);
        }
        return super.onStartCommand(intent, i3, i16);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        w.d("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", c.a(bArr));
        byte[] encode = Base64.encode(bArr, 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_apdu_command", new String(encode, StandardCharsets.UTF_8));
        b.f140347n.a(31, this.f152144a, bundle2);
        return null;
    }
}
