package com.tencent.upgrade.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static c f383892c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f383893a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f383894b;

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383893a = null;
            this.f383894b = null;
        }
    }

    public static c b() {
        if (f383892c == null) {
            synchronized (c.class) {
                if (f383892c == null) {
                    f383892c = new c();
                }
            }
        }
        return f383892c;
    }

    private Object c(String str, Object obj) {
        String string = this.f383893a.getString(str, "");
        try {
            return new Gson().fromJson(string, (Class) obj.getClass());
        } catch (JsonSyntaxException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.tencent.upgrade.storage.d
    public synchronized void a(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, obj);
            return;
        }
        if (this.f383894b == null) {
            this.f383894b = this.f383893a.edit();
        }
        String simpleName = obj.getClass().getSimpleName();
        if (Entry.DATA_TYPE_STRING.equals(simpleName)) {
            this.f383894b.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            this.f383894b.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            this.f383894b.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            this.f383894b.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            this.f383894b.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Serializable) {
            this.f383894b.putString(str, new Gson().toJson(obj));
        } else {
            throw new IllegalArgumentException(obj.getClass().getName() + " \u5fc5\u987b\u5b9e\u73b0Serializable\u63a5\u53e3!");
        }
        this.f383894b.commit();
    }

    public void d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.f383893a = context.getSharedPreferences(context.getPackageName(), 0);
        }
    }

    @Override // com.tencent.upgrade.storage.d
    public Object getParam(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, obj);
        }
        if (obj != null) {
            String simpleName = obj.getClass().getSimpleName();
            if (Entry.DATA_TYPE_STRING.equals(simpleName)) {
                return this.f383893a.getString(str, (String) obj);
            }
            if ("Integer".equals(simpleName)) {
                return Integer.valueOf(this.f383893a.getInt(str, ((Integer) obj).intValue()));
            }
            if ("Boolean".equals(simpleName)) {
                return Boolean.valueOf(this.f383893a.getBoolean(str, ((Boolean) obj).booleanValue()));
            }
            if ("Float".equals(simpleName)) {
                return Float.valueOf(this.f383893a.getFloat(str, ((Float) obj).floatValue()));
            }
            if ("Long".equals(simpleName)) {
                return Long.valueOf(this.f383893a.getLong(str, ((Long) obj).longValue()));
            }
            return c(str, obj);
        }
        throw new IllegalArgumentException("\u9ed8\u8ba4\u503c\u4e0d\u80fd\u4e3anull!");
    }

    @Override // com.tencent.upgrade.storage.d
    public synchronized void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.f383894b == null) {
            this.f383894b = this.f383893a.edit();
        }
        this.f383894b.remove(str);
        this.f383894b.commit();
    }
}
