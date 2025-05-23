package com.tencent.qqnt.aio.util;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.notification.IAIONotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004J.\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/util/AIONotificationUtils;", "", "", "a", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "b", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIONotificationUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIONotificationUtils f352237a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352237a = new AIONotificationUtils();
        }
    }

    AIONotificationUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        return ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).isNotificationEnable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Map<String, Function0<h>> b(@NotNull Map<String, ? extends Function0<? extends h>> map) {
        Map<String, Function0<h>> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
        }
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (!a()) {
            plus = MapsKt__MapsKt.plus(map, TuplesKt.to("CustomBarHelper", AIONotificationUtils$plusCustomBarHelperIfNeed$1.INSTANCE));
            return plus;
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Map<String, Function0<h>> c(@NotNull Map<String, ? extends Function0<? extends h>> map) {
        Map<String, Function0<h>> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
        }
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (!a()) {
            plus = MapsKt__MapsKt.plus(map, TuplesKt.to("ListenTogetherHelper", AIONotificationUtils$plusListenTogetherHelperIfNeed$1.INSTANCE));
            return plus;
        }
        return map;
    }
}
