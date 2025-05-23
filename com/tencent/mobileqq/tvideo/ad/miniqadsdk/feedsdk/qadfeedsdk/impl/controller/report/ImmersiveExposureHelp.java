package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure;
import pw2.g;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ImmersiveExposureHelp {

    /* renamed from: a, reason: collision with root package name */
    private Context f304142a;

    /* renamed from: b, reason: collision with root package name */
    private View f304143b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f304144c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f304145d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f304146e = new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report.ImmersiveExposureHelp.1
        @Override // java.lang.Runnable
        public void run() {
            n.e("ImmersiveExposureHelp", "Runnable check AdValidExposure ,mIsCellVisible:" + ImmersiveExposureHelp.this.f304144c);
            if (ImmersiveExposureHelp.this.f304144c) {
                ImmersiveExposureHelp.this.e();
            }
        }
    };

    public ImmersiveExposureHelp(Context context, View view) {
        this.f304143b = view;
        this.f304142a = context;
    }

    private boolean c() {
        if (this.f304145d != 0 && System.currentTimeMillis() - this.f304145d >= 1000 && !this.f304144c) {
            return true;
        }
        n.e("ImmersiveExposureHelp", "canValidExposure false,time < 1000ms");
        return false;
    }

    private void d() {
        QAdExposure.i(this.f304143b, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        QAdExposure.k(this.f304143b, true, null);
    }

    private void f() {
        this.f304145d = System.currentTimeMillis();
        g.c(this.f304146e);
        g.b(this.f304146e, 1000L);
    }

    public void g() {
        f();
    }

    public void h() {
        f();
    }

    public void i(boolean z16) {
        this.f304144c = z16;
        if (!z16) {
            j();
            return;
        }
        d();
        if (c()) {
            e();
        }
    }

    protected void j() {
        n.e("ImmersiveExposureHelp", "onSwitchBackground remove mCheckAdValidExposureRunnable");
        this.f304145d = 0L;
        g.c(this.f304146e);
    }

    public void k(View view) {
        this.f304143b = view;
    }

    public void l() {
        this.f304144c = false;
        this.f304145d = 0L;
    }
}
