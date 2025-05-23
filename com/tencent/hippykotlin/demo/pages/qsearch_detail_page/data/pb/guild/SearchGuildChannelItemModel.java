package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchGuildChannelItemModel extends BaseSearchItemModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SearchGuildChannelItemModel.class, "joinStatus", "getJoinStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SearchGuildChannelItemModel.class, "isFirstItem", "isFirstItem()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SearchGuildChannelItemModel.class, "isLastItem", "isLastItem()Z", 0)};
    public static final Companion Companion = new Companion();
    public long guildId;
    public long guildOwnerUin;
    public int status;
    public String coverUrl = "";
    public String title = "";
    public String subTitle = "";
    public List<String> icons = new ArrayList();
    public List<SearchNetLabel> topLabelList = new ArrayList();
    public List<SearchNetLabel> bottomLabelList = new ArrayList();
    public String joinGuildSig = "";
    public String query = "";
    public final ReadWriteProperty joinStatus$delegate = c.a(1);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        public final SearchGuildChannelItemModel create(e eVar) {
            CharSequence trim;
            SearchGuildChannelItemModel searchGuildChannelItemModel = new SearchGuildChannelItemModel();
            searchGuildChannelItemModel.status = eVar.j("status");
            searchGuildChannelItemModel.coverUrl = eVar.p("cover_url");
            searchGuildChannelItemModel.title = eVar.p("title");
            trim = StringsKt__StringsKt.trim((CharSequence) eVar.p("sub_title"));
            searchGuildChannelItemModel.subTitle = trim.toString();
            b l3 = eVar.l("icons");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    String o16 = l3.o(i3);
                    if (o16 != null) {
                        searchGuildChannelItemModel.icons.add(o16);
                    }
                }
            }
            b l16 = eVar.l("top_label_list");
            if (l16 != null) {
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    e l17 = l16.l(i16);
                    if (l17 != null) {
                        String p16 = l17.p("name");
                        if (p16.length() > 0) {
                            ?? r85 = searchGuildChannelItemModel.topLabelList;
                            SearchNetLabel searchNetLabel = new SearchNetLabel();
                            searchNetLabel.text = p16;
                            QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                            searchNetLabel.textColor = QUIToken.color$default("text_secondary");
                            searchNetLabel.bgColor = QUIToken.color$default("fill_standard_primary");
                            r85.add(searchNetLabel);
                        }
                    }
                }
            }
            b l18 = eVar.l("bottom_label_list");
            if (l18 != null) {
                int c18 = l18.c();
                for (int i17 = 0; i17 < c18; i17++) {
                    e l19 = l18.l(i17);
                    if (l19 != null) {
                        String p17 = l19.p("name");
                        if (p17.length() > 0) {
                            ?? r86 = searchGuildChannelItemModel.bottomLabelList;
                            SearchNetLabel searchNetLabel2 = new SearchNetLabel();
                            searchNetLabel2.text = p17;
                            QUISkinColor qUISkinColor2 = QUISkinColor.INSTANCE;
                            searchNetLabel2.textColor = QUISkinColor.blueLabelText;
                            searchNetLabel2.bgColor = qUISkinColor2.blueLabelBackground();
                            r86.add(searchNetLabel2);
                        }
                    }
                }
            }
            searchGuildChannelItemModel.guildId = eVar.n("guild_id");
            searchGuildChannelItemModel.joinGuildSig = eVar.p("join_guild_sig");
            searchGuildChannelItemModel.guildOwnerUin = eVar.n("guild_owner_uin");
            searchGuildChannelItemModel.query = eVar.p("query");
            searchGuildChannelItemModel.joinStatus$delegate.setValue(searchGuildChannelItemModel, SearchGuildChannelItemModel.$$delegatedProperties[0], Integer.valueOf(eVar.j("join_status")));
            return searchGuildChannelItemModel;
        }
    }

    public SearchGuildChannelItemModel() {
        Boolean bool = Boolean.FALSE;
        c.a(bool);
        c.a(bool);
    }

    public final int getJoinStatus() {
        return ((Number) this.joinStatus$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.title.length() > 0;
    }
}
