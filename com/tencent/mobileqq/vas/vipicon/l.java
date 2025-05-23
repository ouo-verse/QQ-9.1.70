package com.tencent.mobileqq.vas.vipicon;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/l;", "", "", "rawLevel", "b", "level", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f311340a = new l();

    l() {
    }

    public final int a(int level) {
        if (level <= 1) {
            return 0;
        }
        return 1 << (level - 2);
    }

    public final int b(int rawLevel) {
        if (rawLevel == 0) {
            return 1;
        }
        for (int i3 = 1; i3 < 32; i3++) {
            if ((rawLevel >> i3) == 0) {
                return i3 + 1;
            }
        }
        return 1;
    }
}
