package com.tencent.mobileqq.qqshop.report.dev;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.message.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001d\u001a\u0004\b\r\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/dev/b;", "", "", "eventCode", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "a", "g", "f", "d", "c", "", "b", "Ljava/lang/Long;", "getMsgReceiveTime", "()Ljava/lang/Long;", "j", "(Ljava/lang/Long;)V", "msgReceiveTime", "", "Z", "e", "()Z", h.F, "(Z)V", "isClicked", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData;", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", "i", "(Lmqq/util/WeakReference;)V", "currentLaunchData", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f274713a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Long msgReceiveTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isClicked;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<KuiklyLaunchData> currentLaunchData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f274713a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String eventCode, MsgRecord msgRecord) {
        String str;
        HashMap hashMapOf;
        d dVar = d.f274478a;
        int d16 = dVar.d(msgRecord);
        if (dVar.x(msgRecord)) {
            str = "1";
        } else {
            str = "0";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("action_type", String.valueOf(d16)), TuplesKt.to("position", str), TuplesKt.to("ad_id", dVar.e(msgRecord)), TuplesKt.to(MiniAppPlugin.ATTR_PAGE_TYPE, "2"), TuplesKt.to("platform", "android"), TuplesKt.to(AppConstants.Preferences.QQ_VERSION, AppSetting.f99551k), TuplesKt.to(StartupReportKey.USER_UIN, com.tencent.mobileqq.ecshop.utils.a.a().getCurrentAccountUin()));
        ((IQWalletCommonReport) QRoute.apiIPCSync(IQWalletCommonReport.class)).report(eventCode, (Map<String, String>) hashMapOf);
    }

    @Nullable
    public final WeakReference<KuiklyLaunchData> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (WeakReference) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return currentLaunchData;
    }

    public final void c(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            a("qqshop_msg_inner_click", msgRecord);
        }
    }

    public final void d(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            a("qqshop_msg_inner_show", msgRecord);
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return isClicked;
    }

    public final void f(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            a("qqshop_msg_outer_click", msgRecord);
        }
    }

    public final void g(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            a("qqshop_msg_outer_show", msgRecord);
        }
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            isClicked = z16;
        }
    }

    public final void i(@Nullable WeakReference<KuiklyLaunchData> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) weakReference);
        } else {
            currentLaunchData = weakReference;
        }
    }

    public final void j(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
        } else {
            msgReceiveTime = l3;
        }
    }
}
