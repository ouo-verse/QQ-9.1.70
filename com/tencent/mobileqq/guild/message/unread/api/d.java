package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/d;", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadCount", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static void a(@NotNull d dVar, @NotNull UnreadInfo.a unreadCount) {
            Intrinsics.checkNotNullParameter(unreadCount, "unreadCount");
        }
    }

    void a(@NotNull UnreadInfo.a unreadCount);
}
