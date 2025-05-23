package com.tencent.luggage.wxa.v3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.luggage.wxa.tn.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f143119a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f143120b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143121c;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f143122d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!l.this.f143121c) {
                l lVar = l.this;
                Dialog dialog = (Dialog) lVar.f143119a.invoke();
                dialog.show();
                lVar.f143122d = dialog;
            }
        }
    }

    public l(Function0 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f143119a = factory;
        this.f143120b = new b0(Looper.getMainLooper());
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        Dialog dialog = this.f143122d;
        if (dialog != null) {
            dialog.cancel();
        }
        dismiss();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.f143121c = true;
        this.f143120b.a((Object) null);
        Dialog dialog = this.f143122d;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public final void show() {
        this.f143120b.a(new a(), 500L);
    }
}
