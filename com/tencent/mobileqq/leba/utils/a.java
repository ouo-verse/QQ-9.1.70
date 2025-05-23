package com.tencent.mobileqq.leba.utils;

import android.view.View;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/leba/utils/a;", "", "Landroid/view/View;", "archerView", "", "bubbleTip", "", "offSetY", "", "c", "a", "", "b", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f240765a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f240765a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool("has_show_bubble_tip_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), true);
    }

    @JvmStatic
    @UiThread
    public static final void c(@Nullable View archerView, @Nullable String bubbleTip, int offSetY) {
        boolean z16;
        int i3;
        if (archerView != null) {
            if (bubbleTip != null && bubbleTip.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                a aVar = f240765a;
                if (!aVar.b()) {
                    return;
                }
                if (QQTheme.isNowThemeIsNight()) {
                    i3 = 4;
                } else {
                    i3 = 3;
                }
                QLog.i("BubbleTipUtils", 1, "showBubbleTip " + MsfSdkUtils.getShortUin(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()));
                QUIDefaultBubbleTip.r(archerView.getContext()).o0(bubbleTip).S(archerView).R(2).i0(0.0f, (float) offSetY).r0(false).m0(i3).s0();
                aVar.a();
            }
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
