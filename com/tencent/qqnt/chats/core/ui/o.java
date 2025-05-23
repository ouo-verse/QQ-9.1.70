package com.tencent.qqnt.chats.core.ui;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J \u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J \u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u0018\u0010\u0015\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH&J\b\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/o;", "", "", "onBackground", "onForeground", "", "payload", "f", "([Ljava/lang/Object;)V", "", "uin", "a", "uid", "c", "", "uins", "e", "uids", "d", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "list", "g", "", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface o {
    void a(@NotNull String uin, @Nullable Object payload);

    boolean b();

    void c(@NotNull String uid, @Nullable Object payload);

    void d(@NotNull List<String> uids, @Nullable Object payload);

    void e(@NotNull List<String> uins, @Nullable Object payload);

    void f(@NotNull Object... payload);

    void g(@Nullable List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list);

    void onBackground();

    void onForeground();
}
