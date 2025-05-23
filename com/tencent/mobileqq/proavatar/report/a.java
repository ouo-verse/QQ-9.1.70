package com.tencent.mobileqq.proavatar.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.b;
import com.tencent.qqnt.avatar.util.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/proavatar/report/a;", "Lcom/tencent/qqnt/avatar/util/b;", "Lcom/tencent/qqnt/avatar/util/e;", "tracer", "Lcom/tencent/qqnt/avatar/util/e$a;", "lastEvent", "", "a", "", "event", "", "", "map", "report", "", "b", "Lcom/tencent/mobileqq/avatar/a;", "Lcom/tencent/mobileqq/avatar/a;", "reportSwitch", "c", "Ljava/util/Map;", "eventMap", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f259665a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.avatar.a reportSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> eventMap;

    static {
        Map<String, String> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f259665a = new a();
        reportSwitch = new com.tencent.mobileqq.avatar.a("proavatar_component_report_switch", false);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sync_load", "ProAvatarSyncLoad"), TuplesKt.to("async_load", "ProAvatarAsyncLoad"), TuplesKt.to("info_cache_hit_rate", "ProAvatarInfoCacheHitRate"));
        eventMap = mapOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.avatar.util.b
    public void a(@NotNull e tracer, @NotNull e.a lastEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tracer, (Object) lastEvent);
        } else {
            Intrinsics.checkNotNullParameter(tracer, "tracer");
            Intrinsics.checkNotNullParameter(lastEvent, "lastEvent");
        }
    }

    @Override // com.tencent.qqnt.avatar.util.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.avatar.util.b
    public void report(@NotNull String event, @NotNull Map<String, ? extends Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(map, "map");
        }
    }
}
