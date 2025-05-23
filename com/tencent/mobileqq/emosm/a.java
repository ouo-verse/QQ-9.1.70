package com.tencent.mobileqq.emosm;

import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f204137a;

        /* renamed from: b, reason: collision with root package name */
        public int f204138b;

        /* renamed from: c, reason: collision with root package name */
        public int f204139c;

        /* renamed from: d, reason: collision with root package name */
        public int f204140d;

        /* renamed from: e, reason: collision with root package name */
        public int f204141e;

        /* renamed from: f, reason: collision with root package name */
        public String f204142f;

        public b(int i3, int i16, int i17, int i18, int i19, String str) {
            this.f204137a = i3;
            this.f204138b = i16;
            this.f204139c = i17;
            this.f204140d = i18;
            this.f204141e = i19;
            this.f204142f = str;
        }

        public static b b(Bundle bundle) {
            String str;
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            if (bundle != null) {
                int i26 = bundle.getInt("result", -1);
                int i27 = bundle.getInt("realSaveNum", 0);
                int i28 = bundle.getInt("payChannel", -1);
                int i29 = bundle.getInt("payState", -1);
                int i36 = bundle.getInt("provideState", -1);
                str = bundle.getString("message");
                i18 = i36;
                i16 = i28;
                i17 = i29;
                i19 = i27;
                i3 = i26;
            } else {
                str = "";
                i3 = -1;
                i16 = -1;
                i17 = -1;
                i18 = -1;
                i19 = 0;
            }
            return new b(i3, i19, i16, i17, i18, str);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("result", this.f204137a);
            bundle.putInt("realSaveNum", this.f204138b);
            bundle.putInt("payChannel", this.f204139c);
            bundle.putInt("payState", this.f204140d);
            bundle.putInt("provideState", this.f204141e);
            bundle.putString("message", this.f204142f);
            return bundle;
        }
    }

    public static Bundle a(String str, String str2, int i3, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", str);
        bundle2.putString("callbackid", str2);
        bundle2.putInt("respkey", i3);
        bundle2.putBundle(Const.BUNDLE_KEY_REQUEST, bundle);
        return bundle2;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.emosm.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C7495a {

        /* renamed from: a, reason: collision with root package name */
        public String f204123a;

        /* renamed from: b, reason: collision with root package name */
        public String f204124b;

        /* renamed from: c, reason: collision with root package name */
        public String f204125c;

        /* renamed from: d, reason: collision with root package name */
        public String f204126d;

        /* renamed from: e, reason: collision with root package name */
        public String f204127e;

        /* renamed from: f, reason: collision with root package name */
        public String f204128f;

        /* renamed from: g, reason: collision with root package name */
        public String f204129g;

        /* renamed from: h, reason: collision with root package name */
        public String f204130h;

        /* renamed from: i, reason: collision with root package name */
        public String f204131i;

        /* renamed from: j, reason: collision with root package name */
        public String f204132j;

        /* renamed from: k, reason: collision with root package name */
        public String f204133k;

        /* renamed from: l, reason: collision with root package name */
        public String f204134l;

        /* renamed from: m, reason: collision with root package name */
        public String f204135m;

        /* renamed from: n, reason: collision with root package name */
        public String f204136n;

        public C7495a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            this.f204123a = str;
            this.f204124b = str2;
            this.f204125c = str3;
            this.f204126d = str4;
            this.f204127e = str5;
            this.f204128f = str6;
            this.f204129g = str7;
            this.f204130h = str8;
            this.f204131i = str9;
            this.f204132j = str10;
            this.f204136n = str11;
        }

        public static C7495a b(Bundle bundle) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            if (bundle != null) {
                String string = bundle.getString("callbackid");
                String string2 = bundle.getString("appid");
                String string3 = bundle.getString("userId");
                String string4 = bundle.getString("userKey");
                String string5 = bundle.getString("sessionId");
                String string6 = bundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                String string7 = bundle.getString("zoneId");
                String string8 = bundle.getString(AdParam.PF);
                String string9 = bundle.getString("pfKey");
                String string10 = bundle.getString("tokenUrl");
                String string11 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                String string12 = bundle.getString("other");
                String string13 = bundle.getString("payload");
                str14 = bundle.getString("drmInfo");
                str12 = string12;
                str13 = string13;
                str10 = string10;
                str11 = string11;
                str8 = string8;
                str9 = string9;
                str6 = string6;
                str7 = string7;
                str4 = string4;
                str5 = string5;
                str2 = string2;
                str3 = string3;
                str = string;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
                str6 = str5;
                str7 = str6;
                str8 = str7;
                str9 = str8;
                str10 = str9;
                str11 = str10;
                str12 = str11;
                str13 = str12;
                str14 = str13;
            }
            return new C7495a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("callbackid", this.f204123a);
            bundle.putString("appid", this.f204124b);
            bundle.putString("userId", this.f204125c);
            bundle.putString("userKey", this.f204126d);
            bundle.putString("sessionId", this.f204127e);
            bundle.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, this.f204128f);
            bundle.putString("zoneId", this.f204129g);
            bundle.putString(AdParam.PF, this.f204130h);
            bundle.putString("pfKey", this.f204131i);
            bundle.putString("tokenUrl", this.f204132j);
            return bundle;
        }

        public C7495a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.f204123a = str;
            this.f204124b = str2;
            this.f204125c = str3;
            this.f204126d = str4;
            this.f204127e = str5;
            this.f204128f = str6;
            this.f204129g = str7;
            this.f204130h = str8;
            this.f204131i = str9;
            this.f204132j = str10;
            this.f204133k = str11;
            this.f204134l = str12;
            this.f204135m = str13;
            this.f204136n = str14;
        }
    }
}
