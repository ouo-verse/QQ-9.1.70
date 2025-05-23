package kn1;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\"8\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\",\u0010\u000e\u001a\u0004\u0018\u00010\t*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"\u0015\u0010\u0013\u001a\u00020\u0010*\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0015\u001a\u00020\u0010*\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"\u0015\u0010\u0017\u001a\u00020\u0010*\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lkn1/b;", "", "", "value", "getTopicIds", "(Lkn1/b;)Ljava/util/Collection;", "e", "(Lkn1/b;Ljava/util/Collection;)V", "topicIds", "", "getRequestId", "(Lkn1/b;)Ljava/lang/Integer;", "d", "(Lkn1/b;Ljava/lang/Integer;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "", "c", "(Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;)Z", "success", "a", "fail", "b", "sending", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final boolean a(@NotNull GuildTaskProgressState guildTaskProgressState) {
        Intrinsics.checkNotNullParameter(guildTaskProgressState, "<this>");
        if (guildTaskProgressState.getMainState() != 5 && guildTaskProgressState.getMainState() != 4) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull GuildTaskProgressState guildTaskProgressState) {
        Intrinsics.checkNotNullParameter(guildTaskProgressState, "<this>");
        if (!c(guildTaskProgressState) && !a(guildTaskProgressState)) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull GuildTaskProgressState guildTaskProgressState) {
        Intrinsics.checkNotNullParameter(guildTaskProgressState, "<this>");
        if (guildTaskProgressState.getMainState() == 3) {
            return true;
        }
        return false;
    }

    public static final void d(@NotNull FeedPublishStateV2 feedPublishStateV2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(feedPublishStateV2, "<this>");
        Map<String, Object> c16 = feedPublishStateV2.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
        TypeIntrinsics.asMutableMap(c16).put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, num);
    }

    public static final void e(@NotNull FeedPublishStateV2 feedPublishStateV2, @Nullable Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(feedPublishStateV2, "<this>");
        Map<String, Object> c16 = feedPublishStateV2.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
        TypeIntrinsics.asMutableMap(c16).put("topicIds", collection);
    }
}
