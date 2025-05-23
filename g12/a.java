package g12;

import com.tencent.mobileqq.guild.util.report.c;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lg12/a;", "Lcom/tencent/mobileqq/guild/util/report/c;", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "a", "tag", "", "isPublicVersion", "", "b", "", "subTag", "", "timeCost", "", "c", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<GuildHistogramScene> f401084b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildHistogramScene, Integer> f401085c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<GuildHistogramScene, Integer> f401086d;

    static {
        List<GuildHistogramScene> listOf;
        GuildHistogramScene guildHistogramScene = GuildHistogramScene.GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST;
        GuildHistogramScene guildHistogramScene2 = GuildHistogramScene.GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST;
        GuildHistogramScene guildHistogramScene3 = GuildHistogramScene.GUILD_AIO_ENTER_TO_ANIM_TIME_COST;
        GuildHistogramScene guildHistogramScene4 = GuildHistogramScene.GUILD_AIO_BIND_COMPONENT_TIME_COST;
        GuildHistogramScene guildHistogramScene5 = GuildHistogramScene.GUILD_AIO_FIRST_VIEW_TIME_COST;
        GuildHistogramScene guildHistogramScene6 = GuildHistogramScene.GUILD_AIO_BIND_INPUT_TIME_COST;
        GuildHistogramScene guildHistogramScene7 = GuildHistogramScene.GUILD_AIO_BIND_TITLE_TIME_COST;
        GuildHistogramScene guildHistogramScene8 = GuildHistogramScene.GUILD_AIO_MSG_PRE_PARSE_TIME_COST;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GuildHistogramScene[]{guildHistogramScene, guildHistogramScene2, guildHistogramScene3, guildHistogramScene4, guildHistogramScene5, guildHistogramScene6, guildHistogramScene7, guildHistogramScene8});
        f401084b = listOf;
        HashMap<GuildHistogramScene, Integer> hashMap = new HashMap<>();
        hashMap.put(guildHistogramScene, 100);
        hashMap.put(guildHistogramScene2, 100);
        hashMap.put(guildHistogramScene3, 100);
        hashMap.put(guildHistogramScene4, 100);
        hashMap.put(guildHistogramScene5, 100);
        hashMap.put(guildHistogramScene6, 100);
        hashMap.put(guildHistogramScene7, 100);
        hashMap.put(guildHistogramScene8, 100);
        f401085c = hashMap;
        HashMap<GuildHistogramScene, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(guildHistogramScene, 100);
        hashMap2.put(guildHistogramScene2, 100);
        hashMap2.put(guildHistogramScene3, 100);
        hashMap2.put(guildHistogramScene4, 100);
        hashMap2.put(guildHistogramScene5, 100);
        hashMap2.put(guildHistogramScene6, 100);
        hashMap2.put(guildHistogramScene7, 100);
        hashMap2.put(guildHistogramScene8, 100);
        f401086d = hashMap2;
    }

    @Override // com.tencent.mobileqq.guild.util.report.c
    @NotNull
    public List<GuildHistogramScene> a() {
        return f401084b;
    }

    @Override // com.tencent.mobileqq.guild.util.report.c
    public int b(@NotNull GuildHistogramScene tag, boolean isPublicVersion) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Integer num = -1;
        if (isPublicVersion) {
            HashMap<GuildHistogramScene, Integer> hashMap = f401085c;
            if (hashMap.containsKey(tag)) {
                Integer num2 = hashMap.get(tag);
                Intrinsics.checkNotNull(num2);
                num = num2;
            }
            Intrinsics.checkNotNullExpressionValue(num, "{\n            if (SAMPLE\u20261\n            }\n        }");
            return num.intValue();
        }
        HashMap<GuildHistogramScene, Integer> hashMap2 = f401086d;
        if (hashMap2.containsKey(tag)) {
            Integer num3 = hashMap2.get(tag);
            Intrinsics.checkNotNull(num3);
            num = num3;
        }
        Intrinsics.checkNotNullExpressionValue(num, "{\n            if (SAMPLE\u20261\n            }\n        }");
        return num.intValue();
    }

    @Override // com.tencent.mobileqq.guild.util.report.c
    public void c(@NotNull GuildHistogramScene tag, @NotNull String subTag, float timeCost) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("biz_type", subTag));
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(tag, hashMapOf, timeCost);
    }
}
