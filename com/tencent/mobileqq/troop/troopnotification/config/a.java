package com.tencent.mobileqq.troop.troopnotification.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f300652a;

    /* renamed from: b, reason: collision with root package name */
    public int f300653b;

    /* renamed from: c, reason: collision with root package name */
    public long f300654c;

    /* renamed from: d, reason: collision with root package name */
    public int f300655d;

    /* renamed from: e, reason: collision with root package name */
    public int f300656e;

    /* renamed from: f, reason: collision with root package name */
    public long f300657f;

    /* renamed from: g, reason: collision with root package name */
    public int f300658g;

    /* renamed from: h, reason: collision with root package name */
    public int f300659h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    private void a() {
        this.f300652a = true;
        this.f300653b = 100;
        this.f300654c = 60L;
        this.f300655d = 100;
        this.f300656e = 10;
        this.f300657f = 1209600L;
        this.f300658g = 300;
        this.f300659h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a b(String str) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        JSONException jSONException;
        long j3;
        int i26;
        int i27;
        long j16;
        JSONObject jSONObject;
        boolean z16 = true;
        QLog.d("TroopNotificationConfig.config", 1, "onUpdate, newConf = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long j17 = 0;
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("globalOpen", 0);
        } catch (JSONException e16) {
            e = e16;
            i3 = 0;
            i16 = 0;
        }
        try {
            i27 = jSONObject.optInt("totalRemindCntOfOneWeak", 0);
        } catch (JSONException e17) {
            e = e17;
            i16 = 0;
            i17 = i16;
            i18 = i17;
            i19 = i18;
            jSONException = e;
            j3 = 0;
            jSONException.printStackTrace();
            long j18 = j3;
            i26 = 0;
            i27 = i16;
            j16 = j17;
            j17 = j18;
            a aVar = new a();
            if (i3 != 1) {
            }
            aVar.f300652a = z16;
            aVar.f300653b = i27;
            aVar.f300654c = j16;
            aVar.f300655d = i17;
            aVar.f300656e = i18;
            aVar.f300657f = j17;
            aVar.f300658g = i19;
            aVar.f300659h = i26;
            return aVar;
        }
        try {
            j16 = jSONObject.optLong("intervelShowTime", 0L);
            try {
                i17 = jSONObject.optInt("totalRemindCntOfOneDay");
            } catch (JSONException e18) {
                e = e18;
                i17 = 0;
                i18 = 0;
            }
            try {
                i18 = jSONObject.optInt("todoGroupVerifyMsgLevel", 0);
                try {
                    j17 = jSONObject.optLong("cleanExpiredTime", 0L);
                    i19 = jSONObject.optInt("maxFetchMsgCnt", 300);
                } catch (JSONException e19) {
                    e = e19;
                    i19 = 0;
                }
            } catch (JSONException e26) {
                e = e26;
                i18 = 0;
                i19 = i18;
                jSONException = e;
                i16 = i27;
                j3 = j17;
                j17 = j16;
                jSONException.printStackTrace();
                long j182 = j3;
                i26 = 0;
                i27 = i16;
                j16 = j17;
                j17 = j182;
                a aVar2 = new a();
                if (i3 != 1) {
                }
                aVar2.f300652a = z16;
                aVar2.f300653b = i27;
                aVar2.f300654c = j16;
                aVar2.f300655d = i17;
                aVar2.f300656e = i18;
                aVar2.f300657f = j17;
                aVar2.f300658g = i19;
                aVar2.f300659h = i26;
                return aVar2;
            }
        } catch (JSONException e27) {
            i17 = 0;
            i18 = 0;
            i19 = 0;
            jSONException = e27;
            i16 = i27;
            j3 = 0;
            jSONException.printStackTrace();
            long j1822 = j3;
            i26 = 0;
            i27 = i16;
            j16 = j17;
            j17 = j1822;
            a aVar22 = new a();
            if (i3 != 1) {
            }
            aVar22.f300652a = z16;
            aVar22.f300653b = i27;
            aVar22.f300654c = j16;
            aVar22.f300655d = i17;
            aVar22.f300656e = i18;
            aVar22.f300657f = j17;
            aVar22.f300658g = i19;
            aVar22.f300659h = i26;
            return aVar22;
        }
        try {
            i26 = jSONObject.optInt("showUnreadBk", 0);
        } catch (JSONException e28) {
            e = e28;
            jSONException = e;
            i16 = i27;
            j3 = j17;
            j17 = j16;
            jSONException.printStackTrace();
            long j18222 = j3;
            i26 = 0;
            i27 = i16;
            j16 = j17;
            j17 = j18222;
            a aVar222 = new a();
            if (i3 != 1) {
            }
            aVar222.f300652a = z16;
            aVar222.f300653b = i27;
            aVar222.f300654c = j16;
            aVar222.f300655d = i17;
            aVar222.f300656e = i18;
            aVar222.f300657f = j17;
            aVar222.f300658g = i19;
            aVar222.f300659h = i26;
            return aVar222;
        }
        a aVar2222 = new a();
        if (i3 != 1) {
            z16 = false;
        }
        aVar2222.f300652a = z16;
        aVar2222.f300653b = i27;
        aVar2222.f300654c = j16;
        aVar2222.f300655d = i17;
        aVar2222.f300656e = i18;
        aVar2222.f300657f = j17;
        aVar2222.f300658g = i19;
        aVar2222.f300659h = i26;
        return aVar2222;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopNotificationConfig{isGlobalOpen=" + this.f300652a + ", totalRemindCntOfOneWeak=" + this.f300653b + ", intervelShowTime=" + this.f300654c + ", totalRemindCntOfOneDay=" + this.f300655d + ", todoGroupVerifyMsgLevel=" + this.f300656e + ", cleanExpiredTime=" + this.f300657f + ", maxFetchMsgCnt=" + this.f300658g + ", showUnreadBk=" + this.f300659h + '}';
    }
}
