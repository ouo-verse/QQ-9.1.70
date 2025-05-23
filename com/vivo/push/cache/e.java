package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.j;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class e extends c<com.vivo.push.model.a> {
    public e(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.c
    protected final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.c
    final String b(String str) throws Exception {
        return new String(j.a(j.a(e()), j.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (c.f387619a) {
            for (T t16 : this.f387620b) {
                if (!TextUtils.isEmpty(t16.a()) && t16.a().equals(str)) {
                    return t16.b();
                }
            }
            return null;
        }
    }

    @Override // com.vivo.push.cache.c
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(",");
            if (split.length >= 2) {
                try {
                    String str3 = split[0];
                    arrayList.add(new com.vivo.push.model.a(str3, trim.substring(str3.length() + 1)));
                } catch (Exception e16) {
                    u.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e16)));
                }
            }
        }
        return arrayList;
    }
}
