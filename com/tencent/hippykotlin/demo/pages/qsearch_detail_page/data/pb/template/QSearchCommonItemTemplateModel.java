package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchIcon;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchLabel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchVerticalDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCommonItemTemplateModel extends QSearchBaseTemplateModel {
    public QSearchButtonInfo commonButton;
    public int uinType;
    public String avatar = "";
    public String uin = "";
    public int avatarType = 1;
    public String littleIcon = "";
    public String title = "";
    public List<String> titleIcons = new ArrayList();
    public List<SearchNetLabel> topLabelList = new ArrayList();
    public List<SearchNetLabel> bottomLabelList = new ArrayList();
    public String content = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.title.length() > 0;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        super.parseContent(qSearchTemplate);
        QSearchVerticalDetail decode = new QSearchVerticalDetail(null, null, null, null, null, null, null, null).decode(new e(qSearchTemplate.data));
        QSearchIcon qSearchIcon = decode.icon;
        if (qSearchIcon != null) {
            this.avatar = qSearchIcon.iconLink;
            this.avatarType = qSearchIcon.iconType;
            this.uin = qSearchIcon.uin;
            this.uinType = qSearchIcon.uinType;
        }
        QSearchIcon qSearchIcon2 = decode.littleIcon;
        if (qSearchIcon2 != null) {
            this.littleIcon = qSearchIcon2.iconLink;
        }
        QSearchText qSearchText = decode.title;
        if (qSearchText != null) {
            this.title = qSearchText.text;
        }
        List<QSearchIcon> list = decode.tags;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.titleIcons.add(((QSearchIcon) it.next()).iconLink);
            }
        }
        QSearchButton qSearchButton = decode.button;
        if (qSearchButton != null) {
            QSearchButtonInfo qSearchButtonInfo = new QSearchButtonInfo();
            qSearchButtonInfo.parseContent(qSearchButton);
            this.commonButton = qSearchButtonInfo;
        }
        parseLabels(decode.topLabel, this.topLabelList);
        QSearchText qSearchText2 = decode.subTitle;
        if (qSearchText2 != null) {
            this.content = qSearchText2.text;
        }
        parseLabels(decode.bottomLabel, this.bottomLabelList);
    }

    public final void parseLabels(List<QSearchLabel> list, List<SearchNetLabel> list2) {
        String str;
        String str2;
        if (list != null) {
            ArrayList<QSearchLabel> arrayList = new ArrayList();
            for (Object obj : list) {
                QSearchLabel qSearchLabel = (QSearchLabel) obj;
                QSearchText qSearchText = qSearchLabel.text;
                String str3 = qSearchText != null ? qSearchText.text : null;
                boolean z16 = !(str3 == null || str3.length() == 0);
                QSearchIcon qSearchIcon = qSearchLabel.icon;
                String str4 = qSearchIcon != null ? qSearchIcon.iconLink : null;
                if ((!(str4 == null || str4.length() == 0)) | z16) {
                    arrayList.add(obj);
                }
            }
            for (QSearchLabel qSearchLabel2 : arrayList) {
                SearchNetLabel searchNetLabel = new SearchNetLabel();
                QSearchText qSearchText2 = qSearchLabel2.text;
                String str5 = "";
                if (qSearchText2 == null || (str = qSearchText2.text) == null) {
                    str = "";
                }
                searchNetLabel.text = str;
                QSearchIcon qSearchIcon2 = qSearchLabel2.icon;
                if (qSearchIcon2 != null && (str2 = qSearchIcon2.iconLink) != null) {
                    str5 = str2;
                }
                searchNetLabel.icon = str5;
                searchNetLabel.type = 4;
                if (qSearchLabel2.layout == 2) {
                    QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                    searchNetLabel.textColor = QUISkinColor.blueLabelText;
                    searchNetLabel.bgColor = qUISkinColor.blueLabelBackground();
                } else {
                    QUISkinColor qUISkinColor2 = QUISkinColor.INSTANCE;
                    searchNetLabel.textColor = qUISkinColor2.wrapColor("text_secondary");
                    searchNetLabel.bgColor = qUISkinColor2.wrapColor("fill_standard_primary");
                }
                list2.add(searchNetLabel);
            }
        }
    }
}
