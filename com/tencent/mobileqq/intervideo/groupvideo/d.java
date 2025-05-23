package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f238207d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f238208e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f238209f;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static d d(String str) {
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.f238207d = jSONObject.getBoolean("canPreload");
            dVar.f238208e = jSONObject.getBoolean("canPreloadFullAPKWhenPatchFailed");
            dVar.f238209f = jSONObject.getBoolean("canPrePatch");
        } catch (Exception e16) {
            QLog.e("GroupVideoConfigData", 1, "parse err" + e16.getMessage());
        }
        return dVar;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f238209f;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f238207d;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f238208e;
    }
}
