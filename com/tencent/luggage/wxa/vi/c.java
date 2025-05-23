package com.tencent.luggage.wxa.vi;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.vi.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List f143494a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f143495a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f143496b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f143497c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f143498d;

        public a(List list, Context context, v vVar, String str) {
            this.f143495a = list;
            this.f143496b = context;
            this.f143497c = vVar;
            this.f143498d = str;
        }

        @Override // com.tencent.luggage.wxa.vi.d.b
        public void a(View view, int i3) {
            ((b) this.f143495a.get(i3)).b(this.f143496b, this.f143497c, this.f143498d);
        }
    }

    public void a(b bVar) {
        this.f143494a.add(bVar);
    }

    public void a(Context context, v vVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.f143494a.size(); i3++) {
            b bVar = (b) this.f143494a.get(i3);
            if (bVar.c(context, vVar, str)) {
                arrayList.add(bVar.a(context, vVar, str));
                arrayList2.add(bVar);
            }
        }
        d.a(context, vVar.d() || vVar.L0(), arrayList, str2, vVar.D(), new a(arrayList2, context, vVar, str));
    }
}
