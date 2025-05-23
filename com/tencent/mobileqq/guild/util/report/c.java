package com.tencent.mobileqq.guild.util.report;

import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/util/report/c;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "a", "tag", "", "isPublicVersion", "", "b", "", "subTag", "", "timeCost", "", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface c {
    @NotNull
    List<GuildHistogramScene> a();

    int b(@NotNull GuildHistogramScene tag, boolean isPublicVersion);

    void c(@NotNull GuildHistogramScene tag, @NotNull String subTag, float timeCost);
}
