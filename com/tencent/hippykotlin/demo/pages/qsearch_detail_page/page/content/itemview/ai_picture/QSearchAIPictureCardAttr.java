package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardItemModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class QSearchAIPictureCardAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardAttr.class, "keyword", "getKeyword()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardAttr.class, "listState", "getListState()Lcom/tencent/hippykotlin/demo/pages/base/RefreshListState;", 0)};
    public AIPictureCardItemModel data;
    public QSearchAIPictureCardViewModel viewModel;
    public final ReadWriteProperty keyword$delegate = c.a("");
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
    public final ReadWriteProperty listState$delegate = c.a(new RefreshListState.Empty());

    public final QSearchAIPictureCardViewModel getViewModel() {
        QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel = this.viewModel;
        if (qSearchAIPictureCardViewModel != null) {
            return qSearchAIPictureCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
