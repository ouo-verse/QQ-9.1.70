package com.qzone.component.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.util.CreditLevelMonitor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CreditAppealBanner extends Banner {

    /* renamed from: h, reason: collision with root package name */
    private CellTextView f46327h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f46328i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f46329m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CreditAppealBanner.this.g();
            CreditLevelMonitor.c().a(CreditAppealBanner.this.getContext(), false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CreditAppealBanner.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CreditAppealBanner(Context context) {
        super(context);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 256;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 6;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        LayoutInflater.from(getContext()).inflate(R.layout.bjm, (ViewGroup) this, true);
        this.f46327h = (CellTextView) findViewById(R.id.a5d);
        this.f46328i = (TextView) findViewById(R.id.a5g);
        this.f46329m = (ImageView) findViewById(R.id.a5b);
        a aVar = new a();
        b bVar = new b();
        this.f46328i.setOnClickListener(aVar);
        this.f46329m.setOnClickListener(bVar);
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            if (z16) {
                this.f46298f = false;
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (!this.f46297e || aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.f47119c)) {
            this.f46327h.setText(aVar.f47119c);
        }
        this.f46298f = true;
        c();
    }

    public CreditAppealBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
