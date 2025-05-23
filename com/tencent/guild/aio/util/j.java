package com.tencent.guild.aio.util;

import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/util/j;", "", "", "content", "", "enableHashTagLink", "", "", "unMatchTypes", "", "Lcom/tencent/guild/aio/msglist/markdown/e;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a */
    @NotNull
    public static final j f112409a = new j();

    j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List b(j jVar, String str, boolean z16, Set set, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            set = null;
        }
        return jVar.a(str, z16, set);
    }

    @NotNull
    public final List<LinkSpanEntity> a(@NotNull String content, boolean enableHashTagLink, @Nullable Set<Integer> unMatchTypes) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(content, "content");
        List<Triple<String, Integer, Integer>> parseLinkSpan = ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).parseLinkSpan(content, enableHashTagLink, unMatchTypes);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parseLinkSpan, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = parseLinkSpan.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            arrayList.add(new LinkSpanEntity((String) triple.component1(), ((Number) triple.component2()).intValue(), ((Number) triple.component3()).intValue()));
        }
        return arrayList;
    }
}
