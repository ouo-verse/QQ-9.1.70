package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchGameButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchHeadTopic;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchIcon;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGameTemplateModel extends QSearchBaseTemplateModel {
    public QSearchGameAppInfo appInfo;
    public QSearchButtonInfo button;
    public QSearchText content;
    public QSearchTemplateReportInfo expandReportInfo;
    public String background = "";
    public String topIcon = "";
    public String title = "";
    public String desc = "";
    public List<String> avatarList = new ArrayList();
    public String userDesc = "";
    public List<QSearchIconModel> iconList = new ArrayList();

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.title.length() > 0;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchIconModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        String str2;
        String str3;
        String str4;
        super.parseContent(qSearchTemplate);
        QSearchHeadTopic decode = new QSearchHeadTopic("", null, null, null, null, null, "", null, null, "", null, null).decode(new e(qSearchTemplate.data));
        this.background = decode.background;
        QSearchIcon qSearchIcon = decode.topIcon;
        if (qSearchIcon == null || (str = qSearchIcon.iconLink) == null) {
            str = "";
        }
        this.topIcon = str;
        QSearchText qSearchText = decode.title;
        if (qSearchText == null || (str2 = qSearchText.text) == null) {
            str2 = "";
        }
        this.title = str2;
        QSearchText qSearchText2 = decode.subTitle;
        if (qSearchText2 == null || (str3 = qSearchText2.text) == null) {
            str3 = "";
        }
        this.desc = str3;
        List<String> list = decode.avatarGroup;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.avatarList.add((String) it.next());
            }
        }
        this.userDesc = decode.avatarText;
        this.content = decode.text;
        List<QSearchIcon> list2 = decode.icon;
        if (list2 != null) {
            for (QSearchIcon qSearchIcon2 : list2) {
                ?? r36 = this.iconList;
                QSearchIconModel qSearchIconModel = new QSearchIconModel();
                QSearchReportInfo qSearchReportInfo = qSearchIcon2.reportInfo;
                if (qSearchReportInfo != null) {
                    QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
                    qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
                    qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
                    qSearchIconModel.reportInfo = qSearchTemplateReportInfo;
                }
                qSearchIconModel.url = qSearchIcon2.iconLink;
                QSearchText qSearchText3 = qSearchIcon2.title;
                if (qSearchText3 == null || (str4 = qSearchText3.text) == null) {
                    str4 = "";
                }
                qSearchIconModel.title = str4;
                qSearchIconModel.jumpInfo = qSearchIcon2.jumpLink;
                r36.add(qSearchIconModel);
            }
        }
        QSearchGameButton qSearchGameButton = decode.appInfo;
        if (qSearchGameButton != null) {
            QSearchGameAppInfo qSearchGameAppInfo = new QSearchGameAppInfo();
            QSearchReportInfo qSearchReportInfo2 = qSearchGameButton.reportInfo;
            if (qSearchReportInfo2 != null) {
                QSearchTemplateReportInfo qSearchTemplateReportInfo2 = new QSearchTemplateReportInfo();
                qSearchTemplateReportInfo2.eid = qSearchReportInfo2.eid;
                qSearchTemplateReportInfo2.transferInfo = qSearchReportInfo2.reportInfo;
                qSearchGameAppInfo.reportInfo = qSearchTemplateReportInfo2;
            }
            qSearchGameAppInfo.appId = qSearchGameButton.appId;
            qSearchGameAppInfo.channelId = qSearchGameButton.channelId;
            qSearchGameAppInfo.pkgName = qSearchGameButton.pkgName;
            qSearchGameAppInfo.name = qSearchGameButton.name;
            qSearchGameAppInfo.icon = qSearchGameButton.icon;
            qSearchGameAppInfo.url = qSearchGameButton.url;
            qSearchGameAppInfo.appSize = qSearchGameButton.appSize;
            qSearchGameAppInfo.businessChannel = qSearchGameButton.businessChannel;
            this.appInfo = qSearchGameAppInfo;
        }
        QSearchButton qSearchButton = decode.button;
        if (qSearchButton != null) {
            QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
            qSearchButtonInfo.parseContent(qSearchButton);
            this.button = qSearchButtonInfo;
        }
        QSearchReportInfo qSearchReportInfo3 = decode.reportInfo;
        if (qSearchReportInfo3 != null) {
            QSearchTemplateReportInfo qSearchTemplateReportInfo3 = new QSearchTemplateReportInfo();
            qSearchTemplateReportInfo3.eid = qSearchReportInfo3.eid;
            qSearchTemplateReportInfo3.transferInfo = qSearchReportInfo3.reportInfo;
            this.expandReportInfo = qSearchTemplateReportInfo3;
        }
    }
}
