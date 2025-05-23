package com.tencent.luggage.wxa.qq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.ha.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.debug.b f138974a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f138975b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            p0.a(g.this.getContext(), "xweb_debug_info", g.this.f138975b.getText().toString());
            Toast.makeText(g.this.getContext(), "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f", 0).show();
            return true;
        }
    }

    public g(com.tencent.xweb.debug.b bVar) {
        this.f138974a = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.i8i, viewGroup, false);
        this.f138975b = (TextView) inflate.findViewById(R.id.f95865g5);
        this.f138975b.setText(n.b(this.f138974a.d()) + "\n" + n.a(this.f138974a.d()) + "\n" + m.b());
        this.f138975b.setOnLongClickListener(new a());
        return inflate;
    }
}
