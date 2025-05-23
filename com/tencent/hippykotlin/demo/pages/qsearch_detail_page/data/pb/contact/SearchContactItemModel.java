package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import defpackage.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchContactItemModel extends BaseSearchItemModel {
    public static final Companion Companion = new Companion();
    public int addStatus;
    public int age;
    public boolean hideAddButton;
    public String name = "";
    public String uin = "";
    public String title = "";
    public int gender = 1;
    public List<SearchNetLabel> labelList = new ArrayList();
    public String jumpUrl = "";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v13, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel>, java.util.ArrayList] */
        public final SearchContactItemModel create(e eVar) {
            SearchContactItemModel searchContactItemModel = new SearchContactItemModel();
            p decode = new p().decode(eVar);
            String str = decode.f424821g;
            String str2 = decode.f424815a;
            e eVar2 = new e(str);
            int j3 = eVar2.j("gender");
            searchContactItemModel.gender = j3;
            if (j3 == 1 || j3 == 2) {
                searchContactItemModel.age = eVar2.j("age");
                ?? r16 = searchContactItemModel.labelList;
                SearchNetLabel searchNetLabel = new SearchNetLabel();
                searchNetLabel.text = String.valueOf(searchContactItemModel.age);
                searchNetLabel.gender = searchContactItemModel.gender;
                searchNetLabel.type = -1;
                QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                searchNetLabel.textColor = QUIToken.color$default("text_secondary");
                searchNetLabel.bgColor = QUIToken.color$default("fill_standard_primary");
                r16.add(searchNetLabel);
            }
            int j16 = eVar2.j("cspecialflag");
            if (((j16 & 16) == 0 && (j16 & 1) == 0) ? false : true) {
                searchContactItemModel.uin = eVar2.p("kfaccount");
            } else {
                searchContactItemModel.uin = str2;
            }
            String p16 = eVar2.p("location");
            if (p16.length() > 0) {
                ?? r26 = searchContactItemModel.labelList;
                SearchNetLabel searchNetLabel2 = new SearchNetLabel();
                searchNetLabel2.text = p16;
                QUISkinColor qUISkinColor2 = QUISkinColor.INSTANCE;
                searchNetLabel2.textColor = QUIToken.color$default("text_secondary");
                searchNetLabel2.bgColor = QUIToken.color$default("fill_standard_primary");
                r26.add(searchNetLabel2);
            }
            String p17 = eVar2.p(LpReport_UserInfo_dc02148.CONSTELLATION);
            if (p17.length() > 0) {
                ?? r27 = searchContactItemModel.labelList;
                SearchNetLabel searchNetLabel3 = new SearchNetLabel();
                searchNetLabel3.text = p17;
                QUISkinColor qUISkinColor3 = QUISkinColor.INSTANCE;
                searchNetLabel3.textColor = QUIToken.color$default("text_secondary");
                searchNetLabel3.bgColor = QUIToken.color$default("fill_standard_primary");
                r27.add(searchNetLabel3);
            }
            searchContactItemModel.name = decode.f424816b;
            searchContactItemModel.hideAddButton = decode.f424819e > 0;
            searchContactItemModel.addStatus = Utils.INSTANCE.currentBridgeModule().getFriendStatus(searchContactItemModel.uin);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(decode.f424816b);
            sb5.append('(');
            searchContactItemModel.title = LoadFailParams$$ExternalSyntheticOutline0.m(sb5, decode.f424815a, ')');
            if (decode.f424818d.length() > 0) {
                searchContactItemModel.jumpUrl = decode.f424818d;
            } else {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=");
                m3.append(searchContactItemModel.uin);
                searchContactItemModel.jumpUrl = m3.toString();
            }
            return searchContactItemModel;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.uin.length() > 0;
    }
}
