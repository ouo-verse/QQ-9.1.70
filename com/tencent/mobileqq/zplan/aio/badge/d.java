package com.tencent.mobileqq.zplan.aio.badge;

import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/d;", "", "", "key", "a", "b", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f330937a = new d();

    d() {
    }

    private final String a(String key) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (peekAppRuntime != null ? peekAppRuntime.getAccount() : null) + "_" + key;
    }

    public final String b() {
        return a("BRAND_ALREADY_SHOW_COUNT");
    }

    public final String c() {
        return a("LAST_RED_DOT_SHOW_TIME");
    }
}
