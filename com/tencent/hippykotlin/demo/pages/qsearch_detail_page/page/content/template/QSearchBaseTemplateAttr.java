package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QSearchBaseTemplateAttr<M extends QSearchBaseTemplateModel> extends QSearchReportAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseTemplateAttr.class, "playIndex", "getPlayIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseTemplateAttr.class, "muted", "getMuted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseTemplateAttr.class, "isLastItem", "isLastItem()Z", 0)};
    public M data;
    public int index;
    public boolean isFirstItem;
    public QSearchTabContentViewModel viewModel;
    public String keyword = "";
    public String traceId = "";
    public final ReadWriteProperty playIndex$delegate = c.a(0);
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty isLastItem$delegate = c.a(Boolean.FALSE);

    public final M getData() {
        M m3 = this.data;
        if (m3 != null) {
            return m3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
