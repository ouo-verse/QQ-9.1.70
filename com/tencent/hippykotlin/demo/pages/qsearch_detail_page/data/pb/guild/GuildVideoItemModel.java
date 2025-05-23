package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildItemInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeed;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildVideoItemModel extends SearchGuildBaseItemModel {
    public StFeedEx stFeedEx;

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
        StFeedEx stFeedEx = this.stFeedEx;
        if (stFeedEx != null) {
            arrayList.add(stFeedEx.feedPbToken);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel
    public final void doInit() {
        GuildItemInfo guildItemInfo = this.originData;
        if (guildItemInfo != null) {
            StFeedEx stFeedEx = new StFeedEx(new StFeed(), guildItemInfo.liveInfo);
            stFeedEx.loadFeedPB();
            this.stFeedEx = stFeedEx;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.stFeedEx != null;
    }
}
