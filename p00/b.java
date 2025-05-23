package p00;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.o;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements p00.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q00.c f424856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f424857b;

        a(q00.c cVar, Context context) {
            this.f424856a = cVar;
            this.f424857b = context;
        }

        @Override // p00.a
        public void a(String str) {
            c.e(this.f424856a);
            b.g(1);
            b.d(this.f424857b, str);
        }

        @Override // p00.a
        public void b() {
            c.c(this.f424856a);
            b.g(2);
        }
    }

    public static void c(Context context, q00.b bVar, q00.c cVar) {
        x.j("WSOpenWeiShiHelper", "checkIfNeedShowOpenWeiShiDialog() " + bVar);
        if (context == null || bVar == null || cVar == null) {
            return;
        }
        String i3 = ai.i("key_last_open_ws_action", "");
        q00.a a16 = q00.a.a(i3);
        x.j("WSOpenWeiShiHelper", "checkIfNeedShowOpenWeiShiDialog() lastActionSpString = " + i3);
        if (a16.d() != 0 && a16.c() != 0) {
            long a17 = o.a();
            int d16 = a16.d();
            if (d16 != 1) {
                if (d16 == 2 && f(a17, a16.c(), bVar.b())) {
                    h(context, bVar, cVar);
                    return;
                }
                return;
            }
            if (f(a17, a16.c(), bVar.e())) {
                h(context, bVar, cVar);
                return;
            } else {
                d(context, bVar.f());
                return;
            }
        }
        h(context, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        x.j("WSOpenWeiShiHelper", "directOpenWeiShi()");
        ao.e(context, "biz_src_jc_gzh_weishi", str);
    }

    public static p00.a e(Context context, q00.c cVar) {
        return new a(cVar, context);
    }

    private static boolean f(long j3, long j16, int i3) {
        boolean z16 = j3 >= o.b(i3) + j16;
        x.j("WSOpenWeiShiHelper", "isExpire() result = " + z16 + ", curTime = " + j3 + ", lastTime = " + j16 + ", validityPeriodDay = " + i3);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i3) {
        x.j("WSOpenWeiShiHelper", "saveActionToSp() type = " + i3);
        ai.p("key_last_open_ws_action", q00.a.b(i3, o.a()));
    }

    public static void h(Context context, q00.b bVar, q00.c cVar) {
        x.j("WSOpenWeiShiHelper", "showTipsDialog()");
        d dVar = new d(context);
        dVar.a(bVar);
        dVar.m(e(context, cVar));
        dVar.show();
        c.d(cVar);
    }
}
