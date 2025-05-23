package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildAudienceInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildItemInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class SearchGuildBaseItemModel extends BaseSearchItemModel {
    public static final Companion Companion = new Companion();
    public List<Audience> audienceList = new ArrayList();
    public String channelCreatorHead = "";
    public GuildItemInfo originData;
    public int reportIndex;
    public int resultNumber;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
        public final SearchGuildBaseItemModel create(String str) throws Exception {
            SearchGuildBaseItemModel guildVideoItemModel;
            int collectionSizeOrDefault;
            GuildItemInfo decode = new GuildItemInfo("", 0, 0L, null, "", "", "", "", "", "", "", 0L, 0L, 0L, 0L, "").decode(new e(str));
            int i3 = decode.type;
            if (i3 != 5 && i3 != 6) {
                guildVideoItemModel = new GuildCommonItemModel();
            } else {
                guildVideoItemModel = new GuildVideoItemModel();
            }
            guildVideoItemModel.audienceList.clear();
            List<GuildAudienceInfo> list = decode.audienceInfos;
            if (list != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (GuildAudienceInfo guildAudienceInfo : list) {
                    arrayList.add(new Audience(guildAudienceInfo.icon, guildAudienceInfo.sex));
                }
                guildVideoItemModel.audienceList.addAll(arrayList);
            }
            guildVideoItemModel.originData = decode;
            guildVideoItemModel.doInit();
            return guildVideoItemModel;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return true;
    }

    public final String getAudienceCount() {
        GuildItemInfo guildItemInfo = this.originData;
        if (guildItemInfo != null) {
            return QSearchUtilKt.formatBigNum((int) guildItemInfo.audienceCount);
        }
        return "";
    }

    public final String getChannelIcon() {
        String str;
        GuildItemInfo guildItemInfo = this.originData;
        return (guildItemInfo == null || (str = guildItemInfo.channelIcon) == null) ? "" : str;
    }

    public final String getChannelName() {
        String str;
        GuildItemInfo guildItemInfo = this.originData;
        return (guildItemInfo == null || (str = guildItemInfo.channelName) == null) ? "" : str;
    }

    public final String getCover() {
        String str;
        Object orNull;
        String str2;
        String str3;
        GuildItemInfo guildItemInfo = this.originData;
        if (guildItemInfo == null || (str = guildItemInfo.coverUrl) == null) {
            str = "";
        }
        if (!(str.length() == 0) || getType() != 9) {
            return str;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.audienceList, 0);
        Audience audience = (Audience) orNull;
        if (audience != null && (str3 = audience.avatar) != null) {
            return str3;
        }
        GuildItemInfo guildItemInfo2 = this.originData;
        return (guildItemInfo2 == null || (str2 = guildItemInfo2.channelCreatorHead) == null) ? this.channelCreatorHead : str2;
    }

    public final String getSubChannelName() {
        String str;
        GuildItemInfo guildItemInfo = this.originData;
        return (guildItemInfo == null || (str = guildItemInfo.subChannelName) == null) ? "" : str;
    }

    public final String getTitle() {
        String str;
        GuildItemInfo guildItemInfo = this.originData;
        return (guildItemInfo == null || (str = guildItemInfo.title) == null) ? "" : str;
    }

    public final int getType() {
        GuildItemInfo guildItemInfo = this.originData;
        if (guildItemInfo != null) {
            return guildItemInfo.type;
        }
        return 0;
    }

    public void doInit() {
    }
}
