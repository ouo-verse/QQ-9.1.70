package com.tencent.mobileqq.login.relogin.fragment;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorRes;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/b;", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "maskColorResId", "Le72/b;", "callback", "", "b", "", "fadeInDuration", "c", "Lcom/tencent/mobileqq/login/relogin/fragment/a;", "Lcom/tencent/mobileqq/login/relogin/fragment/a;", "baseLoginSuccessAnimator", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f242508a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a baseLoginSuccessAnimator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f242508a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a() {
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("debug_qq_login_success_anim_type", 1);
        if (decodeInt < -1 || decodeInt > 1) {
            return -1;
        }
        return decodeInt;
    }

    public final void b(@NotNull Activity activity, @NotNull View rootView, @ColorRes int maskColorResId, @Nullable e72.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, rootView, Integer.valueOf(maskColorResId), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        int a16 = a();
        QLog.i("LoginSuccessAnimHelper", 2, "startLoginAnim type: " + a16);
        if (a16 != -1) {
            if (a16 != 0) {
                if (a16 == 1) {
                    baseLoginSuccessAnimator = new SplashLoginSuccessAnimator();
                }
            } else if (callback != null) {
                callback.b();
            }
        } else if (callback != null) {
            callback.b();
        }
        a aVar = baseLoginSuccessAnimator;
        if (aVar != null) {
            aVar.c(activity, rootView, maskColorResId, callback);
        }
    }

    public final void c(@NotNull Activity activity, long fadeInDuration, @Nullable e72.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, Long.valueOf(fadeInDuration), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        a aVar = baseLoginSuccessAnimator;
        if (aVar != null) {
            aVar.d(activity, fadeInDuration, callback);
        }
        baseLoginSuccessAnimator = null;
    }
}
