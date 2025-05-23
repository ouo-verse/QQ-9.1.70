package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPlaylet;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchTemplate;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateModel extends QSearchBaseTemplateModel {
    public QSearchPlaylet contentData;

    public final QSearchPlaylet getContentData() {
        QSearchPlaylet qSearchPlaylet = this.contentData;
        if (qSearchPlaylet != null) {
            return qSearchPlaylet;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentData");
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel
    public final void parseContent(QSearchTemplate qSearchTemplate) {
        super.parseContent(qSearchTemplate);
        this.contentData = new QSearchPlaylet(null, null, null, null, null, null, null).decode(new e(qSearchTemplate.data));
    }
}
