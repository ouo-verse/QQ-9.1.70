package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchBanner;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchIcon;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchBannerTemplateModel extends QSearchBaseTemplateModel {
    public QSearchListItemModel itemModel;
    public QSearchJump jumpInfo;
    public String background = "";
    public List<QSearchButtonInfo> textLinkList = new ArrayList();

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.background.length() > 0;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        String str2;
        String str3;
        super.parseContent(qSearchTemplate);
        QSearchBanner decode = new QSearchBanner(null, null, null, null, null, null).decode(new e(qSearchTemplate.data));
        QSearchIcon qSearchIcon = decode.background;
        if (qSearchIcon != null) {
            this.background = qSearchIcon.iconLink;
            this.jumpInfo = qSearchIcon.jumpLink;
        }
        QSearchIcon qSearchIcon2 = decode.icon;
        if (qSearchIcon2 != null || decode.title != null || decode.subTitle != null || decode.button != null) {
            QSearchListItemModel qSearchListItemModel = new QSearchListItemModel();
            String str4 = "";
            if (qSearchIcon2 == null || (str = qSearchIcon2.iconLink) == null) {
                str = "";
            }
            qSearchListItemModel.icon = str;
            QSearchText qSearchText = decode.title;
            if (qSearchText == null || (str2 = qSearchText.text) == null) {
                str2 = "";
            }
            qSearchListItemModel.title = str2;
            QSearchText qSearchText2 = decode.subTitle;
            if (qSearchText2 != null && (str3 = qSearchText2.text) != null) {
                str4 = str3;
            }
            qSearchListItemModel.desc = str4;
            QSearchButton qSearchButton = decode.button;
            if (qSearchButton != null) {
                QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
                qSearchButtonInfo.parseContent(qSearchButton);
                qSearchListItemModel.button = qSearchButtonInfo;
            }
            this.itemModel = qSearchListItemModel;
        }
        List<QSearchText> list = decode.textLink;
        if (list != null) {
            for (QSearchText qSearchText3 : list) {
                ?? r16 = this.textLinkList;
                QSearchButtonInfo qSearchButtonInfo2 = new QSearchButtonInfo();
                QSearchReportInfo qSearchReportInfo = qSearchText3.reportInfo;
                if (qSearchReportInfo != null) {
                    QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
                    qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
                    qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
                    qSearchButtonInfo2.reportInfo = qSearchTemplateReportInfo;
                }
                qSearchButtonInfo2.text = qSearchText3.text;
                qSearchButtonInfo2.jumpInfo = qSearchText3.jumpLink;
                r16.add(qSearchButtonInfo2);
            }
        }
    }
}
