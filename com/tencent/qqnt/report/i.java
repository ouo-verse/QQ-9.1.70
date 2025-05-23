package com.tencent.qqnt.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/report/i;", "Landroid/os/Handler$Callback;", "", "b", "", "d", "c", "e", "g", "", "hitCache", "a", "f", "Landroid/os/Message;", "msg", "handleMessage", "I", "CACHE_STRATEGY_VERSION_DEFAULT", "count", tl.h.F, "hitCacheCount", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "uiHandler", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final i f361953d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int CACHE_STRATEGY_VERSION_DEFAULT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile int count;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static volatile int hitCacheCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler uiHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        i iVar = new i();
        f361953d = iVar;
        CACHE_STRATEGY_VERSION_DEFAULT = TroopMemberCacheStrategy.DEFAULT.getVersion();
        uiHandler = new Handler(Looper.getMainLooper(), iVar);
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("total_call", Integer.valueOf(count));
        hashMap.put("total_hit_cache", Integer.valueOf(hitCacheCount));
        ITroopMemberCacheService.Companion companion = ITroopMemberCacheService.INSTANCE;
        hashMap.put("strategy_version", Integer.valueOf((companion.c() * 100) + f361953d.d()));
        hashMap.put("each_troop_max_member_size", Integer.valueOf(companion.d()));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_member_info_hit_cache_with_nt", hashMap);
        if (QLog.isDebugVersion()) {
            QLog.d("TroopMemberHitCacheRateReport", 4, "[doReport] troop_member_info_hit_cache_with_nt - " + hashMap);
        }
    }

    private final int c() {
        return com.tencent.mobileqq.troop.config.b.f294691a.d("102125", "hit_cache_strategy_version_android", CACHE_STRATEGY_VERSION_DEFAULT);
    }

    private final int d() {
        return f() ? 1 : 0;
    }

    private final int e() {
        return com.tencent.mobileqq.troop.config.b.f294691a.d("102125", "hit_cache_report_delay_second", 18000);
    }

    private final void g() {
        count = 0;
        hitCacheCount = 0;
    }

    public final void a(boolean hitCache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, hitCache);
            return;
        }
        if (!TroopMemberReportKt.c()) {
            return;
        }
        if (hitCache) {
            hitCacheCount++;
        }
        count++;
        if (!uiHandler.hasMessages(8228)) {
            uiHandler.sendEmptyMessageDelayed(8228, e() * 1000);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f() {
        int i3;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int c16 = c();
        TroopMemberCacheStrategy troopMemberCacheStrategy = TroopMemberCacheStrategy.USE_MEMBER_LIST;
        if (c16 == troopMemberCacheStrategy.getVersion()) {
            return true;
        }
        if (c16 == TroopMemberCacheStrategy.AVERAGE.getVersion()) {
            AppRuntime f16 = bg.f();
            if (f16 != null && (r0 = f16.getCurrentUin()) != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            if (i3 % 2 == troopMemberCacheStrategy.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 8228) {
            b();
            g();
            return true;
        }
        return true;
    }
}
