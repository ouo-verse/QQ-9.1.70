package com.tencent.open.agent.auth.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f340161a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f340162b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f340163c;

    public h(Context context) {
        this.f340161a = lq3.b.a(context, "accountList");
        this.f340162b = lq3.b.a(context, "uin_openid_store");
        this.f340163c = lq3.b.a(context, "openid_encrytoken");
    }

    @Override // com.tencent.open.agent.auth.model.c
    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f340162b.edit();
        edit.putString(str, str3);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            edit.putString(str2 + ":" + str3, str);
            edit.commit();
        }
    }

    @Override // com.tencent.open.agent.auth.model.c
    public void b(String str) {
        SharedPreferences.Editor edit = this.f340161a.edit();
        edit.putString("last_account", str);
        String[] strArr = null;
        String string = this.f340161a.getString("accList", null);
        if (string != null) {
            strArr = string.split(",");
        }
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        arrayList.remove(str);
        arrayList.add(str);
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb5.append(",");
            sb5.append(str3);
        }
        edit.putString("accList", sb5.toString());
        edit.commit();
    }

    @Override // com.tencent.open.agent.auth.model.c
    public void c(String str, String str2) {
        if (str != null && str2 != null) {
            SharedPreferences.Editor edit = this.f340163c.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
