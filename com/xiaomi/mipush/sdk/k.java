package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.s;
import com.xiaomi.push.ed;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, s.a> f388067a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Long> f388068b = new HashMap();

    public static void a(Context context, hg hgVar) {
        ArrayList arrayList;
        s.a aVar;
        String c16 = hgVar.c();
        if (hgVar.a() == 0 && (aVar = f388067a.get(c16)) != null) {
            aVar.e(hgVar.f389297e, hgVar.f389298f);
            s.c(context).h(c16, aVar);
        }
        if (!TextUtils.isEmpty(hgVar.f389297e)) {
            arrayList = new ArrayList();
            arrayList.add(hgVar.f389297e);
        } else {
            arrayList = null;
        }
        p.a(ed.COMMAND_REGISTER.f24710a, arrayList, hgVar.f24828a, hgVar.f389296d, null, null);
    }

    public static void b(Context context, hm hmVar) {
        p.a(ed.COMMAND_UNREGISTER.f24710a, null, hmVar.f389357a, hmVar.f389360d, null, null);
        hmVar.a();
    }
}
