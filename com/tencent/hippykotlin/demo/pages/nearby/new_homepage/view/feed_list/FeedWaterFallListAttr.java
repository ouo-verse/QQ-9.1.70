package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedWaterFallListAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FeedWaterFallListAttr.class, "feedList", "getFeedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FeedWaterFallListAttr.class, "fetchStatus", "getFetchStatus()Lcom/tencent/hippykotlin/demo/pages/nearby/new_homepage/view_model/FetchStatus;", 0)};
    public final ReadWriteProperty feedList$delegate = c.b();
    public final ReadWriteProperty fetchStatus$delegate = c.a(FetchStatus.FETCH_LOADING);
    public boolean isUserLikedPage;
    public NBPHomePageBaseViewModel viewModel;
}
