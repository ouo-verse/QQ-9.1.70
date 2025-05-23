package com.tencent.mobileqq.notification.modularize.business;

import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/business/d;", "", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "a", "", "", "b", "Ljava/util/Map;", "jumpSchemeMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f254280a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, BaseJumpScheme> jumpSchemeMap;

    static {
        Map<Integer, BaseJumpScheme> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f254280a = new d();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, new c()), TuplesKt.to(-1, new e()), TuplesKt.to(4, new a()));
        jumpSchemeMap = mapOf;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final BaseJumpScheme a(@NotNull f pushComponent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseJumpScheme) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pushComponent);
        }
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        if (pushComponent.isUrlJump) {
            return new c();
        }
        BaseJumpScheme baseJumpScheme = jumpSchemeMap.get(Integer.valueOf(pushComponent.mainBusinessId));
        if (baseJumpScheme == null) {
            return new b();
        }
        return baseJumpScheme;
    }
}
