package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchBanner$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTitleTemplateModel extends QSearchBaseTemplateModel {
    public QSearchButtonInfo moreJumpInfo;
    public String title = "";
    public String subTitle = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.title.length() > 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        String str2;
        super.parseContent(qSearchTemplate);
        e eVar = new e(qSearchTemplate.data);
        e m3 = eVar.m("title");
        QSearchText m16 = m3 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m3) : null;
        e m17 = eVar.m("sub_title");
        QSearchText m18 = m17 != null ? QSearchBanner$$ExternalSyntheticOutline0.m(null, null, 15, m17) : null;
        e m19 = eVar.m("button");
        QSearchButton decode = m19 != null ? new QSearchButton(null, null, null, 0, 15, null).decode(m19) : null;
        String str3 = "";
        if (m16 == null || (str = m16.text) == null) {
            str = "";
        }
        this.title = str;
        if (m18 != null && (str2 = m18.text) != null) {
            str3 = str2;
        }
        this.subTitle = str3;
        if (decode != null) {
            QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
            qSearchButtonInfo.parseContent(decode);
            this.moreJumpInfo = qSearchButtonInfo;
        }
    }
}
