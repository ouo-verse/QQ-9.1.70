package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchMiniAppItemModel extends BaseSearchItemModel {
    public static final Companion Companion = new Companion();
    public static final SearchNetLabel shownLabel;
    public int type;
    public String appId = "";
    public String cover = "";
    public String name = "";
    public String desc = "";
    public List<SearchNetLabel> labelList = new ArrayList();
    public String classification = "";
    public int scene = 1005;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        public final SearchMiniAppItemModel create(e eVar) {
            SearchMiniAppItemModel searchMiniAppItemModel = new SearchMiniAppItemModel();
            searchMiniAppItemModel.appId = eVar.p("appid");
            searchMiniAppItemModel.type = eVar.j("miniapp_type");
            searchMiniAppItemModel.cover = eVar.p("cover");
            searchMiniAppItemModel.name = eVar.p("name");
            searchMiniAppItemModel.desc = eVar.p("desc");
            searchMiniAppItemModel.classification = eVar.p("classification");
            b l3 = eVar.l("labels");
            if (l3 != null) {
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    e l16 = l3.l(i3);
                    if (l16 != null) {
                        ?? r56 = searchMiniAppItemModel.labelList;
                        SearchNetLabel searchNetLabel = new SearchNetLabel();
                        searchNetLabel.text = l16.p("name");
                        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                        searchNetLabel.textColor = QUIToken.color$default("text_secondary");
                        searchNetLabel.bgColor = QUIToken.color$default("fill_standard_primary");
                        r56.add(searchNetLabel);
                    }
                }
            }
            return searchMiniAppItemModel;
        }
    }

    static {
        SearchNetLabel searchNetLabel = new SearchNetLabel();
        searchNetLabel.text = "\u4f7f\u7528\u8fc7";
        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
        searchNetLabel.textColor = QUISkinColor.blueLabelText;
        searchNetLabel.bgColor = qUISkinColor.blueLabelBackground();
        shownLabel = searchNetLabel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.name.length() > 0;
    }
}
