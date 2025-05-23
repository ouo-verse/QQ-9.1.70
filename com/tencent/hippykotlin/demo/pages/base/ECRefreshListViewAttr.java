package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshListViewAttr<T> extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListViewAttr.class, "showIphoneXSafeBottom", "getShowIphoneXSafeBottom()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListViewAttr.class, "dataList", "getDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListViewAttr.class, "listState", "getListState()Lcom/tencent/hippykotlin/demo/pages/base/RefreshListState;", 0)};
    public h buttonBgColor;
    public Function1<? super ViewContainer<?, ?>, Unit> emptyViewBuilder;
    public Function1<? super ViewContainer<?, ?>, Unit> errorViewBuilder;
    public Function1<? super ViewContainer<?, ?>, Unit> footerViewBuilder;
    public Integer loadingDelay;
    public float preloadDistance;
    public boolean supportRefreshHeader = true;
    public boolean supportRefreshFooter = true;
    public String footerNoMoreText = "\u6ca1\u6709\u66f4\u591a\u4e86";
    public float footerHeight = 30.0f;
    public String emptyText = "\u4ec0\u4e48\u90fd\u6ca1\u6709";
    public final ReadWriteProperty showIphoneXSafeBottom$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty dataList$delegate = c.b();
    public final ReadWriteProperty listState$delegate = c.a(RefreshListState.Loading.INSTANCE);

    public final com.tencent.kuikly.core.reactive.collection.c<T> getDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dataList$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
