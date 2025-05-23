package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f185361a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f185362b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f185361a = new AtomicBoolean(false);
            f185362b = new Object();
        }
    }

    public static boolean e(@NonNull BaseQQAppInterface baseQQAppInterface, @NonNull RecentUser recentUser, boolean z16) {
        return true;
    }

    public static void a() {
    }

    public static void d(@NonNull BaseQQAppInterface baseQQAppInterface, @NonNull List<RecentUser> list) {
    }

    public static void b(@NonNull BaseQQAppInterface baseQQAppInterface, @NonNull RecentUser recentUser, boolean z16) {
    }

    public static RecentUser c(@NonNull BaseQQAppInterface baseQQAppInterface, @NonNull RecentUser recentUser, boolean z16) {
        return recentUser;
    }
}
