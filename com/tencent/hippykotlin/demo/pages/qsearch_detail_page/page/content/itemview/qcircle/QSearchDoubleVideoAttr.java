package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDoubleVideoAttr extends QSearchReportAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDoubleVideoAttr.class, "playIndex", "getPlayIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDoubleVideoAttr.class, "muted", "getMuted()Z", 0)};
    public DoubleVideoItemModel data;
    public int index;
    public QSearchTabContentViewModel viewModel;
    public final ReadWriteProperty playIndex$delegate = c.a(0);
    public String keyword = "";
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public String traceId = "";

    public final int getPlayIndex() {
        return ((Number) this.playIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }
}
