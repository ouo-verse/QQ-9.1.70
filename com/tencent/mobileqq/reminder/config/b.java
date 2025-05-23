package com.tencent.mobileqq.reminder.config;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/reminder/config/b;", "", "", "c", "", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/mobileqq/reminder/config/a;", "a", "", AdMetricTag.FALLBACK, "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mConfigCache", "Ljava/lang/String;", "mCurrentUin", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f281031a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, a> mConfigCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentUin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f281031a = new b();
        mConfigCache = new ConcurrentHashMap<>();
        mCurrentUin = "";
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a a(String group) {
        c();
        ConcurrentHashMap<String, a> concurrentHashMap = mConfigCache;
        a aVar = concurrentHashMap.get(group);
        if (aVar == null) {
            a aVar2 = new a();
            concurrentHashMap.put(group, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private final void c() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(mCurrentUin, str)) {
            QLog.d("ReminderConfigCacheManager", 1, "reset cache uin " + mCurrentUin + " -> " + str);
            mConfigCache.clear();
            mCurrentUin = str;
        }
    }

    public final boolean b(@NotNull String group, boolean fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, group, Boolean.valueOf(fallback))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(group, "group");
        a a16 = a(group);
        Boolean a17 = a16.a();
        if (a17 == null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
            a16.b(Boolean.valueOf(isSwitchOn));
            QLog.d("ReminderConfigCacheManager", 1, mCurrentUin + " is " + group + " switch on: " + isSwitchOn);
            return isSwitchOn;
        }
        return a17.booleanValue();
    }
}
