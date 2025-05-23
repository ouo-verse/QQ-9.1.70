package com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl;

import com.tencent.mobileqq.mini.apkg.ApkgConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/a;", "", "", "url", "", "a", "b", "Ljava/lang/String;", ApkgConfigManager.KEY_BASELIB_LAST_URL, "", "c", "J", "lastSchemeActionTime", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f263418a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String lastUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastSchemeActionTime;

    a() {
    }

    public final boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        long currentTimeMillis = System.currentTimeMillis();
        if (!Intrinsics.areEqual(url, lastUrl)) {
            lastUrl = url;
            lastSchemeActionTime = currentTimeMillis;
            return false;
        }
        if (currentTimeMillis - lastSchemeActionTime > 1000) {
            lastSchemeActionTime = currentTimeMillis;
            return false;
        }
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d("QQECFrequencyFilter", 2, "filterSchemeAction: filter url=" + url);
        return true;
    }
}
