package com.tencent.ams.dynamicwidget.landingpage;

import android.content.Context;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class LandingPageView$downgrade$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LandingPageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LandingPageView$downgrade$1(LandingPageView landingPageView) {
        this.this$0 = landingPageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) landingPageView);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.this$0.viewRenderStartTime = System.currentTimeMillis();
        try {
            final Context context = this.this$0.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            final AdInfo I = this.this$0.I();
            final int x16 = this.this$0.x();
            DefaultLandingPageView defaultLandingPageView = new DefaultLandingPageView(context, I, x16) { // from class: com.tencent.ams.dynamicwidget.landingpage.LandingPageView$downgrade$1$defaultView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(context, I, x16);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, LandingPageView$downgrade$1.this, context, I, Integer.valueOf(x16));
                    }
                }

                @Override // com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView
                public void B(float downX, float downY) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Float.valueOf(downX), Float.valueOf(downY));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("clickArea", 0);
                    LandingPageView$downgrade$1.this.this$0.d(downX, downY, jSONObject);
                }

                @Override // com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView
                public void C(float downX, float downY, int clickArea) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Float.valueOf(downX), Float.valueOf(downY), Integer.valueOf(clickArea));
                    } else {
                        LandingPageView$downgrade$1.this.this$0.c(downX, downY, clickArea);
                    }
                }
            };
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.this$0.z(), "downgrade, attachRealView");
            this.this$0.a(a.f70203f.getModuleId(), this.this$0.I());
            this.this$0.q(defaultLandingPageView);
            this.this$0.e(0);
            LandingPageView landingPageView = this.this$0;
            long currentTimeMillis = System.currentTimeMillis();
            j16 = this.this$0.viewRenderStartTime;
            landingPageView.v(4001066, Long.valueOf(currentTimeMillis - j16));
        } catch (Throwable th5) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.b(this.this$0.z(), "downgrade fail", th5);
            if (com.tencent.ams.dynamicwidget.c.f70185s.j()) {
                LandingPageView landingPageView2 = this.this$0;
                long currentTimeMillis2 = System.currentTimeMillis();
                j3 = this.this$0.viewRenderStartTime;
                landingPageView2.v(4001067, Long.valueOf(currentTimeMillis2 - j3));
            }
        }
    }
}
