package com.tencent.luggage.wxa.sf;

import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: m, reason: collision with root package name */
    public static long f140346m = -1;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f140349b;

    /* renamed from: c, reason: collision with root package name */
    public int f140350c;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.tf.a f140355h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.tf.b f140356i;

    /* renamed from: j, reason: collision with root package name */
    public ResultReceiver f140357j;

    /* renamed from: k, reason: collision with root package name */
    public HostApduService f140358k;

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f140345l = {0, 0};

    /* renamed from: n, reason: collision with root package name */
    public static b f140347n = new b();

    /* renamed from: a, reason: collision with root package name */
    public String f140348a = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f140351d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f140352e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f140353f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f140354g = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6718b implements com.tencent.luggage.wxa.tf.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.sf.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", Integer.valueOf(b.this.f140350c), Boolean.valueOf(b.this.f140352e));
                b.this.f140354g = true;
                b.this.a(b.f140345l, true, b.this.f140358k);
            }
        }

        public C6718b() {
        }

        @Override // com.tencent.luggage.wxa.tf.a
        public void a(String str, String str2) {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", str, str2);
            if (!w0.c(str) && !w0.c(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_apdu_command", str2);
                b.this.a(str, 31, bundle);
                b.this.f140352e = true;
                if (!b.this.f140353f) {
                    b.this.f140353f = true;
                    b.this.f140354g = false;
                    long unused = b.f140346m = System.currentTimeMillis();
                    l.a().b(new a(), b.this.f140350c);
                    return;
                }
                if (b.this.f140354g) {
                    w.f("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
                    b.this.a(b.f140345l, true, b.this.f140358k);
                    b.this.f140354g = false;
                    return;
                }
                return;
            }
            w.b("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
        }

        @Override // com.tencent.luggage.wxa.tf.a
        public void b(String str, String str2) {
            if (b.this.f140348a != null && b.this.f140348a.equals(str) && !w0.c(str2)) {
                byte[] decode = Base64.decode(str2, 2);
                w.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", str, str2, com.tencent.luggage.wxa.sf.c.a(decode), Boolean.valueOf(b.this.f140352e));
                b bVar = b.this;
                bVar.a(decode, false, bVar.f140358k);
                return;
            }
            w.b("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", b.this.f140348a, str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.tf.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.tf.b
        public void b() {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
        }

        @Override // com.tencent.luggage.wxa.tf.b
        public void onDestroy() {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
        }

        @Override // com.tencent.luggage.wxa.tf.b
        public void onPause() {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
            b.this.c();
            b.this.f140351d = true;
        }

        @Override // com.tencent.luggage.wxa.tf.b
        public void onResume() {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (b.this.f140351d) {
                b.this.b();
                b.this.f140351d = false;
            }
        }
    }

    public b() {
        this.f140355h = new C6718b();
        this.f140356i = new c();
    }

    public void b(boolean z16) {
        this.f140353f = z16;
    }

    public void c(boolean z16) {
        this.f140351d = z16;
    }

    public void d(boolean z16) {
        this.f140354g = z16;
    }

    public void b() {
        HostApduService hostApduService;
        if (this.f140349b != null && (hostApduService = this.f140358k) != null) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(hostApduService);
            if (defaultAdapter == null) {
                w.b("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
                return;
            }
            CardEmulation cardEmulation = CardEmulation.getInstance(defaultAdapter);
            if (cardEmulation != null) {
                try {
                    HostApduService hostApduService2 = this.f140358k;
                    ComponentName componentName = new ComponentName(hostApduService2, hostApduService2.getClass());
                    boolean registerAidsForService = cardEmulation.registerAidsForService(componentName, "payment", this.f140349b);
                    w.d("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", Boolean.valueOf(registerAidsForService));
                    if (registerAidsForService) {
                        a(true);
                        List<String> aidsForService = cardEmulation.getAidsForService(componentName, "payment");
                        if (aidsForService == null || aidsForService.size() <= 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < aidsForService.size(); i3++) {
                            w.b("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + aidsForService.get(i3));
                        }
                        return;
                    }
                    a(false);
                    return;
                } catch (Exception e16) {
                    w.a("MicroMsg.HCEServiceMgr", e16, "alvinluo HCEService register aid exception", new Object[0]);
                    a(false);
                    return;
                }
            }
            return;
        }
        w.b("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
    }

    public void c() {
        CardEmulation cardEmulation;
        HostApduService hostApduService = this.f140358k;
        if (hostApduService == null) {
            w.b("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(hostApduService);
        if (defaultAdapter == null || (cardEmulation = CardEmulation.getInstance(defaultAdapter)) == null) {
            return;
        }
        HostApduService hostApduService2 = this.f140358k;
        ComponentName componentName = new ComponentName(hostApduService2, hostApduService2.getClass());
        w.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
        cardEmulation.removeAidsForService(componentName, "payment");
    }

    public void a(HostApduService hostApduService, ResultReceiver resultReceiver) {
        w.d("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
        this.f140358k = hostApduService;
        this.f140357j = resultReceiver;
    }

    public void a(String str, ArrayList arrayList) {
        this.f140348a = str;
        this.f140349b = arrayList;
    }

    public void a(int i3, String str, Bundle bundle) {
        w.d("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", Integer.valueOf(i3));
        if (i3 == 13) {
            c();
            HostApduService hostApduService = this.f140358k;
            if (hostApduService != null) {
                hostApduService.stopSelf();
                return;
            }
            return;
        }
        if (i3 == 31) {
            if (this.f140355h != null) {
                this.f140355h.a(str, bundle.getString("key_apdu_command"));
                return;
            }
            return;
        }
        if (i3 != 32) {
            switch (i3) {
                case 21:
                    com.tencent.luggage.wxa.tf.b bVar = this.f140356i;
                    if (bVar != null) {
                        bVar.b();
                        return;
                    }
                    return;
                case 22:
                    com.tencent.luggage.wxa.tf.b bVar2 = this.f140356i;
                    if (bVar2 != null) {
                        bVar2.onResume();
                        return;
                    }
                    return;
                case 23:
                    com.tencent.luggage.wxa.tf.b bVar3 = this.f140356i;
                    if (bVar3 != null) {
                        bVar3.onPause();
                        return;
                    }
                    return;
                case 24:
                    com.tencent.luggage.wxa.tf.b bVar4 = this.f140356i;
                    if (bVar4 != null) {
                        bVar4.onDestroy();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if (this.f140355h != null) {
            this.f140355h.b(str, bundle.getString("key_apdu_command"));
        }
    }

    public void a(boolean z16) {
        Bundle bundle = new Bundle();
        if (z16) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", TVKEventId.PLAYER_STATE_VIDEO_POST_PROCESS_INFO);
            bundle.putString("errMsg", "register aids failed");
        }
        a(this.f140348a, 12, bundle);
    }

    public void a(String str, int i3, Bundle bundle) {
        bundle.putString("key_appid", str);
        bundle.putInt("key_event_type", i3);
        a(bundle);
    }

    public void a(Intent intent) {
        int intExtra = intent.getIntExtra("key_time_limit", 1500);
        this.f140350c = intExtra;
        if (intExtra < 1500) {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", Integer.valueOf(intExtra), 1500);
            this.f140350c = 1500;
        }
        int i3 = this.f140350c;
        if (i3 > 60000) {
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", Integer.valueOf(i3), 60000);
            this.f140350c = 60000;
        }
        w.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", Integer.valueOf(this.f140350c));
    }

    public final synchronized void a(byte[] bArr, boolean z16, HostApduService hostApduService) {
        w.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", Boolean.valueOf(z16), Boolean.valueOf(this.f140352e));
        if (this.f140352e) {
            this.f140352e = false;
            long currentTimeMillis = System.currentTimeMillis();
            w.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send response command time: %d, cost: %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - f140346m));
            if (hostApduService != null) {
                hostApduService.sendResponseApdu(bArr);
            } else {
                w.b("MicroMsg.HCEServiceMgr", "alvinluo sendResponseCommandToSystem hceService is null");
            }
            if (z16) {
                com.tencent.luggage.wxa.tf.c.a(this.f140348a);
            }
        }
    }

    public void a(Bundle bundle) {
        w.d("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
        ResultReceiver resultReceiver = this.f140357j;
        if (resultReceiver != null) {
            resultReceiver.send(10002, bundle);
        }
    }
}
