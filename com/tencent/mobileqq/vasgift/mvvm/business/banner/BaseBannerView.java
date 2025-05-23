package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class BaseBannerView extends RelativeLayout implements e {
    protected b C;
    protected BannerResManager D;
    protected long E;
    protected boolean F;
    protected Runnable G;

    /* renamed from: d, reason: collision with root package name */
    protected HitNumberView f311739d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f311740e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f311741f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f311742h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f311743i;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311744m;

    public BaseBannerView(Context context, BannerResManager bannerResManager) {
        super(context);
        this.E = 0L;
        this.F = false;
        this.G = new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                BaseBannerView baseBannerView = BaseBannerView.this;
                if (baseBannerView.F) {
                    QLog.e("Gift_Banner_BBanner", 1, "delayEndRunnable run but isPlaying");
                } else if (baseBannerView.C != null) {
                    baseBannerView.f311739d.o();
                    BaseBannerView baseBannerView2 = BaseBannerView.this;
                    baseBannerView2.C.g(baseBannerView2.f311744m, baseBannerView2.f311739d.k());
                }
            }
        };
        this.D = bannerResManager;
        LayoutInflater.from(context).inflate(k(), (ViewGroup) this, true);
        l();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void d(int i3) {
        this.f311743i.setImageBitmap(this.f311739d.C.o(i3));
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void f() {
        this.F = true;
        ThreadManager.d(this.G);
    }

    public void i(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, String str) {
        this.f311744m = aVar;
        this.f311740e.setText(aVar.f264919j);
        this.f311741f.setText(aVar.f264921l);
        this.f311742h.setText("\u9001" + j(aVar.f264913d, 3) + "\u7ed9");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String j(String str, int i3) {
        if (!TextUtils.isEmpty(str) && str.length() > 4) {
            return str.substring(0, i3 - 1) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    abstract int k();

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.f311739d = (HitNumberView) findViewById(R.id.fca);
        this.f311740e = (TextView) findViewById(R.id.zr_);
        this.f311741f = (TextView) findViewById(R.id.zr9);
        this.f311742h = (TextView) findViewById(R.id.vph);
        this.f311743i = (ImageView) findViewById(R.id.a7v);
        this.f311739d.setResManager(this.D);
        this.f311739d.setListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.F = false;
        long max = Math.max(3000 - (System.currentTimeMillis() - this.E), 600L);
        QLog.i("Gift_Banner_BBanner", 1, "onEnd need delay:" + max);
        ThreadManager.b(this.G, max);
    }

    public void n(int i3) {
        this.F = true;
        ThreadManager.d(this.G);
        this.E = System.currentTimeMillis();
        this.f311739d.r(i3);
    }

    public void o() {
        ThreadManager.d(this.G);
        this.F = false;
        this.f311739d.p();
    }

    public void setAnimationListener(b bVar) {
        this.C = bVar;
    }

    public void setNum(int i3) {
        this.f311739d.setNum(i3);
    }
}
