package com.tencent.luggage.wxa.pk;

import android.content.Context;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.sc.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6606a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f137619a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f137620b;

        public RunnableC6606a(Context context, boolean z16) {
            this.f137619a = context;
            this.f137620b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string;
            Context context = this.f137619a;
            if (this.f137620b) {
                string = context.getString(R.string.yxj);
            } else {
                string = context.getString(R.string.yxi);
            }
            com.tencent.luggage.wxa.y9.a.makeText(context, string, 0).show();
        }
    }

    public static boolean a(boolean z16, Context context, String str, int i3) {
        try {
            if (z16) {
                if (((b) g.a(b.class)).d(str, i3)) {
                    new com.tencent.luggage.wxa.am.b(context).a(context.getResources().getString(R.string.z1p)).a();
                    return true;
                }
                w.b("MicroMsg.CollectionModifyInteractLogic", "performModify added:true->false for username:%s, type:%d, call return false", str, Integer.valueOf(i3));
                a(context, z16);
            } else {
                int b16 = ((b) g.a(b.class)).b(str, i3);
                if (b16 == 0) {
                    new com.tencent.luggage.wxa.am.b(context).a(context.getResources().getString(R.string.z1o)).a();
                    return true;
                }
                if (b16 == -2) {
                    MMAlertDialog create = new MMAlertDialog.Builder(context).setTitle("").setMsg(context.getResources().getString(R.string.yxy, Integer.valueOf(((b) g.a(b.class)).C()))).setPositiveBtnText(R.string.f1640324q).setCancelable(false).create();
                    if (create != null) {
                        create.setCanceledOnTouchOutside(false);
                        create.setCanBack(true);
                        create.show();
                    }
                } else if (b16 == -3) {
                    MMAlertDialog create2 = new MMAlertDialog.Builder(context).setTitle("").setMsg(R.string.ywm).setPositiveBtnText(R.string.f1640324q).setCancelable(false).create();
                    if (create2 != null) {
                        create2.setCanceledOnTouchOutside(false);
                        create2.setCanBack(true);
                        create2.show();
                    }
                } else {
                    w.b("MicroMsg.CollectionModifyInteractLogic", "performModify added:false->true for username:%s, type:%d, call return %d", str, Integer.valueOf(i3), Integer.valueOf(b16));
                    a(context, z16);
                }
            }
        } catch (Exception e16) {
            w.b("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", str, Integer.valueOf(i3), Boolean.valueOf(z16), e16);
            a(context, z16);
        }
        return false;
    }

    public static void a(Context context, boolean z16) {
        c0.a(new RunnableC6606a(context, z16));
    }
}
