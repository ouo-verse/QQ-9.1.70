package com.tencent.mobileqq.guild.media.core;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\fH\u0003\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/j;", "", "Lcom/tencent/mobileqq/guild/media/core/e;", "a", "Lcom/tencent/mobileqq/guild/media/core/notify/p;", "d", "Lcom/tencent/mobileqq/guild/media/core/l;", "c", "", "f", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f228126a = new j();

    j() {
    }

    @JvmStatic
    @NotNull
    public static final e a() {
        return e();
    }

    @JvmStatic
    @NotNull
    public static final CoroutineScope b() {
        return e().getCoroutineScope();
    }

    @JvmStatic
    @NotNull
    public static final l c() {
        return e().v0();
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.guild.media.core.notify.p d() {
        return e().getEventBus();
    }

    @JvmStatic
    private static final f e() {
        return MediaChannelCore.INSTANCE.a();
    }

    @JvmStatic
    public static final boolean f() {
        return MediaChannelCore.INSTANCE.b();
    }
}
