package com.tencent.luggage.wxa.t9;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.tfd.sdk.wxa.ITuringDID;
import com.tencent.tfd.sdk.wxa.ITuringDeviceInfoProvider;
import com.tencent.tfd.sdk.wxa.ITuringPkgProvider;
import com.tencent.tfd.sdk.wxa.ITuringPrivacyPolicy;
import com.tencent.tfd.sdk.wxa.TuringIDService;
import com.tencent.tfd.sdk.wxa.TuringSDK;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static f0 f141170a = f0.e("OAIDService");

    /* renamed from: b, reason: collision with root package name */
    public static boolean f141171b = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ITuringPkgProvider {
        @Override // com.tencent.tfd.sdk.wxa.ITuringPkgProvider
        public List getPkgs() {
            return new ArrayList(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ITuringDeviceInfoProvider {
        @Override // com.tencent.tfd.sdk.wxa.ITuringDeviceInfoProvider
        public String getAndroidId() {
            return l.b();
        }

        @Override // com.tencent.tfd.sdk.wxa.ITuringDeviceInfoProvider
        public String getImei() {
            return null;
        }

        @Override // com.tencent.tfd.sdk.wxa.ITuringDeviceInfoProvider
        public String getImsi() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ITuringPrivacyPolicy {
        @Override // com.tencent.tfd.sdk.wxa.ITuringPrivacyPolicy, com.tencent.tfd.sdk.wxa.Csynchronized
        public boolean userAgreement() {
            return true;
        }
    }

    public static synchronized boolean a(String str) {
        synchronized (v.class) {
            if (!f141171b) {
                f141171b = true;
                com.tencent.luggage.wxa.aa.h.g("108168wxa");
                com.tencent.luggage.wxa.tn.w.d("OAIDService", "Turing VersionInfo: %s, uniqueId: %s init: %d", TuringSDK.getVersionInfo(), str, Integer.valueOf(TuringSDK.createConf(com.tencent.luggage.wxa.tn.z.c(), new c()).channel(0).turingDeviceInfoProvider(new b()).turingPkgProvider(new a()).uniqueId(str).build().init()));
                ITuringDID turingDID = TuringIDService.getTuringDID(com.tencent.luggage.wxa.tn.z.c());
                if (turingDID.getErrorCode() != 0) {
                    com.tencent.luggage.wxa.tn.w.b("OAIDService", "getOAID fail: %d", Integer.valueOf(turingDID.getErrorCode()));
                    return false;
                }
                String aIDTicket = turingDID.getAIDTicket();
                com.tencent.luggage.wxa.tn.w.d("OAIDService", "getOAID success: %s", aIDTicket);
                f141170a.putString("OAIDService#OAID", aIDTicket).commit();
            }
            return true;
        }
    }

    public static String b() {
        return f141170a.getString("OAIDService#OAID", "");
    }

    public static void c(String str) {
        f141171b = true;
        f141170a.putString("OAIDService#OAID", str).commit();
    }

    public static void b(String str) {
        f141170a.putString("OAIDService#AID_TICKET", str);
    }

    public static String a() {
        return f141170a.getString("OAIDService#AID_TICKET", "");
    }
}
