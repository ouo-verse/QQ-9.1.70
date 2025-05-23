package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ab;", "", "", "a", "", "msg", "b", "", "J", "getCostTime", "()J", "setCostTime", "(J)V", "costTime", "c", "getLastTimestamp", "setLastTimestamp", "lastTimestamp", "d", "Ljava/lang/String;", "getLastMsg", "()Ljava/lang/String;", "setLastMsg", "(Ljava/lang/String;)V", "lastMsg", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ab {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long costTime;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f235425a = new ab();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastTimestamp = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastMsg = "";

    ab() {
    }

    @JvmStatic
    public static final void a() {
        costTime = 0L;
        lastTimestamp = System.currentTimeMillis();
        lastMsg = "";
    }

    @JvmStatic
    public static final void b(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }
}
