package com.tencent.mobileqq.wxmini.impl.plugin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h implements WxaExtendApiJSBridge.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Weixin/Inject_thirdInvoke.yml", version = 14)
    private static final HashMap<String, com.tencent.mobileqq.wxmini.impl.plugin.a> f327746d;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap f327747e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class a extends com.tencent.mobileqq.wxmini.impl.plugin.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void f(@NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject, WxaExtendApiJSBridge.a aVar) {
            JSONObject jSONObject2 = new JSONObject();
            Iterator it = h.f327746d.keySet().iterator();
            while (it.hasNext()) {
                try {
                    jSONObject2.put((String) it.next(), true);
                } catch (JSONException unused) {
                }
            }
            aVar.callback(WxaExtendApiJSBridge.ErrMsg.OK, "", jSONObject2);
        }

        @Override // com.tencent.mobileqq.wxmini.impl.plugin.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.wxmini.impl.plugin.a
        public void c(@NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject, @Nullable WxaExtendApiJSBridge.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, jSONObject, aVar);
            } else {
                f(str, str2, jSONObject, aVar);
            }
        }

        @Override // com.tencent.mobileqq.wxmini.impl.plugin.a
        public void d(@NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject, @Nullable WxaExtendApiJSBridge.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, jSONObject, aVar);
            } else {
                f(str, str2, jSONObject, aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final h f327748a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27548);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f327748a = new h();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        HashMap hashMap = new HashMap();
        f327747e = hashMap;
        hashMap.put("qq_fastLogin", e.class);
        f327747e.put("qq_checkSession", c.class);
        f327747e.put("qq_login", g.class);
        HashMap<String, com.tencent.mobileqq.wxmini.impl.plugin.a> hashMap2 = new HashMap<>();
        f327746d = hashMap2;
        c();
        hashMap2.put("qq_fetchCanUseApi", new a());
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static h b() {
        return b.f327748a;
    }

    @QAutoInitMethod
    private static void c() {
        com.tencent.mobileqq.qroute.utils.b.b(f327747e, f327746d);
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.b
    public void invoke(@NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject, WxaExtendApiJSBridge.a aVar) {
        com.tencent.mobileqq.wxmini.impl.plugin.a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, jSONObject, aVar);
            return;
        }
        QLog.d("WxThirdInvokeHandler", 1, "invoke ", str2, " from: ", str, " with data: ", jSONObject);
        HashMap<String, com.tencent.mobileqq.wxmini.impl.plugin.a> hashMap = f327746d;
        if (hashMap.containsKey(str2)) {
            aVar2 = hashMap.get(str2);
        } else {
            if (("invokeQQ".equals(str2) || "invokeQQTest".equals(str2)) && jSONObject != null) {
                String optString = jSONObject.optString(DTConstants.TAG.API);
                if (hashMap.containsKey(optString)) {
                    aVar2 = hashMap.get(optString);
                }
            }
            aVar2 = null;
        }
        if (aVar2 == null) {
            QLog.d("WxThirdInvokeHandler", 1, "apiName: ", str2, " invoke but handle not found");
        } else {
            aVar2.invoke(str, str2, jSONObject, aVar);
        }
    }
}
