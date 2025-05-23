package com.tencent.could.huiyansdk.fragments;

import android.widget.ImageView;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.view.LoadingFrontAnimatorView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i implements f.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100096a;

    public i(AuthingFragment authingFragment) {
        this.f100096a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        LoadingFrontAnimatorView loadingFrontAnimatorView = this.f100096a.f100054i;
        if (loadingFrontAnimatorView != null) {
            loadingFrontAnimatorView.postDelayed(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ai
                @Override // java.lang.Runnable
                public final void run() {
                    i.b();
                }
            }, 200L);
        }
    }

    public static void b() {
        k.a.f100197a.a(1, "AuthingFragment", "STAGE_TYPE_REFLECT");
        HuiYanBaseApi.b.f100031a.getClass();
        YtSDKKitFramework.getInstance().doResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f100096a.f100068w = true;
        this.f100096a.b(HuiYanSdkImp.getInstance().getSdkConfig().getPrepareFaceTimeOutMs(), HuiYanSdkImp.getInstance().getSdkConfig().isShowPrepareTimeout());
        ImageView imageView = this.f100096a.f100048c;
        if (imageView != null) {
            imageView.postDelayed(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.aj
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.a();
                }
            }, 150L);
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (i3 == 1) {
            k.a.f100197a.a(1, "AuthingFragment", "STAGE_TYPE_START");
            this.f100096a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ag
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.c();
                }
            });
        }
        if (i3 == 2) {
            this.f100096a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.ah
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        ImageView imageView = this.f100096a.f100048c;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f100096a.g();
        }
    }
}
