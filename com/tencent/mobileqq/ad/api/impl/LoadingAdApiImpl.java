package com.tencent.mobileqq.ad.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.ad.api.ILoadingAdApi;
import com.tencent.mobileqq.ad.loadingad.b;
import com.tencent.mobileqq.ad.loadingad.c;
import com.tencent.mobileqq.ad.loadingad.g;
import com.tencent.mobileqq.ad.loadingad.i;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/ad/api/impl/LoadingAdApiImpl;", "Lcom/tencent/mobileqq/ad/api/ILoadingAdApi;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "preloadAd", "Lcom/tencent/mobileqq/ad/loadingad/b;", "chooseAdEndListener", "requestAd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/ad/loadingad/c;", "info", "Lcom/tencent/mobileqq/ad/loadingad/i;", "adShowStateListener", "showAd", "", "adJson", "processSelectAdWithUncachedAd", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LoadingAdApiImpl implements ILoadingAdApi {
    static IPatchRedirector $redirector_;

    public LoadingAdApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.ILoadingAdApi
    public void preloadAd(int busiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, busiType);
        } else {
            g.f186889a.E(busiType);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.ILoadingAdApi
    public void processSelectAdWithUncachedAd(@Nullable String adJson, @NotNull b chooseAdEndListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) adJson, (Object) chooseAdEndListener);
        } else {
            Intrinsics.checkNotNullParameter(chooseAdEndListener, "chooseAdEndListener");
            g.f186889a.F(adJson, chooseAdEndListener);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.ILoadingAdApi
    public void requestAd(int busiType, @NotNull b chooseAdEndListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, busiType, (Object) chooseAdEndListener);
        } else {
            Intrinsics.checkNotNullParameter(chooseAdEndListener, "chooseAdEndListener");
            g.f186889a.I(busiType, chooseAdEndListener);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.ILoadingAdApi
    public void showAd(@Nullable Activity activity, @NotNull c info, @NotNull i adShowStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, info, adShowStateListener);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(adShowStateListener, "adShowStateListener");
        g.f186889a.J(activity, info, adShowStateListener);
    }
}
