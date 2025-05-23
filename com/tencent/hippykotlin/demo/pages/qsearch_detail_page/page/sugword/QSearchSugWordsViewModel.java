package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.l;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSugWordsViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSugWordsViewModel.class, "dataList", "getDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSugWordsViewModel.class, "listState", "getListState()Lcom/tencent/hippykotlin/demo/pages/base/RefreshListState;", 0)};
    public final Lazy repo$delegate;
    public final ReadWriteProperty dataList$delegate = c.b();
    public final ReadWriteProperty listState$delegate = c.a(RefreshListState.Idle.INSTANCE);
    public String keyword = "";

    public QSearchSugWordsViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QSearchNetSugWordsRepo>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final QSearchNetSugWordsRepo invoke() {
                return new QSearchNetSugWordsRepo();
            }
        });
        this.repo$delegate = lazy;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<l> getDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dataList$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
