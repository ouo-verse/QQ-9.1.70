package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchHorizontalList;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchListDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHorizontalTemplateModel extends QSearchBaseTitleGroupTemplateModel {
    public int type = 1;
    public List<QSearchListItemModel> items = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return !this.items.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        super.parseContent(qSearchTemplate);
        QSearchHorizontalList decode = new QSearchHorizontalList(0, null, null, null).decode(new e(qSearchTemplate.data));
        this.type = decode.listType;
        QSearchText qSearchText = decode.title;
        if (qSearchText == null || (str = qSearchText.text) == null) {
            str = "";
        }
        this.title = str;
        QSearchButton qSearchButton = decode.button;
        if (qSearchButton != null) {
            QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
            qSearchButtonInfo.parseContent(qSearchButton);
            this.moreJumpInfo = qSearchButtonInfo;
        }
        List<QSearchListDetail> list = decode.list;
        if (list != null) {
            for (QSearchListDetail qSearchListDetail : list) {
                ?? r16 = this.items;
                QSearchListItemModel qSearchListItemModel = new QSearchListItemModel();
                qSearchListItemModel.parseContent(qSearchListDetail);
                r16.add(qSearchListItemModel);
            }
        }
    }
}
