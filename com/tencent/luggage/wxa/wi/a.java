package com.tencent.luggage.wxa.wi;

import android.content.Context;
import com.tencent.luggage.wxa.fd.t;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.j4.g;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.vi.b;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6885a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f144248a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144249b;

        public RunnableC6885a(d dVar, String str) {
            this.f144248a = dVar;
            this.f144249b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(this.f144248a.getContext(), this.f144249b, 0).show();
            this.f144248a.getRuntime().D();
        }
    }

    public boolean c(Context context, com.tencent.luggage.wxa.m4.b bVar, String str) {
        if (!t.a(bVar.getRuntime()) && !t.a(str)) {
            return false;
        }
        return true;
    }

    public static CharSequence a(Context context, com.tencent.luggage.wxa.m4.b bVar) {
        if (((g) bVar.a(g.class)).F) {
            return context.getString(R.string.yy_);
        }
        return context.getString(R.string.yyb);
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public void b(Context context, com.tencent.luggage.wxa.m4.b bVar, String str) {
        a(bVar, str, !bVar.getRuntime().j0().F);
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public String a(Context context, com.tencent.luggage.wxa.m4.b bVar, String str) {
        return a(context, bVar).toString();
    }

    public static void a(d dVar, String str, boolean z16) {
        String string;
        t.a(str, z16);
        if (z16) {
            string = dVar.getContext().getResources().getString(R.string.yxm);
        } else {
            string = dVar.getContext().getResources().getString(R.string.yxl);
        }
        c0.a(new RunnableC6885a(dVar, string));
    }
}
