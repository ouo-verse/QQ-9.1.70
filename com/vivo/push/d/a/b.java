package com.vivo.push.d.a;

import android.text.TextUtils;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<b> f387627a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f387628b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.vivo.push.d.b> f387629c;

    /* renamed from: d, reason: collision with root package name */
    private int f387630d;

    public b(String str, List<com.vivo.push.d.b> list, int i3) {
        new ArrayList();
        this.f387628b = str;
        this.f387630d = i3;
        this.f387629c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f387628b);
        aVar.a(this.f387630d);
        aVar.a(this.f387629c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.d.b> it = this.f387629c.iterator();
        while (it.hasNext()) {
            String b16 = it.next().b();
            if (!TextUtils.isEmpty(b16)) {
                arrayList.add(b16);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f387629c = new ArrayList();
        this.f387628b = aVar.c();
        this.f387630d = aVar.a();
        aVar.a(com.vivo.push.d.b.f387631a, this.f387629c);
    }
}
