package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECStateViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECStateViewAttr.class, "state", "getState()Lcom/tencent/hippykotlin/demo/pages/base/NetworkState;", 0)};
    public h buttonBgColor;
    public String emptyImgToken;
    public h emptyTextColor;
    public h emptyViewBackgroundColor;
    public Function1<? super ViewContainer<?, ?>, Unit> emptyViewBuilder;
    public String errorImageToken;
    public h errorTextColor;
    public Function1<? super ViewContainer<?, ?>, Unit> errorViewBuilder;
    public Integer loadingDelay;
    public String emptyText = "\u4ec0\u4e48\u90fd\u6ca1\u6709";
    public final ReadWriteProperty state$delegate = c.a(NetworkState.Loading);

    public final NetworkState getState() {
        return (NetworkState) this.state$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
