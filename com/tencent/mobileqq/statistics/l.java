package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmsp.oaid2.IVendorCallback;
import com.tencent.qmsp.oaid2.VendorManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static SimpleDateFormat f290036k;

    /* renamed from: l, reason: collision with root package name */
    private static l f290037l;

    /* renamed from: a, reason: collision with root package name */
    private String f290038a;

    /* renamed from: b, reason: collision with root package name */
    private String f290039b;

    /* renamed from: c, reason: collision with root package name */
    private String f290040c;

    /* renamed from: d, reason: collision with root package name */
    private String f290041d;

    /* renamed from: e, reason: collision with root package name */
    private String f290042e;

    /* renamed from: f, reason: collision with root package name */
    private String f290043f;

    /* renamed from: g, reason: collision with root package name */
    private String f290044g;

    /* renamed from: h, reason: collision with root package name */
    private String f290045h;

    /* renamed from: i, reason: collision with root package name */
    private String f290046i;

    /* renamed from: j, reason: collision with root package name */
    private String f290047j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IVendorCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f290048a;

        a(Context context) {
            this.f290048a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this, (Object) context);
            }
        }

        @Override // com.tencent.qmsp.oaid2.IVendorCallback
        public void onResult(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                l.this.f290047j = str2;
                QMMKV.from(this.f290048a, "common_mmkv_configurations").encodeString("key_beacon_privacy_info_oaid", str2);
            }
            QLog.d("QQBeaconPrivateInfo", 1, "getOAIDAsync: isEnable: " + z16 + ", aaid: " + str + ", oaid: " + str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f290036k = new SimpleDateFormat(ZPlanBubbleRedDotController.DismissType.TIME_FORMAT, Locale.SIMPLIFIED_CHINESE);
        }
    }

    public l(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f290038a = "";
        this.f290039b = "";
        this.f290040c = "";
        this.f290041d = "";
        this.f290042e = "";
        this.f290043f = "";
        this.f290044g = "";
        this.f290045h = "";
        this.f290046i = "";
        this.f290047j = "";
        p();
        q(context);
        o(context);
        QLog.d("QQBeaconPrivateInfo", 1, "QQBeaconPrivateInfo init is success");
    }

    public static l f(Context context) {
        if (f290037l == null) {
            synchronized (l.class) {
                if (f290037l == null) {
                    f290037l = new l(context);
                }
            }
        }
        return f290037l;
    }

    private void j(Context context) {
        if (!r(context)) {
            QLog.d("QQBeaconPrivateInfo", 1, "getOAIDAsync not call");
        } else {
            new VendorManager().getVendorInfo(context, new a(context));
        }
    }

    private String k(Context context) {
        return QMMKV.from(context, "common_mmkv_configurations").decodeString("key_beacon_privacy_info_oaid", "");
    }

    private void o(Context context) {
        String string = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        if (string != null) {
            this.f290038a = string.toLowerCase();
        }
    }

    private void p() {
        this.f290043f = DeviceInfoMonitor.getModel();
    }

    private void q(Context context) {
        j(context);
        this.f290047j = k(context);
        QLog.d("QQBeaconPrivateInfo", 1, "[initOAID] obtain oaid: " + this.f290047j);
    }

    private boolean r(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        long decodeLong = from.decodeLong("key_oaid_last_update_time", 0L);
        QLog.d("QQBeaconPrivateInfo", 1, "lastTime: " + f290036k.format(new Date(decodeLong)) + " currTime: " + f290036k.format(new Date(currentTimeMillis)));
        if (currentTimeMillis >= decodeLong && currentTimeMillis - decodeLong < 86400000) {
            QLog.d("QQBeaconPrivateInfo", 1, "Obtain the current interval of OAID less then MAX_TIME");
            return false;
        }
        from.encodeLong("key_oaid_last_update_time", currentTimeMillis);
        QLog.d("QQBeaconPrivateInfo", 1, "update Last get OAID time");
        return true;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f290038a;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f290039b;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f290040c;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f290041d;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f290044g;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f290042e;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f290043f;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f290047j;
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f290045h;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f290046i;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "QQBeaconPrivateInfo{androidID='" + this.f290038a + "', imei='" + this.f290039b + "', imei2='" + this.f290040c + "', imsi='" + this.f290041d + "', meid='" + this.f290042e + "', model='" + this.f290043f + "', mac='" + this.f290044g + "', wifiMacAddress='" + this.f290045h + "', wifiSSID='" + this.f290046i + "', oaid='" + this.f290047j + "'}";
    }
}
