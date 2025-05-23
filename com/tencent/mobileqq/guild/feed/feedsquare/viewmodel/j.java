package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import com.tencent.richframework.data.idata.IDataDisplaySurface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&R\u001c\u0010\u000f\u001a\u00020\u00078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/j;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Lij1/h;", "Lco1/h;", "", "guildId", "channelId", "", "updateTime", "", "Y", "G0", "()J", "setLastUpdatedTime", "(J)V", "lastUpdatedTime", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface j extends IDataDisplaySurface<ij1.h>, co1.h {
    long G0();

    void Y(@NotNull String guildId, @NotNull String channelId, long updateTime);
}
