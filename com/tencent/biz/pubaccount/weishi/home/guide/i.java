package com.tencent.biz.pubaccount.weishi.home.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/i;", "", "", "topBarId", "Lcom/tencent/biz/pubaccount/weishi/home/guide/a;", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f80847a = new i();

    i() {
    }

    public final a a(String topBarId) {
        Intrinsics.checkNotNullParameter(topBarId, "topBarId");
        if (Intrinsics.areEqual(topBarId, "monofeed_tab")) {
            return new WSMonoTabGuideController();
        }
        return null;
    }
}
