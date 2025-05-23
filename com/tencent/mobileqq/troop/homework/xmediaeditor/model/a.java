package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f297402f;

    /* renamed from: g, reason: collision with root package name */
    public String f297403g;

    /* renamed from: h, reason: collision with root package name */
    public int f297404h;

    /* renamed from: i, reason: collision with root package name */
    public int f297405i;

    /* renamed from: j, reason: collision with root package name */
    public String f297406j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f297407k;

    /* renamed from: l, reason: collision with root package name */
    public long f297408l;

    public a(JSONObject jSONObject, String str) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject, (Object) str);
            return;
        }
        this.f297407k = false;
        g(jSONObject);
        this.f297406j = str;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return HttpUtil.isValidUrl(this.f297403g);
    }

    public void g(JSONObject jSONObject) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONObject);
            return;
        }
        this.f297410b = jSONObject;
        this.f297402f = jSONObject.optString("path");
        this.f297403g = jSONObject.optString("url");
        this.f297404h = jSONObject.optInt("time");
        this.f297405i = jSONObject.optInt("size");
        if (TextUtils.isEmpty(this.f297403g)) {
            this.f297417d = 0;
        } else {
            this.f297417d = 3;
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.f297402f = str;
        try {
            this.f297410b.put("path", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f297403g = str;
        try {
            this.f297410b.put("url", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f297403g)) {
            this.f297417d = 0;
        } else {
            this.f297417d = 3;
        }
    }

    public a(String str, String str2, int i3, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        this.f297407k = false;
        this.f297402f = str;
        this.f297403g = str2;
        this.f297404h = i3;
        this.f297405i = i16;
        this.f297406j = str3;
        if (TextUtils.isEmpty(str2)) {
            this.f297417d = 0;
        } else {
            this.f297417d = 3;
        }
        JSONObject jSONObject = new JSONObject();
        this.f297410b = jSONObject;
        try {
            jSONObject.put("type", "voice");
            if (!TextUtils.isEmpty(this.f297402f)) {
                this.f297410b.put("path", this.f297402f);
            }
            if (!TextUtils.isEmpty(this.f297403g)) {
                this.f297410b.put("url", this.f297403g);
            }
            int i17 = this.f297404h;
            if (i17 > 0) {
                this.f297410b.put("time", i17);
            }
            int i18 = this.f297405i;
            if (i18 > 0) {
                this.f297410b.put("size", i18);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
