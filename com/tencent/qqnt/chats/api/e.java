package com.tencent.qqnt.chats.api;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0016\u0010\t\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/api/e;", "", "", "", "removeSets", "addSets", "", "c", "setTops", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e {
    void a(@NotNull Set<String> setTops);

    void c(@NotNull Set<String> removeSets, @NotNull Set<String> addSets);
}
