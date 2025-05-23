package com.qzone.component.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.util.ah;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NetStateCheckBanner extends BasePushBanner {
    private boolean G;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            NetStateCheckBanner.this.setVisibility(8);
            NetStateCheckBanner.this.G = true;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public NetStateCheckBanner(Context context) {
        super(context);
        this.G = false;
    }

    public ImageView A() {
        return this.C;
    }

    public TextView B() {
        return this.f46315m;
    }

    public boolean C() {
        return this.G;
    }

    public View D() {
        return this.D;
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 64;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 1;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        this.f46315m.setText(getResources().getString(R.string.cmb));
        this.C.setVisibility(0);
        this.C.setImageResource(R.drawable.g19);
        this.C.setOnClickListener(new a());
        setVisibility(8);
        setOnClickListener(null);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (ah.a()) {
            z16 = false;
        }
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            this.f46298f = false;
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    public void E() {
        this.G = false;
    }

    public NetStateCheckBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = false;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
    }
}
