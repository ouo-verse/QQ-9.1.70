package com.tencent.mobileqq.aio.animation.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qqnt.beacon.NTBeaconReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/util/e;", "", "", "", "a", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "b", "c2c", "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "", "c", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f188167a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f188167a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean b(@NotNull com.tencent.mobileqq.aio.animation.config.a rule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rule)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (rule.h() == 560) {
            return true;
        }
        return false;
    }

    public final void c(boolean c2c, @NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull com.tencent.mobileqq.aio.animation.config.a rule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(c2c), message, rule);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(rule, "rule");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        HashMap hashMap = new HashMap();
        e eVar = f188167a;
        hashMap.put("param_is_c2c", String.valueOf(eVar.a(c2c)));
        hashMap.put("param_is_self", String.valueOf(eVar.a(message.b())));
        hashMap.put("param_sender_uin", String.valueOf(message.getSenderUin()));
        hashMap.put("param_rule_id", String.valueOf(rule.h()));
        hashMap.put("param_rule_type", String.valueOf(rule.r()));
        hashMap.put("param_match_keyword", rule.o());
        Unit unit = Unit.INSTANCE;
        NTBeaconReport.h(currentUin, "aio_egg_keyword_matched", hashMap);
    }

    private final int a(boolean z16) {
        return z16 ? 1 : 0;
    }
}
