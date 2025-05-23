package com.tencent.mobileqq.guild.media.qcircle;

import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\nH&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/e;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "roomInfo", "Lj30/a;", "controller", "", tl.h.F, "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "setFeedController", "g", "e", "onActivityDestroy", "onPagePause", "f", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {
    void b();

    void e();

    void f();

    void g();

    void h(@NotNull FeedCloudMeta$StFeed data, @NotNull c roomInfo, @NotNull j30.a controller);

    void onActivityDestroy();

    void onPagePause();

    void setFeedController(@Nullable d controller);
}
