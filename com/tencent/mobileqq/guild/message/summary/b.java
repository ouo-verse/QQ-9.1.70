package com.tencent.mobileqq.guild.message.summary;

import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import st1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/message/summary/b;", "Lst1/f;", "", "Lst1/f$a;", "finalList", "", "bIsMember", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f230813a = new b();

    b() {
    }

    @Override // st1.f
    public void a(@NotNull List<f.PullParam> finalList, boolean bIsMember) {
        Object first;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(finalList, "finalList");
        if (finalList.isEmpty()) {
            return;
        }
        List<f.PullParam> list = finalList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (f.PullParam pullParam : list) {
            String guildId = pullParam.getGuildId();
            Object obj = linkedHashMap.get(guildId);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(guildId, obj);
            }
            ((List) obj).add(pullParam.getChannelId());
        }
        if (bIsMember) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String?>");
                iMsgService.refreshMsgAbstracts(str, (ArrayList) value);
            }
            return;
        }
        IGuildSummaryApi iGuildSummaryApi = (IGuildSummaryApi) ch.S0(IGuildSummaryApi.class, "");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) finalList);
        String guildId2 = ((f.PullParam) first).getGuildId();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<String> arrayList = new ArrayList<>(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((f.PullParam) it.next()).getChannelId());
        }
        iGuildSummaryApi.refreshGuestGuildSummary(guildId2, arrayList);
    }
}
