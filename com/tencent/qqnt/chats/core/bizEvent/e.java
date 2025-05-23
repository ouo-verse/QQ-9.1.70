package com.tencent.qqnt.chats.core.bizEvent;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/bizEvent/e;", "", "", "Lcom/tencent/qqnt/chats/core/bizEvent/a;", "a", "event", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e {
    @NotNull
    List<a> a();

    void b(@NotNull a event, @NotNull List<b> items);
}
