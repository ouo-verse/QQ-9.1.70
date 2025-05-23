package com.tencent.mobileqq.unitedconfig_android;

import androidx.annotation.NonNull;
import com.tencent.freesia.CustomRuleBridge;
import com.tencent.freesia.KV;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements CustomRuleBridge {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/UnitedConfig-sdk/Inject_rule_provider.yml", version = 1)
    public static ArrayList<Class<? extends f>> f306032a;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<f> f306033b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends f>> arrayList = new ArrayList<>();
        f306032a = arrayList;
        arrayList.add(InnerRuleProvider.class);
        f306033b = new ArrayList<>();
        Iterator<Class<? extends f>> it = f306032a.iterator();
        while (it.hasNext()) {
            try {
                f306033b.add(it.next().newInstance());
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e("CustomRuleBridgeImpl", 1, e16, new Object[0]);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.CustomRuleBridge
    @NonNull
    public ArrayList<KV> getCustomRules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<KV> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<f> it = f306033b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            for (Map.Entry<String, String> entry : next.a().entrySet()) {
                if (!a.g() && hashMap.containsKey(entry.getKey())) {
                    throw new IllegalArgumentException("duplicate key: " + entry.getKey() + ", from " + ((f) hashMap.get(entry.getKey())).getClass().getSimpleName() + " and " + next.getClass().getSimpleName());
                }
                arrayList.add(new KV(entry.getKey(), entry.getValue()));
                if (!a.g()) {
                    hashMap.put(entry.getKey(), next);
                }
            }
        }
        return arrayList;
    }
}
