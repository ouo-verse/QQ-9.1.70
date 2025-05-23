package com.tencent.luggage.wxa.xi;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ml.i;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.e0;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    public Function f144995a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f144996b;

    /* renamed from: c, reason: collision with root package name */
    public m.a f144997c;

    /* renamed from: d, reason: collision with root package name */
    public DialogInterface.OnCancelListener f144998d;

    /* renamed from: e, reason: collision with root package name */
    public int f144999e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f145000f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f145001g = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f145002a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f145002a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f145002a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f145004a;

        public b(com.tencent.luggage.wxa.ic.g gVar) {
            this.f145004a = gVar;
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            m.a aVar;
            if (!c.this.f145000f && !c.this.f145001g) {
                Context L = this.f145004a.L();
                if (L == null) {
                    L = this.f145004a.F();
                }
                if (c.this.f144995a == null) {
                    aVar = null;
                } else {
                    aVar = (m.a) c.this.f144995a.apply(L);
                }
                if (aVar == null) {
                    aVar = new i(L);
                }
                aVar.setOnCancelListener(c.this.f144998d);
                aVar.setCancelable(true);
                aVar.setCanceledOnTouchOutside(false);
                this.f145004a.N().a(aVar);
                c.this.f144997c = aVar;
                if (c.this.f144999e > 0 && (c.this.f144997c instanceof i)) {
                    ((i) c.this.f144997c).setProgress(c.this.f144999e);
                }
            }
            return false;
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.f145000f = true;
        m.a aVar = this.f144997c;
        if (aVar != null) {
            aVar.cancel();
            return;
        }
        DialogInterface.OnCancelListener onCancelListener = this.f144998d;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.f145001g = true;
        m.a aVar = this.f144997c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void a(Function function) {
        this.f144995a = function;
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        if (!c0.b()) {
            c0.a(new a(gVar));
            return;
        }
        e0 e0Var = new e0(Looper.getMainLooper(), (e0.a) new b(gVar), false);
        this.f144996b = e0Var;
        e0Var.a(500L);
    }

    public c a(DialogInterface.OnCancelListener onCancelListener) {
        this.f144998d = onCancelListener;
        m.a aVar = this.f144997c;
        if (aVar != null) {
            aVar.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    public void a(int i3) {
        int max = Math.max(Math.min(i3, 100), 0);
        this.f144999e = max;
        m.a aVar = this.f144997c;
        if (aVar instanceof i) {
            ((i) aVar).setProgress(max);
        }
    }
}
