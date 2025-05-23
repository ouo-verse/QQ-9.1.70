package com.tencent.mobileqq.ecshop.view;

import android.view.View;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJC\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/ecshop/view/b;", "", "", "msgId", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "Landroid/view/View;", "view", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "deleteListener", "b", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f203962a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f203962a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 function1, long j3, AdFeedbackDialogFragment.Result result) {
        Integer num;
        AdError adError = result.result;
        if (adError == null) {
            num = 1;
        } else if (adError != null) {
            num = Integer.valueOf(adError.getErrorCode());
        } else {
            num = null;
        }
        int i3 = result.action;
        QLog.d("qqshop_QQShopFeedback", 1, "errorCode = " + num + " ; action = " + i3);
        if (num != null && num.intValue() == 0 && i3 == 3 && function1 != null) {
            function1.invoke(Long.valueOf(j3));
        }
    }

    public final void b(final long msgId, @NotNull qq_ad_get.QQAdGetRsp.AdInfo adInfo, @NotNull View view, @Nullable final Function1<? super Long, Unit> deleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), adInfo, view, deleteListener);
            return;
        }
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        AdFeedbackDialogFragment.Listener listener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.ecshop.view.a
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                b.c(Function1.this, msgId, result);
            }
        };
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new WeakReference<>(Foreground.getTopActivity());
        adFeedbackParams.listener = new WeakReference<>(listener);
        adFeedbackParams.f61346ad = new GdtAd(adInfo);
        view.setTag(listener);
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("qqshop_QQShopFeedback", 1, "showGdtNewPopWindow", th5);
        }
    }
}
