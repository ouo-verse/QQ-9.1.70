package com.tencent.could.huiyansdk.fragments;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import androidx.fragment.app.FragmentActivity;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.view.LoadingFrontAnimatorView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f implements YtSDKKitFramework.IYTReflectListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100092a;

    public f(AuthingFragment authingFragment) {
        this.f100092a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public float onGetAppBrightness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f100092a.f100056k;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, colorMatrixColorFilter, Float.valueOf(f16));
        } else {
            this.f100092a.b(colorMatrixColorFilter);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener
    public void onReflectStart(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.f100092a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.af
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        FragmentActivity activity;
        Paint paint;
        LoadingFrontAnimatorView loadingFrontAnimatorView;
        if (this.f100092a.f100056k == -1) {
            return;
        }
        if (HuiYanSdkImp.getInstance().getSdkConfig().isAutoScreenBrightness()) {
            this.f100092a.b(255);
        }
        if (HuiYanSdkImp.getInstance().getSdkConfig().isOpenLightReflectAnim() && (loadingFrontAnimatorView = this.f100092a.f100054i) != null) {
            loadingFrontAnimatorView.b();
            return;
        }
        AuthingFragment authingFragment = this.f100092a;
        if (authingFragment.f100054i == null || (activity = authingFragment.getActivity()) == null) {
            return;
        }
        this.f100092a.f100067v = true;
        AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
        if (authUiConfig != null && authUiConfig.isHideFrontCircleViewOnReflect()) {
            this.f100092a.f100054i.setVisibility(8);
            return;
        }
        this.f100092a.f100054i.setVisibility(0);
        LoadingFrontAnimatorView loadingFrontAnimatorView2 = this.f100092a.f100054i;
        int color = activity.getResources().getColor(R.color.cwp);
        if (color == loadingFrontAnimatorView2.f100348g || (paint = loadingFrontAnimatorView2.f100351j) == null) {
            return;
        }
        loadingFrontAnimatorView2.f100348g = color;
        paint.setColor(color);
        loadingFrontAnimatorView2.invalidate();
    }
}
