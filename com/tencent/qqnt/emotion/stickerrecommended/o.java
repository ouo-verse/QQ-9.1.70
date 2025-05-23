package com.tencent.qqnt.emotion.stickerrecommended;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.SimpleRemoteEmoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class o extends j {
    static IPatchRedirector $redirector_;
    private String A;
    private int B;
    private String C;
    private a D;
    int E;

    /* renamed from: e, reason: collision with root package name */
    private String f356598e;

    /* renamed from: f, reason: collision with root package name */
    private String f356599f;

    /* renamed from: g, reason: collision with root package name */
    private String f356600g;

    /* renamed from: h, reason: collision with root package name */
    private String f356601h;

    /* renamed from: i, reason: collision with root package name */
    private int f356602i;

    /* renamed from: j, reason: collision with root package name */
    private int f356603j;

    /* renamed from: k, reason: collision with root package name */
    private int f356604k;

    /* renamed from: l, reason: collision with root package name */
    private int f356605l;

    /* renamed from: m, reason: collision with root package name */
    private long f356606m;

    /* renamed from: n, reason: collision with root package name */
    private long f356607n;

    /* renamed from: o, reason: collision with root package name */
    private String f356608o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f356609p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f356610q;

    /* renamed from: r, reason: collision with root package name */
    private int f356611r;

    /* renamed from: s, reason: collision with root package name */
    private String f356612s;

    /* renamed from: t, reason: collision with root package name */
    private String f356613t;

    /* renamed from: u, reason: collision with root package name */
    private String f356614u;

    /* renamed from: v, reason: collision with root package name */
    private int f356615v;

    /* renamed from: w, reason: collision with root package name */
    private int f356616w;

    /* renamed from: x, reason: collision with root package name */
    private String f356617x;

    /* renamed from: y, reason: collision with root package name */
    private String f356618y;

    /* renamed from: z, reason: collision with root package name */
    private String f356619z;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f356620a;

        /* renamed from: b, reason: collision with root package name */
        public String f356621b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f356616w = 0;
            this.E = 0;
        }
    }

    private int A(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)) {
                return ((Integer) jSONObject.get(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)).intValue();
            }
            if (jSONObject.has("actionId")) {
                return ((Integer) jSONObject.get("actionId")).intValue();
            }
            if (!jSONObject.has("id")) {
                return -1;
            }
            return ((Integer) jSONObject.get("id")).intValue();
        } catch (JSONException e16) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getZPlanActionId has exception:", e16);
            return -1;
        } catch (Throwable th5) {
            QLog.e(SimpleRemoteEmoticon.TAG, 1, "getZPlanActionId has exception:", th5);
            return -1;
        }
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f356616w == 3) {
            return true;
        }
        return false;
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            this.f356613t = str;
        }
    }

    public void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.f356610q = z16;
        }
    }

    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
        } else {
            this.B = i3;
        }
    }

    public void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
        } else {
            this.f356609p = z16;
        }
    }

    public void G(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.f356616w = i3;
        }
    }

    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        } else {
            this.f356619z = str;
        }
    }

    public void I(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
        } else {
            this.f356606m = j3;
        }
    }

    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.f356603j = i3;
        }
    }

    public void K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f356600g = str;
        }
    }

    public void L(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f356598e = str;
        }
    }

    public void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f356602i = i3;
        }
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            this.f356611r = i3;
        }
    }

    public void O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f356612s = str;
        }
    }

    public void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f356615v = i3;
        }
    }

    public void Q(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) aVar);
        } else {
            this.D = aVar;
        }
    }

    public void R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            this.A = str;
        }
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void T(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        } else {
            this.f356614u = str;
        }
    }

    public void U(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            this.f356617x = str;
        }
    }

    public void V(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
        } else {
            this.f356607n = j3;
        }
    }

    public void W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.f356605l = i3;
        }
    }

    public void X(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.f356601h = str;
        }
    }

    public void Y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f356599f = str;
        }
    }

    public void Z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f356604k = i3;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return getImgMd5();
    }

    public void a0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        } else {
            this.f356618y = str;
        }
    }

    public void b0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.C = str;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return String.valueOf(this.B);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getClickNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.e
    public int getExposeNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (B()) {
            return "zplan-" + A(this.C);
        }
        return this.f356600g;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getImgUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f356598e;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.j, com.tencent.qqnt.emotion.stickerrecommended.g
    public String getReportEventPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (String) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        if (B()) {
            return "e-";
        }
        return super.getReportEventPrefix();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public String getThumbUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f356599f;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.f356613t;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.B;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isClicked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.f356610q;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.g
    public boolean isExposed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.f356609p;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        if (TextUtils.isEmpty(this.f356608o)) {
            this.f356608o = n.a(w());
        }
        return this.f356608o;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.f356616w;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        if (TextUtils.isEmpty(this.f356599f)) {
            return this.f356603j;
        }
        return this.f356605l;
    }

    public long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return this.f356606m;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return this.f356611r;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f356612s;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f356615v;
    }

    public a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (a) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this.D;
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (String) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        if (TextUtils.isEmpty(this.f356599f)) {
            return this.f356600g;
        }
        return this.f356601h;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.A;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.f356614u;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return "imgUrl=" + this.f356598e + " thumbUrl=" + this.f356599f + " imgMd5=" + this.f356600g + " thumbMd5=" + this.f356601h + " imgWidth=" + this.f356602i + " imgHeight=" + this.f356603j + " thumbWidth=" + this.f356604k + " thumbHeight=" + this.f356605l + " imgFileSize=" + this.f356606m + " thumbFileSize=" + this.f356607n;
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.f356617x;
    }

    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f356601h;
    }

    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        if (TextUtils.isEmpty(this.f356599f)) {
            return this.f356598e;
        }
        return this.f356599f;
    }

    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.f356618y;
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        if (TextUtils.isEmpty(this.f356599f)) {
            return this.f356602i;
        }
        return this.f356604k;
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.C;
    }
}
