package com.tencent.mobileqq.qqsec.account;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/u;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "a", "", "tipText", "", "expiredTime", "updateTime", "", "b", "<init>", "()V", "qqsafeblock-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f274415a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f274415a = new u();
        }
    }

    u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MMKVOptionEntity a() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        return from;
    }

    public final void b(@Nullable String tipText, long expiredTime, long updateTime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tipText, Long.valueOf(expiredTime), Long.valueOf(updateTime));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntity a16 = a();
        a16.encodeString(AppConstants.Preferences.QSEC_STATUS_TIP_TEXT + str, tipText);
        a16.encodeLong(AppConstants.Preferences.QSEC_STATUS_EXPIRED_TIME + str, expiredTime);
        a16.encodeLong(AppConstants.Preferences.QSEC_STATUS_UPDATE_LAST_TIME + str, updateTime);
    }
}
