package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildChannelTitleMoreCardItemAttr extends QSearchBaseTitleMoreCardItemAttr {
    public SearchGuildChannelCardItemModel data;

    public final SearchGuildChannelCardItemModel getData() {
        SearchGuildChannelCardItemModel searchGuildChannelCardItemModel = this.data;
        if (searchGuildChannelCardItemModel != null) {
            return searchGuildChannelCardItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
