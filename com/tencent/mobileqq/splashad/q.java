package com.tencent.mobileqq.splashad;

import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.p;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u000bRT\u0010\u0013\u001aB\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\t0\t \u0011* \u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\t0\t\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/splashad/q;", "", "", "isStart", "e", "", "b", "", "bizType", "Lcom/tencent/mobileqq/splashad/g;", "data", "", "f", "c", "d", "a", "Ljava/util/SortedMap;", "kotlin.jvm.PlatformType", "Ljava/util/SortedMap;", "mSplashDataMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f288880a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final SortedMap<Integer, g> mSplashDataMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f288880a = new q();
            mSplashDataMap = Collections.synchronizedSortedMap(new TreeMap());
        }
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            mSplashDataMap.clear();
        }
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SortedMap<Integer, g> mSplashDataMap2 = mSplashDataMap;
        long j3 = Long.MAX_VALUE;
        if (mSplashDataMap2.isEmpty()) {
            QLog.d("SplashHotChecker", 1, "no splashAd need show");
            return Long.MAX_VALUE;
        }
        Intrinsics.checkNotNullExpressionValue(mSplashDataMap2, "mSplashDataMap");
        for (Map.Entry<Integer, g> entry : mSplashDataMap2.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (SplashADUtil.x(key.intValue(), false)) {
                QLog.d("SplashHotChecker", 1, "splash time ExceedLimit, type is " + entry.getKey());
                p b16 = p.b();
                Integer key2 = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "entry.key");
                p.b a16 = b16.a(key2.intValue());
                if (a16 != null) {
                    a16.a(true);
                }
            } else {
                g value = entry.getValue();
                if (value.b() - currentTimeMillis < j3) {
                    j3 = value.b() - currentTimeMillis;
                }
            }
        }
        return j3;
    }

    public final boolean c(int bizType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, bizType)).booleanValue();
        }
        g gVar = mSplashDataMap.get(Integer.valueOf(bizType));
        if (gVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long b16 = gVar.b();
        if (currentTimeMillis > gVar.a() || b16 > currentTimeMillis) {
            return false;
        }
        return true;
    }

    public final boolean d(int bizType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, bizType)).booleanValue();
        }
        if (mSplashDataMap.containsKey(Integer.valueOf(bizType))) {
            return true;
        }
        return false;
    }

    public final boolean e(boolean isStart) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, isStart)).booleanValue();
        }
        SortedMap<Integer, g> mSplashDataMap2 = mSplashDataMap;
        if (mSplashDataMap2.isEmpty()) {
            QLog.d("SplashHotChecker", 1, "no splashAd need show");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Intrinsics.checkNotNullExpressionValue(mSplashDataMap2, "mSplashDataMap");
        int i3 = 0;
        for (Map.Entry<Integer, g> entry : mSplashDataMap2.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (SplashADUtil.x(key.intValue(), false)) {
                QLog.d("SplashHotChecker", 1, "splash time ExceedLimit, type is " + entry.getKey());
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateSplashEmptyOrderParams(true, true, 1003);
                SplashEmptyReportHelper.f288736a.b();
            } else {
                g value = entry.getValue();
                long b16 = value.b();
                if (currentTimeMillis <= value.a() && b16 <= currentTimeMillis) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (i3 != 0) {
                        QLog.d("SplashHotChecker", 1, "splash low priority, type is " + entry.getKey());
                        p b17 = p.b();
                        Integer key2 = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "entry.key");
                        p.b a16 = b17.a(key2.intValue());
                        if (a16 != null) {
                            a16.b(isStart);
                        }
                    } else {
                        Integer key3 = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key3, "entry.key");
                        i3 = key3.intValue();
                    }
                } else {
                    QLog.d("SplashHotChecker", 1, "splash no in time, type is " + entry.getKey());
                    p b18 = p.b();
                    Integer key4 = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key4, "entry.key");
                    p.b a17 = b18.a(key4.intValue());
                    if (a17 != null) {
                        a17.c(isStart);
                    }
                }
            }
        }
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public final void f(int bizType, @Nullable g data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, bizType, (Object) data);
        } else {
            if (data == null) {
                return;
            }
            SortedMap<Integer, g> mSplashDataMap2 = mSplashDataMap;
            Intrinsics.checkNotNullExpressionValue(mSplashDataMap2, "mSplashDataMap");
            mSplashDataMap2.put(Integer.valueOf(bizType), data);
        }
    }
}
