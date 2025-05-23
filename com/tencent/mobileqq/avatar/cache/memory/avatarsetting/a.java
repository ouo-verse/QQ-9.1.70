package com.tencent.mobileqq.avatar.cache.memory.avatarsetting;

import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements w91.a<Setting> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.cache.api.collection.a<String, Setting> f199946a;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f199946a = new com.tencent.cache.api.collection.a<>(Business.Setting, "avatarSetting", i3 <= 0 ? 2000 : i3);
        }
    }

    @Override // w91.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Setting get(String str) {
        com.tencent.cache.api.collection.a<String, Setting> aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Setting) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (aVar = this.f199946a) != null) {
            return aVar.e(str);
        }
        return null;
    }

    @Override // w91.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) setting)).booleanValue();
        }
        com.tencent.cache.api.collection.a<String, Setting> aVar = this.f199946a;
        if (aVar != null) {
            aVar.f(str, setting);
            return true;
        }
        return false;
    }

    @Override // w91.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Setting setting, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, setting, Byte.valueOf(b16))).booleanValue();
        }
        return put(str, setting);
    }

    @Override // w91.a
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.cache.api.collection.a<String, Setting> aVar = this.f199946a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // w91.a
    public void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        com.tencent.cache.api.collection.a<String, Setting> aVar = this.f199946a;
        if (aVar != null) {
            aVar.g(str);
        }
    }
}
