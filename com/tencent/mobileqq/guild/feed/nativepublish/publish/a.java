package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/publish/a;", "", "", "b", "a", "", "I", "inc", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f222223a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int inc;

    a() {
    }

    @NotNull
    public final String a() {
        return "GuildNativeMain_" + System.nanoTime() + "_" + UUID.randomUUID();
    }

    @NotNull
    public final String b() {
        inc++;
        return "GuildNativeSon-" + System.nanoTime() + "-" + inc;
    }
}
