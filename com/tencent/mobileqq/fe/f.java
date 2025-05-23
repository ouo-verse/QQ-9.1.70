package com.tencent.mobileqq.fe;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.dt.app.Dtc;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static f f205836e;

    /* renamed from: a, reason: collision with root package name */
    private MMKVOptionEntity f205837a;

    /* renamed from: b, reason: collision with root package name */
    private MMKVOptionEntity f205838b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f205839c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f205840d;

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205840d = false;
        try {
            this.f205837a = QMMKV.from(FEKit.getInstance().getContext(), "common_mmkv_configurations");
            this.f205838b = QMMKV.from(FEKit.getInstance().getContext(), "qsec_mmkv_configurations");
            this.f205840d = true;
        } catch (Throwable th5) {
            if (th5 instanceof NoClassDefFoundError) {
                try {
                    this.f205839c = FEKit.getInstance().getContext().getSharedPreferences(Dtc.SP_NAME, 4);
                } catch (Throwable th6) {
                    c.a("FEKit_kv", 1, "FEkv sp instance:" + th6);
                }
            }
            c.a("FEKit_kv", 1, "FEkv instance:" + th5);
        }
    }

    public static f a() {
        if (f205836e == null) {
            synchronized (e.class) {
                if (f205836e == null) {
                    f205836e = new f();
                }
            }
        }
        return f205836e;
    }

    public boolean b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        try {
            if (this.f205840d) {
                return this.f205837a.decodeBool(str, false);
            }
            return this.f205839c.getBoolean(str, false);
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVValue:" + th5);
            return false;
        }
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            if (this.f205840d) {
                this.f205838b.encodeString(str, str2).commitAsync();
            } else {
                this.f205839c.edit().putString(str, str2).apply();
            }
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVSaveValue:" + th5);
        }
    }

    public void d(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        try {
            if (this.f205840d) {
                this.f205838b.encodeBytes(str, bArr);
            } else {
                c.a("FEKit_kv", 1, "no mmkv no sp!!");
            }
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVSaveValue:" + th5);
        }
    }

    public void e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            return;
        }
        try {
            if (this.f205840d) {
                this.f205837a.encodeBool(str, z16).commitAsync();
            } else {
                this.f205839c.edit().putBoolean(str, z16).apply();
            }
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVSaveValue:" + th5);
        }
    }

    public void f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            if (this.f205840d) {
                this.f205837a.encodeString(str, str2).commitAsync();
            } else {
                this.f205839c.edit().putString(str, str2).apply();
            }
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVSaveValue:" + th5);
        }
    }

    public String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        try {
            if (this.f205840d) {
                return this.f205837a.decodeString(str, "");
            }
            return this.f205839c.getString(str, "");
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVValue:" + th5);
            return "";
        }
    }

    public String h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        try {
            if (this.f205840d) {
                return this.f205838b.decodeString(str, "");
            }
            return this.f205839c.getString(str, "");
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVValue:" + th5);
            return "";
        }
    }

    public byte[] i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        try {
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmKVValue:" + th5);
        }
        if (this.f205840d) {
            return this.f205838b.decodeBytes(str, "".getBytes(StandardCharsets.UTF_8));
        }
        c.a("FEKit_kv", 1, "no mmkv no sp!!");
        return "".getBytes(StandardCharsets.UTF_8);
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        try {
            if (this.f205840d) {
                return TextUtils.join("|", this.f205838b.allKeyArr());
            }
            return "";
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmkv removeKeyList:" + th5);
            return "";
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        try {
            if (this.f205840d) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : str.split("\\|")) {
                    arrayList.add(String.valueOf(str2));
                }
                this.f205838b.removeKeyList(arrayList);
            }
        } catch (Throwable th5) {
            c.a("FEKit_kv", 1, "mmkv removeKeyList:" + th5);
        }
    }
}
