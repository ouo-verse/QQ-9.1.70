package com.tencent.mobileqq.guild.discoveryv2.myguild;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "", "other", "", "equals", "", "hashCode", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class h {
    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (Intrinsics.areEqual(cls2, cls)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
