package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildCommonItemModel extends SearchGuildBaseItemModel {
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return getChannelName().length() > 0;
    }
}
