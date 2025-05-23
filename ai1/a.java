package ai1;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u001a\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "", "a", "", "adapterPos", "", "", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "b", "position", "d", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull l<?> lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar instanceof RecommendAbsFeedData) {
            return b((RecommendAbsFeedData) lVar);
        }
        return "";
    }

    private static final String b(RecommendAbsFeedData recommendAbsFeedData) {
        return "em_sgrp_channel_and_forum_feed";
    }

    @NotNull
    public static final Map<String, Object> c(@NotNull l<?> lVar, int i3) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar instanceof RecommendAbsFeedData) {
            return d((RecommendAbsFeedData) lVar, i3);
        }
        return new LinkedHashMap();
    }

    private static final Map<String, Object> d(RecommendAbsFeedData recommendAbsFeedData, int i3) {
        Object obj;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[3];
        IGProFeedGuildInfo guildInfo = recommendAbsFeedData.getGuildInfo();
        String str = "";
        if (guildInfo == null) {
            obj = "";
        } else {
            obj = Long.valueOf(guildInfo.getChannelId());
        }
        pairArr[0] = TuplesKt.to("sgrp_sub_channel_id", obj.toString());
        String idd = recommendAbsFeedData.getIdd();
        if (idd != null) {
            str = idd;
        }
        pairArr[1] = TuplesKt.to("sgrp_feed_id", str);
        pairArr[2] = TuplesKt.to("sgrp_module_place", Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
