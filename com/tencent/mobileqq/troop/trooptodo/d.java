package com.tencent.mobileqq.troop.trooptodo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$InfoValue;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f301773a;

    /* renamed from: b, reason: collision with root package name */
    private a f301774b;

    /* renamed from: c, reason: collision with root package name */
    private String f301775c;

    /* renamed from: d, reason: collision with root package name */
    private String f301776d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private b f301777e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f301778a;

        /* renamed from: b, reason: collision with root package name */
        public String f301779b;

        public a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f301778a = str;
                this.f301779b = str2;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "Person{personUin='" + this.f301778a + "', personNickName='" + this.f301779b + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f301780a;

        /* renamed from: b, reason: collision with root package name */
        public long f301781b;

        /* renamed from: c, reason: collision with root package name */
        public long f301782c;

        /* renamed from: d, reason: collision with root package name */
        public int f301783d;

        /* renamed from: e, reason: collision with root package name */
        public String f301784e;

        /* renamed from: f, reason: collision with root package name */
        public int f301785f;

        /* renamed from: g, reason: collision with root package name */
        public String f301786g;

        /* renamed from: h, reason: collision with root package name */
        public long f301787h;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f301783d = -1;
            this.f301784e = "";
            this.f301785f = 0;
            this.f301786g = "";
            this.f301787h = -1L;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "RawInfo{groupCode=" + this.f301780a + ", seq=" + this.f301781b + ", random=" + this.f301782c + ", taskStatus=" + this.f301783d + ", jumpUrl='" + this.f301784e + "', messageType=" + this.f301785f + ", appName='" + this.f301786g + "', appId=" + this.f301787h + '}';
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f301773a = -1;
        this.f301774b = new a("", "");
        this.f301775c = "";
        this.f301776d = "";
        this.f301777e = new b();
    }

    public static d a(oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i3) {
        d dVar = new d();
        dVar.f301775c = oidb_0xf8e_infovalue.title.get();
        dVar.f301774b = new a(String.valueOf(oidb_0xf8e_infovalue.uin.get()), oidb_0xf8e_infovalue.nickname.get());
        dVar.f301776d = oidb_0xf8e_infovalue.icon_url.get();
        b c16 = dVar.c();
        c16.f301780a = oidb_0xf8e_infovalue.group_code.get();
        c16.f301781b = oidb_0xf8e_infovalue.seq.get();
        c16.f301782c = oidb_0xf8e_infovalue.random.get();
        c16.f301783d = i3;
        c16.f301786g = oidb_0xf8e_infovalue.app_name.get();
        c16.f301785f = oidb_0xf8e_infovalue.msg_type.get();
        c16.f301787h = oidb_0xf8e_infovalue.appid.get();
        String str = oidb_0xf8e_infovalue.jump_url.get();
        if (TextUtils.isEmpty(str)) {
            dVar.f301773a = 1;
        } else {
            c16.f301784e = str;
            dVar.f301773a = 2;
        }
        return dVar;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f301775c;
    }

    @NotNull
    public b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f301777e;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f301773a;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopToDoBannerModel{type=" + this.f301773a + ", person=" + this.f301774b + ", content='" + this.f301775c + "', imageUrl='" + this.f301776d + "', rawInfo=" + this.f301777e + '}';
    }
}
