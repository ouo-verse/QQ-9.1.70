package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchIcon;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchListDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchListItemModel extends QSearchBaseReportTemplateModel {
    public QSearchButtonInfo button;
    public QSearchJump jumpInfo;
    public String icon = "";
    public String title = "";
    public String desc = "";

    public final void parseContent(QSearchListDetail qSearchListDetail) {
        String str;
        String str2;
        String str3;
        QSearchReportInfo qSearchReportInfo = qSearchListDetail.reportInfo;
        if (qSearchReportInfo != null) {
            QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
            qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
            qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
            this.reportInfo = qSearchTemplateReportInfo;
        }
        QSearchIcon qSearchIcon = qSearchListDetail.icon;
        String str4 = "";
        if (qSearchIcon == null || (str = qSearchIcon.iconLink) == null) {
            str = "";
        }
        this.icon = str;
        QSearchText qSearchText = qSearchListDetail.title;
        if (qSearchText == null || (str2 = qSearchText.text) == null) {
            str2 = "";
        }
        this.title = str2;
        QSearchText qSearchText2 = qSearchListDetail.subTitle;
        if (qSearchText2 != null && (str3 = qSearchText2.text) != null) {
            str4 = str3;
        }
        this.desc = str4;
        this.jumpInfo = qSearchListDetail.jumpLink;
        QSearchButton qSearchButton = qSearchListDetail.button;
        if (qSearchButton != null) {
            QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
            qSearchButtonInfo.parseContent(qSearchButton);
            this.button = qSearchButtonInfo;
        }
    }
}
