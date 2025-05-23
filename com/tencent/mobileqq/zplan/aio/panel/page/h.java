package com.tencent.mobileqq.zplan.aio.panel.page;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\f\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/h;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/g;", "", "a", "Ljava/lang/String;", "redDotPersistentKey", "", "b", "Z", "()Z", "setRedDotHint", "(Z)V", "redDotHint", "redDotPersistentKeyPrefix", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String redDotPersistentKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean redDotHint;

    public h(String redDotPersistentKeyPrefix) {
        Intrinsics.checkNotNullParameter(redDotPersistentKeyPrefix, "redDotPersistentKeyPrefix");
        this.redDotPersistentKey = redDotPersistentKeyPrefix + "_RED_DOT";
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.g
    /* renamed from: a, reason: from getter */
    public boolean getRedDotHint() {
        return this.redDotHint;
    }
}
