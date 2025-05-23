package com.tencent.mobileqq.ad.cardad.utils;

import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0014\u0010\u0016\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/utils/d;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "b", "Landroid/view/View;", "view", "", "onlyCompareHeight", "", "c", "f", "e", "g", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "gdtShakeIconView", "", "j", "k", "Lkotlin/Function0;", "runnable", h.F, "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f186735a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f186735a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ double d(d dVar, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return dVar.c(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    @NotNull
    public final String b(@Nullable GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gdtAd);
        }
        if (gdtAd == null) {
            return "";
        }
        return gdtAd.getTraceId() + util.base64_pad_url + gdtAd.getAId();
    }

    public final double c(@Nullable View view, boolean onlyCompareHeight) {
        double width;
        double width2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(onlyCompareHeight))).doubleValue();
        }
        if (view != null && view.getVisibility() == 0 && view.isShown()) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return 0.0d;
            }
            int dpToPx = ViewUtils.dpToPx(80.0f);
            if (rect.left < ViewUtils.getScreenWidth() && rect.top < ViewUtils.getScreenHeight() && rect.right > 0 && rect.bottom > dpToPx) {
                int i3 = rect.top;
                if (i3 >= 0 && i3 <= dpToPx) {
                    z16 = true;
                }
                if (z16) {
                    rect.top = dpToPx;
                }
                try {
                    if (onlyCompareHeight) {
                        width = rect.height() * 1.0d;
                        width2 = view.getHeight();
                    } else {
                        width = rect.width() * 1.0d * rect.height();
                        width2 = view.getWidth() * view.getHeight();
                    }
                    return width / width2;
                } catch (Throwable th5) {
                    QLog.e("CardAdUtils", 1, "getPercentageOfRealVisibleRect", th5);
                    return -1.0d;
                }
            }
        }
        return 0.0d;
    }

    public final boolean e(@Nullable GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) gdtAd)).booleanValue();
        }
        if (gdtAd == null) {
            return false;
        }
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 50 && innerShowType != 49 && innerShowType != 35 && innerShowType != 36) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
    }

    public final boolean g(@Nullable GdtAd gdtAd) {
        String posId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) gdtAd)).booleanValue();
        }
        if (gdtAd == null || (posId = gdtAd.getPosId()) == null) {
            return false;
        }
        if (!Intrinsics.areEqual(posId, "1082214467882419") && !Intrinsics.areEqual(posId, "5015318293089789") && !Intrinsics.areEqual(posId, "5075514213382984")) {
            return false;
        }
        return true;
    }

    public final void h(@NotNull final Function0<Unit> runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.i(Function0.this);
                }
            });
        }
    }

    public final void j(@Nullable GdtShakeIconView gdtShakeIconView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gdtShakeIconView);
        } else {
            if (gdtShakeIconView == null) {
                return;
            }
            gdtShakeIconView.stop();
            gdtShakeIconView.setVisibility(0);
            gdtShakeIconView.startAnimation(Integer.MAX_VALUE, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
        }
    }

    public final void k(@Nullable GdtShakeIconView gdtShakeIconView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gdtShakeIconView);
        } else {
            if (gdtShakeIconView == null) {
                return;
            }
            gdtShakeIconView.setVisibility(8);
            gdtShakeIconView.stop();
        }
    }
}
