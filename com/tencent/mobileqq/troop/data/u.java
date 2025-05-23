package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$Player;

/* compiled from: P */
/* loaded from: classes19.dex */
public class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f294993a;

    /* renamed from: b, reason: collision with root package name */
    public long f294994b;

    /* renamed from: c, reason: collision with root package name */
    public int f294995c;

    /* renamed from: d, reason: collision with root package name */
    public int f294996d;

    /* renamed from: e, reason: collision with root package name */
    public String f294997e;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(str));
            this.f294993a = jSONObject.optLong("uin");
            this.f294994b = jSONObject.optLong("time");
            this.f294995c = jSONObject.optInt("amount");
            this.f294996d = jSONObject.optInt("index");
            this.f294997e = jSONObject.optString("tips");
        } catch (JSONException e16) {
            QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, getClass().getSimpleName() + " fromJson error. e=" + e16);
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uin", this.f294993a);
            jSONObject.put("time", this.f294994b);
            jSONObject.put("amount", this.f294995c);
            jSONObject.put("index", this.f294996d);
            jSONObject.put("tips", this.f294997e);
        } catch (JSONException e16) {
            QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, getClass().getSimpleName() + " toJson error. e=" + e16);
        }
        return jSONObject.toString();
    }

    public u(long j3, long j16, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.f294993a = j3;
        this.f294994b = j16;
        this.f294995c = i3;
        this.f294996d = i16;
        this.f294997e = str;
    }

    public u(oidb_0x6c2$Player oidb_0x6c2_player) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x6c2_player);
            return;
        }
        this.f294993a = oidb_0x6c2_player.uint64_uin.get();
        this.f294994b = oidb_0x6c2_player.uint64_time.get();
        this.f294995c = oidb_0x6c2_player.int32_amount.get();
        this.f294996d = oidb_0x6c2_player.int32_index.get();
        this.f294997e = oidb_0x6c2_player.bytes_tips.get().toStringUtf8();
    }
}
