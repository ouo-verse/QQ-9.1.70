package com.tencent.mobileqq.zootopia.utils;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/e;", "", "", "a", "", "J", "lastClickTime", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    public final boolean a() {
        if (System.currentTimeMillis() - this.lastClickTime <= 800) {
            return true;
        }
        this.lastClickTime = System.currentTimeMillis();
        return false;
    }
}
