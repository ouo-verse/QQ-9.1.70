package com.tencent.mobileqq.guild.message;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u0005\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/message/a;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "sKeyIndex", "c", "I", "()I", "ITEM_VIEW_TYPE_GUILD_ITEM_STYLE", "d", "GUILD_LIVE_SECURITY_MSG_TYPE", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f230108a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger sKeyIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int ITEM_VIEW_TYPE_GUILD_ITEM_STYLE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int GUILD_LIVE_SECURITY_MSG_TYPE;

    static {
        a aVar = new a();
        f230108a = aVar;
        sKeyIndex = new AtomicInteger(10999);
        ITEM_VIEW_TYPE_GUILD_ITEM_STYLE = aVar.a();
        GUILD_LIVE_SECURITY_MSG_TYPE = aVar.a();
    }

    a() {
    }

    private final int a() {
        return sKeyIndex.incrementAndGet();
    }

    public final int b() {
        return GUILD_LIVE_SECURITY_MSG_TYPE;
    }

    public final int c() {
        return ITEM_VIEW_TYPE_GUILD_ITEM_STYLE;
    }
}
