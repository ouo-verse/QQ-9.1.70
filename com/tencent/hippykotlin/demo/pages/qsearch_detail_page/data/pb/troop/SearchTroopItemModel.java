package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchTroopItemModel extends BaseSearchItemModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SearchTroopItemModel.class, "joinStatus", "getJoinStatus()I", 0)};
    public static final Companion Companion = new Companion();
    public SearchNetLabel bottomLabel;
    public boolean isExactSearch;
    public int labelFlag;
    public String name = "";
    public String desc = "";
    public String troopUin = "";
    public List<SearchNetLabel> labelList = new ArrayList();
    public final ReadWriteProperty joinStatus$delegate = c.a(1);
    public String authSign = "";
    public e labelReportParams = new e();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        public final SearchTroopItemModel create(e eVar) {
            SearchTroopItemModel searchTroopItemModel = new SearchTroopItemModel();
            p decode = new p().decode(eVar);
            searchTroopItemModel.name = decode.f424816b;
            searchTroopItemModel.troopUin = decode.f424815a;
            Companion companion = SearchTroopItemModel.Companion;
            String str = decode.f424821g;
            companion.getClass();
            e eVar2 = new e(str);
            searchTroopItemModel.authSign = eVar2.p("join_group_auth");
            searchTroopItemModel.isExactSearch = eVar2.j("exact_search") == 1;
            eVar2.j("privilege_flag");
            String p16 = eVar2.p("memo");
            searchTroopItemModel.desc = p16;
            if (p16.length() == 0) {
                searchTroopItemModel.desc = "\u7fa4\u4e3b\u5f88\u61d2\uff0c\u8fd8\u6ca1\u6709\u7fa4\u4ecb\u7ecd\u54e6~";
            }
            int i3 = eVar2.j("join_group_flag") > -1 ? 0 : 1;
            String str2 = searchTroopItemModel.troopUin;
            if (i3 == 1) {
                Object valueForKey = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getValueForKey("QSearchTroopStatus_" + str2);
                Integer num = valueForKey instanceof Integer ? (Integer) valueForKey : null;
                if (num != null && num.intValue() == 2) {
                    i3 = num.intValue();
                }
            }
            searchTroopItemModel.joinStatus$delegate.setValue(searchTroopItemModel, SearchTroopItemModel.$$delegatedProperties[0], Integer.valueOf(i3));
            int j3 = eVar2.j("label_flag");
            searchTroopItemModel.labelFlag = j3;
            if (j3 == 0) {
                b l3 = eVar2.l("label");
                if (l3 != null) {
                    int c16 = l3.c();
                    for (int i16 = 0; i16 < c16; i16++) {
                        e l16 = l3.l(i16);
                        if (l16 != null) {
                            ?? r46 = searchTroopItemModel.labelList;
                            SearchNetLabel searchNetLabel = new SearchNetLabel();
                            searchNetLabel.type = l16.j("attr");
                            searchNetLabel.text = l16.p("name");
                            QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                            searchNetLabel.textColor = QUIToken.color$default("text_secondary");
                            searchNetLabel.bgColor = QUIToken.color$default("fill_standard_primary");
                            r46.add(searchNetLabel);
                        }
                    }
                }
            } else {
                e m3 = eVar2.m("label_v2");
                if (m3 != null) {
                    QUISkinColor qUISkinColor2 = QUISkinColor.INSTANCE;
                    SearchNetLabel parseSingleLabelV2 = companion.parseSingleLabelV2(m3, "group_number", 1, QUIToken.color$default("text_secondary"), QUIToken.color$default("fill_standard_primary"));
                    if (parseSingleLabelV2 != null) {
                        searchTroopItemModel.labelList.add(parseSingleLabelV2);
                        searchTroopItemModel.labelReportParams.v("user_volume_label", parseSingleLabelV2.text);
                    }
                    SearchNetLabel parseSingleLabelV22 = companion.parseSingleLabelV2(m3, "real_time_behavior", 3, QUIToken.color$default("text_secondary"), QUIToken.color$default("fill_standard_primary"));
                    if (parseSingleLabelV22 != null) {
                        searchTroopItemModel.labelList.add(parseSingleLabelV22);
                        searchTroopItemModel.labelReportParams.v("real_time_behavior_tags", parseSingleLabelV22.text);
                    }
                    h hVar = QUISkinColor.blueLabelText;
                    SearchNetLabel parseSingleLabelV23 = companion.parseSingleLabelV2(m3, "recommend_reason", 3, hVar, qUISkinColor2.blueLabelBackground());
                    if (parseSingleLabelV23 != null) {
                        searchTroopItemModel.labelList.add(parseSingleLabelV23);
                        searchTroopItemModel.labelReportParams.v("group_recommand_tag", parseSingleLabelV23.text);
                    }
                    SearchNetLabel parseSingleLabelV24 = companion.parseSingleLabelV2(m3, "group_feature", 3, hVar, qUISkinColor2.blueLabelBackground());
                    if (parseSingleLabelV24 != null) {
                        searchTroopItemModel.bottomLabel = parseSingleLabelV24;
                        searchTroopItemModel.labelReportParams.v("group_characteristics_label", parseSingleLabelV24.text);
                    }
                }
            }
            return searchTroopItemModel;
        }

        public final SearchNetLabel parseSingleLabelV2(e eVar, String str, int i3, h hVar, h hVar2) {
            String p16;
            e m3 = eVar.m(str);
            if (m3 == null || (p16 = m3.p("name")) == null) {
                return null;
            }
            if (p16.length() == 0) {
                return null;
            }
            SearchNetLabel searchNetLabel = new SearchNetLabel();
            searchNetLabel.type = i3;
            searchNetLabel.text = p16;
            searchNetLabel.textColor = hVar;
            searchNetLabel.bgColor = hVar2;
            return searchNetLabel;
        }
    }

    public final int getJoinStatus() {
        return ((Number) this.joinStatus$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.troopUin.length() > 0;
    }
}
