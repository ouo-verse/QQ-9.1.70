package com.tencent.mobileqq.guild.media.qcircle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\"\"\u0010\u0007\u001a\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\u0001\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"", "a", "I", "b", "()I", "d", "(I)V", "mediaRoomStatus", "", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "circleMediaRoom", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static int f229202a = 0;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f229203b = "";

    @NotNull
    public static final String a() {
        return f229203b;
    }

    public static final int b() {
        return f229202a;
    }

    public static final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f229203b = str;
    }

    public static final void d(int i3) {
        f229202a = i3;
    }
}
