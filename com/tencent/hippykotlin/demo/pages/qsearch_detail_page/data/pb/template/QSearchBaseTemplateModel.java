package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchLayOut;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseTemplateModel extends QSearchBaseReportTemplateModel implements ISearchItemModel {
    public QSearchJump jumpLink;
    public QSearchTemplateLayoutInfo layoutInfo = new QSearchTemplateLayoutInfo();
    public Map<String, String> extensionMap = new LinkedHashMap();

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public boolean canPlay() {
        return false;
    }

    public void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        QSearchReportInfo qSearchReportInfo = qSearchTemplate.reportInfo;
        if (qSearchReportInfo != null) {
            QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
            qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
            qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
            this.reportInfo = qSearchTemplateReportInfo;
        }
        QSearchLayOut qSearchLayOut = qSearchTemplate.layOut;
        if (qSearchLayOut != null) {
            QSearchTemplateLayoutInfo qSearchTemplateLayoutInfo = new QSearchTemplateLayoutInfo();
            qSearchTemplateLayoutInfo.marginTop = qSearchLayOut.marginTop;
            qSearchTemplateLayoutInfo.topCorner = qSearchLayOut.topCorner;
            qSearchTemplateLayoutInfo.bottomCorner = qSearchLayOut.bottomCorner;
            qSearchTemplateLayoutInfo.showDivider = qSearchLayOut.showDivider;
            qSearchTemplateLayoutInfo.highlight = qSearchLayOut.highlight;
            qSearchTemplateLayoutInfo.useWholeCard = qSearchLayOut.useOneCard;
            this.layoutInfo = qSearchTemplateLayoutInfo;
        }
        QSearchJump qSearchJump = qSearchTemplate.jumpLink;
        this.jumpLink = qSearchJump;
        if (qSearchJump == null || (str = qSearchJump.extension) == null) {
            return;
        }
        try {
            e eVar = new e(str);
            for (String str2 : eVar.b()) {
                this.extensionMap.put(str2, eVar.q(str2, ""));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
