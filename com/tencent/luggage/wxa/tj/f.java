package com.tencent.luggage.wxa.tj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.ml.o;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f141487a;

    /* renamed from: b, reason: collision with root package name */
    public View f141488b;

    /* renamed from: c, reason: collision with root package name */
    public r f141489c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            f.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements o {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ml.o
        public void a(m mVar) {
            r rVar = f.this.f141489c;
            if (rVar != null) {
                rVar.a(this);
            }
            f.this.d();
        }
    }

    public f(Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f141487a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dz5, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026_tip_bottom_dialog, null)");
        this.f141488b = inflate;
        inflate.findViewById(R.id.fcw).setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f141488b.findViewById(R.id.t6f);
        if (l.f126905a.c()) {
            i3 = R.raw.f169276b7;
        } else {
            i3 = R.raw.f169277b8;
        }
        imageView.setBackgroundResource(i3);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        r rVar = this.f141489c;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        r rVar = this.f141489c;
        if (rVar != null) {
            rVar.b(new b());
        }
        r rVar2 = this.f141489c;
        if (rVar2 != null) {
            rVar2.b(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f141488b;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        r rVar = this.f141489c;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        this.f141489c = rVar;
    }

    public void d() {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
    }
}
