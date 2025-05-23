package com.tencent.luggage.wxa.ub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.ml.o;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.ub.a;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f142171a;

    /* renamed from: b, reason: collision with root package name */
    public View f142172b;

    /* renamed from: c, reason: collision with root package name */
    public r f142173c;

    /* renamed from: d, reason: collision with root package name */
    public b f142174d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void onDismiss();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ub.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6794c implements o {
        public C6794c() {
        }

        @Override // com.tencent.luggage.wxa.ml.o
        public void a(m mVar) {
            r rVar = c.this.f142173c;
            if (rVar != null) {
                rVar.a(this);
            }
            c.this.d();
        }
    }

    public c(Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f142171a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hra, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026force_notify_guide, null)");
        this.f142172b = inflate;
        inflate.findViewById(R.id.fcw).setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f142172b.findViewById(R.id.t6f);
        if (l.f126905a.c()) {
            i3 = R.drawable.ouj;
        } else {
            i3 = R.drawable.ouk;
        }
        imageView.setBackgroundResource(i3);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        r rVar = this.f142173c;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    public void d() {
        b bVar = this.f142174d;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        r rVar = this.f142173c;
        if (rVar != null) {
            rVar.b(new C6794c());
        }
        r rVar2 = this.f142173c;
        if (rVar2 != null) {
            rVar2.b(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f142172b;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        r rVar = this.f142173c;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        com.tencent.luggage.wxa.ub.a.f142165a.a(i3, this.f142172b);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        this.f142173c = rVar;
        a.C6791a c6791a = com.tencent.luggage.wxa.ub.a.f142165a;
        Object systemService = this.f142171a.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        c6791a.a(((WindowManager) systemService).getDefaultDisplay().getRotation(), this.f142172b);
    }

    public final void a(b onDismissListener) {
        Intrinsics.checkNotNullParameter(onDismissListener, "onDismissListener");
        this.f142174d = onDismissListener;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
    }
}
