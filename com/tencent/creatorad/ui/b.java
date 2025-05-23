package com.tencent.creatorad.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import mqq.util.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected CreatorReader$ShareAD f100382a;

    /* renamed from: b, reason: collision with root package name */
    protected String f100383b;

    /* renamed from: c, reason: collision with root package name */
    protected ViewGroup f100384c;

    /* renamed from: d, reason: collision with root package name */
    protected View f100385d;

    /* renamed from: e, reason: collision with root package name */
    private final AdFeedbackDialogFragment.Listener f100386e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100386e = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.creatorad.ui.a
                @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
                public final void onResult(AdFeedbackDialogFragment.Result result) {
                    b.this.g(result);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(AdFeedbackDialogFragment.Result result) {
        if (result != null && result.action == 3) {
            i();
        }
    }

    private void i() {
        p(8);
        CreatorReader$ShareAD creatorReader$ShareAD = this.f100382a;
        if (creatorReader$ShareAD != null) {
            creatorReader$ShareAD.clear();
        }
    }

    public void b(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) creatorReader$ShareAD);
        } else {
            if (!com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
                QLog.e("BasePresenter", 1, "isSharedAdValid false");
                return;
            }
            this.f100382a = creatorReader$ShareAD;
            p(0);
            j(creatorReader$ShareAD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) creatorReader$ShareAD, i3);
        } else {
            if (!com.tencent.creatorad.utils.c.f(creatorReader$ShareAD, i3)) {
                return;
            }
            e(creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(i3));
        }
    }

    protected void e(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) adInfo);
            return;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = new GdtAd(adInfo);
        params.activity = new WeakReference(com.tencent.creatorad.utils.c.a());
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, AdDownloadConstants.DOWNLOAD_SOURCE_AD);
        params.directPlay = true;
        params.videoCeilingSupportedIfNotInstalled = true;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
    }

    public void f(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, viewGroup, layoutParams);
            return;
        }
        this.f100384c = viewGroup;
        this.f100383b = str;
        if (this.f100385d == null) {
            this.f100385d = LayoutInflater.from(viewGroup.getContext()).inflate(h(), this.f100384c, false);
        }
        if (this.f100384c.indexOfChild(this.f100385d) == -1) {
            if (layoutParams != null) {
                this.f100384c.addView(this.f100385d, layoutParams);
            } else {
                this.f100384c.addView(this.f100385d);
            }
        }
        k();
    }

    protected abstract int h();

    protected abstract void j(CreatorReader$ShareAD creatorReader$ShareAD);

    protected abstract void k();

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) creatorReader$ShareAD, i3);
            return;
        }
        if (!com.tencent.creatorad.utils.c.f(creatorReader$ShareAD, i3)) {
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(i3);
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new java.lang.ref.WeakReference<>(com.tencent.creatorad.utils.c.a());
        adFeedbackParams.listener = new java.lang.ref.WeakReference<>(this.f100386e);
        adFeedbackParams.f61346ad = new GdtAd(adInfo);
        adFeedbackParams.styleId = 0;
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("BasePresenter", 1, "openFeedBack", th5);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.f100384c;
        if (viewGroup != null) {
            viewGroup.removeView(this.f100385d);
        }
        this.f100385d = null;
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        View view = this.f100385d;
        if (view != null) {
            view.setVisibility(i3);
        }
        ViewGroup viewGroup = this.f100384c;
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
    }
}
