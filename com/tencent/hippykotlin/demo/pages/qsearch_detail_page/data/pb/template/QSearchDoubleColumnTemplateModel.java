package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchDoubleColumnList;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchListDetail;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDoubleColumnTemplateModel extends QSearchBaseTitleGroupTemplateModel {
    public List<QSearchDoubleListItemModel> items = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchDoubleListItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return !this.items.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchDoubleListItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        String str;
        IntRange until;
        IntProgression step;
        super.parseContent(qSearchTemplate);
        QSearchDoubleColumnList decode = new QSearchDoubleColumnList(null, null, null, null).decode(new e(qSearchTemplate.data));
        QSearchText qSearchText = decode.title;
        if (qSearchText == null || (str = qSearchText.text) == null) {
            str = "";
        }
        this.title = str;
        List<QSearchListDetail> list = decode.list;
        if (list == null) {
            return;
        }
        until = RangesKt___RangesKt.until(0, list.size() - (list.size() % 2));
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            ?? r36 = this.items;
            QSearchDoubleListItemModel qSearchDoubleListItemModel = new QSearchDoubleListItemModel();
            ?? r56 = qSearchDoubleListItemModel.items;
            QSearchListItemModel qSearchListItemModel = new QSearchListItemModel();
            qSearchListItemModel.parseContent(list.get(first));
            r56.add(qSearchListItemModel);
            ?? r57 = qSearchDoubleListItemModel.items;
            QSearchListItemModel qSearchListItemModel2 = new QSearchListItemModel();
            qSearchListItemModel2.parseContent(list.get(first + 1));
            r57.add(qSearchListItemModel2);
            r36.add(qSearchDoubleListItemModel);
            if (first == last) {
                return;
            } else {
                first += step2;
            }
        }
    }
}
