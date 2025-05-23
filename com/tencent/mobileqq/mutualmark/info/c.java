package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f252085a;

    /* renamed from: b, reason: collision with root package name */
    public long f252086b;

    /* renamed from: c, reason: collision with root package name */
    public float f252087c;

    /* renamed from: d, reason: collision with root package name */
    public long f252088d;

    /* renamed from: e, reason: collision with root package name */
    public long f252089e;

    /* renamed from: f, reason: collision with root package name */
    public long f252090f;

    /* renamed from: g, reason: collision with root package name */
    public long f252091g;

    /* renamed from: h, reason: collision with root package name */
    public long f252092h;

    /* renamed from: i, reason: collision with root package name */
    public long f252093i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f252094j;

    /* renamed from: k, reason: collision with root package name */
    public long f252095k;

    /* renamed from: l, reason: collision with root package name */
    public int f252096l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f252097m;

    /* renamed from: n, reason: collision with root package name */
    public int f252098n;

    /* renamed from: o, reason: collision with root package name */
    public String f252099o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f252100p;

    /* renamed from: q, reason: collision with root package name */
    public int f252101q;

    /* renamed from: r, reason: collision with root package name */
    public String f252102r;

    /* renamed from: s, reason: collision with root package name */
    public String f252103s;

    /* renamed from: t, reason: collision with root package name */
    public String f252104t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f252105u;

    /* renamed from: v, reason: collision with root package name */
    public String f252106v;

    /* renamed from: w, reason: collision with root package name */
    public int f252107w;

    /* renamed from: x, reason: collision with root package name */
    public String f252108x;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252096l = 0;
        this.f252097m = false;
        this.f252098n = 999;
        this.f252103s = "";
        this.f252104t = "";
        this.f252105u = false;
        this.f252106v = "";
    }

    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        if (d() || e()) {
            return 0.4f;
        }
        return 1.0f;
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        this.f252085a = dVar.f252109a;
        this.f252086b = dVar.f252110b;
        this.f252087c = dVar.f252111c;
        this.f252088d = dVar.f252112d;
        this.f252089e = dVar.f252113e;
        this.f252090f = dVar.f252114f;
        this.f252091g = dVar.f252115g;
        this.f252092h = dVar.f252116h;
        this.f252093i = dVar.f252117i;
        this.f252094j = dVar.f252122n;
        this.f252095k = dVar.f252123o;
        this.f252106v = dVar.f252124p;
        this.f252107w = dVar.f252125q;
        this.f252108x = dVar.f252127s;
        this.f252103s = dVar.f252118j;
        this.f252102r = dVar.f252119k;
        this.f252104t = dVar.f252120l;
        this.f252105u = dVar.f252121m;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f252100p && TextUtils.isEmpty(this.f252103s)) {
            return false;
        }
        if (this.f252101q == 0 && TextUtils.isEmpty(this.f252103s) && TextUtils.isEmpty(this.f252106v)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f252091g == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        long j3 = this.f252085a;
        if (j3 == 12 || com.tencent.mobileqq.activity.aio.intimate.e.e(j3) || this.f252091g != 2 || NetConnInfoCenter.getServerTimeMillis() >= this.f252092h * 1000) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "MutualMarkForDisplayInfo{type=" + this.f252085a + ", level=" + this.f252086b + ", count=" + this.f252087c + ", continue_days=" + this.f252088d + ", last_action_time=" + this.f252089e + ", last_change_time=" + this.f252090f + ", icon_status=" + this.f252091g + ", icon_status_end_time=" + this.f252092h + ", sub_level=" + this.f252093i + ", hasRemindInContact=" + this.f252094j + ", remindAnimStartTime=" + this.f252095k + ", sortKeyForNormal=" + this.f252096l + ", isInAIOTitleLeft2=" + this.f252097m + ", sortKeyForAIOTitle=" + this.f252098n + ", name='" + this.f252099o + "', disableLocalResource=" + this.f252100p + ", iconResId=" + this.f252101q + ", iconApngUrl='" + this.f252102r + "', icon_static_url='" + this.f252103s + "', icon_name='" + this.f252104t + "', user_close_flag=" + this.f252105u + "}";
    }
}
