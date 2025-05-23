package com.tencent.mobileqq.guild.data;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/data/q;", "Lcom/tencent/mobileqq/guild/data/m;", "Lcom/tencent/mobileqq/guild/data/r;", "", "getChannelName", "()Ljava/lang/String;", "setChannelName", "(Ljava/lang/String;)V", "channelName", "", "", "getTags", "()Ljava/util/Map;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface q extends m, r {
    @NotNull
    Map<String, Integer> getTags();

    void setChannelName(@NotNull String str);
}
