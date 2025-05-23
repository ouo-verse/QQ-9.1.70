package com.tencent.mobileqq.zootopia;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/c;", "", "", "time", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f327951a = new c();

    c() {
    }

    public final String a(long time) {
        String loadingId = com.tencent.open.base.g.d(com.tencent.sqshow.zootopia.utils.w.f373306a.b() + "-" + time);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("generateLoadingId, ");
        sb5.append(loadingId);
        QLog.d("LoadingUtils", 1, sb5.toString());
        Intrinsics.checkNotNullExpressionValue(loadingId, "loadingId");
        return loadingId;
    }
}
