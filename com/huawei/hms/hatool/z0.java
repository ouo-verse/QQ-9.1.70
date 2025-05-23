package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class z0 {

    /* renamed from: a, reason: collision with root package name */
    private String f37246a;

    /* renamed from: b, reason: collision with root package name */
    public l1 f37247b;

    public z0(String str) {
        this.f37246a = str;
        this.f37247b = new l1(str);
        s.c().a(this.f37246a, this.f37247b);
    }

    private s0 b(int i3) {
        if (i3 == 0) {
            return this.f37247b.c();
        }
        if (i3 == 1) {
            return this.f37247b.b();
        }
        if (i3 == 2) {
            return this.f37247b.d();
        }
        if (i3 != 3) {
            return null;
        }
        return this.f37247b.a();
    }

    private boolean c(int i3) {
        String str;
        if (i3 == 2) {
            if ("_default_config_tag".equals(this.f37246a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        } else {
            s0 b16 = b(i3);
            if (b16 != null && !TextUtils.isEmpty(b16.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i3;
        }
        v.e("hmsSdk", str);
        return false;
    }

    public void a(int i3) {
        v.d("hmsSdk", "onReport. TAG: " + this.f37246a + ", TYPE: " + i3);
        g0.a().a(this.f37246a, i3);
    }

    public void a(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onEvent. TAG: " + this.f37246a + ", TYPE: " + i3 + ", eventId : " + str);
        if (e1.a(str) || !c(i3)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f37246a + ", TYPE: " + i3);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f37246a + ", TYPE: " + i3);
            linkedHashMap = null;
        }
        g0.a().a(this.f37246a, i3, str, linkedHashMap);
    }

    public void b(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.f37246a + ", TYPE: " + i3 + ", eventId : " + str);
        if (e1.a(str) || !c(i3)) {
            v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f37246a + ", TYPE: " + i3);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f37246a + ", TYPE: " + i3);
            linkedHashMap = null;
        }
        g0.a().b(this.f37246a, i3, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.f37246a + ", eventId : " + str);
        if (context == null) {
            v.e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (e1.a(str) || !c(0)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f37246a);
            return;
        }
        if (!e1.a("value", str2, 65536)) {
            v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f37246a);
            str2 = "";
        }
        g0.a().a(this.f37246a, context, str, str2);
    }

    public void b(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f37246a);
        if (s0Var != null) {
            this.f37247b.b(s0Var);
        } else {
            this.f37247b.b(null);
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    public void a(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f37246a);
        if (s0Var != null) {
            this.f37247b.a(s0Var);
        } else {
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f37247b.a((s0) null);
        }
    }
}
