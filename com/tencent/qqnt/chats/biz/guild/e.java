package com.tencent.qqnt.chats.biz.guild;

import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", "", "b", "", "a", "", "c", "chats_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    @NotNull
    public static final CharSequence a(@NotNull g.e eVar) {
        CharSequence b16;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        g.c c16 = eVar.c();
        if (c16 == null || (b16 = c16.b()) == null) {
            return "";
        }
        return b16;
    }

    public static final long b(@NotNull g.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        g.c c16 = eVar.c();
        if (c16 != null) {
            return c16.a();
        }
        return 0L;
    }

    public static final int c(@NotNull g.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        g.c c16 = eVar.c();
        if (c16 != null) {
            return c16.c();
        }
        return 0;
    }
}
