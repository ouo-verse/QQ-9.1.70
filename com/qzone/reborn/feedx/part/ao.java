package com.qzone.reborn.feedx.part;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.qzone.component.banner.NetStateCheckBanner;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ao extends g {

    /* renamed from: d, reason: collision with root package name */
    NetStateCheckBanner f55013d = null;

    /* renamed from: e, reason: collision with root package name */
    private gf.n f55014e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ao.this.E9(bool.booleanValue());
        }
    }

    private void D9() {
        ((tc.e) getViewModel(tc.e.class)).f435819i.observe(getHostFragment(), new a());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        this.f55014e = (gf.n) getIocInterface(gf.n.class);
        D9();
    }

    protected void E9(boolean z16) {
        if (!z16) {
            if (this.f55013d == null && this.f55014e.d()) {
                this.f55013d = (NetStateCheckBanner) this.f55014e.e(1);
            }
            NetStateCheckBanner netStateCheckBanner = this.f55013d;
            if (netStateCheckBanner == null || netStateCheckBanner.l() || this.f55013d.C()) {
                return;
            }
            NetStateCheckBanner netStateCheckBanner2 = this.f55013d;
            netStateCheckBanner2.f46298f = true;
            netStateCheckBanner2.c();
            return;
        }
        NetStateCheckBanner netStateCheckBanner3 = this.f55013d;
        if (netStateCheckBanner3 != null) {
            netStateCheckBanner3.E();
            if (this.f55013d.l()) {
                this.f55013d.g();
            }
        }
    }
}
