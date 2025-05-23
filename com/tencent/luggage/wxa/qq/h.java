package com.tencent.luggage.wxa.qq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.ha.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.debug.b f138977a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f138978b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            p0.a(h.this.getContext(), "xweb_debug_info", h.this.f138978b.getText().toString());
            Toast.makeText(h.this.getContext(), "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f", 0).show();
            return true;
        }
    }

    public h(com.tencent.xweb.debug.b bVar) {
        this.f138977a = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.i8j, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.f95875g6);
        this.f138978b = textView;
        textView.setText(x0.a());
        this.f138978b.setOnLongClickListener(new a());
        return inflate;
    }
}
