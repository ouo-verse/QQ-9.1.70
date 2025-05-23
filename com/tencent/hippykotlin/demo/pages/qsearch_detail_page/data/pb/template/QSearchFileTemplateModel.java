package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchFileTemplateModel extends QSearchBaseTemplateModel {
    public boolean isInGroup;
    public String fileId = "";
    public String fileName = "";
    public String fileIconUrl = "";
    public String fileSize = "";
    public SearchNetLabel label = new SearchNetLabel();
    public String groupId = "";
    public String groupName = "";
    public String fileLink = "";
    public String authSign = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.fileName.length() > 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        super.parseContent(qSearchTemplate);
        e eVar = new e(qSearchTemplate.data);
        String q16 = eVar.q("id", "");
        String q17 = eVar.q("file_name", "");
        String q18 = eVar.q("icon_url", "");
        String q19 = eVar.q("file_size", "");
        String q26 = eVar.q("tag", "");
        long o16 = eVar.o("group_id", 0L);
        String q27 = eVar.q("group_name", "");
        int k3 = eVar.k("is_in_group", 0);
        String q28 = eVar.q("file_link", "");
        String q29 = eVar.q("join_group_auth", "");
        this.fileId = q16;
        this.fileName = q17;
        this.fileIconUrl = q18;
        this.fileSize = q19;
        SearchNetLabel searchNetLabel = this.label;
        searchNetLabel.text = q26;
        searchNetLabel.type = 3;
        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
        searchNetLabel.textColor = QUISkinColor.blueLabelText;
        searchNetLabel.bgColor = qUISkinColor.blueLabelBackground();
        this.groupId = String.valueOf(o16);
        this.groupName = q27;
        this.isInGroup = k3 == 1;
        this.fileLink = q28;
        this.authSign = q29;
    }
}
