package com.tencent.mobileqq.relationx.batchAdd;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/relationx/batchAdd/d;", "", "Lcom/tencent/mobileqq/relationx/batchAdd/c;", "a", "", "b", "Ljava/lang/String;", "lastReqUid", "c", "Lcom/tencent/mobileqq/relationx/batchAdd/c;", "cacheBean", "d", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f280711a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastReqUid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static c cacheBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f280711a = new d();
        lastReqUid = "";
        cacheBean = new c();
        lock = new Object();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final c a() {
        IConfigData loadConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (lock) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return cacheBean;
            }
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekA\u2026ime() ?: return cacheBean");
            String currentUid = peekAppRuntime.getCurrentUid();
            if (currentUid == null) {
                currentUid = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid ?: \"\"");
            }
            if (!Intrinsics.areEqual(currentUid, lastReqUid) && (loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("troop_batch_add_friend_config")) != null) {
                Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.relationx.batchAdd.TroopBatchAddFriendConfigData");
                cacheBean = (c) loadConfig;
                lastReqUid = currentUid;
            }
            return cacheBean;
        }
    }
}
