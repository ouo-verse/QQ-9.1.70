package com.tencent.ams.xsad.rewarded;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.ams.xsad.rewarded.view.RewardedAdView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements RewardedAdController {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private RewardedAdController f71743d;

    /* renamed from: e, reason: collision with root package name */
    private RewardedAdListener f71744e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements RewardedAdController.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RewardedAdController.a f71745a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f71746b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f71747c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RewardedAdData f71748d;

        a(RewardedAdController.a aVar, Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData) {
            this.f71745a = aVar;
            this.f71746b = activity;
            this.f71747c = viewGroup;
            this.f71748d = rewardedAdData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, aVar, activity, viewGroup, rewardedAdData);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController.a
        public void onFailure() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "show dynamic rewarded failure.");
                d.this.e(this.f71746b, this.f71747c, this.f71748d, this.f71745a);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "show dynamic rewarded success.");
            RewardedAdController.a aVar = this.f71745a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71744e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData, RewardedAdController.a aVar) {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "showNativeRewardedAd");
        boolean z16 = false;
        if (rewardedAdData != null && activity != null) {
            int i3 = activity.getResources().getConfiguration().orientation;
            boolean z17 = rewardedAdData.f71688b;
            if (z17 && i3 != 1) {
                com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "change orientation to portrait");
                activity.setRequestedOrientation(1);
            } else if (!z17 && i3 != 2) {
                com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "change orientation to landscape");
                activity.setRequestedOrientation(0);
            }
        }
        RewardedAdListener rewardedAdListener = this.f71744e;
        if (rewardedAdData != null) {
            z16 = rewardedAdData.f71688b;
        }
        RewardedAdView rewardedAdView = new RewardedAdView(activity, rewardedAdListener, z16);
        this.f71743d = rewardedAdView;
        rewardedAdView.setRewardedAdListener(this.f71744e);
        this.f71743d.b(activity, viewGroup, rewardedAdData, aVar);
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void b(Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData, RewardedAdController.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, viewGroup, rewardedAdData, aVar);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "show");
        if (c.f().j() && rewardedAdData != null && !TextUtils.isEmpty(rewardedAdData.f71703q)) {
            com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "show dynamic reward");
            try {
                DKRewardedAdController dKRewardedAdController = new DKRewardedAdController(activity);
                this.f71743d = dKRewardedAdController;
                dKRewardedAdController.setRewardedAdListener(this.f71744e);
                this.f71743d.b(activity, viewGroup, rewardedAdData, new a(aVar, activity, viewGroup, rewardedAdData));
                return;
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAdControllerWrapper", "dynamic reward error.", th5);
                e(activity, viewGroup, rewardedAdData, aVar);
                return;
            }
        }
        e(activity, viewGroup, rewardedAdData, aVar);
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerWrapper", "getPlayedDuration");
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController == null) {
            return 0L;
        }
        return rewardedAdController.c();
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void d(com.tencent.ams.xsad.rewarded.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
            return;
        }
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController != null) {
            rewardedAdController.d(aVar);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public int getDisplayType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController != null) {
            return rewardedAdController.getDisplayType();
        }
        return 0;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController == null) {
            return null;
        }
        return rewardedAdController.getView();
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController != null) {
            rewardedAdController.onBackPressed();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rewardedAdListener);
            return;
        }
        this.f71744e = rewardedAdListener;
        RewardedAdController rewardedAdController = this.f71743d;
        if (rewardedAdController != null) {
            rewardedAdController.setRewardedAdListener(rewardedAdListener);
        }
    }
}
