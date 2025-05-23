package com.tencent.luggage.wxa.d7;

import android.content.DialogInterface;
import com.tencent.luggage.ui.WxaAlertActivity;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ml.b;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.n3.q;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f124128a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6134a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f124129a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124130b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.d7.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class DialogInterfaceOnClickListenerC6135a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f124131a;

            public DialogInterfaceOnClickListenerC6135a(b bVar) {
                this.f124131a = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f124131a.dismiss();
            }
        }

        public RunnableC6134a(d dVar, String str) {
            this.f124129a = dVar;
            this.f124130b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g runtime = this.f124129a.getRuntime();
            Intrinsics.checkNotNull(runtime);
            r H = runtime.H();
            b bVar = new b(this.f124129a.getContext());
            String str = this.f124130b;
            d dVar = this.f124129a;
            bVar.setMessage(str);
            bVar.setTitle(dVar.getContext().getString(R.string.zvr));
            bVar.setPositiveButton(R.string.f170648xe, new DialogInterfaceOnClickListenerC6135a(bVar));
            bVar.setCanceledOnTouchOutside(false);
            bVar.setCancelable(false);
            H.a(bVar);
        }
    }

    public final void a(d dVar, String str) {
        if (dVar == null) {
            WxaAlertActivity.INSTANCE.a(z.c(), new q.a(z.c().getString(R.string.zvr), str));
        } else {
            h.f146825d.a(new RunnableC6134a(dVar, str));
        }
    }

    public final void a(d dVar, int i3) {
        a(dVar, z.c().getString(i3));
    }
}
