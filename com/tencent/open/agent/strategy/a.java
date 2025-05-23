package com.tencent.open.agent.strategy;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    private static Map<String, g> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("action_pay", new i("action_pay"));
        hashMap.put("action_quick_login", new j("action_quick_login"));
        hashMap.put("action_ptlogin_login", new j("action_ptlogin_login"));
        hashMap.put("action_invite", new k("action_invite"));
        hashMap.put("action_gift", new k("action_gift"));
        hashMap.put("action_ask", new k("action_ask"));
        hashMap.put("action_reactive", new k("action_reactive"));
        hashMap.put("action_story", new l("action_story"));
        hashMap.put("action_brag", new d("action_brag"));
        hashMap.put("action_challenge", new e("action_challenge"));
        hashMap.put("action_error", new f("action_error"));
        hashMap.put("action_ark_multi", new b("action_ark_multi"));
        hashMap.put("action_sso_login_by_im_block", new h("action_sso_login_by_im_block"));
        hashMap.put("action_login", new SSOLoginAction("action_login"));
        return hashMap;
    }

    public static g b(String str) {
        Map<String, g> a16 = a();
        if (!a16.containsKey(str)) {
            str = "action_error";
        }
        return a16.get(str);
    }
}
