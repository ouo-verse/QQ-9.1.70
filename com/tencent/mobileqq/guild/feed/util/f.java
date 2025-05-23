package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/f;", "", "", "businessType", "", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f223903a = new f();

    f() {
    }

    @JvmStatic
    public static final boolean a(int businessType) {
        if (businessType != 11 && businessType != 12 && businessType != 13) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean b(int businessType) {
        if (businessType == 1 || businessType == 11 || businessType == 2 || businessType == 12 || businessType == 13) {
            return true;
        }
        return false;
    }
}
