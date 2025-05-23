package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildChannelSingleItemAttr extends QSearchBaseSingleItemAttr {
    public SearchGuildChannelItemModel data;
    public String filterTag = "";

    public final SearchGuildChannelItemModel getData() {
        SearchGuildChannelItemModel searchGuildChannelItemModel = this.data;
        if (searchGuildChannelItemModel != null) {
            return searchGuildChannelItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
