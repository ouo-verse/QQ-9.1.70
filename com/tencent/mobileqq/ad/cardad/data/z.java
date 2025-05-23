package com.tencent.mobileqq.ad.cardad.data;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/data/z;", "", "Landroid/content/Context;", "b", "", "isSwitchOn", "", "c", "a", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f186721a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f186721a = new z();
        }
    }

    z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Context b() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(b(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        return from.decodeBool("key_card_ad_can_shake_debug_switch", false);
    }

    public final void c(boolean isSwitchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isSwitchOn);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(b(), "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_VAS)");
        from.encodeBool("key_card_ad_can_shake_debug_switch", isSwitchOn);
    }
}
