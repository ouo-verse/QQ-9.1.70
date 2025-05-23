package com.tencent.now.pkgame.pkgame.pktimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import mo3.d;

/* loaded from: classes22.dex */
public class PkTimerView extends FrameLayout implements lo3.a {

    /* renamed from: d, reason: collision with root package name */
    private TextView f339026d;

    /* renamed from: e, reason: collision with root package name */
    private View f339027e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.now.pkgame.pkgame.pktimer.b f339028f;

    /* renamed from: h, reason: collision with root package name */
    private LifecycleOwner f339029h;

    /* renamed from: i, reason: collision with root package name */
    private ViewModelProvider f339030i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements Observer<String> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            PkTimerView.this.c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            PkTimerView.this.d(bool);
        }
    }

    public PkTimerView(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        super(context);
        this.f339030i = viewModelProvider;
        this.f339029h = lifecycleOwner;
        b();
        e();
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.haz, this);
        this.f339027e = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.f97355k6);
        this.f339026d = textView;
        RFWTypefaceUtil.setNumberTypeface(textView, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Boolean bool) {
        if (bool.booleanValue()) {
            this.f339026d.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            this.f339026d.setTextColor(-1);
        }
    }

    @Override // lo3.a
    public d J() {
        return this.f339028f;
    }

    public void c(String str) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.f339026d.setText(str);
    }

    public void e() {
        com.tencent.now.pkgame.pkgame.pktimer.b bVar = (com.tencent.now.pkgame.pkgame.pktimer.b) this.f339030i.get(com.tencent.now.pkgame.pkgame.pktimer.b.class);
        this.f339028f = bVar;
        bVar.c2(getContext());
        this.f339028f.W1().observe(this.f339029h, new a());
        this.f339028f.a2().observe(this.f339029h, new b());
    }
}
